package com.baidu.nadcore.video.videoplayer.ui.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.l31;
import com.baidu.tieba.n31;
import com.baidu.tieba.o31;
/* loaded from: classes3.dex */
public class BdVideoLoadingView extends ImageView {
    public l31 a;
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
        setLoadingRenderer(new o31(context));
    }

    public void setLoadingAnimListener(a aVar) {
        this.b = aVar;
    }

    public void setLoadingRenderer(n31 n31Var) {
        l31 l31Var = new l31(n31Var);
        this.a = l31Var;
        setImageDrawable(l31Var);
    }

    public BdVideoLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public boolean b() {
        return this.a.isRunning();
    }

    public void c() {
        l31 l31Var = this.a;
        if (l31Var != null) {
            l31Var.start();
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void d() {
        l31 l31Var = this.a;
        if (l31Var != null) {
            l31Var.stop();
            a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
