package com.baidu.searchbox.picture.component;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.baidu.android.ext.widget.LoadingViewHelper;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.lib_atlas_base.R;
import com.baidu.searchbox.picture.component.EnterAndExitAnimationHelper;
import com.baidu.searchbox.picture.component.HugePhotoDraweeView;
import com.baidu.searchbox.picture.component.view.PictureOriginButton;
import com.baidu.searchbox.picture.model.PictureInfo;
import com.baidu.searchbox.picture.utils.Utils;
import com.baidu.searchbox.ui.UIRuntime;
import com.facebook.drawee.a.a.c;
import com.facebook.drawee.controller.b;
import com.facebook.drawee.drawable.p;
import com.facebook.imagepipeline.g.a;
import com.facebook.imagepipeline.g.d;
import com.facebook.imagepipeline.g.f;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
/* loaded from: classes13.dex */
public class BaseBrowseView extends FrameLayout {
    private static final boolean DEBUG = true;
    public static final String IMG_TYPE_GIF = "gif";
    public static final String IMG_TYPE_PIC = "pic";
    private static final float LONG_PIC_DISTINGUISH_RATE = 1.6f;
    public static final float MAX_BITMAP_SIZE = 8192.0f;
    public static final String ROOT_VIEW_COLOR = "#000000";
    private static final String TAG = "baseBrowseView";
    protected HugePhotoDraweeView imageView;
    protected EnterAndExitAnimationHelper mAnimationHelper;
    protected d mCloseableStaticBitmap;
    protected String mCurrentPictureType;
    protected FrameLayout mErrorFrameLayout;
    private boolean mHasLoadOriginImage;
    private OnImageLoadStatusListener mImageLoadStatusListener;
    protected String mImageUrl;
    private boolean mIsOriginButtonShown;
    protected boolean mIsPictureReady;
    protected boolean mIsVisible;
    private View.OnLongClickListener mLongClickListener;
    protected PictureOriginButton mOriginButton;
    protected PictureInfo mPicInfo;
    private OnImageLoadCompleteListener mPictureLoadListener;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    int[] maxTextureSize;

    /* loaded from: classes13.dex */
    public interface OnImageLoadCompleteListener {
        void onLoadComplete(String str, Object obj, Context context);
    }

    /* loaded from: classes13.dex */
    public interface OnImageLoadStatusListener extends OnImageLoadCompleteListener {
        void onSetImageComplete();
    }

    public BaseBrowseView(Context context, ArrayList<Integer> arrayList) {
        super(context);
        this.mImageUrl = null;
        this.maxTextureSize = new int[1];
        this.mIsOriginButtonShown = false;
        this.mHasLoadOriginImage = false;
        this.mAnimationHelper = new EnterAndExitAnimationHelper(getContext(), arrayList);
        initViews(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsVisible = true;
    }

    public void setData(PictureInfo pictureInfo) {
        this.mImageUrl = pictureInfo.mUrl;
        this.mPicInfo = pictureInfo;
        doReadyToLoadImage();
        loadImage();
    }

    private void initViews(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.light_picture_viewpager, this);
        this.mRootView.setBackgroundColor(Color.parseColor(ROOT_VIEW_COLOR));
        this.imageView = (HugePhotoDraweeView) this.mRootView.findViewById(R.id.hugePhotoDraweeView);
        this.mRootView.setTag(this.imageView);
        this.mErrorFrameLayout = (FrameLayout) this.mRootView.findViewById(R.id.light_picture_browse_network_error);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.picture.component.BaseBrowseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BaseBrowseView.this.mAnimationHelper.ismHasExitAnim()) {
                    BaseBrowseView.this.mAnimationHelper.doFinishJob(BaseBrowseView.this.imageView, BaseBrowseView.this.mRootView, BaseBrowseView.this.mOriginButton);
                } else {
                    BaseBrowseView.this.quitActivityWithoutAnimation();
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LoadingViewHelper.removeLoadingView(this);
        this.mIsVisible = false;
    }

    private void doReadyToLoadImage() {
        initIfShowLoadOriginBtn();
        if (this.mAnimationHelper.parseAnimationPos()) {
            setClipChildren(false);
            this.mAnimationHelper.getImageSize();
        }
    }

    private void setImageViewListener() {
        this.imageView.setOnImageEventListener(new HugePhotoDraweeView.OnImageEventListener() { // from class: com.baidu.searchbox.picture.component.BaseBrowseView.2
            @Override // com.baidu.searchbox.picture.component.HugePhotoDraweeView.OnImageEventListener
            public void onReady() {
                if (BaseBrowseView.this.mOriginButton != null && BaseBrowseView.this.mIsOriginButtonShown && !BaseBrowseView.this.mHasLoadOriginImage) {
                    BaseBrowseView.this.mOriginButton.immediatelyShow();
                }
            }

            @Override // com.baidu.searchbox.picture.component.HugePhotoDraweeView.OnImageEventListener
            public void onImageLoaded() {
                BaseBrowseView.this.hideLoadingAndHideErrorView();
                BaseBrowseView.this.mIsPictureReady = true;
                if (!BaseBrowseView.this.mAnimationHelper.hasRunAnim() || !BaseBrowseView.this.mAnimationHelper.isHasAnim()) {
                    if (!DeviceUtil.ScreenInfo.isScreenPortrait()) {
                        BaseBrowseView.this.mAnimationHelper.setIsReadyAnimation(false);
                        BaseBrowseView.this.resetAnimation();
                    } else if (!BaseBrowseView.this.mAnimationHelper.getIsReadyAnimation()) {
                        BaseBrowseView.this.resetAnimation();
                    } else {
                        if (BaseBrowseView.this.mImageLoadStatusListener != null) {
                            BaseBrowseView.this.mImageLoadStatusListener.onSetImageComplete();
                        }
                        if (BaseBrowseView.this.imageView != null && BaseBrowseView.this.mRootView != null) {
                            BaseBrowseView.this.mRootView.getBackground().setAlpha(0);
                            BaseBrowseView.this.imageView.postDelayed(new Runnable() { // from class: com.baidu.searchbox.picture.component.BaseBrowseView.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    BaseBrowseView.this.mAnimationHelper.runEnterAnim(BaseBrowseView.this.imageView, BaseBrowseView.this.mRootView);
                                }
                            }, 100L);
                        }
                    }
                }
            }

            @Override // com.baidu.searchbox.picture.component.HugePhotoDraweeView.OnImageEventListener
            public void onPreviewLoadError(Exception exc) {
                BaseBrowseView.this.mAnimationHelper.setIsReadyAnimation(false);
            }

            @Override // com.baidu.searchbox.picture.component.HugePhotoDraweeView.OnImageEventListener
            public void onImageLoadError(Exception exc) {
                BaseBrowseView.this.hideLoadingAndShowErrorView();
                BaseBrowseView.this.mAnimationHelper.setIsReadyAnimation(false);
            }

            @Override // com.baidu.searchbox.picture.component.HugePhotoDraweeView.OnImageEventListener
            public void onTileLoadError(Exception exc) {
                BaseBrowseView.this.hideLoadingAndHideErrorView();
                BaseBrowseView.this.mAnimationHelper.setIsReadyAnimation(false);
            }
        });
        this.imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.picture.component.BaseBrowseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BaseBrowseView.this.mAnimationHelper.ismHasExitAnim()) {
                    BaseBrowseView.this.mAnimationHelper.doFinishJob(BaseBrowseView.this.imageView, BaseBrowseView.this.mRootView, BaseBrowseView.this.mOriginButton);
                } else {
                    BaseBrowseView.this.quitActivityWithoutAnimation();
                }
            }
        });
        this.imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.searchbox.picture.component.BaseBrowseView.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (BaseBrowseView.this.mLongClickListener != null) {
                    return BaseBrowseView.this.mLongClickListener.onLongClick(BaseBrowseView.this.imageView);
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetAnimation() {
        this.mAnimationHelper.resetAnimation();
        setClipChildren(true);
        Log.d(TAG, " no cache resetAnimation()");
        if (!this.mAnimationHelper.hasRunAnim() || !this.mAnimationHelper.isHasAnim()) {
            this.imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void loadImage() {
        String imageUrl = getImageUrl();
        String frescoCachedPath = Utils.getFrescoCachedPath(imageUrl, getContext());
        if ((TextUtils.isEmpty(frescoCachedPath) && !Utils.inFrescoCache(imageUrl)) || !this.mAnimationHelper.getIsReadyAnimation()) {
            resetAnimation();
            frescoCachedPath = imageUrl;
        } else if (TextUtils.isEmpty(frescoCachedPath)) {
            frescoCachedPath = imageUrl;
        }
        Log.i(TAG, "path = " + frescoCachedPath);
        this.mAnimationHelper.doAnimationCountJob(frescoCachedPath);
        setImageViewListener();
        this.imageView.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
        Uri uri = Utils.getUri(frescoCachedPath);
        if (TextUtils.isEmpty(frescoCachedPath) || uri == null) {
            Log.i(TAG, "path = " + frescoCachedPath);
            return;
        }
        ImageRequestBuilder Y = ImageRequestBuilder.Y(uri);
        b bVar = new b() { // from class: com.baidu.searchbox.picture.component.BaseBrowseView.5
            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void onSubmit(String str, Object obj) {
                super.onSubmit(str, obj);
                BaseBrowseView.this.showLoadingAndHideErrorView();
            }

            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
                super.onFinalImageSet(str, obj, animatable);
                BaseBrowseView.this.onImageHasSet(str, obj, animatable);
            }

            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void onFailure(String str, Throwable th) {
                super.onFailure(str, th);
                BaseBrowseView.this.hideLoadingAndShowErrorView();
            }
        };
        Y.c(new com.facebook.imagepipeline.common.d(DeviceUtil.ScreenInfo.getDisplayWidth(getContext()), Integer.MAX_VALUE, 8192.0f));
        this.imageView.setController(c.dlw().vh(true).bg(Y.dsA()).c(this.imageView.getController()).c(bVar).dmn());
    }

    protected void onImageHasSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        if (this.mPictureLoadListener != null) {
            this.mPictureLoadListener.onLoadComplete(this.mImageUrl, obj, getContext());
        }
        if (obj instanceof d) {
            this.mCurrentPictureType = "pic";
            Log.i(TAG, "show static bitmap-->");
            this.imageView.setIsDynamicBitmap(false);
            this.imageView.setZoomEnabled(true);
            this.mAnimationHelper.doReadyStartAnimLocationJob(this.imageView);
            this.mCloseableStaticBitmap = (d) obj;
            Bitmap dqp = this.mCloseableStaticBitmap.dqp();
            if (this.mImageLoadStatusListener != null) {
                this.mImageLoadStatusListener.onLoadComplete(str, obj, getContext());
            }
            if (dqp == null) {
                hideLoadingAndShowErrorView();
            } else {
                setImageView(dqp);
            }
        } else if (obj instanceof a) {
            this.mCurrentPictureType = IMG_TYPE_GIF;
            Log.i(TAG, "show gif -->");
            hideLoadingAndHideErrorView();
            this.imageView.setIsDynamicBitmap(true);
            this.imageView.setZoomEnabled(false);
            this.imageView.getHierarchy().b(p.b.lMN);
            resetAnimation();
        }
    }

    protected void setImageView(Bitmap bitmap) {
        this.maxTextureSize = HugePhotoUtils.getMaxTextureSize();
        Log.i("GLES10", "maxTextureSize: " + this.maxTextureSize[0]);
        ImageSource cachedBitmap = ImageSource.cachedBitmap(bitmap);
        if (bitmap.getWidth() >= this.maxTextureSize[0] || bitmap.getHeight() >= this.maxTextureSize[0]) {
            cachedBitmap.tilingEnabled();
            this.mAnimationHelper.setIsReadyAnimation(false);
        } else {
            cachedBitmap.tilingDisabled();
        }
        this.imageView.setImage(cachedBitmap);
        longPicDisplayMode(bitmap);
    }

    private void getScreenSize() {
        this.mScreenWidth = DeviceUtil.ScreenInfo.getDisplayWidth(UIRuntime.getAppContext());
        this.mScreenHeight = DeviceUtil.ScreenInfo.getDisplayHeight(UIRuntime.getAppContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingAndHideErrorView() {
        LoadingViewHelper.showShimmerLoadingView(getContext(), this);
        if (this.mErrorFrameLayout != null) {
            this.mErrorFrameLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingAndShowErrorView() {
        LoadingViewHelper.dismissLoadingView(this);
        if (this.mErrorFrameLayout != null) {
            this.mErrorFrameLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingAndHideErrorView() {
        LoadingViewHelper.dismissLoadingView(this);
        if (this.mErrorFrameLayout != null) {
            this.mErrorFrameLayout.setVisibility(8);
        }
    }

    public void quitActivityWithoutAnimation() {
        if (getContext() instanceof Activity) {
            Activity activity = (Activity) getContext();
            activity.finish();
            activity.overridePendingTransition(0, 0);
        }
    }

    public String getCurrentPictureType() {
        return this.mCurrentPictureType;
    }

    public void longPicDisplayMode(Bitmap bitmap) {
        getScreenSize();
        if (bitmap != null) {
            float width = bitmap.getWidth() == 0 ? 1.0f : this.mScreenWidth / bitmap.getWidth();
            if (((int) (bitmap.getHeight() * width)) >= this.mScreenHeight * 1.6f) {
                this.imageView.setDoubleTapZoomScale(width);
                this.imageView.setScaleAndCenter(width, new PointF(this.mScreenWidth / 2, 0.0f));
                disableDrag();
            }
        }
    }

    public void disableDrag() {
    }

    public HugePhotoDraweeView getHugePhotoDraweeView() {
        return this.imageView;
    }

    public PictureInfo getPictInfo() {
        return this.mPicInfo;
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void setPictureLoadListener(OnImageLoadCompleteListener onImageLoadCompleteListener) {
        this.mPictureLoadListener = onImageLoadCompleteListener;
    }

    public void setImageLoadStatusListener(OnImageLoadStatusListener onImageLoadStatusListener) {
        this.mImageLoadStatusListener = onImageLoadStatusListener;
    }

    public void setLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public void setLoadOriginPhotoListener(PictureOriginButton.OnLoadOriginPhotoListener onLoadOriginPhotoListener) {
        if (this.mOriginButton != null) {
            this.mOriginButton.setLoadOriginPhotoListener(onLoadOriginPhotoListener);
        }
    }

    public void setEnterAndOutAnimation(EnterAndExitAnimationHelper.ExitAnimationListener exitAnimationListener) {
        this.mAnimationHelper.setEnterAndOutAnimation(exitAnimationListener);
    }

    private void initIfShowLoadOriginBtn() {
        if (this.mPicInfo != null) {
            if (TextUtils.isEmpty(this.mPicInfo.getOriginUrl())) {
                this.mIsOriginButtonShown = false;
                return;
            }
            this.mIsOriginButtonShown = true;
            if (Utils.inFrescoCache(this.mPicInfo.getOriginUrl())) {
                this.mIsOriginButtonShown = false;
                this.mHasLoadOriginImage = true;
            }
            if (this.mIsOriginButtonShown && this.mOriginButton == null) {
                this.mOriginButton = (PictureOriginButton) ((ViewStub) this.mRootView.findViewById(R.id.light_picture_browse_load_origin_view)).inflate();
                this.mOriginButton.setData(this.mPicInfo);
                this.mOriginButton.setLoadOriginListener(new PictureOriginButton.LoadOriginImageListener() { // from class: com.baidu.searchbox.picture.component.BaseBrowseView.6
                    @Override // com.baidu.searchbox.picture.component.view.PictureOriginButton.LoadOriginImageListener
                    public void success(String str) {
                        BaseBrowseView.this.mHasLoadOriginImage = true;
                        BaseBrowseView.this.updateToOriginImage(str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateToOriginImage(String str) {
        this.imageView.setController(c.dlw().c(this.imageView.getController()).vh(true).c(new b<f>() { // from class: com.baidu.searchbox.picture.component.BaseBrowseView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void onFinalImageSet(String str2, @Nullable f fVar, @Nullable Animatable animatable) {
                if (fVar instanceof d) {
                    BaseBrowseView.this.setImageView(((d) fVar).dqp());
                }
            }
        }).bg(ImageRequestBuilder.Y(Uri.parse(str)).dsA()).dmn());
    }

    public String getImageUrl() {
        return this.mHasLoadOriginImage ? this.mPicInfo.getOriginUrl() : this.mImageUrl;
    }

    public void pictureActivityClosing(int i, boolean z) {
        if (i != 0 && z) {
            setFragmentRootViewBackground(new ColorDrawable(0));
            if (!this.mHasLoadOriginImage && this.mOriginButton != null && this.mIsPictureReady) {
                this.mOriginButton.immediatelyGone();
            }
        }
        if (i == 0) {
            setFragmentRootViewBackground(new ColorDrawable(Color.parseColor(ROOT_VIEW_COLOR)));
            if (!this.mHasLoadOriginImage && this.mOriginButton != null && this.mIsPictureReady) {
                this.mOriginButton.immediatelyShow();
            }
        }
    }

    public void pictureActivityPageChanging(boolean z) {
        if (!this.mHasLoadOriginImage && this.mOriginButton != null && this.mIsPictureReady) {
            if (z) {
                this.mOriginButton.immediatelyGone();
            } else {
                this.mOriginButton.immediatelyShow();
            }
        }
    }

    private void setFragmentRootViewBackground(Drawable drawable) {
        if (getRootView() != null) {
            getRootView().setBackground(drawable);
        }
    }

    public Bitmap getBitmap() {
        if (this.mCloseableStaticBitmap != null) {
            return this.mCloseableStaticBitmap.dqp();
        }
        return null;
    }
}
