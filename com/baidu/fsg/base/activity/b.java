package com.baidu.fsg.base.activity;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f38178a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f38179b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f38180c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f38181d;

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
        this.f38181d = beanActivity;
        this.f38178a = i2;
        this.f38179b = i3;
        this.f38180c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BeanActivity beanActivity = this.f38181d;
            if (beanActivity.mAct != null) {
                beanActivity.handleFailure(this.f38178a, this.f38179b, this.f38180c);
            }
        }
    }
}
