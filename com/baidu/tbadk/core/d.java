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
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.n;
/* loaded from: classes.dex */
public abstract class d extends Fragment implements DialogInterface.OnClickListener, View.OnClickListener, View.OnLongClickListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private n c;
    private boolean d;
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
        this.b = com.baidu.adp.framework.f.a().b();
        this.c = n.a();
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public final void a(String str) {
        if (getActivity() != null) {
            String name = getClass().getName();
            String str2 = String.valueOf(getActivity().getApplicationContext().getPackageName()) + ".chat";
            if (name.startsWith(String.valueOf(getActivity().getApplicationContext().getPackageName()) + ".im") || name.startsWith(str2)) {
                this.c.a(str, 2000);
            } else {
                i.a((Context) getActivity(), str);
            }
        }
    }

    public final void a(int i) {
        if (getActivity() != null) {
            String name = getClass().getName();
            String str = String.valueOf(getActivity().getApplicationContext().getPackageName()) + ".chat";
            if (name.startsWith(String.valueOf(getActivity().getApplicationContext().getPackageName()) + ".im") || name.startsWith(str)) {
                this.c.a(i, 2000);
            } else {
                i.a((Context) getActivity(), i);
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
        if (c_()) {
            b(TbadkApplication.j().l());
            be.a(getClass().getName());
            if (this.d) {
                d();
            }
        }
    }

    public final void b(int i) {
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
        com.baidu.adp.framework.c.a().f(this.b);
        com.baidu.adp.framework.c.a().c(this.b);
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
    public final boolean c_() {
        return !isHidden();
    }

    public final void a(com.baidu.adp.framework.message.d<?> dVar) {
        if (dVar != null) {
            if (dVar.f() == 0) {
                dVar.b(this.b);
            }
            com.baidu.adp.framework.c.a().a(dVar);
        }
    }

    public final void b(boolean z) {
        this.d = z;
        if (isResumed()) {
            d();
        }
    }

    public void d() {
    }
}
