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
    private int WX;
    private SwanAppRoundedImageView cTu;
    private Runnable dVA;
    private TextView dVq;
    private View dVr;
    private TextView dVs;
    private a dVt;
    private b dVu;
    private a dVv;
    private int dVw;
    private boolean dVx;
    private int dVy;
    private int dVz;

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
        this.dVx = false;
        this.dVA = new Runnable() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.4
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuHeaderView.this.dVu != null) {
                    SwanAppMenuHeaderView.this.dVx = SwanAppMenuHeaderView.this.dVu.onLongClick(SwanAppMenuHeaderView.this.dVr);
                }
            }
        };
        ap(inflate(context, a.g.swan_app_menu_header_view, this));
        setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.oj(d.aMg().getAppId()));
    }

    private void ap(View view) {
        this.dVr = view.findViewById(a.f.header_content);
        this.cTu = (SwanAppRoundedImageView) view.findViewById(a.f.swan_app_icon);
        this.dVq = (TextView) view.findViewById(a.f.swan_app_title);
        this.dVs = (TextView) view.findViewById(a.f.btn_item_attenion);
        b.a aMo = d.aMg().aMc().aMo();
        this.cTu.setImageBitmap(ak.a(aMo.getIconUrl(), "SwanAppMenuHeaderView", false, new s.a() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.1
            @Override // com.baidu.swan.apps.ao.s.a
            public void g(String str, Bitmap bitmap) {
                if (bitmap != null && SwanAppMenuHeaderView.this.cTu != null) {
                    SwanAppMenuHeaderView.this.cTu.setImageBitmap(bitmap);
                }
            }
        }));
        this.dVq.setText(aMo.awx());
        this.dVr.setOnTouchListener(this);
        this.dVr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.dVt != null) {
                    SwanAppMenuHeaderView.this.dVt.onClick(view2);
                    view2.setPressed(true);
                }
            }
        });
        this.dVs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.dVv != null) {
                    SwanAppMenuHeaderView.this.dVv.onClick(view2);
                }
            }
        });
    }

    public void setOnMenuHeaderClickListener(a aVar) {
        this.dVt = aVar;
    }

    public void setOnAttentionBtnClickListener(a aVar) {
        this.dVv = aVar;
    }

    public void setAttentionBtnShow(boolean z) {
        this.dVs.setVisibility(z ? 0 : 8);
    }

    public void setAttentionBtnStates(boolean z) {
        if (!z) {
            this.dVs.setText(a.h.aiapps_favorite_guide_add);
            this.dVs.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_attention_btn_bg));
            this.dVs.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_attention_btn_text_color));
            return;
        }
        this.dVs.setText(a.h.swanapp_favored);
        this.dVs.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_cancel_attention_btn_bg));
        this.dVs.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_cancel_attention_btn_text_color));
    }

    public void setOnMenuHeaderLongClickListener(b bVar) {
        this.dVu = bVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.dVy = (int) x;
                this.dVz = (int) y;
                return false;
            case 1:
            default:
                return false;
            case 2:
                if (Math.abs(this.dVy - x) <= 10.0f && Math.abs(this.dVz - y) <= 10.0f) {
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
                if (this.dVu == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.dVA);
                this.dVx = false;
                this.dVw = x;
                this.WX = y;
                postDelayed(this.dVA, IMConnection.RETRY_DELAY_TIMES);
                view.setPressed(true);
                break;
            case 1:
                removeCallbacks(this.dVA);
                if (!this.dVx && this.dVt != null) {
                    this.dVt.onClick(this.dVr);
                }
                this.dVx = false;
                view.setPressed(false);
                return false;
            case 2:
                if (Math.abs(this.dVw - x) > 10 || Math.abs(this.WX - y) > 10) {
                    removeCallbacks(this.dVA);
                    this.dVx = false;
                    break;
                }
                break;
            case 3:
                removeCallbacks(this.dVA);
                this.dVx = false;
                view.setPressed(false);
                break;
        }
        return true;
    }
}
