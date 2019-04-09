package com.baidu.swan.support.v4.app;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.swan.support.v4.a.b;
import com.baidu.swan.support.v4.app.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class p extends o {
    static boolean DEBUG = false;
    private j bnC;
    final com.baidu.swan.support.v4.b.g<a> bom = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> bon = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class a implements b.a<Object>, b.InterfaceC0212b<Object> {
        o.a<Object> boo;
        com.baidu.swan.support.v4.a.b<Object> bop;
        a boq;
        final /* synthetic */ p bor;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        boolean mHaveData;
        final int mId;
        boolean mListenerRegistered;
        boolean mReportNextStart;
        boolean mRetaining;
        boolean mRetainingStarted;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.mRetainingStarted) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.bop == null && this.boo != null) {
                    this.bop = this.boo.f(this.mId, this.mArgs);
                }
                if (this.bop != null) {
                    if (this.bop.getClass().isMemberClass() && !Modifier.isStatic(this.bop.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.bop);
                    }
                    if (!this.mListenerRegistered) {
                        this.bop.a(this.mId, this);
                        this.bop.a((b.a<Object>) this);
                        this.mListenerRegistered = true;
                    }
                    this.bop.startLoading();
                }
            }
        }

        void retain() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.mRetainingStarted = this.mStarted;
            this.mStarted = false;
            this.boo = null;
        }

        void finishRetain() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.mRetainingStarted && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.mHaveData && !this.mReportNextStart) {
                b(this.bop, this.mData);
            }
        }

        void reportStart() {
            if (this.mStarted && this.mReportNextStart) {
                this.mReportNextStart = false;
                if (this.mHaveData) {
                    b(this.bop, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.bop != null && this.mListenerRegistered) {
                this.mListenerRegistered = false;
                this.bop.a((b.InterfaceC0212b<Object>) this);
                this.bop.b(this);
                this.bop.stopLoading();
            }
        }

        void destroy() {
            String str;
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.mDestroyed = true;
            boolean z = this.mDeliveredData;
            this.mDeliveredData = false;
            if (this.boo != null && this.bop != null && this.mHaveData && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.bor.bnC != null) {
                    String str2 = this.bor.bnC.bnB.mNoTransactionsBecause;
                    this.bor.bnC.bnB.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.boo.a(this.bop);
                } finally {
                    if (this.bor.bnC != null) {
                        this.bor.bnC.bnB.mNoTransactionsBecause = str;
                    }
                }
            }
            this.boo = null;
            this.mData = null;
            this.mHaveData = false;
            if (this.bop != null) {
                if (this.mListenerRegistered) {
                    this.mListenerRegistered = false;
                    this.bop.a((b.InterfaceC0212b<Object>) this);
                    this.bop.b(this);
                }
                this.bop.reset();
            }
            if (this.boq != null) {
                this.boq.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.b<Object> bVar, Object obj) {
            String str;
            if (this.boo != null) {
                if (this.bor.bnC != null) {
                    String str2 = this.bor.bnC.bnB.mNoTransactionsBecause;
                    this.bor.bnC.bnB.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + bVar + ": " + bVar.dataToString(obj));
                    }
                    this.boo.a(bVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.bor.bnC != null) {
                        this.bor.bnC.bnB.mNoTransactionsBecause = str;
                    }
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.mId);
            sb.append(" : ");
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.bop, sb);
            sb.append("}}");
            return sb.toString();
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.mId);
            printWriter.print(" mArgs=");
            printWriter.println(this.mArgs);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.boo);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.bop);
            if (this.bop != null) {
                this.bop.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.mHaveData || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.mHaveData);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.mDeliveredData);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.mData);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.mStarted);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.mReportNextStart);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.mRetainingStarted);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.mListenerRegistered);
            if (this.boq != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.boq);
                printWriter.println(Config.TRACE_TODAY_VISIT_SPLIT);
                this.boq.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.bnC = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.bnC = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doStart() {
        if (DEBUG) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.mStarted) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.mStarted = true;
        for (int size = this.bom.size() - 1; size >= 0; size--) {
            this.bom.valueAt(size).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doStop() {
        if (DEBUG) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (!this.mStarted) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
            return;
        }
        for (int size = this.bom.size() - 1; size >= 0; size--) {
            this.bom.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doRetain() {
        if (DEBUG) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (!this.mStarted) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
            return;
        }
        this.mRetaining = true;
        this.mStarted = false;
        for (int size = this.bom.size() - 1; size >= 0; size--) {
            this.bom.valueAt(size).retain();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void finishRetain() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.bom.size() - 1; size >= 0; size--) {
                this.bom.valueAt(size).finishRetain();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doReportNextStart() {
        for (int size = this.bom.size() - 1; size >= 0; size--) {
            this.bom.valueAt(size).mReportNextStart = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doReportStart() {
        for (int size = this.bom.size() - 1; size >= 0; size--) {
            this.bom.valueAt(size).reportStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.bom.size() - 1; size >= 0; size--) {
                this.bom.valueAt(size).destroy();
            }
            this.bom.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.bon.size() - 1; size2 >= 0; size2--) {
            this.bon.valueAt(size2).destroy();
        }
        this.bon.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.bnC, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.bom.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.bom.size(); i++) {
                a valueAt = this.bom.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.bom.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.bon.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.bon.size(); i2++) {
                a valueAt2 = this.bon.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.bon.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.bom.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.bom.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
