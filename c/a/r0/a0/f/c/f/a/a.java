package c.a.r0.a0.f.c.f.a;

import c.a.r0.a0.f.c.f.d.i;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.a0.f.c.f.a.b a;

    /* renamed from: b  reason: collision with root package name */
    public c f13956b;

    /* renamed from: c  reason: collision with root package name */
    public g f13957c;

    /* renamed from: d  reason: collision with root package name */
    public f f13958d;

    /* renamed from: e  reason: collision with root package name */
    public d f13959e;

    /* renamed from: f  reason: collision with root package name */
    public e f13960f;

    /* renamed from: g  reason: collision with root package name */
    public List<c.a.d.m.e.a> f13961g;

    /* renamed from: c.a.r0.a0.f.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0846a implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public C0846a(a aVar, TbPageContext tbPageContext) {
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

        @Override // c.a.r0.a0.f.c.f.d.i
        public void a(c.a.r0.a0.f.a.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null || eVar.getThreadData() == null) {
                return;
            }
            if (eVar.getThreadData().o1() != null && eVar.getThreadData().o1().mYyExtData != null) {
                AlaInfoData o1 = eVar.getThreadData().o1();
                TbPageContext tbPageContext = this.a;
                YyExtData yyExtData = o1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + o1.roomId, o1.mYyExtData.streamInfo, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_CARD);
                return;
            }
            c.a.r0.a0.f.c.c.i(this.a.getPageActivity(), eVar.getThreadData());
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // c.a.r0.a0.f.c.f.d.i
        public void a(c.a.r0.a0.f.a.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null || eVar.getThreadData() == null || eVar.getThreadData().o1() == null || eVar.getThreadData().o1().mYyExtData == null) {
                return;
            }
            AlaInfoData o1 = eVar.getThreadData().o1();
            TbPageContext tbPageContext = this.a;
            YyExtData yyExtData = o1.mYyExtData;
            String str = yyExtData.mSid;
            String str2 = yyExtData.mSsid;
            String str3 = yyExtData.mTemplateId;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + o1.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_HEAD);
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
        this.f13961g = new LinkedList();
        this.a = new c.a.r0.a0.f.c.f.a.b(tbPageContext);
        this.f13956b = new c(tbPageContext);
        this.f13957c = new g(tbPageContext);
        this.f13958d = new f(tbPageContext);
        this.f13959e = new d(tbPageContext);
        this.f13960f = new e(tbPageContext);
        this.f13956b.i0(new C0846a(this, tbPageContext));
        this.f13958d.i0(new b(this, tbPageContext));
        this.f13961g.add(this.a);
        this.f13961g.add(this.f13956b);
        this.f13961g.add(this.f13957c);
        this.f13961g.add(this.f13958d);
        this.f13961g.add(this.f13959e);
        this.f13961g.add(this.f13960f);
    }

    public List<c.a.d.m.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13961g : (List) invokeV.objValue;
    }
}
