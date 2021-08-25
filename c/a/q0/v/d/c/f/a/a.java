package c.a.q0.v.d.c.f.a;

import c.a.q0.v.d.c.f.d.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.q0.v.d.c.f.a.b f25101a;

    /* renamed from: b  reason: collision with root package name */
    public c f25102b;

    /* renamed from: c  reason: collision with root package name */
    public g f25103c;

    /* renamed from: d  reason: collision with root package name */
    public f f25104d;

    /* renamed from: e  reason: collision with root package name */
    public d f25105e;

    /* renamed from: f  reason: collision with root package name */
    public e f25106f;

    /* renamed from: g  reason: collision with root package name */
    public List<c.a.e.l.e.a> f25107g;

    /* renamed from: c.a.q0.v.d.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1170a implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f25108a;

        public C1170a(a aVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25108a = tbPageContext;
        }

        @Override // c.a.q0.v.d.c.f.d.i
        public void a(c.a.q0.v.d.a.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.getThreadData() == null) {
                return;
            }
            if (cVar.getThreadData().j1() != null && cVar.getThreadData().j1().mYyExtData != null) {
                AlaInfoData j1 = cVar.getThreadData().j1();
                TbPageContext tbPageContext = this.f25108a;
                YyExtData yyExtData = j1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + j1.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_CARD);
                return;
            }
            c.a.q0.v.d.c.c.i(this.f25108a.getPageActivity(), cVar.getThreadData());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f25109a;

        public b(a aVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25109a = tbPageContext;
        }

        @Override // c.a.q0.v.d.c.f.d.i
        public void a(c.a.q0.v.d.a.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.getThreadData() == null || cVar.getThreadData().j1() == null || cVar.getThreadData().j1().mYyExtData == null) {
                return;
            }
            AlaInfoData j1 = cVar.getThreadData().j1();
            TbPageContext tbPageContext = this.f25109a;
            YyExtData yyExtData = j1.mYyExtData;
            String str = yyExtData.mSid;
            String str2 = yyExtData.mSsid;
            String str3 = yyExtData.mTemplateId;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + j1.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_HEAD);
        }
    }

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25107g = new LinkedList();
        this.f25101a = new c.a.q0.v.d.c.f.a.b(tbPageContext);
        this.f25102b = new c(tbPageContext);
        this.f25103c = new g(tbPageContext);
        this.f25104d = new f(tbPageContext);
        this.f25105e = new d(tbPageContext);
        this.f25106f = new e(tbPageContext);
        this.f25102b.j0(new C1170a(this, tbPageContext));
        this.f25104d.j0(new b(this, tbPageContext));
        this.f25107g.add(this.f25101a);
        this.f25107g.add(this.f25102b);
        this.f25107g.add(this.f25103c);
        this.f25107g.add(this.f25104d);
        this.f25107g.add(this.f25105e);
        this.f25107g.add(this.f25106f);
    }

    public List<c.a.e.l.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25107g : (List) invokeV.objValue;
    }
}
