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
    private j cCI;
    final com.baidu.swan.support.v4.b.g<a> cDu = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> cDv = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public final class a implements c.a<Object>, c.b<Object> {
        boolean cDA;
        boolean cDB;
        a cDC;
        final /* synthetic */ p cDD;
        o.a<Object> cDw;
        com.baidu.swan.support.v4.a.c<Object> cDx;
        boolean cDy;
        boolean cDz;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.cDz) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.cDx == null && this.cDw != null) {
                    this.cDx = this.cDw.f(this.mId, this.mArgs);
                }
                if (this.cDx != null) {
                    if (this.cDx.getClass().isMemberClass() && !Modifier.isStatic(this.cDx.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.cDx);
                    }
                    if (!this.cDB) {
                        this.cDx.a(this.mId, this);
                        this.cDx.a((c.a<Object>) this);
                        this.cDB = true;
                    }
                    this.cDx.startLoading();
                }
            }
        }

        void auL() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.cDz = this.mStarted;
            this.mStarted = false;
            this.cDw = null;
        }

        void auI() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.cDz && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.cDy && !this.cDA) {
                b(this.cDx, this.mData);
            }
        }

        void auM() {
            if (this.mStarted && this.cDA) {
                this.cDA = false;
                if (this.cDy) {
                    b(this.cDx, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.cDx != null && this.cDB) {
                this.cDB = false;
                this.cDx.a((c.b<Object>) this);
                this.cDx.b(this);
                this.cDx.stopLoading();
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
            if (this.cDw != null && this.cDx != null && this.cDy && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.cDD.cCI != null) {
                    String str2 = this.cDD.cCI.cCH.mNoTransactionsBecause;
                    this.cDD.cCI.cCH.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.cDw.a(this.cDx);
                } finally {
                    if (this.cDD.cCI != null) {
                        this.cDD.cCI.cCH.mNoTransactionsBecause = str;
                    }
                }
            }
            this.cDw = null;
            this.mData = null;
            this.cDy = false;
            if (this.cDx != null) {
                if (this.cDB) {
                    this.cDB = false;
                    this.cDx.a((c.b<Object>) this);
                    this.cDx.b(this);
                }
                this.cDx.reset();
            }
            if (this.cDC != null) {
                this.cDC.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.c<Object> cVar, Object obj) {
            String str;
            if (this.cDw != null) {
                if (this.cDD.cCI != null) {
                    String str2 = this.cDD.cCI.cCH.mNoTransactionsBecause;
                    this.cDD.cCI.cCH.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + cVar + ": " + cVar.dataToString(obj));
                    }
                    this.cDw.a(cVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.cDD.cCI != null) {
                        this.cDD.cCI.cCH.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.cDx, sb);
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
            printWriter.println(this.cDw);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.cDx);
            if (this.cDx != null) {
                this.cDx.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.cDy || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.cDy);
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
            printWriter.print(this.cDA);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.cDz);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.cDB);
            if (this.cDC != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.cDC);
                printWriter.println(":");
                this.cDC.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.cCI = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.cCI = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auG() {
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
        for (int size = this.cDu.size() - 1; size >= 0; size--) {
            this.cDu.valueAt(size).start();
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
        for (int size = this.cDu.size() - 1; size >= 0; size--) {
            this.cDu.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auH() {
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
        for (int size = this.cDu.size() - 1; size >= 0; size--) {
            this.cDu.valueAt(size).auL();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auI() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.cDu.size() - 1; size >= 0; size--) {
                this.cDu.valueAt(size).auI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auJ() {
        for (int size = this.cDu.size() - 1; size >= 0; size--) {
            this.cDu.valueAt(size).cDA = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auK() {
        for (int size = this.cDu.size() - 1; size >= 0; size--) {
            this.cDu.valueAt(size).auM();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.cDu.size() - 1; size >= 0; size--) {
                this.cDu.valueAt(size).destroy();
            }
            this.cDu.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.cDv.size() - 1; size2 >= 0; size2--) {
            this.cDv.valueAt(size2).destroy();
        }
        this.cDv.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.cCI, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.cDu.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.cDu.size(); i++) {
                a valueAt = this.cDu.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.cDu.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.cDv.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.cDv.size(); i2++) {
                a valueAt2 = this.cDv.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.cDv.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.cDu.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.cDu.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
