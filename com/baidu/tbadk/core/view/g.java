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
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private TbPageContext ako;
    private String[] akq;
    private LinearLayout akr;
    private CompoundButton.OnCheckedChangeListener aks;
    private boolean akn = false;
    private SparseArray<String> akp = null;

    public g(TbPageContext tbPageContext) {
        this.ako = tbPageContext;
    }

    public void setData(an anVar) {
        if (anVar != null) {
            this.akp = anVar.qm();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.akq = strArr;
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.akn = z;
    }

    public void a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.aks = onCheckedChangeListener;
    }

    public View getView() {
        if (this.akr == null) {
            this.akr = new LinearLayout(this.ako.getPageActivity());
            this.akr.setOrientation(1);
        }
        List<List<a>> wy = wy();
        if (u.v(wy)) {
            return null;
        }
        int size = wy.size();
        int i = 0;
        while (i < size) {
            View a2 = a(wy.get(i), i == size + (-1), this.akr.getChildAt(i));
            if (a2 != null && a2.getParent() == null) {
                this.akr.addView(a2);
            }
            i++;
        }
        return this.akr;
    }

    private List<List<a>> wy() {
        int i;
        int i2;
        int i3 = -1;
        if (this.akp == null || this.akp.size() == 0) {
            return wz();
        }
        int size = this.akp.size();
        int i4 = this.akn ? 0 : -1;
        int i5 = this.akn ? size - 1 : size;
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
            arrayList2.add(new a(i6, this.akp.keyAt(i6), this.akp.valueAt(i6)));
            if (i > i6 && i < size) {
                arrayList2.add(new a(i, this.akp.keyAt(i), this.akp.valueAt(i)));
            }
            arrayList.add(arrayList2);
            i6 = i2;
        }
        return arrayList;
    }

    private List<List<a>> wz() {
        if (this.akq == null || this.akq.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.akq.length; i += 2) {
            ArrayList arrayList2 = new ArrayList();
            if (!StringUtils.isNull(this.akq[i])) {
                arrayList2.add(new a(i, 0, this.akq[i]));
            }
            if (i + 1 < this.akq.length && !StringUtils.isNull(this.akq[i + 1])) {
                arrayList2.add(new a(i + 1, 0, this.akq[i + 1]));
            }
            if (arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private View a(List<a> list, boolean z, View view) {
        LinearLayout linearLayout;
        if (u.v(list)) {
            return null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = (LinearLayout) LayoutInflater.from(this.ako.getPageActivity()).inflate(d.j.neg_feedback_reason_item, (ViewGroup) this.akr, false);
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
        nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.aks);
        nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.aks);
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
