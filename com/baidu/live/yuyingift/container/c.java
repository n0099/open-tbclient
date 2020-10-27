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
    private BubbleLayout aXl;
    private PopupWindow aXm;
    private AdapterView.OnItemClickListener aXn;
    private ListView aXo;
    private b bKr;
    private TbPageContext mPageContext;
    private int mType;

    public c(TbPageContext<AlaGiftTabActivity> tbPageContext, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.aXn = onItemClickListener;
    }

    public void a(View view, List<j> list, boolean z, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mPageContext.getPageActivity().getResources();
        if (this.aXl == null) {
            this.aXl = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_gift_num_list, null);
            this.aXo = (ListView) this.aXl.findViewById(a.g.gift_num_list);
            this.aXo.setOnItemClickListener(this.aXn);
            J(list);
            this.aXm = new PopupWindow((View) this.aXl, resources.getDimensionPixelSize(a.e.sdk_ds200), (int) ((this.bKr.getCount() * (resources.getDimensionPixelSize(a.e.sdk_ds64) + resources.getDimensionPixelOffset(a.e.sdk_ds1))) + this.aXl.getArrowHeight() + 1.0f), true);
            this.aXm.setTouchable(true);
            this.aXm.setBackgroundDrawable(resources.getDrawable(a.f.sdk_transparent_bg));
            this.aXm.setOnDismissListener(onDismissListener);
        }
        this.aXl.t(resources.getDimensionPixelSize(a.e.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.aXm, view, 0, -this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12));
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
        this.bKr = new b(this.mPageContext.getPageActivity(), this.mType);
        this.bKr.I(list);
        this.aXo.setAdapter((ListAdapter) this.bKr);
    }

    public void dismiss() {
        if (this.aXm != null && this.aXm.isShowing()) {
            if (this.mPageContext == null) {
                ShowUtil.dismissPopupWindow(this.aXm);
            } else {
                ShowUtil.dismissPopupWindow(this.aXm, this.mPageContext.getPageActivity());
            }
        }
    }
}
