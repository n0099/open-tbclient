package com.baidu.tbadk.core;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bo;
import com.baidu.tbadk.core.util.o;
/* loaded from: classes.dex */
public abstract class d extends Fragment implements DialogInterface.OnClickListener, View.OnClickListener, View.OnLongClickListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private o c;
    private boolean d;
    private String e;
    private int b = 0;
    protected int a = -1;

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.b = com.baidu.adp.framework.d.a().b();
        this.c = o.a();
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public String b() {
        return this.e;
    }

    public void a(String str) {
        this.e = str;
    }

    public void b(String str) {
        if (getActivity() != null) {
            String name = getClass().getName();
            String str2 = String.valueOf(getActivity().getApplicationContext().getPackageName()) + ".chat";
            if (name.startsWith(String.valueOf(getActivity().getApplicationContext().getPackageName()) + ".im") || name.startsWith(str2)) {
                this.c.a(str, TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI);
            } else {
                j.a((Context) getActivity(), str);
            }
        }
    }

    public void a(int i) {
        if (getActivity() != null) {
            String name = getClass().getName();
            String str = String.valueOf(getActivity().getApplicationContext().getPackageName()) + ".chat";
            if (name.startsWith(String.valueOf(getActivity().getApplicationContext().getPackageName()) + ".im") || name.startsWith(str)) {
                this.c.a(i, TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI);
            } else {
                j.a((Context) getActivity(), i);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        if (this.c != null) {
            this.c.c();
        }
        super.onResume();
        if (d_()) {
            b(TbadkApplication.m252getInst().getSkinType());
            bo.a(getClass().getName());
            if (this.d) {
                e();
            }
        }
    }

    public void b(int i) {
        if (i != this.a) {
            this.a = i;
            c(this.a);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        this.c.b();
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        MessageManager.getInstance().unRegisterListener(this.b);
        MessageManager.getInstance().removeMessage(this.b);
    }

    public void c(int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            onResume();
        } else {
            onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d_() {
        return !isHidden();
    }

    public void a(Message<?> message) {
        if (message != null) {
            if (message.getTag() == 0) {
                message.setTag(this.b);
            }
            MessageManager.getInstance().sendMessage(message);
        }
    }

    public void a(MessageListener<?> messageListener) {
        if (messageListener != null && messageListener.getTag() == 0) {
            messageListener.setTag(this.b);
        }
        MessageManager.getInstance().registerListener(messageListener);
    }

    public void a(int i, MessageListener<?> messageListener) {
        if (messageListener != null && messageListener.getTag() == 0) {
            messageListener.setTag(this.b);
        }
        MessageManager.getInstance().registerListener(i, messageListener);
    }

    public int d() {
        return this.b;
    }

    public void b(boolean z) {
        this.d = z;
        if (isResumed()) {
            e();
        }
    }

    public void e() {
    }
}
