package com.baidu.platform.comapi.bikenavi.c;

import android.app.Activity;
import android.content.Intent;
import com.baidu.platform.comapi.walknavi.widget.a;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class i implements a.InterfaceC0254a {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0254a
    public void a() {
        Activity activity;
        Activity activity2;
        Activity activity3;
        try {
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            activity3 = this.a.f;
            activity3.startActivity(intent);
        } catch (Exception e) {
            activity = this.a.f;
            activity2 = this.a.f;
            com.baidu.platform.comapi.walknavi.g.d.c.a(activity, com.baidu.platform.comapi.wnplatform.p.a.a.b(activity2, R.string.abc_searchview_description_clear));
        }
    }
}
