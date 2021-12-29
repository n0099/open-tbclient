package c.a.t0.s2.u.f.a1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.a.s0.e1.q;
import c.a.t0.s2.g;
import c.a.t0.s2.h;
import c.a.t0.s2.i;
import c.a.t0.s2.j;
import c.a.t0.s2.l;
import c.a.t0.s2.r.f;
import c.a.t0.s2.u.f.n;
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
public class a extends n<c.a.t0.s2.r.a, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.t0.s2.u.f.a1.b s;
    public c.a.t0.s2.r.a t;
    public f u;
    public View.OnClickListener v;

    /* renamed from: c.a.t0.s2.u.f.a1.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1380a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23256e;

        public View$OnClickListenerC1380a(a aVar) {
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
            this.f23256e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23256e.t == null || this.f23256e.t.f23022e == null || q.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(this.f23256e.n.getPageContext().getPageActivity());
                return;
            }
            a aVar = this.f23256e;
            aVar.g0(aVar.t);
            if (this.f23256e.t.f23022e.b()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f23256e.n.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            } else if (this.f23256e.t.f23022e.a()) {
                this.f23256e.s.u(this.f23256e.t);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f23257b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f23258c;

        /* renamed from: d  reason: collision with root package name */
        public ProgressBar f23259d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f23260e;

        /* renamed from: f  reason: collision with root package name */
        public View f23261f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f23262g;

        /* renamed from: c.a.t0.s2.u.f.a1.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC1381a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f23263e;

            public View$OnClickListenerC1381a(b bVar) {
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
                this.f23263e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23263e.f23262g == null) {
                    return;
                }
                this.f23263e.f23262g.onClick(view);
            }
        }

        public /* synthetic */ b(View view, View$OnClickListenerC1380a view$OnClickListenerC1380a) {
            this(view);
        }

        public final void c(Context context, c.a.t0.s2.r.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, bVar) == null) || bVar == null) {
                return;
            }
            this.f23260e.setText(bVar.f23025c);
            this.f23257b.startLoad(bVar.f23024b, 38, false);
            this.a.setText(context.getResources().getString(l.pb_ad_card_gift_rate, bVar.f23026d) + "%");
            int e2 = c.a.d.f.m.b.e(bVar.f23026d, 0);
            if (e2 > 100) {
                e2 = 100;
            } else if (e2 < 0) {
                e2 = 0;
            }
            this.f23259d.setProgress(e2);
            if (bVar.a()) {
                this.f23258c.setText(l.pb_ad_card_gift_get);
                SkinManager.setViewTextColor(this.f23258c, c.a.t0.s2.f.CAM_X0101);
                SkinManager.setBackgroundResource(this.f23258c, h.btn_pb_ad_card_gift_get);
                this.f23258c.setClickable(true);
            } else if (bVar.b()) {
                this.f23258c.setText(l.pb_ad_card_gift_watch_btn);
                SkinManager.setViewTextColor(this.f23258c, c.a.t0.s2.f.CAM_X0101);
                SkinManager.setBackgroundResource(this.f23258c, h.btn_pb_ad_card_gift_watch);
                this.f23258c.setClickable(true);
            } else {
                this.f23258c.setText(l.pb_ad_card_gift_over_btn);
                SkinManager.setViewTextColor(this.f23258c, c.a.t0.s2.f.CAM_X0109);
                this.f23258c.setBackgroundResource(h.transparent_bg);
                this.f23258c.setClickable(false);
            }
            onChangeSkinType();
        }

        public final void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundResource(this.f23261f, h.bg_pb_ad_card_gift);
                SkinManager.setViewTextColor(this.f23260e, c.a.t0.s2.f.CAM_X0105);
                SkinManager.setViewTextColor(this.a, c.a.t0.s2.f.CAM_X0107);
                this.f23259d.setProgressDrawable(SkinManager.getDrawable(h.bg_pb_ad_card_gift_progress));
            }
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
                this.f23262g = onClickListener;
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
            this.f23261f = view.findViewById(i.bg_ad_card_gift);
            this.f23257b = (TbImageView) view.findViewById(i.img_ad_card_gift_logo);
            this.a = (TextView) view.findViewById(i.txt_ad_card_gift_rate);
            this.f23258c = (TextView) view.findViewById(i.btn_ad_card_gift_get);
            this.f23259d = (ProgressBar) view.findViewById(i.progress_ad_card_gift);
            this.f23260e = (TextView) view.findViewById(i.txt_ad_card_gift_title);
            this.f23257b.setRadius(c.a.d.f.p.n.f(getView().getContext(), g.tbds20));
            this.f23257b.setConrers(5);
            this.f23257b.setDefaultBgResource(c.a.t0.s2.f.cp_atp_a);
            this.f23257b.setDrawCorner(true);
            this.f23258c.setOnClickListener(new View$OnClickListenerC1381a(this));
            this.f23259d.setMax(100);
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
                super((c.a.t0.s2.y.b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = new View$OnClickListenerC1380a(this);
        this.s = new c.a.t0.s2.u.f.a1.b(pbFragment);
    }

    @Override // c.a.t0.s2.u.f.n, c.a.d.n.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        j0(i2, view, viewGroup, (c.a.t0.s2.r.a) obj, (b) viewHolder);
        return view;
    }

    public final void g0(c.a.t0.s2.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            c.a.t0.v3.c.g().c(this.n.getUniqueId(), c.a.t0.v3.a.e(this.u.O(), "a005", "common_click", 1, aVar.f23023f, true, aVar.f23022e.a + "", null, 18));
        }
    }

    public final void h0(c.a.t0.s2.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            String str = aVar.f23022e.a + "";
            c.a.t0.v3.c.g().d(this.n.getUniqueId(), c.a.t0.v3.a.c(this.u.O().v1(), str, "", null), c.a.t0.v3.a.g(this.u.O(), "a005", "common_exp", aVar.f23023f, true, str, "", 18));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: i0 */
    public b M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            b bVar = new b(LayoutInflater.from(this.f3299e).inflate(j.pb_ad_card_gift_item, viewGroup, false), null);
            bVar.setOnClickListener(this.v);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public View j0(int i2, View view, ViewGroup viewGroup, c.a.t0.s2.r.a aVar, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, bVar})) == null) {
            super.S(i2, view, viewGroup, aVar, bVar);
            if (aVar != null && bVar != null) {
                aVar.f23023f = i2 + 1;
                this.t = aVar;
                h0(aVar);
                bVar.c(this.f3299e, aVar.f23022e);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void onDestroy() {
        c.a.t0.s2.u.f.a1.b bVar;
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
            c.a.t0.s2.u.f.a1.b bVar = this.s;
            if (bVar != null) {
                bVar.v(fVar);
            }
        }
    }
}
