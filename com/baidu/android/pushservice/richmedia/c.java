package com.baidu.android.pushservice.richmedia;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaListActivity f733a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MediaListActivity mediaListActivity) {
        this.f733a = mediaListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f733a.finish();
    }
}
