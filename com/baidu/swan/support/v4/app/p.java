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
    private j cCJ;
    final com.baidu.swan.support.v4.b.g<a> cDv = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> cDw = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public final class a implements c.a<Object>, c.b<Object> {
        boolean cDA;
        boolean cDB;
        boolean cDC;
        a cDD;
        final /* synthetic */ p cDE;
        o.a<Object> cDx;
        com.baidu.swan.support.v4.a.c<Object> cDy;
        boolean cDz;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.cDA) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.cDy == null && this.cDx != null) {
                    this.cDy = this.cDx.f(this.mId, this.mArgs);
                }
                if (this.cDy != null) {
                    if (this.cDy.getClass().isMemberClass() && !Modifier.isStatic(this.cDy.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.cDy);
                    }
                    if (!this.cDC) {
                        this.cDy.a(this.mId, this);
                        this.cDy.a((c.a<Object>) this);
                        this.cDC = true;
                    }
                    this.cDy.startLoading();
                }
            }
        }

        void auN() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.cDA = this.mStarted;
            this.mStarted = false;
            this.cDx = null;
        }

        void auK() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.cDA && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.cDz && !this.cDB) {
                b(this.cDy, this.mData);
            }
        }

        void auO() {
            if (this.mStarted && this.cDB) {
                this.cDB = false;
                if (this.cDz) {
                    b(this.cDy, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.cDy != null && this.cDC) {
                this.cDC = false;
                this.cDy.a((c.b<Object>) this);
                this.cDy.b(this);
                this.cDy.stopLoading();
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
            if (this.cDx != null && this.cDy != null && this.cDz && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.cDE.cCJ != null) {
                    String str2 = this.cDE.cCJ.cCI.mNoTransactionsBecause;
                    this.cDE.cCJ.cCI.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.cDx.a(this.cDy);
                } finally {
                    if (this.cDE.cCJ != null) {
                        this.cDE.cCJ.cCI.mNoTransactionsBecause = str;
                    }
                }
            }
            this.cDx = null;
            this.mData = null;
            this.cDz = false;
            if (this.cDy != null) {
                if (this.cDC) {
                    this.cDC = false;
                    this.cDy.a((c.b<Object>) this);
                    this.cDy.b(this);
                }
                this.cDy.reset();
            }
            if (this.cDD != null) {
                this.cDD.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.c<Object> cVar, Object obj) {
            String str;
            if (this.cDx != null) {
                if (this.cDE.cCJ != null) {
                    String str2 = this.cDE.cCJ.cCI.mNoTransactionsBecause;
                    this.cDE.cCJ.cCI.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + cVar + ": " + cVar.dataToString(obj));
                    }
                    this.cDx.a(cVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.cDE.cCJ != null) {
                        this.cDE.cCJ.cCI.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.cDy, sb);
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
            printWriter.println(this.cDx);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.cDy);
            if (this.cDy != null) {
                this.cDy.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.cDz || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.cDz);
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
            printWriter.print(this.cDB);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.cDA);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.cDC);
            if (this.cDD != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.cDD);
                printWriter.println(":");
                this.cDD.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.cCJ = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.cCJ = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auI() {
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
        for (int size = this.cDv.size() - 1; size >= 0; size--) {
            this.cDv.valueAt(size).start();
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
        for (int size = this.cDv.size() - 1; size >= 0; size--) {
            this.cDv.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auJ() {
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
        for (int size = this.cDv.size() - 1; size >= 0; size--) {
            this.cDv.valueAt(size).auN();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auK() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.cDv.size() - 1; size >= 0; size--) {
                this.cDv.valueAt(size).auK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auL() {
        for (int size = this.cDv.size() - 1; size >= 0; size--) {
            this.cDv.valueAt(size).cDB = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auM() {
        for (int size = this.cDv.size() - 1; size >= 0; size--) {
            this.cDv.valueAt(size).auO();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.cDv.size() - 1; size >= 0; size--) {
                this.cDv.valueAt(size).destroy();
            }
            this.cDv.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.cDw.size() - 1; size2 >= 0; size2--) {
            this.cDw.valueAt(size2).destroy();
        }
        this.cDw.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.cCJ, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.cDv.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.cDv.size(); i++) {
                a valueAt = this.cDv.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.cDv.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.cDw.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.cDw.size(); i2++) {
                a valueAt2 = this.cDw.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.cDw.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.cDv.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.cDv.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
