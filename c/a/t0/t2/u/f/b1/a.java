package c.a.t0.t2.u.f.b1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.s0.d1.q;
import c.a.t0.t2.g;
import c.a.t0.t2.h;
import c.a.t0.t2.i;
import c.a.t0.t2.j;
import c.a.t0.t2.l;
import c.a.t0.t2.r.f;
import c.a.t0.t2.u.f.o;
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
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a extends o<c.a.t0.t2.r.a, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.t0.t2.u.f.b1.b s;
    public c.a.t0.t2.r.a t;
    public f u;
    public View.OnClickListener v;

    /* renamed from: c.a.t0.t2.u.f.b1.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1407a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22913e;

        public View$OnClickListenerC1407a(a aVar) {
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
            this.f22913e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22913e.t == null || this.f22913e.t.f22668e == null || q.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(this.f22913e.n.getPageContext().getPageActivity());
                return;
            }
            a aVar = this.f22913e;
            aVar.g0(aVar.t);
            if (this.f22913e.t.f22668e.b()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f22913e.n.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            } else if (this.f22913e.t.f22668e.a()) {
                this.f22913e.s.u(this.f22913e.t);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f22914b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f22915c;

        /* renamed from: d  reason: collision with root package name */
        public ProgressBar f22916d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f22917e;

        /* renamed from: f  reason: collision with root package name */
        public View f22918f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f22919g;

        /* renamed from: c.a.t0.t2.u.f.b1.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC1408a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f22920e;

            public View$OnClickListenerC1408a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f22920e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22920e.f22919g == null) {
                    return;
                }
                this.f22920e.f22919g.onClick(view);
            }
        }

        public /* synthetic */ b(View view, View$OnClickListenerC1407a view$OnClickListenerC1407a) {
            this(view);
        }

        public final void c(Context context, c.a.t0.t2.r.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, bVar) == null) || bVar == null) {
                return;
            }
            this.f22917e.setText(bVar.f22671c);
            this.f22914b.startLoad(bVar.f22670b, 38, false);
            this.a.setText(context.getResources().getString(l.pb_ad_card_gift_rate, bVar.f22672d) + "%");
            int e2 = c.a.d.f.m.b.e(bVar.f22672d, 0);
            if (e2 > 100) {
                e2 = 100;
            } else if (e2 < 0) {
                e2 = 0;
            }
            this.f22916d.setProgress(e2);
            if (bVar.a()) {
                this.f22915c.setText(l.pb_ad_card_gift_get);
                SkinManager.setViewTextColor(this.f22915c, c.a.t0.t2.f.CAM_X0101);
                SkinManager.setBackgroundResource(this.f22915c, h.btn_pb_ad_card_gift_get);
                this.f22915c.setClickable(true);
            } else if (bVar.b()) {
                this.f22915c.setText(l.pb_ad_card_gift_watch_btn);
                SkinManager.setViewTextColor(this.f22915c, c.a.t0.t2.f.CAM_X0101);
                SkinManager.setBackgroundResource(this.f22915c, h.btn_pb_ad_card_gift_watch);
                this.f22915c.setClickable(true);
            } else {
                this.f22915c.setText(l.pb_ad_card_gift_over_btn);
                SkinManager.setViewTextColor(this.f22915c, c.a.t0.t2.f.CAM_X0109);
                this.f22915c.setBackgroundResource(h.transparent_bg);
                this.f22915c.setClickable(false);
            }
            onChangeSkinType();
        }

        public final void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundResource(this.f22918f, h.bg_pb_ad_card_gift);
                SkinManager.setViewTextColor(this.f22917e, c.a.t0.t2.f.CAM_X0105);
                SkinManager.setViewTextColor(this.a, c.a.t0.t2.f.CAM_X0107);
                this.f22916d.setProgressDrawable(SkinManager.getDrawable(h.bg_pb_ad_card_gift_progress));
            }
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
                this.f22919g = onClickListener;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22918f = view.findViewById(i.bg_ad_card_gift);
            this.f22914b = (TbImageView) view.findViewById(i.img_ad_card_gift_logo);
            this.a = (TextView) view.findViewById(i.txt_ad_card_gift_rate);
            this.f22915c = (TextView) view.findViewById(i.btn_ad_card_gift_get);
            this.f22916d = (ProgressBar) view.findViewById(i.progress_ad_card_gift);
            this.f22917e = (TextView) view.findViewById(i.txt_ad_card_gift_title);
            this.f22914b.setRadius(n.f(getView().getContext(), g.tbds20));
            this.f22914b.setConrers(5);
            this.f22914b.setDefaultBgResource(c.a.t0.t2.f.cp_atp_a);
            this.f22914b.setDrawCorner(true);
            this.f22915c.setOnClickListener(new View$OnClickListenerC1408a(this));
            this.f22916d.setMax(100);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.t0.t2.y.c) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = new View$OnClickListenerC1407a(this);
        this.s = new c.a.t0.t2.u.f.b1.b(pbFragment);
    }

    @Override // c.a.t0.t2.u.f.o, c.a.d.n.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        j0(i2, view, viewGroup, (c.a.t0.t2.r.a) obj, (b) viewHolder);
        return view;
    }

    public final void g0(c.a.t0.t2.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            c.a.t0.w3.c.g().c(this.n.getUniqueId(), c.a.t0.w3.a.e(this.u.O(), "a005", "common_click", 1, aVar.f22669f, true, aVar.f22668e.a + "", null, 18));
        }
    }

    public final void h0(c.a.t0.t2.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            String str = aVar.f22668e.a + "";
            c.a.t0.w3.c.g().d(this.n.getUniqueId(), c.a.t0.w3.a.c(this.u.O().w1(), str, "", null), c.a.t0.w3.a.g(this.u.O(), "a005", "common_exp", aVar.f22669f, true, str, "", 18));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: i0 */
    public b M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            b bVar = new b(LayoutInflater.from(this.f3360e).inflate(j.pb_ad_card_gift_item, viewGroup, false), null);
            bVar.setOnClickListener(this.v);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public View j0(int i2, View view, ViewGroup viewGroup, c.a.t0.t2.r.a aVar, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, bVar})) == null) {
            super.S(i2, view, viewGroup, aVar, bVar);
            if (aVar != null && bVar != null) {
                aVar.f22669f = i2 + 1;
                this.t = aVar;
                h0(aVar);
                bVar.c(this.f3360e, aVar.f22668e);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void onDestroy() {
        c.a.t0.t2.u.f.b1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bVar = this.s) == null) {
            return;
        }
        bVar.q();
    }

    public void t(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.u = fVar;
            c.a.t0.t2.u.f.b1.b bVar = this.s;
            if (bVar != null) {
                bVar.v(fVar);
            }
        }
    }
}
