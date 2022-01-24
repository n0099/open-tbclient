package c.a.t0.p4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import c.a.s0.t.c.o0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.LoginPostStatisticHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.view.FrsAnomalyImg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f21221b;

    /* renamed from: c  reason: collision with root package name */
    public p f21222c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f21223d;

    /* renamed from: c.a.t0.p4.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1323a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21224e;

        public View$OnClickListenerC1323a(a aVar) {
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
            this.f21224e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p pVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (pVar = this.f21224e.f21222c) == null) {
                return;
            }
            if (pVar.g() != 0) {
                UtilHelper.setNavigationBarBackground(this.f21224e.f21221b.getPageActivity(), this.f21224e.f21222c.g());
            }
            this.f21224e.f21222c.m(true);
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View A;
        public View B;
        public View C;
        public int D;
        public LinearLayout E;
        public ImageView F;
        public TextView G;
        public View H;

        /* renamed from: e  reason: collision with root package name */
        public View f21225e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f21226f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f21227g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f21228h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f21229i;

        /* renamed from: j  reason: collision with root package name */
        public LinearLayout f21230j;
        public LinearLayout k;
        public LinearLayout l;
        public ImageView m;
        public ImageView n;
        public ImageView o;
        public ImageView p;
        public ImageView q;
        public ImageView r;
        public TextView s;
        public TextView t;
        public TextView u;
        public TextView v;
        public TextView w;
        public TextView x;
        public View y;
        public View z;

        /* renamed from: c.a.t0.p4.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC1324a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f21231e;

            public View$OnClickListenerC1324a(b bVar) {
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
                this.f21231e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21231e.f21222c == null) {
                    return;
                }
                LoginPostStatisticHelper.statisticClickPost(LoginPostStatisticHelper.newStatisticData(3));
                p pVar = this.f21231e.f21222c;
                pVar.s(pVar.k());
            }
        }

        /* renamed from: c.a.t0.p4.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC1325b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f21232e;

            public View$OnClickListenerC1325b(b bVar) {
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
                this.f21232e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                p pVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (pVar = this.f21232e.f21222c) == null) {
                    return;
                }
                pVar.r();
            }
        }

        /* loaded from: classes8.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f21233e;

            public c(b bVar) {
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
                this.f21233e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                p pVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (pVar = this.f21233e.f21222c) == null) {
                    return;
                }
                pVar.w(c.a.s0.s.m.d.f13427d);
            }
        }

        /* loaded from: classes8.dex */
        public class d implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f21234e;

            public d(b bVar) {
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
                this.f21234e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                p pVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (pVar = this.f21234e.f21222c) == null) {
                    return;
                }
                pVar.q();
            }
        }

        /* loaded from: classes8.dex */
        public class e implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f21235e;

            public e(b bVar) {
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
                this.f21235e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                p pVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (pVar = this.f21235e.f21222c) == null) {
                    return;
                }
                pVar.y(pVar.k());
            }
        }

        /* loaded from: classes8.dex */
        public class f implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f21236e;

            public f(b bVar) {
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
                this.f21236e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                p pVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (pVar = this.f21236e.f21222c) == null) {
                    return;
                }
                pVar.z();
            }
        }

        /* loaded from: classes8.dex */
        public class g implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f21237e;

            public g(b bVar) {
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
                this.f21237e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                p pVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (pVar = this.f21237e.f21222c) == null) {
                    return;
                }
                pVar.x(null, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TbPageContext tbPageContext, p pVar) {
            super(tbPageContext, pVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((TbPageContext) objArr2[0], (p) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21225e = this.a.findViewById(R.id.view_background);
            this.f21226f = (LinearLayout) this.a.findViewById(R.id.type_container);
            this.f21227g = (LinearLayout) this.a.findViewById(R.id.thread_text);
            this.m = (ImageView) this.a.findViewById(R.id.thread_text_iv);
            this.s = (TextView) this.a.findViewById(R.id.thread_text_tv);
            this.f21228h = (LinearLayout) this.a.findViewById(R.id.thread_pic);
            this.n = (ImageView) this.a.findViewById(R.id.thread_pic_iv);
            this.t = (TextView) this.a.findViewById(R.id.thread_pic_tv);
            this.f21229i = (LinearLayout) this.a.findViewById(R.id.thread_video);
            this.o = (ImageView) this.a.findViewById(R.id.thread_video_iv);
            this.u = (TextView) this.a.findViewById(R.id.thread_video_tv);
            d();
            this.f21230j = (LinearLayout) this.a.findViewById(R.id.thread_ala);
            this.p = (ImageView) this.a.findViewById(R.id.thread_ala_iv);
            this.v = (TextView) this.a.findViewById(R.id.thread_ala_tv);
            this.f21230j.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            this.f21230j.setVisibility(TbSingleton.getInstance().isAuditPackageSwitchOn() ? 0 : 8);
            this.k = (LinearLayout) this.a.findViewById(R.id.thread_vote);
            this.q = (ImageView) this.a.findViewById(R.id.thread_vote_iv);
            this.w = (TextView) this.a.findViewById(R.id.thread_vote_tv);
            this.l = (LinearLayout) this.a.findViewById(R.id.thread_write_score);
            this.r = (ImageView) this.a.findViewById(R.id.thread_write_score_iv);
            this.x = (TextView) this.a.findViewById(R.id.thread_write_score_tv);
            this.y = this.a.findViewById(R.id.line_1);
            this.z = this.a.findViewById(R.id.line_2);
            this.A = this.a.findViewById(R.id.line_3);
            this.B = this.a.findViewById(R.id.line_4);
            this.C = this.a.findViewById(R.id.line_5);
            this.B.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            this.s.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_article_title));
            this.t.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.u.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.v.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.w.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_vote_title));
            this.x.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.evaluate));
            this.f21225e.setOnClickListener(this.f21223d);
            this.f21227g.setOnClickListener(new View$OnClickListenerC1324a(this));
            this.f21228h.setOnClickListener(new View$OnClickListenerC1325b(this));
            this.f21229i.setOnClickListener(new c(this));
            this.f21230j.setOnClickListener(new d(this));
            this.k.setOnClickListener(new e(this));
            this.l.setOnClickListener(new f(this));
            this.D = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            c(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // c.a.t0.p4.a
        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? LayoutInflater.from(this.f21221b.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null) : (View) invokeV.objValue;
        }

        @Override // c.a.t0.p4.a
        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                super.c(i2);
                SkinManager.setBackgroundColor(this.f21225e, R.color.CAM_X0603);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(this.D).defaultColor(R.color.CAM_X0701).into(this.f21226f);
                this.m.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_text24, WebPManager.ResourceStateType.NORMAL));
                this.n.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_image24, WebPManager.ResourceStateType.NORMAL));
                this.o.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_photograph24, WebPManager.ResourceStateType.NORMAL));
                this.F.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_voiceroom24, WebPManager.ResourceStateType.NORMAL));
                this.p.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_live24, WebPManager.ResourceStateType.NORMAL));
                this.q.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_vote24, WebPManager.ResourceStateType.NORMAL));
                this.r.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_home_publish_grade24, WebPManager.ResourceStateType.NORMAL));
                SkinManager.setViewTextColor(this.s, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.t, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.u, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.G, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.v, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.x, R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).tlRadius(this.D).trRadius(this.D).into(this.f21227g);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).into(this.f21228h);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).into(this.f21229i);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).into(this.E);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).into(this.f21230j);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).blRadius(this.D).brRadius(this.D).into(this.k);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).blRadius(this.D).brRadius(this.D).into(this.l);
                SkinManager.setBackgroundColor(this.y, R.color.CAM_X0613);
                SkinManager.setBackgroundColor(this.z, R.color.CAM_X0613);
                SkinManager.setBackgroundColor(this.A, R.color.CAM_X0613);
                SkinManager.setBackgroundColor(this.B, R.color.CAM_X0613);
                SkinManager.setBackgroundColor(this.C, R.color.CAM_X0613);
                SkinManager.setBackgroundColor(this.H, R.color.CAM_X0613);
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.E = (LinearLayout) this.a.findViewById(R.id.thread_voice_room);
                this.F = (ImageView) this.a.findViewById(R.id.thread_voice_room_iv);
                this.G = (TextView) this.a.findViewById(R.id.thread_voice_room_tv);
                this.H = this.a.findViewById(R.id.line_voice_room);
                e(TbSingleton.getInstance().getVoiceRoomConfig().a());
                this.G.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_voice_room_title));
                this.E.setOnClickListener(new g(this));
            }
        }

        public final void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                int i2 = z ? 0 : 8;
                this.E.setVisibility(i2);
                this.H.setVisibility(i2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout A;
        public ImageView B;
        public TextView C;
        public LinearLayout D;
        public ImageView E;
        public TextView F;
        public OvalActionButton G;
        public GridLayout H;
        public TBLottieAnimationView I;

        /* renamed from: e  reason: collision with root package name */
        public View f21238e;

        /* renamed from: f  reason: collision with root package name */
        public View f21239f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f21240g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f21241h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f21242i;

        /* renamed from: j  reason: collision with root package name */
        public LinearLayout f21243j;
        public ImageView k;
        public TextView l;
        public LinearLayout m;
        public ImageView n;
        public TextView o;
        public LinearLayout p;
        public ImageView q;
        public TextView r;
        public FrsAnomalyImg s;
        public TextView t;
        public LinearLayout u;
        public ImageView v;
        public TextView w;
        public LinearLayout x;
        public ImageView y;
        public TextView z;

        /* renamed from: c.a.t0.p4.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC1326a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f21244e;

            public View$OnClickListenerC1326a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21244e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21244e.f21222c == null) {
                    return;
                }
                LoginPostStatisticHelper.statisticClickPost(LoginPostStatisticHelper.newStatisticData(2));
                p pVar = this.f21244e.f21222c;
                pVar.s(pVar.k());
            }
        }

        /* loaded from: classes8.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f21245e;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21245e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                p pVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (pVar = this.f21245e.f21222c) == null) {
                    return;
                }
                pVar.w(c.a.s0.s.m.d.f13429f);
            }
        }

        /* renamed from: c.a.t0.p4.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC1327c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f21246e;

            public View$OnClickListenerC1327c(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21246e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                p pVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (pVar = this.f21246e.f21222c) == null) {
                    return;
                }
                pVar.r();
            }
        }

        /* loaded from: classes8.dex */
        public class d implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f21247e;

            public d(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21247e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                p pVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (pVar = this.f21247e.f21222c) == null) {
                    return;
                }
                pVar.q();
            }
        }

        /* loaded from: classes8.dex */
        public class e implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f21248e;

            public e(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21248e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                p pVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (pVar = this.f21248e.f21222c) == null) {
                    return;
                }
                pVar.y(pVar.k());
            }
        }

        /* loaded from: classes8.dex */
        public class f implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f21249e;

            public f(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21249e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                p pVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (pVar = this.f21249e.f21222c) == null) {
                    return;
                }
                pVar.z();
            }
        }

        /* loaded from: classes8.dex */
        public class g implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f21250e;

            public g(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21250e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                p pVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (pVar = this.f21250e.f21222c) == null) {
                    return;
                }
                pVar.u();
            }
        }

        /* loaded from: classes8.dex */
        public class h implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o0 f21251e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f21252f;

            public h(c cVar, o0 o0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, o0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21252f = cVar;
                this.f21251e = o0Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f21252f.f21221b.getPageActivity(), null, this.f21251e.b(), true)));
                    StatisticItem statisticItem = new StatisticItem("c14500");
                    statisticItem.param("aid", this.f21251e.b());
                    statisticItem.eventStat();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class i implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ p f21253e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f21254f;

            public i(c cVar, p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, pVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21254f = cVar;
                this.f21253e = pVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    ForumWriteData h2 = this.f21253e.h();
                    p pVar = this.f21254f.f21222c;
                    if (pVar == null || h2 == null) {
                        return;
                    }
                    pVar.x(h2.forumId, h2.forumName);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TbPageContext tbPageContext, p pVar) {
            super(tbPageContext, pVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((TbPageContext) objArr2[0], (p) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (tbPageContext == null) {
                return;
            }
            e();
            this.f21243j = (LinearLayout) this.a.findViewById(R.id.home_write_article);
            this.k = (ImageView) this.a.findViewById(R.id.home_write_article_icon);
            this.l = (TextView) this.a.findViewById(R.id.home_write_article_title);
            this.f21240g = (LinearLayout) this.a.findViewById(R.id.home_write_photo);
            this.f21241h = (ImageView) this.a.findViewById(R.id.home_write_photo_icon);
            this.f21242i = (TextView) this.a.findViewById(R.id.home_write_photo_title);
            this.m = (LinearLayout) this.a.findViewById(R.id.home_write_album);
            this.n = (ImageView) this.a.findViewById(R.id.home_write_album_icon);
            this.o = (TextView) this.a.findViewById(R.id.home_write_album_title);
            this.p = (LinearLayout) this.a.findViewById(R.id.home_write_live);
            this.q = (ImageView) this.a.findViewById(R.id.home_write_live_icon);
            this.r = (TextView) this.a.findViewById(R.id.home_write_live_title);
            this.p.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            d(pVar);
            this.x = (LinearLayout) this.a.findViewById(R.id.home_write_vote);
            this.y = (ImageView) this.a.findViewById(R.id.home_write_vote_icon);
            this.z = (TextView) this.a.findViewById(R.id.home_write_vote_title);
            ((LinearLayout.LayoutParams) this.y.getLayoutParams()).topMargin = TbSingleton.getInstance().isShowStartLiveEntry() ? ((LinearLayout.LayoutParams) this.y.getLayoutParams()).topMargin : 0;
            this.A = (LinearLayout) this.a.findViewById(R.id.home_write_score);
            this.B = (ImageView) this.a.findViewById(R.id.home_write_score_icon);
            this.C = (TextView) this.a.findViewById(R.id.home_write_score_title);
            this.D = (LinearLayout) this.a.findViewById(R.id.home_write_commodity);
            this.E = (ImageView) this.a.findViewById(R.id.home_write_commodity_icon);
            this.F = (TextView) this.a.findViewById(R.id.home_write_commodity_title);
            this.G = (OvalActionButton) this.a.findViewById(R.id.write_close_view);
            p pVar2 = this.f21222c;
            if (pVar2 != null && "frs".equals(pVar2.i())) {
                this.G.setIsCircle(true);
                this.G.setHasShadow(false);
            }
            this.f21239f = this.a.findViewById(R.id.view_background_white);
            this.f21238e = this.a.findViewById(R.id.view_background_translate);
            GridLayout gridLayout = (GridLayout) this.a.findViewById(R.id.type_container);
            this.H = gridLayout;
            gridLayout.setMeasureAllChild(true);
            this.H.setVerNum(2);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.a.findViewById(R.id.bottom_bar_background);
            this.I = tBLottieAnimationView;
            tBLottieAnimationView.setSpeed(1.2f);
            a();
            this.f21238e.setOnClickListener(this.f21223d);
            this.f21238e.setClickable(true);
            this.k.setOnClickListener(new View$OnClickListenerC1326a(this));
            this.f21241h.setOnClickListener(new b(this));
            this.n.setOnClickListener(new View$OnClickListenerC1327c(this));
            this.q.setOnClickListener(new d(this));
            this.x.setOnClickListener(new e(this));
            this.A.setOnClickListener(new f(this));
            this.D.setOnClickListener(new g(this));
        }

        @Override // c.a.t0.p4.a
        public void a() {
            int f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                float k = c.a.d.f.p.n.k(this.f21221b.getPageActivity());
                int i2 = (int) (0.13518518f * k);
                f(this.k, i2);
                f(this.f21241h, i2);
                f(this.n, i2);
                f(this.q, i2);
                f(this.v, i2);
                f(this.y, i2);
                f(this.B, i2);
                f(this.E, i2);
                float f3 = (k * 1.0f) / c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
                ViewGroup.LayoutParams layoutParams = this.H.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds423) * f3);
                    this.H.setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams2 = this.s.getLayoutParams();
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).bottomMargin = (int) (c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds932) * f3);
                    this.s.setLayoutParams(layoutParams2);
                }
                ViewGroup.LayoutParams layoutParams3 = this.f21239f.getLayoutParams();
                if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                    if (TbSingleton.getInstance().getVideoEventsConfig() != null && TbSingleton.getInstance().getVideoEventsConfig().d()) {
                        f2 = (int) (c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1162) * f3);
                        if (f2 <= 0) {
                            f2 = 1162;
                        }
                    } else {
                        f2 = (int) (c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1023) * f3);
                        if (f2 <= 0) {
                            f2 = 1023;
                        }
                    }
                    ((RelativeLayout.LayoutParams) layoutParams3).height = f2;
                    this.f21239f.setLayoutParams(layoutParams3);
                }
                ViewGroup.LayoutParams layoutParams4 = this.I.getLayoutParams();
                if (layoutParams4 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams4).height = (int) ((c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds800) * f3) - ((c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds135) * f3) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                    this.I.setLayoutParams(layoutParams4);
                }
            }
        }

        @Override // c.a.t0.p4.a
        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? LayoutInflater.from(this.f21221b.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null) : (View) invokeV.objValue;
        }

        @Override // c.a.t0.p4.a
        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.G.onChangeSkinType(i2);
                SkinManager.setLottieAnimation(this.I, R.raw.bottom_bar_bg);
                SkinManager.setBackgroundResource(this.f21239f, R.drawable.write_tab_background);
                SkinManager.setImageResource(this.f21241h, R.drawable.icon_mask_post_photograph56);
                SkinManager.setImageResource(this.k, R.drawable.icon_mask_post_text56);
                SkinManager.setImageResource(this.n, R.drawable.icon_mask_post_image56);
                SkinManager.setImageResource(this.q, R.drawable.icon_mask_post_live56);
                SkinManager.setImageResource(this.v, R.drawable.icon_mask_voiceroom56);
                SkinManager.setImageResource(this.y, R.drawable.icon_mask_post_vote56);
                SkinManager.setImageResource(this.B, R.drawable.icon_mask_post_evaluation56);
                SkinManager.setImageResource(this.E, R.drawable.icon_mask_post_goods56);
                SkinManager.setViewTextColor(this.f21242i, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.z, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.C, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.F, R.color.CAM_X0107);
                c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.t);
                d2.v(R.color.CAM_X0101);
                d2.A(R.string.F_X01);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0301);
                FrsAnomalyImg frsAnomalyImg = this.s;
                if (frsAnomalyImg != null) {
                    frsAnomalyImg.changeSkinType();
                }
            }
        }

        public final void d(@NonNull p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, pVar) == null) {
                this.u = (LinearLayout) this.a.findViewById(R.id.home_voice_room);
                this.v = (ImageView) this.a.findViewById(R.id.home_voice_room_icon);
                this.w = (TextView) this.a.findViewById(R.id.home_voice_room_title);
                boolean a = pVar.j().a();
                this.u.setVisibility(a ? 0 : 8);
                if (a) {
                    ((LinearLayout.LayoutParams) this.q.getLayoutParams()).topMargin = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X008);
                }
                this.v.setOnClickListener(new i(this, pVar));
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.s = (FrsAnomalyImg) this.a.findViewById(R.id.write_video_events_location);
                this.t = (TextView) this.a.findViewById(R.id.tv_video_activity);
                FrsAnomalyImg.b bVar = new FrsAnomalyImg.b();
                bVar.a(40);
                bVar.b(640);
                bVar.c(40);
                bVar.d(18);
                this.s.setCorner(33).setTenon(bVar);
                o0 videoEventsConfig = TbSingleton.getInstance().getVideoEventsConfig();
                if (videoEventsConfig == null) {
                    return;
                }
                this.s.setOnClickListener(new h(this, videoEventsConfig));
                this.t.setVisibility(videoEventsConfig.d() ? 0 : 8);
                this.s.setVisibility(videoEventsConfig.d() ? 0 : 8);
                this.s.setVisible(Boolean.valueOf(videoEventsConfig.d()));
                this.s.startLoad(videoEventsConfig.c(), this.f21221b.getUniqueId());
                StatisticItem statisticItem = new StatisticItem("c14501");
                statisticItem.param("aid", videoEventsConfig.b());
                statisticItem.eventStat();
            }
        }

        public final void f(ImageView imageView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048581, this, imageView, i2) == null) || imageView == null || i2 <= 0) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = i2;
            imageView.setLayoutParams(layoutParams);
        }

        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            }
        }
    }

    public a(TbPageContext tbPageContext, p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, pVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21223d = new View$OnClickListenerC1323a(this);
        this.f21221b = tbPageContext;
        this.f21222c = pVar;
        this.a = b();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public abstract View b();

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
        }
    }
}
