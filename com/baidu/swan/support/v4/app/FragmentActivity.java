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
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.bumptech.glide.load.engine.GlideException;
import d.b.g0.m.a.a.a;
import d.b.g0.m.a.a.c;
import d.b.g0.m.a.a.d;
import d.b.g0.m.a.a.g;
import d.b.g0.m.a.a.i;
import d.b.g0.m.a.a.j;
import d.b.g0.m.a.a.k;
import d.b.g0.m.a.a.o;
import d.b.g0.m.a.a.r;
import d.b.g0.m.a.c.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FragmentActivity extends g implements a.b, c.a {
    public static final String FRAGMENTS_TAG = "android:support:fragments";
    public static final int HONEYCOMB = 11;
    public static final int MSG_REALLY_STOPPED = 1;
    public static final int MSG_RESUME_PENDING = 2;
    public static final String TAG = "FragmentActivity";
    public boolean mCreated;
    public boolean mOptionsMenuInvalidated;
    public boolean mReallyStopped;
    public boolean mRequestedPermissionsFromFragment;
    public boolean mResumed;
    public boolean mRetaining;
    public boolean mStopped;
    public final Handler mHandler = new a();
    public final i mFragments = i.b(new b());

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                FragmentActivity fragmentActivity = FragmentActivity.this;
                if (fragmentActivity.mStopped) {
                    fragmentActivity.doReallyStop(false);
                }
            } else if (i != 2) {
                super.handleMessage(message);
            } else {
                FragmentActivity.this.onResumeFragments();
                FragmentActivity.this.mFragments.v();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends j<FragmentActivity> {
        public b() {
            super(FragmentActivity.this);
        }

        @Override // d.b.g0.m.a.a.h
        @Nullable
        public View a(int i) {
            return FragmentActivity.this.findViewById(i);
        }

        @Override // d.b.g0.m.a.a.h
        public boolean b() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // d.b.g0.m.a.a.j
        public void n(Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        @Override // d.b.g0.m.a.a.j
        public void o(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // d.b.g0.m.a.a.j
        public LayoutInflater p() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        @Override // d.b.g0.m.a.a.j
        public int q() {
            Window window = FragmentActivity.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // d.b.g0.m.a.a.j
        public boolean r() {
            return FragmentActivity.this.getWindow() != null;
        }

        @Override // d.b.g0.m.a.a.j
        public void s(@NonNull Fragment fragment, @NonNull String[] strArr, int i) {
            FragmentActivity.this.requestPermissionsFromFragment(fragment, strArr, i);
        }

        @Override // d.b.g0.m.a.a.j
        public boolean t(Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        @Override // d.b.g0.m.a.a.j
        public void u() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }
    }

    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public Object f13038a;

        /* renamed from: b  reason: collision with root package name */
        public List<Fragment> f13039b;

        /* renamed from: c  reason: collision with root package name */
        public f<String, o> f13040c;
    }

    private void dumpViewHierarchy(String str, PrintWriter printWriter, View view) {
        ViewGroup viewGroup;
        int childCount;
        printWriter.print(str);
        if (view == null) {
            printWriter.println(StringUtil.NULL_STRING);
            return;
        }
        printWriter.println(viewToString(view));
        if ((view instanceof ViewGroup) && (childCount = (viewGroup = (ViewGroup) view).getChildCount()) > 0) {
            String str2 = str + GlideException.IndentedAppendable.INDENT;
            for (int i = 0; i < childCount; i++) {
                dumpViewHierarchy(str2, printWriter, viewGroup.getChildAt(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPermissionsFromFragment(Fragment fragment, String[] strArr, int i) {
        if (i == -1) {
            d.b.g0.m.a.a.a.h(this, strArr, i);
        } else if ((i & (-256)) == 0) {
            this.mRequestedPermissionsFromFragment = true;
            d.b.g0.m.a.a.a.h(this, strArr, ((fragment.j + 1) << 8) + (i & 255));
        } else {
            throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
        }
    }

    public static String viewToString(View view) {
        String str;
        StringBuilder sb = new StringBuilder(128);
        sb.append(view.getClass().getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(view)));
        sb.append(' ');
        int visibility = view.getVisibility();
        char c2 = IStringUtil.EXTENSION_SEPARATOR;
        if (visibility == 0) {
            sb.append('V');
        } else if (visibility == 4) {
            sb.append('I');
        } else if (visibility != 8) {
            sb.append(IStringUtil.EXTENSION_SEPARATOR);
        } else {
            sb.append('G');
        }
        sb.append(view.isFocusable() ? 'F' : IStringUtil.EXTENSION_SEPARATOR);
        sb.append(view.isEnabled() ? 'E' : IStringUtil.EXTENSION_SEPARATOR);
        sb.append(view.willNotDraw() ? IStringUtil.EXTENSION_SEPARATOR : 'D');
        sb.append(view.isHorizontalScrollBarEnabled() ? 'H' : IStringUtil.EXTENSION_SEPARATOR);
        sb.append(view.isVerticalScrollBarEnabled() ? 'V' : IStringUtil.EXTENSION_SEPARATOR);
        sb.append(view.isClickable() ? 'C' : IStringUtil.EXTENSION_SEPARATOR);
        sb.append(view.isLongClickable() ? 'L' : IStringUtil.EXTENSION_SEPARATOR);
        sb.append(' ');
        sb.append(view.isFocused() ? 'F' : IStringUtil.EXTENSION_SEPARATOR);
        sb.append(view.isSelected() ? 'S' : IStringUtil.EXTENSION_SEPARATOR);
        if (view.isPressed()) {
            c2 = 'P';
        }
        sb.append(c2);
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
                int i = (-16777216) & id;
                if (i == 16777216) {
                    str = "android";
                } else if (i != 2130706432) {
                    try {
                        str = resources.getResourcePackageName(id);
                    } catch (Resources.NotFoundException unused) {
                    }
                } else {
                    str = "app";
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                sb.append(" ");
                sb.append(str);
                sb.append(":");
                sb.append(resourceTypeName);
                sb.append("/");
                sb.append(resourceEntryName);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // d.b.g0.m.a.a.f
    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.B(view, str, context, attributeSet);
    }

    public void doReallyStop(boolean z) {
        if (this.mReallyStopped) {
            return;
        }
        this.mReallyStopped = true;
        this.mRetaining = z;
        this.mHandler.removeMessages(1);
        onReallyStop();
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + GlideException.IndentedAppendable.INDENT;
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print("mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.mReallyStopped);
        this.mFragments.u(str2, fileDescriptor, printWriter, strArr);
        this.mFragments.y().b(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        dumpViewHierarchy(str + GlideException.IndentedAppendable.INDENT, printWriter, getWindow().getDecorView());
    }

    public Object getLastCustomNonConfigurationInstance() {
        c cVar = (c) getLastNonConfigurationInstance();
        if (cVar != null) {
            return cVar.f13038a;
        }
        return null;
    }

    public k getSupportFragmentManager() {
        return this.mFragments.y();
    }

    public o getSupportLoaderManager() {
        return this.mFragments.z();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.A();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            int x = this.mFragments.x();
            if (x != 0 && i4 >= 0 && i4 < x) {
                Fragment fragment = this.mFragments.w(new ArrayList(x)).get(i4);
                if (fragment == null) {
                    Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                    return;
                }
                fragment.p0(i & 65535, i2, intent);
                return;
            }
            Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.mFragments.y().e()) {
            return;
        }
        supportFinishAfterTransition();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.d(configuration);
    }

    @Override // d.b.g0.m.a.a.f, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        this.mFragments.a(null);
        super.onCreate(bundle);
        c cVar = (c) getLastNonConfigurationInstance();
        if (cVar != null) {
            this.mFragments.E(cVar.f13040c);
        }
        if (bundle != null) {
            this.mFragments.D(bundle.getParcelable("android:support:fragments"), cVar != null ? cVar.f13039b : null);
        }
        this.mFragments.f();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.mFragments.g(menu, getMenuInflater());
            if (Build.VERSION.SDK_INT >= 11) {
                return onCreatePanelMenu;
            }
            return true;
        }
        return super.onCreatePanelMenu(i, menu);
    }

    @Override // d.b.g0.m.a.a.g, android.app.Activity, android.view.LayoutInflater.Factory2
    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        doReallyStop(false);
        this.mFragments.h();
        this.mFragments.r();
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
        this.mFragments.i();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i != 0) {
            if (i != 6) {
                return false;
            }
            return this.mFragments.e(menuItem);
        }
        return this.mFragments.j(menuItem);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.A();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.mFragments.k(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            onResumeFragments();
        }
        this.mFragments.l();
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        onResumeFragments();
        this.mFragments.v();
    }

    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i == 0 && menu != null) {
            if (this.mOptionsMenuInvalidated) {
                this.mOptionsMenuInvalidated = false;
                menu.clear();
                onCreatePanelMenu(i, menu);
            }
            return onPrepareOptionsPanel(view, menu) | this.mFragments.m(menu);
        }
        return super.onPreparePanel(i, view, menu);
    }

    public void onReallyStop() {
        this.mFragments.t(this.mRetaining);
        this.mFragments.n();
    }

    @Override // android.app.Activity, d.b.g0.m.a.a.a.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        int i2 = (i >> 8) & 255;
        if (i2 != 0) {
            int i3 = i2 - 1;
            int x = this.mFragments.x();
            if (x != 0 && i3 >= 0 && i3 < x) {
                Fragment fragment = this.mFragments.w(new ArrayList(x)).get(i3);
                if (fragment == null) {
                    Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                    return;
                }
                fragment.F0(i & 255, strArr, iArr);
                return;
            }
            Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.mFragments.v();
    }

    public void onResumeFragments() {
        this.mFragments.o();
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        if (this.mStopped) {
            doReallyStop(true);
        }
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        List<Fragment> G = this.mFragments.G();
        f<String, o> F = this.mFragments.F();
        if (G == null && F == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        c cVar = new c();
        cVar.f13038a = onRetainCustomNonConfigurationInstance;
        cVar.f13039b = G;
        cVar.f13040c = F;
        return cVar;
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable H = this.mFragments.H();
        if (H != null) {
            bundle.putParcelable("android:support:fragments", H);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.mStopped = false;
        this.mReallyStopped = false;
        this.mHandler.removeMessages(1);
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.A();
        this.mFragments.v();
        this.mFragments.s();
        this.mFragments.p();
        this.mFragments.C();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.A();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        this.mHandler.sendEmptyMessage(1);
        this.mFragments.q();
    }

    public void setEnterSharedElementCallback(r rVar) {
        d.b.g0.m.a.a.a.i(this, rVar);
    }

    public void setExitSharedElementCallback(r rVar) {
        d.b.g0.m.a.a.a.j(this, rVar);
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
        } else if (((-65536) & i) == 0) {
            super.startActivityForResult(intent, ((fragment.j + 1) << 16) + (i & 65535));
        } else {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    public void supportFinishAfterTransition() {
        d.b.g0.m.a.a.a.f(this);
    }

    public void supportInvalidateOptionsMenu() {
        if (Build.VERSION.SDK_INT >= 11) {
            d.a(this);
        } else {
            this.mOptionsMenuInvalidated = true;
        }
    }

    public void supportPostponeEnterTransition() {
        d.b.g0.m.a.a.a.g(this);
    }

    public void supportStartPostponedEnterTransition() {
        d.b.g0.m.a.a.a.k(this);
    }

    @Override // d.b.g0.m.a.a.c.a
    public final void validateRequestPermissionsRequestCode(int i) {
        if (this.mRequestedPermissionsFromFragment) {
            this.mRequestedPermissionsFromFragment = false;
        } else if ((i & (-256)) != 0) {
            throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
        }
    }

    @Override // d.b.g0.m.a.a.f, android.app.Activity, android.view.LayoutInflater.Factory
    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }
}
