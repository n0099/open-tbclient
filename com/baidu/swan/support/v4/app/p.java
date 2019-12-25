package com.baidu.swan.support.v4.app;

import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.support.v4.a.c;
import com.baidu.swan.support.v4.app.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class p extends o {
    static boolean DEBUG = false;
    private j cyz;
    final com.baidu.swan.support.v4.b.g<a> czl = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> czm = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public final class a implements c.a<Object>, c.b<Object> {
        o.a<Object> czn;
        com.baidu.swan.support.v4.a.c<Object> czo;
        boolean czp;
        boolean czq;
        boolean czr;
        boolean czs;
        a czt;
        final /* synthetic */ p czu;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.czq) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.czo == null && this.czn != null) {
                    this.czo = this.czn.f(this.mId, this.mArgs);
                }
                if (this.czo != null) {
                    if (this.czo.getClass().isMemberClass() && !Modifier.isStatic(this.czo.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.czo);
                    }
                    if (!this.czs) {
                        this.czo.a(this.mId, this);
                        this.czo.a((c.a<Object>) this);
                        this.czs = true;
                    }
                    this.czo.startLoading();
                }
            }
        }

        void ase() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.czq = this.mStarted;
            this.mStarted = false;
            this.czn = null;
        }

        void asb() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.czq && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.czp && !this.czr) {
                b(this.czo, this.mData);
            }
        }

        void asf() {
            if (this.mStarted && this.czr) {
                this.czr = false;
                if (this.czp) {
                    b(this.czo, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.czo != null && this.czs) {
                this.czs = false;
                this.czo.a((c.b<Object>) this);
                this.czo.b(this);
                this.czo.stopLoading();
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
            if (this.czn != null && this.czo != null && this.czp && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.czu.cyz != null) {
                    String str2 = this.czu.cyz.cyy.mNoTransactionsBecause;
                    this.czu.cyz.cyy.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.czn.a(this.czo);
                } finally {
                    if (this.czu.cyz != null) {
                        this.czu.cyz.cyy.mNoTransactionsBecause = str;
                    }
                }
            }
            this.czn = null;
            this.mData = null;
            this.czp = false;
            if (this.czo != null) {
                if (this.czs) {
                    this.czs = false;
                    this.czo.a((c.b<Object>) this);
                    this.czo.b(this);
                }
                this.czo.reset();
            }
            if (this.czt != null) {
                this.czt.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.c<Object> cVar, Object obj) {
            String str;
            if (this.czn != null) {
                if (this.czu.cyz != null) {
                    String str2 = this.czu.cyz.cyy.mNoTransactionsBecause;
                    this.czu.cyz.cyy.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + cVar + ": " + cVar.dataToString(obj));
                    }
                    this.czn.a(cVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.czu.cyz != null) {
                        this.czu.cyz.cyy.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.czo, sb);
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
            printWriter.println(this.czn);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.czo);
            if (this.czo != null) {
                this.czo.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.czp || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.czp);
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
            printWriter.print(this.czr);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.czq);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.czs);
            if (this.czt != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.czt);
                printWriter.println(":");
                this.czt.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.cyz = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.cyz = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void arZ() {
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
        for (int size = this.czl.size() - 1; size >= 0; size--) {
            this.czl.valueAt(size).start();
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
        for (int size = this.czl.size() - 1; size >= 0; size--) {
            this.czl.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asa() {
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
        for (int size = this.czl.size() - 1; size >= 0; size--) {
            this.czl.valueAt(size).ase();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asb() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.czl.size() - 1; size >= 0; size--) {
                this.czl.valueAt(size).asb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asc() {
        for (int size = this.czl.size() - 1; size >= 0; size--) {
            this.czl.valueAt(size).czr = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asd() {
        for (int size = this.czl.size() - 1; size >= 0; size--) {
            this.czl.valueAt(size).asf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.czl.size() - 1; size >= 0; size--) {
                this.czl.valueAt(size).destroy();
            }
            this.czl.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.czm.size() - 1; size2 >= 0; size2--) {
            this.czm.valueAt(size2).destroy();
        }
        this.czm.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.cyz, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.czl.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.czl.size(); i++) {
                a valueAt = this.czl.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.czl.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.czm.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.czm.size(); i2++) {
                a valueAt2 = this.czm.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.czm.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.czl.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.czl.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
