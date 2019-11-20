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
    private final j<?> bMJ;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.bMJ = jVar;
    }

    public k abV() {
        return this.bMJ.abX();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.bMJ.bMI.bMY;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.bMJ.bMI.bMY == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.bMJ.bMI.bMY);
        return list;
    }

    public void f(Fragment fragment) {
        this.bMJ.bMI.a(this.bMJ, this.bMJ, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.bMJ.bMI.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.bMJ.bMI.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.bMJ.bMI.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.bMJ.bMI.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.bMJ.bMI.abZ();
    }

    public void dispatchCreate() {
        this.bMJ.bMI.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.bMJ.bMI.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.bMJ.bMI.dispatchStart();
    }

    public void dispatchResume() {
        this.bMJ.bMI.dispatchResume();
    }

    public void dispatchPause() {
        this.bMJ.bMI.dispatchPause();
    }

    public void dispatchStop() {
        this.bMJ.bMI.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.bMJ.bMI.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.bMJ.bMI.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.bMJ.bMI.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.bMJ.bMI.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.bMJ.bMI.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.bMJ.bMI.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.bMJ.bMI.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.bMJ.bMI.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.bMJ.bMI.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.bMJ.bMI.execPendingActions();
    }

    public void doLoaderStart() {
        this.bMJ.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.bMJ.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.bMJ.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.bMJ.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> abW() {
        return this.bMJ.abW();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.bMJ.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.bMJ.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
