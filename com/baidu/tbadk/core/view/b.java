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
    private float GZ;
    private float Ha;
    private float Hb;
    private float Hc;
    private View.OnClickListener Hd;
    private WindowManager.LayoutParams He;
    private LinearLayout Hf;
    private LinearLayout Hg;
    private Rect Hh;
    private boolean Hi;
    private WindowManager windowManager;
    private float x;
    private float y;

    public b(Context context) {
        super(context);
        this.Hh = new Rect();
        setBackgroundResource(com.baidu.tieba.u.btn_game_tie_bg);
        this.windowManager = (WindowManager) context.getSystemService("window");
        this.He = nq();
        this.Hf = no();
        this.Hg = np();
        this.windowManager.addView(this.Hf, this.Hf.getLayoutParams());
        this.windowManager.addView(this.Hg, this.Hg.getLayoutParams());
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getWindowVisibleDisplayFrame(this.Hh);
        this.x = motionEvent.getRawX();
        this.y = motionEvent.getRawY() - this.Hh.top;
        switch (motionEvent.getAction()) {
            case 0:
                this.GZ = motionEvent.getX();
                this.Ha = motionEvent.getY();
                this.Hb = this.x;
                this.Hc = this.y;
                this.Hi = false;
                break;
            case 1:
                int[] q = com.baidu.adp.lib.util.m.q(getContext());
                boolean z = q[0] / 2 < ((int) (this.x - this.GZ));
                if (this.Hi) {
                    n(z ? q[0] - getWidth() : 0, (int) (this.y - this.Ha));
                } else {
                    Y(z);
                }
                this.Ha = 0.0f;
                this.GZ = 0.0f;
                break;
            case 2:
                if (!this.Hi && (Math.abs(this.x - this.Hb) > 3.0f || Math.abs(this.y - this.Hc) > 3.0f)) {
                    this.Hi = true;
                }
                if (this.Hi) {
                    n((int) (this.x - this.GZ), (int) (this.y - this.Ha));
                    this.Hg.setVisibility(8);
                    this.Hf.setVisibility(8);
                    break;
                }
                break;
        }
        return true;
    }

    private void Y(boolean z) {
        if (z) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.Hg.getLayoutParams();
            layoutParams.y = this.He.y;
            this.windowManager.updateViewLayout(this.Hg, layoutParams);
            this.Hg.setVisibility(this.Hg.getVisibility() == 8 ? 0 : 8);
            return;
        }
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) this.Hf.getLayoutParams();
        layoutParams2.y = this.He.y;
        this.windowManager.updateViewLayout(this.Hf, layoutParams2);
        this.Hf.setVisibility(this.Hf.getVisibility() != 8 ? 8 : 0);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.Hd = onClickListener;
    }

    private void n(int i, int i2) {
        this.He.x = i;
        this.He.y = i2;
        this.windowManager.updateViewLayout(this, this.He);
    }

    public WindowManager.LayoutParams getWindowManagerParams() {
        return this.He;
    }

    public void setWindowManagerParams(WindowManager.LayoutParams layoutParams) {
        this.He = layoutParams;
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
                cVar.setOnClickListener(this.Hd);
                ((LinearLayout) this.Hf.findViewById(com.baidu.tieba.v.floatview_layout_right_layout)).addView(cVar, c.nr());
                this.Hf.findViewById(com.baidu.tieba.v.floatview_layout_left_layout).setVisibility(8);
            }
            for (int i2 = size - 1; i2 >= 0; i2--) {
                c cVar2 = new c(getContext(), list.get(i2));
                cVar2.setOnClickListener(this.Hd);
                ((LinearLayout) this.Hg.findViewById(com.baidu.tieba.v.floatview_layout_left_layout)).addView(cVar2, c.nr());
                this.Hg.findViewById(com.baidu.tieba.v.floatview_layout_right_layout).setVisibility(8);
            }
        }
    }

    public void onDestroy() {
        this.windowManager.removeView(this.Hf);
        this.windowManager.removeView(this.Hg);
    }
}
