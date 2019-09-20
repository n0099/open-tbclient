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
    private List<? extends j> aPP;
    private TextView bCB;
    private Context bOL;
    private ViewGroup bOM;
    private LinearLayout bON;
    private View bOO;
    private TextView bOP;
    private c bOQ;
    private a bOR;
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
            this.bOL = context;
            this.bOM = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.bON = (LinearLayout) this.bOM.findViewById(R.id.content_view);
            this.bCB = (TextView) this.bOM.findViewById(R.id.title);
            this.bOO = this.bOM.findViewById(R.id.title_divide_line);
            this.bOO.setVisibility(8);
            this.aPP = new ArrayList();
            this.bOP = (TextView) this.bOM.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.bOL;
    }

    public ViewGroup ahf() {
        return this.bON;
    }

    public View getRootView() {
        return this.bOM;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.bOQ = cVar;
    }

    public c ahg() {
        return this.bOQ;
    }

    public void W(List<? extends j> list) {
        if (list != null) {
            this.aPP = list;
            this.bON.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.bON.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.bOR = aVar;
    }

    public void onChangeSkinType() {
        am.k(this.bCB, R.color.cp_bg_line_k);
        am.j(this.bCB, R.color.cp_cont_c);
        am.l(this.bOO, R.color.cp_bg_line_c);
        am.k(this.bOP, R.color.cp_bg_line_k);
        am.j(this.bOP, R.color.cp_cont_j);
        if (this.aPP != null) {
            for (j jVar : this.aPP) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View ahh() {
        if (!StringUtils.isNull(this.titleText)) {
            this.bCB.setText(this.titleText);
        } else {
            this.bCB.setVisibility(8);
        }
        if (this.bOR != null) {
            this.bOP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.bOR.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.bOM;
    }
}
