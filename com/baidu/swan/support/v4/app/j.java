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
/* loaded from: classes11.dex */
public abstract class j<E> extends h {
    final l dsA;
    private p dsE;
    private boolean dsF;
    private boolean dsG;
    private com.baidu.swan.support.v4.b.f<String, o> dsP;
    private final Activity mActivity;
    final Context mContext;
    private final Handler mHandler;
    final int mWindowAnimations;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler, 0);
    }

    j(Activity activity, Context context, Handler handler, int i) {
        this.dsA = new l();
        this.mActivity = activity;
        this.mContext = context;
        this.mHandler = handler;
        this.mWindowAnimations = i;
    }

    public void onDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean e(Fragment fragment) {
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
    public l aIF() {
        return this.dsA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tD(String str) {
        p pVar;
        if (this.dsP != null && (pVar = (p) this.dsP.get(str)) != null && !pVar.mRetaining) {
            pVar.doDestroy();
            this.dsP.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Fragment fragment) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doLoaderStart() {
        if (!this.dsF) {
            this.dsF = true;
            if (this.dsE != null) {
                this.dsE.aIJ();
            } else if (!this.dsG) {
                this.dsE = d("(root)", this.dsF, false);
                if (this.dsE != null && !this.dsE.mStarted) {
                    this.dsE.aIJ();
                }
            }
            this.dsG = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doLoaderStop(boolean z) {
        if (this.dsE != null && this.dsF) {
            this.dsF = false;
            if (z) {
                this.dsE.aIK();
            } else {
                this.dsE.doStop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doLoaderDestroy() {
        if (this.dsE != null) {
            this.dsE.doDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportLoaderStart() {
        if (this.dsP != null) {
            int size = this.dsP.size();
            p[] pVarArr = new p[size];
            for (int i = size - 1; i >= 0; i--) {
                pVarArr[i] = (p) this.dsP.valueAt(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                p pVar = pVarArr[i2];
                pVar.aIL();
                pVar.aIN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p d(String str, boolean z, boolean z2) {
        if (this.dsP == null) {
            this.dsP = new com.baidu.swan.support.v4.b.f<>();
        }
        p pVar = (p) this.dsP.get(str);
        if (pVar == null) {
            if (z2) {
                p pVar2 = new p(str, this, z);
                this.dsP.put(str, pVar2);
                return pVar2;
            }
            return pVar;
        }
        pVar.b(this);
        return pVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.swan.support.v4.b.f<String, o> aIE() {
        boolean z;
        if (this.dsP != null) {
            int size = this.dsP.size();
            p[] pVarArr = new p[size];
            for (int i = size - 1; i >= 0; i--) {
                pVarArr[i] = (p) this.dsP.valueAt(i);
            }
            z = false;
            for (int i2 = 0; i2 < size; i2++) {
                p pVar = pVarArr[i2];
                if (pVar.mRetaining) {
                    z = true;
                } else {
                    pVar.doDestroy();
                    this.dsP.remove(pVar.mWho);
                }
            }
        } else {
            z = false;
        }
        if (z) {
            return this.dsP;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.dsP = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.dsF);
        if (this.dsE != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.dsE)));
            printWriter.println(":");
            this.dsE.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
