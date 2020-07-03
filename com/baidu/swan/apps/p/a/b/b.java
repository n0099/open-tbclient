package com.baidu.swan.apps.p.a.b;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.aj;
/* loaded from: classes11.dex */
public class b extends PopupWindow {
    private int bUU;
    private a ckj;
    private String[] ckp;
    private com.baidu.swan.apps.framework.a cks;
    private Activity mActivity;

    /* loaded from: classes11.dex */
    public interface a {
        void Wy();

        void aft();

        void eH(int i);

        void kE(String str);
    }

    public b(@NonNull Activity activity, int i, @NonNull a aVar) {
        super(activity);
        this.ckp = new String[12];
        this.cks = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.p.a.b.b.4
            @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
            public boolean onKeyDown(int i2, KeyEvent keyEvent) {
                if (i2 == 4) {
                    b.this.dismiss();
                    return true;
                }
                return false;
            }
        };
        this.ckj = aVar;
        fC(i);
        H(activity);
    }

    private void fC(int i) {
        for (int i2 = 0; i2 < 9; i2++) {
            this.ckp[i2] = String.valueOf(i2 + 1);
        }
        if (i == 1) {
            this.ckp[9] = "X";
        } else if (i == 0) {
            this.ckp[9] = "";
        } else if (i == 2) {
            this.ckp[9] = ".";
        }
        this.ckp[10] = "0";
    }

    private void H(@NonNull Activity activity) {
        this.mActivity = activity;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(a.g.aiapps_keyboard_layout, (ViewGroup) null);
        this.bUU = activity.getResources().getDimensionPixelOffset(a.d.aiapps_keyboard_total_height);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        final GridView gridView = (GridView) linearLayout.findViewById(a.f.keyboard_grid_view);
        gridView.setAdapter((ListAdapter) new com.baidu.swan.apps.p.a.b.a(activity, this.ckp));
        final AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.p.a.b.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i <= b.this.ckp.length) {
                    if (i == 11) {
                        if (b.this.ckj != null) {
                            b.this.ckj.aft();
                        }
                    } else if (b.this.ckj != null) {
                        b.this.ckj.kE(b.this.ckp[i]);
                    }
                }
            }
        };
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.p.a.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                int childCount = gridView.getChildCount();
                if (childCount > 0) {
                    gridView.setClickable(false);
                    for (int i = 0; i < childCount; i++) {
                        View childAt = gridView.getChildAt(i);
                        childAt.setTag(Integer.valueOf(i));
                        childAt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.p.a.b.b.2.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                int intValue = ((Integer) view.getTag()).intValue();
                                onItemClickListener.onItemClick(gridView, view, intValue, intValue);
                            }
                        });
                    }
                    return;
                }
                gridView.setOnItemClickListener(onItemClickListener);
            }
        });
        ImageView imageView = (ImageView) linearLayout.findViewById(a.f.close_btn);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.p.a.b.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.dismiss();
            }
        });
        imageView.setClickable(true);
        setContentView(linearLayout);
        setWidth(-1);
        setHeight(this.bUU);
        setBackgroundDrawable(new BitmapDrawable());
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        if (this.mActivity instanceof SwanAppActivity) {
            ((SwanAppActivity) this.mActivity).b(this.cks);
        }
        if (this.ckj != null) {
            this.ckj.Wy();
        }
    }

    public void show() {
        if (!isShowing()) {
            showAtLocation(this.mActivity.getWindow().getDecorView(), 80, 0, 0);
            if (this.mActivity instanceof SwanAppActivity) {
                ((SwanAppActivity) this.mActivity).a(this.cks);
            }
            if (this.ckj != null) {
                this.ckj.eH(this.bUU);
            }
        }
    }
}
