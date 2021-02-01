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
    private int WQ;
    private int dSQ;
    private boolean dSR;
    private Runnable dSU;
    private TextView esW;
    private ImageView esX;
    private h esY;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.dSR = false;
        this.dSU = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.esY != null && SwanAppMenuItemView.this.esY.bbL() != null) {
                    SwanAppMenuItemView.this.dSR = SwanAppMenuItemView.this.esY.bbL().c(SwanAppMenuItemView.this.esY);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dSR = false;
        this.dSU = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.esY != null && SwanAppMenuItemView.this.esY.bbL() != null) {
                    SwanAppMenuItemView.this.dSR = SwanAppMenuItemView.this.esY.bbL().c(SwanAppMenuItemView.this.esY);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dSR = false;
        this.dSU = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.esY != null && SwanAppMenuItemView.this.esY.bbL() != null) {
                    SwanAppMenuItemView.this.dSR = SwanAppMenuItemView.this.esY.bbL().c(SwanAppMenuItemView.this.esY);
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
        this.esW = (TextView) findViewById(f.d.aiapp_menu_item_new_tips);
        this.esX = (ImageView) findViewById(f.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(h hVar) {
        if (hVar != null) {
            setItemView(hVar);
            this.esY = hVar;
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
            this.mTitleView.setText(hVar.eD(getContext()));
            Drawable i = i(hVar);
            if (i != null) {
                this.mIconView.setImageDrawable(i);
                this.mIconView.setImageLevel(hVar.bbJ());
            }
            this.mTitleView.setTextColor(getResources().getColor(hVar.getTitleColor()));
        }
    }

    private void h(h hVar) {
        if (hVar != null) {
            switch (hVar.bbH()) {
                case 0:
                    this.esW.setVisibility(8);
                    this.esW.setVisibility(8);
                    return;
                case 1:
                    this.esX.setVisibility(8);
                    this.esW.setText(dr(hVar.bbI()));
                    this.esW.setTextColor(getResources().getColor(f.a.swan_app_menu_item_tip_text));
                    this.esW.setBackground(getResources().getDrawable(f.c.swan_app_menu_new_bg));
                    this.esW.setVisibility(0);
                    return;
                case 2:
                    this.esW.setVisibility(8);
                    this.esX.setImageDrawable(getResources().getDrawable(f.c.swan_app_menu_new_dot));
                    this.esX.setVisibility(0);
                    return;
                default:
                    this.esW.setVisibility(8);
                    this.esX.setVisibility(8);
                    return;
            }
        }
    }

    private String dr(long j) {
        return j <= 99 ? String.valueOf(j) : "99+";
    }

    private Drawable i(h hVar) {
        return hVar.eE(getContext());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.esY == null || this.esY.bbL() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.dSU);
                this.dSR = false;
                this.dSQ = x;
                this.WQ = y;
                postDelayed(this.dSU, IMConnection.RETRY_DELAY_TIMES);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.dSU);
                if (!this.dSR && this.esY.bbK() != null) {
                    this.esY.bbK().a(this, this.esY);
                }
                this.dSR = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.dSQ - x) > 10 || Math.abs(this.WQ - y) > 10) {
                    removeCallbacks(this.dSU);
                    this.dSR = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.dSU);
                this.dSR = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
