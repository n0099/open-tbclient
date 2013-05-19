package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends Activity {
    private static final String FRAGMENTS_TAG = "android:support:fragments";
    private static final int HONEYCOMB = 11;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    private static final String TAG = "FragmentActivity";
    t mAllLoaderManagers;
    boolean mCheckedForLoaderManager;
    boolean mCreated;
    y mLoaderManager;
    boolean mLoadersStarted;
    boolean mOptionsMenuInvalidated;
    boolean mReallyStopped;
    boolean mResumed;
    boolean mRetaining;
    boolean mStopped;
    final Handler mHandler = new h(this);
    final m mFragments = new m();

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            if (this.mFragments.f == null || i4 < 0 || i4 >= this.mFragments.f.size()) {
                Log.w(TAG, "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = (Fragment) this.mFragments.f.get(i4);
            if (fragment == null) {
                Log.w(TAG, "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
            }
            fragment.a(65535 & i, i2, intent);
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (!this.mFragments.c()) {
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.a(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mFragments.a(this);
        if (getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        j jVar = (j) getLastNonConfigurationInstance();
        if (jVar != null) {
            this.mAllLoaderManagers = jVar.e;
        }
        if (bundle != null) {
            this.mFragments.a(bundle.getParcelable(FRAGMENTS_TAG), jVar != null ? jVar.d : null);
        }
        this.mFragments.j();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.mFragments.a(menu, getMenuInflater());
            if (Build.VERSION.SDK_INT < 11) {
                return true;
            }
            return onCreatePanelMenu;
        }
        return super.onCreatePanelMenu(i, menu);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x005c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0064 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x006e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v19, types: [android.support.v4.app.Fragment] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.support.v4.app.Fragment, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.support.v4.app.m] */
    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        if (!"fragment".equals(str)) {
            return super.onCreateView(str, context, attributeSet);
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.a);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        int id = 0 != 0 ? r1.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        r1 = resourceId != -1 ? this.mFragments.a(resourceId) : 0;
        if (r1 == 0 && string != null) {
            r1 = this.mFragments.a(string);
        }
        if (r1 == 0 && id != -1) {
            r1 = this.mFragments.a(id);
        }
        if (m.a) {
            Log.v(TAG, "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + attributeValue + " existing=" + ((Object) r1));
        }
        if (r1 == 0) {
            Fragment a = Fragment.a(this, attributeValue);
            a.w = true;
            a.C = resourceId != 0 ? resourceId : id;
            a.D = id;
            a.E = string;
            a.x = true;
            a.A = this.mFragments;
            a.a(this, attributeSet, a.l);
            this.mFragments.a(a, true);
            fragment = a;
        } else if (r1.x) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
        } else {
            r1.x = true;
            if (!r1.I) {
                r1.a(this, attributeSet, r1.l);
            }
            this.mFragments.b(r1);
            fragment = r1;
        }
        if (fragment.O == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.O.setId(resourceId);
        }
        if (fragment.O.getTag() == null) {
            fragment.O.setTag(string);
        }
        return fragment.O;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        doReallyStop(false);
        this.mFragments.q();
        if (this.mLoaderManager != null) {
            this.mLoaderManager.h();
        }
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
        this.mFragments.r();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.mFragments.a(menuItem);
            case 6:
                return this.mFragments.b(menuItem);
            default:
                return false;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.mFragments.b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            this.mFragments.m();
        }
        this.mFragments.n();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.mFragments.e();
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        this.mFragments.m();
        this.mFragments.e();
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
        return (super.onPreparePanel(i, view, menu) || this.mFragments.a(menu)) && menu.hasVisibleItems();
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        boolean z;
        if (this.mStopped) {
            doReallyStop(true);
        }
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        ArrayList g = this.mFragments.g();
        boolean z2 = false;
        if (this.mAllLoaderManagers != null) {
            int a = this.mAllLoaderManagers.a() - 1;
            while (a >= 0) {
                y yVar = (y) this.mAllLoaderManagers.f(a);
                if (yVar.f) {
                    z = true;
                } else {
                    yVar.h();
                    this.mAllLoaderManagers.d(a);
                    z = z2;
                }
                a--;
                z2 = z;
            }
        }
        if (g == null && !z2 && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        j jVar = new j();
        jVar.a = null;
        jVar.b = onRetainCustomNonConfigurationInstance;
        jVar.c = null;
        jVar.d = g;
        jVar.e = this.mAllLoaderManagers;
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable h = this.mFragments.h();
        if (h != null) {
            bundle.putParcelable(FRAGMENTS_TAG, h);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mStopped = false;
        this.mReallyStopped = false;
        this.mHandler.removeMessages(1);
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.k();
        }
        this.mFragments.i();
        this.mFragments.e();
        if (!this.mLoadersStarted) {
            this.mLoadersStarted = true;
            if (this.mLoaderManager != null) {
                this.mLoaderManager.b();
            } else if (!this.mCheckedForLoaderManager) {
                this.mLoaderManager = getLoaderManager(-1, this.mLoadersStarted, false);
            }
            this.mCheckedForLoaderManager = true;
        }
        this.mFragments.l();
        if (this.mAllLoaderManagers != null) {
            for (int a = this.mAllLoaderManagers.a() - 1; a >= 0; a--) {
                y yVar = (y) this.mAllLoaderManagers.f(a);
                yVar.e();
                yVar.g();
            }
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        this.mHandler.sendEmptyMessage(1);
        this.mFragments.o();
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public Object getLastCustomNonConfigurationInstance() {
        j jVar = (j) getLastNonConfigurationInstance();
        if (jVar != null) {
            return jVar.b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void supportInvalidateOptionsMenu() {
        if (Build.VERSION.SDK_INT >= 11) {
            a.a(this);
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
        printWriter.print(str2);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.mLoadersStarted);
        if (this.mLoaderManager != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.mLoaderManager)));
            printWriter.println(":");
            this.mLoaderManager.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        this.mFragments.a(str, fileDescriptor, printWriter, strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doReallyStop(boolean z) {
        if (!this.mReallyStopped) {
            this.mReallyStopped = true;
            this.mRetaining = z;
            this.mHandler.removeMessages(1);
            onReallyStop();
        }
    }

    void onReallyStop() {
        if (this.mLoadersStarted) {
            this.mLoadersStarted = false;
            if (this.mLoaderManager != null) {
                if (!this.mRetaining) {
                    this.mLoaderManager.c();
                } else {
                    this.mLoaderManager.d();
                }
            }
        }
        this.mFragments.p();
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public k getSupportFragmentManager() {
        return this.mFragments;
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (i != -1 && ((-65536) & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
        super.startActivityForResult(intent, i);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        if (i == -1) {
            super.startActivityForResult(intent, -1);
        } else if (((-65536) & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            super.startActivityForResult(intent, ((fragment.n + 1) << 16) + (65535 & i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidateSupportFragmentIndex(int i) {
        y yVar;
        if (this.mAllLoaderManagers != null && (yVar = (y) this.mAllLoaderManagers.a(i)) != null && !yVar.f) {
            yVar.h();
            this.mAllLoaderManagers.c(i);
        }
    }

    public w getSupportLoaderManager() {
        if (this.mLoaderManager != null) {
            return this.mLoaderManager;
        }
        this.mCheckedForLoaderManager = true;
        this.mLoaderManager = getLoaderManager(-1, this.mLoadersStarted, true);
        return this.mLoaderManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y getLoaderManager(int i, boolean z, boolean z2) {
        if (this.mAllLoaderManagers == null) {
            this.mAllLoaderManagers = new t();
        }
        y yVar = (y) this.mAllLoaderManagers.a(i);
        if (yVar == null) {
            if (z2) {
                y yVar2 = new y(this, z);
                this.mAllLoaderManagers.b(i, yVar2);
                return yVar2;
            }
            return yVar;
        }
        yVar.a(this);
        return yVar;
    }
}
