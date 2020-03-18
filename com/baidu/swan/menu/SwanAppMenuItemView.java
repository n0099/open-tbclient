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
/* loaded from: classes11.dex */
public class SwanAppMenuItemView extends RelativeLayout {
    private int czA;
    private int czB;
    private boolean czC;
    private Runnable czD;
    private TextView czx;
    private ImageView czy;
    private i czz;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.czC = false;
        this.czD = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.czz != null && SwanAppMenuItemView.this.czz.asW() != null) {
                    SwanAppMenuItemView.this.czC = SwanAppMenuItemView.this.czz.asW().c(SwanAppMenuItemView.this.czz);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.czC = false;
        this.czD = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.czz != null && SwanAppMenuItemView.this.czz.asW() != null) {
                    SwanAppMenuItemView.this.czC = SwanAppMenuItemView.this.czz.asW().c(SwanAppMenuItemView.this.czz);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.czC = false;
        this.czD = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.czz != null && SwanAppMenuItemView.this.czz.asW() != null) {
                    SwanAppMenuItemView.this.czC = SwanAppMenuItemView.this.czz.asW().c(SwanAppMenuItemView.this.czz);
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
        this.czx = (TextView) findViewById(g.d.aiapp_menu_item_new_tips);
        this.czy = (ImageView) findViewById(g.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(i iVar) {
        if (iVar != null) {
            setItemView(iVar);
            this.czz = iVar;
        }
    }

    private void setItemView(i iVar) {
        this.mTitleView.setEllipsize(TextUtils.TruncateAt.END);
        this.mTitleView.setAlpha(iVar.isEnable() ? 1.0f : 0.3f);
        System.out.println(iVar.isEnable());
        this.mIconView.setEnabled(iVar.isEnable());
        this.mIconView.setScaleType(ImageView.ScaleType.CENTER);
        this.mIconView.setVisibility(0);
        h(iVar);
        i(iVar);
    }

    private void h(i iVar) {
        if (iVar != null) {
            setAlpha(1.0f);
            this.mTitleView.setText(iVar.dz(getContext()));
            Drawable j = j(iVar);
            if (j != null) {
                this.mIconView.setImageDrawable(j);
                this.mIconView.setImageLevel(iVar.asU());
            }
            this.mTitleView.setTextColor(getResources().getColor(iVar.getTitleColor()));
        }
    }

    private void i(i iVar) {
        if (iVar != null) {
            switch (iVar.asS()) {
                case 0:
                    this.czx.setVisibility(8);
                    this.czx.setVisibility(8);
                    return;
                case 1:
                    this.czy.setVisibility(8);
                    this.czx.setText(bg(iVar.asT()));
                    this.czx.setTextColor(getResources().getColor(g.a.swan_app_menu_item_tip_text));
                    this.czx.setBackground(getResources().getDrawable(g.c.swan_app_menu_new_bg));
                    this.czx.setVisibility(0);
                    return;
                case 2:
                    this.czx.setVisibility(8);
                    this.czy.setImageDrawable(getResources().getDrawable(g.c.swan_app_menu_new_dot));
                    this.czy.setVisibility(0);
                    return;
                default:
                    this.czx.setVisibility(8);
                    this.czy.setVisibility(8);
                    return;
            }
        }
    }

    private String bg(long j) {
        return j <= 99 ? String.valueOf(j) : "99+";
    }

    private Drawable j(i iVar) {
        return iVar.dA(getContext());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.czz == null || this.czz.asW() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.czD);
                this.czC = false;
                this.czA = x;
                this.czB = y;
                postDelayed(this.czD, 3000L);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.czD);
                if (!this.czC && this.czz.asV() != null) {
                    this.czz.asV().a(this, this.czz);
                }
                this.czC = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.czA - x) > 10 || Math.abs(this.czB - y) > 10) {
                    removeCallbacks(this.czD);
                    this.czC = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.czD);
                this.czC = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
