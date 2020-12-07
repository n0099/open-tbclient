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
    private Context eOg;
    private RoundLinearLayout eOh;
    private LinearLayout eOi;
    private LinearLayout eOj;
    private EMTextView eOk;
    private View eOl;
    private TextView eOm;
    private View eOn;
    private SpannableStringBuilder eOo;
    private c eOp;
    private a eOq;
    private boolean eOr = false;
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
            this.eOg = context;
            init();
        }
    }

    private void init() {
        this.eOh = (RoundLinearLayout) LayoutInflater.from(this.eOg).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.eOh).pA(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        this.eOi = (LinearLayout) this.eOh.findViewById(R.id.content_view);
        this.eOk = (EMTextView) this.eOh.findViewById(R.id.title);
        this.eOl = this.eOh.findViewById(R.id.title_divide_line);
        this.eOl.setVisibility(8);
        this.eOn = this.eOh.findViewById(R.id.dialog_header);
        this.mItems = new ArrayList();
        this.eOm = (TextView) this.eOh.findViewById(R.id.dialog_bottom_cancel_button);
    }

    private void brN() {
        this.eOr = true;
        this.eOh = (RoundLinearLayout) LayoutInflater.from(this.eOg).inflate(R.layout.popup_dialog_view_horizal, (ViewGroup) null);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.eOh).pA(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        this.eOi = (LinearLayout) this.eOh.findViewById(R.id.content_view);
        this.eOj = (LinearLayout) this.eOh.findViewById(R.id.content_view_second);
        this.eOk = (EMTextView) this.eOh.findViewById(R.id.title);
        this.eOl = this.eOh.findViewById(R.id.title_divide_line);
        this.eOl.setVisibility(8);
        this.eOn = this.eOh.findViewById(R.id.dialog_header);
        this.mItems = new ArrayList();
        this.eOm = (TextView) this.eOh.findViewById(R.id.dialog_bottom_cancel_button);
        int equipmentWidth = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.eOg) - (g.eNQ * 4)) / 2;
        ((LinearLayout.LayoutParams) this.eOi.getLayoutParams()).leftMargin = equipmentWidth;
        ((LinearLayout.LayoutParams) this.eOi.getLayoutParams()).rightMargin = equipmentWidth;
        ((FrameLayout.LayoutParams) this.eOj.getLayoutParams()).leftMargin = equipmentWidth;
        ((FrameLayout.LayoutParams) this.eOj.getLayoutParams()).rightMargin = equipmentWidth;
    }

    public Context getContext() {
        return this.eOg;
    }

    public ViewGroup getView() {
        return this.eOi;
    }

    public View getRootView() {
        return this.eOh;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(SpannableStringBuilder spannableStringBuilder) {
        this.eOo = spannableStringBuilder;
    }

    public void a(c cVar) {
        this.eOp = cVar;
    }

    public c brO() {
        return this.eOp;
    }

    public void bu(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.eOi.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.eOi.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void k(List<? extends j> list, boolean z) {
        if (z && com.baidu.tbadk.a.d.bkG()) {
            bv(list);
        } else {
            bu(list);
        }
    }

    private void bv(List<? extends j> list) {
        boolean z;
        boolean z2;
        int i;
        if (list != null) {
            brN();
            this.mItems = list;
            this.eOi.removeAllViews();
            this.eOj.removeAllViews();
            if (list.size() < 2) {
                z2 = false;
                z = false;
            } else {
                z = ((g) list.get(0)).getId() == -1;
                z2 = ((g) list.get(1)).getId() == -2;
            }
            this.eOl.setVisibility(z ? 0 : 8);
            if (z) {
                i = z2 ? 4 : 3;
            } else {
                i = 0;
            }
            boolean z3 = list.size() - i > 4;
            for (int i2 = 0; i2 < list.size(); i2++) {
                g gVar = (g) list.get(i2);
                gVar.setCanScroll(z3);
                gVar.brI();
                if (gVar != null) {
                    if (i2 < i) {
                        this.eOi.addView(gVar.getView());
                    } else {
                        this.eOj.addView(gVar.getView());
                    }
                }
            }
        }
    }

    public void a(a aVar) {
        this.eOq = aVar;
    }

    public void onChangeSkinType() {
        if (this.eOr) {
            ap.setBackgroundResource(this.eOk, R.color.CAM_X0209);
            ap.setBackgroundResource(this.eOn, R.color.CAM_X0209);
            ap.setBackgroundColor(this.eOl, R.color.CAM_X0203);
        } else {
            ap.setBackgroundResource(this.eOk, R.color.CAM_X0204);
            ap.setViewTextColor(this.eOk, R.color.CAM_X0109);
            ap.setBackgroundResource(this.eOn, R.color.CAM_X0204);
            ap.setBackgroundColor(this.eOl, R.color.CAM_X0204);
        }
        ap.setBackgroundResource(this.eOm, R.color.CAM_X0204);
        ap.k(this.eOm, R.color.CAM_X0107);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View brP() {
        if (!StringUtils.isNull(this.titleText)) {
            this.eOk.setText(this.titleText);
        } else if (this.eOo != null) {
            this.eOk.setText(this.eOo);
        } else {
            this.eOk.setVisibility(8);
        }
        if (this.eOq != null) {
            this.eOm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.eOq.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.eOh;
    }
}
