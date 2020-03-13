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
    private j cCK;
    final com.baidu.swan.support.v4.b.g<a> cDw = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> cDx = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public final class a implements c.a<Object>, c.b<Object> {
        boolean cDA;
        boolean cDB;
        boolean cDC;
        boolean cDD;
        a cDE;
        final /* synthetic */ p cDF;
        o.a<Object> cDy;
        com.baidu.swan.support.v4.a.c<Object> cDz;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.cDB) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.cDz == null && this.cDy != null) {
                    this.cDz = this.cDy.f(this.mId, this.mArgs);
                }
                if (this.cDz != null) {
                    if (this.cDz.getClass().isMemberClass() && !Modifier.isStatic(this.cDz.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.cDz);
                    }
                    if (!this.cDD) {
                        this.cDz.a(this.mId, this);
                        this.cDz.a((c.a<Object>) this);
                        this.cDD = true;
                    }
                    this.cDz.startLoading();
                }
            }
        }

        void auN() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.cDB = this.mStarted;
            this.mStarted = false;
            this.cDy = null;
        }

        void auK() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.cDB && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.cDA && !this.cDC) {
                b(this.cDz, this.mData);
            }
        }

        void auO() {
            if (this.mStarted && this.cDC) {
                this.cDC = false;
                if (this.cDA) {
                    b(this.cDz, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.cDz != null && this.cDD) {
                this.cDD = false;
                this.cDz.a((c.b<Object>) this);
                this.cDz.b(this);
                this.cDz.stopLoading();
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
            if (this.cDy != null && this.cDz != null && this.cDA && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.cDF.cCK != null) {
                    String str2 = this.cDF.cCK.cCJ.mNoTransactionsBecause;
                    this.cDF.cCK.cCJ.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.cDy.a(this.cDz);
                } finally {
                    if (this.cDF.cCK != null) {
                        this.cDF.cCK.cCJ.mNoTransactionsBecause = str;
                    }
                }
            }
            this.cDy = null;
            this.mData = null;
            this.cDA = false;
            if (this.cDz != null) {
                if (this.cDD) {
                    this.cDD = false;
                    this.cDz.a((c.b<Object>) this);
                    this.cDz.b(this);
                }
                this.cDz.reset();
            }
            if (this.cDE != null) {
                this.cDE.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.c<Object> cVar, Object obj) {
            String str;
            if (this.cDy != null) {
                if (this.cDF.cCK != null) {
                    String str2 = this.cDF.cCK.cCJ.mNoTransactionsBecause;
                    this.cDF.cCK.cCJ.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + cVar + ": " + cVar.dataToString(obj));
                    }
                    this.cDy.a(cVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.cDF.cCK != null) {
                        this.cDF.cCK.cCJ.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.cDz, sb);
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
            printWriter.println(this.cDy);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.cDz);
            if (this.cDz != null) {
                this.cDz.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.cDA || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.cDA);
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
            printWriter.print(this.cDC);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.cDB);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.cDD);
            if (this.cDE != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.cDE);
                printWriter.println(":");
                this.cDE.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.cCK = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.cCK = jVar;
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
        for (int size = this.cDw.size() - 1; size >= 0; size--) {
            this.cDw.valueAt(size).start();
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
        for (int size = this.cDw.size() - 1; size >= 0; size--) {
            this.cDw.valueAt(size).stop();
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
        for (int size = this.cDw.size() - 1; size >= 0; size--) {
            this.cDw.valueAt(size).auN();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auK() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.cDw.size() - 1; size >= 0; size--) {
                this.cDw.valueAt(size).auK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auL() {
        for (int size = this.cDw.size() - 1; size >= 0; size--) {
            this.cDw.valueAt(size).cDC = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auM() {
        for (int size = this.cDw.size() - 1; size >= 0; size--) {
            this.cDw.valueAt(size).auO();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.cDw.size() - 1; size >= 0; size--) {
                this.cDw.valueAt(size).destroy();
            }
            this.cDw.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.cDx.size() - 1; size2 >= 0; size2--) {
            this.cDx.valueAt(size2).destroy();
        }
        this.cDx.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.cCK, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.cDw.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.cDw.size(); i++) {
                a valueAt = this.cDw.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.cDw.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.cDx.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.cDx.size(); i2++) {
                a valueAt2 = this.cDx.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.cDx.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.cDw.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.cDw.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
