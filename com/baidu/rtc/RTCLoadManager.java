package com.baidu.rtc;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudbase.plugin.DownSoHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.l.d.a;
import d.a.l.d.b;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class RTCLoadManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String JINGLE_LIB_NAME = "jingle_peerconnection_so";
    public static final String TAG = "BRTCLoadManager";
    public static RTCLoadManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context mContext;
    public boolean mIsLoadCompleted;
    public LoadListener mLoadListener;
    public ExecutorService mLoadServer;
    public b mSoCallback;

    /* loaded from: classes2.dex */
    public interface LoadListener {
        void onLoadError(int i2, String str);

        void onLoadProgress(float f2);

        void onLoadSuccess();
    }

    public RTCLoadManager(Context context) {
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
        this.mLoadServer = Executors.newSingleThreadExecutor();
        this.mIsLoadCompleted = false;
        this.mSoCallback = new b.a(this) { // from class: com.baidu.rtc.RTCLoadManager.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RTCLoadManager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // d.a.l.d.b
            public void onDownloadFail(String str, int i4, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, str, i4, str2) == null) {
                    Log.d(RTCLoadManager.TAG, "Failed to download so.");
                    this.this$0.mIsLoadCompleted = false;
                    if (this.this$0.mLoadListener != null) {
                        this.this$0.mLoadListener.onLoadError(i4, str2);
                    }
                }
            }

            @Override // d.a.l.d.b.a, d.a.l.d.b
            public void onDownloadProgress(float f2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) || this.this$0.mLoadListener == null) {
                    return;
                }
                this.this$0.mLoadListener.onLoadProgress(f2);
            }

            @Override // d.a.l.d.b
            public void onDownloadSuccess(String str, String str2) {
                LoadListener loadListener;
                int i4;
                String str3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                    Log.d(RTCLoadManager.TAG, "Be successful to download so!");
                    String str4 = a.k(this.this$0.mContext) + File.separator + "libjingle_peerconnection_so.so";
                    Log.d(RTCLoadManager.TAG, "RTC so path is: " + str4);
                    if (DownSoHelper.k(this.this$0.mContext).n(a.k(this.this$0.mContext))) {
                        try {
                            System.load(str4);
                            this.this$0.mIsLoadCompleted = true;
                            Log.d(RTCLoadManager.TAG, "loaded so, and start to login room.");
                            if (this.this$0.mLoadListener != null) {
                                this.this$0.mLoadListener.onLoadSuccess();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            Log.d(RTCLoadManager.TAG, "Failed call System.load to load so! Error: " + th);
                            this.this$0.mIsLoadCompleted = false;
                            if (this.this$0.mLoadListener == null) {
                                return;
                            }
                            loadListener = this.this$0.mLoadListener;
                            i4 = -1001;
                            str3 = "Failed call System.load to load so";
                        }
                    } else {
                        Log.d(RTCLoadManager.TAG, "call loadSo failed try call load Full Path.");
                        try {
                            System.load(str4);
                            this.this$0.mIsLoadCompleted = true;
                            Log.d(RTCLoadManager.TAG, "loaded so with full path, and start to login room.");
                            if (this.this$0.mLoadListener != null) {
                                this.this$0.mLoadListener.onLoadSuccess();
                                return;
                            }
                            return;
                        } catch (Throwable th2) {
                            Log.d(RTCLoadManager.TAG, "Failed to load so with full path! Error: " + th2);
                            this.this$0.mIsLoadCompleted = false;
                            if (this.this$0.mLoadListener == null) {
                                return;
                            }
                            loadListener = this.this$0.mLoadListener;
                            i4 = -1002;
                            str3 = "Failed to load so with full path";
                        }
                    }
                    loadListener.onLoadError(i4, str3);
                }
            }
        };
        this.mContext = context;
    }

    public static RTCLoadManager getInstance(Context context) {
        InterceptResult invokeL;
        RTCLoadManager rTCLoadManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            synchronized (RTCLoadManager.class) {
                if (sInstance == null) {
                    sInstance = new RTCLoadManager(context);
                }
                rTCLoadManager = sInstance;
            }
            return rTCLoadManager;
        }
        return (RTCLoadManager) invokeL.objValue;
    }

    public boolean isLoadCompleted() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                z = this.mIsLoadCompleted;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void loadLibraries(String str, String str2, LoadListener loadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, loadListener) == null) {
            synchronized (this) {
                this.mLoadListener = loadListener;
                if (!this.mIsLoadCompleted) {
                    try {
                        System.loadLibrary(JINGLE_LIB_NAME);
                        this.mIsLoadCompleted = true;
                        if (this.mLoadListener != null) {
                            this.mLoadListener.onLoadSuccess();
                        }
                        Log.d(TAG, "Loaded default so in aar");
                    } catch (UnsatisfiedLinkError e2) {
                        this.mIsLoadCompleted = false;
                        Log.d(TAG, "load default so fail " + e2.getMessage());
                        this.mLoadServer.submit(new Runnable(this, str, str2) { // from class: com.baidu.rtc.RTCLoadManager.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ RTCLoadManager this$0;
                            public final /* synthetic */ String val$cpuType;
                            public final /* synthetic */ String val$soLaterLoadUrl;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, str, str2};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$soLaterLoadUrl = str;
                                this.val$cpuType = str2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.this$0.setupSoLaterLoad(this.val$soLaterLoadUrl, this.val$cpuType);
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    public void release() {
        ExecutorService executorService;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (executorService = this.mLoadServer) == null) {
            return;
        }
        executorService.shutdown();
        this.mLoadServer = null;
    }

    public void setupSoLaterLoad(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            Log.d(TAG, "setup so later loading feature, and cpu type: " + str2);
            DownSoHelper.k(this.mContext).o(str2);
            if (TextUtils.isEmpty(str)) {
                DownSoHelper.k(this.mContext).j(a.j(), true, this.mSoCallback);
                return;
            }
            Log.d(TAG, "setup so later load url: " + str);
            DownSoHelper.k(this.mContext).j(str, true, this.mSoCallback);
        }
    }
}
