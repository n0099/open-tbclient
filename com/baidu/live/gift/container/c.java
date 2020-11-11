package com.baidu.live.gift.container;

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
    private BubbleLayout aYD;
    private PopupWindow aYE;
    private AdapterView.OnItemClickListener aYF;
    private ListView aYG;
    private b aYH;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.aYF = onItemClickListener;
    }

    public void a(View view, List<j> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.aYD == null) {
            this.aYD = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.g.ala_gift_num_list, null);
            this.aYG = (ListView) this.aYD.findViewById(a.f.gift_num_list);
            this.aYG.setOnItemClickListener(this.aYF);
            J(list);
            this.aYE = new PopupWindow((View) this.aYD, resources.getDimensionPixelSize(a.d.sdk_ds200), (int) ((this.aYH.getCount() * (resources.getDimensionPixelSize(a.d.sdk_ds64) + resources.getDimensionPixelOffset(a.d.sdk_ds1))) + this.aYD.getArrowHeight() + 1.0f), true);
            this.aYE.setTouchable(true);
            this.aYE.setBackgroundDrawable(resources.getDrawable(a.e.sdk_transparent_bg));
            this.aYE.setOnDismissListener(onDismissListener);
        }
        this.aYD.u(resources.getDimensionPixelSize(a.d.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.aYE, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12));
    }

    public void J(List<j> list) {
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
        this.aYH = new b(this.mPageContext.getPageActivity(), this.mType);
        this.aYH.I(list);
        this.aYG.setAdapter((ListAdapter) this.aYH);
    }

    public void dismiss() {
        if (this.aYE != null && this.aYE.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.aYE);
            } else {
                ShowUtil.dismissPopupWindow(this.aYE, this.mPageContext.getPageActivity());
            }
        }
    }
}
