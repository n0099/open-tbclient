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
    private TextView cKQ;
    private Context cVI;
    private ViewGroup cVJ;
    private LinearLayout cVK;
    private View cVL;
    private TextView cVM;
    private c cVN;
    private a cVO;
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
            this.cVI = context;
            this.cVJ = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.cVK = (LinearLayout) this.cVJ.findViewById(R.id.content_view);
            this.cKQ = (TextView) this.cVJ.findViewById(R.id.title);
            this.cVL = this.cVJ.findViewById(R.id.title_divide_line);
            this.cVL.setVisibility(8);
            this.mItems = new ArrayList();
            this.cVM = (TextView) this.cVJ.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.cVI;
    }

    public ViewGroup getView() {
        return this.cVK;
    }

    public View getRootView() {
        return this.cVJ;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.cVN = cVar;
    }

    public c aEO() {
        return this.cVN;
    }

    public void az(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.cVK.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.cVK.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.cVO = aVar;
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.cKQ, R.color.cp_bg_line_k);
        am.setViewTextColor(this.cKQ, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.cVL, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cVM, R.color.cp_bg_line_k);
        am.setViewTextColor(this.cVM, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View aEP() {
        if (!StringUtils.isNull(this.titleText)) {
            this.cKQ.setText(this.titleText);
        } else {
            this.cKQ.setVisibility(8);
        }
        if (this.cVO != null) {
            this.cVM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.cVO.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.cVJ;
    }
}
