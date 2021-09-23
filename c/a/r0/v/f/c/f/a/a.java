package c.a.r0.v.f.c.f.a;

import c.a.r0.v.f.c.f.d.i;
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
    public c.a.r0.v.f.c.f.a.b f25602a;

    /* renamed from: b  reason: collision with root package name */
    public c f25603b;

    /* renamed from: c  reason: collision with root package name */
    public g f25604c;

    /* renamed from: d  reason: collision with root package name */
    public f f25605d;

    /* renamed from: e  reason: collision with root package name */
    public d f25606e;

    /* renamed from: f  reason: collision with root package name */
    public e f25607f;

    /* renamed from: g  reason: collision with root package name */
    public List<c.a.e.l.e.a> f25608g;

    /* renamed from: c.a.r0.v.f.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1192a implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f25609a;

        public C1192a(a aVar, TbPageContext tbPageContext) {
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
            this.f25609a = tbPageContext;
        }

        @Override // c.a.r0.v.f.c.f.d.i
        public void a(c.a.r0.v.f.a.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.getThreadData() == null) {
                return;
            }
            if (cVar.getThreadData().l1() != null && cVar.getThreadData().l1().mYyExtData != null) {
                AlaInfoData l1 = cVar.getThreadData().l1();
                TbPageContext tbPageContext = this.f25609a;
                YyExtData yyExtData = l1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + l1.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_CARD);
                return;
            }
            c.a.r0.v.f.c.c.i(this.f25609a.getPageActivity(), cVar.getThreadData());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f25610a;

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
            this.f25610a = tbPageContext;
        }

        @Override // c.a.r0.v.f.c.f.d.i
        public void a(c.a.r0.v.f.a.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.getThreadData() == null || cVar.getThreadData().l1() == null || cVar.getThreadData().l1().mYyExtData == null) {
                return;
            }
            AlaInfoData l1 = cVar.getThreadData().l1();
            TbPageContext tbPageContext = this.f25610a;
            YyExtData yyExtData = l1.mYyExtData;
            String str = yyExtData.mSid;
            String str2 = yyExtData.mSsid;
            String str3 = yyExtData.mTemplateId;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + l1.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_HEAD);
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
        this.f25608g = new LinkedList();
        this.f25602a = new c.a.r0.v.f.c.f.a.b(tbPageContext);
        this.f25603b = new c(tbPageContext);
        this.f25604c = new g(tbPageContext);
        this.f25605d = new f(tbPageContext);
        this.f25606e = new d(tbPageContext);
        this.f25607f = new e(tbPageContext);
        this.f25603b.j0(new C1192a(this, tbPageContext));
        this.f25605d.j0(new b(this, tbPageContext));
        this.f25608g.add(this.f25602a);
        this.f25608g.add(this.f25603b);
        this.f25608g.add(this.f25604c);
        this.f25608g.add(this.f25605d);
        this.f25608g.add(this.f25606e);
        this.f25608g.add(this.f25607f);
    }

    public List<c.a.e.l.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25608g : (List) invokeV.objValue;
    }
}
