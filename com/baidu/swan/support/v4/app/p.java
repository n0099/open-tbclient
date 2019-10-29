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
    private j bNA;
    final com.baidu.swan.support.v4.b.g<a> bOk = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> bOl = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class a implements b.a<Object>, b.InterfaceC0269b<Object> {
        o.a<Object> bOm;
        com.baidu.swan.support.v4.a.b<Object> bOn;
        a bOo;
        final /* synthetic */ p bOp;
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
                if (this.bOn == null && this.bOm != null) {
                    this.bOn = this.bOm.f(this.mId, this.mArgs);
                }
                if (this.bOn != null) {
                    if (this.bOn.getClass().isMemberClass() && !Modifier.isStatic(this.bOn.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.bOn);
                    }
                    if (!this.mListenerRegistered) {
                        this.bOn.a(this.mId, this);
                        this.bOn.a((b.a<Object>) this);
                        this.mListenerRegistered = true;
                    }
                    this.bOn.startLoading();
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
            this.bOm = null;
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
                b(this.bOn, this.mData);
            }
        }

        void reportStart() {
            if (this.mStarted && this.mReportNextStart) {
                this.mReportNextStart = false;
                if (this.mHaveData) {
                    b(this.bOn, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.bOn != null && this.mListenerRegistered) {
                this.mListenerRegistered = false;
                this.bOn.a((b.InterfaceC0269b<Object>) this);
                this.bOn.b(this);
                this.bOn.stopLoading();
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
            if (this.bOm != null && this.bOn != null && this.mHaveData && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.bOp.bNA != null) {
                    String str2 = this.bOp.bNA.bNz.mNoTransactionsBecause;
                    this.bOp.bNA.bNz.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.bOm.a(this.bOn);
                } finally {
                    if (this.bOp.bNA != null) {
                        this.bOp.bNA.bNz.mNoTransactionsBecause = str;
                    }
                }
            }
            this.bOm = null;
            this.mData = null;
            this.mHaveData = false;
            if (this.bOn != null) {
                if (this.mListenerRegistered) {
                    this.mListenerRegistered = false;
                    this.bOn.a((b.InterfaceC0269b<Object>) this);
                    this.bOn.b(this);
                }
                this.bOn.reset();
            }
            if (this.bOo != null) {
                this.bOo.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.b<Object> bVar, Object obj) {
            String str;
            if (this.bOm != null) {
                if (this.bOp.bNA != null) {
                    String str2 = this.bOp.bNA.bNz.mNoTransactionsBecause;
                    this.bOp.bNA.bNz.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + bVar + ": " + bVar.dataToString(obj));
                    }
                    this.bOm.a(bVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.bOp.bNA != null) {
                        this.bOp.bNA.bNz.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.bOn, sb);
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
            printWriter.println(this.bOm);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.bOn);
            if (this.bOn != null) {
                this.bOn.dump(str + "  ", fileDescriptor, printWriter, strArr);
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
            if (this.bOo != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.bOo);
                printWriter.println(":");
                this.bOo.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.bNA = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.bNA = jVar;
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
        for (int size = this.bOk.size() - 1; size >= 0; size--) {
            this.bOk.valueAt(size).start();
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
        for (int size = this.bOk.size() - 1; size >= 0; size--) {
            this.bOk.valueAt(size).stop();
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
        for (int size = this.bOk.size() - 1; size >= 0; size--) {
            this.bOk.valueAt(size).retain();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void finishRetain() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.bOk.size() - 1; size >= 0; size--) {
                this.bOk.valueAt(size).finishRetain();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doReportNextStart() {
        for (int size = this.bOk.size() - 1; size >= 0; size--) {
            this.bOk.valueAt(size).mReportNextStart = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doReportStart() {
        for (int size = this.bOk.size() - 1; size >= 0; size--) {
            this.bOk.valueAt(size).reportStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.bOk.size() - 1; size >= 0; size--) {
                this.bOk.valueAt(size).destroy();
            }
            this.bOk.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.bOl.size() - 1; size2 >= 0; size2--) {
            this.bOl.valueAt(size2).destroy();
        }
        this.bOl.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.bNA, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.bOk.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.bOk.size(); i++) {
                a valueAt = this.bOk.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.bOk.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.bOl.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.bOl.size(); i2++) {
                a valueAt2 = this.bOl.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.bOl.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.bOk.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.bOk.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
