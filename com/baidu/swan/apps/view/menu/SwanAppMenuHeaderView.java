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
/* loaded from: classes7.dex */
public class SwanAppMenuHeaderView extends FrameLayout implements View.OnTouchListener {
    private int Wc;
    private SwanAppRoundedImageView cHG;
    private View dFA;
    private TextView dFB;
    private a dFC;
    private b dFD;
    private a dFE;
    private int dFF;
    private boolean dFG;
    private int dFH;
    private int dFI;
    private Runnable dFJ;
    private TextView dFz;

    /* loaded from: classes7.dex */
    public interface a {
        void onClick(View view);
    }

    /* loaded from: classes7.dex */
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
        this.dFG = false;
        this.dFJ = new Runnable() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.4
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuHeaderView.this.dFD != null) {
                    SwanAppMenuHeaderView.this.dFG = SwanAppMenuHeaderView.this.dFD.onLongClick(SwanAppMenuHeaderView.this.dFA);
                }
            }
        };
        al(inflate(context, a.g.swan_app_menu_header_view, this));
        setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.nI(d.aGI().getAppId()));
    }

    private void al(View view) {
        this.dFA = view.findViewById(a.f.header_content);
        this.cHG = (SwanAppRoundedImageView) view.findViewById(a.f.swan_app_icon);
        this.dFz = (TextView) view.findViewById(a.f.swan_app_title);
        this.dFB = (TextView) view.findViewById(a.f.btn_item_attenion);
        b.a aGQ = d.aGI().aGE().aGQ();
        this.cHG.setImageBitmap(ak.a(aGQ.getIconUrl(), "SwanAppMenuHeaderView", false, new s.a() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.1
            @Override // com.baidu.swan.apps.ap.s.a
            public void g(String str, Bitmap bitmap) {
                if (bitmap != null && SwanAppMenuHeaderView.this.cHG != null) {
                    SwanAppMenuHeaderView.this.cHG.setImageBitmap(bitmap);
                }
            }
        }));
        this.dFz.setText(aGQ.arW());
        this.dFA.setOnTouchListener(this);
        this.dFA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.dFC != null) {
                    SwanAppMenuHeaderView.this.dFC.onClick(view2);
                    view2.setPressed(true);
                }
            }
        });
        this.dFB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.dFE != null) {
                    SwanAppMenuHeaderView.this.dFE.onClick(view2);
                }
            }
        });
    }

    public void setOnMenuHeaderClickListener(a aVar) {
        this.dFC = aVar;
    }

    public void setOnAttentionBtnClickListener(a aVar) {
        this.dFE = aVar;
    }

    public void setAttentionBtnShow(boolean z) {
        this.dFB.setVisibility(z ? 0 : 8);
    }

    public void setAttentionBtnStates(boolean z) {
        if (!z) {
            this.dFB.setText(a.h.aiapps_favorite_guide_add);
            this.dFB.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_attention_btn_bg));
            this.dFB.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_attention_btn_text_color));
            return;
        }
        this.dFB.setText(a.h.swanapp_favored);
        this.dFB.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_cancel_attention_btn_bg));
        this.dFB.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_cancel_attention_btn_text_color));
    }

    public void setOnMenuHeaderLongClickListener(b bVar) {
        this.dFD = bVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.dFH = (int) x;
                this.dFI = (int) y;
                return false;
            case 1:
            default:
                return false;
            case 2:
                if (Math.abs(this.dFH - x) <= 10.0f && Math.abs(this.dFI - y) <= 10.0f) {
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
                if (this.dFD == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.dFJ);
                this.dFG = false;
                this.dFF = x;
                this.Wc = y;
                postDelayed(this.dFJ, IMConnection.RETRY_DELAY_TIMES);
                view.setPressed(true);
                break;
            case 1:
                removeCallbacks(this.dFJ);
                if (!this.dFG && this.dFC != null) {
                    this.dFC.onClick(this.dFA);
                }
                this.dFG = false;
                view.setPressed(false);
                return false;
            case 2:
                if (Math.abs(this.dFF - x) > 10 || Math.abs(this.Wc - y) > 10) {
                    removeCallbacks(this.dFJ);
                    this.dFG = false;
                    break;
                }
                break;
            case 3:
                removeCallbacks(this.dFJ);
                this.dFG = false;
                view.setPressed(false);
                break;
        }
        return true;
    }
}
