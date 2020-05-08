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
    private TextView dko;
    private Context dvm;
    private ViewGroup dvn;
    private LinearLayout dvo;
    private View dvp;
    private TextView dvq;
    private c dvr;
    private a dvs;
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
            this.dvm = context;
            this.dvn = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.dvo = (LinearLayout) this.dvn.findViewById(R.id.content_view);
            this.dko = (TextView) this.dvn.findViewById(R.id.title);
            this.dvp = this.dvn.findViewById(R.id.title_divide_line);
            this.dvp.setVisibility(8);
            this.mItems = new ArrayList();
            this.dvq = (TextView) this.dvn.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.dvm;
    }

    public ViewGroup getView() {
        return this.dvo;
    }

    public View getRootView() {
        return this.dvn;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.dvr = cVar;
    }

    public c aNg() {
        return this.dvr;
    }

    public void aI(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.dvo.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.dvo.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.dvs = aVar;
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.dko, R.color.cp_bg_line_k);
        am.setViewTextColor(this.dko, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.dvp, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dvq, R.color.cp_bg_line_k);
        am.setViewTextColor(this.dvq, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View aNh() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dko.setText(this.titleText);
        } else {
            this.dko.setVisibility(8);
        }
        if (this.dvs != null) {
            this.dvq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.dvs.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.dvn;
    }
}
