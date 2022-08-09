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
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.tieba.R;
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
import com.repackage.ab0;
import com.repackage.la0;
import com.repackage.m80;
import com.repackage.oa0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class BannerView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bannerView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i, obj) == null) {
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.q == null || this.a.q.mBannerList.size() == 0) {
                    return 0;
                }
                return this.a.q.mBannerList.size() == 1 ? 1 : Integer.MAX_VALUE;
            }
            return invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                int size = this.a.q.mBannerList.size();
                if (size == 2) {
                    size = 4;
                }
                View view2 = (View) this.a.m.get(i % size);
                if (view2.getParent() != null) {
                    ((ViewGroup) view2.getParent()).removeView(view2);
                }
                viewGroup.addView(view2);
                return view2;
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BannerView a;

        public b(BannerView bannerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bannerView;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.q == null) {
                return;
            }
            if (i == 1) {
                this.a.y();
            } else if (i != 2) {
            } else {
                this.a.A();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Animatable animatable;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.a.q == null || this.a.q.mBannerList == null) {
                return;
            }
            if (this.a.q.mBannerList.size() <= 0) {
                this.a.a = 0;
            } else {
                BannerView bannerView = this.a;
                bannerView.a = i % bannerView.q.mBannerList.size();
            }
            this.a.q.mSelected = i;
            for (int i2 = 0; i2 < this.a.q.mBannerList.size(); i2++) {
                if (this.a.m.get(i2) != null && ((BannerWrapFrameView) this.a.m.get(i2)).getSimpleDraweeView() != null && (animatable = ((BannerWrapFrameView) this.a.m.get(i2)).getSimpleDraweeView().getController().getAnimatable()) != null) {
                    if (i2 == this.a.a) {
                        animatable.start();
                    } else {
                        animatable.stop();
                    }
                }
            }
            if (this.a.h) {
                BannerView bannerView2 = this.a;
                bannerView2.setIndicatorCurrentItem(bannerView2.q.mSelected);
            }
            this.a.B(i);
            if (i < this.a.q.mBannerList.size() && i >= 0) {
                BannerView bannerView3 = this.a;
                bannerView3.t(bannerView3.q.mBannerList.get(this.a.a));
            }
            if (this.a.u != null) {
                this.a.u.a(this.a.q.mBannerList.get(this.a.a));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BannerWrapFrameView a;
        public final /* synthetic */ BannerView b;

        public c(BannerView bannerView, BannerWrapFrameView bannerWrapFrameView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerView, bannerWrapFrameView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bannerView;
            this.a = bannerWrapFrameView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.s == null) {
                return;
            }
            this.b.s.a(this.a.getLiveBannerEntity());
        }
    }

    /* loaded from: classes2.dex */
    public class d extends BaseControllerListener<ImageInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BannerView a;

        public d(BannerView bannerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bannerView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, imageInfo, animatable) == null) {
                super.onFinalImageSet(str, (String) imageInfo, animatable);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends BaseControllerListener<ImageInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BannerView a;

        public e(BannerView bannerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bannerView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, imageInfo, animatable) == null) {
                super.onFinalImageSet(str, (String) imageInfo, animatable);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BannerEntity a;
        public final /* synthetic */ BannerView b;

        public f(BannerView bannerView, BannerEntity bannerEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerView, bannerEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bannerView;
            this.a = bannerEntity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.q == this.a && this.b.q != null) {
                if (this.b.v != null) {
                    this.b.v.a(this.b.a);
                }
                this.b.q.mSelected = this.b.j.getCurrentItem() + 1;
                this.b.j.setCurrentItem(this.b.q.mSelected, true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface g {
        void a(LiveBannerEntity liveBannerEntity);
    }

    /* loaded from: classes2.dex */
    public interface h {
        void a(LiveBannerEntity liveBannerEntity);
    }

    /* loaded from: classes2.dex */
    public interface i {
        void onBannerShow(LiveBannerEntity liveBannerEntity);
    }

    /* loaded from: classes2.dex */
    public interface j {
        void a(int i);
    }

    @TargetApi(21)
    /* loaded from: classes2.dex */
    public static class k extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        public k(float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view2, Outline outline) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, outline) == null) {
                if (view2.getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    view2.measure(makeMeasureSpec, makeMeasureSpec);
                }
                outline.setRoundRect(new Rect(0, 0, view2.getMeasuredWidth(), view2.getMeasuredHeight()), this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        public l(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }

        @RequiresApi(api = 21)
        public void a(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
                this.a.setClipToOutline(true);
                this.a.setOutlineProvider(new k(f));
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65553, this, i2) == null) || this.k.getChildCount() <= 0) {
            return;
        }
        int childCount = i2 % this.k.getChildCount();
        int i3 = 0;
        while (i3 < this.k.getChildCount()) {
            View childAt = this.k.getChildAt(i3);
            childAt.setSelected(i3 == childCount);
            if (i3 == childCount) {
                childAt.getLayoutParams().width = this.n;
                childAt.getLayoutParams().height = this.o;
            } else {
                childAt.getLayoutParams().width = this.o;
                childAt.getLayoutParams().height = this.o;
            }
            i3++;
        }
        this.k.requestLayout();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.r.removeCallbacksAndMessages(null);
            this.r.postDelayed(new f(this, this.q), this.q.mBroadcastInterval);
        }
    }

    public final void B(int i2) {
        ArrayList<BannerWrapFrameView> arrayList;
        BannerEntity bannerEntity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (arrayList = this.m) == null || la0.c(arrayList) || (bannerEntity = this.q) == null || la0.c(bannerEntity.mBannerList)) {
            return;
        }
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
            if (liveBannerStatusAnimView2 == null || liveBannerStatusAnimView2.getParent() == null) {
                return;
            }
            ((ViewGroup) this.d.getParent()).removeView(this.d);
            return;
        }
        LiveBannerStatusAnimView liveBannerStatusAnimView3 = this.d;
        if (liveBannerStatusAnimView3 == null || liveBannerStatusAnimView3.getParent() == null) {
            return;
        }
        ((ViewGroup) this.d.getParent()).removeView(this.d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        if (r3 != 3) goto L14;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (this.i) {
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
            return false;
        }
        return invokeL.booleanValue;
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.intValue;
    }

    public final BannerWrapFrameView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BannerWrapFrameView bannerWrapFrameView = new BannerWrapFrameView(getContext());
            bannerWrapFrameView.setOnClickListener(new c(this, bannerWrapFrameView));
            return bannerWrapFrameView;
        }
        return (BannerWrapFrameView) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            z();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            y();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            int size = View.MeasureSpec.getSize(i2);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, View.MeasureSpec.getMode(i2)), View.MeasureSpec.makeMeasureSpec((int) (size * this.f), 1073741824));
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, i2) == null) {
            super.onVisibilityChanged(view2, i2);
            if (i2 == 0) {
                z();
            } else {
                y();
            }
        }
    }

    public final View p(int i2, int i3) {
        InterceptResult invokeII;
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i2, i3)) == null) {
            View view2 = new View(getContext());
            view2.setSelected(i2 == i3);
            view2.setBackgroundResource(R.drawable.obfuscated_res_0x7f080ce2);
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
        return (View) invokeII.objValue;
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d053c, this);
            this.n = m80.b(context, 8.0f);
            this.o = m80.b(context, 6.0f);
            this.p = m80.b(getContext(), 4.0f);
            this.j = (BannerViewPager) findViewById(R.id.obfuscated_res_0x7f090323);
            this.k = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09031a);
            this.l = (ImageView) findViewById(R.id.obfuscated_res_0x7f09031b);
            this.j.setAdapter(new a(this));
            this.j.setOnPageChangeListener(new b(this));
        }
    }

    public boolean r(List<LiveBannerEntity> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, list)) == null) {
            if (la0.c(list)) {
                return false;
            }
            if (!la0.c(this.e) && la0.a(list) == la0.a(this.e)) {
                for (LiveBannerEntity liveBannerEntity : list) {
                    boolean z = false;
                    for (LiveBannerEntity liveBannerEntity2 : this.e) {
                        if (liveBannerEntity2 != null && !oa0.a(liveBannerEntity2.pic) && liveBannerEntity != null && !oa0.a(liveBannerEntity.pic) && liveBannerEntity2.pic.equals(liveBannerEntity.pic) && liveBannerEntity2.liveStatus == liveBannerEntity.liveStatus) {
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

    public final void s(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            try {
                if (this.g) {
                    RoundingParams fromCornersRadius = RoundingParams.fromCornersRadius(m80.b(getContext(), this.b));
                    fromCornersRadius.setOverlayColor(-1);
                    int k2 = ab0.f().k(this.c);
                    GenericDraweeHierarchy build = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(0).setRoundingParams(fromCornersRadius).setFailureImage(k2).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_XY).setPlaceholderImage(k2).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_XY).build();
                    AbstractDraweeController build2 = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setControllerListener(new d(this)).setUri(this.q.mBannerList.get(i2).pic).build();
                    if (this.m.get(i3).getSimpleDraweeView() == null || this.m.get(i3).getSimpleDraweeView().getController() == null || (this.m.get(i3).getSimpleDraweeView().getController() != null && !this.m.get(i3).getSimpleDraweeView().getController().isSameImageRequest(build2))) {
                        this.m.get(i3).getSimpleDraweeView().setHierarchy(build);
                        this.m.get(i3).getSimpleDraweeView().setController(build2);
                    }
                    if (la0.c(this.m) || i3 < 0 || i3 >= this.m.size() || la0.c(this.q.mBannerList) || i2 < 0 || i2 >= this.q.mBannerList.size()) {
                        return;
                    }
                    this.m.get(i3).setData(this.q.mBannerList.get(i2));
                    return;
                }
                int k3 = ab0.f().k(this.c);
                GenericDraweeHierarchy build3 = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(0).setFailureImage(k3).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_XY).setPlaceholderImage(k3).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_XY).build();
                AbstractDraweeController build4 = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setControllerListener(new e(this)).setUri(this.q.mBannerList.get(i2).pic).build();
                if (this.m.get(i3).getSimpleDraweeView() == null || this.m.get(i3).getSimpleDraweeView().getController() == null || (this.m.get(i3).getSimpleDraweeView().getController() != null && !this.m.get(i3).getSimpleDraweeView().getController().isSameImageRequest(build4))) {
                    this.m.get(i3).getSimpleDraweeView().setHierarchy(build3);
                    this.m.get(i3).getSimpleDraweeView().setController(build4);
                }
                if (la0.c(this.m) || i3 < 0 || i3 >= this.m.size() || la0.c(this.q.mBannerList) || i2 < 0 || i2 >= this.q.mBannerList.size()) {
                    return;
                }
                this.m.get(i3).setData(this.q.mBannerList.get(i2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setAspectRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            this.f = f2;
        }
    }

    public void setBannerEntity(BannerEntity bannerEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bannerEntity) == null) {
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
            this.e = (bannerEntity == null || la0.c(bannerEntity.mBannerList)) ? null : this.q.mBannerList;
            z();
            if (bannerEntity == null || la0.c(bannerEntity.mBannerList)) {
                return;
            }
            B(0);
            t(bannerEntity.mBannerList.get(0));
        }
    }

    public void setCanTouchScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.i = z;
        }
    }

    public void setHasIndicator(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.h = z;
            LinearLayout linearLayout = this.k;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        }
    }

    public void setIndicatorGravity(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (linearLayout = this.k) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.gravity = i2;
        this.k.setLayoutParams(layoutParams);
    }

    public void setIndicatorInterval(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.p = i2;
        }
    }

    public void setIndicatorMargin(int i2, int i3, int i4, int i5) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048595, this, i2, i3, i4, i5) == null) || (linearLayout = this.k) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = i3;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.k.setLayoutParams(layoutParams);
    }

    public void setLargeIndicatorItemSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.n = i2;
        }
    }

    public void setOnBannerClickListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, gVar) == null) {
            this.s = gVar;
        }
    }

    public void setOnBannerSelectListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, hVar) == null) {
            this.u = hVar;
        }
    }

    public void setOnBannerShowListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iVar) == null) {
            this.t = iVar;
        }
    }

    public void setOnBannerSwitchListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, jVar) == null) {
            this.v = jVar;
        }
    }

    public void setScene(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.c = str;
        }
    }

    public void setShowRoundPicture(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.g = z;
            if (z) {
                if (i2 >= 0) {
                    this.b = i2;
                } else {
                    this.b = 0;
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    new l(this).a(m80.b(getContext(), this.b));
                    this.b = 0;
                }
                this.l.setImageResource(R.drawable.obfuscated_res_0x7f080cc7);
            }
        }
    }

    public void setSmallIndicatorItemSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.o = i2;
        }
    }

    public void setSwitchDuration(int i2) {
        BannerViewPager bannerViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048604, this, i2) == null) || (bannerViewPager = this.j) == null) {
            return;
        }
        bannerViewPager.setSwitchDuration(i2);
    }

    public final void t(LiveBannerEntity liveBannerEntity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, liveBannerEntity) == null) && liveBannerEntity != null && liveBannerEntity.needLogShow) {
            i iVar = this.t;
            if (iVar != null) {
                iVar.onBannerShow(liveBannerEntity);
            }
            liveBannerEntity.needLogShow = false;
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, str) == null) || la0.c(this.m)) {
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

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            y();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            y();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            A();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.r.removeCallbacksAndMessages(null);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || this.q == null) {
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
}
