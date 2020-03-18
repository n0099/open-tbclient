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
    private ListView ajA;
    private b ajB;
    private BubbleLayout ajx;
    private PopupWindow ajy;
    private AdapterView.OnItemClickListener ajz;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.ajz = onItemClickListener;
    }

    public void a(View view, List<com.baidu.live.data.e> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.ajx == null) {
            this.ajx = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_gift_num_list, null);
            this.ajA = (ListView) this.ajx.findViewById(a.g.gift_num_list);
            this.ajA.setOnItemClickListener(this.ajz);
            u(list);
            this.ajy = new PopupWindow((View) this.ajx, resources.getDimensionPixelSize(a.e.sdk_ds200), (int) ((this.ajB.getCount() * (resources.getDimensionPixelSize(a.e.sdk_ds64) + resources.getDimensionPixelOffset(a.e.sdk_ds1))) + this.ajx.getArrowHeight() + 1.0f), true);
            this.ajy.setTouchable(true);
            this.ajy.setBackgroundDrawable(resources.getDrawable(a.f.sdk_transparent_bg));
            this.ajy.setOnDismissListener(onDismissListener);
        }
        this.ajx.I(resources.getDimensionPixelSize(a.e.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.ajy, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12));
    }

    public void u(List<com.baidu.live.data.e> list) {
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
        this.ajB = new b(this.mPageContext.getPageActivity(), this.mType);
        this.ajB.t(list);
        this.ajA.setAdapter((ListAdapter) this.ajB);
    }

    public void dismiss() {
        if (this.ajy != null && this.ajy.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.ajy);
            } else {
                ShowUtil.dismissPopupWindow(this.ajy, this.mPageContext.getPageActivity());
            }
        }
    }
}
