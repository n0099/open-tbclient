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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k {
    private Context eYd;
    private RoundLinearLayout eYe;
    private LinearLayout eYf;
    private LinearLayout eYg;
    private EMTextView eYh;
    private View eYi;
    private TextView eYj;
    private View eYk;
    private SpannableStringBuilder eYl;
    private c eYm;
    private a eYn;
    private boolean eYo = false;
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
            this.eYd = context;
            init();
        }
    }

    private void init() {
        this.eYe = (RoundLinearLayout) LayoutInflater.from(this.eYd).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.eYe).pK(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        this.eYf = (LinearLayout) this.eYe.findViewById(R.id.content_view);
        this.eYh = (EMTextView) this.eYe.findViewById(R.id.title);
        this.eYi = this.eYe.findViewById(R.id.title_divide_line);
        this.eYi.setVisibility(8);
        this.eYk = this.eYe.findViewById(R.id.dialog_header);
        this.mItems = new ArrayList();
        this.eYj = (TextView) this.eYe.findViewById(R.id.dialog_bottom_cancel_button);
    }

    private void buq() {
        this.eYo = true;
        this.eYe = (RoundLinearLayout) LayoutInflater.from(this.eYd).inflate(R.layout.popup_dialog_view_horizal, (ViewGroup) null);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.eYe).pK(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        this.eYf = (LinearLayout) this.eYe.findViewById(R.id.content_view);
        this.eYg = (LinearLayout) this.eYe.findViewById(R.id.content_view_second);
        this.eYh = (EMTextView) this.eYe.findViewById(R.id.title);
        this.eYi = this.eYe.findViewById(R.id.title_divide_line);
        this.eYi.setVisibility(8);
        this.eYk = this.eYe.findViewById(R.id.dialog_header);
        this.mItems = new ArrayList();
        this.eYj = (TextView) this.eYe.findViewById(R.id.dialog_bottom_cancel_button);
        int equipmentWidth = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.eYd) - (g.eXN * 4)) / 2;
        ((LinearLayout.LayoutParams) this.eYf.getLayoutParams()).leftMargin = equipmentWidth;
        ((LinearLayout.LayoutParams) this.eYf.getLayoutParams()).rightMargin = equipmentWidth;
        ((FrameLayout.LayoutParams) this.eYg.getLayoutParams()).leftMargin = equipmentWidth;
        ((FrameLayout.LayoutParams) this.eYg.getLayoutParams()).rightMargin = equipmentWidth;
    }

    public Context getContext() {
        return this.eYd;
    }

    public ViewGroup getView() {
        return this.eYf;
    }

    public View getRootView() {
        return this.eYe;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(SpannableStringBuilder spannableStringBuilder) {
        this.eYl = spannableStringBuilder;
    }

    public void a(c cVar) {
        this.eYm = cVar;
    }

    public c bur() {
        return this.eYm;
    }

    public void bB(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.eYf.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.eYf.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void k(List<? extends j> list, boolean z) {
        if (z && com.baidu.tbadk.a.d.bmU()) {
            bC(list);
        } else {
            bB(list);
        }
    }

    private void bC(List<? extends j> list) {
        boolean z;
        boolean z2;
        int i;
        if (list != null) {
            buq();
            this.mItems = list;
            this.eYf.removeAllViews();
            this.eYg.removeAllViews();
            if (list.size() < 2) {
                z2 = false;
                z = false;
            } else {
                z = ((g) list.get(0)).getId() == -1;
                z2 = ((g) list.get(1)).getId() == -2;
            }
            this.eYi.setVisibility(z ? 0 : 8);
            if (z) {
                i = z2 ? 4 : 3;
            } else {
                i = 0;
            }
            boolean z3 = list.size() - i > 4;
            for (int i2 = 0; i2 < list.size(); i2++) {
                g gVar = (g) list.get(i2);
                gVar.setCanScroll(z3);
                gVar.bul();
                if (gVar != null) {
                    if (i2 < i) {
                        this.eYf.addView(gVar.getView());
                    } else {
                        this.eYg.addView(gVar.getView());
                    }
                }
            }
        }
    }

    public void a(a aVar) {
        this.eYn = aVar;
    }

    public void onChangeSkinType() {
        if (this.eYo) {
            ao.setBackgroundResource(this.eYh, R.color.CAM_X0209);
            ao.setBackgroundResource(this.eYk, R.color.CAM_X0209);
            ao.setBackgroundColor(this.eYi, R.color.CAM_X0203);
        } else {
            ao.setBackgroundResource(this.eYh, R.color.CAM_X0204);
            ao.setViewTextColor(this.eYh, R.color.CAM_X0109);
            ao.setBackgroundResource(this.eYk, R.color.CAM_X0204);
            ao.setBackgroundColor(this.eYi, R.color.CAM_X0204);
        }
        ao.setBackgroundResource(this.eYj, R.color.CAM_X0204);
        ao.n(this.eYj, R.color.CAM_X0107);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View bus() {
        if (!StringUtils.isNull(this.titleText)) {
            this.eYh.setText(this.titleText);
        } else if (this.eYl != null) {
            this.eYh.setText(this.eYl);
        } else {
            this.eYh.setVisibility(8);
        }
        if (this.eYn != null) {
            this.eYj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.eYn.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.eYe;
    }
}
