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
    private List<? extends h> aMG;
    private Context bFA;
    private ViewGroup bFB;
    private LinearLayout bFC;
    private View bFD;
    private TextView bFE;
    private c bFF;
    private a bFG;
    private TextView btZ;
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
            this.bFA = context;
            this.bFB = (ViewGroup) LayoutInflater.from(context).inflate(d.h.popup_dialog_view, (ViewGroup) null);
            this.bFC = (LinearLayout) this.bFB.findViewById(d.g.content_view);
            this.btZ = (TextView) this.bFB.findViewById(d.g.title);
            this.bFD = this.bFB.findViewById(d.g.title_divide_line);
            this.bFD.setVisibility(8);
            this.aMG = new ArrayList();
            this.bFE = (TextView) this.bFB.findViewById(d.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.bFA;
    }

    public ViewGroup abi() {
        return this.bFC;
    }

    public View getRootView() {
        return this.bFB;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.bFF = cVar;
    }

    public c abj() {
        return this.bFF;
    }

    public void P(List<? extends h> list) {
        if (list != null) {
            this.aMG = list;
            this.bFC.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    h hVar = list.get(i2);
                    if (hVar != null) {
                        this.bFC.addView(hVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.bFG = aVar;
    }

    public void onChangeSkinType() {
        al.k(this.btZ, d.C0277d.cp_bg_line_d);
        al.j(this.btZ, d.C0277d.cp_cont_c);
        al.l(this.bFD, d.C0277d.cp_bg_line_c);
        al.k(this.bFE, d.C0277d.cp_bg_line_d);
        al.j(this.bFE, d.C0277d.cp_cont_j);
        if (this.aMG != null) {
            for (h hVar : this.aMG) {
                hVar.onChangeSkinType();
            }
        }
    }

    public View abk() {
        if (!StringUtils.isNull(this.titleText)) {
            this.btZ.setText(this.titleText);
        } else {
            this.btZ.setVisibility(8);
        }
        if (this.bFG != null) {
            this.bFE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.i.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    i.this.bFG.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.bFB;
    }
}
