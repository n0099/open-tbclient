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
    private boolean cYA;
    private Runnable cYB;
    private TextView cYv;
    private ImageView cYw;
    private i cYx;
    private int cYy;
    private int cYz;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.cYA = false;
        this.cYB = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.cYx != null && SwanAppMenuItemView.this.cYx.aBg() != null) {
                    SwanAppMenuItemView.this.cYA = SwanAppMenuItemView.this.cYx.aBg().c(SwanAppMenuItemView.this.cYx);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cYA = false;
        this.cYB = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.cYx != null && SwanAppMenuItemView.this.cYx.aBg() != null) {
                    SwanAppMenuItemView.this.cYA = SwanAppMenuItemView.this.cYx.aBg().c(SwanAppMenuItemView.this.cYx);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cYA = false;
        this.cYB = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.cYx != null && SwanAppMenuItemView.this.cYx.aBg() != null) {
                    SwanAppMenuItemView.this.cYA = SwanAppMenuItemView.this.cYx.aBg().c(SwanAppMenuItemView.this.cYx);
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
        this.cYv = (TextView) findViewById(g.d.aiapp_menu_item_new_tips);
        this.cYw = (ImageView) findViewById(g.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(i iVar) {
        if (iVar != null) {
            setItemView(iVar);
            this.cYx = iVar;
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
            this.mTitleView.setText(iVar.dn(getContext()));
            Drawable j = j(iVar);
            if (j != null) {
                this.mIconView.setImageDrawable(j);
                this.mIconView.setImageLevel(iVar.aBe());
            }
            this.mTitleView.setTextColor(getResources().getColor(iVar.getTitleColor()));
        }
    }

    private void i(i iVar) {
        if (iVar != null) {
            switch (iVar.aBc()) {
                case 0:
                    this.cYv.setVisibility(8);
                    this.cYv.setVisibility(8);
                    return;
                case 1:
                    this.cYw.setVisibility(8);
                    this.cYv.setText(bL(iVar.aBd()));
                    this.cYv.setTextColor(getResources().getColor(g.a.swan_app_menu_item_tip_text));
                    this.cYv.setBackground(getResources().getDrawable(g.c.swan_app_menu_new_bg));
                    this.cYv.setVisibility(0);
                    return;
                case 2:
                    this.cYv.setVisibility(8);
                    this.cYw.setImageDrawable(getResources().getDrawable(g.c.swan_app_menu_new_dot));
                    this.cYw.setVisibility(0);
                    return;
                default:
                    this.cYv.setVisibility(8);
                    this.cYw.setVisibility(8);
                    return;
            }
        }
    }

    private String bL(long j) {
        return j <= 99 ? String.valueOf(j) : "99+";
    }

    private Drawable j(i iVar) {
        return iVar.m29do(getContext());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.cYx == null || this.cYx.aBg() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.cYB);
                this.cYA = false;
                this.cYy = x;
                this.cYz = y;
                postDelayed(this.cYB, 3000L);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.cYB);
                if (!this.cYA && this.cYx.aBf() != null) {
                    this.cYx.aBf().a(this, this.cYx);
                }
                this.cYA = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.cYy - x) > 10 || Math.abs(this.cYz - y) > 10) {
                    removeCallbacks(this.cYB);
                    this.cYA = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.cYB);
                this.cYA = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
