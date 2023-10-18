package com.baidu.nadcore.video.videoplayer.ui.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.r21;
import com.baidu.tieba.t21;
import com.baidu.tieba.u21;
/* loaded from: classes3.dex */
public class BdVideoLoadingView extends ImageView {
    public r21 a;
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
        setLoadingRenderer(new u21(context));
    }

    public void setLoadingAnimListener(a aVar) {
        this.b = aVar;
    }

    public void setLoadingRenderer(t21 t21Var) {
        r21 r21Var = new r21(t21Var);
        this.a = r21Var;
        setImageDrawable(r21Var);
    }

    public BdVideoLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public boolean b() {
        return this.a.isRunning();
    }

    public void c() {
        r21 r21Var = this.a;
        if (r21Var != null) {
            r21Var.start();
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void d() {
        r21 r21Var = this.a;
        if (r21Var != null) {
            r21Var.stop();
            a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
