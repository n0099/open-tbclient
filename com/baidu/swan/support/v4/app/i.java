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
    private final j<?> but;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.but = jVar;
    }

    public k Xe() {
        return this.but.Xg();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.but.bus.buI;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.but.bus.buI == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.but.bus.buI);
        return list;
    }

    public void f(Fragment fragment) {
        this.but.bus.a(this.but, this.but, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.but.bus.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.but.bus.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.but.bus.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.but.bus.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.but.bus.Xi();
    }

    public void dispatchCreate() {
        this.but.bus.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.but.bus.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.but.bus.dispatchStart();
    }

    public void dispatchResume() {
        this.but.bus.dispatchResume();
    }

    public void dispatchPause() {
        this.but.bus.dispatchPause();
    }

    public void dispatchStop() {
        this.but.bus.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.but.bus.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.but.bus.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.but.bus.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.but.bus.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.but.bus.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.but.bus.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.but.bus.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.but.bus.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.but.bus.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.but.bus.execPendingActions();
    }

    public void doLoaderStart() {
        this.but.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.but.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.but.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.but.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> Xf() {
        return this.but.Xf();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.but.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.but.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
