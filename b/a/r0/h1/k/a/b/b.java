package b.a.r0.h1.k.a.b;

import b.a.e.l.e.n;
import b.a.e.l.e.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f17575a;

    /* renamed from: b  reason: collision with root package name */
    public List<b.a.e.l.e.a> f17576b;

    /* renamed from: c  reason: collision with root package name */
    public s f17577c;

    /* renamed from: d  reason: collision with root package name */
    public c f17578d;

    /* renamed from: e  reason: collision with root package name */
    public a f17579e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.h1.k.b.b.c f17580f;

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
        this.f17575a = tbPageContext;
        this.f17577c = sVar;
        a();
        this.f17577c.addAdapters(this.f17576b);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17576b = new ArrayList();
            this.f17578d = new c(this.f17575a);
            this.f17579e = new a(this.f17575a);
            this.f17580f = new b.a.r0.h1.k.b.b.c(this.f17575a);
            this.f17576b.add(this.f17578d);
            this.f17576b.add(this.f17579e);
            this.f17576b.add(this.f17580f);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f17577c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f17577c.setData(list);
        }
    }
}
