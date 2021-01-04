package com.baidu.live.yuyingift.container;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.bubbleview.BubbleLayout;
import com.baidu.live.data.k;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class c {
    private b bZl;
    private BubbleLayout bbO;
    private PopupWindow bbP;
    private AdapterView.OnItemClickListener bbQ;
    private ListView bbR;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.bbQ = onItemClickListener;
    }

    public void a(View view, List<k> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.bbO == null) {
            this.bbO = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.g.ala_gift_num_list, null);
            this.bbR = (ListView) this.bbO.findViewById(a.f.gift_num_list);
            this.bbR.setOnItemClickListener(this.bbQ);
            K(list);
            this.bbP = new PopupWindow((View) this.bbO, resources.getDimensionPixelSize(a.d.sdk_ds200), (int) ((this.bZl.getCount() * (resources.getDimensionPixelSize(a.d.sdk_ds64) + resources.getDimensionPixelOffset(a.d.sdk_ds1))) + this.bbO.getArrowHeight() + 1.0f), true);
            this.bbP.setTouchable(true);
            this.bbP.setBackgroundDrawable(resources.getDrawable(a.e.sdk_transparent_bg));
            this.bbP.setOnDismissListener(onDismissListener);
        }
        this.bbO.s(resources.getDimensionPixelSize(a.d.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.bbP, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12));
    }

    public void K(List<k> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (k kVar : list) {
                if (this.mType != 1 || kVar.getNumber() != -1) {
                    if (kVar.getNumber() <= 0) {
                        arrayList.add(kVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
        this.bZl = new b(this.mPageContext.getPageActivity(), this.mType);
        this.bZl.J(list);
        this.bbR.setAdapter((ListAdapter) this.bZl);
    }

    public void dismiss() {
        if (this.bbP != null && this.bbP.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.bbP);
            } else {
                ShowUtil.dismissPopupWindow(this.bbP, this.mPageContext.getPageActivity());
            }
        }
    }
}
