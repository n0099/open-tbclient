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
    private final j<?> bnC;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.bnC = jVar;
    }

    public k Sy() {
        return this.bnC.SA();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.bnC.bnB.bnR;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.bnC.bnB.bnR == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.bnC.bnB.bnR);
        return list;
    }

    public void f(Fragment fragment) {
        this.bnC.bnB.a(this.bnC, this.bnC, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.bnC.bnB.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.bnC.bnB.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.bnC.bnB.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.bnC.bnB.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.bnC.bnB.SC();
    }

    public void dispatchCreate() {
        this.bnC.bnB.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.bnC.bnB.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.bnC.bnB.dispatchStart();
    }

    public void dispatchResume() {
        this.bnC.bnB.dispatchResume();
    }

    public void dispatchPause() {
        this.bnC.bnB.dispatchPause();
    }

    public void dispatchStop() {
        this.bnC.bnB.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.bnC.bnB.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.bnC.bnB.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.bnC.bnB.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.bnC.bnB.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.bnC.bnB.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.bnC.bnB.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.bnC.bnB.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.bnC.bnB.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.bnC.bnB.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.bnC.bnB.execPendingActions();
    }

    public void doLoaderStart() {
        this.bnC.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.bnC.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.bnC.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.bnC.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> Sz() {
        return this.bnC.Sz();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.bnC.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.bnC.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
