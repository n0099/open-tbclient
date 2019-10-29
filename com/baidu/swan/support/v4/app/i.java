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
/* loaded from: classes2.dex */
public class i {
    private final j<?> bNA;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.bNA = jVar;
    }

    public k abX() {
        return this.bNA.abZ();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.bNA.bNz.bNP;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.bNA.bNz.bNP == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.bNA.bNz.bNP);
        return list;
    }

    public void f(Fragment fragment) {
        this.bNA.bNz.a(this.bNA, this.bNA, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.bNA.bNz.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.bNA.bNz.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.bNA.bNz.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.bNA.bNz.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.bNA.bNz.acb();
    }

    public void dispatchCreate() {
        this.bNA.bNz.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.bNA.bNz.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.bNA.bNz.dispatchStart();
    }

    public void dispatchResume() {
        this.bNA.bNz.dispatchResume();
    }

    public void dispatchPause() {
        this.bNA.bNz.dispatchPause();
    }

    public void dispatchStop() {
        this.bNA.bNz.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.bNA.bNz.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.bNA.bNz.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.bNA.bNz.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.bNA.bNz.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.bNA.bNz.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.bNA.bNz.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.bNA.bNz.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.bNA.bNz.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.bNA.bNz.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.bNA.bNz.execPendingActions();
    }

    public void doLoaderStart() {
        this.bNA.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.bNA.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.bNA.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.bNA.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> abY() {
        return this.bNA.abY();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.bNA.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.bNA.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
