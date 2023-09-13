package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.HeadlinesItemCountDownView;
import com.baidu.tieba.z35;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class HeadlinesItemInfoView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TbImageView b;
    public TextView c;
    public HeadlinesItemCountDownView d;
    public TextView e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeadlinesItemInfoView(@NonNull Context context) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeadlinesItemInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
    public HeadlinesItemInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
            this.a = LayoutInflater.from(getContext()).inflate(R.layout.headlines_item_info_view_layout, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.headlines_item_image);
            this.b = tbImageView;
            tbImageView.setRadiusById(R.string.J_X04);
            this.b.addCornerFlags(15);
            this.c = (TextView) findViewById(R.id.headlines_first_info);
            this.d = (HeadlinesItemCountDownView) findViewById(R.id.headlines_count_down_view);
            this.e = (TextView) findViewById(R.id.headlines_order_button);
            c(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void b(z35 z35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z35Var) != null) || z35Var == null) {
            return;
        }
        this.b.startLoad(z35Var.f(), 10, false);
        this.c.setText(z35Var.l());
        this.e.setText(z35Var.b());
        this.d.setData(JavaTypesHelper.toLong(z35Var.d(), 0L), z35Var.c(), z35Var.k());
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            EMManager.from(this).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.c).setTextColor(R.color.CAM_X0107);
            this.d.i(i);
            EMManager.from(this.e).setTextColor(R.color.CAM_X0304).setBorderWidth(R.dimen.L_X01).setBorderColor(R.color.CAM_X0304).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0612);
        }
    }

    public void setOnBannerClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.a.setOnClickListener(onClickListener);
        }
    }

    public void setOnButtonClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.e.setOnClickListener(onClickListener);
        }
    }
}
