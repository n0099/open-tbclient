package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
import android.content.Intent;
import com.baidu.platform.comapi.walknavi.widget.a;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class i implements a.InterfaceC0254a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0254a
    public void a() {
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        try {
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            activity4 = this.a.g;
            activity4.startActivity(intent);
        } catch (Exception e) {
            activity = this.a.g;
            if (activity != null) {
                activity2 = this.a.g;
                activity3 = this.a.g;
                com.baidu.platform.comapi.walknavi.g.d.c.a(activity2, com.baidu.platform.comapi.wnplatform.p.a.a.b(activity3, R.string.abc_searchview_description_clear));
            }
        }
    }
}
