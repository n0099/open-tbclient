package com.baidu.swan.support.v4.app;

import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.support.v4.a.d;
import com.baidu.swan.support.v4.app.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class p extends o {
    static boolean DEBUG = false;
    private j dHE;
    final com.baidu.swan.support.v4.b.g<a> dIq = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> dIr = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public final class a implements d.a<Object>, d.b<Object> {
        o.a<Object> dIs;
        com.baidu.swan.support.v4.a.d<Object> dIt;
        boolean dIu;
        boolean dIv;
        boolean dIw;
        boolean dIx;
        a dIy;
        final /* synthetic */ p dIz;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.dIv) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.dIt == null && this.dIs != null) {
                    this.dIt = this.dIs.e(this.mId, this.mArgs);
                }
                if (this.dIt != null) {
                    if (this.dIt.getClass().isMemberClass() && !Modifier.isStatic(this.dIt.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.dIt);
                    }
                    if (!this.dIx) {
                        this.dIt.a(this.mId, this);
                        this.dIt.a((d.a<Object>) this);
                        this.dIx = true;
                    }
                    this.dIt.startLoading();
                }
            }
        }

        void aVg() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.dIv = this.mStarted;
            this.mStarted = false;
            this.dIs = null;
        }

        void aVd() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.dIv && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.dIu && !this.dIw) {
                b(this.dIt, this.mData);
            }
        }

        void aVh() {
            if (this.mStarted && this.dIw) {
                this.dIw = false;
                if (this.dIu) {
                    b(this.dIt, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.dIt != null && this.dIx) {
                this.dIx = false;
                this.dIt.a((d.b<Object>) this);
                this.dIt.b(this);
                this.dIt.stopLoading();
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
            if (this.dIs != null && this.dIt != null && this.dIu && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.dIz.dHE != null) {
                    String str2 = this.dIz.dHE.dHD.mNoTransactionsBecause;
                    this.dIz.dHE.dHD.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.dIs.a(this.dIt);
                } finally {
                    if (this.dIz.dHE != null) {
                        this.dIz.dHE.dHD.mNoTransactionsBecause = str;
                    }
                }
            }
            this.dIs = null;
            this.mData = null;
            this.dIu = false;
            if (this.dIt != null) {
                if (this.dIx) {
                    this.dIx = false;
                    this.dIt.a((d.b<Object>) this);
                    this.dIt.b(this);
                }
                this.dIt.reset();
            }
            if (this.dIy != null) {
                this.dIy.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.d<Object> dVar, Object obj) {
            String str;
            if (this.dIs != null) {
                if (this.dIz.dHE != null) {
                    String str2 = this.dIz.dHE.dHD.mNoTransactionsBecause;
                    this.dIz.dHE.dHD.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + dVar + ": " + dVar.dataToString(obj));
                    }
                    this.dIs.a(dVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.dIz.dHE != null) {
                        this.dIz.dHE.dHD.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.dIt, sb);
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
            printWriter.println(this.dIs);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.dIt);
            if (this.dIt != null) {
                this.dIt.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.dIu || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.dIu);
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
            printWriter.print(this.dIw);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.dIv);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.dIx);
            if (this.dIy != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.dIy);
                printWriter.println(":");
                this.dIy.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.dHE = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.dHE = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVb() {
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
        for (int size = this.dIq.size() - 1; size >= 0; size--) {
            this.dIq.valueAt(size).start();
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
        for (int size = this.dIq.size() - 1; size >= 0; size--) {
            this.dIq.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVc() {
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
        for (int size = this.dIq.size() - 1; size >= 0; size--) {
            this.dIq.valueAt(size).aVg();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVd() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.dIq.size() - 1; size >= 0; size--) {
                this.dIq.valueAt(size).aVd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVe() {
        for (int size = this.dIq.size() - 1; size >= 0; size--) {
            this.dIq.valueAt(size).dIw = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVf() {
        for (int size = this.dIq.size() - 1; size >= 0; size--) {
            this.dIq.valueAt(size).aVh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.dIq.size() - 1; size >= 0; size--) {
                this.dIq.valueAt(size).destroy();
            }
            this.dIq.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.dIr.size() - 1; size2 >= 0; size2--) {
            this.dIr.valueAt(size2).destroy();
        }
        this.dIr.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.dHE, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.dIq.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.dIq.size(); i++) {
                a valueAt = this.dIq.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.dIq.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.dIr.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.dIr.size(); i2++) {
                a valueAt2 = this.dIr.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.dIr.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.dIq.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.dIq.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
