package com.baidu.android.imrtc.upload;

import android.content.Context;
import com.baidu.android.imrtc.utils.TaskManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Request;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class BIMRtcTrack {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.imrtc.upload.BIMRtcTrack$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1306376075, "Lcom/baidu/android/imrtc/upload/BIMRtcTrack$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1306376075, "Lcom/baidu/android/imrtc/upload/BIMRtcTrack$2;");
                    return;
                }
            }
            int[] iArr = new int[IMPushPb.ActionType.values().length];
            $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType = iArr;
            try {
                iArr[IMPushPb.ActionType.REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class RequestBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int REQUEST_BIM_RTC = 501210;
        public transient /* synthetic */ FieldHolder $fh;
        public Context context;
        public Request request;

        public RequestBuilder(Context context) {
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
            Request request = new Request();
            this.request = request;
            this.context = context;
            request.method = "";
            request.requestId = "";
            request.timestamp = -1L;
            request.responseTime = -1L;
            request.errorCode = -1L;
            request.ext = "";
            request.aliasId = -1L;
        }

        public RequestBuilder aliasId(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                this.request.aliasId = j;
                return this;
            }
            return (RequestBuilder) invokeJ.objValue;
        }

        public void build() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                BIMRtcTrack.reportTracker(this.context, IMPushPb.ActionType.REQUEST, this.request);
            }
        }

        public RequestBuilder errorCode(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                this.request.errorCode = j;
                return this;
            }
            return (RequestBuilder) invokeJ.objValue;
        }

        public RequestBuilder ext(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.request.ext = str;
                return this;
            }
            return (RequestBuilder) invokeL.objValue;
        }

        public RequestBuilder method(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.request.method = str;
                return this;
            }
            return (RequestBuilder) invokeL.objValue;
        }

        public RequestBuilder requestId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.request.requestId = str;
                return this;
            }
            return (RequestBuilder) invokeL.objValue;
        }

        public RequestBuilder requestTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                this.request.timestamp = j;
                return this;
            }
            return (RequestBuilder) invokeJ.objValue;
        }

        public RequestBuilder responseTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
                this.request.responseTime = j;
                return this;
            }
            return (RequestBuilder) invokeJ.objValue;
        }
    }

    public BIMRtcTrack() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void reportTracker(Context context, IMPushPb.ActionType actionType, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, actionType, obj) == null) {
            TaskManager.getInstance().submitForNetWork(new Runnable(actionType, context.getApplicationContext(), obj) { // from class: com.baidu.android.imrtc.upload.BIMRtcTrack.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IMPushPb.ActionType val$actionType;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ Object val$tracker;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {actionType, r7, obj};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$actionType = actionType;
                    this.val$context = r7;
                    this.val$tracker = obj;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (BIMRtcTrackDatabase.myLock) {
                            if (AnonymousClass2.$SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[this.val$actionType.ordinal()] == 1) {
                                BIMRtcTrackDatabase.getInstance(this.val$context).insertRequest((Request) this.val$tracker);
                            }
                        }
                    }
                }
            });
        }
    }
}
