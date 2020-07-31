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
/* loaded from: classes4.dex */
public class c {
    private BubbleLayout aLn;
    private PopupWindow aLo;
    private AdapterView.OnItemClickListener aLp;
    private ListView aLq;
    private b aLr;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.aLp = onItemClickListener;
    }

    public void a(View view, List<g> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.aLn == null) {
            this.aLn = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_gift_num_list, null);
            this.aLq = (ListView) this.aLn.findViewById(a.g.gift_num_list);
            this.aLq.setOnItemClickListener(this.aLp);
            E(list);
            this.aLo = new PopupWindow((View) this.aLn, resources.getDimensionPixelSize(a.e.sdk_ds200), (int) ((this.aLr.getCount() * (resources.getDimensionPixelSize(a.e.sdk_ds64) + resources.getDimensionPixelOffset(a.e.sdk_ds1))) + this.aLn.getArrowHeight() + 1.0f), true);
            this.aLo.setTouchable(true);
            this.aLo.setBackgroundDrawable(resources.getDrawable(a.f.sdk_transparent_bg));
            this.aLo.setOnDismissListener(onDismissListener);
        }
        this.aLn.r(resources.getDimensionPixelSize(a.e.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.aLo, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12));
    }

    public void E(List<g> list) {
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
        this.aLr = new b(this.mPageContext.getPageActivity(), this.mType);
        this.aLr.D(list);
        this.aLq.setAdapter((ListAdapter) this.aLr);
    }

    public void dismiss() {
        if (this.aLo != null && this.aLo.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.aLo);
            } else {
                ShowUtil.dismissPopupWindow(this.aLo, this.mPageContext.getPageActivity());
            }
        }
    }
}
