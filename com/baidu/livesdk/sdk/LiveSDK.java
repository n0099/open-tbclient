package com.baidu.livesdk.sdk;

import android.content.Context;
import com.baidu.livesdk.api.account.Account;
import com.baidu.livesdk.api.http.HttpRequestManager;
import com.baidu.livesdk.api.http.download.DownloadManager;
import com.baidu.livesdk.api.im.live.LiveIM;
import com.baidu.livesdk.api.imageloader.ImageLoader;
import com.baidu.livesdk.api.pay.Pay;
import com.baidu.livesdk.api.player.Player;
import com.baidu.livesdk.api.player.PlayerBuilder;
import com.baidu.livesdk.api.service.Home;
import com.baidu.livesdk.api.service.LikeRequest;
import com.baidu.livesdk.api.service.LiveDataRequest;
import com.baidu.livesdk.api.service.Scheme;
import com.baidu.livesdk.api.service.Tab;
import com.baidu.livesdk.api.service.Ubc;
import com.baidu.livesdk.api.share.Share;
import com.baidu.livesdk.api.widget.LikeView;
import com.baidu.livesdk.api.widget.LoadingView;
import com.baidu.livesdk.api.widget.UniversalToast;
/* loaded from: classes3.dex */
public class LiveSDK {
    public static volatile LiveSDK mSDK;
    public Account mAccount;
    public Context mContext;
    public DownloadManager mDownloadManager;
    public Home mHome;
    public Class<? extends HttpRequestManager> mHttpRequestManagerClass;
    public ImageLoader mImageLoader;
    public LikeRequest mLikeRequest;
    public LikeView mLikeView;
    public LiveDataRequest mLiveDataRequest;
    public LiveIM mLiveIM;
    public LiveSDKParams mLiveSDKParams;
    public LoadingView mLoadingView;
    public Pay mPay;
    public Player mPlayer;
    public Scheme mScheme;
    public Share mShare;
    public Tab mTab;
    public UniversalToast mToast;
    public Ubc mUbc;
    public PlayerBuilder playerBuilder;

    public LiveSDK(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static LiveSDK getInstance(Context context) {
        if (mSDK == null) {
            synchronized (LiveSDK.class) {
                if (mSDK == null) {
                    mSDK = new LiveSDK(context);
                }
            }
        }
        return mSDK;
    }

    public void setAccount(Account account) {
        this.mAccount = account;
    }

    public void setDownloadManager(DownloadManager downloadManager) {
        this.mDownloadManager = downloadManager;
    }

    public void setHome(Home home) {
        this.mHome = home;
    }

    public void setImageLoader(ImageLoader imageLoader) {
        this.mImageLoader = imageLoader;
    }

    public void setLikeRequest(LikeRequest likeRequest) {
        this.mLikeRequest = likeRequest;
    }

    public void setLikeView(LikeView likeView) {
        this.mLikeView = likeView;
    }

    public void setLiveDataRequest(LiveDataRequest liveDataRequest) {
        this.mLiveDataRequest = liveDataRequest;
    }

    public void setLiveIM(LiveIM liveIM) {
        this.mLiveIM = liveIM;
    }

    public void setLiveSDKParams(LiveSDKParams liveSDKParams) {
        this.mLiveSDKParams = liveSDKParams;
    }

    public void setLoadingView(LoadingView loadingView) {
        this.mLoadingView = loadingView;
    }

    public void setPay(Pay pay) {
        this.mPay = pay;
    }

    public void setPlayer(Player player) {
        this.mPlayer = player;
    }

    public void setPlayerBuilder(PlayerBuilder playerBuilder) {
        this.playerBuilder = playerBuilder;
    }

    public void setRequest(Class<? extends HttpRequestManager> cls) {
        this.mHttpRequestManagerClass = cls;
    }

    public void setScheme(Scheme scheme) {
        this.mScheme = scheme;
    }

    public void setShare(Share share) {
        this.mShare = share;
    }

    public void setTab(Tab tab) {
        this.mTab = tab;
    }

    public void setToast(UniversalToast universalToast) {
        this.mToast = universalToast;
    }

    public void setmUbc(Ubc ubc) {
        this.mUbc = ubc;
    }

    public HttpRequestManager createHttpManager() throws IllegalAccessException, InstantiationException {
        return this.mHttpRequestManagerClass.newInstance();
    }

    public Account getAccount() {
        return this.mAccount;
    }

    public DownloadManager getDownloadManager() {
        return this.mDownloadManager;
    }

    public Home getHome() {
        return this.mHome;
    }

    public ImageLoader getImageLoader() {
        return this.mImageLoader;
    }

    public LikeRequest getLikeRequest() {
        return this.mLikeRequest;
    }

    public LikeView getLikeView() {
        return this.mLikeView;
    }

    public LiveDataRequest getLiveDataRequest() {
        return this.mLiveDataRequest;
    }

    public LiveIM getLiveIM() {
        return this.mLiveIM;
    }

    public LiveSDKParams getLiveSDKParams() {
        return this.mLiveSDKParams;
    }

    public LoadingView getLoadingView() {
        return this.mLoadingView;
    }

    public Pay getPay() {
        return this.mPay;
    }

    public Player getPlayer() {
        return this.mPlayer;
    }

    public PlayerBuilder getPlayerBuilder() {
        return this.playerBuilder;
    }

    public Scheme getScheme() {
        return this.mScheme;
    }

    public Share getShare() {
        return this.mShare;
    }

    public Tab getTab() {
        return this.mTab;
    }

    public UniversalToast getToast() {
        return this.mToast;
    }

    public Ubc getmUbc() {
        return this.mUbc;
    }

    public void release() {
        ImageLoader imageLoader = this.mImageLoader;
        if (imageLoader != null) {
            imageLoader.release();
        }
        Account account = this.mAccount;
        if (account != null) {
            account.clearAccountChangeListener();
        }
        Pay pay = this.mPay;
        if (pay != null) {
            pay.release();
        }
        Player player = this.mPlayer;
        if (player != null) {
            player.release();
        }
        LiveDataRequest liveDataRequest = this.mLiveDataRequest;
        if (liveDataRequest != null) {
            liveDataRequest.release();
        }
        Share share = this.mShare;
        if (share != null) {
            share.release();
        }
        LikeView likeView = this.mLikeView;
        if (likeView != null) {
            likeView.release();
        }
    }
}
