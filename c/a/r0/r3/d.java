package c.a.r0.r3;

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
import c.a.e.a.j;
import c.a.e.e.m.g;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.t.c.h0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
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
/* loaded from: classes3.dex */
public class d implements View.OnClickListener, c.a.r0.r3.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public static final int w;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f24396e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f24397f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f24398g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.r3.c f24399h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f24400i;

    /* renamed from: j  reason: collision with root package name */
    public View f24401j;
    public AlertDialog k;
    public DialogInterface.OnDismissListener l;
    public boolean m;
    public ShareDialogConfig n;
    public float o;
    public CustomMessageListener p;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f24402a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24402a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.f24402a.g();
                d dVar = this.f24402a;
                dVar.l(dVar.n);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f24403e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24403e = dVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.f24403e.l != null) {
                    this.f24403e.l.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (this.f24403e.f24399h != null) {
                    this.f24403e.f24399h.s();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f24404e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24404e = dVar;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.f24404e.k == null || !this.f24404e.k.isShowing()) {
                    return null;
                }
                this.f24404e.h();
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1794978106, "Lc/a/r0/r3/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1794978106, "Lc/a/r0/r3/d;");
                return;
            }
        }
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds130);
        q = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
        r = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X007);
        s = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
        t = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
        u = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X08);
        v = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X06);
        w = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    }

    public d(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = 0.33f;
        this.p = new a(this, 2001304);
        this.f24396e = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f24397f = linearLayout;
        linearLayout.setOrientation(1);
        EMTextView eMTextView = new EMTextView(context);
        this.f24398g = eMTextView;
        eMTextView.setTextSize(0, u);
        EMTextView eMTextView2 = this.f24398g;
        int i4 = q;
        eMTextView2.setPadding(i4, r, i4, s);
        this.f24398g.setGravity(1);
        this.f24398g.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f24397f.addView(this.f24398g);
        this.f24399h = new c.a.r0.r3.c(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i5 = ShareGridLayout.DEFAULT_MARGIN_LEFT_RIGHT;
        layoutParams.leftMargin = i5;
        layoutParams.rightMargin = i5;
        this.f24397f.addView(this.f24399h.l(z), layoutParams);
        EMTextView eMTextView3 = new EMTextView(context);
        this.f24400i = eMTextView3;
        eMTextView3.setGravity(1);
        this.f24400i.setTextSize(0, v);
        this.f24400i.setText(R.string.cancel);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = w;
        this.f24400i.setLayoutParams(layoutParams2);
        EMTextView eMTextView4 = this.f24400i;
        int i6 = t;
        eMTextView4.setPadding(0, i6, 0, i6);
        this.f24400i.setOnClickListener(this);
        this.f24397f.addView(this.f24400i);
        this.f24401j = new View(context);
        this.f24401j.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.bottom_enter_anim_place_holder_height)));
        this.f24397f.addView(this.f24401j);
        this.f24399h.t(this);
    }

    @Override // c.a.r0.r3.a
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            h();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f24397f);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f24398g, R.color.CAM_X0109);
            SkinManager.setViewTextColorSelector(this.f24400i, R.color.CAM_X0107);
        }
    }

    public void h() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (alertDialog = this.k) == null) {
            return;
        }
        Context context = this.f24396e;
        if (context instanceof Activity) {
            g.a(alertDialog, (Activity) context);
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
        }
    }

    public void i(ShareDialogConfig.From from) {
        h0 sharePanelConfData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, from) == null) && (sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData()) != null && sharePanelConfData.d(from) && sharePanelConfData.c() && !k.isEmpty(sharePanelConfData.b())) {
            this.f24398g.setText(sharePanelConfData.b());
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
            this.l = onDismissListener;
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
            if (!shareItem2.d0) {
                if (shareItem2.e0) {
                    this.f24398g.setText(R.string.transmit_share_more);
                } else {
                    this.f24398g.setText(R.string.transmit_share_no_outer);
                }
            } else {
                String sharePanelText = TbSingleton.getInstance().getSharePanelText();
                if (!TextUtils.isEmpty(sharePanelText)) {
                    this.f24398g.setText(sharePanelText);
                } else {
                    this.f24398g.setText(R.string.transmit_share_not_add_experience);
                }
            }
            if (shareDialogConfig.isShowNovelMask()) {
                this.f24398g.setVisibility(4);
            }
            this.f24399h.u(shareDialogConfig, this.m);
            this.n = shareDialogConfig;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.m = z;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            g();
            AlertDialog create = new AlertDialog.Builder(this.f24396e, R.style.DialogTheme).create();
            this.k = create;
            create.setCanceledOnTouchOutside(true);
            this.k.setOnDismissListener(new b(this));
            Context context = this.f24396e;
            if (context instanceof Activity) {
                g.i(this.k, (Activity) context);
            }
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f24397f);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0212);
            Window window = this.k.getWindow();
            if (window == null) {
                return;
            }
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.f24397f);
            window.setDimAmount(this.o);
            j();
            j.a(this.f24396e).registerListener(this.p);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
        }
    }

    public final void o(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.f24396e, str, PrefetchEvent.STATE_CLICK, 1, objArr);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, view) == null) && view == this.f24400i) {
            o("share_cancel", new Object[0]);
            h();
        }
    }
}
