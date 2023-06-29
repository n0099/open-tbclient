package com.baidu.nadcore.video.videoplayer.ui.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.r71;
import com.baidu.tieba.t71;
import com.baidu.tieba.u71;
/* loaded from: classes3.dex */
public class BdVideoLoadingView extends ImageView {
    public r71 a;
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
        setLoadingRenderer(new u71(context));
    }

    public void setLoadingAnimListener(a aVar) {
        this.b = aVar;
    }

    public void setLoadingRenderer(t71 t71Var) {
        r71 r71Var = new r71(t71Var);
        this.a = r71Var;
        setImageDrawable(r71Var);
    }

    public BdVideoLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public boolean b() {
        return this.a.isRunning();
    }

    public void c() {
        r71 r71Var = this.a;
        if (r71Var != null) {
            r71Var.start();
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void d() {
        r71 r71Var = this.a;
        if (r71Var != null) {
            r71Var.stop();
            a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
