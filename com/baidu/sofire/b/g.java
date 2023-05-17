package com.baidu.sofire.b;

import android.content.Context;
import android.util.Pair;
import com.baidu.sofire.ac.Callback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class g implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Callback a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Class[] e;
    public final /* synthetic */ Object[] f;

    public g(Callback callback, Context context, int i, String str, Class[] clsArr, Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {callback, context, Integer.valueOf(i), str, clsArr, objArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = callback;
        this.b = context;
        this.c = i;
        this.d = str;
        this.e = clsArr;
        this.f = objArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Callback callback = this.a;
            if (callback != null) {
                callback.onBegin(new Object[0]);
            }
            Pair<Integer, Object> a = c.a(this.b, this.c, 0, this.d, this.e, this.f);
            if (this.a != null) {
                if (((Integer) a.first).intValue() != 0) {
                    this.a.onError(a.first);
                } else {
                    this.a.onEnd(a.second);
                }
            }
        }
    }
}
