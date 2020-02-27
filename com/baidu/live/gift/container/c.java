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
    private BubbleLayout ajn;
    private PopupWindow ajo;
    private AdapterView.OnItemClickListener ajp;
    private ListView ajq;
    private b ajr;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.ajp = onItemClickListener;
    }

    public void a(View view, List<com.baidu.live.data.e> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.ajn == null) {
            this.ajn = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_gift_num_list, null);
            this.ajq = (ListView) this.ajn.findViewById(a.g.gift_num_list);
            this.ajq.setOnItemClickListener(this.ajp);
            u(list);
            this.ajo = new PopupWindow((View) this.ajn, resources.getDimensionPixelSize(a.e.sdk_ds200), (int) ((this.ajr.getCount() * (resources.getDimensionPixelSize(a.e.sdk_ds64) + resources.getDimensionPixelOffset(a.e.sdk_ds1))) + this.ajn.getArrowHeight() + 1.0f), true);
            this.ajo.setTouchable(true);
            this.ajo.setBackgroundDrawable(resources.getDrawable(a.f.sdk_transparent_bg));
            this.ajo.setOnDismissListener(onDismissListener);
        }
        this.ajn.I(resources.getDimensionPixelSize(a.e.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.ajo, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12));
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
        this.ajr = new b(this.mPageContext.getPageActivity(), this.mType);
        this.ajr.t(list);
        this.ajq.setAdapter((ListAdapter) this.ajr);
    }

    public void dismiss() {
        if (this.ajo != null && this.ajo.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.ajo);
            } else {
                ShowUtil.dismissPopupWindow(this.ajo, this.mPageContext.getPageActivity());
            }
        }
    }
}
