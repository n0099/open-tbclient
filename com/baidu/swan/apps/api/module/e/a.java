package com.baidu.swan.apps.api.module.e;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.apps.api.a.c {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b gy(String str) {
        if (DEBUG) {
            Log.d("Api-LoadingView", "start show loading");
        }
        if (Rt()) {
            com.baidu.swan.apps.console.c.e("Api-LoadingView", "Api-LoadingView does not supported when app is invisible.");
            return new com.baidu.swan.apps.api.b.b(1001, "Api-LoadingView does not supported when app is invisible.");
        }
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> az = com.baidu.swan.apps.api.c.b.az("Api-LoadingView", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) az.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-LoadingView", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) az.second;
        com.baidu.swan.apps.console.c.i("Api-LoadingView", "handleShowLoading : joParams = \n" + jSONObject);
        String optString = jSONObject.optString("title");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-LoadingView", "none title");
            }
            return new com.baidu.swan.apps.api.b.b(202, "none title");
        }
        boolean optBoolean = jSONObject.optBoolean("mask", false);
        Context context = getContext();
        if (!(context instanceof SwanAppActivity)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-LoadingView", "context not support");
            }
            return new com.baidu.swan.apps.api.b.b(1001, "context not support");
        }
        com.baidu.swan.apps.core.d.e Ot = ((SwanAppActivity) context).Ot();
        if (Ot == null) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-LoadingView", "none fragment");
            }
            return new com.baidu.swan.apps.api.b.b(1001, "none fragment");
        }
        com.baidu.swan.apps.core.d.b Wd = Ot.Wd();
        if (!(Wd instanceof a.InterfaceC0334a)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-LoadingView", "fragment not support");
            }
            return new com.baidu.swan.apps.api.b.b(1001, "fragment not support");
        }
        com.baidu.swan.apps.res.widget.floatlayer.a Oo = ((a.InterfaceC0334a) Wd).Oo();
        if (Oo == null) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-LoadingView", "can't get floatLayer");
            }
            return new com.baidu.swan.apps.api.b.b(1001, "can't get floatLayer");
        }
        a(Oo, context, optString, optBoolean);
        com.baidu.swan.apps.console.c.i("Api-LoadingView", "show loading success");
        return new com.baidu.swan.apps.api.b.b(0);
    }

    private void a(@NonNull final com.baidu.swan.apps.res.widget.floatlayer.a aVar, @NonNull final Context context, final String str, final boolean z) {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.a.1
            @Override // java.lang.Runnable
            public void run() {
                LoadingView loadingView;
                View view = aVar.getView();
                if (view instanceof LoadingView) {
                    loadingView = (LoadingView) view;
                } else {
                    loadingView = new LoadingView(context);
                    aVar.aq(loadingView);
                }
                if (!TextUtils.isEmpty(str)) {
                    loadingView.setMsg(str);
                }
                aVar.setMask(z);
            }
        });
    }

    public com.baidu.swan.apps.api.b.b RB() {
        Context context = getContext();
        if (!(context instanceof SwanAppActivity)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-LoadingView", "context not support");
            }
            return new com.baidu.swan.apps.api.b.b(1001, "context not support");
        }
        com.baidu.swan.apps.core.d.e Ot = ((SwanAppActivity) context).Ot();
        if (Ot == null) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-LoadingView", "none fragmentManger");
            }
            return new com.baidu.swan.apps.api.b.b(1001, "none fragmentManger");
        }
        final com.baidu.swan.apps.core.d.b Wd = Ot.Wd();
        if (!(Wd instanceof a.InterfaceC0334a)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-LoadingView", "fragment not support");
            }
            return new com.baidu.swan.apps.api.b.b(1001, "fragment not support");
        } else if (Wd.getContext() == null) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-LoadingView", "fragment has detached");
            }
            return new com.baidu.swan.apps.api.b.b(1001, "fragment has detached");
        } else {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.res.widget.floatlayer.a Oo = ((a.InterfaceC0334a) Wd).Oo();
                    if (Oo != null && (Oo.getView() instanceof LoadingView)) {
                        Oo.reset();
                    }
                }
            });
            com.baidu.swan.apps.console.c.i("Api-LoadingView", "hide loading success");
            return new com.baidu.swan.apps.api.b.b(0);
        }
    }
}
