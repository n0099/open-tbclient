package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.mobstat.at;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class av {
    public static av b = new av();
    public static String l = "";
    public a a;
    public Handler d;
    public volatile int e;
    public int f;
    public HandlerThread c = new HandlerThread("fullTraceHandleThread");
    public JSONObject g = new JSONObject();
    public JSONArray h = new JSONArray();
    public JSONArray i = new JSONArray();
    public JSONArray j = new JSONArray();
    public JSONArray k = new JSONArray();
    public boolean m = false;
    public List<JSONObject> n = new ArrayList();
    public List<String> o = new ArrayList();
    public List<String> p = new ArrayList();

    /* loaded from: classes3.dex */
    public interface a {
        void a(JSONObject jSONObject);
    }

    private void b(JSONObject jSONObject) {
    }

    public void b(String str) {
    }

    public static av a() {
        return b;
    }

    private void d() {
        this.f++;
    }

    private void e() {
        this.f = 0;
    }

    public int b() {
        return this.f;
    }

    public boolean c() {
        return this.m;
    }

    public av() {
        this.c.start();
        this.c.setPriority(10);
        this.d = new Handler(this.c.getLooper());
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

    private void d(Context context) {
        this.i = b(this.i, BDStatCore.instance().getPageSessionHead());
        b(context, false);
        d();
    }

    public void b(Context context) {
        CooperService.instance().getHeadObject().installHeader(context, this.g);
    }

    private boolean b(Context context, String str) {
        int i;
        if (str != null) {
            i = str.getBytes().length;
        } else {
            i = 0;
        }
        if (i + this.e <= 184320) {
            return false;
        }
        return true;
    }

    private void c(Context context, String str) {
        LogSender.instance().saveLogData(context, str, true);
        if (this.a != null) {
            try {
                this.a.a(new JSONObject(str));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j, String str, String str2, String str3, int i, long j2, String str4, JSONArray jSONArray, String str5, JSONArray jSONArray2, String str6, Map<String, String> map, boolean z, JSONObject jSONObject, String str7, JSONArray jSONArray3) {
        a(context, EventAnalysis.getEvent(context, j, str, str2, str3, i, j2, 0L, "", null, null, bi.a(str4), bi.a(str5), str6, Config.EventViewType.EDIT.getValue(), 3, null, map, bi.c(jSONArray), bi.d(jSONArray2), z, jSONObject, str7, jSONArray3));
        c(context);
    }

    private void a(Context context, JSONArray jSONArray) {
        if (context != null && this.j != null && jSONArray != null && jSONArray.length() != 0) {
            if (bg.c().b()) {
                bg c = bg.c();
                c.a("putFeedList: " + jSONArray.toString());
            }
            String jSONArray2 = jSONArray.toString();
            if (b(context, jSONArray2)) {
                if (bg.c().b()) {
                    bg c2 = bg.c();
                    c2.a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.e + "; addedSize:" + jSONArray2.length());
                }
                d(context);
            }
            a(this.j, jSONArray);
        }
    }

    private void b(Context context, JSONArray jSONArray) {
        if (context != null && this.k != null && jSONArray != null && jSONArray.length() != 0) {
            if (bg.c().b()) {
                bg c = bg.c();
                c.a("putFeedListItem: " + jSONArray.toString());
            }
            String jSONArray2 = jSONArray.toString();
            if (b(context, jSONArray2)) {
                if (bg.c().b()) {
                    bg c2 = bg.c();
                    c2.a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.e + "; addedSize:" + jSONArray2.length());
                }
                d(context);
            }
            b(this.k, jSONArray);
        }
    }

    private void d(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (bg.c().b()) {
            bg c = bg.c();
            c.a("putPage: " + jSONObject.toString());
        }
        String jSONObject2 = jSONObject.toString();
        if (b(context, jSONObject2)) {
            if (bg.c().b()) {
                bg c2 = bg.c();
                c2.a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.e + "; addedSize:" + jSONObject2.length());
            }
            d(context);
        }
        a(this.i, jSONObject);
    }

    private void a(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (bg.c().b()) {
            bg c = bg.c();
            c.a("putEvent: " + jSONObject.toString());
        }
        String jSONObject2 = jSONObject.toString();
        if (b(context, jSONObject2)) {
            if (bg.c().b()) {
                bg c2 = bg.c();
                c2.a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.e + "; addedSize:" + jSONObject2.length());
            }
            d(context);
        }
        try {
            jSONObject.put(Config.EVENT_NEXT_PAGENAME, "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        EventAnalysis.doEventMerge(this.h, jSONObject);
    }

    private void a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray != null && jSONArray2 != null) {
            for (int i = 0; i < jSONArray2.length(); i++) {
                try {
                    jSONArray.put(jSONArray2.getJSONObject(i));
                } catch (Exception unused) {
                    return;
                }
            }
        }
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
            jSONObject.put("trace", jSONObject2);
        } catch (Exception unused2) {
        }
    }

    public void b(final Context context, final ArrayList<ap> arrayList) {
        if (CooperService.instance().isCloseTrace() || !bu.a().e()) {
            return;
        }
        this.d.post(new Runnable() { // from class: com.baidu.mobstat.av.6
            @Override // java.lang.Runnable
            public void run() {
                av.this.d(context, arrayList);
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

    private boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.equals(str2)) {
            return true;
        }
        return false;
    }

    private boolean a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
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
        return false;
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
        if (jSONObject != null && jSONArray != null) {
            if (jSONObject.optLong("s") <= 0) {
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
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, ArrayList<ap> arrayList) {
        if (context != null && arrayList != null && arrayList.size() != 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<ap> it = arrayList.iterator();
            while (it.hasNext()) {
                ap next = it.next();
                JSONObject a2 = next.a(at.a().a(next.b(), at.a.b), at.a().a(next.f(), at.a.c), bi.c(next.c()));
                if (a2 != null) {
                    jSONArray.put(a2);
                }
            }
            b(context, jSONArray);
            c(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, an anVar) {
        if (context != null && anVar != null) {
            JSONArray b2 = b(this.i, BDStatCore.instance().getPageSessionHead());
            this.i = b2;
            if (b2.length() == 0) {
                return;
            }
            long a2 = a(this.i);
            if (a2 <= 0) {
                return;
            }
            d(context, anVar.a(a2, at.a().a(anVar.a(), at.a.b), at.a().a(anVar.b(), at.a.c)));
            c(context);
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
            jSONObject.put(Config.PY, DataCore.instance().getHeadSessionPy());
            jSONObject.put(Config.PLT, CooperService.instance().getPlatformType());
        } catch (Exception unused) {
        }
    }

    private void b(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray != null && jSONArray2 != null) {
            for (int i = 0; i < jSONArray2.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray2.getJSONObject(i);
                    if (jSONObject != null && jSONObject.length() != 0) {
                        JSONObject jSONObject2 = null;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= jSONArray.length()) {
                                break;
                            }
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                            if (jSONObject3 != null && jSONObject3.length() != 0 && a(jSONObject3, jSONObject)) {
                                jSONObject2 = jSONObject3;
                                break;
                            }
                            i2++;
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
    }

    private void b(JSONObject jSONObject, JSONObject jSONObject2) {
        long j;
        String str;
        String str2;
        String str3;
        long j2;
        long j3;
        String optString = jSONObject.optString("d");
        int optInt = jSONObject.optInt("c");
        long optLong = jSONObject.optLong("t");
        String optString2 = jSONObject.optString("ps");
        String optString3 = jSONObject2.optString("d");
        int optInt2 = jSONObject2.optInt("c");
        long optLong2 = jSONObject2.optLong("t");
        String optString4 = jSONObject2.optString("ps");
        int i = optInt + optInt2;
        int i2 = (optLong > optLong2 ? 1 : (optLong == optLong2 ? 0 : -1));
        if (i2 <= 0) {
            j = optLong;
        } else {
            j = optLong2;
        }
        if (i2 <= 0) {
            str = "ps";
            str2 = optString + "|" + optString3;
        } else {
            str = "ps";
            str2 = optString3 + "|" + optString;
        }
        int i3 = 0;
        long j4 = 0;
        if (i2 <= 0) {
            long j5 = optLong2 - optLong;
            StringBuilder sb = new StringBuilder();
            String[] split = optString4.split(WebChromeClient.PARAM_SEPARATOR);
            if (split != null && split.length != 0) {
                int length = split.length;
                while (i3 < length) {
                    String str4 = split[i3];
                    if (!TextUtils.isEmpty(sb.toString())) {
                        sb.append("|");
                    }
                    try {
                        j3 = Long.valueOf(str4).longValue();
                    } catch (Exception unused) {
                        j3 = 0;
                    }
                    sb.append(j3 + j5);
                    i3++;
                }
            } else {
                try {
                    j4 = Long.valueOf(optString4).longValue();
                } catch (Exception unused2) {
                }
                sb.append(j5 + j4);
            }
            str3 = optString2 + "|" + sb.toString();
        } else {
            long j6 = optLong - optLong2;
            StringBuilder sb2 = new StringBuilder();
            String[] split2 = optString2.split(WebChromeClient.PARAM_SEPARATOR);
            if (split2 != null && split2.length != 0) {
                int length2 = split2.length;
                while (i3 < length2) {
                    String str5 = split2[i3];
                    if (!TextUtils.isEmpty(sb2.toString())) {
                        sb2.append("|");
                    }
                    try {
                        j2 = Long.valueOf(str5).longValue();
                    } catch (Exception unused3) {
                        j2 = 0;
                    }
                    sb2.append(j2 + j6);
                    i3++;
                }
            } else {
                try {
                    j4 = Long.valueOf(optString2).longValue();
                } catch (Exception unused4) {
                }
                sb2.append(j6 + j4);
            }
            str3 = optString4 + "|" + sb2.toString();
        }
        try {
            jSONObject.put("c", i);
            jSONObject.put("t", j);
            jSONObject.put("d", str2);
            jSONObject.put(str, str3);
        } catch (Exception unused5) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, ArrayList<ao> arrayList) {
        if (context != null && arrayList != null && arrayList.size() != 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<ao> it = arrayList.iterator();
            while (it.hasNext()) {
                ao next = it.next();
                JSONObject a2 = next.a(at.a().a(next.a(), at.a.c));
                if (a2 != null) {
                    jSONArray.put(a2);
                }
            }
            a(context, jSONArray);
            c(context);
        }
    }

    public void a(Context context) {
        String str;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONArray optJSONArray3;
        JSONArray optJSONArray4;
        if (context == null) {
            return;
        }
        try {
            this.m = true;
            e();
            str = bw.s(context) + Config.STAT_FULL_CACHE_FILE_NAME;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!bn.c(context, str)) {
            return;
        }
        String a2 = bn.a(context, str);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(a2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jSONObject == null) {
            return;
        }
        try {
            optJSONArray = jSONObject.optJSONArray(Config.EVENT_PART);
            optJSONArray2 = jSONObject.optJSONArray("pr");
            optJSONArray3 = jSONObject.optJSONArray(Config.FEED_LIST_PART);
            optJSONArray4 = jSONObject.optJSONArray("sv");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if ((optJSONArray != null && optJSONArray.length() != 0) || ((optJSONArray2 != null && optJSONArray2.length() != 0) || ((optJSONArray3 != null && optJSONArray3.length() != 0) || (optJSONArray4 != null && optJSONArray4.length() != 0)))) {
            b(context, jSONObject.getJSONObject(Config.HEADER_PART));
            c(context, jSONObject);
            b(jSONObject);
            a2 = jSONObject.toString();
            if (bg.c().b()) {
                bg.c().a("saveLastCacheToSend content: " + a2);
            }
            c(context, a2);
            c(context, false);
            this.m = false;
            return;
        }
        if (bg.c().b()) {
            bg.c().a("saveLastCacheToSend content:empty, return");
        }
    }

    public void a(final Context context, final an anVar) {
        if (CooperService.instance().isCloseTrace() || !bu.a().e()) {
            return;
        }
        this.d.post(new Runnable() { // from class: com.baidu.mobstat.av.4
            @Override // java.lang.Runnable
            public void run() {
                if (BDStatCore.instance().getSessionStartTime() <= 0) {
                    return;
                }
                av.this.b(context, anVar);
            }
        });
    }

    public void a(Context context, String str) {
        JSONArray jSONArray = this.h;
        if (jSONArray == null || jSONArray.length() == 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
            }
            JSONObject jSONObject = (JSONObject) this.h.get(this.h.length() - 1);
            if (jSONObject != null) {
                String optString = jSONObject.optString(Config.EVENT_NEXT_PAGENAME);
                long optLong = jSONObject.optLong("t");
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - optLong <= 1500 && TextUtils.isEmpty(optString)) {
                    jSONObject.put(Config.EVENT_NEXT_PAGENAME, str + "|" + currentTimeMillis);
                    this.h.put(this.h.length() + (-1), jSONObject);
                    c(context);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(Context context, String str, String str2, String str3, int i, long j, String str4, JSONArray jSONArray, String str5, JSONArray jSONArray2, String str6, Map<String, String> map, JSONObject jSONObject, String str7, JSONArray jSONArray3) {
        a(context, str, str2, str3, i, j, str4, jSONArray, str5, jSONArray2, str6, map, false, jSONObject, str7, jSONArray3);
    }

    public void a(final Context context, final String str, final String str2, final String str3, final int i, final long j, final String str4, final JSONArray jSONArray, final String str5, final JSONArray jSONArray2, final String str6, final Map<String, String> map, final boolean z, final JSONObject jSONObject, final String str7, final JSONArray jSONArray3) {
        if (!bu.a().e()) {
            return;
        }
        this.d.post(new Runnable() { // from class: com.baidu.mobstat.av.1
            @Override // java.lang.Runnable
            public void run() {
                long sessionStartTime = BDStatCore.instance().getSessionStartTime();
                if (sessionStartTime <= 0) {
                    return;
                }
                av.this.a(context, sessionStartTime, str, str2, str3, i, j, str4, jSONArray, str5, jSONArray2, str6, map, z, jSONObject, str7, jSONArray3);
            }
        });
    }

    public void a(final Context context, final ArrayList<ao> arrayList) {
        if (CooperService.instance().isCloseTrace() || !bu.a().e()) {
            return;
        }
        this.d.post(new Runnable() { // from class: com.baidu.mobstat.av.5
            @Override // java.lang.Runnable
            public void run() {
                av.this.c(context, arrayList);
            }
        });
    }

    public void a(final Context context, final boolean z) {
        this.d.post(new Runnable() { // from class: com.baidu.mobstat.av.2
            @Override // java.lang.Runnable
            public void run() {
                av.this.b(context, z);
            }
        });
    }

    public void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            l = str;
        } catch (Exception unused) {
        }
    }

    public void a(final JSONObject jSONObject) {
        this.d.post(new Runnable() { // from class: com.baidu.mobstat.av.3
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null && jSONObject2.length() != 0) {
                    av avVar = av.this;
                    avVar.i = avVar.b(avVar.i, jSONObject);
                }
            }
        });
    }

    public void b(Context context, boolean z) {
        try {
            if (z) {
                e();
            } else {
                d();
            }
            try {
                b(context, this.g);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.h.length() == 0 && this.i.length() == 0 && this.j.length() == 0 && this.k.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.HEADER_PART, this.g);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            jSONObject.put("pr", this.i);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            jSONObject.put(Config.EVENT_PART, this.h);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject.put(Config.FEED_LIST_PART, this.j);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            jSONObject.put("sv", this.k);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            jSONObject.put("pd", at.a().a(at.a.b));
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        try {
            jSONObject.put(Config.EVENT_PATH_MAPPING, at.a().a(at.a.a));
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        try {
            jSONObject.put("sd", at.a().a(at.a.c));
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        try {
            jSONObject.put(Config.PYD, l);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        c(context, jSONObject);
        b(jSONObject);
        String jSONObject2 = jSONObject.toString();
        if (bg.c().b()) {
            bg c = bg.c();
            c.a("saveCurrentCacheToSend content: " + jSONObject2);
        }
        c(context, jSONObject2);
        c(context, !z);
        this.m = true;
    }

    public void c(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.HEADER_PART, new JSONObject(this.g.toString()));
                jSONObject.put("pr", new JSONArray(this.i.toString()));
                jSONObject.put(Config.EVENT_PART, new JSONArray(this.h.toString()));
                jSONObject.put(Config.FEED_LIST_PART, new JSONArray(this.j.toString()));
                jSONObject.put("sv", new JSONArray(this.k.toString()));
                jSONObject.put(Config.PYD, l);
                jSONObject.put("pd", at.a().a(at.a.b));
                jSONObject.put(Config.EVENT_PATH_MAPPING, at.a().a(at.a.a));
                jSONObject.put("sd", at.a().a(at.a.c));
            } catch (Exception e) {
                e.printStackTrace();
            }
            String jSONObject2 = jSONObject.toString();
            int length = jSONObject2.getBytes().length;
            if (length >= 184320) {
                return;
            }
            this.e = length;
            String s = bw.s(context);
            bn.a(context, s + Config.STAT_FULL_CACHE_FILE_NAME, jSONObject2, false);
        } catch (Throwable th) {
            th.printStackTrace();
            StatService.closeTrace();
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
            at.a().b();
        }
        c(context);
    }
}
