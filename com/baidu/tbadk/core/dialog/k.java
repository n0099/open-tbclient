package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k {
    private List<? extends j> aOH;
    private TextView bBh;
    private Context bNe;
    private ViewGroup bNf;
    private LinearLayout bNg;
    private View bNh;
    private TextView bNi;
    private c bNj;
    private a bNk;
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
            this.bNe = context;
            this.bNf = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.bNg = (LinearLayout) this.bNf.findViewById(R.id.content_view);
            this.bBh = (TextView) this.bNf.findViewById(R.id.title);
            this.bNh = this.bNf.findViewById(R.id.title_divide_line);
            this.bNh.setVisibility(8);
            this.aOH = new ArrayList();
            this.bNi = (TextView) this.bNf.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.bNe;
    }

    public ViewGroup afX() {
        return this.bNg;
    }

    public View getRootView() {
        return this.bNf;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.bNj = cVar;
    }

    public c afY() {
        return this.bNj;
    }

    public void W(List<? extends j> list) {
        if (list != null) {
            this.aOH = list;
            this.bNg.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.bNg.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.bNk = aVar;
    }

    public void onChangeSkinType() {
        al.k(this.bBh, R.color.cp_bg_line_d);
        al.j(this.bBh, R.color.cp_cont_c);
        al.l(this.bNh, R.color.cp_bg_line_c);
        al.k(this.bNi, R.color.cp_bg_line_d);
        al.j(this.bNi, R.color.cp_cont_j);
        if (this.aOH != null) {
            for (j jVar : this.aOH) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View afZ() {
        if (!StringUtils.isNull(this.titleText)) {
            this.bBh.setText(this.titleText);
        } else {
            this.bBh.setVisibility(8);
        }
        if (this.bNk != null) {
            this.bNi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.bNk.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.bNf;
    }
}
