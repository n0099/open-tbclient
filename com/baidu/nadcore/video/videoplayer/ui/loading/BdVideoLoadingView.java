package com.baidu.nadcore.video.videoplayer.ui.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.m51;
import com.baidu.tieba.o51;
import com.baidu.tieba.p51;
/* loaded from: classes2.dex */
public class BdVideoLoadingView extends ImageView {
    public m51 a;
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
        setLoadingRenderer(new p51(context));
    }

    public void setLoadingAnimListener(a aVar) {
        this.b = aVar;
    }

    public void setLoadingRenderer(o51 o51Var) {
        m51 m51Var = new m51(o51Var);
        this.a = m51Var;
        setImageDrawable(m51Var);
    }

    public BdVideoLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public boolean b() {
        return this.a.isRunning();
    }

    public void c() {
        m51 m51Var = this.a;
        if (m51Var != null) {
            m51Var.start();
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void d() {
        m51 m51Var = this.a;
        if (m51Var != null) {
            m51Var.stop();
            a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
