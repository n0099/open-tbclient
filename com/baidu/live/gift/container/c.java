package com.baidu.live.gift.container;

import android.app.Activity;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class c {
    private BubbleLayout bag;
    private PopupWindow bah;
    private AdapterView.OnItemClickListener bai;
    private ListView baj;
    private b bak;
    private Activity mActivity;
    private int mType;

    public c(Activity activity, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mActivity = activity;
        this.mType = i;
        this.bai = onItemClickListener;
    }

    public void a(View view, List<l> list, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mActivity.getResources();
        if (this.bag == null) {
            this.bag = (BubbleLayout) View.inflate(this.mActivity, a.g.ala_gift_num_list, null);
            this.baj = (ListView) this.bag.findViewById(a.f.gift_num_list);
            this.baj.setOnItemClickListener(this.bai);
        }
        K(list);
        this.bah = new PopupWindow((View) this.bag, resources.getDimensionPixelSize(a.d.sdk_ds200), (int) ((this.bak.getCount() * (resources.getDimensionPixelSize(a.d.sdk_ds64) + resources.getDimensionPixelOffset(a.d.sdk_ds1))) + this.bag.getArrowHeight() + 1.0f), true);
        this.bah.setTouchable(true);
        this.bah.setBackgroundDrawable(resources.getDrawable(a.e.sdk_transparent_bg));
        this.bah.setOnDismissListener(onDismissListener);
        this.bag.s(resources.getDimensionPixelSize(a.d.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.bah, view, 0, -this.mActivity.getResources().getDimensionPixelSize(a.d.sdk_ds12));
    }

    public void z(int i, int i2) {
        if (this.bag != null) {
            this.bag.x(i, i2);
        }
        if (this.baj != null) {
            this.baj.setBackgroundColor(0);
        }
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
        this.bak = new b(this.mActivity, this.mType);
        this.bak.J(list);
        this.baj.setAdapter((ListAdapter) this.bak);
    }

    public void dismiss() {
        if (this.bah != null && this.bah.isShowing()) {
            if (this.mActivity == null) {
                ShowUtil.dismissPopupWindow(this.bah);
            } else {
                ShowUtil.dismissPopupWindow(this.bah, this.mActivity);
            }
        }
    }
}
