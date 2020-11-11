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
    private j ejX;
    final com.baidu.swan.support.v4.b.g<a> ekJ = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> ekK = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class a implements d.a<Object>, d.b<Object> {
        o.a<Object> ekL;
        com.baidu.swan.support.v4.a.d<Object> ekM;
        boolean ekN;
        boolean ekO;
        boolean ekP;
        boolean ekQ;
        a ekR;
        final /* synthetic */ p ekS;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.ekO) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.ekM == null && this.ekL != null) {
                    this.ekM = this.ekL.e(this.mId, this.mArgs);
                }
                if (this.ekM != null) {
                    if (this.ekM.getClass().isMemberClass() && !Modifier.isStatic(this.ekM.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.ekM);
                    }
                    if (!this.ekQ) {
                        this.ekM.a(this.mId, this);
                        this.ekM.a((d.a<Object>) this);
                        this.ekQ = true;
                    }
                    this.ekM.startLoading();
                }
            }
        }

        void retain() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.ekO = this.mStarted;
            this.mStarted = false;
            this.ekL = null;
        }

        void bcR() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.ekO && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.ekN && !this.ekP) {
                b(this.ekM, this.mData);
            }
        }

        void bcU() {
            if (this.mStarted && this.ekP) {
                this.ekP = false;
                if (this.ekN) {
                    b(this.ekM, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.ekM != null && this.ekQ) {
                this.ekQ = false;
                this.ekM.a((d.b<Object>) this);
                this.ekM.b(this);
                this.ekM.stopLoading();
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
            if (this.ekL != null && this.ekM != null && this.ekN && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.ekS.ejX != null) {
                    String str2 = this.ekS.ejX.ejW.mNoTransactionsBecause;
                    this.ekS.ejX.ejW.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.ekL.a(this.ekM);
                } finally {
                    if (this.ekS.ejX != null) {
                        this.ekS.ejX.ejW.mNoTransactionsBecause = str;
                    }
                }
            }
            this.ekL = null;
            this.mData = null;
            this.ekN = false;
            if (this.ekM != null) {
                if (this.ekQ) {
                    this.ekQ = false;
                    this.ekM.a((d.b<Object>) this);
                    this.ekM.b(this);
                }
                this.ekM.reset();
            }
            if (this.ekR != null) {
                this.ekR.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.d<Object> dVar, Object obj) {
            String str;
            if (this.ekL != null) {
                if (this.ekS.ejX != null) {
                    String str2 = this.ekS.ejX.ejW.mNoTransactionsBecause;
                    this.ekS.ejX.ejW.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + dVar + ": " + dVar.dataToString(obj));
                    }
                    this.ekL.a(dVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.ekS.ejX != null) {
                        this.ekS.ejX.ejW.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.ekM, sb);
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
            printWriter.println(this.ekL);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.ekM);
            if (this.ekM != null) {
                this.ekM.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.ekN || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.ekN);
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
            printWriter.print(this.ekP);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.ekO);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.ekQ);
            if (this.ekR != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.ekR);
                printWriter.println(":");
                this.ekR.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.ejX = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.ejX = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bcP() {
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
        for (int size = this.ekJ.size() - 1; size >= 0; size--) {
            this.ekJ.valueAt(size).start();
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
        for (int size = this.ekJ.size() - 1; size >= 0; size--) {
            this.ekJ.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bcQ() {
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
        for (int size = this.ekJ.size() - 1; size >= 0; size--) {
            this.ekJ.valueAt(size).retain();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bcR() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.ekJ.size() - 1; size >= 0; size--) {
                this.ekJ.valueAt(size).bcR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bcS() {
        for (int size = this.ekJ.size() - 1; size >= 0; size--) {
            this.ekJ.valueAt(size).ekP = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bcT() {
        for (int size = this.ekJ.size() - 1; size >= 0; size--) {
            this.ekJ.valueAt(size).bcU();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.ekJ.size() - 1; size >= 0; size--) {
                this.ekJ.valueAt(size).destroy();
            }
            this.ekJ.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.ekK.size() - 1; size2 >= 0; size2--) {
            this.ekK.valueAt(size2).destroy();
        }
        this.ekK.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.ejX, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.ekJ.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.ekJ.size(); i++) {
                a valueAt = this.ekJ.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.ekJ.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.ekK.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.ekK.size(); i2++) {
                a valueAt2 = this.ekK.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.ekK.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.ekJ.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.ekJ.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
