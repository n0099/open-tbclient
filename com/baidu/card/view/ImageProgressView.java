package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.RadiusProgressView;
import com.baidu.tieba.R;
import com.baidu.tieba.gg;
import com.baidu.tieba.gz4;
import com.baidu.tieba.hz4;
import com.baidu.tieba.xj9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ImageProgressView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RadiusProgressView a;
    public LinearLayout b;
    public List<ImageProgressItemView> c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageProgressView(@NonNull Context context) {
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
    public ImageProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
    public ImageProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.c = new ArrayList();
        b();
    }

    public final ImageProgressItemView a(hz4 hz4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hz4Var)) == null) {
            ImageProgressItemView imageProgressItemView = new ImageProgressItemView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.weight = 1.0f;
            this.b.addView(imageProgressItemView, layoutParams);
            imageProgressItemView.b(hz4Var);
            return imageProgressItemView;
        }
        return (ImageProgressItemView) invokeL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.image_progress_view, (ViewGroup) this, true);
            this.a = (RadiusProgressView) findViewById(R.id.image_radius_progress_view);
            this.b = (LinearLayout) findViewById(R.id.image_progress_item_container);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(gz4 gz4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gz4Var) != null) || gz4Var == null) {
            return;
        }
        int count = ListUtils.getCount(gz4Var.j());
        if (count > 0) {
            int e = gg.e(gz4Var.m(), 0);
            this.a.setMax(e);
            this.a.setProgress(gg.e(gz4Var.g(), 0) - (e / (count * 2)));
        }
        this.c.clear();
        this.b.removeAllViews();
        if (!ListUtils.isEmpty(gz4Var.j())) {
            for (int i = 0; i < gz4Var.j().size(); i++) {
                this.c.add(a(gz4Var.j().get(i)));
            }
        }
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.a.setSolidColor(SkinManager.getColor(R.color.CAM_X0101));
            this.a.setProgressColor(xj9.a(SkinManager.getColor(R.color.CAM_X0305), 0.7f));
            this.a.setProgressColorRight(xj9.a(SkinManager.getColor(R.color.CAM_X0305), 0.7f));
            this.a.setProgressColorLeft(xj9.a(SkinManager.getColor(R.color.CAM_X0305), 0.4f));
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                this.c.get(i2).c(i);
            }
        }
    }
}
