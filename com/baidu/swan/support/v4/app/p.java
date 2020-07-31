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
    private j dyr;
    final com.baidu.swan.support.v4.b.g<a> dzd = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> dze = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public final class a implements c.a<Object>, c.b<Object> {
        o.a<Object> dzf;
        com.baidu.swan.support.v4.a.c<Object> dzg;
        boolean dzh;
        boolean dzi;
        boolean dzj;
        boolean dzk;
        a dzl;
        final /* synthetic */ p dzm;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.dzi) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.dzg == null && this.dzf != null) {
                    this.dzg = this.dzf.e(this.mId, this.mArgs);
                }
                if (this.dzg != null) {
                    if (this.dzg.getClass().isMemberClass() && !Modifier.isStatic(this.dzg.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.dzg);
                    }
                    if (!this.dzk) {
                        this.dzg.a(this.mId, this);
                        this.dzg.a((c.a<Object>) this);
                        this.dzk = true;
                    }
                    this.dzg.startLoading();
                }
            }
        }

        void aMG() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.dzi = this.mStarted;
            this.mStarted = false;
            this.dzf = null;
        }

        void aMD() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.dzi && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.dzh && !this.dzj) {
                b(this.dzg, this.mData);
            }
        }

        void aMH() {
            if (this.mStarted && this.dzj) {
                this.dzj = false;
                if (this.dzh) {
                    b(this.dzg, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.dzg != null && this.dzk) {
                this.dzk = false;
                this.dzg.a((c.b<Object>) this);
                this.dzg.b(this);
                this.dzg.stopLoading();
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
            if (this.dzf != null && this.dzg != null && this.dzh && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.dzm.dyr != null) {
                    String str2 = this.dzm.dyr.dyq.mNoTransactionsBecause;
                    this.dzm.dyr.dyq.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.dzf.a(this.dzg);
                } finally {
                    if (this.dzm.dyr != null) {
                        this.dzm.dyr.dyq.mNoTransactionsBecause = str;
                    }
                }
            }
            this.dzf = null;
            this.mData = null;
            this.dzh = false;
            if (this.dzg != null) {
                if (this.dzk) {
                    this.dzk = false;
                    this.dzg.a((c.b<Object>) this);
                    this.dzg.b(this);
                }
                this.dzg.reset();
            }
            if (this.dzl != null) {
                this.dzl.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.c<Object> cVar, Object obj) {
            String str;
            if (this.dzf != null) {
                if (this.dzm.dyr != null) {
                    String str2 = this.dzm.dyr.dyq.mNoTransactionsBecause;
                    this.dzm.dyr.dyq.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + cVar + ": " + cVar.dataToString(obj));
                    }
                    this.dzf.a(cVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.dzm.dyr != null) {
                        this.dzm.dyr.dyq.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.dzg, sb);
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
            printWriter.println(this.dzf);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.dzg);
            if (this.dzg != null) {
                this.dzg.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.dzh || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.dzh);
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
            printWriter.print(this.dzj);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.dzi);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.dzk);
            if (this.dzl != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.dzl);
                printWriter.println(":");
                this.dzl.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.dyr = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.dyr = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aMB() {
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
        for (int size = this.dzd.size() - 1; size >= 0; size--) {
            this.dzd.valueAt(size).start();
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
        for (int size = this.dzd.size() - 1; size >= 0; size--) {
            this.dzd.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aMC() {
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
        for (int size = this.dzd.size() - 1; size >= 0; size--) {
            this.dzd.valueAt(size).aMG();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aMD() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.dzd.size() - 1; size >= 0; size--) {
                this.dzd.valueAt(size).aMD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aME() {
        for (int size = this.dzd.size() - 1; size >= 0; size--) {
            this.dzd.valueAt(size).dzj = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aMF() {
        for (int size = this.dzd.size() - 1; size >= 0; size--) {
            this.dzd.valueAt(size).aMH();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.dzd.size() - 1; size >= 0; size--) {
                this.dzd.valueAt(size).destroy();
            }
            this.dzd.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.dze.size() - 1; size2 >= 0; size2--) {
            this.dze.valueAt(size2).destroy();
        }
        this.dze.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.dyr, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.dzd.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.dzd.size(); i++) {
                a valueAt = this.dzd.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.dzd.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.dze.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.dze.size(); i2++) {
                a valueAt2 = this.dze.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.dze.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.dzd.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.dzd.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
