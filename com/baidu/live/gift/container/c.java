package com.baidu.live.gift.container;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.bubbleview.BubbleLayout;
import com.baidu.live.data.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private BubbleLayout aVQ;
    private PopupWindow aVR;
    private AdapterView.OnItemClickListener aVS;
    private ListView aVT;
    private b aVU;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.aVS = onItemClickListener;
    }

    public void a(View view, List<i> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.aVQ == null) {
            this.aVQ = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_gift_num_list, null);
            this.aVT = (ListView) this.aVQ.findViewById(a.g.gift_num_list);
            this.aVT.setOnItemClickListener(this.aVS);
            J(list);
            this.aVR = new PopupWindow((View) this.aVQ, resources.getDimensionPixelSize(a.e.sdk_ds200), (int) ((this.aVU.getCount() * (resources.getDimensionPixelSize(a.e.sdk_ds64) + resources.getDimensionPixelOffset(a.e.sdk_ds1))) + this.aVQ.getArrowHeight() + 1.0f), true);
            this.aVR.setTouchable(true);
            this.aVR.setBackgroundDrawable(resources.getDrawable(a.f.sdk_transparent_bg));
            this.aVR.setOnDismissListener(onDismissListener);
        }
        this.aVQ.t(resources.getDimensionPixelSize(a.e.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.aVR, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12));
    }

    public void J(List<i> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (i iVar : list) {
                if (this.mType != 1 || iVar.getNumber() != -1) {
                    if (iVar.getNumber() <= 0) {
                        arrayList.add(iVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
        this.aVU = new b(this.mPageContext.getPageActivity(), this.mType);
        this.aVU.I(list);
        this.aVT.setAdapter((ListAdapter) this.aVU);
    }

    public void dismiss() {
        if (this.aVR != null && this.aVR.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.aVR);
            } else {
                ShowUtil.dismissPopupWindow(this.aVR, this.mPageContext.getPageActivity());
            }
        }
    }
}
