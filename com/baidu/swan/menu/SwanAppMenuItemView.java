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
    private int WV;
    private int dQK;
    private boolean dQL;
    private Runnable dQO;
    private TextView eqP;
    private ImageView eqQ;
    private h eqR;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.dQL = false;
        this.dQO = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.eqR != null && SwanAppMenuItemView.this.eqR.bby() != null) {
                    SwanAppMenuItemView.this.dQL = SwanAppMenuItemView.this.eqR.bby().c(SwanAppMenuItemView.this.eqR);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dQL = false;
        this.dQO = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.eqR != null && SwanAppMenuItemView.this.eqR.bby() != null) {
                    SwanAppMenuItemView.this.dQL = SwanAppMenuItemView.this.eqR.bby().c(SwanAppMenuItemView.this.eqR);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dQL = false;
        this.dQO = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.eqR != null && SwanAppMenuItemView.this.eqR.bby() != null) {
                    SwanAppMenuItemView.this.dQL = SwanAppMenuItemView.this.eqR.bby().c(SwanAppMenuItemView.this.eqR);
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
        this.eqP = (TextView) findViewById(f.d.aiapp_menu_item_new_tips);
        this.eqQ = (ImageView) findViewById(f.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(h hVar) {
        if (hVar != null) {
            setItemView(hVar);
            this.eqR = hVar;
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
            this.mTitleView.setText(hVar.eE(getContext()));
            Drawable i = i(hVar);
            if (i != null) {
                this.mIconView.setImageDrawable(i);
                this.mIconView.setImageLevel(hVar.bbw());
            }
            this.mTitleView.setTextColor(getResources().getColor(hVar.getTitleColor()));
        }
    }

    private void h(h hVar) {
        if (hVar != null) {
            switch (hVar.bbu()) {
                case 0:
                    this.eqP.setVisibility(8);
                    this.eqP.setVisibility(8);
                    return;
                case 1:
                    this.eqQ.setVisibility(8);
                    this.eqP.setText(dl(hVar.bbv()));
                    this.eqP.setTextColor(getResources().getColor(f.a.swan_app_menu_item_tip_text));
                    this.eqP.setBackground(getResources().getDrawable(f.c.swan_app_menu_new_bg));
                    this.eqP.setVisibility(0);
                    return;
                case 2:
                    this.eqP.setVisibility(8);
                    this.eqQ.setImageDrawable(getResources().getDrawable(f.c.swan_app_menu_new_dot));
                    this.eqQ.setVisibility(0);
                    return;
                default:
                    this.eqP.setVisibility(8);
                    this.eqQ.setVisibility(8);
                    return;
            }
        }
    }

    private String dl(long j) {
        return j <= 99 ? String.valueOf(j) : "99+";
    }

    private Drawable i(h hVar) {
        return hVar.eF(getContext());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.eqR == null || this.eqR.bby() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.dQO);
                this.dQL = false;
                this.dQK = x;
                this.WV = y;
                postDelayed(this.dQO, IMConnection.RETRY_DELAY_TIMES);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.dQO);
                if (!this.dQL && this.eqR.bbx() != null) {
                    this.eqR.bbx().a(this, this.eqR);
                }
                this.dQL = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.dQK - x) > 10 || Math.abs(this.WV - y) > 10) {
                    removeCallbacks(this.dQO);
                    this.dQL = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.dQO);
                this.dQL = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
