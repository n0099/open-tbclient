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
    private TextView cKR;
    private Context cVJ;
    private ViewGroup cVK;
    private LinearLayout cVL;
    private View cVM;
    private TextView cVN;
    private c cVO;
    private a cVP;
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
            this.cVJ = context;
            this.cVK = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.cVL = (LinearLayout) this.cVK.findViewById(R.id.content_view);
            this.cKR = (TextView) this.cVK.findViewById(R.id.title);
            this.cVM = this.cVK.findViewById(R.id.title_divide_line);
            this.cVM.setVisibility(8);
            this.mItems = new ArrayList();
            this.cVN = (TextView) this.cVK.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.cVJ;
    }

    public ViewGroup getView() {
        return this.cVL;
    }

    public View getRootView() {
        return this.cVK;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.cVO = cVar;
    }

    public c aEQ() {
        return this.cVO;
    }

    public void az(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.cVL.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.cVL.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.cVP = aVar;
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.cKR, R.color.cp_bg_line_k);
        am.setViewTextColor(this.cKR, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.cVM, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cVN, R.color.cp_bg_line_k);
        am.setViewTextColor(this.cVN, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View aER() {
        if (!StringUtils.isNull(this.titleText)) {
            this.cKR.setText(this.titleText);
        } else {
            this.cKR.setVisibility(8);
        }
        if (this.cVP != null) {
            this.cVN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.cVP.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.cVK;
    }
}
