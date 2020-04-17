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
    private final j<?> dbV;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.dbV = jVar;
    }

    public k aCQ() {
        return this.dbV.aCS();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.dbV.dbU.dcm;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.dbV.dbU.dcm == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.dbV.dbU.dcm);
        return list;
    }

    public void f(Fragment fragment) {
        this.dbV.dbU.a(this.dbV, this.dbV, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.dbV.dbU.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.dbV.dbU.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.dbV.dbU.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.dbV.dbU.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.dbV.dbU.aCU();
    }

    public void dispatchCreate() {
        this.dbV.dbU.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.dbV.dbU.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.dbV.dbU.dispatchStart();
    }

    public void dispatchResume() {
        this.dbV.dbU.dispatchResume();
    }

    public void dispatchPause() {
        this.dbV.dbU.dispatchPause();
    }

    public void dispatchStop() {
        this.dbV.dbU.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.dbV.dbU.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.dbV.dbU.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.dbV.dbU.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.dbV.dbU.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.dbV.dbU.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.dbV.dbU.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.dbV.dbU.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.dbV.dbU.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.dbV.dbU.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.dbV.dbU.execPendingActions();
    }

    public void doLoaderStart() {
        this.dbV.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.dbV.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.dbV.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.dbV.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> aCR() {
        return this.dbV.aCR();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.dbV.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.dbV.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
