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
    private Context bNd;
    private ViewGroup bNe;
    private LinearLayout bNf;
    private View bNg;
    private TextView bNh;
    private c bNi;
    private a bNj;
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
            this.bNd = context;
            this.bNe = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.bNf = (LinearLayout) this.bNe.findViewById(R.id.content_view);
            this.bBh = (TextView) this.bNe.findViewById(R.id.title);
            this.bNg = this.bNe.findViewById(R.id.title_divide_line);
            this.bNg.setVisibility(8);
            this.aOH = new ArrayList();
            this.bNh = (TextView) this.bNe.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.bNd;
    }

    public ViewGroup afX() {
        return this.bNf;
    }

    public View getRootView() {
        return this.bNe;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.bNi = cVar;
    }

    public c afY() {
        return this.bNi;
    }

    public void W(List<? extends j> list) {
        if (list != null) {
            this.aOH = list;
            this.bNf.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.bNf.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.bNj = aVar;
    }

    public void onChangeSkinType() {
        al.k(this.bBh, R.color.cp_bg_line_d);
        al.j(this.bBh, R.color.cp_cont_c);
        al.l(this.bNg, R.color.cp_bg_line_c);
        al.k(this.bNh, R.color.cp_bg_line_d);
        al.j(this.bNh, R.color.cp_cont_j);
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
        if (this.bNj != null) {
            this.bNh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.bNj.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.bNe;
    }
}
