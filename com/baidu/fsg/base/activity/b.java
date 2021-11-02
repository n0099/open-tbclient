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
    public final /* synthetic */ int f37348a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f37349b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f37350c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f37351d;

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
        this.f37351d = beanActivity;
        this.f37348a = i2;
        this.f37349b = i3;
        this.f37350c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BeanActivity beanActivity = this.f37351d;
            if (beanActivity.mAct != null) {
                beanActivity.handleFailure(this.f37348a, this.f37349b, this.f37350c);
            }
        }
    }
}
