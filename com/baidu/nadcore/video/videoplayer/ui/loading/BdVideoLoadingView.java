package com.baidu.nadcore.video.videoplayer.ui.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.i31;
import com.baidu.tieba.k31;
import com.baidu.tieba.l31;
/* loaded from: classes3.dex */
public class BdVideoLoadingView extends ImageView {
    public i31 a;
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
        setLoadingRenderer(new l31(context));
    }

    public void setLoadingAnimListener(a aVar) {
        this.b = aVar;
    }

    public void setLoadingRenderer(k31 k31Var) {
        i31 i31Var = new i31(k31Var);
        this.a = i31Var;
        setImageDrawable(i31Var);
    }

    public BdVideoLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public boolean b() {
        return this.a.isRunning();
    }

    public void c() {
        i31 i31Var = this.a;
        if (i31Var != null) {
            i31Var.start();
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void d() {
        i31 i31Var = this.a;
        if (i31Var != null) {
            i31Var.stop();
            a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
