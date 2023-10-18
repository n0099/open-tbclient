package com.baidu.mobads.sdk.internal;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class dn extends CountDownTimer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ dl a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dn(dl dlVar, long j, long j2) {
        super(j, j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dlVar, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = dlVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.b.a("CountDownTimer finished");
            this.a.c();
        }
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            int i = (int) (j / 1000);
            if (i > 5) {
                i = 5;
            }
            textView = this.a.d;
            textView.setText(String.valueOf(i));
        }
    }
}
