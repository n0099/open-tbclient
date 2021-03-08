package com.baidu.mobads.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobad.feeds.XAdNativeResponse;
import com.baidu.mobads.g.b;
import com.baidu.mobads.r;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.d;
import dalvik.system.DexClassLoader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes4.dex */
public class FeedPortraitVideoView extends RelativeLayout implements View.OnClickListener {
    private static final int COVER_PIC_ID = 17;
    private static final int LOADING_VIEW_ID = 18;
    private static final int PAUSE_ID = 16;
    private static final String PLAY_END = "playCompletion";
    private static final String PLAY_ERROR = "playError";
    private static final String PLAY_ICON_STRING = "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\n";
    private static final String PLAY_PAUSE = "playPause";
    private static final String PLAY_RESUME = "playResume";
    private static final String PLAY_START = "playRenderingStart";
    private static final String TAG = "FeedPortraitVideoView";
    private View mAdView;
    private boolean mCanShowCoverPic;
    private boolean mCanVideoClick;
    private ImageView mCoverPic;
    private NativeResponse mCurrentItem;
    private IFeedPortraitListener mFeedVideoListener;
    private boolean mIsVideoFirstPlay;
    private DexClassLoader mLoader;
    private View mLoadingView;
    private ImageView mPauseBtn;
    private IPortraitVideoViewClickListener mPortraitViewClickListener;
    private String mRemoteClassName;
    private Context mViewContext;

    /* loaded from: classes4.dex */
    public interface IPortraitVideoViewClickListener {
        void onPortraitViewClick(FeedPortraitVideoView feedPortraitVideoView);
    }

    public FeedPortraitVideoView(Context context) {
        super(context);
        this.mCanVideoClick = false;
        this.mIsVideoFirstPlay = true;
        this.mCanShowCoverPic = true;
        this.mRemoteClassName = "KsFUVkW3hvh15S0DYx76RpROGGQW+8runZ3lnHDrYi9hfV1Uns7ZF3eKbMRKGO2s";
        init(context);
    }

    public FeedPortraitVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCanVideoClick = false;
        this.mIsVideoFirstPlay = true;
        this.mCanShowCoverPic = true;
        this.mRemoteClassName = "KsFUVkW3hvh15S0DYx76RpROGGQW+8runZ3lnHDrYi9hfV1Uns7ZF3eKbMRKGO2s";
        init(context);
    }

    public FeedPortraitVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCanVideoClick = false;
        this.mIsVideoFirstPlay = true;
        this.mCanShowCoverPic = true;
        this.mRemoteClassName = "KsFUVkW3hvh15S0DYx76RpROGGQW+8runZ3lnHDrYi9hfV1Uns7ZF3eKbMRKGO2s";
        init(context);
    }

    private void init(Context context) {
        this.mViewContext = context;
        Class[] clsArr = {Context.class};
        Object[] objArr = {this.mViewContext};
        this.mLoader = b.d();
        if (this.mLoader == null) {
            this.mLoader = r.a(this.mViewContext);
        }
        this.mAdView = (View) r.a(d.a(this.mRemoteClassName), this.mLoader, clsArr, objArr);
        if (this.mAdView != null) {
            addView(this.mAdView, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void setFeedPortraitListener(IFeedPortraitListener iFeedPortraitListener) {
        this.mFeedVideoListener = iFeedPortraitListener;
        try {
            Class<?> a2 = r.a("com.component.feed.IFeedPortraitListener", this.mLoader);
            Object newProxyInstance = Proxy.newProxyInstance(a2.getClassLoader(), new Class[]{a2}, new a());
            if (this.mAdView != null) {
                r.a(d.a(this.mRemoteClassName), this.mAdView, this.mLoader, "setFeedPortraitListener", new Class[]{a2}, newProxyInstance);
            }
        } catch (Throwable th) {
        }
    }

    public void setAdData(XAdNativeResponse xAdNativeResponse) {
        if (xAdNativeResponse != null) {
            this.mCurrentItem = xAdNativeResponse;
            if (this.mAdView != null) {
                r.a(d.a(this.mRemoteClassName), this.mAdView, this.mLoader, "setAdData", new Class[]{Object.class}, xAdNativeResponse);
            }
            showNormalPic(xAdNativeResponse);
            this.mIsVideoFirstPlay = true;
            if (this.mCanShowCoverPic) {
                showView(xAdNativeResponse);
            }
        }
    }

    public void setCanShowCoverImage(boolean z) {
        this.mCanShowCoverPic = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showNormalPic(XAdNativeResponse xAdNativeResponse) {
        if (xAdNativeResponse != null) {
            this.mCurrentItem = xAdNativeResponse;
            if (this.mAdView != null) {
                r.a(d.a(this.mRemoteClassName), this.mAdView, this.mLoader, "showNormalPic", new Class[]{Object.class}, xAdNativeResponse);
            }
        }
    }

    public void play() {
        if (this.mIsVideoFirstPlay) {
            hidePauseBtn();
        }
        if (this.mAdView != null) {
            r.a(d.a(this.mRemoteClassName), this.mAdView, this.mLoader, AlaStaticKeys.ALA_STATIC_VALUE_PLAY, new Class[0], new Object[0]);
        }
    }

    public void pause() {
        if (this.mAdView != null) {
            r.a(d.a(this.mRemoteClassName), this.mAdView, this.mLoader, "pause", new Class[0], new Object[0]);
        }
    }

    public void resume() {
        if (this.mAdView != null) {
            r.a(d.a(this.mRemoteClassName), this.mAdView, this.mLoader, "resume", new Class[0], new Object[0]);
        }
    }

    public void stop() {
        if (this.mAdView != null) {
            r.a(d.a(this.mRemoteClassName), this.mAdView, this.mLoader, "stop", new Class[0], new Object[0]);
        }
        handleCover();
    }

    public void setVideoMute(boolean z) {
        if (this.mAdView != null) {
            r.a(d.a(this.mRemoteClassName), this.mAdView, this.mLoader, "setVideoMute", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public boolean isPlaying() {
        if (this.mAdView != null) {
            return ((Boolean) r.a(d.a(this.mRemoteClassName), this.mAdView, this.mLoader, "isPlaying", new Class[0], new Object[0])).booleanValue();
        }
        return false;
    }

    public long getCurrentPosition() {
        if (this.mAdView != null) {
            return ((Long) r.a(d.a(this.mRemoteClassName), this.mAdView, this.mLoader, "getCurrentPosition", new Class[0], new Object[0])).longValue();
        }
        return 0L;
    }

    public long getDuration() {
        if (this.mAdView != null) {
            return ((Long) r.a(d.a(this.mRemoteClassName), this.mAdView, this.mLoader, "getDuration", new Class[0], new Object[0])).longValue();
        }
        return 0L;
    }

    public void setCanClickVideo(boolean z) {
        this.mCanVideoClick = z;
        if (this.mAdView != null) {
            r.a(d.a(this.mRemoteClassName), this.mAdView, this.mLoader, "setCanClickVideo", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public boolean isShowEndFrame() {
        if (this.mAdView != null) {
            return ((Boolean) r.a(d.a(this.mRemoteClassName), this.mAdView, this.mLoader, "isShowEndFrame", new Class[0], new Object[0])).booleanValue();
        }
        return false;
    }

    public void setShowProgress(boolean z) {
        if (this.mAdView != null) {
            r.a(d.a(this.mRemoteClassName), this.mAdView, this.mLoader, "setShowProgressBar", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setProgressBackgroundColor(int i) {
        if (this.mAdView != null) {
            r.a(d.a(this.mRemoteClassName), this.mAdView, this.mLoader, "setProgressBackgroundColor", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setProgressBarColor(int i) {
        if (this.mAdView != null) {
            r.a(d.a(this.mRemoteClassName), this.mAdView, this.mLoader, "setProgressBarColor", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setProgressHeightInDp(int i) {
        if (this.mAdView != null) {
            r.a(d.a(this.mRemoteClassName), this.mAdView, this.mLoader, "setProgressHeightDp", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setOnPortraitViewClickListener(IPortraitVideoViewClickListener iPortraitVideoViewClickListener) {
        this.mPortraitViewClickListener = iPortraitVideoViewClickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showView(NativeResponse nativeResponse) {
        this.mCurrentItem = nativeResponse;
        if (this.mCoverPic == null) {
            this.mCoverPic = new ImageView(getContext());
            this.mCoverPic.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.mCoverPic.setId(17);
            this.mCoverPic.setOnClickListener(this);
            addView(this.mCoverPic, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.mCoverPic != null && nativeResponse != null) {
            com.baidu.mobads.c.a.a().a(this.mCoverPic, nativeResponse.getImageUrl());
        }
        if (this.mPauseBtn == null) {
            this.mPauseBtn = new ImageView(getContext());
            this.mPauseBtn.setImageBitmap(XAdSDKFoundationFacade.getInstance().getBitmapUtils().string2bitmap(PLAY_ICON_STRING));
            this.mPauseBtn.setScaleType(ImageView.ScaleType.FIT_XY);
            this.mPauseBtn.setId(16);
            this.mPauseBtn.setOnClickListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(120, 120);
            layoutParams.addRule(13);
            addView(this.mPauseBtn, layoutParams);
        }
        if (this.mLoadingView == null) {
            this.mLoadingView = new ProgressBar(getContext());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            this.mLoadingView.setLayoutParams(layoutParams2);
            this.mLoadingView.setVisibility(4);
            addView(this.mLoadingView);
        }
        handleCover();
    }

    private void hidePauseBtn() {
        if (this.mPauseBtn != null) {
            this.mPauseBtn.setVisibility(4);
        }
        if (this.mCoverPic != null) {
            this.mCoverPic.setVisibility(0);
        }
        if (this.mLoadingView != null) {
            this.mLoadingView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCoverPic() {
        this.mIsVideoFirstPlay = false;
        if (this.mPauseBtn != null) {
            this.mPauseBtn.setVisibility(4);
        }
        if (this.mCoverPic != null) {
            this.mCoverPic.setVisibility(4);
        }
        if (this.mLoadingView != null) {
            this.mLoadingView.setVisibility(4);
        }
    }

    private void handleCover() {
        if (this.mCoverPic != null) {
            this.mCoverPic.setVisibility(0);
        }
        if (this.mPauseBtn != null) {
            this.mPauseBtn.setVisibility(0);
        }
        if (this.mLoadingView != null) {
            this.mLoadingView.setVisibility(4);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == 16 || view.getId() == 17) {
            if (this.mPortraitViewClickListener != null) {
                this.mPortraitViewClickListener.onPortraitViewClick(this);
            }
            if (!this.mCanVideoClick) {
                play();
            } else if (this.mCurrentItem != null && this.mCurrentItem.isDownloadApp()) {
                this.mCurrentItem.handleClick(this);
                play();
            } else if (this.mCurrentItem != null) {
                this.mCurrentItem.handleClick(this);
            }
        }
    }

    /* loaded from: classes4.dex */
    class a implements InvocationHandler {
        a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if (!TextUtils.isEmpty(name)) {
                if (name.equals(FeedPortraitVideoView.PLAY_END)) {
                    if (FeedPortraitVideoView.this.mFeedVideoListener != null) {
                        FeedPortraitVideoView.this.mFeedVideoListener.playCompletion();
                    }
                } else if (name.equals(FeedPortraitVideoView.PLAY_ERROR)) {
                    if (FeedPortraitVideoView.this.mFeedVideoListener != null) {
                        FeedPortraitVideoView.this.mFeedVideoListener.playError();
                    }
                } else if (name.equals(FeedPortraitVideoView.PLAY_START)) {
                    FeedPortraitVideoView.this.hideCoverPic();
                    if (FeedPortraitVideoView.this.mFeedVideoListener != null) {
                        FeedPortraitVideoView.this.mFeedVideoListener.playRenderingStart();
                    }
                } else if (name.equals(FeedPortraitVideoView.PLAY_PAUSE)) {
                    if (FeedPortraitVideoView.this.mPauseBtn != null) {
                        FeedPortraitVideoView.this.mPauseBtn.setVisibility(0);
                    }
                    if (FeedPortraitVideoView.this.mFeedVideoListener != null) {
                        FeedPortraitVideoView.this.mFeedVideoListener.playPause();
                    }
                } else if (name.equals(FeedPortraitVideoView.PLAY_RESUME)) {
                    if (FeedPortraitVideoView.this.mPauseBtn != null) {
                        FeedPortraitVideoView.this.mPauseBtn.setVisibility(4);
                    }
                    if (FeedPortraitVideoView.this.mFeedVideoListener != null) {
                        FeedPortraitVideoView.this.mFeedVideoListener.playResume();
                    }
                }
            }
            return null;
        }
    }
}
