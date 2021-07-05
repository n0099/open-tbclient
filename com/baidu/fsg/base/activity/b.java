package com.baidu.fsg.base.activity;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5139a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5140b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5141c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f5142d;

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
        this.f5142d = beanActivity;
        this.f5139a = i2;
        this.f5140b = i3;
        this.f5141c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BeanActivity beanActivity = this.f5142d;
            if (beanActivity.mAct != null) {
                beanActivity.handleFailure(this.f5139a, this.f5140b, this.f5141c);
            }
        }
    }
}
