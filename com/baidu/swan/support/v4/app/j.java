package com.baidu.swan.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.mobstat.Config;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes2.dex */
public abstract class j<E> extends h {
    private p bnB;
    private com.baidu.swan.support.v4.b.f<String, o> bnK;
    final l bnx;
    private final Activity mActivity;
    private boolean mCheckedForLoaderManager;
    final Context mContext;
    private final Handler mHandler;
    private boolean mLoadersStarted;
    final int mWindowAnimations;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler, 0);
    }

    j(Activity activity, Context context, Handler handler, int i) {
        this.bnx = new l();
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
    public l SC() {
        return this.bnx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void inactivateFragment(String str) {
        p pVar;
        if (this.bnK != null && (pVar = (p) this.bnK.get(str)) != null && !pVar.mRetaining) {
            pVar.doDestroy();
            this.bnK.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Fragment fragment) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doLoaderStart() {
        if (!this.mLoadersStarted) {
            this.mLoadersStarted = true;
            if (this.bnB != null) {
                this.bnB.doStart();
            } else if (!this.mCheckedForLoaderManager) {
                this.bnB = d("(root)", this.mLoadersStarted, false);
                if (this.bnB != null && !this.bnB.mStarted) {
                    this.bnB.doStart();
                }
            }
            this.mCheckedForLoaderManager = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doLoaderStop(boolean z) {
        if (this.bnB != null && this.mLoadersStarted) {
            this.mLoadersStarted = false;
            if (z) {
                this.bnB.doRetain();
            } else {
                this.bnB.doStop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doLoaderDestroy() {
        if (this.bnB != null) {
            this.bnB.doDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportLoaderStart() {
        if (this.bnK != null) {
            int size = this.bnK.size();
            p[] pVarArr = new p[size];
            for (int i = size - 1; i >= 0; i--) {
                pVarArr[i] = (p) this.bnK.valueAt(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                p pVar = pVarArr[i2];
                pVar.finishRetain();
                pVar.doReportStart();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p d(String str, boolean z, boolean z2) {
        if (this.bnK == null) {
            this.bnK = new com.baidu.swan.support.v4.b.f<>();
        }
        p pVar = (p) this.bnK.get(str);
        if (pVar == null) {
            if (z2) {
                p pVar2 = new p(str, this, z);
                this.bnK.put(str, pVar2);
                return pVar2;
            }
            return pVar;
        }
        pVar.b(this);
        return pVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.swan.support.v4.b.f<String, o> SB() {
        boolean z;
        if (this.bnK != null) {
            int size = this.bnK.size();
            p[] pVarArr = new p[size];
            for (int i = size - 1; i >= 0; i--) {
                pVarArr[i] = (p) this.bnK.valueAt(i);
            }
            z = false;
            for (int i2 = 0; i2 < size; i2++) {
                p pVar = pVarArr[i2];
                if (pVar.mRetaining) {
                    z = true;
                } else {
                    pVar.doDestroy();
                    this.bnK.remove(pVar.mWho);
                }
            }
        } else {
            z = false;
        }
        if (z) {
            return this.bnK;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.swan.support.v4.b.f<String, o> fVar) {
        this.bnK = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.mLoadersStarted);
        if (this.bnB != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.bnB)));
            printWriter.println(Config.TRACE_TODAY_VISIT_SPLIT);
            this.bnB.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
