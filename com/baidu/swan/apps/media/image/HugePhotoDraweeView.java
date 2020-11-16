package com.baidu.swan.apps.media.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.swan.apps.a;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
@SuppressLint({"SwanDebugLog"})
/* loaded from: classes7.dex */
public class HugePhotoDraweeView extends SimpleDraweeView {
    private Bitmap bitmap;
    private Paint bitmapPaint;
    private boolean dbY;
    private boolean dbZ;
    private int dcb;
    private int dcc;
    private boolean dcd;
    private int dce;
    private com.baidu.swan.apps.media.image.a.d dcf;
    private com.baidu.swan.apps.media.image.a.b<? extends com.baidu.swan.apps.media.image.a.c> dcg;
    private com.baidu.swan.apps.media.image.a.b<? extends com.baidu.swan.apps.media.image.a.d> dch;
    private a dci;
    private e dcj;
    private f dck;
    private float dcl;
    private boolean dcm;
    private ColorFilter dcn;
    private boolean debug;
    private Paint debugPaint;
    private final Object decoderLock;
    private GestureDetector detector;
    private float doubleTapZoomScale;
    private int doubleTapZoomStyle;
    private float[] dstArray;
    private int fullImageSampleSize;
    private Handler handler;
    private boolean imageLoadedSent;
    private boolean isPanning;
    private boolean isQuickScaling;
    private boolean isZooming;
    private int mColorFilter;
    private Matrix matrix;
    private float maxScale;
    private int maxTouchCount;
    private float minScale;
    private int minimumScaleType;
    private int minimumTileDpi;
    private View.OnLongClickListener onLongClickListener;
    private int orientation;
    private Rect pRegion;
    private boolean panEnabled;
    private int panLimit;
    private Float pendingScale;
    private PointF quickScaleCenter;
    private boolean quickScaleEnabled;
    private float quickScaleLastDistance;
    private PointF quickScaleLastPoint;
    private boolean quickScaleMoved;
    private final float quickScaleThreshold;
    private boolean readySent;
    private int sHeight;
    private int sOrientation;
    private PointF sPendingCenter;
    private RectF sRect;
    private Rect sRegion;
    private PointF sRequestedCenter;
    private int sWidth;
    private float scale;
    private float scaleStart;
    private float[] srcArray;
    private Paint tileBgPaint;
    private Map<Integer, List<g>> tileMap;
    private Uri uri;
    private PointF vCenterStart;
    private float vDistStart;
    private PointF vTranslate;
    private PointF vTranslateStart;
    private boolean zoomEnabled;
    private static final List<Integer> VALID_ORIENTATIONS = Arrays.asList(0, 90, 180, 270, -1);
    private static final List<Integer> VALID_ZOOM_STYLES = Arrays.asList(1, 2, 3);
    private static final List<Integer> VALID_EASING_STYLES = Arrays.asList(2, 1);
    private static final List<Integer> VALID_PAN_LIMITS = Arrays.asList(1, 2, 3);
    private static final List<Integer> VALID_SCALE_TYPES = Arrays.asList(2, 1, 3);
    public static int dca = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    /* loaded from: classes7.dex */
    public interface d {
        void aAy();

        void aAz();

        void onComplete();
    }

    /* loaded from: classes7.dex */
    public interface e {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onReady();

        void onTileLoadError(Exception exc);
    }

    public HugePhotoDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        this.orientation = 0;
        this.minScale = minScale();
        this.maxScale = 5.0f;
        this.minimumTileDpi = -1;
        this.panLimit = 1;
        this.minimumScaleType = 1;
        this.dcb = dca;
        this.dcc = dca;
        this.panEnabled = true;
        this.zoomEnabled = true;
        this.quickScaleEnabled = true;
        this.doubleTapZoomScale = 5.0f;
        this.doubleTapZoomStyle = 1;
        this.dce = 500;
        this.decoderLock = new Object();
        this.dcg = new com.baidu.swan.apps.media.image.a.a(com.baidu.swan.apps.media.image.a.e.class);
        this.dch = new com.baidu.swan.apps.media.image.a.a(com.baidu.swan.apps.media.image.a.f.class);
        this.srcArray = new float[8];
        this.dstArray = new float[8];
        this.dcm = false;
        this.dcn = null;
        this.mColorFilter = 0;
        this.dcl = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMaximumDpi(720);
        setGestureDetector(context);
        this.handler = new Handler(new Handler.Callback() { // from class: com.baidu.swan.apps.media.image.HugePhotoDraweeView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == 1 && HugePhotoDraweeView.this.onLongClickListener != null) {
                    HugePhotoDraweeView.this.maxTouchCount = 0;
                    HugePhotoDraweeView.super.setOnLongClickListener(HugePhotoDraweeView.this.onLongClickListener);
                    HugePhotoDraweeView.this.performLongClick();
                    HugePhotoDraweeView.super.setOnLongClickListener(null);
                }
                return true;
            }
        });
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.HugePhotoDraweeView);
            if (obtainStyledAttributes.hasValue(a.j.HugePhotoDraweeView_assetName) && (string = obtainStyledAttributes.getString(a.j.HugePhotoDraweeView_assetName)) != null && string.length() > 0) {
                setImage(com.baidu.swan.apps.media.image.b.qa(string).aAA());
            }
            if (obtainStyledAttributes.hasValue(a.j.HugePhotoDraweeView_src) && (resourceId = obtainStyledAttributes.getResourceId(a.j.HugePhotoDraweeView_src, 0)) > 0) {
                setImage(com.baidu.swan.apps.media.image.b.jp(resourceId).aAA());
            }
            if (obtainStyledAttributes.hasValue(a.j.HugePhotoDraweeView_panEnabled)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(a.j.HugePhotoDraweeView_panEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(a.j.HugePhotoDraweeView_zoomEnabled)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(a.j.HugePhotoDraweeView_zoomEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(a.j.HugePhotoDraweeView_quickScaleEnabled)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(a.j.HugePhotoDraweeView_quickScaleEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(a.j.HugePhotoDraweeView_tileBackgroundColor)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(a.j.HugePhotoDraweeView_tileBackgroundColor, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.quickScaleThreshold = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    public HugePhotoDraweeView(Context context) {
        this(context, null);
    }

    public void setIsDynamicBitmap(boolean z) {
        this.dcm = z;
    }

    public final void setOrientation(int i2) {
        if (!VALID_ORIENTATIONS.contains(Integer.valueOf(i2))) {
            throw new IllegalArgumentException("Invalid orientation: " + i2);
        }
        this.orientation = i2;
        reset(false);
        invalidate();
        requestLayout();
    }

    public final void setImage(com.baidu.swan.apps.media.image.b bVar) {
        setImage(bVar, null, null);
    }

    public final void setImage(com.baidu.swan.apps.media.image.b bVar, ImageViewState imageViewState) {
        setImage(bVar, null, imageViewState);
    }

    public final void setImage(com.baidu.swan.apps.media.image.b bVar, com.baidu.swan.apps.media.image.b bVar2) {
        setImage(bVar, bVar2, null);
    }

    public final void setImage(com.baidu.swan.apps.media.image.b bVar, com.baidu.swan.apps.media.image.b bVar2, ImageViewState imageViewState) {
        if (bVar == null) {
            throw new NullPointerException("imageSource must not be null");
        }
        reset(true);
        if (imageViewState != null) {
            a(imageViewState);
        }
        if (bVar2 != null) {
            if (bVar.getBitmap() != null) {
                throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
            }
            if (bVar.getSWidth() <= 0 || bVar.getSHeight() <= 0) {
                throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
            }
            this.sWidth = bVar.getSWidth();
            this.sHeight = bVar.getSHeight();
            this.pRegion = bVar2.getSRegion();
            if (bVar2.getBitmap() != null) {
                this.dbZ = bVar2.aAC();
                onPreviewLoaded(bVar2.getBitmap());
            } else {
                Uri uri = bVar2.getUri();
                if (uri == null && bVar2.getResource() != null) {
                    uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + bVar2.getResource());
                }
                a(new c(this, getContext(), this.dcg, uri, true));
            }
        }
        if (bVar.getBitmap() != null && bVar.getSRegion() != null) {
            a(Bitmap.createBitmap(bVar.getBitmap(), bVar.getSRegion().left, bVar.getSRegion().top, bVar.getSRegion().width(), bVar.getSRegion().height()), 0, false);
        } else if (bVar.getBitmap() != null && !bVar.getTile()) {
            a(bVar.getBitmap(), 0, bVar.aAC());
        } else {
            this.sRegion = bVar.getSRegion();
            this.uri = bVar.getUri();
            if (this.uri == null && bVar.getResource() != null) {
                this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + bVar.getResource());
            }
            if (bVar.getTile() || this.sRegion != null) {
                a(new i(this, getContext(), this.dch, bVar));
            } else {
                a(new c(this, getContext(), this.dcg, this.uri, false));
            }
        }
    }

    private void reset(boolean z) {
        this.scale = 0.0f;
        this.scaleStart = 0.0f;
        this.vTranslate = null;
        this.vTranslateStart = null;
        this.pendingScale = Float.valueOf(0.0f);
        this.sPendingCenter = null;
        this.sRequestedCenter = null;
        this.isZooming = false;
        this.isPanning = false;
        this.isQuickScaling = false;
        this.maxTouchCount = 0;
        this.fullImageSampleSize = 0;
        this.vCenterStart = null;
        this.vDistStart = 0.0f;
        this.quickScaleCenter = null;
        this.quickScaleLastDistance = 0.0f;
        this.quickScaleLastPoint = null;
        this.quickScaleMoved = false;
        this.dci = null;
        this.dck = null;
        this.matrix = null;
        this.sRect = null;
        if (z) {
            this.uri = null;
            if (this.dcf != null) {
                synchronized (this.decoderLock) {
                    this.dcf.recycle();
                    this.dcf = null;
                }
            }
            if (this.bitmap != null && !this.dbZ) {
                this.bitmap.recycle();
            }
            this.sWidth = 0;
            this.sHeight = 0;
            this.sOrientation = 0;
            this.sRegion = null;
            this.pRegion = null;
            this.readySent = false;
            this.imageLoadedSent = false;
            this.bitmap = null;
            this.dbY = false;
            this.dbZ = false;
        }
        if (this.tileMap != null) {
            for (Map.Entry<Integer, List<g>> entry : this.tileMap.entrySet()) {
                for (g gVar : entry.getValue()) {
                    gVar.visible = false;
                    if (gVar.bitmap != null) {
                        gVar.bitmap.recycle();
                        gVar.bitmap = null;
                    }
                }
            }
            this.tileMap = null;
        }
        setGestureDetector(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(final Context context) {
        this.detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.swan.apps.media.image.HugePhotoDraweeView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (!HugePhotoDraweeView.this.panEnabled || !HugePhotoDraweeView.this.readySent || HugePhotoDraweeView.this.vTranslate == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f2) <= 500.0f && Math.abs(f3) <= 500.0f) || HugePhotoDraweeView.this.isZooming))) {
                    return super.onFling(motionEvent, motionEvent2, f2, f3);
                }
                PointF pointF = new PointF(HugePhotoDraweeView.this.vTranslate.x + (f2 * 0.25f), HugePhotoDraweeView.this.vTranslate.y + (0.25f * f3));
                new b(new PointF(((HugePhotoDraweeView.this.getWidth() / 2) - pointF.x) / HugePhotoDraweeView.this.scale, ((HugePhotoDraweeView.this.getHeight() / 2) - pointF.y) / HugePhotoDraweeView.this.scale)).jo(1).fG(false).start();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                HugePhotoDraweeView.this.performClick();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (HugePhotoDraweeView.this.zoomEnabled && HugePhotoDraweeView.this.readySent && HugePhotoDraweeView.this.vTranslate != null) {
                    HugePhotoDraweeView.this.setGestureDetector(context);
                    if (!HugePhotoDraweeView.this.quickScaleEnabled) {
                        HugePhotoDraweeView.this.doubleTapZoom(HugePhotoDraweeView.this.viewToSourceCoord(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                        return true;
                    }
                    HugePhotoDraweeView.this.vCenterStart = new PointF(motionEvent.getX(), motionEvent.getY());
                    HugePhotoDraweeView.this.vTranslateStart = new PointF(HugePhotoDraweeView.this.vTranslate.x, HugePhotoDraweeView.this.vTranslate.y);
                    HugePhotoDraweeView.this.scaleStart = HugePhotoDraweeView.this.scale;
                    HugePhotoDraweeView.this.isQuickScaling = true;
                    HugePhotoDraweeView.this.isZooming = true;
                    HugePhotoDraweeView.this.quickScaleCenter = HugePhotoDraweeView.this.viewToSourceCoord(HugePhotoDraweeView.this.vCenterStart);
                    HugePhotoDraweeView.this.quickScaleLastDistance = -1.0f;
                    HugePhotoDraweeView.this.quickScaleLastPoint = new PointF(HugePhotoDraweeView.this.quickScaleCenter.x, HugePhotoDraweeView.this.quickScaleCenter.y);
                    HugePhotoDraweeView.this.quickScaleMoved = false;
                    return false;
                }
                return super.onDoubleTapEvent(motionEvent);
            }
        });
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        PointF center = getCenter();
        if (this.readySent && center != null) {
            this.dci = null;
            this.pendingScale = Float.valueOf(this.scale);
            this.sPendingCenter = center;
        }
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        boolean z = mode != 1073741824;
        boolean z2 = mode2 != 1073741824;
        if (this.sWidth > 0 && this.sHeight > 0) {
            if (z && z2) {
                i5 = sWidth();
                i4 = sHeight();
            } else if (z2) {
                i4 = (int) ((sHeight() / sWidth()) * size);
                i5 = size;
            } else if (z) {
                i5 = (int) ((sWidth() / sHeight()) * size2);
                i4 = size2;
            }
            setMeasuredDimension(Math.max(i5, getSuggestedMinimumWidth()), Math.max(i4, getSuggestedMinimumHeight()));
        }
        i4 = size2;
        i5 = size;
        setMeasuredDimension(Math.max(i5, getSuggestedMinimumWidth()), Math.max(i4, getSuggestedMinimumHeight()));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        float f2;
        boolean z = false;
        if (this.dci != null && !this.dci.interruptible) {
            getParent().requestDisallowInterceptTouchEvent(true);
            return true;
        }
        if (this.dci != null && this.dci.dcp != null) {
            try {
                this.dci.dcp.aAy();
            } catch (Exception e2) {
                Log.w("HugePhotoDraweeView", "Error thrown by animation listener", e2);
            }
        }
        this.dci = null;
        if (this.dcm && this.vTranslate == null) {
            this.vTranslate = new PointF();
        }
        if (this.vTranslate != null) {
            if (!this.isQuickScaling && (this.detector == null || this.detector.onTouchEvent(motionEvent))) {
                this.isZooming = false;
                this.isPanning = false;
                this.maxTouchCount = 0;
                return true;
            }
            if (this.vTranslateStart == null) {
                this.vTranslateStart = new PointF(0.0f, 0.0f);
            }
            if (this.vCenterStart == null) {
                this.vCenterStart = new PointF(0.0f, 0.0f);
            }
            int pointerCount = motionEvent.getPointerCount();
            switch (motionEvent.getAction()) {
                case 0:
                case 5:
                case 261:
                    this.dci = null;
                    getParent().requestDisallowInterceptTouchEvent(true);
                    this.maxTouchCount = Math.max(this.maxTouchCount, pointerCount);
                    if (pointerCount >= 2) {
                        if (this.zoomEnabled) {
                            float distance = distance(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                            this.scaleStart = this.scale;
                            this.vDistStart = distance;
                            this.vTranslateStart.set(this.vTranslate.x, this.vTranslate.y);
                            this.vCenterStart.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
                        } else {
                            this.maxTouchCount = 0;
                        }
                        this.handler.removeMessages(1);
                        return true;
                    } else if (this.isQuickScaling) {
                        return true;
                    } else {
                        this.vTranslateStart.set(this.vTranslate.x, this.vTranslate.y);
                        this.vCenterStart.set(motionEvent.getX(), motionEvent.getY());
                        this.handler.sendEmptyMessageDelayed(1, 600L);
                        return true;
                    }
                case 1:
                case 3:
                case 6:
                case 262:
                    aAw();
                    this.handler.removeMessages(1);
                    if (this.isQuickScaling) {
                        this.isQuickScaling = false;
                        if (!this.quickScaleMoved) {
                            doubleTapZoom(this.quickScaleCenter, this.vCenterStart);
                        }
                    }
                    if (this.maxTouchCount > 0 && (this.isZooming || this.isPanning)) {
                        if (this.isZooming && pointerCount == 2) {
                            this.isPanning = true;
                            this.vTranslateStart.set(this.vTranslate.x, this.vTranslate.y);
                            if (motionEvent.getActionIndex() == 1) {
                                this.vCenterStart.set(motionEvent.getX(0), motionEvent.getY(0));
                            } else {
                                this.vCenterStart.set(motionEvent.getX(1), motionEvent.getY(1));
                            }
                        }
                        if (pointerCount < 3) {
                            this.isZooming = false;
                        }
                        if (pointerCount < 2) {
                            this.isPanning = false;
                            this.maxTouchCount = 0;
                        }
                        refreshRequiredTiles(true);
                        return true;
                    } else if (pointerCount == 1) {
                        this.isZooming = false;
                        this.isPanning = false;
                        this.maxTouchCount = 0;
                        return true;
                    } else {
                        return true;
                    }
                case 2:
                    if (this.maxTouchCount > 0) {
                        if (pointerCount >= 2) {
                            float distance2 = distance(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                            float x = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
                            float y = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
                            if (this.zoomEnabled && (distance(this.vCenterStart.x, x, this.vCenterStart.y, y) > 5.0f || Math.abs(distance2 - this.vDistStart) > 5.0f || this.isPanning)) {
                                this.isZooming = true;
                                this.isPanning = true;
                                this.scale = Math.min(this.maxScale, (distance2 / this.vDistStart) * this.scaleStart);
                                float minScale = minScale();
                                if (this.scale <= minScale) {
                                    Log.i("HugePhotoDraweeView", "scale is " + this.scale + "<= minScaleValue is " + minScale);
                                } else if (this.panEnabled) {
                                    float f3 = this.vCenterStart.x - this.vTranslateStart.x;
                                    float f4 = this.vCenterStart.y - this.vTranslateStart.y;
                                    float f5 = f3 * (this.scale / this.scaleStart);
                                    float f6 = f4 * (this.scale / this.scaleStart);
                                    this.vTranslate.x = x - f5;
                                    this.vTranslate.y = y - f6;
                                } else if (this.sRequestedCenter != null) {
                                    this.vTranslate.x = (getWidth() / 2) - (this.scale * this.sRequestedCenter.x);
                                    this.vTranslate.y = (getHeight() / 2) - (this.scale * this.sRequestedCenter.y);
                                } else {
                                    this.vTranslate.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
                                    this.vTranslate.y = (getHeight() / 2) - (this.scale * (sHeight() / 2));
                                }
                                fitToBounds(true);
                                refreshRequiredTiles(false);
                                z = true;
                            }
                        } else if (this.isQuickScaling) {
                            float abs = this.quickScaleThreshold + (Math.abs(this.vCenterStart.y - motionEvent.getY()) * 2.0f);
                            if (this.quickScaleLastDistance == -1.0f) {
                                this.quickScaleLastDistance = abs;
                            }
                            boolean z2 = motionEvent.getY() > this.quickScaleLastPoint.y;
                            this.quickScaleLastPoint.set(0.0f, motionEvent.getY());
                            float abs2 = Math.abs(1.0f - (abs / this.quickScaleLastDistance)) * 0.5f;
                            if (abs2 > 0.03f || this.quickScaleMoved) {
                                this.quickScaleMoved = true;
                                if (this.quickScaleLastDistance > 0.0f) {
                                    f2 = z2 ? 1.0f + abs2 : 1.0f - abs2;
                                } else {
                                    f2 = 1.0f;
                                }
                                this.scale = Math.max(minScale(), Math.min(this.maxScale, f2 * this.scale));
                                if (this.panEnabled) {
                                    float f7 = this.vCenterStart.x - this.vTranslateStart.x;
                                    float f8 = this.vCenterStart.y - this.vTranslateStart.y;
                                    float f9 = f7 * (this.scale / this.scaleStart);
                                    float f10 = f8 * (this.scale / this.scaleStart);
                                    this.vTranslate.x = this.vCenterStart.x - f9;
                                    this.vTranslate.y = this.vCenterStart.y - f10;
                                } else if (this.sRequestedCenter != null) {
                                    this.vTranslate.x = (getWidth() / 2) - (this.scale * this.sRequestedCenter.x);
                                    this.vTranslate.y = (getHeight() / 2) - (this.scale * this.sRequestedCenter.y);
                                } else {
                                    this.vTranslate.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
                                    this.vTranslate.y = (getHeight() / 2) - (this.scale * (sHeight() / 2));
                                }
                            }
                            this.quickScaleLastDistance = abs;
                            fitToBounds(true);
                            refreshRequiredTiles(false);
                            z = true;
                        } else if (!this.isZooming) {
                            float abs3 = Math.abs(motionEvent.getX() - this.vCenterStart.x);
                            float abs4 = Math.abs(motionEvent.getY() - this.vCenterStart.y);
                            float f11 = this.dcl * 5.0f;
                            if (abs3 > f11 || abs4 > f11 || this.isPanning) {
                                this.vTranslate.x = this.vTranslateStart.x + (motionEvent.getX() - this.vCenterStart.x);
                                this.vTranslate.y = this.vTranslateStart.y + (motionEvent.getY() - this.vCenterStart.y);
                                float f12 = this.vTranslate.x;
                                float f13 = this.vTranslate.y;
                                fitToBounds(true);
                                boolean z3 = f12 != this.vTranslate.x;
                                boolean z4 = z3 && abs3 > abs4 && !this.isPanning;
                                boolean z5 = f13 == this.vTranslate.y && abs4 > 3.0f * f11;
                                if (!z4 && (!z3 || z5 || this.isPanning)) {
                                    this.isPanning = true;
                                } else if (abs3 > f11) {
                                    this.maxTouchCount = 0;
                                    this.handler.removeMessages(1);
                                    getParent().requestDisallowInterceptTouchEvent(false);
                                }
                                if (!this.panEnabled) {
                                    this.vTranslate.x = this.vTranslateStart.x;
                                    this.vTranslate.y = this.vTranslateStart.y;
                                    getParent().requestDisallowInterceptTouchEvent(false);
                                }
                                refreshRequiredTiles(false);
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        this.handler.removeMessages(1);
                        invalidate();
                        return true;
                    }
                    break;
            }
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doubleTapZoom(PointF pointF, PointF pointF2) {
        if (!this.panEnabled) {
            if (this.sRequestedCenter != null) {
                pointF.x = this.sRequestedCenter.x;
                pointF.y = this.sRequestedCenter.y;
            } else {
                pointF.x = sWidth() / 2;
                pointF.y = sHeight() / 2;
            }
        }
        float min = Math.min(this.maxScale, this.doubleTapZoomScale);
        boolean z = ((double) this.scale) <= ((double) min) * 0.9d;
        if (!z) {
            min = minScale();
        }
        if (this.doubleTapZoomStyle == 3) {
            setScaleAndCenter(min, pointF);
        } else if (this.doubleTapZoomStyle == 2 || !z || !this.panEnabled) {
            new b(min, pointF).fF(false).bR(this.dce).start();
        } else if (this.doubleTapZoomStyle == 1) {
            new b(min, pointF, pointF2).fF(false).bR(this.dce).start();
        }
        invalidate();
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        com.baidu.swan.apps.media.image.c.decorateSrcATopMode(getContext(), drawable);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z;
        if (this.dcm) {
            if (this.mColorFilter != com.baidu.swan.apps.media.image.c.getUiCoverLayerColor(getContext())) {
                com.baidu.swan.apps.media.image.c.decorateSrcATopMode(getContext(), getDrawable());
                this.mColorFilter = com.baidu.swan.apps.media.image.c.getUiCoverLayerColor(getContext());
            }
            super.onDraw(canvas);
            return;
        }
        createPaints();
        aAv();
        if (this.sWidth != 0 && this.sHeight != 0 && getWidth() != 0 && getHeight() != 0) {
            if (this.tileMap == null && this.dcf != null) {
                initialiseBaseLayer(getMaxBitmapDimensions(canvas));
            }
            if (checkReady()) {
                preDraw();
                if (this.dci != null) {
                    long currentTimeMillis = System.currentTimeMillis() - this.dci.time;
                    boolean z2 = currentTimeMillis > this.dci.duration;
                    long min = Math.min(currentTimeMillis, this.dci.duration);
                    this.scale = ease(this.dci.easing, min, this.dci.scaleStart, this.dci.scaleEnd - this.dci.scaleStart, this.dci.duration);
                    float ease = ease(this.dci.easing, min, this.dci.vFocusStart.x, this.dci.vFocusEnd.x - this.dci.vFocusStart.x, this.dci.duration);
                    float ease2 = ease(this.dci.easing, min, this.dci.vFocusStart.y, this.dci.vFocusEnd.y - this.dci.vFocusStart.y, this.dci.duration);
                    this.vTranslate.x -= sourceToViewX(this.dci.sCenterEnd.x) - ease;
                    this.vTranslate.y -= sourceToViewY(this.dci.sCenterEnd.y) - ease2;
                    fitToBounds(z2 || this.dci.scaleStart == this.dci.scaleEnd);
                    refreshRequiredTiles(z2);
                    if (z2) {
                        if (this.dci.dcp != null) {
                            try {
                                this.dci.dcp.onComplete();
                            } catch (Exception e2) {
                                Log.w("HugePhotoDraweeView", "Error thrown by animation listener", e2);
                            }
                        }
                        this.dci = null;
                    }
                    invalidate();
                }
                if (this.tileMap != null && isBaseLayerReady()) {
                    int min2 = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
                    boolean z3 = false;
                    Iterator<Map.Entry<Integer, List<g>>> it = this.tileMap.entrySet().iterator();
                    while (true) {
                        z = z3;
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<Integer, List<g>> next = it.next();
                        if (next.getKey().intValue() == min2) {
                            for (g gVar : next.getValue()) {
                                if (gVar.visible && (gVar.loading || gVar.bitmap == null)) {
                                    z = true;
                                }
                            }
                        }
                        z3 = z;
                    }
                    for (Map.Entry<Integer, List<g>> entry : this.tileMap.entrySet()) {
                        if (entry.getKey().intValue() == min2 || z) {
                            for (g gVar2 : entry.getValue()) {
                                sourceToViewRect(gVar2.sRect, gVar2.vRect);
                                if (!gVar2.loading && gVar2.bitmap != null) {
                                    if (this.tileBgPaint != null) {
                                        canvas.drawRect(gVar2.vRect, this.tileBgPaint);
                                    }
                                    if (this.matrix == null) {
                                        this.matrix = new Matrix();
                                    }
                                    this.matrix.reset();
                                    setMatrixArray(this.srcArray, 0.0f, 0.0f, gVar2.bitmap.getWidth(), 0.0f, gVar2.bitmap.getWidth(), gVar2.bitmap.getHeight(), 0.0f, gVar2.bitmap.getHeight());
                                    if (getRequiredRotation() == 0) {
                                        setMatrixArray(this.dstArray, gVar2.vRect.left, gVar2.vRect.top, gVar2.vRect.right, gVar2.vRect.top, gVar2.vRect.right, gVar2.vRect.bottom, gVar2.vRect.left, gVar2.vRect.bottom);
                                    } else if (getRequiredRotation() == 90) {
                                        setMatrixArray(this.dstArray, gVar2.vRect.right, gVar2.vRect.top, gVar2.vRect.right, gVar2.vRect.bottom, gVar2.vRect.left, gVar2.vRect.bottom, gVar2.vRect.left, gVar2.vRect.top);
                                    } else if (getRequiredRotation() == 180) {
                                        setMatrixArray(this.dstArray, gVar2.vRect.right, gVar2.vRect.bottom, gVar2.vRect.left, gVar2.vRect.bottom, gVar2.vRect.left, gVar2.vRect.top, gVar2.vRect.right, gVar2.vRect.top);
                                    } else if (getRequiredRotation() == 270) {
                                        setMatrixArray(this.dstArray, gVar2.vRect.left, gVar2.vRect.bottom, gVar2.vRect.left, gVar2.vRect.top, gVar2.vRect.right, gVar2.vRect.top, gVar2.vRect.right, gVar2.vRect.bottom);
                                    }
                                    this.matrix.setPolyToPoly(this.srcArray, 0, this.dstArray, 0, 4);
                                    canvas.drawBitmap(gVar2.bitmap, this.matrix, this.bitmapPaint);
                                    if (this.debug) {
                                        canvas.drawRect(gVar2.vRect, this.debugPaint);
                                    }
                                } else if (gVar2.loading && this.debug) {
                                    canvas.drawText("LOADING", gVar2.vRect.left + 5, gVar2.vRect.top + 35, this.debugPaint);
                                }
                                if (gVar2.visible && this.debug) {
                                    canvas.drawText("ISS " + gVar2.sampleSize + " RECT " + gVar2.sRect.top + Constants.ACCEPT_TIME_SEPARATOR_SP + gVar2.sRect.left + Constants.ACCEPT_TIME_SEPARATOR_SP + gVar2.sRect.bottom + Constants.ACCEPT_TIME_SEPARATOR_SP + gVar2.sRect.right, gVar2.vRect.left + 5, gVar2.vRect.top + 15, this.debugPaint);
                                }
                            }
                        }
                    }
                    if (this.debug) {
                        canvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.scale)), 5.0f, 15.0f, this.debugPaint);
                        canvas.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.vTranslate.x)) + ":" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.vTranslate.y)), 5.0f, 35.0f, this.debugPaint);
                        PointF center = getCenter();
                        canvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.x)) + ":" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.y)), 5.0f, 55.0f, this.debugPaint);
                        if (this.dci == null) {
                            return;
                        }
                        PointF sourceToViewCoord = sourceToViewCoord(this.dci.sCenterStart);
                        PointF sourceToViewCoord2 = sourceToViewCoord(this.dci.sCenterEndRequested);
                        PointF sourceToViewCoord3 = sourceToViewCoord(this.dci.sCenterEnd);
                        canvas.drawCircle(sourceToViewCoord.x, sourceToViewCoord.y, 10.0f, this.debugPaint);
                        canvas.drawCircle(sourceToViewCoord2.x, sourceToViewCoord2.y, 20.0f, this.debugPaint);
                        canvas.drawCircle(sourceToViewCoord3.x, sourceToViewCoord3.y, 25.0f, this.debugPaint);
                        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 30.0f, this.debugPaint);
                    }
                } else if (this.bitmap != null) {
                    float f2 = this.scale;
                    float f3 = this.scale;
                    if (this.dbY) {
                        f2 = (this.sWidth / this.bitmap.getWidth()) * this.scale;
                        f3 = this.scale * (this.sHeight / this.bitmap.getHeight());
                    }
                    if (this.matrix == null) {
                        this.matrix = new Matrix();
                    }
                    this.matrix.reset();
                    this.matrix.postScale(f2, f3);
                    this.matrix.postRotate(getRequiredRotation());
                    this.matrix.postTranslate(this.vTranslate.x, this.vTranslate.y);
                    if (getRequiredRotation() == 180) {
                        this.matrix.postTranslate(this.scale * this.sWidth, this.scale * this.sHeight);
                    } else if (getRequiredRotation() == 90) {
                        this.matrix.postTranslate(this.scale * this.sHeight, 0.0f);
                    } else if (getRequiredRotation() == 270) {
                        this.matrix.postTranslate(0.0f, this.scale * this.sWidth);
                    }
                    if (this.tileBgPaint != null) {
                        if (this.sRect == null) {
                            this.sRect = new RectF();
                        }
                        this.sRect.set(0.0f, 0.0f, this.sWidth, this.sHeight);
                        this.matrix.mapRect(this.sRect);
                        canvas.drawRect(this.sRect, this.tileBgPaint);
                    }
                    if (this.bitmap != null && !this.bitmap.isRecycled()) {
                        canvas.drawBitmap(this.bitmap, this.matrix, this.bitmapPaint);
                    } else {
                        Log.i("HugePhotoDraweeView", "onDraw-> Bitmap is NULL or Recycled <--");
                    }
                }
            }
        }
    }

    private void aAv() {
        if (this.bitmapPaint != null) {
            if (this.mColorFilter != com.baidu.swan.apps.media.image.c.getUiCoverLayerColor(getContext())) {
                this.mColorFilter = com.baidu.swan.apps.media.image.c.getUiCoverLayerColor(getContext());
                this.dcn = new PorterDuffColorFilter(this.mColorFilter, PorterDuff.Mode.SRC_ATOP);
            }
            this.bitmapPaint.setColorFilter(this.dcn);
        }
    }

    private void setMatrixArray(float[] fArr, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        fArr[3] = f5;
        fArr[4] = f6;
        fArr[5] = f7;
        fArr[6] = f8;
        fArr[7] = f9;
    }

    private boolean isBaseLayerReady() {
        boolean z = true;
        if (this.bitmap != null && !this.dbY) {
            return true;
        }
        if (this.tileMap == null) {
            return false;
        }
        Iterator<Map.Entry<Integer, List<g>>> it = this.tileMap.entrySet().iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            Map.Entry<Integer, List<g>> next = it.next();
            if (next.getKey().intValue() == this.fullImageSampleSize) {
                for (g gVar : next.getValue()) {
                    if (gVar.loading || gVar.bitmap == null) {
                        z2 = false;
                    }
                }
            }
            z = z2;
        }
    }

    private boolean checkReady() {
        boolean z = getWidth() > 0 && getHeight() > 0 && this.sWidth > 0 && this.sHeight > 0 && (this.bitmap != null || isBaseLayerReady());
        if (!this.readySent && z) {
            preDraw();
            this.readySent = true;
            onReady();
            if (this.dcj != null) {
                this.dcj.onReady();
            }
        }
        return z;
    }

    private boolean checkImageLoaded() {
        boolean isBaseLayerReady = isBaseLayerReady();
        if (!this.imageLoadedSent && isBaseLayerReady) {
            preDraw();
            this.imageLoadedSent = true;
            onImageLoaded();
            if (this.dcj != null) {
                this.dcj.onImageLoaded();
            }
        }
        return isBaseLayerReady;
    }

    private void createPaints() {
        if (this.bitmapPaint == null) {
            this.bitmapPaint = new Paint();
            this.bitmapPaint.setAntiAlias(true);
            this.bitmapPaint.setFilterBitmap(true);
            this.bitmapPaint.setDither(true);
        }
        if (this.debugPaint == null && this.debug) {
            this.debugPaint = new Paint();
            this.debugPaint.setTextSize(18.0f);
            this.debugPaint.setColor(-65281);
            this.debugPaint.setStyle(Paint.Style.STROKE);
        }
    }

    private synchronized void initialiseBaseLayer(Point point) {
        this.dck = new f(0.0f, new PointF(0.0f, 0.0f));
        a(true, this.dck);
        this.fullImageSampleSize = calculateInSampleSize(this.dck.scale);
        if (this.fullImageSampleSize > 1) {
            this.fullImageSampleSize /= 2;
        }
        if (this.fullImageSampleSize == 1 && this.sRegion == null && sWidth() < point.x && sHeight() < point.y && this.uri != null) {
            this.dcf.recycle();
            this.dcf = null;
            a(new c(this, getContext(), this.dcg, this.uri, false));
        } else {
            initialiseTileMap(point);
            for (g gVar : this.tileMap.get(Integer.valueOf(this.fullImageSampleSize))) {
                a(new h(this, this.dcf, gVar));
            }
            refreshRequiredTiles(true);
        }
    }

    private void refreshRequiredTiles(boolean z) {
        if (this.dcf != null && this.tileMap != null) {
            int min = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
            for (Map.Entry<Integer, List<g>> entry : this.tileMap.entrySet()) {
                for (g gVar : entry.getValue()) {
                    if (gVar.sampleSize < min || (gVar.sampleSize > min && gVar.sampleSize != this.fullImageSampleSize)) {
                        gVar.visible = false;
                        if (gVar.bitmap != null) {
                            gVar.bitmap.recycle();
                            gVar.bitmap = null;
                        }
                    }
                    if (gVar.sampleSize == min) {
                        if (a(gVar)) {
                            gVar.visible = true;
                            if (!gVar.loading && gVar.bitmap == null && z) {
                                a(new h(this, this.dcf, gVar));
                            }
                        } else if (gVar.sampleSize != this.fullImageSampleSize) {
                            gVar.visible = false;
                            if (gVar.bitmap != null) {
                                gVar.bitmap.recycle();
                                gVar.bitmap = null;
                            }
                        }
                    } else if (gVar.sampleSize == this.fullImageSampleSize) {
                        gVar.visible = true;
                    }
                }
            }
        }
    }

    private boolean a(g gVar) {
        return viewToSourceX(0.0f) <= ((float) gVar.sRect.right) && ((float) gVar.sRect.left) <= viewToSourceX((float) getWidth()) && viewToSourceY(0.0f) <= ((float) gVar.sRect.bottom) && ((float) gVar.sRect.top) <= viewToSourceY((float) getHeight());
    }

    private void preDraw() {
        if (getWidth() != 0 && getHeight() != 0 && this.sWidth > 0 && this.sHeight > 0) {
            if (this.sPendingCenter != null && this.pendingScale != null) {
                this.scale = this.pendingScale.floatValue();
                if (this.vTranslate == null) {
                    this.vTranslate = new PointF();
                }
                this.vTranslate.x = (getWidth() / 2) - (this.scale * this.sPendingCenter.x);
                this.vTranslate.y = (getHeight() / 2) - (this.scale * this.sPendingCenter.y);
                this.sPendingCenter = null;
                this.pendingScale = null;
                fitToBounds(true);
                refreshRequiredTiles(true);
            }
            fitToBounds(false);
        }
    }

    private int calculateInSampleSize(float f2) {
        int round;
        if (this.minimumTileDpi > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f2 *= this.minimumTileDpi / ((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f);
        }
        int sWidth = (int) (sWidth() * f2);
        int sHeight = (int) (sHeight() * f2);
        if (sWidth == 0 || sHeight == 0) {
            return 32;
        }
        if (sHeight() > sHeight || sWidth() > sWidth) {
            round = Math.round(sHeight() / sHeight);
            int round2 = Math.round(sWidth() / sWidth);
            if (round >= round2) {
                round = round2;
            }
        } else {
            round = 1;
        }
        int i2 = 1;
        while (i2 * 2 < round) {
            i2 *= 2;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, f fVar) {
        float max;
        float max2;
        float f2 = 0.5f;
        if (this.panLimit == 2 && isReady()) {
            z = false;
        }
        PointF pointF = fVar.vTranslate;
        float limitedScale = limitedScale(fVar.scale);
        float sWidth = limitedScale * sWidth();
        float sHeight = limitedScale * sHeight();
        if (this.panLimit == 3 && isReady()) {
            pointF.x = Math.max(pointF.x, (getWidth() / 2) - sWidth);
            pointF.y = Math.max(pointF.y, (getHeight() / 2) - sHeight);
        } else if (z) {
            pointF.x = Math.max(pointF.x, getWidth() - sWidth);
            pointF.y = Math.max(pointF.y, getHeight() - sHeight);
        } else {
            pointF.x = Math.max(pointF.x, -sWidth);
            pointF.y = Math.max(pointF.y, -sHeight);
        }
        float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? getPaddingLeft() / (getPaddingLeft() + getPaddingRight()) : 0.5f;
        if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
            f2 = getPaddingTop() / (getPaddingTop() + getPaddingBottom());
        }
        if (this.panLimit == 3 && isReady()) {
            max = Math.max(0, getWidth() / 2);
            max2 = Math.max(0, getHeight() / 2);
        } else if (z) {
            max = Math.max(0.0f, (getWidth() - sWidth) * paddingLeft);
            max2 = Math.max(0.0f, (getHeight() - sHeight) * f2);
        } else {
            max = Math.max(0, getWidth());
            max2 = Math.max(0, getHeight());
        }
        pointF.x = Math.min(pointF.x, max);
        pointF.y = Math.min(pointF.y, max2);
        fVar.scale = limitedScale;
    }

    private void fitToBounds(boolean z) {
        boolean z2 = false;
        if (this.vTranslate == null) {
            z2 = true;
            this.vTranslate = new PointF(0.0f, 0.0f);
        }
        if (this.dck == null) {
            this.dck = new f(0.0f, new PointF(0.0f, 0.0f));
        }
        this.dck.scale = this.scale;
        this.dck.vTranslate.set(this.vTranslate);
        a(z, this.dck);
        this.scale = this.dck.scale;
        this.vTranslate.set(this.dck.vTranslate);
        if (z2) {
            this.vTranslate.set(vTranslateForSCenter(sWidth() / 2, sHeight() / 2, this.scale));
        }
    }

    private void initialiseTileMap(Point point) {
        this.tileMap = new LinkedHashMap();
        int i2 = this.fullImageSampleSize;
        int i3 = 1;
        int i4 = 1;
        while (true) {
            int sWidth = sWidth() / i3;
            int sHeight = sHeight() / i4;
            int i5 = sWidth / i2;
            int i6 = sHeight / i2;
            while (true) {
                if (i5 + i3 + 1 > point.x || (i5 > getWidth() * 1.25d && i2 < this.fullImageSampleSize)) {
                    int i7 = i3 + 1;
                    int sWidth2 = sWidth() / i7;
                    i3 = i7;
                    sWidth = sWidth2;
                    i5 = sWidth2 / i2;
                }
            }
            int i8 = i6;
            int i9 = sHeight;
            while (true) {
                if (i8 + i4 + 1 > point.y || (i8 > getHeight() * 1.25d && i2 < this.fullImageSampleSize)) {
                    int i10 = i4 + 1;
                    int sHeight2 = sHeight() / i10;
                    i4 = i10;
                    i9 = sHeight2;
                    i8 = sHeight2 / i2;
                }
            }
            ArrayList arrayList = new ArrayList(i3 * i4);
            int i11 = 0;
            while (i11 < i3) {
                int i12 = 0;
                while (i12 < i4) {
                    g gVar = new g();
                    gVar.sampleSize = i2;
                    gVar.visible = i2 == this.fullImageSampleSize;
                    gVar.sRect = new Rect(i11 * sWidth, i12 * i9, i11 == i3 + (-1) ? sWidth() : (i11 + 1) * sWidth, i12 == i4 + (-1) ? sHeight() : (i12 + 1) * i9);
                    gVar.vRect = new Rect(0, 0, 0, 0);
                    gVar.fileSRect = new Rect(gVar.sRect);
                    arrayList.add(gVar);
                    i12++;
                }
                i11++;
            }
            this.tileMap.put(Integer.valueOf(i2), arrayList);
            if (i2 != 1) {
                i2 /= 2;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class i extends AsyncTask<Void, Void, int[]> {
        private final WeakReference<Context> contextRef;
        private com.baidu.swan.apps.media.image.a.d dcf;
        private com.baidu.swan.apps.media.image.b dcq;
        private final WeakReference<com.baidu.swan.apps.media.image.a.b<? extends com.baidu.swan.apps.media.image.a.d>> decoderFactoryRef;
        private Exception exception;
        private final WeakReference<HugePhotoDraweeView> viewRef;

        public i(HugePhotoDraweeView hugePhotoDraweeView, Context context, com.baidu.swan.apps.media.image.a.b<? extends com.baidu.swan.apps.media.image.a.d> bVar, com.baidu.swan.apps.media.image.b bVar2) {
            this.viewRef = new WeakReference<>(hugePhotoDraweeView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(bVar);
            this.dcq = bVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public int[] doInBackground(Void... voidArr) {
            Point init;
            int i;
            int i2;
            try {
                if (this.dcq.getUri() != null) {
                    this.dcq.getUri().toString();
                }
                Context context = this.contextRef.get();
                com.baidu.swan.apps.media.image.a.b<? extends com.baidu.swan.apps.media.image.a.d> bVar = this.decoderFactoryRef.get();
                HugePhotoDraweeView hugePhotoDraweeView = this.viewRef.get();
                if (context != null && bVar != null && hugePhotoDraweeView != null) {
                    this.dcf = bVar.make();
                    if (this.dcq.getBitmap() != null) {
                        init = this.dcf.a(context, this.dcq.getBitmap());
                    } else {
                        init = this.dcf.init(context, this.dcq.getUri());
                    }
                    int i3 = init.x;
                    int i4 = init.y;
                    int exifOrientation = hugePhotoDraweeView.getExifOrientation("");
                    if (hugePhotoDraweeView.sRegion != null) {
                        i = hugePhotoDraweeView.sRegion.width();
                        i2 = hugePhotoDraweeView.sRegion.height();
                    } else {
                        i = i3;
                        i2 = i4;
                    }
                    return new int[]{i, i2, exifOrientation};
                }
            } catch (Exception e) {
                Log.e("HugePhotoDraweeView", "Failed to initialise bitmap decoder", e);
                this.exception = e;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(int[] iArr) {
            HugePhotoDraweeView hugePhotoDraweeView = this.viewRef.get();
            if (hugePhotoDraweeView != null) {
                if (this.dcf != null && iArr != null && iArr.length == 3) {
                    hugePhotoDraweeView.a(this.dcf, iArr[0], iArr[1], iArr[2]);
                } else if (this.exception != null && hugePhotoDraweeView.dcj != null) {
                    hugePhotoDraweeView.dcj.onImageLoadError(this.exception);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.baidu.swan.apps.media.image.a.d dVar, int i2, int i3, int i4) {
        if (this.sWidth > 0 && this.sHeight > 0 && (this.sWidth != i2 || this.sHeight != i3)) {
            reset(false);
            if (this.bitmap != null) {
                if (!this.dbZ) {
                    this.bitmap.recycle();
                }
                this.bitmap = null;
                this.dbY = false;
                this.dbZ = false;
            }
        }
        this.dcf = dVar;
        this.sWidth = i2;
        this.sHeight = i3;
        this.sOrientation = i4;
        checkReady();
        checkImageLoaded();
        invalidate();
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class h extends AsyncTask<Void, Void, Bitmap> {
        private final WeakReference<com.baidu.swan.apps.media.image.a.d> decoderRef;
        private Exception exception;
        private final WeakReference<g> tileRef;
        private final WeakReference<HugePhotoDraweeView> viewRef;

        public h(HugePhotoDraweeView hugePhotoDraweeView, com.baidu.swan.apps.media.image.a.d dVar, g gVar) {
            this.viewRef = new WeakReference<>(hugePhotoDraweeView);
            this.decoderRef = new WeakReference<>(dVar);
            this.tileRef = new WeakReference<>(gVar);
            gVar.loading = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            HugePhotoDraweeView hugePhotoDraweeView;
            com.baidu.swan.apps.media.image.a.d dVar;
            g gVar;
            Bitmap decodeRegion;
            try {
                hugePhotoDraweeView = this.viewRef.get();
                dVar = this.decoderRef.get();
                gVar = this.tileRef.get();
            } catch (Exception e) {
                Log.e("HugePhotoDraweeView", "Failed to decode tile", e);
                this.exception = e;
            } catch (OutOfMemoryError e2) {
                Log.e("HugePhotoDraweeView", "Failed to decode tile - OutOfMemoryError", e2);
                this.exception = new RuntimeException(e2);
            }
            if (dVar != null && gVar != null && hugePhotoDraweeView != null && dVar.isReady() && gVar.visible) {
                synchronized (hugePhotoDraweeView.decoderLock) {
                    hugePhotoDraweeView.fileSRect(gVar.sRect, gVar.fileSRect);
                    if (hugePhotoDraweeView.sRegion != null) {
                        gVar.fileSRect.offset(hugePhotoDraweeView.sRegion.left, hugePhotoDraweeView.sRegion.top);
                    }
                    decodeRegion = dVar.decodeRegion(gVar.fileSRect, gVar.sampleSize);
                }
                return decodeRegion;
            }
            if (gVar != null) {
                gVar.loading = false;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            HugePhotoDraweeView hugePhotoDraweeView = this.viewRef.get();
            g gVar = this.tileRef.get();
            if (hugePhotoDraweeView != null && gVar != null) {
                if (bitmap == null) {
                    if (this.exception != null && hugePhotoDraweeView.dcj != null) {
                        hugePhotoDraweeView.dcj.onTileLoadError(this.exception);
                        return;
                    }
                    return;
                }
                gVar.bitmap = bitmap;
                gVar.loading = false;
                hugePhotoDraweeView.onTileLoaded();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTileLoaded() {
        checkReady();
        checkImageLoaded();
        if (isBaseLayerReady() && this.bitmap != null) {
            if (!this.dbZ) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            this.dbY = false;
            this.dbZ = false;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class c extends AsyncTask<Void, Void, Integer> {
        private Bitmap bitmap;
        private final WeakReference<Context> contextRef;
        private final WeakReference<com.baidu.swan.apps.media.image.a.b<? extends com.baidu.swan.apps.media.image.a.c>> decoderFactoryRef;
        private Exception exception;
        private final boolean preview;
        private final Uri source;
        private final WeakReference<HugePhotoDraweeView> viewRef;

        public c(HugePhotoDraweeView hugePhotoDraweeView, Context context, com.baidu.swan.apps.media.image.a.b<? extends com.baidu.swan.apps.media.image.a.c> bVar, Uri uri, boolean z) {
            this.viewRef = new WeakReference<>(hugePhotoDraweeView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(bVar);
            this.source = uri;
            this.preview = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Integer doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = this.contextRef.get();
                com.baidu.swan.apps.media.image.a.b<? extends com.baidu.swan.apps.media.image.a.c> bVar = this.decoderFactoryRef.get();
                HugePhotoDraweeView hugePhotoDraweeView = this.viewRef.get();
                if (context != null && bVar != null && hugePhotoDraweeView != null) {
                    this.bitmap = bVar.make().decode(context, this.source);
                    return Integer.valueOf(hugePhotoDraweeView.getExifOrientation(uri));
                }
            } catch (Exception e) {
                Log.e("HugePhotoDraweeView", "Failed to load bitmap", e);
                this.exception = e;
            } catch (OutOfMemoryError e2) {
                Log.e("HugePhotoDraweeView", "Failed to load bitmap - OutOfMemoryError", e2);
                this.exception = new RuntimeException(e2);
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Integer num) {
            HugePhotoDraweeView hugePhotoDraweeView = this.viewRef.get();
            if (hugePhotoDraweeView != null) {
                if (this.bitmap != null && num != null) {
                    if (this.preview) {
                        hugePhotoDraweeView.onPreviewLoaded(this.bitmap);
                    } else {
                        hugePhotoDraweeView.a(this.bitmap, num.intValue(), false);
                    }
                } else if (this.exception != null && hugePhotoDraweeView.dcj != null) {
                    if (this.preview) {
                        hugePhotoDraweeView.dcj.onPreviewLoadError(this.exception);
                    } else {
                        hugePhotoDraweeView.dcj.onImageLoadError(this.exception);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onPreviewLoaded(Bitmap bitmap) {
        if (this.bitmap != null || this.imageLoadedSent) {
            bitmap.recycle();
        } else {
            if (this.pRegion != null) {
                this.bitmap = Bitmap.createBitmap(bitmap, this.pRegion.left, this.pRegion.top, this.pRegion.width(), this.pRegion.height());
            } else {
                this.bitmap = bitmap;
            }
            this.dbY = true;
            if (checkReady()) {
                invalidate();
                requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(Bitmap bitmap, int i2, boolean z) {
        if (this.sWidth > 0 && this.sHeight > 0 && (this.sWidth != bitmap.getWidth() || this.sHeight != bitmap.getHeight())) {
            reset(false);
        }
        if (this.bitmap != null && !this.dbZ) {
            this.bitmap.recycle();
        }
        this.dbY = false;
        this.dbZ = z;
        this.bitmap = bitmap;
        this.sWidth = bitmap.getWidth();
        this.sHeight = bitmap.getHeight();
        this.sOrientation = i2;
        boolean checkReady = checkReady();
        boolean checkImageLoaded = checkImageLoaded();
        if (checkReady || checkImageLoaded) {
            invalidate();
            requestLayout();
        }
    }

    protected void onImageLoaded() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getExifOrientation(String str) {
        Cursor cursor;
        int i2;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.startsWith("content")) {
            try {
                try {
                    cursor = getContext().getContentResolver().query(Uri.parse(str), new String[]{"orientation"}, null, null, null);
                    if (cursor != null) {
                        try {
                            try {
                                if (cursor.moveToFirst()) {
                                    i2 = cursor.getInt(0);
                                    if (!VALID_ORIENTATIONS.contains(Integer.valueOf(i2)) || i2 == -1) {
                                        Log.w("HugePhotoDraweeView", "Unsupported orientation: " + i2);
                                    }
                                    com.baidu.swan.apps.media.image.a.closeSafely(cursor);
                                }
                                com.baidu.swan.apps.media.image.a.closeSafely(cursor);
                            } catch (Exception e2) {
                                Log.w("HugePhotoDraweeView", "Could not get orientation of image from media store");
                                com.baidu.swan.apps.media.image.a.closeSafely(cursor);
                                return i2;
                            }
                            i2 = 0;
                        } catch (Exception e3) {
                            i2 = 0;
                        }
                    } else {
                        i2 = 0;
                    }
                    com.baidu.swan.apps.media.image.a.closeSafely(cursor);
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.apps.media.image.a.closeSafely(null);
                    throw th;
                }
            } catch (Exception e4) {
                cursor = null;
                i2 = 0;
            } catch (Throwable th2) {
                th = th2;
                com.baidu.swan.apps.media.image.a.closeSafely(null);
                throw th;
            }
            return i2;
        } else if (!str.startsWith("file:///") || str.startsWith("file:///android_asset/")) {
            return 0;
        } else {
            try {
                int attributeInt = new ExifInterface(str.substring("file:///".length() - 1)).getAttributeInt(android.support.media.ExifInterface.TAG_ORIENTATION, 1);
                if (attributeInt == 1 || attributeInt == 0) {
                    return 0;
                }
                if (attributeInt == 6) {
                    return 90;
                }
                if (attributeInt == 3) {
                    return 180;
                }
                if (attributeInt == 8) {
                    return 270;
                }
                Log.w("HugePhotoDraweeView", "Unsupported EXIF orientation: " + attributeInt);
                return 0;
            } catch (Exception e5) {
                Log.w("HugePhotoDraweeView", "Could not get EXIF orientation of image");
                return 0;
            }
        }
    }

    private void a(AsyncTask<Void, Void, ?> asyncTask) {
        if (this.dcd && Build.VERSION.SDK_INT >= 11) {
            try {
                AsyncTask.class.getMethod("executeOnExecutor", Executor.class, Object[].class).invoke(asyncTask, (Executor) AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get(null), null);
                return;
            } catch (Exception e2) {
                Log.i("HugePhotoDraweeView", "Failed to execute AsyncTask on thread pool executor, falling back to single threaded executor", e2);
            }
        }
        asyncTask.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class g {
        private Bitmap bitmap;
        private Rect fileSRect;
        private boolean loading;
        private Rect sRect;
        private int sampleSize;
        private Rect vRect;
        private boolean visible;

        private g() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private d dcp;
        private long duration;
        private int easing;
        private boolean interruptible;
        private PointF sCenterEnd;
        private PointF sCenterEndRequested;
        private PointF sCenterStart;
        private float scaleEnd;
        private float scaleStart;
        private long time;
        private PointF vFocusEnd;
        private PointF vFocusStart;

        private a() {
            this.duration = 500L;
            this.interruptible = true;
            this.easing = 2;
            this.time = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class f {
        private float scale;
        private PointF vTranslate;

        private f(float f, PointF pointF) {
            this.scale = f;
            this.vTranslate = pointF;
        }
    }

    private void a(ImageViewState imageViewState) {
        if (imageViewState != null && imageViewState.getCenter() != null && VALID_ORIENTATIONS.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            this.orientation = imageViewState.getOrientation();
            this.pendingScale = Float.valueOf(imageViewState.getScale());
            this.sPendingCenter = imageViewState.getCenter();
            invalidate();
        }
    }

    public void setMaxTileSize(int i2) {
        this.dcb = i2;
        this.dcc = i2;
    }

    public void setMaxTileSize(int i2, int i3) {
        this.dcb = i2;
        this.dcc = i3;
    }

    private Point getMaxBitmapDimensions(Canvas canvas) {
        int i2;
        int i3;
        int intValue;
        int i4 = 2048;
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                intValue = ((Integer) Canvas.class.getMethod("getMaximumBitmapWidth", new Class[0]).invoke(canvas, new Object[0])).intValue();
            } catch (Exception e2) {
                i2 = 2048;
            }
            try {
                i3 = ((Integer) Canvas.class.getMethod("getMaximumBitmapHeight", new Class[0]).invoke(canvas, new Object[0])).intValue();
                i4 = intValue;
            } catch (Exception e3) {
                i2 = intValue;
                i4 = i2;
                i3 = 2048;
                return new Point(Math.min(i4, this.dcb), Math.min(i3, this.dcc));
            }
        } else {
            i3 = 2048;
        }
        return new Point(Math.min(i4, this.dcb), Math.min(i3, this.dcc));
    }

    private int sWidth() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.sHeight : this.sWidth;
    }

    private int sHeight() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.sWidth : this.sHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fileSRect(Rect rect, Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
        } else if (getRequiredRotation() == 90) {
            rect2.set(rect.top, this.sHeight - rect.right, rect.bottom, this.sHeight - rect.left);
        } else if (getRequiredRotation() == 180) {
            rect2.set(this.sWidth - rect.right, this.sHeight - rect.bottom, this.sWidth - rect.left, this.sHeight - rect.top);
        } else {
            rect2.set(this.sWidth - rect.bottom, rect.left, this.sWidth - rect.top, rect.right);
        }
    }

    private int getRequiredRotation() {
        return this.orientation == -1 ? this.sOrientation : this.orientation;
    }

    private float distance(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f3;
        float f7 = f4 - f5;
        return (float) Math.sqrt((f6 * f6) + (f7 * f7));
    }

    private float viewToSourceX(float f2) {
        if (this.vTranslate == null) {
            return Float.NaN;
        }
        return (f2 - this.vTranslate.x) / this.scale;
    }

    private float viewToSourceY(float f2) {
        if (this.vTranslate == null) {
            return Float.NaN;
        }
        return (f2 - this.vTranslate.y) / this.scale;
    }

    public final PointF viewToSourceCoord(PointF pointF) {
        return viewToSourceCoord(pointF.x, pointF.y, new PointF());
    }

    public final PointF viewToSourceCoord(float f2, float f3) {
        return viewToSourceCoord(f2, f3, new PointF());
    }

    public final PointF viewToSourceCoord(float f2, float f3, PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(viewToSourceX(f2), viewToSourceY(f3));
        return pointF;
    }

    private float sourceToViewX(float f2) {
        if (this.vTranslate == null) {
            return Float.NaN;
        }
        return (this.scale * f2) + this.vTranslate.x;
    }

    private float sourceToViewY(float f2) {
        if (this.vTranslate == null) {
            return Float.NaN;
        }
        return (this.scale * f2) + this.vTranslate.y;
    }

    public final PointF sourceToViewCoord(PointF pointF) {
        return sourceToViewCoord(pointF.x, pointF.y, new PointF());
    }

    public final PointF sourceToViewCoord(float f2, float f3, PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(sourceToViewX(f2), sourceToViewY(f3));
        return pointF;
    }

    private Rect sourceToViewRect(Rect rect, Rect rect2) {
        rect2.set((int) sourceToViewX(rect.left), (int) sourceToViewY(rect.top), (int) sourceToViewX(rect.right), (int) sourceToViewY(rect.bottom));
        return rect2;
    }

    private PointF vTranslateForSCenter(float f2, float f3, float f4) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.dck == null) {
            this.dck = new f(0.0f, new PointF(0.0f, 0.0f));
        }
        this.dck.scale = f4;
        this.dck.vTranslate.set(paddingLeft - (f2 * f4), paddingTop - (f3 * f4));
        a(true, this.dck);
        return this.dck.vTranslate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointF limitedSCenter(float f2, float f3, float f4, PointF pointF) {
        PointF vTranslateForSCenter = vTranslateForSCenter(f2, f3, f4);
        pointF.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - vTranslateForSCenter.x) / f4, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - vTranslateForSCenter.y) / f4);
        return pointF;
    }

    private float minScale() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        if (this.minimumScaleType == 2) {
            return Math.max((getWidth() - paddingLeft) / sWidth(), (getHeight() - paddingBottom) / sHeight());
        }
        if (this.minimumScaleType == 3 && this.minScale > 0.0f) {
            return this.minScale;
        }
        return Math.min((getWidth() - paddingLeft) / sWidth(), (getHeight() - paddingBottom) / sHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float limitedScale(float f2) {
        if (f2 > 0.0f && f2 < minScale()) {
            Log.i("HugePhotoDraweeView", "targetScale is " + f2 + "< minScale is " + minScale());
        } else {
            f2 = Math.max(minScale(), f2);
        }
        return Math.min(this.maxScale, f2);
    }

    private float ease(int i2, long j, float f2, float f3, long j2) {
        switch (i2) {
            case 1:
                return easeOutQuad(j, f2, f3, j2);
            case 2:
                return easeInOutQuad(j, f2, f3, j2);
            default:
                throw new IllegalStateException("Unexpected easing type: " + i2);
        }
    }

    private float easeOutQuad(long j, float f2, float f3, long j2) {
        float f4 = ((float) j) / ((float) j2);
        return ((f4 - 2.0f) * (-f3) * f4) + f2;
    }

    private float easeInOutQuad(long j, float f2, float f3, long j2) {
        float f4 = ((float) j) / (((float) j2) / 2.0f);
        if (f4 < 1.0f) {
            return (f4 * (f3 / 2.0f) * f4) + f2;
        }
        float f5 = f4 - 1.0f;
        return (((f5 * (f5 - 2.0f)) - 1.0f) * ((-f3) / 2.0f)) + f2;
    }

    public final void setRegionDecoderClass(Class<? extends com.baidu.swan.apps.media.image.a.d> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.dch = new com.baidu.swan.apps.media.image.a.a(cls);
    }

    public final void setRegionDecoderFactory(com.baidu.swan.apps.media.image.a.b<? extends com.baidu.swan.apps.media.image.a.d> bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.dch = bVar;
    }

    public final void setBitmapDecoderClass(Class<? extends com.baidu.swan.apps.media.image.a.c> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.dcg = new com.baidu.swan.apps.media.image.a.a(cls);
    }

    public final void setBitmapDecoderFactory(com.baidu.swan.apps.media.image.a.b<? extends com.baidu.swan.apps.media.image.a.c> bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.dcg = bVar;
    }

    public final void setPanLimit(int i2) {
        if (!VALID_PAN_LIMITS.contains(Integer.valueOf(i2))) {
            throw new IllegalArgumentException("Invalid pan limit: " + i2);
        }
        this.panLimit = i2;
        if (isReady()) {
            fitToBounds(true);
            invalidate();
        }
    }

    public final void setMinimumScaleType(int i2) {
        if (!VALID_SCALE_TYPES.contains(Integer.valueOf(i2))) {
            throw new IllegalArgumentException("Invalid scale type: " + i2);
        }
        this.minimumScaleType = i2;
        if (isReady()) {
            fitToBounds(true);
            invalidate();
        }
    }

    public final void setMaxScale(float f2) {
        this.maxScale = f2;
    }

    public final void setMinScale(float f2) {
        this.minScale = f2;
    }

    public final void setMinimumDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale((((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f) * 2.0f) / i2);
    }

    public final void setMaximumDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f) / i2);
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public final float getMinScale() {
        return minScale();
    }

    public void setMinimumTileDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.minimumTileDpi = (int) Math.min((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f, i2);
        if (isReady()) {
            reset(false);
            invalidate();
        }
    }

    public final PointF getCenter() {
        return viewToSourceCoord(getWidth() / 2, getHeight() / 2);
    }

    public final float getScale() {
        return this.scale;
    }

    public final void setScaleAndCenter(float f2, PointF pointF) {
        this.dci = null;
        this.pendingScale = Float.valueOf(f2);
        this.sPendingCenter = pointF;
        this.sRequestedCenter = pointF;
        invalidate();
    }

    public final void aAw() {
        if (this.scale < minScale()) {
            resetScaleAndCenter();
        }
    }

    public final void resetScaleAndCenter() {
        this.dci = null;
        this.pendingScale = Float.valueOf(limitedScale(0.0f));
        if (isReady()) {
            this.sPendingCenter = new PointF(sWidth() / 2, sHeight() / 2);
        } else {
            this.sPendingCenter = new PointF(0.0f, 0.0f);
        }
        invalidate();
    }

    public final boolean isReady() {
        return this.readySent;
    }

    protected void onReady() {
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final ImageViewState getState() {
        if (this.vTranslate == null || this.sWidth <= 0 || this.sHeight <= 0) {
            return null;
        }
        return new ImageViewState(getScale(), getCenter(), getOrientation());
    }

    public final void setZoomEnabled(boolean z) {
        this.zoomEnabled = z;
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.quickScaleEnabled = z;
    }

    public final void setPanEnabled(boolean z) {
        this.panEnabled = z;
        if (!z && this.vTranslate != null) {
            this.vTranslate.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
            this.vTranslate.y = (getHeight() / 2) - (this.scale * (sHeight() / 2));
            if (isReady()) {
                refreshRequiredTiles(true);
                invalidate();
            }
        }
    }

    public final void setTileBackgroundColor(int i2) {
        if (Color.alpha(i2) == 0) {
            this.tileBgPaint = null;
        } else {
            this.tileBgPaint = new Paint();
            this.tileBgPaint.setStyle(Paint.Style.FILL);
            this.tileBgPaint.setColor(i2);
        }
        invalidate();
    }

    public final void setDoubleTapZoomScale(float f2) {
        this.doubleTapZoomScale = f2;
    }

    public final void setDoubleTapZoomDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale((((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f) * 2.0f) / i2);
    }

    public final void setDoubleTapZoomStyle(int i2) {
        if (!VALID_ZOOM_STYLES.contains(Integer.valueOf(i2))) {
            throw new IllegalArgumentException("Invalid zoom style: " + i2);
        }
        this.doubleTapZoomStyle = i2;
    }

    public final void setDoubleTapZoomDuration(int i2) {
        this.dce = Math.max(0, i2);
    }

    public void setParallelLoadingEnabled(boolean z) {
        this.dcd = z;
    }

    public final void setDebug(boolean z) {
        this.debug = z;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setOnImageEventListener(e eVar) {
        this.dcj = eVar;
    }

    /* loaded from: classes7.dex */
    public final class b {
        private d dcp;
        private long duration;
        private int easing;
        private boolean interruptible;
        private boolean panLimited;
        private final PointF targetSCenter;
        private final float targetScale;
        private final PointF vFocus;

        private b(PointF pointF) {
            this.duration = 500L;
            this.easing = 2;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = HugePhotoDraweeView.this.scale;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private b(float f, PointF pointF) {
            this.duration = 500L;
            this.easing = 2;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private b(float f, PointF pointF, PointF pointF2) {
            this.duration = 500L;
            this.easing = 2;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = pointF;
            this.vFocus = pointF2;
        }

        public b bR(long j) {
            this.duration = j;
            return this;
        }

        public b fF(boolean z) {
            this.interruptible = z;
            return this;
        }

        public b jo(int i) {
            if (!HugePhotoDraweeView.VALID_EASING_STYLES.contains(Integer.valueOf(i))) {
                throw new IllegalArgumentException("Unknown easing type: " + i);
            }
            this.easing = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b fG(boolean z) {
            this.panLimited = z;
            return this;
        }

        public void start() {
            PointF pointF;
            if (HugePhotoDraweeView.this.dci != null && HugePhotoDraweeView.this.dci.dcp != null) {
                try {
                    HugePhotoDraweeView.this.dci.dcp.aAz();
                } catch (Exception e) {
                    Log.w("HugePhotoDraweeView", "Error thrown by animation listener", e);
                }
            }
            int width = (((HugePhotoDraweeView.this.getWidth() - HugePhotoDraweeView.this.getPaddingRight()) - HugePhotoDraweeView.this.getPaddingLeft()) / 2) + HugePhotoDraweeView.this.getPaddingLeft();
            int height = (((HugePhotoDraweeView.this.getHeight() - HugePhotoDraweeView.this.getPaddingBottom()) - HugePhotoDraweeView.this.getPaddingTop()) / 2) + HugePhotoDraweeView.this.getPaddingTop();
            float limitedScale = HugePhotoDraweeView.this.limitedScale(this.targetScale);
            if (this.panLimited) {
                pointF = HugePhotoDraweeView.this.limitedSCenter(this.targetSCenter.x, this.targetSCenter.y, limitedScale, new PointF());
            } else {
                pointF = this.targetSCenter;
            }
            HugePhotoDraweeView.this.dci = new a();
            HugePhotoDraweeView.this.dci.scaleStart = HugePhotoDraweeView.this.scale;
            HugePhotoDraweeView.this.dci.scaleEnd = limitedScale;
            HugePhotoDraweeView.this.dci.time = System.currentTimeMillis();
            HugePhotoDraweeView.this.dci.sCenterEndRequested = pointF;
            HugePhotoDraweeView.this.dci.sCenterStart = HugePhotoDraweeView.this.getCenter();
            HugePhotoDraweeView.this.dci.sCenterEnd = pointF;
            HugePhotoDraweeView.this.dci.vFocusStart = HugePhotoDraweeView.this.sourceToViewCoord(pointF);
            HugePhotoDraweeView.this.dci.vFocusEnd = new PointF(width, height);
            HugePhotoDraweeView.this.dci.duration = this.duration;
            HugePhotoDraweeView.this.dci.interruptible = this.interruptible;
            HugePhotoDraweeView.this.dci.easing = this.easing;
            HugePhotoDraweeView.this.dci.time = System.currentTimeMillis();
            HugePhotoDraweeView.this.dci.dcp = this.dcp;
            if (this.vFocus != null) {
                float f = this.vFocus.x - (HugePhotoDraweeView.this.dci.sCenterStart.x * limitedScale);
                float f2 = this.vFocus.y - (HugePhotoDraweeView.this.dci.sCenterStart.y * limitedScale);
                f fVar = new f(limitedScale, new PointF(f, f2));
                HugePhotoDraweeView.this.a(true, fVar);
                HugePhotoDraweeView.this.dci.vFocusEnd = new PointF((fVar.vTranslate.x - f) + this.vFocus.x, (fVar.vTranslate.y - f2) + this.vFocus.y);
            }
            HugePhotoDraweeView.this.invalidate();
        }
    }
}
