package com.baidu.fsg.base.activity;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f39401a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f39402b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f39403c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f39404d;

    public b(BeanActivity beanActivity, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {beanActivity, Integer.valueOf(i2), Integer.valueOf(i3), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39404d = beanActivity;
        this.f39401a = i2;
        this.f39402b = i3;
        this.f39403c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BeanActivity beanActivity = this.f39404d;
            if (beanActivity.mAct != null) {
                beanActivity.handleFailure(this.f39401a, this.f39402b, this.f39403c);
            }
        }
    }
}
