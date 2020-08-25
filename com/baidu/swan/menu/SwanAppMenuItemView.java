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
    private TextView dEj;
    private ImageView dEk;
    private i dEl;
    private int deK;
    private int deL;
    private boolean deM;
    private Runnable deP;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.deM = false;
        this.deP = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.dEl != null && SwanAppMenuItemView.this.dEl.aSJ() != null) {
                    SwanAppMenuItemView.this.deM = SwanAppMenuItemView.this.dEl.aSJ().c(SwanAppMenuItemView.this.dEl);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.deM = false;
        this.deP = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.dEl != null && SwanAppMenuItemView.this.dEl.aSJ() != null) {
                    SwanAppMenuItemView.this.deM = SwanAppMenuItemView.this.dEl.aSJ().c(SwanAppMenuItemView.this.dEl);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.deM = false;
        this.deP = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.dEl != null && SwanAppMenuItemView.this.dEl.aSJ() != null) {
                    SwanAppMenuItemView.this.deM = SwanAppMenuItemView.this.dEl.aSJ().c(SwanAppMenuItemView.this.dEl);
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
        this.dEj = (TextView) findViewById(g.d.aiapp_menu_item_new_tips);
        this.dEk = (ImageView) findViewById(g.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(i iVar) {
        if (iVar != null) {
            setItemView(iVar);
            this.dEl = iVar;
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
            this.mTitleView.setText(iVar.dB(getContext()));
            Drawable i = i(iVar);
            if (i != null) {
                this.mIconView.setImageDrawable(i);
                this.mIconView.setImageLevel(iVar.aSH());
            }
            this.mTitleView.setTextColor(getResources().getColor(iVar.getTitleColor()));
        }
    }

    private void h(i iVar) {
        if (iVar != null) {
            switch (iVar.aSF()) {
                case 0:
                    this.dEj.setVisibility(8);
                    this.dEj.setVisibility(8);
                    return;
                case 1:
                    this.dEk.setVisibility(8);
                    this.dEj.setText(ce(iVar.aSG()));
                    this.dEj.setTextColor(getResources().getColor(g.a.swan_app_menu_item_tip_text));
                    this.dEj.setBackground(getResources().getDrawable(g.c.swan_app_menu_new_bg));
                    this.dEj.setVisibility(0);
                    return;
                case 2:
                    this.dEj.setVisibility(8);
                    this.dEk.setImageDrawable(getResources().getDrawable(g.c.swan_app_menu_new_dot));
                    this.dEk.setVisibility(0);
                    return;
                default:
                    this.dEj.setVisibility(8);
                    this.dEk.setVisibility(8);
                    return;
            }
        }
    }

    private String ce(long j) {
        return j <= 99 ? String.valueOf(j) : "99+";
    }

    private Drawable i(i iVar) {
        return iVar.dC(getContext());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.dEl == null || this.dEl.aSJ() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.deP);
                this.deM = false;
                this.deK = x;
                this.deL = y;
                postDelayed(this.deP, IMConnection.RETRY_DELAY_TIMES);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.deP);
                if (!this.deM && this.dEl.aSI() != null) {
                    this.dEl.aSI().a(this, this.dEl);
                }
                this.deM = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.deK - x) > 10 || Math.abs(this.deL - y) > 10) {
                    removeCallbacks(this.deP);
                    this.deM = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.deP);
                this.deM = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
