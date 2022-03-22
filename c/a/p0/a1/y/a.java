package c.a.p0.a1.y;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import c.a.d.f.p.n;
import c.a.o0.r.x.b.d;
import c.a.o0.r.x.b.e;
import c.a.p0.a1.y.c.c;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Pattern a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f12069b;

    /* renamed from: c  reason: collision with root package name */
    public View f12070c;

    /* renamed from: d  reason: collision with root package name */
    public CoverFlowView<c.a.o0.r.x.b.a> f12071d;

    /* renamed from: e  reason: collision with root package name */
    public c f12072e;

    /* renamed from: f  reason: collision with root package name */
    public d<c.a.o0.r.x.b.a> f12073f;

    /* renamed from: c.a.p0.a1.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0914a extends c.a.o0.r.x.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0914a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.o0.r.x.b.b, c.a.o0.r.x.a
        public c.a.o0.r.x.b.c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.o0.r.x.b.c a = super.a();
                if (a != null) {
                    a.d(81);
                    a.e(R.dimen.obfuscated_res_0x7f0701d5);
                }
                return a;
            }
            return (c.a.o0.r.x.b.c) invokeV.objValue;
        }

        @Override // c.a.o0.r.x.b.b, c.a.o0.r.x.a
        public e c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                e eVar = new e();
                eVar.a((int) (n.k(this.a.f12069b.getPageActivity()) / 2.5714285f));
                return eVar;
            }
            return (e) invokeV.objValue;
        }

        @Override // c.a.o0.r.x.b.b, c.a.o0.r.x.a
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

    /* loaded from: classes2.dex */
    public class b implements d<c.a.o0.r.x.b.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.o0.r.x.b.d
        public void a(int i, c.a.o0.r.x.b.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, aVar) == null) || aVar == null) {
                return;
            }
            boolean z = aVar instanceof c.a;
        }

        @Override // c.a.o0.r.x.b.d
        public void b(int i, String str) {
            c.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) || (aVar = (c.a) this.a.f12071d.n(i)) == null) {
                return;
            }
            Matcher matcher = this.a.a.matcher(aVar.b());
            if (matcher.find()) {
                this.a.f12069b.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.f12069b.getPageActivity()).createNormalCfg(matcher.group(1), null, null)));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");
        this.f12069b = null;
        this.f12071d = null;
        this.f12072e = null;
        this.f12073f = new b(this);
        this.f12069b = tbPageContext;
        d();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12070c : (View) invokeV.objValue;
    }

    public final void d() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbPageContext = this.f12069b) == null) {
            return;
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0799, (ViewGroup) null);
        this.f12070c = inflate;
        if (inflate == null) {
            return;
        }
        this.f12071d = (CoverFlowView) inflate.findViewById(R.id.obfuscated_res_0x7f091d68);
        C0914a c0914a = new C0914a(this);
        this.f12071d.setDisableParentEvent(false);
        this.f12071d.setCoverFlowFactory(c0914a);
        this.f12071d.setCallback(this.f12073f);
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || cVar == null || cVar == this.f12072e) {
            return;
        }
        this.f12071d.setData(cVar.a());
        this.f12072e = cVar;
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, bdUniqueId) != null) || bdUniqueId == null) {
        }
    }

    public void g() {
        CoverFlowView<c.a.o0.r.x.b.a> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (coverFlowView = this.f12071d) == null) {
            return;
        }
        coverFlowView.v();
    }
}
