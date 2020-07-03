package com.baidu.prologue.service.network;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.prologue.service.network.Request;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class Als {
    private static final boolean DEBUG;

    static {
        DEBUG = com.baidu.prologue.a.b.a.bEl.get() != null && com.baidu.prologue.a.b.a.bEl.get().OJ();
    }

    public static void a(@NonNull a aVar) {
        com.baidu.prologue.a.b.a aVar2 = com.baidu.prologue.a.b.a.bEl.get();
        if (aVar2 == null) {
            if (DEBUG) {
                throw new IllegalStateException("宿主App未初始化IAppContext");
            }
            return;
        }
        Request.a aVar3 = new Request.a(aVar2.Oz(), "https://als.baidu.com/clog/clog");
        a(aVar3, aVar2);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aVar.bGl);
        aVar3.aN("ad", jSONArray.toString());
        aVar3.PU().PS().a(new m() { // from class: com.baidu.prologue.service.network.Als.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: gI */
            public void onResponse(String str) {
                if (Als.DEBUG) {
                    Log.d("Als", "Als get correct response.");
                }
            }

            @Override // com.baidu.prologue.service.network.j
            public void o(Throwable th) {
                if (Als.DEBUG) {
                    Log.e("Als", "Als get error response, " + th);
                }
            }
        });
    }

    private static void a(Request.a aVar, com.baidu.prologue.a.b.a aVar2) {
        aVar.aN("_client_type", "2");
        aVar.aN("_os_type", "2");
        aVar.aN("_client_version", aVar2.OA());
        aVar.aN("_os_version", aVar2.OB());
        aVar.aN("model", aVar2.OD());
        aVar.aN("cuid", aVar2.OC());
        aVar.aN("productId", aVar2.OK());
        aVar.aN("net_type", String.valueOf(new g(aVar2.Oz()).PQ()));
    }

    /* loaded from: classes6.dex */
    public static final class a {
        private final JSONObject bGl = new JSONObject();

        public a(@NonNull Type type) {
            aL("da_type", type.value);
            j("origin_time", Long.valueOf(System.currentTimeMillis()));
        }

        public a a(@NonNull Page page) {
            return aL("da_page", page.value);
        }

        public a b(@NonNull Area area) {
            return aL("da_area", area.value);
        }

        public a gT(@NonNull String str) {
            return aL("extra_param", str);
        }

        public a gU(@NonNull String str) {
            return aL("da_ext1", str);
        }

        public a gV(@NonNull String str) {
            return aL("da_ext2", str);
        }

        public a gW(@NonNull String str) {
            return aL("da_ext3", str);
        }

        private a aL(String str, String str2) {
            return k(str, str2);
        }

        private a j(String str, Object obj) {
            return k(str, obj);
        }

        private <T> a k(String str, T t) {
            if (Als.DEBUG && this.bGl.has(str)) {
                throw new IllegalArgumentException("key " + str + " has been set!");
            }
            try {
                this.bGl.put(str, t);
            } catch (JSONException e) {
                if (Als.DEBUG) {
                    throw new IllegalArgumentException("Json put create invalid exception");
                }
            }
            return this;
        }
    }

    /* loaded from: classes6.dex */
    public enum Type {
        CLICK("2"),
        SHOW("3"),
        DISCARD("5"),
        CLOSE("7"),
        DEEP_LINK(PraiseUBCHelper.PRAISE_FLOW_ID);
        
        private final String value;

        Type(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes6.dex */
    public enum CloseType {
        COUNTDOWN_TIME_FINISH("0"),
        CLICK_SKIP_BUTTON("1"),
        CLICK_AD_AREA("2");
        
        public final String value;

        CloseType(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes6.dex */
    public enum Page {
        NA_SPLASH("NA_SPLASH"),
        NA_DEEPLINK("DEEPLINK");
        
        private final String value;

        Page(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes6.dex */
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
