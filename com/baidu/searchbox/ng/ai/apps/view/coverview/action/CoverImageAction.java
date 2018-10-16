package com.baidu.searchbox.ng.ai.apps.view.coverview.action;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.CoverViewModel;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.ImageCoverViewModel;
import com.baidu.searchbox.ng.ai.apps.view.coverview.subview.CoverViewHelper;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.webkit.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CoverImageAction extends CoverViewAction {
    private static final String ACTION_INSERT = "/swan/coverimage/insert";
    private static final String ACTION_REMOVE = "/swan/coverimage/remove";
    private static final String ACTION_UPDATE = "/swan/coverimage/update";
    private static final String MODULE_NAME = "/swan/coverimage";
    private static final String MODULE_PATH = "/swan/coverimage/";
    private static final String TAG = "CoverImage";

    public CoverImageAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, MODULE_NAME);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.coverview.action.CoverViewAction
    protected boolean onHandleSubAction(String str, Context context, @NonNull CoverViewModel coverViewModel, @NonNull WebView webView, @NonNull UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 279649557:
                if (str.equals(ACTION_INSERT)) {
                    c = 0;
                    break;
                }
                break;
            case 528831200:
                if (str.equals(ACTION_REMOVE)) {
                    c = 2;
                    break;
                }
                break;
            case 624595749:
                if (str.equals(ACTION_UPDATE)) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return performInsertAction(context, coverViewModel, webView, unitedSchemeEntity, callbackHandler);
            case 1:
                return performUpdateAction(context, coverViewModel, webView, unitedSchemeEntity, callbackHandler);
            case 2:
                return performRemoveAction(context, coverViewModel, webView, unitedSchemeEntity, callbackHandler);
            default:
                return false;
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.coverview.action.CoverViewAction
    protected CoverViewModel createModel(JSONObject jSONObject) {
        ImageCoverViewModel imageCoverViewModel = new ImageCoverViewModel();
        imageCoverViewModel.type = CoverViewHelper.Type.IMAGE;
        try {
            imageCoverViewModel.parseFromJson(jSONObject);
        } catch (JSONException e) {
            AiAppsLog.e(TAG, "model parse exception:", e);
        }
        return imageCoverViewModel;
    }
}
