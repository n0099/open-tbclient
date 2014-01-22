package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
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
import android.view.ViewGroup;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class n extends Activity {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    private static final int HONEYCOMB = 11;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    private static final String TAG = "FragmentActivity";
    HashMap<String, aj> mAllLoaderManagers;
    boolean mCheckedForLoaderManager;
    boolean mCreated;
    aj mLoaderManager;
    boolean mLoadersStarted;
    boolean mOptionsMenuInvalidated;
    boolean mReallyStopped;
    boolean mResumed;
    boolean mRetaining;
    boolean mStopped;
    final Handler mHandler = new o(this);
    final v mFragments = new v();
    final s mContainer = new p(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.i();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            if (this.mFragments.f == null || i4 < 0 || i4 >= this.mFragments.f.size()) {
                Log.w(TAG, "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = this.mFragments.f.get(i4);
            if (fragment == null) {
                Log.w(TAG, "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                return;
            } else {
                fragment.a(65535 & i, i2, intent);
                return;
            }
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
        this.mFragments.a(this, this.mContainer, (Fragment) null);
        if (getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        r rVar = (r) getLastNonConfigurationInstance();
        if (rVar != null) {
            this.mAllLoaderManagers = rVar.e;
        }
        if (bundle != null) {
            this.mFragments.a(bundle.getParcelable(FRAGMENTS_TAG), rVar != null ? rVar.d : null);
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
    /* JADX WARN: Type inference failed for: r3v3, types: [android.support.v4.app.v] */
    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        if (!"fragment".equals(str)) {
            return super.onCreateView(str, context, attributeSet);
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q.a);
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
        if (v.a) {
            Log.v(TAG, "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + attributeValue + " existing=" + ((Object) r1));
        }
        if (r1 == 0) {
            Fragment a = Fragment.a(this, attributeValue);
            a.x = true;
            a.F = resourceId != 0 ? resourceId : id;
            a.G = id;
            a.H = string;
            a.y = true;
            a.B = this.mFragments;
            a.a(this, attributeSet, a.m);
            this.mFragments.a(a, true);
            fragment = a;
        } else if (r1.y) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
        } else {
            r1.y = true;
            if (!r1.L) {
                r1.a(this, attributeSet, r1.m);
            }
            this.mFragments.b(r1);
            fragment = r1;
        }
        if (fragment.R == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.R.setId(resourceId);
        }
        if (fragment.R.getTag() == null) {
            fragment.R.setTag(string);
        }
        return fragment.R;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        doReallyStop(false);
        this.mFragments.r();
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
        this.mFragments.s();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            onResumeFragments();
        }
        this.mFragments.n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.mFragments.e();
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        onResumeFragments();
        this.mFragments.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResumeFragments() {
        this.mFragments.m();
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
        int i = 0;
        if (this.mStopped) {
            doReallyStop(true);
        }
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        ArrayList<Fragment> g = this.mFragments.g();
        if (this.mAllLoaderManagers != null) {
            aj[] ajVarArr = new aj[this.mAllLoaderManagers.size()];
            this.mAllLoaderManagers.values().toArray(ajVarArr);
            if (ajVarArr != null) {
                int i2 = 0;
                while (i < ajVarArr.length) {
                    aj ajVar = ajVarArr[i];
                    if (ajVar.g) {
                        i2 = 1;
                    } else {
                        ajVar.h();
                        this.mAllLoaderManagers.remove(ajVar.d);
                    }
                    i++;
                }
                i = i2;
            }
        }
        if (g == null && i == 0 && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        r rVar = new r();
        rVar.a = null;
        rVar.b = onRetainCustomNonConfigurationInstance;
        rVar.c = null;
        rVar.d = g;
        rVar.e = this.mAllLoaderManagers;
        return rVar;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
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
                this.mLoaderManager = getLoaderManager(null, this.mLoadersStarted, false);
                if (this.mLoaderManager != null && !this.mLoaderManager.f) {
                    this.mLoaderManager.b();
                }
            }
            this.mCheckedForLoaderManager = true;
        }
        this.mFragments.l();
        if (this.mAllLoaderManagers != null) {
            aj[] ajVarArr = new aj[this.mAllLoaderManagers.size()];
            this.mAllLoaderManagers.values().toArray(ajVarArr);
            if (ajVarArr != null) {
                for (aj ajVar : ajVarArr) {
                    ajVar.e();
                    ajVar.g();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        this.mHandler.sendEmptyMessage(1);
        this.mFragments.o();
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public Object getLastCustomNonConfigurationInstance() {
        r rVar = (r) getLastNonConfigurationInstance();
        if (rVar != null) {
            return rVar.b;
        }
        return null;
    }

    public void supportInvalidateOptionsMenu() {
        if (Build.VERSION.SDK_INT >= 11) {
            h.a(this);
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
                        resourcePackageName = SocialConstants.ANDROID_CLIENT_TYPE;
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
                        resourcePackageName = PushConstants.EXTRA_APP;
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

    public t getSupportFragmentManager() {
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
            super.startActivityForResult(intent, ((fragment.o + 1) << 16) + (65535 & i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidateSupportFragment(String str) {
        aj ajVar;
        if (this.mAllLoaderManagers != null && (ajVar = this.mAllLoaderManagers.get(str)) != null && !ajVar.g) {
            ajVar.h();
            this.mAllLoaderManagers.remove(str);
        }
    }

    public ah getSupportLoaderManager() {
        if (this.mLoaderManager != null) {
            return this.mLoaderManager;
        }
        this.mCheckedForLoaderManager = true;
        this.mLoaderManager = getLoaderManager(null, this.mLoadersStarted, true);
        return this.mLoaderManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj getLoaderManager(String str, boolean z, boolean z2) {
        if (this.mAllLoaderManagers == null) {
            this.mAllLoaderManagers = new HashMap<>();
        }
        aj ajVar = this.mAllLoaderManagers.get(str);
        if (ajVar == null) {
            if (z2) {
                aj ajVar2 = new aj(str, this, z);
                this.mAllLoaderManagers.put(str, ajVar2);
                return ajVar2;
            }
            return ajVar;
        }
        ajVar.a(this);
        return ajVar;
    }
}
