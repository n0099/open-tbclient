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
    private TextView dEn;
    private ImageView dEo;
    private i dEp;
    private int deO;
    private int deP;
    private boolean deQ;
    private Runnable deT;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.deQ = false;
        this.deT = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.dEp != null && SwanAppMenuItemView.this.dEp.aSJ() != null) {
                    SwanAppMenuItemView.this.deQ = SwanAppMenuItemView.this.dEp.aSJ().c(SwanAppMenuItemView.this.dEp);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.deQ = false;
        this.deT = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.dEp != null && SwanAppMenuItemView.this.dEp.aSJ() != null) {
                    SwanAppMenuItemView.this.deQ = SwanAppMenuItemView.this.dEp.aSJ().c(SwanAppMenuItemView.this.dEp);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.deQ = false;
        this.deT = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.dEp != null && SwanAppMenuItemView.this.dEp.aSJ() != null) {
                    SwanAppMenuItemView.this.deQ = SwanAppMenuItemView.this.dEp.aSJ().c(SwanAppMenuItemView.this.dEp);
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
        this.dEn = (TextView) findViewById(g.d.aiapp_menu_item_new_tips);
        this.dEo = (ImageView) findViewById(g.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(i iVar) {
        if (iVar != null) {
            setItemView(iVar);
            this.dEp = iVar;
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
                    this.dEn.setVisibility(8);
                    this.dEn.setVisibility(8);
                    return;
                case 1:
                    this.dEo.setVisibility(8);
                    this.dEn.setText(ce(iVar.aSG()));
                    this.dEn.setTextColor(getResources().getColor(g.a.swan_app_menu_item_tip_text));
                    this.dEn.setBackground(getResources().getDrawable(g.c.swan_app_menu_new_bg));
                    this.dEn.setVisibility(0);
                    return;
                case 2:
                    this.dEn.setVisibility(8);
                    this.dEo.setImageDrawable(getResources().getDrawable(g.c.swan_app_menu_new_dot));
                    this.dEo.setVisibility(0);
                    return;
                default:
                    this.dEn.setVisibility(8);
                    this.dEo.setVisibility(8);
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
                if (this.dEp == null || this.dEp.aSJ() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.deT);
                this.deQ = false;
                this.deO = x;
                this.deP = y;
                postDelayed(this.deT, IMConnection.RETRY_DELAY_TIMES);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.deT);
                if (!this.deQ && this.dEp.aSI() != null) {
                    this.dEp.aSI().a(this, this.dEp);
                }
                this.deQ = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.deO - x) > 10 || Math.abs(this.deP - y) > 10) {
                    removeCallbacks(this.deT);
                    this.deQ = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.deT);
                this.deQ = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
