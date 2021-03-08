package com.baidu.live.yuyingift.container;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.bubbleview.BubbleLayout;
import com.baidu.live.data.l;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class c {
    private BubbleLayout bbH;
    private PopupWindow bbI;
    private AdapterView.OnItemClickListener bbJ;
    private ListView bbK;
    private b cab;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.bbJ = onItemClickListener;
    }

    public void a(View view, List<l> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.bbH == null) {
            this.bbH = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.g.ala_gift_num_list, null);
            this.bbK = (ListView) this.bbH.findViewById(a.f.gift_num_list);
            this.bbK.setOnItemClickListener(this.bbJ);
            K(list);
            this.bbI = new PopupWindow((View) this.bbH, resources.getDimensionPixelSize(a.d.sdk_ds200), (int) ((this.cab.getCount() * (resources.getDimensionPixelSize(a.d.sdk_ds64) + resources.getDimensionPixelOffset(a.d.sdk_ds1))) + this.bbH.getArrowHeight() + 1.0f), true);
            this.bbI.setTouchable(true);
            this.bbI.setBackgroundDrawable(resources.getDrawable(a.e.sdk_transparent_bg));
            this.bbI.setOnDismissListener(onDismissListener);
        }
        this.bbH.A(resources.getDimensionPixelSize(a.d.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.bbI, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12));
    }

    public void K(List<l> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (l lVar : list) {
                if (this.mType != 1 || lVar.getNumber() != -1) {
                    if (lVar.getNumber() <= 0) {
                        arrayList.add(lVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
        this.cab = new b(this.mPageContext.getPageActivity(), this.mType);
        this.cab.J(list);
        this.bbK.setAdapter((ListAdapter) this.cab);
    }

    public void dismiss() {
        if (this.bbI != null && this.bbI.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.bbI);
            } else {
                ShowUtil.dismissPopupWindow(this.bbI, this.mPageContext.getPageActivity());
            }
        }
    }
}
