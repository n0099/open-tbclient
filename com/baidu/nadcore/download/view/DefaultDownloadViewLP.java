package com.baidu.nadcore.download.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ei0;
import com.repackage.ui0;
/* loaded from: classes2.dex */
public class DefaultDownloadViewLP extends FrameLayout implements ui0<DefaultDownloadViewLP> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BannerDownloadView a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultDownloadViewLP(@NonNull Context context) {
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

    @Override // com.repackage.ui0
    public void b(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) && (viewGroup instanceof RelativeLayout)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            viewGroup.addView(this, layoutParams);
            viewGroup.setVisibility(0);
            viewGroup.bringToFront();
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0592, this);
            setBackgroundResource(R.color.obfuscated_res_0x7f060871);
            this.a = (BannerDownloadView) findViewById(R.id.obfuscated_res_0x7f091321);
        }
    }

    public void d(boolean z) {
        View findViewById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (findViewById = findViewById(R.id.obfuscated_res_0x7f091490)) == null) {
            return;
        }
        findViewById.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ui0
    @NonNull
    public DefaultDownloadViewLP getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this : (DefaultDownloadViewLP) invokeV.objValue;
    }

    public void setProgress(float f) {
        BannerDownloadView bannerDownloadView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048581, this, f) == null) || (bannerDownloadView = this.a) == null) {
            return;
        }
        bannerDownloadView.setProgress(f);
    }

    public void setText(String str) {
        BannerDownloadView bannerDownloadView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (bannerDownloadView = this.a) == null) {
            return;
        }
        bannerDownloadView.setText(str);
    }

    @Override // com.repackage.ui0
    public void update(String str, @NonNull ei0 ei0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, ei0Var) == null) {
            if (ei0Var.c == AdDownloadStatus.DOWNLOADING) {
                str = getResources().getString(R.string.obfuscated_res_0x7f0f0b9a) + str;
                setProgress(ei0Var.i);
            } else {
                setProgress(0.0f);
            }
            setText(str);
            postInvalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultDownloadViewLP(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
    public DefaultDownloadViewLP(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        c(context);
    }
}
