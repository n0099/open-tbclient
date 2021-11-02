package com.baidu.fsg.base.activity;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f37341a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f37342b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f37343c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f37344d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f37345e;

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
        this.f37345e = beanActivity;
        this.f37341a = i2;
        this.f37342b = obj;
        this.f37343c = str;
        this.f37344d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BeanActivity beanActivity = this.f37345e;
            if (beanActivity.mAct != null) {
                beanActivity.handleResponse(this.f37341a, this.f37342b, this.f37343c);
                this.f37345e.handleResponse(this.f37341a, this.f37342b, this.f37343c, this.f37344d);
            }
        }
    }
}
