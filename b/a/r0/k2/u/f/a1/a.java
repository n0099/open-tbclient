package b.a.r0.k2.u.f.a1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import b.a.q0.c1.o;
import b.a.r0.k2.g;
import b.a.r0.k2.h;
import b.a.r0.k2.i;
import b.a.r0.k2.j;
import b.a.r0.k2.l;
import b.a.r0.k2.r.f;
import b.a.r0.k2.u.f.n;
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
/* loaded from: classes5.dex */
public class a extends n<b.a.r0.k2.r.a, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.r0.k2.u.f.a1.b s;
    public b.a.r0.k2.r.a t;
    public f u;
    public View.OnClickListener v;

    /* renamed from: b.a.r0.k2.u.f.a1.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1024a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20523e;

        public View$OnClickListenerC1024a(a aVar) {
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
            this.f20523e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20523e.t == null || this.f20523e.t.f20279e == null || o.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(this.f20523e.n.getPageContext().getPageActivity());
                return;
            }
            a aVar = this.f20523e;
            aVar.n0(aVar.t);
            if (this.f20523e.t.f20279e.b()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f20523e.n.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            } else if (this.f20523e.t.f20279e.a()) {
                this.f20523e.s.u(this.f20523e.t);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f20524a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f20525b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f20526c;

        /* renamed from: d  reason: collision with root package name */
        public ProgressBar f20527d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f20528e;

        /* renamed from: f  reason: collision with root package name */
        public View f20529f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f20530g;

        /* renamed from: b.a.r0.k2.u.f.a1.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1025a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f20531e;

            public View$OnClickListenerC1025a(b bVar) {
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
                this.f20531e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20531e.f20530g == null) {
                    return;
                }
                this.f20531e.f20530g.onClick(view);
            }
        }

        public /* synthetic */ b(View view, View$OnClickListenerC1024a view$OnClickListenerC1024a) {
            this(view);
        }

        public final void c(Context context, b.a.r0.k2.r.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, bVar) == null) || bVar == null) {
                return;
            }
            this.f20528e.setText(bVar.f20283c);
            this.f20525b.startLoad(bVar.f20282b, 38, false);
            this.f20524a.setText(context.getResources().getString(l.pb_ad_card_gift_rate, bVar.f20284d) + "%");
            int e2 = b.a.e.f.m.b.e(bVar.f20284d, 0);
            if (e2 > 100) {
                e2 = 100;
            } else if (e2 < 0) {
                e2 = 0;
            }
            this.f20527d.setProgress(e2);
            if (bVar.a()) {
                this.f20526c.setText(l.pb_ad_card_gift_get);
                SkinManager.setViewTextColor(this.f20526c, b.a.r0.k2.f.CAM_X0101);
                SkinManager.setBackgroundResource(this.f20526c, h.btn_pb_ad_card_gift_get);
                this.f20526c.setClickable(true);
            } else if (bVar.b()) {
                this.f20526c.setText(l.pb_ad_card_gift_watch_btn);
                SkinManager.setViewTextColor(this.f20526c, b.a.r0.k2.f.CAM_X0101);
                SkinManager.setBackgroundResource(this.f20526c, h.btn_pb_ad_card_gift_watch);
                this.f20526c.setClickable(true);
            } else {
                this.f20526c.setText(l.pb_ad_card_gift_over_btn);
                SkinManager.setViewTextColor(this.f20526c, b.a.r0.k2.f.CAM_X0109);
                this.f20526c.setBackgroundResource(h.transparent_bg);
                this.f20526c.setClickable(false);
            }
            onChangeSkinType();
        }

        public final void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundResource(this.f20529f, h.bg_pb_ad_card_gift);
                SkinManager.setViewTextColor(this.f20528e, b.a.r0.k2.f.CAM_X0105);
                SkinManager.setViewTextColor(this.f20524a, b.a.r0.k2.f.CAM_X0107);
                this.f20527d.setProgressDrawable(SkinManager.getDrawable(h.bg_pb_ad_card_gift_progress));
            }
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
                this.f20530g = onClickListener;
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
            this.f20529f = view.findViewById(i.bg_ad_card_gift);
            this.f20525b = (TbImageView) view.findViewById(i.img_ad_card_gift_logo);
            this.f20524a = (TextView) view.findViewById(i.txt_ad_card_gift_rate);
            this.f20526c = (TextView) view.findViewById(i.btn_ad_card_gift_get);
            this.f20527d = (ProgressBar) view.findViewById(i.progress_ad_card_gift);
            this.f20528e = (TextView) view.findViewById(i.txt_ad_card_gift_title);
            this.f20525b.setRadius(b.a.e.f.p.l.g(getView().getContext(), g.tbds20));
            this.f20525b.setConrers(5);
            this.f20525b.setDefaultBgResource(b.a.r0.k2.f.cp_atp_a);
            this.f20525b.setDrawCorner(true);
            this.f20526c.setOnClickListener(new View$OnClickListenerC1025a(this));
            this.f20527d.setMax(100);
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
                super((b.a.r0.k2.y.b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = new View$OnClickListenerC1024a(this);
        this.s = new b.a.r0.k2.u.f.a1.b(pbFragment);
    }

    @Override // b.a.r0.k2.u.f.n, b.a.e.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        q0(i2, view, viewGroup, (b.a.r0.k2.r.a) obj, (b) viewHolder);
        return view;
    }

    public final void n0(b.a.r0.k2.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            b.a.r0.l3.c.g().c(this.n.getUniqueId(), b.a.r0.l3.a.e(this.u.O(), "a005", "common_click", 1, aVar.f20280f, true, aVar.f20279e.f20281a + "", null, 18));
        }
    }

    public final void o0(b.a.r0.k2.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            String str = aVar.f20279e.f20281a + "";
            b.a.r0.l3.c.g().d(this.n.getUniqueId(), b.a.r0.l3.a.c(this.u.O().t1(), str, "", null), b.a.r0.l3.a.g(this.u.O(), "a005", "common_exp", aVar.f20280f, true, str, "", 18));
        }
    }

    public void onDestroy() {
        b.a.r0.k2.u.f.a1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.s) == null) {
            return;
        }
        bVar.q();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: p0 */
    public b T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            b bVar = new b(LayoutInflater.from(this.f2421e).inflate(j.pb_ad_card_gift_item, viewGroup, false), null);
            bVar.setOnClickListener(this.v);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public View q0(int i2, View view, ViewGroup viewGroup, b.a.r0.k2.r.a aVar, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, bVar})) == null) {
            super.Z(i2, view, viewGroup, aVar, bVar);
            if (aVar != null && bVar != null) {
                aVar.f20280f = i2 + 1;
                this.t = aVar;
                o0(aVar);
                bVar.c(this.f2421e, aVar.f20279e);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void t(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.u = fVar;
            b.a.r0.k2.u.f.a1.b bVar = this.s;
            if (bVar != null) {
                bVar.v(fVar);
            }
        }
    }
}
