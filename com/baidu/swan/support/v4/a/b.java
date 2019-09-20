package com.baidu.swan.support.v4.a;

import com.baidu.swan.support.v4.b.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes2.dex */
public class b<D> {
    InterfaceC0237b<D> bvH;
    a<D> bvI;
    boolean mAbandoned;
    boolean mContentChanged;
    int mId;
    boolean mProcessingChange;
    boolean mReset;
    boolean mStarted;

    /* loaded from: classes2.dex */
    public interface a<D> {
    }

    /* renamed from: com.baidu.swan.support.v4.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0237b<D> {
    }

    public void a(int i, InterfaceC0237b<D> interfaceC0237b) {
        if (this.bvH != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.bvH = interfaceC0237b;
        this.mId = i;
    }

    public void a(InterfaceC0237b<D> interfaceC0237b) {
        if (this.bvH == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.bvH != interfaceC0237b) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.bvH = null;
    }

    public void a(a<D> aVar) {
        if (this.bvI != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.bvI = aVar;
    }

    public void b(a<D> aVar) {
        if (this.bvI == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.bvI != aVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.bvI = null;
    }

    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        onStartLoading();
    }

    protected void onStartLoading() {
    }

    public void stopLoading() {
        this.mStarted = false;
        onStopLoading();
    }

    protected void onStopLoading() {
    }

    public void reset() {
        onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    protected void onReset() {
    }

    public String dataToString(D d) {
        StringBuilder sb = new StringBuilder(64);
        c.buildShortClassTag(d, sb);
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        c.buildShortClassTag(this, sb);
        sb.append(" id=");
        sb.append(this.mId);
        sb.append("}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mListener=");
        printWriter.println(this.bvH);
        if (this.mStarted || this.mContentChanged || this.mProcessingChange) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.mStarted);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.mContentChanged);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.mProcessingChange);
        }
        if (this.mAbandoned || this.mReset) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.mAbandoned);
            printWriter.print(" mReset=");
            printWriter.println(this.mReset);
        }
    }
}
