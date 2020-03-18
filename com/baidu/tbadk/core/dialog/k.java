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
    private TextView cLd;
    private Context cVX;
    private ViewGroup cVY;
    private LinearLayout cVZ;
    private View cWa;
    private TextView cWb;
    private c cWc;
    private a cWd;
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
            this.cVX = context;
            this.cVY = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.cVZ = (LinearLayout) this.cVY.findViewById(R.id.content_view);
            this.cLd = (TextView) this.cVY.findViewById(R.id.title);
            this.cWa = this.cVY.findViewById(R.id.title_divide_line);
            this.cWa.setVisibility(8);
            this.mItems = new ArrayList();
            this.cWb = (TextView) this.cVY.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.cVX;
    }

    public ViewGroup getView() {
        return this.cVZ;
    }

    public View getRootView() {
        return this.cVY;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.cWc = cVar;
    }

    public c aEU() {
        return this.cWc;
    }

    public void az(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.cVZ.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.cVZ.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.cWd = aVar;
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.cLd, R.color.cp_bg_line_k);
        am.setViewTextColor(this.cLd, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.cWa, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cWb, R.color.cp_bg_line_k);
        am.setViewTextColor(this.cWb, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View aEV() {
        if (!StringUtils.isNull(this.titleText)) {
            this.cLd.setText(this.titleText);
        } else {
            this.cLd.setVisibility(8);
        }
        if (this.cWd != null) {
            this.cWb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.cWd.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.cVY;
    }
}
