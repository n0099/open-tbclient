package com.baidu.k.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes6.dex */
public class a extends com.baidu.swan.apps.component.a.d.a<View, b> {
    private com.baidu.swan.apps.v.a dDV;

    public a(@Nullable Context context, @NonNull b bVar) {
        super(context, bVar);
        this.dDV = new com.baidu.swan.apps.v.a() { // from class: com.baidu.k.b.a.1
            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                super.onActivityStopped(activity);
                com.baidu.k.d.b.aPw().stop();
            }

            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                com.baidu.k.d.b.aPw().resetPreview();
            }
        };
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected View ba(@NonNull Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.addView(com.baidu.k.d.b.aPw().getRecorderView(), aPs());
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
    public void dv(boolean z) {
        super.dv(z);
        com.baidu.swan.apps.t.a.ahj().registerActivityLifecycleCallbacks(this.dDV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void onRemove() {
        super.onRemove();
        com.baidu.swan.apps.t.a.ahj().unregisterActivityLifecycleCallbacks(this.dDV);
    }

    private LinearLayout.LayoutParams aPs() {
        int i;
        if (WW() == 0 || ((b) WW()).bVp == null) {
            i = 200;
        } else {
            i = ((b) WW()).bVp.getWidth() / 2;
        }
        return new LinearLayout.LayoutParams(i, -1);
    }

    public void aPt() {
        if (getView() != 0 && com.baidu.k.d.b.aPw().getPlayerView() != null && com.baidu.k.d.b.aPw().getPlayerView().getParent() == null) {
            ((ViewGroup) getView()).addView(com.baidu.k.d.b.aPw().getPlayerView(), aPs());
        }
    }
}
