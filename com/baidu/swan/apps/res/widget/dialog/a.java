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
    private ViewGroup aLc;
    private FrameLayout aLd;
    private FrameLayout aLe;
    private View aLf;
    private List<C0163a> aLg;
    private int aLh;
    protected Context mContext;

    /* loaded from: classes2.dex */
    public interface c {
        void U(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context) {
        super(context, a.i.NoTitleDialog);
        this.aLg = new ArrayList();
        this.aLh = 2;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        createView();
        Ip().ad(this.aLc);
    }

    private void createView() {
        this.mContext = getContext();
        this.aLc = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_hv_dialog, Ip().Iv(), false);
        this.aLd = (FrameLayout) this.aLc.findViewById(a.f.hv_content);
        this.aLf = this.aLc.findViewById(a.f.hv_divider);
        this.aLe = (FrameLayout) this.aLc.findViewById(a.f.hv_btn_content);
        View f = f(this.aLd);
        if (f != null) {
            this.aLd.addView(f);
        }
        Ik();
        z(this.aLg);
    }

    private void Ik() {
        this.aLf.setBackgroundColor(getContext().getResources().getColor(a.c.aiapps_dialog_gray));
    }

    protected View f(ViewGroup viewGroup) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(List<C0163a> list) {
        this.aLg.clear();
        if (list != null) {
            this.aLg.addAll(list);
        }
    }

    private void z(List<C0163a> list) {
        if (list != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            if (list.size() > this.aLh) {
                linearLayout.setOrientation(1);
            } else {
                linearLayout.setOrientation(0);
            }
            for (int i = 0; i < list.size(); i++) {
                linearLayout.addView(a(list.get(i), linearLayout));
                if (i < list.size() - 1) {
                    if (list.size() > this.aLh) {
                        linearLayout.addView(dg(1));
                    } else {
                        linearLayout.addView(dg(0));
                    }
                }
            }
            this.aLe.removeAllViews();
            this.aLe.addView(linearLayout);
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
        view.setBackgroundColor(this.aLd.getResources().getColor(a.c.aiapps_dialog_gray));
        if (i == 1) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        } else {
            view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
        }
        return view;
    }

    /* loaded from: classes2.dex */
    public class d {
        TextView aLl;
        LinearLayout aLm;
        a aLn;
        TextView text;

        public d(View view, a aVar) {
            if (view != null) {
                this.text = (TextView) view.findViewById(a.f.hv_btn_text);
                this.aLl = (TextView) view.findViewById(a.f.hv_btn_subtext);
                this.aLm = (LinearLayout) view;
                this.aLn = aVar;
            }
        }

        public void b(final C0163a c0163a) {
            if (c0163a != null) {
                this.text.setText(c0163a.mText);
                if (c0163a.aLi > 0) {
                    this.text.setTextColor(a.this.aLd.getResources().getColor(c0163a.aLi));
                }
                if (!TextUtils.isEmpty(c0163a.mSubText)) {
                    this.aLl.setVisibility(0);
                    this.aLl.setText(c0163a.mSubText);
                } else {
                    this.aLl.setVisibility(8);
                }
                if (c0163a.aLj > 0) {
                    this.aLl.setTextColor(a.this.aLd.getResources().getColor(c0163a.aLj));
                }
                this.aLm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.a.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.aLn.dismiss();
                        if (c0163a.aLk != null) {
                            c0163a.aLk.U(view);
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
        public int aLi;
        public int aLj = -1;
        public c aLk;
        public CharSequence mSubText;
        public CharSequence mText;

        public C0163a(CharSequence charSequence, int i, c cVar) {
            this.aLi = -1;
            this.mText = charSequence;
            this.aLi = i;
            this.aLk = cVar;
        }
    }
}
