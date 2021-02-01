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
/* loaded from: classes15.dex */
public class i {
    private final j<?> ewt;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.ewt = jVar;
    }

    public k bdY() {
        return this.ewt.bea();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.ewt.ews.ewL;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.ewt.ews.ewL == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.ewt.ews.ewL);
        return list;
    }

    public void h(Fragment fragment) {
        this.ewt.ews.a(this.ewt, this.ewt, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.ewt.ews.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.ewt.ews.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.ewt.ews.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.ewt.ews.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.ewt.ews.bec();
    }

    public void dispatchCreate() {
        this.ewt.ews.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.ewt.ews.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.ewt.ews.dispatchStart();
    }

    public void dispatchResume() {
        this.ewt.ews.dispatchResume();
    }

    public void dispatchPause() {
        this.ewt.ews.dispatchPause();
    }

    public void dispatchStop() {
        this.ewt.ews.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.ewt.ews.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.ewt.ews.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.ewt.ews.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.ewt.ews.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.ewt.ews.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.ewt.ews.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.ewt.ews.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.ewt.ews.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.ewt.ews.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.ewt.ews.execPendingActions();
    }

    public void doLoaderStart() {
        this.ewt.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.ewt.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.ewt.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.ewt.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> bdZ() {
        return this.ewt.bdZ();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.ewt.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.ewt.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
