package com.baidu.adp.lib.debug.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f465a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f465a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        try {
            com.baidu.adp.lib.debug.b.c = false;
            context = this.f465a.k;
            ((Activity) context).finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
