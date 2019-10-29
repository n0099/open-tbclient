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
    private TextView bUW;
    private Context cfP;
    private ViewGroup cfQ;
    private LinearLayout cfR;
    private View cfS;
    private TextView cfT;
    private c cfU;
    private a cfV;
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
            this.cfP = context;
            this.cfQ = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.cfR = (LinearLayout) this.cfQ.findViewById(R.id.content_view);
            this.bUW = (TextView) this.cfQ.findViewById(R.id.title);
            this.cfS = this.cfQ.findViewById(R.id.title_divide_line);
            this.cfS.setVisibility(8);
            this.mItems = new ArrayList();
            this.cfT = (TextView) this.cfQ.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.cfP;
    }

    public ViewGroup alc() {
        return this.cfR;
    }

    public View getRootView() {
        return this.cfQ;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.cfU = cVar;
    }

    public c ald() {
        return this.cfU;
    }

    public void at(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.cfR.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.cfR.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.cfV = aVar;
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.bUW, R.color.cp_bg_line_k);
        am.setViewTextColor(this.bUW, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.cfS, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cfT, R.color.cp_bg_line_k);
        am.setViewTextColor(this.cfT, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View ale() {
        if (!StringUtils.isNull(this.titleText)) {
            this.bUW.setText(this.titleText);
        } else {
            this.bUW.setVisibility(8);
        }
        if (this.cfV != null) {
            this.cfT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.cfV.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.cfQ;
    }
}
