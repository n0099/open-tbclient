package com.baidu.prologue.service.network;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.prologue.service.network.Request;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import d.a.d0.d.a.f;
import d.a.d0.d.a.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Als {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9430a;

    /* loaded from: classes2.dex */
    public enum Area {
        SKIP_BUTTON("skip_button"),
        IMAGE("image"),
        VIDEO("video"),
        GIF("gif"),
        DEEPLINK_RESULT_APP("APP"),
        DEEPLINK_RESULT_H5("URL"),
        UNKNOW("unknow");
        
        public final String value;

        Area(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes2.dex */
    public enum CloseType {
        COUNTDOWN_TIME_FINISH("0"),
        CLICK_SKIP_BUTTON("1"),
        CLICK_AD_AREA("2"),
        OTHER("3");
        
        public final String value;

        CloseType(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes2.dex */
    public enum Page {
        NA_SPLASH("NA_SPLASH"),
        NA_DEEPLINK("DEEPLINK");
        
        public final String value;

        Page(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes2.dex */
    public enum Type {
        CLICK("2"),
        SHOW("3"),
        DISCARD("5"),
        CLOSE("7"),
        DEEP_LINK("706");
        
        public final String value;

        Type(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes2.dex */
    public static class a implements l {
        @Override // d.a.d0.d.a.i
        public void a(Throwable th) {
            if (Als.f9430a) {
                Log.e("Als", "Als get error response, " + th);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d0.d.a.i
        /* renamed from: c */
        public void b(String str) {
            if (Als.f9430a) {
                Log.d("Als", "Als get correct response.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements l {
        @Override // d.a.d0.d.a.i
        public void a(Throwable th) {
            if (Als.f9430a) {
                Log.e("Als", "Als performance get error response, " + th);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d0.d.a.i
        /* renamed from: c */
        public void b(String str) {
            if (Als.f9430a) {
                Log.d("Als", "Als performance get correct response.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final JSONObject f9431a = new JSONObject();

        public c(@NonNull Type type) {
            d("da_type", type.value);
            c("origin_time", Long.valueOf(System.currentTimeMillis()));
        }

        public final <T> c b(String str, T t) {
            if (Als.f9430a && this.f9431a.has(str)) {
                throw new IllegalArgumentException("key " + str + " has been set!");
            }
            try {
                this.f9431a.put(str, t);
            } catch (JSONException unused) {
                if (Als.f9430a) {
                    throw new IllegalArgumentException("Json put create invalid exception");
                }
            }
            return this;
        }

        public final c c(String str, Object obj) {
            b(str, obj);
            return this;
        }

        public final c d(String str, String str2) {
            b(str, str2);
            return this;
        }

        public c e(@NonNull Area area) {
            d("da_area", area.value);
            return this;
        }

        public c f(@NonNull String str) {
            d("da_ext1", str);
            return this;
        }

        public c g(@NonNull String str) {
            d("da_ext2", str);
            return this;
        }

        public c h(@NonNull String str) {
            d("da_ext3", str);
            return this;
        }

        public c i(@NonNull Page page) {
            d("da_page", page.value);
            return this;
        }

        public c j(@NonNull String str) {
            d("extra_param", str);
            return this;
        }
    }

    static {
        f9430a = d.a.d0.a.b.a.f43374a.get() != null && d.a.d0.a.b.a.f43374a.get().s();
    }

    public static void b(Request.c cVar, d.a.d0.a.b.a aVar) {
        cVar.j(HttpRequest.CLIENT_TYPE, "2");
        cVar.j(AdUploadHttpRequest.KEY_OS_TYPE, "2");
        cVar.j("_client_version", aVar.D());
        cVar.j(AdUploadHttpRequest.KEY_OS_VERSION, aVar.g());
        cVar.j("model", aVar.q());
        cVar.j("cuid", aVar.f());
        cVar.j("productId", aVar.p());
        cVar.j("net_type", String.valueOf(new f(aVar.o()).d()));
    }

    public static void c(Request.c cVar) {
        cVar.j("c_id", "1038");
        cVar.j("c_type", "every");
    }

    public static void d(Request.c cVar, String str, String str2, String str3, long j, String str4) {
        cVar.j("f1", str);
        cVar.j("f2", str2);
        cVar.j("f3", str3);
        cVar.j("f4", j + "");
        cVar.j("f5", str4);
    }

    public static void e(@NonNull c cVar) {
        d.a.d0.a.b.a aVar = d.a.d0.a.b.a.f43374a.get();
        if (aVar == null) {
            if (f9430a) {
                throw new IllegalStateException("宿主App未初始化IAppContext");
            }
            return;
        }
        Request.c cVar2 = new Request.c(aVar.o(), "https://als.baidu.com/clog/clog");
        b(cVar2, aVar);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(cVar.f9431a);
        cVar2.j("ad", jSONArray.toString());
        cVar2.n();
        cVar2.l().e(new a());
    }

    public static void f(String str, String str2, String str3, long j, String str4) {
        d.a.d0.a.b.a aVar = d.a.d0.a.b.a.f43374a.get();
        if (aVar == null) {
            if (f9430a) {
                throw new IllegalStateException("宿主App未初始化IAppContext");
            }
            return;
        }
        Request.c cVar = new Request.c(aVar.o(), "http://als.baidu.com/elog/plog");
        b(cVar, aVar);
        c(cVar);
        d(cVar, str, str2, str3, j, str4);
        cVar.n();
        cVar.l().e(new b());
    }
}
