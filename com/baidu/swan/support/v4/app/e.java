package com.baidu.swan.support.v4.app;

import android.app.SharedElementCallback;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.baidu.swan.support.v4.app.n;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class e extends m implements Runnable {
    static final boolean dHf;
    final l dHg;
    a dHh;
    a dHi;
    int dHj;
    boolean mAddToBackStack;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    boolean mCommitted;
    int mEnterAnim;
    int mExitAnim;
    String mName;
    int mPopEnterAnim;
    int mPopExitAnim;
    ArrayList<String> mSharedElementSourceNames;
    ArrayList<String> mSharedElementTargetNames;
    int mTransition;
    int mTransitionStyle;
    boolean mAllowAddToBackStack = true;
    int mIndex = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class a {
        int cmd;
        a dHt;
        a dHu;
        Fragment dHv;
        ArrayList<Fragment> dHw;
        int enterAnim;
        int exitAnim;
        int popEnterAnim;
        int popExitAnim;
    }

    static {
        dHf = Build.VERSION.SDK_INT >= 21;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            sb.append(" #");
            sb.append(this.mIndex);
        }
        if (this.mName != null) {
            sb.append(" ");
            sb.append(this.mName);
        }
        sb.append("}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        dump(str, printWriter, true);
    }

    public void dump(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.mCommitted);
            if (this.mTransition != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.mTransition));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.mTransitionStyle));
            }
            if (this.mEnterAnim != 0 || this.mExitAnim != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mEnterAnim));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.mExitAnim));
            }
            if (this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mPopEnterAnim));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.mBreadCrumbTitleText);
            }
            if (this.mBreadCrumbShortTitleRes != 0 || this.mBreadCrumbShortTitleText != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.mBreadCrumbShortTitleText);
            }
        }
        if (this.dHh != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str3 = str + "    ";
            int i = 0;
            a aVar = this.dHh;
            while (aVar != null) {
                switch (aVar.cmd) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    default:
                        str2 = "cmd=" + aVar.cmd;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.dHv);
                if (z) {
                    if (aVar.enterAnim != 0 || aVar.exitAnim != 0) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.enterAnim));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.exitAnim));
                    }
                    if (aVar.popEnterAnim != 0 || aVar.popExitAnim != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.popEnterAnim));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.popExitAnim));
                    }
                }
                if (aVar.dHw != null && aVar.dHw.size() > 0) {
                    for (int i2 = 0; i2 < aVar.dHw.size(); i2++) {
                        printWriter.print(str3);
                        if (aVar.dHw.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str3);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(aVar.dHw.get(i2));
                    }
                }
                aVar = aVar.dHt;
                i++;
            }
        }
    }

    public e(l lVar) {
        this.dHg = lVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        if (this.dHh == null) {
            this.dHi = aVar;
            this.dHh = aVar;
        } else {
            aVar.dHu = this.dHi;
            this.dHi.dHt = aVar;
            this.dHi = aVar;
        }
        aVar.enterAnim = this.mEnterAnim;
        aVar.exitAnim = this.mExitAnim;
        aVar.popEnterAnim = this.mPopEnterAnim;
        aVar.popExitAnim = this.mPopExitAnim;
        this.dHj++;
    }

    @Override // com.baidu.swan.support.v4.app.m
    public m a(int i, Fragment fragment) {
        a(i, fragment, (String) null, 1);
        return this;
    }

    @Override // com.baidu.swan.support.v4.app.m
    public m a(int i, Fragment fragment, String str) {
        a(i, fragment, str, 1);
        return this;
    }

    private void a(int i, Fragment fragment, String str, int i2) {
        fragment.dHD = this.dHg;
        if (str != null) {
            if (fragment.mTag != null && !str.equals(fragment.mTag)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i != 0) {
            if (fragment.mFragmentId != 0 && fragment.mFragmentId != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
            fragment.mFragmentId = i;
            fragment.mContainerId = i;
        }
        a aVar = new a();
        aVar.cmd = i2;
        aVar.dHv = fragment;
        a(aVar);
    }

    @Override // com.baidu.swan.support.v4.app.m
    public m c(Fragment fragment) {
        a aVar = new a();
        aVar.cmd = 3;
        aVar.dHv = fragment;
        a(aVar);
        return this;
    }

    @Override // com.baidu.swan.support.v4.app.m
    public m d(Fragment fragment) {
        a aVar = new a();
        aVar.cmd = 4;
        aVar.dHv = fragment;
        a(aVar);
        return this;
    }

    @Override // com.baidu.swan.support.v4.app.m
    public m e(Fragment fragment) {
        a aVar = new a();
        aVar.cmd = 5;
        aVar.dHv = fragment;
        a(aVar);
        return this;
    }

    @Override // com.baidu.swan.support.v4.app.m
    public m aE(int i, int i2) {
        return o(i, i2, 0, 0);
    }

    public m o(int i, int i2, int i3, int i4) {
        this.mEnterAnim = i;
        this.mExitAnim = i2;
        this.mPopEnterAnim = i3;
        this.mPopExitAnim = i4;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bumpBackStackNesting(int i) {
        if (this.mAddToBackStack) {
            if (l.DEBUG) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (a aVar = this.dHh; aVar != null; aVar = aVar.dHt) {
                if (aVar.dHv != null) {
                    aVar.dHv.mBackStackNesting += i;
                    if (l.DEBUG) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.dHv + " to " + aVar.dHv.mBackStackNesting);
                    }
                }
                if (aVar.dHw != null) {
                    for (int size = aVar.dHw.size() - 1; size >= 0; size--) {
                        Fragment fragment = aVar.dHw.get(size);
                        fragment.mBackStackNesting += i;
                        if (l.DEBUG) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.mBackStackNesting);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.m
    public int commit() {
        return commitInternal(false);
    }

    @Override // com.baidu.swan.support.v4.app.m
    public int commitAllowingStateLoss() {
        return commitInternal(true);
    }

    int commitInternal(boolean z) {
        if (this.mCommitted) {
            throw new IllegalStateException("commit already called");
        }
        if (l.DEBUG) {
            Log.v("FragmentManager", "Commit: " + this);
            com.baidu.swan.support.v4.b.d dVar = new com.baidu.swan.support.v4.b.d("FragmentManager");
            PrintWriter printWriter = new PrintWriter(dVar);
            dump("  ", null, printWriter, null);
            closeSafely(printWriter);
            closeSafely(dVar);
        }
        this.mCommitted = true;
        if (this.mAddToBackStack) {
            this.mIndex = this.dHg.a(this);
        } else {
            this.mIndex = -1;
        }
        this.dHg.b(this, z);
        return this.mIndex;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar;
        Fragment fragment;
        if (l.DEBUG) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (this.mAddToBackStack && this.mIndex < 0) {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        bumpBackStackNesting(1);
        if (!dHf) {
            bVar = null;
        } else {
            SparseArray<Fragment> sparseArray = new SparseArray<>();
            SparseArray<Fragment> sparseArray2 = new SparseArray<>();
            a(sparseArray, sparseArray2);
            bVar = a(sparseArray, sparseArray2, false);
        }
        int i = bVar != null ? 0 : this.mTransitionStyle;
        int i2 = bVar != null ? 0 : this.mTransition;
        for (a aVar = this.dHh; aVar != null; aVar = aVar.dHt) {
            int i3 = bVar != null ? 0 : aVar.enterAnim;
            int i4 = bVar != null ? 0 : aVar.exitAnim;
            switch (aVar.cmd) {
                case 1:
                    Fragment fragment2 = aVar.dHv;
                    fragment2.mNextAnim = i3;
                    this.dHg.c(fragment2, false);
                    break;
                case 2:
                    Fragment fragment3 = aVar.dHv;
                    int i5 = fragment3.mContainerId;
                    if (this.dHg.mAdded != null) {
                        int i6 = 0;
                        fragment = fragment3;
                        while (true) {
                            int i7 = i6;
                            if (i7 < this.dHg.mAdded.size()) {
                                Fragment fragment4 = this.dHg.mAdded.get(i7);
                                if (l.DEBUG) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment + " old=" + fragment4);
                                }
                                if (fragment4.mContainerId == i5) {
                                    if (fragment4 == fragment) {
                                        fragment = null;
                                        aVar.dHv = null;
                                    } else {
                                        if (aVar.dHw == null) {
                                            aVar.dHw = new ArrayList<>();
                                        }
                                        aVar.dHw.add(fragment4);
                                        fragment4.mNextAnim = i4;
                                        if (this.mAddToBackStack) {
                                            fragment4.mBackStackNesting++;
                                            if (l.DEBUG) {
                                                Log.v("FragmentManager", "Bump nesting of " + fragment4 + " to " + fragment4.mBackStackNesting);
                                            }
                                        }
                                        this.dHg.a(fragment4, i2, i);
                                    }
                                }
                                i6 = i7 + 1;
                            }
                        }
                    } else {
                        fragment = fragment3;
                    }
                    if (fragment != null) {
                        fragment.mNextAnim = i3;
                        this.dHg.c(fragment, false);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    Fragment fragment5 = aVar.dHv;
                    fragment5.mNextAnim = i4;
                    this.dHg.a(fragment5, i2, i);
                    break;
                case 4:
                    Fragment fragment6 = aVar.dHv;
                    fragment6.mNextAnim = i4;
                    this.dHg.b(fragment6, i2, i);
                    break;
                case 5:
                    Fragment fragment7 = aVar.dHv;
                    fragment7.mNextAnim = i3;
                    this.dHg.c(fragment7, i2, i);
                    break;
                case 6:
                    Fragment fragment8 = aVar.dHv;
                    fragment8.mNextAnim = i4;
                    this.dHg.d(fragment8, i2, i);
                    break;
                case 7:
                    Fragment fragment9 = aVar.dHv;
                    fragment9.mNextAnim = i3;
                    this.dHg.e(fragment9, i2, i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.cmd);
            }
        }
        this.dHg.a(this.dHg.mCurState, i2, i, true);
        if (this.mAddToBackStack) {
            this.dHg.b(this);
        }
    }

    private static void a(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i;
        if (fragment != null && (i = fragment.mContainerId) != 0 && !fragment.isHidden() && fragment.isAdded() && fragment.getView() != null && sparseArray.get(i) == null) {
            sparseArray.put(i, fragment);
        }
    }

    private void b(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i;
        if (fragment != null && (i = fragment.mContainerId) != 0) {
            sparseArray.put(i, fragment);
        }
    }

    private void a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Fragment fragment;
        if (this.dHg.dHX.onHasView()) {
            for (a aVar = this.dHh; aVar != null; aVar = aVar.dHt) {
                switch (aVar.cmd) {
                    case 1:
                        b(sparseArray2, aVar.dHv);
                        break;
                    case 2:
                        Fragment fragment2 = aVar.dHv;
                        if (this.dHg.mAdded != null) {
                            int i = 0;
                            fragment = fragment2;
                            while (true) {
                                int i2 = i;
                                if (i2 < this.dHg.mAdded.size()) {
                                    Fragment fragment3 = this.dHg.mAdded.get(i2);
                                    if (fragment == null || fragment3.mContainerId == fragment.mContainerId) {
                                        if (fragment3 == fragment) {
                                            fragment = null;
                                        } else {
                                            a(sparseArray, fragment3);
                                        }
                                    }
                                    i = i2 + 1;
                                }
                            }
                        } else {
                            fragment = fragment2;
                        }
                        b(sparseArray2, fragment);
                        break;
                    case 3:
                        a(sparseArray, aVar.dHv);
                        break;
                    case 4:
                        a(sparseArray, aVar.dHv);
                        break;
                    case 5:
                        b(sparseArray2, aVar.dHv);
                        break;
                    case 6:
                        a(sparseArray, aVar.dHv);
                        break;
                    case 7:
                        b(sparseArray2, aVar.dHv);
                        break;
                }
            }
        }
    }

    public void b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.dHg.dHX.onHasView()) {
            for (a aVar = this.dHh; aVar != null; aVar = aVar.dHt) {
                switch (aVar.cmd) {
                    case 1:
                        a(sparseArray, aVar.dHv);
                        break;
                    case 2:
                        if (aVar.dHw != null) {
                            for (int size = aVar.dHw.size() - 1; size >= 0; size--) {
                                b(sparseArray2, aVar.dHw.get(size));
                            }
                        }
                        a(sparseArray, aVar.dHv);
                        break;
                    case 3:
                        b(sparseArray2, aVar.dHv);
                        break;
                    case 4:
                        b(sparseArray2, aVar.dHv);
                        break;
                    case 5:
                        a(sparseArray, aVar.dHv);
                        break;
                    case 6:
                        b(sparseArray2, aVar.dHv);
                        break;
                    case 7:
                        a(sparseArray, aVar.dHv);
                        break;
                }
            }
        }
    }

    public b a(boolean z, b bVar, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (l.DEBUG) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            com.baidu.swan.support.v4.b.d dVar = new com.baidu.swan.support.v4.b.d("FragmentManager");
            PrintWriter printWriter = new PrintWriter(dVar);
            dump("  ", null, printWriter, null);
            closeSafely(printWriter);
            closeSafely(dVar);
        }
        if (dHf) {
            if (bVar == null) {
                if (sparseArray.size() != 0 || sparseArray2.size() != 0) {
                    bVar = a(sparseArray, sparseArray2, true);
                }
            } else if (!z) {
                a(bVar, this.mSharedElementTargetNames, this.mSharedElementSourceNames);
            }
        }
        bumpBackStackNesting(-1);
        int i = bVar != null ? 0 : this.mTransitionStyle;
        int i2 = bVar != null ? 0 : this.mTransition;
        for (a aVar = this.dHi; aVar != null; aVar = aVar.dHu) {
            int i3 = bVar != null ? 0 : aVar.popEnterAnim;
            int i4 = bVar != null ? 0 : aVar.popExitAnim;
            switch (aVar.cmd) {
                case 1:
                    Fragment fragment = aVar.dHv;
                    fragment.mNextAnim = i4;
                    this.dHg.a(fragment, l.reverseTransit(i2), i);
                    break;
                case 2:
                    Fragment fragment2 = aVar.dHv;
                    if (fragment2 != null) {
                        fragment2.mNextAnim = i4;
                        this.dHg.a(fragment2, l.reverseTransit(i2), i);
                    }
                    if (aVar.dHw != null) {
                        for (int i5 = 0; i5 < aVar.dHw.size(); i5++) {
                            Fragment fragment3 = aVar.dHw.get(i5);
                            fragment3.mNextAnim = i3;
                            this.dHg.c(fragment3, false);
                        }
                        break;
                    } else {
                        break;
                    }
                case 3:
                    Fragment fragment4 = aVar.dHv;
                    fragment4.mNextAnim = i3;
                    this.dHg.c(fragment4, false);
                    break;
                case 4:
                    Fragment fragment5 = aVar.dHv;
                    fragment5.mNextAnim = i3;
                    this.dHg.c(fragment5, l.reverseTransit(i2), i);
                    break;
                case 5:
                    Fragment fragment6 = aVar.dHv;
                    fragment6.mNextAnim = i4;
                    this.dHg.b(fragment6, l.reverseTransit(i2), i);
                    break;
                case 6:
                    Fragment fragment7 = aVar.dHv;
                    fragment7.mNextAnim = i3;
                    this.dHg.e(fragment7, l.reverseTransit(i2), i);
                    break;
                case 7:
                    Fragment fragment8 = aVar.dHv;
                    fragment8.mNextAnim = i3;
                    this.dHg.d(fragment8, l.reverseTransit(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.cmd);
            }
        }
        if (z) {
            this.dHg.a(this.dHg.mCurState, l.reverseTransit(i2), i, true);
            bVar = null;
        }
        if (this.mIndex >= 0) {
            this.dHg.freeBackStackIndex(this.mIndex);
            this.mIndex = -1;
        }
        return bVar;
    }

    public String getName() {
        return this.mName;
    }

    private b a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        b bVar = new b();
        bVar.dHA = new View(this.dHg.dHE.getContext());
        int i = 0;
        boolean z2 = false;
        while (i < sparseArray.size()) {
            boolean z3 = a(sparseArray.keyAt(i), bVar, z, sparseArray, sparseArray2) ? true : z2;
            i++;
            z2 = z3;
        }
        for (int i2 = 0; i2 < sparseArray2.size(); i2++) {
            int keyAt = sparseArray2.keyAt(i2);
            if (sparseArray.get(keyAt) == null && a(keyAt, bVar, z, sparseArray, sparseArray2)) {
                z2 = true;
            }
        }
        if (!z2) {
            return null;
        }
        return bVar;
    }

    private static Object a(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return n.cloneTransition(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Object b(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return n.cloneTransition(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    private static Object a(Fragment fragment, Fragment fragment2, boolean z) {
        Object sharedElementEnterTransition;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            sharedElementEnterTransition = fragment2.getSharedElementReturnTransition();
        } else {
            sharedElementEnterTransition = fragment.getSharedElementEnterTransition();
        }
        return n.aj(sharedElementEnterTransition);
    }

    private static Object a(Object obj, Fragment fragment, ArrayList<View> arrayList, com.baidu.swan.support.v4.b.a<String, View> aVar, View view) {
        if (obj != null) {
            return n.a(obj, fragment.getView(), arrayList, aVar, view);
        }
        return obj;
    }

    private com.baidu.swan.support.v4.b.a<String, View> a(b bVar, Fragment fragment, boolean z) {
        com.baidu.swan.support.v4.b.a<String, View> aVar = new com.baidu.swan.support.v4.b.a<>();
        if (this.mSharedElementSourceNames != null) {
            n.findNamedViews(aVar, fragment.getView());
            if (z) {
                aVar.retainAll(this.mSharedElementTargetNames);
            } else {
                aVar = a(this.mSharedElementSourceNames, this.mSharedElementTargetNames, aVar);
            }
        }
        if (z) {
            if (fragment.dHK != null) {
                fragment.dHK.onMapSharedElements(this.mSharedElementTargetNames, aVar);
            }
            a(bVar, aVar, false);
        } else {
            if (fragment.dHL != null) {
                fragment.dHL.onMapSharedElements(this.mSharedElementTargetNames, aVar);
            }
            b(bVar, aVar, false);
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0143 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(int i, b bVar, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Object obj;
        Object a2;
        View view;
        ViewGroup viewGroup = (ViewGroup) this.dHg.dHX.onFindViewById(i);
        if (viewGroup == null) {
            return false;
        }
        final Fragment fragment = sparseArray2.get(i);
        Fragment fragment2 = sparseArray.get(i);
        Object a3 = a(fragment, z);
        Object a4 = a(fragment, fragment2, z);
        Object b2 = b(fragment2, z);
        com.baidu.swan.support.v4.b.a<String, View> aVar = null;
        ArrayList<View> arrayList = new ArrayList<>();
        if (a4 != null) {
            aVar = a(bVar, fragment2, z);
            if (aVar.isEmpty()) {
                aVar = null;
                obj = null;
                if (a3 != null && obj == null && b2 == null) {
                    return false;
                }
                ArrayList arrayList2 = new ArrayList();
                Object a5 = a(b2, fragment2, arrayList2, aVar, bVar.dHA);
                if (this.mSharedElementTargetNames != null && aVar != null) {
                    view = aVar.get(this.mSharedElementTargetNames.get(0));
                    if (view != null) {
                        if (a5 != null) {
                            n.setEpicenter(a5, view);
                        }
                        if (obj != null) {
                            n.setEpicenter(obj, view);
                        }
                    }
                }
                n.b bVar2 = new n.b() { // from class: com.baidu.swan.support.v4.app.e.1
                    @Override // com.baidu.swan.support.v4.app.n.b
                    public View getView() {
                        return fragment.getView();
                    }
                };
                ArrayList arrayList3 = new ArrayList();
                com.baidu.swan.support.v4.b.a aVar2 = new com.baidu.swan.support.v4.b.a();
                boolean z2 = true;
                if (fragment != null) {
                    z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
                }
                a2 = n.a(a3, a5, obj, z2);
                if (a2 != null) {
                    n.a(a3, obj, viewGroup, bVar2, bVar.dHA, bVar.dHz, bVar.dHx, arrayList3, aVar, aVar2, arrayList);
                    a(viewGroup, bVar, i, a2);
                    n.a(a2, bVar.dHA, true);
                    a(bVar, i, a2);
                    n.beginDelayedTransition(viewGroup, a2);
                    n.a(viewGroup, bVar.dHA, a3, arrayList3, a5, arrayList2, obj, arrayList, a2, bVar.dHy, aVar2);
                }
                return a2 == null;
            }
            SharedElementCallback sharedElementCallback = z ? fragment2.dHK : fragment.dHK;
            if (sharedElementCallback != null) {
                sharedElementCallback.onSharedElementStart(new ArrayList(aVar.keySet()), new ArrayList(aVar.values()), null);
            }
            a(bVar, viewGroup, a4, fragment, fragment2, z, arrayList);
        }
        obj = a4;
        if (a3 != null) {
        }
        ArrayList arrayList22 = new ArrayList();
        Object a52 = a(b2, fragment2, arrayList22, aVar, bVar.dHA);
        if (this.mSharedElementTargetNames != null) {
            view = aVar.get(this.mSharedElementTargetNames.get(0));
            if (view != null) {
            }
        }
        n.b bVar22 = new n.b() { // from class: com.baidu.swan.support.v4.app.e.1
            @Override // com.baidu.swan.support.v4.app.n.b
            public View getView() {
                return fragment.getView();
            }
        };
        ArrayList arrayList32 = new ArrayList();
        com.baidu.swan.support.v4.b.a aVar22 = new com.baidu.swan.support.v4.b.a();
        boolean z22 = true;
        if (fragment != null) {
        }
        a2 = n.a(a3, a52, obj, z22);
        if (a2 != null) {
        }
        if (a2 == null) {
        }
    }

    private void a(final b bVar, final View view, final Object obj, final Fragment fragment, final Fragment fragment2, final boolean z, final ArrayList<View> arrayList) {
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.baidu.swan.support.v4.app.e.2
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                if (obj != null) {
                    n.a(obj, arrayList);
                    arrayList.clear();
                    com.baidu.swan.support.v4.b.a a2 = e.this.a(bVar, z, fragment);
                    n.a(obj, bVar.dHA, a2, arrayList);
                    e.this.a(a2, bVar);
                    e.this.a(bVar, fragment, fragment2, z, a2);
                    return true;
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar, Fragment fragment, Fragment fragment2, boolean z, com.baidu.swan.support.v4.b.a<String, View> aVar) {
        SharedElementCallback sharedElementCallback = z ? fragment2.dHK : fragment.dHK;
        if (sharedElementCallback != null) {
            sharedElementCallback.onSharedElementEnd(new ArrayList(aVar.keySet()), new ArrayList(aVar.values()), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.support.v4.b.a<String, View> aVar, b bVar) {
        View view;
        if (this.mSharedElementTargetNames != null && !aVar.isEmpty() && (view = aVar.get(this.mSharedElementTargetNames.get(0))) != null) {
            bVar.dHz.dIp = view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.support.v4.b.a<String, View> a(b bVar, boolean z, Fragment fragment) {
        com.baidu.swan.support.v4.b.a<String, View> b2 = b(bVar, fragment, z);
        if (z) {
            if (fragment.dHL != null) {
                fragment.dHL.onMapSharedElements(this.mSharedElementTargetNames, b2);
            }
            a(bVar, b2, true);
        } else {
            if (fragment.dHK != null) {
                fragment.dHK.onMapSharedElements(this.mSharedElementTargetNames, b2);
            }
            b(bVar, b2, true);
        }
        return b2;
    }

    private static com.baidu.swan.support.v4.b.a<String, View> a(ArrayList<String> arrayList, ArrayList<String> arrayList2, com.baidu.swan.support.v4.b.a<String, View> aVar) {
        if (!aVar.isEmpty()) {
            com.baidu.swan.support.v4.b.a<String, View> aVar2 = new com.baidu.swan.support.v4.b.a<>();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                View view = aVar.get(arrayList.get(i));
                if (view != null) {
                    aVar2.put(arrayList2.get(i), view);
                }
            }
            return aVar2;
        }
        return aVar;
    }

    private com.baidu.swan.support.v4.b.a<String, View> b(b bVar, Fragment fragment, boolean z) {
        com.baidu.swan.support.v4.b.a<String, View> aVar = new com.baidu.swan.support.v4.b.a<>();
        View view = fragment.getView();
        if (view != null && this.mSharedElementSourceNames != null) {
            n.findNamedViews(aVar, view);
            if (z) {
                return a(this.mSharedElementSourceNames, this.mSharedElementTargetNames, aVar);
            }
            aVar.retainAll(this.mSharedElementTargetNames);
            return aVar;
        }
        return aVar;
    }

    private void a(final View view, final b bVar, final int i, final Object obj) {
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.baidu.swan.support.v4.app.e.3
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                e.this.a(bVar, i, obj);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar, int i, Object obj) {
        if (this.dHg.mAdded != null) {
            for (int i2 = 0; i2 < this.dHg.mAdded.size(); i2++) {
                Fragment fragment = this.dHg.mAdded.get(i2);
                if (fragment.mView != null && fragment.mContainer != null && fragment.mContainerId == i) {
                    if (fragment.mHidden) {
                        if (!bVar.dHy.contains(fragment.mView)) {
                            n.a(obj, fragment.mView, true);
                            bVar.dHy.add(fragment.mView);
                        }
                    } else {
                        n.a(obj, fragment.mView, false);
                        bVar.dHy.remove(fragment.mView);
                    }
                }
            }
        }
    }

    private static void a(com.baidu.swan.support.v4.b.a<String, String> aVar, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < aVar.size(); i++) {
                if (str.equals(aVar.valueAt(i))) {
                    aVar.setValueAt(i, str2);
                    return;
                }
            }
            aVar.put(str, str2);
        }
    }

    private static void a(b bVar, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    a(bVar.dHx, arrayList.get(i2), arrayList2.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(b bVar, com.baidu.swan.support.v4.b.a<String, View> aVar, boolean z) {
        int size = this.mSharedElementTargetNames == null ? 0 : this.mSharedElementTargetNames.size();
        for (int i = 0; i < size; i++) {
            String str = this.mSharedElementSourceNames.get(i);
            View view = aVar.get(this.mSharedElementTargetNames.get(i));
            if (view != null) {
                String transitionName = n.getTransitionName(view);
                if (z) {
                    a(bVar.dHx, str, transitionName);
                } else {
                    a(bVar.dHx, transitionName, str);
                }
            }
        }
    }

    private void b(b bVar, com.baidu.swan.support.v4.b.a<String, View> aVar, boolean z) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            String keyAt = aVar.keyAt(i);
            String transitionName = n.getTransitionName(aVar.valueAt(i));
            if (z) {
                a(bVar.dHx, keyAt, transitionName);
            } else {
                a(bVar.dHx, transitionName, keyAt);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b {
        public View dHA;
        public com.baidu.swan.support.v4.b.a<String, String> dHx = new com.baidu.swan.support.v4.b.a<>();
        public ArrayList<View> dHy = new ArrayList<>();
        public n.a dHz = new n.a();

        public b() {
        }
    }

    private void closeSafely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
