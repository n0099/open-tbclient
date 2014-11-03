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
    private float Ha;
    private float Hb;
    private float Hc;
    private float Hd;
    private View.OnClickListener He;
    private WindowManager.LayoutParams Hf;
    private LinearLayout Hg;
    private LinearLayout Hh;
    private Rect Hi;
    private boolean Hj;
    private WindowManager windowManager;
    private float x;
    private float y;

    public b(Context context) {
        super(context);
        this.Hi = new Rect();
        setBackgroundResource(com.baidu.tieba.u.btn_game_tie_bg);
        this.windowManager = (WindowManager) context.getSystemService("window");
        this.Hf = nq();
        this.Hg = no();
        this.Hh = np();
        this.windowManager.addView(this.Hg, this.Hg.getLayoutParams());
        this.windowManager.addView(this.Hh, this.Hh.getLayoutParams());
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getWindowVisibleDisplayFrame(this.Hi);
        this.x = motionEvent.getRawX();
        this.y = motionEvent.getRawY() - this.Hi.top;
        switch (motionEvent.getAction()) {
            case 0:
                this.Ha = motionEvent.getX();
                this.Hb = motionEvent.getY();
                this.Hc = this.x;
                this.Hd = this.y;
                this.Hj = false;
                break;
            case 1:
                int[] q = com.baidu.adp.lib.util.m.q(getContext());
                boolean z = q[0] / 2 < ((int) (this.x - this.Ha));
                if (this.Hj) {
                    n(z ? q[0] - getWidth() : 0, (int) (this.y - this.Hb));
                } else {
                    Y(z);
                }
                this.Hb = 0.0f;
                this.Ha = 0.0f;
                break;
            case 2:
                if (!this.Hj && (Math.abs(this.x - this.Hc) > 3.0f || Math.abs(this.y - this.Hd) > 3.0f)) {
                    this.Hj = true;
                }
                if (this.Hj) {
                    n((int) (this.x - this.Ha), (int) (this.y - this.Hb));
                    this.Hh.setVisibility(8);
                    this.Hg.setVisibility(8);
                    break;
                }
                break;
        }
        return true;
    }

    private void Y(boolean z) {
        if (z) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.Hh.getLayoutParams();
            layoutParams.y = this.Hf.y;
            this.windowManager.updateViewLayout(this.Hh, layoutParams);
            this.Hh.setVisibility(this.Hh.getVisibility() == 8 ? 0 : 8);
            return;
        }
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) this.Hg.getLayoutParams();
        layoutParams2.y = this.Hf.y;
        this.windowManager.updateViewLayout(this.Hg, layoutParams2);
        this.Hg.setVisibility(this.Hg.getVisibility() != 8 ? 8 : 0);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.He = onClickListener;
    }

    private void n(int i, int i2) {
        this.Hf.x = i;
        this.Hf.y = i2;
        this.windowManager.updateViewLayout(this, this.Hf);
    }

    public WindowManager.LayoutParams getWindowManagerParams() {
        return this.Hf;
    }

    public void setWindowManagerParams(WindowManager.LayoutParams layoutParams) {
        this.Hf = layoutParams;
    }

    private LinearLayout no() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(com.baidu.tieba.w.floatview_layout, (ViewGroup) null);
        linearLayout.setBackgroundResource(com.baidu.tieba.u.bg_game_tie);
        linearLayout.findViewById(com.baidu.tieba.v.floatview_layout_left_layout).setVisibility(8);
        linearLayout.setLayoutParams(nq());
        linearLayout.setVisibility(8);
        return linearLayout;
    }

    private LinearLayout np() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(com.baidu.tieba.w.floatview_layout, (ViewGroup) null);
        linearLayout.setBackgroundResource(com.baidu.tieba.u.bg_game_tie);
        linearLayout.findViewById(com.baidu.tieba.v.floatview_layout_right_layout).setVisibility(8);
        WindowManager.LayoutParams nq = nq();
        nq.gravity = 53;
        linearLayout.setLayoutParams(nq);
        linearLayout.setVisibility(8);
        return linearLayout;
    }

    private WindowManager.LayoutParams nq() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = 1;
        layoutParams.flags = 40;
        layoutParams.gravity = 51;
        return layoutParams;
    }

    public void setData(List<String> list) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                c cVar = new c(getContext(), list.get(i));
                cVar.setOnClickListener(this.He);
                ((LinearLayout) this.Hg.findViewById(com.baidu.tieba.v.floatview_layout_right_layout)).addView(cVar, c.nr());
                this.Hg.findViewById(com.baidu.tieba.v.floatview_layout_left_layout).setVisibility(8);
            }
            for (int i2 = size - 1; i2 >= 0; i2--) {
                c cVar2 = new c(getContext(), list.get(i2));
                cVar2.setOnClickListener(this.He);
                ((LinearLayout) this.Hh.findViewById(com.baidu.tieba.v.floatview_layout_left_layout)).addView(cVar2, c.nr());
                this.Hh.findViewById(com.baidu.tieba.v.floatview_layout_right_layout).setVisibility(8);
            }
        }
    }

    public void onDestroy() {
        this.windowManager.removeView(this.Hg);
        this.windowManager.removeView(this.Hh);
    }
}
