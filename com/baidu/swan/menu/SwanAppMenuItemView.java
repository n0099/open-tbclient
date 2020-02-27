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
    private TextView czk;
    private ImageView czl;
    private i czm;
    private int czn;
    private int czo;
    private boolean czp;
    private Runnable czq;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.czp = false;
        this.czq = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.czm != null && SwanAppMenuItemView.this.czm.asR() != null) {
                    SwanAppMenuItemView.this.czp = SwanAppMenuItemView.this.czm.asR().c(SwanAppMenuItemView.this.czm);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.czp = false;
        this.czq = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.czm != null && SwanAppMenuItemView.this.czm.asR() != null) {
                    SwanAppMenuItemView.this.czp = SwanAppMenuItemView.this.czm.asR().c(SwanAppMenuItemView.this.czm);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.czp = false;
        this.czq = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.czm != null && SwanAppMenuItemView.this.czm.asR() != null) {
                    SwanAppMenuItemView.this.czp = SwanAppMenuItemView.this.czm.asR().c(SwanAppMenuItemView.this.czm);
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
        this.czk = (TextView) findViewById(g.d.aiapp_menu_item_new_tips);
        this.czl = (ImageView) findViewById(g.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(i iVar) {
        if (iVar != null) {
            setItemView(iVar);
            this.czm = iVar;
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
            this.mTitleView.setText(iVar.dA(getContext()));
            Drawable j = j(iVar);
            if (j != null) {
                this.mIconView.setImageDrawable(j);
                this.mIconView.setImageLevel(iVar.asP());
            }
            this.mTitleView.setTextColor(getResources().getColor(iVar.getTitleColor()));
        }
    }

    private void i(i iVar) {
        if (iVar != null) {
            switch (iVar.asN()) {
                case 0:
                    this.czk.setVisibility(8);
                    this.czk.setVisibility(8);
                    return;
                case 1:
                    this.czl.setVisibility(8);
                    this.czk.setText(bg(iVar.asO()));
                    this.czk.setTextColor(getResources().getColor(g.a.swan_app_menu_item_tip_text));
                    this.czk.setBackground(getResources().getDrawable(g.c.swan_app_menu_new_bg));
                    this.czk.setVisibility(0);
                    return;
                case 2:
                    this.czk.setVisibility(8);
                    this.czl.setImageDrawable(getResources().getDrawable(g.c.swan_app_menu_new_dot));
                    this.czl.setVisibility(0);
                    return;
                default:
                    this.czk.setVisibility(8);
                    this.czl.setVisibility(8);
                    return;
            }
        }
    }

    private String bg(long j) {
        return j <= 99 ? String.valueOf(j) : "99+";
    }

    private Drawable j(i iVar) {
        return iVar.dB(getContext());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.czm == null || this.czm.asR() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.czq);
                this.czp = false;
                this.czn = x;
                this.czo = y;
                postDelayed(this.czq, 3000L);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.czq);
                if (!this.czp && this.czm.asQ() != null) {
                    this.czm.asQ().a(this, this.czm);
                }
                this.czp = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.czn - x) > 10 || Math.abs(this.czo - y) > 10) {
                    removeCallbacks(this.czq);
                    this.czp = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.czq);
                this.czp = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
