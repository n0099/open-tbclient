package com.baidu.nadcore.video.videoplayer.ui.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.k51;
import com.baidu.tieba.m51;
import com.baidu.tieba.n51;
/* loaded from: classes2.dex */
public class BdVideoLoadingView extends ImageView {
    public k51 a;
    public a b;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b();
    }

    public BdVideoLoadingView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        setLoadingRenderer(new n51(context));
    }

    public void setLoadingAnimListener(a aVar) {
        this.b = aVar;
    }

    public void setLoadingRenderer(m51 m51Var) {
        k51 k51Var = new k51(m51Var);
        this.a = k51Var;
        setImageDrawable(k51Var);
    }

    public BdVideoLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public boolean b() {
        return this.a.isRunning();
    }

    public void c() {
        k51 k51Var = this.a;
        if (k51Var != null) {
            k51Var.start();
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void d() {
        k51 k51Var = this.a;
        if (k51Var != null) {
            k51Var.stop();
            a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
