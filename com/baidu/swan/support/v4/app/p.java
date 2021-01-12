package com.baidu.swan.support.v4.app;

import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.support.v4.a.d;
import com.baidu.swan.support.v4.app.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class p extends o {
    static boolean DEBUG = false;
    private j eun;
    final com.baidu.swan.support.v4.b.g<a> eva = new com.baidu.swan.support.v4.b.g<>();
    final com.baidu.swan.support.v4.b.g<a> evb = new com.baidu.swan.support.v4.b.g<>();
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public final class a implements d.a<Object>, d.b<Object> {
        o.a<Object> evc;
        com.baidu.swan.support.v4.a.d<Object> evd;
        boolean eve;
        boolean evf;
        boolean evg;
        boolean evh;
        a evi;
        final /* synthetic */ p evj;
        final Bundle mArgs;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        void start() {
            if (this.mRetaining && this.evf) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.evd == null && this.evc != null) {
                    this.evd = this.evc.e(this.mId, this.mArgs);
                }
                if (this.evd != null) {
                    if (this.evd.getClass().isMemberClass() && !Modifier.isStatic(this.evd.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.evd);
                    }
                    if (!this.evh) {
                        this.evd.a(this.mId, this);
                        this.evd.a((d.a<Object>) this);
                        this.evh = true;
                    }
                    this.evd.startLoading();
                }
            }
        }

        void retain() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.evf = this.mStarted;
            this.mStarted = false;
            this.evc = null;
        }

        void bdT() {
            if (this.mRetaining) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (this.mStarted != this.evf && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.eve && !this.evg) {
                b(this.evd, this.mData);
            }
        }

        void bdW() {
            if (this.mStarted && this.evg) {
                this.evg = false;
                if (this.eve) {
                    b(this.evd, this.mData);
                }
            }
        }

        void stop() {
            if (p.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.evd != null && this.evh) {
                this.evh = false;
                this.evd.a((d.b<Object>) this);
                this.evd.b(this);
                this.evd.stopLoading();
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
            if (this.evc != null && this.evd != null && this.eve && z) {
                if (p.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.evj.eun != null) {
                    String str2 = this.evj.eun.eum.mNoTransactionsBecause;
                    this.evj.eun.eum.mNoTransactionsBecause = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.evc.a(this.evd);
                } finally {
                    if (this.evj.eun != null) {
                        this.evj.eun.eum.mNoTransactionsBecause = str;
                    }
                }
            }
            this.evc = null;
            this.mData = null;
            this.eve = false;
            if (this.evd != null) {
                if (this.evh) {
                    this.evh = false;
                    this.evd.a((d.b<Object>) this);
                    this.evd.b(this);
                }
                this.evd.reset();
            }
            if (this.evi != null) {
                this.evi.destroy();
            }
        }

        void b(com.baidu.swan.support.v4.a.d<Object> dVar, Object obj) {
            String str;
            if (this.evc != null) {
                if (this.evj.eun != null) {
                    String str2 = this.evj.eun.eum.mNoTransactionsBecause;
                    this.evj.eun.eum.mNoTransactionsBecause = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (p.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + dVar + ": " + dVar.dataToString(obj));
                    }
                    this.evc.a(dVar, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (this.evj.eun != null) {
                        this.evj.eun.eum.mNoTransactionsBecause = str;
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
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.evd, sb);
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
            printWriter.println(this.evc);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.evd);
            if (this.evd != null) {
                this.evd.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.eve || this.mDeliveredData) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.eve);
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
            printWriter.print(this.evg);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.evf);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.evh);
            if (this.evi != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.evi);
                printWriter.println(":");
                this.evi.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, j jVar, boolean z) {
        this.mWho = str;
        this.eun = jVar;
        this.mStarted = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.eun = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bdR() {
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
        for (int size = this.eva.size() - 1; size >= 0; size--) {
            this.eva.valueAt(size).start();
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
        for (int size = this.eva.size() - 1; size >= 0; size--) {
            this.eva.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bdS() {
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
        for (int size = this.eva.size() - 1; size >= 0; size--) {
            this.eva.valueAt(size).retain();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bdT() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.eva.size() - 1; size >= 0; size--) {
                this.eva.valueAt(size).bdT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bdU() {
        for (int size = this.eva.size() - 1; size >= 0; size--) {
            this.eva.valueAt(size).evg = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bdV() {
        for (int size = this.eva.size() - 1; size >= 0; size--) {
            this.eva.valueAt(size).bdW();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.eva.size() - 1; size >= 0; size--) {
                this.eva.valueAt(size).destroy();
            }
            this.eva.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.evb.size() - 1; size2 >= 0; size2--) {
            this.evb.valueAt(size2).destroy();
        }
        this.evb.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this.eun, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.eva.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.eva.size(); i++) {
                a valueAt = this.eva.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.eva.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.evb.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.evb.size(); i2++) {
                a valueAt2 = this.evb.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.evb.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.o
    public boolean hasRunningLoaders() {
        int size = this.eva.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            a valueAt = this.eva.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}
