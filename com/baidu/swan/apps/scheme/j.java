package com.baidu.swan.apps.scheme;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.actions.ac;
import com.baidu.swan.apps.scheme.actions.ad;
import com.baidu.swan.apps.scheme.actions.ae;
import com.baidu.swan.apps.scheme.actions.k;
import com.baidu.swan.apps.scheme.actions.p;
import com.baidu.swan.apps.scheme.actions.q;
import com.baidu.swan.apps.scheme.actions.r;
import com.baidu.swan.apps.scheme.actions.t;
import com.baidu.swan.apps.scheme.actions.u;
import com.baidu.swan.apps.scheme.actions.x;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.storage.a.l;
import com.baidu.swan.apps.storage.a.m;
import com.baidu.swan.apps.storage.a.n;
import com.baidu.swan.apps.storage.a.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class j extends UnitedSchemeBaseDispatcher {
    private static final String TAG = j.class.getSimpleName();
    protected final Map<String, ab> bQJ = new HashMap();

    public j() {
        adH();
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        return "swanAPI";
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Uri uri = unitedSchemeEntity.getUri();
        if (uri == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty url");
            return false;
        } else if (uri.getPathSegments() == null || uri.getPathSegments().isEmpty()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty Segment");
            return false;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add("swanAPI");
            arrayList.addAll(uri.getPathSegments());
            String str = "/swanAPI" + uri.getPath();
            if (TextUtils.isEmpty(str) || !str.startsWith("/")) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "err path ：" + str);
                return false;
            }
            String str2 = str;
            for (int size = arrayList.size(); size > 0; size--) {
                String str3 = "/" + ((String) arrayList.get(size - 1));
                if (str2.isEmpty() || str2.length() < str3.length()) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "err path ：" + str2 + " @ " + str3);
                    return false;
                }
                ab abVar = this.bQJ.get(str2);
                if (abVar != null) {
                    if (unitedSchemeEntity.isOnlyVerify()) {
                        return true;
                    }
                    return abVar.a(context, unitedSchemeEntity, callbackHandler, "/swanAPI" + uri.getPath());
                }
                str2 = str2.substring(0, str2.length() - str3.length());
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "not support such action ：" + uri.getPath());
            return false;
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return null;
    }

    protected void adH() {
        this.bQJ.clear();
        a(new u(this));
        a(new com.baidu.swan.apps.network.i(this));
        a(new ae(this));
        a(new com.baidu.swan.apps.scheme.actions.g(this));
        a(new com.baidu.swan.apps.network.b(this));
        a(new p(this));
        a(new l(this));
        a(new m(this));
        a(new com.baidu.swan.apps.storage.a.f(this));
        a(new com.baidu.swan.apps.storage.a.g(this));
        a(new n(this));
        a(new o(this));
        a(new com.baidu.swan.apps.storage.a.i(this));
        a(new com.baidu.swan.apps.storage.a.j(this));
        a(new com.baidu.swan.apps.storage.a.a(this));
        a(new com.baidu.swan.apps.storage.a.b(this));
        a(new com.baidu.swan.apps.setting.a.g(this));
        a(new com.baidu.swan.apps.setting.a.f(this));
        a(new com.baidu.swan.apps.setting.a.e(this));
        a(new com.baidu.swan.apps.setting.a.c(this));
        a(new com.baidu.swan.apps.setting.a.b(this));
        a(new com.baidu.swan.apps.setting.a.a(this));
        a(new com.baidu.swan.apps.setting.a.d(this));
        a(new com.baidu.swan.apps.setting.a.i(this));
        a(new com.baidu.swan.apps.scheme.actions.j(this));
        a(new y(this));
        a(new com.baidu.swan.apps.k.a.a(this));
        a(new ad(this));
        a(new r(this));
        a(new q(this));
        a(new com.baidu.swan.apps.ao.e.a.a(this));
        a(new com.baidu.swan.apps.ao.e.a.b(this));
        a(new com.baidu.swan.apps.ao.a.a.a(this));
        a(new com.baidu.swan.apps.ao.a.a.b(this));
        a(new com.baidu.swan.apps.media.b.a.a(this));
        a(new t(this));
        a(new com.baidu.swan.apps.media.c.a.a(this));
        a(new com.baidu.swan.apps.network.l(this));
        a(new k(this));
        a(new com.baidu.swan.apps.scheme.actions.e.e(this));
        a(new com.baidu.swan.apps.scheme.actions.e.b(this));
        a(new com.baidu.swan.games.t.a.a.c(this));
        a(new com.baidu.swan.games.t.a.a.b(this));
        a(new com.baidu.swan.apps.g.a(this));
        a(new x(this));
        a(new SwanAppDownloadAction(this));
        a(new ac(this));
        a(new com.baidu.swan.apps.scheme.actions.e.c(this));
        a(new com.baidu.swan.apps.scheme.actions.d.a.b(this));
        a(new com.baidu.swan.apps.scheme.actions.d.a.a(this));
        a(new com.baidu.swan.apps.ao.g.a.a(this));
        a(new com.baidu.swan.apps.ao.g.a.b(this));
        a(new com.baidu.swan.apps.ao.c.a.c(this));
        a(new com.baidu.swan.apps.ao.c.a.a(this));
        a(new com.baidu.swan.apps.ao.b.a(this));
        a(new com.baidu.swan.apps.ao.i.a(this));
        a(new com.baidu.swan.apps.ao.b.b(this));
        a(new com.baidu.swan.apps.ao.b.c(this));
        a(new com.baidu.swan.apps.ao.h.a(this));
        a(new com.baidu.swan.apps.c.a.a.a(this));
        a(new com.baidu.swan.apps.setting.a.h(this));
        a(new com.baidu.swan.apps.r.b.d(this));
        a(new com.baidu.swan.apps.c.a.b.a.a(this));
    }

    public void a(ab abVar) {
        this.bQJ.put(abVar.name, abVar);
    }
}
