package com.baidu.fsg.base.activity;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f34167b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34168c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f34169d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f34170e;

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
        this.f34170e = beanActivity;
        this.a = i2;
        this.f34167b = obj;
        this.f34168c = str;
        this.f34169d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BeanActivity beanActivity = this.f34170e;
            if (beanActivity.mAct != null) {
                beanActivity.handleResponse(this.a, this.f34167b, this.f34168c);
                this.f34170e.handleResponse(this.a, this.f34167b, this.f34168c, this.f34169d);
            }
        }
    }
}
