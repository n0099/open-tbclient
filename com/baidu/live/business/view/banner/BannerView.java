package com.baidu.live.business.view.banner;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.tieba.R;
import com.baidu.tieba.fd0;
import com.baidu.tieba.oa0;
import com.baidu.tieba.qc0;
import com.baidu.tieba.tc0;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class BannerView extends FrameLayout {
    public int a;
    public int b;
    public String c;
    public LiveBannerStatusAnimView d;
    public List<LiveBannerEntity> e;
    public float f;
    public boolean g;
    public boolean h;
    public boolean i;
    public BannerViewPager j;
    public LinearLayout k;
    public ImageView l;
    public ArrayList<BannerWrapFrameView> m;
    public int n;
    public int o;
    public int p;
    public BannerEntity q;
    public Handler r;
    public g s;
    public i t;
    public h u;
    public j v;
    public int w;
    public int x;

    /* loaded from: classes3.dex */
    public interface g {
        void a(LiveBannerEntity liveBannerEntity);
    }

    /* loaded from: classes3.dex */
    public interface h {
        void a(LiveBannerEntity liveBannerEntity);
    }

    /* loaded from: classes3.dex */
    public interface i {
        void onBannerShow(LiveBannerEntity liveBannerEntity);
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a(int i);
    }

    /* loaded from: classes3.dex */
    public class a extends PagerAdapter {
        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            return view2 == obj;
        }

        public a() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (BannerView.this.q == null || BannerView.this.q.mBannerList.size() == 0) {
                return 0;
            }
            if (BannerView.this.q.mBannerList.size() == 1) {
                return 1;
            }
            return Integer.MAX_VALUE;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            int size = BannerView.this.q.mBannerList.size();
            if (size == 2) {
                size = 4;
            }
            View view2 = (View) BannerView.this.m.get(i % size);
            if (view2.getParent() != null) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            viewGroup.addView(view2);
            return view2;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewPager.OnPageChangeListener {
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (BannerView.this.q == null) {
                return;
            }
            if (i == 1) {
                BannerView.this.y();
            } else if (i == 2) {
                BannerView.this.A();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Animatable animatable;
            if (BannerView.this.q != null && BannerView.this.q.mBannerList != null) {
                if (BannerView.this.q.mBannerList.size() <= 0) {
                    BannerView.this.a = 0;
                } else {
                    BannerView bannerView = BannerView.this;
                    bannerView.a = i % bannerView.q.mBannerList.size();
                }
                BannerView.this.q.mSelected = i;
                for (int i2 = 0; i2 < BannerView.this.q.mBannerList.size(); i2++) {
                    if (BannerView.this.m.get(i2) != null && ((BannerWrapFrameView) BannerView.this.m.get(i2)).getSimpleDraweeView() != null && (animatable = ((BannerWrapFrameView) BannerView.this.m.get(i2)).getSimpleDraweeView().getController().getAnimatable()) != null) {
                        if (i2 == BannerView.this.a) {
                            animatable.start();
                        } else {
                            animatable.stop();
                        }
                    }
                }
                if (BannerView.this.h) {
                    BannerView bannerView2 = BannerView.this;
                    bannerView2.setIndicatorCurrentItem(bannerView2.q.mSelected);
                }
                BannerView.this.B(i);
                if (i < BannerView.this.q.mBannerList.size() && i >= 0) {
                    BannerView bannerView3 = BannerView.this;
                    bannerView3.t(bannerView3.q.mBannerList.get(BannerView.this.a));
                }
                if (BannerView.this.u != null) {
                    BannerView.this.u.a(BannerView.this.q.mBannerList.get(BannerView.this.a));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public final /* synthetic */ BannerWrapFrameView a;

        public c(BannerWrapFrameView bannerWrapFrameView) {
            this.a = bannerWrapFrameView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (BannerView.this.s != null) {
                BannerView.this.s.a(this.a.getLiveBannerEntity());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends BaseControllerListener<ImageInfo> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {
            super.onFinalImageSet(str, (String) imageInfo, animatable);
        }
    }

    /* loaded from: classes3.dex */
    public class e extends BaseControllerListener<ImageInfo> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {
            super.onFinalImageSet(str, (String) imageInfo, animatable);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public BannerEntity a;

        public f(BannerEntity bannerEntity) {
            this.a = bannerEntity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BannerView.this.q == this.a && BannerView.this.q != null) {
                if (BannerView.this.v != null) {
                    BannerView.this.v.a(BannerView.this.a);
                }
                BannerView.this.q.mSelected = BannerView.this.j.getCurrentItem() + 1;
                BannerView.this.j.setCurrentItem(BannerView.this.q.mSelected, true);
            }
        }
    }

    @TargetApi(21)
    /* loaded from: classes3.dex */
    public static class k extends ViewOutlineProvider {
        public float a;

        public k(float f) {
            this.a = f;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view2, Outline outline) {
            if (view2.getMeasuredWidth() == 0) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                view2.measure(makeMeasureSpec, makeMeasureSpec);
            }
            outline.setRoundRect(new Rect(0, 0, view2.getMeasuredWidth(), view2.getMeasuredHeight()), this.a);
        }
    }

    /* loaded from: classes3.dex */
    public static class l {
        public View a;

        public l(View view2) {
            this.a = view2;
        }

        @RequiresApi(api = 21)
        public void a(float f) {
            this.a.setClipToOutline(true);
            this.a.setOutlineProvider(new k(f));
        }
    }

    public BannerView(@NonNull Context context) {
        super(context);
        this.f = 0.266f;
        this.h = true;
        this.i = true;
        this.m = new ArrayList<>();
        this.q = null;
        this.r = new Handler();
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        q(context);
    }

    public void setAspectRatio(float f2) {
        this.f = f2;
    }

    public void setCanTouchScroll(boolean z) {
        this.i = z;
    }

    public void setHasIndicator(boolean z) {
        this.h = z;
        LinearLayout linearLayout = this.k;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public void setIndicatorGravity(int i2) {
        LinearLayout linearLayout = this.k;
        if (linearLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.gravity = i2;
            this.k.setLayoutParams(layoutParams);
        }
    }

    public void setIndicatorInterval(int i2) {
        this.p = i2;
    }

    public void setLargeIndicatorItemSize(int i2) {
        this.n = i2;
    }

    public void setOnBannerClickListener(g gVar) {
        this.s = gVar;
    }

    public void setOnBannerSelectListener(h hVar) {
        this.u = hVar;
    }

    public void setOnBannerShowListener(i iVar) {
        this.t = iVar;
    }

    public void setOnBannerSwitchListener(j jVar) {
        this.v = jVar;
    }

    public void setScene(String str) {
        this.c = str;
    }

    public void setSmallIndicatorItemSize(int i2) {
        this.o = i2;
    }

    public void setSwitchDuration(int i2) {
        BannerViewPager bannerViewPager = this.j;
        if (bannerViewPager != null) {
            bannerViewPager.setSwitchDuration(i2);
        }
    }

    public final void t(LiveBannerEntity liveBannerEntity) {
        if (liveBannerEntity != null && liveBannerEntity.needLogShow) {
            i iVar = this.t;
            if (iVar != null) {
                iVar.onBannerShow(liveBannerEntity);
            }
            liveBannerEntity.needLogShow = false;
        }
    }

    public void u(String str) {
        if (qc0.c(this.m)) {
            return;
        }
        Iterator<BannerWrapFrameView> it = this.m.iterator();
        while (it.hasNext()) {
            it.next().b(str);
        }
        LiveBannerStatusAnimView liveBannerStatusAnimView = this.d;
        if (liveBannerStatusAnimView != null) {
            liveBannerStatusAnimView.f(str);
        }
    }

    public BannerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 0.266f;
        this.h = true;
        this.i = true;
        this.m = new ArrayList<>();
        this.q = null;
        this.r = new Handler();
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        q(context);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, View.MeasureSpec.getMode(i2)), View.MeasureSpec.makeMeasureSpec((int) (size * this.f), 1073741824));
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view2, int i2) {
        super.onVisibilityChanged(view2, i2);
        if (i2 == 0) {
            z();
        } else {
            y();
        }
    }

    public void setShowRoundPicture(boolean z, int i2) {
        this.g = z;
        if (z) {
            if (i2 >= 0) {
                this.b = i2;
            } else {
                this.b = 0;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                new l(this).a(oa0.b(getContext(), this.b));
                this.b = 0;
            }
            this.l.setImageResource(R.drawable.obfuscated_res_0x7f080f07);
        }
    }

    public BannerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f = 0.266f;
        this.h = true;
        this.i = true;
        this.m = new ArrayList<>();
        this.q = null;
        this.r = new Handler();
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        q(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicatorCurrentItem(int i2) {
        boolean z;
        if (this.k.getChildCount() <= 0) {
            return;
        }
        int childCount = i2 % this.k.getChildCount();
        for (int i3 = 0; i3 < this.k.getChildCount(); i3++) {
            View childAt = this.k.getChildAt(i3);
            if (i3 == childCount) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (i3 == childCount) {
                childAt.getLayoutParams().width = this.n;
                childAt.getLayoutParams().height = this.o;
            } else {
                childAt.getLayoutParams().width = this.o;
                childAt.getLayoutParams().height = this.o;
            }
        }
        this.k.requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r3 != 3) goto L12;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.i) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (Math.abs(y - this.x) > Math.abs(x - this.w)) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                }
            }
            A();
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            this.w = x;
            this.x = y;
            getParent().requestDisallowInterceptTouchEvent(true);
            y();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void q(Context context) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d05db, this);
        this.n = oa0.b(context, 8.0f);
        this.o = oa0.b(context, 6.0f);
        this.p = oa0.b(getContext(), 4.0f);
        this.j = (BannerViewPager) findViewById(R.id.obfuscated_res_0x7f090340);
        this.k = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090337);
        this.l = (ImageView) findViewById(R.id.obfuscated_res_0x7f090338);
        this.j.setAdapter(new a());
        this.j.setOnPageChangeListener(new b());
    }

    public void setBannerEntity(BannerEntity bannerEntity) {
        List<LiveBannerEntity> list;
        Iterator<LiveBannerEntity> it = bannerEntity.mBannerList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            it.next();
            if (i2 >= 10) {
                it.remove();
            }
            i2++;
        }
        this.q = bannerEntity;
        if (bannerEntity != null && !qc0.c(bannerEntity.mBannerList)) {
            list = this.q.mBannerList;
        } else {
            list = null;
        }
        this.e = list;
        z();
        if (bannerEntity != null && !qc0.c(bannerEntity.mBannerList)) {
            B(0);
            t(bannerEntity.mBannerList.get(0));
        }
    }

    public final void A() {
        this.r.removeCallbacksAndMessages(null);
        this.r.postDelayed(new f(this.q), this.q.mBroadcastInterval);
    }

    public int getCurrentPosition() {
        return this.a;
    }

    public final BannerWrapFrameView o() {
        BannerWrapFrameView bannerWrapFrameView = new BannerWrapFrameView(getContext());
        bannerWrapFrameView.setOnClickListener(new c(bannerWrapFrameView));
        return bannerWrapFrameView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        z();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        y();
    }

    public void v() {
        y();
    }

    public void w() {
        y();
    }

    public void x() {
        A();
    }

    public final void y() {
        this.r.removeCallbacksAndMessages(null);
    }

    public final void B(int i2) {
        BannerEntity bannerEntity;
        ArrayList<BannerWrapFrameView> arrayList = this.m;
        if (arrayList != null && !qc0.c(arrayList) && (bannerEntity = this.q) != null && !qc0.c(bannerEntity.mBannerList)) {
            int size = i2 % this.m.size();
            int size2 = i2 % this.q.mBannerList.size();
            if (size >= 0 && size2 >= 0) {
                if (size2 < this.q.mBannerList.size() && size < this.m.size()) {
                    if (this.d == null) {
                        LiveBannerStatusAnimView liveBannerStatusAnimView = new LiveBannerStatusAnimView(getContext());
                        this.d = liveBannerStatusAnimView;
                        liveBannerStatusAnimView.setScene(this.c);
                    }
                    if (this.d.getParent() != null) {
                        ((ViewGroup) this.d.getParent()).removeView(this.d);
                    }
                    this.d.setData(this.q.mBannerList.get(size2));
                    if (this.m.get(size).getStatusViewContainer() != null) {
                        this.m.get(size).getStatusViewContainer().addView(this.d);
                        return;
                    }
                    return;
                }
                LiveBannerStatusAnimView liveBannerStatusAnimView2 = this.d;
                if (liveBannerStatusAnimView2 != null && liveBannerStatusAnimView2.getParent() != null) {
                    ((ViewGroup) this.d.getParent()).removeView(this.d);
                    return;
                }
                return;
            }
            LiveBannerStatusAnimView liveBannerStatusAnimView3 = this.d;
            if (liveBannerStatusAnimView3 != null && liveBannerStatusAnimView3.getParent() != null) {
                ((ViewGroup) this.d.getParent()).removeView(this.d);
            }
        }
    }

    public final View p(int i2, int i3) {
        boolean z;
        LinearLayout.LayoutParams layoutParams;
        View view2 = new View(getContext());
        if (i2 == i3) {
            z = true;
        } else {
            z = false;
        }
        view2.setSelected(z);
        view2.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f22);
        if (i2 == i3) {
            layoutParams = new LinearLayout.LayoutParams(this.n, this.o);
        } else {
            int i4 = this.o;
            layoutParams = new LinearLayout.LayoutParams(i4, i4);
        }
        if (i2 > 0) {
            layoutParams.leftMargin = this.p;
        }
        view2.setLayoutParams(layoutParams);
        return view2;
    }

    public boolean r(List<LiveBannerEntity> list) {
        if (qc0.c(list)) {
            return false;
        }
        if (qc0.c(this.e) || qc0.a(list) != qc0.a(this.e)) {
            return true;
        }
        for (LiveBannerEntity liveBannerEntity : list) {
            boolean z = false;
            for (LiveBannerEntity liveBannerEntity2 : this.e) {
                if (liveBannerEntity2 != null && !tc0.a(liveBannerEntity2.pic) && liveBannerEntity != null && !tc0.a(liveBannerEntity.pic) && liveBannerEntity2.pic.equals(liveBannerEntity.pic) && liveBannerEntity2.liveStatus == liveBannerEntity.liveStatus) {
                    z = true;
                }
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }

    public final void s(int i2, int i3) {
        try {
            if (this.g) {
                RoundingParams fromCornersRadius = RoundingParams.fromCornersRadius(oa0.b(getContext(), this.b));
                fromCornersRadius.setOverlayColor(-1);
                int l2 = fd0.f().l(this.c);
                GenericDraweeHierarchy build = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(0).setRoundingParams(fromCornersRadius).setFailureImage(l2).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_XY).setPlaceholderImage(l2).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_XY).build();
                AbstractDraweeController build2 = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setControllerListener(new d()).setUri(this.q.mBannerList.get(i2).pic).build();
                if (this.m.get(i3).getSimpleDraweeView() == null || this.m.get(i3).getSimpleDraweeView().getController() == null || (this.m.get(i3).getSimpleDraweeView().getController() != null && !this.m.get(i3).getSimpleDraweeView().getController().isSameImageRequest(build2))) {
                    this.m.get(i3).getSimpleDraweeView().setHierarchy(build);
                    this.m.get(i3).getSimpleDraweeView().setController(build2);
                }
                if (!qc0.c(this.m) && i3 >= 0 && i3 < this.m.size() && !qc0.c(this.q.mBannerList) && i2 >= 0 && i2 < this.q.mBannerList.size()) {
                    this.m.get(i3).setData(this.q.mBannerList.get(i2));
                    return;
                }
                return;
            }
            int l3 = fd0.f().l(this.c);
            GenericDraweeHierarchy build3 = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(0).setFailureImage(l3).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_XY).setPlaceholderImage(l3).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_XY).build();
            AbstractDraweeController build4 = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setControllerListener(new e()).setUri(this.q.mBannerList.get(i2).pic).build();
            if (this.m.get(i3).getSimpleDraweeView() == null || this.m.get(i3).getSimpleDraweeView().getController() == null || (this.m.get(i3).getSimpleDraweeView().getController() != null && !this.m.get(i3).getSimpleDraweeView().getController().isSameImageRequest(build4))) {
                this.m.get(i3).getSimpleDraweeView().setHierarchy(build3);
                this.m.get(i3).getSimpleDraweeView().setController(build4);
            }
            if (!qc0.c(this.m) && i3 >= 0 && i3 < this.m.size() && !qc0.c(this.q.mBannerList) && i2 >= 0 && i2 < this.q.mBannerList.size()) {
                this.m.get(i3).setData(this.q.mBannerList.get(i2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setIndicatorMargin(int i2, int i3, int i4, int i5) {
        LinearLayout linearLayout = this.k;
        if (linearLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.topMargin = i3;
            layoutParams.rightMargin = i4;
            layoutParams.bottomMargin = i5;
            this.k.setLayoutParams(layoutParams);
        }
    }

    public void z() {
        if (this.q == null) {
            return;
        }
        if (this.h) {
            this.k.removeAllViews();
        } else {
            this.k.setVisibility(8);
        }
        y();
        if (this.q.mBannerList.size() == 0) {
            return;
        }
        if (this.q.mBannerList.size() == 1) {
            this.k.setVisibility(8);
            while (this.m.size() < 1) {
                this.m.add(o());
            }
            s(0, 0);
        } else if (this.q.mBannerList.size() == 2) {
            if (this.h) {
                this.k.setVisibility(0);
                LinearLayout linearLayout = this.k;
                BannerEntity bannerEntity = this.q;
                linearLayout.addView(p(0, bannerEntity.mSelected % bannerEntity.mBannerList.size()));
                LinearLayout linearLayout2 = this.k;
                BannerEntity bannerEntity2 = this.q;
                linearLayout2.addView(p(1, bannerEntity2.mSelected % bannerEntity2.mBannerList.size()));
            }
            while (this.m.size() < 4) {
                this.m.add(o());
            }
            s(0, 0);
            s(1, 1);
            s(0, 2);
            s(1, 3);
            A();
        } else {
            if (this.h) {
                this.k.setVisibility(0);
            }
            for (int i2 = 0; i2 < this.q.mBannerList.size(); i2++) {
                if (this.h) {
                    BannerEntity bannerEntity3 = this.q;
                    this.k.addView(p(i2, bannerEntity3.mSelected % bannerEntity3.mBannerList.size()));
                }
                if (i2 >= this.m.size()) {
                    this.m.add(o());
                }
                s(i2, i2);
            }
            A();
        }
        this.j.getAdapter().notifyDataSetChanged();
        this.j.setCurrentItem(this.q.mSelected, false);
    }
}
