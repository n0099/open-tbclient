package com.baidu.searchbox.ng.ai.apps.view.coverview.model;

import android.support.annotation.NonNull;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.text.TextUtils;
import android.view.animation.Interpolator;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.view.container.util.Diff;
import com.baidu.searchbox.ng.ai.apps.view.coverview.subview.CoverViewHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CoverViewModel extends AiAppsNaViewModel {
    private static final String KEY_STYLE = "style";
    private static final String KEY_TRANS = "transition";
    private static final String KEY_VIEW_ID = "viewId";
    public static final String MODULE_TAG = "CoverView";
    public static final String TRANS_EASE = "ease";
    public static final String TRANS_EASE_IN = "ease-in";
    public static final String TRANS_EASE_IN_OUT = "ease-in-out";
    public static final String TRANS_EASE_OUT = "ease-out";
    public static final String TRANS_KEY_DURATION = "duration";
    public static final String TRANS_KEY_EASING = "easing";
    public static final String TRANS_LINEAR = "linear";
    public JSONObject animData;
    public JSONObject styleData;
    public CoverViewHelper.Type type;

    public CoverViewModel(String str) {
        super(KEY_VIEW_ID, str);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.styleData = jSONObject.optJSONObject("style");
        this.animData = jSONObject.optJSONObject(KEY_TRANS);
    }

    public void diff(CoverViewModel coverViewModel, Diff diff) {
        if (coverViewModel != null && diff != null) {
            if (!TextUtils.equals(this.id, coverViewModel.id)) {
                diff.mask(15);
            } else if (coverViewModel.animData != null) {
                diff.mask(4);
            } else {
                if (this.position != null && !this.position.equals(coverViewModel.position)) {
                    diff.mask(1);
                }
                if (coverViewModel.hidden != this.hidden) {
                    diff.mask(8);
                }
                if (coverViewModel.styleData != null) {
                    if (this.styleData == null || !TextUtils.equals(this.styleData.toString(), coverViewModel.styleData.toString())) {
                        diff.mask(2);
                    }
                }
            }
        }
    }

    public static Interpolator obtainInterpolator(@NonNull String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1965120668:
                if (str.equals(TRANS_EASE_IN)) {
                    c = 1;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals(TRANS_LINEAR)) {
                    c = 0;
                    break;
                }
                break;
            case -789192465:
                if (str.equals(TRANS_EASE_OUT)) {
                    c = 2;
                    break;
                }
                break;
            case -361990811:
                if (str.equals(TRANS_EASE_IN_OUT)) {
                    c = 3;
                    break;
                }
                break;
            case 3105774:
                if (str.equals(TRANS_EASE)) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return PathInterpolatorCompat.create(0.0f, 0.0f, 1.0f, 1.0f);
            case 1:
                return PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
            case 2:
                return PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
            case 3:
                return PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f);
            default:
                return PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
        }
    }

    public String toString() {
        return "CoverViewModel{slaveId='" + this.slaveId + "', viewId='" + this.id + "', parentId='" + this.parentId + "', hidden=" + this.hidden + ", position=" + this.position + ", styleData=" + this.styleData + ", animData=" + this.animData + ", type=" + this.type + '}';
    }
}
