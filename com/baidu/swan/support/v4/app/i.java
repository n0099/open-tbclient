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
    private final j<?> ezc;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.ezc = jVar;
    }

    public k bhF() {
        return this.ezc.bhH();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.ezc.ezb.ezu;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.ezc.ezb.ezu == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.ezc.ezb.ezu);
        return list;
    }

    public void h(Fragment fragment) {
        this.ezc.ezb.a(this.ezc, this.ezc, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.ezc.ezb.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.ezc.ezb.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.ezc.ezb.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.ezc.ezb.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.ezc.ezb.bhJ();
    }

    public void dispatchCreate() {
        this.ezc.ezb.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.ezc.ezb.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.ezc.ezb.dispatchStart();
    }

    public void dispatchResume() {
        this.ezc.ezb.dispatchResume();
    }

    public void dispatchPause() {
        this.ezc.ezb.dispatchPause();
    }

    public void dispatchStop() {
        this.ezc.ezb.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.ezc.ezb.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.ezc.ezb.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.ezc.ezb.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.ezc.ezb.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.ezc.ezb.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.ezc.ezb.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.ezc.ezb.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.ezc.ezb.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.ezc.ezb.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.ezc.ezb.execPendingActions();
    }

    public void doLoaderStart() {
        this.ezc.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.ezc.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.ezc.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.ezc.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> bhG() {
        return this.ezc.bhG();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.ezc.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.ezc.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
