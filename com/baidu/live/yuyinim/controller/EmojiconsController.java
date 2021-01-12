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
import java.util.Arrays;
import java.util.List;
/* loaded from: classes10.dex */
public class EmojiconsController implements ViewPager.OnPageChangeListener {
    private LinearLayout bZe;
    private ImageView[] bZf;
    private int bZg = -1;
    private ViewPager bZh;
    private RelativeLayout bZi;
    private LinearLayout bZj;
    private int bZk;
    private Context mContext;
    private View rootView;

    public static EmojiconsController c(Context context, View view) {
        return new EmojiconsController(context, view);
    }

    public EmojiconsController(Context context, View view) {
        this.bZk = -1;
        this.rootView = view;
        this.mContext = context;
        this.bZi = (RelativeLayout) view.findViewById(a.f.bd_im_emoji_root);
        this.bZj = (LinearLayout) view.findViewById(a.f.emojis_bar);
        this.bZh = (ViewPager) view.findViewById(a.f.emojis_pager);
        this.bZe = (LinearLayout) view.findViewById(a.f.emojis_viewgroup);
        this.bZh.setOnPageChangeListener(this);
        a aVar = new a(Arrays.asList(com.baidu.live.view.emojiview.a.b(this.mContext, b.bRe).Wf(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bRf).Wf(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bRg).Wf(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bRh).Wf(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bRi).Wf(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bRj).Wf(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bRk).Wf(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bRl).Wf(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bRm).Wf(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bRn).Wf()));
        this.bZh.setAdapter(aVar);
        this.bZf = new ImageView[aVar.getCount()];
        for (int i = 0; i < aVar.getCount(); i++) {
            ImageView imageView = new ImageView(this.mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(com.baidu.live.yuyinim.b.a.dip2px(this.mContext, 6.0f), 0, com.baidu.live.yuyinim.b.a.dip2px(this.mContext, 6.0f), 0);
            imageView.setLayoutParams(layoutParams);
            this.bZf[i] = imageView;
            this.bZe.addView(this.bZf[i]);
        }
        if (this.bZk == -1) {
            this.bZk = SharedPrefHelper.getInstance().getInt("audio_live_emoji_page", 0);
        }
        this.bZh.setCurrentItem(this.bZk);
        onPageSelected(this.bZk);
    }

    private void fo(int i) {
        for (int i2 = 0; i2 < this.bZf.length; i2++) {
            if (i == i2) {
                this.bZf[i2].setImageResource(a.e.bd_im_round_dot_select);
            } else {
                this.bZf[i2].setImageResource(a.e.bd_im_round_dot_normal);
            }
        }
    }

    public void XQ() {
        this.bZh.setAdapter(new a(Arrays.asList(com.baidu.live.view.emojiview.a.b(this.mContext, b.bRe).Wf(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bRf).Wf(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bRg).Wf(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bRh).Wf(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bRi).Wf(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bRj).Wf(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bRk).Wf(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bRl).Wf(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bRm).Wf(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bRn).Wf())));
        if (this.bZk == -1) {
            this.bZk = SharedPrefHelper.getInstance().getInt("audio_live_emoji_page", 0);
        }
        this.bZh.setCurrentItem(this.bZk);
        onPageSelected(this.bZk);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.bZg != i) {
            this.bZg = i;
            if (this.bZg >= 0) {
                if (this.bZg > 0) {
                    this.bZk = this.bZg;
                    SharedPrefHelper.getInstance().putInt("audio_live_emoji_page", this.bZg);
                }
                fo(this.bZg);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes10.dex */
    private static class a extends PagerAdapter {
        private List<View> aXl;

        public a(List<View> list) {
            this.aXl = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return ListUtils.getCount(this.aXl);
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
            View view = this.aXl.get(i);
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (i >= 0 && i < getCount()) {
                viewGroup.removeView(this.aXl.get(i));
            }
        }
    }
}
