package com.baidu.nadcore.video.videoplayer.ui.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.v71;
import com.baidu.tieba.x71;
import com.baidu.tieba.y71;
/* loaded from: classes3.dex */
public class BdVideoLoadingView extends ImageView {
    public v71 a;
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
        setLoadingRenderer(new y71(context));
    }

    public void setLoadingAnimListener(a aVar) {
        this.b = aVar;
    }

    public void setLoadingRenderer(x71 x71Var) {
        v71 v71Var = new v71(x71Var);
        this.a = v71Var;
        setImageDrawable(v71Var);
    }

    public BdVideoLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public boolean b() {
        return this.a.isRunning();
    }

    public void c() {
        v71 v71Var = this.a;
        if (v71Var != null) {
            v71Var.start();
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void d() {
        v71 v71Var = this.a;
        if (v71Var != null) {
            v71Var.stop();
            a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
