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
    private final j<?> eef;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.eef = jVar;
    }

    public k baj() {
        return this.eef.bal();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.eef.eee.eew;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.eef.eee.eew == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.eef.eee.eew);
        return list;
    }

    public void h(Fragment fragment) {
        this.eef.eee.a(this.eef, this.eef, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.eef.eee.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.eef.eee.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.eef.eee.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.eef.eee.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.eef.eee.ban();
    }

    public void dispatchCreate() {
        this.eef.eee.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.eef.eee.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.eef.eee.dispatchStart();
    }

    public void dispatchResume() {
        this.eef.eee.dispatchResume();
    }

    public void dispatchPause() {
        this.eef.eee.dispatchPause();
    }

    public void dispatchStop() {
        this.eef.eee.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.eef.eee.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.eef.eee.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.eef.eee.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.eef.eee.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.eef.eee.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.eef.eee.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.eef.eee.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.eef.eee.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.eef.eee.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.eef.eee.execPendingActions();
    }

    public void doLoaderStart() {
        this.eef.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.eef.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.eef.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.eef.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> bak() {
        return this.eef.bak();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.eef.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.eef.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
