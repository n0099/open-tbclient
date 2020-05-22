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
    private Context dJh;
    private ViewGroup dJi;
    private LinearLayout dJj;
    private View dJk;
    private TextView dJl;
    private c dJm;
    private a dJn;
    private TextView dyo;
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
            this.dJh = context;
            this.dJi = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.dJj = (LinearLayout) this.dJi.findViewById(R.id.content_view);
            this.dyo = (TextView) this.dJi.findViewById(R.id.title);
            this.dJk = this.dJi.findViewById(R.id.title_divide_line);
            this.dJk.setVisibility(8);
            this.mItems = new ArrayList();
            this.dJl = (TextView) this.dJi.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.dJh;
    }

    public ViewGroup getView() {
        return this.dJj;
    }

    public View getRootView() {
        return this.dJi;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.dJm = cVar;
    }

    public c aTg() {
        return this.dJm;
    }

    public void aD(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.dJj.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.dJj.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.dJn = aVar;
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.dyo, R.color.cp_bg_line_k);
        am.setViewTextColor(this.dyo, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.dJk, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dJl, R.color.cp_bg_line_k);
        am.setViewTextColor(this.dJl, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View aTh() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dyo.setText(this.titleText);
        } else {
            this.dyo.setVisibility(8);
        }
        if (this.dJn != null) {
            this.dJl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.dJn.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.dJi;
    }
}
