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
    private final j<?> dVJ;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.dVJ = jVar;
    }

    public k aYq() {
        return this.dVJ.aYs();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.dVJ.dVI.dWa;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.dVJ.dVI.dWa == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.dVJ.dVI.dWa);
        return list;
    }

    public void h(Fragment fragment) {
        this.dVJ.dVI.a(this.dVJ, this.dVJ, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.dVJ.dVI.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.dVJ.dVI.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.dVJ.dVI.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.dVJ.dVI.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.dVJ.dVI.aYu();
    }

    public void dispatchCreate() {
        this.dVJ.dVI.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.dVJ.dVI.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.dVJ.dVI.dispatchStart();
    }

    public void dispatchResume() {
        this.dVJ.dVI.dispatchResume();
    }

    public void dispatchPause() {
        this.dVJ.dVI.dispatchPause();
    }

    public void dispatchStop() {
        this.dVJ.dVI.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.dVJ.dVI.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.dVJ.dVI.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.dVJ.dVI.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.dVJ.dVI.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.dVJ.dVI.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.dVJ.dVI.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.dVJ.dVI.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.dVJ.dVI.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.dVJ.dVI.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.dVJ.dVI.execPendingActions();
    }

    public void doLoaderStart() {
        this.dVJ.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.dVJ.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.dVJ.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.dVJ.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> aYr() {
        return this.dVJ.aYr();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.dVJ.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.dVJ.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
