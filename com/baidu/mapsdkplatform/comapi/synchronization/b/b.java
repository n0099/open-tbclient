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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "b";
    public static com.baidu.mapsdkplatform.comapi.synchronization.c.a b;
    public static OnHistoryTraceListener c;
    public static com.baidu.mapsdkplatform.comapi.synchronization.b.a e;
    public static int g;
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread d;
    public a f;
    public HandlerThread h;
    public e i;
    public volatile boolean j;

    /* loaded from: classes2.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public void a(int i, String str, int i2, HistoryTraceQueryOptions historyTraceQueryOptions) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), historyTraceQueryOptions}) == null) {
                if (b.e == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.a, "Data parser handler is null");
                    return;
                }
                Message obtainMessage = b.e.obtainMessage();
                obtainMessage.what = i;
                obtainMessage.arg1 = i2;
                obtainMessage.obj = str;
                b.e.sendMessage(obtainMessage);
                b.e.a(historyTraceQueryOptions);
            }
        }

        private void a(HistoryTraceQueryOptions historyTraceQueryOptions, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65539, this, historyTraceQueryOptions, i) == null) {
                String a = a(historyTraceQueryOptions);
                if (TextUtils.isEmpty(a)) {
                    b.b(10002, "QueryOptions is null, please check.", i);
                } else {
                    a(a, i, historyTraceQueryOptions);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c.a aVar, int i) {
            int i2;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65543, this, aVar, i) == null) {
                int i3 = c.a[aVar.ordinal()];
                if (i3 == 1) {
                    i2 = 0;
                    str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS;
                } else if (i3 == 2 || i3 == 3) {
                    i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_SERVER_INNER_ERROR;
                    str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SERVER_INNER_ERROR;
                } else if (i3 == 4) {
                    i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_NETWORK_ERROR;
                    str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_NETWORK_ERROR;
                } else if (i3 != 5) {
                    i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_UNDEFINE_ERROR;
                    str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_UNDEFINE_ERROR;
                } else {
                    i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_REQUEST_PARAMETER_ERROR;
                    str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_REQUEST_PARAMETER_ERROR;
                }
                b.b(i2, str, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, int i, HistoryTraceQueryOptions historyTraceQueryOptions) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(65544, this, str, i, historyTraceQueryOptions) == null) {
                if (TextUtils.isEmpty(str)) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.a, "Request url is null");
                    return;
                }
                if (b.b == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.c.a unused = b.b = new com.baidu.mapsdkplatform.comapi.synchronization.c.a();
                }
                b.b.a(str, new d(this, i, historyTraceQueryOptions, str));
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                String str = b.a;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The query type is: " + i);
                HistoryTraceQueryOptions historyTraceQueryOptions = (HistoryTraceQueryOptions) message.obj;
                if (i != 1) {
                    return;
                }
                a(historyTraceQueryOptions, i);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = false;
        b = new com.baidu.mapsdkplatform.comapi.synchronization.c.a();
        this.f = new a();
        HandlerThread handlerThread = new HandlerThread("HistoryTraceDataParser");
        this.d = handlerThread;
        handlerThread.start();
        com.baidu.mapsdkplatform.comapi.synchronization.b.a aVar = new com.baidu.mapsdkplatform.comapi.synchronization.b.a(this.d.getLooper());
        e = aVar;
        aVar.a(this.f);
        HandlerThread handlerThread2 = new HandlerThread("HistoryTraceRender");
        this.h = handlerThread2;
        handlerThread2.start();
        this.i = new e(this.h.getLooper());
    }

    private void a(HistoryTraceData historyTraceData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, this, historyTraceData, i) == null) {
            if (this.i == null) {
                this.i = new e(this.h.getLooper());
            }
            Message obtainMessage = this.i.obtainMessage();
            obtainMessage.what = i;
            if (historyTraceData != null) {
                obtainMessage.obj = historyTraceData;
            }
            this.i.sendMessage(obtainMessage);
        }
    }

    private boolean a(HistoryTraceQueryOptions historyTraceQueryOptions, int i) {
        InterceptResult invokeLI;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, this, historyTraceQueryOptions, i)) == null) {
            if (historyTraceQueryOptions == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "QueryOptions is null, please check!");
                i2 = 10001;
                str = "QueryOptions is null, please check.";
            } else if (TextUtils.isEmpty(historyTraceQueryOptions.getOrderId())) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Query orderId is null, please check");
                i2 = 10003;
                str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_ORDER_ID_NULL;
            } else if (historyTraceQueryOptions.getRoleType() != 0) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Current role type not the passenger");
                i2 = 10004;
                str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_ROLE_TYPE_ERROR;
            } else if (TextUtils.isEmpty(historyTraceQueryOptions.getUserId())) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Order's user id is null");
                i2 = 10005;
                str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_USER_ID_NULL;
            } else if (!TextUtils.isEmpty(historyTraceQueryOptions.getDriverId())) {
                return true;
            } else {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Driver id is null");
                i2 = 10006;
                str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_DRIVER_ID_NULL;
            }
            b(i2, str, i);
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static void b(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            OnHistoryTraceListener onHistoryTraceListener = c;
            if (onHistoryTraceListener == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "OnHistoryTraceListener is null");
            } else if (i2 == 1) {
                onHistoryTraceListener.onQueryHistroyTraceData(i, str, null);
            } else if (i2 != 2) {
            } else {
                onHistoryTraceListener.onRenderHistroyTrace(i, str);
            }
        }
    }

    private void b(HistoryTraceQueryOptions historyTraceQueryOptions, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, this, historyTraceQueryOptions, i) == null) {
            if (this.f == null) {
                this.f = new a();
            }
            Message obtainMessage = this.f.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.obj = historyTraceQueryOptions;
            this.f.sendMessage(obtainMessage);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (b != null) {
                b = null;
            }
            if (c != null) {
                c = null;
            }
            a aVar = this.f;
            if (aVar != null) {
                aVar.removeCallbacksAndMessages(null);
                this.f = null;
            }
            com.baidu.mapsdkplatform.comapi.synchronization.b.a aVar2 = e;
            if (aVar2 != null) {
                aVar2.removeCallbacksAndMessages(null);
                e.a();
                e = null;
            }
            HandlerThread handlerThread = this.d;
            if (handlerThread != null) {
                handlerThread.quit();
                this.d = null;
            }
            e eVar = this.i;
            if (eVar != null) {
                eVar.removeCallbacksAndMessages(null);
                this.i.a();
                this.i = null;
            }
            HandlerThread handlerThread2 = this.h;
            if (handlerThread2 != null) {
                handlerThread2.quit();
                this.h = null;
            }
            this.j = false;
        }
    }

    public void a(BaiduMap baiduMap, HistoryTraceData historyTraceData, HistoryTraceDisplayOptions historyTraceDisplayOptions, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baiduMap, historyTraceData, historyTraceDisplayOptions, i) == null) {
            if (baiduMap == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "BaiduMap instance is null");
                OnHistoryTraceListener onHistoryTraceListener = c;
                if (onHistoryTraceListener != null) {
                    onHistoryTraceListener.onRenderHistroyTrace(10007, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_BAIDUMAP_NULL);
                }
            } else if (5 == i) {
                this.i.a(historyTraceDisplayOptions, baiduMap, i);
                a(historyTraceData, 4);
            } else {
                OnHistoryTraceListener onHistoryTraceListener2 = c;
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
            c = onHistoryTraceListener;
            e.a(onHistoryTraceListener);
            this.i.a(onHistoryTraceListener);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.c.c.b = z;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? com.baidu.mapsdkplatform.comapi.synchronization.c.c.b : invokeV.booleanValue;
    }
}
