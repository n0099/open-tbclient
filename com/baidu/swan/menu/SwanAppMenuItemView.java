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
    private TextView djE;
    private ImageView djF;
    private i djG;
    private int djH;
    private int djI;
    private boolean djJ;
    private Runnable djK;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.djJ = false;
        this.djK = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.djG != null && SwanAppMenuItemView.this.djG.aEY() != null) {
                    SwanAppMenuItemView.this.djJ = SwanAppMenuItemView.this.djG.aEY().d(SwanAppMenuItemView.this.djG);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.djJ = false;
        this.djK = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.djG != null && SwanAppMenuItemView.this.djG.aEY() != null) {
                    SwanAppMenuItemView.this.djJ = SwanAppMenuItemView.this.djG.aEY().d(SwanAppMenuItemView.this.djG);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.djJ = false;
        this.djK = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.djG != null && SwanAppMenuItemView.this.djG.aEY() != null) {
                    SwanAppMenuItemView.this.djJ = SwanAppMenuItemView.this.djG.aEY().d(SwanAppMenuItemView.this.djG);
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
        this.djE = (TextView) findViewById(g.d.aiapp_menu_item_new_tips);
        this.djF = (ImageView) findViewById(g.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(i iVar) {
        if (iVar != null) {
            setItemView(iVar);
            this.djG = iVar;
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
            this.mTitleView.setText(iVar.dq(getContext()));
            Drawable j = j(iVar);
            if (j != null) {
                this.mIconView.setImageDrawable(j);
                this.mIconView.setImageLevel(iVar.aEW());
            }
            this.mTitleView.setTextColor(getResources().getColor(iVar.getTitleColor()));
        }
    }

    private void i(i iVar) {
        if (iVar != null) {
            switch (iVar.aEU()) {
                case 0:
                    this.djE.setVisibility(8);
                    this.djE.setVisibility(8);
                    return;
                case 1:
                    this.djF.setVisibility(8);
                    this.djE.setText(bJ(iVar.aEV()));
                    this.djE.setTextColor(getResources().getColor(g.a.swan_app_menu_item_tip_text));
                    this.djE.setBackground(getResources().getDrawable(g.c.swan_app_menu_new_bg));
                    this.djE.setVisibility(0);
                    return;
                case 2:
                    this.djE.setVisibility(8);
                    this.djF.setImageDrawable(getResources().getDrawable(g.c.swan_app_menu_new_dot));
                    this.djF.setVisibility(0);
                    return;
                default:
                    this.djE.setVisibility(8);
                    this.djF.setVisibility(8);
                    return;
            }
        }
    }

    private String bJ(long j) {
        return j <= 99 ? String.valueOf(j) : "99+";
    }

    private Drawable j(i iVar) {
        return iVar.dr(getContext());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.djG == null || this.djG.aEY() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.djK);
                this.djJ = false;
                this.djH = x;
                this.djI = y;
                postDelayed(this.djK, 3000L);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.djK);
                if (!this.djJ && this.djG.aEX() != null) {
                    this.djG.aEX().a(this, this.djG);
                }
                this.djJ = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.djH - x) > 10 || Math.abs(this.djI - y) > 10) {
                    removeCallbacks(this.djK);
                    this.djJ = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.djK);
                this.djJ = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
