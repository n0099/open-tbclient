package c.a.r0.t.h;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.r0.s.t.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.view.CustomPushPremissionDialogView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.t.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class View$OnClickListenerC0858a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f13896e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int[] f13897f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.s.t.a f13898g;

        public View$OnClickListenerC0858a(TbPageContext tbPageContext, int[] iArr, c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, iArr, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13896e = tbPageContext;
            this.f13897f = iArr;
            this.f13898g = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                a.c(this.f13896e);
                this.f13897f[0] = 1;
                this.f13898g.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f13899e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.s.t.a f13900f;

        public b(int[] iArr, c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iArr, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13899e = iArr;
            this.f13900f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f13899e[0] = 2;
                this.f13900f.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f13901e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int[] f13902f;

        public c(int i2, int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), iArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13901e = i2;
            this.f13902f = iArr;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                StatisticItem statisticItem = new StatisticItem("c13673");
                statisticItem.param("obj_source", this.f13901e);
                statisticItem.param("obj_type", this.f13902f[0]);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public static c.a.r0.s.t.a a(TbPageContext<?> tbPageContext, int i2, int i3, int i4, int i5, a.e eVar, a.e eVar2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{tbPageContext, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), eVar, eVar2})) == null) {
            return b(tbPageContext, i2 >= 0 ? TbadkCoreApplication.getInst().getContext().getString(i2) : null, TbadkCoreApplication.getInst().getContext().getString(i3), TbadkCoreApplication.getInst().getContext().getString(i4), TbadkCoreApplication.getInst().getContext().getString(i5), eVar, eVar2);
        }
        return (c.a.r0.s.t.a) invokeCommon.objValue;
    }

    public static c.a.r0.s.t.a b(TbPageContext<?> tbPageContext, String str, String str2, String str3, String str4, a.e eVar, a.e eVar2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{tbPageContext, str, str2, str3, str4, eVar, eVar2})) == null) {
            if (tbPageContext == null) {
                return null;
            }
            c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(tbPageContext.getPageActivity());
            aVar.setTitle(str);
            aVar.setMessage(str2);
            aVar.setPositiveButton(str3, eVar);
            aVar.setNegativeButton(str4, eVar2);
            aVar.create(tbPageContext);
            return aVar;
        }
        return (c.a.r0.s.t.a) invokeCommon.objValue;
    }

    public static void c(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, fVar) == null) {
            try {
                if (DeviceInfoUtil.isHuaWei()) {
                    Intent intent = new Intent();
                    intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", fVar.getPageActivity().getPackageName(), null));
                    fVar.getPageActivity().startActivity(intent);
                } else {
                    Intent intent2 = new Intent();
                    intent2.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                    intent2.putExtra("android.provider.extra.APP_PACKAGE", fVar.getPageActivity().getPackageName());
                    intent2.putExtra("android.provider.extra.CHANNEL_ID", fVar.getPageActivity().getApplicationInfo().uid);
                    intent2.putExtra("app_package", fVar.getPageActivity().getPackageName());
                    intent2.putExtra("app_uid", fVar.getPageActivity().getApplicationInfo().uid);
                    fVar.getPageActivity().startActivity(intent2);
                }
            } catch (Exception unused) {
                Intent intent3 = new Intent();
                intent3.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent3.setData(Uri.fromParts("package", fVar.getPageActivity().getPackageName(), null));
                fVar.getPageActivity().startActivity(intent3);
            }
        }
    }

    public static c.a.r0.s.t.a d(TbPageContext<?> tbPageContext, a.e eVar, a.e eVar2, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, tbPageContext, eVar, eVar2, str)) == null) {
            if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
                return null;
            }
            c.a.r0.s.t.a create = new c.a.r0.s.t.a(tbPageContext.getPageActivity()).setTitle(TbadkCoreApplication.getInst().getContext().getString(R.string.confirm_title)).setMessage(String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.url_notify), str)).setPositiveButton(TbadkCoreApplication.getInst().getContext().getString(R.string.alert_yes_button), eVar).setNegativeButton(TbadkCoreApplication.getInst().getContext().getString(R.string.cancel), eVar2).create(tbPageContext);
            create.show();
            return create;
        }
        return (c.a.r0.s.t.a) invokeLLLL.objValue;
    }

    public static boolean e(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i2)) == null) {
            boolean z = false;
            if (NotificationManagerCompat.from(context).areNotificationsEnabled()) {
                return false;
            }
            Date date = new Date(c.a.r0.s.g0.b.j().l("push_permission_dialog_scene_cold_start_key", 0L));
            Date date2 = new Date(c.a.r0.s.g0.b.j().l("push_permission_dialog_scene_interaction_key", 0L));
            long currentTimeMillis = System.currentTimeMillis();
            Date date3 = new Date(currentTimeMillis);
            if (i2 == 0 && TimeHelper.getDayDifference(date3, date2) >= 7 && !TimeHelper.isSameDay(date3, date)) {
                z = true;
            }
            if (i2 == 1 && TimeHelper.getDayDifference(date3, date) >= 7 && !TimeHelper.isSameDay(date3, date2)) {
                z = true;
            }
            if (z) {
                if (i2 == 0) {
                    c.a.r0.s.g0.b.j().w("push_permission_dialog_scene_interaction_key", currentTimeMillis);
                } else if (i2 == 1) {
                    c.a.r0.s.g0.b.j().w("push_permission_dialog_scene_cold_start_key", currentTimeMillis);
                }
            }
            return z;
        }
        return invokeLI.booleanValue;
    }

    public static void f(TbPageContext<?> tbPageContext, boolean[] zArr, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65541, null, tbPageContext, zArr, i2) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || zArr == null || zArr.length != 2) {
            return;
        }
        g(tbPageContext, i2, 0L);
    }

    public static void g(TbPageContext<?> tbPageContext, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{tbPageContext, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(tbPageContext.getPageActivity());
            aVar.setCancelable(false);
            aVar.setPositiveButton((String) null, (a.e) null);
            aVar.setNegativeButton((String) null, (a.e) null);
            aVar.setContentViewSize(4);
            CustomPushPremissionDialogView customPushPremissionDialogView = new CustomPushPremissionDialogView(tbPageContext.getPageActivity());
            aVar.setContentView(customPushPremissionDialogView);
            int[] iArr = {-1};
            customPushPremissionDialogView.getPushPermissionDialogConfirmButton().setOnClickListener(new View$OnClickListenerC0858a(tbPageContext, iArr, aVar));
            customPushPremissionDialogView.getPushPermissionDialogCancelButton().setOnClickListener(new b(iArr, aVar));
            aVar.setOnDismissListener(new c(i2, iArr));
            if (j2 > 0) {
                aVar.create(tbPageContext).show(j2);
            } else {
                aVar.create(tbPageContext).show();
            }
            StatisticItem statisticItem = new StatisticItem("c13674");
            statisticItem.param("obj_source", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
