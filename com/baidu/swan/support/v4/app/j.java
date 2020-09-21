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
/* loaded from: classes24.dex */
public abstract class j<E> extends h {
    final l dJH;
    private p dJL;
    private boolean dJM;
    private boolean dJN;
    private com.baidu.swan.support.v4.b.f<String, o> dJW;
    private final Activity mActivity;
    final Context mContext;
    private final Handler mHandler;
    final int mWindowAnimations;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler, 0);
    }

    j(Activity activity, Context context, Handler handler, int i) {
        this.dJH = new l();
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
    public l aVJ() {
        return this.dJH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xl(String str) {
        p pVar;
        if (this.dJW != null && (pVar = (p) this.dJW.get(str)) != null && !pVar.mRetaining) {
            pVar.doDestroy();
            this.dJW.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Fragment fragment) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doLoaderStart() {
        if (!this.dJM) {
            this.dJM = true;
            if (this.dJL != null) {
                this.dJL.aVN();
            } else if (!this.dJN) {
                this.dJL = d("(root)", this.dJM, false);
                if (this.dJL != null && !this.dJL.mStarted) {
                    this.dJL.aVN();
                }
            }
            this.dJN = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doLoaderStop(boolean z) {
        if (this.dJL != null && this.dJM) {
            this.dJM = false;
            if (z) {
                this.dJL.aVO();
            } else {
                this.dJL.doStop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doLoaderDestroy() {
        if (this.dJL != null) {
            this.dJL.doDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportLoaderStart() {
        if (this.dJW != null) {
            int size = this.dJW.size();
            p[] pVarArr = new p[size];
            for (int i = size - 1; i >= 0; i--) {
                pVarArr[i] = (p) this.dJW.valueAt(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                p pVar = pVarArr[i2];
                pVar.aVP();
                pVar.aVR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p d(String str, boolean z, boolean z2) {
        if (this.dJW == null) {
            this.dJW = new com.baidu.swan.support.v4.b.f<>();
        }
        p pVar = (p) this.dJW.get(str);
        if (pVar == null) {
            if (z2) {
                p pVar2 = new p(str, this, z);
                this.dJW.put(str, pVar2);
                return pVar2;
            }
            return pVar;
        }
        pVar.b(this);
        return pVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.swan.support.v4.b.f<String, o> aVI() {
        boolean z;
        if (this.dJW != null) {
            int size = this.dJW.size();
            p[] pVarArr = new p[size];
            for (int i = size - 1; i >= 0; i--) {
                pVarArr[i] = (p) this.dJW.valueAt(i);
            }
            z = false;
            for (int i2 = 0; i2 < size; i2++) {
                p pVar = pVarArr[i2];
                if (pVar.mRetaining) {
                    z = true;
                } else {
                    pVar.doDestroy();
                    this.dJW.remove(pVar.mWho);
                }
            }
        } else {
            z = false;
        }
        if (z) {
            return this.dJW;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.dJW = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.dJM);
        if (this.dJL != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.dJL)));
            printWriter.println(":");
            this.dJL.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
