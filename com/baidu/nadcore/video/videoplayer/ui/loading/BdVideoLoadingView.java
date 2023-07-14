package com.baidu.nadcore.video.videoplayer.ui.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.s81;
import com.baidu.tieba.u81;
import com.baidu.tieba.v81;
/* loaded from: classes3.dex */
public class BdVideoLoadingView extends ImageView {
    public s81 a;
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
        setLoadingRenderer(new v81(context));
    }

    public void setLoadingAnimListener(a aVar) {
        this.b = aVar;
    }

    public void setLoadingRenderer(u81 u81Var) {
        s81 s81Var = new s81(u81Var);
        this.a = s81Var;
        setImageDrawable(s81Var);
    }

    public BdVideoLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public boolean b() {
        return this.a.isRunning();
    }

    public void c() {
        s81 s81Var = this.a;
        if (s81Var != null) {
            s81Var.start();
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void d() {
        s81 s81Var = this.a;
        if (s81Var != null) {
            s81Var.stop();
            a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
