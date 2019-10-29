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
    private ViewGroup aof;
    private FrameLayout bhk;
    private FrameLayout bhl;
    private View bhm;
    private List<a> bhn;
    private int bho;
    protected Context mContext;

    /* loaded from: classes2.dex */
    public interface c {
        void ac(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context) {
        super(context, a.i.NoTitleDialog);
        this.bhn = new ArrayList();
        this.bho = 2;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        nw();
        Qp().al(this.aof);
    }

    private void nw() {
        this.mContext = getContext();
        this.aof = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_hv_dialog, Qp().Qx(), false);
        this.bhk = (FrameLayout) this.aof.findViewById(a.f.hv_content);
        this.bhm = this.aof.findViewById(a.f.hv_divider);
        this.bhl = (FrameLayout) this.aof.findViewById(a.f.hv_btn_content);
        View i = i(this.bhk);
        if (i != null) {
            this.bhk.addView(i);
        }
        Qk();
        Z(this.bhn);
    }

    private void Qk() {
        this.bhm.setBackgroundColor(getContext().getResources().getColor(a.c.aiapps_dialog_gray));
    }

    protected View i(ViewGroup viewGroup) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(List<a> list) {
        this.bhn.clear();
        if (list != null) {
            this.bhn.addAll(list);
        }
    }

    private void Z(List<a> list) {
        if (list != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            if (list.size() > this.bho) {
                linearLayout.setOrientation(1);
            } else {
                linearLayout.setOrientation(0);
            }
            for (int i = 0; i < list.size(); i++) {
                linearLayout.addView(a(list.get(i), linearLayout));
                if (i < list.size() - 1) {
                    if (list.size() > this.bho) {
                        linearLayout.addView(ek(1));
                    } else {
                        linearLayout.addView(ek(0));
                    }
                }
            }
            this.bhl.removeAllViews();
            this.bhl.addView(linearLayout);
        }
    }

    private LinearLayout a(a aVar, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
        linearLayout2.setBackground(getContext().getResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
        new d(linearLayout2, this).b(aVar);
        return linearLayout2;
    }

    private View ek(int i) {
        View view = new View(this.mContext);
        view.setBackgroundColor(this.bhk.getResources().getColor(a.c.aiapps_dialog_gray));
        if (i == 1) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        } else {
            view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
        }
        return view;
    }

    /* loaded from: classes2.dex */
    public class d {
        TextView YM;
        TextView bhs;
        LinearLayout bht;
        b bhu;

        public d(View view, b bVar) {
            if (view != null) {
                this.YM = (TextView) view.findViewById(a.f.hv_btn_text);
                this.bhs = (TextView) view.findViewById(a.f.hv_btn_subtext);
                this.bht = (LinearLayout) view;
                this.bhu = bVar;
            }
        }

        public void b(final a aVar) {
            if (aVar != null) {
                this.YM.setText(aVar.mText);
                if (aVar.bhp > 0) {
                    this.YM.setTextColor(b.this.bhk.getResources().getColor(aVar.bhp));
                }
                if (!TextUtils.isEmpty(aVar.mSubText)) {
                    this.bhs.setVisibility(0);
                    this.bhs.setText(aVar.mSubText);
                } else {
                    this.bhs.setVisibility(8);
                }
                if (aVar.bhq > 0) {
                    this.bhs.setTextColor(b.this.bhk.getResources().getColor(aVar.bhq));
                }
                this.bht.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.b.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.bhu.dismiss();
                        if (aVar.bhr != null) {
                            aVar.bhr.ac(view);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.baidu.swan.apps.res.widget.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0212b extends g.a {
        private List<a> list;

        public C0212b(Context context) {
            super(context);
            this.list = new ArrayList();
            cy(false);
            cu(false);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aW(Context context) {
            return new b(context);
        }

        public C0212b a(a aVar) {
            if (aVar != null) {
                this.list.add(aVar);
            }
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g FW() {
            b bVar = (b) super.FW();
            bVar.Y(this.list);
            return bVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        public int bhp;
        public int bhq = -1;
        public c bhr;
        public CharSequence mSubText;
        public CharSequence mText;

        public a(CharSequence charSequence, int i, c cVar) {
            this.bhp = -1;
            this.mText = charSequence;
            this.bhp = i;
            this.bhr = cVar;
        }
    }
}
