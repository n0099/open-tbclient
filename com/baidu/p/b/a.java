package com.baidu.p.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes15.dex */
public class a extends com.baidu.swan.apps.component.a.d.a<View, b> {
    private com.baidu.swan.apps.v.a euT;

    public a(@Nullable Context context, @NonNull b bVar) {
        super(context, bVar);
        this.euT = new com.baidu.swan.apps.v.a() { // from class: com.baidu.p.b.a.1
            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                super.onActivityStopped(activity);
                com.baidu.p.d.b.bhX().stop();
            }

            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                com.baidu.p.d.b.bhX().resetPreview();
            }
        };
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected View bQ(@NonNull Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.addView(com.baidu.p.d.b.bhX().getRecorderView(), bhT());
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
    public void eN(boolean z) {
        super.eN(z);
        com.baidu.swan.apps.t.a.aza().registerActivityLifecycleCallbacks(this.euT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void onRemove() {
        super.onRemove();
        com.baidu.swan.apps.t.a.aza().unregisterActivityLifecycleCallbacks(this.euT);
    }

    private LinearLayout.LayoutParams bhT() {
        int i;
        if (anq() == 0 || ((b) anq()).cIZ == null) {
            i = 200;
        } else {
            i = ((b) anq()).cIZ.getWidth() / 2;
        }
        return new LinearLayout.LayoutParams(i, -1);
    }

    public void bhU() {
        if (getView() != 0 && com.baidu.p.d.b.bhX().getPlayerView() != null && com.baidu.p.d.b.bhX().getPlayerView().getParent() == null) {
            ((ViewGroup) getView()).addView(com.baidu.p.d.b.bhX().getPlayerView(), bhT());
        }
    }
}
