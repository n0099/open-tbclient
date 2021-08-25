package c.a.q0.i2.k.e.x0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.a.p0.b1.l;
import c.a.q0.i2.h.e;
import c.a.q0.i2.k.e.m;
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
public class a extends m<c.a.q0.i2.h.a, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.q0.i2.k.e.x0.b s;
    public c.a.q0.i2.h.a t;
    public e u;
    public View.OnClickListener v;

    /* renamed from: c.a.q0.i2.k.e.x0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0926a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19653e;

        public View$OnClickListenerC0926a(a aVar) {
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
            this.f19653e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19653e.t == null || this.f19653e.t.f19048e == null || l.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(this.f19653e.n.getPageContext().getPageActivity());
                return;
            }
            a aVar = this.f19653e;
            aVar.o0(aVar.t);
            if (this.f19653e.t.f19048e.b()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f19653e.n.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            } else if (this.f19653e.t.f19048e.a()) {
                this.f19653e.s.u(this.f19653e.t);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f19654a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f19655b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19656c;

        /* renamed from: d  reason: collision with root package name */
        public ProgressBar f19657d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f19658e;

        /* renamed from: f  reason: collision with root package name */
        public View f19659f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f19660g;

        /* renamed from: c.a.q0.i2.k.e.x0.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0927a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19661e;

            public View$OnClickListenerC0927a(b bVar) {
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
                this.f19661e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19661e.f19660g == null) {
                    return;
                }
                this.f19661e.f19660g.onClick(view);
            }
        }

        public /* synthetic */ b(View view, View$OnClickListenerC0926a view$OnClickListenerC0926a) {
            this(view);
        }

        public final void c(Context context, c.a.q0.i2.h.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, bVar) == null) || bVar == null) {
                return;
            }
            this.f19658e.setText(bVar.f19052c);
            this.f19655b.startLoad(bVar.f19051b, 38, false);
            this.f19654a.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.f19053d) + "%");
            int d2 = c.a.e.e.m.b.d(bVar.f19053d, 0);
            if (d2 > 100) {
                d2 = 100;
            } else if (d2 < 0) {
                d2 = 0;
            }
            this.f19657d.setProgress(d2);
            if (bVar.a()) {
                this.f19656c.setText(R.string.pb_ad_card_gift_get);
                SkinManager.setViewTextColor(this.f19656c, R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f19656c, R.drawable.btn_pb_ad_card_gift_get);
                this.f19656c.setClickable(true);
            } else if (bVar.b()) {
                this.f19656c.setText(R.string.pb_ad_card_gift_watch_btn);
                SkinManager.setViewTextColor(this.f19656c, R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f19656c, R.drawable.btn_pb_ad_card_gift_watch);
                this.f19656c.setClickable(true);
            } else {
                this.f19656c.setText(R.string.pb_ad_card_gift_over_btn);
                SkinManager.setViewTextColor(this.f19656c, R.color.CAM_X0109);
                this.f19656c.setBackgroundResource(R.drawable.transparent_bg);
                this.f19656c.setClickable(false);
            }
            onChangeSkinType();
        }

        public final void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundResource(this.f19659f, R.drawable.bg_pb_ad_card_gift);
                SkinManager.setViewTextColor(this.f19658e, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f19654a, R.color.CAM_X0107);
                this.f19657d.setProgressDrawable(SkinManager.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
            }
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
                this.f19660g = onClickListener;
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
            this.f19659f = view.findViewById(R.id.bg_ad_card_gift);
            this.f19655b = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.f19654a = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.f19656c = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.f19657d = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.f19658e = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.f19655b.setRadius(c.a.e.e.p.l.g(getView().getContext(), R.dimen.tbds20));
            this.f19655b.setConrers(5);
            this.f19655b.setDefaultBgResource(R.color.cp_atp_a);
            this.f19655b.setDrawCorner(true);
            this.f19656c.setOnClickListener(new View$OnClickListenerC0927a(this));
            this.f19657d.setMax(100);
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
                super((c.a.q0.i2.o.b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = new View$OnClickListenerC0926a(this);
        this.s = new c.a.q0.i2.k.e.x0.b(pbFragment);
    }

    @Override // c.a.q0.i2.k.e.m, c.a.e.l.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        r0(i2, view, viewGroup, (c.a.q0.i2.h.a) obj, (b) viewHolder);
        return view;
    }

    public final void o0(c.a.q0.i2.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            c.a.q0.h3.c.g().c(this.n.getUniqueId(), c.a.q0.h3.a.e(this.u.O(), "a005", "common_click", 1, aVar.f19049f, true, aVar.f19048e.f19050a + "", null, 18));
        }
    }

    public void onDestroy() {
        c.a.q0.i2.k.e.x0.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.s) == null) {
            return;
        }
        bVar.q();
    }

    public final void p0(c.a.q0.i2.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            String str = aVar.f19048e.f19050a + "";
            c.a.q0.h3.c.g().d(this.n.getUniqueId(), c.a.q0.h3.a.c(this.u.O().q1(), str, "", null), c.a.q0.h3.a.g(this.u.O(), "a005", "common_exp", aVar.f19049f, true, str, "", 18));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: q0 */
    public b U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            b bVar = new b(LayoutInflater.from(this.f2966e).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false), null);
            bVar.setOnClickListener(this.v);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public View r0(int i2, View view, ViewGroup viewGroup, c.a.q0.i2.h.a aVar, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, bVar})) == null) {
            super.a0(i2, view, viewGroup, aVar, bVar);
            if (aVar != null && bVar != null) {
                aVar.f19049f = i2 + 1;
                this.t = aVar;
                p0(aVar);
                bVar.c(this.f2966e, aVar.f19048e);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void t(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.u = eVar;
            c.a.q0.i2.k.e.x0.b bVar = this.s;
            if (bVar != null) {
                bVar.v(eVar);
            }
        }
    }
}
