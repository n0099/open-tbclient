package com.baidu.searchbox.ng.ai.apps.view.coverview.action;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsRectPosition;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewContainer;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.searchbox.ng.ai.apps.view.container.util.NAViewFinder;
import com.baidu.searchbox.ng.ai.apps.view.coverview.OnActionCallback;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.CoverViewModel;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.ImageCoverViewModel;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.TextCoverViewModel;
import com.baidu.searchbox.ng.ai.apps.view.coverview.subview.CoverViewHelper;
import com.baidu.searchbox.ng.ai.apps.view.coverview.subview.ICoverView;
import com.baidu.searchbox.ng.ai.apps.view.coverview.subview.ImageCoverView;
import com.baidu.searchbox.ng.ai.apps.view.coverview.subview.TextCoverView;
import com.baidu.searchbox.ng.ai.apps.view.coverview.utils.CoverViewUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.webkit.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CoverViewAction extends AiAppAction {
    private static final String ACTION_INSERT = "/swan/coverview/insert";
    private static final String ACTION_REMOVE = "/swan/coverview/remove";
    private static final String ACTION_UPDATE = "/swan/coverview/update";
    private static final boolean DEBUG = false;
    private static final String KEY_PARAMS = "params";
    private static final String MODULE_NAME = "/swan/coverview";
    private static final String MODULE_PATH = "/swan/coverview/";
    private static final String TAG = "CoverView";

    public CoverViewAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, MODULE_NAME);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CoverViewAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher, String str) {
        super(unitedSchemeAiAppDispatcher, str);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handleSubAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            AiAppsLog.e("CoverView", "no params json");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        CoverViewModel createModel = createModel(optParamsAsJo);
        if (createModel == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        WebView bdWebViewBySlaveId = AiAppsUtils.getBdWebViewBySlaveId(createModel.slaveId);
        if (bdWebViewBySlaveId == null) {
            AiAppsLog.e("CoverView", "can not find webView by #" + createModel.slaveId);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return onHandleSubAction(str, context, createModel, bdWebViewBySlaveId, unitedSchemeEntity, callbackHandler);
    }

    protected CoverViewModel createModel(JSONObject jSONObject) {
        TextCoverViewModel textCoverViewModel = new TextCoverViewModel();
        textCoverViewModel.type = CoverViewHelper.Type.TEXT;
        try {
            textCoverViewModel.parseFromJson(jSONObject);
        } catch (JSONException e) {
            AiAppsLog.e("CoverView", "model parse exception:", e);
        }
        return textCoverViewModel;
    }

    protected boolean onHandleSubAction(String str, Context context, @NonNull CoverViewModel coverViewModel, @NonNull WebView webView, @NonNull UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 460013883:
                if (str.equals(ACTION_INSERT)) {
                    c = 0;
                    break;
                }
                break;
            case 709195526:
                if (str.equals(ACTION_REMOVE)) {
                    c = 2;
                    break;
                }
                break;
            case 804960075:
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
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
        }
    }

    public boolean performInsertAction(Context context, @NonNull CoverViewModel coverViewModel, @NonNull WebView webView, @NonNull UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        AiAppsRectPosition aiAppsRectPosition = coverViewModel.position;
        if (aiAppsRectPosition == null || !aiAppsRectPosition.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final ICoverView coverView = getCoverView(context, coverViewModel.type);
        coverView.bindModel(coverViewModel);
        coverView.setOnActionCallback(new OnActionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.view.coverview.action.CoverViewAction.1
            @Override // com.baidu.searchbox.ng.ai.apps.view.coverview.OnActionCallback
            public void onAction(int i, View view, @Nullable Object obj) {
                CoverViewModel model = coverView.getModel();
                switch (i) {
                    case 0:
                    case 1:
                        if (model != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("type", ImageCoverViewModel.KEY_LOAD_STATE);
                                jSONObject.put(AiAppsNaViewModel.KEY_PARENT_ID, model.parentId);
                                jSONObject.put("viewId", model.id);
                                jSONObject.put(ImageCoverViewModel.KEY_LOAD_STATE, i == 1 ? "finish" : AiAppsTouchHelper.TouchEventName.TOUCH_ERROR);
                            } catch (JSONException e) {
                                AiAppsLog.e("CoverView", "loadState callback error", e);
                            }
                            CoverViewAction.this.sendAsyncCallback(callbackHandler, jSONObject, model.callback);
                            return;
                        }
                        return;
                    case 2:
                        CoverViewHelper.ClickPosition clickPosition = coverView.getClickPosition();
                        if (model != null && clickPosition != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("type", AiAppsUBCStatistic.TYPE_CLICK);
                                jSONObject2.put(AiAppsNaViewModel.KEY_PARENT_ID, model.parentId);
                                jSONObject2.put("viewId", model.id);
                                jSONObject2.put(Config.EVENT_HEAT_X, AiAppsUIUtils.px2dp(clickPosition.x));
                                jSONObject2.put("y", AiAppsUIUtils.px2dp(clickPosition.y));
                            } catch (JSONException e2) {
                                AiAppsLog.e("CoverView", "click callback error", e2);
                            }
                            CoverViewAction.this.sendAsyncCallback(callbackHandler, jSONObject2, model.callback);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
        boolean insertView = new AiAppsNAViewContainer(context).insertView((View) coverView, coverView.getModel());
        if (insertView) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return insertView;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return insertView;
    }

    public boolean performUpdateAction(Context context, @NonNull CoverViewModel coverViewModel, @NonNull WebView webView, @NonNull UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        AiAppsRectPosition aiAppsRectPosition = coverViewModel.position;
        if (aiAppsRectPosition == null || !aiAppsRectPosition.isValid()) {
            AiAppsLog.e("CoverView", "position not valid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        AiAppsNAViewContainer findNAViewContainer = NAViewFinder.findNAViewContainer(coverViewModel, null);
        if (findNAViewContainer == null) {
            AiAppsLog.e("CoverView", "can't find coverView:#" + coverViewModel.id);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        boolean updateCoverView = CoverViewUtils.updateCoverView(findNAViewContainer, coverViewModel);
        if (updateCoverView) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        }
        return updateCoverView;
    }

    public boolean performRemoveAction(Context context, @NonNull CoverViewModel coverViewModel, @NonNull WebView webView, @NonNull UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        AiAppsNAViewContainer findNAViewContainer = NAViewFinder.findNAViewContainer(coverViewModel, null);
        if (findNAViewContainer == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        boolean removeView = findNAViewContainer.removeView();
        if (removeView) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        }
        return removeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAsyncCallback(@NonNull CallbackHandler callbackHandler, JSONObject jSONObject, String str) {
        AiAppsLog.i("CoverView", "sendAsyncCallback info: " + jSONObject);
        if (!TextUtils.isEmpty(str)) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        }
    }

    private ICoverView getCoverView(Context context, CoverViewHelper.Type type) {
        switch (type) {
            case TEXT:
                return new TextCoverView(context);
            case IMAGE:
                return new ImageCoverView(context);
            default:
                return new TextCoverView(context);
        }
    }
}
