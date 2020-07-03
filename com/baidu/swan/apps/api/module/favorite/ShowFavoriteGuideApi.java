package com.baidu.swan.apps.api.module.favorite;

import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.api.module.favorite.a;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ShowFavoriteGuideApi extends d implements a.InterfaceC0311a {
    private long bPf;
    private long bPg;
    private long bPh;
    private String mCallbackKey;

    public ShowFavoriteGuideApi(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b hp(String str) {
        if (DEBUG) {
            Log.d("Api-showFavoriteGuide", "handle: " + str);
        }
        final e apN = e.apN();
        if (apN == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "SwanApp is null");
        }
        final SwanAppActivity apG = apN.apG();
        if (apG == null) {
            c.e("Api-showFavoriteGuide", "null activity");
            return new com.baidu.swan.apps.api.c.b(1001, "null activity");
        } else if (!aj.auY()) {
            c.i("Api-showFavoriteGuide", "not support outside baiduboxapp");
            return new com.baidu.swan.apps.api.c.b(1001, "not support outside baiduboxapp");
        } else {
            Pair<com.baidu.swan.apps.api.c.b, JSONObject> aR = com.baidu.swan.apps.api.d.b.aR("Api-showFavoriteGuide", str);
            com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aR.first;
            if (!bVar.isSuccess()) {
                if (DEBUG) {
                    c.e("Api-showFavoriteGuide", "parse fail");
                    return bVar;
                }
                return bVar;
            }
            final JSONObject jSONObject = (JSONObject) aR.second;
            n.auA().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.storage.c.b asV = h.asV();
                    final GuideType parse = GuideType.parse(jSONObject.optString("type"));
                    final String string = ShowFavoriteGuideApi.this.getContext().getString(parse.defaultText);
                    ShowFavoriteGuideApi.this.mCallbackKey = jSONObject.optString("cb");
                    String str2 = apN.id;
                    String str3 = "favorite_guide_count_" + str2;
                    if (com.baidu.swan.apps.database.favorite.a.ke(str2)) {
                        c.i("Api-showFavoriteGuide", "favorite already");
                        h.asV().putString(str3, "-1");
                        return;
                    }
                    String string2 = h.asV().getString(str3, "");
                    if (TextUtils.equals("-1", string2)) {
                        c.i("Api-showFavoriteGuide", "favorite at one time");
                        return;
                    }
                    String[] split = string2.split("#");
                    int i = 0;
                    long j = 0;
                    if (split.length == 2 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1])) {
                        i = Integer.parseInt(split[0]);
                        j = Long.parseLong(split[1]);
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    ShowFavoriteGuideApi.this.bPf = asV.getLong("swan_favorite_guide_duration", 3L);
                    ShowFavoriteGuideApi.this.bPg = asV.getLong("swan_favorite_guide_intervalDays", 3L);
                    ShowFavoriteGuideApi.this.bPh = asV.getLong("swan_favorite_guide_maxTimes", 3L);
                    c.i("Api-showFavoriteGuide", "duration=" + ShowFavoriteGuideApi.this.bPf + ", mIntervalDays=" + ShowFavoriteGuideApi.this.bPg + ", mMaxTimes=" + ShowFavoriteGuideApi.this.bPh + " ,storageValue=" + string2);
                    if (i < ShowFavoriteGuideApi.this.bPh && currentTimeMillis - j > ShowFavoriteGuideApi.this.bPg * 86400000) {
                        h.asV().putString(str3, (i + 1) + "#" + currentTimeMillis);
                        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.Vc().a(ShowFavoriteGuideApi.this, apG, apN, parse, string, apN.apQ().getIconUrl(), ShowFavoriteGuideApi.this.bPf);
                            }
                        });
                        return;
                    }
                    c.i("Api-showFavoriteGuide", "Not satisfying display conditions");
                }
            }, "Api-showFavoriteGuide");
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    @Override // com.baidu.swan.apps.api.module.favorite.a.InterfaceC0311a
    @AnyThread
    public void dp(boolean z) {
        if (this.mCallbackKey != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("action", z ? 1 : 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(this.mCallbackKey, new com.baidu.swan.apps.api.c.b(0, "success", jSONObject));
        }
    }

    /* loaded from: classes11.dex */
    public enum GuideType {
        NORMAL("bar", -1, 992, a.h.aiapps_favorite_guide_default_hint),
        WEAK("bar-autohide", -1, 865, a.h.aiapps_favorite_guide_default_hint),
        TIPS(AlaStaticKeys.ALA_STATIC_VALUE_TIP, 18, -1, a.h.aiapps_favorite_guide_default_tips);
        
        @StringRes
        public int defaultText;
        public int limit;
        public int showWidth4px;
        public String typeName;

        GuideType(String str, int i, int i2, @StringRes int i3) {
            this.typeName = str;
            this.limit = i;
            this.showWidth4px = i2;
            this.defaultText = i3;
        }

        public static GuideType parse(String str) {
            GuideType[] values;
            if (!TextUtils.isEmpty(str)) {
                for (GuideType guideType : values()) {
                    if (TextUtils.equals(guideType.typeName, str)) {
                        return guideType;
                    }
                }
            }
            return NORMAL;
        }
    }

    public static void a(GuideType guideType, String str, String str2) {
        String str3;
        String apO = e.apO();
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (guideType == null) {
            str3 = "window";
        } else {
            switch (guideType) {
                case TIPS:
                    str3 = "TIPS";
                    break;
                case WEAK:
                    str3 = "flow";
                    break;
                default:
                    str3 = "flow_close";
                    break;
            }
        }
        eVar.mType = str3;
        eVar.mSource = str;
        eVar.mValue = str2;
        eVar.v("appkey", apO);
        com.baidu.swan.apps.statistic.h.a("923", eVar);
    }
}
