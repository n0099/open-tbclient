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
    final com.baidu.swan.support.v4.b.g<a> ezP = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> ezQ = new com.baidu.swan.support.v4.b.g<>();
    private j ezc;
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class a implements d.a<Object>, d.b<Object> {
        o.a<Object> ezR;
        com.baidu.swan.support.v4.a.d<Object> ezS;
        boolean ezT;
        boolean ezU;
        boolean ezV;
        boolean ezW;
        a ezX;
        final /* synthetic */ p ezY;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.ezU) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.ezS == null && this.ezR != null) {
                    this.ezS = this.ezR.e(this.mId, this.mArgs);
                }
                if (this.ezS != null) {
                    if (this.ezS.getClass().isMemberClass() && !Modifier.isStatic(this.ezS.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.ezS);
                    }
                    if (!this.ezW) {
                        this.ezS.a(this.mId, this);
                        this.ezS.a((d.a<Object>) this);
                        this.ezW = true;
                    }
                    this.ezS.startLoading();
                }
            }
        }

        void retain() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.ezU = this.mStarted;
            this.mStarted = false;
            this.ezR = null;
        }

        void bhM() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.ezU && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.ezT && !this.ezV) {
                b(this.ezS, this.mData);
            }
        }

        void bhP() {
            if (this.mStarted && this.ezV) {
                this.ezV = false;
                if (this.ezT) {
                    b(this.ezS, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.ezS != null && this.ezW) {
                this.ezW = false;
                this.ezS.a((d.b<Object>) this);
                this.ezS.b(this);
                this.ezS.stopLoading();
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
            if (this.ezR != null && this.ezS != null && this.ezT && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.ezY.ezc != null) {
                    String str2 = this.ezY.ezc.ezb.mNoTransactionsBecause;
                    this.ezY.ezc.ezb.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.ezR.a(this.ezS);
                } finally {
                    if (this.ezY.ezc != null) {
                        this.ezY.ezc.ezb.mNoTransactionsBecause = str;
                    }
                }
            }
            this.ezR = null;
            this.mData = null;
            this.ezT = false;
            if (this.ezS != null) {
                if (this.ezW) {
                    this.ezW = false;
                    this.ezS.a((d.b<Object>) this);
                    this.ezS.b(this);
                }
                this.ezS.reset();
            }
            if (this.ezX != null) {
                this.ezX.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.d<Object> dVar, Object obj) {
            String str;
            if (this.ezR != null) {
                if (this.ezY.ezc != null) {
                    String str2 = this.ezY.ezc.ezb.mNoTransactionsBecause;
                    this.ezY.ezc.ezb.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + dVar + ": " + dVar.dataToString(obj));
                    }
                    this.ezR.a(dVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.ezY.ezc != null) {
                        this.ezY.ezc.ezb.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.ezS, sb);
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
            printWriter.println(this.ezR);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.ezS);
            if (this.ezS != null) {
                this.ezS.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.ezT || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.ezT);
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
            printWriter.print(this.ezV);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.ezU);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.ezW);
            if (this.ezX != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.ezX);
                printWriter.println(":");
                this.ezX.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.ezc = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.ezc = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bhK() {
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
        for (int size = this.ezP.size() - 1; size >= 0; size--) {
            this.ezP.valueAt(size).start();
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
        for (int size = this.ezP.size() - 1; size >= 0; size--) {
            this.ezP.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bhL() {
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
        for (int size = this.ezP.size() - 1; size >= 0; size--) {
            this.ezP.valueAt(size).retain();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bhM() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.ezP.size() - 1; size >= 0; size--) {
                this.ezP.valueAt(size).bhM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bhN() {
        for (int size = this.ezP.size() - 1; size >= 0; size--) {
            this.ezP.valueAt(size).ezV = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bhO() {
        for (int size = this.ezP.size() - 1; size >= 0; size--) {
            this.ezP.valueAt(size).bhP();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.ezP.size() - 1; size >= 0; size--) {
                this.ezP.valueAt(size).destroy();
            }
            this.ezP.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.ezQ.size() - 1; size2 >= 0; size2--) {
            this.ezQ.valueAt(size2).destroy();
        }
        this.ezQ.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.ezc, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.ezP.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.ezP.size(); i++) {
                a valueAt = this.ezP.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.ezP.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.ezQ.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.ezQ.size(); i2++) {
                a valueAt2 = this.ezQ.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.ezQ.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.ezP.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.ezP.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
