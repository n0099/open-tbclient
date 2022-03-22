package c.a.p0.q3.g;

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
import c.a.o0.s.c.i0;
import c.a.o0.s.g.g;
import c.a.p0.a4.c0;
import c.a.p0.l0.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.searchbox.account.contants.LoginConstants;
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
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public final View f17677b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f17678c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f17679d;

    /* renamed from: e  reason: collision with root package name */
    public ShareGridLayout f17680e;

    /* renamed from: f  reason: collision with root package name */
    public final List<View> f17681f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f17682g;

    /* renamed from: h  reason: collision with root package name */
    public DialogInterface.OnDismissListener f17683h;
    public AlertDialog i;
    public final SparseArray<ShareItem> j;
    public boolean k;
    public SparseArray<String> l;
    public SparseArray<i0> m;

    /* renamed from: c.a.p0.q3.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1328a implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1328a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.a.i == null || !this.a.i.isShowing()) {
                    return null;
                }
                this.a.f();
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.f17683h != null) {
                    this.a.f17683h.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001277);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View.OnClickListener a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f17684b;

        public c(a aVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17684b = aVar;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17684b.f();
                View.OnClickListener onClickListener = this.a;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2097288890, "Lc/a/p0/q3/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2097288890, "Lc/a/p0/q3/g/a;");
                return;
            }
        }
        n = (int) ((n.k(TbadkCoreApplication.getInst()) - (n.f(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) * 0.2d);
        o = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds234);
        p = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds104);
        q = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds36);
        r = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        s = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    }

    public a(Context context, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = new SparseArray<>(8);
        this.k = false;
        this.a = context;
        this.f17681f = new ArrayList();
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d010b, (ViewGroup) null);
        this.f17677b = inflate;
        this.f17679d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091cba);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.f17679d.setText(sharePanelText);
        }
        ShareGridLayout shareGridLayout = (ShareGridLayout) this.f17677b.findViewById(R.id.obfuscated_res_0x7f091cbc);
        this.f17680e = shareGridLayout;
        ViewGroup.LayoutParams layoutParams = shareGridLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i4 = ShareGridLayout.f36378f;
            marginLayoutParams.leftMargin = i4;
            marginLayoutParams.rightMargin = i4;
            this.f17680e.setLayoutParams(marginLayoutParams);
        }
        this.f17680e.setItemParams(n, o);
        TextView textView = (TextView) this.f17677b.findViewById(R.id.obfuscated_res_0x7f0903fd);
        this.f17678c = textView;
        textView.setOnClickListener(this);
        if (!o(i)) {
            m(new SvgMaskType(R.drawable.obfuscated_res_0x7f080823), R.string.obfuscated_res_0x7f0f1148, 4);
        }
        if (!p(i)) {
            m(new SvgMaskType(R.drawable.obfuscated_res_0x7f08081f), R.string.obfuscated_res_0x7f0f114f, 3);
        }
        if (!n(i)) {
            m(new SvgMaskType(R.drawable.obfuscated_res_0x7f080820), R.string.obfuscated_res_0x7f0f1127, 9);
        }
        if (!q(i)) {
            m(new SvgMaskType(R.drawable.obfuscated_res_0x7f080824), R.string.obfuscated_res_0x7f0f1136, 7);
        }
        if (g.n()) {
            return;
        }
        this.f17680e.setVisibility(8);
    }

    public final void A(ShareItem shareItem, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, shareItem, i) == null) || shareItem == null || shareItem.q == null) {
            return;
        }
        if (shareItem.f30352b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i));
        } else if (!shareItem.f30353c && !shareItem.f30356f) {
            if (shareItem.f30354d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i));
            } else if (shareItem.a) {
                z(i, shareItem.C);
            } else if (shareItem.f30355e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i).param("fid", shareItem.q));
            } else if (shareItem.f30357g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i);
                if (!m.isEmpty(shareItem.t) && shareItem.t.contains("worldcup")) {
                    param.param("obj_param1", 9);
                }
                TiebaStatic.log(param);
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("obj_type", i).param("obj_source", shareItem.E).param("obj_param1", shareItem.F).param("fid", shareItem.J));
        }
    }

    public void c(View view, int i, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i, onClickListener) == null) || i > this.f17681f.size() || i < 0) {
            return;
        }
        this.f17681f.add(i, view);
        if (onClickListener != null) {
            view.setOnClickListener(new c(this, onClickListener));
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int i = 0; i < this.f17681f.size(); i++) {
                this.f17680e.addView(this.f17681f.get(i), new ViewGroup.LayoutParams(n, o));
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (alertDialog = this.i) == null) {
            return;
        }
        this.k = false;
        Context context = this.a;
        if (context instanceof Activity) {
            c.a.d.f.m.g.a(alertDialog, (Activity) context);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<View> list = this.f17681f;
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

    public final ShareItem j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            ShareItem shareItem = this.j.get(i);
            return shareItem == null ? this.j.get(1) : shareItem;
        }
        return (ShareItem) invokeI.objValue;
    }

    public void k(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, onDismissListener) == null) || onDismissListener == null) {
            return;
        }
        this.f17683h = onDismissListener;
    }

    public LinearLayout l(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048586, this, i, i2)) == null) {
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(i2));
            ImageView imageView = new ImageView(this.a);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(imageView);
            int i3 = p;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
            layoutParams.topMargin = q;
            layoutParams.bottomMargin = r;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.a);
            textView.setTextSize(0, s);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageResource(i2);
            textView.setTextColor(this.a.getResources().getColorStateList(R.color.obfuscated_res_0x7f060a04));
            return linearLayout;
        }
        return (LinearLayout) invokeII.objValue;
    }

    public final void m(AbsSvgType absSvgType, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048587, this, absSvgType, i, i2) == null) || absSvgType == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.a);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (absSvgType instanceof SvgPureType) {
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(imageView);
        }
        int i3 = p;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.topMargin = q;
        layoutParams.bottomMargin = r;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.a);
        textView.setTextSize(0, s);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageDrawable(absSvgType.getDrawable());
        textView.setTextColor(this.a.getResources().getColorStateList(R.color.obfuscated_res_0x7f060a04));
        linearLayout.setOnClickListener(this);
        this.f17681f.add(linearLayout);
    }

    public final boolean n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) ? (i & 8) > 0 : invokeI.booleanValue;
    }

    public final boolean o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) ? (i & 1) > 0 : invokeI.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
            int id = view.getId();
            int intValue = view.getTag() != null ? ((Integer) view.getTag()).intValue() : -1;
            if (this.j.size() == 0) {
                return;
            }
            if (view.getId() == R.id.obfuscated_res_0x7f0903fd || !this.k) {
                this.k = true;
                g gVar = new g(this.a, null);
                ShareItem j = j(1);
                if (id == R.id.obfuscated_res_0x7f0903fd) {
                    v("share_cancel", new Object[0]);
                    f();
                    return;
                }
                if (j.U > 0) {
                    x(intValue, j);
                }
                if (intValue == 4) {
                    if (!l.z()) {
                        n.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f111d);
                        return;
                    }
                    v("share_to_weixin", new Object[0]);
                    w(3);
                    ShareItem j2 = j(3);
                    A(j2, 4);
                    if (j2 != null) {
                        gVar.t(j2);
                    }
                } else if (intValue == 3) {
                    if (!l.z()) {
                        n.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f111d);
                        return;
                    }
                    v("share_to_pyq", new Object[0]);
                    w(2);
                    ShareItem j3 = j(2);
                    A(j3, 3);
                    if (j3 != null) {
                        if (j3.f30352b) {
                            j3.s = "【" + j3.r + "】 " + j3.s;
                        }
                        gVar.u(j3);
                    }
                } else if (intValue == 5) {
                    if (!l.z()) {
                        n.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f111d);
                        return;
                    } else if (c0.b(this.a, "com.tencent.mobileqq")) {
                        v("share_to_qzone", new Object[0]);
                        w(4);
                        ShareItem j4 = j(4);
                        A(j4, 5);
                        if (j4 != null) {
                            gVar.p(j4);
                        }
                    } else {
                        Context context = this.a;
                        BdToast.c(context, context.getText(R.string.obfuscated_res_0x7f0f1128)).q();
                    }
                } else if (intValue == 6) {
                    if (!l.z()) {
                        n.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f111d);
                        return;
                    }
                    v("share_to_qweibo", new Object[0]);
                    w(5);
                    ShareItem j5 = j(5);
                    A(j5, 6);
                    if (j5 != null) {
                        if (!j5.a) {
                            j5.s = h(j5);
                        }
                        gVar.s(j5);
                    }
                } else if (intValue == 7) {
                    if (!l.z()) {
                        n.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f111d);
                        return;
                    }
                    v("share_to_sweibo", new Object[0]);
                    w(6);
                    ShareItem j6 = j(6);
                    A(j6, 7);
                    if (j6 != null) {
                        if (!j6.a) {
                            j6.s = h(j6);
                        }
                        gVar.r(j6);
                    }
                } else if (intValue == 8) {
                    if (!l.z()) {
                        n.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f111d);
                        return;
                    }
                    v("share_to_renren", new Object[0]);
                    w(7);
                    ShareItem j7 = j(7);
                    A(j7, 8);
                    if (j7 != null) {
                        if (!j7.a) {
                            j7.s = h(j7);
                        }
                        gVar.q(j7);
                    }
                } else if (intValue == 9) {
                    if (!l.z()) {
                        n.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f111d);
                        return;
                    } else if (c0.b(this.a, "com.tencent.mobileqq")) {
                        v("share_to_qq_friend", new Object[0]);
                        w(8);
                        ShareItem j8 = j(8);
                        A(j8, 9);
                        if (j8 != null) {
                            gVar.o(j8);
                        }
                    } else {
                        Context context2 = this.a;
                        BdToast.c(context2, context2.getText(R.string.obfuscated_res_0x7f0f1128)).q();
                    }
                } else if (intValue == 10) {
                    A(j, 10);
                    View.OnClickListener onClickListener = this.f17682g;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    } else {
                        c.a.d.f.p.c.a(j.t);
                        n.N(this.a.getApplicationContext(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0438));
                    }
                    y(j);
                    if (j != null && j.a) {
                        z(8, j.C);
                    }
                }
                f();
            }
        }
    }

    public final boolean p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) ? (i & 2) > 0 : invokeI.booleanValue;
    }

    public final boolean q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) ? (i & 16) > 0 : invokeI.booleanValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new C1328a(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void s(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.f17682g = onClickListener;
    }

    public void t(ShareItem shareItem, boolean z) {
        Location i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048595, this, shareItem, z) == null) {
            if (z && (i = i()) != null) {
                shareItem.B = i;
            }
            this.j.put(1, shareItem);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!l.z()) {
                n.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f111d);
                Context context = this.a;
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
            } else if (!g.n()) {
                n.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f0e74);
            } else {
                d();
                AlertDialog create = new AlertDialog.Builder(this.a, R.style.obfuscated_res_0x7f100104).create();
                this.i = create;
                create.setCanceledOnTouchOutside(true);
                this.i.setOnDismissListener(new b(this));
                Context context2 = this.a;
                if (context2 instanceof Activity) {
                    c.a.d.f.m.g.i(this.i, (Activity) context2);
                }
                this.f17677b.setBackgroundResource(R.drawable.transmit_share_dialog_background);
                Window window = this.i.getWindow();
                window.addFlags(512);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.y = n.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                window.setAttributes(attributes);
                window.setWindowAnimations(R.style.obfuscated_res_0x7f1003ed);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.f17677b);
                e();
                r();
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
            }
        }
    }

    public final void v(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.a, str, "click", 1, objArr);
        }
    }

    public final void w(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i) == null) || i > 8 || i <= 0) {
            return;
        }
        this.k = true;
        SparseArray<i0> sparseArray = this.m;
        if (sparseArray != null) {
            i0 i0Var = sparseArray.get(i);
            if (!StringUtils.isNull(i0Var.b()) && i0Var.a() != null && i0Var.a().size() > 0) {
                v(i0Var.b(), i0Var.a());
                return;
            }
        }
        SparseArray<String> sparseArray2 = this.l;
        if (sparseArray2 != null) {
            String str = sparseArray2.get(i);
            if (m.isEmpty(str)) {
                return;
            }
            v(str, new Object[0]);
        }
    }

    public final void x(int i, ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048599, this, i, shareItem) == null) || i < 0 || shareItem == null) {
            return;
        }
        String str = i == 4 ? ThirdPartyUtil.TYPE_WEIXIN : i == 3 ? "pyq" : i == 9 ? LoginConstants.QQ_LOGIN : i == 7 ? "weibo" : "";
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
            int i = shareItem.F;
            if (i != 0) {
                param.param("obj_param1", i);
                int i2 = shareItem.F;
                if (i2 == 2) {
                    param.param("fid", shareItem.J);
                } else if (i2 == 3) {
                    int i3 = shareItem.M;
                    if (i3 != 0) {
                        param.param("obj_type", i3);
                    }
                    param.param("tid", shareItem.K).param("fid", shareItem.J);
                }
            }
            param.param("obj_locate", 7);
            TiebaStatic.log(param);
        }
    }

    public final void z(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048601, this, i, str) == null) {
            TiebaStatic.eventStat(this.a, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
        }
    }
}
