package c.a.p0.q3.g;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.j;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.r.t.a;
import c.a.o0.s.c.h0;
import c.a.o0.s.c.i0;
import c.a.p0.a4.c0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.view.ShareDialogItemView;
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
import java.util.UUID;
/* loaded from: classes2.dex */
public class d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int D;
    public static final int E;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener B;
    public int C;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public final View f17685b;

    /* renamed from: c  reason: collision with root package name */
    public final View f17686c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f17687d;

    /* renamed from: e  reason: collision with root package name */
    public ShareGridLayout f17688e;

    /* renamed from: f  reason: collision with root package name */
    public final EMTextView f17689f;

    /* renamed from: g  reason: collision with root package name */
    public final List<View> f17690g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f17691h;
    public DialogInterface.OnDismissListener i;
    public DialogInterface.OnCancelListener j;
    public AlertDialog k;
    public float l;
    public PermissionJudgePolicy m;
    public RelativeLayout n;
    public ImageView o;
    public TextView p;
    public MessageRedDotView q;
    public ImageView r;
    public boolean s;
    public String t;
    public final SparseArray<ShareItem> u;
    public boolean v;
    public SparseArray<String> w;
    public SparseArray<i0> x;
    public boolean y;
    public int z;

    /* loaded from: classes2.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.a.k();
                this.a.f17688e.removeAllViews();
                this.a.j();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.a.k == null || !this.a.k.isShowing()) {
                    return null;
                }
                this.a.m();
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.i != null) {
                    this.a.i.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001277);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* renamed from: c.a.p0.q3.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class DialogInterface$OnCancelListenerC1329d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public DialogInterface$OnCancelListenerC1329d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || this.a.j == null) {
                return;
            }
            this.a.j.onCancel(dialogInterface);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f17692b;

        public e(d dVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17692b = dVar;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f17692b.k != null) {
                    this.f17692b.k.dismiss();
                }
                this.a.onClick(view);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends InsertGalleryAsyncTask.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                n.N(this.a.a, "保存失败！");
            }
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                n.N(this.a.a, "保存成功！");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f17693b;

        public g(d dVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17693b = dVar;
            this.a = shareItem;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                c.a.d.f.p.c.a(this.a.s);
                n.M(this.f17693b.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f0439);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View.OnClickListener a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f17694b;

        public i(d dVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17694b = dVar;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17694b.m();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2097288797, "Lc/a/p0/q3/g/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2097288797, "Lc/a/p0/q3/g/d;");
                return;
            }
        }
        D = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds202);
        E = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds239);
    }

    @SuppressLint({"ResourceType"})
    public d(Context context, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.l = 0.33f;
        this.u = new SparseArray<>(8);
        this.v = false;
        this.y = true;
        this.z = 1;
        this.A = true;
        this.B = new a(this, 2001304);
        this.C = 0;
        this.C = i2;
        this.a = context;
        this.f17690g = new ArrayList();
        View q = q();
        this.f17685b = q;
        this.f17686c = q.findViewById(R.id.obfuscated_res_0x7f091cb9);
        this.f17687d = (TextView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f091cba);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.f17687d.setText(sharePanelText);
        }
        ShareGridLayout shareGridLayout = (ShareGridLayout) this.f17685b.findViewById(R.id.obfuscated_res_0x7f091cbc);
        this.f17688e = shareGridLayout;
        ViewGroup.LayoutParams layoutParams = shareGridLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i5 = ShareGridLayout.f36378f;
            marginLayoutParams.leftMargin = i5;
            marginLayoutParams.rightMargin = i5;
            this.f17688e.setLayoutParams(marginLayoutParams);
        }
        this.f17688e.setItemParams(D, E);
        EMTextView eMTextView = (EMTextView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f0903fd);
        this.f17689f = eMTextView;
        eMTextView.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) this.f17685b.findViewById(R.id.obfuscated_res_0x7f090b9f);
        this.n = relativeLayout;
        if (relativeLayout != null) {
            this.o = (ImageView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f091808);
            TextView textView = (TextView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f091807);
            this.p = textView;
            textView.setText(R.string.obfuscated_res_0x7f0f0e37);
            MessageRedDotView messageRedDotView = (MessageRedDotView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f09180a);
            this.q = messageRedDotView;
            messageRedDotView.setExtendSize(n.f(context, R.dimen.tbds5));
            this.q.setTextSize(R.dimen.T_X09);
            this.q.setTextBold(true);
            this.r = (ImageView) this.f17685b.findViewById(R.id.obfuscated_res_0x7f091809);
        }
    }

    public final boolean A(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (i2 & 16) > 0 : invokeI.booleanValue;
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n != null : invokeV.booleanValue;
    }

    public final boolean C(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? (i2 & 32) > 0 : invokeI.booleanValue;
    }

    public void D(ShareDialogConfig.From from) {
        h0 sharePanelConfData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, from) == null) && (sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData()) != null && sharePanelConfData.d(from) && sharePanelConfData.c() && !m.isEmpty(sharePanelConfData.b())) {
            this.f17687d.setText(sharePanelConfData.b());
        }
    }

    public void E(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && B()) {
            if (z) {
                if (i2 <= 0) {
                    this.q.setVisibility(8);
                } else {
                    this.q.setVisibility(0);
                    this.q.f(i2);
                }
                this.q.setVisibility(0);
                return;
            }
            this.q.setVisibility(8);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new b(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void G(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.f17691h = onClickListener;
    }

    public void H(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
        }
    }

    public void I(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.t = str;
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.y = z;
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.s = z;
        }
    }

    public void L(SparseArray<String> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, sparseArray) == null) {
            this.w = sparseArray;
        }
    }

    public void M(DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onCancelListener) == null) {
            this.j = onCancelListener;
        }
    }

    public void N(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) && B()) {
            this.n.setOnClickListener(new e(this, onClickListener));
        }
    }

    public void O(ShareItem shareItem, boolean z) {
        Location r;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, shareItem, z) == null) {
            if (z && (r = r()) != null) {
                shareItem.B = r;
            }
            this.u.put(1, shareItem);
            if (StringUtils.isNull(shareItem.n)) {
                return;
            }
            this.f17687d.setText(shareItem.n);
        }
    }

    public void P(int i2, ShareItem shareItem, boolean z) {
        Location r;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), shareItem, Boolean.valueOf(z)}) == null) {
            if (z && (r = r()) != null) {
                shareItem.B = r;
            }
            this.u.put(i2, shareItem);
        }
    }

    public void Q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.z = i2;
        }
    }

    public void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.A = z;
        }
    }

    public void S(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, window) == null) {
            window.setLayout(-1, -2);
        }
    }

    public boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.z == 2 && l() : invokeV.booleanValue;
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!l.z()) {
                n.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f111d);
            } else if (!c.a.o0.s.g.g.n()) {
                n.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f0e74);
            } else {
                j();
                AlertDialog create = new AlertDialog.Builder(this.a, R.style.obfuscated_res_0x7f100104).create();
                this.k = create;
                create.setCanceledOnTouchOutside(true);
                this.k.setOnDismissListener(new c(this));
                this.k.setOnCancelListener(new DialogInterface$OnCancelListenerC1329d(this));
                Context context = this.a;
                if (context instanceof Activity) {
                    c.a.d.f.m.g.i(this.k, (Activity) context);
                }
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f17686c);
                d2.n(R.string.J_X14);
                d2.f(R.color.CAM_X0204);
                Window window = this.k.getWindow();
                if (window == null) {
                    return;
                }
                if (this.A) {
                    window.addFlags(512);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.y = n.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                    window.setAttributes(attributes);
                    window.setWindowAnimations(R.style.obfuscated_res_0x7f1003ed);
                } else {
                    window.setWindowAnimations(R.style.obfuscated_res_0x7f1003c3);
                }
                window.setGravity(80);
                S(window);
                window.setContentView(this.f17685b);
                window.setDimAmount(this.l);
                k();
                n();
                F();
                j.a(this.a).registerListener(this.B);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
            }
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList(this.f17690g);
            this.f17690g.clear();
            if (!y(this.C)) {
                h(R.string.obfuscated_res_0x7f0f1148, new SvgMaskType(R.drawable.obfuscated_res_0x7f080823));
            }
            if (!z(this.C)) {
                h(R.string.obfuscated_res_0x7f0f114f, new SvgMaskType(R.drawable.obfuscated_res_0x7f08081f));
            }
            if (!w(this.C)) {
                h(R.string.obfuscated_res_0x7f0f1127, new SvgMaskType(R.drawable.obfuscated_res_0x7f080820));
            }
            if (!x(this.C)) {
                h(R.string.obfuscated_res_0x7f0f112b, new SvgMaskType(R.drawable.obfuscated_res_0x7f080821));
            }
            if (!A(this.C)) {
                h(R.string.obfuscated_res_0x7f0f1136, new SvgMaskType(R.drawable.obfuscated_res_0x7f080824));
            }
            if (C(this.C)) {
                g(R.string.obfuscated_res_0x7f0f112f, R.drawable.obfuscated_res_0x7f080988);
            }
            if (arrayList.size() > 0) {
                this.f17690g.addAll(arrayList);
            }
            if (this.y) {
                g(R.string.obfuscated_res_0x7f0f1110, R.drawable.obfuscated_res_0x7f080985);
            }
        }
    }

    public final void W(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, shareItem) == null) || shareItem == null || TextUtils.isEmpty(shareItem.s) || TextUtils.isEmpty(shareItem.r)) {
            return;
        }
        Context context = this.a;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(activity);
            aVar.setTitle(shareItem.r);
            aVar.setMessage(shareItem.s);
            aVar.setAutoNight(false);
            aVar.setCancelable(true);
            aVar.setTitleShowCenter(true);
            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f1110, new g(this, shareItem));
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f110b, new h(this)).create(j.a(activity));
            aVar.show();
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Y(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.a, str, "click", 1, objArr);
        }
    }

    public final void Z(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i2) == null) || i2 > 8 || i2 <= 0) {
            return;
        }
        this.v = true;
        SparseArray<i0> sparseArray = this.x;
        if (sparseArray != null) {
            i0 i0Var = sparseArray.get(i2);
            if (!StringUtils.isNull(i0Var.b()) && i0Var.a() != null && i0Var.a().size() > 0) {
                Y(i0Var.b(), i0Var.a());
                return;
            }
        }
        SparseArray<String> sparseArray2 = this.w;
        if (sparseArray2 != null) {
            String str = sparseArray2.get(i2);
            if (m.isEmpty(str)) {
                return;
            }
            Y(str, new Object[0]);
        }
    }

    public final void a0(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, shareItem) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 7);
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
            param.param("obj_locate", 9);
            TiebaStatic.log(param);
        }
    }

    public final void b0(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048603, this, i2, str) == null) {
            TiebaStatic.eventStat(this.a, "pb_new_share", null, 1, "loc", Integer.valueOf(i2), PbChosenActivityConfig.KEY_TID, str);
        }
    }

    public final void c0(ShareItem shareItem, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048604, this, shareItem, i2) == null) || shareItem == null) {
            return;
        }
        if (shareItem.q == null) {
            if (shareItem.j) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2).param("obj_source", shareItem.E));
            }
        } else if (shareItem.f30352b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i2).param("obj_source", shareItem.E).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
        } else if (!shareItem.f30353c && !shareItem.f30356f) {
            if (shareItem.f30354d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i2));
            } else if (shareItem.a) {
                b0(i2, shareItem.C);
            } else if (shareItem.f30355e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i2).param("fid", shareItem.q).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
            } else if (shareItem.f30357g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2);
                param.param("obj_source", shareItem.E);
                if (!m.isEmpty(shareItem.t)) {
                    if (shareItem.t.contains("worldcup")) {
                        param.param("obj_param1", 9);
                    }
                    param.param(TiebaStatic.Params.OBJ_URL, shareItem.t);
                }
                TiebaStatic.log(param);
            } else if (shareItem.i) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_TOPIC_DETAIL).param("obj_locate", i2 == 3 ? "1" : i2 == 4 ? "2" : i2 == 9 ? "4" : i2 == 5 ? "3" : i2 == 7 ? "5" : "6").param("topic_id", shareItem.q));
            } else if (shareItem.k) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                statisticItem.param("tid", shareItem.q);
                statisticItem.param("post_id", shareItem.X);
                statisticItem.param("obj_source", 18);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G);
                TiebaStatic.log(statisticItem);
            } else if (shareItem.l) {
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_GAME_DETIAL);
                statisticItem2.param("obj_type", i2);
                statisticItem2.param("obj_name", shareItem.r);
                TiebaStatic.log(statisticItem2);
                StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                statisticItem3.param("obj_source", 19);
                TiebaStatic.log(statisticItem3);
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("obj_type", i2).param("obj_source", shareItem.E).param("obj_param1", shareItem.F).param("fid", shareItem.J).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
        }
    }

    public void g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048605, this, i2, i3) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107));
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            List<View> list = this.f17690g;
            shareDialogItemView.a();
            list.add(shareDialogItemView);
        }
    }

    public void h(int i2, AbsSvgType absSvgType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048606, this, i2, absSvgType) == null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
        shareDialogItemView.setItemIcon(absSvgType);
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.setOnClickListener(this);
        List<View> list = this.f17690g;
        shareDialogItemView.a();
        list.add(shareDialogItemView);
    }

    public void i(View view, int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048607, this, view, i2, onClickListener) == null) || i2 > this.f17690g.size() || i2 < 0) {
            return;
        }
        this.f17690g.add(i2, view);
        if (onClickListener != null) {
            view.setOnClickListener(new i(this, onClickListener));
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || X()) {
            return;
        }
        V();
        if (!c.a.o0.s.g.g.n()) {
            this.f17688e.setVisibility(8);
        }
        for (int i2 = 0; i2 < this.f17690g.size(); i2++) {
            this.f17688e.addView(this.f17690g.get(i2), new ViewGroup.LayoutParams(D, E));
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f17686c);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f17687d, R.color.CAM_X0108, 1);
            SkinManager.setViewTextColorSelector(this.f17689f, R.color.CAM_X0107);
            if (B()) {
                c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.n);
                d3.n(R.string.J_X05);
                d3.f(R.color.CAM_X0201);
                this.o.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b8, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
                c.a.o0.r.v.c d4 = c.a.o0.r.v.c.d(this.p);
                d4.A(R.string.F_X01);
                d4.v(R.color.CAM_X0105);
            }
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (this.a instanceof Activity) {
                if (this.m == null) {
                    this.m = new PermissionJudgePolicy();
                }
                this.m.clearRequestPermissionList();
                this.m.appendRequestPermission((Activity) this.a, "android.permission.WRITE_EXTERNAL_STORAGE");
                return this.m.startRequestPermission((Activity) this.a);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (alertDialog = this.k) == null) {
            return;
        }
        this.v = false;
        if (this.a instanceof Activity) {
            DialogInterface.OnDismissListener onDismissListener = this.i;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(alertDialog);
            }
            c.a.d.f.m.g.a(this.k, (Activity) this.a);
            MessageManager.getInstance().unRegisterListener(this.B);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (this.s) {
                this.f17687d.setVisibility(8);
                if (B()) {
                    this.n.setVisibility(0);
                    return;
                }
                return;
            }
            this.f17687d.setVisibility(0);
            if (B()) {
                this.n.setVisibility(8);
            }
        }
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            List<View> list = this.f17690g;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, view) == null) {
            int id = view.getId();
            int intValue = view.getTag() != null ? ((Integer) view.getTag()).intValue() : -1;
            if (id != R.id.obfuscated_res_0x7f0903fd && intValue != R.drawable.obfuscated_res_0x7f080985 && T()) {
                this.v = false;
                return;
            }
            if (intValue != R.drawable.obfuscated_res_0x7f080988) {
                m();
            }
            if (this.u.size() == 0) {
                return;
            }
            if (id == R.id.obfuscated_res_0x7f0903fd || !this.v) {
                this.v = true;
                ShareItem s = s(1);
                c.a.o0.s.g.g gVar = new c.a.o0.s.g.g(this.a, null);
                if (s != null && s.n0) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_AI_APP_SHARE_CLICK).param("obj_id", s.o0).param("obj_type", s.p0).param("obj_source", s.q0));
                    Bundle bundle = new Bundle();
                    bundle.putInt("source", 16);
                    s.k(bundle);
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                    statisticItem.param("obj_source", 25);
                    TiebaStatic.log(statisticItem);
                }
                if (id == R.id.obfuscated_res_0x7f0903fd) {
                    Y("share_cancel", new Object[0]);
                    if (s != null && s.f30357g) {
                        c0(s, 16);
                    }
                    DialogInterface.OnCancelListener onCancelListener = this.j;
                    if (onCancelListener != null) {
                        onCancelListener.onCancel(this.k);
                        return;
                    }
                    return;
                }
                if (s != null && s.l0) {
                    StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                    statisticItem2.param("obj_source", 31);
                    TiebaStatic.log(statisticItem2);
                }
                StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
                statisticItem3.param("obj_param1", this.t);
                if (intValue == R.drawable.obfuscated_res_0x7f080823) {
                    if (!l.z()) {
                        n.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f111d);
                        return;
                    }
                    Y("share_to_weixin", new Object[0]);
                    Z(3);
                    s = s(3);
                    c0(s, 4);
                    if (s != null) {
                        if (v(s) && s.a() != null && s.a().contains(3)) {
                            c.a.o0.s.g.a.e(s, this.a, 3, this.j);
                        } else if (s.j0 == 1) {
                            W(s);
                        } else {
                            gVar.t(s);
                        }
                    }
                    statisticItem3.param("obj_type", 2);
                } else if (intValue == R.drawable.obfuscated_res_0x7f08081f) {
                    if (!l.z()) {
                        n.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f111d);
                        return;
                    }
                    Y("share_to_pyq", new Object[0]);
                    Z(2);
                    s = s(2);
                    c0(s, 3);
                    if (s != null) {
                        if (v(s) && s.a() != null && s.a().contains(2)) {
                            c.a.o0.s.g.a.e(s, this.a, 2, this.j);
                        } else if (s.j0 == 1) {
                            W(s);
                        } else {
                            if (s.f30352b) {
                                s.s = "【" + s.r + "】 " + s.s;
                            }
                            gVar.u(s);
                        }
                    }
                    statisticItem3.param("obj_type", 3);
                } else if (intValue == R.drawable.obfuscated_res_0x7f080821) {
                    if (!l.z()) {
                        n.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f111d);
                        return;
                    }
                    if (c0.b(this.a, "com.tencent.mobileqq")) {
                        Y("share_to_qzone", new Object[0]);
                        Z(4);
                        s = s(4);
                        c0(s, 5);
                        if (s != null) {
                            if (v(s) && s.a() != null && s.a().contains(4)) {
                                c.a.o0.s.g.a.e(s, this.a, 4, this.j);
                            } else {
                                gVar.p(s);
                            }
                        }
                    } else {
                        Context context = this.a;
                        BdToast.c(context, context.getText(R.string.obfuscated_res_0x7f0f1128)).q();
                    }
                    statisticItem3.param("obj_type", 5);
                } else if (intValue == R.drawable.icon_qq_weibo) {
                    if (!l.z()) {
                        n.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f111d);
                        return;
                    }
                    Y("share_to_qweibo", new Object[0]);
                    Z(5);
                    s = s(5);
                    if (s != null) {
                        if (!s.a) {
                            s.s = p(s);
                        }
                        gVar.s(s);
                    }
                } else if (intValue == R.drawable.obfuscated_res_0x7f080824) {
                    if (!l.z()) {
                        n.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f111d);
                        return;
                    }
                    Y("share_to_sweibo", new Object[0]);
                    Z(6);
                    s = s(6);
                    c0(s, 7);
                    if (s != null) {
                        if (!s.a) {
                            s.s = p(s);
                        }
                        if (v(s) && s.a() != null && s.a().contains(4)) {
                            c.a.o0.s.g.a.e(s, this.a, 6, this.j);
                        } else {
                            gVar.r(s);
                        }
                    }
                    statisticItem3.param("obj_type", 6);
                } else if (intValue == R.drawable.icon_renren) {
                    if (!l.z()) {
                        n.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f111d);
                        return;
                    }
                    Y("share_to_renren", new Object[0]);
                    Z(7);
                    s = s(7);
                    if (s != null) {
                        if (!s.a) {
                            s.s = p(s);
                        }
                        gVar.q(s);
                    }
                } else if (intValue == R.drawable.obfuscated_res_0x7f080820) {
                    if (!l.z()) {
                        n.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f111d);
                        return;
                    }
                    if (c0.b(this.a, "com.tencent.mobileqq")) {
                        Y("share_to_qq_friend", new Object[0]);
                        Z(8);
                        s = s(8);
                        c0(s, 9);
                        if (s != null) {
                            if (v(s) && s.a() != null && s.a().contains(4)) {
                                c.a.o0.s.g.a.e(s, this.a, 8, this.j);
                            } else {
                                gVar.o(s);
                            }
                        }
                    } else {
                        Context context2 = this.a;
                        BdToast.c(context2, context2.getText(R.string.obfuscated_res_0x7f0f1128)).q();
                    }
                    statisticItem3.param("obj_type", 4);
                } else if (intValue == R.drawable.obfuscated_res_0x7f080988) {
                    if (this.m == null) {
                        this.m = new PermissionJudgePolicy();
                    }
                    this.m.clearRequestPermissionList();
                    this.m.appendRequestPermission((Activity) this.a, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.m.startRequestPermission((Activity) this.a)) {
                        this.v = false;
                        return;
                    }
                    m();
                    c0(s, 17);
                    if (FileHelper.isLocalFile(s.v)) {
                        if (FileHelper.copyImageFile(FileHelper.getImageRealPathFromUri(this.a, s.v), UUID.randomUUID().toString().replace("-", "").toLowerCase(), this.a) == 0) {
                            n.N(this.a, "保存成功！");
                        } else {
                            n.N(this.a, "保存失败！");
                        }
                    } else {
                        Uri uri = s.v;
                        if (uri == null) {
                            return;
                        }
                        String uri2 = uri.toString();
                        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                        if (currentActivity == null) {
                            return;
                        }
                        new InsertGalleryAsyncTask(currentActivity, uri2, new f(this)).execute(new String[0]);
                    }
                    statisticItem3.param("obj_type", 1);
                } else if (intValue == R.drawable.obfuscated_res_0x7f080985) {
                    c0(s, 10);
                    View.OnClickListener onClickListener = this.f17691h;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    } else {
                        c.a.d.f.p.c.a(s.t);
                        n.N(this.a.getApplicationContext(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0438));
                    }
                    a0(s);
                    if (s != null && s.a) {
                        b0(8, s.C);
                    }
                    statisticItem3.param("obj_type", 8);
                }
                statisticItem3.param("obj_source", 6);
                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if (s != null) {
                    statisticItem3.param("fid", s.q);
                    statisticItem3.param("fname", s.p);
                }
                TiebaStatic.log(statisticItem3);
            }
        }
    }

    public final String p(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, shareItem)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(shareItem.r)) {
                sb.append("【");
                sb.append(shareItem.r);
                sb.append("】 ");
            }
            if (!TextUtils.isEmpty(shareItem.r)) {
                sb.append(shareItem.s);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0219, (ViewGroup) null) : (View) invokeV.objValue;
    }

    public final Location r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? c.a.p0.l0.h.b() : (Location) invokeV.objValue;
    }

    public ShareItem s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048618, this, i2)) == null) {
            ShareItem shareItem = this.u.get(i2);
            return shareItem == null ? this.u.get(1) : shareItem;
        }
        return (ShareItem) invokeI.objValue;
    }

    public void t(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, onDismissListener) == null) || onDismissListener == null) {
            return;
        }
        this.i = onDismissListener;
    }

    public LinearLayout u(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048620, this, i2, i3)) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107));
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.a();
            return shareDialogItemView;
        }
        return (LinearLayout) invokeII.objValue;
    }

    public final boolean v(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, shareItem)) == null) ? (TextUtils.isEmpty(shareItem.t0) || TextUtils.isEmpty(shareItem.u0)) ? false : true : invokeL.booleanValue;
    }

    public final boolean w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i2)) == null) ? (i2 & 8) > 0 : invokeI.booleanValue;
    }

    public final boolean x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i2)) == null) ? (i2 & 4) > 0 : invokeI.booleanValue;
    }

    public final boolean y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048624, this, i2)) == null) ? (i2 & 1) > 0 : invokeI.booleanValue;
    }

    public final boolean z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i2)) == null) ? (i2 & 2) > 0 : invokeI.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        this(context, false, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
