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
    private ViewGroup aOc;
    private FrameLayout aOd;
    private FrameLayout aOe;
    private View aOf;
    private List<a> aOg;
    private int aOh;
    protected Context mContext;

    /* loaded from: classes2.dex */
    public interface c {
        void W(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context) {
        super(context, a.i.NoTitleDialog);
        this.aOg = new ArrayList();
        this.aOh = 2;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        createView();
        Lw().af(this.aOc);
    }

    private void createView() {
        this.mContext = getContext();
        this.aOc = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_hv_dialog, Lw().LE(), false);
        this.aOd = (FrameLayout) this.aOc.findViewById(a.f.hv_content);
        this.aOf = this.aOc.findViewById(a.f.hv_divider);
        this.aOe = (FrameLayout) this.aOc.findViewById(a.f.hv_btn_content);
        View f = f(this.aOd);
        if (f != null) {
            this.aOd.addView(f);
        }
        Lr();
        A(this.aOg);
    }

    private void Lr() {
        this.aOf.setBackgroundColor(getContext().getResources().getColor(a.c.aiapps_dialog_gray));
    }

    protected View f(ViewGroup viewGroup) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(List<a> list) {
        this.aOg.clear();
        if (list != null) {
            this.aOg.addAll(list);
        }
    }

    private void A(List<a> list) {
        if (list != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            if (list.size() > this.aOh) {
                linearLayout.setOrientation(1);
            } else {
                linearLayout.setOrientation(0);
            }
            for (int i = 0; i < list.size(); i++) {
                linearLayout.addView(a(list.get(i), linearLayout));
                if (i < list.size() - 1) {
                    if (list.size() > this.aOh) {
                        linearLayout.addView(dp(1));
                    } else {
                        linearLayout.addView(dp(0));
                    }
                }
            }
            this.aOe.removeAllViews();
            this.aOe.addView(linearLayout);
        }
    }

    private LinearLayout a(a aVar, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
        linearLayout2.setBackground(getContext().getResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
        new d(linearLayout2, this).b(aVar);
        return linearLayout2;
    }

    private View dp(int i) {
        View view = new View(this.mContext);
        view.setBackgroundColor(this.aOd.getResources().getColor(a.c.aiapps_dialog_gray));
        if (i == 1) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        } else {
            view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
        }
        return view;
    }

    /* loaded from: classes2.dex */
    public class d {
        TextView aOl;
        LinearLayout aOm;
        b aOn;
        TextView text;

        public d(View view, b bVar) {
            if (view != null) {
                this.text = (TextView) view.findViewById(a.f.hv_btn_text);
                this.aOl = (TextView) view.findViewById(a.f.hv_btn_subtext);
                this.aOm = (LinearLayout) view;
                this.aOn = bVar;
            }
        }

        public void b(final a aVar) {
            if (aVar != null) {
                this.text.setText(aVar.mText);
                if (aVar.aOi > 0) {
                    this.text.setTextColor(b.this.aOd.getResources().getColor(aVar.aOi));
                }
                if (!TextUtils.isEmpty(aVar.mSubText)) {
                    this.aOl.setVisibility(0);
                    this.aOl.setText(aVar.mSubText);
                } else {
                    this.aOl.setVisibility(8);
                }
                if (aVar.aOj > 0) {
                    this.aOl.setTextColor(b.this.aOd.getResources().getColor(aVar.aOj));
                }
                this.aOm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.b.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.aOn.dismiss();
                        if (aVar.aOk != null) {
                            aVar.aOk.W(view);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.baidu.swan.apps.res.widget.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0180b extends g.a {
        private List<a> list;

        public C0180b(Context context) {
            super(context);
            this.list = new ArrayList();
            ch(false);
            cd(false);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aU(Context context) {
            return new b(context);
        }

        public C0180b a(a aVar) {
            if (aVar != null) {
                this.list.add(aVar);
            }
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g Bb() {
            b bVar = (b) super.Bb();
            bVar.z(this.list);
            return bVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        public int aOi;
        public int aOj = -1;
        public c aOk;
        public CharSequence mSubText;
        public CharSequence mText;

        public a(CharSequence charSequence, int i, c cVar) {
            this.aOi = -1;
            this.mText = charSequence;
            this.aOi = i;
            this.aOk = cVar;
        }
    }
}
