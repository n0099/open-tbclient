package com.baidu.nadcore.video.videoplayer.ui.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.e61;
import com.baidu.tieba.g61;
import com.baidu.tieba.h61;
/* loaded from: classes3.dex */
public class BdVideoLoadingView extends ImageView {
    public e61 a;
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
        setLoadingRenderer(new h61(context));
    }

    public void setLoadingAnimListener(a aVar) {
        this.b = aVar;
    }

    public void setLoadingRenderer(g61 g61Var) {
        e61 e61Var = new e61(g61Var);
        this.a = e61Var;
        setImageDrawable(e61Var);
    }

    public BdVideoLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public boolean b() {
        return this.a.isRunning();
    }

    public void c() {
        e61 e61Var = this.a;
        if (e61Var != null) {
            e61Var.start();
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void d() {
        e61 e61Var = this.a;
        if (e61Var != null) {
            e61Var.stop();
            a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
