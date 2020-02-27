package com.baidu.m.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes6.dex */
public class a extends com.baidu.swan.apps.component.a.d.a<View, b> {
    private com.baidu.swan.apps.y.a cGi;

    public a(@Nullable Context context, @NonNull b bVar) {
        super(context, bVar);
        this.cGi = new com.baidu.swan.apps.y.a() { // from class: com.baidu.m.b.a.1
            @Override // com.baidu.swan.apps.y.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                super.onActivityStopped(activity);
                com.baidu.m.d.b.awR().stop();
            }

            @Override // com.baidu.swan.apps.y.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                com.baidu.m.d.b.awR().resetPreview();
            }
        };
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected View bn(@NonNull Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.addView(com.baidu.m.d.b.awR().getRecorderView(), awN());
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
    public void cd(boolean z) {
        super.cd(z);
        com.baidu.swan.apps.w.a.TU().registerActivityLifecycleCallbacks(this.cGi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void onRemove() {
        super.onRemove();
        com.baidu.swan.apps.w.a.TU().unregisterActivityLifecycleCallbacks(this.cGi);
    }

    private LinearLayout.LayoutParams awN() {
        int i;
        if (KG() == 0 || ((b) KG()).bip == null) {
            i = 200;
        } else {
            i = ((b) KG()).bip.getWidth() / 2;
        }
        return new LinearLayout.LayoutParams(i, -1);
    }

    public void awO() {
        if (getView() != 0 && com.baidu.m.d.b.awR().getPlayerView() != null && com.baidu.m.d.b.awR().getPlayerView().getParent() == null) {
            ((ViewGroup) getView()).addView(com.baidu.m.d.b.awR().getPlayerView(), awN());
        }
    }
}
