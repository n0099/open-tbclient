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
    private Context eVI;
    private RoundLinearLayout eVJ;
    private LinearLayout eVK;
    private LinearLayout eVL;
    private EMTextView eVM;
    private View eVN;
    private TextView eVO;
    private View eVP;
    private SpannableStringBuilder eVQ;
    private c eVR;
    private a eVS;
    private boolean eVT = false;
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
            this.eVI = context;
            init();
        }
    }

    private void init() {
        this.eVJ = (RoundLinearLayout) LayoutInflater.from(this.eVI).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
        com.baidu.tbadk.core.elementsMaven.c.br(this.eVJ).og(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        this.eVK = (LinearLayout) this.eVJ.findViewById(R.id.content_view);
        this.eVM = (EMTextView) this.eVJ.findViewById(R.id.title);
        this.eVN = this.eVJ.findViewById(R.id.title_divide_line);
        this.eVN.setVisibility(8);
        this.eVP = this.eVJ.findViewById(R.id.dialog_header);
        this.mItems = new ArrayList();
        this.eVO = (TextView) this.eVJ.findViewById(R.id.dialog_bottom_cancel_button);
    }

    private void bqP() {
        this.eVT = true;
        this.eVJ = (RoundLinearLayout) LayoutInflater.from(this.eVI).inflate(R.layout.popup_dialog_view_horizal, (ViewGroup) null);
        com.baidu.tbadk.core.elementsMaven.c.br(this.eVJ).og(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        this.eVK = (LinearLayout) this.eVJ.findViewById(R.id.content_view);
        this.eVL = (LinearLayout) this.eVJ.findViewById(R.id.content_view_second);
        this.eVM = (EMTextView) this.eVJ.findViewById(R.id.title);
        this.eVN = this.eVJ.findViewById(R.id.title_divide_line);
        this.eVN.setVisibility(8);
        this.eVP = this.eVJ.findViewById(R.id.dialog_header);
        this.mItems = new ArrayList();
        this.eVO = (TextView) this.eVJ.findViewById(R.id.dialog_bottom_cancel_button);
        int equipmentWidth = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.eVI) - (g.eVs * 4)) / 2;
        ((LinearLayout.LayoutParams) this.eVK.getLayoutParams()).leftMargin = equipmentWidth;
        ((LinearLayout.LayoutParams) this.eVK.getLayoutParams()).rightMargin = equipmentWidth;
        ((FrameLayout.LayoutParams) this.eVL.getLayoutParams()).leftMargin = equipmentWidth;
        ((FrameLayout.LayoutParams) this.eVL.getLayoutParams()).rightMargin = equipmentWidth;
    }

    public Context getContext() {
        return this.eVI;
    }

    public ViewGroup getView() {
        return this.eVK;
    }

    public View getRootView() {
        return this.eVJ;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(SpannableStringBuilder spannableStringBuilder) {
        this.eVQ = spannableStringBuilder;
    }

    public void a(c cVar) {
        this.eVR = cVar;
    }

    public c bqQ() {
        return this.eVR;
    }

    public void bw(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.eVK.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.eVK.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void k(List<? extends j> list, boolean z) {
        if (z && com.baidu.tbadk.a.d.bjm()) {
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
            bqP();
            this.mItems = list;
            this.eVK.removeAllViews();
            this.eVL.removeAllViews();
            if (list.size() < 2) {
                z2 = false;
                z = false;
            } else {
                z = ((g) list.get(0)).getId() == -1;
                z2 = ((g) list.get(1)).getId() == -2;
            }
            this.eVN.setVisibility(z ? 0 : 8);
            if (z) {
                i = z2 ? 4 : 3;
            } else {
                i = 0;
            }
            boolean z3 = list.size() - i > 4;
            for (int i2 = 0; i2 < list.size(); i2++) {
                g gVar = (g) list.get(i2);
                gVar.setCanScroll(z3);
                gVar.bqK();
                if (gVar != null) {
                    if (i2 < i) {
                        this.eVK.addView(gVar.getView());
                    } else {
                        this.eVL.addView(gVar.getView());
                    }
                }
            }
        }
    }

    public void a(a aVar) {
        this.eVS = aVar;
        if (this.eVS != null && this.eVO != null) {
            this.eVO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.eVS.onClick();
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (this.eVT) {
            ap.setBackgroundResource(this.eVM, R.color.CAM_X0209);
            ap.setBackgroundResource(this.eVP, R.color.CAM_X0209);
            ap.setBackgroundColor(this.eVN, R.color.CAM_X0203);
        } else {
            ap.setBackgroundResource(this.eVM, R.color.CAM_X0204);
            ap.setViewTextColor(this.eVM, R.color.CAM_X0109);
            ap.setBackgroundResource(this.eVP, R.color.CAM_X0204);
            ap.setBackgroundColor(this.eVN, R.color.CAM_X0204);
        }
        ap.setBackgroundResource(this.eVO, R.color.CAM_X0204);
        ap.n(this.eVO, R.color.CAM_X0107);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View bqR() {
        if (!StringUtils.isNull(this.titleText)) {
            this.eVM.setText(this.titleText);
        } else if (this.eVQ != null) {
            this.eVM.setText(this.eVQ);
        } else {
            this.eVM.setVisibility(8);
        }
        if (this.eVS != null) {
            this.eVO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.eVS.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.eVJ;
    }
}
