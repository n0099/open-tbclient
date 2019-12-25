package com.baidu.searchbox.suspensionball.unitedscheme;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.suspensionball.SuspensionBallManager;
import com.baidu.searchbox.suspensionball.SuspensionBallUtils;
import com.baidu.searchbox.suspensionball.SuspensionSpUtil;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class UnitedSchemeSuspensionBallDispatcher extends UnitedSchemeBaseDispatcher {
    public static final String MODULE_SUSPENSIONBALL = "suspensionBall";
    private static final String SCHEME_PATH_SUBPENSIONBALLTOAT_STATUS = "getSuspensionBallToastStatus";
    public static final String SUSPENSION_SHOW_TOAST_KEY = "suspensionBallToastStatus";
    private static final String TOAST_SHOW_VERSION = "11.12.0.0";

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        return UnitedSchemeBaseDispatcher.DISPATCHER_NOT_FIRST_LEVEL;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        }
        if (TextUtils.equals(unitedSchemeEntity.getPath(false), SCHEME_PATH_SUBPENSIONBALLTOAT_STATUS)) {
            JSONObject jSONObject = new JSONObject();
            boolean suspensionBallToastStatus = getSuspensionBallToastStatus();
            try {
                jSONObject.put(SUSPENSION_SHOW_TOAST_KEY, suspensionBallToastStatus ? "1" : "0");
            } catch (JSONException e) {
                e.printStackTrace();
                suspensionBallToastStatus = false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            if (suspensionBallToastStatus) {
                SuspensionSpUtil.putBoolean(SUSPENSION_SHOW_TOAST_KEY, true);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return null;
    }

    private boolean getSuspensionBallToastStatus() {
        String currentVersion = SuspensionBallUtils.getCurrentVersion();
        if (AppConfig.isDebug()) {
            Log.d("dispatcher", "——> getSuspensionBallToastStatus: " + currentVersion);
        }
        if (TextUtils.isEmpty(currentVersion) || SuspensionBallUtils.compareVersion(currentVersion, TOAST_SHOW_VERSION) == -1) {
            if (AppConfig.isDebug()) {
                Log.d("dispatcher", "——> getSuspensionBallToastStatus:  11.11 ");
                return false;
            }
            return false;
        } else if (!SuspensionBallManager.getInstance().isSuspensionBallSwitchOn() || SuspensionSpUtil.getBoolean(SUSPENSION_SHOW_TOAST_KEY, false)) {
            return false;
        } else {
            if (AppConfig.isDebug()) {
                Log.d("dispatcher", "——> getSuspensionBallToastStatus:  >= 11.12  开关开");
            }
            return true;
        }
    }
}
