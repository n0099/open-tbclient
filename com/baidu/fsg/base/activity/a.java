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
    public final /* synthetic */ Object f34635b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34636c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f34637d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f34638e;

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
        this.f34638e = beanActivity;
        this.a = i2;
        this.f34635b = obj;
        this.f34636c = str;
        this.f34637d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BeanActivity beanActivity = this.f34638e;
            if (beanActivity.mAct != null) {
                beanActivity.handleResponse(this.a, this.f34635b, this.f34636c);
                this.f34638e.handleResponse(this.a, this.f34635b, this.f34636c, this.f34637d);
            }
        }
    }
}
