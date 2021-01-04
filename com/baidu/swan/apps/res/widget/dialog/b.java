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
    private ViewGroup bKC;
    private FrameLayout dDG;
    private FrameLayout dDH;
    private View dDI;
    private List<a> dDJ;
    private int dDK;
    protected Context mContext;

    /* loaded from: classes9.dex */
    public interface c {
        void aD(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context) {
        super(context, a.i.NoTitleDialog);
        this.dDJ = new ArrayList();
        this.dDK = 2;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        createView();
        aLr().aK(this.bKC);
    }

    private void createView() {
        this.mContext = getContext();
        this.bKC = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_hv_dialog, aLr().aLA(), false);
        this.dDG = (FrameLayout) this.bKC.findViewById(a.f.hv_content);
        this.dDI = this.bKC.findViewById(a.f.hv_divider);
        this.dDH = (FrameLayout) this.bKC.findViewById(a.f.hv_btn_content);
        View F = F(this.dDG);
        if (F != null) {
            this.dDG.addView(F);
        }
        aLl();
        aV(this.dDJ);
    }

    private void aLl() {
        this.dDI.setBackgroundColor(getContext().getResources().getColor(a.c.aiapps_dialog_gray));
    }

    protected View F(ViewGroup viewGroup) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(List<a> list) {
        this.dDJ.clear();
        if (list != null) {
            this.dDJ.addAll(list);
        }
    }

    private void aV(List<a> list) {
        if (list != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            if (list.size() > this.dDK) {
                linearLayout.setOrientation(1);
            } else {
                linearLayout.setOrientation(0);
            }
            for (int i = 0; i < list.size(); i++) {
                linearLayout.addView(a(list.get(i), linearLayout));
                if (i < list.size() - 1) {
                    if (list.size() > this.dDK) {
                        linearLayout.addView(ko(1));
                    } else {
                        linearLayout.addView(ko(0));
                    }
                }
            }
            this.dDH.removeAllViews();
            this.dDH.addView(linearLayout);
        }
    }

    private LinearLayout a(a aVar, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
        linearLayout2.setBackground(getContext().getResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
        new d(linearLayout2, this).b(aVar);
        return linearLayout2;
    }

    private View ko(int i) {
        View view = new View(this.mContext);
        view.setBackgroundColor(this.dDG.getResources().getColor(a.c.aiapps_dialog_gray));
        if (i == 1) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        } else {
            view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
        }
        return view;
    }

    /* loaded from: classes9.dex */
    public class d {
        TextView bbM;
        TextView dDO;
        LinearLayout dDP;
        b dDQ;

        public d(View view, b bVar) {
            if (view != null) {
                this.bbM = (TextView) view.findViewById(a.f.hv_btn_text);
                this.dDO = (TextView) view.findViewById(a.f.hv_btn_subtext);
                this.dDP = (LinearLayout) view;
                this.dDQ = bVar;
            }
        }

        public void b(final a aVar) {
            if (aVar != null) {
                this.bbM.setText(aVar.mText);
                if (aVar.dDL > 0) {
                    this.bbM.setTextColor(b.this.dDG.getResources().getColor(aVar.dDL));
                }
                if (!TextUtils.isEmpty(aVar.mSubText)) {
                    this.dDO.setVisibility(0);
                    this.dDO.setText(aVar.mSubText);
                } else {
                    this.dDO.setVisibility(8);
                }
                if (aVar.dDM > 0) {
                    this.dDO.setTextColor(b.this.dDG.getResources().getColor(aVar.dDM));
                }
                this.dDP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.b.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.dDQ.dismiss();
                        if (aVar.dDN != null) {
                            aVar.dDN.aD(view);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.baidu.swan.apps.res.widget.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0472b extends g.a {
        private List<a> list;

        public C0472b(Context context) {
            super(context);
            this.list = new ArrayList();
            gY(false);
            gU(false);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g cL(Context context) {
            return new b(context);
        }

        public C0472b a(a aVar) {
            if (aVar != null) {
                this.list.add(aVar);
            }
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g atG() {
            b bVar = (b) super.atG();
            bVar.aU(this.list);
            return bVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        public int dDL;
        public int dDM = -1;
        public c dDN;
        public CharSequence mSubText;
        public CharSequence mText;

        public a(CharSequence charSequence, int i, c cVar) {
            this.dDL = -1;
            this.mText = charSequence;
            this.dDL = i;
            this.dDN = cVar;
        }
    }
}
