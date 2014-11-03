package com.baidu.tbadk.b;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public class a {
    private static int QD;
    private static int QE;
    private View.OnClickListener He;
    private Context QA;
    private com.baidu.tbadk.core.frameworkData.a QB;
    private com.baidu.tbadk.core.frameworkData.a QC;

    public int qY() {
        return QD;
    }

    public void cA(int i) {
        QD = i;
    }

    public int qZ() {
        return QE;
    }

    public void cB(int i) {
        QE = i;
    }

    public a(Context context) {
        this.QA = context;
    }

    public void c(View.OnClickListener onClickListener) {
        this.He = onClickListener;
    }

    public View.OnClickListener ra() {
        return this.He;
    }

    public void a(com.baidu.tbadk.core.frameworkData.a aVar) {
        this.QB = aVar;
    }

    public void b(com.baidu.tbadk.core.frameworkData.a aVar) {
        this.QC = aVar;
    }

    public com.baidu.tbadk.core.frameworkData.a ao(boolean z) {
        return z ? this.QB : this.QC;
    }

    public Context getContext() {
        return this.QA;
    }
}
