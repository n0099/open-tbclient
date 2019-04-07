package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private List<? extends h> aMJ;
    private Context bFC;
    private ViewGroup bFD;
    private LinearLayout bFE;
    private View bFF;
    private TextView bFG;
    private c bFH;
    private a bFI;
    private TextView buc;
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
        void a(i iVar, int i, View view);
    }

    public i(Context context) {
        if (context != null) {
            this.bFC = context;
            this.bFD = (ViewGroup) LayoutInflater.from(context).inflate(d.h.popup_dialog_view, (ViewGroup) null);
            this.bFE = (LinearLayout) this.bFD.findViewById(d.g.content_view);
            this.buc = (TextView) this.bFD.findViewById(d.g.title);
            this.bFF = this.bFD.findViewById(d.g.title_divide_line);
            this.bFF.setVisibility(8);
            this.aMJ = new ArrayList();
            this.bFG = (TextView) this.bFD.findViewById(d.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.bFC;
    }

    public ViewGroup abf() {
        return this.bFE;
    }

    public View getRootView() {
        return this.bFD;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.bFH = cVar;
    }

    public c abg() {
        return this.bFH;
    }

    public void P(List<? extends h> list) {
        if (list != null) {
            this.aMJ = list;
            this.bFE.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    h hVar = list.get(i2);
                    if (hVar != null) {
                        this.bFE.addView(hVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.bFI = aVar;
    }

    public void onChangeSkinType() {
        al.k(this.buc, d.C0277d.cp_bg_line_d);
        al.j(this.buc, d.C0277d.cp_cont_c);
        al.l(this.bFF, d.C0277d.cp_bg_line_c);
        al.k(this.bFG, d.C0277d.cp_bg_line_d);
        al.j(this.bFG, d.C0277d.cp_cont_j);
        if (this.aMJ != null) {
            for (h hVar : this.aMJ) {
                hVar.onChangeSkinType();
            }
        }
    }

    public View abh() {
        if (!StringUtils.isNull(this.titleText)) {
            this.buc.setText(this.titleText);
        } else {
            this.buc.setVisibility(8);
        }
        if (this.bFI != null) {
            this.bFG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.i.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    i.this.bFI.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.bFD;
    }
}
