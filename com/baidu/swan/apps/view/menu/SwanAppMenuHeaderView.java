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
    private int WV;
    private SwanAppRoundedImageView cOI;
    private TextView dQE;
    private View dQF;
    private TextView dQG;
    private a dQH;
    private b dQI;
    private a dQJ;
    private int dQK;
    private boolean dQL;
    private int dQM;
    private int dQN;
    private Runnable dQO;

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
        this.dQL = false;
        this.dQO = new Runnable() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.4
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuHeaderView.this.dQI != null) {
                    SwanAppMenuHeaderView.this.dQL = SwanAppMenuHeaderView.this.dQI.onLongClick(SwanAppMenuHeaderView.this.dQF);
                }
            }
        };
        ap(inflate(context, a.g.swan_app_menu_header_view, this));
        setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.mX(d.aIn().getAppId()));
    }

    private void ap(View view) {
        this.dQF = view.findViewById(a.f.header_content);
        this.cOI = (SwanAppRoundedImageView) view.findViewById(a.f.swan_app_icon);
        this.dQE = (TextView) view.findViewById(a.f.swan_app_title);
        this.dQG = (TextView) view.findViewById(a.f.btn_item_attenion);
        b.a aIv = d.aIn().aIj().aIv();
        this.cOI.setImageBitmap(ak.a(aIv.getIconUrl(), "SwanAppMenuHeaderView", false, new s.a() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.1
            @Override // com.baidu.swan.apps.ao.s.a
            public void g(String str, Bitmap bitmap) {
                if (bitmap != null && SwanAppMenuHeaderView.this.cOI != null) {
                    SwanAppMenuHeaderView.this.cOI.setImageBitmap(bitmap);
                }
            }
        }));
        this.dQE.setText(aIv.asE());
        this.dQF.setOnTouchListener(this);
        this.dQF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.dQH != null) {
                    SwanAppMenuHeaderView.this.dQH.onClick(view2);
                    view2.setPressed(true);
                }
            }
        });
        this.dQG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.dQJ != null) {
                    SwanAppMenuHeaderView.this.dQJ.onClick(view2);
                }
            }
        });
    }

    public void setOnMenuHeaderClickListener(a aVar) {
        this.dQH = aVar;
    }

    public void setOnAttentionBtnClickListener(a aVar) {
        this.dQJ = aVar;
    }

    public void setAttentionBtnShow(boolean z) {
        this.dQG.setVisibility(z ? 0 : 8);
    }

    public void setAttentionBtnStates(boolean z) {
        if (!z) {
            this.dQG.setText(a.h.aiapps_favorite_guide_add);
            this.dQG.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_attention_btn_bg));
            this.dQG.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_attention_btn_text_color));
            return;
        }
        this.dQG.setText(a.h.swanapp_favored);
        this.dQG.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_cancel_attention_btn_bg));
        this.dQG.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_cancel_attention_btn_text_color));
    }

    public void setOnMenuHeaderLongClickListener(b bVar) {
        this.dQI = bVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.dQM = (int) x;
                this.dQN = (int) y;
                return false;
            case 1:
            default:
                return false;
            case 2:
                if (Math.abs(this.dQM - x) <= 10.0f && Math.abs(this.dQN - y) <= 10.0f) {
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
                if (this.dQI == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.dQO);
                this.dQL = false;
                this.dQK = x;
                this.WV = y;
                postDelayed(this.dQO, IMConnection.RETRY_DELAY_TIMES);
                view.setPressed(true);
                break;
            case 1:
                removeCallbacks(this.dQO);
                if (!this.dQL && this.dQH != null) {
                    this.dQH.onClick(this.dQF);
                }
                this.dQL = false;
                view.setPressed(false);
                return false;
            case 2:
                if (Math.abs(this.dQK - x) > 10 || Math.abs(this.WV - y) > 10) {
                    removeCallbacks(this.dQO);
                    this.dQL = false;
                    break;
                }
                break;
            case 3:
                removeCallbacks(this.dQO);
                this.dQL = false;
                view.setPressed(false);
                break;
        }
        return true;
    }
}
