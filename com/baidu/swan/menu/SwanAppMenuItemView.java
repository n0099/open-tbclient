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
/* loaded from: classes10.dex */
public class SwanAppMenuItemView extends RelativeLayout {
    private TextView cvm;
    private ImageView cvn;
    private i cvo;
    private int cvp;
    private int cvq;
    private boolean cvr;
    private Runnable cvs;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.cvr = false;
        this.cvs = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.cvo != null && SwanAppMenuItemView.this.cvo.aqD() != null) {
                    SwanAppMenuItemView.this.cvr = SwanAppMenuItemView.this.cvo.aqD().c(SwanAppMenuItemView.this.cvo);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvr = false;
        this.cvs = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.cvo != null && SwanAppMenuItemView.this.cvo.aqD() != null) {
                    SwanAppMenuItemView.this.cvr = SwanAppMenuItemView.this.cvo.aqD().c(SwanAppMenuItemView.this.cvo);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cvr = false;
        this.cvs = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.cvo != null && SwanAppMenuItemView.this.cvo.aqD() != null) {
                    SwanAppMenuItemView.this.cvr = SwanAppMenuItemView.this.cvo.aqD().c(SwanAppMenuItemView.this.cvo);
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
        this.cvm = (TextView) findViewById(g.d.aiapp_menu_item_new_tips);
        this.cvn = (ImageView) findViewById(g.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(i iVar) {
        if (iVar != null) {
            setItemView(iVar);
            this.cvo = iVar;
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
            this.mTitleView.setText(iVar.dw(getContext()));
            Drawable j = j(iVar);
            if (j != null) {
                this.mIconView.setImageDrawable(j);
                this.mIconView.setImageLevel(iVar.aqB());
            }
            this.mTitleView.setTextColor(getResources().getColor(iVar.getTitleColor()));
        }
    }

    private void i(i iVar) {
        if (iVar != null) {
            switch (iVar.aqz()) {
                case 0:
                    this.cvm.setVisibility(8);
                    this.cvm.setVisibility(8);
                    return;
                case 1:
                    this.cvn.setVisibility(8);
                    this.cvm.setText(bc(iVar.aqA()));
                    this.cvm.setTextColor(getResources().getColor(g.a.swan_app_menu_item_tip_text));
                    this.cvm.setBackground(getResources().getDrawable(g.c.swan_app_menu_new_bg));
                    this.cvm.setVisibility(0);
                    return;
                case 2:
                    this.cvm.setVisibility(8);
                    this.cvn.setImageDrawable(getResources().getDrawable(g.c.swan_app_menu_new_dot));
                    this.cvn.setVisibility(0);
                    return;
                default:
                    this.cvm.setVisibility(8);
                    this.cvn.setVisibility(8);
                    return;
            }
        }
    }

    private String bc(long j) {
        return j <= 99 ? String.valueOf(j) : "99+";
    }

    private Drawable j(i iVar) {
        return iVar.dx(getContext());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.cvo == null || this.cvo.aqD() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.cvs);
                this.cvr = false;
                this.cvp = x;
                this.cvq = y;
                postDelayed(this.cvs, 3000L);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.cvs);
                if (!this.cvr && this.cvo.aqC() != null) {
                    this.cvo.aqC().a(this, this.cvo);
                }
                this.cvr = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.cvp - x) > 10 || Math.abs(this.cvq - y) > 10) {
                    removeCallbacks(this.cvs);
                    this.cvr = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.cvs);
                this.cvr = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
