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
    public final /* synthetic */ int f39390a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f39391b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f39392c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f39393d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f39394e;

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
        this.f39394e = beanActivity;
        this.f39390a = i2;
        this.f39391b = obj;
        this.f39392c = str;
        this.f39393d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BeanActivity beanActivity = this.f39394e;
            if (beanActivity.mAct != null) {
                beanActivity.handleResponse(this.f39390a, this.f39391b, this.f39392c);
                this.f39394e.handleResponse(this.f39390a, this.f39391b, this.f39392c, this.f39393d);
            }
        }
    }
}
