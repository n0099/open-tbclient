package c.a.q0.v0.w1;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.g.d;
import c.a.e.e.p.l;
import c.a.q0.i3.i0.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.e.e.g.c f27321a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f27322b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f27323c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f27324d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.e.e.g.b f27325e;

    /* renamed from: f  reason: collision with root package name */
    public String f27326f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f27327g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f27328h;

    /* renamed from: i  reason: collision with root package name */
    public String f27329i;

    /* renamed from: j  reason: collision with root package name */
    public String f27330j;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f27331e;

        public a(c cVar) {
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
            this.f27331e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f27331e.f27321a == null) {
                return;
            }
            this.f27331e.f27321a.e(this.f27331e.f27323c);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f27332a;

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
            this.f27332a = cVar;
        }

        @Override // c.a.e.e.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27332a.f27321a = null;
                this.f27332a.f27327g.removeCallbacks(this.f27332a.f27328h);
            }
        }

        @Override // c.a.e.e.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* renamed from: c.a.q0.v0.w1.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1279c implements c.a.e.e.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f27333a;

        /* renamed from: c.a.q0.v0.w1.c$c$a */
        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.s.f0.n.a f27334e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ FollowUserButton f27335f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ C1279c f27336g;

            public a(C1279c c1279c, c.a.p0.s.f0.n.a aVar, FollowUserButton followUserButton) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1279c, aVar, followUserButton};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f27336g = c1279c;
                this.f27334e = aVar;
                this.f27335f = followUserButton;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f27336g.f27333a.f27324d != null) {
                        this.f27336g.f27333a.f27324d.onClick(view);
                    }
                    this.f27334e.o(R.color.CAM_X0109);
                    this.f27334e.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                    this.f27335f.setText(TbadkCoreApplication.getInst().getString(R.string.followed));
                    this.f27335f.setClickable(false);
                    if (this.f27336g.f27333a.f27328h != null) {
                        this.f27336g.f27333a.f27327g.removeCallbacks(this.f27336g.f27333a.f27328h);
                        this.f27336g.f27333a.f27327g.postDelayed(this.f27336g.f27333a.f27328h, 1000L);
                    }
                }
            }
        }

        public C1279c(c cVar) {
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
            this.f27333a = cVar;
        }

        @Override // c.a.e.e.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // c.a.e.e.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // c.a.e.e.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.frs_guide_tip, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.frs_guide_bg);
                BarImageView barImageView = (BarImageView) inflate.findViewById(R.id.frs_guide_bar_icon);
                FollowUserButton followUserButton = (FollowUserButton) inflate.findViewById(R.id.frs_guide_concern_btn);
                SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.frs_guide_text), R.color.CAM_X0302);
                barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                barImageView.setContentDescription(this.f27333a.f27322b.getResources().getString(R.string.bar_header));
                barImageView.setStrokeWith(l.g(this.f27333a.f27322b, R.dimen.tbds1));
                barImageView.setShowOval(true);
                barImageView.setPlaceHolder(1);
                barImageView.setShowOuterBorder(false);
                barImageView.setShowInnerBorder(true);
                barImageView.setStrokeColorResId(R.color.CAM_X0401);
                if (!StringUtils.isNull(this.f27333a.f27326f)) {
                    barImageView.startLoad(this.f27333a.f27326f, 10, false);
                }
                c.a.p0.s.f0.n.a aVar = new c.a.p0.s.f0.n.a();
                aVar.o(R.color.CAM_X0302);
                aVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds28));
                aVar.i(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
                aVar.f(UtilHelper.getDimenPixelSize(R.dimen.tbds11));
                followUserButton.setConfig(aVar);
                followUserButton.setText(this.f27333a.f27322b.getString(R.string.attention));
                followUserButton.setOnClickListener(new a(this, aVar, followUserButton));
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(l.g(this.f27333a.f27322b, R.dimen.tbds21)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.f27333a.f27322b, R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.f27333a.f27322b, R.dimen.tbds5)).into(findViewById);
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // c.a.e.e.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.e.e.g.b
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f27337e;

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
            this.f27337e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f27337e.f27321a == null) {
                return;
            }
            this.f27337e.f27321a.e(this.f27337e.f27323c);
            this.f27337e.f27323c.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f27338a;

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
            this.f27338a = cVar;
        }

        @Override // c.a.e.e.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27338a.f27321a = null;
                this.f27338a.f27327g.removeCallbacks(this.f27338a.f27328h);
            }
        }

        @Override // c.a.e.e.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements c.a.e.e.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f27339a;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f27340e;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f27340e = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (MessageManager.getInstance().findTask(2002015) != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("_forumId", this.f27340e.f27339a.f27330j);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new n(TbadkCoreApplication.getInst().getApplicationContext(), "ForumAppealPage", hashMap)));
                    }
                    if (this.f27340e.f27339a.f27328h != null) {
                        this.f27340e.f27339a.f27327g.removeCallbacks(this.f27340e.f27339a.f27328h);
                        this.f27340e.f27339a.f27327g.postDelayed(this.f27340e.f27339a.f27328h, 1000L);
                    }
                }
            }
        }

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
            this.f27339a = cVar;
        }

        @Override // c.a.e.e.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // c.a.e.e.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // c.a.e.e.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.frs_guide_delete_thread_tip, (ViewGroup) null);
                EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.frs_guide_delete_thread_tip_describe);
                SkinManager.setViewTextColor(eMTextView, R.color.CAM_X0302);
                eMTextView.setText(this.f27339a.f27329i);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.frs_guide_delete_thread_tip_button);
                c.a.p0.s.f0.n.b bVar = new c.a.p0.s.f0.n.b();
                bVar.o(R.color.CAM_X0302, R.color.CAM_X0101);
                tBSpecificationBtn.setConfig(bVar);
                tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getString(R.string.frs_guide_delete_thread_tip_button));
                tBSpecificationBtn.setOnClickListener(new a(this));
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // c.a.e.e.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.e.e.g.b
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    public c(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27327g = new Handler();
        this.f27322b = activity;
        this.f27323c = (ViewGroup) activity.findViewById(i2);
    }

    public final c.a.e.e.g.b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C1279c(this) : (c.a.e.e.g.b) invokeV.objValue;
    }

    public final c.a.e.e.g.b l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new f(this) : (c.a.e.e.g.b) invokeV.objValue;
    }

    public void m() {
        c.a.e.e.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cVar = this.f27321a) == null) {
            return;
        }
        cVar.e(this.f27323c);
        this.f27323c.setVisibility(8);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f27326f = str;
        }
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f27324d = onClickListener;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f27329i = str;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f27330j = str;
        }
    }

    public void r() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (viewGroup = this.f27323c) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        c.a.e.e.g.c cVar = this.f27321a;
        if (cVar != null) {
            cVar.e(this.f27323c);
        }
        this.f27328h = new d(this);
        c.a.e.e.g.d dVar = new c.a.e.e.g.d();
        dVar.d(true);
        dVar.g(new e(this));
        if (this.f27325e == null) {
            this.f27325e = l();
        }
        dVar.a(this.f27325e);
        dVar.e(R.anim.frs_guide_tip_enter);
        dVar.f(R.anim.frs_guide_tip_out);
        c.a.e.e.g.c b2 = dVar.b();
        this.f27321a = b2;
        b2.q(this.f27322b, this.f27323c, false);
        c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(this.f27323c);
        d2.n(R.string.J_X05);
        d2.t(R.array.S_O_X004);
        d2.f(R.color.CAM_X0207);
        this.f27327g.postDelayed(this.f27328h, 5000L);
    }

    public void s() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (viewGroup = this.f27323c) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        c.a.e.e.g.c cVar = this.f27321a;
        if (cVar != null) {
            cVar.e(this.f27323c);
        }
        this.f27328h = new a(this);
        c.a.e.e.g.d dVar = new c.a.e.e.g.d();
        dVar.d(true);
        dVar.g(new b(this));
        if (this.f27325e == null) {
            this.f27325e = k();
        }
        dVar.a(this.f27325e);
        dVar.e(R.anim.frs_guide_tip_enter);
        dVar.f(R.anim.frs_guide_tip_out);
        c.a.e.e.g.c b2 = dVar.b();
        this.f27321a = b2;
        b2.q(this.f27322b, this.f27323c, false);
        this.f27327g.postDelayed(this.f27328h, 4000L);
    }
}
