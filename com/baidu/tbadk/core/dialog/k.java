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
    private Context eIE;
    private ViewGroup eIF;
    private LinearLayout eIG;
    private View eIH;
    private TextView eII;
    private c eIJ;
    private a eIK;
    private TextView evg;
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
            this.eIE = context;
            this.eIF = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.eIG = (LinearLayout) this.eIF.findViewById(R.id.content_view);
            this.evg = (TextView) this.eIF.findViewById(R.id.title);
            this.eIH = this.eIF.findViewById(R.id.title_divide_line);
            this.eIH.setVisibility(8);
            this.mItems = new ArrayList();
            this.eII = (TextView) this.eIF.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.eIE;
    }

    public ViewGroup getView() {
        return this.eIG;
    }

    public View getRootView() {
        return this.eIF;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.eIJ = cVar;
    }

    public c bpr() {
        return this.eIJ;
    }

    public void br(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.eIG.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.eIG.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.eIK = aVar;
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.evg, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.evg, R.color.cp_cont_c);
        ap.setBackgroundColor(this.eIH, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.eII, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.eII, R.color.cp_cont_j);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View bps() {
        if (!StringUtils.isNull(this.titleText)) {
            this.evg.setText(this.titleText);
        } else {
            this.evg.setVisibility(8);
        }
        if (this.eIK != null) {
            this.eII.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.eIK.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.eIF;
    }
}
