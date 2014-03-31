package com.baidu.adp.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
public class a extends Activity implements DialogInterface.OnClickListener, View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private int mId = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mId = com.baidu.adp.framework.f.a().b();
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

    public void showToast(String str) {
        com.baidu.adp.lib.util.i.a(getApplicationContext(), str);
    }

    public void releaseResouce() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return false;
    }

    public void sendMessage(com.baidu.adp.framework.message.d<?> dVar) {
        if (dVar != null) {
            if (dVar.f() == 0) {
                dVar.b(this.mId);
            }
            com.baidu.adp.framework.c.a().a(dVar);
        }
    }

    public void sendMessage(com.baidu.adp.framework.message.e eVar) {
        if (eVar != null) {
            if (eVar.c() == 0) {
                eVar.a(this.mId);
            }
            com.baidu.adp.framework.c.a().a(eVar);
        }
    }

    public void registerListener(com.baidu.adp.framework.c.d dVar) {
        if (dVar != null && dVar.c() == 0) {
            dVar.a(this.mId);
        }
        com.baidu.adp.framework.c.a().a(dVar);
    }

    public void registerListener(int i, com.baidu.adp.framework.c.d dVar) {
        if (dVar != null && dVar.c() == 0) {
            dVar.a(this.mId);
        }
        com.baidu.adp.framework.c.a().a(i, dVar);
    }

    public void registerListener(com.baidu.adp.framework.c.c<?> cVar) {
        if (cVar != null && cVar.c() == 0) {
            cVar.b(this.mId);
        }
        com.baidu.adp.framework.c.a().a(cVar);
    }

    public void registerListener(int i, com.baidu.adp.framework.c.c<?> cVar) {
        if (cVar != null && cVar.c() == 0) {
            cVar.b(this.mId);
        }
        com.baidu.adp.framework.c.a().a(i, cVar);
    }

    public int getUniqueId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.framework.c.a().f(this.mId);
        com.baidu.adp.framework.c.a().c(this.mId);
    }
}
