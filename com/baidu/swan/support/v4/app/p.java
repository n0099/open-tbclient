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
    private j dnP;
    final com.baidu.swan.support.v4.b.g<a> doC = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> doD = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public final class a implements c.a<Object>, c.b<Object> {
        o.a<Object> doE;
        com.baidu.swan.support.v4.a.c<Object> doF;
        boolean doG;
        boolean doH;
        boolean doI;
        boolean doJ;
        a doK;
        final /* synthetic */ p doL;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.doH) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.doF == null && this.doE != null) {
                    this.doF = this.doE.e(this.mId, this.mArgs);
                }
                if (this.doF != null) {
                    if (this.doF.getClass().isMemberClass() && !Modifier.isStatic(this.doF.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.doF);
                    }
                    if (!this.doJ) {
                        this.doF.a(this.mId, this);
                        this.doF.a((c.a<Object>) this);
                        this.doJ = true;
                    }
                    this.doF.startLoading();
                }
            }
        }

        void aHI() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.doH = this.mStarted;
            this.mStarted = false;
            this.doE = null;
        }

        void aHF() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.doH && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.doG && !this.doI) {
                b(this.doF, this.mData);
            }
        }

        void aHJ() {
            if (this.mStarted && this.doI) {
                this.doI = false;
                if (this.doG) {
                    b(this.doF, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.doF != null && this.doJ) {
                this.doJ = false;
                this.doF.a((c.b<Object>) this);
                this.doF.b(this);
                this.doF.stopLoading();
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
            if (this.doE != null && this.doF != null && this.doG && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.doL.dnP != null) {
                    String str2 = this.doL.dnP.dnO.mNoTransactionsBecause;
                    this.doL.dnP.dnO.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.doE.a(this.doF);
                } finally {
                    if (this.doL.dnP != null) {
                        this.doL.dnP.dnO.mNoTransactionsBecause = str;
                    }
                }
            }
            this.doE = null;
            this.mData = null;
            this.doG = false;
            if (this.doF != null) {
                if (this.doJ) {
                    this.doJ = false;
                    this.doF.a((c.b<Object>) this);
                    this.doF.b(this);
                }
                this.doF.reset();
            }
            if (this.doK != null) {
                this.doK.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.c<Object> cVar, Object obj) {
            String str;
            if (this.doE != null) {
                if (this.doL.dnP != null) {
                    String str2 = this.doL.dnP.dnO.mNoTransactionsBecause;
                    this.doL.dnP.dnO.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + cVar + ": " + cVar.dataToString(obj));
                    }
                    this.doE.a(cVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.doL.dnP != null) {
                        this.doL.dnP.dnO.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.doF, sb);
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
            printWriter.println(this.doE);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.doF);
            if (this.doF != null) {
                this.doF.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.doG || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.doG);
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
            printWriter.print(this.doI);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.doH);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.doJ);
            if (this.doK != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.doK);
                printWriter.println(":");
                this.doK.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.dnP = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.dnP = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aHD() {
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
        for (int size = this.doC.size() - 1; size >= 0; size--) {
            this.doC.valueAt(size).start();
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
        for (int size = this.doC.size() - 1; size >= 0; size--) {
            this.doC.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aHE() {
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
        for (int size = this.doC.size() - 1; size >= 0; size--) {
            this.doC.valueAt(size).aHI();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aHF() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.doC.size() - 1; size >= 0; size--) {
                this.doC.valueAt(size).aHF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aHG() {
        for (int size = this.doC.size() - 1; size >= 0; size--) {
            this.doC.valueAt(size).doI = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aHH() {
        for (int size = this.doC.size() - 1; size >= 0; size--) {
            this.doC.valueAt(size).aHJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.doC.size() - 1; size >= 0; size--) {
                this.doC.valueAt(size).destroy();
            }
            this.doC.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.doD.size() - 1; size2 >= 0; size2--) {
            this.doD.valueAt(size2).destroy();
        }
        this.doD.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.dnP, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.doC.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.doC.size(); i++) {
                a valueAt = this.doC.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.doC.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.doD.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.doD.size(); i2++) {
                a valueAt2 = this.doD.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.doD.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.doC.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.doC.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
