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
    private Context eCP;
    private ViewGroup eCQ;
    private LinearLayout eCR;
    private View eCS;
    private TextView eCT;
    private c eCU;
    private a eCV;
    private TextView epn;
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
            this.eCP = context;
            this.eCQ = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.eCR = (LinearLayout) this.eCQ.findViewById(R.id.content_view);
            this.epn = (TextView) this.eCQ.findViewById(R.id.title);
            this.eCS = this.eCQ.findViewById(R.id.title_divide_line);
            this.eCS.setVisibility(8);
            this.mItems = new ArrayList();
            this.eCT = (TextView) this.eCQ.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.eCP;
    }

    public ViewGroup getView() {
        return this.eCR;
    }

    public View getRootView() {
        return this.eCQ;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.eCU = cVar;
    }

    public c bmR() {
        return this.eCU;
    }

    public void bk(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.eCR.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.eCR.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.eCV = aVar;
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.epn, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.epn, R.color.cp_cont_c);
        ap.setBackgroundColor(this.eCS, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.eCT, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.eCT, R.color.cp_cont_j);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View bmS() {
        if (!StringUtils.isNull(this.titleText)) {
            this.epn.setText(this.titleText);
        } else {
            this.epn.setVisibility(8);
        }
        if (this.eCV != null) {
            this.eCT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.eCV.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.eCQ;
    }
}
