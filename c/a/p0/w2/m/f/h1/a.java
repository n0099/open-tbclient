package c.a.p0.w2.m.f.h1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.o0.c1.q;
import c.a.p0.w2.i.f;
import c.a.p0.w2.m.f.r;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a extends r<c.a.p0.w2.i.a, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.w2.m.f.h1.b o;
    public c.a.p0.w2.i.a p;
    public f q;
    public View.OnClickListener r;

    /* renamed from: c.a.p0.w2.m.f.h1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1502a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC1502a(a aVar) {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.p == null || this.a.p.a == null || q.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(this.a.j.getPageContext().getPageActivity());
                return;
            }
            a aVar = this.a;
            aVar.g0(aVar.p);
            if (this.a.p.a.b()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.j.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            } else if (this.a.p.a.a()) {
                this.a.o.u(this.a.p);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f20067b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f20068c;

        /* renamed from: d  reason: collision with root package name */
        public ProgressBar f20069d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f20070e;

        /* renamed from: f  reason: collision with root package name */
        public View f20071f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f20072g;

        /* renamed from: c.a.p0.w2.m.f.h1.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC1503a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public View$OnClickListenerC1503a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f20072g == null) {
                    return;
                }
                this.a.f20072g.onClick(view);
            }
        }

        public /* synthetic */ b(View view, View$OnClickListenerC1502a view$OnClickListenerC1502a) {
            this(view);
        }

        public final void e(Context context, c.a.p0.w2.i.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, bVar) == null) || bVar == null) {
                return;
            }
            this.f20070e.setText(bVar.f19807c);
            this.f20067b.J(bVar.f19806b, 38, false);
            this.a.setText(context.getResources().getString(R.string.obfuscated_res_0x7f0f0d88, bVar.f19808d) + "%");
            int e2 = c.a.d.f.m.b.e(bVar.f19808d, 0);
            if (e2 > 100) {
                e2 = 100;
            } else if (e2 < 0) {
                e2 = 0;
            }
            this.f20069d.setProgress(e2);
            if (bVar.a()) {
                this.f20068c.setText(R.string.obfuscated_res_0x7f0f0d86);
                SkinManager.setViewTextColor(this.f20068c, (int) R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f20068c, R.drawable.btn_pb_ad_card_gift_get);
                this.f20068c.setClickable(true);
            } else if (bVar.b()) {
                this.f20068c.setText(R.string.obfuscated_res_0x7f0f0d8d);
                SkinManager.setViewTextColor(this.f20068c, (int) R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f20068c, R.drawable.obfuscated_res_0x7f0803c5);
                this.f20068c.setClickable(true);
            } else {
                this.f20068c.setText(R.string.obfuscated_res_0x7f0f0d87);
                SkinManager.setViewTextColor(this.f20068c, (int) R.color.CAM_X0109);
                this.f20068c.setBackgroundResource(R.drawable.obfuscated_res_0x7f081200);
                this.f20068c.setClickable(false);
            }
            f();
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundResource(this.f20071f, R.drawable.bg_pb_ad_card_gift);
                SkinManager.setViewTextColor(this.f20070e, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0107);
                this.f20069d.setProgressDrawable(SkinManager.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
            }
        }

        public void g(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
                this.f20072g = onClickListener;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20071f = view.findViewById(R.id.obfuscated_res_0x7f09035a);
            this.f20067b = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090e9a);
            this.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092236);
            this.f20068c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090403);
            this.f20069d = (ProgressBar) view.findViewById(R.id.obfuscated_res_0x7f09192d);
            this.f20070e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09223a);
            this.f20067b.setRadius(n.f(b().getContext(), R.dimen.tbds20));
            this.f20067b.setConrers(5);
            this.f20067b.setDefaultBgResource(R.color.cp_atp_a);
            this.f20067b.setDrawCorner(true);
            this.f20068c.setOnClickListener(new View$OnClickListenerC1503a(this));
            this.f20069d.setMax(100);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.p0.w2.q.c) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new View$OnClickListenerC1502a(this);
        this.o = new c.a.p0.w2.m.f.h1.b(pbFragment);
    }

    @Override // c.a.p0.w2.m.f.r, c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        j0(i, view, viewGroup, (c.a.p0.w2.i.a) obj, (b) viewHolder);
        return view;
    }

    public final void g0(c.a.p0.w2.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            c.a.p0.z3.c.g().c(this.j.getUniqueId(), c.a.p0.z3.a.e(this.q.O(), "a005", "common_click", 1, aVar.f19805b, true, aVar.a.a + "", null, 18));
        }
    }

    public final void h0(c.a.p0.w2.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            String str = aVar.a.a + "";
            c.a.p0.z3.c.g().d(this.j.getUniqueId(), c.a.p0.z3.a.c(this.q.O().getTid(), str, "", null), c.a.p0.z3.a.g(this.q.O(), "a005", "common_exp", aVar.f19805b, true, str, "", 18));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: i0 */
    public b M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            b bVar = new b(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0675, viewGroup, false), null);
            bVar.g(this.r);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public View j0(int i, View view, ViewGroup viewGroup, c.a.p0.w2.i.a aVar, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view, viewGroup, aVar, bVar})) == null) {
            super.S(i, view, viewGroup, aVar, bVar);
            if (aVar != null && bVar != null) {
                aVar.f19805b = i + 1;
                this.p = aVar;
                h0(aVar);
                bVar.e(this.a, aVar.a);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void onDestroy() {
        c.a.p0.w2.m.f.h1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bVar = this.o) == null) {
            return;
        }
        bVar.q();
    }

    public void t(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.q = fVar;
            c.a.p0.w2.m.f.h1.b bVar = this.o;
            if (bVar != null) {
                bVar.v(fVar);
            }
        }
    }
}
