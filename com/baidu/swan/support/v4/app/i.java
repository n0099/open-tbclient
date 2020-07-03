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
/* loaded from: classes11.dex */
public class i {
    private final j<?> dsB;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.dsB = jVar;
    }

    public k aID() {
        return this.dsB.aIF();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.dsB.dsA.dsS;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.dsB.dsA.dsS == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.dsB.dsA.dsS);
        return list;
    }

    public void f(Fragment fragment) {
        this.dsB.dsA.a(this.dsB, this.dsB, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.dsB.dsA.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.dsB.dsA.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.dsB.dsA.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.dsB.dsA.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.dsB.dsA.aIH();
    }

    public void dispatchCreate() {
        this.dsB.dsA.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.dsB.dsA.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.dsB.dsA.dispatchStart();
    }

    public void dispatchResume() {
        this.dsB.dsA.dispatchResume();
    }

    public void dispatchPause() {
        this.dsB.dsA.dispatchPause();
    }

    public void dispatchStop() {
        this.dsB.dsA.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.dsB.dsA.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.dsB.dsA.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.dsB.dsA.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.dsB.dsA.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.dsB.dsA.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.dsB.dsA.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.dsB.dsA.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.dsB.dsA.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.dsB.dsA.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.dsB.dsA.execPendingActions();
    }

    public void doLoaderStart() {
        this.dsB.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.dsB.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.dsB.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.dsB.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> aIE() {
        return this.dsB.aIE();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.dsB.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.dsB.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
