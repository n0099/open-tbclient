package com.baidu.cloudsdk.social.share.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ae;
import android.support.v4.view.bq;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.cloudsdk.assets.DrawableUtils;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import java.util.List;
/* loaded from: classes.dex */
public class SocialMediaGridView extends LinearLayout implements bq {

    /* renamed from: a  reason: collision with root package name */
    private GridViewParams f882a;
    private boolean b;
    private ViewPager c;
    private View.OnClickListener d;
    private SocialShareConfig e;
    private List f;
    private Drawable g;
    private Drawable h;
    private ImageView[] i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;

    /* loaded from: classes.dex */
    public class GridViewParams {
        public String mCurrentPageIcon;
        public int mFixedHeight;
        public int mItemTextColor;
        public int mItemTextShadowColor;
        public String mNonCurrentPageIcon;
        public int mPageIndicatorLayoutHeight;
    }

    /* loaded from: classes.dex */
    class a extends LinearLayout {
        public a(Context context, int i, int i2) {
            super(context);
            setOrientation(1);
            int fix720px = DrawableUtils.fix720px(context, 8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.setMargins(0, fix720px, 0, 0);
            layoutParams.weight = 1.0f;
            for (int i3 = 0; i3 < SocialMediaGridView.this.k; i3++) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setLayoutParams(layoutParams);
                linearLayout.setOrientation(0);
                addView(linearLayout);
                for (int i4 = 0; i4 < SocialMediaGridView.this.j; i4++) {
                    int i5 = (SocialMediaGridView.this.j * i3) + i4 + i;
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
                    layoutParams2.setMargins(0, 0, 0, 0);
                    layoutParams2.weight = 1.0f;
                    if (i5 >= SocialMediaGridView.this.f.size()) {
                        LinearLayout linearLayout2 = new LinearLayout(context);
                        linearLayout2.setLayoutParams(layoutParams2);
                        linearLayout.addView(linearLayout2);
                    } else {
                        linearLayout.addView(a(context, i5), layoutParams2);
                    }
                }
            }
        }

        private LinearLayout a(Context context, int i) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            int fix720px = DrawableUtils.fix720px(context, 12);
            linearLayout.setPadding(0, fix720px, 0, fix720px);
            ImageView imageView = new ImageView(context);
            imageView.setAdjustViewBounds(true);
            String mediaType = ((MediaType) SocialMediaGridView.this.f.get(i)).toString();
            MediaIconManager mediaIconManager = MediaIconManager.getInstance(context);
            Drawable nightModeIcon = SocialMediaGridView.this.b ? mediaIconManager.getNightModeIcon(mediaType) : mediaIconManager.getNormalIcon(mediaType);
            Drawable nightModePressedIcon = SocialMediaGridView.this.b ? mediaIconManager.getNightModePressedIcon(mediaType) : mediaIconManager.getNormalPressedIcon(mediaType);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, nightModePressedIcon);
            stateListDrawable.addState(new int[0], nightModeIcon);
            imageView.setImageDrawable(stateListDrawable);
            imageView.setTag(mediaType);
            imageView.setOnClickListener(SocialMediaGridView.this.d);
            int fix720px2 = DrawableUtils.fix720px(context, 96);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(fix720px2, fix720px2);
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(context);
            textView.setText(SocialMediaGridView.this.e.getString(mediaType.toString()));
            textView.setTextSize(0, DrawableUtils.fix720px(context, 26));
            textView.setTextColor(SocialMediaGridView.this.f882a.mItemTextColor);
            textView.setSingleLine();
            textView.setGravity(1);
            int fix720px3 = DrawableUtils.fix720px(context, 3);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, DrawableUtils.fix720px(context, 33));
            layoutParams2.setMargins(0, fix720px3, 0, 0);
            linearLayout.addView(textView, layoutParams2);
            linearLayout.setTag(mediaType);
            linearLayout.setOnClickListener(SocialMediaGridView.this.d);
            return linearLayout;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ae {
        private a[] b;

        public b() {
            if (SocialMediaGridView.this.l > 0) {
                this.b = new a[SocialMediaGridView.this.l];
            }
        }

        @Override // android.support.v4.view.ae
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
            this.b[i] = null;
        }

        @Override // android.support.v4.view.ae
        public int getCount() {
            if (this.b == null) {
                return 0;
            }
            return this.b.length;
        }

        @Override // android.support.v4.view.ae
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            if (this.b[i] == null) {
                int i2 = SocialMediaGridView.this.k * SocialMediaGridView.this.j;
                int i3 = i * i2;
                if (i == SocialMediaGridView.this.l - 1) {
                    i2 = SocialMediaGridView.this.f.size() - i3;
                }
                this.b[i] = new a(viewGroup.getContext(), i3, i2);
            }
            viewGroup.addView(this.b[i]);
            return this.b[i];
        }

        @Override // android.support.v4.view.ae
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public SocialMediaGridView(Context context, GridViewParams gridViewParams, boolean z, View.OnClickListener onClickListener) {
        super(context);
        this.f882a = gridViewParams;
        this.b = z;
        this.d = onClickListener;
        this.e = SocialShareConfig.getInstance(context);
        this.f = this.e.getSupportedMediaTypes();
        for (MediaType mediaType : this.e.getExcludedMediaTypesInShareMenu()) {
            this.f.remove(mediaType);
        }
        setOrientation(1);
        a(context);
        b(context);
        c(context);
    }

    private Drawable a() {
        if (this.h == null) {
            this.h = DrawableUtils.getDrawable(getContext(), this.e.getAssetFileName(this.f882a.mNonCurrentPageIcon));
        }
        return this.h;
    }

    private void a(Context context) {
        int fix720px = DrawableUtils.fix720px(context, 24);
        int fix720px2 = DrawableUtils.fix720px(context, 0);
        setPadding(fix720px, fix720px2, fix720px, 0);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        this.m = (DrawableUtils.fix720px(context, 12) * 2) + DrawableUtils.fix720px(context, 96) + DrawableUtils.fix720px(context, 33) + DrawableUtils.fix720px(context, 3);
        this.n = this.m;
        this.j = (i - (fix720px * 2)) / this.n;
        int size = this.f.size() / this.j;
        if (this.f.size() % this.j > 0) {
            size++;
        }
        int i3 = ((i2 - this.f882a.mFixedHeight) - fix720px2) - this.f882a.mPageIndicatorLayoutHeight;
        int fix720px3 = DrawableUtils.fix720px(context, 8) + this.m;
        this.k = i3 / fix720px3;
        if (this.k > 3) {
            this.k = 3;
        }
        this.l = (size % this.k > 0 ? 1 : 0) + (size / this.k);
        if (this.l > 1) {
            this.o = this.k * fix720px3;
            return;
        }
        this.o = size * fix720px3;
        this.k = size;
    }

    private Drawable b() {
        if (this.g == null) {
            this.g = DrawableUtils.getDrawable(getContext(), this.e.getAssetFileName(this.f882a.mCurrentPageIcon));
        }
        return this.g;
    }

    private void b(Context context) {
        this.c = new ViewPager(context);
        this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, this.o));
        this.c.setOnPageChangeListener(this);
        this.c.setAdapter(new b());
        addView(this.c);
    }

    private void c(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f882a.mPageIndicatorLayoutHeight));
        addView(relativeLayout);
        if (this.l <= 1) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = DrawableUtils.fix720px(context, 16);
        layoutParams.addRule(14);
        layoutParams.addRule(15, -1);
        linearLayout.setLayoutParams(layoutParams);
        relativeLayout.addView(linearLayout);
        this.i = new ImageView[this.l];
        int fix720px = DrawableUtils.fix720px(context, 13);
        int fix720px2 = DrawableUtils.fix720px(context, 14);
        int currentItem = this.c.getCurrentItem();
        for (int i = 0; i < this.l; i++) {
            this.i[i] = new ImageView(context);
            if (i != currentItem) {
                this.i[i].setImageDrawable(a());
            }
            this.i[i].setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(fix720px, fix720px);
            layoutParams2.setMargins(fix720px2 / 2, 0, fix720px2 / 2, 0);
            this.i[i].setLayoutParams(layoutParams2);
            linearLayout.addView(this.i[i]);
        }
        this.i[currentItem].setImageDrawable(b());
    }

    @Override // android.view.View
    @TargetApi(8)
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        removeAllViews();
        Context context = getContext();
        a(context);
        b(context);
        c(context);
    }

    @Override // android.support.v4.view.bq
    public void onPageScrollStateChanged(int i) {
        if (2 != i || this.i == null) {
            return;
        }
        int currentItem = this.c.getCurrentItem();
        for (int i2 = 0; i2 < this.l; i2++) {
            if (i2 != currentItem) {
                this.i[i2].setImageDrawable(a());
            }
        }
        this.i[currentItem].setImageDrawable(b());
    }

    @Override // android.support.v4.view.bq
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.bq
    public void onPageSelected(int i) {
    }
}
