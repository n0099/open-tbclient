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
    private final j<?> dca;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.dca = jVar;
    }

    public k aCQ() {
        return this.dca.aCS();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.dca.dbZ.dcr;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.dca.dbZ.dcr == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.dca.dbZ.dcr);
        return list;
    }

    public void f(Fragment fragment) {
        this.dca.dbZ.a(this.dca, this.dca, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.dca.dbZ.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.dca.dbZ.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.dca.dbZ.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.dca.dbZ.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.dca.dbZ.aCU();
    }

    public void dispatchCreate() {
        this.dca.dbZ.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.dca.dbZ.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.dca.dbZ.dispatchStart();
    }

    public void dispatchResume() {
        this.dca.dbZ.dispatchResume();
    }

    public void dispatchPause() {
        this.dca.dbZ.dispatchPause();
    }

    public void dispatchStop() {
        this.dca.dbZ.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.dca.dbZ.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.dca.dbZ.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.dca.dbZ.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.dca.dbZ.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.dca.dbZ.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.dca.dbZ.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.dca.dbZ.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.dca.dbZ.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.dca.dbZ.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.dca.dbZ.execPendingActions();
    }

    public void doLoaderStart() {
        this.dca.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.dca.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.dca.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.dca.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> aCR() {
        return this.dca.aCR();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.dca.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.dca.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
