package com.baidu.adp.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.lib.util.BdUtilHelper;
/* loaded from: classes.dex */
public class a extends Activity implements DialogInterface.OnClickListener, View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private int mId = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mId = com.baidu.adp.framework.e.a().b();
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
        BdUtilHelper.a(getApplicationContext(), str);
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

    public void sendMessage(com.baidu.adp.framework.message.e<?> eVar) {
        if (eVar != null) {
            if (eVar.e() == 0) {
                eVar.b(this.mId);
            }
            com.baidu.adp.framework.c.a().a(eVar);
        }
    }

    public void registerListener(com.baidu.adp.framework.c.c<?> cVar) {
        if (cVar != null && cVar.c() == 0) {
            cVar.a(this.mId);
        }
        com.baidu.adp.framework.c.a().a(cVar);
    }

    public int getUniqueId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.framework.c.a().f(this.mId);
        com.baidu.adp.framework.c.a().d(this.mId);
    }
}
