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
/* loaded from: classes3.dex */
public class SwanAppMenuHeaderView extends FrameLayout implements View.OnTouchListener {
    private SwanAppRoundedImageView ciI;
    private TextView dgI;
    private View dgJ;
    private TextView dgK;
    private a dgL;
    private b dgM;
    private a dgN;
    private int dgO;
    private int dgP;
    private boolean dgQ;
    private int dgR;
    private int dgS;
    private Runnable dgT;

    /* loaded from: classes3.dex */
    public interface a {
        void onClick(View view);
    }

    /* loaded from: classes3.dex */
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
        this.dgQ = false;
        this.dgT = new Runnable() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.4
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuHeaderView.this.dgM != null) {
                    SwanAppMenuHeaderView.this.dgQ = SwanAppMenuHeaderView.this.dgM.onLongClick(SwanAppMenuHeaderView.this.dgJ);
                }
            }
        };
        am(inflate(context, a.g.swan_app_menu_header_view, this));
        setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.mv(d.aAn().getAppId()));
    }

    private void am(View view) {
        this.dgJ = view.findViewById(a.f.header_content);
        this.ciI = (SwanAppRoundedImageView) view.findViewById(a.f.swan_app_icon);
        this.dgI = (TextView) view.findViewById(a.f.swan_app_title);
        this.dgK = (TextView) view.findViewById(a.f.btn_item_attenion);
        b.a aAv = d.aAn().aAj().aAv();
        this.ciI.setImageBitmap(ak.a(aAv.getIconUrl(), "SwanAppMenuHeaderView", false, new s.a() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.1
            @Override // com.baidu.swan.apps.ap.s.a
            public void g(String str, Bitmap bitmap) {
                if (bitmap != null && SwanAppMenuHeaderView.this.ciI != null) {
                    SwanAppMenuHeaderView.this.ciI.setImageBitmap(bitmap);
                }
            }
        }));
        this.dgI.setText(aAv.aly());
        this.dgJ.setOnTouchListener(this);
        this.dgJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.dgL != null) {
                    SwanAppMenuHeaderView.this.dgL.onClick(view2);
                    view2.setPressed(true);
                }
            }
        });
        this.dgK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.dgN != null) {
                    SwanAppMenuHeaderView.this.dgN.onClick(view2);
                }
            }
        });
    }

    public void setOnMenuHeaderClickListener(a aVar) {
        this.dgL = aVar;
    }

    public void setOnAttentionBtnClickListener(a aVar) {
        this.dgN = aVar;
    }

    public void setAttentionBtnShow(boolean z) {
        this.dgK.setVisibility(z ? 0 : 8);
    }

    public void setAttentionBtnStates(boolean z) {
        if (!z) {
            this.dgK.setText(a.h.aiapps_favorite_guide_add);
            this.dgK.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_attention_btn_bg));
            this.dgK.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_attention_btn_text_color));
            return;
        }
        this.dgK.setText(a.h.swanapp_favored);
        this.dgK.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_cancel_attention_btn_bg));
        this.dgK.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_cancel_attention_btn_text_color));
    }

    public void setOnMenuHeaderLongClickListener(b bVar) {
        this.dgM = bVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.dgR = (int) x;
                this.dgS = (int) y;
                return false;
            case 1:
            default:
                return false;
            case 2:
                if (Math.abs(this.dgR - x) <= 10.0f && Math.abs(this.dgS - y) <= 10.0f) {
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
                if (this.dgM == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.dgT);
                this.dgQ = false;
                this.dgO = x;
                this.dgP = y;
                postDelayed(this.dgT, IMConnection.RETRY_DELAY_TIMES);
                view.setPressed(true);
                break;
            case 1:
                removeCallbacks(this.dgT);
                if (!this.dgQ && this.dgL != null) {
                    this.dgL.onClick(this.dgJ);
                }
                this.dgQ = false;
                view.setPressed(false);
                return false;
            case 2:
                if (Math.abs(this.dgO - x) > 10 || Math.abs(this.dgP - y) > 10) {
                    removeCallbacks(this.dgT);
                    this.dgQ = false;
                    break;
                }
                break;
            case 3:
                removeCallbacks(this.dgT);
                this.dgQ = false;
                view.setPressed(false);
                break;
        }
        return true;
    }
}
