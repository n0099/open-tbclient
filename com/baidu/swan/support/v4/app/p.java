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
    final com.baidu.swan.support.v4.b.g<a> dcN = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> dcO = new com.baidu.swan.support.v4.b.g<>();
    private j dca;
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public final class a implements c.a<Object>, c.b<Object> {
        o.a<Object> dcP;
        com.baidu.swan.support.v4.a.c<Object> dcQ;
        boolean dcR;
        boolean dcS;
        boolean dcT;
        boolean dcU;
        a dcV;
        final /* synthetic */ p dcW;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.dcS) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.dcQ == null && this.dcP != null) {
                    this.dcQ = this.dcP.e(this.mId, this.mArgs);
                }
                if (this.dcQ != null) {
                    if (this.dcQ.getClass().isMemberClass() && !Modifier.isStatic(this.dcQ.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.dcQ);
                    }
                    if (!this.dcU) {
                        this.dcQ.a(this.mId, this);
                        this.dcQ.a((c.a<Object>) this);
                        this.dcU = true;
                    }
                    this.dcQ.startLoading();
                }
            }
        }

        void aDb() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.dcS = this.mStarted;
            this.mStarted = false;
            this.dcP = null;
        }

        void aCY() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.dcS && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.dcR && !this.dcT) {
                b(this.dcQ, this.mData);
            }
        }

        void aDc() {
            if (this.mStarted && this.dcT) {
                this.dcT = false;
                if (this.dcR) {
                    b(this.dcQ, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.dcQ != null && this.dcU) {
                this.dcU = false;
                this.dcQ.a((c.b<Object>) this);
                this.dcQ.b(this);
                this.dcQ.stopLoading();
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
            if (this.dcP != null && this.dcQ != null && this.dcR && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.dcW.dca != null) {
                    String str2 = this.dcW.dca.dbZ.mNoTransactionsBecause;
                    this.dcW.dca.dbZ.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.dcP.a(this.dcQ);
                } finally {
                    if (this.dcW.dca != null) {
                        this.dcW.dca.dbZ.mNoTransactionsBecause = str;
                    }
                }
            }
            this.dcP = null;
            this.mData = null;
            this.dcR = false;
            if (this.dcQ != null) {
                if (this.dcU) {
                    this.dcU = false;
                    this.dcQ.a((c.b<Object>) this);
                    this.dcQ.b(this);
                }
                this.dcQ.reset();
            }
            if (this.dcV != null) {
                this.dcV.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.c<Object> cVar, Object obj) {
            String str;
            if (this.dcP != null) {
                if (this.dcW.dca != null) {
                    String str2 = this.dcW.dca.dbZ.mNoTransactionsBecause;
                    this.dcW.dca.dbZ.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + cVar + ": " + cVar.dataToString(obj));
                    }
                    this.dcP.a(cVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.dcW.dca != null) {
                        this.dcW.dca.dbZ.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.dcQ, sb);
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
            printWriter.println(this.dcP);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.dcQ);
            if (this.dcQ != null) {
                this.dcQ.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.dcR || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.dcR);
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
            printWriter.print(this.dcT);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.dcS);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.dcU);
            if (this.dcV != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.dcV);
                printWriter.println(":");
                this.dcV.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.dca = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.dca = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aCW() {
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
        for (int size = this.dcN.size() - 1; size >= 0; size--) {
            this.dcN.valueAt(size).start();
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
        for (int size = this.dcN.size() - 1; size >= 0; size--) {
            this.dcN.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aCX() {
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
        for (int size = this.dcN.size() - 1; size >= 0; size--) {
            this.dcN.valueAt(size).aDb();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aCY() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.dcN.size() - 1; size >= 0; size--) {
                this.dcN.valueAt(size).aCY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aCZ() {
        for (int size = this.dcN.size() - 1; size >= 0; size--) {
            this.dcN.valueAt(size).dcT = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aDa() {
        for (int size = this.dcN.size() - 1; size >= 0; size--) {
            this.dcN.valueAt(size).aDc();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.dcN.size() - 1; size >= 0; size--) {
                this.dcN.valueAt(size).destroy();
            }
            this.dcN.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.dcO.size() - 1; size2 >= 0; size2--) {
            this.dcO.valueAt(size2).destroy();
        }
        this.dcO.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.dca, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.dcN.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.dcN.size(); i++) {
                a valueAt = this.dcN.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.dcN.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.dcO.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.dcO.size(); i2++) {
                a valueAt2 = this.dcO.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.dcO.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.dcN.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.dcN.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
