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
    private SwanAppRoundedImageView cgG;
    private TextView deI;
    private View deJ;
    private TextView deK;
    private a deL;
    private b deM;
    private a deN;
    private int deO;
    private int deP;
    private boolean deQ;
    private int deR;
    private int deS;
    private Runnable deT;

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
        this.deQ = false;
        this.deT = new Runnable() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.4
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuHeaderView.this.deM != null) {
                    SwanAppMenuHeaderView.this.deQ = SwanAppMenuHeaderView.this.deM.onLongClick(SwanAppMenuHeaderView.this.deJ);
                }
            }
        };
        ak(inflate(context, a.g.swan_app_menu_header_view, this));
        setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.mc(d.azE().getAppId()));
    }

    private void ak(View view) {
        this.deJ = view.findViewById(a.f.header_content);
        this.cgG = (SwanAppRoundedImageView) view.findViewById(a.f.swan_app_icon);
        this.deI = (TextView) view.findViewById(a.f.swan_app_title);
        this.deK = (TextView) view.findViewById(a.f.btn_item_attenion);
        b.a azM = d.azE().azA().azM();
        this.cgG.setImageBitmap(ak.a(azM.getIconUrl(), "SwanAppMenuHeaderView", false, new s.a() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.1
            @Override // com.baidu.swan.apps.ap.s.a
            public void h(String str, Bitmap bitmap) {
                if (bitmap != null && SwanAppMenuHeaderView.this.cgG != null) {
                    SwanAppMenuHeaderView.this.cgG.setImageBitmap(bitmap);
                }
            }
        }));
        this.deI.setText(azM.akO());
        this.deJ.setOnTouchListener(this);
        this.deJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.deL != null) {
                    SwanAppMenuHeaderView.this.deL.onClick(view2);
                    view2.setPressed(true);
                }
            }
        });
        this.deK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.deN != null) {
                    SwanAppMenuHeaderView.this.deN.onClick(view2);
                }
            }
        });
    }

    public void setOnMenuHeaderClickListener(a aVar) {
        this.deL = aVar;
    }

    public void setOnAttentionBtnClickListener(a aVar) {
        this.deN = aVar;
    }

    public void setAttentionBtnShow(boolean z) {
        this.deK.setVisibility(z ? 0 : 8);
    }

    public void setAttentionBtnStates(boolean z) {
        if (!z) {
            this.deK.setText(a.h.aiapps_favorite_guide_add);
            this.deK.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_attention_btn_bg));
            this.deK.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_attention_btn_text_color));
            return;
        }
        this.deK.setText(a.h.swanapp_favored);
        this.deK.setBackground(com.baidu.swan.support.v4.a.a.getDrawable(getContext(), a.e.swanapp_cancel_attention_btn_bg));
        this.deK.setTextColor(com.baidu.swan.support.v4.a.a.getColorStateList(getContext(), a.c.swanapp_cancel_attention_btn_text_color));
    }

    public void setOnMenuHeaderLongClickListener(b bVar) {
        this.deM = bVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.deR = (int) x;
                this.deS = (int) y;
                return false;
            case 1:
            default:
                return false;
            case 2:
                if (Math.abs(this.deR - x) <= 10.0f && Math.abs(this.deS - y) <= 10.0f) {
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
                if (this.deM == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.deT);
                this.deQ = false;
                this.deO = x;
                this.deP = y;
                postDelayed(this.deT, IMConnection.RETRY_DELAY_TIMES);
                view.setPressed(true);
                break;
            case 1:
                removeCallbacks(this.deT);
                if (!this.deQ && this.deL != null) {
                    this.deL.onClick(this.deJ);
                }
                this.deQ = false;
                view.setPressed(false);
                return false;
            case 2:
                if (Math.abs(this.deO - x) > 10 || Math.abs(this.deP - y) > 10) {
                    removeCallbacks(this.deT);
                    this.deQ = false;
                    break;
                }
                break;
            case 3:
                removeCallbacks(this.deT);
                this.deQ = false;
                view.setPressed(false);
                break;
        }
        return true;
    }
}
