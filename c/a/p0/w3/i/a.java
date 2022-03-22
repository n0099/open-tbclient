package c.a.p0.w3.i;

import c.a.p0.w3.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.stamp.model.FetchStampModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FetchStampModel a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.w3.h.a f20573b;

    public a(TbPageContext tbPageContext, c.a.p0.w3.h.a<d> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20573b = aVar;
        this.a = new FetchStampModel(tbPageContext, aVar);
    }

    public void a() {
        FetchStampModel fetchStampModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fetchStampModel = this.a) == null) {
            return;
        }
        fetchStampModel.cancelLoadData();
    }

    public void b() {
        FetchStampModel fetchStampModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (fetchStampModel = this.a) == null) {
            return;
        }
        fetchStampModel.loadData();
    }
}
