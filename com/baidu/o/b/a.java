package com.baidu.o.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes5.dex */
public class a extends com.baidu.swan.apps.component.a.d.a<View, b> {
    private com.baidu.swan.apps.v.a enT;

    public a(@Nullable Context context, @NonNull b bVar) {
        super(context, bVar);
        this.enT = new com.baidu.swan.apps.v.a() { // from class: com.baidu.o.b.a.1
            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                super.onActivityStopped(activity);
                com.baidu.o.d.b.beS().stop();
            }

            @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                com.baidu.o.d.b.beS().resetPreview();
            }
        };
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected View bk(@NonNull Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.addView(com.baidu.o.d.b.beS().getRecorderView(), beO());
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
    public void ey(boolean z) {
        super.ey(z);
        com.baidu.swan.apps.t.a.avS().registerActivityLifecycleCallbacks(this.enT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void onRemove() {
        super.onRemove();
        com.baidu.swan.apps.t.a.avS().unregisterActivityLifecycleCallbacks(this.enT);
    }

    private LinearLayout.LayoutParams beO() {
        int i;
        if (aki() == 0 || ((b) aki()).cCe == null) {
            i = 200;
        } else {
            i = ((b) aki()).cCe.getWidth() / 2;
        }
        return new LinearLayout.LayoutParams(i, -1);
    }

    public void beP() {
        if (getView() != 0 && com.baidu.o.d.b.beS().getPlayerView() != null && com.baidu.o.d.b.beS().getPlayerView().getParent() == null) {
            ((ViewGroup) getView()).addView(com.baidu.o.d.b.beS().getPlayerView(), beO());
        }
    }
}
