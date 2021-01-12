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
/* loaded from: classes10.dex */
public class c {
    private BubbleLayout aXa;
    private PopupWindow aXb;
    private AdapterView.OnItemClickListener aXc;
    private ListView aXd;
    private b bUz;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.aXc = onItemClickListener;
    }

    public void a(View view, List<k> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.aXa == null) {
            this.aXa = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.g.ala_gift_num_list, null);
            this.aXd = (ListView) this.aXa.findViewById(a.f.gift_num_list);
            this.aXd.setOnItemClickListener(this.aXc);
            K(list);
            this.aXb = new PopupWindow((View) this.aXa, resources.getDimensionPixelSize(a.d.sdk_ds200), (int) ((this.bUz.getCount() * (resources.getDimensionPixelSize(a.d.sdk_ds64) + resources.getDimensionPixelOffset(a.d.sdk_ds1))) + this.aXa.getArrowHeight() + 1.0f), true);
            this.aXb.setTouchable(true);
            this.aXb.setBackgroundDrawable(resources.getDrawable(a.e.sdk_transparent_bg));
            this.aXb.setOnDismissListener(onDismissListener);
        }
        this.aXa.s(resources.getDimensionPixelSize(a.d.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.aXb, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12));
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
        this.bUz = new b(this.mPageContext.getPageActivity(), this.mType);
        this.bUz.J(list);
        this.aXd.setAdapter((ListAdapter) this.bUz);
    }

    public void dismiss() {
        if (this.aXb != null && this.aXb.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.aXb);
            } else {
                ShowUtil.dismissPopupWindow(this.aXb, this.mPageContext.getPageActivity());
            }
        }
    }
}
