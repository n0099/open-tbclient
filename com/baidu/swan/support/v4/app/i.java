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
    private final j<?> dHA;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.dHA = jVar;
    }

    public k aUV() {
        return this.dHA.aUX();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.dHA.dHz.dHR;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.dHA.dHz.dHR == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.dHA.dHz.dHR);
        return list;
    }

    public void h(Fragment fragment) {
        this.dHA.dHz.a(this.dHA, this.dHA, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.dHA.dHz.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.dHA.dHz.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.dHA.dHz.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.dHA.dHz.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.dHA.dHz.aUZ();
    }

    public void dispatchCreate() {
        this.dHA.dHz.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.dHA.dHz.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.dHA.dHz.dispatchStart();
    }

    public void dispatchResume() {
        this.dHA.dHz.dispatchResume();
    }

    public void dispatchPause() {
        this.dHA.dHz.dispatchPause();
    }

    public void dispatchStop() {
        this.dHA.dHz.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.dHA.dHz.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.dHA.dHz.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.dHA.dHz.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.dHA.dHz.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.dHA.dHz.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.dHA.dHz.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.dHA.dHz.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.dHA.dHz.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.dHA.dHz.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.dHA.dHz.execPendingActions();
    }

    public void doLoaderStart() {
        this.dHA.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.dHA.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.dHA.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.dHA.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> aUW() {
        return this.dHA.aUW();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.dHA.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.dHA.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
