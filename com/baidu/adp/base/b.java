package com.baidu.adp.base;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
public class b extends FragmentActivity implements DialogInterface.OnClickListener, View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, i {
    private int a = 0;
    private boolean b = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = com.baidu.adp.framework.d.a().b();
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
        com.baidu.adp.lib.util.h.a(getApplicationContext(), str);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return false;
    }

    public void a(Message<?> message) {
        if (message != null) {
            if (message.getTag() == 0) {
                message.setTag(this.a);
            }
            MessageManager.getInstance().sendMessage(message);
        }
    }

    public void a(NetMessage netMessage) {
        if (netMessage != null) {
            if (netMessage.getTag() == 0) {
                netMessage.setTag(this.a);
            }
            MessageManager.getInstance().sendMessage(netMessage);
        }
    }

    public void a(MessageListener<?> messageListener) {
        if (messageListener != null && messageListener.getTag() == 0) {
            messageListener.setTag(this.a);
        }
        MessageManager.getInstance().registerListener(messageListener);
    }

    @Override // com.baidu.adp.base.i
    public int getUniqueId() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.a != 0) {
            MessageManager.getInstance().unRegisterListener(this.a);
            MessageManager.getInstance().removeMessage(this.a);
            com.baidu.adp.lib.resourceLoader.d.a().a(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.baidu.adp.lib.resourceLoader.d.a().b(this.a);
    }

    @Override // com.baidu.adp.base.i
    public boolean isScroll() {
        return this.b;
    }

    @Override // com.baidu.adp.base.i
    public void setIsScroll(boolean z) {
        this.b = z;
    }

    @Override // com.baidu.adp.base.i
    public void onPreLoad(BdListView bdListView) {
    }
}
