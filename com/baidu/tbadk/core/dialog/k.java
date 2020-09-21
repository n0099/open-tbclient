package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k {
    private TextView dUN;
    private Context eii;
    private ViewGroup eij;
    private LinearLayout eik;
    private View eil;
    private TextView eim;
    private c ein;
    private a eio;
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
            this.eii = context;
            this.eij = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.eik = (LinearLayout) this.eij.findViewById(R.id.content_view);
            this.dUN = (TextView) this.eij.findViewById(R.id.title);
            this.eil = this.eij.findViewById(R.id.title_divide_line);
            this.eil.setVisibility(8);
            this.mItems = new ArrayList();
            this.eim = (TextView) this.eij.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.eii;
    }

    public ViewGroup getView() {
        return this.eik;
    }

    public View getRootView() {
        return this.eij;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.ein = cVar;
    }

    public c bip() {
        return this.ein;
    }

    public void aX(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.eik.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.eik.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.eio = aVar;
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.dUN, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.dUN, R.color.cp_cont_c);
        ap.setBackgroundColor(this.eil, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.eim, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.eim, R.color.cp_cont_j);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View biq() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dUN.setText(this.titleText);
        } else {
            this.dUN.setVisibility(8);
        }
        if (this.eio != null) {
            this.eim.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.eio.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.eij;
    }
}
