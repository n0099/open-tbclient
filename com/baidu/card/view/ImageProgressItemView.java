package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.kw4;
import com.baidu.tieba.ou4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ImageProgressItemView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ou4 a;
    public TbImageView b;
    public RoundTbImageView c;
    public TbImageView d;
    public TextView e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageProgressItemView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void b(ou4 ou4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ou4Var) == null) {
            this.a = ou4Var;
            if (ou4Var == null) {
                return;
            }
            this.c.K(ou4Var.a(), 10, false);
            this.e.setText(String.format("%s人", ou4Var.b()));
            d();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageProgressItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageProgressItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d03cd, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090ed0);
            this.b = tbImageView;
            tbImageView.setImageResource(R.drawable.obfuscated_res_0x7f0808fd);
            RoundTbImageView roundTbImageView = (RoundTbImageView) findViewById(R.id.obfuscated_res_0x7f090ed2);
            this.c = roundTbImageView;
            roundTbImageView.setDrawBorder(true);
            this.c.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.L_X01));
            this.c.setBorderColor(SkinManager.getColor(R.color.black_alpha10));
            this.c.setBorderSurroundContent(true);
            TbImageView tbImageView2 = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090ed3);
            this.d = tbImageView2;
            tbImageView2.setImageResource(R.drawable.obfuscated_res_0x7f0808e8);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f090ed4);
            c(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            kw4.d(this.e).v(R.color.CAM_X0105);
        }
    }

    public final void d() {
        ou4 ou4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (ou4Var = this.a) == null) {
            return;
        }
        if (ou4Var.c()) {
            setAlpha(1.0f);
        } else {
            setAlpha(0.4f);
        }
        if (this.a.d()) {
            this.b.setVisibility(0);
            this.d.setVisibility(0);
            return;
        }
        this.b.setVisibility(4);
        this.d.setVisibility(4);
    }
}
