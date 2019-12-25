package com.baidu.live.tbadk.widget.largeimage.logic;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.imagemanager.TbImageMemoryCache;
import com.baidu.live.tbadk.widget.largeimage.atomskeleton.BlockBitmap;
import com.baidu.live.tbadk.widget.largeimage.atomskeleton.Viewpoint;
import com.baidu.live.tbadk.widget.largeimage.tools.BitmapDecoderCreator;
import com.baidu.live.tbadk.widget.largeimage.tools.LoadBlockBitmapTaskManager;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.List;
/* loaded from: classes2.dex */
public class LargeImageDelegate implements ILoadBlockBitmapCallback {
    private static final int ANDROID_MAX_PIC_SIZE = 4096;
    public static final int DEFAULT_ANIMATION_TIME = 400;
    private static final float FLING_RATIO = 2.0f;
    private static final int LOAD_TYPE_BLOCK = 2;
    private static final int LOAD_TYPE_DEFALUE = 0;
    private static final int LOAD_TYPE_ORIGIN = 1;
    private static final String TAG = LargeImageDelegate.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();
    private BitmapDecoderCreator mBitmapDecoderCreator;
    private BitmapRegionDecoder mBitmapRegionDecoder;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private int mCurrentLoadType;
    private float mCurrentScaled;
    private GestureDetector mGestureDetector;
    private final View mImageView;
    private LoadBlockBitmapTaskManager mLoadBitmapTaskManager;
    private ILoadBlockBitmapCallback mLoadThumbnailBitmapCallback;
    private View.OnLongClickListener mLongClickListener;
    private float mMinScale;
    private Bitmap mOriginalBitmap;
    private ScaleGestureDetector mScaleGestureDetector;
    private FlingScroller mScroller;
    private Viewpoint mViewPoint;
    private ValueAnimator scaleAnimator;
    private float mMaxScale = 2.0f;
    private float mInitScale = 1.0f;
    private final Matrix mDisplayMatrix = new Matrix();
    Bitmap mThumbnailBitmap = null;
    private boolean mIsTop = true;
    private boolean mIsYScrollInLastAction = false;
    BdAsyncTask<String, String, String> mLoadThumbnailImageTask = new BdAsyncTask<String, String, String>() { // from class: com.baidu.live.tbadk.widget.largeimage.logic.LargeImageDelegate.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (LargeImageDelegate.this.mViewPoint != null && LargeImageDelegate.this.mBitmapRegionDecoder != null) {
                int[] imageWidthAndHeight = LargeImageDelegate.this.mBitmapDecoderCreator.getImageWidthAndHeight();
                int i = 1;
                while (Math.max(imageWidthAndHeight[0] / LargeImageDelegate.this.mViewPoint.getRealWidth(), imageWidthAndHeight[1] / LargeImageDelegate.this.mViewPoint.getRealHeight()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, imageWidthAndHeight[0], imageWidthAndHeight[1]);
                try {
                    LargeImageDelegate.this.mThumbnailBitmap = LargeImageDelegate.this.mBitmapRegionDecoder.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        LargeImageDelegate.this.mThumbnailBitmap = LargeImageDelegate.this.mBitmapRegionDecoder.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        LargeImageDelegate.this.mThumbnailBitmap = null;
                    }
                }
                TbImageMemoryCache.getInstance().addPic("long_img_mThumb" + System.currentTimeMillis(), new BdImage(LargeImageDelegate.this.mThumbnailBitmap, false));
                LargeImageDelegate.this.initDisplayMatrixSetMinScale(LargeImageDelegate.this.mThumbnailBitmap, LargeImageDelegate.this.mViewPoint, pow);
                LargeImageDelegate.this.mViewPoint.setThumbnail(LargeImageDelegate.this.mThumbnailBitmap);
                LargeImageDelegate.this.initViewPointWindow();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(String str) {
            if (LargeImageDelegate.this.mLoadThumbnailBitmapCallback != null) {
                LargeImageDelegate.this.mLoadThumbnailBitmapCallback.onLoadFinished();
            }
            LargeImageDelegate.this.findNeedLoadBitmapBlockAndSumitTask();
            LargeImageDelegate.this.mImageView.invalidate();
        }
    };

    public LargeImageDelegate(View view) {
        this.mCurrentLoadType = 1;
        this.mImageView = view;
        this.mContext = this.mImageView.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new MoveGestureListener());
        this.mScaleGestureDetector = new ScaleGestureDetector(this.mContext, new ScaleGestureListener());
        this.mScroller = new FlingScroller(this.mContext);
        this.mCurrentLoadType = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.mCurrentLoadType == 2 && isBigThumbnailBlockOK()) {
            switch (action) {
                case 0:
                    if (!this.mScroller.isFinished()) {
                        this.mIsYScrollInLastAction = true;
                    } else {
                        this.mIsYScrollInLastAction = false;
                    }
                case 1:
                case 3:
                    actionUp();
                    break;
            }
            this.mScroller.forceFinished(true);
            this.mScaleGestureDetector.onTouchEvent(motionEvent);
            if (this.mScaleGestureDetector.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean isViewTop() {
        return this.mIsTop;
    }

    public boolean isNormalScale() {
        return Math.floor((double) (this.mInitScale * 10000.0f)) == Math.floor((double) (this.mCurrentScaled * 10000.0f));
    }

    public void actionUp() {
        if (this.mCurrentScaled / this.mInitScale < 1.0f) {
            smoothScale(this.mInitScale, 0.0f, 0.0f, 400);
        }
    }

    public boolean computeScroll() {
        if (this.mCurrentLoadType == 1) {
            return false;
        }
        if (this.mScroller.computeScrollOffset()) {
            int currX = this.mScroller.getCurrX();
            this.mScroller.setOldValueX(currX);
            int currY = this.mScroller.getCurrY();
            this.mScroller.setOldValueY(currY);
            moveTo(-((currX - this.mScroller.getOldValueX()) * 2.0f), -((currY - this.mScroller.getOldValueY()) * 2.0f));
            this.mImageView.invalidate();
            return true;
        }
        return true;
    }

    public void setImageDatas(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.mBitmapDecoderCreator == null) {
            this.mOriginalBitmap = bitmap;
            this.mBitmapDecoderCreator = new BitmapDecoderCreator(this.mContext);
            try {
                this.mBitmapRegionDecoder = this.mBitmapDecoderCreator.createDecoder(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.mBitmapRegionDecoder = this.mBitmapDecoderCreator.createDecoder(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.mCurrentLoadType = 2;
            startLoad();
        }
    }

    public void startLoad() {
        if (this.mCurrentLoadType == 2 && this.mBitmapDecoderCreator != null && this.mLoadThumbnailImageTask.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.mViewPoint == null && this.mImageView.getMeasuredWidth() > 0 && this.mImageView.getMeasuredHeight() > 0 && this.mBitmapDecoderCreator.getImageWidthAndHeight()[0] > 0 && this.mBitmapDecoderCreator.getImageWidthAndHeight()[1] > 0) {
            this.mViewPoint = new Viewpoint(this.mImageView.getMeasuredWidth(), this.mImageView.getMeasuredHeight(), this.mBitmapDecoderCreator.getImageWidthAndHeight());
            this.mLoadThumbnailImageTask.setPriority(3);
            this.mLoadThumbnailImageTask.execute(new String[0]);
        }
    }

    public boolean needLoadOriginAllImage(int[] iArr) {
        if (iArr == null || iArr.length != 2) {
            return false;
        }
        int i = iArr[0];
        int i2 = iArr[1];
        return i < 4096 && i2 < 4096 && i * i2 < BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()) * BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public boolean onDraw(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !isBigThumbnailBlockOK()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.mImageView.getWidth() - this.mImageView.getPaddingLeft()) - this.mImageView.getPaddingRight();
            int height2 = (this.mImageView.getHeight() - this.mImageView.getPaddingTop()) - this.mImageView.getPaddingBottom();
            if (width * height2 > width2 * height) {
                f = height2 / height;
            } else {
                f = width2 / width;
            }
            matrix.setScale(f, f);
            matrix.postTranslate(0.0f, 0.0f);
            canvas.drawBitmap(bitmap, matrix, null);
            return true;
        }
        return onDraw(canvas);
    }

    private boolean isBigThumbnailBlockOK() {
        return (this.mViewPoint == null || this.mViewPoint.getThumbnailBlock() == null || this.mViewPoint.getThumbnailBlock().getBitmap() == null || this.mViewPoint.getThumbnailBlock().getBitmap().isRecycled()) ? false : true;
    }

    protected boolean onDraw(Canvas canvas) {
        if (this.mCurrentLoadType != 1 || this.mOriginalBitmap == null) {
            if (this.mViewPoint != null) {
                this.mViewPoint.getWindowInOriginalBitmap();
                if (isBigThumbnailBlockOK()) {
                    canvas.drawBitmap(this.mViewPoint.getThumbnailBlock().getBitmap(), this.mDisplayMatrix, null);
                }
                getAllDetailBitmapBlock(this.mViewPoint, false);
                updateAllBitmapBlock();
                canvas.save();
                float sampleScale = (1.0f * this.mViewPoint.getSampleScale()) / this.mViewPoint.getScaleLevel();
                canvas.scale(sampleScale, sampleScale);
                List<BlockBitmap> blockBitmapList = this.mViewPoint.getBlockBitmapList();
                if (blockBitmapList != null) {
                    for (BlockBitmap blockBitmap : blockBitmapList) {
                        canvas.drawBitmap(blockBitmap.getBitmap(), blockBitmap.getSrc(), blockBitmap.getDst(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float reInitScaleValue() {
        return this.mInitScale;
    }

    public float getMinScaleValue() {
        if (this.mInitScale < 1.0f) {
            return this.mInitScale;
        }
        return 1.0f;
    }

    public float getMaxScaleValue() {
        return 2.0f * this.mInitScale;
    }

    public void release() {
        if (this.scaleAnimator != null) {
            this.scaleAnimator.cancel();
        }
        if (this.mLoadThumbnailImageTask != null) {
            this.mLoadThumbnailImageTask.cancel();
        }
        if (this.mLoadBitmapTaskManager != null) {
            this.mLoadBitmapTaskManager.onDestory();
        }
        if (this.mViewPoint != null && this.mViewPoint.getBlockBitmapList() != null) {
            this.mViewPoint.getBlockBitmapList().clear();
        }
        if (this.mThumbnailBitmap != null) {
            this.mThumbnailBitmap.recycle();
            this.mThumbnailBitmap = null;
        }
        if (this.mBitmapRegionDecoder != null) {
            this.mBitmapRegionDecoder.recycle();
        }
    }

    private void updateAllBitmapBlock() {
        List<BlockBitmap> blockBitmapList = this.mViewPoint.getBlockBitmapList();
        if (blockBitmapList != null) {
            for (BlockBitmap blockBitmap : blockBitmapList) {
                updateBitmapBlockSrcAndDstRect(blockBitmap, this.mViewPoint);
            }
        }
    }

    public void setLoadThumbnailBitmapCallback(ILoadBlockBitmapCallback iLoadBlockBitmapCallback) {
        this.mLoadThumbnailBitmapCallback = iLoadBlockBitmapCallback;
    }

    public void updateBitmapBlockSrcAndDstRect(BlockBitmap blockBitmap, Viewpoint viewpoint) {
        if (blockBitmap.getPosition().getColumn() == 0 && blockBitmap.getPosition().getRow() == 1) {
            System.currentTimeMillis();
        }
        setBlockBitmapSrcAndDst(blockBitmap, viewpoint.getPositionInOriginBitmap(blockBitmap), viewpoint.getWindowInOriginalBitmap());
    }

    private void setBlockBitmapSrcAndDst(BlockBitmap blockBitmap, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int sampleScale = blockBitmap.getPosition().getSampleScale();
        blockBitmap.setSrcRect((i - rect.left) / sampleScale, (i3 - rect.top) / sampleScale, (i2 - rect.left) / sampleScale, (i4 - rect.top) / sampleScale);
        blockBitmap.setDstRect((i - rect2.left) / sampleScale, (i3 - rect2.top) / sampleScale, (i2 - rect2.left) / sampleScale, (i4 - rect2.top) / sampleScale);
    }

    private void getAllDetailBitmapBlock(Viewpoint viewpoint, boolean z) {
        getAllAvailableBlock(viewpoint.getStartAndEndPosition(), viewpoint.getSampleScale(), z);
    }

    private void getAllAvailableBlock(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<BlockBitmap> list;
        if (this.mLoadBitmapTaskManager == null) {
            this.mLoadBitmapTaskManager = new LoadBlockBitmapTaskManager(this.mViewPoint, this.mBitmapRegionDecoder);
        }
        int i3 = pointArr[0].y;
        int i4 = pointArr[0].x;
        int i5 = pointArr[1].y;
        int i6 = pointArr[1].x;
        if (z) {
            i2 = i3;
            z2 = true;
            list = null;
        } else {
            List<BlockBitmap> blockBitmapList = this.mViewPoint.getBlockBitmapList();
            blockBitmapList.clear();
            i2 = i3;
            z2 = true;
            list = blockBitmapList;
        }
        while (i2 < i5) {
            for (int i7 = i4; i7 < i6; i7++) {
                BlockBitmap blockBitmapFromLru = getBlockBitmapFromLru(i2, i7, i);
                if (blockBitmapFromLru == null) {
                    if (z) {
                        startTask(i2, i7, i);
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                } else if (!z) {
                    list.add(blockBitmapFromLru);
                }
            }
            i2++;
        }
        if (z2) {
            this.mLoadBitmapTaskManager.clearAllTask();
        }
    }

    public void findNeedLoadBitmapBlockAndSumitTask() {
        if (this.mCurrentLoadType != 1) {
            getAllDetailBitmapBlock(this.mViewPoint, true);
        }
    }

    private void startTask(int i, int i2, int i3) {
        LoadBlockBitmapTaskManager.LoadBitmapAsyncTask loadBitmapAsyncTask = new LoadBlockBitmapTaskManager.LoadBitmapAsyncTask(i, i2, i3);
        loadBitmapAsyncTask.setLoadFinshedListener(this);
        this.mLoadBitmapTaskManager.summitTask(loadBitmapAsyncTask);
    }

    private BlockBitmap getBlockBitmapFromLru(int i, int i2, int i3) {
        BlockBitmap blockBitmap;
        BlockBitmap.Position position = new BlockBitmap.Position(i, i2, i3);
        if (this.mLoadBitmapTaskManager.getBlockBitmapLruCache() != null && (blockBitmap = this.mLoadBitmapTaskManager.getBlockBitmapLruCache().get(position)) != null) {
            if (blockBitmap.getBitmap() == null || blockBitmap.getBitmap().isRecycled()) {
                this.mLoadBitmapTaskManager.getBlockBitmapLruCache().remove(position);
                return null;
            }
            return blockBitmap;
        }
        return null;
    }

    @Override // com.baidu.live.tbadk.widget.largeimage.logic.ILoadBlockBitmapCallback
    public void onLoadFinished() {
        this.mImageView.postInvalidate();
    }

    /* loaded from: classes2.dex */
    private class MoveGestureListener extends GestureDetector.SimpleOnGestureListener {
        private MoveGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            LargeImageDelegate.this.moveTo((int) f, (int) f2);
            if (Math.abs(f2) > LargeImageDelegate.TOUCH_SLOP) {
                LargeImageDelegate.this.mIsYScrollInLastAction = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            LargeImageDelegate.this.smoothScale(LargeImageDelegate.this.mCurrentScaled == LargeImageDelegate.this.mMaxScale ? LargeImageDelegate.this.mInitScale : LargeImageDelegate.this.mMaxScale, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect windowInOriginalBitmap = LargeImageDelegate.this.mViewPoint.getWindowInOriginalBitmap();
            Rect originalBitmapRect = LargeImageDelegate.this.mViewPoint.getOriginalBitmapRect();
            float f3 = windowInOriginalBitmap.right - originalBitmapRect.right;
            float f4 = windowInOriginalBitmap.left - originalBitmapRect.left;
            float f5 = windowInOriginalBitmap.bottom - originalBitmapRect.bottom;
            float f6 = windowInOriginalBitmap.top - originalBitmapRect.top;
            LargeImageDelegate.this.mScroller.forceFinished(true);
            LargeImageDelegate.this.mScroller.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            LargeImageDelegate.this.mImageView.invalidate();
            if (Math.abs(f2) > LargeImageDelegate.TOUCH_SLOP) {
                LargeImageDelegate.this.mIsYScrollInLastAction = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (LargeImageDelegate.this.mIsYScrollInLastAction || LargeImageDelegate.this.mLongClickListener == null) {
                LargeImageDelegate.this.mIsYScrollInLastAction = false;
            } else {
                LargeImageDelegate.this.mLongClickListener.onLongClick(LargeImageDelegate.this.mImageView);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (LargeImageDelegate.this.mIsYScrollInLastAction || LargeImageDelegate.this.mClickListener == null) {
                LargeImageDelegate.this.mIsYScrollInLastAction = false;
            } else {
                LargeImageDelegate.this.mClickListener.onClick(LargeImageDelegate.this.mImageView);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void smoothScale(float f, final float f2, final float f3, int i) {
        if (this.scaleAnimator != null) {
            this.scaleAnimator.cancel();
        }
        this.scaleAnimator = ValueAnimator.ofFloat(this.mCurrentScaled, f);
        this.scaleAnimator.setDuration(i);
        this.scaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.tbadk.widget.largeimage.logic.LargeImageDelegate.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    LargeImageDelegate.this.onScale(((Float) valueAnimator.getAnimatedValue()).floatValue() / LargeImageDelegate.this.mCurrentScaled, f2, f3);
                }
            }
        });
        this.scaleAnimator.start();
    }

    /* loaded from: classes2.dex */
    private class ScaleGestureListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private ScaleGestureListener() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            LargeImageDelegate.this.onScale(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }
    }

    public void onScale(float f, float f2, float f3) {
        if (this.mCurrentScaled * f < this.mMinScale) {
            f = this.mMinScale / this.mCurrentScaled;
        }
        if (this.mCurrentScaled * f > this.mMaxScale) {
            f = this.mMaxScale / this.mCurrentScaled;
        }
        Rect windowInOriginalBitmap = this.mViewPoint.getWindowInOriginalBitmap();
        float f4 = ((windowInOriginalBitmap.left + windowInOriginalBitmap.right) * 1.0f) / 2.0f;
        float f5 = ((windowInOriginalBitmap.bottom + windowInOriginalBitmap.top) * 1.0f) / 2.0f;
        if (this.mViewPoint != null) {
            this.mDisplayMatrix.postScale(f, f, this.mViewPoint.getRealWidth() / 2, this.mViewPoint.getRealHeight() / 2);
            this.mViewPoint.postScaleWindow(1.0f / f, f4, f5);
            this.mCurrentScaled *= f;
            this.mViewPoint.setScaleLevel(1.0f / this.mCurrentScaled);
            float[] checkPosition = checkPosition();
            this.mDisplayMatrix.postTranslate(-checkPosition[0], -checkPosition[1]);
            this.mViewPoint.moveWindow((checkPosition[0] * 1.0f) / this.mCurrentScaled, (checkPosition[1] * 1.0f) / this.mCurrentScaled);
            findNeedLoadBitmapBlockAndSumitTask();
            this.mImageView.invalidate();
        }
    }

    public boolean isAtViewTop() {
        Rect windowInOriginalBitmap;
        return (this.mViewPoint == null || (windowInOriginalBitmap = this.mViewPoint.getWindowInOriginalBitmap()) == null || windowInOriginalBitmap.top > 10) ? false : true;
    }

    private float[] checkPosition() {
        Rect windowInOriginalBitmap = this.mViewPoint.getWindowInOriginalBitmap();
        int[] imageWidthAndHeight = this.mBitmapDecoderCreator.getImageWidthAndHeight();
        float[] fArr = {(imageWidthAndHeight[0] / 2) - (((windowInOriginalBitmap.left + windowInOriginalBitmap.right) * 1.0f) / 2.0f)};
        if (windowInOriginalBitmap.top < 0) {
            fArr[1] = 0 - windowInOriginalBitmap.top;
        }
        if (windowInOriginalBitmap.bottom > imageWidthAndHeight[1]) {
            fArr[1] = imageWidthAndHeight[1] - windowInOriginalBitmap.bottom;
        }
        if (windowInOriginalBitmap.bottom - windowInOriginalBitmap.top > imageWidthAndHeight[1]) {
            fArr[1] = (imageWidthAndHeight[1] / 2) - (((windowInOriginalBitmap.bottom + windowInOriginalBitmap.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.mCurrentScaled;
        fArr[1] = fArr[1] * this.mCurrentScaled;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.mViewPoint != null) {
            float[] realMove = getRealMove(f, f2);
            this.mDisplayMatrix.postTranslate(-realMove[0], -realMove[1]);
            this.mViewPoint.moveWindow((realMove[0] * 1.0f) / this.mCurrentScaled, (realMove[1] * 1.0f) / this.mCurrentScaled);
            findNeedLoadBitmapBlockAndSumitTask();
            this.mImageView.invalidate();
        }
    }

    private float[] getRealMove(float f, float f2) {
        float[] fArr = new float[2];
        Rect windowInOriginalBitmap = this.mViewPoint.getWindowInOriginalBitmap();
        int[] imageWidthAndHeight = this.mBitmapDecoderCreator.getImageWidthAndHeight();
        if (windowInOriginalBitmap.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (windowInOriginalBitmap.bottom + f2 > imageWidthAndHeight[1]) {
            f2 = (imageWidthAndHeight[1] - windowInOriginalBitmap.bottom) * this.mCurrentScaled;
        }
        if (windowInOriginalBitmap.bottom - windowInOriginalBitmap.top > imageWidthAndHeight[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.mIsTop = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPointWindow() {
        if (this.mViewPoint != null) {
            this.mViewPoint.postScaleWindow(1.0f / this.mInitScale);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initDisplayMatrixSetMinScale(Bitmap bitmap, Viewpoint viewpoint, int i) {
        float max = Math.max((viewpoint.getRealWidth() * 1.0f) / bitmap.getWidth(), (viewpoint.getRealHeight() * 1.0f) / bitmap.getHeight());
        this.mDisplayMatrix.postScale(max, max);
        this.mMinScale = max * (1.0f / i);
        this.mInitScale = this.mMinScale;
        this.mCurrentScaled = this.mInitScale;
        this.mMaxScale = 2.0f * this.mCurrentScaled;
        float realWidth = (viewpoint.getRealWidth() * 1.0f) / this.mBitmapRegionDecoder.getWidth();
        if (realWidth > 1.0f) {
            this.mMinScale /= realWidth;
        }
        viewpoint.setScaleLevel(1.0f / this.mCurrentScaled);
    }

    /* loaded from: classes2.dex */
    private class FlingScroller extends Scroller {
        int mOldValueX;
        int mOldValueY;

        public FlingScroller(Context context) {
            super(context);
            this.mOldValueX = 0;
            this.mOldValueY = 0;
        }

        public void setOldValueX(int i) {
            this.mOldValueX = i;
        }

        public void setOldValueY(int i) {
            this.mOldValueY = i;
        }

        public int getOldValueX() {
            return this.mOldValueX;
        }

        public int getOldValueY() {
            return this.mOldValueY;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.mOldValueX = 0;
            this.mOldValueY = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}
