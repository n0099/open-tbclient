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
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.actions.ac;
import com.baidu.swan.apps.scheme.actions.o;
import com.baidu.swan.apps.scheme.actions.p;
import com.baidu.swan.apps.scheme.actions.q;
import com.baidu.swan.apps.scheme.actions.s;
import com.baidu.swan.apps.scheme.actions.t;
import com.baidu.swan.apps.scheme.actions.w;
import com.baidu.swan.apps.scheme.actions.x;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.storage.a.l;
import com.baidu.swan.apps.storage.a.m;
import com.baidu.swan.apps.storage.a.n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class j extends UnitedSchemeBaseDispatcher {
    private static final String TAG = j.class.getSimpleName();
    protected final Map<String, z> aRY = new HashMap();

    public j() {
        MO();
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Uri uri = unitedSchemeEntity.getUri();
        if (uri == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty url");
            return false;
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty Segment");
            return false;
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path) || !path.startsWith("/")) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "err path ：" + path);
            return false;
        }
        String str = path;
        for (int size = pathSegments.size(); size > 0; size--) {
            String str2 = "/" + pathSegments.get(size - 1);
            if (str.isEmpty() || str.length() < str2.length()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "err path ：" + str + " @ " + str2);
                return false;
            }
            z zVar = this.aRY.get(str);
            if (zVar != null) {
                if (unitedSchemeEntity.isOnlyVerify()) {
                    return true;
                }
                return zVar.a(context, unitedSchemeEntity, callbackHandler, uri.getPath());
            }
            str = str.substring(0, str.length() - str2.length());
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "not support such action ：" + uri.getPath());
        return false;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return null;
    }

    protected void MO() {
        this.aRY.clear();
        a(new t(this));
        a(new com.baidu.swan.apps.network.i(this));
        a(new ac(this));
        a(new com.baidu.swan.apps.scheme.actions.f(this));
        a(new com.baidu.swan.apps.network.b(this));
        a(new o(this));
        a(new l(this));
        a(new m(this));
        a(new com.baidu.swan.apps.storage.a.f(this));
        a(new com.baidu.swan.apps.storage.a.g(this));
        a(new n(this));
        a(new com.baidu.swan.apps.storage.a.o(this));
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
        a(new com.baidu.swan.apps.setting.a.h(this));
        a(new com.baidu.swan.apps.scheme.actions.i(this));
        a(new x(this));
        a(new com.baidu.swan.apps.scheme.actions.d(this));
        a(new com.baidu.swan.apps.j.a.a(this));
        a(new ab(this));
        a(new q(this));
        a(new p(this));
        a(new com.baidu.swan.apps.aj.e.a.a(this));
        a(new com.baidu.swan.apps.aj.e.a.b(this));
        a(new com.baidu.swan.apps.aj.a.a.a(this));
        a(new com.baidu.swan.apps.aj.a.a.b(this));
        a(new com.baidu.swan.apps.media.c.a.a(this));
        a(new s(this));
        a(new com.baidu.swan.apps.media.d.a.a(this));
        a(new com.baidu.swan.apps.network.l(this));
        a(new com.baidu.swan.apps.scheme.actions.j(this));
        a(new com.baidu.swan.apps.scheme.actions.d.e(this));
        a(new com.baidu.swan.apps.scheme.actions.d.b(this));
        a(new com.baidu.swan.games.q.a.a.c(this));
        a(new com.baidu.swan.games.q.a.a.b(this));
        a(new com.baidu.swan.apps.h.a(this));
        a(new w(this));
        a(new SwanAppDownloadAction(this));
        a(new aa(this));
        a(new com.baidu.swan.apps.scheme.actions.d.c(this));
        a(new com.baidu.swan.apps.scheme.actions.c.a.b(this));
        a(new com.baidu.swan.apps.scheme.actions.c.a.a(this));
        a(new com.baidu.swan.apps.aj.g.a.a(this));
        a(new com.baidu.swan.apps.aj.g.a.b(this));
        a(new com.baidu.swan.apps.aj.b.a.c(this));
        a(new com.baidu.swan.apps.aj.b.a.a(this));
    }

    public void a(z zVar) {
        this.aRY.put(zVar.name, zVar);
    }
}
