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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private BubbleLayout aHt;
    private PopupWindow aHu;
    private AdapterView.OnItemClickListener aHv;
    private ListView aHw;
    private b aHx;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.aHv = onItemClickListener;
    }

    public void a(View view, List<g> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.aHt == null) {
            this.aHt = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_gift_num_list, null);
            this.aHw = (ListView) this.aHt.findViewById(a.g.gift_num_list);
            this.aHw.setOnItemClickListener(this.aHv);
            y(list);
            this.aHu = new PopupWindow((View) this.aHt, resources.getDimensionPixelSize(a.e.sdk_ds200), (int) ((this.aHx.getCount() * (resources.getDimensionPixelSize(a.e.sdk_ds64) + resources.getDimensionPixelOffset(a.e.sdk_ds1))) + this.aHt.getArrowHeight() + 1.0f), true);
            this.aHu.setTouchable(true);
            this.aHu.setBackgroundDrawable(resources.getDrawable(a.f.sdk_transparent_bg));
            this.aHu.setOnDismissListener(onDismissListener);
        }
        this.aHt.p(resources.getDimensionPixelSize(a.e.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.aHu, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12));
    }

    public void y(List<g> list) {
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
        this.aHx = new b(this.mPageContext.getPageActivity(), this.mType);
        this.aHx.x(list);
        this.aHw.setAdapter((ListAdapter) this.aHx);
    }

    public void dismiss() {
        if (this.aHu != null && this.aHu.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.aHu);
            } else {
                ShowUtil.dismissPopupWindow(this.aHu, this.mPageContext.getPageActivity());
            }
        }
    }
}
