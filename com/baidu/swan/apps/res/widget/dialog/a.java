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
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.widget.dialog.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends e {
    private ViewGroup aKX;
    private FrameLayout aKY;
    private FrameLayout aKZ;
    private View aLa;
    private List<C0134a> aLb;
    private int aLc;
    protected Context mContext;

    /* loaded from: classes2.dex */
    public interface c {
        void U(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context) {
        super(context, b.i.NoTitleDialog);
        this.aLb = new ArrayList();
        this.aLc = 2;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        createView();
        Ir().ad(this.aKX);
    }

    private void createView() {
        this.mContext = getContext();
        this.aKX = (ViewGroup) LayoutInflater.from(this.mContext).inflate(b.g.aiapps_view_hv_dialog, Ir().Ix(), false);
        this.aKY = (FrameLayout) this.aKX.findViewById(b.f.hv_content);
        this.aLa = this.aKX.findViewById(b.f.hv_divider);
        this.aKZ = (FrameLayout) this.aKX.findViewById(b.f.hv_btn_content);
        View f = f(this.aKY);
        if (f != null) {
            this.aKY.addView(f);
        }
        Im();
        z(this.aLb);
    }

    private void Im() {
        this.aLa.setBackgroundColor(getContext().getResources().getColor(b.c.aiapps_dialog_gray));
    }

    protected View f(ViewGroup viewGroup) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(List<C0134a> list) {
        this.aLb.clear();
        if (list != null) {
            this.aLb.addAll(list);
        }
    }

    private void z(List<C0134a> list) {
        if (list != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            if (list.size() > this.aLc) {
                linearLayout.setOrientation(1);
            } else {
                linearLayout.setOrientation(0);
            }
            for (int i = 0; i < list.size(); i++) {
                linearLayout.addView(a(list.get(i), linearLayout));
                if (i < list.size() - 1) {
                    if (list.size() > this.aLc) {
                        linearLayout.addView(dh(1));
                    } else {
                        linearLayout.addView(dh(0));
                    }
                }
            }
            this.aKZ.removeAllViews();
            this.aKZ.addView(linearLayout);
        }
    }

    private LinearLayout a(C0134a c0134a, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(b.g.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
        linearLayout2.setBackground(getContext().getResources().getDrawable(b.e.aiapp_alertdialog_button_day_bg_all_selector));
        new d(linearLayout2, this).b(c0134a);
        return linearLayout2;
    }

    private View dh(int i) {
        View view = new View(this.mContext);
        view.setBackgroundColor(this.aKY.getResources().getColor(b.c.aiapps_dialog_gray));
        if (i == 1) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        } else {
            view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
        }
        return view;
    }

    /* loaded from: classes2.dex */
    public class d {
        TextView aLg;
        LinearLayout aLh;
        a aLi;
        TextView text;

        public d(View view, a aVar) {
            if (view != null) {
                this.text = (TextView) view.findViewById(b.f.hv_btn_text);
                this.aLg = (TextView) view.findViewById(b.f.hv_btn_subtext);
                this.aLh = (LinearLayout) view;
                this.aLi = aVar;
            }
        }

        public void b(final C0134a c0134a) {
            if (c0134a != null) {
                this.text.setText(c0134a.mText);
                if (c0134a.aLd > 0) {
                    this.text.setTextColor(a.this.aKY.getResources().getColor(c0134a.aLd));
                }
                if (!TextUtils.isEmpty(c0134a.mSubText)) {
                    this.aLg.setVisibility(0);
                    this.aLg.setText(c0134a.mSubText);
                } else {
                    this.aLg.setVisibility(8);
                }
                if (c0134a.aLe > 0) {
                    this.aLg.setTextColor(a.this.aKY.getResources().getColor(c0134a.aLe));
                }
                this.aLh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.a.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.aLi.dismiss();
                        if (c0134a.aLf != null) {
                            c0134a.aLf.U(view);
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends e.a {
        private List<C0134a> list;

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

        public b a(C0134a c0134a) {
            if (c0134a != null) {
                this.list.add(c0134a);
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
    public static class C0134a {
        public int aLd;
        public int aLe = -1;
        public c aLf;
        public CharSequence mSubText;
        public CharSequence mText;

        public C0134a(CharSequence charSequence, int i, c cVar) {
            this.aLd = -1;
            this.mText = charSequence;
            this.aLd = i;
            this.aLf = cVar;
        }
    }
}
