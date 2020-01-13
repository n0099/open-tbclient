package com.baidu.swan.support.v4.app;

import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.support.v4.a.c;
import com.baidu.swan.support.v4.app.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class p extends o {
    static boolean DEBUG = false;
    private j cyK;
    final com.baidu.swan.support.v4.b.g<a> czw = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> czx = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public final class a implements c.a<Object>, c.b<Object> {
        boolean czA;
        boolean czB;
        boolean czC;
        boolean czD;
        a czE;
        final /* synthetic */ p czF;
        o.a<Object> czy;
        com.baidu.swan.support.v4.a.c<Object> czz;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.czB) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.czz == null && this.czy != null) {
                    this.czz = this.czy.f(this.mId, this.mArgs);
                }
                if (this.czz != null) {
                    if (this.czz.getClass().isMemberClass() && !Modifier.isStatic(this.czz.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.czz);
                    }
                    if (!this.czD) {
                        this.czz.a(this.mId, this);
                        this.czz.a((c.a<Object>) this);
                        this.czD = true;
                    }
                    this.czz.startLoading();
                }
            }
        }

        void asx() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.czB = this.mStarted;
            this.mStarted = false;
            this.czy = null;
        }

        void asu() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.czB && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.czA && !this.czC) {
                b(this.czz, this.mData);
            }
        }

        void asy() {
            if (this.mStarted && this.czC) {
                this.czC = false;
                if (this.czA) {
                    b(this.czz, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.czz != null && this.czD) {
                this.czD = false;
                this.czz.a((c.b<Object>) this);
                this.czz.b(this);
                this.czz.stopLoading();
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
            if (this.czy != null && this.czz != null && this.czA && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.czF.cyK != null) {
                    String str2 = this.czF.cyK.cyJ.mNoTransactionsBecause;
                    this.czF.cyK.cyJ.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.czy.a(this.czz);
                } finally {
                    if (this.czF.cyK != null) {
                        this.czF.cyK.cyJ.mNoTransactionsBecause = str;
                    }
                }
            }
            this.czy = null;
            this.mData = null;
            this.czA = false;
            if (this.czz != null) {
                if (this.czD) {
                    this.czD = false;
                    this.czz.a((c.b<Object>) this);
                    this.czz.b(this);
                }
                this.czz.reset();
            }
            if (this.czE != null) {
                this.czE.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.c<Object> cVar, Object obj) {
            String str;
            if (this.czy != null) {
                if (this.czF.cyK != null) {
                    String str2 = this.czF.cyK.cyJ.mNoTransactionsBecause;
                    this.czF.cyK.cyJ.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + cVar + ": " + cVar.dataToString(obj));
                    }
                    this.czy.a(cVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.czF.cyK != null) {
                        this.czF.cyK.cyJ.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.czz, sb);
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
            printWriter.println(this.czy);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.czz);
            if (this.czz != null) {
                this.czz.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.czA || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.czA);
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
            printWriter.print(this.czC);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.czB);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.czD);
            if (this.czE != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.czE);
                printWriter.println(":");
                this.czE.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.cyK = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.cyK = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ass() {
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
        for (int size = this.czw.size() - 1; size >= 0; size--) {
            this.czw.valueAt(size).start();
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
        for (int size = this.czw.size() - 1; size >= 0; size--) {
            this.czw.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ast() {
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
        for (int size = this.czw.size() - 1; size >= 0; size--) {
            this.czw.valueAt(size).asx();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asu() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.czw.size() - 1; size >= 0; size--) {
                this.czw.valueAt(size).asu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asv() {
        for (int size = this.czw.size() - 1; size >= 0; size--) {
            this.czw.valueAt(size).czC = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asw() {
        for (int size = this.czw.size() - 1; size >= 0; size--) {
            this.czw.valueAt(size).asy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.czw.size() - 1; size >= 0; size--) {
                this.czw.valueAt(size).destroy();
            }
            this.czw.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.czx.size() - 1; size2 >= 0; size2--) {
            this.czx.valueAt(size2).destroy();
        }
        this.czx.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.cyK, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.czw.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.czw.size(); i++) {
                a valueAt = this.czw.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.czw.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.czx.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.czx.size(); i2++) {
                a valueAt2 = this.czx.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.czx.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.czw.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.czw.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
