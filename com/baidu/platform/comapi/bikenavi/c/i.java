package com.baidu.platform.comapi.bikenavi.c;

import android.app.Activity;
import android.content.Intent;
import com.baidu.platform.comapi.walknavi.widget.a;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class i implements a.InterfaceC0302a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f4209a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar) {
        this.f4209a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0302a
    public void a() {
        Activity activity;
        Activity activity2;
        Activity activity3;
        try {
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            activity3 = this.f4209a.f;
            activity3.startActivity(intent);
        } catch (Exception e) {
            activity = this.f4209a.f;
            activity2 = this.f4209a.f;
            com.baidu.platform.comapi.walknavi.g.d.c.a(activity, com.baidu.platform.comapi.wnplatform.p.a.a.b(activity2, R.drawable.res_0x7f080009_ic_icon_mask_first24__1));
        }
    }
}
