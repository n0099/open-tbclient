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
    private TextView dSD;
    private Context efT;
    private ViewGroup efU;
    private LinearLayout efV;
    private View efW;
    private TextView efX;
    private c efY;
    private a efZ;
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
            this.efT = context;
            this.efU = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
            this.efV = (LinearLayout) this.efU.findViewById(R.id.content_view);
            this.dSD = (TextView) this.efU.findViewById(R.id.title);
            this.efW = this.efU.findViewById(R.id.title_divide_line);
            this.efW.setVisibility(8);
            this.mItems = new ArrayList();
            this.efX = (TextView) this.efU.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.efT;
    }

    public ViewGroup getView() {
        return this.efV;
    }

    public View getRootView() {
        return this.efU;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.efY = cVar;
    }

    public c bhv() {
        return this.efY;
    }

    public void aT(List<? extends j> list) {
        if (list != null) {
            this.mItems = list;
            this.efV.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    j jVar = list.get(i2);
                    if (jVar != null) {
                        this.efV.addView(jVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.efZ = aVar;
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.dSD, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.dSD, R.color.cp_cont_c);
        ap.setBackgroundColor(this.efW, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.efX, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.efX, R.color.cp_cont_j);
        if (this.mItems != null) {
            for (j jVar : this.mItems) {
                jVar.onChangeSkinType();
            }
        }
    }

    public View bhw() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dSD.setText(this.titleText);
        } else {
            this.dSD.setVisibility(8);
        }
        if (this.efZ != null) {
            this.efX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.efZ.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.efU;
    }
}
