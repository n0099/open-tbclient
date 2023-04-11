package com.baidu.nadcore.video.videoplayer.ui.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.l51;
import com.baidu.tieba.n51;
import com.baidu.tieba.o51;
/* loaded from: classes2.dex */
public class BdVideoLoadingView extends ImageView {
    public l51 a;
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
        setLoadingRenderer(new o51(context));
    }

    public void setLoadingAnimListener(a aVar) {
        this.b = aVar;
    }

    public void setLoadingRenderer(n51 n51Var) {
        l51 l51Var = new l51(n51Var);
        this.a = l51Var;
        setImageDrawable(l51Var);
    }

    public BdVideoLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public boolean b() {
        return this.a.isRunning();
    }

    public void c() {
        l51 l51Var = this.a;
        if (l51Var != null) {
            l51Var.start();
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void d() {
        l51 l51Var = this.a;
        if (l51Var != null) {
            l51Var.stop();
            a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
