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
import com.baidu.swan.menu.g;
/* loaded from: classes9.dex */
public class SwanAppMenuItemView extends RelativeLayout {
    private int cVE;
    private int cVF;
    private boolean cVG;
    private Runnable cVJ;
    private TextView duk;
    private ImageView dul;
    private i dum;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.cVG = false;
        this.cVJ = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.dum != null && SwanAppMenuItemView.this.dum.aJV() != null) {
                    SwanAppMenuItemView.this.cVG = SwanAppMenuItemView.this.dum.aJV().c(SwanAppMenuItemView.this.dum);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cVG = false;
        this.cVJ = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.dum != null && SwanAppMenuItemView.this.dum.aJV() != null) {
                    SwanAppMenuItemView.this.cVG = SwanAppMenuItemView.this.dum.aJV().c(SwanAppMenuItemView.this.dum);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cVG = false;
        this.cVJ = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.dum != null && SwanAppMenuItemView.this.dum.aJV() != null) {
                    SwanAppMenuItemView.this.cVG = SwanAppMenuItemView.this.dum.aJV().c(SwanAppMenuItemView.this.dum);
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
        this.duk = (TextView) findViewById(g.d.aiapp_menu_item_new_tips);
        this.dul = (ImageView) findViewById(g.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(i iVar) {
        if (iVar != null) {
            setItemView(iVar);
            this.dum = iVar;
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
            this.mTitleView.setText(iVar.dv(getContext()));
            Drawable i = i(iVar);
            if (i != null) {
                this.mIconView.setImageDrawable(i);
                this.mIconView.setImageLevel(iVar.aJT());
            }
            this.mTitleView.setTextColor(getResources().getColor(iVar.getTitleColor()));
        }
    }

    private void h(i iVar) {
        if (iVar != null) {
            switch (iVar.aJR()) {
                case 0:
                    this.duk.setVisibility(8);
                    this.duk.setVisibility(8);
                    return;
                case 1:
                    this.dul.setVisibility(8);
                    this.duk.setText(bX(iVar.aJS()));
                    this.duk.setTextColor(getResources().getColor(g.a.swan_app_menu_item_tip_text));
                    this.duk.setBackground(getResources().getDrawable(g.c.swan_app_menu_new_bg));
                    this.duk.setVisibility(0);
                    return;
                case 2:
                    this.duk.setVisibility(8);
                    this.dul.setImageDrawable(getResources().getDrawable(g.c.swan_app_menu_new_dot));
                    this.dul.setVisibility(0);
                    return;
                default:
                    this.duk.setVisibility(8);
                    this.dul.setVisibility(8);
                    return;
            }
        }
    }

    private String bX(long j) {
        return j <= 99 ? String.valueOf(j) : "99+";
    }

    private Drawable i(i iVar) {
        return iVar.dw(getContext());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.dum == null || this.dum.aJV() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.cVJ);
                this.cVG = false;
                this.cVE = x;
                this.cVF = y;
                postDelayed(this.cVJ, 3000L);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.cVJ);
                if (!this.cVG && this.dum.aJU() != null) {
                    this.dum.aJU().a(this, this.dum);
                }
                this.cVG = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.cVE - x) > 10 || Math.abs(this.cVF - y) > 10) {
                    removeCallbacks(this.cVJ);
                    this.cVG = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.cVJ);
                this.cVG = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
