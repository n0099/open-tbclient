package com.baidu.swan.support.v4.app;

import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.support.v4.a.d;
import com.baidu.swan.support.v4.app.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class p extends o {
    static boolean DEBUG = false;
    final com.baidu.swan.support.v4.b.g<a> eeR = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> eeS = new com.baidu.swan.support.v4.b.g<>();
    private j eef;
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class a implements d.a<Object>, d.b<Object> {
        o.a<Object> eeT;
        com.baidu.swan.support.v4.a.d<Object> eeU;
        boolean eeV;
        boolean eeW;
        boolean eeX;
        boolean eeY;
        a eeZ;
        final /* synthetic */ p efa;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.eeW) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.eeU == null && this.eeT != null) {
                    this.eeU = this.eeT.e(this.mId, this.mArgs);
                }
                if (this.eeU != null) {
                    if (this.eeU.getClass().isMemberClass() && !Modifier.isStatic(this.eeU.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.eeU);
                    }
                    if (!this.eeY) {
                        this.eeU.a(this.mId, this);
                        this.eeU.a((d.a<Object>) this);
                        this.eeY = true;
                    }
                    this.eeU.startLoading();
                }
            }
        }

        void retain() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.eeW = this.mStarted;
            this.mStarted = false;
            this.eeT = null;
        }

        void bar() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.eeW && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.eeV && !this.eeX) {
                b(this.eeU, this.mData);
            }
        }

        void bau() {
            if (this.mStarted && this.eeX) {
                this.eeX = false;
                if (this.eeV) {
                    b(this.eeU, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.eeU != null && this.eeY) {
                this.eeY = false;
                this.eeU.a((d.b<Object>) this);
                this.eeU.b(this);
                this.eeU.stopLoading();
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
            if (this.eeT != null && this.eeU != null && this.eeV && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.efa.eef != null) {
                    String str2 = this.efa.eef.eee.mNoTransactionsBecause;
                    this.efa.eef.eee.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.eeT.a(this.eeU);
                } finally {
                    if (this.efa.eef != null) {
                        this.efa.eef.eee.mNoTransactionsBecause = str;
                    }
                }
            }
            this.eeT = null;
            this.mData = null;
            this.eeV = false;
            if (this.eeU != null) {
                if (this.eeY) {
                    this.eeY = false;
                    this.eeU.a((d.b<Object>) this);
                    this.eeU.b(this);
                }
                this.eeU.reset();
            }
            if (this.eeZ != null) {
                this.eeZ.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.d<Object> dVar, Object obj) {
            String str;
            if (this.eeT != null) {
                if (this.efa.eef != null) {
                    String str2 = this.efa.eef.eee.mNoTransactionsBecause;
                    this.efa.eef.eee.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + dVar + ": " + dVar.dataToString(obj));
                    }
                    this.eeT.a(dVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.efa.eef != null) {
                        this.efa.eef.eee.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.eeU, sb);
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
            printWriter.println(this.eeT);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.eeU);
            if (this.eeU != null) {
                this.eeU.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.eeV || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.eeV);
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
            printWriter.print(this.eeX);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.eeW);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.eeY);
            if (this.eeZ != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.eeZ);
                printWriter.println(":");
                this.eeZ.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.eef = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.eef = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bap() {
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
        for (int size = this.eeR.size() - 1; size >= 0; size--) {
            this.eeR.valueAt(size).start();
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
        for (int size = this.eeR.size() - 1; size >= 0; size--) {
            this.eeR.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void baq() {
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
        for (int size = this.eeR.size() - 1; size >= 0; size--) {
            this.eeR.valueAt(size).retain();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bar() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.eeR.size() - 1; size >= 0; size--) {
                this.eeR.valueAt(size).bar();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bas() {
        for (int size = this.eeR.size() - 1; size >= 0; size--) {
            this.eeR.valueAt(size).eeX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bat() {
        for (int size = this.eeR.size() - 1; size >= 0; size--) {
            this.eeR.valueAt(size).bau();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.eeR.size() - 1; size >= 0; size--) {
                this.eeR.valueAt(size).destroy();
            }
            this.eeR.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.eeS.size() - 1; size2 >= 0; size2--) {
            this.eeS.valueAt(size2).destroy();
        }
        this.eeS.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.eef, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.eeR.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.eeR.size(); i++) {
                a valueAt = this.eeR.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.eeR.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.eeS.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.eeS.size(); i2++) {
                a valueAt2 = this.eeS.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.eeS.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.eeR.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.eeR.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
