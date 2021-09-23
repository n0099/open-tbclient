package c.a.r0.j2.k.e.z0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.q0.d1.p;
import c.a.r0.j2.h.e;
import c.a.r0.j2.k.e.n;
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
public class a extends n<c.a.r0.j2.h.a, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.j2.k.e.z0.b s;
    public c.a.r0.j2.h.a t;
    public e u;
    public View.OnClickListener v;

    /* renamed from: c.a.r0.j2.k.e.z0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0962a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20374e;

        public View$OnClickListenerC0962a(a aVar) {
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
            this.f20374e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20374e.t == null || this.f20374e.t.f19612e == null || p.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(this.f20374e.n.getPageContext().getPageActivity());
                return;
            }
            a aVar = this.f20374e;
            aVar.o0(aVar.t);
            if (this.f20374e.t.f19612e.b()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f20374e.n.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            } else if (this.f20374e.t.f19612e.a()) {
                this.f20374e.s.u(this.f20374e.t);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f20375a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f20376b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f20377c;

        /* renamed from: d  reason: collision with root package name */
        public ProgressBar f20378d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f20379e;

        /* renamed from: f  reason: collision with root package name */
        public View f20380f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f20381g;

        /* renamed from: c.a.r0.j2.k.e.z0.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0963a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f20382e;

            public View$OnClickListenerC0963a(b bVar) {
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
                this.f20382e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20382e.f20381g == null) {
                    return;
                }
                this.f20382e.f20381g.onClick(view);
            }
        }

        public /* synthetic */ b(View view, View$OnClickListenerC0962a view$OnClickListenerC0962a) {
            this(view);
        }

        public final void c(Context context, c.a.r0.j2.h.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, bVar) == null) || bVar == null) {
                return;
            }
            this.f20379e.setText(bVar.f19616c);
            this.f20376b.startLoad(bVar.f19615b, 38, false);
            this.f20375a.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.f19617d) + "%");
            int e2 = c.a.e.e.m.b.e(bVar.f19617d, 0);
            if (e2 > 100) {
                e2 = 100;
            } else if (e2 < 0) {
                e2 = 0;
            }
            this.f20378d.setProgress(e2);
            if (bVar.a()) {
                this.f20377c.setText(R.string.pb_ad_card_gift_get);
                SkinManager.setViewTextColor(this.f20377c, R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f20377c, R.drawable.btn_pb_ad_card_gift_get);
                this.f20377c.setClickable(true);
            } else if (bVar.b()) {
                this.f20377c.setText(R.string.pb_ad_card_gift_watch_btn);
                SkinManager.setViewTextColor(this.f20377c, R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f20377c, R.drawable.btn_pb_ad_card_gift_watch);
                this.f20377c.setClickable(true);
            } else {
                this.f20377c.setText(R.string.pb_ad_card_gift_over_btn);
                SkinManager.setViewTextColor(this.f20377c, R.color.CAM_X0109);
                this.f20377c.setBackgroundResource(R.drawable.transparent_bg);
                this.f20377c.setClickable(false);
            }
            onChangeSkinType();
        }

        public final void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundResource(this.f20380f, R.drawable.bg_pb_ad_card_gift);
                SkinManager.setViewTextColor(this.f20379e, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f20375a, R.color.CAM_X0107);
                this.f20378d.setProgressDrawable(SkinManager.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
            }
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
                this.f20381g = onClickListener;
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
            this.f20380f = view.findViewById(R.id.bg_ad_card_gift);
            this.f20376b = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.f20375a = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.f20377c = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.f20378d = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.f20379e = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.f20376b.setRadius(l.g(getView().getContext(), R.dimen.tbds20));
            this.f20376b.setConrers(5);
            this.f20376b.setDefaultBgResource(R.color.cp_atp_a);
            this.f20376b.setDrawCorner(true);
            this.f20377c.setOnClickListener(new View$OnClickListenerC0963a(this));
            this.f20378d.setMax(100);
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
                super((c.a.r0.j2.o.b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = new View$OnClickListenerC0962a(this);
        this.s = new c.a.r0.j2.k.e.z0.b(pbFragment);
    }

    @Override // c.a.r0.j2.k.e.n, c.a.e.l.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        r0(i2, view, viewGroup, (c.a.r0.j2.h.a) obj, (b) viewHolder);
        return view;
    }

    public final void o0(c.a.r0.j2.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            c.a.r0.i3.c.g().c(this.n.getUniqueId(), c.a.r0.i3.a.e(this.u.O(), "a005", "common_click", 1, aVar.f19613f, true, aVar.f19612e.f19614a + "", null, 18));
        }
    }

    public void onDestroy() {
        c.a.r0.j2.k.e.z0.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.s) == null) {
            return;
        }
        bVar.q();
    }

    public final void p0(c.a.r0.j2.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            String str = aVar.f19612e.f19614a + "";
            c.a.r0.i3.c.g().d(this.n.getUniqueId(), c.a.r0.i3.a.c(this.u.O().s1(), str, "", null), c.a.r0.i3.a.g(this.u.O(), "a005", "common_exp", aVar.f19613f, true, str, "", 18));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: q0 */
    public b U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            b bVar = new b(LayoutInflater.from(this.f2958e).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false), null);
            bVar.setOnClickListener(this.v);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public View r0(int i2, View view, ViewGroup viewGroup, c.a.r0.j2.h.a aVar, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, bVar})) == null) {
            super.a0(i2, view, viewGroup, aVar, bVar);
            if (aVar != null && bVar != null) {
                aVar.f19613f = i2 + 1;
                this.t = aVar;
                p0(aVar);
                bVar.c(this.f2958e, aVar.f19612e);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void t(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.u = eVar;
            c.a.r0.j2.k.e.z0.b bVar = this.s;
            if (bVar != null) {
                bVar.v(eVar);
            }
        }
    }
}
