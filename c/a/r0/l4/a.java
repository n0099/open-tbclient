package c.a.r0.l4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import c.a.d.f.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f19368b;

    /* renamed from: c  reason: collision with root package name */
    public f f19369c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f19370d;

    /* renamed from: c.a.r0.l4.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC1155a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19371e;

        public View$OnClickListenerC1155a(a aVar) {
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
            this.f19371e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f19371e.f19369c) == null) {
                return;
            }
            if (fVar.g() != 0) {
                UtilHelper.setNavigationBarBackground(this.f19371e.f19368b.getPageActivity(), this.f19371e.f19369c.g());
            }
            this.f19371e.f19369c.m(true);
        }
    }

    /* loaded from: classes6.dex */
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
        public View f19372e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f19373f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f19374g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f19375h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f19376i;

        /* renamed from: j  reason: collision with root package name */
        public LinearLayout f19377j;

        /* renamed from: k  reason: collision with root package name */
        public LinearLayout f19378k;
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

        /* renamed from: c.a.r0.l4.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC1156a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19379e;

            public View$OnClickListenerC1156a(b bVar) {
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
                this.f19379e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.r0.l4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f19379e.f19369c) == null) {
                    return;
                }
                fVar.s(fVar.k());
            }
        }

        /* renamed from: c.a.r0.l4.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC1157b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19380e;

            public View$OnClickListenerC1157b(b bVar) {
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
                this.f19380e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.r0.l4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f19380e.f19369c) == null) {
                    return;
                }
                fVar.r();
            }
        }

        /* loaded from: classes6.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19381e;

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
                this.f19381e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.r0.l4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f19381e.f19369c) == null) {
                    return;
                }
                fVar.w(c.a.q0.s.m.d.f12800d);
            }
        }

        /* loaded from: classes6.dex */
        public class d implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19382e;

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
                this.f19382e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.r0.l4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f19382e.f19369c) == null) {
                    return;
                }
                fVar.q();
            }
        }

        /* loaded from: classes6.dex */
        public class e implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19383e;

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
                this.f19383e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.r0.l4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f19383e.f19369c) == null) {
                    return;
                }
                fVar.y(fVar.k());
            }
        }

        /* loaded from: classes6.dex */
        public class f implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19384e;

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
                this.f19384e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.r0.l4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f19384e.f19369c) == null) {
                    return;
                }
                fVar.z();
            }
        }

        /* loaded from: classes6.dex */
        public class g implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19385e;

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
                this.f19385e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.r0.l4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f19385e.f19369c) == null) {
                    return;
                }
                fVar.x(null, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TbPageContext tbPageContext, c.a.r0.l4.f fVar) {
            super(tbPageContext, fVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((TbPageContext) objArr2[0], (c.a.r0.l4.f) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19372e = this.a.findViewById(R.id.view_background);
            this.f19373f = (LinearLayout) this.a.findViewById(R.id.type_container);
            this.f19374g = (LinearLayout) this.a.findViewById(R.id.thread_text);
            this.m = (ImageView) this.a.findViewById(R.id.thread_text_iv);
            this.s = (TextView) this.a.findViewById(R.id.thread_text_tv);
            this.f19375h = (LinearLayout) this.a.findViewById(R.id.thread_pic);
            this.n = (ImageView) this.a.findViewById(R.id.thread_pic_iv);
            this.t = (TextView) this.a.findViewById(R.id.thread_pic_tv);
            this.f19376i = (LinearLayout) this.a.findViewById(R.id.thread_video);
            this.o = (ImageView) this.a.findViewById(R.id.thread_video_iv);
            this.u = (TextView) this.a.findViewById(R.id.thread_video_tv);
            d();
            this.f19377j = (LinearLayout) this.a.findViewById(R.id.thread_ala);
            this.p = (ImageView) this.a.findViewById(R.id.thread_ala_iv);
            this.v = (TextView) this.a.findViewById(R.id.thread_ala_tv);
            this.f19377j.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            this.f19377j.setVisibility(TbSingleton.getInstance().isAuditPackageSwitchOn() ? 0 : 8);
            this.f19378k = (LinearLayout) this.a.findViewById(R.id.thread_vote);
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
            this.f19372e.setOnClickListener(this.f19370d);
            this.f19374g.setOnClickListener(new View$OnClickListenerC1156a(this));
            this.f19375h.setOnClickListener(new View$OnClickListenerC1157b(this));
            this.f19376i.setOnClickListener(new c(this));
            this.f19377j.setOnClickListener(new d(this));
            this.f19378k.setOnClickListener(new e(this));
            this.l.setOnClickListener(new f(this));
            this.D = l.f(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            c(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // c.a.r0.l4.a
        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? LayoutInflater.from(this.f19368b.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null) : (View) invokeV.objValue;
        }

        @Override // c.a.r0.l4.a
        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                super.c(i2);
                SkinManager.setBackgroundColor(this.f19372e, R.color.CAM_X0603);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(this.D).defaultColor(R.color.CAM_X0701).into(this.f19373f);
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
                TBSelector.makeDrawableSelector().setShape(0).setType(1).tlRadius(this.D).trRadius(this.D).into(this.f19374g);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).into(this.f19375h);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).into(this.f19376i);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).into(this.E);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).into(this.f19377j);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).blRadius(this.D).brRadius(this.D).into(this.f19378k);
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

    /* loaded from: classes6.dex */
    public static class c extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView A;
        public LinearLayout B;
        public ImageView C;
        public TextView D;
        public OvalActionButton E;
        public GridLayout F;
        public TBLottieAnimationView G;

        /* renamed from: e  reason: collision with root package name */
        public View f19386e;

        /* renamed from: f  reason: collision with root package name */
        public View f19387f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f19388g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f19389h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f19390i;

        /* renamed from: j  reason: collision with root package name */
        public LinearLayout f19391j;

        /* renamed from: k  reason: collision with root package name */
        public ImageView f19392k;
        public TextView l;
        public LinearLayout m;
        public ImageView n;
        public TextView o;
        public LinearLayout p;
        public ImageView q;
        public TextView r;
        public LinearLayout s;
        public ImageView t;
        public TextView u;
        public LinearLayout v;
        public ImageView w;
        public TextView x;
        public LinearLayout y;
        public ImageView z;

        /* renamed from: c.a.r0.l4.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC1158a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f19393e;

            public View$OnClickListenerC1158a(c cVar) {
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
                this.f19393e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.r0.l4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f19393e.f19369c) == null) {
                    return;
                }
                fVar.s(fVar.k());
            }
        }

        /* loaded from: classes6.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f19394e;

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
                this.f19394e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.r0.l4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f19394e.f19369c) == null) {
                    return;
                }
                fVar.w(c.a.q0.s.m.d.f12802f);
            }
        }

        /* renamed from: c.a.r0.l4.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC1159c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f19395e;

            public View$OnClickListenerC1159c(c cVar) {
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
                this.f19395e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.r0.l4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f19395e.f19369c) == null) {
                    return;
                }
                fVar.r();
            }
        }

        /* loaded from: classes6.dex */
        public class d implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f19396e;

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
                this.f19396e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.r0.l4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f19396e.f19369c) == null) {
                    return;
                }
                fVar.q();
            }
        }

        /* loaded from: classes6.dex */
        public class e implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f19397e;

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
                this.f19397e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.r0.l4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f19397e.f19369c) == null) {
                    return;
                }
                fVar.y(fVar.k());
            }
        }

        /* loaded from: classes6.dex */
        public class f implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f19398e;

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
                this.f19398e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.r0.l4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f19398e.f19369c) == null) {
                    return;
                }
                fVar.z();
            }
        }

        /* loaded from: classes6.dex */
        public class g implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f19399e;

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
                this.f19399e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.r0.l4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f19399e.f19369c) == null) {
                    return;
                }
                fVar.u();
            }
        }

        /* loaded from: classes6.dex */
        public class h implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.l4.f f19400e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f19401f;

            public h(c cVar, c.a.r0.l4.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19401f = cVar;
                this.f19400e = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    ForumWriteData h2 = this.f19400e.h();
                    c.a.r0.l4.f fVar = this.f19401f.f19369c;
                    if (fVar == null || h2 == null) {
                        return;
                    }
                    fVar.x(h2.forumId, h2.forumName);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TbPageContext tbPageContext, c.a.r0.l4.f fVar) {
            super(tbPageContext, fVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((TbPageContext) objArr2[0], (c.a.r0.l4.f) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (tbPageContext == null) {
                return;
            }
            this.f19391j = (LinearLayout) this.a.findViewById(R.id.home_write_article);
            this.f19392k = (ImageView) this.a.findViewById(R.id.home_write_article_icon);
            this.l = (TextView) this.a.findViewById(R.id.home_write_article_title);
            this.f19388g = (LinearLayout) this.a.findViewById(R.id.home_write_photo);
            this.f19389h = (ImageView) this.a.findViewById(R.id.home_write_photo_icon);
            this.f19390i = (TextView) this.a.findViewById(R.id.home_write_photo_title);
            this.m = (LinearLayout) this.a.findViewById(R.id.home_write_album);
            this.n = (ImageView) this.a.findViewById(R.id.home_write_album_icon);
            this.o = (TextView) this.a.findViewById(R.id.home_write_album_title);
            this.p = (LinearLayout) this.a.findViewById(R.id.home_write_live);
            this.q = (ImageView) this.a.findViewById(R.id.home_write_live_icon);
            this.r = (TextView) this.a.findViewById(R.id.home_write_live_title);
            this.p.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            d(fVar);
            this.v = (LinearLayout) this.a.findViewById(R.id.home_write_vote);
            this.w = (ImageView) this.a.findViewById(R.id.home_write_vote_icon);
            this.x = (TextView) this.a.findViewById(R.id.home_write_vote_title);
            ((LinearLayout.LayoutParams) this.w.getLayoutParams()).topMargin = TbSingleton.getInstance().isShowStartLiveEntry() ? ((LinearLayout.LayoutParams) this.w.getLayoutParams()).topMargin : 0;
            this.y = (LinearLayout) this.a.findViewById(R.id.home_write_score);
            this.z = (ImageView) this.a.findViewById(R.id.home_write_score_icon);
            this.A = (TextView) this.a.findViewById(R.id.home_write_score_title);
            this.B = (LinearLayout) this.a.findViewById(R.id.home_write_commodity);
            this.C = (ImageView) this.a.findViewById(R.id.home_write_commodity_icon);
            this.D = (TextView) this.a.findViewById(R.id.home_write_commodity_title);
            this.E = (OvalActionButton) this.a.findViewById(R.id.write_close_view);
            c.a.r0.l4.f fVar2 = this.f19369c;
            if (fVar2 != null && "frs".equals(fVar2.i())) {
                this.E.setIsCircle(true);
                this.E.setHasShadow(false);
            }
            this.f19387f = this.a.findViewById(R.id.view_background_white);
            this.f19386e = this.a.findViewById(R.id.view_background_translate);
            GridLayout gridLayout = (GridLayout) this.a.findViewById(R.id.type_container);
            this.F = gridLayout;
            gridLayout.setMeasureAllChild(true);
            this.F.setVerNum(2);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.a.findViewById(R.id.bottom_bar_background);
            this.G = tBLottieAnimationView;
            tBLottieAnimationView.setSpeed(1.2f);
            a();
            this.f19386e.setOnClickListener(this.f19370d);
            this.f19386e.setClickable(true);
            this.f19392k.setOnClickListener(new View$OnClickListenerC1158a(this));
            this.f19389h.setOnClickListener(new b(this));
            this.n.setOnClickListener(new View$OnClickListenerC1159c(this));
            this.q.setOnClickListener(new d(this));
            this.v.setOnClickListener(new e(this));
            this.y.setOnClickListener(new f(this));
            this.B.setOnClickListener(new g(this));
        }

        @Override // c.a.r0.l4.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                float k2 = l.k(this.f19368b.getPageActivity());
                int i2 = (int) (0.13518518f * k2);
                e(this.f19392k, i2);
                e(this.f19389h, i2);
                e(this.n, i2);
                e(this.q, i2);
                e(this.t, i2);
                e(this.w, i2);
                e(this.z, i2);
                e(this.C, i2);
                float f2 = (k2 * 1.0f) / l.f(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
                ViewGroup.LayoutParams layoutParams = this.F.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.f(TbadkCoreApplication.getInst(), R.dimen.tbds423) * f2);
                    this.F.setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams2 = this.f19387f.getLayoutParams();
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    int f3 = (int) (l.f(TbadkCoreApplication.getInst(), R.dimen.tbds1023) * f2);
                    if (f3 <= 0) {
                        f3 = 1023;
                    }
                    ((RelativeLayout.LayoutParams) layoutParams2).height = f3;
                    this.f19387f.setLayoutParams(layoutParams2);
                }
                ViewGroup.LayoutParams layoutParams3 = this.G.getLayoutParams();
                if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((l.f(TbadkCoreApplication.getInst(), R.dimen.tbds800) * f2) - ((l.f(TbadkCoreApplication.getInst(), R.dimen.tbds135) * f2) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                    this.G.setLayoutParams(layoutParams3);
                }
            }
        }

        @Override // c.a.r0.l4.a
        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? LayoutInflater.from(this.f19368b.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null) : (View) invokeV.objValue;
        }

        @Override // c.a.r0.l4.a
        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.E.onChangeSkinType(i2);
                SkinManager.setLottieAnimation(this.G, R.raw.bottom_bar_bg);
                SkinManager.setBackgroundResource(this.f19387f, R.drawable.write_tab_background);
                SkinManager.setImageResource(this.f19389h, R.drawable.icon_mask_post_photograph56);
                SkinManager.setImageResource(this.f19392k, R.drawable.icon_mask_post_text56);
                SkinManager.setImageResource(this.n, R.drawable.icon_mask_post_image56);
                SkinManager.setImageResource(this.q, R.drawable.icon_mask_post_live56);
                SkinManager.setImageResource(this.t, R.drawable.icon_mask_voiceroom56);
                SkinManager.setImageResource(this.w, R.drawable.icon_mask_post_vote56);
                SkinManager.setImageResource(this.z, R.drawable.icon_mask_post_evaluation56);
                SkinManager.setImageResource(this.C, R.drawable.icon_mask_post_goods56);
                SkinManager.setViewTextColor(this.f19390i, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.u, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.x, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.A, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.D, R.color.CAM_X0107);
            }
        }

        public final void d(@NonNull c.a.r0.l4.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
                this.s = (LinearLayout) this.a.findViewById(R.id.home_voice_room);
                this.t = (ImageView) this.a.findViewById(R.id.home_voice_room_icon);
                this.u = (TextView) this.a.findViewById(R.id.home_voice_room_title);
                boolean a = fVar.j().a();
                this.s.setVisibility(a ? 0 : 8);
                if (a) {
                    ((LinearLayout.LayoutParams) this.q.getLayoutParams()).topMargin = l.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X008);
                }
                this.t.setOnClickListener(new h(this, fVar));
            }
        }

        public final void e(ImageView imageView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048580, this, imageView, i2) == null) || imageView == null || i2 <= 0) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = i2;
            imageView.setLayoutParams(layoutParams);
        }

        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            }
        }
    }

    public a(TbPageContext tbPageContext, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19370d = new View$OnClickListenerC1155a(this);
        this.f19368b = tbPageContext;
        this.f19369c = fVar;
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
