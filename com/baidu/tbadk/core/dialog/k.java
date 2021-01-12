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
    private SpannableStringBuilder eTA;
    private c eTB;
    private a eTC;
    private boolean eTD = false;
    private Context eTs;
    private RoundLinearLayout eTt;
    private LinearLayout eTu;
    private LinearLayout eTv;
    private EMTextView eTw;
    private View eTx;
    private TextView eTy;
    private View eTz;
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
            this.eTs = context;
            init();
        }
    }

    private void init() {
        this.eTt = (RoundLinearLayout) LayoutInflater.from(this.eTs).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.eTt).od(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        this.eTu = (LinearLayout) this.eTt.findViewById(R.id.content_view);
        this.eTw = (EMTextView) this.eTt.findViewById(R.id.title);
        this.eTx = this.eTt.findViewById(R.id.title_divide_line);
        this.eTx.setVisibility(8);
        this.eTz = this.eTt.findViewById(R.id.dialog_header);
        this.mItems = new ArrayList();
        this.eTy = (TextView) this.eTt.findViewById(R.id.dialog_bottom_cancel_button);
    }

    private void bqw() {
        this.eTD = true;
        this.eTt = (RoundLinearLayout) LayoutInflater.from(this.eTs).inflate(R.layout.popup_dialog_view_horizal, (ViewGroup) null);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.eTt).od(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        this.eTu = (LinearLayout) this.eTt.findViewById(R.id.content_view);
        this.eTv = (LinearLayout) this.eTt.findViewById(R.id.content_view_second);
        this.eTw = (EMTextView) this.eTt.findViewById(R.id.title);
        this.eTx = this.eTt.findViewById(R.id.title_divide_line);
        this.eTx.setVisibility(8);
        this.eTz = this.eTt.findViewById(R.id.dialog_header);
        this.mItems = new ArrayList();
        this.eTy = (TextView) this.eTt.findViewById(R.id.dialog_bottom_cancel_button);
        int equipmentWidth = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.eTs) - (g.eTc * 4)) / 2;
        ((LinearLayout.LayoutParams) this.eTu.getLayoutParams()).leftMargin = equipmentWidth;
        ((LinearLayout.LayoutParams) this.eTu.getLayoutParams()).rightMargin = equipmentWidth;
        ((FrameLayout.LayoutParams) this.eTv.getLayoutParams()).leftMargin = equipmentWidth;
        ((FrameLayout.LayoutParams) this.eTv.getLayoutParams()).rightMargin = equipmentWidth;
    }

    public Context getContext() {
        return this.eTs;
    }

    public ViewGroup getView() {
        return this.eTu;
    }

    public View getRootView() {
        return this.eTt;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(SpannableStringBuilder spannableStringBuilder) {
        this.eTA = spannableStringBuilder;
    }

    public void a(c cVar) {
        this.eTB = cVar;
    }

    public c bqx() {
        return this.eTB;
    }

    public void bB(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.eTu.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.eTu.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void k(List<? extends j> list, boolean z) {
        if (z && com.baidu.tbadk.a.d.bja()) {
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
            bqw();
            this.mItems = list;
            this.eTu.removeAllViews();
            this.eTv.removeAllViews();
            if (list.size() < 2) {
                z2 = false;
                z = false;
            } else {
                z = ((g) list.get(0)).getId() == -1;
                z2 = ((g) list.get(1)).getId() == -2;
            }
            this.eTx.setVisibility(z ? 0 : 8);
            if (z) {
                i = z2 ? 4 : 3;
            } else {
                i = 0;
            }
            boolean z3 = list.size() - i > 4;
            for (int i2 = 0; i2 < list.size(); i2++) {
                g gVar = (g) list.get(i2);
                gVar.setCanScroll(z3);
                gVar.bqr();
                if (gVar != null) {
                    if (i2 < i) {
                        this.eTu.addView(gVar.getView());
                    } else {
                        this.eTv.addView(gVar.getView());
                    }
                }
            }
        }
    }

    public void a(a aVar) {
        this.eTC = aVar;
    }

    public void onChangeSkinType() {
        if (this.eTD) {
            ao.setBackgroundResource(this.eTw, R.color.CAM_X0209);
            ao.setBackgroundResource(this.eTz, R.color.CAM_X0209);
            ao.setBackgroundColor(this.eTx, R.color.CAM_X0203);
        } else {
            ao.setBackgroundResource(this.eTw, R.color.CAM_X0204);
            ao.setViewTextColor(this.eTw, R.color.CAM_X0109);
            ao.setBackgroundResource(this.eTz, R.color.CAM_X0204);
            ao.setBackgroundColor(this.eTx, R.color.CAM_X0204);
        }
        ao.setBackgroundResource(this.eTy, R.color.CAM_X0204);
        ao.n(this.eTy, R.color.CAM_X0107);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View bqy() {
        if (!StringUtils.isNull(this.titleText)) {
            this.eTw.setText(this.titleText);
        } else if (this.eTA != null) {
            this.eTw.setText(this.eTA);
        } else {
            this.eTw.setVisibility(8);
        }
        if (this.eTC != null) {
            this.eTy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.eTC.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.eTt;
    }
}
