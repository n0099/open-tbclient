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
    private b YA;
    private BubbleLayout Yw;
    private PopupWindow Yx;
    private AdapterView.OnItemClickListener Yy;
    private ListView Yz;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.Yy = onItemClickListener;
    }

    public void a(View view, List<com.baidu.live.gift.a.b> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.Yw == null) {
            this.Yw = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_gift_num_list, null);
            this.Yz = (ListView) this.Yw.findViewById(a.g.gift_num_list);
            this.Yz.setOnItemClickListener(this.Yy);
            v(list);
            this.Yx = new PopupWindow((View) this.Yw, resources.getDimensionPixelSize(a.e.sdk_ds200), (int) ((this.YA.getCount() * (resources.getDimensionPixelSize(a.e.sdk_ds64) + resources.getDimensionPixelOffset(a.e.sdk_ds1))) + this.Yw.getArrowHeight() + 1.0f), true);
            this.Yx.setTouchable(true);
            this.Yx.setBackgroundDrawable(resources.getDrawable(a.f.sdk_transparent_bg));
            this.Yx.setOnDismissListener(onDismissListener);
        }
        this.Yw.H(resources.getDimensionPixelSize(a.e.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.Yx, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12));
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
        this.YA = new b(this.mPageContext.getPageActivity(), this.mType);
        this.YA.u(list);
        this.Yz.setAdapter((ListAdapter) this.YA);
    }

    public void dismiss() {
        if (this.Yx != null && this.Yx.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.Yx);
            } else {
                ShowUtil.dismissPopupWindow(this.Yx, this.mPageContext.getPageActivity());
            }
        }
    }
}
