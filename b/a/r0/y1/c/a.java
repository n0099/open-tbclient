package b.a.r0.y1.c;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import b.a.e.a.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f27273a;

    /* renamed from: b  reason: collision with root package name */
    public Context f27274b;

    /* renamed from: c  reason: collision with root package name */
    public View f27275c;

    /* renamed from: d  reason: collision with root package name */
    public CoverFlowView<b.a.r0.y1.c.k.b> f27276d;

    /* renamed from: b.a.r0.y1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1343a implements b.a.q0.s.w.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1343a(a aVar) {
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
                }
            }
        }

        @Override // b.a.q0.s.w.a
        public b.a.q0.s.w.b.c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.q0.s.w.b.c cVar = new b.a.q0.s.w.b.c();
                cVar.c(R.drawable.icon_diandian_white_n);
                cVar.g(R.drawable.icon_diandian_white_s);
                cVar.h(R.dimen.ds1);
                cVar.d(85);
                cVar.f(R.dimen.ds30);
                cVar.e(R.dimen.ds20);
                return cVar;
            }
            return (b.a.q0.s.w.b.c) invokeV.objValue;
        }

        @Override // b.a.q0.s.w.a
        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // b.a.q0.s.w.a
        public b.a.q0.s.w.b.e c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                b.a.q0.s.w.b.e eVar = new b.a.q0.s.w.b.e();
                eVar.a(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds280));
                return eVar;
            }
            return (b.a.q0.s.w.b.e) invokeV.objValue;
        }

        @Override // b.a.q0.s.w.a
        public TbImageView d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements b.a.q0.s.w.b.d<b.a.r0.y1.c.k.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27277a;

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
            this.f27277a = aVar;
        }

        @Override // b.a.q0.s.w.b.d
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                TiebaStatic.log("c10446");
                MemberCenterStatic.a((TbPageContext) j.a(this.f27277a.f27274b), new String[]{str});
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.s.w.b.d
        /* renamed from: c */
        public void a(int i2, b.a.r0.y1.c.k.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, bVar) == null) {
            }
        }
    }

    public a(View view, BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27273a = baseFragmentActivity;
        this.f27274b = baseFragmentActivity.getActivity();
        c(view);
    }

    public void b(b.a.r0.y1.c.k.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        List<b.a.r0.y1.c.k.b> a2 = aVar.a();
        if (a2.size() > 5) {
            a2 = a2.subList(0, 4);
        }
        this.f27276d.setData(a2);
        this.f27276d.setVisibility(0);
    }

    public final void c(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null) {
            return;
        }
        this.f27275c = view;
        CoverFlowView<b.a.r0.y1.c.k.b> coverFlowView = (CoverFlowView) view.findViewById(R.id.coverflowview);
        this.f27276d = coverFlowView;
        coverFlowView.setDisableParentEvent(false);
        e();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.q0.w0.a.a(this.f27273a.getPageContext(), this.f27275c);
            CoverFlowView<b.a.r0.y1.c.k.b> coverFlowView = this.f27276d;
            if (coverFlowView == null || coverFlowView.getVisibility() != 0) {
                return;
            }
            this.f27276d.onChangeSkinType();
        }
    }

    public final void e() {
        CoverFlowView<b.a.r0.y1.c.k.b> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (coverFlowView = this.f27276d) == null) {
            return;
        }
        coverFlowView.setCoverFlowFactory(new C1343a(this));
        this.f27276d.setCallback(new b(this));
    }
}
