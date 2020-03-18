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
    private final j<?> cCV;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.cCV = jVar;
    }

    public k auF() {
        return this.cCV.auH();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.cCV.cCU.cDm;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.cCV.cCU.cDm == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.cCV.cCU.cDm);
        return list;
    }

    public void f(Fragment fragment) {
        this.cCV.cCU.a(this.cCV, this.cCV, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.cCV.cCU.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.cCV.cCU.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.cCV.cCU.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.cCV.cCU.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.cCV.cCU.auJ();
    }

    public void dispatchCreate() {
        this.cCV.cCU.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.cCV.cCU.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.cCV.cCU.dispatchStart();
    }

    public void dispatchResume() {
        this.cCV.cCU.dispatchResume();
    }

    public void dispatchPause() {
        this.cCV.cCU.dispatchPause();
    }

    public void dispatchStop() {
        this.cCV.cCU.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.cCV.cCU.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.cCV.cCU.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.cCV.cCU.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.cCV.cCU.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.cCV.cCU.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.cCV.cCU.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.cCV.cCU.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.cCV.cCU.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.cCV.cCU.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.cCV.cCU.execPendingActions();
    }

    public void doLoaderStart() {
        this.cCV.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.cCV.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.cCV.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.cCV.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> auG() {
        return this.cCV.auG();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.cCV.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.cCV.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
