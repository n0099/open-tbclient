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
import com.baidu.swan.apps.res.widget.dialog.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends e {
    private ViewGroup aLb;
    private FrameLayout aLc;
    private FrameLayout aLd;
    private View aLe;
    private List<C0163a> aLf;
    private int aLg;
    protected Context mContext;

    /* loaded from: classes2.dex */
    public interface c {
        void U(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context) {
        super(context, a.i.NoTitleDialog);
        this.aLf = new ArrayList();
        this.aLg = 2;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        createView();
        Ip().ad(this.aLb);
    }

    private void createView() {
        this.mContext = getContext();
        this.aLb = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_hv_dialog, Ip().Iv(), false);
        this.aLc = (FrameLayout) this.aLb.findViewById(a.f.hv_content);
        this.aLe = this.aLb.findViewById(a.f.hv_divider);
        this.aLd = (FrameLayout) this.aLb.findViewById(a.f.hv_btn_content);
        View f = f(this.aLc);
        if (f != null) {
            this.aLc.addView(f);
        }
        Ik();
        z(this.aLf);
    }

    private void Ik() {
        this.aLe.setBackgroundColor(getContext().getResources().getColor(a.c.aiapps_dialog_gray));
    }

    protected View f(ViewGroup viewGroup) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(List<C0163a> list) {
        this.aLf.clear();
        if (list != null) {
            this.aLf.addAll(list);
        }
    }

    private void z(List<C0163a> list) {
        if (list != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            if (list.size() > this.aLg) {
                linearLayout.setOrientation(1);
            } else {
                linearLayout.setOrientation(0);
            }
            for (int i = 0; i < list.size(); i++) {
                linearLayout.addView(a(list.get(i), linearLayout));
                if (i < list.size() - 1) {
                    if (list.size() > this.aLg) {
                        linearLayout.addView(dg(1));
                    } else {
                        linearLayout.addView(dg(0));
                    }
                }
            }
            this.aLd.removeAllViews();
            this.aLd.addView(linearLayout);
        }
    }

    private LinearLayout a(C0163a c0163a, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
        linearLayout2.setBackground(getContext().getResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
        new d(linearLayout2, this).b(c0163a);
        return linearLayout2;
    }

    private View dg(int i) {
        View view = new View(this.mContext);
        view.setBackgroundColor(this.aLc.getResources().getColor(a.c.aiapps_dialog_gray));
        if (i == 1) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        } else {
            view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
        }
        return view;
    }

    /* loaded from: classes2.dex */
    public class d {
        TextView aLk;
        LinearLayout aLl;
        a aLm;
        TextView text;

        public d(View view, a aVar) {
            if (view != null) {
                this.text = (TextView) view.findViewById(a.f.hv_btn_text);
                this.aLk = (TextView) view.findViewById(a.f.hv_btn_subtext);
                this.aLl = (LinearLayout) view;
                this.aLm = aVar;
            }
        }

        public void b(final C0163a c0163a) {
            if (c0163a != null) {
                this.text.setText(c0163a.mText);
                if (c0163a.aLh > 0) {
                    this.text.setTextColor(a.this.aLc.getResources().getColor(c0163a.aLh));
                }
                if (!TextUtils.isEmpty(c0163a.mSubText)) {
                    this.aLk.setVisibility(0);
                    this.aLk.setText(c0163a.mSubText);
                } else {
                    this.aLk.setVisibility(8);
                }
                if (c0163a.aLi > 0) {
                    this.aLk.setTextColor(a.this.aLc.getResources().getColor(c0163a.aLi));
                }
                this.aLl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.a.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.aLm.dismiss();
                        if (c0163a.aLj != null) {
                            c0163a.aLj.U(view);
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends e.a {
        private List<C0163a> list;

        public b(Context context) {
            super(context);
            this.list = new ArrayList();
            bU(false);
            bQ(false);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        protected e bB(Context context) {
            return new a(context);
        }

        public b a(C0163a c0163a) {
            if (c0163a != null) {
                this.list.add(c0163a);
            }
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        public e zq() {
            a aVar = (a) super.zq();
            aVar.y(this.list);
            return aVar;
        }
    }

    /* renamed from: com.baidu.swan.apps.res.widget.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0163a {
        public int aLh;
        public int aLi = -1;
        public c aLj;
        public CharSequence mSubText;
        public CharSequence mText;

        public C0163a(CharSequence charSequence, int i, c cVar) {
            this.aLh = -1;
            this.mText = charSequence;
            this.aLh = i;
            this.aLj = cVar;
        }
    }
}
