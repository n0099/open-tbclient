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
/* loaded from: classes16.dex */
public class i {
    private final j<?> eps;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.eps = jVar;
    }

    public k bfh() {
        return this.eps.bfj();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.eps.epr.epJ;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.eps.epr.epJ == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.eps.epr.epJ);
        return list;
    }

    public void h(Fragment fragment) {
        this.eps.epr.a(this.eps, this.eps, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.eps.epr.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.eps.epr.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.eps.epr.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.eps.epr.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.eps.epr.bfl();
    }

    public void dispatchCreate() {
        this.eps.epr.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.eps.epr.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.eps.epr.dispatchStart();
    }

    public void dispatchResume() {
        this.eps.epr.dispatchResume();
    }

    public void dispatchPause() {
        this.eps.epr.dispatchPause();
    }

    public void dispatchStop() {
        this.eps.epr.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.eps.epr.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.eps.epr.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.eps.epr.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.eps.epr.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.eps.epr.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.eps.epr.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.eps.epr.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.eps.epr.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.eps.epr.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.eps.epr.execPendingActions();
    }

    public void doLoaderStart() {
        this.eps.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.eps.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.eps.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.eps.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> bfi() {
        return this.eps.bfi();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.eps.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.eps.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
