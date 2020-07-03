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
    private TextView dop;
    private ImageView doq;
    private i dor;
    private int dos;
    private int dot;
    private boolean dou;
    private Runnable dov;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.dou = false;
        this.dov = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.dor != null && SwanAppMenuItemView.this.dor.aGe() != null) {
                    SwanAppMenuItemView.this.dou = SwanAppMenuItemView.this.dor.aGe().d(SwanAppMenuItemView.this.dor);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dou = false;
        this.dov = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.dor != null && SwanAppMenuItemView.this.dor.aGe() != null) {
                    SwanAppMenuItemView.this.dou = SwanAppMenuItemView.this.dor.aGe().d(SwanAppMenuItemView.this.dor);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dou = false;
        this.dov = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.dor != null && SwanAppMenuItemView.this.dor.aGe() != null) {
                    SwanAppMenuItemView.this.dou = SwanAppMenuItemView.this.dor.aGe().d(SwanAppMenuItemView.this.dor);
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
        this.dop = (TextView) findViewById(g.d.aiapp_menu_item_new_tips);
        this.doq = (ImageView) findViewById(g.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(i iVar) {
        if (iVar != null) {
            setItemView(iVar);
            this.dor = iVar;
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
            this.mTitleView.setText(iVar.dr(getContext()));
            Drawable j = j(iVar);
            if (j != null) {
                this.mIconView.setImageDrawable(j);
                this.mIconView.setImageLevel(iVar.aGc());
            }
            this.mTitleView.setTextColor(getResources().getColor(iVar.getTitleColor()));
        }
    }

    private void i(i iVar) {
        if (iVar != null) {
            switch (iVar.aGa()) {
                case 0:
                    this.dop.setVisibility(8);
                    this.dop.setVisibility(8);
                    return;
                case 1:
                    this.doq.setVisibility(8);
                    this.dop.setText(bJ(iVar.aGb()));
                    this.dop.setTextColor(getResources().getColor(g.a.swan_app_menu_item_tip_text));
                    this.dop.setBackground(getResources().getDrawable(g.c.swan_app_menu_new_bg));
                    this.dop.setVisibility(0);
                    return;
                case 2:
                    this.dop.setVisibility(8);
                    this.doq.setImageDrawable(getResources().getDrawable(g.c.swan_app_menu_new_dot));
                    this.doq.setVisibility(0);
                    return;
                default:
                    this.dop.setVisibility(8);
                    this.doq.setVisibility(8);
                    return;
            }
        }
    }

    private String bJ(long j) {
        return j <= 99 ? String.valueOf(j) : "99+";
    }

    private Drawable j(i iVar) {
        return iVar.ds(getContext());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.dor == null || this.dor.aGe() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.dov);
                this.dou = false;
                this.dos = x;
                this.dot = y;
                postDelayed(this.dov, 3000L);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.dov);
                if (!this.dou && this.dor.aGd() != null) {
                    this.dor.aGd().a(this, this.dor);
                }
                this.dou = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.dos - x) > 10 || Math.abs(this.dot - y) > 10) {
                    removeCallbacks(this.dov);
                    this.dou = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.dov);
                this.dou = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
