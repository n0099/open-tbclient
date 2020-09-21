package com.baidu.o.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes6.dex */
public class a extends com.baidu.swan.apps.component.a.d.a<View, b> {
    private com.baidu.swan.apps.v.a dPk;

    public a(@Nullable Context context, @NonNull b bVar) {
        super(context, bVar);
        this.dPk = new com.baidu.swan.apps.v.a() { // from class: com.baidu.o.b.a.1
            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                super.onActivityStopped(activity);
                com.baidu.o.d.b.aYy().stop();
            }

            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                com.baidu.o.d.b.aYy().resetPreview();
            }
        };
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected View be(@NonNull Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.addView(com.baidu.o.d.b.aYy().getRecorderView(), aYu());
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
    public void dD(boolean z) {
        super.dD(z);
        com.baidu.swan.apps.t.a.apu().registerActivityLifecycleCallbacks(this.dPk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void onRemove() {
        super.onRemove();
        com.baidu.swan.apps.t.a.apu().unregisterActivityLifecycleCallbacks(this.dPk);
    }

    private LinearLayout.LayoutParams aYu() {
        int i;
        if (adL() == 0 || ((b) adL()).cdd == null) {
            i = 200;
        } else {
            i = ((b) adL()).cdd.getWidth() / 2;
        }
        return new LinearLayout.LayoutParams(i, -1);
    }

    public void aYv() {
        if (getView() != 0 && com.baidu.o.d.b.aYy().getPlayerView() != null && com.baidu.o.d.b.aYy().getPlayerView().getParent() == null) {
            ((ViewGroup) getView()).addView(com.baidu.o.d.b.aYy().getPlayerView(), aYu());
        }
    }
}
