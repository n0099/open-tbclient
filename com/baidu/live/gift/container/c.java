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
/* loaded from: classes3.dex */
public class c {
    private BubbleLayout aJR;
    private PopupWindow aJS;
    private AdapterView.OnItemClickListener aJT;
    private ListView aJU;
    private b aJV;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.aJT = onItemClickListener;
    }

    public void a(View view, List<g> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.aJR == null) {
            this.aJR = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_gift_num_list, null);
            this.aJU = (ListView) this.aJR.findViewById(a.g.gift_num_list);
            this.aJU.setOnItemClickListener(this.aJT);
            C(list);
            this.aJS = new PopupWindow((View) this.aJR, resources.getDimensionPixelSize(a.e.sdk_ds200), (int) ((this.aJV.getCount() * (resources.getDimensionPixelSize(a.e.sdk_ds64) + resources.getDimensionPixelOffset(a.e.sdk_ds1))) + this.aJR.getArrowHeight() + 1.0f), true);
            this.aJS.setTouchable(true);
            this.aJS.setBackgroundDrawable(resources.getDrawable(a.f.sdk_transparent_bg));
            this.aJS.setOnDismissListener(onDismissListener);
        }
        this.aJR.r(resources.getDimensionPixelSize(a.e.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.aJS, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12));
    }

    public void C(List<g> list) {
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
        this.aJV = new b(this.mPageContext.getPageActivity(), this.mType);
        this.aJV.B(list);
        this.aJU.setAdapter((ListAdapter) this.aJV);
    }

    public void dismiss() {
        if (this.aJS != null && this.aJS.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.aJS);
            } else {
                ShowUtil.dismissPopupWindow(this.aJS, this.mPageContext.getPageActivity());
            }
        }
    }
}
