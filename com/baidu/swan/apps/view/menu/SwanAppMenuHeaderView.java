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
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.s;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
/* loaded from: classes7.dex */
public class SwanAppMenuHeaderView extends FrameLayout implements View.OnTouchListener {
    private TextView cVA;
    private FrameLayout cVB;
    private a cVC;
    private b cVD;
    private int cVE;
    private int cVF;
    private boolean cVG;
    private int cVH;
    private int cVI;
    private Runnable cVJ;
    private SwanAppRoundedImageView caJ;

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
        this.cVG = false;
        this.cVJ = new Runnable() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.3
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppMenuHeaderView.this.cVD != null) {
                    SwanAppMenuHeaderView.this.cVG = SwanAppMenuHeaderView.this.cVD.onLongClick(SwanAppMenuHeaderView.this.cVB);
                }
            }
        };
        aj(inflate(context, a.g.swan_app_menu_header_view, this));
    }

    private void aj(View view) {
        this.cVB = (FrameLayout) view.findViewById(a.f.header_content);
        this.caJ = (SwanAppRoundedImageView) view.findViewById(a.f.swan_app_icon);
        this.cVA = (TextView) view.findViewById(a.f.swan_app_title);
        b.a arz = d.arr().arn().arz();
        this.caJ.setImageBitmap(al.a(arz.getIconUrl(), "SwanAppMenuHeaderView", false, new s.a() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.1
            @Override // com.baidu.swan.apps.aq.s.a
            public void h(String str, Bitmap bitmap) {
                if (bitmap != null && SwanAppMenuHeaderView.this.caJ != null) {
                    SwanAppMenuHeaderView.this.caJ.setImageBitmap(bitmap);
                }
            }
        }));
        this.cVA.setText(arz.aee());
        this.cVB.setOnTouchListener(this);
        this.cVB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SwanAppMenuHeaderView.this.cVC != null) {
                    SwanAppMenuHeaderView.this.cVC.onClick(view2);
                    view2.setPressed(true);
                }
            }
        });
    }

    public void setOnMenuHeaderClickListener(a aVar) {
        this.cVC = aVar;
    }

    public void setOnMenuHeaderLongClickListener(b bVar) {
        this.cVD = bVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.cVH = (int) x;
                this.cVI = (int) y;
                return false;
            case 1:
            default:
                return false;
            case 2:
                if (Math.abs(this.cVH - x) <= 10.0f && Math.abs(this.cVI - y) <= 10.0f) {
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
                if (this.cVD == null) {
                    return super.onTouchEvent(motionEvent);
                }
                removeCallbacks(this.cVJ);
                this.cVG = false;
                this.cVE = x;
                this.cVF = y;
                postDelayed(this.cVJ, 3000L);
                view.setPressed(true);
                break;
            case 1:
                removeCallbacks(this.cVJ);
                if (!this.cVG && this.cVC != null) {
                    this.cVC.onClick(this.cVB);
                }
                this.cVG = false;
                view.setPressed(false);
                return false;
            case 2:
                if (Math.abs(this.cVE - x) > 10 || Math.abs(this.cVF - y) > 10) {
                    removeCallbacks(this.cVJ);
                    this.cVG = false;
                    break;
                }
                break;
            case 3:
                removeCallbacks(this.cVJ);
                this.cVG = false;
                view.setPressed(false);
                break;
        }
        return true;
    }
}
