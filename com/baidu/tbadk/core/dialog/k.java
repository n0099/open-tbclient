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
/* loaded from: classes2.dex */
public class k {
    private TextView dSz;
    private Context efP;
    private ViewGroup efQ;
    private LinearLayout efR;
    private View efS;
    private TextView efT;
    private c efU;
    private a efV;
    private List<? extends j> mItems;
    private String titleText;

    /* loaded from: classes2.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onClick();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(k kVar, int i, View view);
    }

    public k(Context context) {
        if (context != null) {
            this.efP = context;
            this.efQ = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.efR = (LinearLayout) this.efQ.findViewById(R.id.content_view);
            this.dSz = (TextView) this.efQ.findViewById(R.id.title);
            this.efS = this.efQ.findViewById(R.id.title_divide_line);
            this.efS.setVisibility(8);
            this.mItems = new ArrayList();
            this.efT = (TextView) this.efQ.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.efP;
    }

    public ViewGroup getView() {
        return this.efR;
    }

    public View getRootView() {
        return this.efQ;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.efU = cVar;
    }

    public c bhv() {
        return this.efU;
    }

    public void aT(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.efR.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.efR.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.efV = aVar;
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.dSz, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.dSz, R.color.cp_cont_c);
        ap.setBackgroundColor(this.efS, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.efT, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.efT, R.color.cp_cont_j);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View bhw() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dSz.setText(this.titleText);
        } else {
            this.dSz.setVisibility(8);
        }
        if (this.efV != null) {
            this.efT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.efV.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.efQ;
    }
}
