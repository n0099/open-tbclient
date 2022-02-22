package c.a.u0.u2.u.f.b1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.t0.d1.q;
import c.a.u0.u2.g;
import c.a.u0.u2.h;
import c.a.u0.u2.i;
import c.a.u0.u2.j;
import c.a.u0.u2.l;
import c.a.u0.u2.r.f;
import c.a.u0.u2.u.f.o;
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
/* loaded from: classes9.dex */
public class a extends o<c.a.u0.u2.r.a, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.u0.u2.u.f.b1.b s;
    public c.a.u0.u2.r.a t;
    public f u;
    public View.OnClickListener v;

    /* renamed from: c.a.u0.u2.u.f.b1.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1430a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23411e;

        public View$OnClickListenerC1430a(a aVar) {
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
            this.f23411e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23411e.t == null || this.f23411e.t.f23166e == null || q.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(this.f23411e.n.getPageContext().getPageActivity());
                return;
            }
            a aVar = this.f23411e;
            aVar.g0(aVar.t);
            if (this.f23411e.t.f23166e.b()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f23411e.n.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            } else if (this.f23411e.t.f23166e.a()) {
                this.f23411e.s.u(this.f23411e.t);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f23412b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f23413c;

        /* renamed from: d  reason: collision with root package name */
        public ProgressBar f23414d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f23415e;

        /* renamed from: f  reason: collision with root package name */
        public View f23416f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f23417g;

        /* renamed from: c.a.u0.u2.u.f.b1.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class View$OnClickListenerC1431a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f23418e;

            public View$OnClickListenerC1431a(b bVar) {
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
                this.f23418e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23418e.f23417g == null) {
                    return;
                }
                this.f23418e.f23417g.onClick(view);
            }
        }

        public /* synthetic */ b(View view, View$OnClickListenerC1430a view$OnClickListenerC1430a) {
            this(view);
        }

        public final void c(Context context, c.a.u0.u2.r.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, bVar) == null) || bVar == null) {
                return;
            }
            this.f23415e.setText(bVar.f23169c);
            this.f23412b.startLoad(bVar.f23168b, 38, false);
            this.a.setText(context.getResources().getString(l.pb_ad_card_gift_rate, bVar.f23170d) + "%");
            int e2 = c.a.d.f.m.b.e(bVar.f23170d, 0);
            if (e2 > 100) {
                e2 = 100;
            } else if (e2 < 0) {
                e2 = 0;
            }
            this.f23414d.setProgress(e2);
            if (bVar.a()) {
                this.f23413c.setText(l.pb_ad_card_gift_get);
                SkinManager.setViewTextColor(this.f23413c, c.a.u0.u2.f.CAM_X0101);
                SkinManager.setBackgroundResource(this.f23413c, h.btn_pb_ad_card_gift_get);
                this.f23413c.setClickable(true);
            } else if (bVar.b()) {
                this.f23413c.setText(l.pb_ad_card_gift_watch_btn);
                SkinManager.setViewTextColor(this.f23413c, c.a.u0.u2.f.CAM_X0101);
                SkinManager.setBackgroundResource(this.f23413c, h.btn_pb_ad_card_gift_watch);
                this.f23413c.setClickable(true);
            } else {
                this.f23413c.setText(l.pb_ad_card_gift_over_btn);
                SkinManager.setViewTextColor(this.f23413c, c.a.u0.u2.f.CAM_X0109);
                this.f23413c.setBackgroundResource(h.transparent_bg);
                this.f23413c.setClickable(false);
            }
            onChangeSkinType();
        }

        public final void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundResource(this.f23416f, h.bg_pb_ad_card_gift);
                SkinManager.setViewTextColor(this.f23415e, c.a.u0.u2.f.CAM_X0105);
                SkinManager.setViewTextColor(this.a, c.a.u0.u2.f.CAM_X0107);
                this.f23414d.setProgressDrawable(SkinManager.getDrawable(h.bg_pb_ad_card_gift_progress));
            }
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
                this.f23417g = onClickListener;
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
            this.f23416f = view.findViewById(i.bg_ad_card_gift);
            this.f23412b = (TbImageView) view.findViewById(i.img_ad_card_gift_logo);
            this.a = (TextView) view.findViewById(i.txt_ad_card_gift_rate);
            this.f23413c = (TextView) view.findViewById(i.btn_ad_card_gift_get);
            this.f23414d = (ProgressBar) view.findViewById(i.progress_ad_card_gift);
            this.f23415e = (TextView) view.findViewById(i.txt_ad_card_gift_title);
            this.f23412b.setRadius(n.f(getView().getContext(), g.tbds20));
            this.f23412b.setConrers(5);
            this.f23412b.setDefaultBgResource(c.a.u0.u2.f.cp_atp_a);
            this.f23412b.setDrawCorner(true);
            this.f23413c.setOnClickListener(new View$OnClickListenerC1431a(this));
            this.f23414d.setMax(100);
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
                super((c.a.u0.u2.y.c) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = new View$OnClickListenerC1430a(this);
        this.s = new c.a.u0.u2.u.f.b1.b(pbFragment);
    }

    @Override // c.a.u0.u2.u.f.o, c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        j0(i2, view, viewGroup, (c.a.u0.u2.r.a) obj, (b) viewHolder);
        return view;
    }

    public final void g0(c.a.u0.u2.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            c.a.u0.y3.c.g().c(this.n.getUniqueId(), c.a.u0.y3.a.e(this.u.O(), "a005", "common_click", 1, aVar.f23167f, true, aVar.f23166e.a + "", null, 18));
        }
    }

    public final void h0(c.a.u0.u2.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            String str = aVar.f23166e.a + "";
            c.a.u0.y3.c.g().d(this.n.getUniqueId(), c.a.u0.y3.a.c(this.u.O().w1(), str, "", null), c.a.u0.y3.a.g(this.u.O(), "a005", "common_exp", aVar.f23167f, true, str, "", 18));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: i0 */
    public b M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            b bVar = new b(LayoutInflater.from(this.f2447e).inflate(j.pb_ad_card_gift_item, viewGroup, false), null);
            bVar.setOnClickListener(this.v);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public View j0(int i2, View view, ViewGroup viewGroup, c.a.u0.u2.r.a aVar, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, bVar})) == null) {
            super.S(i2, view, viewGroup, aVar, bVar);
            if (aVar != null && bVar != null) {
                aVar.f23167f = i2 + 1;
                this.t = aVar;
                h0(aVar);
                bVar.c(this.f2447e, aVar.f23166e);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void onDestroy() {
        c.a.u0.u2.u.f.b1.b bVar;
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
            c.a.u0.u2.u.f.b1.b bVar = this.s;
            if (bVar != null) {
                bVar.v(fVar);
            }
        }
    }
}
