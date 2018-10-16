package com.baidu.searchbox.support.v4.app;

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
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.support.v4.app.ActivityCompat;
import com.baidu.searchbox.support.v4.app.ActivityCompatApi23;
import com.baidu.searchbox.support.v4.util.SimpleArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class FragmentActivity extends BaseFragmentActivityHoneycomb implements ActivityCompat.OnRequestPermissionsResultCallback, ActivityCompatApi23.RequestPermissionsRequestCodeValidator {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    private static final int HONEYCOMB = 11;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    boolean mOptionsMenuInvalidated;
    boolean mReallyStopped;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mRetaining;
    boolean mStopped;
    final Handler mHandler = new Handler() { // from class: com.baidu.searchbox.support.v4.app.FragmentActivity.1
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
                    FragmentActivity.this.mFragments.execPendingActions();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    };
    final FragmentController mFragments = FragmentController.createController(new HostCallbacks());

    @Override // com.baidu.searchbox.support.v4.app.BaseFragmentActivityHoneycomb, android.app.Activity, android.view.LayoutInflater.Factory2
    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    @Override // com.baidu.searchbox.support.v4.app.BaseFragmentActivityDonut, android.app.Activity, android.view.LayoutInflater.Factory
    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    /* loaded from: classes2.dex */
    static final class NonConfigurationInstances {
        Object custom;
        List<Fragment> fragments;
        SimpleArrayMap<String, LoaderManager> loaders;

        NonConfigurationInstances() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.noteStateNotSaved();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            int activeFragmentsCount = this.mFragments.getActiveFragmentsCount();
            if (activeFragmentsCount == 0 || i4 < 0 || i4 >= activeFragmentsCount) {
                Log.w(TAG, "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = this.mFragments.getActiveFragments(new ArrayList(activeFragmentsCount)).get(i4);
            if (fragment == null) {
                Log.w(TAG, "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
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
        if (!this.mFragments.getSupportFragmentManager().popBackStackImmediate()) {
            supportFinishAfterTransition();
        }
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.finishAfterTransition(this);
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.setEnterSharedElementCallback(this, sharedElementCallback);
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.setExitSharedElementCallback(this, sharedElementCallback);
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition(this);
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition(this);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.dispatchConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.support.v4.app.BaseFragmentActivityDonut, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        this.mFragments.attachHost(null);
        super.onCreate(bundle);
        NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            this.mFragments.restoreLoaderNonConfig(nonConfigurationInstances.loaders);
        }
        if (bundle != null) {
            this.mFragments.restoreAllState(bundle.getParcelable(FRAGMENTS_TAG), nonConfigurationInstances != null ? nonConfigurationInstances.fragments : null);
        }
        this.mFragments.dispatchCreate();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater());
            if (Build.VERSION.SDK_INT < 11) {
                return true;
            }
            return onCreatePanelMenu;
        }
        return super.onCreatePanelMenu(i, menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.searchbox.support.v4.app.BaseFragmentActivityDonut
    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.onCreateView(view, str, context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        doReallyStop(false);
        this.mFragments.dispatchDestroy();
        this.mFragments.doLoaderDestroy();
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
        this.mFragments.dispatchLowMemory();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.mFragments.dispatchOptionsItemSelected(menuItem);
            case 6:
                return this.mFragments.dispatchContextItemSelected(menuItem);
            default:
                return false;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.mFragments.dispatchOptionsMenuClosed(menu);
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
        this.mFragments.dispatchPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.noteStateNotSaved();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.noteStateNotSaved();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.mFragments.execPendingActions();
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        onResumeFragments();
        this.mFragments.execPendingActions();
    }

    protected void onResumeFragments() {
        this.mFragments.dispatchResume();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.mOptionsMenuInvalidated) {
            this.mOptionsMenuInvalidated = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return onPrepareOptionsPanel(view, menu) | this.mFragments.dispatchPrepareOptionsMenu(menu);
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
        List<Fragment> retainNonConfig = this.mFragments.retainNonConfig();
        SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig = this.mFragments.retainLoaderNonConfig();
        if (retainNonConfig == null && retainLoaderNonConfig == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        NonConfigurationInstances nonConfigurationInstances = new NonConfigurationInstances();
        nonConfigurationInstances.custom = onRetainCustomNonConfigurationInstance;
        nonConfigurationInstances.fragments = retainNonConfig;
        nonConfigurationInstances.loaders = retainLoaderNonConfig;
        return nonConfigurationInstances;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable saveAllState = this.mFragments.saveAllState();
        if (saveAllState != null) {
            bundle.putParcelable(FRAGMENTS_TAG, saveAllState);
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
            this.mFragments.dispatchActivityCreated();
        }
        this.mFragments.noteStateNotSaved();
        this.mFragments.execPendingActions();
        this.mFragments.doLoaderStart();
        this.mFragments.dispatchStart();
        this.mFragments.reportLoaderStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        this.mHandler.sendEmptyMessage(1);
        this.mFragments.dispatchStop();
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            return nonConfigurationInstances.custom;
        }
        return null;
    }

    public void supportInvalidateOptionsMenu() {
        if (Build.VERSION.SDK_INT >= 11) {
            ActivityCompatHoneycomb.invalidateOptionsMenu(this);
        } else {
            this.mOptionsMenuInvalidated = true;
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
        this.mFragments.dumpLoaders(str2, fileDescriptor, printWriter, strArr);
        this.mFragments.getSupportFragmentManager().dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        dumpViewHierarchy(str + "  ", printWriter, getWindow().getDecorView());
    }

    private static String viewToString(View view) {
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
                        resourcePackageName = HttpConstants.OS_TYPE_VALUE;
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

    private void dumpViewHierarchy(String str, PrintWriter printWriter, View view) {
        ViewGroup viewGroup;
        int childCount;
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(viewToString(view));
        if ((view instanceof ViewGroup) && (childCount = (viewGroup = (ViewGroup) view).getChildCount()) > 0) {
            String str2 = str + "  ";
            for (int i = 0; i < childCount; i++) {
                dumpViewHierarchy(str2, printWriter, viewGroup.getChildAt(i));
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
        this.mFragments.doLoaderStop(this.mRetaining);
        this.mFragments.dispatchReallyStop();
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.getSupportFragmentManager();
    }

    public LoaderManager getSupportLoaderManager() {
        return this.mFragments.getSupportLoaderManager();
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (i != -1 && ((-65536) & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
        super.startActivityForResult(intent, i);
    }

    @Override // com.baidu.searchbox.support.v4.app.ActivityCompatApi23.RequestPermissionsRequestCodeValidator
    public final void validateRequestPermissionsRequestCode(int i) {
        if (this.mRequestedPermissionsFromFragment) {
            this.mRequestedPermissionsFromFragment = false;
        } else if ((i & InputDeviceCompat.SOURCE_ANY) != 0) {
            throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
        }
    }

    @Override // android.app.Activity, com.baidu.searchbox.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        int i2 = (i >> 8) & 255;
        if (i2 != 0) {
            int i3 = i2 - 1;
            int activeFragmentsCount = this.mFragments.getActiveFragmentsCount();
            if (activeFragmentsCount == 0 || i3 < 0 || i3 >= activeFragmentsCount) {
                Log.w(TAG, "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = this.mFragments.getActiveFragments(new ArrayList(activeFragmentsCount)).get(i3);
            if (fragment == null) {
                Log.w(TAG, "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
            } else {
                fragment.onRequestPermissionsResult(i & 255, strArr, iArr);
            }
        }
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        if (i == -1) {
            super.startActivityForResult(intent, -1);
        } else if (((-65536) & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            super.startActivityForResult(intent, ((fragment.mIndex + 1) << 16) + (65535 & i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPermissionsFromFragment(Fragment fragment, String[] strArr, int i) {
        if (i == -1) {
            ActivityCompat.requestPermissions(this, strArr, i);
        } else if ((i & InputDeviceCompat.SOURCE_ANY) != 0) {
            throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
        } else {
            this.mRequestedPermissionsFromFragment = true;
            ActivityCompat.requestPermissions(this, strArr, ((fragment.mIndex + 1) << 8) + (i & 255));
        }
    }

    /* loaded from: classes2.dex */
    class HostCallbacks extends FragmentHostCallback<FragmentActivity> {
        public HostCallbacks() {
            super(FragmentActivity.this);
        }

        @Override // com.baidu.searchbox.support.v4.app.FragmentHostCallback
        public void onDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // com.baidu.searchbox.support.v4.app.FragmentHostCallback
        public boolean onShouldSaveFragmentState(Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        @Override // com.baidu.searchbox.support.v4.app.FragmentHostCallback
        public LayoutInflater onGetLayoutInflater() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.searchbox.support.v4.app.FragmentHostCallback
        public FragmentActivity onGetHost() {
            return FragmentActivity.this;
        }

        @Override // com.baidu.searchbox.support.v4.app.FragmentHostCallback
        public void onSupportInvalidateOptionsMenu() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }

        @Override // com.baidu.searchbox.support.v4.app.FragmentHostCallback
        public void onStartActivityFromFragment(Fragment fragment, Intent intent, int i) {
            FragmentActivity.this.startActivityFromFragment(fragment, intent, i);
        }

        @Override // com.baidu.searchbox.support.v4.app.FragmentHostCallback
        public void onRequestPermissionsFromFragment(@NonNull Fragment fragment, @NonNull String[] strArr, int i) {
            FragmentActivity.this.requestPermissionsFromFragment(fragment, strArr, i);
        }

        @Override // com.baidu.searchbox.support.v4.app.FragmentHostCallback
        public boolean onShouldShowRequestPermissionRationale(@NonNull String str) {
            return ActivityCompat.shouldShowRequestPermissionRationale(FragmentActivity.this, str);
        }

        @Override // com.baidu.searchbox.support.v4.app.FragmentHostCallback
        public boolean onHasWindowAnimations() {
            return FragmentActivity.this.getWindow() != null;
        }

        @Override // com.baidu.searchbox.support.v4.app.FragmentHostCallback
        public int onGetWindowAnimations() {
            Window window = FragmentActivity.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // com.baidu.searchbox.support.v4.app.FragmentHostCallback
        public void onAttachFragment(Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        @Override // com.baidu.searchbox.support.v4.app.FragmentHostCallback, com.baidu.searchbox.support.v4.app.FragmentContainer
        @Nullable
        public View onFindViewById(int i) {
            return FragmentActivity.this.findViewById(i);
        }

        @Override // com.baidu.searchbox.support.v4.app.FragmentHostCallback, com.baidu.searchbox.support.v4.app.FragmentContainer
        public boolean onHasView() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }
}
