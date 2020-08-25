package com.baidu.o.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes7.dex */
public class a extends com.baidu.swan.apps.component.a.d.a<View, b> {
    private com.baidu.swan.apps.v.a dNd;

    public a(@Nullable Context context, @NonNull b bVar) {
        super(context, bVar);
        this.dNd = new com.baidu.swan.apps.v.a() { // from class: com.baidu.o.b.a.1
            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                super.onActivityStopped(activity);
                com.baidu.o.d.b.aXM().stop();
            }

            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                com.baidu.o.d.b.aXM().resetPreview();
            }
        };
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected View bf(@NonNull Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.addView(com.baidu.o.d.b.aXM().getRecorderView(), aXI());
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
    public void dE(boolean z) {
        super.dE(z);
        com.baidu.swan.apps.t.a.aoJ().registerActivityLifecycleCallbacks(this.dNd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void onRemove() {
        super.onRemove();
        com.baidu.swan.apps.t.a.aoJ().unregisterActivityLifecycleCallbacks(this.dNd);
    }

    private LinearLayout.LayoutParams aXI() {
        int i;
        if (adc() == 0 || ((b) adc()).caX == null) {
            i = 200;
        } else {
            i = ((b) adc()).caX.getWidth() / 2;
        }
        return new LinearLayout.LayoutParams(i, -1);
    }

    public void aXJ() {
        if (getView() != 0 && com.baidu.o.d.b.aXM().getPlayerView() != null && com.baidu.o.d.b.aXM().getPlayerView().getParent() == null) {
            ((ViewGroup) getView()).addView(com.baidu.o.d.b.aXM().getPlayerView(), aXI());
        }
    }
}
