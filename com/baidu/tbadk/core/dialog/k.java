package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k {
    private Context eGZ;
    private RoundLinearLayout eHa;
    private LinearLayout eHb;
    private EMTextView eHc;
    private View eHd;
    private TextView eHe;
    private View eHf;
    private c eHg;
    private a eHh;
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
            this.eGZ = context;
            this.eHa = (RoundLinearLayout) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            com.baidu.tbadk.core.elementsMaven.c.bj(this.eHa).pb(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
            this.eHb = (LinearLayout) this.eHa.findViewById(R.id.content_view);
            this.eHc = (EMTextView) this.eHa.findViewById(R.id.title);
            this.eHd = this.eHa.findViewById(R.id.title_divide_line);
            this.eHd.setVisibility(8);
            this.eHf = this.eHa.findViewById(R.id.dialog_header);
            this.mItems = new ArrayList();
            this.eHe = (TextView) this.eHa.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.eGZ;
    }

    public ViewGroup getView() {
        return this.eHb;
    }

    public View getRootView() {
        return this.eHa;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.eHg = cVar;
    }

    public c bov() {
        return this.eHg;
    }

    public void br(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.eHb.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.eHb.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.eHh = aVar;
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.eHc, R.color.CAM_X0204);
        ap.setViewTextColor(this.eHc, R.color.CAM_X0109);
        ap.setBackgroundColor(this.eHd, R.color.CAM_X0204);
        ap.setBackgroundResource(this.eHe, R.color.CAM_X0204);
        ap.k(this.eHe, R.color.CAM_X0107);
        ap.setBackgroundResource(this.eHf, R.color.CAM_X0204);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View bow() {
        if (!StringUtils.isNull(this.titleText)) {
            this.eHc.setText(this.titleText);
        } else {
            this.eHc.setVisibility(8);
        }
        if (this.eHh != null) {
            this.eHe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.eHh.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.eHa;
    }
}
