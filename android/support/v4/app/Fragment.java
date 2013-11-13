package android.support.v4.app;

import android.app.Activity;
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
import com.baidu.zeus.bouncycastle.DERTags;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, Class<?>> f275a = new HashMap<>();
    int A;
    v B;
    n C;
    v D;
    Fragment E;
    int F;
    int G;
    String H;
    boolean I;
    boolean J;
    boolean K;
    boolean L;
    boolean M;
    boolean O;
    int P;
    ViewGroup Q;
    View R;
    View S;
    boolean T;
    aj V;
    boolean W;
    boolean X;
    View k;
    int l;
    Bundle m;
    SparseArray<Parcelable> n;
    String p;
    Bundle q;
    Fragment r;
    int t;
    boolean u;
    boolean v;
    boolean w;
    boolean x;
    boolean y;
    boolean z;
    int j = 0;
    int o = -1;
    int s = -1;
    boolean N = true;
    boolean U = true;

    /* loaded from: classes.dex */
    public class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new m();

        /* renamed from: a  reason: collision with root package name */
        final Bundle f276a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            this.f276a = parcel.readBundle();
            if (classLoader != null && this.f276a != null) {
                this.f276a.setClassLoader(classLoader);
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f276a);
        }
    }

    /* loaded from: classes.dex */
    public class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    public static Fragment a(Context context, String str) {
        return a(context, str, (Bundle) null);
    }

    public static Fragment a(Context context, String str, Bundle bundle) {
        try {
            Class<?> cls = f275a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f275a.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.q = bundle;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(Bundle bundle) {
        if (this.n != null) {
            this.S.restoreHierarchyState(this.n);
            this.n = null;
        }
        this.O = false;
        h(bundle);
        if (!this.O) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, Fragment fragment) {
        this.o = i;
        if (fragment != null) {
            this.p = fragment.p + ":" + this.o;
        } else {
            this.p = "android:fragment:" + this.o;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean f() {
        return this.A > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) DERTags.TAGGED);
        android.support.v4.b.a.a(this, sb);
        if (this.o >= 0) {
            sb.append(" #");
            sb.append(this.o);
        }
        if (this.F != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.F));
        }
        if (this.H != null) {
            sb.append(" ");
            sb.append(this.H);
        }
        sb.append('}');
        return sb.toString();
    }

    public final String g() {
        return this.H;
    }

    public void g(Bundle bundle) {
        if (this.o >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.q = bundle;
    }

    public final Bundle h() {
        return this.q;
    }

    public final n i() {
        return this.C;
    }

    public final Resources j() {
        if (this.C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        return this.C.getResources();
    }

    public final String a(int i) {
        return j().getString(i);
    }

    public final t k() {
        return this.B;
    }

    public final t l() {
        if (this.D == null) {
            w();
            if (this.j >= 5) {
                this.D.m();
            } else if (this.j >= 4) {
                this.D.l();
            } else if (this.j >= 2) {
                this.D.k();
            } else if (this.j >= 1) {
                this.D.j();
            }
        }
        return this.D;
    }

    public final Fragment m() {
        return this.E;
    }

    public final boolean n() {
        return this.C != null && this.u;
    }

    public final boolean o() {
        return this.J;
    }

    public final boolean p() {
        return this.I;
    }

    public void b(boolean z) {
    }

    public void c(boolean z) {
        if (this.N != z) {
            this.N = z;
            if (this.M && n() && !p()) {
                this.C.supportInvalidateOptionsMenu();
            }
        }
    }

    public void d(boolean z) {
        if (!this.U && z && this.j < 4) {
            this.B.a(this);
        }
        this.U = z;
        this.T = !z;
    }

    public void a(int i, int i2, Intent intent) {
    }

    public LayoutInflater b(Bundle bundle) {
        return this.C.getLayoutInflater();
    }

    public void a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.O = true;
    }

    public void a(Activity activity) {
        this.O = true;
    }

    public Animation a(int i, boolean z, int i2) {
        return null;
    }

    public void a(Bundle bundle) {
        this.O = true;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void a(View view, Bundle bundle) {
    }

    public View q() {
        return this.R;
    }

    public void d(Bundle bundle) {
        this.O = true;
    }

    public void h(Bundle bundle) {
        this.O = true;
    }

    public void c_() {
        this.O = true;
        if (!this.W) {
            this.W = true;
            if (!this.X) {
                this.X = true;
                this.V = this.C.getLoaderManager(this.p, this.W, false);
            }
            if (this.V != null) {
                this.V.b();
            }
        }
    }

    public void r() {
        this.O = true;
    }

    public void e(Bundle bundle) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.O = true;
    }

    public void s() {
        this.O = true;
    }

    public void d() {
        this.O = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.O = true;
    }

    public void e() {
        this.O = true;
    }

    public void t() {
        this.O = true;
        if (!this.X) {
            this.X = true;
            this.V = this.C.getLoaderManager(this.p, this.W, false);
        }
        if (this.V != null) {
            this.V.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        this.o = -1;
        this.p = null;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = 0;
        this.B = null;
        this.C = null;
        this.F = 0;
        this.G = 0;
        this.H = null;
        this.I = false;
        this.J = false;
        this.L = false;
        this.V = null;
        this.W = false;
        this.X = false;
    }

    public void b() {
        this.O = true;
    }

    public void a(Menu menu, MenuInflater menuInflater) {
    }

    public void a(Menu menu) {
    }

    public void v() {
    }

    public boolean a(MenuItem menuItem) {
        return false;
    }

    public void b(Menu menu) {
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        i().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public boolean b(MenuItem menuItem) {
        return false;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.F));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.G));
        printWriter.print(" mTag=");
        printWriter.println(this.H);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.j);
        printWriter.print(" mIndex=");
        printWriter.print(this.o);
        printWriter.print(" mWho=");
        printWriter.print(this.p);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.A);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.u);
        printWriter.print(" mRemoving=");
        printWriter.print(this.v);
        printWriter.print(" mResumed=");
        printWriter.print(this.w);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.x);
        printWriter.print(" mInLayout=");
        printWriter.println(this.y);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.I);
        printWriter.print(" mDetached=");
        printWriter.print(this.J);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.N);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.M);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.K);
        printWriter.print(" mRetaining=");
        printWriter.print(this.L);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.U);
        if (this.B != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.B);
        }
        if (this.C != null) {
            printWriter.print(str);
            printWriter.print("mActivity=");
            printWriter.println(this.C);
        }
        if (this.E != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.E);
        }
        if (this.q != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.q);
        }
        if (this.m != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.m);
        }
        if (this.n != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.n);
        }
        if (this.r != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.r);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.t);
        }
        if (this.P != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.P);
        }
        if (this.Q != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.Q);
        }
        if (this.R != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.R);
        }
        if (this.S != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.R);
        }
        if (this.k != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.k);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.l);
        }
        if (this.V != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.V.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.D != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.D + ":");
            this.D.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    void w() {
        this.D = new v();
        this.D.a(this.C, new l(this), this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Bundle bundle) {
        Parcelable parcelable;
        if (this.D != null) {
            this.D.i();
        }
        this.O = false;
        a(bundle);
        if (!this.O) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
        }
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            if (this.D == null) {
                w();
            }
            this.D.a(parcelable, (ArrayList<Fragment>) null);
            this.D.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.D != null) {
            this.D.i();
        }
        return a(layoutInflater, viewGroup, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Bundle bundle) {
        if (this.D != null) {
            this.D.i();
        }
        this.O = false;
        d(bundle);
        if (!this.O) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
        if (this.D != null) {
            this.D.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x() {
        if (this.D != null) {
            this.D.i();
            this.D.e();
        }
        this.O = false;
        c_();
        if (!this.O) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
        }
        if (this.D != null) {
            this.D.l();
        }
        if (this.V != null) {
            this.V.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        if (this.D != null) {
            this.D.i();
            this.D.e();
        }
        this.O = false;
        r();
        if (!this.O) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        }
        if (this.D != null) {
            this.D.m();
            this.D.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.D != null) {
            this.D.a(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z() {
        onLowMemory();
        if (this.D != null) {
            this.D.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.I) {
            return false;
        }
        if (this.M && this.N) {
            z = true;
            a(menu, menuInflater);
        }
        if (this.D != null) {
            return z | this.D.a(menu, menuInflater);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(Menu menu) {
        boolean z = false;
        if (this.I) {
            return false;
        }
        if (this.M && this.N) {
            z = true;
            a(menu);
        }
        if (this.D != null) {
            return z | this.D.a(menu);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(MenuItem menuItem) {
        if (!this.I) {
            if (this.M && this.N && a(menuItem)) {
                return true;
            }
            if (this.D != null && this.D.a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(MenuItem menuItem) {
        if (!this.I) {
            if (b(menuItem)) {
                return true;
            }
            if (this.D != null && this.D.b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Menu menu) {
        if (!this.I) {
            if (this.M && this.N) {
                b(menu);
            }
            if (this.D != null) {
                this.D.b(menu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Bundle bundle) {
        Parcelable h;
        e(bundle);
        if (this.D != null && (h = this.D.h()) != null) {
            bundle.putParcelable("android:support:fragments", h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        if (this.D != null) {
            this.D.n();
        }
        this.O = false;
        s();
        if (!this.O) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        if (this.D != null) {
            this.D.o();
        }
        this.O = false;
        d();
        if (!this.O) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C() {
        if (this.D != null) {
            this.D.p();
        }
        if (this.W) {
            this.W = false;
            if (!this.X) {
                this.X = true;
                this.V = this.C.getLoaderManager(this.p, this.W, false);
            }
            if (this.V != null) {
                if (!this.C.mRetaining) {
                    this.V.c();
                } else {
                    this.V.d();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D() {
        if (this.D != null) {
            this.D.q();
        }
        this.O = false;
        e();
        if (!this.O) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        }
        if (this.V != null) {
            this.V.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E() {
        if (this.D != null) {
            this.D.r();
        }
        this.O = false;
        t();
        if (!this.O) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }
}
