package c.a.q0.q0.x;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import c.a.e.e.p.l;
import c.a.p0.s.w.b.d;
import c.a.p0.s.w.b.e;
import c.a.q0.q0.x.c.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Pattern f23820a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f23821b;

    /* renamed from: c  reason: collision with root package name */
    public View f23822c;

    /* renamed from: d  reason: collision with root package name */
    public CoverFlowView<c.a.p0.s.w.b.a> f23823d;

    /* renamed from: e  reason: collision with root package name */
    public c f23824e;

    /* renamed from: f  reason: collision with root package name */
    public d<c.a.p0.s.w.b.a> f23825f;

    /* renamed from: c.a.q0.q0.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1100a extends c.a.p0.s.w.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f23826a;

        public C1100a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23826a = aVar;
        }

        @Override // c.a.p0.s.w.b.b, c.a.p0.s.w.a
        public c.a.p0.s.w.b.c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.s.w.b.c a2 = super.a();
                if (a2 != null) {
                    a2.d(81);
                    a2.e(R.dimen.ds20);
                }
                return a2;
            }
            return (c.a.p0.s.w.b.c) invokeV.objValue;
        }

        @Override // c.a.p0.s.w.b.b, c.a.p0.s.w.a
        public e c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                e eVar = new e();
                eVar.a((int) (l.k(this.f23826a.f23821b.getPageActivity()) / 2.5714285f));
                return eVar;
            }
            return (e) invokeV.objValue;
        }

        @Override // c.a.p0.s.w.b.b, c.a.p0.s.w.a
        public TbImageView d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d<c.a.p0.s.w.b.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f23827a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23827a = aVar;
        }

        @Override // c.a.p0.s.w.b.d
        public void a(int i2, c.a.p0.s.w.b.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) || aVar == null) {
                return;
            }
            boolean z = aVar instanceof c.a;
        }

        @Override // c.a.p0.s.w.b.d
        public void b(int i2, String str) {
            c.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (aVar = (c.a) this.f23827a.f23823d.getItem(i2)) == null) {
                return;
            }
            Matcher matcher = this.f23827a.f23820a.matcher(aVar.b());
            if (matcher.find()) {
                this.f23827a.f23821b.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f23827a.f23821b.getPageActivity()).createNormalCfg(matcher.group(1), null, null)));
            }
        }
    }

    public a(TbPageContext<?> tbPageContext) {
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
        this.f23820a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");
        this.f23821b = null;
        this.f23823d = null;
        this.f23824e = null;
        this.f23825f = new b(this);
        this.f23821b = tbPageContext;
        d();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23822c : (View) invokeV.objValue;
    }

    public final void d() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbPageContext = this.f23821b) == null) {
            return;
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.square_banner_layout, (ViewGroup) null);
        this.f23822c = inflate;
        if (inflate == null) {
            return;
        }
        this.f23823d = (CoverFlowView) inflate.findViewById(R.id.square_banner_cover_flow_view);
        C1100a c1100a = new C1100a(this);
        this.f23823d.setDisableParentEvent(false);
        this.f23823d.setCoverFlowFactory(c1100a);
        this.f23823d.setCallback(this.f23825f);
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || cVar == null || cVar == this.f23824e) {
            return;
        }
        this.f23823d.setData(cVar.a());
        this.f23824e = cVar;
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, bdUniqueId) != null) || bdUniqueId == null) {
        }
    }

    public void g() {
        CoverFlowView<c.a.p0.s.w.b.a> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (coverFlowView = this.f23823d) == null) {
            return;
        }
        coverFlowView.startMarqueen();
    }
}
