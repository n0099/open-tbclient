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
import com.baidu.tieba.dr0;
import com.baidu.tieba.er0;
import com.baidu.tieba.g31;
import com.baidu.tieba.gr0;
import com.baidu.tieba.ir0;
import com.baidu.tieba.mr0;
import com.baidu.tieba.or0;
import com.baidu.tieba.vi0;
import com.baidu.tieba.vr0;
import com.baidu.tieba.yr0;
import com.baidu.tieba.zr0;
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
    public final mr0 f;
    @Nullable
    public final dr0 g;
    @Nullable
    public final AdOperator h;
    @Nullable
    public final zr0 i;
    @Nullable
    public final vr0 j;
    @Nullable
    public final List<or0> k;
    @Nullable
    public final er0 l;
    @Nullable
    public ir0 m;
    public int n;
    @NonNull
    public List<String> o;
    public yr0 p;
    public vi0 q;

    public AdBaseModel(@NonNull mr0 mr0Var, @NonNull JSONObject jSONObject) throws ParseError {
        this(mr0Var, jSONObject, false);
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

    public AdBaseModel(@NonNull mr0 mr0Var, @NonNull JSONObject jSONObject, boolean z) throws ParseError {
        dr0 a;
        AdOperator a2;
        boolean z2;
        zr0 d;
        int length;
        int length2;
        this.e = new ArrayList();
        this.o = new ArrayList();
        String str = mr0Var.b;
        JSONObject optJSONObject = jSONObject.optJSONObject(GameGuideConfigInfo.KEY_CLOSE_INFO);
        if (optJSONObject == null) {
            a = null;
        } else {
            a = dr0.a(optJSONObject);
        }
        this.g = a;
        this.f = mr0Var;
        this.j = vr0.b(jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO), z);
        this.k = or0.a(jSONObject.optJSONArray("prefetch_video"));
        this.l = er0.b(jSONObject.optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO));
        this.m = ir0.a(jSONObject.optJSONObject("enhance"));
        gr0.a(jSONObject.optJSONObject(InteractionPrivacySwitch.MODULE));
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
            d = zr0.d(optJSONObject3);
        }
        if (d != null) {
            d.m = mr0Var.d;
        }
        this.i = (d == null || !d.l) ? null : d;
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
                    g31.b(this.e, new MonitorUrl(optString, optString2));
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
                    g31.b(this.o, optString3);
                }
            }
        }
        vr0 vr0Var = this.j;
        if (vr0Var != null) {
            vr0Var.d(this);
        }
        this.c = null;
    }

    public void a(@Nullable yr0 yr0Var) {
        List<or0> list;
        this.p = yr0Var;
        if (yr0Var == null || yr0Var.c) {
            this.f.b();
        }
        if ((yr0Var == null || yr0Var.d) && (list = this.k) != null && list.size() > 0) {
            for (or0 or0Var : this.k) {
                or0Var.b();
            }
        }
    }
}
