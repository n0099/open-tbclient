package com.baidu.live.yuyinim.controller;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.view.emojiview.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class EmojiconsController implements ViewPager.OnPageChangeListener {
    private LinearLayout cdi;
    private ImageView[] cdj;
    private int cdk = -1;
    private ViewPager cdl;
    private RelativeLayout cdm;
    private LinearLayout cdo;
    private int cdp;
    private Context mContext;
    private View rootView;

    public static EmojiconsController c(Context context, View view) {
        return new EmojiconsController(context, view);
    }

    public EmojiconsController(Context context, View view) {
        this.cdp = -1;
        this.rootView = view;
        this.mContext = context;
        this.cdm = (RelativeLayout) view.findViewById(a.f.bd_im_emoji_root);
        this.cdo = (LinearLayout) view.findViewById(a.f.emojis_bar);
        this.cdl = (ViewPager) view.findViewById(a.f.emojis_pager);
        this.cdi = (LinearLayout) view.findViewById(a.f.emojis_viewgroup);
        this.cdl.setOnPageChangeListener(this);
        a aVar = new a(ZG());
        this.cdl.setAdapter(aVar);
        this.cdj = new ImageView[aVar.getCount()];
        for (int i = 0; i < aVar.getCount(); i++) {
            ImageView imageView = new ImageView(this.mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(com.baidu.live.yuyinim.b.a.dip2px(this.mContext, 6.0f), 0, com.baidu.live.yuyinim.b.a.dip2px(this.mContext, 6.0f), 0);
            imageView.setLayoutParams(layoutParams);
            this.cdj[i] = imageView;
            this.cdi.addView(this.cdj[i]);
        }
        if (this.cdp == -1) {
            this.cdp = SharedPrefHelper.getInstance().getInt("audio_live_emoji_page", 0);
        }
        this.cdl.setCurrentItem(this.cdp);
        onPageSelected(this.cdp);
    }

    private List<View> ZG() {
        List<String> list = b.bUT;
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        int i = 0;
        while (z) {
            int i2 = i + 20;
            if (i2 > list.size()) {
                i2 = list.size();
            }
            List<String> subList = list.subList(i, i2);
            boolean z2 = subList.size() < 20 ? false : z;
            arrayList.add(com.baidu.live.view.emojiview.a.c(this.mContext, subList).XO());
            i += 20;
            z = z2;
        }
        return arrayList;
    }

    private void fu(int i) {
        for (int i2 = 0; i2 < this.cdj.length; i2++) {
            if (i == i2) {
                this.cdj[i2].setImageResource(a.e.bd_im_round_dot_select);
            } else {
                this.cdj[i2].setImageResource(a.e.bd_im_round_dot_normal);
            }
        }
    }

    public void ZH() {
        a aVar = new a(ZG());
        this.cdl.setAdapter(aVar);
        this.cdj = new ImageView[aVar.getCount()];
        this.cdi.removeAllViews();
        for (int i = 0; i < aVar.getCount(); i++) {
            ImageView imageView = new ImageView(this.mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(com.baidu.live.yuyinim.b.a.dip2px(this.mContext, 6.0f), 0, com.baidu.live.yuyinim.b.a.dip2px(this.mContext, 6.0f), 0);
            imageView.setLayoutParams(layoutParams);
            this.cdj[i] = imageView;
            this.cdi.addView(this.cdj[i]);
        }
        if (this.cdp == -1) {
            this.cdp = SharedPrefHelper.getInstance().getInt("audio_live_emoji_page", 0);
        }
        this.cdl.setCurrentItem(this.cdp);
        onPageSelected(this.cdp);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.cdk = i;
        if (this.cdk >= 0) {
            this.cdp = this.cdk;
            SharedPrefHelper.getInstance().putInt("audio_live_emoji_page", this.cdk);
            fu(this.cdk);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes11.dex */
    private static class a extends PagerAdapter {
        private List<View> bas;

        public a(List<View> list) {
            this.bas = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return ListUtils.getCount(this.bas);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            View view = this.bas.get(i);
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (i >= 0 && i < getCount()) {
                viewGroup.removeView(this.bas.get(i));
            }
        }
    }
}
