package com.baidu.live.gift.container;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.bubbleview.BubbleLayout;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private BubbleLayout YO;
    private PopupWindow YP;
    private AdapterView.OnItemClickListener YQ;
    private ListView YR;
    private b YS;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.YQ = onItemClickListener;
    }

    public void a(View view, List<com.baidu.live.gift.a.b> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.YO == null) {
            this.YO = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_gift_num_list, null);
            this.YR = (ListView) this.YO.findViewById(a.g.gift_num_list);
            this.YR.setOnItemClickListener(this.YQ);
            v(list);
            this.YP = new PopupWindow((View) this.YO, resources.getDimensionPixelSize(a.e.sdk_ds200), (int) ((this.YS.getCount() * (resources.getDimensionPixelSize(a.e.sdk_ds64) + resources.getDimensionPixelOffset(a.e.sdk_ds1))) + this.YO.getArrowHeight() + 1.0f), true);
            this.YP.setTouchable(true);
            this.YP.setBackgroundDrawable(resources.getDrawable(a.f.sdk_transparent_bg));
            this.YP.setOnDismissListener(onDismissListener);
        }
        this.YO.H(resources.getDimensionPixelSize(a.e.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.YP, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12));
    }

    public void v(List<com.baidu.live.gift.a.b> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (com.baidu.live.gift.a.b bVar : list) {
                if (this.mType != 1 || bVar.getNumber() != -1) {
                    if (bVar.getNumber() <= 0) {
                        arrayList.add(bVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
        this.YS = new b(this.mPageContext.getPageActivity(), this.mType);
        this.YS.u(list);
        this.YR.setAdapter((ListAdapter) this.YS);
    }

    public void dismiss() {
        if (this.YP != null && this.YP.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.YP);
            } else {
                ShowUtil.dismissPopupWindow(this.YP, this.mPageContext.getPageActivity());
            }
        }
    }
}
