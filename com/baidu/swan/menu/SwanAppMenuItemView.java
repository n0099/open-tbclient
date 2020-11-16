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
/* loaded from: classes5.dex */
public class SwanAppMenuItemView extends RelativeLayout {
    private int Wc;
    private int dFF;
    private boolean dFG;
    private Runnable dFJ;
    private TextView eeV;
    private ImageView eeW;
    private i eeX;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.dFG = false;
        this.dFJ = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.eeX != null && SwanAppMenuItemView.this.eeX.aZQ() != null) {
                    SwanAppMenuItemView.this.dFG = SwanAppMenuItemView.this.eeX.aZQ().c(SwanAppMenuItemView.this.eeX);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dFG = false;
        this.dFJ = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.eeX != null && SwanAppMenuItemView.this.eeX.aZQ() != null) {
                    SwanAppMenuItemView.this.dFG = SwanAppMenuItemView.this.eeX.aZQ().c(SwanAppMenuItemView.this.eeX);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dFG = false;
        this.dFJ = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.eeX != null && SwanAppMenuItemView.this.eeX.aZQ() != null) {
                    SwanAppMenuItemView.this.dFG = SwanAppMenuItemView.this.eeX.aZQ().c(SwanAppMenuItemView.this.eeX);
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
        this.eeV = (TextView) findViewById(g.d.aiapp_menu_item_new_tips);
        this.eeW = (ImageView) findViewById(g.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(i iVar) {
        if (iVar != null) {
            setItemView(iVar);
            this.eeX = iVar;
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
                this.mIconView.setImageLevel(iVar.aZO());
            }
            this.mTitleView.setTextColor(getResources().getColor(iVar.getTitleColor()));
        }
    }

    private void h(i iVar) {
        if (iVar != null) {
            switch (iVar.aZM()) {
                case 0:
                    this.eeV.setVisibility(8);
                    this.eeV.setVisibility(8);
                    return;
                case 1:
                    this.eeW.setVisibility(8);
                    this.eeV.setText(cL(iVar.aZN()));
                    this.eeV.setTextColor(getResources().getColor(g.a.swan_app_menu_item_tip_text));
                    this.eeV.setBackground(getResources().getDrawable(g.c.swan_app_menu_new_bg));
                    this.eeV.setVisibility(0);
                    return;
                case 2:
                    this.eeV.setVisibility(8);
                    this.eeW.setImageDrawable(getResources().getDrawable(g.c.swan_app_menu_new_dot));
                    this.eeW.setVisibility(0);
                    return;
                default:
                    this.eeV.setVisibility(8);
                    this.eeW.setVisibility(8);
                    return;
            }
        }
    }

    private String cL(long j) {
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
                if (this.eeX == null || this.eeX.aZQ() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.dFJ);
                this.dFG = false;
                this.dFF = x;
                this.Wc = y;
                postDelayed(this.dFJ, IMConnection.RETRY_DELAY_TIMES);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.dFJ);
                if (!this.dFG && this.eeX.aZP() != null) {
                    this.eeX.aZP().a(this, this.eeX);
                }
                this.dFG = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.dFF - x) > 10 || Math.abs(this.Wc - y) > 10) {
                    removeCallbacks(this.dFJ);
                    this.dFG = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.dFJ);
                this.dFG = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
