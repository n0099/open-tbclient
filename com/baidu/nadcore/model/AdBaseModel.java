package com.baidu.nadcore.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.TiebaMainDatabaseHelper;
import com.baidu.tieba.bq0;
import com.baidu.tieba.cq0;
import com.baidu.tieba.ip0;
import com.baidu.tieba.jp0;
import com.baidu.tieba.lp0;
import com.baidu.tieba.np0;
import com.baidu.tieba.oh0;
import com.baidu.tieba.rp0;
import com.baidu.tieba.tp0;
import com.baidu.tieba.y01;
import com.baidu.tieba.yp0;
import com.fun.ad.sdk.FunAdSdk;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AdBaseModel {
    public boolean a;
    public boolean b;
    @Nullable
    public final ParseError c;
    public final boolean d;
    @NonNull
    public final List<MonitorUrl> e;
    @NonNull
    public final rp0 f;
    @Nullable
    public final ip0 g;
    @Nullable
    public final AdOperator h;
    @Nullable
    public final cq0 i;
    @Nullable
    public final yp0 j;
    @Nullable
    public final List<tp0> k;
    @Nullable
    public final jp0 l;
    @Nullable
    public np0 m;
    public int n;
    @NonNull
    public List<String> o;
    public bq0 p;
    public oh0 q;

    public AdBaseModel(@NonNull rp0 rp0Var, @NonNull JSONObject jSONObject) throws ParseError {
        this(rp0Var, jSONObject, false);
    }

    /* loaded from: classes2.dex */
    public enum STYLE {
        BIG_IMAGE("big_image"),
        SMALL_IMAGE("small_image"),
        THREE_IMAGE("three_image"),
        VIDEO("video"),
        PORTRAIT_VIDEO("portrait_video"),
        FLOAT(ShaderParams.VALUE_TYPE_FLOAT),
        REWARD_VIDEO_LP("reward_video_lp"),
        REWARD_VIDEO_LP_IMPL("reward_video_lp_impl"),
        MAX(FunAdSdk.PLATFORM_MAX),
        HIDDEN("hidden");
        
        public final String value;

        STYLE(String str) {
            this.value = str;
        }

        public static STYLE from(String str) {
            STYLE[] values;
            for (STYLE style : values()) {
                if (style.value.equals(str)) {
                    return style;
                }
            }
            throw new EnumConstantNotPresentException(STYLE.class, str);
        }

        public static int getStyleCount() {
            return values().length;
        }
    }

    public AdBaseModel(@NonNull rp0 rp0Var, @NonNull JSONObject jSONObject, boolean z) throws ParseError {
        ip0 a;
        AdOperator a2;
        boolean z2;
        cq0 c;
        int length;
        int length2;
        this.e = new ArrayList();
        this.o = new ArrayList();
        String str = rp0Var.b;
        JSONObject optJSONObject = jSONObject.optJSONObject(GameGuideConfigInfo.KEY_CLOSE_INFO);
        if (optJSONObject == null) {
            a = null;
        } else {
            a = ip0.a(optJSONObject);
        }
        this.g = a;
        this.f = rp0Var;
        this.j = yp0.b(jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO), z);
        this.k = tp0.a(jSONObject.optJSONArray("prefetch_video"));
        this.l = jp0.b(jSONObject.optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO));
        this.m = np0.a(jSONObject.optJSONObject("enhance"));
        lp0.a(jSONObject.optJSONObject("interaction"));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("operate");
        if (optJSONObject2 == null) {
            a2 = null;
        } else {
            a2 = AdOperator.a(optJSONObject2);
        }
        this.h = a2;
        if (a2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.d = z2;
        JSONObject optJSONObject3 = jSONObject.optJSONObject("app_info");
        if (optJSONObject3 == null) {
            c = null;
        } else {
            c = cq0.c(optJSONObject3);
        }
        this.i = (c == null || !c.k) ? null : c;
        JSONArray optJSONArray = jSONObject.optJSONArray("ad_monitor_url");
        if (optJSONArray == null) {
            length = 0;
        } else {
            length = optJSONArray.length();
        }
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject4 = optJSONArray.optJSONObject(i);
            if (optJSONObject4 != null) {
                String optString = optJSONObject4.optString("show_url");
                String optString2 = optJSONObject4.optString("click_url");
                if (!TextUtils.isEmpty(optString) || !TextUtils.isEmpty(optString2)) {
                    y01.b(this.e, new MonitorUrl(optString, optString2));
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(PushConstants.SUB_TAGS_STATUS_LIST);
        if (optJSONArray2 == null) {
            length2 = 0;
        } else {
            length2 = optJSONArray2.length();
        }
        for (int i2 = 0; i2 < length2; i2++) {
            JSONObject optJSONObject5 = optJSONArray2.optJSONObject(i2);
            if (optJSONObject5 != null) {
                String optString3 = optJSONObject5.optString("word");
                if (!TextUtils.isEmpty(optString3)) {
                    y01.b(this.o, optString3);
                }
            }
        }
        yp0 yp0Var = this.j;
        if (yp0Var != null) {
            yp0Var.d(this);
        }
        this.c = null;
    }

    public void a(@Nullable bq0 bq0Var) {
        List<tp0> list;
        this.p = bq0Var;
        if (bq0Var == null || bq0Var.c) {
            this.f.b();
        }
        if ((bq0Var == null || bq0Var.d) && (list = this.k) != null && list.size() > 0) {
            for (tp0 tp0Var : this.k) {
                tp0Var.b();
            }
        }
    }
}
