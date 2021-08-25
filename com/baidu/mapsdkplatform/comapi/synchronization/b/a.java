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
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes5.dex */
public class a extends Handler {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f42204a;

    /* renamed from: b  reason: collision with root package name */
    public static OnHistoryTraceListener f42205b;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f42206h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public HistoryTraceData f42207c;

    /* renamed from: d  reason: collision with root package name */
    public List<HistoryTraceData.HistoryTracePoint> f42208d;

    /* renamed from: e  reason: collision with root package name */
    public b.a f42209e;

    /* renamed from: f  reason: collision with root package name */
    public HistoryTraceQueryOptions f42210f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42211g;

    /* renamed from: i  reason: collision with root package name */
    public int f42212i;

    /* renamed from: j  reason: collision with root package name */
    public String f42213j;
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
        f42204a = a.class.getSimpleName();
        f42206h = false;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42211g = false;
        this.f42212i = 0;
        this.f42213j = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS;
        this.f42208d = new ArrayList();
        this.f42207c = new HistoryTraceData();
        this.k = new SparseArray<>();
    }

    private LatLng a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42204a, "Coord string is null");
                return null;
            }
            String[] split = str.split(",");
            if (split.length == 0 || 2 != split.length) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42204a, "Coord result is error");
                return null;
            }
            try {
                try {
                    return new LatLng(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
                } catch (NumberFormatException e2) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42204a, "Parser coord latitude failed", e2);
                    return null;
                }
            } catch (NumberFormatException e3) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42204a, "Parser coord longitude failed", e3);
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
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42204a, "Request result not contain points info");
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
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

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
            if (this.f42209e == null) {
                this.f42209e = new b.a();
            }
            Message obtainMessage = this.f42209e.obtainMessage();
            obtainMessage.what = i2;
            obtainMessage.obj = this.f42210f;
            this.f42209e.sendMessage(obtainMessage);
        }
    }

    private void a(int i2, String str, int i3, HistoryTraceData historyTraceData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), historyTraceData}) == null) {
            OnHistoryTraceListener onHistoryTraceListener = f42205b;
            if (onHistoryTraceListener == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42204a, "OnHistoryTraceListener is null");
            } else if (1 == i3) {
                onHistoryTraceListener.onQueryHistroyTraceData(i2, str, historyTraceData);
            } else {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42204a, "Undefined message type to notify");
            }
        }
    }

    private boolean a(String str, HistoryTraceData historyTraceData, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, this, str, historyTraceData, i2)) == null) {
            if (TextUtils.isEmpty(str) || historyTraceData == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42204a, "Parameter error when parser");
                a(10009, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_RESULT_PARSER_FAILED, i2, null);
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!a(jSONObject, i2)) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42204a, "Request result contain error");
                    return false;
                }
                this.f42211g = false;
                int optInt = jSONObject.optInt("total");
                historyTraceData.setTotalPoints(optInt);
                int optInt2 = jSONObject.optInt("size");
                int optInt3 = jSONObject.optInt("req_page_index");
                if (optInt2 * optInt3 < optInt) {
                    f42206h = true;
                    optInt3++;
                    f.a(optInt3);
                }
                historyTraceData.setCurrentPageIndex(optInt3);
                historyTraceData.setDistance(jSONObject.optDouble("distance"));
                historyTraceData.setTollDiatance(jSONObject.optDouble("toll_distance"));
                historyTraceData.setCurrentOrderState(jSONObject.optInt("o_status"));
                historyTraceData.setOrderStartPosition(a(jSONObject.optString("o_start_point")));
                historyTraceData.setOrderEndPosition(a(jSONObject.optString("o_end_point")));
                List<HistoryTraceData.HistoryTracePoint> list = this.f42208d;
                if (list != null && !list.isEmpty()) {
                    this.f42208d.clear();
                }
                List<HistoryTraceData.HistoryTracePoint> a2 = a(jSONObject.optJSONArray("points"));
                if (a2 != null && !a2.isEmpty()) {
                    this.f42208d.addAll(a2);
                }
                return true;
            } catch (JSONException e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42204a, "JSONException happened when parser request result", e2);
                return false;
            }
        }
        return invokeLLI.booleanValue;
    }

    private boolean a(JSONObject jSONObject, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, this, jSONObject, i2)) == null) {
            if (jSONObject == null || !jSONObject.has("status")) {
                a(10009, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_RESULT_PARSER_FAILED, i2, null);
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42204a, "Request result no status");
                return false;
            }
            this.f42212i = jSONObject.optInt("status");
            this.f42213j = jSONObject.optString("message");
            int i3 = this.f42212i;
            if (i3 == 0) {
                this.f42211g = false;
                return true;
            } else if (1 != i3 || this.f42211g) {
                return true;
            } else {
                a(i2);
                this.f42211g = true;
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (f42205b != null) {
                f42205b = null;
            }
            List<HistoryTraceData.HistoryTracePoint> list = this.f42208d;
            if (list != null) {
                list.clear();
                this.f42208d = null;
            }
            this.f42207c = null;
        }
    }

    public void a(HistoryTraceQueryOptions historyTraceQueryOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, historyTraceQueryOptions) == null) {
            this.f42210f = historyTraceQueryOptions;
        }
    }

    public void a(OnHistoryTraceListener onHistoryTraceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onHistoryTraceListener) == null) {
            f42205b = onHistoryTraceListener;
        }
    }

    public void a(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f42209e = aVar;
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, message) == null) {
            String str = f42204a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "Message type = " + message.what);
            if (message.what != 3) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42204a, "Undefined message type");
                return;
            }
            int i2 = message.arg1;
            String str2 = (String) message.obj;
            if (str2 == null) {
                a(10008, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_RESULT_NULL, i2, null);
                return;
            }
            boolean a2 = a(str2, this.f42207c, i2);
            if (a2) {
                this.k.put(this.f42207c.getCurrentPageIndex() - 1, this.f42208d);
                if (f42206h) {
                    a(i2);
                    return;
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < this.k.size(); i3++) {
                List<HistoryTraceData.HistoryTracePoint> list = this.k.get(i3);
                if (list != null && !list.isEmpty()) {
                    arrayList.addAll(list);
                }
            }
            this.f42207c.setPointsList(arrayList);
            HistoryTraceData historyTraceData = this.f42207c;
            if (a2 && !f42206h) {
                a(this.f42212i, this.f42213j, i2, historyTraceData);
                this.f42207c = null;
                this.f42207c = new HistoryTraceData();
                this.f42208d.clear();
                this.f42208d = null;
                this.f42208d = new ArrayList();
                this.k.clear();
            }
            f42206h = false;
        }
    }
}
