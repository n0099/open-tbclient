package com.baidu.nadcore.video.videoplayer.ui.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.j31;
import com.baidu.tieba.l31;
import com.baidu.tieba.m31;
/* loaded from: classes3.dex */
public class BdVideoLoadingView extends ImageView {
    public j31 a;
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
        setLoadingRenderer(new m31(context));
    }

    public void setLoadingAnimListener(a aVar) {
        this.b = aVar;
    }

    public void setLoadingRenderer(l31 l31Var) {
        j31 j31Var = new j31(l31Var);
        this.a = j31Var;
        setImageDrawable(j31Var);
    }

    public BdVideoLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public boolean b() {
        return this.a.isRunning();
    }

    public void c() {
        j31 j31Var = this.a;
        if (j31Var != null) {
            j31Var.start();
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void d() {
        j31 j31Var = this.a;
        if (j31Var != null) {
            j31Var.stop();
            a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
