package com.baidu.swan.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class i {
    private final j<?> btC;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.btC = jVar;
    }

    public k Wk() {
        return this.btC.Wm();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.btC.btB.btR;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.btC.btB.btR == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.btC.btB.btR);
        return list;
    }

    public void f(Fragment fragment) {
        this.btC.btB.a(this.btC, this.btC, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.btC.btB.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.btC.btB.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.btC.btB.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.btC.btB.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.btC.btB.Wo();
    }

    public void dispatchCreate() {
        this.btC.btB.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.btC.btB.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.btC.btB.dispatchStart();
    }

    public void dispatchResume() {
        this.btC.btB.dispatchResume();
    }

    public void dispatchPause() {
        this.btC.btB.dispatchPause();
    }

    public void dispatchStop() {
        this.btC.btB.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.btC.btB.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.btC.btB.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.btC.btB.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.btC.btB.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.btC.btB.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.btC.btB.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.btC.btB.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.btC.btB.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.btC.btB.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.btC.btB.execPendingActions();
    }

    public void doLoaderStart() {
        this.btC.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.btC.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.btC.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.btC.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> Wl() {
        return this.btC.Wl();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.btC.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.btC.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
