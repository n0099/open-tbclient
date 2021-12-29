package c.a.t0.d1.i2;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.g.d;
import c.a.d.f.p.n;
import c.a.t0.d1.a1;
import c.a.t0.d1.b1;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.e1;
import c.a.t0.d1.f1;
import c.a.t0.d1.g1;
import c.a.t0.d1.i1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.f.g.c a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f16496b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f16497c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f16498d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.d.f.g.b f16499e;

    /* renamed from: f  reason: collision with root package name */
    public String f16500f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f16501g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f16502h;

    /* renamed from: i  reason: collision with root package name */
    public String f16503i;

    /* renamed from: j  reason: collision with root package name */
    public String f16504j;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f16505e;

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
            this.f16505e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16505e.a == null) {
                return;
            }
            this.f16505e.a.f(this.f16505e.f16497c);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
        }

        @Override // c.a.d.f.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a = null;
                this.a.f16501g.removeCallbacks(this.a.f16502h);
            }
        }

        @Override // c.a.d.f.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* renamed from: c.a.t0.d1.i2.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1016c implements c.a.d.f.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: c.a.t0.d1.i2.c$c$a */
        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.s.i0.n.a f16506e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ FollowUserButton f16507f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ C1016c f16508g;

            public a(C1016c c1016c, c.a.s0.s.i0.n.a aVar, FollowUserButton followUserButton) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1016c, aVar, followUserButton};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16508g = c1016c;
                this.f16506e = aVar;
                this.f16507f = followUserButton;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f16508g.a.f16498d != null) {
                        this.f16508g.a.f16498d.onClick(view);
                    }
                    this.f16506e.p(c1.CAM_X0109);
                    this.f16506e.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                    this.f16507f.setText(TbadkCoreApplication.getInst().getString(i1.followed));
                    this.f16507f.setClickable(false);
                    if (this.f16508g.a.f16502h != null) {
                        this.f16508g.a.f16501g.removeCallbacks(this.f16508g.a.f16502h);
                        this.f16508g.a.f16501g.postDelayed(this.f16508g.a.f16502h, 1000L);
                    }
                }
            }
        }

        public C1016c(c cVar) {
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
            this.a = cVar;
        }

        @Override // c.a.d.f.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // c.a.d.f.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // c.a.d.f.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(g1.frs_guide_tip, (ViewGroup) null);
                View findViewById = inflate.findViewById(f1.frs_guide_bg);
                BarImageView barImageView = (BarImageView) inflate.findViewById(f1.frs_guide_bar_icon);
                FollowUserButton followUserButton = (FollowUserButton) inflate.findViewById(f1.frs_guide_concern_btn);
                SkinManager.setViewTextColor((TextView) inflate.findViewById(f1.frs_guide_text), c1.CAM_X0302);
                barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                barImageView.setContentDescription(this.a.f16496b.getResources().getString(i1.bar_header));
                barImageView.setStrokeWith(n.f(this.a.f16496b, d1.tbds1));
                barImageView.setShowOval(true);
                barImageView.setPlaceHolder(1);
                barImageView.setShowOuterBorder(false);
                barImageView.setShowInnerBorder(true);
                barImageView.setStrokeColorResId(c1.CAM_X0401);
                if (!StringUtils.isNull(this.a.f16500f)) {
                    barImageView.startLoad(this.a.f16500f, 10, false);
                }
                c.a.s0.s.i0.n.a aVar = new c.a.s0.s.i0.n.a();
                aVar.p(c1.CAM_X0302);
                aVar.g(UtilHelper.getDimenPixelSize(d1.tbds28));
                aVar.i(e1.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
                aVar.f(UtilHelper.getDimenPixelSize(d1.tbds11));
                followUserButton.setConfig(aVar);
                followUserButton.setText(this.a.f16496b.getString(i1.attention));
                followUserButton.setOnClickListener(new a(this, aVar, followUserButton));
                TBSelector.makeShadowDrawable().setBgColor(c1.CAM_X0207).setShapeRadius(n.f(this.a.f16496b, d1.tbds21)).setShadowColor(c1.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(n.f(this.a.f16496b, d1.tbds10)).setOffsetX(0).setOffsetY(n.f(this.a.f16496b, d1.tbds5)).into(findViewById);
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // c.a.d.f.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.d.f.g.b
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f16509e;

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
            this.f16509e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16509e.a == null) {
                return;
            }
            this.f16509e.a.f(this.f16509e.f16497c);
            this.f16509e.f16497c.setVisibility(8);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
        }

        @Override // c.a.d.f.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a = null;
                this.a.f16501g.removeCallbacks(this.a.f16502h);
            }
        }

        @Override // c.a.d.f.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements c.a.d.f.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f16510e;

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
                this.f16510e = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (MessageManager.getInstance().findTask(2002015) != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("_forumId", this.f16510e.a.f16504j);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new c.a.t0.w3.j0.n(TbadkCoreApplication.getInst().getApplicationContext(), "ForumAppealPage", hashMap)));
                    }
                    if (this.f16510e.a.f16502h != null) {
                        this.f16510e.a.f16501g.removeCallbacks(this.f16510e.a.f16502h);
                        this.f16510e.a.f16501g.postDelayed(this.f16510e.a.f16502h, 1000L);
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
            this.a = cVar;
        }

        @Override // c.a.d.f.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // c.a.d.f.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // c.a.d.f.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(g1.frs_guide_delete_thread_tip, (ViewGroup) null);
                EMTextView eMTextView = (EMTextView) inflate.findViewById(f1.frs_guide_delete_thread_tip_describe);
                SkinManager.setViewTextColor(eMTextView, c1.CAM_X0302);
                eMTextView.setText(this.a.f16503i);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(f1.frs_guide_delete_thread_tip_button);
                c.a.s0.s.i0.n.b bVar = new c.a.s0.s.i0.n.b();
                bVar.p(c1.CAM_X0302, c1.CAM_X0101);
                tBSpecificationBtn.setConfig(bVar);
                tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getString(i1.frs_guide_delete_thread_tip_button));
                tBSpecificationBtn.setOnClickListener(new a(this));
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // c.a.d.f.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.d.f.g.b
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
        this.f16501g = new Handler();
        this.f16496b = activity;
        this.f16497c = (ViewGroup) activity.findViewById(i2);
    }

    public final c.a.d.f.g.b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C1016c(this) : (c.a.d.f.g.b) invokeV.objValue;
    }

    public final c.a.d.f.g.b l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new f(this) : (c.a.d.f.g.b) invokeV.objValue;
    }

    public void m() {
        c.a.d.f.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cVar = this.a) == null) {
            return;
        }
        cVar.f(this.f16497c);
        this.f16497c.setVisibility(8);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f16500f = str;
        }
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f16498d = onClickListener;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f16503i = str;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f16504j = str;
        }
    }

    public void r() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (viewGroup = this.f16497c) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        c.a.d.f.g.c cVar = this.a;
        if (cVar != null) {
            cVar.f(this.f16497c);
        }
        this.f16502h = new d(this);
        c.a.d.f.g.d dVar = new c.a.d.f.g.d();
        dVar.d(true);
        dVar.g(new e(this));
        if (this.f16499e == null) {
            this.f16499e = l();
        }
        dVar.a(this.f16499e);
        dVar.e(a1.frs_guide_tip_enter);
        dVar.f(a1.frs_guide_tip_out);
        c.a.d.f.g.c b2 = dVar.b();
        this.a = b2;
        b2.u(this.f16496b, this.f16497c, false);
        c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.f16497c);
        d2.n(i1.J_X05);
        d2.u(b1.S_O_X004);
        d2.f(c1.CAM_X0207);
        this.f16501g.postDelayed(this.f16502h, 5000L);
    }

    public void s() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (viewGroup = this.f16497c) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        c.a.d.f.g.c cVar = this.a;
        if (cVar != null) {
            cVar.f(this.f16497c);
        }
        this.f16502h = new a(this);
        c.a.d.f.g.d dVar = new c.a.d.f.g.d();
        dVar.d(true);
        dVar.g(new b(this));
        if (this.f16499e == null) {
            this.f16499e = k();
        }
        dVar.a(this.f16499e);
        dVar.e(a1.frs_guide_tip_enter);
        dVar.f(a1.frs_guide_tip_out);
        c.a.d.f.g.c b2 = dVar.b();
        this.a = b2;
        b2.u(this.f16496b, this.f16497c, false);
        this.f16501g.postDelayed(this.f16502h, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
    }
}
