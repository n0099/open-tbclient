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
    public static OnHistoryTraceListener f8010b;

    /* renamed from: c  reason: collision with root package name */
    public HistoryTraceData f8012c;

    /* renamed from: d  reason: collision with root package name */
    public List<HistoryTraceData.HistoryTracePoint> f8013d;

    /* renamed from: e  reason: collision with root package name */
    public b.a f8014e;

    /* renamed from: f  reason: collision with root package name */
    public HistoryTraceQueryOptions f8015f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8016g;

    /* renamed from: i  reason: collision with root package name */
    public int f8017i;
    public String j;
    public SparseArray<List<HistoryTraceData.HistoryTracePoint>> k;

    /* renamed from: a  reason: collision with root package name */
    public static final String f8009a = a.class.getSimpleName();

    /* renamed from: h  reason: collision with root package name */
    public static boolean f8011h = false;

    public a(Looper looper) {
        super(looper);
        this.f8016g = false;
        this.f8017i = 0;
        this.j = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS;
        this.f8013d = new ArrayList();
        this.f8012c = new HistoryTraceData();
        this.k = new SparseArray<>();
    }

    private LatLng a(String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8009a, "Coord string is null");
            return null;
        }
        String[] split = str.split(",");
        if (split.length == 0 || 2 != split.length) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8009a, "Coord result is error");
            return null;
        }
        try {
            try {
                return new LatLng(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
            } catch (NumberFormatException e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f8009a, "Parser coord latitude failed", e2);
                return null;
            }
        } catch (NumberFormatException e3) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f8009a, "Parser coord longitude failed", e3);
            return null;
        }
    }

    private List<HistoryTraceData.HistoryTracePoint> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8009a, "Request result not contain points info");
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

    private void a(int i2) {
        if (this.f8014e == null) {
            this.f8014e = new b.a();
        }
        Message obtainMessage = this.f8014e.obtainMessage();
        obtainMessage.what = i2;
        obtainMessage.obj = this.f8015f;
        this.f8014e.sendMessage(obtainMessage);
    }

    private void a(int i2, String str, int i3, HistoryTraceData historyTraceData) {
        OnHistoryTraceListener onHistoryTraceListener = f8010b;
        if (onHistoryTraceListener == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8009a, "OnHistoryTraceListener is null");
        } else if (1 == i3) {
            onHistoryTraceListener.onQueryHistroyTraceData(i2, str, historyTraceData);
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8009a, "Undefined message type to notify");
        }
    }

    private boolean a(String str, HistoryTraceData historyTraceData, int i2) {
        if (TextUtils.isEmpty(str) || historyTraceData == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8009a, "Parameter error when parser");
            a(10009, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_RESULT_PARSER_FAILED, i2, null);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!a(jSONObject, i2)) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8009a, "Request result contain error");
                return false;
            }
            this.f8016g = false;
            int optInt = jSONObject.optInt("total");
            historyTraceData.setTotalPoints(optInt);
            int optInt2 = jSONObject.optInt("size");
            int optInt3 = jSONObject.optInt("req_page_index");
            if (optInt2 * optInt3 < optInt) {
                f8011h = true;
                optInt3++;
                f.a(optInt3);
            }
            historyTraceData.setCurrentPageIndex(optInt3);
            historyTraceData.setDistance(jSONObject.optDouble("distance"));
            historyTraceData.setTollDiatance(jSONObject.optDouble("toll_distance"));
            historyTraceData.setCurrentOrderState(jSONObject.optInt("o_status"));
            historyTraceData.setOrderStartPosition(a(jSONObject.optString("o_start_point")));
            historyTraceData.setOrderEndPosition(a(jSONObject.optString("o_end_point")));
            List<HistoryTraceData.HistoryTracePoint> list = this.f8013d;
            if (list != null && !list.isEmpty()) {
                this.f8013d.clear();
            }
            List<HistoryTraceData.HistoryTracePoint> a2 = a(jSONObject.optJSONArray("points"));
            if (a2 != null && !a2.isEmpty()) {
                this.f8013d.addAll(a2);
            }
            return true;
        } catch (JSONException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f8009a, "JSONException happened when parser request result", e2);
            return false;
        }
    }

    private boolean a(JSONObject jSONObject, int i2) {
        if (jSONObject == null || !jSONObject.has("status")) {
            a(10009, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_RESULT_PARSER_FAILED, i2, null);
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8009a, "Request result no status");
            return false;
        }
        this.f8017i = jSONObject.optInt("status");
        this.j = jSONObject.optString("message");
        int i3 = this.f8017i;
        if (i3 == 0) {
            this.f8016g = false;
            return true;
        } else if (1 != i3 || this.f8016g) {
            return true;
        } else {
            a(i2);
            this.f8016g = true;
            return false;
        }
    }

    public void a() {
        if (f8010b != null) {
            f8010b = null;
        }
        List<HistoryTraceData.HistoryTracePoint> list = this.f8013d;
        if (list != null) {
            list.clear();
            this.f8013d = null;
        }
        this.f8012c = null;
    }

    public void a(HistoryTraceQueryOptions historyTraceQueryOptions) {
        this.f8015f = historyTraceQueryOptions;
    }

    public void a(OnHistoryTraceListener onHistoryTraceListener) {
        f8010b = onHistoryTraceListener;
    }

    public void a(b.a aVar) {
        this.f8014e = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str = f8009a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "Message type = " + message.what);
        if (message.what != 3) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8009a, "Undefined message type");
            return;
        }
        int i2 = message.arg1;
        String str2 = (String) message.obj;
        if (str2 == null) {
            a(10008, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_RESULT_NULL, i2, null);
            return;
        }
        boolean a2 = a(str2, this.f8012c, i2);
        if (a2) {
            this.k.put(this.f8012c.getCurrentPageIndex(), this.f8013d);
            if (f8011h) {
                a(i2);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.k.size(); i3++) {
            List<HistoryTraceData.HistoryTracePoint> list = this.k.get(i3);
            if (list != null && !list.isEmpty()) {
                arrayList.addAll(this.f8013d);
            }
        }
        this.f8012c.setPointsList(arrayList);
        HistoryTraceData historyTraceData = this.f8012c;
        if (a2 && !f8011h) {
            a(this.f8017i, this.j, i2, historyTraceData);
            this.f8012c = null;
            this.f8012c = new HistoryTraceData();
            this.f8013d.clear();
            this.f8013d = null;
            this.f8013d = new ArrayList();
            this.k.clear();
        }
        f8011h = false;
    }
}
