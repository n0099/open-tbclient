package com.baidu.tbadk.b;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public class a {
    private static int QA;
    private static int Qz;
    private View.OnClickListener Hd;
    private Context Qw;
    private com.baidu.tbadk.core.frameworkData.a Qx;
    private com.baidu.tbadk.core.frameworkData.a Qy;

    public int qW() {
        return Qz;
    }

    public void cA(int i) {
        Qz = i;
    }

    public int qX() {
        return QA;
    }

    public void cB(int i) {
        QA = i;
    }

    public a(Context context) {
        this.Qw = context;
    }

    public void c(View.OnClickListener onClickListener) {
        this.Hd = onClickListener;
    }

    public View.OnClickListener qY() {
        return this.Hd;
    }

    public void a(com.baidu.tbadk.core.frameworkData.a aVar) {
        this.Qx = aVar;
    }

    public void b(com.baidu.tbadk.core.frameworkData.a aVar) {
        this.Qy = aVar;
    }

    public com.baidu.tbadk.core.frameworkData.a ao(boolean z) {
        return z ? this.Qx : this.Qy;
    }

    public Context getContext() {
        return this.Qw;
    }
}
