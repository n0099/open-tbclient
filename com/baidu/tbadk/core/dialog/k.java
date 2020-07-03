package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k {
    private TextView dDu;
    private Context dPX;
    private ViewGroup dPY;
    private LinearLayout dPZ;
    private View dQa;
    private TextView dQb;
    private c dQc;
    private a dQd;
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
            this.dPX = context;
            this.dPY = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.dPZ = (LinearLayout) this.dPY.findViewById(R.id.content_view);
            this.dDu = (TextView) this.dPY.findViewById(R.id.title);
            this.dQa = this.dPY.findViewById(R.id.title_divide_line);
            this.dQa.setVisibility(8);
            this.mItems = new ArrayList();
            this.dQb = (TextView) this.dPY.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.dPX;
    }

    public ViewGroup getView() {
        return this.dPZ;
    }

    public View getRootView() {
        return this.dPY;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.dQc = cVar;
    }

    public c aVa() {
        return this.dQc;
    }

    public void aL(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.dPZ.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.dPZ.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.dQd = aVar;
    }

    public void onChangeSkinType() {
        an.setBackgroundResource(this.dDu, R.color.cp_bg_line_k);
        an.setViewTextColor(this.dDu, (int) R.color.cp_cont_c);
        an.setBackgroundColor(this.dQa, R.color.cp_bg_line_c);
        an.setBackgroundResource(this.dQb, R.color.cp_bg_line_k);
        an.setViewTextColor(this.dQb, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View aVb() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dDu.setText(this.titleText);
        } else {
            this.dDu.setVisibility(8);
        }
        if (this.dQd != null) {
            this.dQb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.dQd.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.dPY;
    }
}
