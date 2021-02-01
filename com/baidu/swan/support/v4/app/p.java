package com.baidu.swan.support.v4.app;

import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.support.v4.a.d;
import com.baidu.swan.support.v4.app.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class p extends o {
    static boolean DEBUG = false;
    private j ewt;
    final com.baidu.swan.support.v4.b.g<a> exg = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> exh = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public final class a implements d.a<Object>, d.b<Object> {
        o.a<Object> exi;
        com.baidu.swan.support.v4.a.d<Object> exj;
        boolean exk;
        boolean exl;
        boolean exm;
        boolean exn;
        a exo;
        final /* synthetic */ p exp;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.exl) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.exj == null && this.exi != null) {
                    this.exj = this.exi.e(this.mId, this.mArgs);
                }
                if (this.exj != null) {
                    if (this.exj.getClass().isMemberClass() && !Modifier.isStatic(this.exj.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.exj);
                    }
                    if (!this.exn) {
                        this.exj.a(this.mId, this);
                        this.exj.a((d.a<Object>) this);
                        this.exn = true;
                    }
                    this.exj.startLoading();
                }
            }
        }

        void retain() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.exl = this.mStarted;
            this.mStarted = false;
            this.exi = null;
        }

        void beg() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.exl && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.exk && !this.exm) {
                b(this.exj, this.mData);
            }
        }

        void bej() {
            if (this.mStarted && this.exm) {
                this.exm = false;
                if (this.exk) {
                    b(this.exj, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.exj != null && this.exn) {
                this.exn = false;
                this.exj.a((d.b<Object>) this);
                this.exj.b(this);
                this.exj.stopLoading();
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
            if (this.exi != null && this.exj != null && this.exk && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.exp.ewt != null) {
                    String str2 = this.exp.ewt.ews.mNoTransactionsBecause;
                    this.exp.ewt.ews.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.exi.a(this.exj);
                } finally {
                    if (this.exp.ewt != null) {
                        this.exp.ewt.ews.mNoTransactionsBecause = str;
                    }
                }
            }
            this.exi = null;
            this.mData = null;
            this.exk = false;
            if (this.exj != null) {
                if (this.exn) {
                    this.exn = false;
                    this.exj.a((d.b<Object>) this);
                    this.exj.b(this);
                }
                this.exj.reset();
            }
            if (this.exo != null) {
                this.exo.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.d<Object> dVar, Object obj) {
            String str;
            if (this.exi != null) {
                if (this.exp.ewt != null) {
                    String str2 = this.exp.ewt.ews.mNoTransactionsBecause;
                    this.exp.ewt.ews.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + dVar + ": " + dVar.dataToString(obj));
                    }
                    this.exi.a(dVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.exp.ewt != null) {
                        this.exp.ewt.ews.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.exj, sb);
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
            printWriter.println(this.exi);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.exj);
            if (this.exj != null) {
                this.exj.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.exk || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.exk);
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
            printWriter.print(this.exm);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.exl);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.exn);
            if (this.exo != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.exo);
                printWriter.println(":");
                this.exo.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.ewt = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.ewt = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bee() {
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
        for (int size = this.exg.size() - 1; size >= 0; size--) {
            this.exg.valueAt(size).start();
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
        for (int size = this.exg.size() - 1; size >= 0; size--) {
            this.exg.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bef() {
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
        for (int size = this.exg.size() - 1; size >= 0; size--) {
            this.exg.valueAt(size).retain();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beg() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.exg.size() - 1; size >= 0; size--) {
                this.exg.valueAt(size).beg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beh() {
        for (int size = this.exg.size() - 1; size >= 0; size--) {
            this.exg.valueAt(size).exm = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bei() {
        for (int size = this.exg.size() - 1; size >= 0; size--) {
            this.exg.valueAt(size).bej();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.exg.size() - 1; size >= 0; size--) {
                this.exg.valueAt(size).destroy();
            }
            this.exg.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.exh.size() - 1; size2 >= 0; size2--) {
            this.exh.valueAt(size2).destroy();
        }
        this.exh.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.ewt, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.exg.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.exg.size(); i++) {
                a valueAt = this.exg.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.exg.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.exh.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.exh.size(); i2++) {
                a valueAt2 = this.exh.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.exh.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.exg.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.exg.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
