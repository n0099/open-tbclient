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
    private float LX;
    private float LY;
    private WindowManager.LayoutParams LZ;
    private LinearLayout Ma;
    private LinearLayout Mb;
    private Rect Mc;
    private boolean Md;
    private View.OnClickListener mClickListener;
    private float mStartX;
    private float mStartY;
    private WindowManager windowManager;
    private float x;
    private float y;

    public j(Context context) {
        super(context);
        this.Mc = new Rect();
        setBackgroundResource(com.baidu.tieba.v.btn_game_tie_bg);
        this.windowManager = (WindowManager) context.getSystemService("window");
        this.LZ = qr();
        this.Ma = qp();
        this.Mb = qq();
        this.windowManager.addView(this.Ma, this.Ma.getLayoutParams());
        this.windowManager.addView(this.Mb, this.Mb.getLayoutParams());
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getWindowVisibleDisplayFrame(this.Mc);
        this.x = motionEvent.getRawX();
        this.y = motionEvent.getRawY() - this.Mc.top;
        switch (motionEvent.getAction()) {
            case 0:
                this.LX = motionEvent.getX();
                this.LY = motionEvent.getY();
                this.mStartX = this.x;
                this.mStartY = this.y;
                this.Md = false;
                break;
            case 1:
                int[] P = com.baidu.adp.lib.util.l.P(getContext());
                boolean z = P[0] / 2 < ((int) (this.x - this.LX));
                if (this.Md) {
                    q(z ? P[0] - getWidth() : 0, (int) (this.y - this.LY));
                } else {
                    ap(z);
                }
                this.LY = 0.0f;
                this.LX = 0.0f;
                break;
            case 2:
                if (!this.Md && (Math.abs(this.x - this.mStartX) > 3.0f || Math.abs(this.y - this.mStartY) > 3.0f)) {
                    this.Md = true;
                }
                if (this.Md) {
                    q((int) (this.x - this.LX), (int) (this.y - this.LY));
                    this.Mb.setVisibility(8);
                    this.Ma.setVisibility(8);
                    break;
                }
                break;
        }
        return true;
    }

    private void ap(boolean z) {
        if (z) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.Mb.getLayoutParams();
            layoutParams.y = this.LZ.y;
            this.windowManager.updateViewLayout(this.Mb, layoutParams);
            this.Mb.setVisibility(this.Mb.getVisibility() == 8 ? 0 : 8);
            return;
        }
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) this.Ma.getLayoutParams();
        layoutParams2.y = this.LZ.y;
        this.windowManager.updateViewLayout(this.Ma, layoutParams2);
        this.Ma.setVisibility(this.Ma.getVisibility() != 8 ? 8 : 0);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    private void q(int i, int i2) {
        this.LZ.x = i;
        this.LZ.y = i2;
        this.windowManager.updateViewLayout(this, this.LZ);
    }

    public WindowManager.LayoutParams getWindowManagerParams() {
        return this.LZ;
    }

    public void setWindowManagerParams(WindowManager.LayoutParams layoutParams) {
        this.LZ = layoutParams;
    }

    private LinearLayout qp() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(com.baidu.tieba.x.floatview_layout, (ViewGroup) null);
        linearLayout.setBackgroundResource(com.baidu.tieba.v.bg_game_tie);
        linearLayout.findViewById(com.baidu.tieba.w.floatview_layout_left_layout).setVisibility(8);
        linearLayout.setLayoutParams(qr());
        linearLayout.setVisibility(8);
        return linearLayout;
    }

    private LinearLayout qq() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(com.baidu.tieba.x.floatview_layout, (ViewGroup) null);
        linearLayout.setBackgroundResource(com.baidu.tieba.v.bg_game_tie);
        linearLayout.findViewById(com.baidu.tieba.w.floatview_layout_right_layout).setVisibility(8);
        WindowManager.LayoutParams qr = qr();
        qr.gravity = 53;
        linearLayout.setLayoutParams(qr);
        linearLayout.setVisibility(8);
        return linearLayout;
    }

    private WindowManager.LayoutParams qr() {
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
                ((LinearLayout) this.Ma.findViewById(com.baidu.tieba.w.floatview_layout_right_layout)).addView(kVar, k.qs());
                this.Ma.findViewById(com.baidu.tieba.w.floatview_layout_left_layout).setVisibility(8);
            }
            for (int i2 = size - 1; i2 >= 0; i2--) {
                k kVar2 = new k(getContext(), list.get(i2));
                kVar2.setOnClickListener(this.mClickListener);
                ((LinearLayout) this.Mb.findViewById(com.baidu.tieba.w.floatview_layout_left_layout)).addView(kVar2, k.qs());
                this.Mb.findViewById(com.baidu.tieba.w.floatview_layout_right_layout).setVisibility(8);
            }
        }
    }

    public void onDestroy() {
        this.windowManager.removeView(this.Ma);
        this.windowManager.removeView(this.Mb);
    }
}
