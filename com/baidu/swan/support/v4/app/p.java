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
    private j dbV;
    final com.baidu.swan.support.v4.b.g<a> dcI = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> dcJ = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public final class a implements c.a<Object>, c.b<Object> {
        o.a<Object> dcK;
        com.baidu.swan.support.v4.a.c<Object> dcL;
        boolean dcM;
        boolean dcN;
        boolean dcO;
        boolean dcP;
        a dcQ;
        final /* synthetic */ p dcR;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.dcN) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.dcL == null && this.dcK != null) {
                    this.dcL = this.dcK.e(this.mId, this.mArgs);
                }
                if (this.dcL != null) {
                    if (this.dcL.getClass().isMemberClass() && !Modifier.isStatic(this.dcL.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.dcL);
                    }
                    if (!this.dcP) {
                        this.dcL.a(this.mId, this);
                        this.dcL.a((c.a<Object>) this);
                        this.dcP = true;
                    }
                    this.dcL.startLoading();
                }
            }
        }

        void aDb() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.dcN = this.mStarted;
            this.mStarted = false;
            this.dcK = null;
        }

        void aCY() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.dcN && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.dcM && !this.dcO) {
                b(this.dcL, this.mData);
            }
        }

        void aDc() {
            if (this.mStarted && this.dcO) {
                this.dcO = false;
                if (this.dcM) {
                    b(this.dcL, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.dcL != null && this.dcP) {
                this.dcP = false;
                this.dcL.a((c.b<Object>) this);
                this.dcL.b(this);
                this.dcL.stopLoading();
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
            if (this.dcK != null && this.dcL != null && this.dcM && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.dcR.dbV != null) {
                    String str2 = this.dcR.dbV.dbU.mNoTransactionsBecause;
                    this.dcR.dbV.dbU.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.dcK.a(this.dcL);
                } finally {
                    if (this.dcR.dbV != null) {
                        this.dcR.dbV.dbU.mNoTransactionsBecause = str;
                    }
                }
            }
            this.dcK = null;
            this.mData = null;
            this.dcM = false;
            if (this.dcL != null) {
                if (this.dcP) {
                    this.dcP = false;
                    this.dcL.a((c.b<Object>) this);
                    this.dcL.b(this);
                }
                this.dcL.reset();
            }
            if (this.dcQ != null) {
                this.dcQ.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.c<Object> cVar, Object obj) {
            String str;
            if (this.dcK != null) {
                if (this.dcR.dbV != null) {
                    String str2 = this.dcR.dbV.dbU.mNoTransactionsBecause;
                    this.dcR.dbV.dbU.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + cVar + ": " + cVar.dataToString(obj));
                    }
                    this.dcK.a(cVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.dcR.dbV != null) {
                        this.dcR.dbV.dbU.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.dcL, sb);
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
            printWriter.println(this.dcK);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.dcL);
            if (this.dcL != null) {
                this.dcL.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.dcM || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.dcM);
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
            printWriter.print(this.dcO);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.dcN);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.dcP);
            if (this.dcQ != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.dcQ);
                printWriter.println(":");
                this.dcQ.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.dbV = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.dbV = jVar;
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
        for (int size = this.dcI.size() - 1; size >= 0; size--) {
            this.dcI.valueAt(size).start();
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
        for (int size = this.dcI.size() - 1; size >= 0; size--) {
            this.dcI.valueAt(size).stop();
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
        for (int size = this.dcI.size() - 1; size >= 0; size--) {
            this.dcI.valueAt(size).aDb();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aCY() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.dcI.size() - 1; size >= 0; size--) {
                this.dcI.valueAt(size).aCY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aCZ() {
        for (int size = this.dcI.size() - 1; size >= 0; size--) {
            this.dcI.valueAt(size).dcO = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aDa() {
        for (int size = this.dcI.size() - 1; size >= 0; size--) {
            this.dcI.valueAt(size).aDc();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.dcI.size() - 1; size >= 0; size--) {
                this.dcI.valueAt(size).destroy();
            }
            this.dcI.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.dcJ.size() - 1; size2 >= 0; size2--) {
            this.dcJ.valueAt(size2).destroy();
        }
        this.dcJ.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.dbV, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.dcI.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.dcI.size(); i++) {
                a valueAt = this.dcI.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.dcI.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.dcJ.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.dcJ.size(); i2++) {
                a valueAt2 = this.dcJ.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.dcJ.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.dcI.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.dcI.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
