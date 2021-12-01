package com.baidu.live.business.view.banner;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes8.dex */
public class BannerView extends FrameLayout implements c.a.w.b.g.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BannerViewTag";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f35322e;

    /* renamed from: f  reason: collision with root package name */
    public int f35323f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35324g;

    /* renamed from: h  reason: collision with root package name */
    public String f35325h;

    /* renamed from: i  reason: collision with root package name */
    public LiveBannerStatusAnimView f35326i;

    /* renamed from: j  reason: collision with root package name */
    public List<LiveBannerEntity> f35327j;

    /* renamed from: k  reason: collision with root package name */
    public float f35328k;
    public boolean l;
    public h m;
    public ViewPager n;
    public LinearLayout o;
    public ImageView p;
    public ArrayList<BannerWrapFrameView> q;
    public TextView r;
    public int s;
    public int t;
    public int u;
    public f v;
    public BannerEntity w;
    public Handler x;
    public int y;
    public int z;

    /* loaded from: classes8.dex */
    public class a extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BannerView a;

        public a(BannerView bannerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bannerView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) {
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.w == null || this.a.w.mBannerList.size() == 0) {
                    return 0;
                }
                return this.a.w.mBannerList.size() == 1 ? 1 : Integer.MAX_VALUE;
            }
            return invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) {
                int size = this.a.w.mBannerList.size();
                if (size == 2) {
                    size = 4;
                }
                View view = (View) this.a.q.get(i2 % size);
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                viewGroup.addView(view);
                return view;
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BannerView f35329e;

        public b(BannerView bannerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35329e = bannerView;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f35329e.w == null) {
                return;
            }
            if (i2 == 1) {
                this.f35329e.q();
            } else if (i2 != 2) {
            } else {
                this.f35329e.r();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Animatable animatable;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f35329e.w == null || this.f35329e.w.mBannerList == null) {
                return;
            }
            if (this.f35329e.w.mBannerList.size() <= 0) {
                this.f35329e.f35322e = 0;
            } else {
                BannerView bannerView = this.f35329e;
                bannerView.f35322e = i2 % bannerView.w.mBannerList.size();
            }
            this.f35329e.w.mSelected = i2;
            for (int i3 = 0; i3 < this.f35329e.w.mBannerList.size(); i3++) {
                if (this.f35329e.q.get(i3) != null && ((BannerWrapFrameView) this.f35329e.q.get(i3)).getSimpleDraweeView() != null && (animatable = ((BannerWrapFrameView) this.f35329e.q.get(i3)).getSimpleDraweeView().getController().getAnimatable()) != null) {
                    if (i3 == this.f35329e.f35322e) {
                        animatable.start();
                    } else {
                        animatable.stop();
                    }
                }
            }
            BannerView bannerView2 = this.f35329e;
            bannerView2.setIndicatorCurrentItem(bannerView2.w.mSelected);
            this.f35329e.s(i2);
            if (i2 < this.f35329e.w.mBannerList.size() && i2 >= 0) {
                BannerView bannerView3 = this.f35329e;
                bannerView3.p(bannerView3.w.mBannerList.get(this.f35329e.f35322e));
            }
            this.f35329e.getLogger().a(this.f35329e.f35322e);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BannerWrapFrameView f35330e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BannerView f35331f;

        public c(BannerView bannerView, BannerWrapFrameView bannerWrapFrameView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerView, bannerWrapFrameView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35331f = bannerView;
            this.f35330e = bannerWrapFrameView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f35331f.m == null) {
                return;
            }
            this.f35331f.m.a(this.f35330e.getLiveBannerEntity());
        }
    }

    /* loaded from: classes8.dex */
    public class d extends BaseControllerListener<ImageInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BannerView f35332b;

        public d(BannerView bannerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35332b = bannerView;
            this.a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, imageInfo, animatable) == null) {
                super.onFinalImageSet(str, (String) imageInfo, animatable);
                if (this.a == 0) {
                    this.f35332b.getLogger().a(0);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends BaseControllerListener<ImageInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BannerView f35333b;

        public e(BannerView bannerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35333b = bannerView;
            this.a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, imageInfo, animatable) == null) {
                super.onFinalImageSet(str, (String) imageInfo, animatable);
                if (this.a == 0) {
                    this.f35333b.getLogger().a(0);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BannerView a;

        public f(BannerView bannerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bannerView;
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public BannerEntity f35334e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BannerView f35335f;

        public g(BannerView bannerView, BannerEntity bannerEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerView, bannerEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35335f = bannerView;
            this.f35334e = bannerEntity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f35335f.w == this.f35334e && this.f35335f.w != null) {
                this.f35335f.w.mSelected = this.f35335f.n.getCurrentItem() + 1;
                this.f35335f.n.setCurrentItem(this.f35335f.w.mSelected, true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface h {
        void a(LiveBannerEntity liveBannerEntity);
    }

    @TargetApi(21)
    /* loaded from: classes8.dex */
    public static class i extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        public i(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f2;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, outline) == null) {
                if (view.getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    view.measure(makeMeasureSpec, makeMeasureSpec);
                }
                outline.setRoundRect(new Rect(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight()), this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        public j(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view;
        }

        @RequiresApi(api = 21)
        public void a(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
                this.a.setClipToOutline(true);
                this.a.setOutlineProvider(new i(f2));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35328k = 0.266f;
        this.m = null;
        this.q = new ArrayList<>();
        this.v = new f(this);
        this.w = null;
        this.x = new Handler();
        n(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicatorCurrentItem(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65550, this, i2) == null) || this.o.getChildCount() <= 0) {
            return;
        }
        int childCount = i2 % this.o.getChildCount();
        int i3 = 0;
        while (i3 < this.o.getChildCount()) {
            View childAt = this.o.getChildAt(i3);
            childAt.setSelected(i3 == childCount);
            if (i3 == childCount) {
                childAt.getLayoutParams().width = this.s;
                childAt.getLayoutParams().height = this.t;
            } else {
                childAt.getLayoutParams().width = this.t;
                childAt.getLayoutParams().height = this.t;
            }
            i3++;
        }
        this.o.requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r2 != 3) goto L11;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (Math.abs(y - this.z) > Math.abs(x - this.y)) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        } else {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                r();
                getParent().requestDisallowInterceptTouchEvent(false);
            } else {
                this.y = x;
                this.z = y;
                getParent().requestDisallowInterceptTouchEvent(true);
                q();
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public f getLogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.v : (f) invokeV.objValue;
    }

    public boolean isBannerNeedUpdate(List<LiveBannerEntity> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (c.a.w.e.g.d.c(list)) {
                return false;
            }
            if (!c.a.w.e.g.d.c(this.f35327j) && c.a.w.e.g.d.a(list) == c.a.w.e.g.d.a(this.f35327j)) {
                for (LiveBannerEntity liveBannerEntity : list) {
                    boolean z = false;
                    for (LiveBannerEntity liveBannerEntity2 : this.f35327j) {
                        if (liveBannerEntity2 != null && !c.a.w.e.g.j.a(liveBannerEntity2.pic) && liveBannerEntity != null && !c.a.w.e.g.j.a(liveBannerEntity.pic) && liveBannerEntity2.pic.equals(liveBannerEntity.pic) && liveBannerEntity2.liveStatus == liveBannerEntity.liveStatus) {
                            z = true;
                        }
                    }
                    if (!z) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final BannerWrapFrameView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BannerWrapFrameView bannerWrapFrameView = new BannerWrapFrameView(getContext());
            bannerWrapFrameView.setIsImmersion(this.f35324g);
            bannerWrapFrameView.setOnClickListener(new c(this, bannerWrapFrameView));
            return bannerWrapFrameView;
        }
        return (BannerWrapFrameView) invokeV.objValue;
    }

    public final View m(int i2, int i3) {
        InterceptResult invokeII;
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i2, i3)) == null) {
            View view = new View(getContext());
            view.setSelected(i2 == i3);
            view.setBackgroundResource(c.a.w.c.a.b.live_feed_page_selector_banner_indicator_item);
            if (i2 == i3) {
                layoutParams = new LinearLayout.LayoutParams(this.s, this.t);
            } else {
                int i4 = this.t;
                layoutParams = new LinearLayout.LayoutParams(i4, i4);
            }
            if (i2 > 0) {
                layoutParams.leftMargin = this.u;
            }
            view.setLayoutParams(layoutParams);
            return view;
        }
        return (View) invokeII.objValue;
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            FrameLayout.inflate(context, c.a.w.c.a.d.live_feed_page_view_banner, this);
            this.s = c.a.w.b.f.a.a(context, 8.0f);
            this.t = c.a.w.b.f.a.a(context, 6.0f);
            this.u = c.a.w.b.f.a.a(getContext(), 4.0f);
            this.n = (ViewPager) findViewById(c.a.w.c.a.c.banner_view_pager);
            this.o = (LinearLayout) findViewById(c.a.w.c.a.c.banner_indicator);
            this.p = (ImageView) findViewById(c.a.w.c.a.c.banner_indicator_bg);
            this.r = (TextView) findViewById(c.a.w.c.a.c.ad_label);
            this.n.setAdapter(new a(this));
            this.n.setOnPageChangeListener(new b(this));
        }
    }

    public final void o(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            try {
                if (this.l) {
                    RoundingParams fromCornersRadius = RoundingParams.fromCornersRadius(c.a.w.b.f.a.a(getContext(), this.f35323f));
                    fromCornersRadius.setOverlayColor(-1);
                    int j2 = c.a.w.i.f.e().j(this.f35324g);
                    GenericDraweeHierarchy build = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(0).setRoundingParams(fromCornersRadius).setFailureImage(j2).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_XY).setPlaceholderImage(j2).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_XY).build();
                    AbstractDraweeController build2 = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setControllerListener(new d(this, i2)).setUri(this.w.mBannerList.get(i2).pic).build();
                    if (this.q.get(i3).getSimpleDraweeView() == null || this.q.get(i3).getSimpleDraweeView().getController() == null || (this.q.get(i3).getSimpleDraweeView().getController() != null && !this.q.get(i3).getSimpleDraweeView().getController().isSameImageRequest(build2))) {
                        this.q.get(i3).getSimpleDraweeView().setHierarchy(build);
                        this.q.get(i3).getSimpleDraweeView().setController(build2);
                    }
                    if (c.a.w.e.g.d.c(this.q) || i3 < 0 || i3 >= this.q.size() || c.a.w.e.g.d.c(this.w.mBannerList) || i2 < 0 || i2 >= this.w.mBannerList.size()) {
                        return;
                    }
                    this.q.get(i3).setData(this.w.mBannerList.get(i2));
                    return;
                }
                int j3 = c.a.w.i.f.e().j(this.f35324g);
                GenericDraweeHierarchy build3 = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(0).setFailureImage(j3).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_XY).setPlaceholderImage(j3).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_XY).build();
                AbstractDraweeController build4 = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setControllerListener(new e(this, i2)).setUri(this.w.mBannerList.get(i2).pic).build();
                if (this.q.get(i3).getSimpleDraweeView() == null || this.q.get(i3).getSimpleDraweeView().getController() == null || (this.q.get(i3).getSimpleDraweeView().getController() != null && !this.q.get(i3).getSimpleDraweeView().getController().isSameImageRequest(build4))) {
                    this.q.get(i3).getSimpleDraweeView().setHierarchy(build3);
                    this.q.get(i3).getSimpleDraweeView().setController(build4);
                }
                if (c.a.w.e.g.d.c(this.q) || i3 < 0 || i3 >= this.q.size() || c.a.w.e.g.d.c(this.w.mBannerList) || i2 < 0 || i2 >= this.w.mBannerList.size()) {
                    return;
                }
                this.q.get(i3).setData(this.w.mBannerList.get(i2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void onApplyData(Fragment fragment, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, fragment, bundle) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onAttachedToWindow();
            refresh();
        }
    }

    public void onDarkModeChange(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || c.a.w.e.g.d.c(this.q)) {
            return;
        }
        Iterator<BannerWrapFrameView> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().onDarkModeChange(str);
        }
        LiveBannerStatusAnimView liveBannerStatusAnimView = this.f35326i;
        if (liveBannerStatusAnimView != null) {
            liveBannerStatusAnimView.onDarkModeChange(str);
        }
    }

    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetachedFromWindow();
            q();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            int size = View.MeasureSpec.getSize(i2);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, View.MeasureSpec.getMode(i2)), View.MeasureSpec.makeMeasureSpec((int) (size * this.f35328k), 1073741824));
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            q();
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            getLogger().a(this.f35322e);
            r();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, view, i2) == null) {
            super.onVisibilityChanged(view, i2);
            if (i2 == 0) {
                refresh();
            } else {
                q();
            }
        }
    }

    public final void p(LiveBannerEntity liveBannerEntity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, liveBannerEntity) == null) && liveBannerEntity != null && liveBannerEntity.needLogShow) {
            LiveHostInfo liveHostInfo = liveBannerEntity.hostInfo;
            c.a.w.b.c.a.f(getContext(), this.f35325h, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, liveHostInfo == null ? "" : liveHostInfo.uk, this.f35324g ? "chenjinshi" : "zhibopindao", liveBannerEntity.statInfo);
            liveBannerEntity.needLogShow = false;
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.x.removeCallbacksAndMessages(null);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.x.postDelayed(new g(this, this.w), this.w.mBroadcastInterval);
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || this.w == null) {
            return;
        }
        this.o.removeAllViews();
        q();
        if (this.w.mBannerList.size() == 0) {
            return;
        }
        if (this.w.mBannerList.size() == 1) {
            this.o.setVisibility(8);
            while (this.q.size() < 1) {
                this.q.add(l());
            }
            o(0, 0);
        } else if (this.w.mBannerList.size() == 2) {
            this.o.setVisibility(0);
            LinearLayout linearLayout = this.o;
            BannerEntity bannerEntity = this.w;
            linearLayout.addView(m(0, bannerEntity.mSelected % bannerEntity.mBannerList.size()));
            LinearLayout linearLayout2 = this.o;
            BannerEntity bannerEntity2 = this.w;
            linearLayout2.addView(m(1, bannerEntity2.mSelected % bannerEntity2.mBannerList.size()));
            while (this.q.size() < 4) {
                this.q.add(l());
            }
            o(0, 0);
            o(1, 1);
            o(0, 2);
            o(1, 3);
            r();
        } else {
            this.o.setVisibility(0);
            for (int i2 = 0; i2 < this.w.mBannerList.size(); i2++) {
                BannerEntity bannerEntity3 = this.w;
                this.o.addView(m(i2, bannerEntity3.mSelected % bannerEntity3.mBannerList.size()));
                if (i2 >= this.q.size()) {
                    this.q.add(l());
                }
                o(i2, i2);
            }
            r();
        }
        this.n.getAdapter().notifyDataSetChanged();
        this.n.setCurrentItem(this.w.mSelected, false);
    }

    public final void s(int i2) {
        ArrayList<BannerWrapFrameView> arrayList;
        BannerEntity bannerEntity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (arrayList = this.q) == null || c.a.w.e.g.d.c(arrayList) || (bannerEntity = this.w) == null || c.a.w.e.g.d.c(bannerEntity.mBannerList)) {
            return;
        }
        int size = i2 % this.q.size();
        int size2 = i2 % this.w.mBannerList.size();
        if (size >= 0 && size2 >= 0) {
            if (size2 < this.w.mBannerList.size() && size < this.q.size()) {
                if (this.f35326i == null) {
                    LiveBannerStatusAnimView liveBannerStatusAnimView = new LiveBannerStatusAnimView(getContext());
                    this.f35326i = liveBannerStatusAnimView;
                    liveBannerStatusAnimView.setIsImmersion(this.f35324g);
                }
                if (this.f35326i.getParent() != null) {
                    ((ViewGroup) this.f35326i.getParent()).removeView(this.f35326i);
                }
                this.f35326i.setData(this.w.mBannerList.get(size2));
                if (this.q.get(size).getStatusViewContainer() != null) {
                    this.q.get(size).getStatusViewContainer().addView(this.f35326i);
                    return;
                }
                return;
            }
            LiveBannerStatusAnimView liveBannerStatusAnimView2 = this.f35326i;
            if (liveBannerStatusAnimView2 == null || liveBannerStatusAnimView2.getParent() == null) {
                return;
            }
            ((ViewGroup) this.f35326i.getParent()).removeView(this.f35326i);
            return;
        }
        LiveBannerStatusAnimView liveBannerStatusAnimView3 = this.f35326i;
        if (liveBannerStatusAnimView3 == null || liveBannerStatusAnimView3.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f35326i.getParent()).removeView(this.f35326i);
    }

    public void setAspectRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f2) == null) {
            this.f35328k = f2;
        }
    }

    public void setBannerEntity(BannerEntity bannerEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bannerEntity) == null) {
            Iterator<LiveBannerEntity> it = bannerEntity.mBannerList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                it.next();
                if (i2 >= 10) {
                    it.remove();
                }
                i2++;
            }
            this.w = bannerEntity;
            this.f35327j = (bannerEntity == null || c.a.w.e.g.d.c(bannerEntity.mBannerList)) ? null : this.w.mBannerList;
            refresh();
            if (bannerEntity == null || c.a.w.e.g.d.c(bannerEntity.mBannerList)) {
                return;
            }
            s(0);
            p(bannerEntity.mBannerList.get(0));
        }
    }

    public void setBannerMargin(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048599, this, i2, i3, i4, i5) == null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(i2, i3, i4, i5);
            }
        }
    }

    public void setIndicatorGravity(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i2) == null) || (linearLayout = this.o) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.gravity = i2;
        this.o.setLayoutParams(layoutParams);
    }

    public void setIndicatorInterval(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.u = i2;
        }
    }

    public void setIndicatorMargin(int i2, int i3, int i4, int i5) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048602, this, i2, i3, i4, i5) == null) || (linearLayout = this.o) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = i3;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.o.setLayoutParams(layoutParams);
    }

    public void setIsImmersion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.f35324g = z;
        }
    }

    public void setLargeIndicatorItemSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.s = i2;
        }
    }

    public void setOnBannerClickListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, hVar) == null) {
            this.m = hVar;
        }
    }

    public void setPageMargin(int i2) {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048606, this, i2) == null) || (viewPager = this.n) == null) {
            return;
        }
        viewPager.setPageMargin(c.a.w.b.f.a.a(getContext(), i2));
    }

    public void setShowRoundPicture(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.l = z;
            if (z) {
                if (i2 >= 0) {
                    this.f35323f = i2;
                } else {
                    this.f35323f = 0;
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    new j(this).a(c.a.w.b.f.a.a(getContext(), this.f35323f));
                    this.f35323f = 0;
                }
                this.p.setImageResource(c.a.w.c.a.b.live_feed_page_banner_round_indicator_bg);
            }
        }
    }

    public void setSmallIndicatorItemSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.t = i2;
        }
    }

    public void setSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.f35325h = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35328k = 0.266f;
        this.m = null;
        this.q = new ArrayList<>();
        this.v = new f(this);
        this.w = null;
        this.x = new Handler();
        n(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f35328k = 0.266f;
        this.m = null;
        this.q = new ArrayList<>();
        this.v = new f(this);
        this.w = null;
        this.x = new Handler();
        n(context);
    }
}
