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
    private final j<?> cyz;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.cyz = jVar;
    }

    public k arT() {
        return this.cyz.arV();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.cyz.cyy.cyQ;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.cyz.cyy.cyQ == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.cyz.cyy.cyQ);
        return list;
    }

    public void f(Fragment fragment) {
        this.cyz.cyy.a(this.cyz, this.cyz, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.cyz.cyy.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.cyz.cyy.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.cyz.cyy.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.cyz.cyy.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.cyz.cyy.arX();
    }

    public void dispatchCreate() {
        this.cyz.cyy.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.cyz.cyy.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.cyz.cyy.dispatchStart();
    }

    public void dispatchResume() {
        this.cyz.cyy.dispatchResume();
    }

    public void dispatchPause() {
        this.cyz.cyy.dispatchPause();
    }

    public void dispatchStop() {
        this.cyz.cyy.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.cyz.cyy.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.cyz.cyy.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.cyz.cyy.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.cyz.cyy.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.cyz.cyy.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.cyz.cyy.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.cyz.cyy.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.cyz.cyy.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.cyz.cyy.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.cyz.cyy.execPendingActions();
    }

    public void doLoaderStart() {
        this.cyz.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.cyz.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.cyz.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.cyz.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> arU() {
        return this.cyz.arU();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.cyz.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.cyz.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
