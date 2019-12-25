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
    private TextView cGB;
    private TextView cRA;
    private c cRB;
    private a cRC;
    private Context cRw;
    private ViewGroup cRx;
    private LinearLayout cRy;
    private View cRz;
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
            this.cRw = context;
            this.cRx = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.cRy = (LinearLayout) this.cRx.findViewById(R.id.content_view);
            this.cGB = (TextView) this.cRx.findViewById(R.id.title);
            this.cRz = this.cRx.findViewById(R.id.title_divide_line);
            this.cRz.setVisibility(8);
            this.mItems = new ArrayList();
            this.cRA = (TextView) this.cRx.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.cRw;
    }

    public ViewGroup aCk() {
        return this.cRy;
    }

    public View getRootView() {
        return this.cRx;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.cRB = cVar;
    }

    public c aCl() {
        return this.cRB;
    }

    public void aA(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.cRy.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.cRy.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.cRC = aVar;
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.cGB, R.color.cp_bg_line_k);
        am.setViewTextColor(this.cGB, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.cRz, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cRA, R.color.cp_bg_line_k);
        am.setViewTextColor(this.cRA, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View aCm() {
        if (!StringUtils.isNull(this.titleText)) {
            this.cGB.setText(this.titleText);
        } else {
            this.cGB.setVisibility(8);
        }
        if (this.cRC != null) {
            this.cRA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.cRC.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.cRx;
    }
}
