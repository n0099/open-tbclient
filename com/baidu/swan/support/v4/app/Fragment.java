package com.baidu.swan.support.v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.baidu.tieba.gm4;
import com.baidu.tieba.jm4;
import com.baidu.tieba.lm4;
import com.baidu.tieba.ql4;
import com.baidu.tieba.sl4;
import com.baidu.tieba.tl4;
import com.baidu.tieba.ul4;
import com.baidu.tieba.yl4;
import com.bumptech.glide.load.engine.GlideException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes3.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener {
    public static final jm4<String, Class<?>> Z = new jm4<>();
    public static final Object a0 = new Object();
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean F;
    public int G;
    public ViewGroup H;
    public View I;
    public View J;
    public boolean K;
    public yl4 M;
    public boolean N;
    public boolean O;
    public Object Q;
    public Object R;
    public Object S;
    public Object T;
    public Object U;
    public Boolean V;
    public Boolean W;
    public SharedElementCallback X;
    public SharedElementCallback Y;
    public View b;
    public int c;
    public Bundle d;
    public SparseArray<Parcelable> e;
    public String g;
    public Bundle h;
    public Fragment i;
    public int k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public ul4 s;
    public sl4 t;
    public ul4 u;
    public Fragment v;
    public int w;
    public int x;
    public String y;
    public boolean z;
    public int a = 0;
    public int f = -1;
    public int j = -1;
    public boolean E = true;
    public boolean L = true;
    public Object P = null;

    public void B0() {
    }

    public void E0(boolean z) {
    }

    public boolean H0(MenuItem menuItem) {
        return false;
    }

    public void I0(Menu menu) {
    }

    public void J0(Menu menu) {
    }

    public void K0(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
    }

    public void L0(Bundle bundle) {
    }

    public void O0(View view2, @Nullable Bundle bundle) {
    }

    public void s0(int i, int i2, Intent intent) {
    }

    public boolean v0(MenuItem menuItem) {
        return false;
    }

    public Animation x0(int i, boolean z, int i2) {
        return null;
    }

    public void y0(Menu menu, MenuInflater menuInflater) {
    }

    @Nullable
    public View z0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return null;
    }

    /* loaded from: classes3.dex */
    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* loaded from: classes3.dex */
    public class a extends ql4 {
        public a() {
        }

        @Override // com.baidu.tieba.ql4
        @Nullable
        public View a(int i) {
            View view2 = Fragment.this.I;
            if (view2 != null) {
                return view2.findViewById(i);
            }
            throw new IllegalStateException("Fragment does not have a view");
        }

        @Override // com.baidu.tieba.ql4
        public boolean b() {
            if (Fragment.this.I != null) {
                return true;
            }
            return false;
        }
    }

    public Fragment() {
        Object obj = a0;
        this.Q = obj;
        this.R = null;
        this.S = obj;
        this.T = null;
        this.U = obj;
        this.X = null;
        this.Y = null;
    }

    public void A0() {
        this.F = true;
        if (!this.O) {
            this.O = true;
            this.M = this.t.i(this.g, this.N, false);
        }
        yl4 yl4Var = this.M;
        if (yl4Var != null) {
            yl4Var.b();
        }
    }

    public final tl4 B() {
        return this.s;
    }

    public void C0() {
        this.F = true;
    }

    public void D0() {
        this.F = true;
    }

    public Object E() {
        Object obj = this.S;
        if (obj == a0) {
            return u();
        }
        return obj;
    }

    public Object F() {
        Object obj = this.Q;
        if (obj == a0) {
            return t();
        }
        return obj;
    }

    public Object G() {
        return this.T;
    }

    public Object H() {
        Object obj = this.U;
        if (obj == a0) {
            return G();
        }
        return obj;
    }

    public void M0() {
        this.F = true;
        if (!this.N) {
            this.N = true;
            if (!this.O) {
                this.O = true;
                this.M = this.t.i(this.g, true, false);
            }
            yl4 yl4Var = this.M;
            if (yl4Var != null) {
                yl4Var.f();
            }
        }
    }

    public void N0() {
        this.F = true;
    }

    public final Fragment S() {
        return this.i;
    }

    public final int U() {
        return this.k;
    }

    public void X0() {
        ul4 ul4Var = this.u;
        if (ul4Var != null) {
            ul4Var.s();
        }
        this.F = false;
        A0();
        if (this.F) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public void Z0() {
        onLowMemory();
        ul4 ul4Var = this.u;
        if (ul4Var != null) {
            ul4Var.u();
        }
    }

    public boolean a0() {
        return this.L;
    }

    @Nullable
    public View b0() {
        return this.I;
    }

    public void d0() {
        this.f = -1;
        this.g = null;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = 0;
        this.s = null;
        this.u = null;
        this.t = null;
        this.w = 0;
        this.x = 0;
        this.y = null;
        this.z = false;
        this.A = false;
        this.C = false;
        this.M = null;
        this.N = false;
        this.O = false;
    }

    public void d1() {
        ul4 ul4Var = this.u;
        if (ul4Var != null) {
            ul4Var.x();
        }
        this.F = false;
        onPause();
        if (this.F) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }

    public void f1() {
        ul4 ul4Var = this.u;
        if (ul4Var != null) {
            ul4Var.z();
        }
        if (this.N) {
            this.N = false;
            if (!this.O) {
                this.O = true;
                this.M = this.t.i(this.g, false, false);
            }
            yl4 yl4Var = this.M;
            if (yl4Var != null) {
                if (!this.C) {
                    yl4Var.g();
                } else {
                    yl4Var.e();
                }
            }
        }
    }

    public final FragmentActivity getActivity() {
        sl4 sl4Var = this.t;
        if (sl4Var == null) {
            return null;
        }
        return (FragmentActivity) sl4Var.getActivity();
    }

    public Context getContext() {
        sl4 sl4Var = this.t;
        if (sl4Var == null) {
            return null;
        }
        return sl4Var.getContext();
    }

    public final Resources getResources() {
        sl4 sl4Var = this.t;
        if (sl4Var != null) {
            return sl4Var.getContext().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void j1() {
        ul4 ul4Var = this.u;
        if (ul4Var != null) {
            ul4Var.C();
        }
        this.F = false;
        N0();
        if (this.F) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }

    public void l0() {
        ul4 ul4Var = new ul4();
        this.u = ul4Var;
        ul4Var.j(this.t, new a(), this);
    }

    public final boolean m0() {
        if (this.t != null && this.l) {
            return true;
        }
        return false;
    }

    public boolean n() {
        Boolean bool = this.W;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public final boolean n0() {
        return this.A;
    }

    public boolean o() {
        Boolean bool = this.V;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public final boolean o0() {
        return this.z;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.F = true;
    }

    public void onPause() {
        this.F = true;
    }

    public void onResume() {
        this.F = true;
    }

    public final Bundle p() {
        return this.h;
    }

    public final boolean p0() {
        if (this.r > 0) {
            return true;
        }
        return false;
    }

    public final tl4 q() {
        if (this.u == null) {
            l0();
            int i = this.a;
            if (i >= 5) {
                this.u.A();
            } else if (i >= 4) {
                this.u.B();
            } else if (i >= 2) {
                this.u.n();
            } else if (i >= 1) {
                this.u.q();
            }
        }
        return this.u;
    }

    public Object t() {
        return this.P;
    }

    public Object u() {
        return this.R;
    }

    /* loaded from: classes3.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public final Bundle mState;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* loaded from: classes3.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Bundle bundle) {
            this.mState = bundle;
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle readBundle = parcel.readBundle();
            this.mState = readBundle;
            if (classLoader != null && readBundle != null) {
                readBundle.setClassLoader(classLoader);
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.mState);
        }
    }

    public static Fragment g0(Context context, String str) {
        return k0(context, str, null);
    }

    public static boolean q0(Context context, String str) {
        try {
            Class<?> cls = Z.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                Z.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final String P(@StringRes int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public boolean V0(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.z) {
            return false;
        }
        if (this.D && this.E) {
            y0(menu, menuInflater);
            z = true;
        }
        ul4 ul4Var = this.u;
        if (ul4Var != null) {
            return z | ul4Var.r(menu, menuInflater);
        }
        return z;
    }

    public void n1(Fragment fragment, int i) {
        this.i = fragment;
        this.k = i;
    }

    public final void requestPermissions(@NonNull String[] strArr, int i) {
        sl4 sl4Var = this.t;
        if (sl4Var != null) {
            sl4Var.p(this, strArr, i);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startActivityForResult(Intent intent, int i) {
        sl4 sl4Var = this.t;
        if (sl4Var != null) {
            sl4Var.r(this, intent, i);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public static Fragment k0(Context context, String str, @Nullable Bundle bundle) {
        try {
            Class<?> cls = Z.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                Z.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.h = bundle;
            }
            return fragment;
        } catch (ClassNotFoundException e) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (IllegalAccessException e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (java.lang.InstantiationException e3) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        }
    }

    public LayoutInflater D(Bundle bundle) {
        LayoutInflater m = this.t.m();
        q();
        ul4 ul4Var = this.u;
        ul4Var.J();
        lm4.a(m, ul4Var);
        return m;
    }

    public final String N(@StringRes int i) {
        return getResources().getString(i);
    }

    public void P0(@Nullable Bundle bundle) {
        this.F = true;
    }

    public void S0(Configuration configuration) {
        onConfigurationChanged(configuration);
        ul4 ul4Var = this.u;
        if (ul4Var != null) {
            ul4Var.o(configuration);
        }
    }

    public boolean T0(MenuItem menuItem) {
        if (!this.z) {
            if (v0(menuItem)) {
                return true;
            }
            ul4 ul4Var = this.u;
            if (ul4Var != null && ul4Var.p(menuItem)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final CharSequence V(@StringRes int i) {
        return getResources().getText(i);
    }

    public boolean a1(MenuItem menuItem) {
        if (!this.z) {
            if (this.D && this.E && H0(menuItem)) {
                return true;
            }
            ul4 ul4Var = this.u;
            if (ul4Var != null && ul4Var.v(menuItem)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public void b1(Menu menu) {
        if (!this.z) {
            if (this.D && this.E) {
                I0(menu);
            }
            ul4 ul4Var = this.u;
            if (ul4Var != null) {
                ul4Var.w(menu);
            }
        }
    }

    public boolean e1(Menu menu) {
        boolean z = false;
        if (this.z) {
            return false;
        }
        if (this.D && this.E) {
            J0(menu);
            z = true;
        }
        ul4 ul4Var = this.u;
        if (ul4Var != null) {
            return z | ul4Var.y(menu);
        }
        return z;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void h1(Bundle bundle) {
        Parcelable e0;
        L0(bundle);
        ul4 ul4Var = this.u;
        if (ul4Var != null && (e0 = ul4Var.e0()) != null) {
            bundle.putParcelable(androidx.fragment.app.FragmentActivity.FRAGMENTS_TAG, e0);
        }
    }

    public void l1(Bundle bundle) {
        if (this.f < 0) {
            this.h = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already active");
    }

    public void o1(boolean z) {
        if (!this.L && z && this.a < 4) {
            this.s.W(this);
        }
        this.L = z;
        this.K = !z;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.F = true;
    }

    public void r0(@Nullable Bundle bundle) {
        this.F = true;
    }

    public void startActivity(Intent intent) {
        sl4 sl4Var = this.t;
        if (sl4Var != null) {
            sl4Var.r(this, intent, -1);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void t0(Activity activity) {
        this.F = true;
    }

    public void u0(Context context) {
        Activity activity;
        this.F = true;
        sl4 sl4Var = this.t;
        if (sl4Var == null) {
            activity = null;
        } else {
            activity = sl4Var.getActivity();
        }
        if (activity != null) {
            this.F = false;
            t0(activity);
        }
    }

    public void w0(@Nullable Bundle bundle) {
        this.F = true;
    }

    @Deprecated
    public void F0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.F = true;
    }

    public void G0(Context context, AttributeSet attributeSet, Bundle bundle) {
        Activity activity;
        this.F = true;
        sl4 sl4Var = this.t;
        if (sl4Var == null) {
            activity = null;
        } else {
            activity = sl4Var.getActivity();
        }
        if (activity != null) {
            this.F = false;
            F0(activity, attributeSet, bundle);
        }
    }

    public View W0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ul4 ul4Var = this.u;
        if (ul4Var != null) {
            ul4Var.V();
        }
        return z0(layoutInflater, viewGroup, bundle);
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view2, ContextMenu.ContextMenuInfo contextMenuInfo) {
        getActivity().onCreateContextMenu(contextMenu, view2, contextMenuInfo);
    }

    public void Q0(Bundle bundle) {
        ul4 ul4Var = this.u;
        if (ul4Var != null) {
            ul4Var.V();
        }
        this.F = false;
        r0(bundle);
        if (this.F) {
            ul4 ul4Var2 = this.u;
            if (ul4Var2 != null) {
                ul4Var2.n();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public final void k1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.e;
        if (sparseArray != null) {
            this.J.restoreHierarchyState(sparseArray);
            this.e = null;
        }
        this.F = false;
        P0(bundle);
        if (this.F) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    public void U0(Bundle bundle) {
        Parcelable parcelable;
        ul4 ul4Var = this.u;
        if (ul4Var != null) {
            ul4Var.V();
        }
        this.F = false;
        w0(bundle);
        if (this.F) {
            if (bundle != null && (parcelable = bundle.getParcelable(androidx.fragment.app.FragmentActivity.FRAGMENTS_TAG)) != null) {
                if (this.u == null) {
                    l0();
                }
                this.u.b0(parcelable, null);
                this.u.q();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    public void Y0() {
        ul4 ul4Var = this.u;
        if (ul4Var != null) {
            ul4Var.t();
        }
        this.F = false;
        C0();
        if (this.F) {
            yl4 yl4Var = this.M;
            if (yl4Var != null) {
                yl4Var.c();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    public void g1() {
        ul4 ul4Var = this.u;
        if (ul4Var != null) {
            ul4Var.V();
            this.u.E();
        }
        this.F = false;
        onResume();
        if (this.F) {
            ul4 ul4Var2 = this.u;
            if (ul4Var2 != null) {
                ul4Var2.A();
                this.u.E();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
    }

    public void i1() {
        ul4 ul4Var = this.u;
        if (ul4Var != null) {
            ul4Var.V();
            this.u.E();
        }
        this.F = false;
        M0();
        if (this.F) {
            ul4 ul4Var2 = this.u;
            if (ul4Var2 != null) {
                ul4Var2.B();
            }
            yl4 yl4Var = this.M;
            if (yl4Var != null) {
                yl4Var.d();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        gm4.a(this, sb);
        if (this.f >= 0) {
            sb.append(" #");
            sb.append(this.f);
        }
        if (this.w != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.w));
        }
        if (this.y != null) {
            sb.append(" ");
            sb.append(this.y);
        }
        sb.append('}');
        return sb.toString();
    }

    public void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.w));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.x));
        printWriter.print(" mTag=");
        printWriter.println(this.y);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.a);
        printWriter.print(" mIndex=");
        printWriter.print(this.f);
        printWriter.print(" mWho=");
        printWriter.print(this.g);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.m);
        printWriter.print(" mResumed=");
        printWriter.print(this.n);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.o);
        printWriter.print(" mInLayout=");
        printWriter.println(this.p);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.z);
        printWriter.print(" mDetached=");
        printWriter.print(this.A);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.E);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.D);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.B);
        printWriter.print(" mRetaining=");
        printWriter.print(this.C);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.L);
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.s);
        }
        if (this.t != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.t);
        }
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.v);
        }
        if (this.h != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.h);
        }
        if (this.d != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.d);
        }
        if (this.e != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.e);
        }
        if (this.i != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.i);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.k);
        }
        if (this.G != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.G);
        }
        if (this.H != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.H);
        }
        if (this.I != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.I);
        }
        if (this.J != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.I);
        }
        if (this.b != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.b);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.c);
        }
        if (this.M != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            yl4 yl4Var = this.M;
            yl4Var.h(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
        }
        if (this.u != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.u + ":");
            ul4 ul4Var = this.u;
            ul4Var.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
        }
    }

    public final void m1(int i, Fragment fragment) {
        this.f = i;
        if (fragment != null) {
            this.g = fragment.g + ":" + this.f;
            return;
        }
        this.g = "android:fragment:" + this.f;
    }
}
