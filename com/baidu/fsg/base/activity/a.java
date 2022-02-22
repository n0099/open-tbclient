package com.baidu.fsg.base.activity;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class a implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f33903b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f33904c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f33905d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f33906e;

    public a(BeanActivity beanActivity, int i2, Object obj, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {beanActivity, Integer.valueOf(i2), obj, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33906e = beanActivity;
        this.a = i2;
        this.f33903b = obj;
        this.f33904c = str;
        this.f33905d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BeanActivity beanActivity = this.f33906e;
            if (beanActivity.mAct != null) {
                beanActivity.handleResponse(this.a, this.f33903b, this.f33904c);
                this.f33906e.handleResponse(this.a, this.f33903b, this.f33904c, this.f33905d);
            }
        }
    }
}
