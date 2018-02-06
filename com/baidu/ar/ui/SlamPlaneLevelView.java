package com.baidu.ar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.ar.util.Res;
/* loaded from: classes3.dex */
public class SlamPlaneLevelView extends RelativeLayout implements View.OnClickListener {
    private Context a;
    private View b;
    private ImageView c;
    private ImageView d;
    private ImageView e;

    public SlamPlaneLevelView(Context context) {
        super(context);
        this.a = context;
        a();
    }

    public SlamPlaneLevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        a();
    }

    public SlamPlaneLevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        a();
    }

    public void a() {
        this.b = Res.inflate("bdar_view_slam_indicate_light");
        addView(this.b);
        this.c = (ImageView) this.b.findViewById(Res.id("iv_first_light"));
        this.d = (ImageView) this.b.findViewById(Res.id("iv_second_light"));
        this.e = (ImageView) this.b.findViewById(Res.id("iv_third_light"));
    }

    public void b() {
        this.c.setEnabled(false);
        this.d.setEnabled(false);
        this.e.setEnabled(false);
    }

    public void c() {
        this.c.setEnabled(true);
        this.d.setEnabled(false);
        this.e.setEnabled(false);
    }

    public void d() {
        this.c.setEnabled(true);
        this.d.setEnabled(true);
        this.e.setEnabled(false);
    }

    public void e() {
        this.c.setEnabled(true);
        this.d.setEnabled(true);
        this.e.setEnabled(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
