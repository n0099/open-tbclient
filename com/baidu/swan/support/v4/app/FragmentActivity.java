package com.baidu.swan.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.InputDeviceCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.baidu.swan.support.v4.app.a;
import com.baidu.swan.support.v4.app.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class FragmentActivity extends g implements a.InterfaceC0559a, c.a {
    boolean ekh;
    boolean mCreated;
    boolean mReallyStopped;
    boolean mRequestedPermissionsFromFragment;
    protected boolean mResumed;
    boolean mRetaining;
    boolean mStopped;
    final Handler mHandler = new Handler() { // from class: com.baidu.swan.support.v4.app.FragmentActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (FragmentActivity.this.mStopped) {
                        FragmentActivity.this.doReallyStop(false);
                        return;
                    }
                    return;
                case 2:
                    FragmentActivity.this.onResumeFragments();
                    FragmentActivity.this.ekg.execPendingActions();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    };
    final i ekg = i.a(new a());

    @Override // com.baidu.swan.support.v4.app.g, android.app.Activity, android.view.LayoutInflater.Factory2
    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    @Override // com.baidu.swan.support.v4.app.f, android.app.Activity, android.view.LayoutInflater.Factory
    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    /* loaded from: classes6.dex */
    static final class b {
        Object custom;
        List<Fragment> ekj;
        com.baidu.swan.support.v4.b.f<String, o> ekk;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.ekg.noteStateNotSaved();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            int activeFragmentsCount = this.ekg.getActiveFragmentsCount();
            if (activeFragmentsCount == 0 || i4 < 0 || i4 >= activeFragmentsCount) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = this.ekg.getActiveFragments(new ArrayList(activeFragmentsCount)).get(i4);
            if (fragment == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                return;
            } else {
                fragment.onActivityResult(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (!this.ekg.bcJ().popBackStackImmediate()) {
            supportFinishAfterTransition();
        }
    }

    public void supportFinishAfterTransition() {
        com.baidu.swan.support.v4.app.a.finishAfterTransition(this);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.ekg.dispatchConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        this.ekg.h(null);
        super.onCreate(bundle);
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null) {
            this.ekg.a(bVar.ekk);
        }
        if (bundle != null) {
            this.ekg.restoreAllState(bundle.getParcelable("android:support:fragments"), bVar != null ? bVar.ekj : null);
        }
        this.ekg.dispatchCreate();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.ekg.dispatchCreateOptionsMenu(menu, getMenuInflater());
            if (Build.VERSION.SDK_INT < 11) {
                return true;
            }
            return onCreatePanelMenu;
        }
        return super.onCreatePanelMenu(i, menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.swan.support.v4.app.f
    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.ekg.onCreateView(view, str, context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        doReallyStop(false);
        this.ekg.dispatchDestroy();
        this.ekg.doLoaderDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT < 5 && i == 4 && keyEvent.getRepeatCount() == 0) {
            onBackPressed();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.ekg.dispatchLowMemory();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.ekg.dispatchOptionsItemSelected(menuItem);
            case 6:
                return this.ekg.dispatchContextItemSelected(menuItem);
            default:
                return false;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.ekg.dispatchOptionsMenuClosed(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            onResumeFragments();
        }
        this.ekg.dispatchPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.ekg.noteStateNotSaved();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.ekg.noteStateNotSaved();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.ekg.execPendingActions();
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        onResumeFragments();
        this.ekg.execPendingActions();
    }

    protected void onResumeFragments() {
        this.ekg.dispatchResume();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.ekh) {
            this.ekh = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return onPrepareOptionsPanel(view, menu) | this.ekg.dispatchPrepareOptionsMenu(menu);
    }

    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        if (this.mStopped) {
            doReallyStop(true);
        }
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        List<Fragment> retainNonConfig = this.ekg.retainNonConfig();
        com.baidu.swan.support.v4.b.f<String, o> bcK = this.ekg.bcK();
        if (retainNonConfig == null && bcK == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        b bVar = new b();
        bVar.custom = onRetainCustomNonConfigurationInstance;
        bVar.ekj = retainNonConfig;
        bVar.ekk = bcK;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable saveAllState = this.ekg.saveAllState();
        if (saveAllState != null) {
            bundle.putParcelable("android:support:fragments", saveAllState);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.mStopped = false;
        this.mReallyStopped = false;
        this.mHandler.removeMessages(1);
        if (!this.mCreated) {
            this.mCreated = true;
            this.ekg.dispatchActivityCreated();
        }
        this.ekg.noteStateNotSaved();
        this.ekg.execPendingActions();
        this.ekg.doLoaderStart();
        this.ekg.dispatchStart();
        this.ekg.reportLoaderStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        this.mHandler.sendEmptyMessage(1);
        this.ekg.dispatchStop();
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public void supportInvalidateOptionsMenu() {
        if (Build.VERSION.SDK_INT >= 11) {
            d.aa(this);
        } else {
            this.ekh = true;
        }
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 11) {
        }
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print("mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.mReallyStopped);
        this.ekg.dumpLoaders(str2, fileDescriptor, printWriter, strArr);
        this.ekg.bcJ().dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        a(str + "  ", printWriter, getWindow().getDecorView());
    }

    private static String aZ(View view) {
        String resourcePackageName;
        StringBuilder sb = new StringBuilder(128);
        sb.append(view.getClass().getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(view)));
        sb.append(' ');
        switch (view.getVisibility()) {
            case 0:
                sb.append('V');
                break;
            case 4:
                sb.append('I');
                break;
            case 8:
                sb.append('G');
                break;
            default:
                sb.append('.');
                break;
        }
        sb.append(view.isFocusable() ? 'F' : '.');
        sb.append(view.isEnabled() ? 'E' : '.');
        sb.append(view.willNotDraw() ? '.' : 'D');
        sb.append(view.isHorizontalScrollBarEnabled() ? 'H' : '.');
        sb.append(view.isVerticalScrollBarEnabled() ? 'V' : '.');
        sb.append(view.isClickable() ? 'C' : '.');
        sb.append(view.isLongClickable() ? 'L' : '.');
        sb.append(' ');
        sb.append(view.isFocused() ? 'F' : '.');
        sb.append(view.isSelected() ? 'S' : '.');
        sb.append(view.isPressed() ? 'P' : '.');
        sb.append(' ');
        sb.append(view.getLeft());
        sb.append(',');
        sb.append(view.getTop());
        sb.append('-');
        sb.append(view.getRight());
        sb.append(',');
        sb.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            sb.append(" #");
            sb.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (id != 0 && resources != null) {
                switch ((-16777216) & id) {
                    case 16777216:
                        resourcePackageName = "android";
                        String resourceTypeName = resources.getResourceTypeName(id);
                        String resourceEntryName = resources.getResourceEntryName(id);
                        sb.append(" ");
                        sb.append(resourcePackageName);
                        sb.append(":");
                        sb.append(resourceTypeName);
                        sb.append("/");
                        sb.append(resourceEntryName);
                        break;
                    case 2130706432:
                        resourcePackageName = "app";
                        String resourceTypeName2 = resources.getResourceTypeName(id);
                        String resourceEntryName2 = resources.getResourceEntryName(id);
                        sb.append(" ");
                        sb.append(resourcePackageName);
                        sb.append(":");
                        sb.append(resourceTypeName2);
                        sb.append("/");
                        sb.append(resourceEntryName2);
                        break;
                    default:
                        try {
                            resourcePackageName = resources.getResourcePackageName(id);
                            String resourceTypeName22 = resources.getResourceTypeName(id);
                            String resourceEntryName22 = resources.getResourceEntryName(id);
                            sb.append(" ");
                            sb.append(resourcePackageName);
                            sb.append(":");
                            sb.append(resourceTypeName22);
                            sb.append("/");
                            sb.append(resourceEntryName22);
                            break;
                        } catch (Resources.NotFoundException e) {
                            break;
                        }
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }

    private void a(String str, PrintWriter printWriter, View view) {
        ViewGroup viewGroup;
        int childCount;
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(aZ(view));
        if ((view instanceof ViewGroup) && (childCount = (viewGroup = (ViewGroup) view).getChildCount()) > 0) {
            String str2 = str + "  ";
            for (int i = 0; i < childCount; i++) {
                a(str2, printWriter, viewGroup.getChildAt(i));
            }
        }
    }

    void doReallyStop(boolean z) {
        if (!this.mReallyStopped) {
            this.mReallyStopped = true;
            this.mRetaining = z;
            this.mHandler.removeMessages(1);
            onReallyStop();
        }
    }

    void onReallyStop() {
        this.ekg.doLoaderStop(this.mRetaining);
        this.ekg.dispatchReallyStop();
    }

    public void f(Fragment fragment) {
    }

    public k bcJ() {
        return this.ekg.bcJ();
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (i != -1 && ((-65536) & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
        super.startActivityForResult(intent, i);
    }

    @Override // com.baidu.swan.support.v4.app.c.a
    public final void validateRequestPermissionsRequestCode(int i) {
        if (this.mRequestedPermissionsFromFragment) {
            this.mRequestedPermissionsFromFragment = false;
        } else if ((i & InputDeviceCompat.SOURCE_ANY) != 0) {
            throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
        }
    }

    @Override // android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0559a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        int i2 = (i >> 8) & 255;
        if (i2 != 0) {
            int i3 = i2 - 1;
            int activeFragmentsCount = this.ekg.getActiveFragmentsCount();
            if (activeFragmentsCount == 0 || i3 < 0 || i3 >= activeFragmentsCount) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = this.ekg.getActiveFragments(new ArrayList(activeFragmentsCount)).get(i3);
            if (fragment == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
            } else {
                fragment.onRequestPermissionsResult(i & 255, strArr, iArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, String[] strArr, int i) {
        if (i == -1) {
            com.baidu.swan.support.v4.app.a.requestPermissions(this, strArr, i);
        } else if ((i & InputDeviceCompat.SOURCE_ANY) != 0) {
            throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
        } else {
            this.mRequestedPermissionsFromFragment = true;
            com.baidu.swan.support.v4.app.a.requestPermissions(this, strArr, ((fragment.mIndex + 1) << 8) + (i & 255));
        }
    }

    /* loaded from: classes6.dex */
    class a extends j<FragmentActivity> {
        public a() {
            super(FragmentActivity.this);
        }

        @Override // com.baidu.swan.support.v4.app.j
        public void onDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // com.baidu.swan.support.v4.app.j
        public boolean g(Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        @Override // com.baidu.swan.support.v4.app.j
        public LayoutInflater onGetLayoutInflater() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        @Override // com.baidu.swan.support.v4.app.j
        public void onSupportInvalidateOptionsMenu() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }

        @Override // com.baidu.swan.support.v4.app.j
        public void b(@NonNull Fragment fragment, @NonNull String[] strArr, int i) {
            FragmentActivity.this.a(fragment, strArr, i);
        }

        @Override // com.baidu.swan.support.v4.app.j
        public boolean onHasWindowAnimations() {
            return FragmentActivity.this.getWindow() != null;
        }

        @Override // com.baidu.swan.support.v4.app.j
        public int onGetWindowAnimations() {
            Window window = FragmentActivity.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // com.baidu.swan.support.v4.app.j
        public void f(Fragment fragment) {
            FragmentActivity.this.f(fragment);
        }

        @Override // com.baidu.swan.support.v4.app.j, com.baidu.swan.support.v4.app.h
        @Nullable
        public View onFindViewById(int i) {
            return FragmentActivity.this.findViewById(i);
        }

        @Override // com.baidu.swan.support.v4.app.j, com.baidu.swan.support.v4.app.h
        public boolean onHasView() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }
}
