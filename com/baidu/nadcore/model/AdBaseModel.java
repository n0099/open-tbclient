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
import com.baidu.tieba.an0;
import com.baidu.tieba.cn0;
import com.baidu.tieba.je0;
import com.baidu.tieba.jn0;
import com.baidu.tieba.ky0;
import com.baidu.tieba.mn0;
import com.baidu.tieba.nn0;
import com.baidu.tieba.rm0;
import com.baidu.tieba.sm0;
import com.baidu.tieba.um0;
import com.baidu.tieba.wm0;
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
    public final an0 f;
    @Nullable
    public final rm0 g;
    @Nullable
    public final AdOperator h;
    @Nullable
    public final nn0 i;
    @Nullable
    public final jn0 j;
    @Nullable
    public final List<cn0> k;
    @Nullable
    public final sm0 l;
    @Nullable
    public wm0 m;
    public int n;
    @NonNull
    public List<String> o;
    public mn0 p;
    public je0 q;

    public AdBaseModel(@NonNull an0 an0Var, @NonNull JSONObject jSONObject) throws ParseError {
        this(an0Var, jSONObject, false);
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

    public AdBaseModel(@NonNull an0 an0Var, @NonNull JSONObject jSONObject, boolean z) throws ParseError {
        rm0 a;
        AdOperator a2;
        boolean z2;
        nn0 d;
        int length;
        int length2;
        this.e = new ArrayList();
        this.o = new ArrayList();
        String str = an0Var.b;
        JSONObject optJSONObject = jSONObject.optJSONObject(GameGuideConfigInfo.KEY_CLOSE_INFO);
        if (optJSONObject == null) {
            a = null;
        } else {
            a = rm0.a(optJSONObject);
        }
        this.g = a;
        this.f = an0Var;
        this.j = jn0.b(jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO), z);
        this.k = cn0.a(jSONObject.optJSONArray("prefetch_video"));
        this.l = sm0.b(jSONObject.optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO));
        this.m = wm0.a(jSONObject.optJSONObject("enhance"));
        um0.a(jSONObject.optJSONObject(InteractionPrivacySwitch.MODULE));
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
            d = nn0.d(optJSONObject3);
        }
        if (d != null) {
            d.m = an0Var.d;
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
                    ky0.b(this.e, new MonitorUrl(optString, optString2));
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
                    ky0.b(this.o, optString3);
                }
            }
        }
        jn0 jn0Var = this.j;
        if (jn0Var != null) {
            jn0Var.d(this);
        }
        this.c = null;
    }

    public void a(@Nullable mn0 mn0Var) {
        List<cn0> list;
        this.p = mn0Var;
        if (mn0Var == null || mn0Var.c) {
            this.f.b();
        }
        if ((mn0Var == null || mn0Var.d) && (list = this.k) != null && list.size() > 0) {
            for (cn0 cn0Var : this.k) {
                cn0Var.b();
            }
        }
    }
}
