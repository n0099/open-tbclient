package com.baidu.searchbox.ng.ai.apps.scheme;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.searchbox.ng.ai.apps.scheme.intercept.AiAppsLaunchInterceptor;
import com.baidu.searchbox.ng.ai.apps.scheme.intercept.AiAppsWebSafeInterceptor;
import com.baidu.searchbox.unitedscheme.ISchemeContext;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeInterceptChain;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class SchemeContext implements ISchemeContext {
    @Override // com.baidu.searchbox.unitedscheme.ISchemeContext
    public void addInterceptor(UnitedSchemeInterceptChain unitedSchemeInterceptChain) {
        unitedSchemeInterceptChain.addInterceptor(new AiAppsWebSafeInterceptor());
        unitedSchemeInterceptChain.addInterceptor(new AiAppsLaunchInterceptor());
    }

    @Override // com.baidu.searchbox.unitedscheme.ISchemeContext
    public void addDispatcher(HashMap<String, Class<? extends UnitedSchemeBaseDispatcher>> hashMap) {
        hashMap.put(AiAppUnitedSchemeUtilsDispatcher.MODULE_UTILS, AiAppUnitedSchemeUtilsDispatcher.class);
        hashMap.put(AiAppUnitedSchemeTTSDispatcher.MODULE_TTS, AiAppUnitedSchemeTTSDispatcher.class);
        hashMap.put(AiAppUnitedSchemeWalletDispatcher.MODULE_WALLET, AiAppUnitedSchemeWalletDispatcher.class);
        hashMap.put("swan", USStaticAiAppDispatcher.class);
    }

    @Override // com.baidu.searchbox.unitedscheme.ISchemeContext
    public void showSchemeNotSupportDialog(Context context) {
        UniversalToast.makeText(context, "current version is not support for this scheme").showToast();
    }
}
