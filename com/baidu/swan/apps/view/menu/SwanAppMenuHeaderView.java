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
/* loaded from: classes8.dex */
public class SwanAppMenuHeaderView extends FrameLayout implements View.OnTouchListener {
    private SwanAppRoundedImageView cgC;
    private TextView deE;
    private View deF;
    private TextView deG;
    private a deH;
    private b deI;
    private a deJ;
    private int deK;
    private int deL;
    private boolean deM;
    private int deN;
    private int deO;
    private Runnable deP;

    /* loaded from: classes8.dex */
    public interface a {
        void onClick(View view);
    }

    /* loaded from: classes8.dex */
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
        this.deM = false;
        this.deP = new Runnable() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.4
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuHeaderView.this.deI != null) {
                    SwanAppMenuHeaderView.this.deM = SwanAppMenuHeaderView.this.deI.onLongClick(SwanAppMenuHeaderView.this.deF);
                }
            }
        };
        ak(inflate(context, a.g.swan_app_menu_header_view, this));
        setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.mb(d.azE().getAppId()));
    }

    private void ak(View view) {
        this.deF = view.findViewById(a.f.header_content);
        this.cgC = (SwanAppRoundedImageView) view.findViewById(a.f.swan_app_icon);
        this.deE = (TextView) view.findViewById(a.f.swan_app_title);
        this.deG = (TextView) view.findViewById(a.f.btn_item_attenion);
        b.a azM = d.azE().azA().azM();
        this.cgC.setImageBitmap(ak.a(azM.getIconUrl(), "SwanAppMenuHeaderView", false, new s.a() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.1
            @Override // com.baidu.swan.apps.ap.s.a
            public void h(String str, Bitmap bitmap) {
                if (bitmap != null && SwanAppMenuHeaderView.this.cgC != null) {
                    SwanAppMenuHeaderView.this.cgC.setImageBitmap(bitmap);
                }
            }
        }));
        this.deE.setText(azM.akO());
        this.deF.setOnTouchListener(this);
        this.deF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.deH != null) {
                    SwanAppMenuHeaderView.this.deH.onClick(view2);
                    view2.setPressed(true);
                }
            }
        });
        this.deG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.deJ != null) {
                    SwanAppMenuHeaderView.this.deJ.onClick(view2);
                }
            }
        });
    }

    public void setOnMenuHeaderClickListener(a aVar) {
        this.deH = aVar;
    }

    public void setOnAttentionBtnClickListener(a aVar) {
        this.deJ = aVar;
    }

    public void setAttentionBtnShow(boolean z) {
        this.deG.setVisibility(z ? 0 : 8);
    }

    public void setAttentionBtnStates(boolean z) {
        if (!z) {
            this.deG.setText(a.h.aiapps_favorite_guide_add);
            this.deG.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_attention_btn_bg));
            this.deG.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_attention_btn_text_color));
            return;
        }
        this.deG.setText(a.h.swanapp_favored);
        this.deG.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_cancel_attention_btn_bg));
        this.deG.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_cancel_attention_btn_text_color));
    }

    public void setOnMenuHeaderLongClickListener(b bVar) {
        this.deI = bVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.deN = (int) x;
                this.deO = (int) y;
                return false;
            case 1:
            default:
                return false;
            case 2:
                if (Math.abs(this.deN - x) <= 10.0f && Math.abs(this.deO - y) <= 10.0f) {
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
                if (this.deI == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.deP);
                this.deM = false;
                this.deK = x;
                this.deL = y;
                postDelayed(this.deP, IMConnection.RETRY_DELAY_TIMES);
                view.setPressed(true);
                break;
            case 1:
                removeCallbacks(this.deP);
                if (!this.deM && this.deH != null) {
                    this.deH.onClick(this.deF);
                }
                this.deM = false;
                view.setPressed(false);
                return false;
            case 2:
                if (Math.abs(this.deK - x) > 10 || Math.abs(this.deL - y) > 10) {
                    removeCallbacks(this.deP);
                    this.deM = false;
                    break;
                }
                break;
            case 3:
                removeCallbacks(this.deP);
                this.deM = false;
                view.setPressed(false);
                break;
        }
        return true;
    }
}
