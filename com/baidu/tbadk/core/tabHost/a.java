package com.baidu.tbadk.core.tabHost;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class a {
    private int awb;
    private final b<com.baidu.adp.widget.ImageView.a> mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.tabHost.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass1) aVar, str, i);
            if (a.this.mTabHost == null || aVar == null || !aVar.or()) {
                a.this.Bw();
                return;
            }
            FragmentTabWidget fragmentTabWidget = a.this.mTabHost.getFragmentTabWidget();
            CustomViewPager fragmentViewPager = a.this.mTabHost.getFragmentViewPager();
            ViewGroup tabWrapper = a.this.mTabHost.getTabWrapper();
            if (fragmentTabWidget != null && fragmentViewPager != null) {
                a.this.mTabHost.setNeedShowThemeStyle(false);
                fragmentTabWidget.setBackGroundDrawableResId(e.d.black_alpha0);
                al.j(tabWrapper, e.d.black_alpha0);
                al.j(fragmentTabWidget, e.d.black_alpha0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fragmentViewPager.getLayoutParams();
                layoutParams.bottomMargin = l.h(a.this.mTabHost.getContext(), e.C0200e.tbds100);
                fragmentViewPager.setLayoutParams(layoutParams);
                fragmentTabWidget.setBackgroundDrawable(new BitmapDrawable(aVar.oq()));
            }
        }
    };
    private FragmentTabHost mTabHost;

    public a(FragmentTabHost fragmentTabHost, int i) {
        this.awb = 0;
        this.mTabHost = fragmentTabHost;
        this.awb = i;
    }

    public void a(Pair<String, String> pair) {
        if (pair != null) {
            String str = (String) pair.first;
            String str2 = (String) pair.second;
            if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(str2)) {
                et(str2);
            } else if (!TextUtils.isEmpty(str)) {
                et(str);
            } else {
                Bw();
            }
        }
    }

    private void et(String str) {
        c.jA().a(str, 10, this.mCallback, getBdUniqueId());
    }

    private BdUniqueId getBdUniqueId() {
        com.baidu.adp.base.e<?> aK;
        if (this.mTabHost == null || this.mTabHost.getContext() == null || (aK = i.aK(this.mTabHost.getContext())) == null) {
            return null;
        }
        return aK.getUniqueId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bw() {
        if (this.mTabHost != null && this.mTabHost.getFragmentTabWidget() != null) {
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(this.awb);
            al.j(this.mTabHost.getFragmentTabWidget(), this.awb);
            al.j(this.mTabHost.getTabWrapper(), this.awb);
        }
    }
}
