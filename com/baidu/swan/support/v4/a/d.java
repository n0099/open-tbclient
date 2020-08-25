package com.baidu.swan.support.v4.a;

import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes9.dex */
public class d<D> {
    b<D> dIw;
    a<D> dIx;
    boolean mAbandoned;
    boolean mContentChanged;
    int mId;
    boolean mProcessingChange;
    boolean mReset;
    boolean mStarted;

    /* loaded from: classes9.dex */
    public interface a<D> {
    }

    /* loaded from: classes9.dex */
    public interface b<D> {
    }

    public void a(int i, b<D> bVar) {
        if (this.dIw != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.dIw = bVar;
        this.mId = i;
    }

    public void a(b<D> bVar) {
        if (this.dIw == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.dIw != bVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.dIw = null;
    }

    public void a(a<D> aVar) {
        if (this.dIx != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.dIx = aVar;
    }

    public void b(a<D> aVar) {
        if (this.dIx == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.dIx != aVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.dIx = null;
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
        com.baidu.swan.support.v4.b.c.buildShortClassTag(d, sb);
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this, sb);
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
        printWriter.println(this.dIw);
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
