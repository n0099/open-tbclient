package com.baidu.android.pushservice.richmedia;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaListActivity f338a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaListActivity mediaListActivity) {
        this.f338a = mediaListActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        new AlertDialog.Builder(this.f338a).setTitle("提示").setMessage("确定要删除该记录？").setPositiveButton("确定", new g(this, j)).setNegativeButton("取消", new f(this)).show();
        return true;
    }
}
