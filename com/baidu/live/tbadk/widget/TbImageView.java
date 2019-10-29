package com.baidu.live.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.IScrollable;
import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.lib.resourceloader.BdResourceCallback;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.newwidget.imageview.BDImageView;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.BitmapHelper;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tieba.pb.a.a;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TbImageView extends BDImageView implements View.OnClickListener, Runnable {
    private static final int LOADING_FRAMES_COUNT = 12;
    private static final int LOADING_FRAMES_DURATION = 150;
    private static Method mClearDisplayListMethod;
    private static Method mDestroyLayerMethod;
    private static Method mDestroyLayerWithParamMethod;
    private static Method mResetDisplayListMethod;
    private static HashMap<String, SoftReference<BdImage>> sDefaultBdImageCache;
    protected boolean canLogPerf;
    protected boolean isLongPic;
    private boolean isPageIdRegisterMessage;
    private int lastSkinType;
    private boolean mAutoChangeStyle;
    private BdImage mCurUsedBdImage;
    private int mCurrentDefaultBgId;
    private int mCurrentDefaultId;
    private float mCurrentDegrees;
    private int mDefaultBgId;
    protected int mDefaultErrorId;
    protected int mDefaultId;
    protected int mDefaultIdInUse;
    protected ImageViewEvent mEvent;
    private a mGestureDetector;
    protected int mHeight;
    private boolean mInterceptOnClick;
    private final a mInternalGestureDetector;
    protected boolean mIsGif;
    int mLoadedHeight;
    int mLoadedWidth;
    private final int mLoadingDefaultId;
    private float mLoadingFrameIncrement;
    private final Matrix mMatrix;
    private View.OnClickListener mOnClickListener;
    protected OnDrawListener mOnDrawListener;
    protected BdUniqueId mPageId;
    private boolean mShowLoading;
    protected boolean mSupportNoImage;
    private TbViewTagDrawer mTagDrawer;
    private String mTagStr;
    protected int mType;
    protected String mUrl;
    protected int mWidth;
    protected long requestTime;

    /* loaded from: classes6.dex */
    public interface ImageViewEvent {
        void onCancel();

        void onComplete(String str, boolean z);
    }

    /* loaded from: classes6.dex */
    public interface OnDrawListener {
        void onAfterDraw(TbImageView tbImageView, Canvas canvas);

        void onBeforeDraw(TbImageView tbImageView, Canvas canvas);
    }

    public void setEvent(ImageViewEvent imageViewEvent) {
        this.mEvent = imageViewEvent;
    }

    public void setOnDrawListener(OnDrawListener onDrawListener) {
        this.mOnDrawListener = onDrawListener;
    }

    @Deprecated
    public int getLoadedWidth() {
        return this.mLoadedWidth;
    }

    @Deprecated
    public int getLoadedHeight() {
        return this.mLoadedHeight;
    }

    private void processIsGifPic(BdImage bdImage) {
        if (bdImage != null) {
            this.mIsGif = bdImage.isGif();
        }
    }

    private void processIsLongPic(BdImage bdImage) {
    }

    public TbImageView(Context context) {
        super(context);
        this.mEvent = null;
        this.mDefaultId = a.d.sdk_transparent;
        this.mDefaultErrorId = a.f.sdk_img_default_100;
        this.mDefaultIdInUse = this.mDefaultId;
        this.mLoadingDefaultId = a.f.sdk_img_loading;
        this.mDefaultBgId = a.d.sdk_cp_bg_line_e;
        this.mIsGif = false;
        this.isLongPic = false;
        this.mType = -1;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.mSupportNoImage = false;
        this.lastSkinType = 3;
        this.mCurUsedBdImage = null;
        this.requestTime = 0L;
        this.mLoadedWidth = 0;
        this.mLoadedHeight = 0;
        this.isPageIdRegisterMessage = false;
        this.mInternalGestureDetector = new com.baidu.live.tieba.pb.a.a(new a.InterfaceC0077a() { // from class: com.baidu.live.tbadk.widget.TbImageView.1
            @Override // com.baidu.live.tieba.pb.a.a.InterfaceC0077a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbImageView.this.mGestureDetector != null) {
                    TbImageView.this.mGestureDetector.N(view);
                    return TbImageView.this.mGestureDetector.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.live.tieba.pb.a.a.InterfaceC0077a
            public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.live.tieba.pb.a.a.InterfaceC0077a
            public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.mInterceptOnClick) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.mGestureDetector != null) {
                        TbImageView.this.mGestureDetector.N(view);
                        return TbImageView.this.mGestureDetector.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                TbImageView.this.realLoadBitmap(TbImageView.this.mUrl, TbImageView.this.mType);
                return true;
            }
        });
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEvent = null;
        this.mDefaultId = a.d.sdk_transparent;
        this.mDefaultErrorId = a.f.sdk_img_default_100;
        this.mDefaultIdInUse = this.mDefaultId;
        this.mLoadingDefaultId = a.f.sdk_img_loading;
        this.mDefaultBgId = a.d.sdk_cp_bg_line_e;
        this.mIsGif = false;
        this.isLongPic = false;
        this.mType = -1;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.mSupportNoImage = false;
        this.lastSkinType = 3;
        this.mCurUsedBdImage = null;
        this.requestTime = 0L;
        this.mLoadedWidth = 0;
        this.mLoadedHeight = 0;
        this.isPageIdRegisterMessage = false;
        this.mInternalGestureDetector = new com.baidu.live.tieba.pb.a.a(new a.InterfaceC0077a() { // from class: com.baidu.live.tbadk.widget.TbImageView.1
            @Override // com.baidu.live.tieba.pb.a.a.InterfaceC0077a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbImageView.this.mGestureDetector != null) {
                    TbImageView.this.mGestureDetector.N(view);
                    return TbImageView.this.mGestureDetector.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.live.tieba.pb.a.a.InterfaceC0077a
            public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.live.tieba.pb.a.a.InterfaceC0077a
            public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.mInterceptOnClick) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.mGestureDetector != null) {
                        TbImageView.this.mGestureDetector.N(view);
                        return TbImageView.this.mGestureDetector.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                TbImageView.this.realLoadBitmap(TbImageView.this.mUrl, TbImageView.this.mType);
                return true;
            }
        });
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTagDrawer = new TbViewTagDrawer(this);
        updateNight();
        this.mLoadingFrameIncrement = 30.0f;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.mNeedRecomputeMatrix = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.mNeedRecomputeMatrix = true;
            requestLayout();
        }
    }

    @Override // com.baidu.live.adp.newwidget.imageview.BDImageView
    public BdImage getBdImage() {
        return this.mCurUsedBdImage;
    }

    @Override // com.baidu.live.adp.newwidget.imageview.BDImageView
    protected BdImage getDefaultBdImage() {
        SoftReference<BdImage> softReference;
        BdImage bdImage;
        if (sDefaultBdImageCache == null) {
            sDefaultBdImageCache = new HashMap<>();
        }
        String valueOf = String.valueOf(this.mCurrentDefaultId);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.getInst().getSkinType() == 1) ? valueOf + "_1" : valueOf;
        if (this.lastSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mNeedRecomputeMatrix = true;
            this.lastSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (!sDefaultBdImageCache.containsKey(str) || (softReference = sDefaultBdImageCache.get(str)) == null || (bdImage = softReference.get()) == null || !bdImage.isValidNow()) {
            Bitmap bitmap = null;
            if (this.mCurrentDefaultId > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                        bitmap = SkinManager.getBitmap(this.mCurrentDefaultId);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.mCurrentDefaultId);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.mCurrentDefaultId);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.mCurrentDefaultId);
                }
            }
            BdImage bdImage2 = new BdImage(bitmap, false, String.valueOf(this.mCurrentDefaultId));
            sDefaultBdImageCache.put(str, new SoftReference<>(bdImage2));
            return bdImage2;
        }
        return bdImage;
    }

    public void startLoad(String str, int i, boolean z) {
        BdUniqueId bdUniqueId = null;
        boolean z2 = false;
        IScrollable iScrollable = IScrollableHelper.getIScrollable(getContext());
        if (iScrollable != null) {
            BdUniqueId uniqueId = this.mPageId != null ? this.mPageId : iScrollable.getUniqueId();
            z2 = iScrollable.isScroll();
            bdUniqueId = uniqueId;
        }
        internalStartLoad(str, i, z, bdUniqueId, z2);
    }

    public void startLoad(String str, int i, boolean z, boolean z2) {
        BdUniqueId bdUniqueId = null;
        IScrollable iScrollable = IScrollableHelper.getIScrollable(getContext());
        if (iScrollable != null) {
            bdUniqueId = this.mPageId != null ? this.mPageId : iScrollable.getUniqueId();
        }
        internalStartLoad(str, i, z, bdUniqueId, z2);
    }

    private void internalStartLoad(String str, int i, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        this.mDefaultIdInUse = this.mDefaultId;
        if (TextUtils.isEmpty(str)) {
            this.mDefaultIdInUse = this.mDefaultErrorId;
            this.mUrl = str;
            return;
        }
        boolean z3 = BdResourceLoader.getInstance().generateAddress(str, i).equals(this.mUrl) && i == this.mType && bdUniqueId == this.mPageId;
        if (!z3) {
            this.mCurUsedBdImage = null;
            invalidate();
            stopLoad();
            this.mNeedRecomputeMatrix = true;
            this.mIsGif = false;
            requestLayout();
        } else if (getBdImage() != null) {
            invalidate();
            if (this.mEvent != null) {
                this.mEvent.onComplete(str, true);
                return;
            }
            return;
        }
        this.mUrl = BdResourceLoader.getInstance().generateAddress(str, i);
        this.mType = i;
        this.mPageId = bdUniqueId;
        this.mNeedRecomputeMatrix = true;
        if (z2) {
            invalidate();
        } else if (this.mSupportNoImage) {
            invalidate();
        } else if (z3 && !BdNetTypeUtil.isNetWorkAvailable()) {
            this.mDefaultIdInUse = this.mDefaultErrorId;
            invalidate();
            if (this.mEvent != null) {
                this.mEvent.onComplete(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.requestTime = System.currentTimeMillis();
            realLoadBitmap(str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realLoadBitmap(String str, int i) {
        BdResourceLoader.getInstance().loadResource(str, i, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
            public void onLoaded(BdImage bdImage, String str2, int i2) {
                if (bdImage != null) {
                    TbImageView.this.mLoadedWidth = bdImage.getWidth();
                    TbImageView.this.mLoadedHeight = bdImage.getHeight();
                }
                if (TbImageView.this.mUrl != null && TbImageView.this.mUrl.equals(str2)) {
                    TbImageView.this.mCurUsedBdImage = bdImage;
                }
                TbImageView.this.stopLoading();
                if (bdImage == null) {
                    TbImageView.this.mDefaultIdInUse = TbImageView.this.mDefaultErrorId;
                }
                if (TbImageView.this.mEvent != null) {
                    TbImageView.this.mEvent.onComplete(str2, bdImage != null);
                }
                TbImageView.this.startLogPerf();
            }
        }, null);
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            BdResourceLoader.getInstance().cancelLoad(this.mUrl, this.mType, null);
            stopLoading();
        }
    }

    public void startLoadWithoutScroll(String str, int i, boolean z) {
        startLoadWithoutScroll(str, i, 0, 0, z);
    }

    public void startLoadWithoutScroll(String str, int i, int i2, int i3, boolean z) {
        IScrollable iScrollable = IScrollableHelper.getIScrollable(getContext());
        if (iScrollable != null) {
            iScrollable.getUniqueId();
        }
        this.mUrl = BdResourceLoader.getInstance().generateAddress(str, i);
        realLoadBitmap(str, i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        IScrollableHelper.getBbPageContext(getContext());
        if (this.mPageId != null) {
            this.isPageIdRegisterMessage = true;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isPageIdRegisterMessage = false;
        stopLoad();
        if (this.mCurUsedBdImage != null) {
            this.mCurUsedBdImage.reset();
            this.mCurUsedBdImage = null;
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        stopLoad();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            stopLoad();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.newwidget.imageview.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        updateNight();
        notifiyOnDrawListener(true, canvas);
        super.onDraw(canvas);
        notifiyOnDrawListener(false, canvas);
    }

    private void notifiyOnDrawListener(boolean z, Canvas canvas) {
        if (this.mOnDrawListener != null) {
            if (z) {
                this.mOnDrawListener.onBeforeDraw(this, canvas);
            } else {
                this.mOnDrawListener.onAfterDraw(this, canvas);
            }
        }
    }

    @Override // com.baidu.live.adp.newwidget.imageview.BDImageView
    public void drawContentTag(Canvas canvas, ImageView imageView) {
        super.drawContentTag(canvas, imageView);
        if (this.mTagDrawer != null && this.mArgs != null) {
            if (this.mArgs.mIsShowGifIcon && isGif()) {
                this.mTagDrawer.drawBottomRightTag(canvas, getContext().getString(a.i.sdk_icon_tag_gif));
            } else if (this.mArgs.mIsShowLongIcon && isLongPic()) {
                this.mTagDrawer.drawBottomRightTag(canvas, getContext().getString(a.i.sdk_icon_tag_long));
            } else if (this.mTagStr != null) {
                this.mTagDrawer.drawBottomRightTag(canvas, this.mTagStr);
            }
        }
    }

    public void setTagDrawerExtraWH(int i, int i2) {
        if (this.mTagDrawer != null) {
            this.mTagDrawer.setExtraWH(i, i2);
        }
    }

    public boolean isGif() {
        return this.mIsGif;
    }

    public boolean isLongPic() {
        return this.isLongPic;
    }

    public void setIsLongPic(boolean z) {
        this.isLongPic = z;
    }

    public void startLoading() {
        this.mShowLoading = true;
        nextLoadingFrame();
    }

    public void stopLoading() {
        this.mShowLoading = false;
        removeCallbacks(this);
        this.mCurrentDegrees = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void nextLoadingFrame() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mShowLoading) {
            this.mCurrentDegrees += this.mLoadingFrameIncrement;
            if (this.mCurrentDegrees > 360.0f - this.mLoadingFrameIncrement) {
                this.mCurrentDegrees = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.mCurrentDegrees, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            nextLoadingFrame();
        }
    }

    private void updateNight() {
        if (this.mAutoChangeStyle) {
            this.mArgs.mIsNight = TbadkCoreApplication.getInst().getSkinType() == 1;
        } else {
            this.mArgs.mIsNight = false;
        }
        int i = this.mCurrentDefaultId;
        int i2 = this.mShowLoading ? this.mLoadingDefaultId : this.mDefaultId;
        if (i2 != this.mCurrentDefaultId) {
            this.mCurrentDefaultId = i2;
            this.mNeedRecomputeMatrix = true;
        }
        this.mCurrentDefaultBgId = this.mDefaultBgId;
        if (this.mCurrentDefaultBgId > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(SkinManager.getDrawable(this.mCurrentDefaultBgId));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.mCurrentDefaultBgId));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.mDefaultId != i) {
            this.mDefaultId = i;
            this.mDefaultIdInUse = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.mDefaultErrorId = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.mDefaultBgId != i) {
            this.mDefaultBgId = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public String getUrl() {
        return this.mUrl;
    }

    @Override // com.baidu.live.adp.newwidget.imageview.IRefresh
    public void refresh() {
        if (!TextUtils.isEmpty(this.mUrl) && this.mCurUsedBdImage == null) {
            realLoadBitmap(this.mUrl, this.mType);
            invalidate();
        }
    }

    public void reset() {
        setTag(null);
        this.mUrl = null;
        this.mIsGif = false;
        this.isLongPic = false;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnTouchListener(this.mInternalGestureDetector);
        if (!isClickable()) {
            setClickable(true);
        }
        this.mOnClickListener = onClickListener;
    }

    public void setTbGestureDetector(com.baidu.live.tieba.pb.a.a aVar) {
        super.setOnTouchListener(this.mInternalGestureDetector);
        this.mGestureDetector = aVar;
    }

    public void setInterceptOnClick(boolean z) {
        this.mInterceptOnClick = z;
    }

    public View.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.mInterceptOnClick) {
            startLoading();
            realLoadBitmap(this.mUrl, this.mType);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.mTagDrawer != null) {
            return (int) this.mTagDrawer.getTagWidth(getContext().getString(a.i.sdk_icon_tag_gif));
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.mTagDrawer != null) {
            return (int) this.mTagDrawer.getTagHeight(getContext().getString(a.i.sdk_icon_tag_gif));
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.mSupportNoImage = z;
    }

    public void startLogPerf() {
        if (!this.canLogPerf) {
            this.canLogPerf = true;
        }
    }

    @Override // com.baidu.live.adp.newwidget.imageview.BDImageView
    public void setDrawBorder(boolean z) {
        super.setDrawBorder(z);
    }

    public void setTagPaddingDis(int i, int i2) {
        if (this.mTagDrawer != null) {
            this.mTagDrawer.setTagPaddingDis(i, i2);
        }
    }

    public void setTagTextSize(int i) {
        if (this.mTagDrawer != null) {
            this.mTagDrawer.setTagTextSize(i);
        }
    }

    public void setTagStr(String str) {
        this.mTagStr = str;
    }

    public void setTagColor(int i) {
        if (this.mTagDrawer != null) {
            this.mTagDrawer.setTagTextColor(i);
        }
    }

    public static String getUrlWithResizeTag(String str, int i, int i2) {
        if (!TextUtils.isEmpty(str) && i > 0 && i2 > 0 && !str.startsWith("@resize")) {
            if (str.contains("@resize")) {
                str = str.substring(0, str.indexOf("@resize"));
            }
            return str + String.format("@resize{w:%s,h:%s}", Integer.valueOf(i), Integer.valueOf(i2));
        }
        return str;
    }

    public static int[] parseResizeFromUrlTag(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("@resize")) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str.substring(str.indexOf("{"), str.indexOf("}") + 1));
            return new int[]{jSONObject.optInt("w"), jSONObject.optInt("h")};
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
