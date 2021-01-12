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
/* loaded from: classes8.dex */
public class b extends g {
    private ViewGroup bFQ;
    private FrameLayout dyU;
    private FrameLayout dyV;
    private View dyW;
    private List<a> dyX;
    private int dyY;
    protected Context mContext;

    /* loaded from: classes8.dex */
    public interface c {
        void aD(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context) {
        super(context, a.i.NoTitleDialog);
        this.dyX = new ArrayList();
        this.dyY = 2;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        createView();
        aHy().aK(this.bFQ);
    }

    private void createView() {
        this.mContext = getContext();
        this.bFQ = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_hv_dialog, aHy().aHH(), false);
        this.dyU = (FrameLayout) this.bFQ.findViewById(a.f.hv_content);
        this.dyW = this.bFQ.findViewById(a.f.hv_divider);
        this.dyV = (FrameLayout) this.bFQ.findViewById(a.f.hv_btn_content);
        View F = F(this.dyU);
        if (F != null) {
            this.dyU.addView(F);
        }
        aHs();
        aV(this.dyX);
    }

    private void aHs() {
        this.dyW.setBackgroundColor(getContext().getResources().getColor(a.c.aiapps_dialog_gray));
    }

    protected View F(ViewGroup viewGroup) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(List<a> list) {
        this.dyX.clear();
        if (list != null) {
            this.dyX.addAll(list);
        }
    }

    private void aV(List<a> list) {
        if (list != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            if (list.size() > this.dyY) {
                linearLayout.setOrientation(1);
            } else {
                linearLayout.setOrientation(0);
            }
            for (int i = 0; i < list.size(); i++) {
                linearLayout.addView(a(list.get(i), linearLayout));
                if (i < list.size() - 1) {
                    if (list.size() > this.dyY) {
                        linearLayout.addView(iI(1));
                    } else {
                        linearLayout.addView(iI(0));
                    }
                }
            }
            this.dyV.removeAllViews();
            this.dyV.addView(linearLayout);
        }
    }

    private LinearLayout a(a aVar, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
        linearLayout2.setBackground(getContext().getResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
        new d(linearLayout2, this).b(aVar);
        return linearLayout2;
    }

    private View iI(int i) {
        View view = new View(this.mContext);
        view.setBackgroundColor(this.dyU.getResources().getColor(a.c.aiapps_dialog_gray));
        if (i == 1) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        } else {
            view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
        }
        return view;
    }

    /* loaded from: classes8.dex */
    public class d {
        TextView aWY;
        TextView dzc;
        LinearLayout dzd;
        b dze;

        public d(View view, b bVar) {
            if (view != null) {
                this.aWY = (TextView) view.findViewById(a.f.hv_btn_text);
                this.dzc = (TextView) view.findViewById(a.f.hv_btn_subtext);
                this.dzd = (LinearLayout) view;
                this.dze = bVar;
            }
        }

        public void b(final a aVar) {
            if (aVar != null) {
                this.aWY.setText(aVar.mText);
                if (aVar.dyZ > 0) {
                    this.aWY.setTextColor(b.this.dyU.getResources().getColor(aVar.dyZ));
                }
                if (!TextUtils.isEmpty(aVar.mSubText)) {
                    this.dzc.setVisibility(0);
                    this.dzc.setText(aVar.mSubText);
                } else {
                    this.dzc.setVisibility(8);
                }
                if (aVar.dza > 0) {
                    this.dzc.setTextColor(b.this.dyU.getResources().getColor(aVar.dza));
                }
                this.dzd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.b.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.dze.dismiss();
                        if (aVar.dzb != null) {
                            aVar.dzb.aD(view);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.baidu.swan.apps.res.widget.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0455b extends g.a {
        private List<a> list;

        public C0455b(Context context) {
            super(context);
            this.list = new ArrayList();
            gU(false);
            gQ(false);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g cK(Context context) {
            return new b(context);
        }

        public C0455b a(a aVar) {
            if (aVar != null) {
                this.list.add(aVar);
            }
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g apM() {
            b bVar = (b) super.apM();
            bVar.aU(this.list);
            return bVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        public int dyZ;
        public int dza = -1;
        public c dzb;
        public CharSequence mSubText;
        public CharSequence mText;

        public a(CharSequence charSequence, int i, c cVar) {
            this.dyZ = -1;
            this.mText = charSequence;
            this.dyZ = i;
            this.dzb = cVar;
        }
    }
}
