package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pya;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PublishProgressView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PublishProgressBar a;
    public TextView b;
    public TextView c;
    public PublishProgressData d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishProgressView(Context context) {
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
        a(context, null);
    }

    private void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i) == null) {
            this.b.setText(String.format(getResources().getString(R.string.publish_progress_prefix), Integer.valueOf(this.a.c(i))));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishProgressView(Context context, AttributeSet attributeSet) {
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
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, attributeSet) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.publish_progress_view, this);
            this.a = (PublishProgressBar) inflate.findViewById(R.id.obfuscated_res_0x7f091e63);
            this.b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091e6b);
            TextView textView = (TextView) inflate.findViewById(R.id.progress_close_btn);
            this.c = textView;
            textView.setOnClickListener(this);
            this.a.setOnClickListener(this);
            b();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishProgressView(Context context, AttributeSet attributeSet, int i) {
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
        a(context, attributeSet);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.b();
            EMManager.from(this.b).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X06).setTextStyle(R.string.F_X01);
            EMManager.from(this.c).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X01);
        }
    }

    public void c(@NonNull PublishProgressData publishProgressData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, publishProgressData) == null) {
            if (publishProgressData.equals(this.d)) {
                this.d.update(publishProgressData);
                d();
                return;
            }
            this.d = publishProgressData;
            d();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && view2.getId() == R.id.progress_close_btn) {
            PublishProgressData publishProgressData = this.d;
            if (publishProgressData != null) {
                publishProgressData.hideRunning();
                d();
            }
            pya.c();
        }
    }

    public final void d() {
        PublishProgressData publishProgressData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (publishProgressData = this.d) == null) {
            return;
        }
        if (publishProgressData.isRunning()) {
            setProgress(this.d.getProgress());
            setVisibility(0);
            return;
        }
        setVisibility(8);
        setProgress(0);
    }
}
