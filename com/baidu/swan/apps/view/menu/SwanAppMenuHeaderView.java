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
    private SwanAppRoundedImageView cJq;
    private TextView dHg;
    private View dHh;
    private TextView dHi;
    private a dHj;
    private b dHk;
    private a dHl;
    private int dHm;
    private int dHn;
    private boolean dHo;
    private int dHp;
    private int dHq;
    private Runnable dHr;

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
        this.dHo = false;
        this.dHr = new Runnable() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.4
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuHeaderView.this.dHk != null) {
                    SwanAppMenuHeaderView.this.dHo = SwanAppMenuHeaderView.this.dHk.onLongClick(SwanAppMenuHeaderView.this.dHh);
                }
            }
        };
        al(inflate(context, a.g.swan_app_menu_header_view, this));
        setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.nO(d.aHq().getAppId()));
    }

    private void al(View view) {
        this.dHh = view.findViewById(a.f.header_content);
        this.cJq = (SwanAppRoundedImageView) view.findViewById(a.f.swan_app_icon);
        this.dHg = (TextView) view.findViewById(a.f.swan_app_title);
        this.dHi = (TextView) view.findViewById(a.f.btn_item_attenion);
        b.a aHy = d.aHq().aHm().aHy();
        this.cJq.setImageBitmap(ak.a(aHy.getIconUrl(), "SwanAppMenuHeaderView", false, new s.a() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.1
            @Override // com.baidu.swan.apps.ap.s.a
            public void g(String str, Bitmap bitmap) {
                if (bitmap != null && SwanAppMenuHeaderView.this.cJq != null) {
                    SwanAppMenuHeaderView.this.cJq.setImageBitmap(bitmap);
                }
            }
        }));
        this.dHg.setText(aHy.asF());
        this.dHh.setOnTouchListener(this);
        this.dHh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.dHj != null) {
                    SwanAppMenuHeaderView.this.dHj.onClick(view2);
                    view2.setPressed(true);
                }
            }
        });
        this.dHi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.dHl != null) {
                    SwanAppMenuHeaderView.this.dHl.onClick(view2);
                }
            }
        });
    }

    public void setOnMenuHeaderClickListener(a aVar) {
        this.dHj = aVar;
    }

    public void setOnAttentionBtnClickListener(a aVar) {
        this.dHl = aVar;
    }

    public void setAttentionBtnShow(boolean z) {
        this.dHi.setVisibility(z ? 0 : 8);
    }

    public void setAttentionBtnStates(boolean z) {
        if (!z) {
            this.dHi.setText(a.h.aiapps_favorite_guide_add);
            this.dHi.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_attention_btn_bg));
            this.dHi.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_attention_btn_text_color));
            return;
        }
        this.dHi.setText(a.h.swanapp_favored);
        this.dHi.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_cancel_attention_btn_bg));
        this.dHi.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_cancel_attention_btn_text_color));
    }

    public void setOnMenuHeaderLongClickListener(b bVar) {
        this.dHk = bVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.dHp = (int) x;
                this.dHq = (int) y;
                return false;
            case 1:
            default:
                return false;
            case 2:
                if (Math.abs(this.dHp - x) <= 10.0f && Math.abs(this.dHq - y) <= 10.0f) {
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
                if (this.dHk == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.dHr);
                this.dHo = false;
                this.dHm = x;
                this.dHn = y;
                postDelayed(this.dHr, IMConnection.RETRY_DELAY_TIMES);
                view.setPressed(true);
                break;
            case 1:
                removeCallbacks(this.dHr);
                if (!this.dHo && this.dHj != null) {
                    this.dHj.onClick(this.dHh);
                }
                this.dHo = false;
                view.setPressed(false);
                return false;
            case 2:
                if (Math.abs(this.dHm - x) > 10 || Math.abs(this.dHn - y) > 10) {
                    removeCallbacks(this.dHr);
                    this.dHo = false;
                    break;
                }
                break;
            case 3:
                removeCallbacks(this.dHr);
                this.dHo = false;
                view.setPressed(false);
                break;
        }
        return true;
    }
}
