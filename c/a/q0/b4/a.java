package c.a.q0.b4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f16057a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f16058b;

    /* renamed from: c  reason: collision with root package name */
    public f f16059c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f16060d;

    /* renamed from: c.a.q0.b4.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0763a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16061e;

        public View$OnClickListenerC0763a(a aVar) {
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
            this.f16061e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f16061e.f16059c) == null) {
                return;
            }
            if (fVar.g() != 0) {
                UtilHelper.setNavigationBarBackground(this.f16061e.f16058b.getPageActivity(), this.f16061e.f16059c.g());
            }
            this.f16061e.f16059c.k(true);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View A;
        public View B;
        public View C;
        public int D;

        /* renamed from: e  reason: collision with root package name */
        public View f16062e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f16063f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f16064g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f16065h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f16066i;

        /* renamed from: j  reason: collision with root package name */
        public LinearLayout f16067j;
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

        /* renamed from: c.a.q0.b4.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0764a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f16068e;

            public View$OnClickListenerC0764a(b bVar) {
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
                this.f16068e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.q0.b4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f16068e.f16059c) == null) {
                    return;
                }
                fVar.o(fVar.i());
            }
        }

        /* renamed from: c.a.q0.b4.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0765b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f16069e;

            public View$OnClickListenerC0765b(b bVar) {
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
                this.f16069e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.q0.b4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f16069e.f16059c) == null) {
                    return;
                }
                fVar.n();
            }
        }

        /* loaded from: classes3.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f16070e;

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
                this.f16070e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.q0.b4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f16070e.f16059c) == null) {
                    return;
                }
                fVar.s();
            }
        }

        /* loaded from: classes3.dex */
        public class d implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f16071e;

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
                this.f16071e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.q0.b4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f16071e.f16059c) == null) {
                    return;
                }
                fVar.m();
            }
        }

        /* loaded from: classes3.dex */
        public class e implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f16072e;

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
                this.f16072e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.q0.b4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f16072e.f16059c) == null) {
                    return;
                }
                fVar.t(fVar.i());
            }
        }

        /* loaded from: classes3.dex */
        public class f implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f16073e;

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
                this.f16073e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.q0.b4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f16073e.f16059c) == null) {
                    return;
                }
                fVar.u();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TbPageContext tbPageContext, c.a.q0.b4.f fVar) {
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
                    super((TbPageContext) objArr2[0], (c.a.q0.b4.f) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16062e = this.f16057a.findViewById(R.id.view_background);
            this.f16063f = (LinearLayout) this.f16057a.findViewById(R.id.type_container);
            this.f16064g = (LinearLayout) this.f16057a.findViewById(R.id.thread_text);
            this.m = (ImageView) this.f16057a.findViewById(R.id.thread_text_iv);
            this.s = (TextView) this.f16057a.findViewById(R.id.thread_text_tv);
            this.f16065h = (LinearLayout) this.f16057a.findViewById(R.id.thread_pic);
            this.n = (ImageView) this.f16057a.findViewById(R.id.thread_pic_iv);
            this.t = (TextView) this.f16057a.findViewById(R.id.thread_pic_tv);
            this.f16066i = (LinearLayout) this.f16057a.findViewById(R.id.thread_video);
            this.o = (ImageView) this.f16057a.findViewById(R.id.thread_video_iv);
            this.u = (TextView) this.f16057a.findViewById(R.id.thread_video_tv);
            this.f16067j = (LinearLayout) this.f16057a.findViewById(R.id.thread_ala);
            this.p = (ImageView) this.f16057a.findViewById(R.id.thread_ala_iv);
            this.v = (TextView) this.f16057a.findViewById(R.id.thread_ala_tv);
            this.f16067j.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            this.f16067j.setVisibility(TbSingleton.getInstance().isAuditPackageSwitchOn() ? 0 : 8);
            this.k = (LinearLayout) this.f16057a.findViewById(R.id.thread_vote);
            this.q = (ImageView) this.f16057a.findViewById(R.id.thread_vote_iv);
            this.w = (TextView) this.f16057a.findViewById(R.id.thread_vote_tv);
            this.l = (LinearLayout) this.f16057a.findViewById(R.id.thread_write_score);
            this.r = (ImageView) this.f16057a.findViewById(R.id.thread_write_score_iv);
            this.x = (TextView) this.f16057a.findViewById(R.id.thread_write_score_tv);
            this.y = this.f16057a.findViewById(R.id.line_1);
            this.z = this.f16057a.findViewById(R.id.line_2);
            this.A = this.f16057a.findViewById(R.id.line_3);
            this.B = this.f16057a.findViewById(R.id.line_4);
            this.C = this.f16057a.findViewById(R.id.line_5);
            this.B.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            this.s.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_article_title));
            this.t.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.u.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.v.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.w.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_vote_title));
            this.x.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.evaluate));
            this.f16062e.setOnClickListener(this.f16060d);
            this.f16064g.setOnClickListener(new View$OnClickListenerC0764a(this));
            this.f16065h.setOnClickListener(new View$OnClickListenerC0765b(this));
            this.f16066i.setOnClickListener(new c(this));
            this.f16067j.setOnClickListener(new d(this));
            this.k.setOnClickListener(new e(this));
            this.l.setOnClickListener(new f(this));
            this.D = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            c(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // c.a.q0.b4.a
        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? LayoutInflater.from(this.f16058b.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null) : (View) invokeV.objValue;
        }

        @Override // c.a.q0.b4.a
        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                super.c(i2);
                SkinManager.setBackgroundColor(this.f16062e, R.color.CAM_X0603);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(this.D).defaultColor(R.color.CAM_X0701).into(this.f16063f);
                this.m.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_text24, WebPManager.ResourceStateType.NORMAL));
                this.n.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_image24, WebPManager.ResourceStateType.NORMAL));
                this.o.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_photograph24, WebPManager.ResourceStateType.NORMAL));
                this.p.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_live24, WebPManager.ResourceStateType.NORMAL));
                this.q.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_vote24, WebPManager.ResourceStateType.NORMAL));
                this.r.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_home_publish_grade24, WebPManager.ResourceStateType.NORMAL));
                SkinManager.setViewTextColor(this.s, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.t, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.u, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.v, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.x, R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).tlRadius(this.D).trRadius(this.D).into(this.f16064g);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).into(this.f16065h);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).into(this.f16066i);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).into(this.f16067j);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).blRadius(this.D).brRadius(this.D).into(this.k);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).blRadius(this.D).brRadius(this.D).into(this.l);
                SkinManager.setBackgroundColor(this.y, R.color.CAM_X0613);
                SkinManager.setBackgroundColor(this.z, R.color.CAM_X0613);
                SkinManager.setBackgroundColor(this.A, R.color.CAM_X0613);
                SkinManager.setBackgroundColor(this.B, R.color.CAM_X0613);
                SkinManager.setBackgroundColor(this.C, R.color.CAM_X0613);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView A;
        public OvalActionButton B;
        public GridLayout C;
        public TBLottieAnimationView D;

        /* renamed from: e  reason: collision with root package name */
        public View f16074e;

        /* renamed from: f  reason: collision with root package name */
        public View f16075f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f16076g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f16077h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f16078i;

        /* renamed from: j  reason: collision with root package name */
        public LinearLayout f16079j;
        public ImageView k;
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

        /* renamed from: c.a.q0.b4.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0766a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f16080e;

            public View$OnClickListenerC0766a(c cVar) {
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
                this.f16080e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.q0.b4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f16080e.f16059c) == null) {
                    return;
                }
                fVar.o(fVar.i());
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f16081e;

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
                this.f16081e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.q0.b4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f16081e.f16059c) == null) {
                    return;
                }
                fVar.s();
            }
        }

        /* renamed from: c.a.q0.b4.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0767c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f16082e;

            public View$OnClickListenerC0767c(c cVar) {
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
                this.f16082e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.q0.b4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f16082e.f16059c) == null) {
                    return;
                }
                fVar.n();
            }
        }

        /* loaded from: classes3.dex */
        public class d implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f16083e;

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
                this.f16083e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.q0.b4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f16083e.f16059c) == null) {
                    return;
                }
                fVar.m();
            }
        }

        /* loaded from: classes3.dex */
        public class e implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f16084e;

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
                this.f16084e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.q0.b4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f16084e.f16059c) == null) {
                    return;
                }
                fVar.t(fVar.i());
            }
        }

        /* loaded from: classes3.dex */
        public class f implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f16085e;

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
                this.f16085e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.q0.b4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f16085e.f16059c) == null) {
                    return;
                }
                fVar.u();
            }
        }

        /* loaded from: classes3.dex */
        public class g implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f16086e;

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
                this.f16086e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.q0.b4.f fVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (fVar = this.f16086e.f16059c) == null) {
                    return;
                }
                fVar.q();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TbPageContext tbPageContext, c.a.q0.b4.f fVar) {
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
                    super((TbPageContext) objArr2[0], (c.a.q0.b4.f) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (tbPageContext == null) {
                return;
            }
            this.f16079j = (LinearLayout) this.f16057a.findViewById(R.id.home_write_article);
            this.k = (ImageView) this.f16057a.findViewById(R.id.home_write_article_icon);
            this.l = (TextView) this.f16057a.findViewById(R.id.home_write_article_title);
            this.f16076g = (LinearLayout) this.f16057a.findViewById(R.id.home_write_photo);
            this.f16077h = (ImageView) this.f16057a.findViewById(R.id.home_write_photo_icon);
            this.f16078i = (TextView) this.f16057a.findViewById(R.id.home_write_photo_title);
            this.m = (LinearLayout) this.f16057a.findViewById(R.id.home_write_album);
            this.n = (ImageView) this.f16057a.findViewById(R.id.home_write_album_icon);
            this.o = (TextView) this.f16057a.findViewById(R.id.home_write_album_title);
            this.p = (LinearLayout) this.f16057a.findViewById(R.id.home_write_live);
            this.q = (ImageView) this.f16057a.findViewById(R.id.home_write_live_icon);
            this.r = (TextView) this.f16057a.findViewById(R.id.home_write_live_title);
            this.p.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            this.s = (LinearLayout) this.f16057a.findViewById(R.id.home_write_vote);
            this.t = (ImageView) this.f16057a.findViewById(R.id.home_write_vote_icon);
            this.u = (TextView) this.f16057a.findViewById(R.id.home_write_vote_title);
            ((LinearLayout.LayoutParams) this.t.getLayoutParams()).topMargin = TbSingleton.getInstance().isShowStartLiveEntry() ? ((LinearLayout.LayoutParams) this.t.getLayoutParams()).topMargin : 0;
            this.v = (LinearLayout) this.f16057a.findViewById(R.id.home_write_score);
            this.w = (ImageView) this.f16057a.findViewById(R.id.home_write_score_icon);
            this.x = (TextView) this.f16057a.findViewById(R.id.home_write_score_title);
            this.y = (LinearLayout) this.f16057a.findViewById(R.id.home_write_commodity);
            this.z = (ImageView) this.f16057a.findViewById(R.id.home_write_commodity_icon);
            this.A = (TextView) this.f16057a.findViewById(R.id.home_write_commodity_title);
            this.B = (OvalActionButton) this.f16057a.findViewById(R.id.write_close_view);
            c.a.q0.b4.f fVar2 = this.f16059c;
            if (fVar2 != null && "frs".equals(fVar2.h())) {
                this.B.setIsCircle(true);
                this.B.setHasShadow(false);
            }
            this.f16075f = this.f16057a.findViewById(R.id.view_background_white);
            this.f16074e = this.f16057a.findViewById(R.id.view_background_translate);
            GridLayout gridLayout = (GridLayout) this.f16057a.findViewById(R.id.type_container);
            this.C = gridLayout;
            gridLayout.setMeasureAllChild(true);
            this.C.setVerNum(2);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.f16057a.findViewById(R.id.bottom_bar_background);
            this.D = tBLottieAnimationView;
            tBLottieAnimationView.setSpeed(1.2f);
            a();
            this.f16074e.setOnClickListener(this.f16060d);
            this.f16074e.setClickable(true);
            this.k.setOnClickListener(new View$OnClickListenerC0766a(this));
            this.f16077h.setOnClickListener(new b(this));
            this.n.setOnClickListener(new View$OnClickListenerC0767c(this));
            this.q.setOnClickListener(new d(this));
            this.s.setOnClickListener(new e(this));
            this.v.setOnClickListener(new f(this));
            this.y.setOnClickListener(new g(this));
        }

        @Override // c.a.q0.b4.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                float k = l.k(this.f16058b.getPageActivity());
                int i2 = (int) (0.13518518f * k);
                d(this.k, i2);
                d(this.f16077h, i2);
                d(this.n, i2);
                d(this.q, i2);
                d(this.t, i2);
                d(this.w, i2);
                d(this.z, i2);
                float g2 = (k * 1.0f) / l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
                ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds423) * g2);
                    this.C.setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams2 = this.f16075f.getLayoutParams();
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    int g3 = (int) (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1023) * g2);
                    if (g3 <= 0) {
                        g3 = 1023;
                    }
                    ((RelativeLayout.LayoutParams) layoutParams2).height = g3;
                    this.f16075f.setLayoutParams(layoutParams2);
                }
                ViewGroup.LayoutParams layoutParams3 = this.D.getLayoutParams();
                if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((l.g(TbadkCoreApplication.getInst(), R.dimen.tbds800) * g2) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.tbds135) * g2) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                    this.D.setLayoutParams(layoutParams3);
                }
            }
        }

        @Override // c.a.q0.b4.a
        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? LayoutInflater.from(this.f16058b.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null) : (View) invokeV.objValue;
        }

        @Override // c.a.q0.b4.a
        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.B.onChangeSkinType(i2);
                SkinManager.setLottieAnimation(this.D, R.raw.bottom_bar_bg);
                SkinManager.setBackgroundResource(this.f16075f, R.drawable.write_tab_background);
                SkinManager.setImageResource(this.f16077h, R.drawable.icon_mask_post_photograph56);
                SkinManager.setImageResource(this.k, R.drawable.icon_mask_post_text56);
                SkinManager.setImageResource(this.n, R.drawable.icon_mask_post_image56);
                SkinManager.setImageResource(this.q, R.drawable.icon_mask_post_live56);
                SkinManager.setImageResource(this.t, R.drawable.icon_mask_post_vote56);
                SkinManager.setImageResource(this.w, R.drawable.icon_mask_post_evaluation56);
                SkinManager.setImageResource(this.z, R.drawable.icon_mask_post_goods56);
                SkinManager.setViewTextColor(this.f16078i, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.u, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.x, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.A, R.color.CAM_X0107);
            }
        }

        public final void d(ImageView imageView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048579, this, imageView, i2) == null) || imageView == null || i2 <= 0) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = i2;
            imageView.setLayoutParams(layoutParams);
        }

        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
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
        this.f16060d = new View$OnClickListenerC0763a(this);
        this.f16058b = tbPageContext;
        this.f16059c = fVar;
        this.f16057a = b();
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
