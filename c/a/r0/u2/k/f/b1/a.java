package c.a.r0.u2.k.f.b1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.q0.c1.q;
import c.a.r0.u2.h.f;
import c.a.r0.u2.k.f.o;
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
/* loaded from: classes2.dex */
public class a extends o<c.a.r0.u2.h.a, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.u2.k.f.b1.b s;
    public c.a.r0.u2.h.a t;
    public f u;
    public View.OnClickListener v;

    /* renamed from: c.a.r0.u2.k.f.b1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1446a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23325e;

        public View$OnClickListenerC1446a(a aVar) {
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
            this.f23325e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23325e.t == null || this.f23325e.t.f23080e == null || q.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(this.f23325e.n.getPageContext().getPageActivity());
                return;
            }
            a aVar = this.f23325e;
            aVar.g0(aVar.t);
            if (this.f23325e.t.f23080e.b()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f23325e.n.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            } else if (this.f23325e.t.f23080e.a()) {
                this.f23325e.s.u(this.f23325e.t);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f23326b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f23327c;

        /* renamed from: d  reason: collision with root package name */
        public ProgressBar f23328d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f23329e;

        /* renamed from: f  reason: collision with root package name */
        public View f23330f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f23331g;

        /* renamed from: c.a.r0.u2.k.f.b1.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC1447a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f23332e;

            public View$OnClickListenerC1447a(b bVar) {
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
                this.f23332e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23332e.f23331g == null) {
                    return;
                }
                this.f23332e.f23331g.onClick(view);
            }
        }

        public /* synthetic */ b(View view, View$OnClickListenerC1446a view$OnClickListenerC1446a) {
            this(view);
        }

        public final void c(Context context, c.a.r0.u2.h.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, bVar) == null) || bVar == null) {
                return;
            }
            this.f23329e.setText(bVar.f23083c);
            this.f23326b.startLoad(bVar.f23082b, 38, false);
            this.a.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.f23084d) + "%");
            int e2 = c.a.d.f.m.b.e(bVar.f23084d, 0);
            if (e2 > 100) {
                e2 = 100;
            } else if (e2 < 0) {
                e2 = 0;
            }
            this.f23328d.setProgress(e2);
            if (bVar.a()) {
                this.f23327c.setText(R.string.pb_ad_card_gift_get);
                SkinManager.setViewTextColor(this.f23327c, (int) R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f23327c, R.drawable.btn_pb_ad_card_gift_get);
                this.f23327c.setClickable(true);
            } else if (bVar.b()) {
                this.f23327c.setText(R.string.pb_ad_card_gift_watch_btn);
                SkinManager.setViewTextColor(this.f23327c, (int) R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f23327c, R.drawable.btn_pb_ad_card_gift_watch);
                this.f23327c.setClickable(true);
            } else {
                this.f23327c.setText(R.string.pb_ad_card_gift_over_btn);
                SkinManager.setViewTextColor(this.f23327c, (int) R.color.CAM_X0109);
                this.f23327c.setBackgroundResource(R.drawable.transparent_bg);
                this.f23327c.setClickable(false);
            }
            onChangeSkinType();
        }

        public final void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundResource(this.f23330f, R.drawable.bg_pb_ad_card_gift);
                SkinManager.setViewTextColor(this.f23329e, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0107);
                this.f23328d.setProgressDrawable(SkinManager.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
            }
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
                this.f23331g = onClickListener;
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
            this.f23330f = view.findViewById(R.id.bg_ad_card_gift);
            this.f23326b = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.a = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.f23327c = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.f23328d = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.f23329e = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.f23326b.setRadius(n.f(getView().getContext(), R.dimen.tbds20));
            this.f23326b.setConrers(5);
            this.f23326b.setDefaultBgResource(R.color.cp_atp_a);
            this.f23326b.setDrawCorner(true);
            this.f23327c.setOnClickListener(new View$OnClickListenerC1447a(this));
            this.f23328d.setMax(100);
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
                super((c.a.r0.u2.o.c) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = new View$OnClickListenerC1446a(this);
        this.s = new c.a.r0.u2.k.f.b1.b(pbFragment);
    }

    @Override // c.a.r0.u2.k.f.o, c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        j0(i2, view, viewGroup, (c.a.r0.u2.h.a) obj, (b) viewHolder);
        return view;
    }

    public final void g0(c.a.r0.u2.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            c.a.r0.x3.c.g().c(this.n.getUniqueId(), c.a.r0.x3.a.e(this.u.O(), "a005", "common_click", 1, aVar.f23081f, true, aVar.f23080e.a + "", null, 18));
        }
    }

    public final void h0(c.a.r0.u2.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            String str = aVar.f23080e.a + "";
            c.a.r0.x3.c.g().d(this.n.getUniqueId(), c.a.r0.x3.a.c(this.u.O().w1(), str, "", null), c.a.r0.x3.a.g(this.u.O(), "a005", "common_exp", aVar.f23081f, true, str, "", 18));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: i0 */
    public b M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            b bVar = new b(LayoutInflater.from(this.f3076e).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false), null);
            bVar.setOnClickListener(this.v);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public View j0(int i2, View view, ViewGroup viewGroup, c.a.r0.u2.h.a aVar, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, bVar})) == null) {
            super.S(i2, view, viewGroup, aVar, bVar);
            if (aVar != null && bVar != null) {
                aVar.f23081f = i2 + 1;
                this.t = aVar;
                h0(aVar);
                bVar.c(this.f3076e, aVar.f23080e);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void onDestroy() {
        c.a.r0.u2.k.f.b1.b bVar;
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
            c.a.r0.u2.k.f.b1.b bVar = this.s;
            if (bVar != null) {
                bVar.v(fVar);
            }
        }
    }
}
