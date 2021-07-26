package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.f0.t.b;
/* loaded from: classes3.dex */
public class FollowUserButton extends TBSpecificationBtn implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a s;
    public int t;
    public boolean u;

    /* loaded from: classes3.dex */
    public interface a {
        void onClick(View view);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FollowUserButton(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.p0.s.f0.t.b
    public void a(View view) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.s) == null) {
            return;
        }
        aVar.onClick(view);
    }

    @Override // d.a.p0.s.f0.t.b
    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            setOnClickListener(onClickListener);
        }
    }

    @Override // d.a.p0.s.f0.t.b
    public void c(boolean z, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            e(z, i2);
        }
    }

    @Override // d.a.p0.s.f0.t.b
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
        }
    }

    @Override // d.a.p0.s.f0.t.b
    public void e(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (z) {
                s(true);
            } else {
                s(false);
            }
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            k();
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                setVisibility(0);
                setClickable(this.u);
                d.a.p0.s.f0.n.b bVar = new d.a.p0.s.f0.n.b();
                bVar.r(R.color.CAM_X0109);
                bVar.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                setConfig(bVar);
                setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            } else {
                setVisibility(0);
                d.a.p0.s.f0.n.b bVar2 = new d.a.p0.s.f0.n.b();
                bVar2.g(UtilHelper.getDimenPixelSize(R.dimen.tbds30));
                bVar2.i(this.t, 0, TBSpecificationButtonConfig.IconType.SVG);
                bVar2.q(R.color.CAM_X0304);
                setConfig(bVar2);
                setClickable(true);
                setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            }
            r(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setClickableUnLike(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.u = z;
        }
    }

    public void setOnClickEvent(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.s = aVar;
        }
    }

    public void setSvgIconResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.t = i2;
            k();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FollowUserButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowUserButton(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.t = 0;
        this.u = true;
        d.a.p0.s.f0.n.b bVar = new d.a.p0.s.f0.n.b();
        bVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds30));
        bVar.i(this.t, 0, TBSpecificationButtonConfig.IconType.SVG);
        bVar.q(R.color.CAM_X0304);
        setConfig(bVar);
        setText(TbadkCoreApplication.getInst().getString(R.string.attention));
    }
}
