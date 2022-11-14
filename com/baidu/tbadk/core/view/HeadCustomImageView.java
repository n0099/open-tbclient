package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.qn8;
import com.baidu.tieba.sz4;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class HeadCustomImageView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public TbImageView b;
    public RoundRelativeLayout c;
    public RoundRelativeLayout d;
    public int e;
    public ImageView f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public RelativeLayout.LayoutParams k;
    public RelativeLayout.LayoutParams l;
    public int m;
    public Context n;
    public int o;
    public int p;
    public String q;
    public String r;
    public String s;
    public int t;
    public MetaData u;
    public boolean v;

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, tbPageContext) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadCustomImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = true;
        this.h = yi.g(TbadkApplication.getInst(), R.dimen.tbds36);
        this.m = yi.g(TbadkApplication.getInst(), R.dimen.tbds118);
        this.v = true;
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadCustomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = true;
        this.h = yi.g(TbadkApplication.getInst(), R.dimen.tbds36);
        this.m = yi.g(TbadkApplication.getInst(), R.dimen.tbds118);
        this.v = true;
        d(context);
    }

    public void setSmallWidthAndHeight(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048600, this, i, i2) == null) {
            this.i = i;
            this.j = i2;
            this.m = (int) (i * 1.2f);
            this.k.addRule(14);
            this.k.addRule(12);
            RelativeLayout.LayoutParams layoutParams = this.k;
            int i3 = this.m;
            layoutParams.width = i3;
            layoutParams.height = i3;
            this.l.addRule(12);
            this.l.addRule(14);
            RelativeLayout.LayoutParams layoutParams2 = this.l;
            int i4 = this.i;
            layoutParams2.width = i4;
            layoutParams2.height = i4;
            this.d.setLayoutParams(layoutParams2);
            this.b.setLayoutParams(this.k);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadCustomImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.g = true;
        this.h = yi.g(TbadkApplication.getInst(), R.dimen.tbds36);
        this.m = yi.g(TbadkApplication.getInst(), R.dimen.tbds118);
        this.v = true;
        d(context);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ImageView imageView = new ImageView(this.n);
            this.f = imageView;
            imageView.setImageDrawable(null);
            int i = this.h;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
            layoutParams.addRule(12, -1);
            layoutParams.addRule(11, -1);
            this.f.setLayoutParams(layoutParams);
            this.f.setVisibility(8);
            addView(this.f);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.c != null && TbSingleton.getInstance().getLightEmotionInfo() != null && TbSingleton.getInstance().getLightEmotionInfo().size() != 0) {
                Rect rect = new Rect();
                this.c.getGlobalVisibleRect(rect);
                sz4.b(this.n, rect.centerX(), rect.bottom, this.u, 1, this.t, this.v);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setHeadViewNormalSize() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (tbImageView = this.b) != null && tbImageView.getVisibility() == 0) {
            TbImageView tbImageView2 = this.b;
            tbImageView2.setPivotY(tbImageView2.getHeight());
            TbImageView tbImageView3 = this.b;
            tbImageView3.setPivotX(tbImageView3.getWidth() / 2.0f);
            ViewPropertyAnimator animate = this.b.animate();
            animate.scaleX(1.0f);
            animate.scaleY(1.0f);
            animate.setDuration(0L);
            animate.start();
        }
    }

    public final void c(long j) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) && (tbImageView = this.b) != null && tbImageView.getVisibility() == 0) {
            TbImageView tbImageView2 = this.b;
            tbImageView2.setPivotY(tbImageView2.getHeight());
            TbImageView tbImageView3 = this.b;
            tbImageView3.setPivotX(tbImageView3.getWidth() / 2.0f);
            ViewPropertyAnimator animate = this.b.animate();
            animate.scaleX(1.2f);
            animate.scaleY(1.2f);
            animate.setDuration(j);
            animate.start();
        }
    }

    public void setHeadImageBackgroundColorResource(String str) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && (tbImageView = this.a) != null && tbImageView.getVisibility() == 0 && this.n != null && this.d != null) {
            this.a.setDefaultBgResource(R.color.transparent);
            this.a.setBackgroundColor(qn8.a(qn8.f(str), 0.3f));
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.n = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d038d, (ViewGroup) this, true);
            setClipChildren(false);
            setClipToPadding(false);
            this.c = (RoundRelativeLayout) findViewById(R.id.obfuscated_res_0x7f090d5e);
            this.b = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090d5d);
            this.a = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090d5b);
            this.d = (RoundRelativeLayout) findViewById(R.id.obfuscated_res_0x7f090d5c);
            int g = yi.g(context, R.dimen.tbds90);
            this.e = g;
            this.d.setRoundLayoutRadius(new float[]{g, g, g, g, g, g, g, g});
            RoundRelativeLayout roundRelativeLayout = this.c;
            int i = this.e;
            roundRelativeLayout.setRoundLayoutRadius(new float[]{0.0f, 0.0f, 0.0f, 0.0f, i, i, i, i});
            this.k = new RelativeLayout.LayoutParams(-2, -2);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            this.l = layoutParams;
            layoutParams.addRule(14);
            setLayerType(1, null);
            a();
        }
    }

    public void e(MetaData metaData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, metaData) != null) || metaData == null) {
            return;
        }
        this.u = metaData;
        if (UtilHelper.isFllowByPriorty(metaData)) {
            if (metaData.getAuthType() == 1) {
                z = UtilHelper.showOfficialIcon(this.f, metaData);
            } else if (metaData.getAuthType() == 1) {
                z = UtilHelper.showOriginalIcon(this.f, metaData);
            } else if (metaData.getAuthType() == 3) {
                z = UtilHelper.showNewGodIcon(this.f, metaData);
            } else if (metaData.getAuthType() == 4) {
                z = UtilHelper.showHeadBazhuIcon(this.f, metaData, this.g);
            }
            if (!z || UtilHelper.showOfficialIcon(this.f, metaData) || UtilHelper.showOriginalIcon(this.f, metaData) || UtilHelper.showNewGodIcon(this.f, metaData)) {
                return;
            }
            f(false);
        }
        z = false;
        if (!z) {
            return;
        }
        f(false);
    }

    public void f(boolean z) {
        ImageView imageView;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048581, this, z) != null) || (imageView = this.f) == null) {
            return;
        }
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        imageView.setVisibility(i);
    }

    public void setBubbleName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.q = str;
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.t = i;
        }
    }

    public void setHeadImageBackgroundColor(int i) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i) == null) && (tbImageView = this.a) != null && tbImageView.getVisibility() == 0 && this.n != null && this.d != null) {
            this.a.setDefaultBgResource(i);
        }
    }

    public void setHeadImageBackgroundResource(String str) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, str) == null) && (tbImageView = this.a) != null && tbImageView.getVisibility() == 0) {
            this.a.K(str, 45, false);
        }
    }

    public void setHeadImageViewResource(String str) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, str) == null) && (tbImageView = this.b) != null && tbImageView.getVisibility() == 0 && str != null) {
            this.b.G(str, 10, 0, 0, true);
            invalidate();
        }
    }

    public void setLocate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.o = i;
        }
    }

    public void setShowHomeIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.v = z;
        }
    }

    public void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.r = str;
        }
    }

    public void setUserInfo(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, metaData) == null) {
            this.u = metaData;
        }
    }

    public void setVirtualHeadUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.s = str;
        }
    }

    public void setWithBubble(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.p = i;
        }
    }

    public void g(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            if (z) {
                c(j);
            } else {
                c(0L);
            }
        }
    }

    public int getBubble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public String getBubbleName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.q;
        }
        return (String) invokeV.objValue;
    }

    public int getLocate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.o;
        }
        return invokeV.intValue;
    }

    public String getTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.r;
        }
        return (String) invokeV.objValue;
    }

    public MetaData getUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.u;
        }
        return (MetaData) invokeV.objValue;
    }

    public String getVirtualHeadUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.s;
        }
        return (String) invokeV.objValue;
    }

    public void setBigWidthAndHeight(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) {
            this.i = i;
            this.j = i2;
            this.m = (int) (i * 1.2f);
            this.k.addRule(14);
            this.k.addRule(12);
            RelativeLayout.LayoutParams layoutParams = this.k;
            int i3 = this.m;
            layoutParams.width = i3;
            layoutParams.height = i3;
            this.l.addRule(12);
            this.l.addRule(14);
            RelativeLayout.LayoutParams layoutParams2 = this.l;
            int i4 = this.i;
            layoutParams2.width = i4;
            layoutParams2.height = i4;
            this.d.setLayoutParams(layoutParams2);
            this.b.setLayoutParams(this.k);
            this.b.setPivotY(this.j);
            this.b.setPivotX(this.i / 2.0f);
            ViewPropertyAnimator animate = this.b.animate();
            animate.scaleX(1.2f);
            animate.scaleY(1.2f);
            animate.setDuration(0L);
            animate.start();
        }
    }
}
