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
/* loaded from: classes9.dex */
public class b extends g {
    private ViewGroup bJA;
    private FrameLayout dAZ;
    private FrameLayout dBa;
    private View dBb;
    private List<a> dBc;
    private int dBd;
    protected Context mContext;

    /* loaded from: classes9.dex */
    public interface c {
        void az(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context) {
        super(context, a.i.NoTitleDialog);
        this.dBc = new ArrayList();
        this.dBd = 2;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        createView();
        aHR().aG(this.bJA);
    }

    private void createView() {
        this.mContext = getContext();
        this.bJA = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_hv_dialog, aHR().aIa(), false);
        this.dAZ = (FrameLayout) this.bJA.findViewById(a.f.hv_content);
        this.dBb = this.bJA.findViewById(a.f.hv_divider);
        this.dBa = (FrameLayout) this.bJA.findViewById(a.f.hv_btn_content);
        View D = D(this.dAZ);
        if (D != null) {
            this.dAZ.addView(D);
        }
        aHL();
        aQ(this.dBc);
    }

    private void aHL() {
        this.dBb.setBackgroundColor(getContext().getResources().getColor(a.c.aiapps_dialog_gray));
    }

    protected View D(ViewGroup viewGroup) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(List<a> list) {
        this.dBc.clear();
        if (list != null) {
            this.dBc.addAll(list);
        }
    }

    private void aQ(List<a> list) {
        if (list != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            if (list.size() > this.dBd) {
                linearLayout.setOrientation(1);
            } else {
                linearLayout.setOrientation(0);
            }
            for (int i = 0; i < list.size(); i++) {
                linearLayout.addView(a(list.get(i), linearLayout));
                if (i < list.size() - 1) {
                    if (list.size() > this.dBd) {
                        linearLayout.addView(iL(1));
                    } else {
                        linearLayout.addView(iL(0));
                    }
                }
            }
            this.dBa.removeAllViews();
            this.dBa.addView(linearLayout);
        }
    }

    private LinearLayout a(a aVar, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
        linearLayout2.setBackground(getContext().getResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
        new d(linearLayout2, this).b(aVar);
        return linearLayout2;
    }

    private View iL(int i) {
        View view = new View(this.mContext);
        view.setBackgroundColor(this.dAZ.getResources().getColor(a.c.aiapps_dialog_gray));
        if (i == 1) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        } else {
            view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
        }
        return view;
    }

    /* loaded from: classes9.dex */
    public class d {
        TextView bae;
        TextView dBh;
        LinearLayout dBi;
        b dBj;

        public d(View view, b bVar) {
            if (view != null) {
                this.bae = (TextView) view.findViewById(a.f.hv_btn_text);
                this.dBh = (TextView) view.findViewById(a.f.hv_btn_subtext);
                this.dBi = (LinearLayout) view;
                this.dBj = bVar;
            }
        }

        public void b(final a aVar) {
            if (aVar != null) {
                this.bae.setText(aVar.mText);
                if (aVar.dBe > 0) {
                    this.bae.setTextColor(b.this.dAZ.getResources().getColor(aVar.dBe));
                }
                if (!TextUtils.isEmpty(aVar.mSubText)) {
                    this.dBh.setVisibility(0);
                    this.dBh.setText(aVar.mSubText);
                } else {
                    this.dBh.setVisibility(8);
                }
                if (aVar.dBf > 0) {
                    this.dBh.setTextColor(b.this.dAZ.getResources().getColor(aVar.dBf));
                }
                this.dBi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.b.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.dBj.dismiss();
                        if (aVar.dBg != null) {
                            aVar.dBg.az(view);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.baidu.swan.apps.res.widget.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0452b extends g.a {
        private List<a> list;

        public C0452b(Context context) {
            super(context);
            this.list = new ArrayList();
            gW(false);
            gS(false);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g cJ(Context context) {
            return new b(context);
        }

        public C0452b a(a aVar) {
            if (aVar != null) {
                this.list.add(aVar);
            }
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g aqk() {
            b bVar = (b) super.aqk();
            bVar.aP(this.list);
            return bVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        public int dBe;
        public int dBf = -1;
        public c dBg;
        public CharSequence mSubText;
        public CharSequence mText;

        public a(CharSequence charSequence, int i, c cVar) {
            this.dBe = -1;
            this.mText = charSequence;
            this.dBe = i;
            this.dBg = cVar;
        }
    }
}
