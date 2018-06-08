package com.baidu.tbadk.core.tabHost;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a {
    private int anP;
    private FragmentTabHost aoi;
    private final b<com.baidu.adp.widget.ImageView.a> mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.tabHost.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass1) aVar, str, i);
            if (a.this.aoi == null || aVar == null || !aVar.na()) {
                a.this.xW();
                return;
            }
            FragmentTabWidget fragmentTabWidget = a.this.aoi.getFragmentTabWidget();
            CustomViewPager fragmentViewPager = a.this.aoi.getFragmentViewPager();
            FrameLayout tabWrapper = a.this.aoi.getTabWrapper();
            if (fragmentTabWidget != null && fragmentViewPager != null) {
                a.this.aoi.setNeedShowThemeStyle(false);
                fragmentTabWidget.setBackGroundDrawableResId(d.C0141d.black_alpha0);
                al.j(tabWrapper, d.C0141d.black_alpha0);
                al.j(fragmentTabWidget, d.C0141d.black_alpha0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fragmentViewPager.getLayoutParams();
                layoutParams.bottomMargin = l.e(a.this.aoi.getContext(), d.e.tbds100);
                fragmentViewPager.setLayoutParams(layoutParams);
                fragmentTabWidget.setBackgroundDrawable(new BitmapDrawable(aVar.mZ()));
            }
        }
    };

    public a(FragmentTabHost fragmentTabHost, int i) {
        this.anP = 0;
        this.aoi = fragmentTabHost;
        this.anP = i;
    }

    public void a(Pair<String, String> pair) {
        if (pair != null) {
            String str = (String) pair.first;
            String str2 = (String) pair.second;
            if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(str2)) {
                dL(str2);
            } else if (!TextUtils.isEmpty(str)) {
                dL(str);
            } else {
                xW();
            }
        }
    }

    private void dL(String str) {
        c.ig().a(str, 10, this.mCallback, getBdUniqueId());
    }

    private BdUniqueId getBdUniqueId() {
        e<?> ad;
        if (this.aoi == null || this.aoi.getContext() == null || (ad = i.ad(this.aoi.getContext())) == null) {
            return null;
        }
        return ad.getUniqueId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xW() {
        if (this.aoi != null && this.aoi.getFragmentTabWidget() != null) {
            this.aoi.getFragmentTabWidget().setBackGroundDrawableResId(this.anP);
            al.j(this.aoi.getFragmentTabWidget(), this.anP);
            al.j(this.aoi.getTabWrapper(), this.anP);
        }
    }
}
