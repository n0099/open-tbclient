package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeInterceptChain;
import java.util.HashMap;
/* loaded from: classes2.dex */
public interface ISchemeContext {
    void addDispatcher(HashMap<String, Class<? extends UnitedSchemeBaseDispatcher>> hashMap);

    void addInterceptor(UnitedSchemeInterceptChain unitedSchemeInterceptChain);

    void showSchemeNotSupportDialog(Context context);
}
