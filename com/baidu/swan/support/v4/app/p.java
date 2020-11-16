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
    private j eiq;
    final com.baidu.swan.support.v4.b.g<a> ejc = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> ejd = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class a implements d.a<Object>, d.b<Object> {
        o.a<Object> eje;
        com.baidu.swan.support.v4.a.d<Object> ejf;
        boolean ejg;
        boolean ejh;
        boolean eji;
        boolean ejj;
        a ejk;
        final /* synthetic */ p ejl;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.ejh) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.ejf == null && this.eje != null) {
                    this.ejf = this.eje.e(this.mId, this.mArgs);
                }
                if (this.ejf != null) {
                    if (this.ejf.getClass().isMemberClass() && !Modifier.isStatic(this.ejf.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.ejf);
                    }
                    if (!this.ejj) {
                        this.ejf.a(this.mId, this);
                        this.ejf.a((d.a<Object>) this);
                        this.ejj = true;
                    }
                    this.ejf.startLoading();
                }
            }
        }

        void retain() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.ejh = this.mStarted;
            this.mStarted = false;
            this.eje = null;
        }

        void bck() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.ejh && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.ejg && !this.eji) {
                b(this.ejf, this.mData);
            }
        }

        void bcn() {
            if (this.mStarted && this.eji) {
                this.eji = false;
                if (this.ejg) {
                    b(this.ejf, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.ejf != null && this.ejj) {
                this.ejj = false;
                this.ejf.a((d.b<Object>) this);
                this.ejf.b(this);
                this.ejf.stopLoading();
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
            if (this.eje != null && this.ejf != null && this.ejg && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.ejl.eiq != null) {
                    String str2 = this.ejl.eiq.eip.mNoTransactionsBecause;
                    this.ejl.eiq.eip.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.eje.a(this.ejf);
                } finally {
                    if (this.ejl.eiq != null) {
                        this.ejl.eiq.eip.mNoTransactionsBecause = str;
                    }
                }
            }
            this.eje = null;
            this.mData = null;
            this.ejg = false;
            if (this.ejf != null) {
                if (this.ejj) {
                    this.ejj = false;
                    this.ejf.a((d.b<Object>) this);
                    this.ejf.b(this);
                }
                this.ejf.reset();
            }
            if (this.ejk != null) {
                this.ejk.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.d<Object> dVar, Object obj) {
            String str;
            if (this.eje != null) {
                if (this.ejl.eiq != null) {
                    String str2 = this.ejl.eiq.eip.mNoTransactionsBecause;
                    this.ejl.eiq.eip.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + dVar + ": " + dVar.dataToString(obj));
                    }
                    this.eje.a(dVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.ejl.eiq != null) {
                        this.ejl.eiq.eip.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.ejf, sb);
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
            printWriter.println(this.eje);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.ejf);
            if (this.ejf != null) {
                this.ejf.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.ejg || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.ejg);
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
            printWriter.print(this.eji);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.ejh);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.ejj);
            if (this.ejk != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.ejk);
                printWriter.println(":");
                this.ejk.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.eiq = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.eiq = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bci() {
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
        for (int size = this.ejc.size() - 1; size >= 0; size--) {
            this.ejc.valueAt(size).start();
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
        for (int size = this.ejc.size() - 1; size >= 0; size--) {
            this.ejc.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bcj() {
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
        for (int size = this.ejc.size() - 1; size >= 0; size--) {
            this.ejc.valueAt(size).retain();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bck() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.ejc.size() - 1; size >= 0; size--) {
                this.ejc.valueAt(size).bck();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bcl() {
        for (int size = this.ejc.size() - 1; size >= 0; size--) {
            this.ejc.valueAt(size).eji = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bcm() {
        for (int size = this.ejc.size() - 1; size >= 0; size--) {
            this.ejc.valueAt(size).bcn();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.ejc.size() - 1; size >= 0; size--) {
                this.ejc.valueAt(size).destroy();
            }
            this.ejc.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.ejd.size() - 1; size2 >= 0; size2--) {
            this.ejd.valueAt(size2).destroy();
        }
        this.ejd.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.eiq, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.ejc.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.ejc.size(); i++) {
                a valueAt = this.ejc.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.ejc.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.ejd.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.ejd.size(); i2++) {
                a valueAt2 = this.ejd.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.ejd.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.ejc.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.ejc.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
