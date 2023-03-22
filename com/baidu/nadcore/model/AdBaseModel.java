package com.baidu.nadcore.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.TiebaMainDatabaseHelper;
import com.baidu.tieba.ep0;
import com.baidu.tieba.fp0;
import com.baidu.tieba.hp0;
import com.baidu.tieba.jp0;
import com.baidu.tieba.kh0;
import com.baidu.tieba.np0;
import com.baidu.tieba.pp0;
import com.baidu.tieba.u01;
import com.baidu.tieba.up0;
import com.baidu.tieba.xp0;
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
    public final np0 f;
    @Nullable
    public final ep0 g;
    @Nullable
    public final AdOperator h;
    @Nullable
    public final yp0 i;
    @Nullable
    public final up0 j;
    @Nullable
    public final List<pp0> k;
    @Nullable
    public final fp0 l;
    @Nullable
    public jp0 m;
    public int n;
    @NonNull
    public List<String> o;
    public xp0 p;
    public kh0 q;

    public AdBaseModel(@NonNull np0 np0Var, @NonNull JSONObject jSONObject) throws ParseError {
        this(np0Var, jSONObject, false);
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

    public AdBaseModel(@NonNull np0 np0Var, @NonNull JSONObject jSONObject, boolean z) throws ParseError {
        ep0 a;
        AdOperator a2;
        boolean z2;
        yp0 c;
        int length;
        int length2;
        this.e = new ArrayList();
        this.o = new ArrayList();
        String str = np0Var.b;
        JSONObject optJSONObject = jSONObject.optJSONObject(GameGuideConfigInfo.KEY_CLOSE_INFO);
        if (optJSONObject == null) {
            a = null;
        } else {
            a = ep0.a(optJSONObject);
        }
        this.g = a;
        this.f = np0Var;
        this.j = up0.b(jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO), z);
        this.k = pp0.a(jSONObject.optJSONArray("prefetch_video"));
        this.l = fp0.b(jSONObject.optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO));
        this.m = jp0.a(jSONObject.optJSONObject("enhance"));
        hp0.a(jSONObject.optJSONObject("interaction"));
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
            c = yp0.c(optJSONObject3);
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
                    u01.b(this.e, new MonitorUrl(optString, optString2));
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
                    u01.b(this.o, optString3);
                }
            }
        }
        up0 up0Var = this.j;
        if (up0Var != null) {
            up0Var.d(this);
        }
        this.c = null;
    }

    public void a(@Nullable xp0 xp0Var) {
        List<pp0> list;
        this.p = xp0Var;
        if (xp0Var == null || xp0Var.c) {
            this.f.b();
        }
        if ((xp0Var == null || xp0Var.d) && (list = this.k) != null && list.size() > 0) {
            for (pp0 pp0Var : this.k) {
                pp0Var.b();
            }
        }
    }
}
