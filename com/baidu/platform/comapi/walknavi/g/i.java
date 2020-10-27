package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
import android.content.Intent;
import com.baidu.platform.comapi.walknavi.widget.a;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class i implements a.InterfaceC0281a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3062a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.f3062a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0281a
    public void a() {
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        try {
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            activity4 = this.f3062a.g;
            activity4.startActivity(intent);
        } catch (Exception e) {
            activity = this.f3062a.g;
            if (activity != null) {
                activity2 = this.f3062a.g;
                activity3 = this.f3062a.g;
                com.baidu.platform.comapi.walknavi.g.d.c.a(activity2, com.baidu.platform.comapi.wnplatform.p.a.a.b(activity3, R.raw.card_live_bg_night));
            }
        }
    }
}
