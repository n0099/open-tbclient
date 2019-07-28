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
    private ViewGroup aNE;
    private FrameLayout aNF;
    private FrameLayout aNG;
    private View aNH;
    private List<a> aNI;
    private int aNJ;
    protected Context mContext;

    /* loaded from: classes2.dex */
    public interface c {
        void W(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context) {
        super(context, a.i.NoTitleDialog);
        this.aNI = new ArrayList();
        this.aNJ = 2;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        createView();
        Ls().af(this.aNE);
    }

    private void createView() {
        this.mContext = getContext();
        this.aNE = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_hv_dialog, Ls().LA(), false);
        this.aNF = (FrameLayout) this.aNE.findViewById(a.f.hv_content);
        this.aNH = this.aNE.findViewById(a.f.hv_divider);
        this.aNG = (FrameLayout) this.aNE.findViewById(a.f.hv_btn_content);
        View f = f(this.aNF);
        if (f != null) {
            this.aNF.addView(f);
        }
        Ln();
        A(this.aNI);
    }

    private void Ln() {
        this.aNH.setBackgroundColor(getContext().getResources().getColor(a.c.aiapps_dialog_gray));
    }

    protected View f(ViewGroup viewGroup) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(List<a> list) {
        this.aNI.clear();
        if (list != null) {
            this.aNI.addAll(list);
        }
    }

    private void A(List<a> list) {
        if (list != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            if (list.size() > this.aNJ) {
                linearLayout.setOrientation(1);
            } else {
                linearLayout.setOrientation(0);
            }
            for (int i = 0; i < list.size(); i++) {
                linearLayout.addView(a(list.get(i), linearLayout));
                if (i < list.size() - 1) {
                    if (list.size() > this.aNJ) {
                        linearLayout.addView(m16do(1));
                    } else {
                        linearLayout.addView(m16do(0));
                    }
                }
            }
            this.aNG.removeAllViews();
            this.aNG.addView(linearLayout);
        }
    }

    private LinearLayout a(a aVar, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
        linearLayout2.setBackground(getContext().getResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
        new d(linearLayout2, this).b(aVar);
        return linearLayout2;
    }

    /* renamed from: do  reason: not valid java name */
    private View m16do(int i) {
        View view = new View(this.mContext);
        view.setBackgroundColor(this.aNF.getResources().getColor(a.c.aiapps_dialog_gray));
        if (i == 1) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        } else {
            view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
        }
        return view;
    }

    /* loaded from: classes2.dex */
    public class d {
        TextView aNN;
        LinearLayout aNO;
        b aNP;
        TextView text;

        public d(View view, b bVar) {
            if (view != null) {
                this.text = (TextView) view.findViewById(a.f.hv_btn_text);
                this.aNN = (TextView) view.findViewById(a.f.hv_btn_subtext);
                this.aNO = (LinearLayout) view;
                this.aNP = bVar;
            }
        }

        public void b(final a aVar) {
            if (aVar != null) {
                this.text.setText(aVar.mText);
                if (aVar.aNK > 0) {
                    this.text.setTextColor(b.this.aNF.getResources().getColor(aVar.aNK));
                }
                if (!TextUtils.isEmpty(aVar.mSubText)) {
                    this.aNN.setVisibility(0);
                    this.aNN.setText(aVar.mSubText);
                } else {
                    this.aNN.setVisibility(8);
                }
                if (aVar.aNL > 0) {
                    this.aNN.setTextColor(b.this.aNF.getResources().getColor(aVar.aNL));
                }
                this.aNO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.b.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.aNP.dismiss();
                        if (aVar.aNM != null) {
                            aVar.aNM.W(view);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.baidu.swan.apps.res.widget.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0171b extends g.a {
        private List<a> list;

        public C0171b(Context context) {
            super(context);
            this.list = new ArrayList();
            ch(false);
            cd(false);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aU(Context context) {
            return new b(context);
        }

        public C0171b a(a aVar) {
            if (aVar != null) {
                this.list.add(aVar);
            }
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g AX() {
            b bVar = (b) super.AX();
            bVar.z(this.list);
            return bVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        public int aNK;
        public int aNL = -1;
        public c aNM;
        public CharSequence mSubText;
        public CharSequence mText;

        public a(CharSequence charSequence, int i, c cVar) {
            this.aNK = -1;
            this.mText = charSequence;
            this.aNK = i;
            this.aNM = cVar;
        }
    }
}
