package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
/* loaded from: classes.dex */
public class ad {
    private int Il;
    private com.baidu.adp.widget.ScrollView.g Im;
    private boolean In;
    af Io;
    int mDuration;
    View mView;
    private int Ik = 1;
    Handler mHandler = new Handler();
    Runnable Ip = new ae(this);

    public ad(Context context, int i, int i2, int i3) {
        this.In = true;
        int abs = Math.abs(i - i2);
        this.Il = i2;
        if (abs < this.Ik) {
            this.In = false;
        }
        this.Io = new af(this, context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.g gVar) {
        this.Im = gVar;
    }

    public void g(View view) {
        if (this.In && this.Io != null) {
            this.mView = view;
            this.Io.h(Math.abs(this.Il), this.mDuration);
            this.mHandler.postDelayed(this.Ip, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.Il) {
            paddingTop = this.Il;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
