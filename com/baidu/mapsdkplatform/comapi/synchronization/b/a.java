package com.baidu.mapsdkplatform.comapi.synchronization.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceData;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapapi.synchronization.histroytrace.OnHistoryTraceListener;
import com.baidu.mapsdkplatform.comapi.synchronization.b.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends Handler {

    /* renamed from: b  reason: collision with root package name */
    public static OnHistoryTraceListener f7733b;

    /* renamed from: c  reason: collision with root package name */
    public HistoryTraceData f7735c;

    /* renamed from: d  reason: collision with root package name */
    public List<HistoryTraceData.HistoryTracePoint> f7736d;

    /* renamed from: e  reason: collision with root package name */
    public b.a f7737e;

    /* renamed from: f  reason: collision with root package name */
    public HistoryTraceQueryOptions f7738f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7739g;
    public int i;
    public String j;
    public SparseArray<List<HistoryTraceData.HistoryTracePoint>> k;

    /* renamed from: a  reason: collision with root package name */
    public static final String f7732a = a.class.getSimpleName();

    /* renamed from: h  reason: collision with root package name */
    public static boolean f7734h = false;

    public a(Looper looper) {
        super(looper);
        this.f7739g = false;
        this.i = 0;
        this.j = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS;
        this.f7736d = new ArrayList();
        this.f7735c = new HistoryTraceData();
        this.k = new SparseArray<>();
    }

    private LatLng a(String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7732a, "Coord string is null");
            return null;
        }
        String[] split = str.split(",");
        if (split.length == 0 || 2 != split.length) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7732a, "Coord result is error");
            return null;
        }
        try {
            try {
                return new LatLng(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
            } catch (NumberFormatException e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7732a, "Parser coord latitude failed", e2);
                return null;
            }
        } catch (NumberFormatException e3) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7732a, "Parser coord longitude failed", e3);
            return null;
        }
    }

    private List<HistoryTraceData.HistoryTracePoint> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7732a, "Request result not contain points info");
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

    private void a(int i) {
        if (this.f7737e == null) {
            this.f7737e = new b.a();
        }
        Message obtainMessage = this.f7737e.obtainMessage();
        obtainMessage.what = i;
        obtainMessage.obj = this.f7738f;
        this.f7737e.sendMessage(obtainMessage);
    }

    private void a(int i, String str, int i2, HistoryTraceData historyTraceData) {
        OnHistoryTraceListener onHistoryTraceListener = f7733b;
        if (onHistoryTraceListener == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7732a, "OnHistoryTraceListener is null");
        } else if (1 == i2) {
            onHistoryTraceListener.onQueryHistroyTraceData(i, str, historyTraceData);
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7732a, "Undefined message type to notify");
        }
    }

    private boolean a(String str, HistoryTraceData historyTraceData, int i) {
        if (TextUtils.isEmpty(str) || historyTraceData == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7732a, "Parameter error when parser");
            a(10009, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_RESULT_PARSER_FAILED, i, null);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!a(jSONObject, i)) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7732a, "Request result contain error");
                return false;
            }
            this.f7739g = false;
            int optInt = jSONObject.optInt("total");
            historyTraceData.setTotalPoints(optInt);
            int optInt2 = jSONObject.optInt("size");
            int optInt3 = jSONObject.optInt("req_page_index");
            if (optInt2 * optInt3 < optInt) {
                f7734h = true;
                optInt3++;
                f.a(optInt3);
            }
            historyTraceData.setCurrentPageIndex(optInt3);
            historyTraceData.setDistance(jSONObject.optDouble("distance"));
            historyTraceData.setTollDiatance(jSONObject.optDouble("toll_distance"));
            historyTraceData.setCurrentOrderState(jSONObject.optInt("o_status"));
            historyTraceData.setOrderStartPosition(a(jSONObject.optString("o_start_point")));
            historyTraceData.setOrderEndPosition(a(jSONObject.optString("o_end_point")));
            List<HistoryTraceData.HistoryTracePoint> list = this.f7736d;
            if (list != null && !list.isEmpty()) {
                this.f7736d.clear();
            }
            List<HistoryTraceData.HistoryTracePoint> a2 = a(jSONObject.optJSONArray("points"));
            if (a2 != null && !a2.isEmpty()) {
                this.f7736d.addAll(a2);
            }
            return true;
        } catch (JSONException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7732a, "JSONException happened when parser request result", e2);
            return false;
        }
    }

    private boolean a(JSONObject jSONObject, int i) {
        if (jSONObject == null || !jSONObject.has("status")) {
            a(10009, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_RESULT_PARSER_FAILED, i, null);
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7732a, "Request result no status");
            return false;
        }
        this.i = jSONObject.optInt("status");
        this.j = jSONObject.optString("message");
        int i2 = this.i;
        if (i2 == 0) {
            this.f7739g = false;
            return true;
        } else if (1 != i2 || this.f7739g) {
            return true;
        } else {
            a(i);
            this.f7739g = true;
            return false;
        }
    }

    public void a() {
        if (f7733b != null) {
            f7733b = null;
        }
        List<HistoryTraceData.HistoryTracePoint> list = this.f7736d;
        if (list != null) {
            list.clear();
            this.f7736d = null;
        }
        this.f7735c = null;
    }

    public void a(HistoryTraceQueryOptions historyTraceQueryOptions) {
        this.f7738f = historyTraceQueryOptions;
    }

    public void a(OnHistoryTraceListener onHistoryTraceListener) {
        f7733b = onHistoryTraceListener;
    }

    public void a(b.a aVar) {
        this.f7737e = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str = f7732a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "Message type = " + message.what);
        if (message.what != 3) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7732a, "Undefined message type");
            return;
        }
        int i = message.arg1;
        String str2 = (String) message.obj;
        if (str2 == null) {
            a(10008, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_RESULT_NULL, i, null);
            return;
        }
        boolean a2 = a(str2, this.f7735c, i);
        if (a2) {
            this.k.put(this.f7735c.getCurrentPageIndex(), this.f7736d);
            if (f7734h) {
                a(i);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            List<HistoryTraceData.HistoryTracePoint> list = this.k.get(i2);
            if (list != null && !list.isEmpty()) {
                arrayList.addAll(this.f7736d);
            }
        }
        this.f7735c.setPointsList(arrayList);
        HistoryTraceData historyTraceData = this.f7735c;
        if (a2 && !f7734h) {
            a(this.i, this.j, i, historyTraceData);
            this.f7735c = null;
            this.f7735c = new HistoryTraceData();
            this.f7736d.clear();
            this.f7736d = null;
            this.f7736d = new ArrayList();
            this.k.clear();
        }
        f7734h = false;
    }
}
