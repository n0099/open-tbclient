package c.a.p0.f1.k.a.b;

import c.a.e.k.e.n;
import c.a.e.k.e.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f17599a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.e.k.e.a> f17600b;

    /* renamed from: c  reason: collision with root package name */
    public s f17601c;

    /* renamed from: d  reason: collision with root package name */
    public c f17602d;

    /* renamed from: e  reason: collision with root package name */
    public a f17603e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.f1.k.b.b.c f17604f;

    public b(TbPageContext tbPageContext, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, sVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17599a = tbPageContext;
        this.f17601c = sVar;
        a();
        this.f17601c.addAdapters(this.f17600b);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17600b = new ArrayList();
            this.f17602d = new c(this.f17599a);
            this.f17603e = new a(this.f17599a);
            this.f17604f = new c.a.p0.f1.k.b.b.c(this.f17599a);
            this.f17600b.add(this.f17602d);
            this.f17600b.add(this.f17603e);
            this.f17600b.add(this.f17604f);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f17601c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f17601c.setData(list);
        }
    }
}
