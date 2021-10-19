package c.a.r0.x0.x1;

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
import c.a.r0.k3.i0.n;
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
    public c.a.e.e.g.c f28183a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f28184b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f28185c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f28186d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.e.e.g.b f28187e;

    /* renamed from: f  reason: collision with root package name */
    public String f28188f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f28189g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f28190h;

    /* renamed from: i  reason: collision with root package name */
    public String f28191i;

    /* renamed from: j  reason: collision with root package name */
    public String f28192j;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f28193e;

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
            this.f28193e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f28193e.f28183a == null) {
                return;
            }
            this.f28193e.f28183a.e(this.f28193e.f28185c);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f28194a;

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
            this.f28194a = cVar;
        }

        @Override // c.a.e.e.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28194a.f28183a = null;
                this.f28194a.f28189g.removeCallbacks(this.f28194a.f28190h);
            }
        }

        @Override // c.a.e.e.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* renamed from: c.a.r0.x0.x1.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1325c implements c.a.e.e.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f28195a;

        /* renamed from: c.a.r0.x0.x1.c$c$a */
        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.s.f0.n.a f28196e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ FollowUserButton f28197f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ C1325c f28198g;

            public a(C1325c c1325c, c.a.q0.s.f0.n.a aVar, FollowUserButton followUserButton) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1325c, aVar, followUserButton};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f28198g = c1325c;
                this.f28196e = aVar;
                this.f28197f = followUserButton;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f28198g.f28195a.f28186d != null) {
                        this.f28198g.f28195a.f28186d.onClick(view);
                    }
                    this.f28196e.p(R.color.CAM_X0109);
                    this.f28196e.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                    this.f28197f.setText(TbadkCoreApplication.getInst().getString(R.string.followed));
                    this.f28197f.setClickable(false);
                    if (this.f28198g.f28195a.f28190h != null) {
                        this.f28198g.f28195a.f28189g.removeCallbacks(this.f28198g.f28195a.f28190h);
                        this.f28198g.f28195a.f28189g.postDelayed(this.f28198g.f28195a.f28190h, 1000L);
                    }
                }
            }
        }

        public C1325c(c cVar) {
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
            this.f28195a = cVar;
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
                barImageView.setContentDescription(this.f28195a.f28184b.getResources().getString(R.string.bar_header));
                barImageView.setStrokeWith(l.g(this.f28195a.f28184b, R.dimen.tbds1));
                barImageView.setShowOval(true);
                barImageView.setPlaceHolder(1);
                barImageView.setShowOuterBorder(false);
                barImageView.setShowInnerBorder(true);
                barImageView.setStrokeColorResId(R.color.CAM_X0401);
                if (!StringUtils.isNull(this.f28195a.f28188f)) {
                    barImageView.startLoad(this.f28195a.f28188f, 10, false);
                }
                c.a.q0.s.f0.n.a aVar = new c.a.q0.s.f0.n.a();
                aVar.p(R.color.CAM_X0302);
                aVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds28));
                aVar.i(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
                aVar.f(UtilHelper.getDimenPixelSize(R.dimen.tbds11));
                followUserButton.setConfig(aVar);
                followUserButton.setText(this.f28195a.f28184b.getString(R.string.attention));
                followUserButton.setOnClickListener(new a(this, aVar, followUserButton));
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(l.g(this.f28195a.f28184b, R.dimen.tbds21)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.f28195a.f28184b, R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.f28195a.f28184b, R.dimen.tbds5)).into(findViewById);
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
        public final /* synthetic */ c f28199e;

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
            this.f28199e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f28199e.f28183a == null) {
                return;
            }
            this.f28199e.f28183a.e(this.f28199e.f28185c);
            this.f28199e.f28185c.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f28200a;

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
            this.f28200a = cVar;
        }

        @Override // c.a.e.e.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28200a.f28183a = null;
                this.f28200a.f28189g.removeCallbacks(this.f28200a.f28190h);
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
        public final /* synthetic */ c f28201a;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f28202e;

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
                this.f28202e = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (MessageManager.getInstance().findTask(2002015) != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("_forumId", this.f28202e.f28201a.f28192j);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new n(TbadkCoreApplication.getInst().getApplicationContext(), "ForumAppealPage", hashMap)));
                    }
                    if (this.f28202e.f28201a.f28190h != null) {
                        this.f28202e.f28201a.f28189g.removeCallbacks(this.f28202e.f28201a.f28190h);
                        this.f28202e.f28201a.f28189g.postDelayed(this.f28202e.f28201a.f28190h, 1000L);
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
            this.f28201a = cVar;
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
                eMTextView.setText(this.f28201a.f28191i);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.frs_guide_delete_thread_tip_button);
                c.a.q0.s.f0.n.b bVar = new c.a.q0.s.f0.n.b();
                bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
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
        this.f28189g = new Handler();
        this.f28184b = activity;
        this.f28185c = (ViewGroup) activity.findViewById(i2);
    }

    public final c.a.e.e.g.b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C1325c(this) : (c.a.e.e.g.b) invokeV.objValue;
    }

    public final c.a.e.e.g.b l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new f(this) : (c.a.e.e.g.b) invokeV.objValue;
    }

    public void m() {
        c.a.e.e.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cVar = this.f28183a) == null) {
            return;
        }
        cVar.e(this.f28185c);
        this.f28185c.setVisibility(8);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f28188f = str;
        }
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f28186d = onClickListener;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f28191i = str;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f28192j = str;
        }
    }

    public void r() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (viewGroup = this.f28185c) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        c.a.e.e.g.c cVar = this.f28183a;
        if (cVar != null) {
            cVar.e(this.f28185c);
        }
        this.f28190h = new d(this);
        c.a.e.e.g.d dVar = new c.a.e.e.g.d();
        dVar.d(true);
        dVar.g(new e(this));
        if (this.f28187e == null) {
            this.f28187e = l();
        }
        dVar.a(this.f28187e);
        dVar.e(R.anim.frs_guide_tip_enter);
        dVar.f(R.anim.frs_guide_tip_out);
        c.a.e.e.g.c b2 = dVar.b();
        this.f28183a = b2;
        b2.q(this.f28184b, this.f28185c, false);
        c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f28185c);
        d2.n(R.string.J_X05);
        d2.u(R.array.S_O_X004);
        d2.f(R.color.CAM_X0207);
        this.f28189g.postDelayed(this.f28190h, 5000L);
    }

    public void s() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (viewGroup = this.f28185c) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        c.a.e.e.g.c cVar = this.f28183a;
        if (cVar != null) {
            cVar.e(this.f28185c);
        }
        this.f28190h = new a(this);
        c.a.e.e.g.d dVar = new c.a.e.e.g.d();
        dVar.d(true);
        dVar.g(new b(this));
        if (this.f28187e == null) {
            this.f28187e = k();
        }
        dVar.a(this.f28187e);
        dVar.e(R.anim.frs_guide_tip_enter);
        dVar.f(R.anim.frs_guide_tip_out);
        c.a.e.e.g.c b2 = dVar.b();
        this.f28183a = b2;
        b2.q(this.f28184b, this.f28185c, false);
        this.f28189g.postDelayed(this.f28190h, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
    }
}
