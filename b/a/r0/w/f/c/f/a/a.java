package b.a.r0.w.f.c.f.a;

import b.a.r0.w.f.c.f.d.i;
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

    /* renamed from: a  reason: collision with root package name */
    public b.a.r0.w.f.c.f.a.b f24621a;

    /* renamed from: b  reason: collision with root package name */
    public c f24622b;

    /* renamed from: c  reason: collision with root package name */
    public g f24623c;

    /* renamed from: d  reason: collision with root package name */
    public f f24624d;

    /* renamed from: e  reason: collision with root package name */
    public d f24625e;

    /* renamed from: f  reason: collision with root package name */
    public e f24626f;

    /* renamed from: g  reason: collision with root package name */
    public List<b.a.e.l.e.a> f24627g;

    /* renamed from: b.a.r0.w.f.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1202a implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f24628a;

        public C1202a(a aVar, TbPageContext tbPageContext) {
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
            this.f24628a = tbPageContext;
        }

        @Override // b.a.r0.w.f.c.f.d.i
        public void a(b.a.r0.w.f.a.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null || eVar.getThreadData() == null) {
                return;
            }
            if (eVar.getThreadData().l1() != null && eVar.getThreadData().l1().mYyExtData != null) {
                AlaInfoData l1 = eVar.getThreadData().l1();
                TbPageContext tbPageContext = this.f24628a;
                YyExtData yyExtData = l1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + l1.roomId, l1.mYyExtData.streamInfo, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_CARD);
                return;
            }
            b.a.r0.w.f.c.c.i(this.f24628a.getPageActivity(), eVar.getThreadData());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f24629a;

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
            this.f24629a = tbPageContext;
        }

        @Override // b.a.r0.w.f.c.f.d.i
        public void a(b.a.r0.w.f.a.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null || eVar.getThreadData() == null || eVar.getThreadData().l1() == null || eVar.getThreadData().l1().mYyExtData == null) {
                return;
            }
            AlaInfoData l1 = eVar.getThreadData().l1();
            TbPageContext tbPageContext = this.f24629a;
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
        this.f24627g = new LinkedList();
        this.f24621a = new b.a.r0.w.f.c.f.a.b(tbPageContext);
        this.f24622b = new c(tbPageContext);
        this.f24623c = new g(tbPageContext);
        this.f24624d = new f(tbPageContext);
        this.f24625e = new d(tbPageContext);
        this.f24626f = new e(tbPageContext);
        this.f24622b.i0(new C1202a(this, tbPageContext));
        this.f24624d.i0(new b(this, tbPageContext));
        this.f24627g.add(this.f24621a);
        this.f24627g.add(this.f24622b);
        this.f24627g.add(this.f24623c);
        this.f24627g.add(this.f24624d);
        this.f24627g.add(this.f24625e);
        this.f24627g.add(this.f24626f);
    }

    public List<b.a.e.l.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24627g : (List) invokeV.objValue;
    }
}
