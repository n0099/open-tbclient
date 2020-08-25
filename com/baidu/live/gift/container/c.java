package com.baidu.live.gift.container;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.bubbleview.BubbleLayout;
import com.baidu.live.data.g;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    private BubbleLayout aQA;
    private PopupWindow aQB;
    private AdapterView.OnItemClickListener aQC;
    private ListView aQD;
    private b aQE;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.aQC = onItemClickListener;
    }

    public void a(View view, List<g> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.aQA == null) {
            this.aQA = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_gift_num_list, null);
            this.aQD = (ListView) this.aQA.findViewById(a.g.gift_num_list);
            this.aQD.setOnItemClickListener(this.aQC);
            F(list);
            this.aQB = new PopupWindow((View) this.aQA, resources.getDimensionPixelSize(a.e.sdk_ds200), (int) ((this.aQE.getCount() * (resources.getDimensionPixelSize(a.e.sdk_ds64) + resources.getDimensionPixelOffset(a.e.sdk_ds1))) + this.aQA.getArrowHeight() + 1.0f), true);
            this.aQB.setTouchable(true);
            this.aQB.setBackgroundDrawable(resources.getDrawable(a.f.sdk_transparent_bg));
            this.aQB.setOnDismissListener(onDismissListener);
        }
        this.aQA.r(resources.getDimensionPixelSize(a.e.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.aQB, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12));
    }

    public void F(List<g> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (g gVar : list) {
                if (this.mType != 1 || gVar.getNumber() != -1) {
                    if (gVar.getNumber() <= 0) {
                        arrayList.add(gVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
        this.aQE = new b(this.mPageContext.getPageActivity(), this.mType);
        this.aQE.E(list);
        this.aQD.setAdapter((ListAdapter) this.aQE);
    }

    public void dismiss() {
        if (this.aQB != null && this.aQB.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.aQB);
            } else {
                ShowUtil.dismissPopupWindow(this.aQB, this.mPageContext.getPageActivity());
            }
        }
    }
}
