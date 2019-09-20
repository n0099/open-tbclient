package com.baidu.swan.support.v4.app;

import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.support.v4.a.b;
import com.baidu.swan.support.v4.app.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class p extends o {
    static boolean DEBUG = false;
    private j buR;
    final com.baidu.swan.support.v4.b.g<a> bvB = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> bvC = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class a implements b.a<Object>, b.InterfaceC0237b<Object> {
        o.a<Object> bvD;
        com.baidu.swan.support.v4.a.b<Object> bvE;
        a bvF;
        final /* synthetic */ p bvG;
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
                if (this.bvE == null && this.bvD != null) {
                    this.bvE = this.bvD.f(this.mId, this.mArgs);
                }
                if (this.bvE != null) {
                    if (this.bvE.getClass().isMemberClass() && !Modifier.isStatic(this.bvE.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.bvE);
                    }
                    if (!this.mListenerRegistered) {
                        this.bvE.a(this.mId, this);
                        this.bvE.a((b.a<Object>) this);
                        this.mListenerRegistered = true;
                    }
                    this.bvE.startLoading();
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
            this.bvD = null;
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
                b(this.bvE, this.mData);
            }
        }

        void reportStart() {
            if (this.mStarted && this.mReportNextStart) {
                this.mReportNextStart = false;
                if (this.mHaveData) {
                    b(this.bvE, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.bvE != null && this.mListenerRegistered) {
                this.mListenerRegistered = false;
                this.bvE.a((b.InterfaceC0237b<Object>) this);
                this.bvE.b(this);
                this.bvE.stopLoading();
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
            if (this.bvD != null && this.bvE != null && this.mHaveData && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.bvG.buR != null) {
                    String str2 = this.bvG.buR.buQ.mNoTransactionsBecause;
                    this.bvG.buR.buQ.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.bvD.a(this.bvE);
                } finally {
                    if (this.bvG.buR != null) {
                        this.bvG.buR.buQ.mNoTransactionsBecause = str;
                    }
                }
            }
            this.bvD = null;
            this.mData = null;
            this.mHaveData = false;
            if (this.bvE != null) {
                if (this.mListenerRegistered) {
                    this.mListenerRegistered = false;
                    this.bvE.a((b.InterfaceC0237b<Object>) this);
                    this.bvE.b(this);
                }
                this.bvE.reset();
            }
            if (this.bvF != null) {
                this.bvF.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.b<Object> bVar, Object obj) {
            String str;
            if (this.bvD != null) {
                if (this.bvG.buR != null) {
                    String str2 = this.bvG.buR.buQ.mNoTransactionsBecause;
                    this.bvG.buR.buQ.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + bVar + ": " + bVar.dataToString(obj));
                    }
                    this.bvD.a(bVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.bvG.buR != null) {
                        this.bvG.buR.buQ.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.bvE, sb);
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
            printWriter.println(this.bvD);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.bvE);
            if (this.bvE != null) {
                this.bvE.dump(str + "  ", fileDescriptor, printWriter, strArr);
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
            if (this.bvF != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.bvF);
                printWriter.println(":");
                this.bvF.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.buR = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.buR = jVar;
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
        for (int size = this.bvB.size() - 1; size >= 0; size--) {
            this.bvB.valueAt(size).start();
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
        for (int size = this.bvB.size() - 1; size >= 0; size--) {
            this.bvB.valueAt(size).stop();
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
        for (int size = this.bvB.size() - 1; size >= 0; size--) {
            this.bvB.valueAt(size).retain();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void finishRetain() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.bvB.size() - 1; size >= 0; size--) {
                this.bvB.valueAt(size).finishRetain();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doReportNextStart() {
        for (int size = this.bvB.size() - 1; size >= 0; size--) {
            this.bvB.valueAt(size).mReportNextStart = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doReportStart() {
        for (int size = this.bvB.size() - 1; size >= 0; size--) {
            this.bvB.valueAt(size).reportStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.bvB.size() - 1; size >= 0; size--) {
                this.bvB.valueAt(size).destroy();
            }
            this.bvB.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.bvC.size() - 1; size2 >= 0; size2--) {
            this.bvC.valueAt(size2).destroy();
        }
        this.bvC.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.buR, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.bvB.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.bvB.size(); i++) {
                a valueAt = this.bvB.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.bvB.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.bvC.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.bvC.size(); i2++) {
                a valueAt2 = this.bvC.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.bvC.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.bvB.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.bvB.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
