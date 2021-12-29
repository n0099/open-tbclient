package com.baidu.mapsdkplatform.comapi.synchronization.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceData;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceDisplayOptions;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapapi.synchronization.histroytrace.OnHistoryTraceListener;
import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "b";

    /* renamed from: b  reason: collision with root package name */
    public static com.baidu.mapsdkplatform.comapi.synchronization.c.a f37167b;

    /* renamed from: c  reason: collision with root package name */
    public static OnHistoryTraceListener f37168c;

    /* renamed from: e  reason: collision with root package name */
    public static com.baidu.mapsdkplatform.comapi.synchronization.b.a f37169e;

    /* renamed from: g  reason: collision with root package name */
    public static int f37170g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f37171d;

    /* renamed from: f  reason: collision with root package name */
    public a f37172f;

    /* renamed from: h  reason: collision with root package name */
    public HandlerThread f37173h;

    /* renamed from: i  reason: collision with root package name */
    public e f37174i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f37175j;

    /* loaded from: classes10.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        private String a(HistoryTraceQueryOptions historyTraceQueryOptions) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, historyTraceQueryOptions)) == null) {
                String a = new f(historyTraceQueryOptions).a();
                if (TextUtils.isEmpty(a)) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.a, "Build request url failed");
                    return null;
                }
                return a;
            }
            return (String) invokeL.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, String str, int i3, HistoryTraceQueryOptions historyTraceQueryOptions) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), historyTraceQueryOptions}) == null) {
                if (b.f37169e == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.a, "Data parser handler is null");
                    return;
                }
                Message obtainMessage = b.f37169e.obtainMessage();
                obtainMessage.what = i2;
                obtainMessage.arg1 = i3;
                obtainMessage.obj = str;
                b.f37169e.sendMessage(obtainMessage);
                b.f37169e.a(historyTraceQueryOptions);
            }
        }

        private void a(HistoryTraceQueryOptions historyTraceQueryOptions, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65539, this, historyTraceQueryOptions, i2) == null) {
                String a = a(historyTraceQueryOptions);
                if (TextUtils.isEmpty(a)) {
                    b.b(10002, "QueryOptions is null, please check.", i2);
                } else {
                    a(a, i2, historyTraceQueryOptions);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c.a aVar, int i2) {
            int i3;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65543, this, aVar, i2) == null) {
                int i4 = c.a[aVar.ordinal()];
                if (i4 == 1) {
                    i3 = 0;
                    str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS;
                } else if (i4 == 2 || i4 == 3) {
                    i3 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_SERVER_INNER_ERROR;
                    str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SERVER_INNER_ERROR;
                } else if (i4 == 4) {
                    i3 = 100010;
                    str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_NETWORK_ERROR;
                } else if (i4 != 5) {
                    i3 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_UNDEFINE_ERROR;
                    str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_UNDEFINE_ERROR;
                } else {
                    i3 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_REQUEST_PARAMETER_ERROR;
                    str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_REQUEST_PARAMETER_ERROR;
                }
                b.b(i3, str, i2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, int i2, HistoryTraceQueryOptions historyTraceQueryOptions) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(65544, this, str, i2, historyTraceQueryOptions) == null) {
                if (TextUtils.isEmpty(str)) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.a, "Request url is null");
                    return;
                }
                if (b.f37167b == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.c.a unused = b.f37167b = new com.baidu.mapsdkplatform.comapi.synchronization.c.a();
                }
                b.f37167b.a(str, new d(this, i2, historyTraceQueryOptions, str));
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                String str = b.a;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The query type is: " + i2);
                HistoryTraceQueryOptions historyTraceQueryOptions = (HistoryTraceQueryOptions) message.obj;
                if (i2 != 1) {
                    return;
                }
                a(historyTraceQueryOptions, i2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-879695141, "Lcom/baidu/mapsdkplatform/comapi/synchronization/b/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-879695141, "Lcom/baidu/mapsdkplatform/comapi/synchronization/b/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37175j = false;
        f37167b = new com.baidu.mapsdkplatform.comapi.synchronization.c.a();
        this.f37172f = new a();
        HandlerThread handlerThread = new HandlerThread("HistoryTraceDataParser");
        this.f37171d = handlerThread;
        handlerThread.start();
        com.baidu.mapsdkplatform.comapi.synchronization.b.a aVar = new com.baidu.mapsdkplatform.comapi.synchronization.b.a(this.f37171d.getLooper());
        f37169e = aVar;
        aVar.a(this.f37172f);
        HandlerThread handlerThread2 = new HandlerThread("HistoryTraceRender");
        this.f37173h = handlerThread2;
        handlerThread2.start();
        this.f37174i = new e(this.f37173h.getLooper());
    }

    private void a(HistoryTraceData historyTraceData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, this, historyTraceData, i2) == null) {
            if (this.f37174i == null) {
                this.f37174i = new e(this.f37173h.getLooper());
            }
            Message obtainMessage = this.f37174i.obtainMessage();
            obtainMessage.what = i2;
            if (historyTraceData != null) {
                obtainMessage.obj = historyTraceData;
            }
            this.f37174i.sendMessage(obtainMessage);
        }
    }

    private boolean a(HistoryTraceQueryOptions historyTraceQueryOptions, int i2) {
        InterceptResult invokeLI;
        int i3;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, this, historyTraceQueryOptions, i2)) == null) {
            if (historyTraceQueryOptions == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "QueryOptions is null, please check!");
                i3 = 10001;
                str = "QueryOptions is null, please check.";
            } else if (TextUtils.isEmpty(historyTraceQueryOptions.getOrderId())) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Query orderId is null, please check");
                i3 = 10003;
                str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_ORDER_ID_NULL;
            } else if (historyTraceQueryOptions.getRoleType() != 0) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Current role type not the passenger");
                i3 = 10004;
                str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_ROLE_TYPE_ERROR;
            } else if (TextUtils.isEmpty(historyTraceQueryOptions.getUserId())) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Order's user id is null");
                i3 = 10005;
                str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_USER_ID_NULL;
            } else if (!TextUtils.isEmpty(historyTraceQueryOptions.getDriverId())) {
                return true;
            } else {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Driver id is null");
                i3 = 10006;
                str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_DRIVER_ID_NULL;
            }
            b(i3, str, i2);
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static void b(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            OnHistoryTraceListener onHistoryTraceListener = f37168c;
            if (onHistoryTraceListener == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "OnHistoryTraceListener is null");
            } else if (i3 == 1) {
                onHistoryTraceListener.onQueryHistroyTraceData(i2, str, null);
            } else if (i3 != 2) {
            } else {
                onHistoryTraceListener.onRenderHistroyTrace(i2, str);
            }
        }
    }

    private void b(HistoryTraceQueryOptions historyTraceQueryOptions, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, this, historyTraceQueryOptions, i2) == null) {
            if (this.f37172f == null) {
                this.f37172f = new a();
            }
            Message obtainMessage = this.f37172f.obtainMessage();
            obtainMessage.what = i2;
            obtainMessage.obj = historyTraceQueryOptions;
            this.f37172f.sendMessage(obtainMessage);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (f37167b != null) {
                f37167b = null;
            }
            if (f37168c != null) {
                f37168c = null;
            }
            a aVar = this.f37172f;
            if (aVar != null) {
                aVar.removeCallbacksAndMessages(null);
                this.f37172f = null;
            }
            com.baidu.mapsdkplatform.comapi.synchronization.b.a aVar2 = f37169e;
            if (aVar2 != null) {
                aVar2.removeCallbacksAndMessages(null);
                f37169e.a();
                f37169e = null;
            }
            HandlerThread handlerThread = this.f37171d;
            if (handlerThread != null) {
                handlerThread.quit();
                this.f37171d = null;
            }
            e eVar = this.f37174i;
            if (eVar != null) {
                eVar.removeCallbacksAndMessages(null);
                this.f37174i.a();
                this.f37174i = null;
            }
            HandlerThread handlerThread2 = this.f37173h;
            if (handlerThread2 != null) {
                handlerThread2.quit();
                this.f37173h = null;
            }
            this.f37175j = false;
        }
    }

    public void a(BaiduMap baiduMap, HistoryTraceData historyTraceData, HistoryTraceDisplayOptions historyTraceDisplayOptions, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baiduMap, historyTraceData, historyTraceDisplayOptions, i2) == null) {
            if (baiduMap == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "BaiduMap instance is null");
                OnHistoryTraceListener onHistoryTraceListener = f37168c;
                if (onHistoryTraceListener != null) {
                    onHistoryTraceListener.onRenderHistroyTrace(10007, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_BAIDUMAP_NULL);
                }
            } else if (5 == i2) {
                this.f37174i.a(historyTraceDisplayOptions, baiduMap, i2);
                a(historyTraceData, 4);
            } else {
                OnHistoryTraceListener onHistoryTraceListener2 = f37168c;
                if (onHistoryTraceListener2 != null) {
                    onHistoryTraceListener2.onRenderHistroyTrace(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_CURRENT_ORDER_STATE_NOT_COMPLETE, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_CURRENT_ORDER_STATE_NOT_COMPLETE);
                }
            }
        }
    }

    public void a(HistoryTraceQueryOptions historyTraceQueryOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, historyTraceQueryOptions) == null) {
            if (a(historyTraceQueryOptions, 1)) {
                b(historyTraceQueryOptions, 1);
            } else {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "QueryOptions error, please check!");
            }
        }
    }

    public void a(OnHistoryTraceListener onHistoryTraceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onHistoryTraceListener) == null) {
            f37168c = onHistoryTraceListener;
            f37169e.a(onHistoryTraceListener);
            this.f37174i.a(onHistoryTraceListener);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.c.c.f37194b = z;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? com.baidu.mapsdkplatform.comapi.synchronization.c.c.f37194b : invokeV.booleanValue;
    }
}
