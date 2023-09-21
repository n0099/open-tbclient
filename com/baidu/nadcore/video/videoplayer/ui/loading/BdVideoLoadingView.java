package com.baidu.nadcore.video.videoplayer.ui.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.e81;
import com.baidu.tieba.g81;
import com.baidu.tieba.h81;
/* loaded from: classes3.dex */
public class BdVideoLoadingView extends ImageView {
    public e81 a;
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
        setLoadingRenderer(new h81(context));
    }

    public void setLoadingAnimListener(a aVar) {
        this.b = aVar;
    }

    public void setLoadingRenderer(g81 g81Var) {
        e81 e81Var = new e81(g81Var);
        this.a = e81Var;
        setImageDrawable(e81Var);
    }

    public BdVideoLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public boolean b() {
        return this.a.isRunning();
    }

    public void c() {
        e81 e81Var = this.a;
        if (e81Var != null) {
            e81Var.start();
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void d() {
        e81 e81Var = this.a;
        if (e81Var != null) {
            e81Var.stop();
            a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
