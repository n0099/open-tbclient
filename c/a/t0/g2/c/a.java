package c.a.t0.g2.c;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import c.a.d.a.j;
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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public Context f17768b;

    /* renamed from: c  reason: collision with root package name */
    public View f17769c;

    /* renamed from: d  reason: collision with root package name */
    public CoverFlowView<c.a.t0.g2.c.k.b> f17770d;

    /* renamed from: c.a.t0.g2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1117a implements c.a.s0.s.w.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1117a(a aVar) {
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

        @Override // c.a.s0.s.w.a
        public c.a.s0.s.w.b.c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.s0.s.w.b.c cVar = new c.a.s0.s.w.b.c();
                cVar.c(R.drawable.icon_diandian_white_n);
                cVar.g(R.drawable.icon_diandian_white_s);
                cVar.h(R.dimen.ds1);
                cVar.d(85);
                cVar.f(R.dimen.ds30);
                cVar.e(R.dimen.ds20);
                return cVar;
            }
            return (c.a.s0.s.w.b.c) invokeV.objValue;
        }

        @Override // c.a.s0.s.w.a
        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.s0.s.w.a
        public c.a.s0.s.w.b.e c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                c.a.s0.s.w.b.e eVar = new c.a.s0.s.w.b.e();
                eVar.a(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds280));
                return eVar;
            }
            return (c.a.s0.s.w.b.e) invokeV.objValue;
        }

        @Override // c.a.s0.s.w.a
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

    /* loaded from: classes7.dex */
    public class b implements c.a.s0.s.w.b.d<c.a.t0.g2.c.k.b> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.s0.s.w.b.d
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                TiebaStatic.log("c10446");
                MemberCenterStatic.a((TbPageContext) j.a(this.a.f17768b), new String[]{str});
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.s.w.b.d
        /* renamed from: c */
        public void a(int i2, c.a.t0.g2.c.k.b bVar) {
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
        this.a = baseFragmentActivity;
        this.f17768b = baseFragmentActivity.getActivity();
        c(view);
    }

    public void b(c.a.t0.g2.c.k.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        List<c.a.t0.g2.c.k.b> a = aVar.a();
        if (a.size() > 5) {
            a = a.subList(0, 4);
        }
        this.f17770d.setData(a);
        this.f17770d.setVisibility(0);
    }

    public final void c(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null) {
            return;
        }
        this.f17769c = view;
        CoverFlowView<c.a.t0.g2.c.k.b> coverFlowView = (CoverFlowView) view.findViewById(R.id.coverflowview);
        this.f17770d = coverFlowView;
        coverFlowView.setDisableParentEvent(false);
        e();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.s0.x0.a.a(this.a.getPageContext(), this.f17769c);
            CoverFlowView<c.a.t0.g2.c.k.b> coverFlowView = this.f17770d;
            if (coverFlowView == null || coverFlowView.getVisibility() != 0) {
                return;
            }
            this.f17770d.onChangeSkinType();
        }
    }

    public final void e() {
        CoverFlowView<c.a.t0.g2.c.k.b> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (coverFlowView = this.f17770d) == null) {
            return;
        }
        coverFlowView.setCoverFlowFactory(new C1117a(this));
        this.f17770d.setCallback(new b(this));
    }
}
