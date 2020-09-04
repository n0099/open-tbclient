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
    private BubbleLayout aQC;
    private PopupWindow aQD;
    private AdapterView.OnItemClickListener aQE;
    private ListView aQF;
    private b aQG;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.aQE = onItemClickListener;
    }

    public void a(View view, List<g> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.aQC == null) {
            this.aQC = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_gift_num_list, null);
            this.aQF = (ListView) this.aQC.findViewById(a.g.gift_num_list);
            this.aQF.setOnItemClickListener(this.aQE);
            F(list);
            this.aQD = new PopupWindow((View) this.aQC, resources.getDimensionPixelSize(a.e.sdk_ds200), (int) ((this.aQG.getCount() * (resources.getDimensionPixelSize(a.e.sdk_ds64) + resources.getDimensionPixelOffset(a.e.sdk_ds1))) + this.aQC.getArrowHeight() + 1.0f), true);
            this.aQD.setTouchable(true);
            this.aQD.setBackgroundDrawable(resources.getDrawable(a.f.sdk_transparent_bg));
            this.aQD.setOnDismissListener(onDismissListener);
        }
        this.aQC.r(resources.getDimensionPixelSize(a.e.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.aQD, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12));
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
        this.aQG = new b(this.mPageContext.getPageActivity(), this.mType);
        this.aQG.E(list);
        this.aQF.setAdapter((ListAdapter) this.aQG);
    }

    public void dismiss() {
        if (this.aQD != null && this.aQD.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.aQD);
            } else {
                ShowUtil.dismissPopupWindow(this.aQD, this.mPageContext.getPageActivity());
            }
        }
    }
}
