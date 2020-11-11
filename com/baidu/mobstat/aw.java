package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.mobstat.Config;
import com.baidu.mobstat.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class aw {
    private static aw b = new aw();

    /* renamed from: a  reason: collision with root package name */
    public a f2564a;
    private Handler d;
    private volatile int e;
    private int f;
    private HandlerThread c = new HandlerThread("fullTraceHandleThread");
    private JSONObject g = new JSONObject();
    private JSONArray h = new JSONArray();
    private JSONArray i = new JSONArray();
    private JSONArray j = new JSONArray();
    private JSONArray k = new JSONArray();

    /* loaded from: classes17.dex */
    public interface a {
        void a(JSONObject jSONObject);
    }

    public static aw a() {
        return b;
    }

    private aw() {
        this.c.start();
        this.c.setPriority(10);
        this.d = new Handler(this.c.getLooper());
    }

    public void a(Context context) {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONArray optJSONArray3;
        JSONArray optJSONArray4;
        if (context != null) {
            String str = bw.u(context) + Config.STAT_FULL_CACHE_FILE_NAME;
            if (bo.c(context, str)) {
                String a2 = bo.a(context, str);
                if (!TextUtils.isEmpty(a2)) {
                    try {
                        jSONObject = new JSONObject(a2);
                    } catch (Exception e) {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        try {
                            optJSONArray = jSONObject.optJSONArray("ev");
                            optJSONArray2 = jSONObject.optJSONArray(Config.PRINCIPAL_PART);
                            optJSONArray3 = jSONObject.optJSONArray(Config.FEED_LIST_PART);
                            optJSONArray4 = jSONObject.optJSONArray("sv");
                        } catch (Exception e2) {
                        }
                        if ((optJSONArray == null || optJSONArray.length() == 0) && ((optJSONArray2 == null || optJSONArray2.length() == 0) && ((optJSONArray3 == null || optJSONArray3.length() == 0) && (optJSONArray4 == null || optJSONArray4.length() == 0)))) {
                            if (bh.c().b()) {
                                bh.c().a("saveLastCacheToSend content:empty, return");
                                return;
                            }
                            return;
                        }
                        b(context, jSONObject.getJSONObject(Config.HEADER_PART));
                        c(context, jSONObject);
                        b(jSONObject);
                        a2 = jSONObject.toString();
                        if (bh.c().b()) {
                            bh.c().a("saveLastCacheToSend content: " + a2);
                        }
                        b(context, a2);
                        c(context, false);
                    }
                }
            }
        }
    }

    public void a(Context context, String str, String str2, int i, long j, String str3, JSONArray jSONArray, String str4, JSONArray jSONArray2, String str5, Map<String, String> map, JSONObject jSONObject, String str6) {
        a(context, str, str2, i, j, str3, jSONArray, str4, jSONArray2, str5, map, false, jSONObject, str6);
    }

    public void a(final Context context, final String str, final String str2, final int i, final long j, final String str3, final JSONArray jSONArray, final String str4, final JSONArray jSONArray2, final String str5, final Map<String, String> map, final boolean z, final JSONObject jSONObject, final String str6) {
        this.d.post(new Runnable() { // from class: com.baidu.mobstat.aw.1
            @Override // java.lang.Runnable
            public void run() {
                long sessionStartTime = BDStatCore.instance().getSessionStartTime();
                if (sessionStartTime > 0) {
                    aw.this.a(context, sessionStartTime, str, str2, i, j, str3, jSONArray, str4, jSONArray2, str5, map, z, jSONObject, str6);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j, String str, String str2, int i, long j2, String str3, JSONArray jSONArray, String str4, JSONArray jSONArray2, String str5, Map<String, String> map, boolean z, JSONObject jSONObject, String str6) {
        a(context, EventAnalysis.getEvent(context, j, str, str2, i, j2, 0L, "", null, null, bj.a(str3), bj.a(str4), str5, Config.EventViewType.EDIT.getValue(), 3, null, map, bj.c(jSONArray), bj.d(jSONArray2), z, jSONObject, str6));
        c(context);
    }

    private void a(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            if (bh.c().b()) {
                bh.c().a("putEvent: " + jSONObject.toString());
            }
            String jSONObject2 = jSONObject.toString();
            if (a(context, jSONObject2)) {
                if (bh.c().b()) {
                    bh.c().a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.e + "; addedSize:" + jSONObject2.length());
                }
                d(context);
            }
            EventAnalysis.doEventMerge(this.h, jSONObject);
        }
    }

    private boolean a(Context context, String str) {
        return (str != null ? str.getBytes().length : 0) + this.e > 184320;
    }

    public void a(final Context context, final boolean z) {
        this.d.post(new Runnable() { // from class: com.baidu.mobstat.aw.2
            @Override // java.lang.Runnable
            public void run() {
                aw.this.b(context, z);
            }
        });
    }

    public void a(final JSONObject jSONObject) {
        this.d.post(new Runnable() { // from class: com.baidu.mobstat.aw.3
            @Override // java.lang.Runnable
            public void run() {
                if (jSONObject != null && jSONObject.length() != 0) {
                    aw.this.i = aw.this.b(aw.this.i, jSONObject);
                }
            }
        });
    }

    public void b(Context context, boolean z) {
        if (z) {
            c();
        } else {
            b();
        }
        try {
            b(context, this.g);
        } catch (Exception e) {
        }
        if (this.h.length() != 0 || this.i.length() != 0 || this.j.length() != 0 || this.k.length() != 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.HEADER_PART, this.g);
            } catch (Exception e2) {
            }
            try {
                jSONObject.put(Config.PRINCIPAL_PART, this.i);
            } catch (Exception e3) {
            }
            try {
                jSONObject.put("ev", this.h);
            } catch (Exception e4) {
            }
            try {
                jSONObject.put(Config.FEED_LIST_PART, this.j);
            } catch (Exception e5) {
            }
            try {
                jSONObject.put("sv", this.k);
            } catch (Exception e6) {
            }
            try {
                jSONObject.put(Config.EVENT_PAGE_MAPPING, au.a().a(au.a.b));
            } catch (Exception e7) {
            }
            try {
                jSONObject.put(Config.EVENT_PATH_MAPPING, au.a().a(au.a.f2563a));
            } catch (Exception e8) {
            }
            try {
                jSONObject.put("sd", au.a().a(au.a.c));
            } catch (Exception e9) {
            }
            c(context, jSONObject);
            b(jSONObject);
            String jSONObject2 = jSONObject.toString();
            if (bh.c().b()) {
                bh.c().a("saveCurrentCacheToSend content: " + jSONObject2);
            }
            b(context, jSONObject2);
            c(context, !z);
        }
    }

    public void c(Context context, boolean z) {
        this.g = new JSONObject();
        b(context);
        this.i = new JSONArray();
        this.h = new JSONArray();
        this.j = new JSONArray();
        this.k = new JSONArray();
        if (!z) {
            au.a().b();
        }
        c(context);
    }

    public void b(Context context) {
        CooperService.instance().getHeadObject().installHeader(context, this.g);
    }

    public void c(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.HEADER_PART, new JSONObject(this.g.toString()));
            jSONObject.put(Config.PRINCIPAL_PART, new JSONArray(this.i.toString()));
            jSONObject.put("ev", new JSONArray(this.h.toString()));
            jSONObject.put(Config.FEED_LIST_PART, new JSONArray(this.j.toString()));
            jSONObject.put("sv", new JSONArray(this.k.toString()));
            jSONObject.put(Config.EVENT_PAGE_MAPPING, au.a().a(au.a.b));
            jSONObject.put(Config.EVENT_PATH_MAPPING, au.a().a(au.a.f2563a));
            jSONObject.put("sd", au.a().a(au.a.c));
        } catch (Exception e) {
        }
        String jSONObject2 = jSONObject.toString();
        int length = jSONObject2.getBytes().length;
        if (length < 184320) {
            this.e = length;
            bo.a(context, bw.u(context) + Config.STAT_FULL_CACHE_FILE_NAME, jSONObject2, false);
        }
    }

    private void b(Context context, JSONObject jSONObject) {
        CooperService.instance().getHeadObject().installHeader(context, jSONObject);
        try {
            jSONObject.put("t", System.currentTimeMillis());
            jSONObject.put(Config.SEQUENCE_INDEX, this.f);
            jSONObject.put("ss", BDStatCore.instance().getSessionStartTime());
            jSONObject.put("at", "1");
            jSONObject.put("sign", CooperService.instance().getUUID());
        } catch (Exception e) {
        }
    }

    private void d(Context context) {
        this.i = b(this.i, BDStatCore.instance().getPageSessionHead());
        b(context, false);
        b();
    }

    private void b() {
        this.f++;
    }

    private void c() {
        this.f = 0;
    }

    private void c(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(Config.TRACE_FAILED_CNT, 0);
            } catch (Exception e) {
            }
            try {
                jSONObject.put(Config.TRACE_PART, jSONObject2);
            } catch (Exception e2) {
            }
        }
    }

    private void b(JSONObject jSONObject) {
    }

    private void b(Context context, String str) {
        LogSender.instance().saveLogData(context, str, true);
        if (this.f2564a != null) {
            try {
                this.f2564a.a(new JSONObject(str));
            } catch (Exception e) {
            }
        }
    }

    public void a(final Context context, final ao aoVar) {
        this.d.post(new Runnable() { // from class: com.baidu.mobstat.aw.4
            @Override // java.lang.Runnable
            public void run() {
                if (BDStatCore.instance().getSessionStartTime() > 0) {
                    aw.this.b(context, aoVar);
                }
            }
        });
    }

    public void a(final Context context, final ArrayList<ap> arrayList) {
        this.d.post(new Runnable() { // from class: com.baidu.mobstat.aw.5
            @Override // java.lang.Runnable
            public void run() {
                aw.this.c(context, arrayList);
            }
        });
    }

    public void b(final Context context, final ArrayList<aq> arrayList) {
        this.d.post(new Runnable() { // from class: com.baidu.mobstat.aw.6
            @Override // java.lang.Runnable
            public void run() {
                aw.this.d(context, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, ao aoVar) {
        if (context != null && aoVar != null) {
            this.i = b(this.i, BDStatCore.instance().getPageSessionHead());
            if (this.i.length() != 0) {
                long a2 = a(this.i);
                if (a2 > 0) {
                    d(context, aoVar.a(a2, au.a().a(aoVar.a(), au.a.b), au.a().a(aoVar.b(), au.a.c)));
                    c(context);
                }
            }
        }
    }

    private void d(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            if (bh.c().b()) {
                bh.c().a("putPage: " + jSONObject.toString());
            }
            String jSONObject2 = jSONObject.toString();
            if (a(context, jSONObject2)) {
                if (bh.c().b()) {
                    bh.c().a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.e + "; addedSize:" + jSONObject2.length());
                }
                d(context);
            }
            a(this.i, jSONObject);
        }
    }

    private void a(JSONArray jSONArray, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONArray jSONArray2 = null;
        try {
            jSONObject2 = jSONArray.getJSONObject(0);
        } catch (Exception e) {
            jSONObject2 = null;
        }
        if (jSONObject2 != null) {
            try {
                jSONArray2 = jSONObject2.optJSONArray("p");
            } catch (Exception e2) {
            }
        }
        if (jSONArray2 == null) {
            JSONArray jSONArray3 = new JSONArray();
            jSONArray3.put(jSONObject);
            if (jSONObject2 != null) {
                try {
                    jSONObject2.put("p", jSONArray3);
                    return;
                } catch (Exception e3) {
                    return;
                }
            }
            return;
        }
        jSONArray2.put(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONArray b(JSONArray jSONArray, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONArray jSONArray2;
        JSONObject jSONObject4;
        JSONObject jSONObject5 = null;
        if (jSONObject != null && jSONArray != null && jSONObject.optLong("s") > 0) {
            JSONArray jSONArray3 = new JSONArray();
            if (jSONArray.length() == 0) {
                try {
                    jSONObject2 = new JSONObject(jSONObject.toString());
                    try {
                        jSONObject2.put("p", new JSONArray());
                    } catch (Exception e) {
                        jSONObject5 = jSONObject2;
                        jSONObject2 = jSONObject5;
                        if (jSONObject2 != null) {
                        }
                        return jSONArray3;
                    }
                } catch (Exception e2) {
                }
                if (jSONObject2 != null) {
                    jSONArray3.put(jSONObject2);
                }
            } else {
                try {
                    jSONObject3 = jSONArray.getJSONObject(0);
                } catch (Exception e3) {
                    jSONObject3 = null;
                }
                if (jSONObject3 != null) {
                    try {
                        jSONArray2 = jSONObject3.getJSONArray("p");
                    } catch (Exception e4) {
                        jSONArray2 = null;
                    }
                } else {
                    jSONArray2 = null;
                }
                try {
                    jSONObject4 = new JSONObject(jSONObject.toString());
                    if (jSONArray2 != null) {
                        try {
                            jSONObject4.put("p", jSONArray2);
                        } catch (Exception e5) {
                            jSONObject5 = jSONObject4;
                            jSONObject4 = jSONObject5;
                            if (jSONObject4 != null) {
                            }
                            return jSONArray3;
                        }
                    }
                } catch (Exception e6) {
                }
                if (jSONObject4 != null) {
                    jSONArray3.put(jSONObject4);
                }
            }
            return jSONArray3;
        }
        return jSONArray;
    }

    private long a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return 0L;
        }
        try {
            return jSONArray.getJSONObject(0).optLong("s");
        } catch (Exception e) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, ArrayList<ap> arrayList) {
        if (context != null && arrayList != null && arrayList.size() != 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<ap> it = arrayList.iterator();
            while (it.hasNext()) {
                ap next = it.next();
                JSONObject a2 = next.a(au.a().a(next.a(), au.a.c));
                if (a2 != null) {
                    jSONArray.put(a2);
                }
            }
            a(context, jSONArray);
            c(context);
        }
    }

    private void a(Context context, JSONArray jSONArray) {
        if (context != null && this.j != null && jSONArray != null && jSONArray.length() != 0) {
            if (bh.c().b()) {
                bh.c().a("putFeedList: " + jSONArray.toString());
            }
            String jSONArray2 = jSONArray.toString();
            if (a(context, jSONArray2)) {
                if (bh.c().b()) {
                    bh.c().a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.e + "; addedSize:" + jSONArray2.length());
                }
                d(context);
            }
            a(this.j, jSONArray);
        }
    }

    private void a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray != null && jSONArray2 != null) {
            for (int i = 0; i < jSONArray2.length(); i++) {
                try {
                    jSONArray.put(jSONArray2.getJSONObject(i));
                } catch (Exception e) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, ArrayList<aq> arrayList) {
        if (context != null && arrayList != null && arrayList.size() != 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<aq> it = arrayList.iterator();
            while (it.hasNext()) {
                aq next = it.next();
                JSONObject a2 = next.a(au.a().a(next.b(), au.a.b), au.a().a(next.f(), au.a.c), bj.c(next.c()));
                if (a2 != null) {
                    jSONArray.put(a2);
                }
            }
            b(context, jSONArray);
            c(context);
        }
    }

    private void b(Context context, JSONArray jSONArray) {
        if (context != null && this.k != null && jSONArray != null && jSONArray.length() != 0) {
            if (bh.c().b()) {
                bh.c().a("putFeedListItem: " + jSONArray.toString());
            }
            String jSONArray2 = jSONArray.toString();
            if (a(context, jSONArray2)) {
                if (bh.c().b()) {
                    bh.c().a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.e + "; addedSize:" + jSONArray2.length());
                }
                d(context);
            }
            b(this.k, jSONArray);
        }
    }

    private void b(JSONArray jSONArray, JSONArray jSONArray2) {
        JSONObject jSONObject;
        if (jSONArray != null && jSONArray2 != null) {
            for (int i = 0; i < jSONArray2.length(); i++) {
                try {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                    if (jSONObject2 != null && jSONObject2.length() != 0) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= jSONArray.length()) {
                                jSONObject = null;
                                break;
                            }
                            jSONObject = jSONArray.getJSONObject(i2);
                            if (jSONObject != null && jSONObject.length() != 0 && a(jSONObject, jSONObject2)) {
                                break;
                            }
                            i2++;
                        }
                        if (jSONObject == null) {
                            jSONArray.put(jSONObject2);
                        } else {
                            b(jSONObject, jSONObject2);
                        }
                    }
                } catch (Exception e) {
                    return;
                }
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
        if (!a(optString, optString7) || !a(optString2, optString8) || !a(optString3, optString9) || !a(optString4, optString10) || !a(optString5, optString11) || !a(optString6, optString12) || optInt != optInt2) {
            return false;
        }
        return true;
    }

    private void b(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        String str2;
        String optString = jSONObject.optString("d");
        int optInt = jSONObject.optInt("c");
        long optLong = jSONObject.optLong("t");
        String optString2 = jSONObject.optString("ps");
        String optString3 = jSONObject2.optString("d");
        int optInt2 = jSONObject2.optInt("c");
        long optLong2 = jSONObject2.optLong("t");
        String optString4 = jSONObject2.optString("ps");
        int i = optInt + optInt2;
        long j = optLong <= optLong2 ? optLong : optLong2;
        if (optLong <= optLong2) {
            str = optString + "|" + optString3;
        } else {
            str = optString3 + "|" + optString;
        }
        if (optLong <= optLong2) {
            long j2 = optLong2 - optLong;
            StringBuilder sb = new StringBuilder();
            String[] split = optString4.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            if (split == null || split.length == 0) {
                long j3 = 0;
                try {
                    j3 = Long.valueOf(optString4).longValue();
                } catch (Exception e) {
                }
                sb.append(j3 + j2);
            } else {
                for (String str3 : split) {
                    if (!TextUtils.isEmpty(sb.toString())) {
                        sb.append("|");
                    }
                    long j4 = 0;
                    try {
                        j4 = Long.valueOf(str3).longValue();
                    } catch (Exception e2) {
                    }
                    sb.append(j4 + j2);
                }
            }
            str2 = optString2 + "|" + sb.toString();
        } else {
            long j5 = optLong - optLong2;
            StringBuilder sb2 = new StringBuilder();
            String[] split2 = optString2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            if (split2 == null || split2.length == 0) {
                long j6 = 0;
                try {
                    j6 = Long.valueOf(optString2).longValue();
                } catch (Exception e3) {
                }
                sb2.append(j6 + j5);
            } else {
                for (String str4 : split2) {
                    if (!TextUtils.isEmpty(sb2.toString())) {
                        sb2.append("|");
                    }
                    long j7 = 0;
                    try {
                        j7 = Long.valueOf(str4).longValue();
                    } catch (Exception e4) {
                    }
                    sb2.append(j7 + j5);
                }
            }
            str2 = optString4 + "|" + sb2.toString();
        }
        try {
            jSONObject.put("c", i);
            jSONObject.put("t", j);
            jSONObject.put("d", str);
            jSONObject.put("ps", str2);
        } catch (Exception e5) {
        }
    }

    private boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals(str2)) ? false : true;
    }
}
