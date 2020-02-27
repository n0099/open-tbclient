package com.baidu.live.tbadk.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.BlockingLinkedDeque;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.BitmapHelper;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.coreextra.view.ImageUrlData;
import com.baidu.live.tbadk.widget.largeimage.logic.ILoadBlockBitmapCallback;
import com.baidu.live.tbadk.widget.largeimage.logic.LargeImageDelegate;
import com.baidu.live.u.a;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class DragImageView extends ImageView {
    public static final int DEFAULT_MODE = 0;
    static final int DRAG = 1;
    static final int EXIT = 4;
    public static final int GIF_DYNAMIC = 1;
    public static final int GIF_STATIC = 0;
    public static final int HEAD_MODE = 1;
    public static final int IMAGE_TYPE_DEFAULT = 2;
    public static final int IMAGE_TYPE_DYNAMIC = 1;
    public static final int IMAGE_TYPE_STATIC = 0;
    private static final int MAX_IMAGE_SIZE = 1300;
    private static final int MSG_DECODED_NOTIFY = 1;
    private static final int MSG_INVALIDATE = 2;
    private static final int MSG_REFRESH = 0;
    static final int NORMAL = 0;
    static final int UP = 3;
    static final int ZOOM = 2;
    private static final float ZOOM_IN_MULTIPLE = 1.25f;
    private volatile int decodeIndex;
    private int frameNum;
    private int height;
    private boolean isHeadImage;
    private boolean isInDragScaleMode;
    private DecelerateAnimation mAnimation;
    private int mBackgroundColorId;
    private int mBottom;
    private int mBottomOffset;
    private BlockingLinkedDeque<Frame> mBuffer;
    private View.OnClickListener mClick;
    private Frame mCurrentFrame;
    private float mCurrentScale;
    private Interpolator mDecelerateInterpolater;
    private float mDensity;
    private Rect mDisplayRect;
    private Matrix mDragMatrix;
    private IDragToExitListener mDragToExitListener;
    private RectF mDstRect;
    private GestureDetector mGestureDetector;
    private Bitmap mGifCache;
    private int mGifMaxUseableMem;
    private int mGifType;
    public Handler mHandler;
    private boolean mHaveMove;
    private boolean mHaveZoom;
    private byte[] mImageData;
    private int mImageMode;
    private Rect mImageRect;
    private OnImageScrollListener mImageScrollListener;
    public int mImageType;
    private ImageUrlData mImageUrlData;
    private float mInitScale;
    private boolean mIsTouched;
    private LargeImageDelegate mLargeImageDelegate;
    private volatile long mLastPlayTime;
    private int mLeftOffset;
    private volatile boolean mListIsEmpty;
    private OnSizeChangedListener mListener;
    private boolean mLoadBigImage;
    private Matrix mMatrix;
    private float mMaxScale;
    private int mMaxZoomInSize;
    private int mMode;
    private float mMoveDistance;
    private float mOldDist;
    private float mOldScale;
    private OnGifSetListener mOnGifSetListener;
    private View.OnLongClickListener mOnLongClickListener;
    private Paint mPaint;
    private BlockingLinkedDeque<Frame> mPool;
    private float mRatio;
    private float mResizedHeight;
    private float mResizedWidth;
    private ArrayList<Float> mScale;
    private int mTop;
    private int mTopOffset;
    private int mViewHeight;
    private int mViewWidth;
    private int width;
    private static final String TAG = DragImageView.class.getSimpleName();
    private static final int EXIT_DISTANCE = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;

    /* loaded from: classes3.dex */
    public static class Frame {
        public Bitmap bm;
        public int delay;
    }

    /* loaded from: classes3.dex */
    public interface IDragToExitListener {
        void onDragEnd();

        void onDragStart();
    }

    /* loaded from: classes3.dex */
    public interface OnGifSetListener {
        void gifSet(DragImageView dragImageView);
    }

    /* loaded from: classes3.dex */
    public interface OnImageScrollListener {
        void imageScroll(DragImageView dragImageView, int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface OnSizeChangedListener {
        void sizeChenged(DragImageView dragImageView, boolean z, boolean z2);
    }

    public void setIsHeadImage(boolean z) {
        this.isHeadImage = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.mImageUrlData = imageUrlData;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mIsTouched = false;
        this.mImageData = null;
        this.mGifMaxUseableMem = 0;
        this.mMaxZoomInSize = MAX_IMAGE_SIZE;
        this.mImageMode = 0;
        this.mListener = null;
        this.mClick = null;
        this.mOnLongClickListener = null;
        this.mOnGifSetListener = null;
        this.mOldDist = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.mHaveMove = false;
        this.mHaveZoom = false;
        this.mGifType = 0;
        this.mGifCache = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.mTopOffset = 0;
        this.mBottomOffset = 0;
        this.mLeftOffset = 0;
        this.mBackgroundColorId = 0;
        this.mDecelerateInterpolater = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.mDragMatrix = new Matrix();
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDstRect = new RectF();
        this.width = 0;
        this.height = 0;
        this.frameNum = 0;
        this.mCurrentFrame = null;
        this.mBuffer = new BlockingLinkedDeque<>(5);
        this.mPool = new BlockingLinkedDeque<>(6);
        this.decodeIndex = 0;
        this.mLastPlayTime = 0L;
        this.mListIsEmpty = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.refreshImage();
                        break;
                    case 1:
                        if (DragImageView.this.mListIsEmpty) {
                            DragImageView.this.refreshImage();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.mLastPlayTime = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public DragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mIsTouched = false;
        this.mImageData = null;
        this.mGifMaxUseableMem = 0;
        this.mMaxZoomInSize = MAX_IMAGE_SIZE;
        this.mImageMode = 0;
        this.mListener = null;
        this.mClick = null;
        this.mOnLongClickListener = null;
        this.mOnGifSetListener = null;
        this.mOldDist = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.mHaveMove = false;
        this.mHaveZoom = false;
        this.mGifType = 0;
        this.mGifCache = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.mTopOffset = 0;
        this.mBottomOffset = 0;
        this.mLeftOffset = 0;
        this.mBackgroundColorId = 0;
        this.mDecelerateInterpolater = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.mDragMatrix = new Matrix();
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDstRect = new RectF();
        this.width = 0;
        this.height = 0;
        this.frameNum = 0;
        this.mCurrentFrame = null;
        this.mBuffer = new BlockingLinkedDeque<>(5);
        this.mPool = new BlockingLinkedDeque<>(6);
        this.decodeIndex = 0;
        this.mLastPlayTime = 0L;
        this.mListIsEmpty = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.refreshImage();
                        break;
                    case 1:
                        if (DragImageView.this.mListIsEmpty) {
                            DragImageView.this.refreshImage();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.mLastPlayTime = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public DragImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mIsTouched = false;
        this.mImageData = null;
        this.mGifMaxUseableMem = 0;
        this.mMaxZoomInSize = MAX_IMAGE_SIZE;
        this.mImageMode = 0;
        this.mListener = null;
        this.mClick = null;
        this.mOnLongClickListener = null;
        this.mOnGifSetListener = null;
        this.mOldDist = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.mHaveMove = false;
        this.mHaveZoom = false;
        this.mGifType = 0;
        this.mGifCache = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.mTopOffset = 0;
        this.mBottomOffset = 0;
        this.mLeftOffset = 0;
        this.mBackgroundColorId = 0;
        this.mDecelerateInterpolater = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.mDragMatrix = new Matrix();
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDstRect = new RectF();
        this.width = 0;
        this.height = 0;
        this.frameNum = 0;
        this.mCurrentFrame = null;
        this.mBuffer = new BlockingLinkedDeque<>(5);
        this.mPool = new BlockingLinkedDeque<>(6);
        this.decodeIndex = 0;
        this.mLastPlayTime = 0L;
        this.mListIsEmpty = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.refreshImage();
                        break;
                    case 1:
                        if (DragImageView.this.mListIsEmpty) {
                            DragImageView.this.refreshImage();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.mLastPlayTime = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(IDragToExitListener iDragToExitListener) {
        this.mDragToExitListener = iDragToExitListener;
    }

    public int getImageType() {
        return this.mImageType;
    }

    public void setImageMode(int i) {
        this.mImageMode = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public boolean isViewTop() {
        if (this.mLargeImageDelegate == null) {
            return false;
        }
        return this.mLargeImageDelegate.isViewTop();
    }

    public boolean isAtViewTop() {
        if (this.mLargeImageDelegate != null) {
            return this.mLargeImageDelegate.isAtViewTop();
        }
        return false;
    }

    public void actionUp() {
        this.mHaveZoom = false;
        this.mIsTouched = false;
        this.mMode = 3;
        adjustPos();
        if (this.mCurrentScale < this.mInitScale) {
            this.mCurrentScale = this.mInitScale;
            resizeBitmap();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mLargeImageDelegate != null && this.mLargeImageDelegate.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.mIsTouched = true;
                this.mHaveMove = false;
                this.mHaveZoom = false;
                break;
            case 1:
                actionUp();
                break;
            case 2:
                if (this.mMode == 0) {
                    this.mMode = 1;
                    break;
                }
                break;
        }
        if (action == CompatibleUtile.getInstance().getActionPointerUp()) {
            this.mMode = 1;
        } else if (action == CompatibleUtile.getInstance().getActionPointerDown()) {
            this.mOldDist = spacing(motionEvent);
            if (this.mOldDist > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.mHaveMove = true;
                        this.mHaveZoom = true;
                        if (this.mImageType != 1 && this.mImageType != 2) {
                            float spacing = spacing(motionEvent);
                            if (spacing >= 0.0f && Math.abs(this.mOldDist - spacing) >= 10.0f) {
                                if (Math.abs(this.mOldDist - spacing) > 100.0f) {
                                    this.mOldDist = spacing;
                                    break;
                                } else {
                                    float f = spacing / this.mOldDist;
                                    this.mOldDist = spacing;
                                    this.mOldScale = this.mCurrentScale;
                                    this.mCurrentScale *= f;
                                    if (this.mCurrentScale > this.mMaxScale) {
                                        this.mCurrentScale = this.mMaxScale;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    resizeBitmap();
                                    break;
                                }
                            }
                        }
                    }
                    break;
            }
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected float getMinScaleValue() {
        return this.mLargeImageDelegate != null ? this.mLargeImageDelegate.getMinScaleValue() : this.mInitScale / 4.0f;
    }

    public float spacing(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            reInitBitmap();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean pagerCantScroll() {
        if (this.mLargeImageDelegate != null) {
            return this.mLargeImageDelegate.isNormalScale();
        }
        return this.mInitScale == this.mCurrentScale;
    }

    protected float reInitScaleValue(Bitmap bitmap) {
        if (this.mLargeImageDelegate != null) {
            return this.mLargeImageDelegate.reInitScaleValue();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.mImageMode == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.isHeadImage) {
                if (this.mImageType == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.mImageType != 2) {
                float f = this.mDensity;
                float f2 = f >= 1.0f ? f : 1.0f;
                if (bitmap.getWidth() * f2 >= this.mViewWidth || bitmap.getHeight() * f2 >= this.mViewHeight) {
                    return Math.min(width, height);
                }
                return f2;
            } else {
                return 1.0f;
            }
        }
        return Math.max(this.mViewWidth / bitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / bitmap.getHeight());
    }

    protected float getMaxScaleValue(Bitmap bitmap) {
        if (this.mLargeImageDelegate != null) {
            return this.mLargeImageDelegate.getMaxScaleValue();
        }
        float f = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f = (float) Math.sqrt(this.mMaxZoomInSize / (bitmap.getWidth() * bitmap.getHeight()));
            if (f > 10.0f) {
                return 10.0f;
            }
        }
        return f;
    }

    private void reInitBitmap() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.mInitScale = reInitScaleValue(imageBitmap);
            this.mMaxScale = getMaxScaleValue(imageBitmap);
            this.mScale.clear();
            this.mScale.add(Float.valueOf(this.mInitScale));
            this.mCurrentScale = this.mInitScale;
            this.mOldScale = this.mCurrentScale;
            resizeBitmap();
            return;
        }
        this.mResizedWidth = 0.0f;
        this.mResizedHeight = 0.0f;
        this.mInitScale = 1.0f;
        this.mMaxScale = 1.0f;
        this.mCurrentScale = 1.0f;
        this.mOldScale = this.mCurrentScale;
        this.mScale.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void callChangeListener() {
        if (this.mListener != null) {
            this.mListener.sizeChenged(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(OnSizeChangedListener onSizeChangedListener) {
        this.mListener = onSizeChangedListener;
    }

    public void setOnImageScrollListener(OnImageScrollListener onImageScrollListener) {
        this.mImageScrollListener = onImageScrollListener;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.mLargeImageDelegate != null) {
            this.mLargeImageDelegate.startLoad();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.mImageData = bArr;
        if (this.mLargeImageDelegate != null) {
            this.mLargeImageDelegate.setImageDatas(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void createLargeImageDelegate() {
        if (this.mLargeImageDelegate == null) {
            this.mLargeImageDelegate = new LargeImageDelegate(this);
            this.mLargeImageDelegate.setOnClickListener(this.mClick);
            this.mLargeImageDelegate.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    public void setImageLoadCallBack(ILoadBlockBitmapCallback iLoadBlockBitmapCallback) {
        if (this.mLargeImageDelegate != null) {
            this.mLargeImageDelegate.setLoadThumbnailBitmapCallback(iLoadBlockBitmapCallback);
        }
    }

    public boolean hasLoadLongImage() {
        return (getImageBitmap() == null || this.mLargeImageDelegate == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.mGifCache;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.mLargeImageDelegate == null || !this.mLargeImageDelegate.onDraw(canvas, getImageBitmap())) {
            if (this.mImageType == 2 && this.mBackgroundColorId != 0 && !this.mAnimation.getIsAnimationInProgre()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f = 0.0f;
                float f2 = height * 0.3f;
                float f3 = width;
                float f4 = (1.0f - 0.3f) * height;
                if (this.isHeadImage && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f = (width / 2) - (i * 2.5f);
                    f2 = (height / 2) - (i2 * 2.5f);
                    f3 = (i * 2.5f) + (width / 2);
                    f4 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(SkinManager.getColor(this.mBackgroundColorId));
                canvas.drawRect(f, f2, f3, f4, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.isInDragScaleMode) {
                this.isInDragScaleMode = false;
                this.mDragMatrix.reset();
                if (this.mMoveDistance < EXIT_DISTANCE) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    startExitAnimation();
                }
            }
            if (this.mImageType == 0 && this.isInDragScaleMode && this.mDisplayRect != null && this.mImageUrlData != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.mDstRect == null) {
                    this.mDstRect = new RectF();
                }
                this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.mImageRect, this.mDstRect, (Paint) null);
                }
            } else if (this.mMode == 4 && this.mDisplayRect != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.mImageRect, this.mDstRect, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.mImageType == 1 && this.mGifCache != null && !this.mGifCache.isRecycled()) {
                int width2 = this.mGifCache.getWidth();
                int height2 = this.mGifCache.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f5 = this.mDensity;
                if (f5 < 1.0f) {
                    f5 = 1.0f;
                }
                if (width2 * f5 >= width3 || height2 * f5 >= height3) {
                    f5 = Math.min(width3 / width2, height3 / height2);
                }
                if (Math.abs(f5 - 1.0f) < 1.0E-8f) {
                    z = true;
                } else {
                    this.mMatrix.setScale(f5, f5);
                    i3 = (int) ((width3 - (width2 * f5)) / 2.0f);
                    i4 = (int) ((height3 - (height2 * f5)) / 2.0f);
                    this.mMatrix.postTranslate(i3, i4);
                    width2 = (int) (width2 * f5);
                    height2 = (int) (f5 * height2);
                    z = false;
                }
                canvas.clipRect(i3, i4, width2 + i3, height2 + i4);
                canvas.drawColor(-1);
                if (this.mGifType == 1 && this.mCurrentFrame != null && this.mCurrentFrame.bm != null) {
                    if (z) {
                        canvas.drawBitmap(this.mCurrentFrame.bm, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.mCurrentFrame.bm, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.mGifCache, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.mGifCache, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        if (this.mImageType != 1) {
        }
    }

    public void pause() {
        if (this.mImageType == 1) {
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.mImageType == 1) {
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mListIsEmpty = true;
            this.mCurrentFrame = null;
            this.mPool.clear();
            this.mBuffer.clear();
            this.width = 0;
            this.height = 0;
            this.decodeIndex = 0;
            this.frameNum = 0;
        }
    }

    private void initData() {
        this.mDensity = BdUtilHelper.getEquipmentDensity(getContext());
        this.mMaxZoomInSize = BdUtilHelper.getEquipmentHeight(getContext()) * BdUtilHelper.getEquipmentWidth(getContext()) * 2;
        if (this.mMaxZoomInSize < 1690000) {
            this.mMaxZoomInSize = 1690000;
        }
        this.mResizedWidth = 0.0f;
        this.mResizedHeight = 0.0f;
        this.mScale = new ArrayList<>();
        this.mInitScale = 1.0f;
        this.mMaxScale = 1.0f;
        this.mCurrentScale = 1.0f;
        this.mOldScale = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mAnimation = new DecelerateAnimation();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.live.tbadk.widget.DragImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (DragImageView.this.mImageType != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
                    DragImageView.this.mAnimation.prepareAnimation(f, f2);
                    DragImageView.this.startAnimation(DragImageView.this.mAnimation);
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.mImageType != 1 && DragImageView.this.mImageType != 2) {
                    DragImageView.this.mMode = 2;
                    if (DragImageView.this.mCurrentScale > DragImageView.this.mInitScale) {
                        DragImageView.this.mCurrentScale = DragImageView.this.mInitScale;
                        DragImageView.this.mOldScale = DragImageView.this.mCurrentScale;
                        DragImageView.this.resizeBitmap();
                        return true;
                    }
                    DragImageView.this.mCurrentScale = DragImageView.this.mInitScale * 2.0f;
                    DragImageView.this.resizeBitmap(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.mClick != null && !DragImageView.this.mHaveMove) {
                    DragImageView.this.mClick.onClick(DragImageView.this);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0102  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x0110  */
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                int i;
                int i2;
                DragImageView.this.mHaveMove = true;
                if (DragImageView.this.mImageMode == 0 && DragImageView.this.mHaveZoom) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (DragImageView.this.mResizedWidth >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f);
                    if (DragImageView.this.mImageMode == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.mResizedWidth) {
                            i = (int) (DragImageView.this.mResizedWidth - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.mResizedHeight + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f2);
                            if (DragImageView.this.mImageMode == 0) {
                                if (i2 < (-DragImageView.this.mTopOffset)) {
                                    i2 = -DragImageView.this.mTopOffset;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.mResizedHeight + DragImageView.this.mBottom + DragImageView.this.mBottomOffset) {
                                    i2 = (int) ((DragImageView.this.mResizedHeight - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.mBottomOffset);
                                }
                            }
                        } else {
                            i2 = scrollY;
                        }
                        if (i == DragImageView.this.getScrollX() || i2 != DragImageView.this.getScrollY()) {
                            DragImageView.this.scrollTo(i, i2);
                            DragImageView.this.invalidate();
                            if (DragImageView.this.mImageScrollListener != null) {
                                DragImageView.this.mImageScrollListener.imageScroll(DragImageView.this, i, i2);
                            }
                        }
                        return true;
                    }
                }
                i = scrollX;
                if (DragImageView.this.mResizedHeight + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                if (DragImageView.this.mImageScrollListener != null) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.mOnLongClickListener != null && !DragImageView.this.mHaveMove) {
                    DragImageView.this.mOnLongClickListener.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void onDrag(float f, float f2) {
        Bitmap imageBitmap;
        if (this.isInDragScaleMode && this.mDisplayRect != null && (imageBitmap = getImageBitmap()) != null) {
            this.mMoveDistance -= f2;
            int measuredHeight = getMeasuredHeight();
            if (this.mMoveDistance > measuredHeight) {
                this.mMoveDistance = measuredHeight;
            }
            float f3 = f2 / measuredHeight;
            this.mDragMatrix.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
            if (this.mRatio * (1.0f + f3) > 1.0f || this.mMoveDistance < 0.0f) {
                this.mDragMatrix.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * imageBitmap.getWidth()) / 2.0f, (imageBitmap.getHeight() / 2) * this.mRatio);
                this.mRatio = 1.0f;
            } else {
                this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * imageBitmap.getWidth()) / 2.0f, (imageBitmap.getHeight() / 2) * this.mRatio);
                this.mRatio *= f3 + 1.0f;
            }
            invalidate();
        }
    }

    private void startExitAnimation() {
        if (this.mImageUrlData == null) {
            if (this.mDragToExitListener != null) {
                this.mDragToExitListener.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.mImageUrlData.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.mDragToExitListener != null) {
                this.mDragToExitListener.onDragEnd();
                return;
            }
            return;
        }
        this.mDstRect.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.mDstRect.right - this.mDstRect.left)) + this.mDstRect.top;
        final float[] fArr = {(this.mDstRect.left + this.mDstRect.right) / 2.0f, (this.mDstRect.top + this.mDstRect.bottom) / 2.0f};
        final float[] fArr2 = {(sourceImageRectInScreen.left + sourceImageRectInScreen.right) / 2, (sourceImageRectInScreen.top + sourceImageRectInScreen.bottom) / 2};
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr[0], fArr2[0]);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.tbadk.widget.DragImageView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float animatedFraction = fArr[1] + ((fArr2[1] - fArr[1]) * valueAnimator.getAnimatedFraction());
                    DragImageView.this.mDstRect = DragImageView.this.getRectInScreenFromPosition(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
                    DragImageView.this.invalidate();
                }
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.tbadk.widget.DragImageView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                DragImageView.this.isInDragScaleMode = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.mDragToExitListener != null) {
                    DragImageView.this.mDragToExitListener.onDragEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    private void adjustPos() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.mResizedWidth >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.mResizedWidth) {
                scrollX = (int) (this.mResizedWidth - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.mResizedHeight + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.mTopOffset) ? -this.mTopOffset : scrollY;
            if (getHeight() + i > this.mResizedHeight + this.mBottom + this.mBottomOffset) {
                i = (int) ((this.mResizedHeight - getHeight()) + this.mBottom + this.mBottomOffset);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
            if (this.mImageScrollListener != null) {
                this.mImageScrollListener.imageScroll(this, scrollX, i);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mLargeImageDelegate != null) {
            this.mLargeImageDelegate.computeScroll();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.mResizedWidth;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.mResizedHeight;
    }

    public boolean onRightSide() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        return !this.mHaveZoom && getScrollX() >= ((int) (this.mResizedWidth - ((float) getWidth()))) + (-1);
    }

    public boolean onLeftSide() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        return !this.mHaveZoom && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.mAnimation.getIsAnimationInProgre()) {
            this.mAnimation.stopAnimation();
        }
        this.mBackgroundColorId = 0;
        super.setImageBitmap(bitmap);
        reInitBitmap();
        this.mImageType = 0;
        if (this.mDisplayRect == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
        }
        if (this.mImageRect == null) {
            this.mImageRect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    public void replaceImageBitmap(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                super.setImageMatrix(this.mMatrix);
                return;
            }
            if (this.mAnimation.getIsAnimationInProgre()) {
                this.mAnimation.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.mImageType = 0;
        }
    }

    public void setGifData(byte[] bArr, Bitmap bitmap) {
        if (this.mAnimation.getIsAnimationInProgre()) {
            this.mAnimation.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        reInitBitmap();
        this.mImageType = 1;
        this.mGifCache = bitmap;
        this.mImageData = bArr;
        if (this.mOnGifSetListener != null) {
            this.mOnGifSetListener.gifSet(this);
        }
    }

    public void onDestroy() {
        if (this.mAnimation.getIsAnimationInProgre()) {
            this.mAnimation.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.mGifCache = null;
        stop();
        if (this.mLargeImageDelegate != null) {
            this.mLargeImageDelegate.release();
            System.gc();
        }
    }

    public void release() {
        if (this.mAnimation.getIsAnimationInProgre()) {
            this.mAnimation.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.mGifCache = null;
    }

    public void setDefaultBitmap() {
        if (this.mAnimation.getIsAnimationInProgre()) {
            this.mAnimation.stopAnimation();
        }
        try {
            if (this.isHeadImage) {
                super.setImageBitmap(BitmapHelper.getCashBitmap(a.f.sdk_icon_default_avatar100));
            } else {
                super.setImageBitmap(BitmapHelper.getCashBitmap(a.f.sdk_ph_btn_see_default));
            }
        } catch (OutOfMemoryError e) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            System.gc();
            super.setImageBitmap(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
        this.mImageType = 2;
        reInitBitmap();
    }

    public void zoomInBitmap() {
        if (this.mImageType != 1 && this.mImageType != 2) {
            int size = this.mScale.size();
            if (size > 0) {
                this.mScale.add(Float.valueOf(this.mScale.get(size - 1).floatValue() * ZOOM_IN_MULTIPLE));
            } else {
                this.mScale.add(Float.valueOf(this.mInitScale));
            }
            resizeBitmap();
        }
    }

    public void zoomOutBitmap() {
        if (this.mImageType != 1 && this.mImageType != 2) {
            int size = this.mScale.size();
            if (size > 1) {
                this.mScale.remove(size - 1);
            }
            resizeBitmap();
        }
    }

    public void restoreSize() {
        callChangeListener();
        if (this.mImageType != 1 && this.mImageType != 2 && this.mCurrentScale != this.mInitScale) {
            this.mScale.clear();
            this.mScale.add(Float.valueOf(this.mInitScale));
            this.mCurrentScale = this.mInitScale;
            this.mOldScale = this.mCurrentScale;
            resizeBitmap();
        }
    }

    public boolean canZoomIn() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.mScale.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.mScale.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * ZOOM_IN_MULTIPLE) * ZOOM_IN_MULTIPLE <= ((float) this.mMaxZoomInSize) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.mScale.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resizeBitmap() {
        resizeBitmap(false, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resizeBitmap(boolean z, int i, int i2) {
        float f;
        float f2;
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled()) {
            try {
                if (this.mMode != 2) {
                    int size = this.mScale.size();
                    if (size > 0) {
                        f2 = this.mScale.get(size - 1).floatValue();
                    } else {
                        f2 = this.mInitScale;
                    }
                    this.mCurrentScale = f2;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.mResizedWidth = imageBitmap.getWidth() * this.mCurrentScale;
                this.mResizedHeight = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.mOldScale * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.mOldScale;
                this.mTopOffset = this.mTop;
                this.mBottomOffset = 0;
                float f3 = this.mResizedWidth < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.mResizedWidth) / 2.0f) : 0.0f;
                if (this.mResizedHeight < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.mResizedHeight) / 2.0f);
                    if (this.mImageMode == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.mTopOffset = (int) (this.mTop - f);
                    this.mBottomOffset = this.mTop - this.mTopOffset;
                } else {
                    f = 0.0f;
                }
                this.mLeftOffset = (int) f3;
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.mResizedWidth <= screenWidth) {
                        width2 = 0;
                    } else if (this.mResizedWidth > screenWidth && this.mResizedWidth / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.mResizedWidth / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.mResizedWidth - width) / 2.0f);
                    }
                    if (this.mResizedWidth <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.mResizedWidth) {
                        scrollX = (int) (this.mResizedWidth - getWidth());
                    }
                }
                if (scrollX > 0 && this.mResizedWidth - scrollX < getWidth()) {
                    scrollX = (int) (this.mResizedWidth - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.mResizedHeight - height) / 2.0f)) + scrollY : scrollY;
                if (this.mResizedHeight <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.mResizedHeight) {
                    i3 = (int) (this.mResizedHeight - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                callChangeListener();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class DecelerateAnimation extends Animation {
        static final long Decelerate = 2500;
        private int mStartX;
        private int mStartY;
        private long mTimeX;
        private long mTimeY;
        private long velocityX;
        private long velocityY;
        private boolean mIsAnimationInProgres = false;
        private boolean mStop = false;

        public DecelerateAnimation() {
        }

        public void prepareAnimation(float f, float f2) {
            if (f > 1500.0f) {
                f = 1500.0f;
            } else if (f < -1500.0f) {
                f = -1500.0f;
            }
            if (f2 > 1500.0f) {
                f2 = 1500.0f;
            } else if (f2 < -1500.0f) {
                f2 = -1500.0f;
            }
            this.velocityX = f;
            this.velocityY = f2;
            this.mTimeX = Math.abs((f * 1000.0f) / 2500.0f);
            this.mTimeY = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.mTimeX, this.mTimeY));
            setInterpolator(DragImageView.this.mDecelerateInterpolater);
            this.mStartX = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.mIsAnimationInProgres = true;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            long j;
            int i;
            int i2;
            int i3 = 0;
            if (f > 1.0f) {
                f = 1.0f;
            }
            if (this.mTimeX > this.mTimeY) {
                j = ((float) this.mTimeX) * f;
            } else {
                j = ((float) this.mTimeY) * f;
            }
            float f2 = ((float) (j > this.mTimeX ? this.mTimeX : j)) / 1000.0f;
            if (this.velocityX > 0) {
                i = this.mStartX - ((int) (f2 * (((float) this.velocityX) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.mStartX - ((int) (f2 * (((float) this.velocityX) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.mTimeY) {
                j = this.mTimeY;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.velocityY > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.velocityY) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.velocityY) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.mResizedHeight + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.mTopOffset)) {
                    i2 = -DragImageView.this.mTopOffset;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.mResizedHeight + DragImageView.this.mBottom + DragImageView.this.mBottomOffset) {
                    i2 = (int) ((DragImageView.this.mResizedHeight - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.mBottomOffset);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.mResizedWidth > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.mResizedWidth ? (int) (DragImageView.this.mResizedWidth - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.mStop) {
                if (DragImageView.this.mIsTouched) {
                    this.mIsAnimationInProgres = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.mIsAnimationInProgres = false;
                    return false;
                } catch (Exception e) {
                    this.mIsAnimationInProgres = false;
                    return false;
                }
            }
            this.mStop = false;
            this.mIsAnimationInProgres = false;
            return false;
        }

        public boolean getIsAnimationInProgre() {
            return this.mIsAnimationInProgres;
        }

        public void stopAnimation() {
            this.mStop = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        if (this.mLargeImageDelegate != null) {
            this.mLargeImageDelegate.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(OnGifSetListener onGifSetListener) {
        this.mOnGifSetListener = onGifSetListener;
    }

    public Bitmap getVisableBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        Matrix matrix = new Matrix(this.mMatrix);
        matrix.postTranslate(-scrollX, -scrollY);
        canvas.drawBitmap(getImageBitmap(), matrix, null);
        return createBitmap;
    }

    private int getScreenWidth() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshImage() {
        long j;
        Frame poll = this.mBuffer.poll();
        if (poll == null) {
            this.mListIsEmpty = true;
            return;
        }
        this.mListIsEmpty = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mCurrentFrame != null) {
            j = this.mCurrentFrame.delay - (currentTimeMillis - this.mLastPlayTime);
            this.mPool.offer(this.mCurrentFrame);
        } else {
            j = 0;
        }
        this.mCurrentFrame = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public Frame createFrame() {
        Frame poll = this.mPool.poll();
        if (poll == null) {
            poll = new Frame();
            try {
                poll.bm = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
        return poll;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        play();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onDestroy();
    }

    public Frame getCurrentFrame() {
        return this.mCurrentFrame;
    }

    public boolean isLoadBigImage() {
        return this.mLoadBigImage;
    }

    public void setLoadBigImage(boolean z) {
        this.mLoadBigImage = z;
    }

    public int getBottomOffset() {
        return this.mBottomOffset;
    }

    public int getLeftOffset() {
        return this.mLeftOffset;
    }
}
