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
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.live.business.model.data.LiveHostInfo;
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
import com.repackage.ba0;
import com.repackage.ha0;
import com.repackage.ic0;
import com.repackage.m90;
import com.repackage.rb0;
import com.repackage.xb0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class BannerView extends FrameLayout implements ha0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public boolean c;
    public String d;
    public LiveBannerStatusAnimView e;
    public List<LiveBannerEntity> f;
    public float g;
    public boolean h;
    public h i;
    public ViewPager j;
    public LinearLayout k;
    public ImageView l;
    public ArrayList<BannerWrapFrameView> m;
    public TextView n;
    public int o;
    public int p;
    public int q;
    public f r;
    public BannerEntity s;
    public Handler t;
    public int u;
    public int v;

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
                if (this.a.s == null || this.a.s.mBannerList.size() == 0) {
                    return 0;
                }
                return this.a.s.mBannerList.size() == 1 ? 1 : Integer.MAX_VALUE;
            }
            return invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                int size = this.a.s.mBannerList.size();
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
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.s == null) {
                return;
            }
            if (i == 1) {
                this.a.v();
            } else if (i != 2) {
            } else {
                this.a.x();
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
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.a.s == null || this.a.s.mBannerList == null) {
                return;
            }
            if (this.a.s.mBannerList.size() <= 0) {
                this.a.a = 0;
            } else {
                BannerView bannerView = this.a;
                bannerView.a = i % bannerView.s.mBannerList.size();
            }
            this.a.s.mSelected = i;
            for (int i2 = 0; i2 < this.a.s.mBannerList.size(); i2++) {
                if (this.a.m.get(i2) != null && ((BannerWrapFrameView) this.a.m.get(i2)).getSimpleDraweeView() != null && (animatable = ((BannerWrapFrameView) this.a.m.get(i2)).getSimpleDraweeView().getController().getAnimatable()) != null) {
                    if (i2 == this.a.a) {
                        animatable.start();
                    } else {
                        animatable.stop();
                    }
                }
            }
            BannerView bannerView2 = this.a;
            bannerView2.setIndicatorCurrentItem(bannerView2.s.mSelected);
            this.a.y(i);
            if (i < this.a.s.mBannerList.size() && i >= 0) {
                BannerView bannerView3 = this.a;
                bannerView3.q(bannerView3.s.mBannerList.get(this.a.a));
            }
            this.a.getLogger().a(this.a.a);
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.i == null) {
                return;
            }
            this.b.i.a(this.a.getLiveBannerEntity());
        }
    }

    /* loaded from: classes2.dex */
    public class d extends BaseControllerListener<ImageInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ BannerView b;

        public d(BannerView bannerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bannerView;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, imageInfo, animatable) == null) {
                super.onFinalImageSet(str, (String) imageInfo, animatable);
                if (this.a == 0) {
                    this.b.getLogger().a(0);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends BaseControllerListener<ImageInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ BannerView b;

        public e(BannerView bannerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bannerView;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, imageInfo, animatable) == null) {
                super.onFinalImageSet(str, (String) imageInfo, animatable);
                if (this.a == 0) {
                    this.b.getLogger().a(0);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BannerEntity a;
        public final /* synthetic */ BannerView b;

        public g(BannerView bannerView, BannerEntity bannerEntity) {
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.s == this.a && this.b.s != null) {
                this.b.s.mSelected = this.b.j.getCurrentItem() + 1;
                this.b.j.setCurrentItem(this.b.s.mSelected, true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface h {
        void a(LiveBannerEntity liveBannerEntity);
    }

    @TargetApi(21)
    /* loaded from: classes2.dex */
    public static class i extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        public i(float f) {
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
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        public j(View view2) {
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
                this.a.setOutlineProvider(new i(f));
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
        this.g = 0.266f;
        this.i = null;
        this.m = new ArrayList<>();
        this.r = new f(this);
        this.s = null;
        this.t = new Handler();
        n(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicatorCurrentItem(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65550, this, i2) == null) || this.k.getChildCount() <= 0) {
            return;
        }
        int childCount = i2 % this.k.getChildCount();
        int i3 = 0;
        while (i3 < this.k.getChildCount()) {
            View childAt = this.k.getChildAt(i3);
            childAt.setSelected(i3 == childCount);
            if (i3 == childCount) {
                childAt.getLayoutParams().width = this.o;
                childAt.getLayoutParams().height = this.p;
            } else {
                childAt.getLayoutParams().width = this.p;
                childAt.getLayoutParams().height = this.p;
            }
            i3++;
        }
        this.k.requestLayout();
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
                        if (Math.abs(y - this.v) > Math.abs(x - this.u)) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        } else {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                x();
                getParent().requestDisallowInterceptTouchEvent(false);
            } else {
                this.u = x;
                this.v = y;
                getParent().requestDisallowInterceptTouchEvent(true);
                v();
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public f getLogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.r : (f) invokeV.objValue;
    }

    public final BannerWrapFrameView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BannerWrapFrameView bannerWrapFrameView = new BannerWrapFrameView(getContext());
            bannerWrapFrameView.setIsImmersion(this.c);
            bannerWrapFrameView.setOnClickListener(new c(this, bannerWrapFrameView));
            return bannerWrapFrameView;
        }
        return (BannerWrapFrameView) invokeV.objValue;
    }

    public final View m(int i2, int i3) {
        InterceptResult invokeII;
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            View view2 = new View(getContext());
            view2.setSelected(i2 == i3);
            view2.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d3d);
            if (i2 == i3) {
                layoutParams = new LinearLayout.LayoutParams(this.o, this.p);
            } else {
                int i4 = this.p;
                layoutParams = new LinearLayout.LayoutParams(i4, i4);
            }
            if (i2 > 0) {
                layoutParams.leftMargin = this.q;
            }
            view2.setLayoutParams(layoutParams);
            return view2;
        }
        return (View) invokeII.objValue;
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0515, this);
            this.o = ba0.a(context, 8.0f);
            this.p = ba0.a(context, 6.0f);
            this.q = ba0.a(getContext(), 4.0f);
            this.j = (ViewPager) findViewById(R.id.obfuscated_res_0x7f09030a);
            this.k = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090301);
            this.l = (ImageView) findViewById(R.id.obfuscated_res_0x7f090302);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f0900bb);
            this.j.setAdapter(new a(this));
            this.j.setOnPageChangeListener(new b(this));
        }
    }

    public boolean o(List<LiveBannerEntity> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (rb0.c(list)) {
                return false;
            }
            if (!rb0.c(this.f) && rb0.a(list) == rb0.a(this.f)) {
                for (LiveBannerEntity liveBannerEntity : list) {
                    boolean z = false;
                    for (LiveBannerEntity liveBannerEntity2 : this.f) {
                        if (liveBannerEntity2 != null && !xb0.a(liveBannerEntity2.pic) && liveBannerEntity != null && !xb0.a(liveBannerEntity.pic) && liveBannerEntity2.pic.equals(liveBannerEntity.pic) && liveBannerEntity2.liveStatus == liveBannerEntity.liveStatus) {
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

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onAttachedToWindow();
            w();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            v();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            int size = View.MeasureSpec.getSize(i2);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, View.MeasureSpec.getMode(i2)), View.MeasureSpec.makeMeasureSpec((int) (size * this.g), 1073741824));
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, view2, i2) == null) {
            super.onVisibilityChanged(view2, i2);
            if (i2 == 0) {
                w();
            } else {
                v();
            }
        }
    }

    public final void p(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            try {
                if (this.h) {
                    RoundingParams fromCornersRadius = RoundingParams.fromCornersRadius(ba0.a(getContext(), this.b));
                    fromCornersRadius.setOverlayColor(-1);
                    int j2 = ic0.e().j(this.c);
                    GenericDraweeHierarchy build = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(0).setRoundingParams(fromCornersRadius).setFailureImage(j2).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_XY).setPlaceholderImage(j2).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_XY).build();
                    AbstractDraweeController build2 = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setControllerListener(new d(this, i2)).setUri(this.s.mBannerList.get(i2).pic).build();
                    if (this.m.get(i3).getSimpleDraweeView() == null || this.m.get(i3).getSimpleDraweeView().getController() == null || (this.m.get(i3).getSimpleDraweeView().getController() != null && !this.m.get(i3).getSimpleDraweeView().getController().isSameImageRequest(build2))) {
                        this.m.get(i3).getSimpleDraweeView().setHierarchy(build);
                        this.m.get(i3).getSimpleDraweeView().setController(build2);
                    }
                    if (rb0.c(this.m) || i3 < 0 || i3 >= this.m.size() || rb0.c(this.s.mBannerList) || i2 < 0 || i2 >= this.s.mBannerList.size()) {
                        return;
                    }
                    this.m.get(i3).setData(this.s.mBannerList.get(i2));
                    return;
                }
                int j3 = ic0.e().j(this.c);
                GenericDraweeHierarchy build3 = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(0).setFailureImage(j3).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_XY).setPlaceholderImage(j3).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_XY).build();
                AbstractDraweeController build4 = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setControllerListener(new e(this, i2)).setUri(this.s.mBannerList.get(i2).pic).build();
                if (this.m.get(i3).getSimpleDraweeView() == null || this.m.get(i3).getSimpleDraweeView().getController() == null || (this.m.get(i3).getSimpleDraweeView().getController() != null && !this.m.get(i3).getSimpleDraweeView().getController().isSameImageRequest(build4))) {
                    this.m.get(i3).getSimpleDraweeView().setHierarchy(build3);
                    this.m.get(i3).getSimpleDraweeView().setController(build4);
                }
                if (rb0.c(this.m) || i3 < 0 || i3 >= this.m.size() || rb0.c(this.s.mBannerList) || i2 < 0 || i2 >= this.s.mBannerList.size()) {
                    return;
                }
                this.m.get(i3).setData(this.s.mBannerList.get(i2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void q(LiveBannerEntity liveBannerEntity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, liveBannerEntity) == null) && liveBannerEntity != null && liveBannerEntity.needLogShow) {
            LiveHostInfo liveHostInfo = liveBannerEntity.hostInfo;
            m90.f(getContext(), this.d, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, liveHostInfo == null ? "" : liveHostInfo.uk, this.c ? "chenjinshi" : "zhibopindao", liveBannerEntity.materialId, liveBannerEntity.statInfo);
            liveBannerEntity.needLogShow = false;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || rb0.c(this.m)) {
            return;
        }
        Iterator<BannerWrapFrameView> it = this.m.iterator();
        while (it.hasNext()) {
            it.next().b(str);
        }
        LiveBannerStatusAnimView liveBannerStatusAnimView = this.e;
        if (liveBannerStatusAnimView != null) {
            liveBannerStatusAnimView.f(str);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public void setAspectRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f2) == null) {
            this.g = f2;
        }
    }

    public void setBannerEntity(BannerEntity bannerEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bannerEntity) == null) {
            Iterator<LiveBannerEntity> it = bannerEntity.mBannerList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                it.next();
                if (i2 >= 10) {
                    it.remove();
                }
                i2++;
            }
            this.s = bannerEntity;
            this.f = (bannerEntity == null || rb0.c(bannerEntity.mBannerList)) ? null : this.s.mBannerList;
            w();
            if (bannerEntity == null || rb0.c(bannerEntity.mBannerList)) {
                return;
            }
            y(0);
            q(bannerEntity.mBannerList.get(0));
        }
    }

    public void setBannerMargin(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048592, this, i2, i3, i4, i5) == null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(i2, i3, i4, i5);
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
            this.q = i2;
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

    public void setIsImmersion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.c = z;
        }
    }

    public void setLargeIndicatorItemSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.o = i2;
        }
    }

    public void setOnBannerClickListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, hVar) == null) {
            this.i = hVar;
        }
    }

    public void setPageMargin(int i2) {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || (viewPager = this.j) == null) {
            return;
        }
        viewPager.setPageMargin(ba0.a(getContext(), i2));
    }

    public void setShowRoundPicture(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.h = z;
            if (z) {
                if (i2 >= 0) {
                    this.b = i2;
                } else {
                    this.b = 0;
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    new j(this).a(ba0.a(getContext(), this.b));
                    this.b = 0;
                }
                this.l.setImageResource(R.drawable.obfuscated_res_0x7f080d2b);
            }
        }
    }

    public void setSmallIndicatorItemSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.p = i2;
        }
    }

    public void setSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.d = str;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            v();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            getLogger().a(this.a);
            x();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.t.removeCallbacksAndMessages(null);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || this.s == null) {
            return;
        }
        this.k.removeAllViews();
        v();
        if (this.s.mBannerList.size() == 0) {
            return;
        }
        if (this.s.mBannerList.size() == 1) {
            this.k.setVisibility(8);
            while (this.m.size() < 1) {
                this.m.add(l());
            }
            p(0, 0);
        } else if (this.s.mBannerList.size() == 2) {
            this.k.setVisibility(0);
            LinearLayout linearLayout = this.k;
            BannerEntity bannerEntity = this.s;
            linearLayout.addView(m(0, bannerEntity.mSelected % bannerEntity.mBannerList.size()));
            LinearLayout linearLayout2 = this.k;
            BannerEntity bannerEntity2 = this.s;
            linearLayout2.addView(m(1, bannerEntity2.mSelected % bannerEntity2.mBannerList.size()));
            while (this.m.size() < 4) {
                this.m.add(l());
            }
            p(0, 0);
            p(1, 1);
            p(0, 2);
            p(1, 3);
            x();
        } else {
            this.k.setVisibility(0);
            for (int i2 = 0; i2 < this.s.mBannerList.size(); i2++) {
                BannerEntity bannerEntity3 = this.s;
                this.k.addView(m(i2, bannerEntity3.mSelected % bannerEntity3.mBannerList.size()));
                if (i2 >= this.m.size()) {
                    this.m.add(l());
                }
                p(i2, i2);
            }
            x();
        }
        this.j.getAdapter().notifyDataSetChanged();
        this.j.setCurrentItem(this.s.mSelected, false);
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.t.postDelayed(new g(this, this.s), this.s.mBroadcastInterval);
        }
    }

    public final void y(int i2) {
        ArrayList<BannerWrapFrameView> arrayList;
        BannerEntity bannerEntity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048608, this, i2) == null) || (arrayList = this.m) == null || rb0.c(arrayList) || (bannerEntity = this.s) == null || rb0.c(bannerEntity.mBannerList)) {
            return;
        }
        int size = i2 % this.m.size();
        int size2 = i2 % this.s.mBannerList.size();
        if (size >= 0 && size2 >= 0) {
            if (size2 < this.s.mBannerList.size() && size < this.m.size()) {
                if (this.e == null) {
                    LiveBannerStatusAnimView liveBannerStatusAnimView = new LiveBannerStatusAnimView(getContext());
                    this.e = liveBannerStatusAnimView;
                    liveBannerStatusAnimView.setIsImmersion(this.c);
                }
                if (this.e.getParent() != null) {
                    ((ViewGroup) this.e.getParent()).removeView(this.e);
                }
                this.e.setData(this.s.mBannerList.get(size2));
                if (this.m.get(size).getStatusViewContainer() != null) {
                    this.m.get(size).getStatusViewContainer().addView(this.e);
                    return;
                }
                return;
            }
            LiveBannerStatusAnimView liveBannerStatusAnimView2 = this.e;
            if (liveBannerStatusAnimView2 == null || liveBannerStatusAnimView2.getParent() == null) {
                return;
            }
            ((ViewGroup) this.e.getParent()).removeView(this.e);
            return;
        }
        LiveBannerStatusAnimView liveBannerStatusAnimView3 = this.e;
        if (liveBannerStatusAnimView3 == null || liveBannerStatusAnimView3.getParent() == null) {
            return;
        }
        ((ViewGroup) this.e.getParent()).removeView(this.e);
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
        this.g = 0.266f;
        this.i = null;
        this.m = new ArrayList<>();
        this.r = new f(this);
        this.s = null;
        this.t = new Handler();
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
        this.g = 0.266f;
        this.i = null;
        this.m = new ArrayList<>();
        this.r = new f(this);
        this.s = null;
        this.t = new Handler();
        n(context);
    }
}
