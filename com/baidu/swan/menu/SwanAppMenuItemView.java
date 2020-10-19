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
    private TextView dSp;
    private ImageView dSq;
    private i dSr;
    private int dsW;
    private int dsX;
    private boolean dsY;
    private Runnable dtb;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.dsY = false;
        this.dtb = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.dSr != null && SwanAppMenuItemView.this.dSr.aWe() != null) {
                    SwanAppMenuItemView.this.dsY = SwanAppMenuItemView.this.dSr.aWe().c(SwanAppMenuItemView.this.dSr);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dsY = false;
        this.dtb = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.dSr != null && SwanAppMenuItemView.this.dSr.aWe() != null) {
                    SwanAppMenuItemView.this.dsY = SwanAppMenuItemView.this.dSr.aWe().c(SwanAppMenuItemView.this.dSr);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dsY = false;
        this.dtb = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.dSr != null && SwanAppMenuItemView.this.dSr.aWe() != null) {
                    SwanAppMenuItemView.this.dsY = SwanAppMenuItemView.this.dSr.aWe().c(SwanAppMenuItemView.this.dSr);
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
        this.dSp = (TextView) findViewById(g.d.aiapp_menu_item_new_tips);
        this.dSq = (ImageView) findViewById(g.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(i iVar) {
        if (iVar != null) {
            setItemView(iVar);
            this.dSr = iVar;
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
                this.mIconView.setImageLevel(iVar.aWc());
            }
            this.mTitleView.setTextColor(getResources().getColor(iVar.getTitleColor()));
        }
    }

    private void h(i iVar) {
        if (iVar != null) {
            switch (iVar.aWa()) {
                case 0:
                    this.dSp.setVisibility(8);
                    this.dSp.setVisibility(8);
                    return;
                case 1:
                    this.dSq.setVisibility(8);
                    this.dSp.setText(cn(iVar.aWb()));
                    this.dSp.setTextColor(getResources().getColor(g.a.swan_app_menu_item_tip_text));
                    this.dSp.setBackground(getResources().getDrawable(g.c.swan_app_menu_new_bg));
                    this.dSp.setVisibility(0);
                    return;
                case 2:
                    this.dSp.setVisibility(8);
                    this.dSq.setImageDrawable(getResources().getDrawable(g.c.swan_app_menu_new_dot));
                    this.dSq.setVisibility(0);
                    return;
                default:
                    this.dSp.setVisibility(8);
                    this.dSq.setVisibility(8);
                    return;
            }
        }
    }

    private String cn(long j) {
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
                if (this.dSr == null || this.dSr.aWe() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.dtb);
                this.dsY = false;
                this.dsW = x;
                this.dsX = y;
                postDelayed(this.dtb, IMConnection.RETRY_DELAY_TIMES);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.dtb);
                if (!this.dsY && this.dSr.aWd() != null) {
                    this.dSr.aWd().a(this, this.dSr);
                }
                this.dsY = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.dsW - x) > 10 || Math.abs(this.dsX - y) > 10) {
                    removeCallbacks(this.dtb);
                    this.dsY = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.dtb);
                this.dsY = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
