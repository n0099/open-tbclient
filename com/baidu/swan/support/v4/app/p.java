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
    private j dsB;
    final com.baidu.swan.support.v4.b.g<a> dtn = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> dto = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public final class a implements c.a<Object>, c.b<Object> {
        o.a<Object> dtp;
        com.baidu.swan.support.v4.a.c<Object> dtq;
        boolean dtr;
        boolean dtt;
        boolean dtu;
        boolean dtv;
        a dtw;
        final /* synthetic */ p dtx;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.dtt) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.dtq == null && this.dtp != null) {
                    this.dtq = this.dtp.e(this.mId, this.mArgs);
                }
                if (this.dtq != null) {
                    if (this.dtq.getClass().isMemberClass() && !Modifier.isStatic(this.dtq.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.dtq);
                    }
                    if (!this.dtv) {
                        this.dtq.a(this.mId, this);
                        this.dtq.a((c.a<Object>) this);
                        this.dtv = true;
                    }
                    this.dtq.startLoading();
                }
            }
        }

        void aIO() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.dtt = this.mStarted;
            this.mStarted = false;
            this.dtp = null;
        }

        void aIL() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.dtt && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.dtr && !this.dtu) {
                b(this.dtq, this.mData);
            }
        }

        void aIP() {
            if (this.mStarted && this.dtu) {
                this.dtu = false;
                if (this.dtr) {
                    b(this.dtq, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.dtq != null && this.dtv) {
                this.dtv = false;
                this.dtq.a((c.b<Object>) this);
                this.dtq.b(this);
                this.dtq.stopLoading();
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
            if (this.dtp != null && this.dtq != null && this.dtr && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.dtx.dsB != null) {
                    String str2 = this.dtx.dsB.dsA.mNoTransactionsBecause;
                    this.dtx.dsB.dsA.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.dtp.a(this.dtq);
                } finally {
                    if (this.dtx.dsB != null) {
                        this.dtx.dsB.dsA.mNoTransactionsBecause = str;
                    }
                }
            }
            this.dtp = null;
            this.mData = null;
            this.dtr = false;
            if (this.dtq != null) {
                if (this.dtv) {
                    this.dtv = false;
                    this.dtq.a((c.b<Object>) this);
                    this.dtq.b(this);
                }
                this.dtq.reset();
            }
            if (this.dtw != null) {
                this.dtw.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.c<Object> cVar, Object obj) {
            String str;
            if (this.dtp != null) {
                if (this.dtx.dsB != null) {
                    String str2 = this.dtx.dsB.dsA.mNoTransactionsBecause;
                    this.dtx.dsB.dsA.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + cVar + ": " + cVar.dataToString(obj));
                    }
                    this.dtp.a(cVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.dtx.dsB != null) {
                        this.dtx.dsB.dsA.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.dtq, sb);
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
            printWriter.println(this.dtp);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.dtq);
            if (this.dtq != null) {
                this.dtq.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.dtr || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.dtr);
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
            printWriter.print(this.dtu);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.dtt);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.dtv);
            if (this.dtw != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.dtw);
                printWriter.println(":");
                this.dtw.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.dsB = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.dsB = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aIJ() {
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
        for (int size = this.dtn.size() - 1; size >= 0; size--) {
            this.dtn.valueAt(size).start();
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
        for (int size = this.dtn.size() - 1; size >= 0; size--) {
            this.dtn.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aIK() {
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
        for (int size = this.dtn.size() - 1; size >= 0; size--) {
            this.dtn.valueAt(size).aIO();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aIL() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.dtn.size() - 1; size >= 0; size--) {
                this.dtn.valueAt(size).aIL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aIM() {
        for (int size = this.dtn.size() - 1; size >= 0; size--) {
            this.dtn.valueAt(size).dtu = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aIN() {
        for (int size = this.dtn.size() - 1; size >= 0; size--) {
            this.dtn.valueAt(size).aIP();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.dtn.size() - 1; size >= 0; size--) {
                this.dtn.valueAt(size).destroy();
            }
            this.dtn.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.dto.size() - 1; size2 >= 0; size2--) {
            this.dto.valueAt(size2).destroy();
        }
        this.dto.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.dsB, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.dtn.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.dtn.size(); i++) {
                a valueAt = this.dtn.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.dtn.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.dto.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.dto.size(); i2++) {
                a valueAt2 = this.dto.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.dto.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.dtn.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.dtn.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
