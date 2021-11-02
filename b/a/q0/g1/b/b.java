package b.a.q0.g1.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.s.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f12592a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f12593a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f12594b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, AlertDialog alertDialog, Activity activity) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), alertDialog, activity};
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
            this.f12593a = alertDialog;
            this.f12594b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 3) {
                    this.f12593a.dismiss();
                    new BdTopToast(this.f12594b, 2000).setIcon(true).setContent(this.f12594b.getString(R.string.youngster_close_title)).show((ViewGroup) this.f12594b.findViewById(16908290));
                }
            }
        }
    }

    /* renamed from: b.a.q0.g1.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0662b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f12595a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f12596b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0662b(int i2, AlertDialog alertDialog, Activity activity) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), alertDialog, activity};
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
            this.f12595a = alertDialog;
            this.f12596b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 3) {
                    this.f12595a.dismiss();
                    new BdTopToast(this.f12596b, 2000).setIcon(true).setContent(this.f12596b.getString(R.string.youngster_close_title)).show((ViewGroup) this.f12596b.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                b.f12592a = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f12597e;

        public d(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12597e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MainTabActivityConfig.toExitApp(this.f12597e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f12598e;

        public e(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12598e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f12598e);
                youngsterPasswordActivityConfig.setYoungsterPasswordPageType(6);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f12599e;

        public f(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12599e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f12599e);
                youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
                if (this.f12599e.getComponentName().getClassName().contains("MainTabActivity")) {
                    youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(3);
                } else {
                    youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(1);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f12600a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f12601b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(int i2, AlertDialog alertDialog, Activity activity) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), alertDialog, activity};
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
            this.f12600a = alertDialog;
            this.f12601b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 3) {
                    this.f12600a.dismiss();
                    new BdTopToast(this.f12601b, 2000).setIcon(true).setContent(this.f12601b.getString(R.string.youngster_close_title)).show((ViewGroup) this.f12601b.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f12602a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f12603b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(int i2, AlertDialog alertDialog, Activity activity) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), alertDialog, activity};
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
            this.f12602a = alertDialog;
            this.f12603b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                int intValue = data instanceof Integer ? ((Integer) data).intValue() : 0;
                if (intValue == 6) {
                    this.f12602a.dismiss();
                    new BdTopToast(this.f12603b, 2000).setIcon(true).setContent(this.f12603b.getString(R.string.youngster_dialog_close_time_success_message)).show((ViewGroup) this.f12603b.findViewById(16908290));
                } else if (intValue == 7) {
                    this.f12602a.dismiss();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f12604a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f12605b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(int i2, AlertDialog alertDialog, Activity activity) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), alertDialog, activity};
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
            this.f12604a = alertDialog;
            this.f12605b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 3) {
                    this.f12604a.dismiss();
                    new BdTopToast(this.f12605b, 2000).setIcon(true).setContent(this.f12605b.getString(R.string.youngster_close_title)).show((ViewGroup) this.f12605b.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f12606e;

        public j(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12606e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MainTabActivityConfig.toExitApp(this.f12606e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f12607e;

        public k(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12607e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f12607e);
                youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
                if (this.f12607e.getComponentName().getClassName().contains("MainTabActivity")) {
                    youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(3);
                } else {
                    youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(1);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            b.a.q0.s.e0.b.j().w("key_youngster_use_time_dialog_show_time", System.currentTimeMillis());
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            b.a.q0.s.e0.b.j().w("key_youngster_use_time_dialog_show_time", 0L);
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            long l = b.a.q0.s.e0.b.j().l("key_youngster_use_time_dialog_show_time", 0L);
            return l > System.currentTimeMillis() || System.currentTimeMillis() - l <= 600000;
        }
        return invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (b.a.q0.g1.b.c.d()) {
                Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                if (currentActivity == null || currentActivity.isDestroyed() || currentActivity.getComponentName().getClassName().contains("YoungsterPasswordActivity") || currentActivity.getRequestedOrientation() == 0) {
                    return false;
                }
                RelativeLayout relativeLayout = new RelativeLayout(currentActivity);
                View view = new View(currentActivity);
                b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(view);
                d2.m(1);
                d2.n(R.string.J_X06);
                d2.f(R.color.CAM_X0205);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds103));
                layoutParams.setMargins(0, UtilHelper.getDimenPixelSize(R.dimen.tbds100), 0, 0);
                relativeLayout.addView(view, layoutParams);
                ImageView imageView = new ImageView(currentActivity);
                WebPManager.setMaskDrawable(imageView, R.drawable.pic_mask_qingshaonian_time, null);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(14);
                relativeLayout.addView(imageView, layoutParams2);
                l lVar = new l(currentActivity);
                lVar.q(R.string.youngster_open_title);
                lVar.j(R.string.youngster_dialog_close_night_message);
                lVar.i(relativeLayout);
                lVar.p(new TBAlertConfig.a(R.string.youngster_dialog_close_quit_message, TBAlertConfig.OperateBtnStyle.MAIN, new j(currentActivity)), new TBAlertConfig.a(R.string.youngster_settings_close_title, TBAlertConfig.OperateBtnStyle.MAIN, new k(currentActivity)));
                lVar.g(false);
                AlertDialog t = lVar.t();
                a aVar = new a(2921484, t, currentActivity);
                C0662b c0662b = new C0662b(2921486, t, currentActivity);
                if (currentActivity instanceof BaseActivity) {
                    BdUniqueId uniqueId = ((BaseActivity) currentActivity).getUniqueId();
                    aVar.setTag(uniqueId);
                    c0662b.setTag(uniqueId);
                } else if (currentActivity instanceof BaseFragmentActivity) {
                    BdUniqueId uniqueId2 = ((BaseFragmentActivity) currentActivity).getUniqueId();
                    aVar.setTag(uniqueId2);
                    c0662b.setTag(uniqueId2);
                }
                MessageManager.getInstance().registerListener(aVar);
                MessageManager.getInstance().registerListener(c0662b);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (b.a.q0.g1.b.c.d()) {
                if (f12592a) {
                    if (b.a.q0.g1.b.c.f12608a) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921561, 7));
                        return d();
                    }
                    return true;
                } else if (b.a.q0.g1.b.c.f12608a) {
                    return d();
                } else {
                    Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                    if (currentActivity == null || currentActivity.isDestroyed() || currentActivity.getComponentName().getClassName().contains("YoungsterPasswordActivity") || currentActivity.getRequestedOrientation() == 0) {
                        return false;
                    }
                    RelativeLayout relativeLayout = new RelativeLayout(currentActivity);
                    View view = new View(currentActivity);
                    b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(view);
                    d2.m(1);
                    d2.n(R.string.J_X06);
                    d2.f(R.color.CAM_X0205);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds103));
                    layoutParams.setMargins(0, UtilHelper.getDimenPixelSize(R.dimen.tbds100), 0, 0);
                    relativeLayout.addView(view, layoutParams);
                    ImageView imageView = new ImageView(currentActivity);
                    WebPManager.setMaskDrawable(imageView, R.drawable.pic_mask_qingshaonian_time, null);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(14);
                    relativeLayout.addView(imageView, layoutParams2);
                    l lVar = new l(currentActivity);
                    lVar.q(R.string.youngster_open_title);
                    lVar.j(R.string.youngster_dialog_close_time_message);
                    lVar.i(relativeLayout);
                    lVar.p(new TBAlertConfig.a(R.string.youngster_dialog_close_quit_message, TBAlertConfig.OperateBtnStyle.MAIN, new d(currentActivity)), new TBAlertConfig.a(R.string.youngster_settings_input_password_time, TBAlertConfig.OperateBtnStyle.MAIN, new e(currentActivity)), new TBAlertConfig.a(R.string.youngster_settings_close_title, TBAlertConfig.OperateBtnStyle.MAIN, new f(currentActivity)));
                    lVar.g(false);
                    lVar.o(new c());
                    AlertDialog t = lVar.t();
                    g gVar = new g(2921484, t, currentActivity);
                    h hVar = new h(2921561, t, currentActivity);
                    i iVar = new i(2921486, t, currentActivity);
                    if (currentActivity instanceof BaseActivity) {
                        BdUniqueId uniqueId = ((BaseActivity) currentActivity).getUniqueId();
                        hVar.setTag(uniqueId);
                        gVar.setTag(uniqueId);
                        iVar.setTag(uniqueId);
                    } else if (currentActivity instanceof BaseFragmentActivity) {
                        BdUniqueId uniqueId2 = ((BaseFragmentActivity) currentActivity).getUniqueId();
                        hVar.setTag(uniqueId2);
                        gVar.setTag(uniqueId2);
                        iVar.setTag(uniqueId2);
                    }
                    MessageManager.getInstance().registerListener(gVar);
                    MessageManager.getInstance().registerListener(hVar);
                    MessageManager.getInstance().registerListener(iVar);
                    a();
                    f12592a = true;
                    return true;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
