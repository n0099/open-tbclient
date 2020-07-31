package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k {
    private TextView dJr;
    private Context dWp;
    private ViewGroup dWq;
    private LinearLayout dWr;
    private View dWs;
    private TextView dWt;
    private c dWu;
    private a dWv;
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
            this.dWp = context;
            this.dWq = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.dWr = (LinearLayout) this.dWq.findViewById(R.id.content_view);
            this.dJr = (TextView) this.dWq.findViewById(R.id.title);
            this.dWs = this.dWq.findViewById(R.id.title_divide_line);
            this.dWs.setVisibility(8);
            this.mItems = new ArrayList();
            this.dWt = (TextView) this.dWq.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.dWp;
    }

    public ViewGroup getView() {
        return this.dWr;
    }

    public View getRootView() {
        return this.dWq;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.dWu = cVar;
    }

    public c aZa() {
        return this.dWu;
    }

    public void aS(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.dWr.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.dWr.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.dWv = aVar;
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this.dJr, R.color.cp_bg_line_k);
        ao.setViewTextColor(this.dJr, R.color.cp_cont_c);
        ao.setBackgroundColor(this.dWs, R.color.cp_bg_line_c);
        ao.setBackgroundResource(this.dWt, R.color.cp_bg_line_k);
        ao.setViewTextColor(this.dWt, R.color.cp_cont_j);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View aZb() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dJr.setText(this.titleText);
        } else {
            this.dJr.setVisibility(8);
        }
        if (this.dWv != null) {
            this.dWt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.dWv.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.dWq;
    }
}
