package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k {
    private TextView egP;
    private Context euq;
    private ViewGroup eur;
    private LinearLayout eus;
    private View eut;
    private TextView euu;
    private c euv;
    private a euw;
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
            this.euq = context;
            this.eur = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.eus = (LinearLayout) this.eur.findViewById(R.id.content_view);
            this.egP = (TextView) this.eur.findViewById(R.id.title);
            this.eut = this.eur.findViewById(R.id.title_divide_line);
            this.eut.setVisibility(8);
            this.mItems = new ArrayList();
            this.euu = (TextView) this.eur.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.euq;
    }

    public ViewGroup getView() {
        return this.eus;
    }

    public View getRootView() {
        return this.eur;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.euv = cVar;
    }

    public c bkY() {
        return this.euv;
    }

    public void ba(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.eus.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.eus.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.euw = aVar;
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.egP, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.egP, R.color.cp_cont_c);
        ap.setBackgroundColor(this.eut, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.euu, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.euu, R.color.cp_cont_j);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View bkZ() {
        if (!StringUtils.isNull(this.titleText)) {
            this.egP.setText(this.titleText);
        } else {
            this.egP.setVisibility(8);
        }
        if (this.euw != null) {
            this.euu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.euw.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.eur;
    }
}
