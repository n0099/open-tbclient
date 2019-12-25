package com.baidu.live.gift.container;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.bubbleview.BubbleLayout;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private BubbleLayout agu;
    private PopupWindow agv;
    private AdapterView.OnItemClickListener agw;
    private ListView agx;
    private b agy;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.agw = onItemClickListener;
    }

    public void a(View view, List<com.baidu.live.data.d> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.agu == null) {
            this.agu = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_gift_num_list, null);
            this.agx = (ListView) this.agu.findViewById(a.g.gift_num_list);
            this.agx.setOnItemClickListener(this.agw);
            u(list);
            this.agv = new PopupWindow((View) this.agu, resources.getDimensionPixelSize(a.e.sdk_ds200), (int) ((this.agy.getCount() * (resources.getDimensionPixelSize(a.e.sdk_ds64) + resources.getDimensionPixelOffset(a.e.sdk_ds1))) + this.agu.getArrowHeight() + 1.0f), true);
            this.agv.setTouchable(true);
            this.agv.setBackgroundDrawable(resources.getDrawable(a.f.sdk_transparent_bg));
            this.agv.setOnDismissListener(onDismissListener);
        }
        this.agu.I(resources.getDimensionPixelSize(a.e.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.agv, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12));
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
        this.agy = new b(this.mPageContext.getPageActivity(), this.mType);
        this.agy.t(list);
        this.agx.setAdapter((ListAdapter) this.agy);
    }

    public void dismiss() {
        if (this.agv != null && this.agv.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.agv);
            } else {
                ShowUtil.dismissPopupWindow(this.agv, this.mPageContext.getPageActivity());
            }
        }
    }
}
