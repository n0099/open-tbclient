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
import com.baidu.live.data.k;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class c {
    private BubbleLayout bbO;
    private PopupWindow bbP;
    private AdapterView.OnItemClickListener bbQ;
    private ListView bbR;
    private b bbS;
    private Activity mActivity;
    private int mType;

    public c(Activity activity, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.mActivity = activity;
        this.mType = i;
        this.bbQ = onItemClickListener;
    }

    public void a(View view, List<k> list, PopupWindow.OnDismissListener onDismissListener) {
        Resources resources = this.mActivity.getResources();
        if (this.bbO == null) {
            this.bbO = (BubbleLayout) View.inflate(this.mActivity, a.g.ala_gift_num_list, null);
            this.bbR = (ListView) this.bbO.findViewById(a.f.gift_num_list);
            this.bbR.setOnItemClickListener(this.bbQ);
        }
        K(list);
        this.bbP = new PopupWindow((View) this.bbO, resources.getDimensionPixelSize(a.d.sdk_ds200), (int) ((this.bbS.getCount() * (resources.getDimensionPixelSize(a.d.sdk_ds64) + resources.getDimensionPixelOffset(a.d.sdk_ds1))) + this.bbO.getArrowHeight() + 1.0f), true);
        this.bbP.setTouchable(true);
        this.bbP.setBackgroundDrawable(resources.getDrawable(a.e.sdk_transparent_bg));
        this.bbP.setOnDismissListener(onDismissListener);
        this.bbO.s(resources.getDimensionPixelSize(a.d.sdk_ds40));
        ShowUtil.showPopupWindowAsDropDown(this.bbP, view, 0, -this.mActivity.getResources().getDimensionPixelSize(a.d.sdk_ds12));
    }

    public void z(int i, int i2) {
        if (this.bbO != null) {
            this.bbO.x(i, i2);
        }
        if (this.bbR != null) {
            this.bbR.setBackgroundColor(0);
        }
    }

    public void K(List<k> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (k kVar : list) {
                if (this.mType != 1 || kVar.getNumber() != -1) {
                    if (kVar.getNumber() <= 0) {
                        arrayList.add(kVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
        this.bbS = new b(this.mActivity, this.mType);
        this.bbS.J(list);
        this.bbR.setAdapter((ListAdapter) this.bbS);
    }

    public void dismiss() {
        if (this.bbP != null && this.bbP.isShowing()) {
            if (this.mActivity == null) {
                ShowUtil.dismissPopupWindow(this.bbP);
            } else {
                ShowUtil.dismissPopupWindow(this.bbP, this.mActivity);
            }
        }
    }
}
