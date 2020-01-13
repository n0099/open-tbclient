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
/* loaded from: classes10.dex */
public class i {
    private final j<?> cyK;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.cyK = jVar;
    }

    public k asm() {
        return this.cyK.aso();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.cyK.cyJ.czb;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.cyK.cyJ.czb == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.cyK.cyJ.czb);
        return list;
    }

    public void f(Fragment fragment) {
        this.cyK.cyJ.a(this.cyK, this.cyK, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.cyK.cyJ.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.cyK.cyJ.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.cyK.cyJ.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.cyK.cyJ.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.cyK.cyJ.asq();
    }

    public void dispatchCreate() {
        this.cyK.cyJ.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.cyK.cyJ.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.cyK.cyJ.dispatchStart();
    }

    public void dispatchResume() {
        this.cyK.cyJ.dispatchResume();
    }

    public void dispatchPause() {
        this.cyK.cyJ.dispatchPause();
    }

    public void dispatchStop() {
        this.cyK.cyJ.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.cyK.cyJ.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.cyK.cyJ.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.cyK.cyJ.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.cyK.cyJ.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.cyK.cyJ.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.cyK.cyJ.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.cyK.cyJ.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.cyK.cyJ.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.cyK.cyJ.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.cyK.cyJ.execPendingActions();
    }

    public void doLoaderStart() {
        this.cyK.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.cyK.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.cyK.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.cyK.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> asn() {
        return this.cyK.asn();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.cyK.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.cyK.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
