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
    private final j<?> eiq;

    public static final i a(j<?> jVar) {
        return new i(jVar);
    }

    private i(j<?> jVar) {
        this.eiq = jVar;
    }

    public k bcc() {
        return this.eiq.bce();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.eiq.eip.eiH;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.eiq.eip.eiH == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.eiq.eip.eiH);
        return list;
    }

    public void h(Fragment fragment) {
        this.eiq.eip.a(this.eiq, this.eiq, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.eiq.eip.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.eiq.eip.noteStateNotSaved();
    }

    public Parcelable saveAllState() {
        return this.eiq.eip.saveAllState();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.eiq.eip.restoreAllState(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.eiq.eip.bcg();
    }

    public void dispatchCreate() {
        this.eiq.eip.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.eiq.eip.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.eiq.eip.dispatchStart();
    }

    public void dispatchResume() {
        this.eiq.eip.dispatchResume();
    }

    public void dispatchPause() {
        this.eiq.eip.dispatchPause();
    }

    public void dispatchStop() {
        this.eiq.eip.dispatchStop();
    }

    public void dispatchReallyStop() {
        this.eiq.eip.dispatchReallyStop();
    }

    public void dispatchDestroy() {
        this.eiq.eip.dispatchDestroy();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.eiq.eip.dispatchConfigurationChanged(configuration);
    }

    public void dispatchLowMemory() {
        this.eiq.eip.dispatchLowMemory();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.eiq.eip.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.eiq.eip.dispatchPrepareOptionsMenu(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.eiq.eip.dispatchOptionsItemSelected(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.eiq.eip.dispatchContextItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.eiq.eip.dispatchOptionsMenuClosed(menu);
    }

    public boolean execPendingActions() {
        return this.eiq.eip.execPendingActions();
    }

    public void doLoaderStart() {
        this.eiq.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        this.eiq.doLoaderStop(z);
    }

    public void doLoaderDestroy() {
        this.eiq.doLoaderDestroy();
    }

    public void reportLoaderStart() {
        this.eiq.reportLoaderStart();
    }

    public com.baidu.swan.support.v4.b.f<String, o> bcd() {
        return this.eiq.bcd();
    }

    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.eiq.a(fVar);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.eiq.dumpLoaders(str, fileDescriptor, printWriter, strArr);
    }
}
