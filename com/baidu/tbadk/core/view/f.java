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
public class f extends Button {
    private float XA;
    private WindowManager.LayoutParams XB;
    private LinearLayout XC;
    private LinearLayout XD;
    private Rect XE;
    private boolean XF;
    private float Xx;
    private float Xy;
    private float Xz;
    private View.OnClickListener mClickListener;
    private WindowManager windowManager;
    private float x;
    private float y;

    public f(Context context) {
        super(context);
        this.XE = new Rect();
        setBackgroundResource(com.baidu.tieba.u.btn_game_tie_bg);
        this.windowManager = (WindowManager) context.getSystemService("window");
        this.XB = tH();
        this.XC = tF();
        this.XD = tG();
        this.windowManager.addView(this.XC, this.XC.getLayoutParams());
        this.windowManager.addView(this.XD, this.XD.getLayoutParams());
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getWindowVisibleDisplayFrame(this.XE);
        this.x = motionEvent.getRawX();
        this.y = motionEvent.getRawY() - this.XE.top;
        switch (motionEvent.getAction()) {
            case 0:
                this.Xx = motionEvent.getX();
                this.Xy = motionEvent.getY();
                this.Xz = this.x;
                this.XA = this.y;
                this.XF = false;
                break;
            case 1:
                int[] P = com.baidu.adp.lib.util.n.P(getContext());
                boolean z = P[0] / 2 < ((int) (this.x - this.Xx));
                if (this.XF) {
                    o(z ? P[0] - getWidth() : 0, (int) (this.y - this.Xy));
                } else {
                    al(z);
                }
                this.Xy = 0.0f;
                this.Xx = 0.0f;
                break;
            case 2:
                if (!this.XF && (Math.abs(this.x - this.Xz) > 3.0f || Math.abs(this.y - this.XA) > 3.0f)) {
                    this.XF = true;
                }
                if (this.XF) {
                    o((int) (this.x - this.Xx), (int) (this.y - this.Xy));
                    this.XD.setVisibility(8);
                    this.XC.setVisibility(8);
                    break;
                }
                break;
        }
        return true;
    }

    private void al(boolean z) {
        if (z) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.XD.getLayoutParams();
            layoutParams.y = this.XB.y;
            this.windowManager.updateViewLayout(this.XD, layoutParams);
            this.XD.setVisibility(this.XD.getVisibility() == 8 ? 0 : 8);
            return;
        }
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) this.XC.getLayoutParams();
        layoutParams2.y = this.XB.y;
        this.windowManager.updateViewLayout(this.XC, layoutParams2);
        this.XC.setVisibility(this.XC.getVisibility() != 8 ? 8 : 0);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    private void o(int i, int i2) {
        this.XB.x = i;
        this.XB.y = i2;
        this.windowManager.updateViewLayout(this, this.XB);
    }

    public WindowManager.LayoutParams getWindowManagerParams() {
        return this.XB;
    }

    public void setWindowManagerParams(WindowManager.LayoutParams layoutParams) {
        this.XB = layoutParams;
    }

    private LinearLayout tF() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(com.baidu.tieba.w.floatview_layout, (ViewGroup) null);
        linearLayout.setBackgroundResource(com.baidu.tieba.u.bg_game_tie);
        linearLayout.findViewById(com.baidu.tieba.v.floatview_layout_left_layout).setVisibility(8);
        linearLayout.setLayoutParams(tH());
        linearLayout.setVisibility(8);
        return linearLayout;
    }

    private LinearLayout tG() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(com.baidu.tieba.w.floatview_layout, (ViewGroup) null);
        linearLayout.setBackgroundResource(com.baidu.tieba.u.bg_game_tie);
        linearLayout.findViewById(com.baidu.tieba.v.floatview_layout_right_layout).setVisibility(8);
        WindowManager.LayoutParams tH = tH();
        tH.gravity = 53;
        linearLayout.setLayoutParams(tH);
        linearLayout.setVisibility(8);
        return linearLayout;
    }

    private WindowManager.LayoutParams tH() {
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
                g gVar = new g(getContext(), list.get(i));
                gVar.setOnClickListener(this.mClickListener);
                ((LinearLayout) this.XC.findViewById(com.baidu.tieba.v.floatview_layout_right_layout)).addView(gVar, g.tI());
                this.XC.findViewById(com.baidu.tieba.v.floatview_layout_left_layout).setVisibility(8);
            }
            for (int i2 = size - 1; i2 >= 0; i2--) {
                g gVar2 = new g(getContext(), list.get(i2));
                gVar2.setOnClickListener(this.mClickListener);
                ((LinearLayout) this.XD.findViewById(com.baidu.tieba.v.floatview_layout_left_layout)).addView(gVar2, g.tI());
                this.XD.findViewById(com.baidu.tieba.v.floatview_layout_right_layout).setVisibility(8);
            }
        }
    }

    public void onDestroy() {
        this.windowManager.removeView(this.XC);
        this.windowManager.removeView(this.XD);
    }
}
