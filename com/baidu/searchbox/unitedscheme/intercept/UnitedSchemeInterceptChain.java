package com.baidu.searchbox.unitedscheme.intercept;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class UnitedSchemeInterceptChain {
    public static final String TAG = "InterceptChain";
    public Map<String, UnitedSchemeBaseInterceptor> mInterceptors = Collections.synchronizedMap(new LinkedHashMap());

    public void addInterceptor(UnitedSchemeBaseInterceptor unitedSchemeBaseInterceptor) {
        if (unitedSchemeBaseInterceptor == null) {
            return;
        }
        this.mInterceptors.put(unitedSchemeBaseInterceptor.getInterceptorName(), unitedSchemeBaseInterceptor);
    }

    public boolean isEmpty() {
        return this.mInterceptors.isEmpty();
    }

    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        try {
            for (Map.Entry<String, UnitedSchemeBaseInterceptor> entry : this.mInterceptors.entrySet()) {
                UnitedSchemeBaseInterceptor value = entry.getValue();
                if (value != null && value.shouldInterceptDispatch(context, unitedSchemeEntity, callbackHandler)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            if (SchemeConfig.DEBUG) {
                Log.e(TAG, "error:" + e2.getMessage());
                return false;
            }
            return false;
        }
    }
}
