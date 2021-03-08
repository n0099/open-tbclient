package com.baidu.swan.support.v4.app;

import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.support.v4.a.d;
import com.baidu.swan.support.v4.app.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class p extends o {
    static boolean DEBUG = false;
    private j exV;
    final com.baidu.swan.support.v4.b.g<a> eyK = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> eyL = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public final class a implements d.a<Object>, d.b<Object> {
        o.a<Object> eyM;
        com.baidu.swan.support.v4.a.d<Object> eyN;
        boolean eyO;
        boolean eyP;
        boolean eyQ;
        boolean eyR;
        a eyS;
        final /* synthetic */ p eyT;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.eyP) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.eyN == null && this.eyM != null) {
                    this.eyN = this.eyM.e(this.mId, this.mArgs);
                }
                if (this.eyN != null) {
                    if (this.eyN.getClass().isMemberClass() && !Modifier.isStatic(this.eyN.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.eyN);
                    }
                    if (!this.eyR) {
                        this.eyN.a(this.mId, this);
                        this.eyN.a((d.a<Object>) this);
                        this.eyR = true;
                    }
                    this.eyN.startLoading();
                }
            }
        }

        void retain() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.eyP = this.mStarted;
            this.mStarted = false;
            this.eyM = null;
        }

        void bei() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.eyP && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.eyO && !this.eyQ) {
                b(this.eyN, this.mData);
            }
        }

        void bel() {
            if (this.mStarted && this.eyQ) {
                this.eyQ = false;
                if (this.eyO) {
                    b(this.eyN, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.eyN != null && this.eyR) {
                this.eyR = false;
                this.eyN.a((d.b<Object>) this);
                this.eyN.b(this);
                this.eyN.stopLoading();
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
            if (this.eyM != null && this.eyN != null && this.eyO && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.eyT.exV != null) {
                    String str2 = this.eyT.exV.exU.mNoTransactionsBecause;
                    this.eyT.exV.exU.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.eyM.a(this.eyN);
                } finally {
                    if (this.eyT.exV != null) {
                        this.eyT.exV.exU.mNoTransactionsBecause = str;
                    }
                }
            }
            this.eyM = null;
            this.mData = null;
            this.eyO = false;
            if (this.eyN != null) {
                if (this.eyR) {
                    this.eyR = false;
                    this.eyN.a((d.b<Object>) this);
                    this.eyN.b(this);
                }
                this.eyN.reset();
            }
            if (this.eyS != null) {
                this.eyS.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.d<Object> dVar, Object obj) {
            String str;
            if (this.eyM != null) {
                if (this.eyT.exV != null) {
                    String str2 = this.eyT.exV.exU.mNoTransactionsBecause;
                    this.eyT.exV.exU.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + dVar + ": " + dVar.dataToString(obj));
                    }
                    this.eyM.a(dVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.eyT.exV != null) {
                        this.eyT.exV.exU.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.eyN, sb);
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
            printWriter.println(this.eyM);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.eyN);
            if (this.eyN != null) {
                this.eyN.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.eyO || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.eyO);
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
            printWriter.print(this.eyQ);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.eyP);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.eyR);
            if (this.eyS != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.eyS);
                printWriter.println(":");
                this.eyS.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.exV = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.exV = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beg() {
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
        for (int size = this.eyK.size() - 1; size >= 0; size--) {
            this.eyK.valueAt(size).start();
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
        for (int size = this.eyK.size() - 1; size >= 0; size--) {
            this.eyK.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beh() {
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
        for (int size = this.eyK.size() - 1; size >= 0; size--) {
            this.eyK.valueAt(size).retain();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bei() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.eyK.size() - 1; size >= 0; size--) {
                this.eyK.valueAt(size).bei();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bej() {
        for (int size = this.eyK.size() - 1; size >= 0; size--) {
            this.eyK.valueAt(size).eyQ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bek() {
        for (int size = this.eyK.size() - 1; size >= 0; size--) {
            this.eyK.valueAt(size).bel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.eyK.size() - 1; size >= 0; size--) {
                this.eyK.valueAt(size).destroy();
            }
            this.eyK.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.eyL.size() - 1; size2 >= 0; size2--) {
            this.eyL.valueAt(size2).destroy();
        }
        this.eyL.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.exV, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.eyK.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.eyK.size(); i++) {
                a valueAt = this.eyK.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.eyK.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.eyL.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.eyL.size(); i2++) {
                a valueAt2 = this.eyL.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.eyL.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.eyK.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.eyK.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
