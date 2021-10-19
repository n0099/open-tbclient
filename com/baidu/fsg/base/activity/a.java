package com.baidu.fsg.base.activity;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f39394a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f39395b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f39396c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f39397d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f39398e;

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
        this.f39398e = beanActivity;
        this.f39394a = i2;
        this.f39395b = obj;
        this.f39396c = str;
        this.f39397d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BeanActivity beanActivity = this.f39398e;
            if (beanActivity.mAct != null) {
                beanActivity.handleResponse(this.f39394a, this.f39395b, this.f39396c);
                this.f39398e.handleResponse(this.f39394a, this.f39395b, this.f39396c, this.f39397d);
            }
        }
    }
}
