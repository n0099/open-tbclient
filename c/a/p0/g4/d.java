package c.a.p0.g4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.j;
import c.a.d.f.m.g;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.s.c.h0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
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
/* loaded from: classes2.dex */
public class d implements View.OnClickListener, c.a.p0.g4.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f15278b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f15279c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.g4.c f15280d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f15281e;

    /* renamed from: f  reason: collision with root package name */
    public View f15282f;

    /* renamed from: g  reason: collision with root package name */
    public AlertDialog f15283g;

    /* renamed from: h  reason: collision with root package name */
    public DialogInterface.OnDismissListener f15284h;
    public boolean i;
    public ShareDialogConfig j;
    public float k;
    public CustomMessageListener l;

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
                this.a.g();
                d dVar = this.a;
                dVar.l(dVar.j);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements DialogInterface.OnDismissListener {
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

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.f15284h != null) {
                    this.a.f15284h.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (this.a.f15280d != null) {
                    this.a.f15280d.s();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements CustomMessageTask.CustomRunnable<Object> {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.a.f15283g == null || !this.a.f15283g.isShowing()) {
                    return null;
                }
                this.a.h();
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1700771504, "Lc/a/p0/g4/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1700771504, "Lc/a/p0/g4/d;");
                return;
            }
        }
        n.f(TbadkCoreApplication.getInst(), R.dimen.tbds130);
        m = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
        n = n.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X007);
        o = n.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
        p = n.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
        q = n.f(TbadkCoreApplication.getInst(), R.dimen.T_X08);
        r = n.f(TbadkCoreApplication.getInst(), R.dimen.T_X06);
        s = n.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    }

    public d(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = 0.33f;
        this.l = new a(this, 2001304);
        this.a = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f15278b = linearLayout;
        linearLayout.setOrientation(1);
        EMTextView eMTextView = new EMTextView(context);
        this.f15279c = eMTextView;
        eMTextView.setTextSize(0, q);
        EMTextView eMTextView2 = this.f15279c;
        int i3 = m;
        eMTextView2.setPadding(i3, n, i3, o);
        this.f15279c.setGravity(1);
        this.f15279c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f15278b.addView(this.f15279c);
        this.f15280d = new c.a.p0.g4.c(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i4 = ShareGridLayout.f36378f;
        layoutParams.leftMargin = i4;
        layoutParams.rightMargin = i4;
        this.f15278b.addView(this.f15280d.l(z), layoutParams);
        EMTextView eMTextView3 = new EMTextView(context);
        this.f15281e = eMTextView3;
        eMTextView3.setGravity(1);
        this.f15281e.setTextSize(0, r);
        this.f15281e.setText(R.string.obfuscated_res_0x7f0f036c);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = s;
        this.f15281e.setLayoutParams(layoutParams2);
        EMTextView eMTextView4 = this.f15281e;
        int i5 = p;
        eMTextView4.setPadding(0, i5, 0, i5);
        this.f15281e.setOnClickListener(this);
        this.f15278b.addView(this.f15281e);
        this.f15282f = new View(context);
        this.f15282f.setLayoutParams(new LinearLayout.LayoutParams(-1, n.f(TbadkCoreApplication.getInst(), R.dimen.bottom_enter_anim_place_holder_height)));
        this.f15278b.addView(this.f15282f);
        this.f15280d.t(this);
    }

    @Override // c.a.p0.g4.a
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            h();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f15278b);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f15279c, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColorSelector(this.f15281e, R.color.CAM_X0107);
        }
    }

    public void h() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (alertDialog = this.f15283g) == null) {
            return;
        }
        Context context = this.a;
        if (context instanceof Activity) {
            g.a(alertDialog, (Activity) context);
            MessageManager.getInstance().unRegisterListener(this.l);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
        }
    }

    public void i(ShareDialogConfig.From from) {
        h0 sharePanelConfData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, from) == null) && (sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData()) != null && sharePanelConfData.d(from) && sharePanelConfData.c() && !m.isEmpty(sharePanelConfData.b())) {
            this.f15279c.setText(sharePanelConfData.b());
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001450, new c(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void k(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onDismissListener) == null) {
            this.f15284h = onDismissListener;
        }
    }

    public void l(ShareDialogConfig shareDialogConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, shareDialogConfig) == null) {
            if (!TextUtils.isEmpty(shareDialogConfig.shareItem.D)) {
                ShareItem shareItem = shareDialogConfig.shareItem;
                shareItem.s = shareItem.D;
            }
            ShareItem shareItem2 = shareDialogConfig.shareItem;
            if (!shareItem2.f0) {
                if (shareItem2.g0) {
                    this.f15279c.setText(R.string.obfuscated_res_0x7f0f1417);
                } else {
                    this.f15279c.setText(R.string.obfuscated_res_0x7f0f1418);
                }
            } else {
                String sharePanelText = TbSingleton.getInstance().getSharePanelText();
                if (!TextUtils.isEmpty(sharePanelText)) {
                    this.f15279c.setText(sharePanelText);
                } else {
                    this.f15279c.setText(R.string.obfuscated_res_0x7f0f1419);
                }
            }
            if (shareDialogConfig.isShowNovelMask()) {
                this.f15279c.setVisibility(4);
            }
            this.f15280d.u(shareDialogConfig, this.i);
            this.j = shareDialogConfig;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.i = z;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            g();
            AlertDialog create = new AlertDialog.Builder(this.a, R.style.obfuscated_res_0x7f100104).create();
            this.f15283g = create;
            create.setCanceledOnTouchOutside(true);
            this.f15283g.setOnDismissListener(new b(this));
            Context context = this.a;
            if (context instanceof Activity) {
                g.i(this.f15283g, (Activity) context);
            }
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f15278b);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0212);
            Window window = this.f15283g.getWindow();
            if (window == null) {
                return;
            }
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = n.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f1003ed);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.f15278b);
            window.setDimAmount(this.k);
            j();
            j.a(this.a).registerListener(this.l);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
        }
    }

    public final void o(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.a, str, "click", 1, objArr);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, view) == null) && view == this.f15281e) {
            o("share_cancel", new Object[0]);
            h();
        }
    }
}
