package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class k {
    private LinearLayout a;
    private ImageView b;
    private TextView c;
    private int d;
    private int e;
    private int f = -1;

    public k(View view, int i, int i2, int i3, int i4, int i5) {
        this.d = i;
        this.e = i2;
        if (view != null) {
            this.a = (LinearLayout) view.findViewById(i3);
            this.b = (ImageView) view.findViewById(i4);
            this.c = (TextView) view.findViewById(i5);
        }
    }

    public k(Activity activity, int i, int i2, int i3, int i4, int i5) {
        this.d = i;
        this.e = i2;
        this.a = (LinearLayout) activity.findViewById(i3);
        this.b = (ImageView) activity.findViewById(i4);
        this.c = (TextView) activity.findViewById(i5);
    }

    public void a(int i) {
        if (i != this.f) {
            this.f = i;
            if (i == 1) {
                this.b.setImageResource(this.e);
                this.c.setTextColor(bc.a(i));
                return;
            }
            this.b.setImageResource(this.d);
            this.c.setTextColor(-5065030);
        }
    }

    public void a() {
        a(TbadkApplication.m252getInst().getSkinType());
    }

    public void b() {
        this.b.setImageDrawable(null);
        this.f = -1;
    }

    public void b(int i) {
        this.a.setVisibility(i);
        if (i == 8) {
            this.b.setImageDrawable(null);
            this.b.setVisibility(8);
            this.f = -1;
            return;
        }
        this.b.setVisibility(0);
        a(TbadkApplication.m252getInst().getSkinType());
    }
}
