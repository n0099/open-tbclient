package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class HeadWorldCupFlagLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int e;
    public static final int f;
    public static final int g;
    public static final int h;
    public static final int i;
    public static final int j;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public TbImageView b;
    public FrameLayout.LayoutParams c;
    public FrameLayout.LayoutParams d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1642608096, "Lcom/baidu/card/view/HeadWorldCupFlagLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1642608096, "Lcom/baidu/card/view/HeadWorldCupFlagLayout;");
                return;
            }
        }
        e = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        f = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        g = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds138);
        h = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds72);
        i = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds64);
        j = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds64);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = new TbImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g, h);
            this.c = layoutParams;
            layoutParams.gravity = 17;
            this.a.setLayoutParams(layoutParams);
            this.a.setDefaultBgResource(R.color.transparent);
            addView(this.a);
            this.b = new TbImageView(getContext());
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, j);
            this.d = layoutParams2;
            layoutParams2.gravity = 17;
            layoutParams2.topMargin = f;
            layoutParams2.leftMargin = e;
            this.b.setLayoutParams(layoutParams2);
            this.b.setRotation(20.0f);
            this.b.setDefaultBgResource(R.color.transparent);
            addView(this.b);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeadWorldCupFlagLayout(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void setScale(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d)}) == null) {
            FrameLayout.LayoutParams layoutParams = this.c;
            layoutParams.width = (int) (g * d);
            layoutParams.height = (int) (h * d);
            FrameLayout.LayoutParams layoutParams2 = this.d;
            int i2 = i;
            layoutParams2.width = (int) (i2 * d);
            layoutParams2.height = (int) (i2 * d);
            layoutParams2.leftMargin = (int) (e * d);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeadWorldCupFlagLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadWorldCupFlagLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        a();
    }

    public void b(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, metaData) == null) && metaData != null && metaData.getUserWorldCupData() != null) {
            String a = metaData.getUserWorldCupData().a();
            if (!TextUtils.isEmpty(a)) {
                setVisibility(0);
                String worldCupSponsorFlag = TbSingleton.getInstance().getWorldCupSponsorFlag();
                if (TextUtils.isEmpty(worldCupSponsorFlag)) {
                    WebPManager.setMaskDrawable(this.a, R.drawable.icon_mask_world_cup_sponsor, null);
                } else {
                    this.a.setDefaultResource(R.drawable.icon_mask_world_cup_sponsor);
                    this.a.N(worldCupSponsorFlag, 10, false);
                }
                this.b.N(a, 10, false);
                return;
            }
            setVisibility(8);
        }
    }
}
