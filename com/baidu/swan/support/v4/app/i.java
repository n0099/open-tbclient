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
    private final j<?> dnP;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.dnP = jVar;
    }

    public k aHx() {
        return this.dnP.aHz();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.dnP.dnO.doh;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.dnP.dnO.doh == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.dnP.dnO.doh);
        return list;
    }

    public void f(Fragment fragment) {
        this.dnP.dnO.a(this.dnP, this.dnP, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.dnP.dnO.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.dnP.dnO.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.dnP.dnO.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.dnP.dnO.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.dnP.dnO.aHB();
    }

    public void dispatchCreate() {
        this.dnP.dnO.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.dnP.dnO.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.dnP.dnO.dispatchStart();
    }

    public void dispatchResume() {
        this.dnP.dnO.dispatchResume();
    }

    public void dispatchPause() {
        this.dnP.dnO.dispatchPause();
    }

    public void dispatchStop() {
        this.dnP.dnO.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.dnP.dnO.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.dnP.dnO.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.dnP.dnO.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.dnP.dnO.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.dnP.dnO.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.dnP.dnO.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.dnP.dnO.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.dnP.dnO.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.dnP.dnO.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.dnP.dnO.execPendingActions();
    }

    public void doLoaderStart() {
        this.dnP.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.dnP.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.dnP.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.dnP.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> aHy() {
        return this.dnP.aHy();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.dnP.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.dnP.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
