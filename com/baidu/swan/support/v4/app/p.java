package com.baidu.swan.support.v4.app;

import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.support.v4.a.d;
import com.baidu.swan.support.v4.app.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes24.dex */
public class p extends o {
    static boolean DEBUG = false;
    private j dJI;
    final com.baidu.swan.support.v4.b.g<a> dKu = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> dKv = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes24.dex */
    public final class a implements d.a<Object>, d.b<Object> {
        boolean dKA;
        boolean dKB;
        a dKC;
        final /* synthetic */ p dKD;
        o.a<Object> dKw;
        com.baidu.swan.support.v4.a.d<Object> dKx;
        boolean dKy;
        boolean dKz;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.dKz) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.dKx == null && this.dKw != null) {
                    this.dKx = this.dKw.e(this.mId, this.mArgs);
                }
                if (this.dKx != null) {
                    if (this.dKx.getClass().isMemberClass() && !Modifier.isStatic(this.dKx.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.dKx);
                    }
                    if (!this.dKB) {
                        this.dKx.a(this.mId, this);
                        this.dKx.a((d.a<Object>) this);
                        this.dKB = true;
                    }
                    this.dKx.startLoading();
                }
            }
        }

        void aVS() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.dKz = this.mStarted;
            this.mStarted = false;
            this.dKw = null;
        }

        void aVP() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.dKz && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.dKy && !this.dKA) {
                b(this.dKx, this.mData);
            }
        }

        void aVT() {
            if (this.mStarted && this.dKA) {
                this.dKA = false;
                if (this.dKy) {
                    b(this.dKx, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.dKx != null && this.dKB) {
                this.dKB = false;
                this.dKx.a((d.b<Object>) this);
                this.dKx.b(this);
                this.dKx.stopLoading();
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
            if (this.dKw != null && this.dKx != null && this.dKy && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.dKD.dJI != null) {
                    String str2 = this.dKD.dJI.dJH.mNoTransactionsBecause;
                    this.dKD.dJI.dJH.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.dKw.a(this.dKx);
                } finally {
                    if (this.dKD.dJI != null) {
                        this.dKD.dJI.dJH.mNoTransactionsBecause = str;
                    }
                }
            }
            this.dKw = null;
            this.mData = null;
            this.dKy = false;
            if (this.dKx != null) {
                if (this.dKB) {
                    this.dKB = false;
                    this.dKx.a((d.b<Object>) this);
                    this.dKx.b(this);
                }
                this.dKx.reset();
            }
            if (this.dKC != null) {
                this.dKC.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.d<Object> dVar, Object obj) {
            String str;
            if (this.dKw != null) {
                if (this.dKD.dJI != null) {
                    String str2 = this.dKD.dJI.dJH.mNoTransactionsBecause;
                    this.dKD.dJI.dJH.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + dVar + ": " + dVar.dataToString(obj));
                    }
                    this.dKw.a(dVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.dKD.dJI != null) {
                        this.dKD.dJI.dJH.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.dKx, sb);
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
            printWriter.println(this.dKw);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.dKx);
            if (this.dKx != null) {
                this.dKx.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.dKy || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.dKy);
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
            printWriter.print(this.dKA);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.dKz);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.dKB);
            if (this.dKC != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.dKC);
                printWriter.println(":");
                this.dKC.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.dJI = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.dJI = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVN() {
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
        for (int size = this.dKu.size() - 1; size >= 0; size--) {
            this.dKu.valueAt(size).start();
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
        for (int size = this.dKu.size() - 1; size >= 0; size--) {
            this.dKu.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVO() {
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
        for (int size = this.dKu.size() - 1; size >= 0; size--) {
            this.dKu.valueAt(size).aVS();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVP() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.dKu.size() - 1; size >= 0; size--) {
                this.dKu.valueAt(size).aVP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVQ() {
        for (int size = this.dKu.size() - 1; size >= 0; size--) {
            this.dKu.valueAt(size).dKA = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVR() {
        for (int size = this.dKu.size() - 1; size >= 0; size--) {
            this.dKu.valueAt(size).aVT();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.dKu.size() - 1; size >= 0; size--) {
                this.dKu.valueAt(size).destroy();
            }
            this.dKu.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.dKv.size() - 1; size2 >= 0; size2--) {
            this.dKv.valueAt(size2).destroy();
        }
        this.dKv.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.dJI, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.dKu.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.dKu.size(); i++) {
                a valueAt = this.dKu.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.dKu.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.dKv.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.dKv.size(); i2++) {
                a valueAt2 = this.dKv.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.dKv.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.dKu.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.dKu.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
