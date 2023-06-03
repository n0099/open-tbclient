package com.baidu.nadcore.video.videoplayer.ui.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.n71;
import com.baidu.tieba.p71;
import com.baidu.tieba.q71;
/* loaded from: classes3.dex */
public class BdVideoLoadingView extends ImageView {
    public n71 a;
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
        setLoadingRenderer(new q71(context));
    }

    public void setLoadingAnimListener(a aVar) {
        this.b = aVar;
    }

    public void setLoadingRenderer(p71 p71Var) {
        n71 n71Var = new n71(p71Var);
        this.a = n71Var;
        setImageDrawable(n71Var);
    }

    public BdVideoLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public boolean b() {
        return this.a.isRunning();
    }

    public void c() {
        n71 n71Var = this.a;
        if (n71Var != null) {
            n71Var.start();
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void d() {
        n71 n71Var = this.a;
        if (n71Var != null) {
            n71Var.stop();
            a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
