package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class p {
    private LinearLayout a;
    private ImageView b;
    private TextView d;
    private int e;
    private int f;
    private Bitmap c = null;
    private int g = -1;

    public p(View view, int i, int i2, int i3, int i4, int i5) {
        this.e = i;
        this.f = i2;
        if (view != null) {
            this.a = (LinearLayout) view.findViewById(i3);
            this.b = (ImageView) view.findViewById(i4);
            this.d = (TextView) view.findViewById(i5);
        }
    }

    public p(Activity activity, int i, int i2, int i3, int i4, int i5) {
        this.e = i;
        this.f = i2;
        this.a = (LinearLayout) activity.findViewById(i3);
        this.b = (ImageView) activity.findViewById(i4);
        this.d = (TextView) activity.findViewById(i5);
    }

    public void a(int i) {
        if (i != this.g) {
            this.g = i;
            if (i == 1) {
                this.c = com.baidu.tbadk.core.util.d.b(TbadkApplication.m252getInst().getApp(), this.f);
                this.d.setTextColor(ay.a(i));
            } else {
                this.c = com.baidu.tbadk.core.util.d.b(TbadkApplication.m252getInst().getApp(), this.e);
                this.d.setTextColor(TbadkApplication.m252getInst().getApp().getResources().getColor(com.baidu.tieba.r.invite_friend_nodata_text));
            }
            if (this.c != null) {
                this.b.setImageBitmap(this.c);
            }
        }
    }

    public void a() {
        a(TbadkApplication.m252getInst().getSkinType());
    }

    public void b() {
        this.b.setImageDrawable(null);
        if (this.c != null) {
            if (!this.c.isRecycled()) {
                this.c.recycle();
            }
            this.c = null;
        }
        this.g = -1;
    }

    public void b(int i) {
        this.a.setVisibility(i);
        if (i == 8) {
            this.b.setImageDrawable(null);
            this.b.setVisibility(8);
            this.g = -1;
            return;
        }
        this.b.setVisibility(0);
        a(TbadkApplication.m252getInst().getSkinType());
    }
}
