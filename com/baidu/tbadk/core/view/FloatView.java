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
    private float adi;
    private float adj;
    private float adk;
    private float adl;
    private WindowManager.LayoutParams adm;
    private LinearLayout adn;
    private LinearLayout ado;
    private Rect adp;
    private boolean adq;
    private View.OnClickListener mClickListener;
    private WindowManager windowManager;
    private float x;
    private float y;

    public FloatView(Context context) {
        super(context);
        this.adp = new Rect();
        setBackgroundResource(i.e.btn_game_tie_bg);
        this.windowManager = (WindowManager) context.getSystemService("window");
        this.adm = vr();
        this.adn = vp();
        this.ado = vq();
        this.windowManager.addView(this.adn, this.adn.getLayoutParams());
        this.windowManager.addView(this.ado, this.ado.getLayoutParams());
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getWindowVisibleDisplayFrame(this.adp);
        this.x = motionEvent.getRawX();
        this.y = motionEvent.getRawY() - this.adp.top;
        switch (motionEvent.getAction()) {
            case 0:
                this.adi = motionEvent.getX();
                this.adj = motionEvent.getY();
                this.adk = this.x;
                this.adl = this.y;
                this.adq = false;
                break;
            case 1:
                int[] N = com.baidu.adp.lib.util.k.N(getContext());
                boolean z = N[0] / 2 < ((int) (this.x - this.adi));
                if (this.adq) {
                    y(z ? N[0] - getWidth() : 0, (int) (this.y - this.adj));
                } else {
                    aw(z);
                }
                this.adj = 0.0f;
                this.adi = 0.0f;
                break;
            case 2:
                if (!this.adq && (Math.abs(this.x - this.adk) > 3.0f || Math.abs(this.y - this.adl) > 3.0f)) {
                    this.adq = true;
                }
                if (this.adq) {
                    y((int) (this.x - this.adi), (int) (this.y - this.adj));
                    this.ado.setVisibility(8);
                    this.adn.setVisibility(8);
                    break;
                }
                break;
        }
        return true;
    }

    private void aw(boolean z) {
        if (z) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.ado.getLayoutParams();
            layoutParams.y = this.adm.y;
            this.windowManager.updateViewLayout(this.ado, layoutParams);
            this.ado.setVisibility(this.ado.getVisibility() == 8 ? 0 : 8);
            return;
        }
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) this.adn.getLayoutParams();
        layoutParams2.y = this.adm.y;
        this.windowManager.updateViewLayout(this.adn, layoutParams2);
        this.adn.setVisibility(this.adn.getVisibility() != 8 ? 8 : 0);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    private void y(int i, int i2) {
        this.adm.x = i;
        this.adm.y = i2;
        this.windowManager.updateViewLayout(this, this.adm);
    }

    public WindowManager.LayoutParams getWindowManagerParams() {
        return this.adm;
    }

    public void setWindowManagerParams(WindowManager.LayoutParams layoutParams) {
        this.adm = layoutParams;
    }

    private LinearLayout vp() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(i.g.floatview_layout, (ViewGroup) null);
        linearLayout.setBackgroundResource(i.e.bg_game_tie);
        linearLayout.findViewById(i.f.floatview_layout_left_layout).setVisibility(8);
        linearLayout.setLayoutParams(vr());
        linearLayout.setVisibility(8);
        return linearLayout;
    }

    private LinearLayout vq() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(i.g.floatview_layout, (ViewGroup) null);
        linearLayout.setBackgroundResource(i.e.bg_game_tie);
        linearLayout.findViewById(i.f.floatview_layout_right_layout).setVisibility(8);
        WindowManager.LayoutParams vr = vr();
        vr.gravity = 53;
        linearLayout.setLayoutParams(vr);
        linearLayout.setVisibility(8);
        return linearLayout;
    }

    private WindowManager.LayoutParams vr() {
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
                ((LinearLayout) this.adn.findViewById(i.f.floatview_layout_right_layout)).addView(aVar, a.vs());
                this.adn.findViewById(i.f.floatview_layout_left_layout).setVisibility(8);
            }
            for (int i2 = size - 1; i2 >= 0; i2--) {
                a aVar2 = new a(getContext(), list.get(i2));
                aVar2.setOnClickListener(this.mClickListener);
                ((LinearLayout) this.ado.findViewById(i.f.floatview_layout_left_layout)).addView(aVar2, a.vs());
                this.ado.findViewById(i.f.floatview_layout_right_layout).setVisibility(8);
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

        public static LinearLayout.LayoutParams vs() {
            return new LinearLayout.LayoutParams(-2, -1);
        }
    }

    public void onDestroy() {
        this.windowManager.removeView(this.adn);
        this.windowManager.removeView(this.ado);
    }
}
