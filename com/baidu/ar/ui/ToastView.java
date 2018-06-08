package com.baidu.ar.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class ToastView extends TextView {
    private TimerTask a;
    private Timer b;

    public ToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public ToastView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    private void b() {
        this.a = new TimerTask() { // from class: com.baidu.ar.ui.ToastView.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ToastView.this.a();
            }
        };
        this.b = new Timer();
    }

    public void a() {
        setVisibility(8);
    }
}
