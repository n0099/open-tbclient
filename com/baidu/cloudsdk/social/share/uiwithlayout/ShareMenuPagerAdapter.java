package com.baidu.cloudsdk.social.share.uiwithlayout;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.List;
/* loaded from: classes.dex */
public class ShareMenuPagerAdapter extends PagerAdapter {
    private List a;

    public ShareMenuPagerAdapter(Context context, List list) {
        this.a = list;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView((View) obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.a.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView((View) this.a.get(i));
        return this.a.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
