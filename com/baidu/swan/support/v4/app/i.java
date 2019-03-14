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
    private final j<?> bny;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.bny = jVar;
    }

    public k SA() {
        return this.bny.SC();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.bny.bnx.bnN;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.bny.bnx.bnN == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.bny.bnx.bnN);
        return list;
    }

    public void f(Fragment fragment) {
        this.bny.bnx.a(this.bny, this.bny, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.bny.bnx.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.bny.bnx.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.bny.bnx.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.bny.bnx.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.bny.bnx.SE();
    }

    public void dispatchCreate() {
        this.bny.bnx.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.bny.bnx.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.bny.bnx.dispatchStart();
    }

    public void dispatchResume() {
        this.bny.bnx.dispatchResume();
    }

    public void dispatchPause() {
        this.bny.bnx.dispatchPause();
    }

    public void dispatchStop() {
        this.bny.bnx.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.bny.bnx.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.bny.bnx.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.bny.bnx.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.bny.bnx.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.bny.bnx.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.bny.bnx.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.bny.bnx.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.bny.bnx.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.bny.bnx.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.bny.bnx.execPendingActions();
    }

    public void doLoaderStart() {
        this.bny.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.bny.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.bny.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.bny.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> SB() {
        return this.bny.SB();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.bny.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.bny.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
