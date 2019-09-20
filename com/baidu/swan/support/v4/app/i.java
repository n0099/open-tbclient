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
    private final j<?> buR;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.buR = jVar;
    }

    public k Xi() {
        return this.buR.Xk();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.buR.buQ.bvg;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.buR.buQ.bvg == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.buR.buQ.bvg);
        return list;
    }

    public void f(Fragment fragment) {
        this.buR.buQ.a(this.buR, this.buR, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.buR.buQ.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.buR.buQ.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.buR.buQ.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.buR.buQ.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.buR.buQ.Xm();
    }

    public void dispatchCreate() {
        this.buR.buQ.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.buR.buQ.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.buR.buQ.dispatchStart();
    }

    public void dispatchResume() {
        this.buR.buQ.dispatchResume();
    }

    public void dispatchPause() {
        this.buR.buQ.dispatchPause();
    }

    public void dispatchStop() {
        this.buR.buQ.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.buR.buQ.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.buR.buQ.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.buR.buQ.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.buR.buQ.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.buR.buQ.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.buR.buQ.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.buR.buQ.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.buR.buQ.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.buR.buQ.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.buR.buQ.execPendingActions();
    }

    public void doLoaderStart() {
        this.buR.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.buR.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.buR.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.buR.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> Xj() {
        return this.buR.Xj();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.buR.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.buR.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
