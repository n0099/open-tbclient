package com.baidu.live.gift.container;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.bubbleview.BubbleLayout;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private BubbleLayout ahe;
    private PopupWindow ahf;
    private AdapterView.OnItemClickListener ahg;
    private ListView ahh;
    private b ahi;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.ahg = onItemClickListener;
    }

    public void a(View view, List<com.baidu.live.data.d> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.ahe == null) {
            this.ahe = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_gift_num_list, null);
            this.ahh = (ListView) this.ahe.findViewById(a.g.gift_num_list);
            this.ahh.setOnItemClickListener(this.ahg);
            u(list);
            this.ahf = new PopupWindow((View) this.ahe, resources.getDimensionPixelSize(a.e.sdk_ds200), (int) ((this.ahi.getCount() * (resources.getDimensionPixelSize(a.e.sdk_ds64) + resources.getDimensionPixelOffset(a.e.sdk_ds1))) + this.ahe.getArrowHeight() + 1.0f), true);
            this.ahf.setTouchable(true);
            this.ahf.setBackgroundDrawable(resources.getDrawable(a.f.sdk_transparent_bg));
            this.ahf.setOnDismissListener(onDismissListener);
        }
        this.ahe.I(resources.getDimensionPixelSize(a.e.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.ahf, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12));
    }

    public void u(List<com.baidu.live.data.d> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (com.baidu.live.data.d dVar : list) {
                if (this.mType != 1 || dVar.getNumber() != -1) {
                    if (dVar.getNumber() <= 0) {
                        arrayList.add(dVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
        this.ahi = new b(this.mPageContext.getPageActivity(), this.mType);
        this.ahi.t(list);
        this.ahh.setAdapter((ListAdapter) this.ahi);
    }

    public void dismiss() {
        if (this.ahf != null && this.ahf.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.ahf);
            } else {
                ShowUtil.dismissPopupWindow(this.ahf, this.mPageContext.getPageActivity());
            }
        }
    }
}
