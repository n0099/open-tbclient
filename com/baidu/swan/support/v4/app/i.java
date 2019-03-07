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
    private final j<?> bnx;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.bnx = jVar;
    }

    public k SA() {
        return this.bnx.SC();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.bnx.bnw.bnM;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.bnx.bnw.bnM == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.bnx.bnw.bnM);
        return list;
    }

    public void f(Fragment fragment) {
        this.bnx.bnw.a(this.bnx, this.bnx, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.bnx.bnw.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.bnx.bnw.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.bnx.bnw.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.bnx.bnw.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.bnx.bnw.SE();
    }

    public void dispatchCreate() {
        this.bnx.bnw.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.bnx.bnw.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.bnx.bnw.dispatchStart();
    }

    public void dispatchResume() {
        this.bnx.bnw.dispatchResume();
    }

    public void dispatchPause() {
        this.bnx.bnw.dispatchPause();
    }

    public void dispatchStop() {
        this.bnx.bnw.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.bnx.bnw.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.bnx.bnw.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.bnx.bnw.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.bnx.bnw.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.bnx.bnw.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.bnx.bnw.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.bnx.bnw.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.bnx.bnw.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.bnx.bnw.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.bnx.bnw.execPendingActions();
    }

    public void doLoaderStart() {
        this.bnx.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.bnx.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.bnx.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.bnx.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> SB() {
        return this.bnx.SB();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.bnx.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.bnx.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
