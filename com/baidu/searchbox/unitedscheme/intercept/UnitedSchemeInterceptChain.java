package com.baidu.searchbox.unitedscheme.intercept;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class UnitedSchemeInterceptChain {
    private static final String TAG = "UnitedSchemeInterceptChain";
    private Map<String, UnitedSchemeBaseInterceptor> mInterceptors = Collections.synchronizedMap(new LinkedHashMap());

    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        try {
            for (Map.Entry<String, UnitedSchemeBaseInterceptor> entry : this.mInterceptors.entrySet()) {
                UnitedSchemeBaseInterceptor value = entry.getValue();
                if (value != null && value.shouldInterceptDispatch(context, unitedSchemeEntity, callbackHandler)) {
                    return true;
                }
            }
        } catch (Exception e) {
            if (SchemeConfig.DEBUG) {
                Log.e(TAG, "error:" + e.getMessage());
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
