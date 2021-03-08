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
import com.baidu.swan.menu.f;
/* loaded from: classes4.dex */
public class SwanAppMenuItemView extends RelativeLayout {
    private int Yl;
    private int dUr;
    private boolean dUs;
    private Runnable dUv;
    private h euA;
    private TextView euy;
    private ImageView euz;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.dUs = false;
        this.dUv = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.euA != null && SwanAppMenuItemView.this.euA.bbN() != null) {
                    SwanAppMenuItemView.this.dUs = SwanAppMenuItemView.this.euA.bbN().c(SwanAppMenuItemView.this.euA);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dUs = false;
        this.dUv = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.euA != null && SwanAppMenuItemView.this.euA.bbN() != null) {
                    SwanAppMenuItemView.this.dUs = SwanAppMenuItemView.this.euA.bbN().c(SwanAppMenuItemView.this.euA);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dUs = false;
        this.dUv = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.euA != null && SwanAppMenuItemView.this.euA.bbN() != null) {
                    SwanAppMenuItemView.this.dUs = SwanAppMenuItemView.this.euA.bbN().c(SwanAppMenuItemView.this.euA);
                }
            }
        };
        init();
    }

    private void init() {
        setGravity(49);
        LayoutInflater.from(getContext()).inflate(f.e.aiapp_menu_item_view_layout, this);
        this.mIconView = (ImageView) findViewById(f.d.aiapp_menu_item_icon);
        this.mTitleView = (TextView) findViewById(f.d.aiapp_menu_item_title);
        this.euy = (TextView) findViewById(f.d.aiapp_menu_item_new_tips);
        this.euz = (ImageView) findViewById(f.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(h hVar) {
        if (hVar != null) {
            setItemView(hVar);
            this.euA = hVar;
        }
    }

    private void setItemView(h hVar) {
        this.mTitleView.setEllipsize(TextUtils.TruncateAt.END);
        this.mTitleView.setAlpha(hVar.isEnable() ? 1.0f : 0.3f);
        System.out.println(hVar.isEnable());
        this.mIconView.setEnabled(hVar.isEnable());
        this.mIconView.setScaleType(ImageView.ScaleType.CENTER);
        this.mIconView.setVisibility(0);
        g(hVar);
        h(hVar);
    }

    private void g(h hVar) {
        if (hVar != null) {
            setAlpha(1.0f);
            this.mTitleView.setText(hVar.eC(getContext()));
            Drawable i = i(hVar);
            if (i != null) {
                this.mIconView.setImageDrawable(i);
                this.mIconView.setImageLevel(hVar.bbL());
            }
            this.mTitleView.setTextColor(getResources().getColor(hVar.getTitleColor()));
        }
    }

    private void h(h hVar) {
        if (hVar != null) {
            switch (hVar.bbJ()) {
                case 0:
                    this.euy.setVisibility(8);
                    this.euy.setVisibility(8);
                    return;
                case 1:
                    this.euz.setVisibility(8);
                    this.euy.setText(dr(hVar.bbK()));
                    this.euy.setTextColor(getResources().getColor(f.a.swan_app_menu_item_tip_text));
                    this.euy.setBackground(getResources().getDrawable(f.c.swan_app_menu_new_bg));
                    this.euy.setVisibility(0);
                    return;
                case 2:
                    this.euy.setVisibility(8);
                    this.euz.setImageDrawable(getResources().getDrawable(f.c.swan_app_menu_new_dot));
                    this.euz.setVisibility(0);
                    return;
                default:
                    this.euy.setVisibility(8);
                    this.euz.setVisibility(8);
                    return;
            }
        }
    }

    private String dr(long j) {
        return j <= 99 ? String.valueOf(j) : "99+";
    }

    private Drawable i(h hVar) {
        return hVar.eD(getContext());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.euA == null || this.euA.bbN() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.dUv);
                this.dUs = false;
                this.dUr = x;
                this.Yl = y;
                postDelayed(this.dUv, IMConnection.RETRY_DELAY_TIMES);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.dUv);
                if (!this.dUs && this.euA.bbM() != null) {
                    this.euA.bbM().a(this, this.euA);
                }
                this.dUs = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.dUr - x) > 10 || Math.abs(this.Yl - y) > 10) {
                    removeCallbacks(this.dUv);
                    this.dUs = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.dUv);
                this.dUs = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
