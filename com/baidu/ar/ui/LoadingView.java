package com.baidu.ar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.ar.util.Res;
/* loaded from: classes3.dex */
public class LoadingView extends FrameLayout {
    private TextView a;

    public LoadingView(Context context) {
        super(context);
        a();
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        Context context = getContext();
        Res.addResource(context);
        context.getPackageName();
        Res.inflate("bdar_layout_loading", this, true);
        this.a = (TextView) findViewById(Res.id("bdar_id_loading_message"));
    }

    public void dismiss() {
        setVisibility(8);
    }

    public void setMsg(int i) {
        if (this.a != null) {
            this.a.setText(i);
        }
    }

    public void setMsg(String str) {
        if (this.a != null) {
            this.a.setText(str);
        }
    }

    public void show() {
        setVisibility(0);
    }
}
