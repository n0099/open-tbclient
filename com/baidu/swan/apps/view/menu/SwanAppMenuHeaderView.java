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
    private SwanAppRoundedImageView cDx;
    private TextView dBo;
    private View dBp;
    private TextView dBq;
    private a dBr;
    private b dBs;
    private a dBt;
    private int dBu;
    private int dBv;
    private boolean dBw;
    private int dBx;
    private int dBy;
    private Runnable dBz;

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
        this.dBw = false;
        this.dBz = new Runnable() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.4
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuHeaderView.this.dBs != null) {
                    SwanAppMenuHeaderView.this.dBw = SwanAppMenuHeaderView.this.dBs.onLongClick(SwanAppMenuHeaderView.this.dBp);
                }
            }
        };
        ah(inflate(context, a.g.swan_app_menu_header_view, this));
        setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.nA(d.aEQ().getAppId()));
    }

    private void ah(View view) {
        this.dBp = view.findViewById(a.f.header_content);
        this.cDx = (SwanAppRoundedImageView) view.findViewById(a.f.swan_app_icon);
        this.dBo = (TextView) view.findViewById(a.f.swan_app_title);
        this.dBq = (TextView) view.findViewById(a.f.btn_item_attenion);
        b.a aEY = d.aEQ().aEM().aEY();
        this.cDx.setImageBitmap(ak.a(aEY.getIconUrl(), "SwanAppMenuHeaderView", false, new s.a() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.1
            @Override // com.baidu.swan.apps.ap.s.a
            public void g(String str, Bitmap bitmap) {
                if (bitmap != null && SwanAppMenuHeaderView.this.cDx != null) {
                    SwanAppMenuHeaderView.this.cDx.setImageBitmap(bitmap);
                }
            }
        }));
        this.dBo.setText(aEY.aqe());
        this.dBp.setOnTouchListener(this);
        this.dBp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.dBr != null) {
                    SwanAppMenuHeaderView.this.dBr.onClick(view2);
                    view2.setPressed(true);
                }
            }
        });
        this.dBq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.dBt != null) {
                    SwanAppMenuHeaderView.this.dBt.onClick(view2);
                }
            }
        });
    }

    public void setOnMenuHeaderClickListener(a aVar) {
        this.dBr = aVar;
    }

    public void setOnAttentionBtnClickListener(a aVar) {
        this.dBt = aVar;
    }

    public void setAttentionBtnShow(boolean z) {
        this.dBq.setVisibility(z ? 0 : 8);
    }

    public void setAttentionBtnStates(boolean z) {
        if (!z) {
            this.dBq.setText(a.h.aiapps_favorite_guide_add);
            this.dBq.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_attention_btn_bg));
            this.dBq.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_attention_btn_text_color));
            return;
        }
        this.dBq.setText(a.h.swanapp_favored);
        this.dBq.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_cancel_attention_btn_bg));
        this.dBq.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_cancel_attention_btn_text_color));
    }

    public void setOnMenuHeaderLongClickListener(b bVar) {
        this.dBs = bVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.dBx = (int) x;
                this.dBy = (int) y;
                return false;
            case 1:
            default:
                return false;
            case 2:
                if (Math.abs(this.dBx - x) <= 10.0f && Math.abs(this.dBy - y) <= 10.0f) {
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
                if (this.dBs == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.dBz);
                this.dBw = false;
                this.dBu = x;
                this.dBv = y;
                postDelayed(this.dBz, IMConnection.RETRY_DELAY_TIMES);
                view.setPressed(true);
                break;
            case 1:
                removeCallbacks(this.dBz);
                if (!this.dBw && this.dBr != null) {
                    this.dBr.onClick(this.dBp);
                }
                this.dBw = false;
                view.setPressed(false);
                return false;
            case 2:
                if (Math.abs(this.dBu - x) > 10 || Math.abs(this.dBv - y) > 10) {
                    removeCallbacks(this.dBz);
                    this.dBw = false;
                    break;
                }
                break;
            case 3:
                removeCallbacks(this.dBz);
                this.dBw = false;
                view.setPressed(false);
                break;
        }
        return true;
    }
}
