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
    private j dHA;
    final com.baidu.swan.support.v4.b.g<a> dIm = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> dIn = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public final class a implements d.a<Object>, d.b<Object> {
        o.a<Object> dIo;
        com.baidu.swan.support.v4.a.d<Object> dIp;
        boolean dIq;
        boolean dIr;
        boolean dIs;
        boolean dIt;
        a dIu;
        final /* synthetic */ p dIv;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.dIr) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.dIp == null && this.dIo != null) {
                    this.dIp = this.dIo.e(this.mId, this.mArgs);
                }
                if (this.dIp != null) {
                    if (this.dIp.getClass().isMemberClass() && !Modifier.isStatic(this.dIp.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.dIp);
                    }
                    if (!this.dIt) {
                        this.dIp.a(this.mId, this);
                        this.dIp.a((d.a<Object>) this);
                        this.dIt = true;
                    }
                    this.dIp.startLoading();
                }
            }
        }

        void aVg() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.dIr = this.mStarted;
            this.mStarted = false;
            this.dIo = null;
        }

        void aVd() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.dIr && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.dIq && !this.dIs) {
                b(this.dIp, this.mData);
            }
        }

        void aVh() {
            if (this.mStarted && this.dIs) {
                this.dIs = false;
                if (this.dIq) {
                    b(this.dIp, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.dIp != null && this.dIt) {
                this.dIt = false;
                this.dIp.a((d.b<Object>) this);
                this.dIp.b(this);
                this.dIp.stopLoading();
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
            if (this.dIo != null && this.dIp != null && this.dIq && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.dIv.dHA != null) {
                    String str2 = this.dIv.dHA.dHz.mNoTransactionsBecause;
                    this.dIv.dHA.dHz.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.dIo.a(this.dIp);
                } finally {
                    if (this.dIv.dHA != null) {
                        this.dIv.dHA.dHz.mNoTransactionsBecause = str;
                    }
                }
            }
            this.dIo = null;
            this.mData = null;
            this.dIq = false;
            if (this.dIp != null) {
                if (this.dIt) {
                    this.dIt = false;
                    this.dIp.a((d.b<Object>) this);
                    this.dIp.b(this);
                }
                this.dIp.reset();
            }
            if (this.dIu != null) {
                this.dIu.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.d<Object> dVar, Object obj) {
            String str;
            if (this.dIo != null) {
                if (this.dIv.dHA != null) {
                    String str2 = this.dIv.dHA.dHz.mNoTransactionsBecause;
                    this.dIv.dHA.dHz.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + dVar + ": " + dVar.dataToString(obj));
                    }
                    this.dIo.a(dVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.dIv.dHA != null) {
                        this.dIv.dHA.dHz.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.dIp, sb);
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
            printWriter.println(this.dIo);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.dIp);
            if (this.dIp != null) {
                this.dIp.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.dIq || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.dIq);
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
            printWriter.print(this.dIs);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.dIr);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.dIt);
            if (this.dIu != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.dIu);
                printWriter.println(":");
                this.dIu.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.dHA = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.dHA = jVar;
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
        for (int size = this.dIm.size() - 1; size >= 0; size--) {
            this.dIm.valueAt(size).start();
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
        for (int size = this.dIm.size() - 1; size >= 0; size--) {
            this.dIm.valueAt(size).stop();
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
        for (int size = this.dIm.size() - 1; size >= 0; size--) {
            this.dIm.valueAt(size).aVg();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVd() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.dIm.size() - 1; size >= 0; size--) {
                this.dIm.valueAt(size).aVd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVe() {
        for (int size = this.dIm.size() - 1; size >= 0; size--) {
            this.dIm.valueAt(size).dIs = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVf() {
        for (int size = this.dIm.size() - 1; size >= 0; size--) {
            this.dIm.valueAt(size).aVh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.dIm.size() - 1; size >= 0; size--) {
                this.dIm.valueAt(size).destroy();
            }
            this.dIm.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.dIn.size() - 1; size2 >= 0; size2--) {
            this.dIn.valueAt(size2).destroy();
        }
        this.dIn.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.dHA, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.dIm.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.dIm.size(); i++) {
                a valueAt = this.dIm.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.dIm.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.dIn.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.dIn.size(); i2++) {
                a valueAt2 = this.dIn.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.dIn.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.dIm.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.dIm.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
