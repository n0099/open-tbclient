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
    public b.a.r0.w.f.c.f.a.b f26138a;

    /* renamed from: b  reason: collision with root package name */
    public c f26139b;

    /* renamed from: c  reason: collision with root package name */
    public g f26140c;

    /* renamed from: d  reason: collision with root package name */
    public f f26141d;

    /* renamed from: e  reason: collision with root package name */
    public d f26142e;

    /* renamed from: f  reason: collision with root package name */
    public e f26143f;

    /* renamed from: g  reason: collision with root package name */
    public List<b.a.e.m.e.a> f26144g;

    /* renamed from: b.a.r0.w.f.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1270a implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f26145a;

        public C1270a(a aVar, TbPageContext tbPageContext) {
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
            this.f26145a = tbPageContext;
        }

        @Override // b.a.r0.w.f.c.f.d.i
        public void a(b.a.r0.w.f.a.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null || eVar.getThreadData() == null) {
                return;
            }
            if (eVar.getThreadData().m1() != null && eVar.getThreadData().m1().mYyExtData != null) {
                AlaInfoData m1 = eVar.getThreadData().m1();
                TbPageContext tbPageContext = this.f26145a;
                YyExtData yyExtData = m1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + m1.roomId, m1.mYyExtData.streamInfo, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_CARD);
                return;
            }
            b.a.r0.w.f.c.c.i(this.f26145a.getPageActivity(), eVar.getThreadData());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f26146a;

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
            this.f26146a = tbPageContext;
        }

        @Override // b.a.r0.w.f.c.f.d.i
        public void a(b.a.r0.w.f.a.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null || eVar.getThreadData() == null || eVar.getThreadData().m1() == null || eVar.getThreadData().m1().mYyExtData == null) {
                return;
            }
            AlaInfoData m1 = eVar.getThreadData().m1();
            TbPageContext tbPageContext = this.f26146a;
            YyExtData yyExtData = m1.mYyExtData;
            String str = yyExtData.mSid;
            String str2 = yyExtData.mSsid;
            String str3 = yyExtData.mTemplateId;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + m1.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_HEAD);
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
        this.f26144g = new LinkedList();
        this.f26138a = new b.a.r0.w.f.c.f.a.b(tbPageContext);
        this.f26139b = new c(tbPageContext);
        this.f26140c = new g(tbPageContext);
        this.f26141d = new f(tbPageContext);
        this.f26142e = new d(tbPageContext);
        this.f26143f = new e(tbPageContext);
        this.f26139b.i0(new C1270a(this, tbPageContext));
        this.f26141d.i0(new b(this, tbPageContext));
        this.f26144g.add(this.f26138a);
        this.f26144g.add(this.f26139b);
        this.f26144g.add(this.f26140c);
        this.f26144g.add(this.f26141d);
        this.f26144g.add(this.f26142e);
        this.f26144g.add(this.f26143f);
    }

    public List<b.a.e.m.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26144g : (List) invokeV.objValue;
    }
}
