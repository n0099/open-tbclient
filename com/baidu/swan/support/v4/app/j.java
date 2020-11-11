package com.baidu.swan.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes6.dex */
public abstract class j<E> extends h {
    final l ejW;
    private p eka;
    private boolean ekb;
    private boolean ekc;
    private com.baidu.swan.support.v4.b.f<String, o> ekl;
    private final Activity mActivity;
    final Context mContext;
    private final Handler mHandler;
    final int mWindowAnimations;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler, 0);
    }

    j(Activity activity, Context context, Handler handler, int i) {
        this.ejW = new l();
        this.mActivity = activity;
        this.mContext = context;
        this.mHandler = handler;
        this.mWindowAnimations = i;
    }

    public void onDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean g(Fragment fragment) {
        return true;
    }

    public LayoutInflater onGetLayoutInflater() {
        return (LayoutInflater) this.mContext.getSystemService("layout_inflater");
    }

    public void onSupportInvalidateOptionsMenu() {
    }

    public void b(@NonNull Fragment fragment, @NonNull String[] strArr, int i) {
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    public int onGetWindowAnimations() {
        return this.mWindowAnimations;
    }

    @Override // com.baidu.swan.support.v4.app.h
    @Nullable
    public View onFindViewById(int i) {
        return null;
    }

    @Override // com.baidu.swan.support.v4.app.h
    public boolean onHasView() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activity getActivity() {
        return this.mActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context getContext() {
        return this.mContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler getHandler() {
        return this.mHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l bcL() {
        return this.ejW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yE(String str) {
        p pVar;
        if (this.ekl != null && (pVar = (p) this.ekl.get(str)) != null && !pVar.mRetaining) {
            pVar.doDestroy();
            this.ekl.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Fragment fragment) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doLoaderStart() {
        if (!this.ekb) {
            this.ekb = true;
            if (this.eka != null) {
                this.eka.bcP();
            } else if (!this.ekc) {
                this.eka = d("(root)", this.ekb, false);
                if (this.eka != null && !this.eka.mStarted) {
                    this.eka.bcP();
                }
            }
            this.ekc = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doLoaderStop(boolean z) {
        if (this.eka != null && this.ekb) {
            this.ekb = false;
            if (z) {
                this.eka.bcQ();
            } else {
                this.eka.doStop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doLoaderDestroy() {
        if (this.eka != null) {
            this.eka.doDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportLoaderStart() {
        if (this.ekl != null) {
            int size = this.ekl.size();
            p[] pVarArr = new p[size];
            for (int i = size - 1; i >= 0; i--) {
                pVarArr[i] = (p) this.ekl.valueAt(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                p pVar = pVarArr[i2];
                pVar.bcR();
                pVar.bcT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p d(String str, boolean z, boolean z2) {
        if (this.ekl == null) {
            this.ekl = new com.baidu.swan.support.v4.b.f<>();
        }
        p pVar = (p) this.ekl.get(str);
        if (pVar == null) {
            if (z2) {
                p pVar2 = new p(str, this, z);
                this.ekl.put(str, pVar2);
                return pVar2;
            }
            return pVar;
        }
        pVar.b(this);
        return pVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.swan.support.v4.b.f<String, o> bcK() {
        boolean z;
        if (this.ekl != null) {
            int size = this.ekl.size();
            p[] pVarArr = new p[size];
            for (int i = size - 1; i >= 0; i--) {
                pVarArr[i] = (p) this.ekl.valueAt(i);
            }
            z = false;
            for (int i2 = 0; i2 < size; i2++) {
                p pVar = pVarArr[i2];
                if (pVar.mRetaining) {
                    z = true;
                } else {
                    pVar.doDestroy();
                    this.ekl.remove(pVar.mWho);
                }
            }
        } else {
            z = false;
        }
        if (z) {
            return this.ekl;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.ekl = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.ekb);
        if (this.eka != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.eka)));
            printWriter.println(":");
            this.eka.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
