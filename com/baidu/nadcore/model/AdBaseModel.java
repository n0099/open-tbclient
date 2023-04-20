package com.baidu.nadcore.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.TiebaMainDatabaseHelper;
import com.baidu.tieba.aq0;
import com.baidu.tieba.gp0;
import com.baidu.tieba.hp0;
import com.baidu.tieba.jp0;
import com.baidu.tieba.lp0;
import com.baidu.tieba.mh0;
import com.baidu.tieba.pp0;
import com.baidu.tieba.rp0;
import com.baidu.tieba.w01;
import com.baidu.tieba.wp0;
import com.baidu.tieba.zp0;
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
    public final pp0 f;
    @Nullable
    public final gp0 g;
    @Nullable
    public final AdOperator h;
    @Nullable
    public final aq0 i;
    @Nullable
    public final wp0 j;
    @Nullable
    public final List<rp0> k;
    @Nullable
    public final hp0 l;
    @Nullable
    public lp0 m;
    public int n;
    @NonNull
    public List<String> o;
    public zp0 p;
    public mh0 q;

    public AdBaseModel(@NonNull pp0 pp0Var, @NonNull JSONObject jSONObject) throws ParseError {
        this(pp0Var, jSONObject, false);
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

    public AdBaseModel(@NonNull pp0 pp0Var, @NonNull JSONObject jSONObject, boolean z) throws ParseError {
        gp0 a;
        AdOperator a2;
        boolean z2;
        aq0 c;
        int length;
        int length2;
        this.e = new ArrayList();
        this.o = new ArrayList();
        String str = pp0Var.b;
        JSONObject optJSONObject = jSONObject.optJSONObject(GameGuideConfigInfo.KEY_CLOSE_INFO);
        if (optJSONObject == null) {
            a = null;
        } else {
            a = gp0.a(optJSONObject);
        }
        this.g = a;
        this.f = pp0Var;
        this.j = wp0.b(jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO), z);
        this.k = rp0.a(jSONObject.optJSONArray("prefetch_video"));
        this.l = hp0.b(jSONObject.optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO));
        this.m = lp0.a(jSONObject.optJSONObject("enhance"));
        jp0.a(jSONObject.optJSONObject("interaction"));
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
            c = aq0.c(optJSONObject3);
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
                    w01.b(this.e, new MonitorUrl(optString, optString2));
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
                    w01.b(this.o, optString3);
                }
            }
        }
        wp0 wp0Var = this.j;
        if (wp0Var != null) {
            wp0Var.d(this);
        }
        this.c = null;
    }

    public void a(@Nullable zp0 zp0Var) {
        List<rp0> list;
        this.p = zp0Var;
        if (zp0Var == null || zp0Var.c) {
            this.f.b();
        }
        if ((zp0Var == null || zp0Var.d) && (list = this.k) != null && list.size() > 0) {
            for (rp0 rp0Var : this.k) {
                rp0Var.b();
            }
        }
    }
}
