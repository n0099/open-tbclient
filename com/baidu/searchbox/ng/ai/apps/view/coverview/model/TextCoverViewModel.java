package com.baidu.searchbox.ng.ai.apps.view.coverview.model;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewType;
import com.baidu.searchbox.ng.ai.apps.view.container.util.Diff;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TextCoverViewModel extends CoverViewModel {
    public static final String KEY_TEXT = "text";
    public String text;

    public TextCoverViewModel() {
        super(AiAppsNAViewType.COVERVIEW);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.coverview.model.CoverViewModel, com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        if (jSONObject != null) {
            this.text = jSONObject.optString("text");
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.coverview.model.CoverViewModel
    public void diff(CoverViewModel coverViewModel, Diff diff) {
        super.diff(coverViewModel, diff);
        if ((coverViewModel instanceof TextCoverViewModel) && !TextUtils.equals(this.text, ((TextCoverViewModel) coverViewModel).text)) {
            diff.mask(2);
        }
    }
}
