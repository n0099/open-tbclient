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
/* loaded from: classes23.dex */
public class SwanAppMenuItemView extends RelativeLayout {
    private TextView dGo;
    private ImageView dGp;
    private i dGq;
    private int dgO;
    private int dgP;
    private boolean dgQ;
    private Runnable dgT;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.dgQ = false;
        this.dgT = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.dGq != null && SwanAppMenuItemView.this.dGq.aTv() != null) {
                    SwanAppMenuItemView.this.dgQ = SwanAppMenuItemView.this.dGq.aTv().c(SwanAppMenuItemView.this.dGq);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dgQ = false;
        this.dgT = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.dGq != null && SwanAppMenuItemView.this.dGq.aTv() != null) {
                    SwanAppMenuItemView.this.dgQ = SwanAppMenuItemView.this.dGq.aTv().c(SwanAppMenuItemView.this.dGq);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dgQ = false;
        this.dgT = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.dGq != null && SwanAppMenuItemView.this.dGq.aTv() != null) {
                    SwanAppMenuItemView.this.dgQ = SwanAppMenuItemView.this.dGq.aTv().c(SwanAppMenuItemView.this.dGq);
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
        this.dGo = (TextView) findViewById(g.d.aiapp_menu_item_new_tips);
        this.dGp = (ImageView) findViewById(g.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(i iVar) {
        if (iVar != null) {
            setItemView(iVar);
            this.dGq = iVar;
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
            this.mTitleView.setText(iVar.dA(getContext()));
            Drawable i = i(iVar);
            if (i != null) {
                this.mIconView.setImageDrawable(i);
                this.mIconView.setImageLevel(iVar.aTt());
            }
            this.mTitleView.setTextColor(getResources().getColor(iVar.getTitleColor()));
        }
    }

    private void h(i iVar) {
        if (iVar != null) {
            switch (iVar.aTr()) {
                case 0:
                    this.dGo.setVisibility(8);
                    this.dGo.setVisibility(8);
                    return;
                case 1:
                    this.dGp.setVisibility(8);
                    this.dGo.setText(cf(iVar.aTs()));
                    this.dGo.setTextColor(getResources().getColor(g.a.swan_app_menu_item_tip_text));
                    this.dGo.setBackground(getResources().getDrawable(g.c.swan_app_menu_new_bg));
                    this.dGo.setVisibility(0);
                    return;
                case 2:
                    this.dGo.setVisibility(8);
                    this.dGp.setImageDrawable(getResources().getDrawable(g.c.swan_app_menu_new_dot));
                    this.dGp.setVisibility(0);
                    return;
                default:
                    this.dGo.setVisibility(8);
                    this.dGp.setVisibility(8);
                    return;
            }
        }
    }

    private String cf(long j) {
        return j <= 99 ? String.valueOf(j) : "99+";
    }

    private Drawable i(i iVar) {
        return iVar.dB(getContext());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.dGq == null || this.dGq.aTv() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.dgT);
                this.dgQ = false;
                this.dgO = x;
                this.dgP = y;
                postDelayed(this.dgT, IMConnection.RETRY_DELAY_TIMES);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.dgT);
                if (!this.dgQ && this.dGq.aTu() != null) {
                    this.dGq.aTu().a(this, this.dGq);
                }
                this.dgQ = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.dgO - x) > 10 || Math.abs(this.dgP - y) > 10) {
                    removeCallbacks(this.dgT);
                    this.dgQ = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.dgT);
                this.dgQ = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
