package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k {
    private TextView cKS;
    private Context cVK;
    private ViewGroup cVL;
    private LinearLayout cVM;
    private View cVN;
    private TextView cVO;
    private c cVP;
    private a cVQ;
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
            this.cVK = context;
            this.cVL = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.cVM = (LinearLayout) this.cVL.findViewById(R.id.content_view);
            this.cKS = (TextView) this.cVL.findViewById(R.id.title);
            this.cVN = this.cVL.findViewById(R.id.title_divide_line);
            this.cVN.setVisibility(8);
            this.mItems = new ArrayList();
            this.cVO = (TextView) this.cVL.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.cVK;
    }

    public ViewGroup getView() {
        return this.cVM;
    }

    public View getRootView() {
        return this.cVL;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.cVP = cVar;
    }

    public c aEQ() {
        return this.cVP;
    }

    public void az(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.cVM.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.cVM.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.cVQ = aVar;
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.cKS, R.color.cp_bg_line_k);
        am.setViewTextColor(this.cKS, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.cVN, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cVO, R.color.cp_bg_line_k);
        am.setViewTextColor(this.cVO, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View aER() {
        if (!StringUtils.isNull(this.titleText)) {
            this.cKS.setText(this.titleText);
        } else {
            this.cKS.setVisibility(8);
        }
        if (this.cVQ != null) {
            this.cVO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.cVQ.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.cVL;
    }
}
