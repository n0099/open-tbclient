package com.baidu.prologue.service.network;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.prologue.service.network.Request;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class Als {
    private static final boolean DEBUG;

    static {
        DEBUG = com.baidu.prologue.a.b.a.cft.get() != null && com.baidu.prologue.a.b.a.cft.get().abk();
    }

    public static void a(@NonNull a aVar) {
        com.baidu.prologue.a.b.a aVar2 = com.baidu.prologue.a.b.a.cft.get();
        if (aVar2 == null) {
            if (DEBUG) {
                throw new IllegalStateException("宿主App未初始化IAppContext");
            }
            return;
        }
        Request.a aVar3 = new Request.a(aVar2.aba(), "https://als.baidu.com/clog/clog");
        a(aVar3, aVar2);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aVar.chv);
        aVar3.bc(MapBundleKey.MapObjKey.OBJ_AD, jSONArray.toString());
        aVar3.act().acr().a(new m() { // from class: com.baidu.prologue.service.network.Als.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: jw */
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
        com.baidu.prologue.a.b.a aVar = com.baidu.prologue.a.b.a.cft.get();
        if (aVar == null) {
            if (DEBUG) {
                throw new IllegalStateException("宿主App未初始化IAppContext");
            }
            return;
        }
        Request.a aVar2 = new Request.a(aVar.aba(), "http://als.baidu.com/elog/plog");
        a(aVar2, aVar);
        a(aVar2);
        a(aVar2, str, str2, str3, j, str4);
        aVar2.act().acr().a(new m() { // from class: com.baidu.prologue.service.network.Als.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: jw */
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
        aVar.bc("_client_type", "2");
        aVar.bc("_os_type", "2");
        aVar.bc("_client_version", aVar2.abb());
        aVar.bc("_os_version", aVar2.abc());
        aVar.bc("model", aVar2.abe());
        aVar.bc("cuid", aVar2.abd());
        aVar.bc("productId", aVar2.abl());
        aVar.bc("net_type", String.valueOf(new g(aVar2.aba()).acp()));
    }

    private static void a(Request.a aVar) {
        aVar.bc("c_id", "1038");
        aVar.bc("c_type", "every");
    }

    private static void a(Request.a aVar, String str, String str2, String str3, long j, String str4) {
        aVar.bc("f1", str);
        aVar.bc("f2", str2);
        aVar.bc("f3", str3);
        aVar.bc("f4", j + "");
        aVar.bc("f5", str4);
    }

    /* loaded from: classes14.dex */
    public static final class a {
        private final JSONObject chv = new JSONObject();

        public a(@NonNull Type type) {
            ba("da_type", type.value);
            j("origin_time", Long.valueOf(System.currentTimeMillis()));
        }

        public a a(@NonNull Page page) {
            return ba("da_page", page.value);
        }

        public a b(@NonNull Area area) {
            return ba("da_area", area.value);
        }

        public a jH(@NonNull String str) {
            return ba("extra_param", str);
        }

        public a jI(@NonNull String str) {
            return ba("da_ext1", str);
        }

        public a jJ(@NonNull String str) {
            return ba("da_ext2", str);
        }

        public a jK(@NonNull String str) {
            return ba("da_ext3", str);
        }

        private a ba(String str, String str2) {
            return k(str, str2);
        }

        private a j(String str, Object obj) {
            return k(str, obj);
        }

        private <T> a k(String str, T t) {
            if (Als.DEBUG && this.chv.has(str)) {
                throw new IllegalArgumentException("key " + str + " has been set!");
            }
            try {
                this.chv.put(str, t);
            } catch (JSONException e) {
                if (Als.DEBUG) {
                    throw new IllegalArgumentException("Json put create invalid exception");
                }
            }
            return this;
        }
    }

    /* loaded from: classes14.dex */
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

    /* loaded from: classes14.dex */
    public enum CloseType {
        COUNTDOWN_TIME_FINISH("0"),
        CLICK_SKIP_BUTTON("1"),
        CLICK_AD_AREA("2");
        
        public final String value;

        CloseType(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes14.dex */
    public enum Page {
        NA_SPLASH("NA_SPLASH"),
        NA_DEEPLINK("DEEPLINK");
        
        private final String value;

        Page(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes14.dex */
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
