package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k {
    private Context eXh;
    private RoundLinearLayout eXi;
    private LinearLayout eXj;
    private LinearLayout eXk;
    private EMTextView eXl;
    private View eXm;
    private TextView eXn;
    private View eXo;
    private SpannableStringBuilder eXp;
    private c eXq;
    private a eXr;
    private boolean eXs = false;
    private List<? extends j> mItems;
    private String titleText;

    /* loaded from: classes.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onClick();
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(k kVar, int i, View view);
    }

    public k(Context context) {
        if (context != null) {
            this.eXh = context;
            init();
        }
    }

    private void init() {
        this.eXi = (RoundLinearLayout) LayoutInflater.from(this.eXh).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
        com.baidu.tbadk.core.elementsMaven.c.br(this.eXi).oh(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        this.eXj = (LinearLayout) this.eXi.findViewById(R.id.content_view);
        this.eXl = (EMTextView) this.eXi.findViewById(R.id.title);
        this.eXm = this.eXi.findViewById(R.id.title_divide_line);
        this.eXm.setVisibility(8);
        this.eXo = this.eXi.findViewById(R.id.dialog_header);
        this.mItems = new ArrayList();
        this.eXn = (TextView) this.eXi.findViewById(R.id.dialog_bottom_cancel_button);
    }

    private void bqQ() {
        this.eXs = true;
        this.eXi = (RoundLinearLayout) LayoutInflater.from(this.eXh).inflate(R.layout.popup_dialog_view_horizal, (ViewGroup) null);
        com.baidu.tbadk.core.elementsMaven.c.br(this.eXi).oh(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        this.eXj = (LinearLayout) this.eXi.findViewById(R.id.content_view);
        this.eXk = (LinearLayout) this.eXi.findViewById(R.id.content_view_second);
        this.eXl = (EMTextView) this.eXi.findViewById(R.id.title);
        this.eXm = this.eXi.findViewById(R.id.title_divide_line);
        this.eXm.setVisibility(8);
        this.eXo = this.eXi.findViewById(R.id.dialog_header);
        this.mItems = new ArrayList();
        this.eXn = (TextView) this.eXi.findViewById(R.id.dialog_bottom_cancel_button);
        int equipmentWidth = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.eXh) - (g.eWR * 4)) / 2;
        ((LinearLayout.LayoutParams) this.eXj.getLayoutParams()).leftMargin = equipmentWidth;
        ((LinearLayout.LayoutParams) this.eXj.getLayoutParams()).rightMargin = equipmentWidth;
        ((FrameLayout.LayoutParams) this.eXk.getLayoutParams()).leftMargin = equipmentWidth;
        ((FrameLayout.LayoutParams) this.eXk.getLayoutParams()).rightMargin = equipmentWidth;
    }

    public Context getContext() {
        return this.eXh;
    }

    public ViewGroup getView() {
        return this.eXj;
    }

    public View getRootView() {
        return this.eXi;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(SpannableStringBuilder spannableStringBuilder) {
        this.eXp = spannableStringBuilder;
    }

    public void a(c cVar) {
        this.eXq = cVar;
    }

    public c bqR() {
        return this.eXq;
    }

    public void bw(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.eXj.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.eXj.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void k(List<? extends j> list, boolean z) {
        if (z && com.baidu.tbadk.a.d.bjo()) {
            bx(list);
        } else {
            bw(list);
        }
    }

    private void bx(List<? extends j> list) {
        boolean z;
        boolean z2;
        int i;
        if (list != null) {
            bqQ();
            this.mItems = list;
            this.eXj.removeAllViews();
            this.eXk.removeAllViews();
            if (list.size() < 2) {
                z2 = false;
                z = false;
            } else {
                z = ((g) list.get(0)).getId() == -1;
                z2 = ((g) list.get(1)).getId() == -2;
            }
            this.eXm.setVisibility(z ? 0 : 8);
            if (z) {
                i = z2 ? 4 : 3;
            } else {
                i = 0;
            }
            boolean z3 = list.size() - i > 4;
            for (int i2 = 0; i2 < list.size(); i2++) {
                g gVar = (g) list.get(i2);
                gVar.setCanScroll(z3);
                gVar.bqL();
                if (gVar != null) {
                    if (i2 < i) {
                        this.eXj.addView(gVar.getView());
                    } else {
                        this.eXk.addView(gVar.getView());
                    }
                }
            }
        }
    }

    public void a(a aVar) {
        this.eXr = aVar;
        if (this.eXr != null && this.eXn != null) {
            this.eXn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.eXr.onClick();
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (this.eXs) {
            ap.setBackgroundResource(this.eXl, R.color.CAM_X0209);
            ap.setBackgroundResource(this.eXo, R.color.CAM_X0209);
            ap.setBackgroundColor(this.eXm, R.color.CAM_X0203);
        } else {
            ap.setBackgroundResource(this.eXl, R.color.CAM_X0204);
            ap.setViewTextColor(this.eXl, R.color.CAM_X0109);
            ap.setBackgroundResource(this.eXo, R.color.CAM_X0204);
            ap.setBackgroundColor(this.eXm, R.color.CAM_X0204);
        }
        ap.setBackgroundResource(this.eXn, R.color.CAM_X0204);
        ap.n(this.eXn, R.color.CAM_X0107);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View bqS() {
        if (!StringUtils.isNull(this.titleText)) {
            this.eXl.setText(this.titleText);
        } else if (this.eXp != null) {
            this.eXl.setText(this.eXp);
        } else {
            this.eXl.setVisibility(8);
        }
        if (this.eXr != null) {
            this.eXn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.eXr.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.eXi;
    }
}
