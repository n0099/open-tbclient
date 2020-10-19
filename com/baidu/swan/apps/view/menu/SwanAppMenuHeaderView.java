package com.baidu.swan.apps.view.menu;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.s;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
/* loaded from: classes10.dex */
public class SwanAppMenuHeaderView extends FrameLayout implements View.OnTouchListener {
    private SwanAppRoundedImageView cvb;
    private TextView dsQ;
    private View dsR;
    private TextView dsS;
    private a dsT;
    private b dsU;
    private a dsV;
    private int dsW;
    private int dsX;
    private boolean dsY;
    private int dsZ;
    private int dta;
    private Runnable dtb;

    /* loaded from: classes10.dex */
    public interface a {
        void onClick(View view);
    }

    /* loaded from: classes10.dex */
    public interface b {
        boolean onLongClick(View view);
    }

    public SwanAppMenuHeaderView(Context context) {
        this(context, null);
    }

    public SwanAppMenuHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwanAppMenuHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.dsY = false;
        this.dtb = new Runnable() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.4
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuHeaderView.this.dsU != null) {
                    SwanAppMenuHeaderView.this.dsY = SwanAppMenuHeaderView.this.dsU.onLongClick(SwanAppMenuHeaderView.this.dsR);
                }
            }
        };
        an(inflate(context, a.g.swan_app_menu_header_view, this));
        setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.nh(d.aCW().getAppId()));
    }

    private void an(View view) {
        this.dsR = view.findViewById(a.f.header_content);
        this.cvb = (SwanAppRoundedImageView) view.findViewById(a.f.swan_app_icon);
        this.dsQ = (TextView) view.findViewById(a.f.swan_app_title);
        this.dsS = (TextView) view.findViewById(a.f.btn_item_attenion);
        b.a aDe = d.aCW().aCS().aDe();
        this.cvb.setImageBitmap(ak.a(aDe.getIconUrl(), "SwanAppMenuHeaderView", false, new s.a() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.1
            @Override // com.baidu.swan.apps.ap.s.a
            public void g(String str, Bitmap bitmap) {
                if (bitmap != null && SwanAppMenuHeaderView.this.cvb != null) {
                    SwanAppMenuHeaderView.this.cvb.setImageBitmap(bitmap);
                }
            }
        }));
        this.dsQ.setText(aDe.aoj());
        this.dsR.setOnTouchListener(this);
        this.dsR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.dsT != null) {
                    SwanAppMenuHeaderView.this.dsT.onClick(view2);
                    view2.setPressed(true);
                }
            }
        });
        this.dsS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.dsV != null) {
                    SwanAppMenuHeaderView.this.dsV.onClick(view2);
                }
            }
        });
    }

    public void setOnMenuHeaderClickListener(a aVar) {
        this.dsT = aVar;
    }

    public void setOnAttentionBtnClickListener(a aVar) {
        this.dsV = aVar;
    }

    public void setAttentionBtnShow(boolean z) {
        this.dsS.setVisibility(z ? 0 : 8);
    }

    public void setAttentionBtnStates(boolean z) {
        if (!z) {
            this.dsS.setText(a.h.aiapps_favorite_guide_add);
            this.dsS.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_attention_btn_bg));
            this.dsS.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_attention_btn_text_color));
            return;
        }
        this.dsS.setText(a.h.swanapp_favored);
        this.dsS.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_cancel_attention_btn_bg));
        this.dsS.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_cancel_attention_btn_text_color));
    }

    public void setOnMenuHeaderLongClickListener(b bVar) {
        this.dsU = bVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.dsZ = (int) x;
                this.dta = (int) y;
                return false;
            case 1:
            default:
                return false;
            case 2:
                if (Math.abs(this.dsZ - x) <= 10.0f && Math.abs(this.dta - y) <= 10.0f) {
                    return false;
                }
                return true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.dsU == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.dtb);
                this.dsY = false;
                this.dsW = x;
                this.dsX = y;
                postDelayed(this.dtb, IMConnection.RETRY_DELAY_TIMES);
                view.setPressed(true);
                break;
            case 1:
                removeCallbacks(this.dtb);
                if (!this.dsY && this.dsT != null) {
                    this.dsT.onClick(this.dsR);
                }
                this.dsY = false;
                view.setPressed(false);
                return false;
            case 2:
                if (Math.abs(this.dsW - x) > 10 || Math.abs(this.dsX - y) > 10) {
                    removeCallbacks(this.dtb);
                    this.dsY = false;
                    break;
                }
                break;
            case 3:
                removeCallbacks(this.dtb);
                this.dsY = false;
                view.setPressed(false);
                break;
        }
        return true;
    }
}
