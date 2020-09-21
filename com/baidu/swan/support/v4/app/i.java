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
/* loaded from: classes24.dex */
public class i {
    private final j<?> dJI;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.dJI = jVar;
    }

    public k aVH() {
        return this.dJI.aVJ();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.dJI.dJH.dJZ;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.dJI.dJH.dJZ == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.dJI.dJH.dJZ);
        return list;
    }

    public void h(Fragment fragment) {
        this.dJI.dJH.a(this.dJI, this.dJI, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.dJI.dJH.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.dJI.dJH.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.dJI.dJH.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.dJI.dJH.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.dJI.dJH.aVL();
    }

    public void dispatchCreate() {
        this.dJI.dJH.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.dJI.dJH.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.dJI.dJH.dispatchStart();
    }

    public void dispatchResume() {
        this.dJI.dJH.dispatchResume();
    }

    public void dispatchPause() {
        this.dJI.dJH.dispatchPause();
    }

    public void dispatchStop() {
        this.dJI.dJH.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.dJI.dJH.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.dJI.dJH.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.dJI.dJH.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.dJI.dJH.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.dJI.dJH.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.dJI.dJH.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.dJI.dJH.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.dJI.dJH.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.dJI.dJH.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.dJI.dJH.execPendingActions();
    }

    public void doLoaderStart() {
        this.dJI.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.dJI.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.dJI.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.dJI.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> aVI() {
        return this.dJI.aVI();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.dJI.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.dJI.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
