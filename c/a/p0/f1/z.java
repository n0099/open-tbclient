package c.a.p0.f1;

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
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f14882b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14883c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f14884d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f14885e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f14886f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14887g;

    /* renamed from: h  reason: collision with root package name */
    public PermissionJudgePolicy f14888h;
    public c.a.p0.w2.m.f.e1 i;
    public Bitmap j;
    public e k;
    public View l;
    public String m;
    public String n;
    public d o;
    public int p;
    public View.OnClickListener q;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z a;

        public a(z zVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Bitmap m = this.a.m();
                if (view.getId() == this.a.f14882b.getId()) {
                    this.a.p(m);
                } else if (view.getId() == this.a.f14883c.getId()) {
                    this.a.u(m, 3);
                } else if (view.getId() == this.a.f14884d.getId()) {
                    this.a.u(m, 2);
                } else if (view.getId() == this.a.f14885e.getId()) {
                    this.a.u(m, 4);
                } else if (view.getId() == this.a.f14886f.getId()) {
                    this.a.u(m, 8);
                } else if (view.getId() == this.a.f14887g.getId()) {
                    this.a.u(m, 6);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends c.a.o0.c1.k0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bitmap a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f14889b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ z f14890c;

        public b(z zVar, Bitmap bitmap, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar, bitmap, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14890c = zVar;
            this.a = bitmap;
            this.f14889b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.c1.k0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14890c.l(this.a, this.f14889b) : (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements c.a.o0.c1.s<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f14891b;

        public c(z zVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14891b = zVar;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.c1.s
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f14891b.a.getPageActivity(), this.a, shareItem, false));
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a();

        void b();
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(int i);
    }

    public z(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            if (this.f14888h == null) {
                this.f14888h = new PermissionJudgePolicy();
            }
            this.f14888h.clearRequestPermissionList();
            this.f14888h.appendRequestPermission(this.a.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            return this.f14888h.startRequestPermission(this.a.getPageActivity());
        }
        return invokeV.booleanValue;
    }

    public final ShareItem l(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, i)) == null) {
            ShareItem shareItem = new ShareItem();
            shareItem.i0 = false;
            shareItem.h0 = false;
            shareItem.b0 = 1;
            if (i == 6) {
                shareItem.r = this.a.getString(R.string.obfuscated_res_0x7f0f03f1) + PreferencesUtil.LEFT_MOUNT + this.n + this.a.getString(R.string.obfuscated_res_0x7f0f043c) + PreferencesUtil.RIGHT_MOUNT + "@" + this.a.getString(R.string.obfuscated_res_0x7f0f13b8) + "https://tieba.baidu.com/f?kw=" + c.a.d.f.p.m.getUrlEncode(this.n) + "&fr=frsshare";
            } else {
                shareItem.r = this.a.getString(R.string.obfuscated_res_0x7f0f029e);
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
            int f2 = c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds44);
            int f3 = c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds54);
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
        TextView textView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090bb6);
        this.f14882b = textView;
        t(textView, new SvgMaskType(R.drawable.obfuscated_res_0x7f0807de));
        this.f14882b.setOnClickListener(this.q);
        TextView textView2 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090bbf);
        this.f14883c = textView2;
        t(textView2, new SvgMaskType(R.drawable.obfuscated_res_0x7f080823));
        this.f14883c.setOnClickListener(this.q);
        TextView textView3 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090bb7);
        this.f14884d = textView3;
        t(textView3, new SvgMaskType(R.drawable.obfuscated_res_0x7f08081f));
        this.f14884d.setOnClickListener(this.q);
        TextView textView4 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090bbc);
        this.f14885e = textView4;
        t(textView4, new SvgMaskType(R.drawable.obfuscated_res_0x7f080821));
        this.f14885e.setOnClickListener(this.q);
        TextView textView5 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090bba);
        this.f14886f = textView5;
        t(textView5, new SvgMaskType(R.drawable.obfuscated_res_0x7f080820));
        this.f14886f.setOnClickListener(this.q);
        TextView textView6 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090bc0);
        this.f14887g = textView6;
        t(textView6, new SvgMaskType(R.drawable.obfuscated_res_0x7f080824));
        this.f14887g.setOnClickListener(this.q);
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
        if (this.i == null) {
            this.i = new c.a.p0.w2.m.f.e1(this.a);
        }
        this.i.b(this.m, BitmapHelper.Bitmap2Bytes(bitmap, 100));
    }

    public void q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            this.m = str;
            this.n = str2;
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.p = i;
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
        int f2 = c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds88);
        drawable.setBounds(0, 0, f2, f2);
        textView.setCompoundDrawables(null, drawable, null, null);
        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0106);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = n();
        textView.setLayoutParams(layoutParams);
    }

    public final void u(Bitmap bitmap, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048586, this, bitmap, i) == null) || bitmap == null || k()) {
            return;
        }
        int i2 = 1;
        if (i == 3) {
            i2 = 2;
        } else if (i == 2) {
            i2 = 3;
        } else if (i == 4) {
            i2 = 4;
        } else if (i == 8) {
            i2 = 5;
        } else if (i == 6) {
            i2 = 6;
        }
        e eVar = this.k;
        if (eVar != null) {
            eVar.a(i2);
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
        if (i == 3) {
            statisticItem.param("obj_type", 2);
        } else if (i == 2) {
            statisticItem.param("obj_type", 3);
        } else if (i == 8) {
            statisticItem.param("obj_type", 4);
        } else if (i == 4) {
            statisticItem.param("obj_type", 5);
        } else if (i == 6) {
            statisticItem.param("obj_type", 6);
        }
        statisticItem.param("obj_source", this.p);
        TiebaStatic.log(statisticItem);
        c.a.o0.c1.n0.b(new b(this, bitmap, i), new c(this, i));
    }
}
