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
import com.baidu.swan.menu.g;
/* loaded from: classes14.dex */
public class SwanAppMenuItemView extends RelativeLayout {
    private int dBu;
    private int dBv;
    private boolean dBw;
    private Runnable dBz;
    private TextView eaL;
    private ImageView eaM;
    private i eaN;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.dBw = false;
        this.dBz = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.eaN != null && SwanAppMenuItemView.this.eaN.aXX() != null) {
                    SwanAppMenuItemView.this.dBw = SwanAppMenuItemView.this.eaN.aXX().c(SwanAppMenuItemView.this.eaN);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dBw = false;
        this.dBz = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.eaN != null && SwanAppMenuItemView.this.eaN.aXX() != null) {
                    SwanAppMenuItemView.this.dBw = SwanAppMenuItemView.this.eaN.aXX().c(SwanAppMenuItemView.this.eaN);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dBw = false;
        this.dBz = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.eaN != null && SwanAppMenuItemView.this.eaN.aXX() != null) {
                    SwanAppMenuItemView.this.dBw = SwanAppMenuItemView.this.eaN.aXX().c(SwanAppMenuItemView.this.eaN);
                }
            }
        };
        init();
    }

    private void init() {
        setGravity(49);
        LayoutInflater.from(getContext()).inflate(g.e.aiapp_menu_item_view_layout, this);
        this.mIconView = (ImageView) findViewById(g.d.aiapp_menu_item_icon);
        this.mTitleView = (TextView) findViewById(g.d.aiapp_menu_item_title);
        this.eaL = (TextView) findViewById(g.d.aiapp_menu_item_new_tips);
        this.eaM = (ImageView) findViewById(g.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(i iVar) {
        if (iVar != null) {
            setItemView(iVar);
            this.eaN = iVar;
        }
    }

    private void setItemView(i iVar) {
        this.mTitleView.setEllipsize(TextUtils.TruncateAt.END);
        this.mTitleView.setAlpha(iVar.isEnable() ? 1.0f : 0.3f);
        System.out.println(iVar.isEnable());
        this.mIconView.setEnabled(iVar.isEnable());
        this.mIconView.setScaleType(ImageView.ScaleType.CENTER);
        this.mIconView.setVisibility(0);
        g(iVar);
        h(iVar);
    }

    private void g(i iVar) {
        if (iVar != null) {
            setAlpha(1.0f);
            this.mTitleView.setText(iVar.dG(getContext()));
            Drawable i = i(iVar);
            if (i != null) {
                this.mIconView.setImageDrawable(i);
                this.mIconView.setImageLevel(iVar.aXV());
            }
            this.mTitleView.setTextColor(getResources().getColor(iVar.getTitleColor()));
        }
    }

    private void h(i iVar) {
        if (iVar != null) {
            switch (iVar.aXT()) {
                case 0:
                    this.eaL.setVisibility(8);
                    this.eaL.setVisibility(8);
                    return;
                case 1:
                    this.eaM.setVisibility(8);
                    this.eaL.setText(cp(iVar.aXU()));
                    this.eaL.setTextColor(getResources().getColor(g.a.swan_app_menu_item_tip_text));
                    this.eaL.setBackground(getResources().getDrawable(g.c.swan_app_menu_new_bg));
                    this.eaL.setVisibility(0);
                    return;
                case 2:
                    this.eaL.setVisibility(8);
                    this.eaM.setImageDrawable(getResources().getDrawable(g.c.swan_app_menu_new_dot));
                    this.eaM.setVisibility(0);
                    return;
                default:
                    this.eaL.setVisibility(8);
                    this.eaM.setVisibility(8);
                    return;
            }
        }
    }

    private String cp(long j) {
        return j <= 99 ? String.valueOf(j) : "99+";
    }

    private Drawable i(i iVar) {
        return iVar.dH(getContext());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.eaN == null || this.eaN.aXX() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.dBz);
                this.dBw = false;
                this.dBu = x;
                this.dBv = y;
                postDelayed(this.dBz, IMConnection.RETRY_DELAY_TIMES);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.dBz);
                if (!this.dBw && this.eaN.aXW() != null) {
                    this.eaN.aXW().a(this, this.eaN);
                }
                this.dBw = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.dBu - x) > 10 || Math.abs(this.dBv - y) > 10) {
                    removeCallbacks(this.dBz);
                    this.dBw = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.dBz);
                this.dBw = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
