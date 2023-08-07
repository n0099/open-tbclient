package com.baidu.nadcore.crius.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.render.CriusRender;
import com.baidu.tieba.bd1;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class AdCriusBaseView<T extends CriusData> extends RelativeLayout {
    public ViewGroup a;
    public LinearLayout b;
    public ViewGroup c;
    @NonNull
    public CriusRender d;

    public abstract int d();

    public void e(T t) {
    }

    public abstract void f(View view2, String str, Map<String, String> map);

    public abstract int h();

    public abstract int j();

    /* loaded from: classes3.dex */
    public class a implements CriusRender.IHrefClick {
        public a() {
        }

        @Override // com.baidu.searchbox.crius.render.CriusRender.IHrefClick
        public void onClick(View view2, String str, Map<String, String> map) {
            AdCriusBaseView.this.f(view2, str, map);
        }
    }

    public AdCriusBaseView(Context context) {
        this(context, null);
    }

    public void g(Context context) {
        LayoutInflater.from(context).inflate(h(), this);
        this.a = (ViewGroup) findViewById(j());
        this.b = (LinearLayout) findViewById(d());
    }

    public AdCriusBaseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void k(T t, boolean z) {
        if (t != null) {
            i(t, z);
        } else {
            setVisibility(8);
        }
    }

    public AdCriusBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g(context);
        CriusRender criusRender = new CriusRender();
        this.d = criusRender;
        criusRender.setHrefClick(new a());
    }

    public void i(T t, boolean z) {
        if (this.d == null) {
            return;
        }
        this.b.removeAllViews();
        bd1 bd1Var = (bd1) ServiceManager.getService(bd1.a);
        if (bd1Var != null) {
            this.c = this.d.initCriusView(getContext(), t, bd1Var.b(), z, bd1Var.a());
        } else {
            this.c = this.d.initCriusView(getContext(), t, false, z, -1);
        }
        this.b.addView(this.c);
        e(t);
    }
}
