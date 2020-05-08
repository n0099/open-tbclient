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
    private TextView cYA;
    private ImageView cYB;
    private i cYC;
    private int cYD;
    private int cYE;
    private boolean cYF;
    private Runnable cYG;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.cYF = false;
        this.cYG = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.cYC != null && SwanAppMenuItemView.this.cYC.aBg() != null) {
                    SwanAppMenuItemView.this.cYF = SwanAppMenuItemView.this.cYC.aBg().c(SwanAppMenuItemView.this.cYC);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cYF = false;
        this.cYG = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.cYC != null && SwanAppMenuItemView.this.cYC.aBg() != null) {
                    SwanAppMenuItemView.this.cYF = SwanAppMenuItemView.this.cYC.aBg().c(SwanAppMenuItemView.this.cYC);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cYF = false;
        this.cYG = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.cYC != null && SwanAppMenuItemView.this.cYC.aBg() != null) {
                    SwanAppMenuItemView.this.cYF = SwanAppMenuItemView.this.cYC.aBg().c(SwanAppMenuItemView.this.cYC);
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
        this.cYA = (TextView) findViewById(g.d.aiapp_menu_item_new_tips);
        this.cYB = (ImageView) findViewById(g.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(i iVar) {
        if (iVar != null) {
            setItemView(iVar);
            this.cYC = iVar;
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
            this.mTitleView.setText(iVar.db(getContext()));
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
                    this.cYA.setVisibility(8);
                    this.cYA.setVisibility(8);
                    return;
                case 1:
                    this.cYB.setVisibility(8);
                    this.cYA.setText(bL(iVar.aBd()));
                    this.cYA.setTextColor(getResources().getColor(g.a.swan_app_menu_item_tip_text));
                    this.cYA.setBackground(getResources().getDrawable(g.c.swan_app_menu_new_bg));
                    this.cYA.setVisibility(0);
                    return;
                case 2:
                    this.cYA.setVisibility(8);
                    this.cYB.setImageDrawable(getResources().getDrawable(g.c.swan_app_menu_new_dot));
                    this.cYB.setVisibility(0);
                    return;
                default:
                    this.cYA.setVisibility(8);
                    this.cYB.setVisibility(8);
                    return;
            }
        }
    }

    private String bL(long j) {
        return j <= 99 ? String.valueOf(j) : "99+";
    }

    private Drawable j(i iVar) {
        return iVar.dc(getContext());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.cYC == null || this.cYC.aBg() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.cYG);
                this.cYF = false;
                this.cYD = x;
                this.cYE = y;
                postDelayed(this.cYG, 3000L);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.cYG);
                if (!this.cYF && this.cYC.aBf() != null) {
                    this.cYC.aBf().a(this, this.cYC);
                }
                this.cYF = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.cYD - x) > 10 || Math.abs(this.cYE - y) > 10) {
                    removeCallbacks(this.cYG);
                    this.cYF = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.cYG);
                this.cYF = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
