package com.baidu.swan.apps.scheme;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.ISchemeContext;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeInterceptChain;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a implements ISchemeContext {
    @Override // com.baidu.searchbox.unitedscheme.ISchemeContext
    public void addInterceptor(UnitedSchemeInterceptChain unitedSchemeInterceptChain) {
        unitedSchemeInterceptChain.addInterceptor(new com.baidu.swan.apps.scheme.a.b());
        unitedSchemeInterceptChain.addInterceptor(new com.baidu.swan.apps.scheme.a.a());
        unitedSchemeInterceptChain.addInterceptor(new com.baidu.swan.games.k.a());
    }

    @Override // com.baidu.searchbox.unitedscheme.ISchemeContext
    public void addDispatcher(HashMap<String, Class<? extends UnitedSchemeBaseDispatcher>> hashMap) {
        hashMap.put("utils", g.class);
        hashMap.put("BDWallet", h.class);
        hashMap.put("swan", i.class);
    }

    @Override // com.baidu.searchbox.unitedscheme.ISchemeContext
    public void showSchemeNotSupportDialog(Context context) {
        com.baidu.swan.apps.res.widget.b.d.a(context, "current version is not support for this scheme").IK();
    }
}
