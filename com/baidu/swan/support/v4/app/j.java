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
/* loaded from: classes9.dex */
public abstract class j<E> extends h {
    private com.baidu.swan.support.v4.b.f<String, o> dyF;
    final l dyq;
    private p dyu;
    private boolean dyv;
    private boolean dyw;
    private final Activity mActivity;
    final Context mContext;
    private final Handler mHandler;
    final int mWindowAnimations;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler, 0);
    }

    j(Activity activity, Context context, Handler handler, int i) {
        this.dyq = new l();
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
    public l aMx() {
        return this.dyq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uG(String str) {
        p pVar;
        if (this.dyF != null && (pVar = (p) this.dyF.get(str)) != null && !pVar.mRetaining) {
            pVar.doDestroy();
            this.dyF.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Fragment fragment) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doLoaderStart() {
        if (!this.dyv) {
            this.dyv = true;
            if (this.dyu != null) {
                this.dyu.aMB();
            } else if (!this.dyw) {
                this.dyu = d("(root)", this.dyv, false);
                if (this.dyu != null && !this.dyu.mStarted) {
                    this.dyu.aMB();
                }
            }
            this.dyw = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doLoaderStop(boolean z) {
        if (this.dyu != null && this.dyv) {
            this.dyv = false;
            if (z) {
                this.dyu.aMC();
            } else {
                this.dyu.doStop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doLoaderDestroy() {
        if (this.dyu != null) {
            this.dyu.doDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportLoaderStart() {
        if (this.dyF != null) {
            int size = this.dyF.size();
            p[] pVarArr = new p[size];
            for (int i = size - 1; i >= 0; i--) {
                pVarArr[i] = (p) this.dyF.valueAt(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                p pVar = pVarArr[i2];
                pVar.aMD();
                pVar.aMF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p d(String str, boolean z, boolean z2) {
        if (this.dyF == null) {
            this.dyF = new com.baidu.swan.support.v4.b.f<>();
        }
        p pVar = (p) this.dyF.get(str);
        if (pVar == null) {
            if (z2) {
                p pVar2 = new p(str, this, z);
                this.dyF.put(str, pVar2);
                return pVar2;
            }
            return pVar;
        }
        pVar.b(this);
        return pVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.swan.support.v4.b.f<String, o> aMw() {
        boolean z;
        if (this.dyF != null) {
            int size = this.dyF.size();
            p[] pVarArr = new p[size];
            for (int i = size - 1; i >= 0; i--) {
                pVarArr[i] = (p) this.dyF.valueAt(i);
            }
            z = false;
            for (int i2 = 0; i2 < size; i2++) {
                p pVar = pVarArr[i2];
                if (pVar.mRetaining) {
                    z = true;
                } else {
                    pVar.doDestroy();
                    this.dyF.remove(pVar.mWho);
                }
            }
        } else {
            z = false;
        }
        if (z) {
            return this.dyF;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.dyF = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.dyv);
        if (this.dyu != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.dyu)));
            printWriter.println(":");
            this.dyu.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
