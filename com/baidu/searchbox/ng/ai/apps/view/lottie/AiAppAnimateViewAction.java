package com.baidu.searchbox.ng.ai.apps.view.lottie;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsRectPosition;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AbsAiAppWidgetAction;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewContainer;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewType;
import com.baidu.searchbox.ng.ai.apps.view.container.util.NAViewFinder;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppAnimateViewAction extends AbsAiAppWidgetAction {
    public static final String MODULE_NAME = "/swan/animView";
    private static final String SCHEME_BDFILE = "bdfile";

    public AiAppAnimateViewAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, MODULE_NAME);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AbsAiAppWidgetAction
    @NonNull
    public String getModuleName() {
        return MODULE_NAME;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AbsAiAppWidgetAction
    public boolean insertAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp) {
        JSONObject paramsJSONObject = getParamsJSONObject(unitedSchemeEntity);
        if (paramsJSONObject == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            AiAppsLog.e("AbsAiAppWidget", "params is null");
            return false;
        }
        AnimateConcreteModel animateConcreteModel = new AnimateConcreteModel(paramsJSONObject);
        if (!animateConcreteModel.isValidWithPathParams()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            AiAppsLog.e("AbsAiAppWidget", "parse insert params, but invalid");
            return false;
        }
        JSONObject sdCardPath = getSdCardPath(animateConcreteModel.path, aiApp);
        if (sdCardPath == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            AiAppsLog.e("AbsAiAppWidget", "parse insert params, path file is invalid");
            return false;
        }
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        lottieAnimationView.G(animateConcreteModel.loop);
        lottieAnimationView.setAnimation(sdCardPath);
        if (animateConcreteModel.style != null) {
            lottieAnimationView.a(new PorterDuffColorFilter(Color.parseColor(animateConcreteModel.style.bgColor), PorterDuff.Mode.ADD));
            lottieAnimationView.setAlpha(animateConcreteModel.style.opacity);
        }
        if (animateConcreteModel.autoPlay) {
            lottieAnimationView.cv();
        }
        boolean insertView = new AiAppsNAViewContainer(context).insertView(lottieAnimationView, animateConcreteModel);
        AiAppsLog.i("AbsAiAppWidget", "insert anim view success = " + insertView);
        if (insertView) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            AiAppsLog.e("AbsAiAppWidget", "insert anim view, but failure");
        }
        return insertView;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AbsAiAppWidgetAction
    public boolean updateAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp) {
        JSONObject paramsJSONObject = getParamsJSONObject(unitedSchemeEntity);
        if (paramsJSONObject == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            AiAppsLog.e("AbsAiAppWidget", "params is null");
            return false;
        }
        AnimateConcreteModel animateConcreteModel = new AnimateConcreteModel(paramsJSONObject);
        if (!animateConcreteModel.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            AiAppsLog.e("AbsAiAppWidget", "parse update params, but invalid");
            return false;
        }
        AiAppsNAViewContainer findNAViewContainer = NAViewFinder.findNAViewContainer(animateConcreteModel, null);
        if (findNAViewContainer == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            AiAppsLog.e("AbsAiAppWidget", "get wrapper is null");
            return false;
        }
        View nAView = findNAViewContainer.getNAView();
        if (nAView == null || !(nAView instanceof LottieAnimationView)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            AiAppsLog.e("AbsAiAppWidget", "get lottie view is null");
            return false;
        }
        LottieAnimationView lottieAnimationView = (LottieAnimationView) nAView;
        if (animateConcreteModel.style != null) {
            lottieAnimationView.a(new PorterDuffColorFilter(Color.parseColor(animateConcreteModel.style.bgColor), PorterDuff.Mode.ADD));
            lottieAnimationView.setAlpha(animateConcreteModel.style.opacity);
        }
        String str2 = animateConcreteModel.action;
        if (TextUtils.equals(str2, "play")) {
            lottieAnimationView.cw();
        } else if (TextUtils.equals(str2, "pause")) {
            lottieAnimationView.cx();
        } else if (TextUtils.equals(str2, IntentConfig.STOP)) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setProgress(0.0f);
        }
        boolean updateView = findNAViewContainer.updateView(animateConcreteModel);
        AiAppsLog.i("AbsAiAppWidget", "update anim view success = " + updateView);
        if (updateView) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return updateView;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        AiAppsLog.e("AbsAiAppWidget", "update anim view, but failure");
        return updateView;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AbsAiAppWidgetAction
    public boolean removeAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp) {
        JSONObject paramsJSONObject = getParamsJSONObject(unitedSchemeEntity);
        if (paramsJSONObject == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            AiAppsLog.e("AbsAiAppWidget", "params is null");
            return false;
        }
        AnimateConcreteModel animateConcreteModel = new AnimateConcreteModel(paramsJSONObject);
        if (!animateConcreteModel.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            AiAppsLog.e("AbsAiAppWidget", "parse remove params, but invalid");
            return false;
        }
        AiAppsNAViewContainer findNAViewContainer = NAViewFinder.findNAViewContainer(animateConcreteModel, null);
        boolean z = findNAViewContainer != null && findNAViewContainer.removeView();
        AiAppsLog.i("AbsAiAppWidget", "remove anim view success = " + z);
        if (z) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            AiAppsLog.e("AbsAiAppWidget", "remove anim view, but failure");
        }
        return z;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AbsAiAppWidgetAction
    public boolean otherSubAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp) {
        return false;
    }

    /* loaded from: classes2.dex */
    private class AnimateConcreteModel extends AiAppsNaViewModel {
        private static final String ANIM_ACTION = "action";
        private static final String ANIM_AUTO_PLAY = "autoPlay";
        private static final String ANIM_LOOP = "loop";
        private static final String ANIM_PATH = "path";
        private static final String ANIM_STYLE = "style";
        private static final String ANIM_STYLE_BG_COLOR = "bgColor";
        private static final String ANIM_STYLE_OPACITY = "opacity";
        private static final String ANIM_VIEW_ID = "viewId";
        private static final String PAUSE = "pause";
        private static final String PLAY = "play";
        private static final String STOP = "stop";
        String action;
        boolean autoPlay;
        boolean loop;
        String path;
        AiAppsRectPosition position;
        AnimStyle style;

        AnimateConcreteModel(JSONObject jSONObject) {
            super(ANIM_VIEW_ID, AiAppsNAViewType.ANIMATEVIEW);
            this.loop = false;
            this.autoPlay = true;
            this.action = null;
            try {
                parseFromJson(jSONObject);
            } catch (JSONException e) {
                AiAppsLog.e("animView", "parsing animView occurs exception", e);
            }
        }

        @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.path = jSONObject.optString("path");
                this.loop = jSONObject.optBoolean(ANIM_LOOP);
                this.autoPlay = jSONObject.optBoolean(ANIM_AUTO_PLAY);
                this.action = jSONObject.optString("action");
                JSONObject optJSONObject = jSONObject.optJSONObject("style");
                if (optJSONObject != null) {
                    this.style = new AnimStyle();
                    this.style.bgColor = optJSONObject.optString("bgColor");
                    this.style.opacity = (float) optJSONObject.optDouble("opacity");
                }
            }
        }

        @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
        public boolean isValid() {
            return (TextUtils.isEmpty(this.slaveId) || TextUtils.isEmpty(this.id)) ? false : true;
        }

        public boolean isValidWithPathParams() {
            return isValid() && !TextUtils.isEmpty(this.path);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class AnimStyle {
            String bgColor;
            float opacity;

            AnimStyle() {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [369=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:48:0x008f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONObject getSdCardPath(String str, AiApp aiApp) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str) || aiApp == null) {
            return null;
        }
        try {
            String scheme2Path = SCHEME_BDFILE.equalsIgnoreCase(URI.create(str).getScheme()) ? StorageUtil.scheme2Path(str, aiApp.id) : StorageUtil.relativeToPath(str, aiApp, aiApp.getVersion());
            ?? isEmpty = TextUtils.isEmpty(scheme2Path);
            if (isEmpty != 0) {
                return null;
            }
            File file = new File(scheme2Path);
            if (!file.exists()) {
                return null;
            }
            try {
                if (file.isFile()) {
                    try {
                        bufferedReader = new BufferedReader(new FileReader(file));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            jSONObject = new JSONObject(sb.toString());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e) {
                                }
                            }
                        } catch (IOException e2) {
                            bufferedReader2 = bufferedReader;
                            bufferedReader = bufferedReader2;
                            AiAppsLog.e("AbsAiAppWidget", "insert anim view, read json data occur exception");
                            if (bufferedReader == null) {
                                try {
                                    bufferedReader.close();
                                    jSONObject = null;
                                } catch (IOException e3) {
                                    jSONObject = null;
                                }
                            } else {
                                jSONObject = null;
                            }
                            return jSONObject;
                        } catch (JSONException e4) {
                            AiAppsLog.e("AbsAiAppWidget", "insert anim view, read json data occur exception");
                            if (bufferedReader == null) {
                            }
                            return jSONObject;
                        }
                    } catch (IOException e5) {
                        bufferedReader2 = null;
                    } catch (JSONException e6) {
                        bufferedReader = null;
                    } catch (Throwable th) {
                        th = th;
                        isEmpty = 0;
                        if (isEmpty != 0) {
                            try {
                                isEmpty.close();
                            } catch (IOException e7) {
                            }
                        }
                        throw th;
                    }
                    return jSONObject;
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e8) {
            return null;
        }
    }
}
