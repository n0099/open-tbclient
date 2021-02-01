package com.baidu.swan.apps.view.menu;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.s;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
/* loaded from: classes9.dex */
public class SwanAppMenuHeaderView extends FrameLayout implements View.OnTouchListener {
    private int WQ;
    private SwanAppRoundedImageView cQW;
    private TextView dSK;
    private View dSL;
    private TextView dSM;
    private a dSN;
    private b dSO;
    private a dSP;
    private int dSQ;
    private boolean dSR;
    private int dSS;
    private int dST;
    private Runnable dSU;

    /* loaded from: classes9.dex */
    public interface a {
        void onClick(View view);
    }

    /* loaded from: classes9.dex */
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
        this.dSR = false;
        this.dSU = new Runnable() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.4
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuHeaderView.this.dSO != null) {
                    SwanAppMenuHeaderView.this.dSR = SwanAppMenuHeaderView.this.dSO.onLongClick(SwanAppMenuHeaderView.this.dSL);
                }
            }
        };
        am(inflate(context, a.g.swan_app_menu_header_view, this));
        setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.np(d.aIG().getAppId()));
    }

    private void am(View view) {
        this.dSL = view.findViewById(a.f.header_content);
        this.cQW = (SwanAppRoundedImageView) view.findViewById(a.f.swan_app_icon);
        this.dSK = (TextView) view.findViewById(a.f.swan_app_title);
        this.dSM = (TextView) view.findViewById(a.f.btn_item_attenion);
        b.a aIO = d.aIG().aIC().aIO();
        this.cQW.setImageBitmap(ak.a(aIO.getIconUrl(), "SwanAppMenuHeaderView", false, new s.a() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.1
            @Override // com.baidu.swan.apps.ao.s.a
            public void f(String str, Bitmap bitmap) {
                if (bitmap != null && SwanAppMenuHeaderView.this.cQW != null) {
                    SwanAppMenuHeaderView.this.cQW.setImageBitmap(bitmap);
                }
            }
        }));
        this.dSK.setText(aIO.atc());
        this.dSL.setOnTouchListener(this);
        this.dSL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.dSN != null) {
                    SwanAppMenuHeaderView.this.dSN.onClick(view2);
                    view2.setPressed(true);
                }
            }
        });
        this.dSM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.dSP != null) {
                    SwanAppMenuHeaderView.this.dSP.onClick(view2);
                }
            }
        });
    }

    public void setOnMenuHeaderClickListener(a aVar) {
        this.dSN = aVar;
    }

    public void setOnAttentionBtnClickListener(a aVar) {
        this.dSP = aVar;
    }

    public void setAttentionBtnShow(boolean z) {
        this.dSM.setVisibility(z ? 0 : 8);
    }

    public void setAttentionBtnStates(boolean z) {
        if (!z) {
            this.dSM.setText(a.h.aiapps_favorite_guide_add);
            this.dSM.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_attention_btn_bg));
            this.dSM.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_attention_btn_text_color));
            return;
        }
        this.dSM.setText(a.h.swanapp_favored);
        this.dSM.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_cancel_attention_btn_bg));
        this.dSM.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_cancel_attention_btn_text_color));
    }

    public void setOnMenuHeaderLongClickListener(b bVar) {
        this.dSO = bVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.dSS = (int) x;
                this.dST = (int) y;
                return false;
            case 1:
            default:
                return false;
            case 2:
                if (Math.abs(this.dSS - x) <= 10.0f && Math.abs(this.dST - y) <= 10.0f) {
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
                if (this.dSO == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.dSU);
                this.dSR = false;
                this.dSQ = x;
                this.WQ = y;
                postDelayed(this.dSU, IMConnection.RETRY_DELAY_TIMES);
                view.setPressed(true);
                break;
            case 1:
                removeCallbacks(this.dSU);
                if (!this.dSR && this.dSN != null) {
                    this.dSN.onClick(this.dSL);
                }
                this.dSR = false;
                view.setPressed(false);
                return false;
            case 2:
                if (Math.abs(this.dSQ - x) > 10 || Math.abs(this.WQ - y) > 10) {
                    removeCallbacks(this.dSU);
                    this.dSR = false;
                    break;
                }
                break;
            case 3:
                removeCallbacks(this.dSU);
                this.dSR = false;
                view.setPressed(false);
                break;
        }
        return true;
    }
}
