package com.baidu.swan.support.v4.app;

import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.support.v4.a.d;
import com.baidu.swan.support.v4.app.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class p extends o {
    static boolean DEBUG = false;
    private j dVJ;
    final com.baidu.swan.support.v4.b.g<a> dWv = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> dWw = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class a implements d.a<Object>, d.b<Object> {
        boolean dWA;
        boolean dWB;
        boolean dWC;
        a dWD;
        final /* synthetic */ p dWE;
        o.a<Object> dWx;
        com.baidu.swan.support.v4.a.d<Object> dWy;
        boolean dWz;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.dWA) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.dWy == null && this.dWx != null) {
                    this.dWy = this.dWx.e(this.mId, this.mArgs);
                }
                if (this.dWy != null) {
                    if (this.dWy.getClass().isMemberClass() && !Modifier.isStatic(this.dWy.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.dWy);
                    }
                    if (!this.dWC) {
                        this.dWy.a(this.mId, this);
                        this.dWy.a((d.a<Object>) this);
                        this.dWC = true;
                    }
                    this.dWy.startLoading();
                }
            }
        }

        void retain() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.dWA = this.mStarted;
            this.mStarted = false;
            this.dWx = null;
        }

        void aYy() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.dWA && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.dWz && !this.dWB) {
                b(this.dWy, this.mData);
            }
        }

        void aYB() {
            if (this.mStarted && this.dWB) {
                this.dWB = false;
                if (this.dWz) {
                    b(this.dWy, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.dWy != null && this.dWC) {
                this.dWC = false;
                this.dWy.a((d.b<Object>) this);
                this.dWy.b(this);
                this.dWy.stopLoading();
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
            if (this.dWx != null && this.dWy != null && this.dWz && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.dWE.dVJ != null) {
                    String str2 = this.dWE.dVJ.dVI.mNoTransactionsBecause;
                    this.dWE.dVJ.dVI.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.dWx.a(this.dWy);
                } finally {
                    if (this.dWE.dVJ != null) {
                        this.dWE.dVJ.dVI.mNoTransactionsBecause = str;
                    }
                }
            }
            this.dWx = null;
            this.mData = null;
            this.dWz = false;
            if (this.dWy != null) {
                if (this.dWC) {
                    this.dWC = false;
                    this.dWy.a((d.b<Object>) this);
                    this.dWy.b(this);
                }
                this.dWy.reset();
            }
            if (this.dWD != null) {
                this.dWD.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.d<Object> dVar, Object obj) {
            String str;
            if (this.dWx != null) {
                if (this.dWE.dVJ != null) {
                    String str2 = this.dWE.dVJ.dVI.mNoTransactionsBecause;
                    this.dWE.dVJ.dVI.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + dVar + ": " + dVar.dataToString(obj));
                    }
                    this.dWx.a(dVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.dWE.dVJ != null) {
                        this.dWE.dVJ.dVI.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.dWy, sb);
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
            printWriter.println(this.dWx);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.dWy);
            if (this.dWy != null) {
                this.dWy.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.dWz || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.dWz);
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
            printWriter.print(this.dWB);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.dWA);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.dWC);
            if (this.dWD != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.dWD);
                printWriter.println(":");
                this.dWD.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.dVJ = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.dVJ = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aYw() {
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
        for (int size = this.dWv.size() - 1; size >= 0; size--) {
            this.dWv.valueAt(size).start();
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
        for (int size = this.dWv.size() - 1; size >= 0; size--) {
            this.dWv.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aYx() {
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
        for (int size = this.dWv.size() - 1; size >= 0; size--) {
            this.dWv.valueAt(size).retain();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aYy() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.dWv.size() - 1; size >= 0; size--) {
                this.dWv.valueAt(size).aYy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aYz() {
        for (int size = this.dWv.size() - 1; size >= 0; size--) {
            this.dWv.valueAt(size).dWB = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aYA() {
        for (int size = this.dWv.size() - 1; size >= 0; size--) {
            this.dWv.valueAt(size).aYB();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.dWv.size() - 1; size >= 0; size--) {
                this.dWv.valueAt(size).destroy();
            }
            this.dWv.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.dWw.size() - 1; size2 >= 0; size2--) {
            this.dWw.valueAt(size2).destroy();
        }
        this.dWw.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.dVJ, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.dWv.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.dWv.size(); i++) {
                a valueAt = this.dWv.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.dWv.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.dWw.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.dWw.size(); i2++) {
                a valueAt2 = this.dWw.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.dWw.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.dWv.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.dWv.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
