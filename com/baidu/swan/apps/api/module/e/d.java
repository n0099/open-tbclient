package com.baidu.swan.apps.api.module.e;

import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.api.a.d;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d extends com.baidu.swan.apps.api.a.d {
    public d(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b jg(String str) {
        if (DEBUG) {
            Log.d("Api-PageScrollTo", "page scroll to");
        }
        return a(str, false, new d.a() { // from class: com.baidu.swan.apps.api.module.e.d.1
            @Override // com.baidu.swan.apps.api.a.d.a
            public com.baidu.swan.apps.api.c.b a(com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject, @Nullable String str2) {
                final int optInt = jSONObject.optInt("scrollTop", -1);
                final int optInt2 = jSONObject.optInt("duration", -1);
                if (optInt <= -1 || optInt2 <= -1) {
                    com.baidu.swan.apps.console.c.e("Api-PageScrollTo", "illegal scrollTop or duration");
                    return new com.baidu.swan.apps.api.c.b(1001, "illegal params");
                }
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.d.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final com.baidu.swan.apps.adaptation.b.d arJ = com.baidu.swan.apps.v.f.arY().arJ();
                        if (arJ != null) {
                            ValueAnimator ofInt = ValueAnimator.ofInt(arJ.getWebViewScrollY(), d.a(arJ, ah.dip2px(d.this.getContext(), optInt)));
                            ofInt.setDuration(optInt2);
                            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.api.module.e.d.1.1.1
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    arJ.webViewScrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                                }
                            });
                            ofInt.start();
                        }
                    }
                });
                return new com.baidu.swan.apps.api.c.b(0);
            }
        });
    }

    public static int a(@NonNull com.baidu.swan.apps.adaptation.b.d dVar, int i) {
        int contentHeight = ((int) (dVar.getContentHeight() * dVar.getScale())) - ((Integer) com.baidu.swan.apps.v.f.arY().arK().second).intValue();
        if (contentHeight <= 0) {
            return 0;
        }
        return i > contentHeight ? contentHeight : i;
    }
}
