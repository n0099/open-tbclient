package b.a.r0.x0;

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
/* loaded from: classes5.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f26772a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f26773b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26774c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26775d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26776e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f26777f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f26778g;

    /* renamed from: h  reason: collision with root package name */
    public PermissionJudgePolicy f26779h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.r0.k2.u.f.w0 f26780i;
    public Bitmap j;
    public e k;
    public View l;
    public String m;
    public String n;
    public d o;
    public int p;
    public View.OnClickListener q;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ y f26781e;

        public a(y yVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26781e = yVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Bitmap m = this.f26781e.m();
                if (view.getId() == this.f26781e.f26773b.getId()) {
                    this.f26781e.p(m);
                } else if (view.getId() == this.f26781e.f26774c.getId()) {
                    this.f26781e.u(m, 3);
                } else if (view.getId() == this.f26781e.f26775d.getId()) {
                    this.f26781e.u(m, 2);
                } else if (view.getId() == this.f26781e.f26776e.getId()) {
                    this.f26781e.u(m, 4);
                } else if (view.getId() == this.f26781e.f26777f.getId()) {
                    this.f26781e.u(m, 8);
                } else if (view.getId() == this.f26781e.f26778g.getId()) {
                    this.f26781e.u(m, 6);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends b.a.q0.d1.i0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f26782a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f26783b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ y f26784c;

        public b(y yVar, Bitmap bitmap, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar, bitmap, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26784c = yVar;
            this.f26782a = bitmap;
            this.f26783b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.d1.i0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26784c.l(this.f26782a, this.f26783b) : (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements b.a.q0.d1.q<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f26785a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ y f26786b;

        public c(y yVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26786b = yVar;
            this.f26785a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f26786b.f26772a.getPageActivity(), this.f26785a, shareItem, false));
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a();

        void b();
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(int i2);
    }

    public y(TbPageContext tbPageContext) {
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
        this.f26772a = tbPageContext;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f26779h == null) {
                this.f26779h = new PermissionJudgePolicy();
            }
            this.f26779h.clearRequestPermissionList();
            this.f26779h.appendRequestPermission(this.f26772a.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            return this.f26779h.startRequestPermission(this.f26772a.getPageActivity());
        }
        return invokeV.booleanValue;
    }

    public final ShareItem l(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, i2)) == null) {
            ShareItem shareItem = new ShareItem();
            shareItem.g0 = false;
            shareItem.f0 = false;
            shareItem.Z = 1;
            if (i2 == 6) {
                shareItem.r = this.f26772a.getString(h1.come_on_look_forum) + PreferencesUtil.LEFT_MOUNT + this.n + this.f26772a.getString(h1.core_bar) + PreferencesUtil.RIGHT_MOUNT + "@" + this.f26772a.getString(h1.tieba_text) + "https://tieba.baidu.com/f?kw=" + b.a.e.e.p.k.getUrlEncode(this.n) + "&fr=frsshare";
            } else {
                shareItem.r = this.f26772a.getString(h1.app_name);
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
            if (this.j == null) {
                d dVar = this.o;
                if (dVar != null) {
                    dVar.a();
                }
                this.l.buildDrawingCache();
                this.j = this.l.getDrawingCache();
                d dVar2 = this.o;
                if (dVar2 != null) {
                    dVar2.b();
                }
            }
            return this.j;
        }
        return (Bitmap) invokeV.objValue;
    }

    public final int n() {
        InterceptResult invokeV;
        int k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int g2 = b.a.e.e.p.l.g(this.f26772a.getPageActivity(), c1.tbds44);
            int g3 = b.a.e.e.p.l.g(this.f26772a.getPageActivity(), c1.tbds54);
            if (UtilHelper.getRealScreenOrientation(this.f26772a.getPageActivity()) == 2) {
                k = b.a.e.e.p.l.i(this.f26772a.getPageActivity());
            } else {
                k = b.a.e.e.p.l.k(this.f26772a.getPageActivity());
            }
            return ((k - (g2 * 2)) - g3) / 6;
        }
        return invokeV.intValue;
    }

    public void o(View view, View view2, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, view, view2, dVar) == null) || view == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(e1.frs_private_share_download);
        this.f26773b = textView;
        t(textView, new SvgMaskType(d1.icon_mask_frs_private_share_download40_svg));
        this.f26773b.setOnClickListener(this.q);
        TextView textView2 = (TextView) view.findViewById(e1.frs_private_share_wechat);
        this.f26774c = textView2;
        t(textView2, new SvgMaskType(d1.icon_mask_share_wechat40_svg));
        this.f26774c.setOnClickListener(this.q);
        TextView textView3 = (TextView) view.findViewById(e1.frs_private_share_moment);
        this.f26775d = textView3;
        t(textView3, new SvgMaskType(d1.icon_mask_share_circle40_svg));
        this.f26775d.setOnClickListener(this.q);
        TextView textView4 = (TextView) view.findViewById(e1.frs_private_share_qzone);
        this.f26776e = textView4;
        t(textView4, new SvgMaskType(d1.icon_mask_share_qqzone40_svg));
        this.f26776e.setOnClickListener(this.q);
        TextView textView5 = (TextView) view.findViewById(e1.frs_private_share_qq);
        this.f26777f = textView5;
        t(textView5, new SvgMaskType(d1.icon_mask_share_qq40_svg));
        this.f26777f.setOnClickListener(this.q);
        TextView textView6 = (TextView) view.findViewById(e1.frs_private_share_weibo);
        this.f26778g = textView6;
        t(textView6, new SvgMaskType(d1.icon_mask_share_weibo40_svg));
        this.f26778g.setOnClickListener(this.q);
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
        if (this.f26780i == null) {
            this.f26780i = new b.a.r0.k2.u.f.w0(this.f26772a);
        }
        this.f26780i.b(this.m, BitmapHelper.Bitmap2Bytes(bitmap, 100));
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
        int g2 = b.a.e.e.p.l.g(this.f26772a.getPageActivity(), c1.tbds88);
        drawable.setBounds(0, 0, g2, g2);
        textView.setCompoundDrawables(null, drawable, null, null);
        SkinManager.setViewTextColor(textView, b1.CAM_X0106);
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
        b.a.q0.d1.l0.b(new b(this, bitmap, i2), new c(this, i2));
    }
}
