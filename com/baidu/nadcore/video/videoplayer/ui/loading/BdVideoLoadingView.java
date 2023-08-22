package com.baidu.nadcore.video.videoplayer.ui.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.a81;
import com.baidu.tieba.c81;
import com.baidu.tieba.d81;
/* loaded from: classes3.dex */
public class BdVideoLoadingView extends ImageView {
    public a81 a;
    public a b;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();
    }

    public BdVideoLoadingView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        setLoadingRenderer(new d81(context));
    }

    public void setLoadingAnimListener(a aVar) {
        this.b = aVar;
    }

    public void setLoadingRenderer(c81 c81Var) {
        a81 a81Var = new a81(c81Var);
        this.a = a81Var;
        setImageDrawable(a81Var);
    }

    public BdVideoLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public boolean b() {
        return this.a.isRunning();
    }

    public void c() {
        a81 a81Var = this.a;
        if (a81Var != null) {
            a81Var.start();
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void d() {
        a81 a81Var = this.a;
        if (a81Var != null) {
            a81Var.stop();
            a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
