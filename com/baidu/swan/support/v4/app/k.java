package com.baidu.swan.support.v4.app;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class k {

    /* loaded from: classes2.dex */
    public interface a {
        void onBackStackChanged();
    }

    public abstract m Xh();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract boolean executePendingTransactions();

    public abstract List<Fragment> getFragments();

    public abstract boolean popBackStackImmediate();
}
