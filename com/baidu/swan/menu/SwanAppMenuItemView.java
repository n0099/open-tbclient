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
    private int dHm;
    private int dHn;
    private boolean dHo;
    private Runnable dHr;
    private TextView egD;
    private ImageView egE;
    private i egF;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.dHo = false;
        this.dHr = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.egF != null && SwanAppMenuItemView.this.egF.bax() != null) {
                    SwanAppMenuItemView.this.dHo = SwanAppMenuItemView.this.egF.bax().c(SwanAppMenuItemView.this.egF);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dHo = false;
        this.dHr = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.egF != null && SwanAppMenuItemView.this.egF.bax() != null) {
                    SwanAppMenuItemView.this.dHo = SwanAppMenuItemView.this.egF.bax().c(SwanAppMenuItemView.this.egF);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dHo = false;
        this.dHr = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.egF != null && SwanAppMenuItemView.this.egF.bax() != null) {
                    SwanAppMenuItemView.this.dHo = SwanAppMenuItemView.this.egF.bax().c(SwanAppMenuItemView.this.egF);
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
        this.egD = (TextView) findViewById(g.d.aiapp_menu_item_new_tips);
        this.egE = (ImageView) findViewById(g.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(i iVar) {
        if (iVar != null) {
            setItemView(iVar);
            this.egF = iVar;
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
                this.mIconView.setImageLevel(iVar.bav());
            }
            this.mTitleView.setTextColor(getResources().getColor(iVar.getTitleColor()));
        }
    }

    private void h(i iVar) {
        if (iVar != null) {
            switch (iVar.bat()) {
                case 0:
                    this.egD.setVisibility(8);
                    this.egD.setVisibility(8);
                    return;
                case 1:
                    this.egE.setVisibility(8);
                    this.egD.setText(cL(iVar.bau()));
                    this.egD.setTextColor(getResources().getColor(g.a.swan_app_menu_item_tip_text));
                    this.egD.setBackground(getResources().getDrawable(g.c.swan_app_menu_new_bg));
                    this.egD.setVisibility(0);
                    return;
                case 2:
                    this.egD.setVisibility(8);
                    this.egE.setImageDrawable(getResources().getDrawable(g.c.swan_app_menu_new_dot));
                    this.egE.setVisibility(0);
                    return;
                default:
                    this.egD.setVisibility(8);
                    this.egE.setVisibility(8);
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
                if (this.egF == null || this.egF.bax() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.dHr);
                this.dHo = false;
                this.dHm = x;
                this.dHn = y;
                postDelayed(this.dHr, IMConnection.RETRY_DELAY_TIMES);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.dHr);
                if (!this.dHo && this.egF.baw() != null) {
                    this.egF.baw().a(this, this.egF);
                }
                this.dHo = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.dHm - x) > 10 || Math.abs(this.dHn - y) > 10) {
                    removeCallbacks(this.dHr);
                    this.dHo = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.dHr);
                this.dHo = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
