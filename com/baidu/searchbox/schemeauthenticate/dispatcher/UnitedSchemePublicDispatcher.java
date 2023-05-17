package com.baidu.searchbox.schemeauthenticate.dispatcher;

import android.content.Context;
import android.util.Log;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
@Service
/* loaded from: classes4.dex */
public class UnitedSchemePublicDispatcher extends UnitedSchemeBaseDispatcher {
    public static final String MODULE_NAME = "public";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = UnitedSchemePublicDispatcher.class.getSimpleName();
    public static HashMap<String, Class<? extends UnitedSchemeBaseDispatcher>> mSubDispatchers = new HashMap<>();

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        return MODULE_NAME;
    }

    public UnitedSchemePublicDispatcher() {
        mSubDispatchers.put(UnitedSchemeThirdPartDispatcher.MODULE_NAME, UnitedSchemeThirdPartDispatcher.class);
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return mSubDispatchers.get(str);
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (DEBUG) {
            String str = TAG;
            Log.i(str, "invoke entity:" + unitedSchemeEntity);
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
        return false;
    }
}
