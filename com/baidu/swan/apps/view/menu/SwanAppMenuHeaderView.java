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
/* loaded from: classes8.dex */
public class SwanAppMenuHeaderView extends FrameLayout implements View.OnTouchListener {
    private int Yl;
    private SwanAppRoundedImageView cSw;
    private TextView dUl;
    private View dUm;
    private TextView dUn;
    private a dUo;
    private b dUp;
    private a dUq;
    private int dUr;
    private boolean dUs;
    private int dUt;
    private int dUu;
    private Runnable dUv;

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
        this.dUs = false;
        this.dUv = new Runnable() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.4
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuHeaderView.this.dUp != null) {
                    SwanAppMenuHeaderView.this.dUs = SwanAppMenuHeaderView.this.dUp.onLongClick(SwanAppMenuHeaderView.this.dUm);
                }
            }
        };
        am(inflate(context, a.g.swan_app_menu_header_view, this));
        setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.nw(d.aIJ().getAppId()));
    }

    private void am(View view) {
        this.dUm = view.findViewById(a.f.header_content);
        this.cSw = (SwanAppRoundedImageView) view.findViewById(a.f.swan_app_icon);
        this.dUl = (TextView) view.findViewById(a.f.swan_app_title);
        this.dUn = (TextView) view.findViewById(a.f.btn_item_attenion);
        b.a aIR = d.aIJ().aIF().aIR();
        this.cSw.setImageBitmap(ak.a(aIR.getIconUrl(), "SwanAppMenuHeaderView", false, new s.a() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.1
            @Override // com.baidu.swan.apps.ao.s.a
            public void f(String str, Bitmap bitmap) {
                if (bitmap != null && SwanAppMenuHeaderView.this.cSw != null) {
                    SwanAppMenuHeaderView.this.cSw.setImageBitmap(bitmap);
                }
            }
        }));
        this.dUl.setText(aIR.atf());
        this.dUm.setOnTouchListener(this);
        this.dUm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.dUo != null) {
                    SwanAppMenuHeaderView.this.dUo.onClick(view2);
                    view2.setPressed(true);
                }
            }
        });
        this.dUn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.dUq != null) {
                    SwanAppMenuHeaderView.this.dUq.onClick(view2);
                }
            }
        });
    }

    public void setOnMenuHeaderClickListener(a aVar) {
        this.dUo = aVar;
    }

    public void setOnAttentionBtnClickListener(a aVar) {
        this.dUq = aVar;
    }

    public void setAttentionBtnShow(boolean z) {
        this.dUn.setVisibility(z ? 0 : 8);
    }

    public void setAttentionBtnStates(boolean z) {
        if (!z) {
            this.dUn.setText(a.h.aiapps_favorite_guide_add);
            this.dUn.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_attention_btn_bg));
            this.dUn.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_attention_btn_text_color));
            return;
        }
        this.dUn.setText(a.h.swanapp_favored);
        this.dUn.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_cancel_attention_btn_bg));
        this.dUn.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_cancel_attention_btn_text_color));
    }

    public void setOnMenuHeaderLongClickListener(b bVar) {
        this.dUp = bVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.dUt = (int) x;
                this.dUu = (int) y;
                return false;
            case 1:
            default:
                return false;
            case 2:
                if (Math.abs(this.dUt - x) <= 10.0f && Math.abs(this.dUu - y) <= 10.0f) {
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
                if (this.dUp == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.dUv);
                this.dUs = false;
                this.dUr = x;
                this.Yl = y;
                postDelayed(this.dUv, IMConnection.RETRY_DELAY_TIMES);
                view.setPressed(true);
                break;
            case 1:
                removeCallbacks(this.dUv);
                if (!this.dUs && this.dUo != null) {
                    this.dUo.onClick(this.dUm);
                }
                this.dUs = false;
                view.setPressed(false);
                return false;
            case 2:
                if (Math.abs(this.dUr - x) > 10 || Math.abs(this.Yl - y) > 10) {
                    removeCallbacks(this.dUv);
                    this.dUs = false;
                    break;
                }
                break;
            case 3:
                removeCallbacks(this.dUv);
                this.dUs = false;
                view.setPressed(false);
                break;
        }
        return true;
    }
}
