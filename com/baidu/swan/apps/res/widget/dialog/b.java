package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends g {
    private ViewGroup anN;
    private FrameLayout bgS;
    private FrameLayout bgT;
    private View bgU;
    private List<a> bgV;
    private int bgW;
    protected Context mContext;

    /* loaded from: classes2.dex */
    public interface c {
        void ac(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context) {
        super(context, a.i.NoTitleDialog);
        this.bgV = new ArrayList();
        this.bgW = 2;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        nw();
        Qq().al(this.anN);
    }

    private void nw() {
        this.mContext = getContext();
        this.anN = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_hv_dialog, Qq().Qy(), false);
        this.bgS = (FrameLayout) this.anN.findViewById(a.f.hv_content);
        this.bgU = this.anN.findViewById(a.f.hv_divider);
        this.bgT = (FrameLayout) this.anN.findViewById(a.f.hv_btn_content);
        View i = i(this.bgS);
        if (i != null) {
            this.bgS.addView(i);
        }
        Ql();
        Z(this.bgV);
    }

    private void Ql() {
        this.bgU.setBackgroundColor(getContext().getResources().getColor(a.c.aiapps_dialog_gray));
    }

    protected View i(ViewGroup viewGroup) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(List<a> list) {
        this.bgV.clear();
        if (list != null) {
            this.bgV.addAll(list);
        }
    }

    private void Z(List<a> list) {
        if (list != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            if (list.size() > this.bgW) {
                linearLayout.setOrientation(1);
            } else {
                linearLayout.setOrientation(0);
            }
            for (int i = 0; i < list.size(); i++) {
                linearLayout.addView(a(list.get(i), linearLayout));
                if (i < list.size() - 1) {
                    if (list.size() > this.bgW) {
                        linearLayout.addView(ek(1));
                    } else {
                        linearLayout.addView(ek(0));
                    }
                }
            }
            this.bgT.removeAllViews();
            this.bgT.addView(linearLayout);
        }
    }

    private LinearLayout a(a aVar, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
        linearLayout2.setBackground(getContext().getResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
        new d(linearLayout2, this).b(aVar);
        return linearLayout2;
    }

    private View ek(int i) {
        View view = new View(this.mContext);
        view.setBackgroundColor(this.bgS.getResources().getColor(a.c.aiapps_dialog_gray));
        if (i == 1) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        } else {
            view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
        }
        return view;
    }

    /* loaded from: classes2.dex */
    public class d {
        TextView Yu;
        TextView bha;
        LinearLayout bhb;
        b bhc;

        public d(View view, b bVar) {
            if (view != null) {
                this.Yu = (TextView) view.findViewById(a.f.hv_btn_text);
                this.bha = (TextView) view.findViewById(a.f.hv_btn_subtext);
                this.bhb = (LinearLayout) view;
                this.bhc = bVar;
            }
        }

        public void b(final a aVar) {
            if (aVar != null) {
                this.Yu.setText(aVar.mText);
                if (aVar.bgX > 0) {
                    this.Yu.setTextColor(b.this.bgS.getResources().getColor(aVar.bgX));
                }
                if (!TextUtils.isEmpty(aVar.mSubText)) {
                    this.bha.setVisibility(0);
                    this.bha.setText(aVar.mSubText);
                } else {
                    this.bha.setVisibility(8);
                }
                if (aVar.bgY > 0) {
                    this.bha.setTextColor(b.this.bgS.getResources().getColor(aVar.bgY));
                }
                this.bhb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.b.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.bhc.dismiss();
                        if (aVar.bgZ != null) {
                            aVar.bgZ.ac(view);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.baidu.swan.apps.res.widget.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0212b extends g.a {
        private List<a> list;

        public C0212b(Context context) {
            super(context);
            this.list = new ArrayList();
            cy(false);
            cu(false);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aW(Context context) {
            return new b(context);
        }

        public C0212b a(a aVar) {
            if (aVar != null) {
                this.list.add(aVar);
            }
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g FX() {
            b bVar = (b) super.FX();
            bVar.Y(this.list);
            return bVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        public int bgX;
        public int bgY = -1;
        public c bgZ;
        public CharSequence mSubText;
        public CharSequence mText;

        public a(CharSequence charSequence, int i, c cVar) {
            this.bgX = -1;
            this.mText = charSequence;
            this.bgX = i;
            this.bgZ = cVar;
        }
    }
}
