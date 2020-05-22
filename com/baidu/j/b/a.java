package com.baidu.j.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes6.dex */
public class a extends com.baidu.swan.apps.component.a.d.a<View, b> {
    private com.baidu.swan.apps.w.a dtp;

    public a(@Nullable Context context, @NonNull b bVar) {
        super(context, bVar);
        this.dtp = new com.baidu.swan.apps.w.a() { // from class: com.baidu.j.b.a.1
            @Override // com.baidu.swan.apps.w.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                super.onActivityStopped(activity);
                com.baidu.j.d.b.aKC().stop();
            }

            @Override // com.baidu.swan.apps.w.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                com.baidu.j.d.b.aKC().resetPreview();
            }
        };
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected View aY(@NonNull Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.addView(com.baidu.j.d.b.aKC().getRecorderView(), aKy());
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
    public void dn(boolean z) {
        super.dn(z);
        com.baidu.swan.apps.u.a.aeR().registerActivityLifecycleCallbacks(this.dtp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void onRemove() {
        super.onRemove();
        com.baidu.swan.apps.u.a.aeR().unregisterActivityLifecycleCallbacks(this.dtp);
    }

    private LinearLayout.LayoutParams aKy() {
        int i;
        if (Vj() == 0 || ((b) Vj()).bPJ == null) {
            i = 200;
        } else {
            i = ((b) Vj()).bPJ.getWidth() / 2;
        }
        return new LinearLayout.LayoutParams(i, -1);
    }

    public void aKz() {
        if (getView() != 0 && com.baidu.j.d.b.aKC().getPlayerView() != null && com.baidu.j.d.b.aKC().getPlayerView().getParent() == null) {
            ((ViewGroup) getView()).addView(com.baidu.j.d.b.aKC().getPlayerView(), aKy());
        }
    }
}
