package com.baidu.tbadk.core.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.DimenRes;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.HeadIconRefreshHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class HeadPendantView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float HEAD_PADDING_RATE = 0.13f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f38998e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f38999f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f39000g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f39001h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f39002i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f39003j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public boolean o;
    public boolean p;
    public boolean q;

    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f39004e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HeadPendantView f39005f;

        public a(HeadPendantView headPendantView, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headPendantView, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39005f = headPendantView;
            this.f39004e = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f39004e.setAlpha(valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadPendantView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f39003j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = n.f(TbadkApplication.getInst(), R.dimen.tbds36);
        this.p = true;
        this.q = false;
        this.f38998e = context;
        init();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ImageView imageView = new ImageView(this.f38998e);
            this.f39001h = imageView;
            imageView.setImageDrawable(null);
            int i2 = this.n;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
            layoutParams.addRule(12, -1);
            layoutParams.addRule(11, -1);
            this.f39001h.setLayoutParams(layoutParams);
            this.f39001h.setVisibility(8);
            addView(this.f39001h);
        }
    }

    public void adjustBjhPbFirstFloorHeadView(@DimenRes int i2, @DimenRes int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) && (getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = n.f(getContext(), i2);
            ((FrameLayout.LayoutParams) getLayoutParams()).width = n.f(getContext(), i3);
            ((FrameLayout.LayoutParams) getLayoutParams()).height = n.f(getContext(), i3);
            if (this.l) {
                ((FrameLayout.LayoutParams) getLayoutParams()).gravity = 51;
            } else {
                ((FrameLayout.LayoutParams) getLayoutParams()).gravity = 16;
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HeadImageView headImageView = new HeadImageView(this.f38998e);
            this.f39002i = headImageView;
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f39002i.setPlaceHolder(1);
            this.f39002i.setDefaultResource(R.color.CAM_X0205);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(15, -1);
            this.f39002i.setLayoutParams(layoutParams);
            addView(this.f39002i);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbImageView tbImageView = new TbImageView(this.f38998e);
            this.f39000g = tbImageView;
            tbImageView.setPageId(this.f38999f);
            this.f39000g.setDefaultBgResource(0);
            this.f39000g.setDefaultResource(0);
            this.f39000g.setImageDrawable(null);
            this.f39000g.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f39000g.setVisibility(8);
            addView(this.f39000g);
        }
    }

    public final void d(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            view.setAlpha(0.0f);
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
            ofInt.setDuration(50L);
            ofInt.addUpdateListener(new a(this, view));
            ofInt.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.dispatchDraw(canvas);
        }
    }

    public final void e() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.n <= 0 || (imageView = this.f39001h) == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        int i2 = this.n;
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.f39001h.setLayoutParams(layoutParams);
    }

    public final void f(MetaData metaData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, metaData) == null) || metaData == null) {
            return;
        }
        if (this.o) {
            this.f39001h.setVisibility(8);
            return;
        }
        this.f39002i.setShowV(false);
        if (UtilHelper.isFllowByPriorty(metaData)) {
            if (metaData.getAuthType() == 1) {
                z = UtilHelper.showOfficialIcon(this.f39001h, metaData);
            } else if (metaData.getAuthType() == 1) {
                z = UtilHelper.showOriginalIcon(this.f39001h, metaData);
            } else if (metaData.getAuthType() == 3) {
                z = UtilHelper.showNewGodIcon(this.f39001h, metaData);
            } else if (metaData.getAuthType() == 4 && !this.m) {
                z = UtilHelper.showHeadBazhuIcon(this.f39001h, metaData, this.p);
            }
            if (!z || UtilHelper.showOfficialIcon(this.f39001h, metaData) || UtilHelper.showOriginalIcon(this.f39001h, metaData) || UtilHelper.showNewGodIcon(this.f39001h, metaData)) {
                return;
            }
            showBigVIcon(false);
            if (this.m || UtilHelper.showHeadBazhuIcon(this.f39001h, metaData, this.p)) {
            }
        }
        z = false;
        if (!z) {
            return;
        }
        showBigVIcon(false);
        if (this.m) {
        }
    }

    public ImageView getBigVIconView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f39001h : (ImageView) invokeV.objValue;
    }

    public HeadImageView getHeadView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f39002i : (HeadImageView) invokeV.objValue;
    }

    public TbImageView getPendantView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f39000g : (TbImageView) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.n = n.f(getContext(), R.dimen.tbds42);
            b();
            c();
            a();
        }
    }

    public boolean isPendantShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.k : invokeV.booleanValue;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
            if (this.f39003j) {
                int size = View.MeasureSpec.getSize(i2);
                int i4 = (int) (size * 0.13f);
                int size2 = (int) (View.MeasureSpec.getSize(i3) * 0.13f);
                ((RelativeLayout.LayoutParams) this.f39002i.getLayoutParams()).setMargins(i4, size2, i4, size2);
                ImageView imageView = this.f39001h;
                if (imageView != null) {
                    ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).setMargins(i4, size2, i4, size2);
                }
            }
            if (this.l) {
                ((RelativeLayout.LayoutParams) this.f39002i.getLayoutParams()).setMargins(0, 0, 0, 0);
                ImageView imageView2 = this.f39001h;
                if (imageView2 != null) {
                    ((RelativeLayout.LayoutParams) imageView2.getLayoutParams()).setMargins(0, 0, 0, 0);
                }
            }
            super.onMeasure(i2, i3);
        }
    }

    public void setAuthIconType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
        }
    }

    public void setAutoChangeStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f39000g.setAutoChangeStyle(z);
            this.f39002i.setAutoChangeStyle(z);
        }
    }

    public void setBigVDimenSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            if (i2 > 0) {
                this.n = n.f(getContext(), i2);
            }
            e();
        }
    }

    public void setBigVIconResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
        }
    }

    public void setBjhPbFirstFloor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.l = z;
        }
    }

    public void setDefalutResid(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f39002i.setDefaultResource(i2);
        }
    }

    public void setHasPendantStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f39003j = true;
        }
    }

    public void setIsHomePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.m = z;
        }
    }

    public void setIsNeedAlpAnima(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.q = z;
        }
    }

    public void setIsclearmode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.o = z;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bdUniqueId) == null) {
            this.f38999f = bdUniqueId;
            HeadImageView headImageView = this.f39002i;
            if (headImageView != null) {
                headImageView.setPageId(bdUniqueId);
            }
            TbImageView tbImageView = this.f39000g;
            if (tbImageView != null) {
                tbImageView.setPageId(bdUniqueId);
            }
        }
    }

    public void setShowSimpleIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.p = z;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.f39002i.setUrl(str);
        }
    }

    public void showBigVIcon(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || (imageView = this.f39001h) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public void showHeadPendantAndBigV(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, metaData) == null) || metaData == null) {
            return;
        }
        if (metaData.getPendantData() != null) {
            startLoadPendantUrl(metaData.getPendantData().getImgUrl());
        } else {
            startLoadPendantUrl(null);
        }
        f(metaData);
    }

    public void startLoad(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f39002i.startLoad(str, i2, 0, 0, z);
        }
    }

    public void startLoadAndAutoAdjustPendantStyle(MetaData metaData, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048608, this, metaData, i2, i3) == null) {
            if (metaData != null && metaData.getPendantData() != null && !TextUtils.isEmpty(metaData.getPendantData().getImgUrl())) {
                setHasPendantStyle(true);
                setBigVDimenSize(i3);
            } else {
                setHasPendantStyle(false);
                setBigVDimenSize(i2);
            }
            startLoadWithPendantAndBigV(metaData);
        }
    }

    public void startLoadOnlyHeadUrl(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(str);
        this.f39002i.setImageBitmap(null);
        this.f39002i.setUrl(headPortraitFilter);
        if (headPortraitFilter.startsWith("http")) {
            startLoad(headPortraitFilter, 10, false);
        } else {
            startLoad(headPortraitFilter, 25, false);
        }
    }

    public void startLoadPendantUrl(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, str) == null) || this.f39000g == null) {
            return;
        }
        if (this.f39003j && !StringUtils.isNull(str)) {
            this.k = true;
            this.f39000g.setVisibility(0);
            this.f39000g.setImageDrawable(null);
            this.f39000g.startLoad(str, 10, false);
            if (this.q) {
                d(this.f39000g);
                return;
            }
            return;
        }
        this.f39000g.setVisibility(8);
        this.k = false;
    }

    public void startLoadWithPendantAndBigV(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, metaData) == null) || metaData == null || TextUtils.isEmpty(metaData.getPortrait())) {
            return;
        }
        String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(metaData.getAvater());
        setUrl(headPortraitFilter);
        if (headPortraitFilter.startsWith("http")) {
            startLoad(headPortraitFilter, 10, false);
        } else {
            startLoad(headPortraitFilter, 25, false);
        }
        showHeadPendantAndBigV(metaData);
    }

    public void setHasPendantStyle(boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (this.f39003j && !z && (headImageView2 = this.f39002i) != null) {
                ((RelativeLayout.LayoutParams) headImageView2.getLayoutParams()).setMargins(0, 0, 0, 0);
                ImageView imageView = this.f39001h;
                if (imageView != null) {
                    ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).setMargins(0, 0, 0, 0);
                }
                TbImageView tbImageView = this.f39000g;
                if (tbImageView != null) {
                    tbImageView.setVisibility(8);
                }
                this.k = false;
                invalidate();
            } else if (!this.f39003j && z && (headImageView = this.f39002i) != null) {
                int width = (int) (this.f39002i.getWidth() * 0.13f);
                int height = (int) (this.f39002i.getHeight() * 0.13f);
                ((RelativeLayout.LayoutParams) headImageView.getLayoutParams()).setMargins(width, height, width, height);
                ImageView imageView2 = this.f39001h;
                if (imageView2 != null) {
                    ((RelativeLayout.LayoutParams) imageView2.getLayoutParams()).setMargins(width, height, width, height);
                }
                invalidate();
            }
            this.f39003j = z;
        }
    }

    public void showHeadPendantAndBigV(MetaData metaData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048606, this, metaData, i2) == null) || metaData == null) {
            return;
        }
        showHeadPendantAndBigV(metaData);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadPendantView(Context context, AttributeSet attributeSet) {
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
        this.f39003j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = n.f(TbadkApplication.getInst(), R.dimen.tbds36);
        this.p = true;
        this.q = false;
        this.f38998e = context;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadPendantView(Context context) {
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
        this.f39003j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = n.f(TbadkApplication.getInst(), R.dimen.tbds36);
        this.p = true;
        this.q = false;
        this.f38998e = context;
        init();
    }
}
