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
    private float Mo;
    private float Mp;
    private float Mq;
    private float Mr;
    private WindowManager.LayoutParams Ms;
    private LinearLayout Mt;
    private LinearLayout Mu;
    private Rect Mv;
    private boolean Mw;
    private View.OnClickListener mClickListener;
    private WindowManager windowManager;
    private float x;
    private float y;

    public j(Context context) {
        super(context);
        this.Mv = new Rect();
        setBackgroundResource(com.baidu.tieba.v.btn_game_tie_bg);
        this.windowManager = (WindowManager) context.getSystemService("window");
        this.Ms = qw();
        this.Mt = qu();
        this.Mu = qv();
        this.windowManager.addView(this.Mt, this.Mt.getLayoutParams());
        this.windowManager.addView(this.Mu, this.Mu.getLayoutParams());
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getWindowVisibleDisplayFrame(this.Mv);
        this.x = motionEvent.getRawX();
        this.y = motionEvent.getRawY() - this.Mv.top;
        switch (motionEvent.getAction()) {
            case 0:
                this.Mo = motionEvent.getX();
                this.Mp = motionEvent.getY();
                this.Mq = this.x;
                this.Mr = this.y;
                this.Mw = false;
                break;
            case 1:
                int[] P = com.baidu.adp.lib.util.l.P(getContext());
                boolean z = P[0] / 2 < ((int) (this.x - this.Mo));
                if (this.Mw) {
                    q(z ? P[0] - getWidth() : 0, (int) (this.y - this.Mp));
                } else {
                    ar(z);
                }
                this.Mp = 0.0f;
                this.Mo = 0.0f;
                break;
            case 2:
                if (!this.Mw && (Math.abs(this.x - this.Mq) > 3.0f || Math.abs(this.y - this.Mr) > 3.0f)) {
                    this.Mw = true;
                }
                if (this.Mw) {
                    q((int) (this.x - this.Mo), (int) (this.y - this.Mp));
                    this.Mu.setVisibility(8);
                    this.Mt.setVisibility(8);
                    break;
                }
                break;
        }
        return true;
    }

    private void ar(boolean z) {
        if (z) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.Mu.getLayoutParams();
            layoutParams.y = this.Ms.y;
            this.windowManager.updateViewLayout(this.Mu, layoutParams);
            this.Mu.setVisibility(this.Mu.getVisibility() == 8 ? 0 : 8);
            return;
        }
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) this.Mt.getLayoutParams();
        layoutParams2.y = this.Ms.y;
        this.windowManager.updateViewLayout(this.Mt, layoutParams2);
        this.Mt.setVisibility(this.Mt.getVisibility() != 8 ? 8 : 0);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    private void q(int i, int i2) {
        this.Ms.x = i;
        this.Ms.y = i2;
        this.windowManager.updateViewLayout(this, this.Ms);
    }

    public WindowManager.LayoutParams getWindowManagerParams() {
        return this.Ms;
    }

    public void setWindowManagerParams(WindowManager.LayoutParams layoutParams) {
        this.Ms = layoutParams;
    }

    private LinearLayout qu() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(com.baidu.tieba.x.floatview_layout, (ViewGroup) null);
        linearLayout.setBackgroundResource(com.baidu.tieba.v.bg_game_tie);
        linearLayout.findViewById(com.baidu.tieba.w.floatview_layout_left_layout).setVisibility(8);
        linearLayout.setLayoutParams(qw());
        linearLayout.setVisibility(8);
        return linearLayout;
    }

    private LinearLayout qv() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(com.baidu.tieba.x.floatview_layout, (ViewGroup) null);
        linearLayout.setBackgroundResource(com.baidu.tieba.v.bg_game_tie);
        linearLayout.findViewById(com.baidu.tieba.w.floatview_layout_right_layout).setVisibility(8);
        WindowManager.LayoutParams qw = qw();
        qw.gravity = 53;
        linearLayout.setLayoutParams(qw);
        linearLayout.setVisibility(8);
        return linearLayout;
    }

    private WindowManager.LayoutParams qw() {
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
                ((LinearLayout) this.Mt.findViewById(com.baidu.tieba.w.floatview_layout_right_layout)).addView(kVar, k.qx());
                this.Mt.findViewById(com.baidu.tieba.w.floatview_layout_left_layout).setVisibility(8);
            }
            for (int i2 = size - 1; i2 >= 0; i2--) {
                k kVar2 = new k(getContext(), list.get(i2));
                kVar2.setOnClickListener(this.mClickListener);
                ((LinearLayout) this.Mu.findViewById(com.baidu.tieba.w.floatview_layout_left_layout)).addView(kVar2, k.qx());
                this.Mu.findViewById(com.baidu.tieba.w.floatview_layout_right_layout).setVisibility(8);
            }
        }
    }

    public void onDestroy() {
        this.windowManager.removeView(this.Mt);
        this.windowManager.removeView(this.Mu);
    }
}
