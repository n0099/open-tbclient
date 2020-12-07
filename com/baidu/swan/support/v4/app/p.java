package com.baidu.swan.support.v4.app;

import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.support.v4.a.d;
import com.baidu.swan.support.v4.app.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes16.dex */
public class p extends o {
    static boolean DEBUG = false;
    private j eps;
    final com.baidu.swan.support.v4.b.g<a> eqe = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> eqf = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public final class a implements d.a<Object>, d.b<Object> {
        o.a<Object> eqg;
        com.baidu.swan.support.v4.a.d<Object> eqh;
        boolean eqi;
        boolean eqj;
        boolean eqk;
        boolean eql;
        a eqm;
        final /* synthetic */ p eqn;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.eqj) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.eqh == null && this.eqg != null) {
                    this.eqh = this.eqg.e(this.mId, this.mArgs);
                }
                if (this.eqh != null) {
                    if (this.eqh.getClass().isMemberClass() && !Modifier.isStatic(this.eqh.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.eqh);
                    }
                    if (!this.eql) {
                        this.eqh.a(this.mId, this);
                        this.eqh.a((d.a<Object>) this);
                        this.eql = true;
                    }
                    this.eqh.startLoading();
                }
            }
        }

        void retain() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.eqj = this.mStarted;
            this.mStarted = false;
            this.eqg = null;
        }

        void bfp() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.eqj && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.eqi && !this.eqk) {
                b(this.eqh, this.mData);
            }
        }

        void bfs() {
            if (this.mStarted && this.eqk) {
                this.eqk = false;
                if (this.eqi) {
                    b(this.eqh, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.eqh != null && this.eql) {
                this.eql = false;
                this.eqh.a((d.b<Object>) this);
                this.eqh.b(this);
                this.eqh.stopLoading();
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
            if (this.eqg != null && this.eqh != null && this.eqi && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.eqn.eps != null) {
                    String str2 = this.eqn.eps.epr.mNoTransactionsBecause;
                    this.eqn.eps.epr.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.eqg.a(this.eqh);
                } finally {
                    if (this.eqn.eps != null) {
                        this.eqn.eps.epr.mNoTransactionsBecause = str;
                    }
                }
            }
            this.eqg = null;
            this.mData = null;
            this.eqi = false;
            if (this.eqh != null) {
                if (this.eql) {
                    this.eql = false;
                    this.eqh.a((d.b<Object>) this);
                    this.eqh.b(this);
                }
                this.eqh.reset();
            }
            if (this.eqm != null) {
                this.eqm.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.d<Object> dVar, Object obj) {
            String str;
            if (this.eqg != null) {
                if (this.eqn.eps != null) {
                    String str2 = this.eqn.eps.epr.mNoTransactionsBecause;
                    this.eqn.eps.epr.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + dVar + ": " + dVar.dataToString(obj));
                    }
                    this.eqg.a(dVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.eqn.eps != null) {
                        this.eqn.eps.epr.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.eqh, sb);
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
            printWriter.println(this.eqg);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.eqh);
            if (this.eqh != null) {
                this.eqh.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.eqi || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.eqi);
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
            printWriter.print(this.eqk);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.eqj);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.eql);
            if (this.eqm != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.eqm);
                printWriter.println(":");
                this.eqm.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.eps = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.eps = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfn() {
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
        for (int size = this.eqe.size() - 1; size >= 0; size--) {
            this.eqe.valueAt(size).start();
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
        for (int size = this.eqe.size() - 1; size >= 0; size--) {
            this.eqe.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfo() {
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
        for (int size = this.eqe.size() - 1; size >= 0; size--) {
            this.eqe.valueAt(size).retain();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfp() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.eqe.size() - 1; size >= 0; size--) {
                this.eqe.valueAt(size).bfp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfq() {
        for (int size = this.eqe.size() - 1; size >= 0; size--) {
            this.eqe.valueAt(size).eqk = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfr() {
        for (int size = this.eqe.size() - 1; size >= 0; size--) {
            this.eqe.valueAt(size).bfs();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.eqe.size() - 1; size >= 0; size--) {
                this.eqe.valueAt(size).destroy();
            }
            this.eqe.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.eqf.size() - 1; size2 >= 0; size2--) {
            this.eqf.valueAt(size2).destroy();
        }
        this.eqf.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.eps, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.eqe.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.eqe.size(); i++) {
                a valueAt = this.eqe.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.eqe.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.eqf.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.eqf.size(); i2++) {
                a valueAt2 = this.eqf.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.eqf.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.eqe.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.eqe.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
