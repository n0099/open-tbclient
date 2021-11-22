package b.a.q0.f1.b;

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
    public static boolean f13298a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f13299a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f13300b;

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
            this.f13299a = alertDialog;
            this.f13300b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 3) {
                    this.f13299a.dismiss();
                    new BdTopToast(this.f13300b, 2000).setIcon(true).setContent(this.f13300b.getString(R.string.youngster_close_title)).show((ViewGroup) this.f13300b.findViewById(16908290));
                }
            }
        }
    }

    /* renamed from: b.a.q0.f1.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0695b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f13301a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f13302b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0695b(int i2, AlertDialog alertDialog, Activity activity) {
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
            this.f13301a = alertDialog;
            this.f13302b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 3) {
                    this.f13301a.dismiss();
                    new BdTopToast(this.f13302b, 2000).setIcon(true).setContent(this.f13302b.getString(R.string.youngster_close_title)).show((ViewGroup) this.f13302b.findViewById(16908290));
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
                b.f13298a = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f13303e;

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
            this.f13303e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MainTabActivityConfig.toExitApp(this.f13303e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f13304e;

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
            this.f13304e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f13304e);
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
        public final /* synthetic */ Activity f13305e;

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
            this.f13305e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f13305e);
                youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
                if (this.f13305e.getComponentName().getClassName().contains("MainTabActivity")) {
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
        public final /* synthetic */ AlertDialog f13306a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f13307b;

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
            this.f13306a = alertDialog;
            this.f13307b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 3) {
                    this.f13306a.dismiss();
                    new BdTopToast(this.f13307b, 2000).setIcon(true).setContent(this.f13307b.getString(R.string.youngster_close_title)).show((ViewGroup) this.f13307b.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f13308a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f13309b;

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
            this.f13308a = alertDialog;
            this.f13309b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                int intValue = data instanceof Integer ? ((Integer) data).intValue() : 0;
                if (intValue == 6) {
                    this.f13308a.dismiss();
                    new BdTopToast(this.f13309b, 2000).setIcon(true).setContent(this.f13309b.getString(R.string.youngster_dialog_close_time_success_message)).show((ViewGroup) this.f13309b.findViewById(16908290));
                } else if (intValue == 7) {
                    this.f13308a.dismiss();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f13310a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f13311b;

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
            this.f13310a = alertDialog;
            this.f13311b = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 3) {
                    this.f13310a.dismiss();
                    new BdTopToast(this.f13311b, 2000).setIcon(true).setContent(this.f13311b.getString(R.string.youngster_close_title)).show((ViewGroup) this.f13311b.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f13312e;

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
            this.f13312e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MainTabActivityConfig.toExitApp(this.f13312e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f13313e;

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
            this.f13313e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f13313e);
                youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
                if (this.f13313e.getComponentName().getClassName().contains("MainTabActivity")) {
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
            if (b.a.q0.f1.b.c.d()) {
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
                C0695b c0695b = new C0695b(2921486, t, currentActivity);
                if (currentActivity instanceof BaseActivity) {
                    BdUniqueId uniqueId = ((BaseActivity) currentActivity).getUniqueId();
                    aVar.setTag(uniqueId);
                    c0695b.setTag(uniqueId);
                } else if (currentActivity instanceof BaseFragmentActivity) {
                    BdUniqueId uniqueId2 = ((BaseFragmentActivity) currentActivity).getUniqueId();
                    aVar.setTag(uniqueId2);
                    c0695b.setTag(uniqueId2);
                }
                MessageManager.getInstance().registerListener(aVar);
                MessageManager.getInstance().registerListener(c0695b);
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
            if (b.a.q0.f1.b.c.d()) {
                if (f13298a) {
                    if (b.a.q0.f1.b.c.f13314a) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921561, 7));
                        return d();
                    }
                    return true;
                } else if (b.a.q0.f1.b.c.f13314a) {
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
                    f13298a = true;
                    return true;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
