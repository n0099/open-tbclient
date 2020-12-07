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
    private int WZ;
    private int dMD;
    private boolean dME;
    private Runnable dMH;
    private TextView elW;
    private ImageView elX;
    private i elY;
    private ImageView mIconView;
    private TextView mTitleView;

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.dME = false;
        this.dMH = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.elY != null && SwanAppMenuItemView.this.elY.bcV() != null) {
                    SwanAppMenuItemView.this.dME = SwanAppMenuItemView.this.elY.bcV().c(SwanAppMenuItemView.this.elY);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dME = false;
        this.dMH = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.elY != null && SwanAppMenuItemView.this.elY.bcV() != null) {
                    SwanAppMenuItemView.this.dME = SwanAppMenuItemView.this.elY.bcV().c(SwanAppMenuItemView.this.elY);
                }
            }
        };
        init();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dME = false;
        this.dMH = new Runnable() { // from class: com.baidu.swan.menu.SwanAppMenuItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuItemView.this.elY != null && SwanAppMenuItemView.this.elY.bcV() != null) {
                    SwanAppMenuItemView.this.dME = SwanAppMenuItemView.this.elY.bcV().c(SwanAppMenuItemView.this.elY);
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
        this.elW = (TextView) findViewById(g.d.aiapp_menu_item_new_tips);
        this.elX = (ImageView) findViewById(g.d.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(i iVar) {
        if (iVar != null) {
            setItemView(iVar);
            this.elY = iVar;
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
            this.mTitleView.setText(iVar.em(getContext()));
            Drawable i = i(iVar);
            if (i != null) {
                this.mIconView.setImageDrawable(i);
                this.mIconView.setImageLevel(iVar.bcT());
            }
            this.mTitleView.setTextColor(getResources().getColor(iVar.getTitleColor()));
        }
    }

    private void h(i iVar) {
        if (iVar != null) {
            switch (iVar.bcR()) {
                case 0:
                    this.elW.setVisibility(8);
                    this.elW.setVisibility(8);
                    return;
                case 1:
                    this.elX.setVisibility(8);
                    this.elW.setText(dk(iVar.bcS()));
                    this.elW.setTextColor(getResources().getColor(g.a.swan_app_menu_item_tip_text));
                    this.elW.setBackground(getResources().getDrawable(g.c.swan_app_menu_new_bg));
                    this.elW.setVisibility(0);
                    return;
                case 2:
                    this.elW.setVisibility(8);
                    this.elX.setImageDrawable(getResources().getDrawable(g.c.swan_app_menu_new_dot));
                    this.elX.setVisibility(0);
                    return;
                default:
                    this.elW.setVisibility(8);
                    this.elX.setVisibility(8);
                    return;
            }
        }
    }

    private String dk(long j) {
        return j <= 99 ? String.valueOf(j) : "99+";
    }

    private Drawable i(i iVar) {
        return iVar.en(getContext());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.elY == null || this.elY.bcV() == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.dMH);
                this.dME = false;
                this.dMD = x;
                this.WZ = y;
                postDelayed(this.dMH, IMConnection.RETRY_DELAY_TIMES);
                setPressed(true);
                return true;
            case 1:
                removeCallbacks(this.dMH);
                if (!this.dME && this.elY.bcU() != null) {
                    this.elY.bcU().a(this, this.elY);
                }
                this.dME = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            case 2:
                if (Math.abs(this.dMD - x) > 10 || Math.abs(this.WZ - y) > 10) {
                    removeCallbacks(this.dMH);
                    this.dME = false;
                    return true;
                }
                return true;
            case 3:
                removeCallbacks(this.dMH);
                this.dME = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            default:
                return true;
        }
    }
}
