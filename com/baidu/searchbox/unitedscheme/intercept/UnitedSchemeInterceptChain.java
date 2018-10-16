package com.baidu.searchbox.unitedscheme.intercept;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class UnitedSchemeInterceptChain {
    private Map<String, UnitedSchemeBaseInterceptor> mInterceptors = new LinkedHashMap();

    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        for (String str : this.mInterceptors.keySet()) {
            UnitedSchemeBaseInterceptor unitedSchemeBaseInterceptor = this.mInterceptors.get(str);
            if (unitedSchemeBaseInterceptor != null && unitedSchemeBaseInterceptor.shouldInterceptDispatch(context, unitedSchemeEntity, callbackHandler)) {
                return true;
            }
        }
        return false;
    }

    public void addInterceptor(UnitedSchemeBaseInterceptor unitedSchemeBaseInterceptor) {
        if (unitedSchemeBaseInterceptor != null) {
            this.mInterceptors.put(unitedSchemeBaseInterceptor.getInterceptorName(), unitedSchemeBaseInterceptor);
        }
    }

    public void removeInterceptor(UnitedSchemeBaseInterceptor unitedSchemeBaseInterceptor) {
        if (unitedSchemeBaseInterceptor != null) {
            this.mInterceptors.remove(unitedSchemeBaseInterceptor.getInterceptorName());
        }
    }

    public void clearChain() {
        this.mInterceptors.clear();
    }
}
