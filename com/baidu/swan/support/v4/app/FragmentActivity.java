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
import com.baidu.tieba.el4;
import com.baidu.tieba.gl4;
import com.baidu.tieba.gm4;
import com.baidu.tieba.hl4;
import com.baidu.tieba.ll4;
import com.baidu.tieba.ol4;
import com.baidu.tieba.pl4;
import com.baidu.tieba.ql4;
import com.baidu.tieba.ul4;
import com.bumptech.glide.load.engine.GlideException;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes3.dex */
public class FragmentActivity extends ll4 implements el4.b, gl4.a {
    public final Handler a = new a();
    public final ol4 b = ol4.b(new b());
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;

    /* loaded from: classes3.dex */
    public static final class c {
        public Object a;
        public List<Fragment> b;
        public gm4<String, ul4> c;
    }

    public void m(Fragment fragment) {
    }

    public Object q() {
        return null;
    }

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    super.handleMessage(message);
                    return;
                }
                FragmentActivity.this.p();
                FragmentActivity.this.b.v();
                return;
            }
            FragmentActivity fragmentActivity = FragmentActivity.this;
            if (fragmentActivity.e) {
                fragmentActivity.j(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends pl4<FragmentActivity> {
        public b() {
            super(FragmentActivity.this);
        }

        @Override // com.baidu.tieba.pl4, com.baidu.tieba.nl4
        @Nullable
        public View a(int i) {
            return FragmentActivity.this.findViewById(i);
        }

        @Override // com.baidu.tieba.pl4
        public void k(Fragment fragment) {
            FragmentActivity.this.m(fragment);
        }

        @Override // com.baidu.tieba.pl4
        public boolean q(Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        @Override // com.baidu.tieba.pl4, com.baidu.tieba.nl4
        public boolean b() {
            Window window = FragmentActivity.this.getWindow();
            if (window != null && window.peekDecorView() != null) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.pl4
        public LayoutInflater m() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        @Override // com.baidu.tieba.pl4
        public int n() {
            Window window = FragmentActivity.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // com.baidu.tieba.pl4
        public boolean o() {
            if (FragmentActivity.this.getWindow() != null) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.pl4
        public void s() {
            FragmentActivity.this.u();
        }

        @Override // com.baidu.tieba.pl4
        public void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // com.baidu.tieba.pl4
        public void p(@NonNull Fragment fragment, @NonNull String[] strArr, int i) {
            FragmentActivity.this.r(fragment, strArr, i);
        }

        @Override // com.baidu.tieba.pl4
        public void r(Fragment fragment, Intent intent, int i) {
            FragmentActivity.this.s(fragment, intent, i);
        }
    }

    public ql4 l() {
        return this.b.y();
    }

    public void o() {
        this.b.t(this.g);
        this.b.n();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (!this.b.y().f()) {
            t();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        j(false);
        this.b.h();
        this.b.r();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.b.i();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.d = false;
        if (this.a.hasMessages(2)) {
            this.a.removeMessages(2);
            p();
        }
        this.b.l();
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.a.removeMessages(2);
        p();
        this.b.v();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.a.sendEmptyMessage(2);
        this.d = true;
        this.b.v();
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        if (this.e) {
            j(true);
        }
        Object q = q();
        List<Fragment> F = this.b.F();
        gm4<String, ul4> E = this.b.E();
        if (F == null && E == null && q == null) {
            return null;
        }
        c cVar = new c();
        cVar.a = q;
        cVar.b = F;
        cVar.c = E;
        return cVar;
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.b.z();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.e = true;
        this.a.sendEmptyMessage(1);
        this.b.q();
    }

    public void p() {
        this.b.o();
    }

    public void t() {
        el4.e(this);
    }

    public void u() {
        if (Build.VERSION.SDK_INT >= 11) {
            hl4.a(this);
        } else {
            this.h = true;
        }
    }

    @Override // com.baidu.tieba.kl4
    public final View h(View view2, String str, Context context, AttributeSet attributeSet) {
        return this.b.A(view2, str, context, attributeSet);
    }

    public static String x(View view2) {
        char c2;
        char c3;
        char c4;
        char c5;
        char c6;
        char c7;
        char c8;
        String str;
        StringBuilder sb = new StringBuilder(128);
        sb.append(view2.getClass().getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(view2)));
        sb.append(WebvttCueParser.CHAR_SPACE);
        int visibility = view2.getVisibility();
        char c9 = 'V';
        char c10 = IStringUtil.EXTENSION_SEPARATOR;
        if (visibility != 0) {
            if (visibility != 4) {
                if (visibility != 8) {
                    sb.append(IStringUtil.EXTENSION_SEPARATOR);
                } else {
                    sb.append('G');
                }
            } else {
                sb.append('I');
            }
        } else {
            sb.append('V');
        }
        char c11 = 'F';
        if (view2.isFocusable()) {
            c2 = 'F';
        } else {
            c2 = IStringUtil.EXTENSION_SEPARATOR;
        }
        sb.append(c2);
        if (view2.isEnabled()) {
            c3 = 'E';
        } else {
            c3 = IStringUtil.EXTENSION_SEPARATOR;
        }
        sb.append(c3);
        if (view2.willNotDraw()) {
            c4 = IStringUtil.EXTENSION_SEPARATOR;
        } else {
            c4 = 'D';
        }
        sb.append(c4);
        if (view2.isHorizontalScrollBarEnabled()) {
            c5 = 'H';
        } else {
            c5 = IStringUtil.EXTENSION_SEPARATOR;
        }
        sb.append(c5);
        if (!view2.isVerticalScrollBarEnabled()) {
            c9 = IStringUtil.EXTENSION_SEPARATOR;
        }
        sb.append(c9);
        if (view2.isClickable()) {
            c6 = 'C';
        } else {
            c6 = IStringUtil.EXTENSION_SEPARATOR;
        }
        sb.append(c6);
        if (view2.isLongClickable()) {
            c7 = 'L';
        } else {
            c7 = IStringUtil.EXTENSION_SEPARATOR;
        }
        sb.append(c7);
        sb.append(WebvttCueParser.CHAR_SPACE);
        if (!view2.isFocused()) {
            c11 = IStringUtil.EXTENSION_SEPARATOR;
        }
        sb.append(c11);
        if (view2.isSelected()) {
            c8 = 'S';
        } else {
            c8 = IStringUtil.EXTENSION_SEPARATOR;
        }
        sb.append(c8);
        if (view2.isPressed()) {
            c10 = 'P';
        }
        sb.append(c10);
        sb.append(WebvttCueParser.CHAR_SPACE);
        sb.append(view2.getLeft());
        sb.append(',');
        sb.append(view2.getTop());
        sb.append(SignatureImpl.SEP);
        sb.append(view2.getRight());
        sb.append(',');
        sb.append(view2.getBottom());
        int id = view2.getId();
        if (id != -1) {
            sb.append(" #");
            sb.append(Integer.toHexString(id));
            Resources resources = view2.getResources();
            if (id != 0 && resources != null) {
                int i = (-16777216) & id;
                if (i != 16777216) {
                    if (i != 2130706432) {
                        try {
                            str = resources.getResourcePackageName(id);
                        } catch (Resources.NotFoundException unused) {
                        }
                    } else {
                        str = "app";
                    }
                } else {
                    str = "android";
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

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + GlideException.IndentedAppendable.INDENT;
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.c);
        printWriter.print("mResumed=");
        printWriter.print(this.d);
        printWriter.print(" mStopped=");
        printWriter.print(this.e);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.f);
        this.b.u(str2, fileDescriptor, printWriter, strArr);
        this.b.y().b(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        k(str + GlideException.IndentedAppendable.INDENT, printWriter, getWindow().getDecorView());
    }

    public void j(boolean z) {
        if (!this.f) {
            this.f = true;
            this.g = z;
            this.a.removeMessages(1);
            o();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.b.d(configuration);
    }

    @Override // com.baidu.tieba.kl4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        List<Fragment> list = null;
        this.b.a(null);
        super.onCreate(bundle);
        c cVar = (c) getLastNonConfigurationInstance();
        if (cVar != null) {
            this.b.D(cVar.c);
        }
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable(androidx.fragment.app.FragmentActivity.FRAGMENTS_TAG);
            ol4 ol4Var = this.b;
            if (cVar != null) {
                list = cVar.b;
            }
            ol4Var.C(parcelable, list);
        }
        this.b.f();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.b.z();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable G = this.b.G();
        if (G != null) {
            bundle.putParcelable(androidx.fragment.app.FragmentActivity.FRAGMENTS_TAG, G);
        }
    }

    @Override // com.baidu.tieba.gl4.a
    public final void validateRequestPermissionsRequestCode(int i) {
        if (this.i) {
            this.i = false;
        } else if ((i & (-256)) == 0) {
        } else {
            throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
        }
    }

    public final void k(String str, PrintWriter printWriter, View view2) {
        ViewGroup viewGroup;
        int childCount;
        printWriter.print(str);
        if (view2 == null) {
            printWriter.println(StringUtil.NULL_STRING);
            return;
        }
        printWriter.println(x(view2));
        if (!(view2 instanceof ViewGroup) || (childCount = (viewGroup = (ViewGroup) view2).getChildCount()) <= 0) {
            return;
        }
        String str2 = str + GlideException.IndentedAppendable.INDENT;
        for (int i = 0; i < childCount; i++) {
            k(str2, printWriter, viewGroup.getChildAt(i));
        }
    }

    public boolean n(View view2, Menu menu) {
        return super.onPreparePanel(0, view2, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.b.g(menu, getMenuInflater());
            if (Build.VERSION.SDK_INT >= 11) {
                return onCreatePanelMenu;
            }
            return true;
        }
        return super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT < 5 && i == 4 && keyEvent.getRepeatCount() == 0) {
            onBackPressed();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
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
            return this.b.e(menuItem);
        }
        return this.b.j(menuItem);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.b.k(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (i != -1 && ((-65536) & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.b.z();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            int x = this.b.x();
            if (x != 0 && i4 >= 0 && i4 < x) {
                Fragment fragment = this.b.w(new ArrayList(x)).get(i4);
                if (fragment == null) {
                    Log.w(androidx.fragment.app.FragmentActivity.TAG, "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                    return;
                }
                fragment.s0(i & 65535, i2, intent);
                return;
            }
            Log.w(androidx.fragment.app.FragmentActivity.TAG, "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view2, Menu menu) {
        if (i == 0 && menu != null) {
            if (this.h) {
                this.h = false;
                menu.clear();
                onCreatePanelMenu(i, menu);
            }
            return n(view2, menu) | this.b.m(menu);
        }
        return super.onPreparePanel(i, view2, menu);
    }

    public final void r(Fragment fragment, String[] strArr, int i) {
        if (i == -1) {
            el4.requestPermissions(this, strArr, i);
        } else if ((i & (-256)) == 0) {
            this.i = true;
            el4.requestPermissions(this, strArr, ((fragment.f + 1) << 8) + (i & 255));
        } else {
            throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
        }
    }

    public void s(Fragment fragment, Intent intent, int i) {
        if (i == -1) {
            super.startActivityForResult(intent, -1);
        } else if (((-65536) & i) == 0) {
            super.startActivityForResult(intent, ((fragment.f + 1) << 16) + (i & 65535));
        } else {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    @Override // android.app.Activity, com.baidu.tieba.el4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        int i2 = (i >> 8) & 255;
        if (i2 != 0) {
            int i3 = i2 - 1;
            int x = this.b.x();
            if (x != 0 && i3 >= 0 && i3 < x) {
                Fragment fragment = this.b.w(new ArrayList(x)).get(i3);
                if (fragment == null) {
                    Log.w(androidx.fragment.app.FragmentActivity.TAG, "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                    return;
                }
                fragment.K0(i & 255, strArr, iArr);
                return;
            }
            Log.w(androidx.fragment.app.FragmentActivity.TAG, "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.e = false;
        this.f = false;
        this.a.removeMessages(1);
        if (!this.c) {
            this.c = true;
            this.b.c();
        }
        this.b.z();
        this.b.v();
        this.b.s();
        this.b.p();
        this.b.B();
    }
}
