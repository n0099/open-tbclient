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
/* loaded from: classes10.dex */
public class EmojiconsController implements ViewPager.OnPageChangeListener {
    private LinearLayout ceK;
    private ImageView[] ceL;
    private int ceM = -1;
    private ViewPager ceN;
    private RelativeLayout ceO;
    private LinearLayout ceP;
    private int ceQ;
    private Context mContext;
    private View rootView;

    public static EmojiconsController b(Context context, View view) {
        return new EmojiconsController(context, view);
    }

    public EmojiconsController(Context context, View view) {
        this.ceQ = -1;
        this.rootView = view;
        this.mContext = context;
        this.ceO = (RelativeLayout) view.findViewById(a.f.bd_im_emoji_root);
        this.ceP = (LinearLayout) view.findViewById(a.f.emojis_bar);
        this.ceN = (ViewPager) view.findViewById(a.f.emojis_pager);
        this.ceK = (LinearLayout) view.findViewById(a.f.emojis_viewgroup);
        this.ceN.setOnPageChangeListener(this);
        a aVar = new a(ZJ());
        this.ceN.setAdapter(aVar);
        this.ceL = new ImageView[aVar.getCount()];
        for (int i = 0; i < aVar.getCount(); i++) {
            ImageView imageView = new ImageView(this.mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(com.baidu.live.yuyinim.b.a.dip2px(this.mContext, 6.0f), 0, com.baidu.live.yuyinim.b.a.dip2px(this.mContext, 6.0f), 0);
            imageView.setLayoutParams(layoutParams);
            this.ceL[i] = imageView;
            this.ceK.addView(this.ceL[i]);
        }
        if (this.ceQ == -1) {
            this.ceQ = SharedPrefHelper.getInstance().getInt("audio_live_emoji_page", 0);
        }
        this.ceN.setCurrentItem(this.ceQ);
        onPageSelected(this.ceQ);
    }

    private List<View> ZJ() {
        List<String> list = b.bWt;
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
            arrayList.add(com.baidu.live.view.emojiview.a.c(this.mContext, subList).XR());
            i += 20;
            z = z2;
        }
        return arrayList;
    }

    private void fv(int i) {
        for (int i2 = 0; i2 < this.ceL.length; i2++) {
            if (i == i2) {
                this.ceL[i2].setImageResource(a.e.bd_im_round_dot_select);
            } else {
                this.ceL[i2].setImageResource(a.e.bd_im_round_dot_normal);
            }
        }
    }

    public void ZK() {
        a aVar = new a(ZJ());
        this.ceN.setAdapter(aVar);
        this.ceL = new ImageView[aVar.getCount()];
        this.ceK.removeAllViews();
        for (int i = 0; i < aVar.getCount(); i++) {
            ImageView imageView = new ImageView(this.mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(com.baidu.live.yuyinim.b.a.dip2px(this.mContext, 6.0f), 0, com.baidu.live.yuyinim.b.a.dip2px(this.mContext, 6.0f), 0);
            imageView.setLayoutParams(layoutParams);
            this.ceL[i] = imageView;
            this.ceK.addView(this.ceL[i]);
        }
        if (this.ceQ == -1) {
            this.ceQ = SharedPrefHelper.getInstance().getInt("audio_live_emoji_page", 0);
        }
        this.ceN.setCurrentItem(this.ceQ);
        onPageSelected(this.ceQ);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.ceM = i;
        if (this.ceM >= 0) {
            this.ceQ = this.ceM;
            SharedPrefHelper.getInstance().putInt("audio_live_emoji_page", this.ceM);
            fv(this.ceM);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes10.dex */
    private static class a extends PagerAdapter {
        private List<View> bbS;

        public a(List<View> list) {
            this.bbS = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return ListUtils.getCount(this.bbS);
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
            View view = this.bbS.get(i);
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (i >= 0 && i < getCount()) {
                viewGroup.removeView(this.bbS.get(i));
            }
        }
    }
}
