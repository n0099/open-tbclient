package com.baidu.adp.a;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
public class c extends FragmentActivity implements DialogInterface.OnClickListener, View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private int a = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = com.baidu.adp.framework.f.a().b();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return true;
    }

    public void a(String str) {
        com.baidu.adp.lib.util.i.a(getApplicationContext(), str);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return false;
    }

    public final void a(com.baidu.adp.framework.message.d<?> dVar) {
        if (dVar != null) {
            if (dVar.f() == 0) {
                dVar.b(this.a);
            }
            com.baidu.adp.framework.c.a().a(dVar);
        }
    }

    public final void a(com.baidu.adp.framework.c.c<?> cVar) {
        if (cVar != null && cVar.c() == 0) {
            cVar.b(this.a);
        }
        com.baidu.adp.framework.c.a().a(cVar);
    }

    public final int a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.a != 0) {
            com.baidu.adp.framework.c.a().f(this.a);
            com.baidu.adp.framework.c.a().c(this.a);
        }
    }
}
