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
import android.widget.TextView;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class FloatView extends Button {
    private boolean adA;
    private float ads;
    private float adt;
    private float adu;
    private float adv;
    private WindowManager.LayoutParams adw;
    private LinearLayout adx;
    private LinearLayout ady;
    private Rect adz;
    private View.OnClickListener mClickListener;
    private WindowManager windowManager;
    private float x;
    private float y;

    public FloatView(Context context) {
        super(context);
        this.adz = new Rect();
        setBackgroundResource(i.e.btn_game_tie_bg);
        this.windowManager = (WindowManager) context.getSystemService("window");
        this.adw = vw();
        this.adx = vu();
        this.ady = vv();
        this.windowManager.addView(this.adx, this.adx.getLayoutParams());
        this.windowManager.addView(this.ady, this.ady.getLayoutParams());
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getWindowVisibleDisplayFrame(this.adz);
        this.x = motionEvent.getRawX();
        this.y = motionEvent.getRawY() - this.adz.top;
        switch (motionEvent.getAction()) {
            case 0:
                this.ads = motionEvent.getX();
                this.adt = motionEvent.getY();
                this.adu = this.x;
                this.adv = this.y;
                this.adA = false;
                break;
            case 1:
                int[] N = com.baidu.adp.lib.util.k.N(getContext());
                boolean z = N[0] / 2 < ((int) (this.x - this.ads));
                if (this.adA) {
                    y(z ? N[0] - getWidth() : 0, (int) (this.y - this.adt));
                } else {
                    aw(z);
                }
                this.adt = 0.0f;
                this.ads = 0.0f;
                break;
            case 2:
                if (!this.adA && (Math.abs(this.x - this.adu) > 3.0f || Math.abs(this.y - this.adv) > 3.0f)) {
                    this.adA = true;
                }
                if (this.adA) {
                    y((int) (this.x - this.ads), (int) (this.y - this.adt));
                    this.ady.setVisibility(8);
                    this.adx.setVisibility(8);
                    break;
                }
                break;
        }
        return true;
    }

    private void aw(boolean z) {
        if (z) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.ady.getLayoutParams();
            layoutParams.y = this.adw.y;
            this.windowManager.updateViewLayout(this.ady, layoutParams);
            this.ady.setVisibility(this.ady.getVisibility() == 8 ? 0 : 8);
            return;
        }
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) this.adx.getLayoutParams();
        layoutParams2.y = this.adw.y;
        this.windowManager.updateViewLayout(this.adx, layoutParams2);
        this.adx.setVisibility(this.adx.getVisibility() != 8 ? 8 : 0);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    private void y(int i, int i2) {
        this.adw.x = i;
        this.adw.y = i2;
        this.windowManager.updateViewLayout(this, this.adw);
    }

    public WindowManager.LayoutParams getWindowManagerParams() {
        return this.adw;
    }

    public void setWindowManagerParams(WindowManager.LayoutParams layoutParams) {
        this.adw = layoutParams;
    }

    private LinearLayout vu() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(i.g.floatview_layout, (ViewGroup) null);
        linearLayout.setBackgroundResource(i.e.bg_game_tie);
        linearLayout.findViewById(i.f.floatview_layout_left_layout).setVisibility(8);
        linearLayout.setLayoutParams(vw());
        linearLayout.setVisibility(8);
        return linearLayout;
    }

    private LinearLayout vv() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(i.g.floatview_layout, (ViewGroup) null);
        linearLayout.setBackgroundResource(i.e.bg_game_tie);
        linearLayout.findViewById(i.f.floatview_layout_right_layout).setVisibility(8);
        WindowManager.LayoutParams vw = vw();
        vw.gravity = 53;
        linearLayout.setLayoutParams(vw);
        linearLayout.setVisibility(8);
        return linearLayout;
    }

    private WindowManager.LayoutParams vw() {
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
                a aVar = new a(getContext(), list.get(i));
                aVar.setOnClickListener(this.mClickListener);
                ((LinearLayout) this.adx.findViewById(i.f.floatview_layout_right_layout)).addView(aVar, a.vx());
                this.adx.findViewById(i.f.floatview_layout_left_layout).setVisibility(8);
            }
            for (int i2 = size - 1; i2 >= 0; i2--) {
                a aVar2 = new a(getContext(), list.get(i2));
                aVar2.setOnClickListener(this.mClickListener);
                ((LinearLayout) this.ady.findViewById(i.f.floatview_layout_left_layout)).addView(aVar2, a.vx());
                this.ady.findViewById(i.f.floatview_layout_right_layout).setVisibility(8);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class a extends LinearLayout {
        public a(Context context, String str) {
            super(context);
            LayoutInflater.from(getContext()).inflate(i.g.floatview_item_layout, this);
            setGravity(17);
            ((TextView) findViewById(i.f.floatview_item_tv)).setText(str);
            setTag(str);
        }

        public static LinearLayout.LayoutParams vx() {
            return new LinearLayout.LayoutParams(-2, -1);
        }
    }

    public void onDestroy() {
        this.windowManager.removeView(this.adx);
        this.windowManager.removeView(this.ady);
    }
}
