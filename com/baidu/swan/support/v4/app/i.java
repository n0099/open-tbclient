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
    private final j<?> bnB;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.bnB = jVar;
    }

    public k Sy() {
        return this.bnB.SA();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.bnB.bnA.bnQ;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.bnB.bnA.bnQ == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.bnB.bnA.bnQ);
        return list;
    }

    public void f(Fragment fragment) {
        this.bnB.bnA.a(this.bnB, this.bnB, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.bnB.bnA.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.bnB.bnA.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.bnB.bnA.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.bnB.bnA.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.bnB.bnA.SC();
    }

    public void dispatchCreate() {
        this.bnB.bnA.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.bnB.bnA.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.bnB.bnA.dispatchStart();
    }

    public void dispatchResume() {
        this.bnB.bnA.dispatchResume();
    }

    public void dispatchPause() {
        this.bnB.bnA.dispatchPause();
    }

    public void dispatchStop() {
        this.bnB.bnA.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.bnB.bnA.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.bnB.bnA.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.bnB.bnA.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.bnB.bnA.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.bnB.bnA.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.bnB.bnA.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.bnB.bnA.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.bnB.bnA.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.bnB.bnA.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.bnB.bnA.execPendingActions();
    }

    public void doLoaderStart() {
        this.bnB.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.bnB.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.bnB.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.bnB.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> Sz() {
        return this.bnB.Sz();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.bnB.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.bnB.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
