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
/* loaded from: classes6.dex */
public class i {
    private final j<?> ejX;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.ejX = jVar;
    }

    public k bcJ() {
        return this.ejX.bcL();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.ejX.ejW.eko;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.ejX.ejW.eko == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.ejX.ejW.eko);
        return list;
    }

    public void h(Fragment fragment) {
        this.ejX.ejW.a(this.ejX, this.ejX, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.ejX.ejW.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.ejX.ejW.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.ejX.ejW.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.ejX.ejW.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.ejX.ejW.bcN();
    }

    public void dispatchCreate() {
        this.ejX.ejW.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.ejX.ejW.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.ejX.ejW.dispatchStart();
    }

    public void dispatchResume() {
        this.ejX.ejW.dispatchResume();
    }

    public void dispatchPause() {
        this.ejX.ejW.dispatchPause();
    }

    public void dispatchStop() {
        this.ejX.ejW.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.ejX.ejW.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.ejX.ejW.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.ejX.ejW.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.ejX.ejW.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.ejX.ejW.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.ejX.ejW.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.ejX.ejW.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.ejX.ejW.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.ejX.ejW.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.ejX.ejW.execPendingActions();
    }

    public void doLoaderStart() {
        this.ejX.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.ejX.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.ejX.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.ejX.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> bcK() {
        return this.ejX.bcK();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.ejX.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.ejX.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
