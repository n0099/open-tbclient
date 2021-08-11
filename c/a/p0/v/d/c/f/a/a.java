package c.a.p0.v.d.c.f.a;

import c.a.p0.v.d.c.f.d.i;
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
    public c.a.p0.v.d.c.f.a.b f24768a;

    /* renamed from: b  reason: collision with root package name */
    public c f24769b;

    /* renamed from: c  reason: collision with root package name */
    public g f24770c;

    /* renamed from: d  reason: collision with root package name */
    public f f24771d;

    /* renamed from: e  reason: collision with root package name */
    public d f24772e;

    /* renamed from: f  reason: collision with root package name */
    public e f24773f;

    /* renamed from: g  reason: collision with root package name */
    public List<c.a.e.k.e.a> f24774g;

    /* renamed from: c.a.p0.v.d.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1159a implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f24775a;

        public C1159a(a aVar, TbPageContext tbPageContext) {
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
            this.f24775a = tbPageContext;
        }

        @Override // c.a.p0.v.d.c.f.d.i
        public void a(c.a.p0.v.d.a.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.getThreadData() == null) {
                return;
            }
            if (cVar.getThreadData().j1() != null && cVar.getThreadData().j1().mYyExtData != null) {
                AlaInfoData j1 = cVar.getThreadData().j1();
                TbPageContext tbPageContext = this.f24775a;
                YyExtData yyExtData = j1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + j1.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_CARD);
                return;
            }
            c.a.p0.v.d.c.c.i(this.f24775a.getPageActivity(), cVar.getThreadData());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f24776a;

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
            this.f24776a = tbPageContext;
        }

        @Override // c.a.p0.v.d.c.f.d.i
        public void a(c.a.p0.v.d.a.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.getThreadData() == null || cVar.getThreadData().j1() == null || cVar.getThreadData().j1().mYyExtData == null) {
                return;
            }
            AlaInfoData j1 = cVar.getThreadData().j1();
            TbPageContext tbPageContext = this.f24776a;
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
        this.f24774g = new LinkedList();
        this.f24768a = new c.a.p0.v.d.c.f.a.b(tbPageContext);
        this.f24769b = new c(tbPageContext);
        this.f24770c = new g(tbPageContext);
        this.f24771d = new f(tbPageContext);
        this.f24772e = new d(tbPageContext);
        this.f24773f = new e(tbPageContext);
        this.f24769b.j0(new C1159a(this, tbPageContext));
        this.f24771d.j0(new b(this, tbPageContext));
        this.f24774g.add(this.f24768a);
        this.f24774g.add(this.f24769b);
        this.f24774g.add(this.f24770c);
        this.f24774g.add(this.f24771d);
        this.f24774g.add(this.f24772e);
        this.f24774g.add(this.f24773f);
    }

    public List<c.a.e.k.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24774g : (List) invokeV.objValue;
    }
}
