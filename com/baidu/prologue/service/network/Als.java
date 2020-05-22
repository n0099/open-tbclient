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
        DEBUG = com.baidu.prologue.a.b.a.bzx.get() != null && com.baidu.prologue.a.b.a.bzx.get().ND();
    }

    public static void a(@NonNull a aVar) {
        com.baidu.prologue.a.b.a aVar2 = com.baidu.prologue.a.b.a.bzx.get();
        if (aVar2 == null) {
            if (DEBUG) {
                throw new IllegalStateException("宿主App未初始化IAppContext");
            }
            return;
        }
        Request.a aVar3 = new Request.a(aVar2.Nt(), "https://als.baidu.com/clog/clog");
        a(aVar3, aVar2);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aVar.bBx);
        aVar3.aL("ad", jSONArray.toString());
        aVar3.OO().OM().a(new m() { // from class: com.baidu.prologue.service.network.Als.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: gA */
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
        aVar.aL("_client_type", "2");
        aVar.aL("_os_type", "2");
        aVar.aL("_client_version", aVar2.Nu());
        aVar.aL("_os_version", aVar2.Nv());
        aVar.aL("model", aVar2.Nx());
        aVar.aL("cuid", aVar2.Nw());
        aVar.aL("productId", aVar2.NE());
        aVar.aL("net_type", String.valueOf(new g(aVar2.Nt()).OK()));
    }

    /* loaded from: classes6.dex */
    public static final class a {
        private final JSONObject bBx = new JSONObject();

        public a(@NonNull Type type) {
            aJ("da_type", type.value);
            j("origin_time", Long.valueOf(System.currentTimeMillis()));
        }

        public a a(@NonNull Page page) {
            return aJ("da_page", page.value);
        }

        public a b(@NonNull Area area) {
            return aJ("da_area", area.value);
        }

        public a gL(@NonNull String str) {
            return aJ("extra_param", str);
        }

        public a gM(@NonNull String str) {
            return aJ("da_ext1", str);
        }

        public a gN(@NonNull String str) {
            return aJ("da_ext2", str);
        }

        public a gO(@NonNull String str) {
            return aJ("da_ext3", str);
        }

        private a aJ(String str, String str2) {
            return k(str, str2);
        }

        private a j(String str, Object obj) {
            return k(str, obj);
        }

        private <T> a k(String str, T t) {
            if (Als.DEBUG && this.bBx.has(str)) {
                throw new IllegalArgumentException("key " + str + " has been set!");
            }
            try {
                this.bBx.put(str, t);
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
