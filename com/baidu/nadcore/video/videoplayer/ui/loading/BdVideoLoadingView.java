package com.baidu.nadcore.video.videoplayer.ui.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.f81;
import com.baidu.tieba.h81;
import com.baidu.tieba.i81;
/* loaded from: classes3.dex */
public class BdVideoLoadingView extends ImageView {
    public f81 a;
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
        setLoadingRenderer(new i81(context));
    }

    public void setLoadingAnimListener(a aVar) {
        this.b = aVar;
    }

    public void setLoadingRenderer(h81 h81Var) {
        f81 f81Var = new f81(h81Var);
        this.a = f81Var;
        setImageDrawable(f81Var);
    }

    public BdVideoLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public boolean b() {
        return this.a.isRunning();
    }

    public void c() {
        f81 f81Var = this.a;
        if (f81Var != null) {
            f81Var.start();
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void d() {
        f81 f81Var = this.a;
        if (f81Var != null) {
            f81Var.stop();
            a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
