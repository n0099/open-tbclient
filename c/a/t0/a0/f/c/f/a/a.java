package c.a.t0.a0.f.c.f.a;

import c.a.t0.a0.f.c.f.d.i;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.t0.a0.f.c.f.a.b a;

    /* renamed from: b  reason: collision with root package name */
    public c f14583b;

    /* renamed from: c  reason: collision with root package name */
    public g f14584c;

    /* renamed from: d  reason: collision with root package name */
    public f f14585d;

    /* renamed from: e  reason: collision with root package name */
    public d f14586e;

    /* renamed from: f  reason: collision with root package name */
    public e f14587f;

    /* renamed from: g  reason: collision with root package name */
    public List<c.a.d.n.e.a> f14588g;

    /* renamed from: c.a.t0.a0.f.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0930a implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public C0930a(a aVar, TbPageContext tbPageContext) {
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
            this.a = tbPageContext;
        }

        @Override // c.a.t0.a0.f.c.f.d.i
        public void a(c.a.t0.a0.f.a.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null || eVar.getThreadData() == null) {
                return;
            }
            if (eVar.getThreadData().p1() != null && eVar.getThreadData().p1().mYyExtData != null) {
                AlaInfoData p1 = eVar.getThreadData().p1();
                TbPageContext tbPageContext = this.a;
                YyExtData yyExtData = p1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + p1.roomId, p1.mYyExtData.streamInfo, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_CARD);
                return;
            }
            c.a.t0.a0.f.c.c.i(this.a.getPageActivity(), eVar.getThreadData());
        }
    }

    /* loaded from: classes6.dex */
    public class b implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

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
            this.a = tbPageContext;
        }

        @Override // c.a.t0.a0.f.c.f.d.i
        public void a(c.a.t0.a0.f.a.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null || eVar.getThreadData() == null || eVar.getThreadData().p1() == null || eVar.getThreadData().p1().mYyExtData == null) {
                return;
            }
            AlaInfoData p1 = eVar.getThreadData().p1();
            TbPageContext tbPageContext = this.a;
            YyExtData yyExtData = p1.mYyExtData;
            String str = yyExtData.mSid;
            String str2 = yyExtData.mSsid;
            String str3 = yyExtData.mTemplateId;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + p1.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_HEAD);
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
        this.f14588g = new LinkedList();
        this.a = new c.a.t0.a0.f.c.f.a.b(tbPageContext);
        this.f14583b = new c(tbPageContext);
        this.f14584c = new g(tbPageContext);
        this.f14585d = new f(tbPageContext);
        this.f14586e = new d(tbPageContext);
        this.f14587f = new e(tbPageContext);
        this.f14583b.b0(new C0930a(this, tbPageContext));
        this.f14585d.b0(new b(this, tbPageContext));
        this.f14588g.add(this.a);
        this.f14588g.add(this.f14583b);
        this.f14588g.add(this.f14584c);
        this.f14588g.add(this.f14585d);
        this.f14588g.add(this.f14586e);
        this.f14588g.add(this.f14587f);
    }

    public List<c.a.d.n.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14588g : (List) invokeV.objValue;
    }
}
