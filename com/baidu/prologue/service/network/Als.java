package com.baidu.prologue.service.network;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.prologue.service.network.Request;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class Als {
    private static final boolean DEBUG;

    static {
        DEBUG = com.baidu.prologue.a.b.a.bKi.get() != null && com.baidu.prologue.a.b.a.bKi.get().UU();
    }

    public static void a(@NonNull a aVar) {
        com.baidu.prologue.a.b.a aVar2 = com.baidu.prologue.a.b.a.bKi.get();
        if (aVar2 == null) {
            if (DEBUG) {
                throw new IllegalStateException("宿主App未初始化IAppContext");
            }
            return;
        }
        Request.a aVar3 = new Request.a(aVar2.UK(), "https://als.baidu.com/clog/clog");
        a(aVar3, aVar2);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aVar.bMk);
        aVar3.aR(MapBundleKey.MapObjKey.OBJ_AD, jSONArray.toString());
        aVar3.We().Wc().a(new m() { // from class: com.baidu.prologue.service.network.Als.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: ia */
            public void onResponse(String str) {
                if (Als.DEBUG) {
                    Log.d("Als", "Als get correct response.");
                }
            }

            @Override // com.baidu.prologue.service.network.j
            public void n(Throwable th) {
                if (Als.DEBUG) {
                    Log.e("Als", "Als get error response, " + th);
                }
            }
        });
    }

    public static void a(String str, String str2, String str3, long j, String str4) {
        com.baidu.prologue.a.b.a aVar = com.baidu.prologue.a.b.a.bKi.get();
        if (aVar == null) {
            if (DEBUG) {
                throw new IllegalStateException("宿主App未初始化IAppContext");
            }
            return;
        }
        Request.a aVar2 = new Request.a(aVar.UK(), "http://als.baidu.com/elog/plog");
        a(aVar2, aVar);
        a(aVar2);
        a(aVar2, str, str2, str3, j, str4);
        aVar2.We().Wc().a(new m() { // from class: com.baidu.prologue.service.network.Als.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: ia */
            public void onResponse(String str5) {
                if (Als.DEBUG) {
                    Log.d("Als", "Als performance get correct response.");
                }
            }

            @Override // com.baidu.prologue.service.network.j
            public void n(Throwable th) {
                if (Als.DEBUG) {
                    Log.e("Als", "Als performance get error response, " + th);
                }
            }
        });
    }

    private static void a(Request.a aVar, com.baidu.prologue.a.b.a aVar2) {
        aVar.aR("_client_type", "2");
        aVar.aR("_os_type", "2");
        aVar.aR("_client_version", aVar2.UL());
        aVar.aR("_os_version", aVar2.UM());
        aVar.aR("model", aVar2.UO());
        aVar.aR("cuid", aVar2.UN());
        aVar.aR("productId", aVar2.UV());
        aVar.aR("net_type", String.valueOf(new g(aVar2.UK()).Wa()));
    }

    private static void a(Request.a aVar) {
        aVar.aR("c_id", "1038");
        aVar.aR("c_type", "every");
    }

    private static void a(Request.a aVar, String str, String str2, String str3, long j, String str4) {
        aVar.aR("f1", str);
        aVar.aR("f2", str2);
        aVar.aR("f3", str3);
        aVar.aR("f4", j + "");
        aVar.aR("f5", str4);
    }

    /* loaded from: classes9.dex */
    public static final class a {
        private final JSONObject bMk = new JSONObject();

        public a(@NonNull Type type) {
            aP("da_type", type.value);
            j("origin_time", Long.valueOf(System.currentTimeMillis()));
        }

        public a a(@NonNull Page page) {
            return aP("da_page", page.value);
        }

        public a b(@NonNull Area area) {
            return aP("da_area", area.value);
        }

        public a il(@NonNull String str) {
            return aP("extra_param", str);
        }

        public a im(@NonNull String str) {
            return aP("da_ext1", str);
        }

        public a in(@NonNull String str) {
            return aP("da_ext2", str);
        }

        public a io(@NonNull String str) {
            return aP("da_ext3", str);
        }

        private a aP(String str, String str2) {
            return k(str, str2);
        }

        private a j(String str, Object obj) {
            return k(str, obj);
        }

        private <T> a k(String str, T t) {
            if (Als.DEBUG && this.bMk.has(str)) {
                throw new IllegalArgumentException("key " + str + " has been set!");
            }
            try {
                this.bMk.put(str, t);
            } catch (JSONException e) {
                if (Als.DEBUG) {
                    throw new IllegalArgumentException("Json put create invalid exception");
                }
            }
            return this;
        }
    }

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public enum CloseType {
        COUNTDOWN_TIME_FINISH("0"),
        CLICK_SKIP_BUTTON("1"),
        CLICK_AD_AREA("2");
        
        public final String value;

        CloseType(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes9.dex */
    public enum Page {
        NA_SPLASH("NA_SPLASH"),
        NA_DEEPLINK("DEEPLINK");
        
        private final String value;

        Page(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes9.dex */
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
