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
    private final j<?> cCI;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.cCI = jVar;
    }

    public k auA() {
        return this.cCI.auC();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.cCI.cCH.cCZ;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.cCI.cCH.cCZ == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.cCI.cCH.cCZ);
        return list;
    }

    public void f(Fragment fragment) {
        this.cCI.cCH.a(this.cCI, this.cCI, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.cCI.cCH.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.cCI.cCH.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.cCI.cCH.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.cCI.cCH.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.cCI.cCH.auE();
    }

    public void dispatchCreate() {
        this.cCI.cCH.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.cCI.cCH.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.cCI.cCH.dispatchStart();
    }

    public void dispatchResume() {
        this.cCI.cCH.dispatchResume();
    }

    public void dispatchPause() {
        this.cCI.cCH.dispatchPause();
    }

    public void dispatchStop() {
        this.cCI.cCH.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.cCI.cCH.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.cCI.cCH.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.cCI.cCH.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.cCI.cCH.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.cCI.cCH.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.cCI.cCH.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.cCI.cCH.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.cCI.cCH.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.cCI.cCH.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.cCI.cCH.execPendingActions();
    }

    public void doLoaderStart() {
        this.cCI.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.cCI.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.cCI.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.cCI.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> auB() {
        return this.cCI.auB();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.cCI.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.cCI.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
