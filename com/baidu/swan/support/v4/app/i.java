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
/* loaded from: classes11.dex */
public class i {
    private final j<?> cCJ;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.cCJ = jVar;
    }

    public k auC() {
        return this.cCJ.auE();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.cCJ.cCI.cDa;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.cCJ.cCI.cDa == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.cCJ.cCI.cDa);
        return list;
    }

    public void f(Fragment fragment) {
        this.cCJ.cCI.a(this.cCJ, this.cCJ, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.cCJ.cCI.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.cCJ.cCI.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.cCJ.cCI.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.cCJ.cCI.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.cCJ.cCI.auG();
    }

    public void dispatchCreate() {
        this.cCJ.cCI.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.cCJ.cCI.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.cCJ.cCI.dispatchStart();
    }

    public void dispatchResume() {
        this.cCJ.cCI.dispatchResume();
    }

    public void dispatchPause() {
        this.cCJ.cCI.dispatchPause();
    }

    public void dispatchStop() {
        this.cCJ.cCI.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.cCJ.cCI.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.cCJ.cCI.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.cCJ.cCI.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.cCJ.cCI.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.cCJ.cCI.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.cCJ.cCI.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.cCJ.cCI.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.cCJ.cCI.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.cCJ.cCI.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.cCJ.cCI.execPendingActions();
    }

    public void doLoaderStart() {
        this.cCJ.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.cCJ.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.cCJ.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.cCJ.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> auD() {
        return this.cCJ.auD();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.cCJ.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.cCJ.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
