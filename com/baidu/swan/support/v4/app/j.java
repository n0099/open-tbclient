package com.baidu.swan.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes6.dex */
public abstract class j<E> extends h {
    final l ezb;
    private p ezf;
    private boolean ezg;
    private boolean ezh;
    private com.baidu.swan.support.v4.b.f<String, o> ezr;
    private final Activity mActivity;
    final Context mContext;
    private final Handler mHandler;
    final int mWindowAnimations;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler, 0);
    }

    j(Activity activity, Context context, Handler handler, int i) {
        this.ezb = new l();
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
    public l bhG() {
        return this.ezb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zf(String str) {
        p pVar;
        if (this.ezr != null && (pVar = (p) this.ezr.get(str)) != null && !pVar.mRetaining) {
            pVar.doDestroy();
            this.ezr.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Fragment fragment) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doLoaderStart() {
        if (!this.ezg) {
            this.ezg = true;
            if (this.ezf != null) {
                this.ezf.bhK();
            } else if (!this.ezh) {
                this.ezf = d("(root)", this.ezg, false);
                if (this.ezf != null && !this.ezf.mStarted) {
                    this.ezf.bhK();
                }
            }
            this.ezh = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doLoaderStop(boolean z) {
        if (this.ezf != null && this.ezg) {
            this.ezg = false;
            if (z) {
                this.ezf.bhL();
            } else {
                this.ezf.doStop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doLoaderDestroy() {
        if (this.ezf != null) {
            this.ezf.doDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportLoaderStart() {
        if (this.ezr != null) {
            int size = this.ezr.size();
            p[] pVarArr = new p[size];
            for (int i = size - 1; i >= 0; i--) {
                pVarArr[i] = (p) this.ezr.valueAt(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                p pVar = pVarArr[i2];
                pVar.bhM();
                pVar.bhO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p d(String str, boolean z, boolean z2) {
        if (this.ezr == null) {
            this.ezr = new com.baidu.swan.support.v4.b.f<>();
        }
        p pVar = (p) this.ezr.get(str);
        if (pVar == null) {
            if (z2) {
                p pVar2 = new p(str, this, z);
                this.ezr.put(str, pVar2);
                return pVar2;
            }
            return pVar;
        }
        pVar.b(this);
        return pVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.swan.support.v4.b.f<String, o> bhF() {
        boolean z;
        if (this.ezr != null) {
            int size = this.ezr.size();
            p[] pVarArr = new p[size];
            for (int i = size - 1; i >= 0; i--) {
                pVarArr[i] = (p) this.ezr.valueAt(i);
            }
            z = false;
            for (int i2 = 0; i2 < size; i2++) {
                p pVar = pVarArr[i2];
                if (pVar.mRetaining) {
                    z = true;
                } else {
                    pVar.doDestroy();
                    this.ezr.remove(pVar.mWho);
                }
            }
        } else {
            z = false;
        }
        if (z) {
            return this.ezr;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.ezr = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.ezg);
        if (this.ezf != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.ezf)));
            printWriter.println(":");
            this.ezf.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
