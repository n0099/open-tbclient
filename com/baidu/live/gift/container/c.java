package com.baidu.live.gift.container;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.bubbleview.BubbleLayout;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private BubbleLayout aBQ;
    private PopupWindow aBR;
    private AdapterView.OnItemClickListener aBS;
    private ListView aBT;
    private b aBU;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.aBS = onItemClickListener;
    }

    public void a(View view, List<com.baidu.live.data.e> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.aBQ == null) {
            this.aBQ = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_gift_num_list, null);
            this.aBT = (ListView) this.aBQ.findViewById(a.g.gift_num_list);
            this.aBT.setOnItemClickListener(this.aBS);
            y(list);
            this.aBR = new PopupWindow((View) this.aBQ, resources.getDimensionPixelSize(a.e.sdk_ds200), (int) ((this.aBU.getCount() * (resources.getDimensionPixelSize(a.e.sdk_ds64) + resources.getDimensionPixelOffset(a.e.sdk_ds1))) + this.aBQ.getArrowHeight() + 1.0f), true);
            this.aBR.setTouchable(true);
            this.aBR.setBackgroundDrawable(resources.getDrawable(a.f.sdk_transparent_bg));
            this.aBR.setOnDismissListener(onDismissListener);
        }
        this.aBQ.p(resources.getDimensionPixelSize(a.e.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.aBR, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12));
    }

    public void y(List<com.baidu.live.data.e> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (com.baidu.live.data.e eVar : list) {
                if (this.mType != 1 || eVar.getNumber() != -1) {
                    if (eVar.getNumber() <= 0) {
                        arrayList.add(eVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
        this.aBU = new b(this.mPageContext.getPageActivity(), this.mType);
        this.aBU.x(list);
        this.aBT.setAdapter((ListAdapter) this.aBU);
    }

    public void dismiss() {
        if (this.aBR != null && this.aBR.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.aBR);
            } else {
                ShowUtil.dismissPopupWindow(this.aBR, this.mPageContext.getPageActivity());
            }
        }
    }
}
