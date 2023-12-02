package com.baidu.nadcore.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.interaction.cloudcontrol.ccs.InteractionPrivacySwitch;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.TiebaMainDatabaseHelper;
import com.baidu.tieba.cn0;
import com.baidu.tieba.en0;
import com.baidu.tieba.ke0;
import com.baidu.tieba.ln0;
import com.baidu.tieba.ny0;
import com.baidu.tieba.on0;
import com.baidu.tieba.pn0;
import com.baidu.tieba.sm0;
import com.baidu.tieba.tm0;
import com.baidu.tieba.vm0;
import com.baidu.tieba.xm0;
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
    public final cn0 f;
    @Nullable
    public final sm0 g;
    @Nullable
    public final AdOperator h;
    @Nullable
    public final pn0 i;
    @Nullable
    public final ln0 j;
    @Nullable
    public final List<en0> k;
    @Nullable
    public final tm0 l;
    @Nullable
    public xm0 m;
    public int n;
    @NonNull
    public List<String> o;
    public on0 p;
    public ke0 q;

    public AdBaseModel(@NonNull cn0 cn0Var, @NonNull JSONObject jSONObject) throws ParseError {
        this(cn0Var, jSONObject, false);
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

    public AdBaseModel(@NonNull cn0 cn0Var, @NonNull JSONObject jSONObject, boolean z) throws ParseError {
        sm0 a;
        AdOperator a2;
        boolean z2;
        pn0 d;
        int length;
        int length2;
        this.e = new ArrayList();
        this.o = new ArrayList();
        String str = cn0Var.b;
        JSONObject optJSONObject = jSONObject.optJSONObject(GameGuideConfigInfo.KEY_CLOSE_INFO);
        if (optJSONObject == null) {
            a = null;
        } else {
            a = sm0.a(optJSONObject);
        }
        this.g = a;
        this.f = cn0Var;
        this.j = ln0.b(jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO), z);
        this.k = en0.a(jSONObject.optJSONArray("prefetch_video"));
        this.l = tm0.b(jSONObject.optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO));
        this.m = xm0.a(jSONObject.optJSONObject("enhance"));
        vm0.a(jSONObject.optJSONObject(InteractionPrivacySwitch.MODULE));
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
            d = null;
        } else {
            d = pn0.d(optJSONObject3);
        }
        if (d != null) {
            d.n = cn0Var.d;
        }
        this.i = (d == null || !d.m) ? null : d;
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
                    ny0.b(this.e, new MonitorUrl(optString, optString2));
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
                String optString3 = optJSONObject5.optString(DownloadStatisticConstants.UBC_VALUE_WORD);
                if (!TextUtils.isEmpty(optString3)) {
                    ny0.b(this.o, optString3);
                }
            }
        }
        ln0 ln0Var = this.j;
        if (ln0Var != null) {
            ln0Var.d(this);
        }
        this.c = null;
    }

    public void a(@Nullable on0 on0Var) {
        List<en0> list;
        this.p = on0Var;
        if (on0Var == null || on0Var.c) {
            this.f.b();
        }
        if ((on0Var == null || on0Var.d) && (list = this.k) != null && list.size() > 0) {
            for (en0 en0Var : this.k) {
                en0Var.b();
            }
        }
    }
}
