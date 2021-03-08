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
/* loaded from: classes3.dex */
public class i {
    private final j<?> exV;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.exV = jVar;
    }

    public k bea() {
        return this.exV.bec();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.exV.exU.eyp;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.exV.exU.eyp == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.exV.exU.eyp);
        return list;
    }

    public void h(Fragment fragment) {
        this.exV.exU.a(this.exV, this.exV, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.exV.exU.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.exV.exU.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.exV.exU.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.exV.exU.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.exV.exU.bee();
    }

    public void dispatchCreate() {
        this.exV.exU.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.exV.exU.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.exV.exU.dispatchStart();
    }

    public void dispatchResume() {
        this.exV.exU.dispatchResume();
    }

    public void dispatchPause() {
        this.exV.exU.dispatchPause();
    }

    public void dispatchStop() {
        this.exV.exU.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.exV.exU.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.exV.exU.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.exV.exU.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.exV.exU.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.exV.exU.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.exV.exU.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.exV.exU.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.exV.exU.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.exV.exU.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.exV.exU.execPendingActions();
    }

    public void doLoaderStart() {
        this.exV.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.exV.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.exV.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.exV.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> beb() {
        return this.exV.beb();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.exV.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.exV.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
