package com.baidu.adp.lib.stats;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.switchs.SwitchKey;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class g {
    private static g a;
    private static i s = null;
    private Context b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q = null;
    private String r = null;
    private e t = null;
    private a u = null;
    private c v = null;
    private BdStatSwitchData w = null;
    private j x;
    private h y;

    public static g a() {
        synchronized (g.class) {
            if (a == null) {
                a = new g();
            }
        }
        return a;
    }

    public final void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.b = context;
        this.o = str;
        this.p = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.j = str7;
        this.k = str8;
        this.m = Build.MODEL;
        this.n = Build.VERSION.RELEASE;
        this.l = str9;
        if (this.x == null && context != null) {
            try {
                this.x = new j(this, (byte) 0);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(this.x, intentFilter);
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(e.getMessage());
            }
        }
        if (this.y == null && context != null) {
            this.y = new h(this, (byte) 0);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("adp.bdstatisticsmanager2.account_changed");
            context.registerReceiver(this.y, intentFilter2);
        }
        if (s == null) {
            HandlerThread handlerThread = new HandlerThread("FILE_HANDLER", 10);
            handlerThread.start();
            s = new i(this, handlerThread.getLooper());
        }
        if (TextUtils.isEmpty(str10)) {
            str10 = String.valueOf(String.valueOf(Environment.getExternalStorageDirectory().toString()) + File.separator + this.c) + File.separator + "log";
        }
        this.w = new BdStatSwitchData();
        if (this.t == null) {
            this.t = new e(context, s, str10);
        }
        if (this.u == null) {
            this.u = new a(context, s, str10);
        }
        if (this.v == null) {
            this.v = new c(context, s, str10);
        }
        a(this.w);
        f();
    }

    private static void f() {
        s.removeMessages(8);
        s.sendMessage(s.obtainMessage(8));
    }

    public static /* synthetic */ void a(g gVar) {
        gVar.q = o.a(gVar.b);
        gVar.r = o.b(gVar.b);
        boolean a2 = com.baidu.adp.lib.network.i.a();
        if (gVar.t != null) {
            gVar.t.c(a2);
        }
        if (gVar.u != null) {
            gVar.u.c(a2);
        }
        if (gVar.v != null) {
            gVar.v.c(a2);
        }
    }

    public final synchronized void a(String str, String str2, String str3) {
        if ((this.g != null || str != null) && (this.g == null || !this.g.equals(str))) {
            this.g = str;
            this.h = str2;
            this.i = str3;
            if (this.t != null) {
                this.t.a(true);
            }
            if (this.u != null) {
                this.u.a(true);
            }
            if (this.v != null) {
                this.v.a(true);
            }
            f();
        }
    }

    public final void a(String str, Object... objArr) {
        d a2;
        if (!TextUtils.isEmpty(str) && objArr != null && objArr.length != 0 && (a2 = a(str)) != null && a2.i()) {
            p pVar = new p(str);
            pVar.a(objArr);
            a2.a(pVar);
        }
    }

    public final void a(String str, String str2, String str3, long j, long j2, long j3, long j4, long j5, int i, int i2, String str4, Object... objArr) {
        a("img", null, str2, str3, j, j2, j3, j4, j5, i, i2, str4, objArr);
    }

    public final void b(String str, String str2, String str3, long j, long j2, long j3, long j4, long j5, int i, int i2, String str4, Object... objArr) {
        a("d", str, str2, str3, j, j2, j3, j4, j5, i, i2, str4, objArr);
    }

    private void a(String str, String str2, String str3, String str4, long j, long j2, long j3, long j4, long j5, int i, int i2, String str5, Object... objArr) {
        d a2 = a(com.baidu.loginshare.e.e);
        if (a2 != null && a2.i() && a2.c(str) && !l.a().a(com.baidu.loginshare.e.e)) {
            p pVar = new p(com.baidu.loginshare.e.e);
            pVar.a("module", com.baidu.loginshare.e.e, "st", str, com.baidu.loginshare.e.e, this.q, "interface", str2, "f", str4, "cost", Long.valueOf(j3), "con_cost", Long.valueOf(j4), "rsp_cost", Long.valueOf(j5), "size_u", Long.valueOf(j2), "size_d", Long.valueOf(j), "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                pVar.a(objArr);
            }
            if (i2 != 0) {
                pVar.a("sid", str3);
                pVar.a("result", Integer.valueOf(i2));
                pVar.a("es", str5);
            }
            if (i > 0) {
                pVar.a("retry", Integer.valueOf(i));
            }
            a2.a(pVar);
        }
    }

    public final void a(String str, String str2, String str3, long j, int i, String str4, Object... objArr) {
        a(true, "d", str, str2, null, j, i, str4, objArr);
    }

    public final void a(boolean z, String str, String str2, String str3, String str4, long j, int i, String str5, Object... objArr) {
        d a2 = a("op");
        if (a2 != null && a2.i() && a2.c(str)) {
            if (!z || !l.a().a("op")) {
                p pVar = new p("op");
                pVar.a("module", "op", "st", str, "op_key", str2, "sid", str3, "f", str4, "cost", Long.valueOf(j), "result", Integer.valueOf(i), "es", str5, "t", String.valueOf(System.currentTimeMillis()));
                if (objArr != null && objArr.length > 0) {
                    pVar.a(objArr);
                }
                a2.a(pVar);
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4, int i, String str5, Object... objArr) {
        a(true, str, str2, str3, str4, 0L, i, str5, objArr);
    }

    public final void a(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!l.a().a("file")) {
            a(true, "file", str, null, str3, 0L, i, str4, objArr);
        }
    }

    public final void b(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!l.a().a("db")) {
            a(true, "db", str, null, str3, 0L, i, str4, objArr);
        }
    }

    public final void c(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!l.a().a("img")) {
            a(true, "img", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public final void d(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!l.a().a(SwitchKey.VOICE)) {
            a(true, SwitchKey.VOICE, str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public final void a(String str, String str2, String str3, Object... objArr) {
        d a2 = a("crash");
        if (a2 != null && a2.i()) {
            p pVar = new p("crash");
            pVar.a("module", "crash", "crash_type", str, "ci", 0, "f", 0, "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                pVar.a(objArr);
            }
            a2.a(pVar);
        }
    }

    public final void b(String str, Object... objArr) {
        d a2 = a("dbg");
        if (a2 != null && a2.i() && a2.c(str)) {
            p pVar = new p("dbg");
            pVar.a("module", "dbg", "st", str, "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                pVar.a(objArr);
            }
            a2.a(pVar);
        }
    }

    public final void a(String str, String str2, int i, Object... objArr) {
        d a2 = a("stat");
        if (a2 != null && a2.i() && !l.a().a("stat")) {
            p pVar = new p("stat");
            pVar.a("module", "stat", "op_key", str, "pt", str2, "co", Integer.valueOf(i), "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                pVar.a(objArr);
                pVar.a((Object) "mi", (Object) 0);
            }
            a2.a(pVar);
        }
    }

    public final void b() {
        if (this.t != null) {
            this.t.b(true);
        }
        if (this.v != null) {
            this.v.b(true);
        }
        if (this.u != null) {
            this.u.b(true);
        }
    }

    public final void c() {
        if (this.t != null) {
            this.t.a(true);
        }
        if (this.v != null) {
            this.v.a(true);
        }
        if (this.u != null) {
            this.u.a(true);
        }
    }

    public static /* synthetic */ void g(g gVar) {
        try {
            String a2 = gVar.a(false);
            byte[] bytes = TextUtils.isEmpty(a2) ? null : a2.getBytes();
            com.baidu.adp.lib.network.e.a();
            com.baidu.adp.lib.network.f a3 = com.baidu.adp.lib.network.b.a(false, gVar.p, bytes, 3, -1, null, null, null);
            if (a3 != null) {
                String str = new String(a3.d, "utf-8");
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
                bdStatSwitchData.parserJson(str);
                if (bdStatSwitchData.getError_code() == 0) {
                    gVar.a(bdStatSwitchData);
                    if (bdStatSwitchData.getDebug() != null && bdStatSwitchData.getDebug().getCommon() != null && !bdStatSwitchData.getDebug().getCommon().isIs_open()) {
                        gVar.u.e();
                    }
                    if (bdStatSwitchData.getError() != null && bdStatSwitchData.getError().getCommon() != null && !bdStatSwitchData.getError().getCommon().isIs_open()) {
                        gVar.v.e();
                    }
                    if (bdStatSwitchData.getStat() != null && bdStatSwitchData.getStat().getCommon() != null && !bdStatSwitchData.getStat().getCommon().isIs_open()) {
                        gVar.t.e();
                    }
                    s.removeMessages(7);
                    s.sendMessage(s.obtainMessage(7));
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.a(gVar.getClass(), "syncSwitch", e);
        }
    }

    private void a(BdStatSwitchData bdStatSwitchData) {
        if (bdStatSwitchData == null) {
            return;
        }
        synchronized (BdStatSwitchData.class) {
            this.w = bdStatSwitchData;
            if (this.w.getError() != null && this.v != null) {
                this.v.a(this.w.getError());
            }
            if (this.w.getStat() != null && this.t != null) {
                this.t.a(this.w.getStat());
            }
            if (this.w.getDebug() != null && this.u != null) {
                this.u.a(this.w.getDebug());
            }
        }
    }

    public static /* synthetic */ void b(g gVar, d dVar) {
        ArrayList<String> a2;
        if (dVar == null || dVar.h() || !dVar.i()) {
            return;
        }
        dVar.d(true);
        try {
            String a3 = (dVar.c() == null || !dVar.c().equals("omp")) ? gVar.a(true) : gVar.g();
            if (dVar.d()) {
                ArrayList<String> k = dVar.k();
                dVar.l();
                ArrayList<String> a4 = dVar.a(k);
                if (a4 != null && a4.size() > 0) {
                    gVar.a(dVar, a3, a4, (String) null);
                }
            } else {
                ArrayList<String> b = dVar.b();
                if (b != null && b.size() > 0) {
                    Iterator<String> it = b.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!TextUtils.isEmpty(next) && (a2 = dVar.a(gVar.b(next))) != null && a2.size() != 0) {
                            gVar.a(dVar, a3, a2, next);
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.a(gVar.getClass(), "upload", e);
        }
        dVar.d(false);
        dVar.a();
        dVar.a(gVar.g);
    }

    private void a(d dVar, String str, ArrayList<String> arrayList, String str2) {
        byte[] a2;
        if (dVar != null && (a2 = a(str, arrayList)) != null && a2.length > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(a2.length / 2);
            if (a2 != null) {
                try {
                    if (a2.length != 0) {
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                        gZIPOutputStream.write(a2, 0, a2.length);
                        gZIPOutputStream.flush();
                        gZIPOutputStream.finish();
                        gZIPOutputStream.close();
                    }
                } catch (Exception e) {
                    com.baidu.adp.lib.util.e.a(getClass(), "compressAndUpload", e);
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            HashMap hashMap = new HashMap();
            hashMap.put(dVar.c(), byteArray);
            try {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new BasicNameValuePair("_client_type", "2"));
                arrayList2.add(new BasicNameValuePair("_client_version", this.e));
                arrayList2.add(new BasicNameValuePair("_phone_imei", this.l));
                arrayList2.add(new BasicNameValuePair("_client_id", this.j));
                arrayList2.add(new BasicNameValuePair("from", this.f));
                arrayList2.add(new BasicNameValuePair("net_type", this.r));
                arrayList2.add(new BasicNameValuePair(SocialConstants.PARAM_CUID, this.k));
                arrayList2.add(new BasicNameValuePair("model", this.m));
                if (TextUtils.isEmpty(this.g)) {
                    arrayList2.add(new BasicNameValuePair(SapiAccountManager.SESSION_UID, SocialConstants.FALSE));
                } else {
                    arrayList2.add(new BasicNameValuePair(SapiAccountManager.SESSION_UID, this.g));
                }
                arrayList2.add(new BasicNameValuePair("un", this.h));
                arrayList2.add(new BasicNameValuePair("BDUSS", this.i));
                com.baidu.adp.lib.network.e.a();
                com.baidu.adp.lib.network.f a3 = com.baidu.adp.lib.network.e.a(this.o, false, arrayList2, hashMap, 3, -1, null, null, null);
                if (a3 != null && a3.a == 200) {
                    dVar.b(str2);
                }
            } catch (Exception e2) {
                com.baidu.adp.lib.util.e.a(getClass(), "compressAndUpload", e2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(boolean z) {
        String str;
        String[] split;
        StringBuilder sb = new StringBuilder();
        sb.append("_client_type=2");
        String str2 = this.e;
        if (!TextUtils.isEmpty(str2)) {
            if (str2.split("\\.").length == 4) {
                str = String.valueOf(split[0]) + "." + split[1] + "." + split[2];
                try {
                    StringBuilder append = sb.append("&new_four_version").append("=");
                    if (z) {
                        str2 = URLEncoder.encode(str2, "utf-8");
                    }
                    append.append(str2);
                } catch (UnsupportedEncodingException e) {
                    com.baidu.adp.lib.util.e.a(getClass(), "generalStatCommonPostdata", e);
                }
                a(sb, "_client_version", str, z);
                a(sb, "_phone_imei", this.l, z);
                a(sb, "_client_id", this.j, z);
                a(sb, "from", this.f, z);
                a(sb, "net_type", this.r, z);
                a(sb, SocialConstants.PARAM_CUID, this.k, z);
                a(sb, "model", this.m, z);
                if (!TextUtils.isEmpty(this.g)) {
                    a(sb, SapiAccountManager.SESSION_UID, SocialConstants.FALSE, z);
                } else {
                    a(sb, SapiAccountManager.SESSION_UID, this.g, z);
                }
                a(sb, "un", this.h, z);
                a(sb, "BDUSS", this.i, z);
                return sb.toString();
            }
        }
        str = str2;
        a(sb, "_client_version", str, z);
        a(sb, "_phone_imei", this.l, z);
        a(sb, "_client_id", this.j, z);
        a(sb, "from", this.f, z);
        a(sb, "net_type", this.r, z);
        a(sb, SocialConstants.PARAM_CUID, this.k, z);
        a(sb, "model", this.m, z);
        if (!TextUtils.isEmpty(this.g)) {
        }
        a(sb, "un", this.h, z);
        a(sb, "BDUSS", this.i, z);
        return sb.toString();
    }

    private void a(StringBuilder sb, String str, String str2, boolean z) {
        if (sb != null && !TextUtils.isEmpty(str)) {
            try {
                String str3 = TextUtils.isEmpty(str2) ? "" : str2;
                StringBuilder append = sb.append("&").append(str).append("=");
                if (z) {
                    str3 = URLEncoder.encode(str3, "utf-8");
                }
                append.append(str3);
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.a(getClass(), "AppendParam", e);
            }
        }
    }

    private String g() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("product");
            sb.append("=");
            sb.append(URLEncoder.encode(this.c, "utf-8"));
            sb.append("&");
            sb.append("sub_sys");
            sb.append("=");
            sb.append(URLEncoder.encode(this.d, "utf-8"));
            sb.append("&");
            sb.append("version");
            sb.append("=");
            sb.append(URLEncoder.encode(this.e, "utf-8"));
            sb.append("&");
            sb.append("os");
            sb.append("=");
            sb.append(SocialConstants.ANDROID_CLIENT_TYPE);
            sb.append("&");
            sb.append("os_version");
            sb.append("=");
            sb.append(URLEncoder.encode(this.n, "utf-8"));
            if (!TextUtils.isEmpty(this.f)) {
                sb.append("&");
                sb.append("from");
                sb.append("=");
                sb.append(URLEncoder.encode(this.f, "utf-8"));
            }
            sb.append("&");
            sb.append("phone");
            sb.append("=");
            sb.append(URLEncoder.encode(this.m, "utf-8"));
            if (!TextUtils.isEmpty(this.g)) {
                sb.append("&");
                sb.append(SapiAccountManager.SESSION_UID);
                sb.append("=");
                sb.append(URLEncoder.encode(this.g, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.j)) {
                sb.append("&");
                sb.append(SocialConstants.PARAM_CLIENT_ID);
                sb.append("=");
                sb.append(URLEncoder.encode(this.j, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.l)) {
                sb.append("&");
                sb.append("imei");
                sb.append("=");
                sb.append(URLEncoder.encode(this.l, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.h)) {
                sb.append("&");
                sb.append("uname");
                sb.append("=");
                sb.append(URLEncoder.encode(this.h, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.k)) {
                sb.append("&");
                sb.append(SocialConstants.PARAM_CUID);
                sb.append("=");
                sb.append(URLEncoder.encode(this.k, "utf-8"));
            }
            sb.append("&");
            sb.append(com.baidu.loginshare.e.e);
            sb.append("=");
            sb.append(URLEncoder.encode(this.q, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            com.baidu.adp.lib.util.e.a(getClass(), "generalCommonPostdata", e);
        }
        return sb.toString();
    }

    private byte[] a(String str, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                sb.append("&rec");
                sb.append(i);
                sb.append('=');
                try {
                    sb.append(URLEncoder.encode(arrayList.get(i), "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    com.baidu.adp.lib.util.e.a(getClass(), "generatePostdata", e);
                }
            }
            return sb.toString().getBytes();
        } catch (Exception e2) {
            com.baidu.adp.lib.util.e.a(getClass(), "generatePostdata", e2);
            return null;
        }
    }

    private d a(String str) {
        if (this.v != null && (str.equals(com.baidu.loginshare.e.e) || str.equals("op") || str.equals("crash"))) {
            return this.v;
        }
        if (this.u != null && str.equals("dbg")) {
            return this.u;
        }
        if (this.t != null && str.equals("stat")) {
            return this.t;
        }
        return this.v;
    }

    private ArrayList<String> b(String str) {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        Throwable th;
        BufferedReader bufferedReader2;
        IOException e;
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                try {
                    fileInputStream = new FileInputStream(str);
                    try {
                        inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
                        try {
                            bufferedReader2 = new BufferedReader(inputStreamReader);
                            while (true) {
                                try {
                                    String readLine = bufferedReader2.readLine();
                                    if (readLine != null) {
                                        arrayList.add(readLine);
                                    } else {
                                        try {
                                            break;
                                        } catch (IOException e2) {
                                            com.baidu.adp.lib.util.e.a(getClass(), "readLogFile", e2);
                                        }
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    com.baidu.adp.lib.util.e.a(getClass(), "readLogFile", e);
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException e4) {
                                            com.baidu.adp.lib.util.e.a(getClass(), "readLogFile", e4);
                                        }
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                    }
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                    return arrayList;
                                }
                            }
                            bufferedReader2.close();
                            inputStreamReader.close();
                            fileInputStream.close();
                        } catch (IOException e5) {
                            bufferedReader2 = null;
                            e = e5;
                        } catch (Throwable th2) {
                            bufferedReader = null;
                            th = th2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e6) {
                                    com.baidu.adp.lib.util.e.a(getClass(), "readLogFile", e6);
                                    throw th;
                                }
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    } catch (IOException e7) {
                        inputStreamReader = null;
                        e = e7;
                        bufferedReader2 = null;
                    } catch (Throwable th3) {
                        bufferedReader = null;
                        inputStreamReader = null;
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (IOException e8) {
                inputStreamReader = null;
                fileInputStream = null;
                bufferedReader2 = null;
                e = e8;
            } catch (Throwable th5) {
                bufferedReader = null;
                inputStreamReader = null;
                fileInputStream = null;
                th = th5;
            }
            return arrayList;
        }
        return null;
    }

    public static /* synthetic */ void a(g gVar, d dVar) {
        if (dVar == null || dVar.h()) {
            return;
        }
        dVar.a();
        if (dVar.f() == null) {
            if (gVar.g != null) {
                dVar.a(gVar.g);
            }
        } else if (dVar.f().equals(gVar.g)) {
        } else {
            dVar.a(gVar.g);
        }
    }

    public final long d() {
        long uploadMilliInterval;
        synchronized (BdStatSwitchData.class) {
            if (this.w == null) {
                this.w = new BdStatSwitchData();
            }
            uploadMilliInterval = this.w.getUploadMilliInterval();
        }
        return uploadMilliInterval;
    }
}
