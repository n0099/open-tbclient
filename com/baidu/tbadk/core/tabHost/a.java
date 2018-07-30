package com.baidu.tbadk.core.tabHost;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a {
    private int anQ;
    private final b<com.baidu.adp.widget.ImageView.a> mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.tabHost.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass1) aVar, str, i);
            if (a.this.mTabHost == null || aVar == null || !aVar.nc()) {
                a.this.yb();
                return;
            }
            FragmentTabWidget fragmentTabWidget = a.this.mTabHost.getFragmentTabWidget();
            CustomViewPager fragmentViewPager = a.this.mTabHost.getFragmentViewPager();
            ViewGroup tabWrapper = a.this.mTabHost.getTabWrapper();
            if (fragmentTabWidget != null && fragmentViewPager != null) {
                a.this.mTabHost.setNeedShowThemeStyle(false);
                fragmentTabWidget.setBackGroundDrawableResId(d.C0140d.black_alpha0);
                am.j(tabWrapper, d.C0140d.black_alpha0);
                am.j(fragmentTabWidget, d.C0140d.black_alpha0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fragmentViewPager.getLayoutParams();
                layoutParams.bottomMargin = l.f(a.this.mTabHost.getContext(), d.e.tbds100);
                fragmentViewPager.setLayoutParams(layoutParams);
                fragmentTabWidget.setBackgroundDrawable(new BitmapDrawable(aVar.nb()));
            }
        }
    };
    private FragmentTabHost mTabHost;

    public a(FragmentTabHost fragmentTabHost, int i) {
        this.anQ = 0;
        this.mTabHost = fragmentTabHost;
        this.anQ = i;
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
                yb();
            }
        }
    }

    private void dL(String str) {
        c.ih().a(str, 10, this.mCallback, getBdUniqueId());
    }

    private BdUniqueId getBdUniqueId() {
        e<?> ad;
        if (this.mTabHost == null || this.mTabHost.getContext() == null || (ad = i.ad(this.mTabHost.getContext())) == null) {
            return null;
        }
        return ad.getUniqueId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yb() {
        if (this.mTabHost != null && this.mTabHost.getFragmentTabWidget() != null) {
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(this.anQ);
            am.j(this.mTabHost.getFragmentTabWidget(), this.anQ);
            am.j(this.mTabHost.getTabWrapper(), this.anQ);
        }
    }
}
