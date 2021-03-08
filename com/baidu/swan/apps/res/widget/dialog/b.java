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
    private ViewGroup bLa;
    private FrameLayout dCA;
    private FrameLayout dCB;
    private View dCC;
    private List<a> dCD;
    private int dCE;
    protected Context mContext;

    /* loaded from: classes8.dex */
    public interface c {
        void az(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context) {
        super(context, a.i.NoTitleDialog);
        this.dCD = new ArrayList();
        this.dCE = 2;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        createView();
        aHU().aG(this.bLa);
    }

    private void createView() {
        this.mContext = getContext();
        this.bLa = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_hv_dialog, aHU().aId(), false);
        this.dCA = (FrameLayout) this.bLa.findViewById(a.f.hv_content);
        this.dCC = this.bLa.findViewById(a.f.hv_divider);
        this.dCB = (FrameLayout) this.bLa.findViewById(a.f.hv_btn_content);
        View D = D(this.dCA);
        if (D != null) {
            this.dCA.addView(D);
        }
        aHO();
        aQ(this.dCD);
    }

    private void aHO() {
        this.dCC.setBackgroundColor(getContext().getResources().getColor(a.c.aiapps_dialog_gray));
    }

    protected View D(ViewGroup viewGroup) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(List<a> list) {
        this.dCD.clear();
        if (list != null) {
            this.dCD.addAll(list);
        }
    }

    private void aQ(List<a> list) {
        if (list != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            if (list.size() > this.dCE) {
                linearLayout.setOrientation(1);
            } else {
                linearLayout.setOrientation(0);
            }
            for (int i = 0; i < list.size(); i++) {
                linearLayout.addView(a(list.get(i), linearLayout));
                if (i < list.size() - 1) {
                    if (list.size() > this.dCE) {
                        linearLayout.addView(iM(1));
                    } else {
                        linearLayout.addView(iM(0));
                    }
                }
            }
            this.dCB.removeAllViews();
            this.dCB.addView(linearLayout);
        }
    }

    private LinearLayout a(a aVar, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
        linearLayout2.setBackground(getContext().getResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
        new d(linearLayout2, this).b(aVar);
        return linearLayout2;
    }

    private View iM(int i) {
        View view = new View(this.mContext);
        view.setBackgroundColor(this.dCA.getResources().getColor(a.c.aiapps_dialog_gray));
        if (i == 1) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        } else {
            view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
        }
        return view;
    }

    /* loaded from: classes8.dex */
    public class d {
        TextView bbF;
        TextView dCI;
        LinearLayout dCJ;
        b dCK;

        public d(View view, b bVar) {
            if (view != null) {
                this.bbF = (TextView) view.findViewById(a.f.hv_btn_text);
                this.dCI = (TextView) view.findViewById(a.f.hv_btn_subtext);
                this.dCJ = (LinearLayout) view;
                this.dCK = bVar;
            }
        }

        public void b(final a aVar) {
            if (aVar != null) {
                this.bbF.setText(aVar.mText);
                if (aVar.dCF > 0) {
                    this.bbF.setTextColor(b.this.dCA.getResources().getColor(aVar.dCF));
                }
                if (!TextUtils.isEmpty(aVar.mSubText)) {
                    this.dCI.setVisibility(0);
                    this.dCI.setText(aVar.mSubText);
                } else {
                    this.dCI.setVisibility(8);
                }
                if (aVar.dCG > 0) {
                    this.dCI.setTextColor(b.this.dCA.getResources().getColor(aVar.dCG));
                }
                this.dCJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.b.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.dCK.dismiss();
                        if (aVar.dCH != null) {
                            aVar.dCH.az(view);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.baidu.swan.apps.res.widget.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0458b extends g.a {
        private List<a> list;

        public C0458b(Context context) {
            super(context);
            this.list = new ArrayList();
            gW(false);
            gS(false);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g cI(Context context) {
            return new b(context);
        }

        public C0458b a(a aVar) {
            if (aVar != null) {
                this.list.add(aVar);
            }
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g aqn() {
            b bVar = (b) super.aqn();
            bVar.aP(this.list);
            return bVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        public int dCF;
        public int dCG = -1;
        public c dCH;
        public CharSequence mSubText;
        public CharSequence mText;

        public a(CharSequence charSequence, int i, c cVar) {
            this.dCF = -1;
            this.mText = charSequence;
            this.dCF = i;
            this.dCH = cVar;
        }
    }
}
