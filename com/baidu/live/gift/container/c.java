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
/* loaded from: classes10.dex */
public class c {
    private BubbleLayout bbH;
    private PopupWindow bbI;
    private AdapterView.OnItemClickListener bbJ;
    private ListView bbK;
    private b bbL;
    private Activity mActivity;
    private int mType;

    public c(Activity activity, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mActivity = activity;
        this.mType = i;
        this.bbJ = onItemClickListener;
    }

    public void a(View view, List<l> list, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mActivity.getResources();
        if (this.bbH == null) {
            this.bbH = (BubbleLayout) View.inflate(this.mActivity, a.g.ala_gift_num_list, null);
            this.bbK = (ListView) this.bbH.findViewById(a.f.gift_num_list);
            this.bbK.setOnItemClickListener(this.bbJ);
        }
        K(list);
        this.bbI = new PopupWindow((View) this.bbH, resources.getDimensionPixelSize(a.d.sdk_ds200), (int) ((this.bbL.getCount() * (resources.getDimensionPixelSize(a.d.sdk_ds64) + resources.getDimensionPixelOffset(a.d.sdk_ds1))) + this.bbH.getArrowHeight() + 1.0f), true);
        this.bbI.setTouchable(true);
        this.bbI.setBackgroundDrawable(resources.getDrawable(a.e.sdk_transparent_bg));
        this.bbI.setOnDismissListener(onDismissListener);
        this.bbH.A(resources.getDimensionPixelSize(a.d.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.bbI, view, 0, -this.mActivity.getResources().getDimensionPixelSize(a.d.sdk_ds12));
    }

    public void z(int i, int i2) {
        if (this.bbH != null) {
            this.bbH.x(i, i2);
        }
        if (this.bbK != null) {
            this.bbK.setBackgroundColor(0);
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
        this.bbL = new b(this.mActivity, this.mType);
        this.bbL.J(list);
        this.bbK.setAdapter((ListAdapter) this.bbL);
    }

    public void dismiss() {
        if (this.bbI != null && this.bbI.isShowing()) {
            if (this.mActivity == null) {
                ShowUtil.dismissPopupWindow(this.bbI);
            } else {
                ShowUtil.dismissPopupWindow(this.bbI, this.mActivity);
            }
        }
    }
}
