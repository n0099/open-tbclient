package com.baidu.rtc;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.a.b.a;
import c.a.a.b.b;
import c.a.a.b.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes11.dex */
public class RTCLoadManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String JINGLE_LIB_NAME = "jingle_peerconnection_so";
    public static final String TAG = "BRTCLoadManager";
    public static RTCLoadManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public List<LoadListener> mCallbackList;
    public Context mContext;
    public ExecutorService mLoadServer;
    public LoadStatus mLoadStatus;
    public c mSoCallback;

    /* loaded from: classes11.dex */
    public interface LoadListener {
        void onLoadError(int i2, String str);

        void onLoadProgress(float f2);

        void onLoadSuccess();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class LoadStatus {
        public static final /* synthetic */ LoadStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LoadStatus IDLE;
        public static final LoadStatus LIBRARY_LOADING;
        public static final LoadStatus LOAD_COMPLETED;
        public static final LoadStatus LOAD_FAILED;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mValue;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2049870049, "Lcom/baidu/rtc/RTCLoadManager$LoadStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2049870049, "Lcom/baidu/rtc/RTCLoadManager$LoadStatus;");
                    return;
                }
            }
            IDLE = new LoadStatus("IDLE", 0, 0);
            LIBRARY_LOADING = new LoadStatus("LIBRARY_LOADING", 1, 1);
            LOAD_FAILED = new LoadStatus("LOAD_FAILED", 2, 2);
            LoadStatus loadStatus = new LoadStatus("LOAD_COMPLETED", 3, 3);
            LOAD_COMPLETED = loadStatus;
            $VALUES = new LoadStatus[]{IDLE, LIBRARY_LOADING, LOAD_FAILED, loadStatus};
        }

        public LoadStatus(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mValue = i3;
        }

        public static LoadStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LoadStatus) Enum.valueOf(LoadStatus.class, str) : (LoadStatus) invokeL.objValue;
        }

        public static LoadStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LoadStatus[]) $VALUES.clone() : (LoadStatus[]) invokeV.objValue;
        }
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
        this.mLoadStatus = LoadStatus.IDLE;
        this.mCallbackList = new ArrayList();
        this.mSoCallback = new c.a(this) { // from class: com.baidu.rtc.RTCLoadManager.2
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

            @Override // c.a.a.b.c
            public void onDownloadFail(String str, int i4, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, str, i4, str2) == null) {
                    String str3 = "Failed to download so :" + str2 + " / " + str;
                    this.this$0.mLoadStatus = LoadStatus.LOAD_FAILED;
                    this.this$0.callbackFail(i4, str2 + " / " + str);
                }
            }

            @Override // c.a.a.b.c.a, c.a.a.b.c
            public void onDownloadProgress(float f2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                    this.this$0.callbackProgress(f2);
                }
            }

            @Override // c.a.a.b.c
            public void onDownloadSuccess(String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                    String str3 = b.k(this.this$0.mContext) + File.separator + "libjingle_peerconnection_so.so";
                    String str4 = "RTC so path is: " + str3;
                    a.k(this.this$0.mContext).n(b.k(this.this$0.mContext));
                    try {
                        System.load(str3);
                        this.this$0.mLoadStatus = LoadStatus.LOAD_COMPLETED;
                        this.this$0.callbackSuccess();
                    } catch (Throwable th) {
                        String str5 = "Failed call System.load to load so! Error: " + th;
                        this.this$0.mLoadStatus = LoadStatus.LOAD_FAILED;
                        this.this$0.callbackFail(-1001, th.getMessage() + " / " + str);
                    }
                }
            }
        };
        this.mContext = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackFail(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65542, this, i2, str) == null) || this.mCallbackList == null) {
            return;
        }
        for (int i3 = 0; i3 < this.mCallbackList.size(); i3++) {
            this.mCallbackList.get(i3).onLoadError(i2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackProgress(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(65543, this, f2) == null) || this.mCallbackList == null) {
            return;
        }
        for (int i2 = 0; i2 < this.mCallbackList.size(); i2++) {
            this.mCallbackList.get(i2).onLoadProgress(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackSuccess() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.mCallbackList == null) {
            return;
        }
        for (int i2 = 0; i2 < this.mCallbackList.size(); i2++) {
            this.mCallbackList.get(i2).onLoadSuccess();
        }
    }

    public static synchronized RTCLoadManager getInstance(Context context) {
        InterceptResult invokeL;
        RTCLoadManager rTCLoadManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
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

    public void clearCallback() {
        List<LoadListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (list = this.mCallbackList) == null || list.size() < 1) {
            return;
        }
        this.mCallbackList.clear();
    }

    public LoadStatus getLoadStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mLoadStatus : (LoadStatus) invokeV.objValue;
    }

    public synchronized boolean isLoadCompleted() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                z = this.mLoadStatus == LoadStatus.LOAD_COMPLETED;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void loadLibraries(String str, LoadListener loadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, loadListener) == null) {
            loadLibraries(null, str, loadListener);
        }
    }

    public void registerCallback(LoadListener loadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, loadListener) == null) || loadListener == null) {
            return;
        }
        List<LoadListener> list = this.mCallbackList;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            this.mCallbackList = arrayList;
            arrayList.add(loadListener);
        } else if (list.contains(loadListener)) {
        } else {
            this.mCallbackList.add(loadListener);
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            clearCallback();
            a.k(this.mContext).o();
            ExecutorService executorService = this.mLoadServer;
            if (executorService != null) {
                executorService.shutdown();
                this.mLoadServer = null;
            }
            this.mLoadStatus = LoadStatus.IDLE;
            sInstance = null;
        }
    }

    public void setupSoLaterLoad(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            String str3 = "setup so later loading feature cpu type: " + str2;
            a.k(this.mContext).p(str2);
            if (TextUtils.isEmpty(str)) {
                a.k(this.mContext).j(b.j(), true, this.mSoCallback);
                return;
            }
            String str4 = "setup so later load url: " + str;
            a.k(this.mContext).j(str, true, this.mSoCallback);
        }
    }

    public void unregisterCallback(LoadListener loadListener) {
        List<LoadListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, loadListener) == null) || (list = this.mCallbackList) == null || list.size() < 1) {
            return;
        }
        this.mCallbackList.remove(loadListener);
    }

    public synchronized void loadLibraries(String str, String str2, LoadListener loadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, loadListener) == null) {
            synchronized (this) {
                registerCallback(loadListener);
                if (this.mLoadStatus == LoadStatus.IDLE || this.mLoadStatus == LoadStatus.LOAD_FAILED) {
                    this.mLoadStatus = LoadStatus.LIBRARY_LOADING;
                    try {
                        System.loadLibrary(JINGLE_LIB_NAME);
                        this.mLoadStatus = LoadStatus.LOAD_COMPLETED;
                        callbackSuccess();
                    } catch (UnsatisfiedLinkError e2) {
                        String str3 = "Load default so fail " + e2.getMessage();
                        if (this.mLoadServer == null || this.mLoadServer.isShutdown()) {
                            this.mLoadServer = Executors.newSingleThreadExecutor();
                        }
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
}
