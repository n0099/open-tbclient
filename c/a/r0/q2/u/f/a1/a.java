package c.a.r0.q2.u.f.a1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.a.q0.d1.o;
import c.a.r0.q2.g;
import c.a.r0.q2.h;
import c.a.r0.q2.i;
import c.a.r0.q2.j;
import c.a.r0.q2.l;
import c.a.r0.q2.r.f;
import c.a.r0.q2.u.f.n;
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
/* loaded from: classes6.dex */
public class a extends n<c.a.r0.q2.r.a, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.q2.u.f.a1.b s;
    public c.a.r0.q2.r.a t;
    public f u;
    public View.OnClickListener v;

    /* renamed from: c.a.r0.q2.u.f.a1.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC1271a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21738e;

        public View$OnClickListenerC1271a(a aVar) {
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
            this.f21738e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21738e.t == null || this.f21738e.t.f21504e == null || o.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(this.f21738e.n.getPageContext().getPageActivity());
                return;
            }
            a aVar = this.f21738e;
            aVar.n0(aVar.t);
            if (this.f21738e.t.f21504e.b()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f21738e.n.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            } else if (this.f21738e.t.f21504e.a()) {
                this.f21738e.s.u(this.f21738e.t);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f21739b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f21740c;

        /* renamed from: d  reason: collision with root package name */
        public ProgressBar f21741d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f21742e;

        /* renamed from: f  reason: collision with root package name */
        public View f21743f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f21744g;

        /* renamed from: c.a.r0.q2.u.f.a1.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC1272a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f21745e;

            public View$OnClickListenerC1272a(b bVar) {
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
                this.f21745e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21745e.f21744g == null) {
                    return;
                }
                this.f21745e.f21744g.onClick(view);
            }
        }

        public /* synthetic */ b(View view, View$OnClickListenerC1271a view$OnClickListenerC1271a) {
            this(view);
        }

        public final void c(Context context, c.a.r0.q2.r.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, bVar) == null) || bVar == null) {
                return;
            }
            this.f21742e.setText(bVar.f21507c);
            this.f21739b.startLoad(bVar.f21506b, 38, false);
            this.a.setText(context.getResources().getString(l.pb_ad_card_gift_rate, bVar.f21508d) + "%");
            int e2 = c.a.d.f.m.b.e(bVar.f21508d, 0);
            if (e2 > 100) {
                e2 = 100;
            } else if (e2 < 0) {
                e2 = 0;
            }
            this.f21741d.setProgress(e2);
            if (bVar.a()) {
                this.f21740c.setText(l.pb_ad_card_gift_get);
                SkinManager.setViewTextColor(this.f21740c, c.a.r0.q2.f.CAM_X0101);
                SkinManager.setBackgroundResource(this.f21740c, h.btn_pb_ad_card_gift_get);
                this.f21740c.setClickable(true);
            } else if (bVar.b()) {
                this.f21740c.setText(l.pb_ad_card_gift_watch_btn);
                SkinManager.setViewTextColor(this.f21740c, c.a.r0.q2.f.CAM_X0101);
                SkinManager.setBackgroundResource(this.f21740c, h.btn_pb_ad_card_gift_watch);
                this.f21740c.setClickable(true);
            } else {
                this.f21740c.setText(l.pb_ad_card_gift_over_btn);
                SkinManager.setViewTextColor(this.f21740c, c.a.r0.q2.f.CAM_X0109);
                this.f21740c.setBackgroundResource(h.transparent_bg);
                this.f21740c.setClickable(false);
            }
            onChangeSkinType();
        }

        public final void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundResource(this.f21743f, h.bg_pb_ad_card_gift);
                SkinManager.setViewTextColor(this.f21742e, c.a.r0.q2.f.CAM_X0105);
                SkinManager.setViewTextColor(this.a, c.a.r0.q2.f.CAM_X0107);
                this.f21741d.setProgressDrawable(SkinManager.getDrawable(h.bg_pb_ad_card_gift_progress));
            }
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
                this.f21744g = onClickListener;
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
            this.f21743f = view.findViewById(i.bg_ad_card_gift);
            this.f21739b = (TbImageView) view.findViewById(i.img_ad_card_gift_logo);
            this.a = (TextView) view.findViewById(i.txt_ad_card_gift_rate);
            this.f21740c = (TextView) view.findViewById(i.btn_ad_card_gift_get);
            this.f21741d = (ProgressBar) view.findViewById(i.progress_ad_card_gift);
            this.f21742e = (TextView) view.findViewById(i.txt_ad_card_gift_title);
            this.f21739b.setRadius(c.a.d.f.p.l.f(getView().getContext(), g.tbds20));
            this.f21739b.setConrers(5);
            this.f21739b.setDefaultBgResource(c.a.r0.q2.f.cp_atp_a);
            this.f21739b.setDrawCorner(true);
            this.f21740c.setOnClickListener(new View$OnClickListenerC1272a(this));
            this.f21741d.setMax(100);
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
                super((c.a.r0.q2.y.b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = new View$OnClickListenerC1271a(this);
        this.s = new c.a.r0.q2.u.f.a1.b(pbFragment);
    }

    @Override // c.a.r0.q2.u.f.n, c.a.d.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        q0(i2, view, viewGroup, (c.a.r0.q2.r.a) obj, (b) viewHolder);
        return view;
    }

    public final void n0(c.a.r0.q2.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            c.a.r0.s3.c.g().c(this.n.getUniqueId(), c.a.r0.s3.a.e(this.u.O(), "a005", "common_click", 1, aVar.f21505f, true, aVar.f21504e.a + "", null, 18));
        }
    }

    public final void o0(c.a.r0.q2.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            String str = aVar.f21504e.a + "";
            c.a.r0.s3.c.g().d(this.n.getUniqueId(), c.a.r0.s3.a.c(this.u.O().v1(), str, "", null), c.a.r0.s3.a.g(this.u.O(), "a005", "common_exp", aVar.f21505f, true, str, "", 18));
        }
    }

    public void onDestroy() {
        c.a.r0.q2.u.f.a1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.s) == null) {
            return;
        }
        bVar.q();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: p0 */
    public b S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            b bVar = new b(LayoutInflater.from(this.f2907e).inflate(j.pb_ad_card_gift_item, viewGroup, false), null);
            bVar.setOnClickListener(this.v);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public View q0(int i2, View view, ViewGroup viewGroup, c.a.r0.q2.r.a aVar, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, bVar})) == null) {
            super.Z(i2, view, viewGroup, aVar, bVar);
            if (aVar != null && bVar != null) {
                aVar.f21505f = i2 + 1;
                this.t = aVar;
                o0(aVar);
                bVar.c(this.f2907e, aVar.f21504e);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void t(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.u = fVar;
            c.a.r0.q2.u.f.a1.b bVar = this.s;
            if (bVar != null) {
                bVar.v(fVar);
            }
        }
    }
}
