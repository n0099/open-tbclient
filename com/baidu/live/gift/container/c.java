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
    private BubbleLayout aWS;
    private PopupWindow aWT;
    private AdapterView.OnItemClickListener aWU;
    private ListView aWV;
    private b aWW;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.aWU = onItemClickListener;
    }

    public void a(View view, List<j> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.aWS == null) {
            this.aWS = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.g.ala_gift_num_list, null);
            this.aWV = (ListView) this.aWS.findViewById(a.f.gift_num_list);
            this.aWV.setOnItemClickListener(this.aWU);
            J(list);
            this.aWT = new PopupWindow((View) this.aWS, resources.getDimensionPixelSize(a.d.sdk_ds200), (int) ((this.aWW.getCount() * (resources.getDimensionPixelSize(a.d.sdk_ds64) + resources.getDimensionPixelOffset(a.d.sdk_ds1))) + this.aWS.getArrowHeight() + 1.0f), true);
            this.aWT.setTouchable(true);
            this.aWT.setBackgroundDrawable(resources.getDrawable(a.e.sdk_transparent_bg));
            this.aWT.setOnDismissListener(onDismissListener);
        }
        this.aWS.t(resources.getDimensionPixelSize(a.d.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.aWT, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12));
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
        this.aWW = new b(this.mPageContext.getPageActivity(), this.mType);
        this.aWW.I(list);
        this.aWV.setAdapter((ListAdapter) this.aWW);
    }

    public void dismiss() {
        if (this.aWT != null && this.aWT.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.aWT);
            } else {
                ShowUtil.dismissPopupWindow(this.aWT, this.mPageContext.getPageActivity());
            }
        }
    }
}
