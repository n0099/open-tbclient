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
    private n customToast;
    private boolean isPrimary;
    private int mId = 0;
    protected int mSkinType = -1;

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
        this.mId = com.baidu.adp.framework.f.a().b();
        this.customToast = n.a();
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void showToast(String str) {
        if (getActivity() != null) {
            String name = getClass().getName();
            String str2 = String.valueOf(getActivity().getApplicationContext().getPackageName()) + ".chat";
            if (name.startsWith(String.valueOf(getActivity().getApplicationContext().getPackageName()) + ".im") || name.startsWith(str2)) {
                this.customToast.a(str, 2000);
            } else {
                i.a((Context) getActivity(), str);
            }
        }
    }

    public void showToast(int i) {
        if (getActivity() != null) {
            String name = getClass().getName();
            String str = String.valueOf(getActivity().getApplicationContext().getPackageName()) + ".chat";
            if (name.startsWith(String.valueOf(getActivity().getApplicationContext().getPackageName()) + ".im") || name.startsWith(str)) {
                this.customToast.a(i, 2000);
            } else {
                i.a((Context) getActivity(), i);
            }
        }
    }

    public void showToast(String str, boolean z) {
        if (z) {
            this.customToast.a(str, 2000);
        } else {
            i.a((Context) TbadkApplication.j().b(), str);
        }
    }

    public void showToast(int i, boolean z) {
        if (z) {
            this.customToast.a(i, 2000);
        } else {
            i.a((Context) TbadkApplication.j().b(), i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        if (this.customToast != null) {
            this.customToast.c();
        }
        super.onResume();
        if (isShow()) {
            changeSkinType(TbadkApplication.j().l());
            be.a(getClass().getName());
            if (this.isPrimary) {
                onPrimary();
            }
        }
    }

    public void changeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            onChangeSkinType(this.mSkinType);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        this.customToast.b();
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
        com.baidu.adp.framework.c.a().f(this.mId);
        com.baidu.adp.framework.c.a().c(this.mId);
    }

    public void onChangeSkinType(int i) {
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

    public void onResourceRecycle() {
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
    public boolean isShow() {
        return !isHidden();
    }

    public void sendMessage(com.baidu.adp.framework.message.d<?> dVar) {
        if (dVar != null) {
            if (dVar.f() == 0) {
                dVar.b(this.mId);
            }
            com.baidu.adp.framework.c.a().a(dVar);
        }
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

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (isResumed()) {
            onPrimary();
        }
    }

    public boolean isPrimary() {
        return this.isPrimary;
    }

    public void onPrimary() {
    }
}
