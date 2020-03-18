package com.baidu.swan.apps.api.module.favorite;

import android.graphics.Bitmap;
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
import com.baidu.swan.apps.api.a.c;
import com.baidu.swan.apps.api.module.favorite.a;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ShowFavoriteGuideApi extends c implements a.InterfaceC0220a {
    private Bitmap bdF;
    private long bdG;
    private long bdH;
    private long bdI;
    private String mCallbackKey;

    public ShowFavoriteGuideApi(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b fg(String str) {
        if (DEBUG) {
            Log.d("Api-showFavoriteGuide", "handle: " + str);
        }
        final e acJ = e.acJ();
        if (acJ == null) {
            return new com.baidu.swan.apps.api.b.b(1001, "SwanApp is null");
        }
        final SwanAppActivity acE = acJ.acE();
        if (acE == null) {
            com.baidu.swan.apps.console.c.e("Api-showFavoriteGuide", "null activity");
            return new com.baidu.swan.apps.api.b.b(1001, "null activity");
        } else if (!ai.ahl()) {
            com.baidu.swan.apps.console.c.i("Api-showFavoriteGuide", "not support outside baiduboxapp");
            return new com.baidu.swan.apps.api.b.b(1001, "not support outside baiduboxapp");
        } else {
            Pair<com.baidu.swan.apps.api.b.b, JSONObject> aq = com.baidu.swan.apps.api.c.b.aq("Api-showFavoriteGuide", str);
            com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) aq.first;
            if (!bVar.isSuccess()) {
                if (DEBUG) {
                    com.baidu.swan.apps.console.c.e("Api-showFavoriteGuide", "parse fail");
                    return bVar;
                }
                return bVar;
            }
            final JSONObject jSONObject = (JSONObject) aq.second;
            m.agO().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.storage.c.b afu = h.afu();
                    final GuideType parse = GuideType.parse(jSONObject.optString("type"));
                    final String string = ShowFavoriteGuideApi.this.getContext().getString(parse.defaultText);
                    ShowFavoriteGuideApi.this.mCallbackKey = jSONObject.optString("cb");
                    String str2 = acJ.id;
                    String str3 = "favorite_guide_count_" + str2;
                    if (com.baidu.swan.apps.database.favorite.a.hB(str2)) {
                        com.baidu.swan.apps.console.c.i("Api-showFavoriteGuide", "favorite already");
                        h.afu().putString(str3, "-1");
                        return;
                    }
                    String string2 = h.afu().getString(str3, "");
                    if (TextUtils.equals("-1", string2)) {
                        com.baidu.swan.apps.console.c.i("Api-showFavoriteGuide", "favorite at one time");
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
                    ShowFavoriteGuideApi.this.bdG = afu.getLong("swan_favorite_guide_duration", 3L);
                    ShowFavoriteGuideApi.this.bdH = afu.getLong("swan_favorite_guide_intervalDays", 3L);
                    ShowFavoriteGuideApi.this.bdI = afu.getLong("swan_favorite_guide_maxTimes", 3L);
                    com.baidu.swan.apps.console.c.i("Api-showFavoriteGuide", "duration=" + ShowFavoriteGuideApi.this.bdG + ", mIntervalDays=" + ShowFavoriteGuideApi.this.bdH + ", mMaxTimes=" + ShowFavoriteGuideApi.this.bdI + " ,storageValue=" + string2);
                    if (i < ShowFavoriteGuideApi.this.bdI && currentTimeMillis - j > ShowFavoriteGuideApi.this.bdH * 86400000) {
                        h.afu().putString(str3, (i + 1) + "#" + currentTimeMillis);
                        ShowFavoriteGuideApi.this.bdF = ai.a((com.baidu.swan.apps.x.b.b) acJ.GJ(), "Api-showFavoriteGuide", false);
                        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.JK().a(ShowFavoriteGuideApi.this, acE, acJ, parse, string, ShowFavoriteGuideApi.this.bdF, ShowFavoriteGuideApi.this.bdG);
                            }
                        });
                        return;
                    }
                    com.baidu.swan.apps.console.c.i("Api-showFavoriteGuide", "Not satisfying display conditions");
                }
            }, "Api-showFavoriteGuide");
            return new com.baidu.swan.apps.api.b.b(0);
        }
    }

    @Override // com.baidu.swan.apps.api.module.favorite.a.InterfaceC0220a
    @AnyThread
    public void cb(boolean z) {
        if (this.mCallbackKey != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("action", z ? 1 : 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(this.mCallbackKey, new com.baidu.swan.apps.api.b.b(0, "success", jSONObject));
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
        String acK = e.acK();
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
        eVar.n("appkey", acK);
        f.a("923", eVar);
    }
}
