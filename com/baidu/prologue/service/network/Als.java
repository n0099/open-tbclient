package com.baidu.prologue.service.network;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.prologue.service.network.Request;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class Als {
    private static final boolean DEBUG;

    static {
        DEBUG = com.baidu.prologue.a.b.a.cop.get() != null && com.baidu.prologue.a.b.a.cop.get().acv();
    }

    public static void a(@NonNull a aVar) {
        com.baidu.prologue.a.b.a aVar2 = com.baidu.prologue.a.b.a.cop.get();
        if (aVar2 == null) {
            if (DEBUG) {
                throw new IllegalStateException("宿主App未初始化IAppContext");
            }
            return;
        }
        Request.a aVar3 = new Request.a(aVar2.acl(), "https://als.baidu.com/clog/clog");
        a(aVar3, aVar2);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aVar.cqs);
        aVar3.bh("ad", jSONArray.toString());
        aVar3.adE().adC().a(new m() { // from class: com.baidu.prologue.service.network.Als.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: ei */
            public void onResponse(String str) {
                if (Als.DEBUG) {
                    Log.d("Als", "Als get correct response.");
                }
            }

            @Override // com.baidu.prologue.service.network.j
            public void l(Throwable th) {
                if (Als.DEBUG) {
                    Log.e("Als", "Als get error response, " + th);
                }
            }
        });
    }

    public static void a(String str, String str2, String str3, long j, String str4) {
        com.baidu.prologue.a.b.a aVar = com.baidu.prologue.a.b.a.cop.get();
        if (aVar == null) {
            if (DEBUG) {
                throw new IllegalStateException("宿主App未初始化IAppContext");
            }
            return;
        }
        Request.a aVar2 = new Request.a(aVar.acl(), "http://als.baidu.com/elog/plog");
        a(aVar2, aVar);
        a(aVar2);
        a(aVar2, str, str2, str3, j, str4);
        aVar2.adE().adC().a(new m() { // from class: com.baidu.prologue.service.network.Als.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: ei */
            public void onResponse(String str5) {
                if (Als.DEBUG) {
                    Log.d("Als", "Als performance get correct response.");
                }
            }

            @Override // com.baidu.prologue.service.network.j
            public void l(Throwable th) {
                if (Als.DEBUG) {
                    Log.e("Als", "Als performance get error response, " + th);
                }
            }
        });
    }

    private static void a(Request.a aVar, com.baidu.prologue.a.b.a aVar2) {
        aVar.bh("_client_type", "2");
        aVar.bh("_os_type", "2");
        aVar.bh("_client_version", aVar2.acm());
        aVar.bh("_os_version", aVar2.acn());
        aVar.bh("model", aVar2.acp());
        aVar.bh("cuid", aVar2.aco());
        aVar.bh("productId", aVar2.acw());
        aVar.bh("net_type", String.valueOf(new g(aVar2.acl()).adA()));
    }

    private static void a(Request.a aVar) {
        aVar.bh("c_id", "1038");
        aVar.bh("c_type", "every");
    }

    private static void a(Request.a aVar, String str, String str2, String str3, long j, String str4) {
        aVar.bh("f1", str);
        aVar.bh("f2", str2);
        aVar.bh("f3", str3);
        aVar.bh("f4", j + "");
        aVar.bh("f5", str4);
    }

    /* loaded from: classes5.dex */
    public static final class a {
        private final JSONObject cqs = new JSONObject();

        public a(@NonNull Type type) {
            bf("da_type", type.value);
            i("origin_time", Long.valueOf(System.currentTimeMillis()));
        }

        public a a(@NonNull Page page) {
            return bf("da_page", page.value);
        }

        public a b(@NonNull Area area) {
            return bf("da_area", area.value);
        }

        public a iX(@NonNull String str) {
            return bf("extra_param", str);
        }

        public a iY(@NonNull String str) {
            return bf("da_ext1", str);
        }

        public a iZ(@NonNull String str) {
            return bf("da_ext2", str);
        }

        public a ja(@NonNull String str) {
            return bf("da_ext3", str);
        }

        private a bf(String str, String str2) {
            return j(str, str2);
        }

        private a i(String str, Object obj) {
            return j(str, obj);
        }

        private <T> a j(String str, T t) {
            if (Als.DEBUG && this.cqs.has(str)) {
                throw new IllegalArgumentException("key " + str + " has been set!");
            }
            try {
                this.cqs.put(str, t);
            } catch (JSONException e) {
                if (Als.DEBUG) {
                    throw new IllegalArgumentException("Json put create invalid exception");
                }
            }
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public enum Type {
        CLICK("2"),
        SHOW("3"),
        DISCARD("5"),
        CLOSE("7"),
        DEEP_LINK("706");
        
        private final String value;

        Type(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes5.dex */
    public enum CloseType {
        COUNTDOWN_TIME_FINISH("0"),
        CLICK_SKIP_BUTTON("1"),
        CLICK_AD_AREA("2");
        
        public final String value;

        CloseType(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes5.dex */
    public enum Page {
        NA_SPLASH("NA_SPLASH"),
        NA_DEEPLINK("DEEPLINK");
        
        private final String value;

        Page(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes5.dex */
    public enum Area {
        SKIP_BUTTON("skip_button"),
        IMAGE("image"),
        VIDEO("video"),
        DEEPLINK_RESULT_APP("APP"),
        DEEPLINK_RESULT_H5("URL");
        
        private final String value;

        Area(String str) {
            this.value = str;
        }
    }
}
