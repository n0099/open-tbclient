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
    private BubbleLayout aBW;
    private PopupWindow aBX;
    private AdapterView.OnItemClickListener aBY;
    private ListView aBZ;
    private b aCa;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.aBY = onItemClickListener;
    }

    public void a(View view, List<com.baidu.live.data.e> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.aBW == null) {
            this.aBW = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_gift_num_list, null);
            this.aBZ = (ListView) this.aBW.findViewById(a.g.gift_num_list);
            this.aBZ.setOnItemClickListener(this.aBY);
            y(list);
            this.aBX = new PopupWindow((View) this.aBW, resources.getDimensionPixelSize(a.e.sdk_ds200), (int) ((this.aCa.getCount() * (resources.getDimensionPixelSize(a.e.sdk_ds64) + resources.getDimensionPixelOffset(a.e.sdk_ds1))) + this.aBW.getArrowHeight() + 1.0f), true);
            this.aBX.setTouchable(true);
            this.aBX.setBackgroundDrawable(resources.getDrawable(a.f.sdk_transparent_bg));
            this.aBX.setOnDismissListener(onDismissListener);
        }
        this.aBW.p(resources.getDimensionPixelSize(a.e.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.aBX, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12));
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
        this.aCa = new b(this.mPageContext.getPageActivity(), this.mType);
        this.aCa.x(list);
        this.aBZ.setAdapter((ListAdapter) this.aCa);
    }

    public void dismiss() {
        if (this.aBX != null && this.aBX.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.aBX);
            } else {
                ShowUtil.dismissPopupWindow(this.aBX, this.mPageContext.getPageActivity());
            }
        }
    }
}
