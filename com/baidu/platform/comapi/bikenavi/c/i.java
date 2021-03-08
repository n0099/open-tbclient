package com.baidu.platform.comapi.bikenavi.c;

import android.app.Activity;
import android.content.Intent;
import com.baidu.platform.comapi.walknavi.widget.a;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class i implements a.InterfaceC0295a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2881a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar) {
        this.f2881a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0295a
    public void a() {
        Activity activity;
        Activity activity2;
        Activity activity3;
        try {
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            activity3 = this.f2881a.f;
            activity3.startActivity(intent);
        } catch (Exception e) {
            activity = this.f2881a.f;
            activity2 = this.f2881a.f;
            com.baidu.platform.comapi.walknavi.g.c.c.a(activity, com.baidu.platform.comapi.wnplatform.o.a.a.b(activity2, R.drawable.res_0x7f080009_ic_icon_mask_first24__1));
        }
    }
}
