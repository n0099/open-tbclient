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
/* loaded from: classes11.dex */
public final class e extends m implements Runnable {
    static final boolean dnp;
    final l dnq;
    a dnr;
    a dnt;
    int dnu;
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
    /* loaded from: classes11.dex */
    public static final class a {
        int cmd;
        a dnE;
        a dnF;
        Fragment dnG;
        ArrayList<Fragment> dnH;
        int enterAnim;
        int exitAnim;
        int popEnterAnim;
        int popExitAnim;
    }

    static {
        dnp = Build.VERSION.SDK_INT >= 21;
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
        if (this.dnr != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str3 = str + "    ";
            int i = 0;
            a aVar = this.dnr;
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
                printWriter.println(aVar.dnG);
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
                if (aVar.dnH != null && aVar.dnH.size() > 0) {
                    for (int i2 = 0; i2 < aVar.dnH.size(); i2++) {
                        printWriter.print(str3);
                        if (aVar.dnH.size() == 1) {
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
                        printWriter.println(aVar.dnH.get(i2));
                    }
                }
                aVar = aVar.dnE;
                i++;
            }
        }
    }

    public e(l lVar) {
        this.dnq = lVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        if (this.dnr == null) {
            this.dnt = aVar;
            this.dnr = aVar;
        } else {
            aVar.dnF = this.dnt;
            this.dnt.dnE = aVar;
            this.dnt = aVar;
        }
        aVar.enterAnim = this.mEnterAnim;
        aVar.exitAnim = this.mExitAnim;
        aVar.popEnterAnim = this.mPopEnterAnim;
        aVar.popExitAnim = this.mPopExitAnim;
        this.dnu++;
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
        fragment.dnO = this.dnq;
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
        aVar.dnG = fragment;
        a(aVar);
    }

    @Override // com.baidu.swan.support.v4.app.m
    public m a(Fragment fragment) {
        a aVar = new a();
        aVar.cmd = 3;
        aVar.dnG = fragment;
        a(aVar);
        return this;
    }

    @Override // com.baidu.swan.support.v4.app.m
    public m b(Fragment fragment) {
        a aVar = new a();
        aVar.cmd = 4;
        aVar.dnG = fragment;
        a(aVar);
        return this;
    }

    @Override // com.baidu.swan.support.v4.app.m
    public m c(Fragment fragment) {
        a aVar = new a();
        aVar.cmd = 5;
        aVar.dnG = fragment;
        a(aVar);
        return this;
    }

    @Override // com.baidu.swan.support.v4.app.m
    public m av(int i, int i2) {
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
            for (a aVar = this.dnr; aVar != null; aVar = aVar.dnE) {
                if (aVar.dnG != null) {
                    aVar.dnG.mBackStackNesting += i;
                    if (l.DEBUG) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.dnG + " to " + aVar.dnG.mBackStackNesting);
                    }
                }
                if (aVar.dnH != null) {
                    for (int size = aVar.dnH.size() - 1; size >= 0; size--) {
                        Fragment fragment = aVar.dnH.get(size);
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
            this.mIndex = this.dnq.a(this);
        } else {
            this.mIndex = -1;
        }
        this.dnq.b(this, z);
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
        if (!dnp) {
            bVar = null;
        } else {
            SparseArray<Fragment> sparseArray = new SparseArray<>();
            SparseArray<Fragment> sparseArray2 = new SparseArray<>();
            a(sparseArray, sparseArray2);
            bVar = a(sparseArray, sparseArray2, false);
        }
        int i = bVar != null ? 0 : this.mTransitionStyle;
        int i2 = bVar != null ? 0 : this.mTransition;
        for (a aVar = this.dnr; aVar != null; aVar = aVar.dnE) {
            int i3 = bVar != null ? 0 : aVar.enterAnim;
            int i4 = bVar != null ? 0 : aVar.exitAnim;
            switch (aVar.cmd) {
                case 1:
                    Fragment fragment2 = aVar.dnG;
                    fragment2.mNextAnim = i3;
                    this.dnq.c(fragment2, false);
                    break;
                case 2:
                    Fragment fragment3 = aVar.dnG;
                    int i5 = fragment3.mContainerId;
                    if (this.dnq.mAdded != null) {
                        int i6 = 0;
                        fragment = fragment3;
                        while (true) {
                            int i7 = i6;
                            if (i7 < this.dnq.mAdded.size()) {
                                Fragment fragment4 = this.dnq.mAdded.get(i7);
                                if (l.DEBUG) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment + " old=" + fragment4);
                                }
                                if (fragment4.mContainerId == i5) {
                                    if (fragment4 == fragment) {
                                        fragment = null;
                                        aVar.dnG = null;
                                    } else {
                                        if (aVar.dnH == null) {
                                            aVar.dnH = new ArrayList<>();
                                        }
                                        aVar.dnH.add(fragment4);
                                        fragment4.mNextAnim = i4;
                                        if (this.mAddToBackStack) {
                                            fragment4.mBackStackNesting++;
                                            if (l.DEBUG) {
                                                Log.v("FragmentManager", "Bump nesting of " + fragment4 + " to " + fragment4.mBackStackNesting);
                                            }
                                        }
                                        this.dnq.a(fragment4, i2, i);
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
                        this.dnq.c(fragment, false);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    Fragment fragment5 = aVar.dnG;
                    fragment5.mNextAnim = i4;
                    this.dnq.a(fragment5, i2, i);
                    break;
                case 4:
                    Fragment fragment6 = aVar.dnG;
                    fragment6.mNextAnim = i4;
                    this.dnq.b(fragment6, i2, i);
                    break;
                case 5:
                    Fragment fragment7 = aVar.dnG;
                    fragment7.mNextAnim = i3;
                    this.dnq.c(fragment7, i2, i);
                    break;
                case 6:
                    Fragment fragment8 = aVar.dnG;
                    fragment8.mNextAnim = i4;
                    this.dnq.d(fragment8, i2, i);
                    break;
                case 7:
                    Fragment fragment9 = aVar.dnG;
                    fragment9.mNextAnim = i3;
                    this.dnq.e(fragment9, i2, i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.cmd);
            }
        }
        this.dnq.a(this.dnq.mCurState, i2, i, true);
        if (this.mAddToBackStack) {
            this.dnq.b(this);
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
        if (this.dnq.doj.onHasView()) {
            for (a aVar = this.dnr; aVar != null; aVar = aVar.dnE) {
                switch (aVar.cmd) {
                    case 1:
                        b(sparseArray2, aVar.dnG);
                        break;
                    case 2:
                        Fragment fragment2 = aVar.dnG;
                        if (this.dnq.mAdded != null) {
                            int i = 0;
                            fragment = fragment2;
                            while (true) {
                                int i2 = i;
                                if (i2 < this.dnq.mAdded.size()) {
                                    Fragment fragment3 = this.dnq.mAdded.get(i2);
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
                        a(sparseArray, aVar.dnG);
                        break;
                    case 4:
                        a(sparseArray, aVar.dnG);
                        break;
                    case 5:
                        b(sparseArray2, aVar.dnG);
                        break;
                    case 6:
                        a(sparseArray, aVar.dnG);
                        break;
                    case 7:
                        b(sparseArray2, aVar.dnG);
                        break;
                }
            }
        }
    }

    public void b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.dnq.doj.onHasView()) {
            for (a aVar = this.dnr; aVar != null; aVar = aVar.dnE) {
                switch (aVar.cmd) {
                    case 1:
                        a(sparseArray, aVar.dnG);
                        break;
                    case 2:
                        if (aVar.dnH != null) {
                            for (int size = aVar.dnH.size() - 1; size >= 0; size--) {
                                b(sparseArray2, aVar.dnH.get(size));
                            }
                        }
                        a(sparseArray, aVar.dnG);
                        break;
                    case 3:
                        b(sparseArray2, aVar.dnG);
                        break;
                    case 4:
                        b(sparseArray2, aVar.dnG);
                        break;
                    case 5:
                        a(sparseArray, aVar.dnG);
                        break;
                    case 6:
                        b(sparseArray2, aVar.dnG);
                        break;
                    case 7:
                        a(sparseArray, aVar.dnG);
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
        if (dnp) {
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
        for (a aVar = this.dnt; aVar != null; aVar = aVar.dnF) {
            int i3 = bVar != null ? 0 : aVar.popEnterAnim;
            int i4 = bVar != null ? 0 : aVar.popExitAnim;
            switch (aVar.cmd) {
                case 1:
                    Fragment fragment = aVar.dnG;
                    fragment.mNextAnim = i4;
                    this.dnq.a(fragment, l.reverseTransit(i2), i);
                    break;
                case 2:
                    Fragment fragment2 = aVar.dnG;
                    if (fragment2 != null) {
                        fragment2.mNextAnim = i4;
                        this.dnq.a(fragment2, l.reverseTransit(i2), i);
                    }
                    if (aVar.dnH != null) {
                        for (int i5 = 0; i5 < aVar.dnH.size(); i5++) {
                            Fragment fragment3 = aVar.dnH.get(i5);
                            fragment3.mNextAnim = i3;
                            this.dnq.c(fragment3, false);
                        }
                        break;
                    } else {
                        break;
                    }
                case 3:
                    Fragment fragment4 = aVar.dnG;
                    fragment4.mNextAnim = i3;
                    this.dnq.c(fragment4, false);
                    break;
                case 4:
                    Fragment fragment5 = aVar.dnG;
                    fragment5.mNextAnim = i3;
                    this.dnq.c(fragment5, l.reverseTransit(i2), i);
                    break;
                case 5:
                    Fragment fragment6 = aVar.dnG;
                    fragment6.mNextAnim = i4;
                    this.dnq.b(fragment6, l.reverseTransit(i2), i);
                    break;
                case 6:
                    Fragment fragment7 = aVar.dnG;
                    fragment7.mNextAnim = i3;
                    this.dnq.e(fragment7, l.reverseTransit(i2), i);
                    break;
                case 7:
                    Fragment fragment8 = aVar.dnG;
                    fragment8.mNextAnim = i3;
                    this.dnq.d(fragment8, l.reverseTransit(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.cmd);
            }
        }
        if (z) {
            this.dnq.a(this.dnq.mCurState, l.reverseTransit(i2), i, true);
            bVar = null;
        }
        if (this.mIndex >= 0) {
            this.dnq.freeBackStackIndex(this.mIndex);
            this.mIndex = -1;
        }
        return bVar;
    }

    public String getName() {
        return this.mName;
    }

    private b a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        b bVar = new b();
        bVar.dnL = new View(this.dnq.dnP.getContext());
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
        return n.ah(sharedElementEnterTransition);
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
            if (fragment.dnV != null) {
                fragment.dnV.onMapSharedElements(this.mSharedElementTargetNames, aVar);
            }
            a(bVar, aVar, false);
        } else {
            if (fragment.dnW != null) {
                fragment.dnW.onMapSharedElements(this.mSharedElementTargetNames, aVar);
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
        ViewGroup viewGroup = (ViewGroup) this.dnq.doj.onFindViewById(i);
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
                Object a5 = a(b2, fragment2, arrayList2, aVar, bVar.dnL);
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
                    n.a(a3, obj, viewGroup, bVar2, bVar.dnL, bVar.dnK, bVar.dnI, arrayList3, aVar, aVar2, arrayList);
                    a(viewGroup, bVar, i, a2);
                    n.a(a2, bVar.dnL, true);
                    a(bVar, i, a2);
                    n.beginDelayedTransition(viewGroup, a2);
                    n.a(viewGroup, bVar.dnL, a3, arrayList3, a5, arrayList2, obj, arrayList, a2, bVar.dnJ, aVar2);
                }
                return a2 == null;
            }
            SharedElementCallback sharedElementCallback = z ? fragment2.dnV : fragment.dnV;
            if (sharedElementCallback != null) {
                sharedElementCallback.onSharedElementStart(new ArrayList(aVar.keySet()), new ArrayList(aVar.values()), null);
            }
            a(bVar, viewGroup, a4, fragment, fragment2, z, arrayList);
        }
        obj = a4;
        if (a3 != null) {
        }
        ArrayList arrayList22 = new ArrayList();
        Object a52 = a(b2, fragment2, arrayList22, aVar, bVar.dnL);
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
                    n.a(obj, bVar.dnL, a2, arrayList);
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
        SharedElementCallback sharedElementCallback = z ? fragment2.dnV : fragment.dnV;
        if (sharedElementCallback != null) {
            sharedElementCallback.onSharedElementEnd(new ArrayList(aVar.keySet()), new ArrayList(aVar.values()), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.support.v4.b.a<String, View> aVar, b bVar) {
        View view;
        if (this.mSharedElementTargetNames != null && !aVar.isEmpty() && (view = aVar.get(this.mSharedElementTargetNames.get(0))) != null) {
            bVar.dnK.doB = view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.support.v4.b.a<String, View> a(b bVar, boolean z, Fragment fragment) {
        com.baidu.swan.support.v4.b.a<String, View> b2 = b(bVar, fragment, z);
        if (z) {
            if (fragment.dnW != null) {
                fragment.dnW.onMapSharedElements(this.mSharedElementTargetNames, b2);
            }
            a(bVar, b2, true);
        } else {
            if (fragment.dnV != null) {
                fragment.dnV.onMapSharedElements(this.mSharedElementTargetNames, b2);
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
        if (this.dnq.mAdded != null) {
            for (int i2 = 0; i2 < this.dnq.mAdded.size(); i2++) {
                Fragment fragment = this.dnq.mAdded.get(i2);
                if (fragment.mView != null && fragment.mContainer != null && fragment.mContainerId == i) {
                    if (fragment.mHidden) {
                        if (!bVar.dnJ.contains(fragment.mView)) {
                            n.a(obj, fragment.mView, true);
                            bVar.dnJ.add(fragment.mView);
                        }
                    } else {
                        n.a(obj, fragment.mView, false);
                        bVar.dnJ.remove(fragment.mView);
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
                    a(bVar.dnI, arrayList.get(i2), arrayList2.get(i2));
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
                    a(bVar.dnI, str, transitionName);
                } else {
                    a(bVar.dnI, transitionName, str);
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
                a(bVar.dnI, keyAt, transitionName);
            } else {
                a(bVar.dnI, transitionName, keyAt);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b {
        public com.baidu.swan.support.v4.b.a<String, String> dnI = new com.baidu.swan.support.v4.b.a<>();
        public ArrayList<View> dnJ = new ArrayList<>();
        public n.a dnK = new n.a();
        public View dnL;

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
