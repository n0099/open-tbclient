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
    private ViewGroup aKY;
    private FrameLayout aKZ;
    private FrameLayout aLa;
    private View aLb;
    private List<C0163a> aLc;
    private int aLd;
    protected Context mContext;

    /* loaded from: classes2.dex */
    public interface c {
        void U(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context) {
        super(context, a.i.NoTitleDialog);
        this.aLc = new ArrayList();
        this.aLd = 2;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        createView();
        Ir().ad(this.aKY);
    }

    private void createView() {
        this.mContext = getContext();
        this.aKY = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_hv_dialog, Ir().Ix(), false);
        this.aKZ = (FrameLayout) this.aKY.findViewById(a.f.hv_content);
        this.aLb = this.aKY.findViewById(a.f.hv_divider);
        this.aLa = (FrameLayout) this.aKY.findViewById(a.f.hv_btn_content);
        View f = f(this.aKZ);
        if (f != null) {
            this.aKZ.addView(f);
        }
        Im();
        z(this.aLc);
    }

    private void Im() {
        this.aLb.setBackgroundColor(getContext().getResources().getColor(a.c.aiapps_dialog_gray));
    }

    protected View f(ViewGroup viewGroup) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(List<C0163a> list) {
        this.aLc.clear();
        if (list != null) {
            this.aLc.addAll(list);
        }
    }

    private void z(List<C0163a> list) {
        if (list != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            if (list.size() > this.aLd) {
                linearLayout.setOrientation(1);
            } else {
                linearLayout.setOrientation(0);
            }
            for (int i = 0; i < list.size(); i++) {
                linearLayout.addView(a(list.get(i), linearLayout));
                if (i < list.size() - 1) {
                    if (list.size() > this.aLd) {
                        linearLayout.addView(dh(1));
                    } else {
                        linearLayout.addView(dh(0));
                    }
                }
            }
            this.aLa.removeAllViews();
            this.aLa.addView(linearLayout);
        }
    }

    private LinearLayout a(C0163a c0163a, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
        linearLayout2.setBackground(getContext().getResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
        new d(linearLayout2, this).b(c0163a);
        return linearLayout2;
    }

    private View dh(int i) {
        View view = new View(this.mContext);
        view.setBackgroundColor(this.aKZ.getResources().getColor(a.c.aiapps_dialog_gray));
        if (i == 1) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        } else {
            view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
        }
        return view;
    }

    /* loaded from: classes2.dex */
    public class d {
        TextView aLh;
        LinearLayout aLi;
        a aLj;
        TextView text;

        public d(View view, a aVar) {
            if (view != null) {
                this.text = (TextView) view.findViewById(a.f.hv_btn_text);
                this.aLh = (TextView) view.findViewById(a.f.hv_btn_subtext);
                this.aLi = (LinearLayout) view;
                this.aLj = aVar;
            }
        }

        public void b(final C0163a c0163a) {
            if (c0163a != null) {
                this.text.setText(c0163a.mText);
                if (c0163a.aLe > 0) {
                    this.text.setTextColor(a.this.aKZ.getResources().getColor(c0163a.aLe));
                }
                if (!TextUtils.isEmpty(c0163a.mSubText)) {
                    this.aLh.setVisibility(0);
                    this.aLh.setText(c0163a.mSubText);
                } else {
                    this.aLh.setVisibility(8);
                }
                if (c0163a.aLf > 0) {
                    this.aLh.setTextColor(a.this.aKZ.getResources().getColor(c0163a.aLf));
                }
                this.aLi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.a.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.aLj.dismiss();
                        if (c0163a.aLg != null) {
                            c0163a.aLg.U(view);
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
        public e zr() {
            a aVar = (a) super.zr();
            aVar.y(this.list);
            return aVar;
        }
    }

    /* renamed from: com.baidu.swan.apps.res.widget.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0163a {
        public int aLe;
        public int aLf = -1;
        public c aLg;
        public CharSequence mSubText;
        public CharSequence mText;

        public C0163a(CharSequence charSequence, int i, c cVar) {
            this.aLe = -1;
            this.mText = charSequence;
            this.aLe = i;
            this.aLg = cVar;
        }
    }
}
