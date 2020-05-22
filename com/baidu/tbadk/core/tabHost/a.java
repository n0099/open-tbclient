package com.baidu.tbadk.core.tabHost;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.e.b;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a {
    private final b<com.baidu.adp.widget.ImageView.a> dLn = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.tabHost.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass1) aVar, str, i);
            if (a.this.mTabHost == null || aVar == null || !aVar.isValidNow()) {
                a.this.aUc();
                return;
            }
            FragmentTabWidget fragmentTabWidget = a.this.mTabHost.getFragmentTabWidget();
            CustomViewPager fragmentViewPager = a.this.mTabHost.getFragmentViewPager();
            ViewGroup tabWrapper = a.this.mTabHost.getTabWrapper();
            if (fragmentTabWidget != null && fragmentViewPager != null) {
                a.this.mTabHost.setNeedShowThemeStyle(false);
                fragmentTabWidget.setBackGroundDrawableResId(R.color.black_alpha0);
                am.setBackgroundColor(tabWrapper, R.color.black_alpha0);
                am.setBackgroundColor(fragmentTabWidget, R.color.black_alpha0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fragmentViewPager.getLayoutParams();
                layoutParams.bottomMargin = l.getDimens(a.this.mTabHost.getContext(), R.dimen.tbds100);
                fragmentViewPager.setLayoutParams(layoutParams);
                fragmentTabWidget.setBackgroundDrawable(new BitmapDrawable(aVar.getRawBitmap()));
            }
        }
    };
    private int mBackgroundColorResId;
    private FragmentTabHost mTabHost;

    public a(FragmentTabHost fragmentTabHost, int i) {
        this.mBackgroundColorResId = 0;
        this.mTabHost = fragmentTabHost;
        this.mBackgroundColorResId = i;
    }

    public void d(Pair<String, String> pair) {
        if (pair != null) {
            String str = (String) pair.first;
            String str2 = (String) pair.second;
            if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(str2)) {
                wa(str2);
            } else if (!TextUtils.isEmpty(str)) {
                wa(str);
            } else {
                aUc();
            }
        }
    }

    private void wa(String str) {
        c.kX().a(str, 10, this.dLn, getBdUniqueId());
    }

    private BdUniqueId getBdUniqueId() {
        e<?> G;
        if (this.mTabHost == null || this.mTabHost.getContext() == null || (G = i.G(this.mTabHost.getContext())) == null) {
            return null;
        }
        return G.getUniqueId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUc() {
        if (this.mTabHost != null && this.mTabHost.getFragmentTabWidget() != null) {
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(this.mBackgroundColorResId);
            am.setBackgroundColor(this.mTabHost.getFragmentTabWidget(), this.mBackgroundColorResId);
            am.setBackgroundColor(this.mTabHost.getTabWrapper(), this.mBackgroundColorResId);
        }
    }
}
