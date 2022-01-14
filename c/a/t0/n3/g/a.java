package c.a.t0.n3.g;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.s0.t.c.j0;
import c.a.s0.t.g.g;
import c.a.t0.k0.h;
import c.a.t0.w3.b0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.core.util.svg.SvgPureType;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.plugin.passprovider.PassProviderPlugin;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public static final int w;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f19769e;

    /* renamed from: f  reason: collision with root package name */
    public final View f19770f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f19771g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f19772h;

    /* renamed from: i  reason: collision with root package name */
    public ShareGridLayout f19773i;

    /* renamed from: j  reason: collision with root package name */
    public final List<View> f19774j;
    public View.OnClickListener k;
    public DialogInterface.OnDismissListener l;
    public AlertDialog m;
    public final SparseArray<ShareItem> n;
    public boolean o;
    public SparseArray<String> p;
    public SparseArray<j0> q;

    /* renamed from: c.a.t0.n3.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1238a implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19775e;

        public C1238a(a aVar) {
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
            this.f19775e = aVar;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.f19775e.m == null || !this.f19775e.m.isShowing()) {
                    return null;
                }
                this.f19775e.f();
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19776e;

        public b(a aVar) {
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
            this.f19776e = aVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.f19776e.l != null) {
                    this.f19776e.l.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001277);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public View.OnClickListener f19777e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f19778f;

        public c(a aVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19778f = aVar;
            this.f19777e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19778f.f();
                View.OnClickListener onClickListener = this.f19777e;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1250886657, "Lc/a/t0/n3/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1250886657, "Lc/a/t0/n3/g/a;");
                return;
            }
        }
        r = (int) ((n.k(TbadkCoreApplication.getInst()) - (n.f(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) * 0.2d);
        s = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds234);
        t = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds104);
        u = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds36);
        v = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        w = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    }

    public a(Context context, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = new SparseArray<>(8);
        this.o = false;
        this.f19769e = context;
        this.f19774j = new ArrayList();
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
        this.f19770f = inflate;
        this.f19772h = (TextView) inflate.findViewById(R.id.share_dialog_title);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.f19772h.setText(sharePanelText);
        }
        ShareGridLayout shareGridLayout = (ShareGridLayout) this.f19770f.findViewById(R.id.share_grid_layout);
        this.f19773i = shareGridLayout;
        ViewGroup.LayoutParams layoutParams = shareGridLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i5 = ShareGridLayout.DEFAULT_MARGIN_LEFT_RIGHT;
            marginLayoutParams.leftMargin = i5;
            marginLayoutParams.rightMargin = i5;
            this.f19773i.setLayoutParams(marginLayoutParams);
        }
        this.f19773i.setItemParams(r, s);
        TextView textView = (TextView) this.f19770f.findViewById(R.id.btnShareCancel);
        this.f19771g = textView;
        textView.setOnClickListener(this);
        if (!o(i2)) {
            m(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
        }
        if (!p(i2)) {
            m(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
        }
        if (!n(i2)) {
            m(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
        }
        if (!q(i2)) {
            m(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
        }
        if (g.n()) {
            return;
        }
        this.f19773i.setVisibility(8);
    }

    public final void A(ShareItem shareItem, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, shareItem, i2) == null) || shareItem == null || shareItem.q == null) {
            return;
        }
        if (shareItem.f40762b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i2));
        } else if (!shareItem.f40763c && !shareItem.f40766f) {
            if (shareItem.f40764d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i2));
            } else if (shareItem.a) {
                z(i2, shareItem.C);
            } else if (shareItem.f40765e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i2).param("fid", shareItem.q));
            } else if (shareItem.f40767g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2);
                if (!m.isEmpty(shareItem.t) && shareItem.t.contains("worldcup")) {
                    param.param("obj_param1", 9);
                }
                TiebaStatic.log(param);
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("obj_type", i2).param("obj_source", shareItem.E).param("obj_param1", shareItem.F).param("fid", shareItem.J));
        }
    }

    public void c(View view, int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2, onClickListener) == null) || i2 > this.f19774j.size() || i2 < 0) {
            return;
        }
        this.f19774j.add(i2, view);
        if (onClickListener != null) {
            view.setOnClickListener(new c(this, onClickListener));
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int i2 = 0; i2 < this.f19774j.size(); i2++) {
                this.f19773i.addView(this.f19774j.get(i2), new ViewGroup.LayoutParams(r, s));
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void f() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (alertDialog = this.m) == null) {
            return;
        }
        this.o = false;
        Context context = this.f19769e;
        if (context instanceof Activity) {
            c.a.d.f.m.g.a(alertDialog, (Activity) context);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<View> list = this.f19774j;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public final String h(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, shareItem)) == null) {
            String str = "【" + shareItem.r + "】 " + shareItem.s;
            shareItem.s = str;
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final Location i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? h.b() : (Location) invokeV.objValue;
    }

    public final ShareItem j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            ShareItem shareItem = this.n.get(i2);
            return shareItem == null ? this.n.get(1) : shareItem;
        }
        return (ShareItem) invokeI.objValue;
    }

    public void k(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, onDismissListener) == null) || onDismissListener == null) {
            return;
        }
        this.l = onDismissListener;
    }

    public LinearLayout l(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048586, this, i2, i3)) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f19769e);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(i3));
            ImageView imageView = new ImageView(this.f19769e);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(imageView);
            int i4 = t;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i4);
            layoutParams.topMargin = u;
            layoutParams.bottomMargin = v;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.f19769e);
            textView.setTextSize(0, w);
            textView.setText(i2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageResource(i3);
            textView.setTextColor(this.f19769e.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
            return linearLayout;
        }
        return (LinearLayout) invokeII.objValue;
    }

    public final void m(AbsSvgType absSvgType, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048587, this, absSvgType, i2, i3) == null) || absSvgType == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.f19769e);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i3));
        ImageView imageView = new ImageView(this.f19769e);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (absSvgType instanceof SvgPureType) {
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(imageView);
        }
        int i4 = t;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i4);
        layoutParams.topMargin = u;
        layoutParams.bottomMargin = v;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.f19769e);
        textView.setTextSize(0, w);
        textView.setText(i2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageDrawable(absSvgType.getDrawable());
        textView.setTextColor(this.f19769e.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        linearLayout.setOnClickListener(this);
        this.f19774j.add(linearLayout);
    }

    public final boolean n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? (i2 & 8) > 0 : invokeI.booleanValue;
    }

    public final boolean o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) ? (i2 & 1) > 0 : invokeI.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
            int id = view.getId();
            int intValue = view.getTag() != null ? ((Integer) view.getTag()).intValue() : -1;
            if (this.n.size() == 0) {
                return;
            }
            if (view.getId() == R.id.btnShareCancel || !this.o) {
                this.o = true;
                g gVar = new g(this.f19769e, null);
                ShareItem j2 = j(1);
                if (id == R.id.btnShareCancel) {
                    v("share_cancel", new Object[0]);
                    f();
                    return;
                }
                if (j2.U > 0) {
                    x(intValue, j2);
                }
                if (intValue == 4) {
                    if (!l.z()) {
                        n.M(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    v("share_to_weixin", new Object[0]);
                    w(3);
                    ShareItem j3 = j(3);
                    A(j3, 4);
                    if (j3 != null) {
                        gVar.t(j3);
                    }
                } else if (intValue == 3) {
                    if (!l.z()) {
                        n.M(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    v("share_to_pyq", new Object[0]);
                    w(2);
                    ShareItem j4 = j(2);
                    A(j4, 3);
                    if (j4 != null) {
                        if (j4.f40762b) {
                            j4.s = "【" + j4.r + "】 " + j4.s;
                        }
                        gVar.u(j4);
                    }
                } else if (intValue == 5) {
                    if (!l.z()) {
                        n.M(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    } else if (b0.b(this.f19769e, "com.tencent.mobileqq")) {
                        v("share_to_qzone", new Object[0]);
                        w(4);
                        ShareItem j5 = j(4);
                        A(j5, 5);
                        if (j5 != null) {
                            gVar.p(j5);
                        }
                    } else {
                        Context context = this.f19769e;
                        BdToast.c(context, context.getText(R.string.share_qq_not_install)).q();
                    }
                } else if (intValue == 6) {
                    if (!l.z()) {
                        n.M(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    v("share_to_qweibo", new Object[0]);
                    w(5);
                    ShareItem j6 = j(5);
                    A(j6, 6);
                    if (j6 != null) {
                        if (!j6.a) {
                            j6.s = h(j6);
                        }
                        gVar.s(j6);
                    }
                } else if (intValue == 7) {
                    if (!l.z()) {
                        n.M(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    v("share_to_sweibo", new Object[0]);
                    w(6);
                    ShareItem j7 = j(6);
                    A(j7, 7);
                    if (j7 != null) {
                        if (!j7.a) {
                            j7.s = h(j7);
                        }
                        gVar.r(j7);
                    }
                } else if (intValue == 8) {
                    if (!l.z()) {
                        n.M(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    v("share_to_renren", new Object[0]);
                    w(7);
                    ShareItem j8 = j(7);
                    A(j8, 8);
                    if (j8 != null) {
                        if (!j8.a) {
                            j8.s = h(j8);
                        }
                        gVar.q(j8);
                    }
                } else if (intValue == 9) {
                    if (!l.z()) {
                        n.M(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    } else if (b0.b(this.f19769e, "com.tencent.mobileqq")) {
                        v("share_to_qq_friend", new Object[0]);
                        w(8);
                        ShareItem j9 = j(8);
                        A(j9, 9);
                        if (j9 != null) {
                            gVar.o(j9);
                        }
                    } else {
                        Context context2 = this.f19769e;
                        BdToast.c(context2, context2.getText(R.string.share_qq_not_install)).q();
                    }
                } else if (intValue == 10) {
                    A(j2, 10);
                    View.OnClickListener onClickListener = this.k;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    } else {
                        c.a.d.f.p.c.a(j2.t);
                        n.N(this.f19769e.getApplicationContext(), this.f19769e.getResources().getString(R.string.copy_pb_url_success));
                    }
                    y(j2);
                    if (j2 != null && j2.a) {
                        z(8, j2.C);
                    }
                }
                f();
            }
        }
    }

    public final boolean p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) ? (i2 & 2) > 0 : invokeI.booleanValue;
    }

    public final boolean q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) ? (i2 & 16) > 0 : invokeI.booleanValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new C1238a(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void s(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.k = onClickListener;
    }

    public void t(ShareItem shareItem, boolean z) {
        Location i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048595, this, shareItem, z) == null) {
            if (z && (i2 = i()) != null) {
                shareItem.B = i2;
            }
            this.n.put(1, shareItem);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!l.z()) {
                n.M(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                Context context = this.f19769e;
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
            } else if (!g.n()) {
                n.M(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
            } else {
                d();
                AlertDialog create = new AlertDialog.Builder(this.f19769e, R.style.DialogTheme).create();
                this.m = create;
                create.setCanceledOnTouchOutside(true);
                this.m.setOnDismissListener(new b(this));
                Context context2 = this.f19769e;
                if (context2 instanceof Activity) {
                    c.a.d.f.m.g.i(this.m, (Activity) context2);
                }
                this.f19770f.setBackgroundResource(R.drawable.transmit_share_dialog_background);
                Window window = this.m.getWindow();
                window.addFlags(512);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.y = n.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                window.setAttributes(attributes);
                window.setWindowAnimations(R.style.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.f19770f);
                e();
                r();
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
            }
        }
    }

    public final void v(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.f19769e, str, "click", 1, objArr);
        }
    }

    public final void w(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || i2 > 8 || i2 <= 0) {
            return;
        }
        this.o = true;
        SparseArray<j0> sparseArray = this.q;
        if (sparseArray != null) {
            j0 j0Var = sparseArray.get(i2);
            if (!StringUtils.isNull(j0Var.b()) && j0Var.a() != null && j0Var.a().size() > 0) {
                v(j0Var.b(), j0Var.a());
                return;
            }
        }
        SparseArray<String> sparseArray2 = this.p;
        if (sparseArray2 != null) {
            String str = sparseArray2.get(i2);
            if (m.isEmpty(str)) {
                return;
            }
            v(str, new Object[0]);
        }
    }

    public final void x(int i2, ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048599, this, i2, shareItem) == null) || i2 < 0 || shareItem == null) {
            return;
        }
        String str = i2 == 4 ? ThirdPartyUtil.TYPE_WEIXIN : i2 == 3 ? "pyq" : i2 == 9 ? "qq" : i2 == 7 ? PassProviderPlugin.LOGIN_TYPE_WEIBO : "";
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VOICE_ROOM_SHARE);
        statisticItem.addParam("obj_type", shareItem.V);
        statisticItem.addParam(TiebaStatic.Params.TIEBA_PARAMS, str);
        statisticItem.addParam("room_id", shareItem.U);
        statisticItem.eventStat();
    }

    public final void y(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, shareItem) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 9);
            int i2 = shareItem.F;
            if (i2 != 0) {
                param.param("obj_param1", i2);
                int i3 = shareItem.F;
                if (i3 == 2) {
                    param.param("fid", shareItem.J);
                } else if (i3 == 3) {
                    int i4 = shareItem.M;
                    if (i4 != 0) {
                        param.param("obj_type", i4);
                    }
                    param.param("tid", shareItem.K).param("fid", shareItem.J);
                }
            }
            param.param("obj_locate", 7);
            TiebaStatic.log(param);
        }
    }

    public final void z(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048601, this, i2, str) == null) {
            TiebaStatic.eventStat(this.f19769e, "pb_new_share", null, 1, "loc", Integer.valueOf(i2), PbChosenActivityConfig.KEY_TID, str);
        }
    }
}
