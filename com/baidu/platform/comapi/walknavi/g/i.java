package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
import android.content.Intent;
import com.baidu.platform.comapi.walknavi.widget.a;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class i implements a.InterfaceC0302a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3066a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.f3066a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0302a
    public void a() {
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        try {
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            activity4 = this.f3066a.g;
            activity4.startActivity(intent);
        } catch (Exception e) {
            activity = this.f3066a.g;
            if (activity != null) {
                activity2 = this.f3066a.g;
                activity3 = this.f3066a.g;
                com.baidu.platform.comapi.walknavi.g.d.c.a(activity2, com.baidu.platform.comapi.wnplatform.p.a.a.b(activity3, R.raw.card_live_bg_night));
            }
        }
    }
}
