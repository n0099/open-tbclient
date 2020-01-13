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
    private TextView cGN;
    private Context cRG;
    private ViewGroup cRH;
    private LinearLayout cRI;
    private View cRJ;
    private TextView cRK;
    private c cRL;
    private a cRM;
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
            this.cRG = context;
            this.cRH = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.cRI = (LinearLayout) this.cRH.findViewById(R.id.content_view);
            this.cGN = (TextView) this.cRH.findViewById(R.id.title);
            this.cRJ = this.cRH.findViewById(R.id.title_divide_line);
            this.cRJ.setVisibility(8);
            this.mItems = new ArrayList();
            this.cRK = (TextView) this.cRH.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.cRG;
    }

    public ViewGroup aCD() {
        return this.cRI;
    }

    public View getRootView() {
        return this.cRH;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.cRL = cVar;
    }

    public c aCE() {
        return this.cRL;
    }

    public void az(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.cRI.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.cRI.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.cRM = aVar;
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.cGN, R.color.cp_bg_line_k);
        am.setViewTextColor(this.cGN, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.cRJ, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cRK, R.color.cp_bg_line_k);
        am.setViewTextColor(this.cRK, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View aCF() {
        if (!StringUtils.isNull(this.titleText)) {
            this.cGN.setText(this.titleText);
        } else {
            this.cGN.setVisibility(8);
        }
        if (this.cRM != null) {
            this.cRK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.cRM.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.cRH;
    }
}
