package com.baidu.mapsdkplatform.comapi.synchronization.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceData;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapapi.synchronization.histroytrace.OnHistoryTraceListener;
import com.baidu.mapsdkplatform.comapi.synchronization.b.b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;

    /* renamed from: b  reason: collision with root package name */
    public static OnHistoryTraceListener f26767b;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f26768h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public HistoryTraceData f26769c;

    /* renamed from: d  reason: collision with root package name */
    public List<HistoryTraceData.HistoryTracePoint> f26770d;

    /* renamed from: e  reason: collision with root package name */
    public b.a f26771e;

    /* renamed from: f  reason: collision with root package name */
    public HistoryTraceQueryOptions f26772f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26773g;
    public int i;
    public String j;
    public SparseArray<List<HistoryTraceData.HistoryTracePoint>> k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-879695172, "Lcom/baidu/mapsdkplatform/comapi/synchronization/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-879695172, "Lcom/baidu/mapsdkplatform/comapi/synchronization/b/a;");
                return;
            }
        }
        a = a.class.getSimpleName();
        f26768h = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f26773g = false;
        this.i = 0;
        this.j = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS;
        this.f26770d = new ArrayList();
        this.f26769c = new HistoryTraceData();
        this.k = new SparseArray<>();
    }

    private LatLng a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Coord string is null");
                return null;
            }
            String[] split = str.split(",");
            if (split.length == 0 || 2 != split.length) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Coord result is error");
                return null;
            }
            try {
                try {
                    return new LatLng(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
                } catch (NumberFormatException e2) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Parser coord latitude failed", e2);
                    return null;
                }
            } catch (NumberFormatException e3) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Parser coord longitude failed", e3);
                return null;
            }
        }
        return (LatLng) invokeL.objValue;
    }

    private List<HistoryTraceData.HistoryTracePoint> a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Request result not contain points info");
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    HistoryTraceData.HistoryTracePoint historyTracePoint = new HistoryTraceData.HistoryTracePoint();
                    historyTracePoint.setPoint(new LatLng(optJSONObject.optDouble("latitude"), optJSONObject.optDouble("longitude")));
                    historyTracePoint.setLocationTime(optJSONObject.optLong("loc_time"));
                    historyTracePoint.setCreateTime(optJSONObject.optString("create_time"));
                    arrayList.add(historyTracePoint);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    private void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i) == null) {
            if (this.f26771e == null) {
                this.f26771e = new b.a();
            }
            Message obtainMessage = this.f26771e.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.obj = this.f26772f;
            this.f26771e.sendMessage(obtainMessage);
        }
    }

    private void a(int i, String str, int i2, HistoryTraceData historyTraceData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), historyTraceData}) == null) {
            OnHistoryTraceListener onHistoryTraceListener = f26767b;
            if (onHistoryTraceListener == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "OnHistoryTraceListener is null");
            } else if (1 == i2) {
                onHistoryTraceListener.onQueryHistroyTraceData(i, str, historyTraceData);
            } else {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Undefined message type to notify");
            }
        }
    }

    private boolean a(String str, HistoryTraceData historyTraceData, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65542, this, str, historyTraceData, i)) == null) {
            if (TextUtils.isEmpty(str) || historyTraceData == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Parameter error when parser");
                a(10009, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_RESULT_PARSER_FAILED, i, null);
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!a(jSONObject, i)) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Request result contain error");
                    return false;
                }
                this.f26773g = false;
                int optInt = jSONObject.optInt("total");
                historyTraceData.setTotalPoints(optInt);
                int optInt2 = jSONObject.optInt("size");
                int optInt3 = jSONObject.optInt("req_page_index");
                if (optInt2 * optInt3 < optInt) {
                    f26768h = true;
                    optInt3++;
                    f.a(optInt3);
                }
                historyTraceData.setCurrentPageIndex(optInt3);
                historyTraceData.setDistance(jSONObject.optDouble("distance"));
                historyTraceData.setTollDiatance(jSONObject.optDouble("toll_distance"));
                historyTraceData.setCurrentOrderState(jSONObject.optInt("o_status"));
                historyTraceData.setOrderStartPosition(a(jSONObject.optString("o_start_point")));
                historyTraceData.setOrderEndPosition(a(jSONObject.optString("o_end_point")));
                List<HistoryTraceData.HistoryTracePoint> list = this.f26770d;
                if (list != null && !list.isEmpty()) {
                    this.f26770d.clear();
                }
                List<HistoryTraceData.HistoryTracePoint> a2 = a(jSONObject.optJSONArray("points"));
                if (a2 != null && !a2.isEmpty()) {
                    this.f26770d.addAll(a2);
                }
                return true;
            } catch (JSONException e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "JSONException happened when parser request result", e2);
                return false;
            }
        }
        return invokeLLI.booleanValue;
    }

    private boolean a(JSONObject jSONObject, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, this, jSONObject, i)) == null) {
            if (jSONObject == null || !jSONObject.has("status")) {
                a(10009, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_RESULT_PARSER_FAILED, i, null);
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Request result no status");
                return false;
            }
            this.i = jSONObject.optInt("status");
            this.j = jSONObject.optString("message");
            int i2 = this.i;
            if (i2 == 0) {
                this.f26773g = false;
                return true;
            } else if (1 != i2 || this.f26773g) {
                return true;
            } else {
                a(i);
                this.f26773g = true;
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (f26767b != null) {
                f26767b = null;
            }
            List<HistoryTraceData.HistoryTracePoint> list = this.f26770d;
            if (list != null) {
                list.clear();
                this.f26770d = null;
            }
            this.f26769c = null;
        }
    }

    public void a(HistoryTraceQueryOptions historyTraceQueryOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, historyTraceQueryOptions) == null) {
            this.f26772f = historyTraceQueryOptions;
        }
    }

    public void a(OnHistoryTraceListener onHistoryTraceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onHistoryTraceListener) == null) {
            f26767b = onHistoryTraceListener;
        }
    }

    public void a(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f26771e = aVar;
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, message) == null) {
            String str = a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "Message type = " + message.what);
            if (message.what != 3) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Undefined message type");
                return;
            }
            int i = message.arg1;
            String str2 = (String) message.obj;
            if (str2 == null) {
                a(10008, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_RESULT_NULL, i, null);
                return;
            }
            boolean a2 = a(str2, this.f26769c, i);
            if (a2) {
                this.k.put(this.f26769c.getCurrentPageIndex() - 1, this.f26770d);
                if (f26768h) {
                    a(i);
                    return;
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                List<HistoryTraceData.HistoryTracePoint> list = this.k.get(i2);
                if (list != null && !list.isEmpty()) {
                    arrayList.addAll(list);
                }
            }
            this.f26769c.setPointsList(arrayList);
            HistoryTraceData historyTraceData = this.f26769c;
            if (a2 && !f26768h) {
                a(this.i, this.j, i, historyTraceData);
                this.f26769c = null;
                this.f26769c = new HistoryTraceData();
                this.f26770d.clear();
                this.f26770d = null;
                this.f26770d = new ArrayList();
                this.k.clear();
            }
            f26768h = false;
        }
    }
}
