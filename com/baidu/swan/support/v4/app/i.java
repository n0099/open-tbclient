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
/* loaded from: classes5.dex */
public class i {
    private final j<?> eun;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.eun = jVar;
    }

    public k bdL() {
        return this.eun.bdN();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.eun.eum.euF;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.eun.eum.euF == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.eun.eum.euF);
        return list;
    }

    public void h(Fragment fragment) {
        this.eun.eum.a(this.eun, this.eun, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.eun.eum.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.eun.eum.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.eun.eum.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.eun.eum.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.eun.eum.bdP();
    }

    public void dispatchCreate() {
        this.eun.eum.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.eun.eum.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.eun.eum.dispatchStart();
    }

    public void dispatchResume() {
        this.eun.eum.dispatchResume();
    }

    public void dispatchPause() {
        this.eun.eum.dispatchPause();
    }

    public void dispatchStop() {
        this.eun.eum.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.eun.eum.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.eun.eum.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.eun.eum.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.eun.eum.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.eun.eum.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.eun.eum.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.eun.eum.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.eun.eum.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.eun.eum.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.eun.eum.execPendingActions();
    }

    public void doLoaderStart() {
        this.eun.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.eun.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.eun.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.eun.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> bdM() {
        return this.eun.bdM();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.eun.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.eun.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
