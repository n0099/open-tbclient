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
    private final j<?> cCK;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.cCK = jVar;
    }

    public k auC() {
        return this.cCK.auE();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.cCK.cCJ.cDb;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.cCK.cCJ.cDb == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.cCK.cCJ.cDb);
        return list;
    }

    public void f(Fragment fragment) {
        this.cCK.cCJ.a(this.cCK, this.cCK, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.cCK.cCJ.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.cCK.cCJ.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.cCK.cCJ.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.cCK.cCJ.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.cCK.cCJ.auG();
    }

    public void dispatchCreate() {
        this.cCK.cCJ.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.cCK.cCJ.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.cCK.cCJ.dispatchStart();
    }

    public void dispatchResume() {
        this.cCK.cCJ.dispatchResume();
    }

    public void dispatchPause() {
        this.cCK.cCJ.dispatchPause();
    }

    public void dispatchStop() {
        this.cCK.cCJ.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.cCK.cCJ.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.cCK.cCJ.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.cCK.cCJ.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.cCK.cCJ.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.cCK.cCJ.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.cCK.cCJ.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.cCK.cCJ.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.cCK.cCJ.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.cCK.cCJ.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.cCK.cCJ.execPendingActions();
    }

    public void doLoaderStart() {
        this.cCK.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.cCK.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.cCK.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.cCK.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> auD() {
        return this.cCK.auD();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.cCK.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.cCK.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
