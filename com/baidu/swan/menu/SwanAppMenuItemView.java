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
    private TextView cvb;
    private ImageView cvc;
    private i cvd;
    private int cve;
    private int cvf;
    private boolean cvg;
    private Runnable cvh;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.cvg = false;
        this.cvh = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.cvd != null && SwanAppMenuItemView.this.cvd.aqk() != null) {
                    SwanAppMenuItemView.this.cvg = SwanAppMenuItemView.this.cvd.aqk().c(SwanAppMenuItemView.this.cvd);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvg = false;
        this.cvh = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.cvd != null && SwanAppMenuItemView.this.cvd.aqk() != null) {
                    SwanAppMenuItemView.this.cvg = SwanAppMenuItemView.this.cvd.aqk().c(SwanAppMenuItemView.this.cvd);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cvg = false;
        this.cvh = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.cvd != null && SwanAppMenuItemView.this.cvd.aqk() != null) {
                    SwanAppMenuItemView.this.cvg = SwanAppMenuItemView.this.cvd.aqk().c(SwanAppMenuItemView.this.cvd);
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
        this.cvb = (TextView) findViewById(g.d.aiapp_menu_item_new_tips);
        this.cvc = (ImageView) findViewById(g.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(i iVar) {
        if (iVar != null) {
            setItemView(iVar);
            this.cvd = iVar;
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
            this.mTitleView.setText(iVar.dw(getContext()));
            Drawable j = j(iVar);
            if (j != null) {
                this.mIconView.setImageDrawable(j);
                this.mIconView.setImageLevel(iVar.aqi());
            }
            this.mTitleView.setTextColor(getResources().getColor(iVar.getTitleColor()));
        }
    }

    private void i(i iVar) {
        if (iVar != null) {
            switch (iVar.aqg()) {
                case 0:
                    this.cvb.setVisibility(8);
                    this.cvb.setVisibility(8);
                    return;
                case 1:
                    this.cvc.setVisibility(8);
                    this.cvb.setText(aZ(iVar.aqh()));
                    this.cvb.setTextColor(getResources().getColor(g.a.swan_app_menu_item_tip_text));
                    this.cvb.setBackground(getResources().getDrawable(g.c.swan_app_menu_new_bg));
                    this.cvb.setVisibility(0);
                    return;
                case 2:
                    this.cvb.setVisibility(8);
                    this.cvc.setImageDrawable(getResources().getDrawable(g.c.swan_app_menu_new_dot));
                    this.cvc.setVisibility(0);
                    return;
                default:
                    this.cvb.setVisibility(8);
                    this.cvc.setVisibility(8);
                    return;
            }
        }
    }

    private String aZ(long j) {
        return j <= 99 ? String.valueOf(j) : "99+";
    }

    private Drawable j(i iVar) {
        return iVar.dx(getContext());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.cvd == null || this.cvd.aqk() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.cvh);
                this.cvg = false;
                this.cve = x;
                this.cvf = y;
                postDelayed(this.cvh, 3000L);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.cvh);
                if (!this.cvg && this.cvd.aqj() != null) {
                    this.cvd.aqj().a(this, this.cvd);
                }
                this.cvg = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.cve - x) > 10 || Math.abs(this.cvf - y) > 10) {
                    removeCallbacks(this.cvh);
                    this.cvg = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.cvh);
                this.cvg = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
