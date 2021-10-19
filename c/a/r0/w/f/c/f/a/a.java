package c.a.r0.w.f.c.f.a;

import c.a.r0.w.f.c.f.d.i;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.r0.w.f.c.f.a.b f25777a;

    /* renamed from: b  reason: collision with root package name */
    public c f25778b;

    /* renamed from: c  reason: collision with root package name */
    public g f25779c;

    /* renamed from: d  reason: collision with root package name */
    public f f25780d;

    /* renamed from: e  reason: collision with root package name */
    public d f25781e;

    /* renamed from: f  reason: collision with root package name */
    public e f25782f;

    /* renamed from: g  reason: collision with root package name */
    public List<c.a.e.l.e.a> f25783g;

    /* renamed from: c.a.r0.w.f.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1201a implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f25784a;

        public C1201a(a aVar, TbPageContext tbPageContext) {
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
            this.f25784a = tbPageContext;
        }

        @Override // c.a.r0.w.f.c.f.d.i
        public void a(c.a.r0.w.f.a.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.getThreadData() == null) {
                return;
            }
            if (cVar.getThreadData().l1() != null && cVar.getThreadData().l1().mYyExtData != null) {
                AlaInfoData l1 = cVar.getThreadData().l1();
                TbPageContext tbPageContext = this.f25784a;
                YyExtData yyExtData = l1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + l1.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_CARD);
                return;
            }
            c.a.r0.w.f.c.c.i(this.f25784a.getPageActivity(), cVar.getThreadData());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f25785a;

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
            this.f25785a = tbPageContext;
        }

        @Override // c.a.r0.w.f.c.f.d.i
        public void a(c.a.r0.w.f.a.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.getThreadData() == null || cVar.getThreadData().l1() == null || cVar.getThreadData().l1().mYyExtData == null) {
                return;
            }
            AlaInfoData l1 = cVar.getThreadData().l1();
            TbPageContext tbPageContext = this.f25785a;
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
        this.f25783g = new LinkedList();
        this.f25777a = new c.a.r0.w.f.c.f.a.b(tbPageContext);
        this.f25778b = new c(tbPageContext);
        this.f25779c = new g(tbPageContext);
        this.f25780d = new f(tbPageContext);
        this.f25781e = new d(tbPageContext);
        this.f25782f = new e(tbPageContext);
        this.f25778b.j0(new C1201a(this, tbPageContext));
        this.f25780d.j0(new b(this, tbPageContext));
        this.f25783g.add(this.f25777a);
        this.f25783g.add(this.f25778b);
        this.f25783g.add(this.f25779c);
        this.f25783g.add(this.f25780d);
        this.f25783g.add(this.f25781e);
        this.f25783g.add(this.f25782f);
    }

    public List<c.a.e.l.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25783g : (List) invokeV.objValue;
    }
}
