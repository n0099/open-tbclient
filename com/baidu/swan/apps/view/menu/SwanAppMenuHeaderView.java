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
/* loaded from: classes25.dex */
public class SwanAppMenuHeaderView extends FrameLayout implements View.OnTouchListener {
    private int WZ;
    private SwanAppRoundedImageView cOz;
    private a dMA;
    private b dMB;
    private a dMC;
    private int dMD;
    private boolean dME;
    private int dMF;
    private int dMG;
    private Runnable dMH;
    private TextView dMx;
    private View dMy;
    private TextView dMz;

    /* loaded from: classes25.dex */
    public interface a {
        void onClick(View view);
    }

    /* loaded from: classes25.dex */
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
        this.dME = false;
        this.dMH = new Runnable() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.4
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuHeaderView.this.dMB != null) {
                    SwanAppMenuHeaderView.this.dME = SwanAppMenuHeaderView.this.dMB.onLongClick(SwanAppMenuHeaderView.this.dMy);
                }
            }
        };
        an(inflate(context, a.g.swan_app_menu_header_view, this));
        setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.or(d.aJQ().getAppId()));
    }

    private void an(View view) {
        this.dMy = view.findViewById(a.f.header_content);
        this.cOz = (SwanAppRoundedImageView) view.findViewById(a.f.swan_app_icon);
        this.dMx = (TextView) view.findViewById(a.f.swan_app_title);
        this.dMz = (TextView) view.findViewById(a.f.btn_item_attenion);
        b.a aJY = d.aJQ().aJM().aJY();
        this.cOz.setImageBitmap(ak.a(aJY.getIconUrl(), "SwanAppMenuHeaderView", false, new s.a() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.1
            @Override // com.baidu.swan.apps.ap.s.a
            public void g(String str, Bitmap bitmap) {
                if (bitmap != null && SwanAppMenuHeaderView.this.cOz != null) {
                    SwanAppMenuHeaderView.this.cOz.setImageBitmap(bitmap);
                }
            }
        }));
        this.dMx.setText(aJY.avf());
        this.dMy.setOnTouchListener(this);
        this.dMy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.dMA != null) {
                    SwanAppMenuHeaderView.this.dMA.onClick(view2);
                    view2.setPressed(true);
                }
            }
        });
        this.dMz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.dMC != null) {
                    SwanAppMenuHeaderView.this.dMC.onClick(view2);
                }
            }
        });
    }

    public void setOnMenuHeaderClickListener(a aVar) {
        this.dMA = aVar;
    }

    public void setOnAttentionBtnClickListener(a aVar) {
        this.dMC = aVar;
    }

    public void setAttentionBtnShow(boolean z) {
        this.dMz.setVisibility(z ? 0 : 8);
    }

    public void setAttentionBtnStates(boolean z) {
        if (!z) {
            this.dMz.setText(a.h.aiapps_favorite_guide_add);
            this.dMz.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_attention_btn_bg));
            this.dMz.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_attention_btn_text_color));
            return;
        }
        this.dMz.setText(a.h.swanapp_favored);
        this.dMz.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_cancel_attention_btn_bg));
        this.dMz.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_cancel_attention_btn_text_color));
    }

    public void setOnMenuHeaderLongClickListener(b bVar) {
        this.dMB = bVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.dMF = (int) x;
                this.dMG = (int) y;
                return false;
            case 1:
            default:
                return false;
            case 2:
                if (Math.abs(this.dMF - x) <= 10.0f && Math.abs(this.dMG - y) <= 10.0f) {
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
                if (this.dMB == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.dMH);
                this.dME = false;
                this.dMD = x;
                this.WZ = y;
                postDelayed(this.dMH, IMConnection.RETRY_DELAY_TIMES);
                view.setPressed(true);
                break;
            case 1:
                removeCallbacks(this.dMH);
                if (!this.dME && this.dMA != null) {
                    this.dMA.onClick(this.dMy);
                }
                this.dME = false;
                view.setPressed(false);
                return false;
            case 2:
                if (Math.abs(this.dMD - x) > 10 || Math.abs(this.WZ - y) > 10) {
                    removeCallbacks(this.dMH);
                    this.dME = false;
                    break;
                }
                break;
            case 3:
                removeCallbacks(this.dMH);
                this.dME = false;
                view.setPressed(false);
                break;
        }
        return true;
    }
}
