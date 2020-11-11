package com.baidu.o.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes19.dex */
public class a extends com.baidu.swan.apps.component.a.d.a<View, b> {
    private com.baidu.swan.apps.v.a epB;

    public a(@Nullable Context context, @NonNull b bVar) {
        super(context, bVar);
        this.epB = new com.baidu.swan.apps.v.a() { // from class: com.baidu.o.b.a.1
            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                super.onActivityStopped(activity);
                com.baidu.o.d.b.bfz().stop();
            }

            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                com.baidu.o.d.b.bfz().resetPreview();
            }
        };
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected View bk(@NonNull Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.addView(com.baidu.o.d.b.bfz().getRecorderView(), bfv());
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
    public void ev(boolean z) {
        super.ev(z);
        com.baidu.swan.apps.t.a.awA().registerActivityLifecycleCallbacks(this.epB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void onRemove() {
        super.onRemove();
        com.baidu.swan.apps.t.a.awA().unregisterActivityLifecycleCallbacks(this.epB);
    }

    private LinearLayout.LayoutParams bfv() {
        int i;
        if (akQ() == 0 || ((b) akQ()).cDO == null) {
            i = 200;
        } else {
            i = ((b) akQ()).cDO.getWidth() / 2;
        }
        return new LinearLayout.LayoutParams(i, -1);
    }

    public void bfw() {
        if (getView() != 0 && com.baidu.o.d.b.bfz().getPlayerView() != null && com.baidu.o.d.b.bfz().getPlayerView().getParent() == null) {
            ((ViewGroup) getView()).addView(com.baidu.o.d.b.bfz().getPlayerView(), bfv());
        }
    }
}
