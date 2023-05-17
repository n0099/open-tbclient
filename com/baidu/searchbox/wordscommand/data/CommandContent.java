package com.baidu.searchbox.wordscommand.data;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CommandContent implements Serializable {
    public static final String KEY_IS_ALERT = "is_alert";
    public static final String VALUE_IS_ALERT = "1";
    public final String btnCancle;
    public final String btnSure;
    public final String imgUrl;
    public final boolean isRepeat;
    public final JSONObject logparam;
    public final boolean mShowable;
    public final String scheme;
    public final String tips;
    public final String title;

    public CommandContent(JSONObject jSONObject) {
        this.title = jSONObject.optString("title");
        this.imgUrl = jSONObject.optString("img");
        this.tips = jSONObject.optString("tips");
        this.scheme = jSONObject.optString("scheme");
        this.btnSure = jSONObject.optString("btn_sure");
        this.btnCancle = jSONObject.optString("btn_cancle");
        this.logparam = jSONObject.optJSONObject("logparam");
        this.isRepeat = TextUtils.equals("1", jSONObject.optString("is_repeat"));
        this.mShowable = TextUtils.equals("1", jSONObject.optString(KEY_IS_ALERT, "1"));
    }
}
