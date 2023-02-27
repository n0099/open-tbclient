package com.baidu.nadcore.video.videoplayer.ui.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.u61;
import com.baidu.tieba.w61;
import com.baidu.tieba.x61;
/* loaded from: classes2.dex */
public class BdVideoLoadingView extends ImageView {
    public u61 a;
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
        setLoadingRenderer(new x61(context));
    }

    public void setLoadingAnimListener(a aVar) {
        this.b = aVar;
    }

    public void setLoadingRenderer(w61 w61Var) {
        u61 u61Var = new u61(w61Var);
        this.a = u61Var;
        setImageDrawable(u61Var);
    }

    public BdVideoLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public boolean b() {
        return this.a.isRunning();
    }

    public void c() {
        u61 u61Var = this.a;
        if (u61Var != null) {
            u61Var.start();
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void d() {
        u61 u61Var = this.a;
        if (u61Var != null) {
            u61Var.stop();
            a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
