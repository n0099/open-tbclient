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
    private List<? extends h> aMK;
    private Context bFD;
    private ViewGroup bFE;
    private LinearLayout bFF;
    private View bFG;
    private TextView bFH;
    private c bFI;
    private a bFJ;
    private TextView bud;
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
            this.bFD = context;
            this.bFE = (ViewGroup) LayoutInflater.from(context).inflate(d.h.popup_dialog_view, (ViewGroup) null);
            this.bFF = (LinearLayout) this.bFE.findViewById(d.g.content_view);
            this.bud = (TextView) this.bFE.findViewById(d.g.title);
            this.bFG = this.bFE.findViewById(d.g.title_divide_line);
            this.bFG.setVisibility(8);
            this.aMK = new ArrayList();
            this.bFH = (TextView) this.bFE.findViewById(d.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.bFD;
    }

    public ViewGroup abf() {
        return this.bFF;
    }

    public View getRootView() {
        return this.bFE;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.bFI = cVar;
    }

    public c abg() {
        return this.bFI;
    }

    public void P(List<? extends h> list) {
        if (list != null) {
            this.aMK = list;
            this.bFF.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    h hVar = list.get(i2);
                    if (hVar != null) {
                        this.bFF.addView(hVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.bFJ = aVar;
    }

    public void onChangeSkinType() {
        al.k(this.bud, d.C0277d.cp_bg_line_d);
        al.j(this.bud, d.C0277d.cp_cont_c);
        al.l(this.bFG, d.C0277d.cp_bg_line_c);
        al.k(this.bFH, d.C0277d.cp_bg_line_d);
        al.j(this.bFH, d.C0277d.cp_cont_j);
        if (this.aMK != null) {
            for (h hVar : this.aMK) {
                hVar.onChangeSkinType();
            }
        }
    }

    public View abh() {
        if (!StringUtils.isNull(this.titleText)) {
            this.bud.setText(this.titleText);
        } else {
            this.bud.setVisibility(8);
        }
        if (this.bFJ != null) {
            this.bFH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.i.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    i.this.bFJ.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.bFE;
    }
}
