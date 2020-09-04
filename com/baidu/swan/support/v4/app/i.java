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
/* loaded from: classes9.dex */
public class i {
    private final j<?> dHE;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.dHE = jVar;
    }

    public k aUV() {
        return this.dHE.aUX();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.dHE.dHD.dHV;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.dHE.dHD.dHV == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.dHE.dHD.dHV);
        return list;
    }

    public void h(Fragment fragment) {
        this.dHE.dHD.a(this.dHE, this.dHE, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.dHE.dHD.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.dHE.dHD.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.dHE.dHD.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.dHE.dHD.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.dHE.dHD.aUZ();
    }

    public void dispatchCreate() {
        this.dHE.dHD.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.dHE.dHD.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.dHE.dHD.dispatchStart();
    }

    public void dispatchResume() {
        this.dHE.dHD.dispatchResume();
    }

    public void dispatchPause() {
        this.dHE.dHD.dispatchPause();
    }

    public void dispatchStop() {
        this.dHE.dHD.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.dHE.dHD.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.dHE.dHD.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.dHE.dHD.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.dHE.dHD.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.dHE.dHD.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.dHE.dHD.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.dHE.dHD.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.dHE.dHD.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.dHE.dHD.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.dHE.dHD.execPendingActions();
    }

    public void doLoaderStart() {
        this.dHE.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.dHE.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.dHE.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.dHE.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> aUW() {
        return this.dHE.aUW();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.dHE.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.dHE.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
