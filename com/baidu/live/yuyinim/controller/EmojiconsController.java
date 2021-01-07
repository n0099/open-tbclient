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
/* loaded from: classes11.dex */
public class EmojiconsController implements ViewPager.OnPageChangeListener {
    private LinearLayout cdU;
    private ImageView[] cdV;
    private int cdW = -1;
    private ViewPager cdX;
    private RelativeLayout cdY;
    private LinearLayout cdZ;
    private int cea;
    private Context mContext;
    private View rootView;

    public static EmojiconsController c(Context context, View view) {
        return new EmojiconsController(context, view);
    }

    public EmojiconsController(Context context, View view) {
        this.cea = -1;
        this.rootView = view;
        this.mContext = context;
        this.cdY = (RelativeLayout) view.findViewById(a.f.bd_im_emoji_root);
        this.cdZ = (LinearLayout) view.findViewById(a.f.emojis_bar);
        this.cdX = (ViewPager) view.findViewById(a.f.emojis_pager);
        this.cdU = (LinearLayout) view.findViewById(a.f.emojis_viewgroup);
        this.cdX.setOnPageChangeListener(this);
        a aVar = new a(Arrays.asList(com.baidu.live.view.emojiview.a.b(this.mContext, b.bVQ).ZY(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bVR).ZY(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bVS).ZY(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bVT).ZY(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bVU).ZY(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bVV).ZY(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bVW).ZY(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bVX).ZY(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bVY).ZY(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bVZ).ZY()));
        this.cdX.setAdapter(aVar);
        this.cdV = new ImageView[aVar.getCount()];
        for (int i = 0; i < aVar.getCount(); i++) {
            ImageView imageView = new ImageView(this.mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(com.baidu.live.yuyinim.b.a.dip2px(this.mContext, 6.0f), 0, com.baidu.live.yuyinim.b.a.dip2px(this.mContext, 6.0f), 0);
            imageView.setLayoutParams(layoutParams);
            this.cdV[i] = imageView;
            this.cdU.addView(this.cdV[i]);
        }
        if (this.cea == -1) {
            this.cea = SharedPrefHelper.getInstance().getInt("audio_live_emoji_page", 0);
        }
        this.cdX.setCurrentItem(this.cea);
        onPageSelected(this.cea);
    }

    private void gV(int i) {
        for (int i2 = 0; i2 < this.cdV.length; i2++) {
            if (i == i2) {
                this.cdV[i2].setImageResource(a.e.bd_im_round_dot_select);
            } else {
                this.cdV[i2].setImageResource(a.e.bd_im_round_dot_normal);
            }
        }
    }

    public void abJ() {
        this.cdX.setAdapter(new a(Arrays.asList(com.baidu.live.view.emojiview.a.b(this.mContext, b.bVQ).ZY(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bVR).ZY(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bVS).ZY(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bVT).ZY(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bVU).ZY(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bVV).ZY(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bVW).ZY(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bVX).ZY(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bVY).ZY(), com.baidu.live.view.emojiview.a.b(this.mContext, b.bVZ).ZY())));
        if (this.cea == -1) {
            this.cea = SharedPrefHelper.getInstance().getInt("audio_live_emoji_page", 0);
        }
        this.cdX.setCurrentItem(this.cea);
        onPageSelected(this.cea);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.cdW != i) {
            this.cdW = i;
            if (this.cdW >= 0) {
                if (this.cdW > 0) {
                    this.cea = this.cdW;
                    SharedPrefHelper.getInstance().putInt("audio_live_emoji_page", this.cdW);
                }
                gV(this.cdW);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes11.dex */
    private static class a extends PagerAdapter {
        private List<View> bbZ;

        public a(List<View> list) {
            this.bbZ = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return ListUtils.getCount(this.bbZ);
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
            View view = this.bbZ.get(i);
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (i >= 0 && i < getCount()) {
                viewGroup.removeView(this.bbZ.get(i));
            }
        }
    }
}
