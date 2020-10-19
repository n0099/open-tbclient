package com.baidu.prologue.service.network;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.prologue.service.network.Request;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class Als {
    private static final boolean DEBUG;

    static {
        DEBUG = com.baidu.prologue.a.b.a.bSV.get() != null && com.baidu.prologue.a.b.a.bSV.get().XA();
    }

    public static void a(@NonNull a aVar) {
        com.baidu.prologue.a.b.a aVar2 = com.baidu.prologue.a.b.a.bSV.get();
        if (aVar2 == null) {
            if (DEBUG) {
                throw new IllegalStateException("宿主App未初始化IAppContext");
            }
            return;
        }
        Request.a aVar3 = new Request.a(aVar2.Xq(), "https://als.baidu.com/clog/clog");
        a(aVar3, aVar2);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aVar.bUX);
        aVar3.aW(MapBundleKey.MapObjKey.OBJ_AD, jSONArray.toString());
        aVar3.YK().YI().a(new m() { // from class: com.baidu.prologue.service.network.Als.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: iW */
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
        com.baidu.prologue.a.b.a aVar = com.baidu.prologue.a.b.a.bSV.get();
        if (aVar == null) {
            if (DEBUG) {
                throw new IllegalStateException("宿主App未初始化IAppContext");
            }
            return;
        }
        Request.a aVar2 = new Request.a(aVar.Xq(), "http://als.baidu.com/elog/plog");
        a(aVar2, aVar);
        a(aVar2);
        a(aVar2, str, str2, str3, j, str4);
        aVar2.YK().YI().a(new m() { // from class: com.baidu.prologue.service.network.Als.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: iW */
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
        aVar.aW("_client_type", "2");
        aVar.aW("_os_type", "2");
        aVar.aW("_client_version", aVar2.Xr());
        aVar.aW("_os_version", aVar2.Xs());
        aVar.aW("model", aVar2.Xu());
        aVar.aW("cuid", aVar2.Xt());
        aVar.aW("productId", aVar2.XB());
        aVar.aW("net_type", String.valueOf(new g(aVar2.Xq()).YG()));
    }

    private static void a(Request.a aVar) {
        aVar.aW("c_id", "1038");
        aVar.aW("c_type", "every");
    }

    private static void a(Request.a aVar, String str, String str2, String str3, long j, String str4) {
        aVar.aW("f1", str);
        aVar.aW("f2", str2);
        aVar.aW("f3", str3);
        aVar.aW("f4", j + "");
        aVar.aW("f5", str4);
    }

    /* loaded from: classes19.dex */
    public static final class a {
        private final JSONObject bUX = new JSONObject();

        public a(@NonNull Type type) {
            aU("da_type", type.value);
            j("origin_time", Long.valueOf(System.currentTimeMillis()));
        }

        public a a(@NonNull Page page) {
            return aU("da_page", page.value);
        }

        public a b(@NonNull Area area) {
            return aU("da_area", area.value);
        }

        public a jh(@NonNull String str) {
            return aU("extra_param", str);
        }

        public a ji(@NonNull String str) {
            return aU("da_ext1", str);
        }

        public a jj(@NonNull String str) {
            return aU("da_ext2", str);
        }

        public a jk(@NonNull String str) {
            return aU("da_ext3", str);
        }

        private a aU(String str, String str2) {
            return k(str, str2);
        }

        private a j(String str, Object obj) {
            return k(str, obj);
        }

        private <T> a k(String str, T t) {
            if (Als.DEBUG && this.bUX.has(str)) {
                throw new IllegalArgumentException("key " + str + " has been set!");
            }
            try {
                this.bUX.put(str, t);
            } catch (JSONException e) {
                if (Als.DEBUG) {
                    throw new IllegalArgumentException("Json put create invalid exception");
                }
            }
            return this;
        }
    }

    /* loaded from: classes19.dex */
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

    /* loaded from: classes19.dex */
    public enum CloseType {
        COUNTDOWN_TIME_FINISH("0"),
        CLICK_SKIP_BUTTON("1"),
        CLICK_AD_AREA("2");
        
        public final String value;

        CloseType(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes19.dex */
    public enum Page {
        NA_SPLASH("NA_SPLASH"),
        NA_DEEPLINK("DEEPLINK");
        
        private final String value;

        Page(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes19.dex */
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
