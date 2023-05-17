package com.baidu.nadcore.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.searchbox.interaction.cloudcontrol.ccs.InteractionPrivacySwitch;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.TiebaMainDatabaseHelper;
import com.baidu.tieba.bq0;
import com.baidu.tieba.dq0;
import com.baidu.tieba.ei0;
import com.baidu.tieba.hq0;
import com.baidu.tieba.jq0;
import com.baidu.tieba.o11;
import com.baidu.tieba.oq0;
import com.baidu.tieba.rq0;
import com.baidu.tieba.sq0;
import com.baidu.tieba.yp0;
import com.baidu.tieba.zp0;
import com.fun.ad.sdk.FunAdSdk;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdBaseModel {
    public boolean a;
    public boolean b;
    @Nullable
    public final ParseError c;
    public final boolean d;
    @NonNull
    public final List<MonitorUrl> e;
    @NonNull
    public final hq0 f;
    @Nullable
    public final yp0 g;
    @Nullable
    public final AdOperator h;
    @Nullable
    public final sq0 i;
    @Nullable
    public final oq0 j;
    @Nullable
    public final List<jq0> k;
    @Nullable
    public final zp0 l;
    @Nullable
    public dq0 m;
    public int n;
    @NonNull
    public List<String> o;
    public rq0 p;
    public ei0 q;

    public AdBaseModel(@NonNull hq0 hq0Var, @NonNull JSONObject jSONObject) throws ParseError {
        this(hq0Var, jSONObject, false);
    }

    /* loaded from: classes3.dex */
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

    public AdBaseModel(@NonNull hq0 hq0Var, @NonNull JSONObject jSONObject, boolean z) throws ParseError {
        yp0 a;
        AdOperator a2;
        boolean z2;
        sq0 c;
        int length;
        int length2;
        this.e = new ArrayList();
        this.o = new ArrayList();
        String str = hq0Var.b;
        JSONObject optJSONObject = jSONObject.optJSONObject(GameGuideConfigInfo.KEY_CLOSE_INFO);
        if (optJSONObject == null) {
            a = null;
        } else {
            a = yp0.a(optJSONObject);
        }
        this.g = a;
        this.f = hq0Var;
        this.j = oq0.b(jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO), z);
        this.k = jq0.a(jSONObject.optJSONArray("prefetch_video"));
        this.l = zp0.b(jSONObject.optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO));
        this.m = dq0.a(jSONObject.optJSONObject("enhance"));
        bq0.a(jSONObject.optJSONObject(InteractionPrivacySwitch.MODULE));
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
            c = sq0.c(optJSONObject3);
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
                    o11.b(this.e, new MonitorUrl(optString, optString2));
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
                    o11.b(this.o, optString3);
                }
            }
        }
        oq0 oq0Var = this.j;
        if (oq0Var != null) {
            oq0Var.d(this);
        }
        this.c = null;
    }

    public void a(@Nullable rq0 rq0Var) {
        List<jq0> list;
        this.p = rq0Var;
        if (rq0Var == null || rq0Var.c) {
            this.f.b();
        }
        if ((rq0Var == null || rq0Var.d) && (list = this.k) != null && list.size() > 0) {
            for (jq0 jq0Var : this.k) {
                jq0Var.b();
            }
        }
    }
}
