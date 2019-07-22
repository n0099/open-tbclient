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
    private List<? extends j> aPr;
    private TextView bCd;
    private Context bOf;
    private ViewGroup bOg;
    private LinearLayout bOh;
    private View bOi;
    private TextView bOj;
    private c bOk;
    private a bOl;
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
            this.bOf = context;
            this.bOg = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.bOh = (LinearLayout) this.bOg.findViewById(R.id.content_view);
            this.bCd = (TextView) this.bOg.findViewById(R.id.title);
            this.bOi = this.bOg.findViewById(R.id.title_divide_line);
            this.bOi.setVisibility(8);
            this.aPr = new ArrayList();
            this.bOj = (TextView) this.bOg.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.bOf;
    }

    public ViewGroup agZ() {
        return this.bOh;
    }

    public View getRootView() {
        return this.bOg;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.bOk = cVar;
    }

    public c aha() {
        return this.bOk;
    }

    public void W(List<? extends j> list) {
        if (list != null) {
            this.aPr = list;
            this.bOh.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.bOh.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.bOl = aVar;
    }

    public void onChangeSkinType() {
        am.k(this.bCd, R.color.cp_bg_line_d);
        am.j(this.bCd, R.color.cp_cont_c);
        am.l(this.bOi, R.color.cp_bg_line_c);
        am.k(this.bOj, R.color.cp_bg_line_d);
        am.j(this.bOj, R.color.cp_cont_j);
        if (this.aPr != null) {
            for (j jVar : this.aPr) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View ahb() {
        if (!StringUtils.isNull(this.titleText)) {
            this.bCd.setText(this.titleText);
        } else {
            this.bCd.setVisibility(8);
        }
        if (this.bOl != null) {
            this.bOj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.bOl.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.bOg;
    }
}
