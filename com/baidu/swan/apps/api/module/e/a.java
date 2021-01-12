package com.baidu.swan.apps.api.module.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends com.baidu.swan.apps.api.a.d {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b jW(String str) {
        if (DEBUG) {
            Log.d("Api-LoadingView", "start show loading");
        }
        if (ajr()) {
            com.baidu.swan.apps.console.c.e("Api-LoadingView", "Api-LoadingView does not supported when app is invisible.");
            return new com.baidu.swan.apps.api.c.b(1001, "Api-LoadingView does not supported when app is invisible.");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bn = com.baidu.swan.apps.api.d.b.bn("Api-LoadingView", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bn.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-LoadingView", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bn.second;
        com.baidu.swan.apps.console.c.i("Api-LoadingView", "handleShowLoading : joParams = \n" + jSONObject);
        String optString = jSONObject.optString("title");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-LoadingView", "none title");
            }
            return new com.baidu.swan.apps.api.c.b(202, "none title");
        }
        boolean optBoolean = jSONObject.optBoolean("mask", false);
        Context context = getContext();
        if (!(context instanceof SwanAppActivity)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-LoadingView", "context not support");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "context not support");
        }
        com.baidu.swan.apps.core.d.f afz = ((SwanAppActivity) context).afz();
        if (afz == null) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-LoadingView", "none fragment");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "none fragment");
        }
        com.baidu.swan.apps.core.d.c aoY = afz.aoY();
        if (!(aoY instanceof a.InterfaceC0456a)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-LoadingView", "fragment not support");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "fragment not support");
        }
        com.baidu.swan.apps.res.widget.floatlayer.a afu = ((a.InterfaceC0456a) aoY).afu();
        if (afu == null) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-LoadingView", "can't get floatLayer");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "can't get floatLayer");
        }
        a(afu, context, optString, optBoolean);
        com.baidu.swan.apps.console.c.i("Api-LoadingView", "show loading success");
        return new com.baidu.swan.apps.api.c.b(0);
    }

    private void a(@NonNull final com.baidu.swan.apps.res.widget.floatlayer.a aVar, @NonNull final Context context, final String str, final boolean z) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.a.1
            @Override // java.lang.Runnable
            public void run() {
                LoadingView loadingView;
                View view = aVar.getView();
                if (view instanceof LoadingView) {
                    loadingView = (LoadingView) view;
                } else {
                    loadingView = new LoadingView(context);
                    FrameLayout frameLayout = new FrameLayout(context);
                    frameLayout.setPadding(0, 0, 0, ah.O(160.0f));
                    frameLayout.addView(loadingView);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    aVar.c(frameLayout, layoutParams);
                }
                if (!TextUtils.isEmpty(str)) {
                    loadingView.setMsg(str);
                }
                aVar.setMask(z);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b ajz() {
        Context context = getContext();
        if (!(context instanceof SwanAppActivity)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-LoadingView", "context not support");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "context not support");
        }
        com.baidu.swan.apps.core.d.f afz = ((SwanAppActivity) context).afz();
        if (afz == null) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-LoadingView", "none fragmentManger");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "none fragmentManger");
        }
        final com.baidu.swan.apps.core.d.c aoY = afz.aoY();
        if (!(aoY instanceof a.InterfaceC0456a)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-LoadingView", "fragment not support");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "fragment not support");
        } else if (aoY.getContext() == null) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-LoadingView", "fragment has detached");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "fragment has detached");
        } else {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.res.widget.floatlayer.a afu = ((a.InterfaceC0456a) aoY).afu();
                    if (afu != null && (afu.getView() instanceof FrameLayout) && (((FrameLayout) afu.getView()).getChildAt(0) instanceof LoadingView)) {
                        afu.reset();
                    }
                }
            });
            com.baidu.swan.apps.console.c.i("Api-LoadingView", "hide loading success");
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }
}
