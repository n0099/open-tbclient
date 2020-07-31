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
/* loaded from: classes9.dex */
public class i {
    private final j<?> dyr;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.dyr = jVar;
    }

    public k aMv() {
        return this.dyr.aMx();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.dyr.dyq.dyI;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.dyr.dyq.dyI == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.dyr.dyq.dyI);
        return list;
    }

    public void f(Fragment fragment) {
        this.dyr.dyq.a(this.dyr, this.dyr, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.dyr.dyq.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.dyr.dyq.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.dyr.dyq.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.dyr.dyq.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.dyr.dyq.aMz();
    }

    public void dispatchCreate() {
        this.dyr.dyq.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.dyr.dyq.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.dyr.dyq.dispatchStart();
    }

    public void dispatchResume() {
        this.dyr.dyq.dispatchResume();
    }

    public void dispatchPause() {
        this.dyr.dyq.dispatchPause();
    }

    public void dispatchStop() {
        this.dyr.dyq.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.dyr.dyq.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.dyr.dyq.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.dyr.dyq.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.dyr.dyq.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.dyr.dyq.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.dyr.dyq.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.dyr.dyq.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.dyr.dyq.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.dyr.dyq.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.dyr.dyq.execPendingActions();
    }

    public void doLoaderStart() {
        this.dyr.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.dyr.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.dyr.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.dyr.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> aMw() {
        return this.dyr.aMw();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.dyr.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.dyr.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
