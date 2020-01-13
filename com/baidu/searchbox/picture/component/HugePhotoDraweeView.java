package com.baidu.searchbox.picture.component;

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
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.lib_atlas_base.R;
import com.baidu.searchbox.picture.component.view.ImageViewState;
import com.baidu.searchbox.picture.decoder.CompatDecoderFactory;
import com.baidu.searchbox.picture.decoder.DecoderFactory;
import com.baidu.searchbox.picture.decoder.ImageDecoder;
import com.baidu.searchbox.picture.decoder.ImageRegionDecoder;
import com.baidu.searchbox.picture.decoder.SkiaImageDecoder;
import com.baidu.searchbox.picture.decoder.SkiaImageRegionDecoder;
import com.baidu.searchbox.ui.util.PorterDuffModeHelper;
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
/* loaded from: classes12.dex */
public class HugePhotoDraweeView extends SimpleDraweeView {
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    private static final int MESSAGE_LONG_CLICK = 1;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 180;
    public static final int ORIENTATION_270 = 270;
    public static final int ORIENTATION_90 = 90;
    public static final int ORIENTATION_USE_EXIF = -1;
    public static final int PAN_LIMIT_CENTER = 3;
    public static final int PAN_LIMIT_INSIDE = 1;
    public static final int PAN_LIMIT_OUTSIDE = 2;
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int SCALE_TYPE_CUSTOM = 3;
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_FIXED = 1;
    private Anim anim;
    private Bitmap bitmap;
    private DecoderFactory<? extends ImageDecoder> bitmapDecoderFactory;
    private boolean bitmapIsCached;
    private boolean bitmapIsPreview;
    private Paint bitmapPaint;
    private boolean debug;
    private Paint debugPaint;
    private ImageRegionDecoder decoder;
    private final Object decoderLock;
    private float density;
    private GestureDetector detector;
    private int doubleTapZoomDuration;
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
    private ColorFilter mGlobalColorFilter;
    private boolean mIsDynamicBitmap;
    private Matrix matrix;
    private float maxScale;
    private int maxTileHeight;
    private int maxTileWidth;
    private int maxTouchCount;
    private float minScale;
    private int minimumScaleType;
    private int minimumTileDpi;
    private OnImageEventListener onImageEventListener;
    private View.OnLongClickListener onLongClickListener;
    private int orientation;
    private Rect pRegion;
    private boolean panEnabled;
    private int panLimit;
    private boolean parallelLoadingEnabled;
    private Float pendingScale;
    private PointF quickScaleCenter;
    private boolean quickScaleEnabled;
    private float quickScaleLastDistance;
    private PointF quickScaleLastPoint;
    private boolean quickScaleMoved;
    private final float quickScaleThreshold;
    private boolean readySent;
    private DecoderFactory<? extends ImageRegionDecoder> regionDecoderFactory;
    private int sHeight;
    private int sOrientation;
    private PointF sPendingCenter;
    private RectF sRect;
    private Rect sRegion;
    private PointF sRequestedCenter;
    private int sWidth;
    private ScaleAndTranslate satTemp;
    private float scale;
    private float scaleStart;
    private float[] srcArray;
    private Paint tileBgPaint;
    private Map<Integer, List<Tile>> tileMap;
    private Uri uri;
    private PointF vCenterStart;
    private float vDistStart;
    private PointF vTranslate;
    private PointF vTranslateStart;
    private boolean zoomEnabled;
    private static final String TAG = HugePhotoDraweeView.class.getSimpleName();
    private static final List<Integer> VALID_ORIENTATIONS = Arrays.asList(0, 90, 180, 270, -1);
    private static final List<Integer> VALID_ZOOM_STYLES = Arrays.asList(1, 2, 3);
    private static final List<Integer> VALID_EASING_STYLES = Arrays.asList(2, 1);
    private static final List<Integer> VALID_PAN_LIMITS = Arrays.asList(1, 2, 3);
    private static final List<Integer> VALID_SCALE_TYPES = Arrays.asList(2, 1, 3);
    public static int TILE_SIZE_AUTO = Integer.MAX_VALUE;

    /* loaded from: classes12.dex */
    public interface OnAnimationEventListener {
        void onComplete();

        void onInterruptedByNewAnim();

        void onInterruptedByUser();
    }

    /* loaded from: classes12.dex */
    public interface OnImageEventListener {
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
        this.maxTileWidth = TILE_SIZE_AUTO;
        this.maxTileHeight = TILE_SIZE_AUTO;
        this.panEnabled = true;
        this.zoomEnabled = true;
        this.quickScaleEnabled = true;
        this.doubleTapZoomScale = 5.0f;
        this.doubleTapZoomStyle = 1;
        this.doubleTapZoomDuration = 500;
        this.decoderLock = new Object();
        this.bitmapDecoderFactory = new CompatDecoderFactory(SkiaImageDecoder.class);
        this.regionDecoderFactory = new CompatDecoderFactory(SkiaImageRegionDecoder.class);
        this.srcArray = new float[8];
        this.dstArray = new float[8];
        this.mIsDynamicBitmap = false;
        this.mGlobalColorFilter = null;
        this.mColorFilter = 0;
        this.density = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMaximumDpi(720);
        setGestureDetector(context);
        this.handler = new Handler(new Handler.Callback() { // from class: com.baidu.searchbox.picture.component.HugePhotoDraweeView.1
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
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HugePhotoDraweeView);
            if (obtainStyledAttributes.hasValue(R.styleable.HugePhotoDraweeView_assetName) && (string = obtainStyledAttributes.getString(R.styleable.HugePhotoDraweeView_assetName)) != null && string.length() > 0) {
                setImage(ImageSource.asset(string).tilingEnabled());
            }
            if (obtainStyledAttributes.hasValue(R.styleable.HugePhotoDraweeView_src) && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.HugePhotoDraweeView_src, 0)) > 0) {
                setImage(ImageSource.resource(resourceId).tilingEnabled());
            }
            if (obtainStyledAttributes.hasValue(R.styleable.HugePhotoDraweeView_panEnabled)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(R.styleable.HugePhotoDraweeView_panEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.HugePhotoDraweeView_zoomEnabled)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(R.styleable.HugePhotoDraweeView_zoomEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.HugePhotoDraweeView_quickScaleEnabled)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(R.styleable.HugePhotoDraweeView_quickScaleEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.HugePhotoDraweeView_tileBackgroundColor)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(R.styleable.HugePhotoDraweeView_tileBackgroundColor, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.quickScaleThreshold = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    public HugePhotoDraweeView(Context context) {
        this(context, null);
    }

    public void setIsDynamicBitmap(boolean z) {
        this.mIsDynamicBitmap = z;
    }

    public final void setOrientation(int i) {
        if (!VALID_ORIENTATIONS.contains(Integer.valueOf(i))) {
            throw new IllegalArgumentException("Invalid orientation: " + i);
        }
        this.orientation = i;
        reset(false);
        invalidate();
        requestLayout();
    }

    public final void setImage(ImageSource imageSource) {
        setImage(imageSource, null, null);
    }

    public final void setImage(ImageSource imageSource, ImageViewState imageViewState) {
        setImage(imageSource, null, imageViewState);
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2) {
        setImage(imageSource, imageSource2, null);
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2, ImageViewState imageViewState) {
        if (imageSource == null) {
            throw new NullPointerException("imageSource must not be null");
        }
        reset(true);
        if (imageViewState != null) {
            restoreState(imageViewState);
        }
        if (imageSource2 != null) {
            if (imageSource.getBitmap() != null) {
                throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
            }
            if (imageSource.getSWidth() <= 0 || imageSource.getSHeight() <= 0) {
                throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
            }
            this.sWidth = imageSource.getSWidth();
            this.sHeight = imageSource.getSHeight();
            this.pRegion = imageSource2.getSRegion();
            if (imageSource2.getBitmap() != null) {
                this.bitmapIsCached = imageSource2.isCached();
                onPreviewLoaded(imageSource2.getBitmap());
            } else {
                Uri uri = imageSource2.getUri();
                if (uri == null && imageSource2.getResource() != null) {
                    uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource2.getResource());
                }
                execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, uri, true));
            }
        }
        if (imageSource.getBitmap() != null && imageSource.getSRegion() != null) {
            onImageLoaded(Bitmap.createBitmap(imageSource.getBitmap(), imageSource.getSRegion().left, imageSource.getSRegion().top, imageSource.getSRegion().width(), imageSource.getSRegion().height()), 0, false);
        } else if (imageSource.getBitmap() != null && !imageSource.getTile()) {
            onImageLoaded(imageSource.getBitmap(), 0, imageSource.isCached());
        } else {
            this.sRegion = imageSource.getSRegion();
            this.uri = imageSource.getUri();
            if (this.uri == null && imageSource.getResource() != null) {
                this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource.getResource());
            }
            if (imageSource.getTile() || this.sRegion != null) {
                execute(new TilesInitTask(this, getContext(), this.regionDecoderFactory, imageSource));
            } else {
                execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
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
        this.anim = null;
        this.satTemp = null;
        this.matrix = null;
        this.sRect = null;
        if (z) {
            this.uri = null;
            if (this.decoder != null) {
                synchronized (this.decoderLock) {
                    this.decoder.recycle();
                    this.decoder = null;
                }
            }
            if (this.bitmap != null && !this.bitmapIsCached) {
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
            this.bitmapIsPreview = false;
            this.bitmapIsCached = false;
        }
        if (this.tileMap != null) {
            for (Map.Entry<Integer, List<Tile>> entry : this.tileMap.entrySet()) {
                for (Tile tile : entry.getValue()) {
                    tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        tile.bitmap = null;
                    }
                }
            }
            this.tileMap = null;
        }
        setGestureDetector(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(final Context context) {
        this.detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.searchbox.picture.component.HugePhotoDraweeView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (!HugePhotoDraweeView.this.panEnabled || !HugePhotoDraweeView.this.readySent || HugePhotoDraweeView.this.vTranslate == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f) <= 500.0f && Math.abs(f2) <= 500.0f) || HugePhotoDraweeView.this.isZooming))) {
                    return super.onFling(motionEvent, motionEvent2, f, f2);
                }
                PointF pointF = new PointF(HugePhotoDraweeView.this.vTranslate.x + (f * 0.25f), HugePhotoDraweeView.this.vTranslate.y + (0.25f * f2));
                new AnimationBuilder(new PointF(((HugePhotoDraweeView.this.getWidth() / 2) - pointF.x) / HugePhotoDraweeView.this.scale, ((HugePhotoDraweeView.this.getHeight() / 2) - pointF.y) / HugePhotoDraweeView.this.scale)).withEasing(1).withPanLimited(false).start();
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
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        PointF center = getCenter();
        if (this.readySent && center != null) {
            this.anim = null;
            this.pendingScale = Float.valueOf(this.scale);
            this.sPendingCenter = center;
        }
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        boolean z = mode != 1073741824;
        boolean z2 = mode2 != 1073741824;
        if (this.sWidth > 0 && this.sHeight > 0) {
            if (z && z2) {
                i4 = sWidth();
                i3 = sHeight();
            } else if (z2) {
                i3 = (int) ((sHeight() / sWidth()) * size);
                i4 = size;
            } else if (z) {
                i4 = (int) ((sWidth() / sHeight()) * size2);
                i3 = size2;
            }
            setMeasuredDimension(Math.max(i4, getSuggestedMinimumWidth()), Math.max(i3, getSuggestedMinimumHeight()));
        }
        i3 = size2;
        i4 = size;
        setMeasuredDimension(Math.max(i4, getSuggestedMinimumWidth()), Math.max(i3, getSuggestedMinimumHeight()));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        float f;
        boolean z = false;
        if (this.anim != null && !this.anim.interruptible) {
            getParent().requestDisallowInterceptTouchEvent(true);
            return true;
        }
        if (this.anim != null && this.anim.listener != null) {
            try {
                this.anim.listener.onInterruptedByUser();
            } catch (Exception e) {
                Log.w(TAG, "Error thrown by animation listener", e);
            }
        }
        this.anim = null;
        if (this.mIsDynamicBitmap && this.vTranslate == null) {
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
                    this.anim = null;
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
                    resetMinScaleIfNeeded();
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
                                    Log.i(TAG, "scale is " + this.scale + "<= minScaleValue is " + minScale);
                                } else if (this.panEnabled) {
                                    float f2 = this.vCenterStart.x - this.vTranslateStart.x;
                                    float f3 = this.vCenterStart.y - this.vTranslateStart.y;
                                    float f4 = f2 * (this.scale / this.scaleStart);
                                    float f5 = f3 * (this.scale / this.scaleStart);
                                    this.vTranslate.x = x - f4;
                                    this.vTranslate.y = y - f5;
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
                                    f = z2 ? 1.0f + abs2 : 1.0f - abs2;
                                } else {
                                    f = 1.0f;
                                }
                                this.scale = Math.max(minScale(), Math.min(this.maxScale, f * this.scale));
                                if (this.panEnabled) {
                                    float f6 = this.vCenterStart.x - this.vTranslateStart.x;
                                    float f7 = this.vCenterStart.y - this.vTranslateStart.y;
                                    float f8 = f6 * (this.scale / this.scaleStart);
                                    float f9 = f7 * (this.scale / this.scaleStart);
                                    this.vTranslate.x = this.vCenterStart.x - f8;
                                    this.vTranslate.y = this.vCenterStart.y - f9;
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
                            float f10 = this.density * 5.0f;
                            if (abs3 > f10 || abs4 > f10 || this.isPanning) {
                                this.vTranslate.x = this.vTranslateStart.x + (motionEvent.getX() - this.vCenterStart.x);
                                this.vTranslate.y = this.vTranslateStart.y + (motionEvent.getY() - this.vCenterStart.y);
                                float f11 = this.vTranslate.x;
                                float f12 = this.vTranslate.y;
                                fitToBounds(true);
                                boolean z3 = f11 != this.vTranslate.x;
                                boolean z4 = z3 && abs3 > abs4 && !this.isPanning;
                                boolean z5 = f12 == this.vTranslate.y && abs4 > 3.0f * f10;
                                if (!z4 && (!z3 || z5 || this.isPanning)) {
                                    this.isPanning = true;
                                } else if (abs3 > f10) {
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
            new AnimationBuilder(min, pointF).withInterruptible(false).withDuration(this.doubleTapZoomDuration).start();
        } else if (this.doubleTapZoomStyle == 1) {
            new AnimationBuilder(min, pointF, pointF2).withInterruptible(false).withDuration(this.doubleTapZoomDuration).start();
        }
        invalidate();
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        PorterDuffModeHelper.decorateSrcATopMode(getContext(), drawable);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z;
        if (this.mIsDynamicBitmap) {
            if (this.mColorFilter != PorterDuffModeHelper.getUiCoverLayerColor(getContext())) {
                PorterDuffModeHelper.decorateSrcATopMode(getContext(), getDrawable());
                this.mColorFilter = PorterDuffModeHelper.getUiCoverLayerColor(getContext());
            }
            super.onDraw(canvas);
            return;
        }
        createPaints();
        drawImageViewNightMode();
        if (this.sWidth != 0 && this.sHeight != 0 && getWidth() != 0 && getHeight() != 0) {
            if (this.tileMap == null && this.decoder != null) {
                initialiseBaseLayer(getMaxBitmapDimensions(canvas));
            }
            if (checkReady()) {
                preDraw();
                if (this.anim != null) {
                    long currentTimeMillis = System.currentTimeMillis() - this.anim.time;
                    boolean z2 = currentTimeMillis > this.anim.duration;
                    long min = Math.min(currentTimeMillis, this.anim.duration);
                    this.scale = ease(this.anim.easing, min, this.anim.scaleStart, this.anim.scaleEnd - this.anim.scaleStart, this.anim.duration);
                    float ease = ease(this.anim.easing, min, this.anim.vFocusStart.x, this.anim.vFocusEnd.x - this.anim.vFocusStart.x, this.anim.duration);
                    float ease2 = ease(this.anim.easing, min, this.anim.vFocusStart.y, this.anim.vFocusEnd.y - this.anim.vFocusStart.y, this.anim.duration);
                    this.vTranslate.x -= sourceToViewX(this.anim.sCenterEnd.x) - ease;
                    this.vTranslate.y -= sourceToViewY(this.anim.sCenterEnd.y) - ease2;
                    fitToBounds(z2 || this.anim.scaleStart == this.anim.scaleEnd);
                    refreshRequiredTiles(z2);
                    if (z2) {
                        if (this.anim.listener != null) {
                            try {
                                this.anim.listener.onComplete();
                            } catch (Exception e) {
                                Log.w(TAG, "Error thrown by animation listener", e);
                            }
                        }
                        this.anim = null;
                    }
                    invalidate();
                }
                if (this.tileMap != null && isBaseLayerReady()) {
                    int min2 = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
                    boolean z3 = false;
                    Iterator<Map.Entry<Integer, List<Tile>>> it = this.tileMap.entrySet().iterator();
                    while (true) {
                        z = z3;
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<Integer, List<Tile>> next = it.next();
                        if (next.getKey().intValue() == min2) {
                            for (Tile tile : next.getValue()) {
                                if (tile.visible && (tile.loading || tile.bitmap == null)) {
                                    z = true;
                                }
                            }
                        }
                        z3 = z;
                    }
                    for (Map.Entry<Integer, List<Tile>> entry : this.tileMap.entrySet()) {
                        if (entry.getKey().intValue() == min2 || z) {
                            for (Tile tile2 : entry.getValue()) {
                                sourceToViewRect(tile2.sRect, tile2.vRect);
                                if (!tile2.loading && tile2.bitmap != null) {
                                    if (this.tileBgPaint != null) {
                                        canvas.drawRect(tile2.vRect, this.tileBgPaint);
                                    }
                                    if (this.matrix == null) {
                                        this.matrix = new Matrix();
                                    }
                                    this.matrix.reset();
                                    setMatrixArray(this.srcArray, 0.0f, 0.0f, tile2.bitmap.getWidth(), 0.0f, tile2.bitmap.getWidth(), tile2.bitmap.getHeight(), 0.0f, tile2.bitmap.getHeight());
                                    if (getRequiredRotation() == 0) {
                                        setMatrixArray(this.dstArray, tile2.vRect.left, tile2.vRect.top, tile2.vRect.right, tile2.vRect.top, tile2.vRect.right, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.bottom);
                                    } else if (getRequiredRotation() == 90) {
                                        setMatrixArray(this.dstArray, tile2.vRect.right, tile2.vRect.top, tile2.vRect.right, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.top);
                                    } else if (getRequiredRotation() == 180) {
                                        setMatrixArray(this.dstArray, tile2.vRect.right, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.top, tile2.vRect.right, tile2.vRect.top);
                                    } else if (getRequiredRotation() == 270) {
                                        setMatrixArray(this.dstArray, tile2.vRect.left, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.top, tile2.vRect.right, tile2.vRect.top, tile2.vRect.right, tile2.vRect.bottom);
                                    }
                                    this.matrix.setPolyToPoly(this.srcArray, 0, this.dstArray, 0, 4);
                                    canvas.drawBitmap(tile2.bitmap, this.matrix, this.bitmapPaint);
                                    if (this.debug) {
                                        canvas.drawRect(tile2.vRect, this.debugPaint);
                                    }
                                } else if (tile2.loading && this.debug) {
                                    canvas.drawText("LOADING", tile2.vRect.left + 5, tile2.vRect.top + 35, this.debugPaint);
                                }
                                if (tile2.visible && this.debug) {
                                    canvas.drawText("ISS " + tile2.sampleSize + " RECT " + tile2.sRect.top + Constants.ACCEPT_TIME_SEPARATOR_SP + tile2.sRect.left + Constants.ACCEPT_TIME_SEPARATOR_SP + tile2.sRect.bottom + Constants.ACCEPT_TIME_SEPARATOR_SP + tile2.sRect.right, tile2.vRect.left + 5, tile2.vRect.top + 15, this.debugPaint);
                                }
                            }
                        }
                    }
                    if (this.debug) {
                        canvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.scale)), 5.0f, 15.0f, this.debugPaint);
                        canvas.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.vTranslate.x)) + ":" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.vTranslate.y)), 5.0f, 35.0f, this.debugPaint);
                        PointF center = getCenter();
                        canvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.x)) + ":" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.y)), 5.0f, 55.0f, this.debugPaint);
                        if (this.anim == null) {
                            return;
                        }
                        PointF sourceToViewCoord = sourceToViewCoord(this.anim.sCenterStart);
                        PointF sourceToViewCoord2 = sourceToViewCoord(this.anim.sCenterEndRequested);
                        PointF sourceToViewCoord3 = sourceToViewCoord(this.anim.sCenterEnd);
                        canvas.drawCircle(sourceToViewCoord.x, sourceToViewCoord.y, 10.0f, this.debugPaint);
                        canvas.drawCircle(sourceToViewCoord2.x, sourceToViewCoord2.y, 20.0f, this.debugPaint);
                        canvas.drawCircle(sourceToViewCoord3.x, sourceToViewCoord3.y, 25.0f, this.debugPaint);
                        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 30.0f, this.debugPaint);
                    }
                } else if (this.bitmap != null) {
                    float f = this.scale;
                    float f2 = this.scale;
                    if (this.bitmapIsPreview) {
                        f = (this.sWidth / this.bitmap.getWidth()) * this.scale;
                        f2 = this.scale * (this.sHeight / this.bitmap.getHeight());
                    }
                    if (this.matrix == null) {
                        this.matrix = new Matrix();
                    }
                    this.matrix.reset();
                    this.matrix.postScale(f, f2);
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
                        Log.i(TAG, "onDraw-> Bitmap is NULL or Recycled <--");
                    }
                }
            }
        }
    }

    private void drawImageViewNightMode() {
        if (this.bitmapPaint != null) {
            if (this.mColorFilter != PorterDuffModeHelper.getUiCoverLayerColor(getContext())) {
                this.mColorFilter = PorterDuffModeHelper.getUiCoverLayerColor(getContext());
                this.mGlobalColorFilter = new PorterDuffColorFilter(this.mColorFilter, PorterDuff.Mode.SRC_ATOP);
            }
            this.bitmapPaint.setColorFilter(this.mGlobalColorFilter);
        }
    }

    private void setMatrixArray(float[] fArr, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
        fArr[4] = f5;
        fArr[5] = f6;
        fArr[6] = f7;
        fArr[7] = f8;
    }

    private boolean isBaseLayerReady() {
        boolean z = true;
        if (this.bitmap != null && !this.bitmapIsPreview) {
            return true;
        }
        if (this.tileMap == null) {
            return false;
        }
        Iterator<Map.Entry<Integer, List<Tile>>> it = this.tileMap.entrySet().iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            Map.Entry<Integer, List<Tile>> next = it.next();
            if (next.getKey().intValue() == this.fullImageSampleSize) {
                for (Tile tile : next.getValue()) {
                    if (tile.loading || tile.bitmap == null) {
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
            if (this.onImageEventListener != null) {
                this.onImageEventListener.onReady();
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
            if (this.onImageEventListener != null) {
                this.onImageEventListener.onImageLoaded();
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
        this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        fitToBounds(true, this.satTemp);
        this.fullImageSampleSize = calculateInSampleSize(this.satTemp.scale);
        if (this.fullImageSampleSize > 1) {
            this.fullImageSampleSize /= 2;
        }
        if (this.fullImageSampleSize == 1 && this.sRegion == null && sWidth() < point.x && sHeight() < point.y && this.uri != null) {
            this.decoder.recycle();
            this.decoder = null;
            execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
        } else {
            initialiseTileMap(point);
            for (Tile tile : this.tileMap.get(Integer.valueOf(this.fullImageSampleSize))) {
                execute(new TileLoadTask(this, this.decoder, tile));
            }
            refreshRequiredTiles(true);
        }
    }

    private void refreshRequiredTiles(boolean z) {
        if (this.decoder != null && this.tileMap != null) {
            int min = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
            for (Map.Entry<Integer, List<Tile>> entry : this.tileMap.entrySet()) {
                for (Tile tile : entry.getValue()) {
                    if (tile.sampleSize < min || (tile.sampleSize > min && tile.sampleSize != this.fullImageSampleSize)) {
                        tile.visible = false;
                        if (tile.bitmap != null) {
                            tile.bitmap.recycle();
                            tile.bitmap = null;
                        }
                    }
                    if (tile.sampleSize == min) {
                        if (tileVisible(tile)) {
                            tile.visible = true;
                            if (!tile.loading && tile.bitmap == null && z) {
                                execute(new TileLoadTask(this, this.decoder, tile));
                            }
                        } else if (tile.sampleSize != this.fullImageSampleSize) {
                            tile.visible = false;
                            if (tile.bitmap != null) {
                                tile.bitmap.recycle();
                                tile.bitmap = null;
                            }
                        }
                    } else if (tile.sampleSize == this.fullImageSampleSize) {
                        tile.visible = true;
                    }
                }
            }
        }
    }

    private boolean tileVisible(Tile tile) {
        return viewToSourceX(0.0f) <= ((float) tile.sRect.right) && ((float) tile.sRect.left) <= viewToSourceX((float) getWidth()) && viewToSourceY(0.0f) <= ((float) tile.sRect.bottom) && ((float) tile.sRect.top) <= viewToSourceY((float) getHeight());
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

    private int calculateInSampleSize(float f) {
        int round;
        if (this.minimumTileDpi > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f *= this.minimumTileDpi / ((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f);
        }
        int sWidth = (int) (sWidth() * f);
        int sHeight = (int) (sHeight() * f);
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
        int i = 1;
        while (i * 2 < round) {
            i *= 2;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fitToBounds(boolean z, ScaleAndTranslate scaleAndTranslate) {
        float max;
        float max2;
        float f = 0.5f;
        if (this.panLimit == 2 && isReady()) {
            z = false;
        }
        PointF pointF = scaleAndTranslate.vTranslate;
        float limitedScale = limitedScale(scaleAndTranslate.scale);
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
            f = getPaddingTop() / (getPaddingTop() + getPaddingBottom());
        }
        if (this.panLimit == 3 && isReady()) {
            max = Math.max(0, getWidth() / 2);
            max2 = Math.max(0, getHeight() / 2);
        } else if (z) {
            max = Math.max(0.0f, (getWidth() - sWidth) * paddingLeft);
            max2 = Math.max(0.0f, (getHeight() - sHeight) * f);
        } else {
            max = Math.max(0, getWidth());
            max2 = Math.max(0, getHeight());
        }
        pointF.x = Math.min(pointF.x, max);
        pointF.y = Math.min(pointF.y, max2);
        scaleAndTranslate.scale = limitedScale;
    }

    private void fitToBounds(boolean z) {
        boolean z2 = false;
        if (this.vTranslate == null) {
            z2 = true;
            this.vTranslate = new PointF(0.0f, 0.0f);
        }
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        this.satTemp.scale = this.scale;
        this.satTemp.vTranslate.set(this.vTranslate);
        fitToBounds(z, this.satTemp);
        this.scale = this.satTemp.scale;
        this.vTranslate.set(this.satTemp.vTranslate);
        if (z2) {
            this.vTranslate.set(vTranslateForSCenter(sWidth() / 2, sHeight() / 2, this.scale));
        }
    }

    private void initialiseTileMap(Point point) {
        this.tileMap = new LinkedHashMap();
        int i = this.fullImageSampleSize;
        int i2 = 1;
        int i3 = 1;
        while (true) {
            int sWidth = sWidth() / i2;
            int sHeight = sHeight() / i3;
            int i4 = sWidth / i;
            int i5 = sHeight / i;
            while (true) {
                if (i4 + i2 + 1 > point.x || (i4 > getWidth() * 1.25d && i < this.fullImageSampleSize)) {
                    int i6 = i2 + 1;
                    int sWidth2 = sWidth() / i6;
                    i2 = i6;
                    sWidth = sWidth2;
                    i4 = sWidth2 / i;
                }
            }
            int i7 = i5;
            int i8 = sHeight;
            while (true) {
                if (i7 + i3 + 1 > point.y || (i7 > getHeight() * 1.25d && i < this.fullImageSampleSize)) {
                    int i9 = i3 + 1;
                    int sHeight2 = sHeight() / i9;
                    i3 = i9;
                    i8 = sHeight2;
                    i7 = sHeight2 / i;
                }
            }
            ArrayList arrayList = new ArrayList(i2 * i3);
            int i10 = 0;
            while (i10 < i2) {
                int i11 = 0;
                while (i11 < i3) {
                    Tile tile = new Tile();
                    tile.sampleSize = i;
                    tile.visible = i == this.fullImageSampleSize;
                    tile.sRect = new Rect(i10 * sWidth, i11 * i8, i10 == i2 + (-1) ? sWidth() : (i10 + 1) * sWidth, i11 == i3 + (-1) ? sHeight() : (i11 + 1) * i8);
                    tile.vRect = new Rect(0, 0, 0, 0);
                    tile.fileSRect = new Rect(tile.sRect);
                    arrayList.add(tile);
                    i11++;
                }
                i10++;
            }
            this.tileMap.put(Integer.valueOf(i), arrayList);
            if (i != 1) {
                i /= 2;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class TilesInitTask extends AsyncTask<Void, Void, int[]> {
        private final WeakReference<Context> contextRef;
        private ImageRegionDecoder decoder;
        private final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> decoderFactoryRef;
        private Exception exception;
        private ImageSource imageSource;
        private final WeakReference<HugePhotoDraweeView> viewRef;

        public TilesInitTask(HugePhotoDraweeView hugePhotoDraweeView, Context context, DecoderFactory<? extends ImageRegionDecoder> decoderFactory, ImageSource imageSource) {
            this.viewRef = new WeakReference<>(hugePhotoDraweeView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.imageSource = imageSource;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public int[] doInBackground(Void... voidArr) {
            Point init;
            int i;
            int i2;
            try {
                if (this.imageSource.getUri() != null) {
                    this.imageSource.getUri().toString();
                }
                Context context = this.contextRef.get();
                DecoderFactory<? extends ImageRegionDecoder> decoderFactory = this.decoderFactoryRef.get();
                HugePhotoDraweeView hugePhotoDraweeView = this.viewRef.get();
                if (context != null && decoderFactory != null && hugePhotoDraweeView != null) {
                    this.decoder = decoderFactory.make();
                    if (this.imageSource.getBitmap() != null) {
                        init = this.decoder.init(context, this.imageSource.getBitmap());
                    } else {
                        init = this.decoder.init(context, this.imageSource.getUri());
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
                Log.e(HugePhotoDraweeView.TAG, "Failed to initialise bitmap decoder", e);
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
                if (this.decoder != null && iArr != null && iArr.length == 3) {
                    hugePhotoDraweeView.onTilesInited(this.decoder, iArr[0], iArr[1], iArr[2]);
                } else if (this.exception != null && hugePhotoDraweeView.onImageEventListener != null) {
                    hugePhotoDraweeView.onImageEventListener.onImageLoadError(this.exception);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTilesInited(ImageRegionDecoder imageRegionDecoder, int i, int i2, int i3) {
        if (this.sWidth > 0 && this.sHeight > 0 && (this.sWidth != i || this.sHeight != i2)) {
            reset(false);
            if (this.bitmap != null) {
                if (!this.bitmapIsCached) {
                    this.bitmap.recycle();
                }
                this.bitmap = null;
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            }
        }
        this.decoder = imageRegionDecoder;
        this.sWidth = i;
        this.sHeight = i2;
        this.sOrientation = i3;
        checkReady();
        checkImageLoaded();
        invalidate();
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class TileLoadTask extends AsyncTask<Void, Void, Bitmap> {
        private final WeakReference<ImageRegionDecoder> decoderRef;
        private Exception exception;
        private final WeakReference<Tile> tileRef;
        private final WeakReference<HugePhotoDraweeView> viewRef;

        public TileLoadTask(HugePhotoDraweeView hugePhotoDraweeView, ImageRegionDecoder imageRegionDecoder, Tile tile) {
            this.viewRef = new WeakReference<>(hugePhotoDraweeView);
            this.decoderRef = new WeakReference<>(imageRegionDecoder);
            this.tileRef = new WeakReference<>(tile);
            tile.loading = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            HugePhotoDraweeView hugePhotoDraweeView;
            ImageRegionDecoder imageRegionDecoder;
            Tile tile;
            Bitmap decodeRegion;
            try {
                hugePhotoDraweeView = this.viewRef.get();
                imageRegionDecoder = this.decoderRef.get();
                tile = this.tileRef.get();
            } catch (Exception e) {
                Log.e(HugePhotoDraweeView.TAG, "Failed to decode tile", e);
                this.exception = e;
            } catch (OutOfMemoryError e2) {
                Log.e(HugePhotoDraweeView.TAG, "Failed to decode tile - OutOfMemoryError", e2);
                this.exception = new RuntimeException(e2);
            }
            if (imageRegionDecoder != null && tile != null && hugePhotoDraweeView != null && imageRegionDecoder.isReady() && tile.visible) {
                synchronized (hugePhotoDraweeView.decoderLock) {
                    hugePhotoDraweeView.fileSRect(tile.sRect, tile.fileSRect);
                    if (hugePhotoDraweeView.sRegion != null) {
                        tile.fileSRect.offset(hugePhotoDraweeView.sRegion.left, hugePhotoDraweeView.sRegion.top);
                    }
                    decodeRegion = imageRegionDecoder.decodeRegion(tile.fileSRect, tile.sampleSize);
                }
                return decodeRegion;
            }
            if (tile != null) {
                tile.loading = false;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            HugePhotoDraweeView hugePhotoDraweeView = this.viewRef.get();
            Tile tile = this.tileRef.get();
            if (hugePhotoDraweeView != null && tile != null) {
                if (bitmap == null) {
                    if (this.exception != null && hugePhotoDraweeView.onImageEventListener != null) {
                        hugePhotoDraweeView.onImageEventListener.onTileLoadError(this.exception);
                        return;
                    }
                    return;
                }
                tile.bitmap = bitmap;
                tile.loading = false;
                hugePhotoDraweeView.onTileLoaded();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTileLoaded() {
        checkReady();
        checkImageLoaded();
        if (isBaseLayerReady() && this.bitmap != null) {
            if (!this.bitmapIsCached) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            this.bitmapIsPreview = false;
            this.bitmapIsCached = false;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class BitmapLoadTask extends AsyncTask<Void, Void, Integer> {
        private Bitmap bitmap;
        private final WeakReference<Context> contextRef;
        private final WeakReference<DecoderFactory<? extends ImageDecoder>> decoderFactoryRef;
        private Exception exception;
        private final boolean preview;
        private final Uri source;
        private final WeakReference<HugePhotoDraweeView> viewRef;

        public BitmapLoadTask(HugePhotoDraweeView hugePhotoDraweeView, Context context, DecoderFactory<? extends ImageDecoder> decoderFactory, Uri uri, boolean z) {
            this.viewRef = new WeakReference<>(hugePhotoDraweeView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
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
                DecoderFactory<? extends ImageDecoder> decoderFactory = this.decoderFactoryRef.get();
                HugePhotoDraweeView hugePhotoDraweeView = this.viewRef.get();
                if (context != null && decoderFactory != null && hugePhotoDraweeView != null) {
                    this.bitmap = decoderFactory.make().decode(context, this.source);
                    return Integer.valueOf(hugePhotoDraweeView.getExifOrientation(uri));
                }
            } catch (Exception e) {
                Log.e(HugePhotoDraweeView.TAG, "Failed to load bitmap", e);
                this.exception = e;
            } catch (OutOfMemoryError e2) {
                Log.e(HugePhotoDraweeView.TAG, "Failed to load bitmap - OutOfMemoryError", e2);
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
                        hugePhotoDraweeView.onImageLoaded(this.bitmap, num.intValue(), false);
                    }
                } else if (this.exception != null && hugePhotoDraweeView.onImageEventListener != null) {
                    if (this.preview) {
                        hugePhotoDraweeView.onImageEventListener.onPreviewLoadError(this.exception);
                    } else {
                        hugePhotoDraweeView.onImageEventListener.onImageLoadError(this.exception);
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
            this.bitmapIsPreview = true;
            if (checkReady()) {
                invalidate();
                requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onImageLoaded(Bitmap bitmap, int i, boolean z) {
        if (this.sWidth > 0 && this.sHeight > 0 && (this.sWidth != bitmap.getWidth() || this.sHeight != bitmap.getHeight())) {
            reset(false);
        }
        if (this.bitmap != null && !this.bitmapIsCached) {
            this.bitmap.recycle();
        }
        this.bitmapIsPreview = false;
        this.bitmapIsCached = z;
        this.bitmap = bitmap;
        this.sWidth = bitmap.getWidth();
        this.sHeight = bitmap.getHeight();
        this.sOrientation = i;
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
        int i;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.startsWith("content")) {
            try {
                cursor = getContext().getContentResolver().query(Uri.parse(str), new String[]{"orientation"}, null, null, null);
                if (cursor != null) {
                    try {
                        try {
                            try {
                                if (cursor.moveToFirst()) {
                                    i = cursor.getInt(0);
                                    if (!VALID_ORIENTATIONS.contains(Integer.valueOf(i)) || i == -1) {
                                        Log.w(TAG, "Unsupported orientation: " + i);
                                    }
                                    Closeables.closeSafely(cursor);
                                }
                                Closeables.closeSafely(cursor);
                            } catch (Exception e) {
                                Log.w(TAG, "Could not get orientation of image from media store");
                                Closeables.closeSafely(cursor);
                                return i;
                            }
                            i = 0;
                        } catch (Exception e2) {
                            i = 0;
                        }
                    } catch (Throwable th) {
                        th = th;
                        Closeables.closeSafely(cursor);
                        throw th;
                    }
                } else {
                    i = 0;
                }
                Closeables.closeSafely(cursor);
            } catch (Exception e3) {
                cursor = null;
                i = 0;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                Closeables.closeSafely(cursor);
                throw th;
            }
            return i;
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
                Log.w(TAG, "Unsupported EXIF orientation: " + attributeInt);
                return 0;
            } catch (Exception e4) {
                Log.w(TAG, "Could not get EXIF orientation of image");
                return 0;
            }
        }
    }

    private void execute(AsyncTask<Void, Void, ?> asyncTask) {
        if (this.parallelLoadingEnabled && Build.VERSION.SDK_INT >= 11) {
            try {
                AsyncTask.class.getMethod("executeOnExecutor", Executor.class, Object[].class).invoke(asyncTask, (Executor) AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get(null), null);
                return;
            } catch (Exception e) {
                Log.i(TAG, "Failed to execute AsyncTask on thread pool executor, falling back to single threaded executor", e);
            }
        }
        asyncTask.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class Tile {
        private Bitmap bitmap;
        private Rect fileSRect;
        private boolean loading;
        private Rect sRect;
        private int sampleSize;
        private Rect vRect;
        private boolean visible;

        private Tile() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class Anim {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private PointF sCenterEnd;
        private PointF sCenterEndRequested;
        private PointF sCenterStart;
        private float scaleEnd;
        private float scaleStart;
        private long time;
        private PointF vFocusEnd;
        private PointF vFocusStart;

        private Anim() {
            this.duration = 500L;
            this.interruptible = true;
            this.easing = 2;
            this.time = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class ScaleAndTranslate {
        private float scale;
        private PointF vTranslate;

        private ScaleAndTranslate(float f, PointF pointF) {
            this.scale = f;
            this.vTranslate = pointF;
        }
    }

    private void restoreState(ImageViewState imageViewState) {
        if (imageViewState != null && imageViewState.getCenter() != null && VALID_ORIENTATIONS.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            this.orientation = imageViewState.getOrientation();
            this.pendingScale = Float.valueOf(imageViewState.getScale());
            this.sPendingCenter = imageViewState.getCenter();
            invalidate();
        }
    }

    public void setMaxTileSize(int i) {
        this.maxTileWidth = i;
        this.maxTileHeight = i;
    }

    public void setMaxTileSize(int i, int i2) {
        this.maxTileWidth = i;
        this.maxTileHeight = i2;
    }

    private Point getMaxBitmapDimensions(Canvas canvas) {
        int i;
        int i2;
        int intValue;
        int i3 = 2048;
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                intValue = ((Integer) Canvas.class.getMethod("getMaximumBitmapWidth", new Class[0]).invoke(canvas, new Object[0])).intValue();
            } catch (Exception e) {
                i = 2048;
            }
            try {
                i2 = ((Integer) Canvas.class.getMethod("getMaximumBitmapHeight", new Class[0]).invoke(canvas, new Object[0])).intValue();
                i3 = intValue;
            } catch (Exception e2) {
                i = intValue;
                i3 = i;
                i2 = 2048;
                return new Point(Math.min(i3, this.maxTileWidth), Math.min(i2, this.maxTileHeight));
            }
        } else {
            i2 = 2048;
        }
        return new Point(Math.min(i3, this.maxTileWidth), Math.min(i2, this.maxTileHeight));
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

    private float distance(float f, float f2, float f3, float f4) {
        float f5 = f - f2;
        float f6 = f3 - f4;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }

    public void recycle() {
        reset(true);
        this.bitmapPaint = null;
        this.debugPaint = null;
        this.tileBgPaint = null;
    }

    private float viewToSourceX(float f) {
        if (this.vTranslate == null) {
            return Float.NaN;
        }
        return (f - this.vTranslate.x) / this.scale;
    }

    private float viewToSourceY(float f) {
        if (this.vTranslate == null) {
            return Float.NaN;
        }
        return (f - this.vTranslate.y) / this.scale;
    }

    public final PointF viewToSourceCoord(PointF pointF) {
        return viewToSourceCoord(pointF.x, pointF.y, new PointF());
    }

    public final PointF viewToSourceCoord(float f, float f2) {
        return viewToSourceCoord(f, f2, new PointF());
    }

    public final PointF viewToSourceCoord(PointF pointF, PointF pointF2) {
        return viewToSourceCoord(pointF.x, pointF.y, pointF2);
    }

    public final PointF viewToSourceCoord(float f, float f2, PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(viewToSourceX(f), viewToSourceY(f2));
        return pointF;
    }

    private float sourceToViewX(float f) {
        if (this.vTranslate == null) {
            return Float.NaN;
        }
        return (this.scale * f) + this.vTranslate.x;
    }

    private float sourceToViewY(float f) {
        if (this.vTranslate == null) {
            return Float.NaN;
        }
        return (this.scale * f) + this.vTranslate.y;
    }

    public final PointF sourceToViewCoord(PointF pointF) {
        return sourceToViewCoord(pointF.x, pointF.y, new PointF());
    }

    public final PointF sourceToViewCoord(float f, float f2) {
        return sourceToViewCoord(f, f2, new PointF());
    }

    public final PointF sourceToViewCoord(PointF pointF, PointF pointF2) {
        return sourceToViewCoord(pointF.x, pointF.y, pointF2);
    }

    public final PointF sourceToViewCoord(float f, float f2, PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(sourceToViewX(f), sourceToViewY(f2));
        return pointF;
    }

    private Rect sourceToViewRect(Rect rect, Rect rect2) {
        rect2.set((int) sourceToViewX(rect.left), (int) sourceToViewY(rect.top), (int) sourceToViewX(rect.right), (int) sourceToViewY(rect.bottom));
        return rect2;
    }

    private PointF vTranslateForSCenter(float f, float f2, float f3) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        this.satTemp.scale = f3;
        this.satTemp.vTranslate.set(paddingLeft - (f * f3), paddingTop - (f2 * f3));
        fitToBounds(true, this.satTemp);
        return this.satTemp.vTranslate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointF limitedSCenter(float f, float f2, float f3, PointF pointF) {
        PointF vTranslateForSCenter = vTranslateForSCenter(f, f2, f3);
        pointF.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - vTranslateForSCenter.x) / f3, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - vTranslateForSCenter.y) / f3);
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
    public float limitedScale(float f) {
        if (f > 0.0f && f < minScale()) {
            Log.i(TAG, "targetScale is " + f + "< minScale is " + minScale());
        } else {
            f = Math.max(minScale(), f);
        }
        return Math.min(this.maxScale, f);
    }

    private float ease(int i, long j, float f, float f2, long j2) {
        switch (i) {
            case 1:
                return easeOutQuad(j, f, f2, j2);
            case 2:
                return easeInOutQuad(j, f, f2, j2);
            default:
                throw new IllegalStateException("Unexpected easing type: " + i);
        }
    }

    private float easeOutQuad(long j, float f, float f2, long j2) {
        float f3 = ((float) j) / ((float) j2);
        return ((f3 - 2.0f) * (-f2) * f3) + f;
    }

    private float easeInOutQuad(long j, float f, float f2, long j2) {
        float f3 = ((float) j) / (((float) j2) / 2.0f);
        if (f3 < 1.0f) {
            return (f3 * (f2 / 2.0f) * f3) + f;
        }
        float f4 = f3 - 1.0f;
        return (((f4 * (f4 - 2.0f)) - 1.0f) * ((-f2) / 2.0f)) + f;
    }

    public final void setRegionDecoderClass(Class<? extends ImageRegionDecoder> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.regionDecoderFactory = new CompatDecoderFactory(cls);
    }

    public final void setRegionDecoderFactory(DecoderFactory<? extends ImageRegionDecoder> decoderFactory) {
        if (decoderFactory == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.regionDecoderFactory = decoderFactory;
    }

    public final void setBitmapDecoderClass(Class<? extends ImageDecoder> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.bitmapDecoderFactory = new CompatDecoderFactory(cls);
    }

    public final void setBitmapDecoderFactory(DecoderFactory<? extends ImageDecoder> decoderFactory) {
        if (decoderFactory == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.bitmapDecoderFactory = decoderFactory;
    }

    public final void setPanLimit(int i) {
        if (!VALID_PAN_LIMITS.contains(Integer.valueOf(i))) {
            throw new IllegalArgumentException("Invalid pan limit: " + i);
        }
        this.panLimit = i;
        if (isReady()) {
            fitToBounds(true);
            invalidate();
        }
    }

    public final void setMinimumScaleType(int i) {
        if (!VALID_SCALE_TYPES.contains(Integer.valueOf(i))) {
            throw new IllegalArgumentException("Invalid scale type: " + i);
        }
        this.minimumScaleType = i;
        if (isReady()) {
            fitToBounds(true);
            invalidate();
        }
    }

    public final void setMaxScale(float f) {
        this.maxScale = f;
    }

    public final void setMinScale(float f) {
        this.minScale = f;
    }

    public final void setMinimumDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale((((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f) * 2.0f) / i);
    }

    public final void setMaximumDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f) / i);
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public final float getMinScale() {
        return minScale();
    }

    public void setMinimumTileDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.minimumTileDpi = (int) Math.min((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f, i);
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

    public final void setScaleAndCenter(float f, PointF pointF) {
        this.anim = null;
        this.pendingScale = Float.valueOf(f);
        this.sPendingCenter = pointF;
        this.sRequestedCenter = pointF;
        invalidate();
    }

    public final void resetMinScaleIfNeeded() {
        if (this.scale < minScale()) {
            resetScaleAndCenter();
        }
    }

    public final void resetScaleAndCenter() {
        this.anim = null;
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

    public final boolean isImageLoaded() {
        return this.imageLoadedSent;
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

    public final boolean isZoomEnabled() {
        return this.zoomEnabled;
    }

    public final void setZoomEnabled(boolean z) {
        this.zoomEnabled = z;
    }

    public final boolean isQuickScaleEnabled() {
        return this.quickScaleEnabled;
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.quickScaleEnabled = z;
    }

    public final boolean isPanEnabled() {
        return this.panEnabled;
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

    public final void setTileBackgroundColor(int i) {
        if (Color.alpha(i) == 0) {
            this.tileBgPaint = null;
        } else {
            this.tileBgPaint = new Paint();
            this.tileBgPaint.setStyle(Paint.Style.FILL);
            this.tileBgPaint.setColor(i);
        }
        invalidate();
    }

    public final void setDoubleTapZoomScale(float f) {
        this.doubleTapZoomScale = f;
    }

    public final void setDoubleTapZoomDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale((((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f) * 2.0f) / i);
    }

    public final void setDoubleTapZoomStyle(int i) {
        if (!VALID_ZOOM_STYLES.contains(Integer.valueOf(i))) {
            throw new IllegalArgumentException("Invalid zoom style: " + i);
        }
        this.doubleTapZoomStyle = i;
    }

    public final void setDoubleTapZoomDuration(int i) {
        this.doubleTapZoomDuration = Math.max(0, i);
    }

    public void setParallelLoadingEnabled(boolean z) {
        this.parallelLoadingEnabled = z;
    }

    public final void setDebug(boolean z) {
        this.debug = z;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setOnImageEventListener(OnImageEventListener onImageEventListener) {
        this.onImageEventListener = onImageEventListener;
    }

    public AnimationBuilder animateCenter(PointF pointF) {
        if (isReady()) {
            return new AnimationBuilder(pointF);
        }
        return null;
    }

    public AnimationBuilder animateScale(float f) {
        if (isReady()) {
            return new AnimationBuilder(f);
        }
        return null;
    }

    public AnimationBuilder animateScaleAndCenter(float f, PointF pointF) {
        if (isReady()) {
            return new AnimationBuilder(f, pointF);
        }
        return null;
    }

    /* loaded from: classes12.dex */
    public final class AnimationBuilder {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private boolean panLimited;
        private final PointF targetSCenter;
        private final float targetScale;
        private final PointF vFocus;

        private AnimationBuilder(PointF pointF) {
            this.duration = 500L;
            this.easing = 2;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = HugePhotoDraweeView.this.scale;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f) {
            this.duration = 500L;
            this.easing = 2;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = HugePhotoDraweeView.this.getCenter();
            this.vFocus = null;
        }

        private AnimationBuilder(float f, PointF pointF) {
            this.duration = 500L;
            this.easing = 2;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f, PointF pointF, PointF pointF2) {
            this.duration = 500L;
            this.easing = 2;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = pointF;
            this.vFocus = pointF2;
        }

        public AnimationBuilder withDuration(long j) {
            this.duration = j;
            return this;
        }

        public AnimationBuilder withInterruptible(boolean z) {
            this.interruptible = z;
            return this;
        }

        public AnimationBuilder withEasing(int i) {
            if (!HugePhotoDraweeView.VALID_EASING_STYLES.contains(Integer.valueOf(i))) {
                throw new IllegalArgumentException("Unknown easing type: " + i);
            }
            this.easing = i;
            return this;
        }

        public AnimationBuilder withOnAnimationEventListener(OnAnimationEventListener onAnimationEventListener) {
            this.listener = onAnimationEventListener;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AnimationBuilder withPanLimited(boolean z) {
            this.panLimited = z;
            return this;
        }

        public void start() {
            PointF pointF;
            if (HugePhotoDraweeView.this.anim != null && HugePhotoDraweeView.this.anim.listener != null) {
                try {
                    HugePhotoDraweeView.this.anim.listener.onInterruptedByNewAnim();
                } catch (Exception e) {
                    Log.w(HugePhotoDraweeView.TAG, "Error thrown by animation listener", e);
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
            HugePhotoDraweeView.this.anim = new Anim();
            HugePhotoDraweeView.this.anim.scaleStart = HugePhotoDraweeView.this.scale;
            HugePhotoDraweeView.this.anim.scaleEnd = limitedScale;
            HugePhotoDraweeView.this.anim.time = System.currentTimeMillis();
            HugePhotoDraweeView.this.anim.sCenterEndRequested = pointF;
            HugePhotoDraweeView.this.anim.sCenterStart = HugePhotoDraweeView.this.getCenter();
            HugePhotoDraweeView.this.anim.sCenterEnd = pointF;
            HugePhotoDraweeView.this.anim.vFocusStart = HugePhotoDraweeView.this.sourceToViewCoord(pointF);
            HugePhotoDraweeView.this.anim.vFocusEnd = new PointF(width, height);
            HugePhotoDraweeView.this.anim.duration = this.duration;
            HugePhotoDraweeView.this.anim.interruptible = this.interruptible;
            HugePhotoDraweeView.this.anim.easing = this.easing;
            HugePhotoDraweeView.this.anim.time = System.currentTimeMillis();
            HugePhotoDraweeView.this.anim.listener = this.listener;
            if (this.vFocus != null) {
                float f = this.vFocus.x - (HugePhotoDraweeView.this.anim.sCenterStart.x * limitedScale);
                float f2 = this.vFocus.y - (HugePhotoDraweeView.this.anim.sCenterStart.y * limitedScale);
                ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(limitedScale, new PointF(f, f2));
                HugePhotoDraweeView.this.fitToBounds(true, scaleAndTranslate);
                HugePhotoDraweeView.this.anim.vFocusEnd = new PointF((scaleAndTranslate.vTranslate.x - f) + this.vFocus.x, (scaleAndTranslate.vTranslate.y - f2) + this.vFocus.y);
            }
            HugePhotoDraweeView.this.invalidate();
        }
    }

    /* loaded from: classes12.dex */
    public static class DefaultOnAnimationEventListener implements OnAnimationEventListener {
        @Override // com.baidu.searchbox.picture.component.HugePhotoDraweeView.OnAnimationEventListener
        public void onComplete() {
        }

        @Override // com.baidu.searchbox.picture.component.HugePhotoDraweeView.OnAnimationEventListener
        public void onInterruptedByUser() {
        }

        @Override // com.baidu.searchbox.picture.component.HugePhotoDraweeView.OnAnimationEventListener
        public void onInterruptedByNewAnim() {
        }
    }

    /* loaded from: classes12.dex */
    public static class DefaultOnImageEventListener implements OnImageEventListener {
        @Override // com.baidu.searchbox.picture.component.HugePhotoDraweeView.OnImageEventListener
        public void onReady() {
        }

        @Override // com.baidu.searchbox.picture.component.HugePhotoDraweeView.OnImageEventListener
        public void onImageLoaded() {
        }

        @Override // com.baidu.searchbox.picture.component.HugePhotoDraweeView.OnImageEventListener
        public void onPreviewLoadError(Exception exc) {
        }

        @Override // com.baidu.searchbox.picture.component.HugePhotoDraweeView.OnImageEventListener
        public void onImageLoadError(Exception exc) {
        }

        @Override // com.baidu.searchbox.picture.component.HugePhotoDraweeView.OnImageEventListener
        public void onTileLoadError(Exception exc) {
        }
    }
}
