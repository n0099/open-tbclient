package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
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
import com.baidu.android.common.util.HanziToPinyin;
import com.baidu.zeus.bouncycastle.DERTags;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;
/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener {
    private static final HashMap a = new HashMap();
    m A;
    g B;
    int C;
    int D;
    String E;
    boolean F;
    boolean G;
    boolean H;
    boolean I;
    boolean J;
    boolean L;
    int M;
    ViewGroup N;
    View O;
    View P;
    boolean Q;
    y S;
    boolean T;
    boolean U;
    View j;
    int k;
    Bundle l;
    SparseArray m;
    String o;
    Bundle p;
    Fragment q;
    int s;
    boolean t;
    boolean u;
    boolean v;
    boolean w;
    boolean x;
    boolean y;
    int z;
    int i = 0;
    int n = -1;
    int r = -1;
    boolean K = true;
    boolean R = true;

    /* loaded from: classes.dex */
    public class SavedState implements Parcelable {
        public static final Parcelable.Creator CREATOR = new f();
        final Bundle a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            this.a = parcel.readBundle();
            if (classLoader != null && this.a != null) {
                this.a.setClassLoader(classLoader);
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.a);
        }
    }

    public static Fragment a(Context context, String str) {
        return a(context, str, (Bundle) null);
    }

    public static Fragment a(Context context, String str, Bundle bundle) {
        try {
            Class<?> cls = (Class) a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                a.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.p = bundle;
            }
            return fragment;
        } catch (ClassNotFoundException e) {
            throw new e("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (IllegalAccessException e2) {
            throw new e("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (InstantiationException e3) {
            throw new e("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        if (this.m != null) {
            this.P.restoreHierarchyState(this.m);
            this.m = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        this.n = i;
        this.o = "android:fragment:" + this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean f() {
        return this.z > 0;
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
        if (this.n >= 0) {
            sb.append(" #");
            sb.append(this.n);
        }
        if (this.C != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.C));
        }
        if (this.E != null) {
            sb.append(HanziToPinyin.Token.SEPARATOR);
            sb.append(this.E);
        }
        sb.append('}');
        return sb.toString();
    }

    public final g g() {
        return this.B;
    }

    public final k h() {
        return this.A;
    }

    public void b(boolean z) {
    }

    public void a(int i, int i2, Intent intent) {
    }

    public LayoutInflater b(Bundle bundle) {
        return this.B.getLayoutInflater();
    }

    public void a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.L = true;
    }

    public void a(Activity activity) {
        this.L = true;
    }

    public Animation a(int i, boolean z, int i2) {
        return null;
    }

    public void a(Bundle bundle) {
        this.L = true;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void a(View view, Bundle bundle) {
    }

    public View i() {
        return this.O;
    }

    public void d(Bundle bundle) {
        this.L = true;
    }

    public void b() {
        this.L = true;
        if (!this.T) {
            this.T = true;
            if (!this.U) {
                this.U = true;
                this.S = this.B.getLoaderManager(this.n, this.T, false);
            }
            if (this.S != null) {
                this.S.b();
            }
        }
    }

    public void j() {
        this.L = true;
    }

    public void e(Bundle bundle) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.L = true;
    }

    public void k() {
        this.L = true;
    }

    public void c() {
        this.L = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.L = true;
    }

    public void d() {
        this.L = true;
    }

    public void l() {
        this.L = true;
        if (!this.U) {
            this.U = true;
            this.S = this.B.getLoaderManager(this.n, this.T, false);
        }
        if (this.S != null) {
            this.S.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        this.n = -1;
        this.o = null;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = 0;
        this.A = null;
        this.B = null;
        this.C = 0;
        this.D = 0;
        this.E = null;
        this.F = false;
        this.G = false;
        this.I = false;
        this.S = null;
        this.T = false;
        this.U = false;
    }

    public void n() {
        this.L = true;
    }

    public void a(Menu menu, MenuInflater menuInflater) {
    }

    public void a(Menu menu) {
    }

    public void o() {
    }

    public boolean a(MenuItem menuItem) {
        return false;
    }

    public void b(Menu menu) {
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        g().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public boolean b(MenuItem menuItem) {
        return false;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.C));
        printWriter.print(" mContainerId#=");
        printWriter.print(Integer.toHexString(this.D));
        printWriter.print(" mTag=");
        printWriter.println(this.E);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.i);
        printWriter.print(" mIndex=");
        printWriter.print(this.n);
        printWriter.print(" mWho=");
        printWriter.print(this.o);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.z);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.t);
        printWriter.print(" mRemoving=");
        printWriter.print(this.u);
        printWriter.print(" mResumed=");
        printWriter.print(this.v);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.w);
        printWriter.print(" mInLayout=");
        printWriter.println(this.x);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.F);
        printWriter.print(" mDetached=");
        printWriter.print(this.G);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.K);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.J);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.H);
        printWriter.print(" mRetaining=");
        printWriter.print(this.I);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.R);
        if (this.A != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.A);
        }
        if (this.B != null) {
            printWriter.print(str);
            printWriter.print("mActivity=");
            printWriter.println(this.B);
        }
        if (this.p != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.p);
        }
        if (this.l != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.l);
        }
        if (this.m != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.m);
        }
        if (this.q != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.q);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.s);
        }
        if (this.M != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.M);
        }
        if (this.N != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.N);
        }
        if (this.O != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.O);
        }
        if (this.P != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.O);
        }
        if (this.j != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.j);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.k);
        }
        if (this.S != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.S.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        b();
        if (this.S != null) {
            this.S.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        if (this.T) {
            this.T = false;
            if (!this.U) {
                this.U = true;
                this.S = this.B.getLoaderManager(this.n, this.T, false);
            }
            if (this.S != null) {
                if (!this.B.mRetaining) {
                    this.S.c();
                } else {
                    this.S.d();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        d();
        if (this.S != null) {
            this.S.f();
        }
    }
}
