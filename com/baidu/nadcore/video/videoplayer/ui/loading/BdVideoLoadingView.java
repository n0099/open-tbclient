package com.baidu.nadcore.video.videoplayer.ui.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.o71;
import com.baidu.tieba.q71;
import com.baidu.tieba.r71;
/* loaded from: classes3.dex */
public class BdVideoLoadingView extends ImageView {
    public o71 a;
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
        setLoadingRenderer(new r71(context));
    }

    public void setLoadingAnimListener(a aVar) {
        this.b = aVar;
    }

    public void setLoadingRenderer(q71 q71Var) {
        o71 o71Var = new o71(q71Var);
        this.a = o71Var;
        setImageDrawable(o71Var);
    }

    public BdVideoLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public boolean b() {
        return this.a.isRunning();
    }

    public void c() {
        o71 o71Var = this.a;
        if (o71Var != null) {
            o71Var.start();
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void d() {
        o71 o71Var = this.a;
        if (o71Var != null) {
            o71Var.stop();
            a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
