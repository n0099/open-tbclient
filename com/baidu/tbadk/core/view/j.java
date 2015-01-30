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
public class j extends Button {
    private float Mr;
    private float Ms;
    private float Mt;
    private float Mu;
    private WindowManager.LayoutParams Mv;
    private LinearLayout Mw;
    private LinearLayout Mx;
    private Rect My;
    private boolean Mz;
    private View.OnClickListener mClickListener;
    private WindowManager windowManager;
    private float x;
    private float y;

    public j(Context context) {
        super(context);
        this.My = new Rect();
        setBackgroundResource(com.baidu.tieba.v.btn_game_tie_bg);
        this.windowManager = (WindowManager) context.getSystemService("window");
        this.Mv = qC();
        this.Mw = qA();
        this.Mx = qB();
        this.windowManager.addView(this.Mw, this.Mw.getLayoutParams());
        this.windowManager.addView(this.Mx, this.Mx.getLayoutParams());
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getWindowVisibleDisplayFrame(this.My);
        this.x = motionEvent.getRawX();
        this.y = motionEvent.getRawY() - this.My.top;
        switch (motionEvent.getAction()) {
            case 0:
                this.Mr = motionEvent.getX();
                this.Ms = motionEvent.getY();
                this.Mt = this.x;
                this.Mu = this.y;
                this.Mz = false;
                break;
            case 1:
                int[] P = com.baidu.adp.lib.util.l.P(getContext());
                boolean z = P[0] / 2 < ((int) (this.x - this.Mr));
                if (this.Mz) {
                    q(z ? P[0] - getWidth() : 0, (int) (this.y - this.Ms));
                } else {
                    ar(z);
                }
                this.Ms = 0.0f;
                this.Mr = 0.0f;
                break;
            case 2:
                if (!this.Mz && (Math.abs(this.x - this.Mt) > 3.0f || Math.abs(this.y - this.Mu) > 3.0f)) {
                    this.Mz = true;
                }
                if (this.Mz) {
                    q((int) (this.x - this.Mr), (int) (this.y - this.Ms));
                    this.Mx.setVisibility(8);
                    this.Mw.setVisibility(8);
                    break;
                }
                break;
        }
        return true;
    }

    private void ar(boolean z) {
        if (z) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.Mx.getLayoutParams();
            layoutParams.y = this.Mv.y;
            this.windowManager.updateViewLayout(this.Mx, layoutParams);
            this.Mx.setVisibility(this.Mx.getVisibility() == 8 ? 0 : 8);
            return;
        }
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) this.Mw.getLayoutParams();
        layoutParams2.y = this.Mv.y;
        this.windowManager.updateViewLayout(this.Mw, layoutParams2);
        this.Mw.setVisibility(this.Mw.getVisibility() != 8 ? 8 : 0);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    private void q(int i, int i2) {
        this.Mv.x = i;
        this.Mv.y = i2;
        this.windowManager.updateViewLayout(this, this.Mv);
    }

    public WindowManager.LayoutParams getWindowManagerParams() {
        return this.Mv;
    }

    public void setWindowManagerParams(WindowManager.LayoutParams layoutParams) {
        this.Mv = layoutParams;
    }

    private LinearLayout qA() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(com.baidu.tieba.x.floatview_layout, (ViewGroup) null);
        linearLayout.setBackgroundResource(com.baidu.tieba.v.bg_game_tie);
        linearLayout.findViewById(com.baidu.tieba.w.floatview_layout_left_layout).setVisibility(8);
        linearLayout.setLayoutParams(qC());
        linearLayout.setVisibility(8);
        return linearLayout;
    }

    private LinearLayout qB() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(com.baidu.tieba.x.floatview_layout, (ViewGroup) null);
        linearLayout.setBackgroundResource(com.baidu.tieba.v.bg_game_tie);
        linearLayout.findViewById(com.baidu.tieba.w.floatview_layout_right_layout).setVisibility(8);
        WindowManager.LayoutParams qC = qC();
        qC.gravity = 53;
        linearLayout.setLayoutParams(qC);
        linearLayout.setVisibility(8);
        return linearLayout;
    }

    private WindowManager.LayoutParams qC() {
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
                k kVar = new k(getContext(), list.get(i));
                kVar.setOnClickListener(this.mClickListener);
                ((LinearLayout) this.Mw.findViewById(com.baidu.tieba.w.floatview_layout_right_layout)).addView(kVar, k.qD());
                this.Mw.findViewById(com.baidu.tieba.w.floatview_layout_left_layout).setVisibility(8);
            }
            for (int i2 = size - 1; i2 >= 0; i2--) {
                k kVar2 = new k(getContext(), list.get(i2));
                kVar2.setOnClickListener(this.mClickListener);
                ((LinearLayout) this.Mx.findViewById(com.baidu.tieba.w.floatview_layout_left_layout)).addView(kVar2, k.qD());
                this.Mx.findViewById(com.baidu.tieba.w.floatview_layout_right_layout).setVisibility(8);
            }
        }
    }

    public void onDestroy() {
        this.windowManager.removeView(this.Mw);
        this.windowManager.removeView(this.Mx);
    }
}
