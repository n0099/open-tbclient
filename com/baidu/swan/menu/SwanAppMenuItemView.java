package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.swan.menu.f;
/* loaded from: classes5.dex */
public class SwanAppMenuItemView extends RelativeLayout {
    private int WX;
    private Runnable dVA;
    private int dVw;
    private boolean dVx;
    private TextView evD;
    private ImageView evE;
    private h evF;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.dVx = false;
        this.dVA = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.evF != null && SwanAppMenuItemView.this.evF.bfr() != null) {
                    SwanAppMenuItemView.this.dVx = SwanAppMenuItemView.this.evF.bfr().c(SwanAppMenuItemView.this.evF);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dVx = false;
        this.dVA = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.evF != null && SwanAppMenuItemView.this.evF.bfr() != null) {
                    SwanAppMenuItemView.this.dVx = SwanAppMenuItemView.this.evF.bfr().c(SwanAppMenuItemView.this.evF);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dVx = false;
        this.dVA = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.evF != null && SwanAppMenuItemView.this.evF.bfr() != null) {
                    SwanAppMenuItemView.this.dVx = SwanAppMenuItemView.this.evF.bfr().c(SwanAppMenuItemView.this.evF);
                }
            }
        };
        init();
    }

    private void init() {
        setGravity(49);
        LayoutInflater.from(getContext()).inflate(f.e.aiapp_menu_item_view_layout, this);
        this.mIconView = (ImageView) findViewById(f.d.aiapp_menu_item_icon);
        this.mTitleView = (TextView) findViewById(f.d.aiapp_menu_item_title);
        this.evD = (TextView) findViewById(f.d.aiapp_menu_item_new_tips);
        this.evE = (ImageView) findViewById(f.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(h hVar) {
        if (hVar != null) {
            setItemView(hVar);
            this.evF = hVar;
        }
    }

    private void setItemView(h hVar) {
        this.mTitleView.setEllipsize(TextUtils.TruncateAt.END);
        this.mTitleView.setAlpha(hVar.isEnable() ? 1.0f : 0.3f);
        System.out.println(hVar.isEnable());
        this.mIconView.setEnabled(hVar.isEnable());
        this.mIconView.setScaleType(ImageView.ScaleType.CENTER);
        this.mIconView.setVisibility(0);
        g(hVar);
        h(hVar);
    }

    private void g(h hVar) {
        if (hVar != null) {
            setAlpha(1.0f);
            this.mTitleView.setText(hVar.eF(getContext()));
            Drawable i = i(hVar);
            if (i != null) {
                this.mIconView.setImageDrawable(i);
                this.mIconView.setImageLevel(hVar.bfp());
            }
            this.mTitleView.setTextColor(getResources().getColor(hVar.getTitleColor()));
        }
    }

    private void h(h hVar) {
        if (hVar != null) {
            switch (hVar.bfn()) {
                case 0:
                    this.evD.setVisibility(8);
                    this.evD.setVisibility(8);
                    return;
                case 1:
                    this.evE.setVisibility(8);
                    this.evD.setText(dl(hVar.bfo()));
                    this.evD.setTextColor(getResources().getColor(f.a.swan_app_menu_item_tip_text));
                    this.evD.setBackground(getResources().getDrawable(f.c.swan_app_menu_new_bg));
                    this.evD.setVisibility(0);
                    return;
                case 2:
                    this.evD.setVisibility(8);
                    this.evE.setImageDrawable(getResources().getDrawable(f.c.swan_app_menu_new_dot));
                    this.evE.setVisibility(0);
                    return;
                default:
                    this.evD.setVisibility(8);
                    this.evE.setVisibility(8);
                    return;
            }
        }
    }

    private String dl(long j) {
        return j <= 99 ? String.valueOf(j) : "99+";
    }

    private Drawable i(h hVar) {
        return hVar.eG(getContext());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.evF == null || this.evF.bfr() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.dVA);
                this.dVx = false;
                this.dVw = x;
                this.WX = y;
                postDelayed(this.dVA, IMConnection.RETRY_DELAY_TIMES);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.dVA);
                if (!this.dVx && this.evF.bfq() != null) {
                    this.evF.bfq().a(this, this.evF);
                }
                this.dVx = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.dVw - x) > 10 || Math.abs(this.WX - y) > 10) {
                    removeCallbacks(this.dVA);
                    this.dVx = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.dVA);
                this.dVx = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
