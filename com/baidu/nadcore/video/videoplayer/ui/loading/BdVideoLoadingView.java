package com.baidu.nadcore.video.videoplayer.ui.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.o51;
import com.baidu.tieba.q51;
import com.baidu.tieba.r51;
/* loaded from: classes2.dex */
public class BdVideoLoadingView extends ImageView {
    public o51 a;
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
        setLoadingRenderer(new r51(context));
    }

    public void setLoadingAnimListener(a aVar) {
        this.b = aVar;
    }

    public void setLoadingRenderer(q51 q51Var) {
        o51 o51Var = new o51(q51Var);
        this.a = o51Var;
        setImageDrawable(o51Var);
    }

    public BdVideoLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public boolean b() {
        return this.a.isRunning();
    }

    public void c() {
        o51 o51Var = this.a;
        if (o51Var != null) {
            o51Var.start();
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void d() {
        o51 o51Var = this.a;
        if (o51Var != null) {
            o51Var.stop();
            a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
