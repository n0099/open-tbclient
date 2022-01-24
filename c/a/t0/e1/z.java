package c.a.t0.e1;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17217b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17218c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17219d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17220e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17221f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17222g;

    /* renamed from: h  reason: collision with root package name */
    public PermissionJudgePolicy f17223h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.t0.t2.u.f.y0 f17224i;

    /* renamed from: j  reason: collision with root package name */
    public Bitmap f17225j;
    public e k;
    public View l;
    public String m;
    public String n;
    public d o;
    public int p;
    public View.OnClickListener q;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ z f17226e;

        public a(z zVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17226e = zVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Bitmap m = this.f17226e.m();
                if (view.getId() == this.f17226e.f17217b.getId()) {
                    this.f17226e.p(m);
                } else if (view.getId() == this.f17226e.f17218c.getId()) {
                    this.f17226e.u(m, 3);
                } else if (view.getId() == this.f17226e.f17219d.getId()) {
                    this.f17226e.u(m, 2);
                } else if (view.getId() == this.f17226e.f17220e.getId()) {
                    this.f17226e.u(m, 4);
                } else if (view.getId() == this.f17226e.f17221f.getId()) {
                    this.f17226e.u(m, 8);
                } else if (view.getId() == this.f17226e.f17222g.getId()) {
                    this.f17226e.u(m, 6);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends c.a.s0.d1.k0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bitmap a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f17227b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ z f17228c;

        public b(z zVar, Bitmap bitmap, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar, bitmap, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17228c = zVar;
            this.a = bitmap;
            this.f17227b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.d1.k0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17228c.l(this.a, this.f17227b) : (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements c.a.s0.d1.s<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f17229b;

        public c(z zVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17229b = zVar;
            this.a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.d1.s
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f17229b.a.getPageActivity(), this.a, shareItem, false));
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a();

        void b();
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(int i2);
    }

    public z(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new a(this);
        this.a = tbPageContext;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f17223h == null) {
                this.f17223h = new PermissionJudgePolicy();
            }
            this.f17223h.clearRequestPermissionList();
            this.f17223h.appendRequestPermission(this.a.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            return this.f17223h.startRequestPermission(this.a.getPageActivity());
        }
        return invokeV.booleanValue;
    }

    public final ShareItem l(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, i2)) == null) {
            ShareItem shareItem = new ShareItem();
            shareItem.i0 = false;
            shareItem.h0 = false;
            shareItem.b0 = 1;
            if (i2 == 6) {
                shareItem.r = this.a.getString(i1.come_on_look_forum) + PreferencesUtil.LEFT_MOUNT + this.n + this.a.getString(i1.core_bar) + PreferencesUtil.RIGHT_MOUNT + "@" + this.a.getString(i1.tieba_text) + "https://tieba.baidu.com/f?kw=" + c.a.d.f.p.m.getUrlEncode(this.n) + "&fr=frsshare";
            } else {
                shareItem.r = this.a.getString(i1.app_name);
            }
            shareItem.s = "";
            shareItem.i(bitmap);
            shareItem.g();
            return shareItem;
        }
        return (ShareItem) invokeLI.objValue;
    }

    public Bitmap m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f17225j == null) {
                d dVar = this.o;
                if (dVar != null) {
                    dVar.a();
                }
                this.l.buildDrawingCache();
                this.f17225j = this.l.getDrawingCache();
                d dVar2 = this.o;
                if (dVar2 != null) {
                    dVar2.b();
                }
            }
            return this.f17225j;
        }
        return (Bitmap) invokeV.objValue;
    }

    public final int n() {
        InterceptResult invokeV;
        int k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int f2 = c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds44);
            int f3 = c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds54);
            if (UtilHelper.getRealScreenOrientation(this.a.getPageActivity()) == 2) {
                k = c.a.d.f.p.n.i(this.a.getPageActivity());
            } else {
                k = c.a.d.f.p.n.k(this.a.getPageActivity());
            }
            return ((k - (f2 * 2)) - f3) / 6;
        }
        return invokeV.intValue;
    }

    public void o(View view, View view2, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, view, view2, dVar) == null) || view == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(f1.frs_private_share_download);
        this.f17217b = textView;
        t(textView, new SvgMaskType(e1.icon_mask_frs_private_share_download40_svg));
        this.f17217b.setOnClickListener(this.q);
        TextView textView2 = (TextView) view.findViewById(f1.frs_private_share_wechat);
        this.f17218c = textView2;
        t(textView2, new SvgMaskType(e1.icon_mask_share_wechat40_svg));
        this.f17218c.setOnClickListener(this.q);
        TextView textView3 = (TextView) view.findViewById(f1.frs_private_share_moment);
        this.f17219d = textView3;
        t(textView3, new SvgMaskType(e1.icon_mask_share_circle40_svg));
        this.f17219d.setOnClickListener(this.q);
        TextView textView4 = (TextView) view.findViewById(f1.frs_private_share_qzone);
        this.f17220e = textView4;
        t(textView4, new SvgMaskType(e1.icon_mask_share_qqzone40_svg));
        this.f17220e.setOnClickListener(this.q);
        TextView textView5 = (TextView) view.findViewById(f1.frs_private_share_qq);
        this.f17221f = textView5;
        t(textView5, new SvgMaskType(e1.icon_mask_share_qq40_svg));
        this.f17221f.setOnClickListener(this.q);
        TextView textView6 = (TextView) view.findViewById(f1.frs_private_share_weibo);
        this.f17222g = textView6;
        t(textView6, new SvgMaskType(e1.icon_mask_share_weibo40_svg));
        this.f17222g.setOnClickListener(this.q);
        this.l = view2;
        this.o = dVar;
    }

    public final void p(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bitmap) == null) || k()) {
            return;
        }
        e eVar = this.k;
        if (eVar != null) {
            eVar.a(1);
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
        statisticItem.param("obj_type", 1);
        statisticItem.param("obj_source", this.p);
        TiebaStatic.log(statisticItem);
        if (this.f17224i == null) {
            this.f17224i = new c.a.t0.t2.u.f.y0(this.a);
        }
        this.f17224i.b(this.m, BitmapHelper.Bitmap2Bytes(bitmap, 100));
    }

    public void q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            this.m = str;
            this.n = str2;
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.p = i2;
        }
    }

    public void s(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.k = eVar;
        }
    }

    public final void t(TextView textView, AbsSvgType absSvgType) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, textView, absSvgType) == null) || absSvgType == null || (drawable = absSvgType.getDrawable()) == null) {
            return;
        }
        int f2 = c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds88);
        drawable.setBounds(0, 0, f2, f2);
        textView.setCompoundDrawables(null, drawable, null, null);
        SkinManager.setViewTextColor(textView, c1.CAM_X0106);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = n();
        textView.setLayoutParams(layoutParams);
    }

    public final void u(Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048586, this, bitmap, i2) == null) || bitmap == null || k()) {
            return;
        }
        int i3 = 1;
        if (i2 == 3) {
            i3 = 2;
        } else if (i2 == 2) {
            i3 = 3;
        } else if (i2 == 4) {
            i3 = 4;
        } else if (i2 == 8) {
            i3 = 5;
        } else if (i2 == 6) {
            i3 = 6;
        }
        e eVar = this.k;
        if (eVar != null) {
            eVar.a(i3);
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
        if (i2 == 3) {
            statisticItem.param("obj_type", 2);
        } else if (i2 == 2) {
            statisticItem.param("obj_type", 3);
        } else if (i2 == 8) {
            statisticItem.param("obj_type", 4);
        } else if (i2 == 4) {
            statisticItem.param("obj_type", 5);
        } else if (i2 == 6) {
            statisticItem.param("obj_type", 6);
        }
        statisticItem.param("obj_source", this.p);
        TiebaStatic.log(statisticItem);
        c.a.s0.d1.n0.b(new b(this, bitmap, i2), new c(this, i2));
    }
}
