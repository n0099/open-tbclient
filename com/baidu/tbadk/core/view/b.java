package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import java.util.List;
/* loaded from: classes.dex */
public class b extends Button {
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private View.OnClickListener g;
    private WindowManager h;
    private WindowManager.LayoutParams i;
    private LinearLayout j;
    private LinearLayout k;
    private Rect l;
    private boolean m;

    public b(Context context) {
        super(context);
        this.l = new Rect();
        setBackgroundResource(com.baidu.tieba.t.btn_game_tie_bg);
        this.h = (WindowManager) context.getSystemService("window");
        this.i = new WindowManager.LayoutParams();
        this.i.x = 0;
        this.i.y = 0;
        this.i.width = -2;
        this.i.height = -2;
        this.i.type = 2002;
        this.i.format = 1;
        this.i.flags = 40;
        this.i.gravity = 51;
        this.j = b();
        this.k = c();
        this.h.addView(this.j, this.j.getLayoutParams());
        this.h.addView(this.k, this.k.getLayoutParams());
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getWindowVisibleDisplayFrame(this.l);
        this.c = motionEvent.getRawX();
        this.d = motionEvent.getRawY() - this.l.top;
        switch (motionEvent.getAction()) {
            case 0:
                this.a = motionEvent.getX();
                this.b = motionEvent.getY();
                this.e = this.c;
                this.f = this.d;
                this.m = false;
                break;
            case 1:
                int[] e = com.baidu.adp.lib.util.j.e(getContext());
                boolean z = e[0] / 2 < ((int) (this.c - this.a));
                if (this.m) {
                    a(z ? e[0] - getWidth() : 0, (int) (this.d - this.b));
                } else {
                    a(z);
                }
                this.b = 0.0f;
                this.a = 0.0f;
                break;
            case 2:
                if (!this.m && (Math.abs(this.c - this.e) > 3.0f || Math.abs(this.d - this.f) > 3.0f)) {
                    this.m = true;
                }
                if (this.m) {
                    a((int) (this.c - this.a), (int) (this.d - this.b));
                    this.k.setVisibility(8);
                    this.j.setVisibility(8);
                    break;
                }
                break;
        }
        return true;
    }

    private void a(boolean z) {
        if (z) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.k.getLayoutParams();
            layoutParams.y = this.i.y;
            this.h.updateViewLayout(this.k, layoutParams);
            this.k.setVisibility(this.k.getVisibility() == 8 ? 0 : 8);
            return;
        }
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) this.j.getLayoutParams();
        layoutParams2.y = this.i.y;
        this.h.updateViewLayout(this.j, layoutParams2);
        this.j.setVisibility(this.j.getVisibility() != 8 ? 8 : 0);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.g = onClickListener;
    }

    private void a(int i, int i2) {
        this.i.x = i;
        this.i.y = i2;
        this.h.updateViewLayout(this, this.i);
    }

    public WindowManager.LayoutParams getWindowManagerParams() {
        return this.i;
    }

    public void setWindowManagerParams(WindowManager.LayoutParams layoutParams) {
        this.i = layoutParams;
    }

    private LinearLayout b() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(com.baidu.tieba.v.floatview_layout, (ViewGroup) null);
        linearLayout.setBackgroundResource(com.baidu.tieba.t.bg_game_tie);
        linearLayout.findViewById(com.baidu.tieba.u.floatview_layout_left_layout).setVisibility(8);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.type = 2002;
        layoutParams.format = 1;
        layoutParams.flags = 40;
        layoutParams.gravity = 51;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setVisibility(8);
        return linearLayout;
    }

    private LinearLayout c() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(com.baidu.tieba.v.floatview_layout, (ViewGroup) null);
        linearLayout.setBackgroundResource(com.baidu.tieba.t.bg_game_tie);
        linearLayout.findViewById(com.baidu.tieba.u.floatview_layout_right_layout).setVisibility(8);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.type = 2002;
        layoutParams.format = 1;
        layoutParams.flags = 40;
        layoutParams.gravity = 53;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setVisibility(8);
        return linearLayout;
    }

    public void setData(List<String> list) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                c cVar = new c(getContext(), list.get(i));
                cVar.setOnClickListener(this.g);
                ((LinearLayout) this.j.findViewById(com.baidu.tieba.u.floatview_layout_right_layout)).addView(cVar, c.a());
                this.j.findViewById(com.baidu.tieba.u.floatview_layout_left_layout).setVisibility(8);
            }
            for (int i2 = size - 1; i2 >= 0; i2--) {
                c cVar2 = new c(getContext(), list.get(i2));
                cVar2.setOnClickListener(this.g);
                ((LinearLayout) this.k.findViewById(com.baidu.tieba.u.floatview_layout_left_layout)).addView(cVar2, c.a());
                this.k.findViewById(com.baidu.tieba.u.floatview_layout_right_layout).setVisibility(8);
            }
        }
    }

    public void a() {
        this.h.removeViewImmediate(this.j);
        this.h.removeViewImmediate(this.k);
    }
}
