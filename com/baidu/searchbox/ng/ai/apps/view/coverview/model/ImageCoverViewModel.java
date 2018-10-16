package com.baidu.searchbox.ng.ai.apps.view.coverview.model;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewType;
import com.baidu.searchbox.ng.ai.apps.view.container.util.Diff;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ImageCoverViewModel extends CoverViewModel {
    public static final String KEY_LOAD_STATE = "loadState";
    public static final String KEY_SRC = "src";
    public String imageSource;
    public boolean loadStateSwitcher;

    public ImageCoverViewModel() {
        super(AiAppsNAViewType.COVERIMAGE);
        this.loadStateSwitcher = false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.coverview.model.CoverViewModel, com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        if (jSONObject != null) {
            this.imageSource = jSONObject.optString(KEY_SRC);
            this.loadStateSwitcher = jSONObject.optBoolean(KEY_LOAD_STATE, false);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.coverview.model.CoverViewModel
    public void diff(CoverViewModel coverViewModel, Diff diff) {
        super.diff(coverViewModel, diff);
        if (coverViewModel instanceof ImageCoverViewModel) {
            ImageCoverViewModel imageCoverViewModel = (ImageCoverViewModel) coverViewModel;
            if (!TextUtils.equals(this.imageSource, imageCoverViewModel.imageSource)) {
                diff.mask(2);
            }
            if (this.loadStateSwitcher != imageCoverViewModel.loadStateSwitcher) {
                diff.mask(2);
            }
        }
    }
}
