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
    private TextView czm;
    private ImageView czn;
    private i czo;
    private int czp;
    private int czq;
    private boolean czr;
    private Runnable czs;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.czr = false;
        this.czs = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.czo != null && SwanAppMenuItemView.this.czo.asT() != null) {
                    SwanAppMenuItemView.this.czr = SwanAppMenuItemView.this.czo.asT().c(SwanAppMenuItemView.this.czo);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.czr = false;
        this.czs = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.czo != null && SwanAppMenuItemView.this.czo.asT() != null) {
                    SwanAppMenuItemView.this.czr = SwanAppMenuItemView.this.czo.asT().c(SwanAppMenuItemView.this.czo);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.czr = false;
        this.czs = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.czo != null && SwanAppMenuItemView.this.czo.asT() != null) {
                    SwanAppMenuItemView.this.czr = SwanAppMenuItemView.this.czo.asT().c(SwanAppMenuItemView.this.czo);
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
        this.czm = (TextView) findViewById(g.d.aiapp_menu_item_new_tips);
        this.czn = (ImageView) findViewById(g.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(i iVar) {
        if (iVar != null) {
            setItemView(iVar);
            this.czo = iVar;
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
                this.mIconView.setImageLevel(iVar.asR());
            }
            this.mTitleView.setTextColor(getResources().getColor(iVar.getTitleColor()));
        }
    }

    private void i(i iVar) {
        if (iVar != null) {
            switch (iVar.asP()) {
                case 0:
                    this.czm.setVisibility(8);
                    this.czm.setVisibility(8);
                    return;
                case 1:
                    this.czn.setVisibility(8);
                    this.czm.setText(bg(iVar.asQ()));
                    this.czm.setTextColor(getResources().getColor(g.a.swan_app_menu_item_tip_text));
                    this.czm.setBackground(getResources().getDrawable(g.c.swan_app_menu_new_bg));
                    this.czm.setVisibility(0);
                    return;
                case 2:
                    this.czm.setVisibility(8);
                    this.czn.setImageDrawable(getResources().getDrawable(g.c.swan_app_menu_new_dot));
                    this.czn.setVisibility(0);
                    return;
                default:
                    this.czm.setVisibility(8);
                    this.czn.setVisibility(8);
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
                if (this.czo == null || this.czo.asT() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.czs);
                this.czr = false;
                this.czp = x;
                this.czq = y;
                postDelayed(this.czs, 3000L);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.czs);
                if (!this.czr && this.czo.asS() != null) {
                    this.czo.asS().a(this, this.czo);
                }
                this.czr = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.czp - x) > 10 || Math.abs(this.czq - y) > 10) {
                    removeCallbacks(this.czs);
                    this.czr = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.czs);
                this.czr = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
