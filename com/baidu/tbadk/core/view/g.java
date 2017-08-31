package com.baidu.tbadk.core.view;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private boolean alc = false;
    private SparseArray<String> ald = null;
    private String[] ale;
    private LinearLayout alf;
    private CompoundButton.OnCheckedChangeListener alg;
    private TbPageContext mF;

    public g(TbPageContext tbPageContext) {
        this.mF = tbPageContext;
    }

    public void setData(an anVar) {
        if (anVar != null) {
            this.ald = anVar.qs();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.ale = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.alc = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.alg = onCheckedChangeListener;
    }

    public View getView() {
        if (this.alf == null) {
            this.alf = new LinearLayout(this.mF.getPageActivity());
            this.alf.setOrientation(1);
        }
        List<List<a>> wG = wG();
        if (v.v(wG)) {
            return null;
        }
        int size = wG.size();
        int i = 0;
        while (i < size) {
            View a2 = a(wG.get(i), i == size + (-1), this.alf.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.alf.addView(a2);
            }
            i++;
        }
        return this.alf;
    }

    private List<List<a>> wG() {
        int i;
        int i2;
        int i3 = -1;
        if (this.ald == null || this.ald.size() == 0) {
            return wH();
        }
        int size = this.ald.size();
        int i4 = this.alc ? 0 : -1;
        int i5 = this.alc ? size - 1 : size;
        if (i5 > 1 && i5 % 2 == 1) {
            i3 = i4 + 1;
        }
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        while (i6 < size) {
            if (i6 == i4 || i6 == i3) {
                i = i6;
                i2 = i6 + 1;
            } else {
                i2 = i6 + 2;
                i = i6 + 1;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(i6, this.ald.keyAt(i6), this.ald.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.ald.keyAt(i), this.ald.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> wH() {
        if (this.ale == null || this.ale.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.ale.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.ale[i])) {
                arrayList2.add(new a(i, 0, this.ale[i]));
            }
            if (i + 1 < this.ale.length && !StringUtils.isNull(this.ale[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.ale[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (v.v(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.mF.getPageActivity()).inflate(d.j.neg_feedback_reason_item, (ViewGroup) this.alf, false);
        }
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.h.left_reason);
        NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(d.h.right_reason);
        nEGFeedBackReasonCheckBox.setChecked(false);
        nEGFeedBackReasonCheckBox2.setChecked(false);
        a aVar = list.get(0);
        if (aVar != null) {
            nEGFeedBackReasonCheckBox.setText(aVar.reason);
            nEGFeedBackReasonCheckBox.setTag(aVar);
        }
        if (list.size() > 1 && list.get(1) != null) {
            a aVar2 = list.get(1);
            nEGFeedBackReasonCheckBox2.setText(aVar2.reason);
            nEGFeedBackReasonCheckBox2.setVisibility(0);
            nEGFeedBackReasonCheckBox2.setTag(aVar2);
        } else {
            nEGFeedBackReasonCheckBox2.setVisibility(8);
        }
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.alg);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.alg);
        if (z && linearLayout.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = 0;
            return linearLayout;
        }
        return linearLayout;
    }

    /* loaded from: classes.dex */
    public class a {
        public int id;
        public String reason;

        public a(int i, int i2, String str) {
            this.id = i2;
            this.reason = str;
        }
    }
}
