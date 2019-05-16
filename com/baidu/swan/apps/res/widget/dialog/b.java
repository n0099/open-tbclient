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
    private ViewGroup aMV;
    private FrameLayout aMW;
    private FrameLayout aMX;
    private View aMY;
    private List<a> aMZ;
    private int aNa;
    protected Context mContext;

    /* loaded from: classes2.dex */
    public interface c {
        void U(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context) {
        super(context, a.i.NoTitleDialog);
        this.aMZ = new ArrayList();
        this.aNa = 2;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        createView();
        KF().ad(this.aMV);
    }

    private void createView() {
        this.mContext = getContext();
        this.aMV = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_hv_dialog, KF().KN(), false);
        this.aMW = (FrameLayout) this.aMV.findViewById(a.f.hv_content);
        this.aMY = this.aMV.findViewById(a.f.hv_divider);
        this.aMX = (FrameLayout) this.aMV.findViewById(a.f.hv_btn_content);
        View f = f(this.aMW);
        if (f != null) {
            this.aMW.addView(f);
        }
        KA();
        A(this.aMZ);
    }

    private void KA() {
        this.aMY.setBackgroundColor(getContext().getResources().getColor(a.c.aiapps_dialog_gray));
    }

    protected View f(ViewGroup viewGroup) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(List<a> list) {
        this.aMZ.clear();
        if (list != null) {
            this.aMZ.addAll(list);
        }
    }

    private void A(List<a> list) {
        if (list != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            if (list.size() > this.aNa) {
                linearLayout.setOrientation(1);
            } else {
                linearLayout.setOrientation(0);
            }
            for (int i = 0; i < list.size(); i++) {
                linearLayout.addView(a(list.get(i), linearLayout));
                if (i < list.size() - 1) {
                    if (list.size() > this.aNa) {
                        linearLayout.addView(dl(1));
                    } else {
                        linearLayout.addView(dl(0));
                    }
                }
            }
            this.aMX.removeAllViews();
            this.aMX.addView(linearLayout);
        }
    }

    private LinearLayout a(a aVar, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
        linearLayout2.setBackground(getContext().getResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
        new d(linearLayout2, this).b(aVar);
        return linearLayout2;
    }

    private View dl(int i) {
        View view = new View(this.mContext);
        view.setBackgroundColor(this.aMW.getResources().getColor(a.c.aiapps_dialog_gray));
        if (i == 1) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        } else {
            view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
        }
        return view;
    }

    /* loaded from: classes2.dex */
    public class d {
        TextView aNe;
        LinearLayout aNf;
        b aNg;
        TextView text;

        public d(View view, b bVar) {
            if (view != null) {
                this.text = (TextView) view.findViewById(a.f.hv_btn_text);
                this.aNe = (TextView) view.findViewById(a.f.hv_btn_subtext);
                this.aNf = (LinearLayout) view;
                this.aNg = bVar;
            }
        }

        public void b(final a aVar) {
            if (aVar != null) {
                this.text.setText(aVar.mText);
                if (aVar.aNb > 0) {
                    this.text.setTextColor(b.this.aMW.getResources().getColor(aVar.aNb));
                }
                if (!TextUtils.isEmpty(aVar.mSubText)) {
                    this.aNe.setVisibility(0);
                    this.aNe.setText(aVar.mSubText);
                } else {
                    this.aNe.setVisibility(8);
                }
                if (aVar.aNc > 0) {
                    this.aNe.setTextColor(b.this.aMW.getResources().getColor(aVar.aNc));
                }
                this.aNf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.b.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.aNg.dismiss();
                        if (aVar.aNd != null) {
                            aVar.aNd.U(view);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.baidu.swan.apps.res.widget.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0169b extends g.a {
        private List<a> list;

        public C0169b(Context context) {
            super(context);
            this.list = new ArrayList();
            ce(false);
            ca(false);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aU(Context context) {
            return new b(context);
        }

        public C0169b a(a aVar) {
            if (aVar != null) {
                this.list.add(aVar);
            }
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g Aq() {
            b bVar = (b) super.Aq();
            bVar.z(this.list);
            return bVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        public int aNb;
        public int aNc = -1;
        public c aNd;
        public CharSequence mSubText;
        public CharSequence mText;

        public a(CharSequence charSequence, int i, c cVar) {
            this.aNb = -1;
            this.mText = charSequence;
            this.aNb = i;
            this.aNd = cVar;
        }
    }
}
