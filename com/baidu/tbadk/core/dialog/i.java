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
    private List<? extends h> aMF;
    private LinearLayout bFA;
    private View bFB;
    private TextView bFC;
    private c bFD;
    private a bFE;
    private Context bFy;
    private ViewGroup bFz;
    private TextView btX;
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
            this.bFy = context;
            this.bFz = (ViewGroup) LayoutInflater.from(context).inflate(d.h.popup_dialog_view, (ViewGroup) null);
            this.bFA = (LinearLayout) this.bFz.findViewById(d.g.content_view);
            this.btX = (TextView) this.bFz.findViewById(d.g.title);
            this.bFB = this.bFz.findViewById(d.g.title_divide_line);
            this.bFB.setVisibility(8);
            this.aMF = new ArrayList();
            this.bFC = (TextView) this.bFz.findViewById(d.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.bFy;
    }

    public ViewGroup abi() {
        return this.bFA;
    }

    public View getRootView() {
        return this.bFz;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.bFD = cVar;
    }

    public c abj() {
        return this.bFD;
    }

    public void P(List<? extends h> list) {
        if (list != null) {
            this.aMF = list;
            this.bFA.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    h hVar = list.get(i2);
                    if (hVar != null) {
                        this.bFA.addView(hVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.bFE = aVar;
    }

    public void onChangeSkinType() {
        al.k(this.btX, d.C0236d.cp_bg_line_d);
        al.j(this.btX, d.C0236d.cp_cont_c);
        al.l(this.bFB, d.C0236d.cp_bg_line_c);
        al.k(this.bFC, d.C0236d.cp_bg_line_d);
        al.j(this.bFC, d.C0236d.cp_cont_j);
        if (this.aMF != null) {
            for (h hVar : this.aMF) {
                hVar.onChangeSkinType();
            }
        }
    }

    public View abk() {
        if (!StringUtils.isNull(this.titleText)) {
            this.btX.setText(this.titleText);
        } else {
            this.btX.setVisibility(8);
        }
        if (this.bFE != null) {
            this.bFC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.i.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    i.this.bFE.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.bFz;
    }
}
