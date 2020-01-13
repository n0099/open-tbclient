package com.baidu.m.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes5.dex */
public class a extends com.baidu.swan.apps.component.a.d.a<View, b> {
    private com.baidu.swan.apps.y.a cCk;

    public a(@Nullable Context context, @NonNull b bVar) {
        super(context, bVar);
        this.cCk = new com.baidu.swan.apps.y.a() { // from class: com.baidu.m.b.a.1
            @Override // com.baidu.swan.apps.y.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                super.onActivityStopped(activity);
                com.baidu.m.d.b.auD().stop();
            }

            @Override // com.baidu.swan.apps.y.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                com.baidu.m.d.b.auD().resetPreview();
            }
        };
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected View bj(@NonNull Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.addView(com.baidu.m.d.b.auD().getRecorderView(), auz());
        return linearLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.d.a, com.baidu.swan.apps.component.b.a
    public void a(@NonNull View view, @NonNull b bVar, @NonNull com.baidu.swan.apps.component.d.b bVar2) {
        super.a((a) view, (View) bVar, bVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void bV(boolean z) {
        super.bV(z);
        com.baidu.swan.apps.w.a.RG().registerActivityLifecycleCallbacks(this.cCk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void onRemove() {
        super.onRemove();
        com.baidu.swan.apps.w.a.RG().unregisterActivityLifecycleCallbacks(this.cCk);
    }

    private LinearLayout.LayoutParams auz() {
        int i;
        if (Ir() == 0 || ((b) Ir()).bdZ == null) {
            i = 200;
        } else {
            i = ((b) Ir()).bdZ.getWidth() / 2;
        }
        return new LinearLayout.LayoutParams(i, -1);
    }

    public void auA() {
        if (getView() != 0 && com.baidu.m.d.b.auD().getPlayerView() != null && com.baidu.m.d.b.auD().getPlayerView().getParent() == null) {
            ((ViewGroup) getView()).addView(com.baidu.m.d.b.auD().getPlayerView(), auz());
        }
    }
}
