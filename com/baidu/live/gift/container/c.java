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
    private BubbleLayout aSF;
    private PopupWindow aSG;
    private AdapterView.OnItemClickListener aSH;
    private ListView aSI;
    private b aSJ;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.aSH = onItemClickListener;
    }

    public void a(View view, List<i> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.aSF == null) {
            this.aSF = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_gift_num_list, null);
            this.aSI = (ListView) this.aSF.findViewById(a.g.gift_num_list);
            this.aSI.setOnItemClickListener(this.aSH);
            H(list);
            this.aSG = new PopupWindow((View) this.aSF, resources.getDimensionPixelSize(a.e.sdk_ds200), (int) ((this.aSJ.getCount() * (resources.getDimensionPixelSize(a.e.sdk_ds64) + resources.getDimensionPixelOffset(a.e.sdk_ds1))) + this.aSF.getArrowHeight() + 1.0f), true);
            this.aSG.setTouchable(true);
            this.aSG.setBackgroundDrawable(resources.getDrawable(a.f.sdk_transparent_bg));
            this.aSG.setOnDismissListener(onDismissListener);
        }
        this.aSF.r(resources.getDimensionPixelSize(a.e.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.aSG, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12));
    }

    public void H(List<i> list) {
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
        this.aSJ = new b(this.mPageContext.getPageActivity(), this.mType);
        this.aSJ.G(list);
        this.aSI.setAdapter((ListAdapter) this.aSJ);
    }

    public void dismiss() {
        if (this.aSG != null && this.aSG.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.aSG);
            } else {
                ShowUtil.dismissPopupWindow(this.aSG, this.mPageContext.getPageActivity());
            }
        }
    }
}
