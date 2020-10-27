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
    private com.baidu.swan.apps.v.a ejH;

    public a(@Nullable Context context, @NonNull b bVar) {
        super(context, bVar);
        this.ejH = new com.baidu.swan.apps.v.a() { // from class: com.baidu.o.b.a.1
            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                super.onActivityStopped(activity);
                com.baidu.o.d.b.bcZ().stop();
            }

            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                com.baidu.o.d.b.bcZ().resetPreview();
            }
        };
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected View bk(@NonNull Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.addView(com.baidu.o.d.b.bcZ().getRecorderView(), bcV());
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
    public void em(boolean z) {
        super.em(z);
        com.baidu.swan.apps.t.a.aua().registerActivityLifecycleCallbacks(this.ejH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void onRemove() {
        super.onRemove();
        com.baidu.swan.apps.t.a.aua().unregisterActivityLifecycleCallbacks(this.ejH);
    }

    private LinearLayout.LayoutParams bcV() {
        int i;
        if (aiq() == 0 || ((b) aiq()).cxV == null) {
            i = 200;
        } else {
            i = ((b) aiq()).cxV.getWidth() / 2;
        }
        return new LinearLayout.LayoutParams(i, -1);
    }

    public void bcW() {
        if (getView() != 0 && com.baidu.o.d.b.bcZ().getPlayerView() != null && com.baidu.o.d.b.bcZ().getPlayerView().getParent() == null) {
            ((ViewGroup) getView()).addView(com.baidu.o.d.b.bcZ().getPlayerView(), bcV());
        }
    }
}
