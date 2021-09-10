package c.a.r0.c3.g;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
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
import c.a.e.e.p.j;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.t.c.h0;
import c.a.q0.t.g.g;
import c.a.r0.j3.z;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.core.util.svg.SvgPureType;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
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
/* loaded from: classes3.dex */
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
    public final Context f16544e;

    /* renamed from: f  reason: collision with root package name */
    public final View f16545f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f16546g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f16547h;

    /* renamed from: i  reason: collision with root package name */
    public ShareGridLayout f16548i;

    /* renamed from: j  reason: collision with root package name */
    public final List<View> f16549j;
    public View.OnClickListener k;
    public DialogInterface.OnDismissListener l;
    public AlertDialog m;
    public final SparseArray<ShareItem> n;
    public boolean o;
    public SparseArray<String> p;
    public SparseArray<h0> q;

    /* renamed from: c.a.r0.c3.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0796a implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16550e;

        public C0796a(a aVar) {
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
            this.f16550e = aVar;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.f16550e.m == null || !this.f16550e.m.isShowing()) {
                    return null;
                }
                this.f16550e.f();
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16551e;

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
            this.f16551e = aVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.f16551e.l != null) {
                    this.f16551e.l.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001277);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public View.OnClickListener f16552e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f16553f;

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
            this.f16553f = aVar;
            this.f16552e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16553f.f();
                View.OnClickListener onClickListener = this.f16552e;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2030465546, "Lc/a/r0/c3/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2030465546, "Lc/a/r0/c3/g/a;");
                return;
            }
        }
        r = (int) ((l.k(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) * 0.2d);
        s = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds234);
        t = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
        u = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds36);
        v = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        w = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
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
        this.f16544e = context;
        this.f16549j = new ArrayList();
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
        this.f16545f = inflate;
        this.f16547h = (TextView) inflate.findViewById(R.id.share_dialog_title);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.f16547h.setText(sharePanelText);
        }
        ShareGridLayout shareGridLayout = (ShareGridLayout) this.f16545f.findViewById(R.id.share_grid_layout);
        this.f16548i = shareGridLayout;
        ViewGroup.LayoutParams layoutParams = shareGridLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i5 = ShareGridLayout.DEFAULT_MARGIN_LEFT_RIGHT;
            marginLayoutParams.leftMargin = i5;
            marginLayoutParams.rightMargin = i5;
            this.f16548i.setLayoutParams(marginLayoutParams);
        }
        this.f16548i.setItemParams(r, s);
        TextView textView = (TextView) this.f16545f.findViewById(R.id.btnShareCancel);
        this.f16546g = textView;
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
        if (g.g()) {
            return;
        }
        this.f16548i.setVisibility(8);
    }

    public void c(View view, int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048576, this, view, i2, onClickListener) == null) || i2 > this.f16549j.size() || i2 < 0) {
            return;
        }
        this.f16549j.add(i2, view);
        if (onClickListener != null) {
            view.setOnClickListener(new c(this, onClickListener));
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i2 = 0; i2 < this.f16549j.size(); i2++) {
                this.f16548i.addView(this.f16549j.get(i2), new ViewGroup.LayoutParams(r, s));
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void f() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (alertDialog = this.m) == null) {
            return;
        }
        this.o = false;
        Context context = this.f16544e;
        if (context instanceof Activity) {
            c.a.e.e.m.g.a(alertDialog, (Activity) context);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<View> list = this.f16549j;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, shareItem)) == null) {
            String str = "【" + shareItem.r + "】 " + shareItem.s;
            shareItem.s = str;
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final Location i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (PermissionUtil.checkLocationForGoogle(this.f16544e)) {
                LocationManager locationManager = (LocationManager) this.f16544e.getSystemService("location");
                Criteria criteria = new Criteria();
                criteria.setAccuracy(1);
                criteria.setAltitudeRequired(false);
                criteria.setBearingRequired(false);
                criteria.setCostAllowed(true);
                criteria.setPowerRequirement(1);
                try {
                    return locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (Location) invokeV.objValue;
    }

    public final ShareItem j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            ShareItem shareItem = this.n.get(i2);
            return shareItem == null ? this.n.get(1) : shareItem;
        }
        return (ShareItem) invokeI.objValue;
    }

    public void k(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onDismissListener) == null) || onDismissListener == null) {
            return;
        }
        this.l = onDismissListener;
    }

    public LinearLayout l(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i2, i3)) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f16544e);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(i3));
            ImageView imageView = new ImageView(this.f16544e);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(imageView);
            int i4 = t;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i4);
            layoutParams.topMargin = u;
            layoutParams.bottomMargin = v;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.f16544e);
            textView.setTextSize(0, w);
            textView.setText(i2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageResource(i3);
            textView.setTextColor(this.f16544e.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
            return linearLayout;
        }
        return (LinearLayout) invokeII.objValue;
    }

    public final void m(AbsSvgType absSvgType, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048586, this, absSvgType, i2, i3) == null) || absSvgType == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.f16544e);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i3));
        ImageView imageView = new ImageView(this.f16544e);
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
        TextView textView = new TextView(this.f16544e);
        textView.setTextSize(0, w);
        textView.setText(i2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageDrawable(absSvgType.getDrawable());
        textView.setTextColor(this.f16544e.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        linearLayout.setOnClickListener(this);
        this.f16549j.add(linearLayout);
    }

    public final boolean n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? (i2 & 8) > 0 : invokeI.booleanValue;
    }

    public final boolean o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? (i2 & 1) > 0 : invokeI.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            int id = view.getId();
            int intValue = view.getTag() != null ? ((Integer) view.getTag()).intValue() : -1;
            if (this.n.size() == 0) {
                return;
            }
            if (view.getId() == R.id.btnShareCancel || !this.o) {
                this.o = true;
                g gVar = new g(this.f16544e, null);
                ShareItem j2 = j(1);
                if (id == R.id.btnShareCancel) {
                    v("share_cancel", new Object[0]);
                    f();
                    return;
                }
                if (intValue == 4) {
                    if (!j.z()) {
                        l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    v("share_to_weixin", new Object[0]);
                    w(3);
                    ShareItem j3 = j(3);
                    z(j3, 4);
                    if (j3 != null) {
                        gVar.m(j3);
                    }
                } else if (intValue == 3) {
                    if (!j.z()) {
                        l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    v("share_to_pyq", new Object[0]);
                    w(2);
                    ShareItem j4 = j(2);
                    z(j4, 3);
                    if (j4 != null) {
                        if (j4.f48106b) {
                            j4.s = "【" + j4.r + "】 " + j4.s;
                        }
                        gVar.n(j4);
                    }
                } else if (intValue == 5) {
                    if (!j.z()) {
                        l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    } else if (z.b(this.f16544e, "com.tencent.mobileqq")) {
                        v("share_to_qzone", new Object[0]);
                        w(4);
                        ShareItem j5 = j(4);
                        z(j5, 5);
                        if (j5 != null) {
                            gVar.i(j5);
                        }
                    } else {
                        Context context = this.f16544e;
                        BdToast.c(context, context.getText(R.string.share_qq_not_install)).q();
                    }
                } else if (intValue == 6) {
                    if (!j.z()) {
                        l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    v("share_to_qweibo", new Object[0]);
                    w(5);
                    ShareItem j6 = j(5);
                    z(j6, 6);
                    if (j6 != null) {
                        if (!j6.f48105a) {
                            j6.s = h(j6);
                        }
                        gVar.l(j6);
                    }
                } else if (intValue == 7) {
                    if (!j.z()) {
                        l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    v("share_to_sweibo", new Object[0]);
                    w(6);
                    ShareItem j7 = j(6);
                    z(j7, 7);
                    if (j7 != null) {
                        if (!j7.f48105a) {
                            j7.s = h(j7);
                        }
                        gVar.k(j7);
                    }
                } else if (intValue == 8) {
                    if (!j.z()) {
                        l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    v("share_to_renren", new Object[0]);
                    w(7);
                    ShareItem j8 = j(7);
                    z(j8, 8);
                    if (j8 != null) {
                        if (!j8.f48105a) {
                            j8.s = h(j8);
                        }
                        gVar.j(j8);
                    }
                } else if (intValue == 9) {
                    if (!j.z()) {
                        l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    } else if (z.b(this.f16544e, "com.tencent.mobileqq")) {
                        v("share_to_qq_friend", new Object[0]);
                        w(8);
                        ShareItem j9 = j(8);
                        z(j9, 9);
                        if (j9 != null) {
                            gVar.h(j9);
                        }
                    } else {
                        Context context2 = this.f16544e;
                        BdToast.c(context2, context2.getText(R.string.share_qq_not_install)).q();
                    }
                } else if (intValue == 10) {
                    z(j2, 10);
                    View.OnClickListener onClickListener = this.k;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    } else {
                        c.a.e.e.p.a.a(j2.t);
                        l.M(this.f16544e.getApplicationContext(), this.f16544e.getResources().getString(R.string.copy_pb_url_success));
                    }
                    x(j2);
                    if (j2 != null && j2.f48105a) {
                        y(8, j2.C);
                    }
                }
                f();
            }
        }
    }

    public final boolean p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? (i2 & 2) > 0 : invokeI.booleanValue;
    }

    public final boolean q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) ? (i2 & 16) > 0 : invokeI.booleanValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new C0796a(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void s(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.k = onClickListener;
    }

    public void t(ShareItem shareItem, boolean z) {
        Location i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048594, this, shareItem, z) == null) {
            if (z && (i2 = i()) != null) {
                shareItem.B = i2;
            }
            this.n.put(1, shareItem);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (!j.z()) {
                l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
            } else if (!g.g()) {
                l.L(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
            } else {
                d();
                AlertDialog create = new AlertDialog.Builder(this.f16544e, R.style.DialogTheme).create();
                this.m = create;
                create.setCanceledOnTouchOutside(true);
                this.m.setOnDismissListener(new b(this));
                Context context = this.f16544e;
                if (context instanceof Activity) {
                    c.a.e.e.m.g.i(this.m, (Activity) context);
                }
                this.f16545f.setBackgroundResource(R.drawable.transmit_share_dialog_background);
                Window window = this.m.getWindow();
                window.addFlags(512);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.y = l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                window.setAttributes(attributes);
                window.setWindowAnimations(R.style.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.f16545f);
                e();
                r();
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
            }
        }
    }

    public final void v(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.f16544e, str, PrefetchEvent.STATE_CLICK, 1, objArr);
        }
    }

    public final void w(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || i2 > 8 || i2 <= 0) {
            return;
        }
        this.o = true;
        SparseArray<h0> sparseArray = this.q;
        if (sparseArray != null) {
            h0 h0Var = sparseArray.get(i2);
            if (!StringUtils.isNull(h0Var.b()) && h0Var.a() != null && h0Var.a().size() > 0) {
                v(h0Var.b(), h0Var.a());
                return;
            }
        }
        SparseArray<String> sparseArray2 = this.p;
        if (sparseArray2 != null) {
            String str = sparseArray2.get(i2);
            if (k.isEmpty(str)) {
                return;
            }
            v(str, new Object[0]);
        }
    }

    public final void x(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, shareItem) == null) {
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

    public final void y(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048599, this, i2, str) == null) {
            TiebaStatic.eventStat(this.f16544e, "pb_new_share", null, 1, "loc", Integer.valueOf(i2), PbChosenActivityConfig.KEY_TID, str);
        }
    }

    public final void z(ShareItem shareItem, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048600, this, shareItem, i2) == null) || shareItem == null || shareItem.q == null) {
            return;
        }
        if (shareItem.f48106b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i2));
        } else if (!shareItem.f48107c && !shareItem.f48110f) {
            if (shareItem.f48108d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i2));
            } else if (shareItem.f48105a) {
                y(i2, shareItem.C);
            } else if (shareItem.f48109e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i2).param("fid", shareItem.q));
            } else if (shareItem.f48111g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2);
                if (!k.isEmpty(shareItem.t) && shareItem.t.contains("worldcup")) {
                    param.param("obj_param1", 9);
                }
                TiebaStatic.log(param);
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("obj_type", i2).param("obj_source", shareItem.E).param("obj_param1", shareItem.F).param("fid", shareItem.J));
        }
    }
}
