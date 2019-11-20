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
    private TextView bUf;
    private Context ceY;
    private ViewGroup ceZ;
    private LinearLayout cfa;
    private View cfb;
    private TextView cfc;
    private c cfd;
    private a cfe;
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
            this.ceY = context;
            this.ceZ = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.cfa = (LinearLayout) this.ceZ.findViewById(R.id.content_view);
            this.bUf = (TextView) this.ceZ.findViewById(R.id.title);
            this.cfb = this.ceZ.findViewById(R.id.title_divide_line);
            this.cfb.setVisibility(8);
            this.mItems = new ArrayList();
            this.cfc = (TextView) this.ceZ.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.ceY;
    }

    public ViewGroup ala() {
        return this.cfa;
    }

    public View getRootView() {
        return this.ceZ;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.cfd = cVar;
    }

    public c alb() {
        return this.cfd;
    }

    public void at(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.cfa.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.cfa.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.cfe = aVar;
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.bUf, R.color.cp_bg_line_k);
        am.setViewTextColor(this.bUf, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.cfb, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cfc, R.color.cp_bg_line_k);
        am.setViewTextColor(this.cfc, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View alc() {
        if (!StringUtils.isNull(this.titleText)) {
            this.bUf.setText(this.titleText);
        } else {
            this.bUf.setVisibility(8);
        }
        if (this.cfe != null) {
            this.cfc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.cfe.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.ceZ;
    }
}
