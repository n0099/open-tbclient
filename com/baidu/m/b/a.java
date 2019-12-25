package com.baidu.m.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes4.dex */
public class a extends com.baidu.swan.apps.component.a.d.a<View, b> {
    private com.baidu.swan.apps.y.a cBZ;

    public a(@Nullable Context context, @NonNull b bVar) {
        super(context, bVar);
        this.cBZ = new com.baidu.swan.apps.y.a() { // from class: com.baidu.m.b.a.1
            @Override // com.baidu.swan.apps.y.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                super.onActivityStopped(activity);
                com.baidu.m.d.b.auk().stop();
            }

            @Override // com.baidu.swan.apps.y.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                com.baidu.m.d.b.auk().resetPreview();
            }
        };
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected View bj(@NonNull Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.addView(com.baidu.m.d.b.auk().getRecorderView(), aug());
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
    public void bQ(boolean z) {
        super.bQ(z);
        com.baidu.swan.apps.w.a.Rk().registerActivityLifecycleCallbacks(this.cBZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void onRemove() {
        super.onRemove();
        com.baidu.swan.apps.w.a.Rk().unregisterActivityLifecycleCallbacks(this.cBZ);
    }

    private LinearLayout.LayoutParams aug() {
        int i;
        if (HV() == 0 || ((b) HV()).bdl == null) {
            i = 200;
        } else {
            i = ((b) HV()).bdl.getWidth() / 2;
        }
        return new LinearLayout.LayoutParams(i, -1);
    }

    public void auh() {
        if (getView() != 0 && com.baidu.m.d.b.auk().getPlayerView() != null && com.baidu.m.d.b.auk().getPlayerView().getParent() == null) {
            ((ViewGroup) getView()).addView(com.baidu.m.d.b.auk().getPlayerView(), aug());
        }
    }
}
