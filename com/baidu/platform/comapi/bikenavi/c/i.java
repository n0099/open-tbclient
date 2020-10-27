package com.baidu.platform.comapi.bikenavi.c;

import android.app.Activity;
import android.content.Intent;
import com.baidu.platform.comapi.walknavi.widget.a;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class i implements a.InterfaceC0281a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2836a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar) {
        this.f2836a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0281a
    public void a() {
        Activity activity;
        Activity activity2;
        Activity activity3;
        try {
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            activity3 = this.f2836a.f;
            activity3.startActivity(intent);
        } catch (Exception e) {
            activity = this.f2836a.f;
            activity2 = this.f2836a.f;
            com.baidu.platform.comapi.walknavi.g.d.c.a(activity, com.baidu.platform.comapi.wnplatform.p.a.a.b(activity2, R.raw.card_live_bg_night));
        }
    }
}
