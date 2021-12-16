package com.baidu.livesdk.sdk;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class LiveSDK {
    public static /* synthetic */ Interceptable $ic;
    public static volatile LiveSDK mSDK;
    public transient /* synthetic */ FieldHolder $fh;
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
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context.getApplicationContext();
    }

    public static LiveSDK getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (mSDK == null) {
                synchronized (LiveSDK.class) {
                    if (mSDK == null) {
                        mSDK = new LiveSDK(context);
                    }
                }
            }
            return mSDK;
        }
        return (LiveSDK) invokeL.objValue;
    }

    public HttpRequestManager createHttpManager() throws IllegalAccessException, InstantiationException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mHttpRequestManagerClass.newInstance() : (HttpRequestManager) invokeV.objValue;
    }

    public Account getAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAccount : (Account) invokeV.objValue;
    }

    public DownloadManager getDownloadManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDownloadManager : (DownloadManager) invokeV.objValue;
    }

    public Home getHome() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mHome : (Home) invokeV.objValue;
    }

    public ImageLoader getImageLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mImageLoader : (ImageLoader) invokeV.objValue;
    }

    public LikeRequest getLikeRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mLikeRequest : (LikeRequest) invokeV.objValue;
    }

    public LikeView getLikeView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mLikeView : (LikeView) invokeV.objValue;
    }

    public LiveDataRequest getLiveDataRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mLiveDataRequest : (LiveDataRequest) invokeV.objValue;
    }

    public LiveIM getLiveIM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mLiveIM : (LiveIM) invokeV.objValue;
    }

    public LiveSDKParams getLiveSDKParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mLiveSDKParams : (LiveSDKParams) invokeV.objValue;
    }

    public LoadingView getLoadingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mLoadingView : (LoadingView) invokeV.objValue;
    }

    public Pay getPay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mPay : (Pay) invokeV.objValue;
    }

    public Player getPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mPlayer : (Player) invokeV.objValue;
    }

    public PlayerBuilder getPlayerBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.playerBuilder : (PlayerBuilder) invokeV.objValue;
    }

    public Scheme getScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mScheme : (Scheme) invokeV.objValue;
    }

    public Share getShare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mShare : (Share) invokeV.objValue;
    }

    public Tab getTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mTab : (Tab) invokeV.objValue;
    }

    public UniversalToast getToast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mToast : (UniversalToast) invokeV.objValue;
    }

    public Ubc getmUbc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mUbc : (Ubc) invokeV.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
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

    public void setAccount(Account account) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, account) == null) {
            this.mAccount = account;
        }
    }

    public void setDownloadManager(DownloadManager downloadManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, downloadManager) == null) {
            this.mDownloadManager = downloadManager;
        }
    }

    public void setHome(Home home) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, home) == null) {
            this.mHome = home;
        }
    }

    public void setImageLoader(ImageLoader imageLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, imageLoader) == null) {
            this.mImageLoader = imageLoader;
        }
    }

    public void setLikeRequest(LikeRequest likeRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, likeRequest) == null) {
            this.mLikeRequest = likeRequest;
        }
    }

    public void setLikeView(LikeView likeView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, likeView) == null) {
            this.mLikeView = likeView;
        }
    }

    public void setLiveDataRequest(LiveDataRequest liveDataRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, liveDataRequest) == null) {
            this.mLiveDataRequest = liveDataRequest;
        }
    }

    public void setLiveIM(LiveIM liveIM) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, liveIM) == null) {
            this.mLiveIM = liveIM;
        }
    }

    public void setLiveSDKParams(LiveSDKParams liveSDKParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, liveSDKParams) == null) {
            this.mLiveSDKParams = liveSDKParams;
        }
    }

    public void setLoadingView(LoadingView loadingView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, loadingView) == null) {
            this.mLoadingView = loadingView;
        }
    }

    public void setPay(Pay pay) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, pay) == null) {
            this.mPay = pay;
        }
    }

    public void setPlayer(Player player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, player) == null) {
            this.mPlayer = player;
        }
    }

    public void setPlayerBuilder(PlayerBuilder playerBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, playerBuilder) == null) {
            this.playerBuilder = playerBuilder;
        }
    }

    public void setRequest(Class<? extends HttpRequestManager> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, cls) == null) {
            this.mHttpRequestManagerClass = cls;
        }
    }

    public void setScheme(Scheme scheme) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, scheme) == null) {
            this.mScheme = scheme;
        }
    }

    public void setShare(Share share) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, share) == null) {
            this.mShare = share;
        }
    }

    public void setTab(Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, tab) == null) {
            this.mTab = tab;
        }
    }

    public void setToast(UniversalToast universalToast) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, universalToast) == null) {
            this.mToast = universalToast;
        }
    }

    public void setmUbc(Ubc ubc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, ubc) == null) {
            this.mUbc = ubc;
        }
    }
}
