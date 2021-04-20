package com.baidu.mapsdkplatform.comapi.favrite;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f7578b;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comjni.map.favorite.a f7579a = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7580c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7581d = false;

    /* renamed from: e  reason: collision with root package name */
    public Vector<String> f7582e = null;

    /* renamed from: f  reason: collision with root package name */
    public Vector<String> f7583f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7584g = false;

    /* renamed from: h  reason: collision with root package name */
    public c f7585h = new c();
    public b i = new b();

    /* renamed from: com.baidu.mapsdkplatform.comapi.favrite.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0098a implements Comparator<String> {
        public C0098a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str2.compareTo(str);
        }
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: b  reason: collision with root package name */
        public long f7588b;

        /* renamed from: c  reason: collision with root package name */
        public long f7589c;

        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f7588b = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.f7589c = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            return this.f7589c - this.f7588b > 1000;
        }
    }

    /* loaded from: classes2.dex */
    public class c {

        /* renamed from: b  reason: collision with root package name */
        public String f7591b;

        /* renamed from: c  reason: collision with root package name */
        public long f7592c;

        /* renamed from: d  reason: collision with root package name */
        public long f7593d;

        public c() {
            this.f7592c = 5000L;
            this.f7593d = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a() {
            return this.f7591b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            this.f7591b = str;
            this.f7593d = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            return TextUtils.isEmpty(this.f7591b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            return true;
        }
    }

    public static a a() {
        if (f7578b == null) {
            synchronized (a.class) {
                if (f7578b == null) {
                    a aVar = new a();
                    f7578b = aVar;
                    aVar.h();
                }
            }
        }
        return f7578b;
    }

    public static boolean g() {
        com.baidu.mapsdkplatform.comjni.map.favorite.a aVar;
        a aVar2 = f7578b;
        return (aVar2 == null || (aVar = aVar2.f7579a) == null || !aVar.d()) ? false : true;
    }

    private boolean h() {
        if (this.f7579a == null) {
            com.baidu.mapsdkplatform.comjni.map.favorite.a aVar = new com.baidu.mapsdkplatform.comjni.map.favorite.a();
            this.f7579a = aVar;
            if (aVar.a() == 0) {
                this.f7579a = null;
                return false;
            }
            j();
            i();
        }
        return true;
    }

    private boolean i() {
        if (this.f7579a == null) {
            return false;
        }
        String str = SysOSUtil.getModuleFileName() + "/";
        this.f7579a.a(1);
        return this.f7579a.a(str, "fav_poi", "fifo", 10, 501, -1);
    }

    private void j() {
        this.f7580c = false;
        this.f7581d = false;
    }

    public synchronized int a(String str, FavSyncPoi favSyncPoi) {
        if (this.f7579a == null) {
            return 0;
        }
        if (str != null && !str.equals("") && favSyncPoi != null) {
            j();
            ArrayList<String> e2 = e();
            if ((e2 != null ? e2.size() : 0) + 1 > 500) {
                return -2;
            }
            if (e2 != null && e2.size() > 0) {
                Iterator<String> it = e2.iterator();
                while (it.hasNext()) {
                    FavSyncPoi b2 = b(it.next());
                    if (b2 != null && str.equals(b2.f7571b)) {
                        return -1;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                favSyncPoi.f7571b = str;
                String valueOf = String.valueOf(System.currentTimeMillis());
                String str2 = valueOf + "_" + favSyncPoi.hashCode();
                favSyncPoi.f7577h = valueOf;
                favSyncPoi.f7570a = str2;
                jSONObject.put("bdetail", favSyncPoi.i);
                jSONObject.put("uspoiname", favSyncPoi.f7571b);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", favSyncPoi.f7572c.getmPtx());
                jSONObject2.put("y", favSyncPoi.f7572c.getmPty());
                jSONObject.put(Config.PLATFORM_TYPE, jSONObject2);
                jSONObject.put("ncityid", favSyncPoi.f7574e);
                jSONObject.put("npoitype", favSyncPoi.f7576g);
                jSONObject.put("uspoiuid", favSyncPoi.f7575f);
                jSONObject.put(DuPaBInfoMsg.B_ADDR, favSyncPoi.f7573d);
                jSONObject.put("addtimesec", favSyncPoi.f7577h);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("Fav_Sync", jSONObject);
                jSONObject3.put("Fav_Content", favSyncPoi.j);
                if (this.f7579a.a(str2, jSONObject3.toString())) {
                    j();
                    return 1;
                }
                return 0;
            } catch (JSONException unused) {
                return 0;
            } finally {
                g();
            }
        }
        return -1;
    }

    public synchronized boolean a(String str) {
        if (this.f7579a == null) {
            return false;
        }
        if (str != null && !str.equals("")) {
            if (c(str)) {
                j();
                return this.f7579a.a(str);
            }
            return false;
        }
        return false;
    }

    public FavSyncPoi b(String str) {
        if (this.f7579a != null && str != null && !str.equals("")) {
            try {
                if (c(str)) {
                    FavSyncPoi favSyncPoi = new FavSyncPoi();
                    String b2 = this.f7579a.b(str);
                    if (b2 != null && !b2.equals("")) {
                        JSONObject jSONObject = new JSONObject(b2);
                        JSONObject optJSONObject = jSONObject.optJSONObject("Fav_Sync");
                        String optString = jSONObject.optString("Fav_Content");
                        favSyncPoi.f7571b = optJSONObject.optString("uspoiname");
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject(Config.PLATFORM_TYPE);
                        favSyncPoi.f7572c = new Point(optJSONObject2.optInt("x"), optJSONObject2.optInt("y"));
                        favSyncPoi.f7574e = optJSONObject.optString("ncityid");
                        favSyncPoi.f7575f = optJSONObject.optString("uspoiuid");
                        favSyncPoi.f7576g = optJSONObject.optInt("npoitype");
                        favSyncPoi.f7573d = optJSONObject.optString(DuPaBInfoMsg.B_ADDR);
                        favSyncPoi.f7577h = optJSONObject.optString("addtimesec");
                        favSyncPoi.i = optJSONObject.optBoolean("bdetail");
                        favSyncPoi.j = optString;
                        favSyncPoi.f7570a = str;
                        return favSyncPoi;
                    }
                    return null;
                }
                return null;
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            } catch (JSONException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public void b() {
        a aVar = f7578b;
        if (aVar != null) {
            com.baidu.mapsdkplatform.comjni.map.favorite.a aVar2 = aVar.f7579a;
            if (aVar2 != null) {
                aVar2.b();
                f7578b.f7579a = null;
            }
            f7578b = null;
        }
    }

    public synchronized boolean b(String str, FavSyncPoi favSyncPoi) {
        boolean z = false;
        if (this.f7579a != null && str != null && !str.equals("") && favSyncPoi != null) {
            if (c(str)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("uspoiname", favSyncPoi.f7571b);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("x", favSyncPoi.f7572c.getmPtx());
                    jSONObject2.put("y", favSyncPoi.f7572c.getmPty());
                    jSONObject.put(Config.PLATFORM_TYPE, jSONObject2);
                    jSONObject.put("ncityid", favSyncPoi.f7574e);
                    jSONObject.put("npoitype", favSyncPoi.f7576g);
                    jSONObject.put("uspoiuid", favSyncPoi.f7575f);
                    jSONObject.put(DuPaBInfoMsg.B_ADDR, favSyncPoi.f7573d);
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    favSyncPoi.f7577h = valueOf;
                    jSONObject.put("addtimesec", valueOf);
                    jSONObject.put("bdetail", false);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("Fav_Sync", jSONObject);
                    jSONObject3.put("Fav_Content", favSyncPoi.j);
                    j();
                    if (this.f7579a != null) {
                        if (this.f7579a.b(str, jSONObject3.toString())) {
                            z = true;
                        }
                    }
                    return z;
                } catch (JSONException unused) {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    public synchronized boolean c() {
        if (this.f7579a == null) {
            return false;
        }
        j();
        boolean c2 = this.f7579a.c();
        g();
        return c2;
    }

    public boolean c(String str) {
        return (this.f7579a == null || str == null || str.equals("") || !this.f7579a.c(str)) ? false : true;
    }

    public ArrayList<String> d() {
        String b2;
        if (this.f7579a == null) {
            return null;
        }
        if (!this.f7581d || this.f7583f == null) {
            try {
                Bundle bundle = new Bundle();
                this.f7579a.a(bundle);
                String[] stringArray = bundle.getStringArray("rstString");
                if (stringArray != null) {
                    if (this.f7583f == null) {
                        this.f7583f = new Vector<>();
                    } else {
                        this.f7583f.clear();
                    }
                    for (int i = 0; i < stringArray.length; i++) {
                        if (!stringArray[i].equals("data_version") && (b2 = this.f7579a.b(stringArray[i])) != null && !b2.equals("")) {
                            this.f7583f.add(stringArray[i]);
                        }
                    }
                    if (this.f7583f.size() > 0) {
                        try {
                            Collections.sort(this.f7583f, new C0098a());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        this.f7581d = true;
                    }
                } else if (this.f7583f != null) {
                    this.f7583f.clear();
                    this.f7583f = null;
                }
                if (this.f7583f != null && !this.f7583f.isEmpty()) {
                    return new ArrayList<>(this.f7583f);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return new ArrayList<>(this.f7583f);
    }

    public ArrayList<String> e() {
        if (this.f7579a == null) {
            return null;
        }
        if (!this.f7580c || this.f7582e == null) {
            try {
                Bundle bundle = new Bundle();
                this.f7579a.a(bundle);
                String[] stringArray = bundle.getStringArray("rstString");
                if (stringArray != null) {
                    if (this.f7582e == null) {
                        this.f7582e = new Vector<>();
                    } else {
                        this.f7582e.clear();
                    }
                    for (String str : stringArray) {
                        if (!str.equals("data_version")) {
                            this.f7582e.add(str);
                        }
                    }
                    if (this.f7582e.size() > 0) {
                        try {
                            Collections.sort(this.f7582e, new C0098a());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        this.f7580c = true;
                    }
                } else if (this.f7582e != null) {
                    this.f7582e.clear();
                    this.f7582e = null;
                }
                Vector<String> vector = this.f7582e;
                if (vector == null || vector.size() == 0) {
                    return null;
                }
                return new ArrayList<>(this.f7582e);
            } catch (Exception unused) {
                return null;
            }
        }
        return new ArrayList<>(this.f7582e);
    }

    public String f() {
        String b2;
        if (!this.i.c() || this.f7585h.c() || this.f7585h.b()) {
            this.i.a();
            if (this.f7579a == null) {
                return null;
            }
            ArrayList<String> d2 = d();
            JSONObject jSONObject = new JSONObject();
            if (d2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    int i = 0;
                    Iterator<String> it = d2.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (next != null && !next.equals("data_version") && (b2 = this.f7579a.b(next)) != null && !b2.equals("")) {
                            JSONObject optJSONObject = new JSONObject(b2).optJSONObject("Fav_Sync");
                            optJSONObject.put("key", next);
                            jSONArray.put(i, optJSONObject);
                            i++;
                        }
                    }
                    if (i > 0) {
                        jSONObject.put("favcontents", jSONArray);
                        jSONObject.put("favpoinum", i);
                    }
                } catch (JSONException unused) {
                    return null;
                }
            }
            this.i.b();
            this.f7585h.a(jSONObject.toString());
            return this.f7585h.a();
        }
        return this.f7585h.a();
    }
}
