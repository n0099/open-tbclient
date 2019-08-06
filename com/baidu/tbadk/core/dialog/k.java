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
    private Context bOk;
    private ViewGroup bOl;
    private LinearLayout bOm;
    private View bOn;
    private TextView bOo;
    private c bOp;
    private a bOq;
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
            this.bOk = context;
            this.bOl = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.bOm = (LinearLayout) this.bOl.findViewById(R.id.content_view);
            this.bCd = (TextView) this.bOl.findViewById(R.id.title);
            this.bOn = this.bOl.findViewById(R.id.title_divide_line);
            this.bOn.setVisibility(8);
            this.aPr = new ArrayList();
            this.bOo = (TextView) this.bOl.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.bOk;
    }

    public ViewGroup ahb() {
        return this.bOm;
    }

    public View getRootView() {
        return this.bOl;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.bOp = cVar;
    }

    public c ahc() {
        return this.bOp;
    }

    public void W(List<? extends j> list) {
        if (list != null) {
            this.aPr = list;
            this.bOm.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.bOm.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.bOq = aVar;
    }

    public void onChangeSkinType() {
        am.k(this.bCd, R.color.cp_bg_line_d);
        am.j(this.bCd, R.color.cp_cont_c);
        am.l(this.bOn, R.color.cp_bg_line_c);
        am.k(this.bOo, R.color.cp_bg_line_d);
        am.j(this.bOo, R.color.cp_cont_j);
        if (this.aPr != null) {
            for (j jVar : this.aPr) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View ahd() {
        if (!StringUtils.isNull(this.titleText)) {
            this.bCd.setText(this.titleText);
        } else {
            this.bCd.setVisibility(8);
        }
        if (this.bOq != null) {
            this.bOo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.bOq.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.bOl;
    }
}
