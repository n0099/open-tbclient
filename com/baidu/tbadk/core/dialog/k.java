package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k {
    private TextView dkk;
    private Context dvi;
    private ViewGroup dvj;
    private LinearLayout dvk;
    private View dvl;
    private TextView dvm;
    private c dvn;
    private a dvo;
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
            this.dvi = context;
            this.dvj = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.dvk = (LinearLayout) this.dvj.findViewById(R.id.content_view);
            this.dkk = (TextView) this.dvj.findViewById(R.id.title);
            this.dvl = this.dvj.findViewById(R.id.title_divide_line);
            this.dvl.setVisibility(8);
            this.mItems = new ArrayList();
            this.dvm = (TextView) this.dvj.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.dvi;
    }

    public ViewGroup getView() {
        return this.dvk;
    }

    public View getRootView() {
        return this.dvj;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.dvn = cVar;
    }

    public c aNi() {
        return this.dvn;
    }

    public void aI(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.dvk.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.dvk.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.dvo = aVar;
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.dkk, R.color.cp_bg_line_k);
        am.setViewTextColor(this.dkk, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.dvl, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dvm, R.color.cp_bg_line_k);
        am.setViewTextColor(this.dvm, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View aNj() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dkk.setText(this.titleText);
        } else {
            this.dkk.setVisibility(8);
        }
        if (this.dvo != null) {
            this.dvm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.dvo.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.dvj;
    }
}
