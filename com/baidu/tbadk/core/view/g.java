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
public class g extends Button {
    private float Yk;
    private float Yl;
    private float Ym;
    private float Yn;
    private WindowManager.LayoutParams Yo;
    private LinearLayout Yp;
    private LinearLayout Yq;
    private Rect Yr;
    private boolean Ys;
    private View.OnClickListener mClickListener;
    private WindowManager windowManager;
    private float x;
    private float y;

    public g(Context context) {
        super(context);
        this.Yr = new Rect();
        setBackgroundResource(com.baidu.tieba.p.btn_game_tie_bg);
        this.windowManager = (WindowManager) context.getSystemService("window");
        this.Yo = un();
        this.Yp = ul();
        this.Yq = um();
        this.windowManager.addView(this.Yp, this.Yp.getLayoutParams());
        this.windowManager.addView(this.Yq, this.Yq.getLayoutParams());
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getWindowVisibleDisplayFrame(this.Yr);
        this.x = motionEvent.getRawX();
        this.y = motionEvent.getRawY() - this.Yr.top;
        switch (motionEvent.getAction()) {
            case 0:
                this.Yk = motionEvent.getX();
                this.Yl = motionEvent.getY();
                this.Ym = this.x;
                this.Yn = this.y;
                this.Ys = false;
                break;
            case 1:
                int[] P = com.baidu.adp.lib.util.n.P(getContext());
                boolean z = P[0] / 2 < ((int) (this.x - this.Yk));
                if (this.Ys) {
                    o(z ? P[0] - getWidth() : 0, (int) (this.y - this.Yl));
                } else {
                    as(z);
                }
                this.Yl = 0.0f;
                this.Yk = 0.0f;
                break;
            case 2:
                if (!this.Ys && (Math.abs(this.x - this.Ym) > 3.0f || Math.abs(this.y - this.Yn) > 3.0f)) {
                    this.Ys = true;
                }
                if (this.Ys) {
                    o((int) (this.x - this.Yk), (int) (this.y - this.Yl));
                    this.Yq.setVisibility(8);
                    this.Yp.setVisibility(8);
                    break;
                }
                break;
        }
        return true;
    }

    private void as(boolean z) {
        if (z) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.Yq.getLayoutParams();
            layoutParams.y = this.Yo.y;
            this.windowManager.updateViewLayout(this.Yq, layoutParams);
            this.Yq.setVisibility(this.Yq.getVisibility() == 8 ? 0 : 8);
            return;
        }
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) this.Yp.getLayoutParams();
        layoutParams2.y = this.Yo.y;
        this.windowManager.updateViewLayout(this.Yp, layoutParams2);
        this.Yp.setVisibility(this.Yp.getVisibility() != 8 ? 8 : 0);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    private void o(int i, int i2) {
        this.Yo.x = i;
        this.Yo.y = i2;
        this.windowManager.updateViewLayout(this, this.Yo);
    }

    public WindowManager.LayoutParams getWindowManagerParams() {
        return this.Yo;
    }

    public void setWindowManagerParams(WindowManager.LayoutParams layoutParams) {
        this.Yo = layoutParams;
    }

    private LinearLayout ul() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(com.baidu.tieba.r.floatview_layout, (ViewGroup) null);
        linearLayout.setBackgroundResource(com.baidu.tieba.p.bg_game_tie);
        linearLayout.findViewById(com.baidu.tieba.q.floatview_layout_left_layout).setVisibility(8);
        linearLayout.setLayoutParams(un());
        linearLayout.setVisibility(8);
        return linearLayout;
    }

    private LinearLayout um() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(com.baidu.tieba.r.floatview_layout, (ViewGroup) null);
        linearLayout.setBackgroundResource(com.baidu.tieba.p.bg_game_tie);
        linearLayout.findViewById(com.baidu.tieba.q.floatview_layout_right_layout).setVisibility(8);
        WindowManager.LayoutParams un = un();
        un.gravity = 53;
        linearLayout.setLayoutParams(un);
        linearLayout.setVisibility(8);
        return linearLayout;
    }

    private WindowManager.LayoutParams un() {
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
                h hVar = new h(getContext(), list.get(i));
                hVar.setOnClickListener(this.mClickListener);
                ((LinearLayout) this.Yp.findViewById(com.baidu.tieba.q.floatview_layout_right_layout)).addView(hVar, h.uo());
                this.Yp.findViewById(com.baidu.tieba.q.floatview_layout_left_layout).setVisibility(8);
            }
            for (int i2 = size - 1; i2 >= 0; i2--) {
                h hVar2 = new h(getContext(), list.get(i2));
                hVar2.setOnClickListener(this.mClickListener);
                ((LinearLayout) this.Yq.findViewById(com.baidu.tieba.q.floatview_layout_left_layout)).addView(hVar2, h.uo());
                this.Yq.findViewById(com.baidu.tieba.q.floatview_layout_right_layout).setVisibility(8);
            }
        }
    }

    public void onDestroy() {
        this.windowManager.removeView(this.Yp);
        this.windowManager.removeView(this.Yq);
    }
}
