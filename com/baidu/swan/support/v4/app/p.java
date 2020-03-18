package com.baidu.swan.support.v4.app;

import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.support.v4.a.c;
import com.baidu.swan.support.v4.app.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class p extends o {
    static boolean DEBUG = false;
    private j cCV;
    final com.baidu.swan.support.v4.b.g<a> cDH = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> cDI = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public final class a implements c.a<Object>, c.b<Object> {
        o.a<Object> cDJ;
        com.baidu.swan.support.v4.a.c<Object> cDK;
        boolean cDL;
        boolean cDM;
        boolean cDN;
        boolean cDO;
        a cDP;
        final /* synthetic */ p cDQ;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.cDM) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.cDK == null && this.cDJ != null) {
                    this.cDK = this.cDJ.f(this.mId, this.mArgs);
                }
                if (this.cDK != null) {
                    if (this.cDK.getClass().isMemberClass() && !Modifier.isStatic(this.cDK.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.cDK);
                    }
                    if (!this.cDO) {
                        this.cDK.a(this.mId, this);
                        this.cDK.a((c.a<Object>) this);
                        this.cDO = true;
                    }
                    this.cDK.startLoading();
                }
            }
        }

        void auQ() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.cDM = this.mStarted;
            this.mStarted = false;
            this.cDJ = null;
        }

        void auN() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.cDM && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.cDL && !this.cDN) {
                b(this.cDK, this.mData);
            }
        }

        void auR() {
            if (this.mStarted && this.cDN) {
                this.cDN = false;
                if (this.cDL) {
                    b(this.cDK, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.cDK != null && this.cDO) {
                this.cDO = false;
                this.cDK.a((c.b<Object>) this);
                this.cDK.b(this);
                this.cDK.stopLoading();
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
            if (this.cDJ != null && this.cDK != null && this.cDL && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.cDQ.cCV != null) {
                    String str2 = this.cDQ.cCV.cCU.mNoTransactionsBecause;
                    this.cDQ.cCV.cCU.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.cDJ.a(this.cDK);
                } finally {
                    if (this.cDQ.cCV != null) {
                        this.cDQ.cCV.cCU.mNoTransactionsBecause = str;
                    }
                }
            }
            this.cDJ = null;
            this.mData = null;
            this.cDL = false;
            if (this.cDK != null) {
                if (this.cDO) {
                    this.cDO = false;
                    this.cDK.a((c.b<Object>) this);
                    this.cDK.b(this);
                }
                this.cDK.reset();
            }
            if (this.cDP != null) {
                this.cDP.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.c<Object> cVar, Object obj) {
            String str;
            if (this.cDJ != null) {
                if (this.cDQ.cCV != null) {
                    String str2 = this.cDQ.cCV.cCU.mNoTransactionsBecause;
                    this.cDQ.cCV.cCU.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + cVar + ": " + cVar.dataToString(obj));
                    }
                    this.cDJ.a(cVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.cDQ.cCV != null) {
                        this.cDQ.cCV.cCU.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.cDK, sb);
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
            printWriter.println(this.cDJ);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.cDK);
            if (this.cDK != null) {
                this.cDK.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.cDL || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.cDL);
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
            printWriter.print(this.cDN);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.cDM);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.cDO);
            if (this.cDP != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.cDP);
                printWriter.println(":");
                this.cDP.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.cCV = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.cCV = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auL() {
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
        for (int size = this.cDH.size() - 1; size >= 0; size--) {
            this.cDH.valueAt(size).start();
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
        for (int size = this.cDH.size() - 1; size >= 0; size--) {
            this.cDH.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auM() {
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
        for (int size = this.cDH.size() - 1; size >= 0; size--) {
            this.cDH.valueAt(size).auQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auN() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.cDH.size() - 1; size >= 0; size--) {
                this.cDH.valueAt(size).auN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auO() {
        for (int size = this.cDH.size() - 1; size >= 0; size--) {
            this.cDH.valueAt(size).cDN = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auP() {
        for (int size = this.cDH.size() - 1; size >= 0; size--) {
            this.cDH.valueAt(size).auR();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.cDH.size() - 1; size >= 0; size--) {
                this.cDH.valueAt(size).destroy();
            }
            this.cDH.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.cDI.size() - 1; size2 >= 0; size2--) {
            this.cDI.valueAt(size2).destroy();
        }
        this.cDI.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.cCV, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.cDH.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.cDH.size(); i++) {
                a valueAt = this.cDH.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.cDH.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.cDI.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.cDI.size(); i2++) {
                a valueAt2 = this.cDI.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.cDI.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.cDH.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.cDH.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
