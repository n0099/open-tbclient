package c.a.o0.r.r;

import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class k1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f10901b;

    /* renamed from: c  reason: collision with root package name */
    public String f10902c;

    /* renamed from: d  reason: collision with root package name */
    public String f10903d;

    public k1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null) {
            return;
        }
        this.a = intent.getStringExtra(TiebaStatic.Params.RECOM_WEIGHT);
        this.f10901b = intent.getStringExtra("recom_source");
        this.f10902c = intent.getStringExtra("recom_abtag");
        this.f10903d = intent.getStringExtra(TiebaStatic.Params.RECOM_EXTRA);
    }

    public void b(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) || threadData == null) {
            return;
        }
        this.a = threadData.mRecomWeight;
        this.f10901b = threadData.mRecomSource;
        this.f10902c = threadData.mRecomAbTag;
        this.f10903d = threadData.mRecomExtra;
    }

    public void c(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) || intent == null) {
            return;
        }
        intent.putExtra(TiebaStatic.Params.RECOM_WEIGHT, this.a);
        intent.putExtra("recom_source", this.f10901b);
        intent.putExtra("recom_abtag", this.f10902c);
        intent.putExtra(TiebaStatic.Params.RECOM_EXTRA, this.f10903d);
    }

    public void d(c.a.p0.c3.u uVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, uVar) == null) || uVar == null) {
            return;
        }
        uVar.f13508g = this.a;
        uVar.f13507f = this.f10901b;
        uVar.l = this.f10902c;
        uVar.o = this.f10903d;
    }
}
