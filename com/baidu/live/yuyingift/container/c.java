package com.baidu.live.yuyingift.container;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.bubbleview.BubbleLayout;
import com.baidu.live.data.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private b bTz;
    private BubbleLayout bag;
    private PopupWindow bah;
    private AdapterView.OnItemClickListener bai;
    private ListView baj;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.bai = onItemClickListener;
    }

    public void a(View view, List<j> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.bag == null) {
            this.bag = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.g.ala_gift_num_list, null);
            this.baj = (ListView) this.bag.findViewById(a.f.gift_num_list);
            this.baj.setOnItemClickListener(this.bai);
            K(list);
            this.bah = new PopupWindow((View) this.bag, resources.getDimensionPixelSize(a.d.sdk_ds200), (int) ((this.bTz.getCount() * (resources.getDimensionPixelSize(a.d.sdk_ds64) + resources.getDimensionPixelOffset(a.d.sdk_ds1))) + this.bag.getArrowHeight() + 1.0f), true);
            this.bah.setTouchable(true);
            this.bah.setBackgroundDrawable(resources.getDrawable(a.e.sdk_transparent_bg));
            this.bah.setOnDismissListener(onDismissListener);
        }
        this.bag.s(resources.getDimensionPixelSize(a.d.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.bah, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12));
    }

    public void K(List<j> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (j jVar : list) {
                if (this.mType != 1 || jVar.getNumber() != -1) {
                    if (jVar.getNumber() <= 0) {
                        arrayList.add(jVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
        this.bTz = new b(this.mPageContext.getPageActivity(), this.mType);
        this.bTz.J(list);
        this.baj.setAdapter((ListAdapter) this.bTz);
    }

    public void dismiss() {
        if (this.bah != null && this.bah.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.bah);
            } else {
                ShowUtil.dismissPopupWindow(this.bah, this.mPageContext.getPageActivity());
            }
        }
    }
}
