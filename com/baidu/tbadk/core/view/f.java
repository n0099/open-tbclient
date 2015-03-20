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
    private LinearLayout XA;
    private LinearLayout XB;
    private Rect XC;
    private boolean XD;
    private float Xv;
    private float Xw;
    private float Xx;
    private float Xy;
    private WindowManager.LayoutParams Xz;
    private View.OnClickListener mClickListener;
    private WindowManager windowManager;
    private float x;
    private float y;

    public f(Context context) {
        super(context);
        this.XC = new Rect();
        setBackgroundResource(com.baidu.tieba.u.btn_game_tie_bg);
        this.windowManager = (WindowManager) context.getSystemService("window");
        this.Xz = tH();
        this.XA = tF();
        this.XB = tG();
        this.windowManager.addView(this.XA, this.XA.getLayoutParams());
        this.windowManager.addView(this.XB, this.XB.getLayoutParams());
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getWindowVisibleDisplayFrame(this.XC);
        this.x = motionEvent.getRawX();
        this.y = motionEvent.getRawY() - this.XC.top;
        switch (motionEvent.getAction()) {
            case 0:
                this.Xv = motionEvent.getX();
                this.Xw = motionEvent.getY();
                this.Xx = this.x;
                this.Xy = this.y;
                this.XD = false;
                break;
            case 1:
                int[] P = com.baidu.adp.lib.util.n.P(getContext());
                boolean z = P[0] / 2 < ((int) (this.x - this.Xv));
                if (this.XD) {
                    o(z ? P[0] - getWidth() : 0, (int) (this.y - this.Xw));
                } else {
                    al(z);
                }
                this.Xw = 0.0f;
                this.Xv = 0.0f;
                break;
            case 2:
                if (!this.XD && (Math.abs(this.x - this.Xx) > 3.0f || Math.abs(this.y - this.Xy) > 3.0f)) {
                    this.XD = true;
                }
                if (this.XD) {
                    o((int) (this.x - this.Xv), (int) (this.y - this.Xw));
                    this.XB.setVisibility(8);
                    this.XA.setVisibility(8);
                    break;
                }
                break;
        }
        return true;
    }

    private void al(boolean z) {
        if (z) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.XB.getLayoutParams();
            layoutParams.y = this.Xz.y;
            this.windowManager.updateViewLayout(this.XB, layoutParams);
            this.XB.setVisibility(this.XB.getVisibility() == 8 ? 0 : 8);
            return;
        }
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) this.XA.getLayoutParams();
        layoutParams2.y = this.Xz.y;
        this.windowManager.updateViewLayout(this.XA, layoutParams2);
        this.XA.setVisibility(this.XA.getVisibility() != 8 ? 8 : 0);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    private void o(int i, int i2) {
        this.Xz.x = i;
        this.Xz.y = i2;
        this.windowManager.updateViewLayout(this, this.Xz);
    }

    public WindowManager.LayoutParams getWindowManagerParams() {
        return this.Xz;
    }

    public void setWindowManagerParams(WindowManager.LayoutParams layoutParams) {
        this.Xz = layoutParams;
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
                ((LinearLayout) this.XA.findViewById(com.baidu.tieba.v.floatview_layout_right_layout)).addView(gVar, g.tI());
                this.XA.findViewById(com.baidu.tieba.v.floatview_layout_left_layout).setVisibility(8);
            }
            for (int i2 = size - 1; i2 >= 0; i2--) {
                g gVar2 = new g(getContext(), list.get(i2));
                gVar2.setOnClickListener(this.mClickListener);
                ((LinearLayout) this.XB.findViewById(com.baidu.tieba.v.floatview_layout_left_layout)).addView(gVar2, g.tI());
                this.XB.findViewById(com.baidu.tieba.v.floatview_layout_right_layout).setVisibility(8);
            }
        }
    }

    public void onDestroy() {
        this.windowManager.removeView(this.XA);
        this.windowManager.removeView(this.XB);
    }
}
