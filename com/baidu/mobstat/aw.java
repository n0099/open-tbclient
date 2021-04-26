package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.mobstat.au;
import com.baidu.tbadk.core.util.FieldBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class aw {

    /* renamed from: b  reason: collision with root package name */
    public static aw f8894b = new aw();

    /* renamed from: a  reason: collision with root package name */
    public a f8895a;

    /* renamed from: d  reason: collision with root package name */
    public Handler f8897d;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f8898e;

    /* renamed from: f  reason: collision with root package name */
    public int f8899f;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f8896c = new HandlerThread("fullTraceHandleThread");

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f8900g = new JSONObject();

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f8901h = new JSONArray();

    /* renamed from: i  reason: collision with root package name */
    public JSONArray f8902i = new JSONArray();
    public JSONArray j = new JSONArray();
    public JSONArray k = new JSONArray();

    /* loaded from: classes2.dex */
    public interface a {
        void a(JSONObject jSONObject);
    }

    public aw() {
        this.f8896c.start();
        this.f8896c.setPriority(10);
        this.f8897d = new Handler(this.f8896c.getLooper());
    }

    private void b(JSONObject jSONObject) {
    }

    private void d(Context context) {
        this.f8902i = b(this.f8902i, BDStatCore.instance().getPageSessionHead());
        b(context, false);
        b();
    }

    public void c(Context context, boolean z) {
        this.f8900g = new JSONObject();
        b(context);
        this.f8902i = new JSONArray();
        this.f8901h = new JSONArray();
        this.j = new JSONArray();
        this.k = new JSONArray();
        if (!z) {
            au.a().b();
        }
        c(context);
    }

    public void b(Context context, boolean z) {
        if (z) {
            c();
        } else {
            b();
        }
        try {
            b(context, this.f8900g);
        } catch (Exception unused) {
        }
        if (this.f8901h.length() == 0 && this.f8902i.length() == 0 && this.j.length() == 0 && this.k.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.HEADER_PART, this.f8900g);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put(Config.PRINCIPAL_PART, this.f8902i);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("ev", this.f8901h);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put(Config.FEED_LIST_PART, this.j);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("sv", this.k);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put(Config.EVENT_PAGE_MAPPING, au.a().a(au.a.f8892b));
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put(Config.EVENT_PATH_MAPPING, au.a().a(au.a.f8891a));
        } catch (Exception unused8) {
        }
        try {
            jSONObject.put("sd", au.a().a(au.a.f8893c));
        } catch (Exception unused9) {
        }
        c(context, jSONObject);
        b(jSONObject);
        String jSONObject2 = jSONObject.toString();
        if (bh.c().b()) {
            bh c2 = bh.c();
            c2.a("saveCurrentCacheToSend content: " + jSONObject2);
        }
        b(context, jSONObject2);
        c(context, !z);
    }

    private void d(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (bh.c().b()) {
            bh c2 = bh.c();
            c2.a("putPage: " + jSONObject.toString());
        }
        String jSONObject2 = jSONObject.toString();
        if (a(context, jSONObject2)) {
            if (bh.c().b()) {
                bh c3 = bh.c();
                c3.a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.f8898e + "; addedSize:" + jSONObject2.length());
            }
            d(context);
        }
        a(this.f8902i, jSONObject);
    }

    public static aw a() {
        return f8894b;
    }

    public void a(Context context) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONArray optJSONArray3;
        JSONArray optJSONArray4;
        if (context == null) {
            return;
        }
        String str = bw.u(context) + Config.STAT_FULL_CACHE_FILE_NAME;
        if (bo.c(context, str)) {
            String a2 = bo.a(context, str);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(a2);
            } catch (Exception unused) {
            }
            if (jSONObject == null) {
                return;
            }
            try {
                optJSONArray = jSONObject.optJSONArray("ev");
                optJSONArray2 = jSONObject.optJSONArray(Config.PRINCIPAL_PART);
                optJSONArray3 = jSONObject.optJSONArray(Config.FEED_LIST_PART);
                optJSONArray4 = jSONObject.optJSONArray("sv");
            } catch (Exception unused2) {
            }
            if ((optJSONArray != null && optJSONArray.length() != 0) || ((optJSONArray2 != null && optJSONArray2.length() != 0) || ((optJSONArray3 != null && optJSONArray3.length() != 0) || (optJSONArray4 != null && optJSONArray4.length() != 0)))) {
                b(context, jSONObject.getJSONObject(Config.HEADER_PART));
                c(context, jSONObject);
                b(jSONObject);
                a2 = jSONObject.toString();
                if (bh.c().b()) {
                    bh.c().a("saveLastCacheToSend content: " + a2);
                }
                b(context, a2);
                c(context, false);
                return;
            }
            if (bh.c().b()) {
                bh.c().a("saveLastCacheToSend content:empty, return");
            }
        }
    }

    public void c(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.HEADER_PART, new JSONObject(this.f8900g.toString()));
            jSONObject.put(Config.PRINCIPAL_PART, new JSONArray(this.f8902i.toString()));
            jSONObject.put("ev", new JSONArray(this.f8901h.toString()));
            jSONObject.put(Config.FEED_LIST_PART, new JSONArray(this.j.toString()));
            jSONObject.put("sv", new JSONArray(this.k.toString()));
            jSONObject.put(Config.EVENT_PAGE_MAPPING, au.a().a(au.a.f8892b));
            jSONObject.put(Config.EVENT_PATH_MAPPING, au.a().a(au.a.f8891a));
            jSONObject.put("sd", au.a().a(au.a.f8893c));
        } catch (Exception unused) {
        }
        String jSONObject2 = jSONObject.toString();
        int length = jSONObject2.getBytes().length;
        if (length >= 184320) {
            return;
        }
        this.f8898e = length;
        String u = bw.u(context);
        bo.a(context, u + Config.STAT_FULL_CACHE_FILE_NAME, jSONObject2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, ArrayList<aq> arrayList) {
        if (context == null || arrayList == null || arrayList.size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<aq> it = arrayList.iterator();
        while (it.hasNext()) {
            aq next = it.next();
            JSONObject a2 = next.a(au.a().a(next.b(), au.a.f8892b), au.a().a(next.f(), au.a.f8893c), bj.c(next.c()));
            if (a2 != null) {
                jSONArray.put(a2);
            }
        }
        b(context, jSONArray);
        c(context);
    }

    public void b(Context context) {
        CooperService.instance().getHeadObject().installHeader(context, this.f8900g);
    }

    private void b(Context context, JSONObject jSONObject) {
        CooperService.instance().getHeadObject().installHeader(context, jSONObject);
        try {
            jSONObject.put("t", System.currentTimeMillis());
            jSONObject.put(Config.SEQUENCE_INDEX, this.f8899f);
            jSONObject.put("ss", BDStatCore.instance().getSessionStartTime());
            jSONObject.put("at", "1");
            jSONObject.put("sign", CooperService.instance().getUUID());
        } catch (Exception unused) {
        }
    }

    private void c() {
        this.f8899f = 0;
    }

    private void c(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(Config.TRACE_FAILED_CNT, 0);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put(Config.TRACE_PART, jSONObject2);
        } catch (Exception unused2) {
        }
    }

    private void b() {
        this.f8899f++;
    }

    private void b(Context context, String str) {
        LogSender.instance().saveLogData(context, str, true);
        if (this.f8895a != null) {
            try {
                this.f8895a.a(new JSONObject(str));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, ArrayList<ap> arrayList) {
        if (context == null || arrayList == null || arrayList.size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<ap> it = arrayList.iterator();
        while (it.hasNext()) {
            ap next = it.next();
            JSONObject a2 = next.a(au.a().a(next.a(), au.a.f8893c));
            if (a2 != null) {
                jSONArray.put(a2);
            }
        }
        a(context, jSONArray);
        c(context);
    }

    public void a(Context context, String str, String str2, int i2, long j, String str3, JSONArray jSONArray, String str4, JSONArray jSONArray2, String str5, Map<String, String> map, JSONObject jSONObject, String str6) {
        a(context, str, str2, i2, j, str3, jSONArray, str4, jSONArray2, str5, map, false, jSONObject, str6);
    }

    public void a(final Context context, final String str, final String str2, final int i2, final long j, final String str3, final JSONArray jSONArray, final String str4, final JSONArray jSONArray2, final String str5, final Map<String, String> map, final boolean z, final JSONObject jSONObject, final String str6) {
        this.f8897d.post(new Runnable() { // from class: com.baidu.mobstat.aw.1
            @Override // java.lang.Runnable
            public void run() {
                long sessionStartTime = BDStatCore.instance().getSessionStartTime();
                if (sessionStartTime <= 0) {
                    return;
                }
                aw.this.a(context, sessionStartTime, str, str2, i2, j, str3, jSONArray, str4, jSONArray2, str5, map, z, jSONObject, str6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j, String str, String str2, int i2, long j2, String str3, JSONArray jSONArray, String str4, JSONArray jSONArray2, String str5, Map<String, String> map, boolean z, JSONObject jSONObject, String str6) {
        a(context, EventAnalysis.getEvent(context, j, str, str2, i2, j2, 0L, "", null, null, bj.a(str3), bj.a(str4), str5, Config.EventViewType.EDIT.getValue(), 3, null, map, bj.c(jSONArray), bj.d(jSONArray2), z, jSONObject, str6));
        c(context);
    }

    public void b(final Context context, final ArrayList<aq> arrayList) {
        this.f8897d.post(new Runnable() { // from class: com.baidu.mobstat.aw.6
            @Override // java.lang.Runnable
            public void run() {
                aw.this.d(context, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, ao aoVar) {
        if (context == null || aoVar == null) {
            return;
        }
        JSONArray b2 = b(this.f8902i, BDStatCore.instance().getPageSessionHead());
        this.f8902i = b2;
        if (b2.length() == 0) {
            return;
        }
        long a2 = a(this.f8902i);
        if (a2 <= 0) {
            return;
        }
        d(context, aoVar.a(a2, au.a().a(aoVar.a(), au.a.f8892b), au.a().a(aoVar.b(), au.a.f8893c)));
        c(context);
    }

    private void a(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (bh.c().b()) {
            bh c2 = bh.c();
            c2.a("putEvent: " + jSONObject.toString());
        }
        String jSONObject2 = jSONObject.toString();
        if (a(context, jSONObject2)) {
            if (bh.c().b()) {
                bh c3 = bh.c();
                c3.a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.f8898e + "; addedSize:" + jSONObject2.length());
            }
            d(context);
        }
        EventAnalysis.doEventMerge(this.f8901h, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:9|10|11|(6:27|28|14|15|(2:20|21)|(1:18))|13|14|15|(0)|(0)) */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONArray b(JSONArray jSONArray, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONArray jSONArray2;
        JSONObject jSONObject4;
        if (jSONObject == null || jSONArray == null || jSONObject.optLong("s") <= 0) {
            return jSONArray;
        }
        JSONArray jSONArray3 = new JSONArray();
        JSONObject jSONObject5 = null;
        if (jSONArray.length() == 0) {
            try {
                jSONObject2 = new JSONObject(jSONObject.toString());
            } catch (Exception unused) {
            }
            try {
                jSONObject2.put("p", new JSONArray());
            } catch (Exception unused2) {
                jSONObject5 = jSONObject2;
                jSONObject2 = jSONObject5;
                if (jSONObject2 != null) {
                }
                return jSONArray3;
            }
            if (jSONObject2 != null) {
                jSONArray3.put(jSONObject2);
            }
        } else {
            try {
                jSONObject3 = jSONArray.getJSONObject(0);
            } catch (Exception unused3) {
                jSONObject3 = null;
            }
            if (jSONObject3 != null) {
                try {
                    jSONArray2 = jSONObject3.getJSONArray("p");
                } catch (Exception unused4) {
                }
                jSONObject4 = new JSONObject(jSONObject.toString());
                if (jSONArray2 != null) {
                    try {
                        jSONObject4.put("p", jSONArray2);
                    } catch (Exception unused5) {
                        jSONObject5 = jSONObject4;
                        jSONObject4 = jSONObject5;
                        if (jSONObject4 != null) {
                        }
                        return jSONArray3;
                    }
                }
                if (jSONObject4 != null) {
                    jSONArray3.put(jSONObject4);
                }
            }
            jSONArray2 = null;
            jSONObject4 = new JSONObject(jSONObject.toString());
            if (jSONArray2 != null) {
            }
            if (jSONObject4 != null) {
            }
        }
        return jSONArray3;
    }

    private boolean a(Context context, String str) {
        return (str != null ? str.getBytes().length : 0) + this.f8898e > 184320;
    }

    public void a(final Context context, final boolean z) {
        this.f8897d.post(new Runnable() { // from class: com.baidu.mobstat.aw.2
            @Override // java.lang.Runnable
            public void run() {
                aw.this.b(context, z);
            }
        });
    }

    public void a(final JSONObject jSONObject) {
        this.f8897d.post(new Runnable() { // from class: com.baidu.mobstat.aw.3
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 == null || jSONObject2.length() == 0) {
                    return;
                }
                aw awVar = aw.this;
                awVar.f8902i = awVar.b(awVar.f8902i, jSONObject);
            }
        });
    }

    public void a(final Context context, final ao aoVar) {
        this.f8897d.post(new Runnable() { // from class: com.baidu.mobstat.aw.4
            @Override // java.lang.Runnable
            public void run() {
                if (BDStatCore.instance().getSessionStartTime() <= 0) {
                    return;
                }
                aw.this.b(context, aoVar);
            }
        });
    }

    public void a(final Context context, final ArrayList<ap> arrayList) {
        this.f8897d.post(new Runnable() { // from class: com.baidu.mobstat.aw.5
            @Override // java.lang.Runnable
            public void run() {
                aw.this.c(context, arrayList);
            }
        });
    }

    private void a(JSONArray jSONArray, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONArray jSONArray2 = null;
        try {
            jSONObject2 = jSONArray.getJSONObject(0);
        } catch (Exception unused) {
            jSONObject2 = null;
        }
        if (jSONObject2 != null) {
            try {
                jSONArray2 = jSONObject2.optJSONArray("p");
            } catch (Exception unused2) {
            }
        }
        if (jSONArray2 == null) {
            JSONArray jSONArray3 = new JSONArray();
            jSONArray3.put(jSONObject);
            if (jSONObject2 != null) {
                try {
                    jSONObject2.put("p", jSONArray3);
                    return;
                } catch (Exception unused3) {
                    return;
                }
            }
            return;
        }
        jSONArray2.put(jSONObject);
    }

    private void b(Context context, JSONArray jSONArray) {
        if (context == null || this.k == null || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        if (bh.c().b()) {
            bh c2 = bh.c();
            c2.a("putFeedListItem: " + jSONArray.toString());
        }
        String jSONArray2 = jSONArray.toString();
        if (a(context, jSONArray2)) {
            if (bh.c().b()) {
                bh c3 = bh.c();
                c3.a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.f8898e + "; addedSize:" + jSONArray2.length());
            }
            d(context);
        }
        b(this.k, jSONArray);
    }

    private long a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return 0L;
        }
        try {
            return jSONArray.getJSONObject(0).optLong("s");
        } catch (Exception unused) {
            return 0L;
        }
    }

    private void a(Context context, JSONArray jSONArray) {
        if (context == null || this.j == null || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        if (bh.c().b()) {
            bh c2 = bh.c();
            c2.a("putFeedList: " + jSONArray.toString());
        }
        String jSONArray2 = jSONArray.toString();
        if (a(context, jSONArray2)) {
            if (bh.c().b()) {
                bh c3 = bh.c();
                c3.a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.f8898e + "; addedSize:" + jSONArray2.length());
            }
            d(context);
        }
        a(this.j, jSONArray);
    }

    private void b(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null || jSONArray2 == null) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray2.getJSONObject(i2);
                if (jSONObject != null && jSONObject.length() != 0) {
                    JSONObject jSONObject2 = null;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= jSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                        if (jSONObject3 != null && jSONObject3.length() != 0 && a(jSONObject3, jSONObject)) {
                            jSONObject2 = jSONObject3;
                            break;
                        }
                        i3++;
                    }
                    if (jSONObject2 == null) {
                        jSONArray.put(jSONObject);
                    } else {
                        b(jSONObject2, jSONObject);
                    }
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    private void a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null || jSONArray2 == null) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            try {
                jSONArray.put(jSONArray2.getJSONObject(i2));
            } catch (Exception unused) {
                return;
            }
        }
    }

    private boolean a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return false;
        }
        String optString = jSONObject.optString("id");
        jSONObject.optString("d");
        String optString2 = jSONObject.optString("p");
        String optString3 = jSONObject.optString("path");
        String optString4 = jSONObject.optString("title");
        String optString5 = jSONObject.optString("index");
        String optString6 = jSONObject.optString("n");
        int optInt = jSONObject.optInt("user");
        jSONObject.optInt("c");
        jSONObject.optLong("t");
        jSONObject.optString("ps");
        String optString7 = jSONObject2.optString("id");
        jSONObject2.optString("d");
        String optString8 = jSONObject2.optString("p");
        String optString9 = jSONObject2.optString("path");
        String optString10 = jSONObject2.optString("title");
        String optString11 = jSONObject2.optString("index");
        String optString12 = jSONObject2.optString("n");
        int optInt2 = jSONObject2.optInt("user");
        jSONObject2.optInt("c");
        jSONObject2.optLong("t");
        jSONObject2.optString("ps");
        return a(optString, optString7) && a(optString2, optString8) && a(optString3, optString9) && a(optString4, optString10) && a(optString5, optString11) && a(optString6, optString12) && optInt == optInt2;
    }

    private void b(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        String str2;
        String str3;
        long j;
        long j2;
        String optString = jSONObject.optString("d");
        int optInt = jSONObject.optInt("c");
        long optLong = jSONObject.optLong("t");
        String optString2 = jSONObject.optString("ps");
        String optString3 = jSONObject2.optString("d");
        int optInt2 = jSONObject2.optInt("c");
        long optLong2 = jSONObject2.optLong("t");
        String optString4 = jSONObject2.optString("ps");
        int i2 = optInt + optInt2;
        int i3 = (optLong > optLong2 ? 1 : (optLong == optLong2 ? 0 : -1));
        long j3 = i3 <= 0 ? optLong : optLong2;
        if (i3 <= 0) {
            str = "ps";
            str2 = optString + FieldBuilder.SE + optString3;
        } else {
            str = "ps";
            str2 = optString3 + FieldBuilder.SE + optString;
        }
        int i4 = 0;
        long j4 = 0;
        if (i3 <= 0) {
            long j5 = optLong2 - optLong;
            StringBuilder sb = new StringBuilder();
            String[] split = optString4.split("\\|");
            if (split != null && split.length != 0) {
                int length = split.length;
                while (i4 < length) {
                    String str4 = split[i4];
                    if (!TextUtils.isEmpty(sb.toString())) {
                        sb.append(FieldBuilder.SE);
                    }
                    try {
                        j2 = Long.valueOf(str4).longValue();
                    } catch (Exception unused) {
                        j2 = 0;
                    }
                    sb.append(j2 + j5);
                    i4++;
                }
            } else {
                try {
                    j4 = Long.valueOf(optString4).longValue();
                } catch (Exception unused2) {
                }
                sb.append(j5 + j4);
            }
            str3 = optString2 + FieldBuilder.SE + sb.toString();
        } else {
            long j6 = optLong - optLong2;
            StringBuilder sb2 = new StringBuilder();
            String[] split2 = optString2.split("\\|");
            if (split2 != null && split2.length != 0) {
                int length2 = split2.length;
                while (i4 < length2) {
                    String str5 = split2[i4];
                    if (!TextUtils.isEmpty(sb2.toString())) {
                        sb2.append(FieldBuilder.SE);
                    }
                    try {
                        j = Long.valueOf(str5).longValue();
                    } catch (Exception unused3) {
                        j = 0;
                    }
                    sb2.append(j + j6);
                    i4++;
                }
            } else {
                try {
                    j4 = Long.valueOf(optString2).longValue();
                } catch (Exception unused4) {
                }
                sb2.append(j6 + j4);
            }
            str3 = optString4 + FieldBuilder.SE + sb2.toString();
        }
        try {
            jSONObject.put("c", i2);
            jSONObject.put("t", j3);
            jSONObject.put("d", str2);
            jSONObject.put(str, str3);
        } catch (Exception unused5) {
        }
    }

    private boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals(str2)) ? false : true;
    }
}
