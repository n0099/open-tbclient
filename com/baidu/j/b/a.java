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
    private com.baidu.swan.apps.w.a dxZ;

    public a(@Nullable Context context, @NonNull b bVar) {
        super(context, bVar);
        this.dxZ = new com.baidu.swan.apps.w.a() { // from class: com.baidu.j.b.a.1
            @Override // com.baidu.swan.apps.w.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                super.onActivityStopped(activity);
                com.baidu.j.d.b.aLI().stop();
            }

            @Override // com.baidu.swan.apps.w.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                com.baidu.j.d.b.aLI().resetPreview();
            }
        };
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected View aZ(@NonNull Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.addView(com.baidu.j.d.b.aLI().getRecorderView(), aLE());
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
    public void ds(boolean z) {
        super.ds(z);
        com.baidu.swan.apps.u.a.afX().registerActivityLifecycleCallbacks(this.dxZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void onRemove() {
        super.onRemove();
        com.baidu.swan.apps.u.a.afX().unregisterActivityLifecycleCallbacks(this.dxZ);
    }

    private LinearLayout.LayoutParams aLE() {
        int i;
        if (Wp() == 0 || ((b) Wp()).bUx == null) {
            i = 200;
        } else {
            i = ((b) Wp()).bUx.getWidth() / 2;
        }
        return new LinearLayout.LayoutParams(i, -1);
    }

    public void aLF() {
        if (getView() != 0 && com.baidu.j.d.b.aLI().getPlayerView() != null && com.baidu.j.d.b.aLI().getPlayerView().getParent() == null) {
            ((ViewGroup) getView()).addView(com.baidu.j.d.b.aLI().getPlayerView(), aLE());
        }
    }
}
