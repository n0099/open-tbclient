package c.a.p0.t.g;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.j;
import c.a.p0.s.s.a;
import c.a.q0.i3.z;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.t.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0706a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f14898e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f14899f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnCancelListener f14900g;

        public C0706a(int i2, Context context, DialogInterface.OnCancelListener onCancelListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), context, onCancelListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14898e = i2;
            this.f14899f = context;
            this.f14900g = onCancelListener;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                a.d(this.f14898e, this.f14899f);
                aVar.dismiss();
                DialogInterface.OnCancelListener onCancelListener = this.f14900g;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(aVar.getDialog());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnCancelListener f14901e;

        public b(DialogInterface.OnCancelListener onCancelListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onCancelListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14901e = onCancelListener;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                DialogInterface.OnCancelListener onCancelListener = this.f14901e;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(aVar.getDialog());
                }
            }
        }
    }

    public static boolean b(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i2)) == null) {
            if (i2 == 3 || i2 == 2) {
                return z.b(context, "com.tencent.mm");
            }
            if (i2 == 8 || i2 == 4) {
                return z.b(context, "com.tencent.mobileqq");
            }
            if (i2 == 6) {
                return z.b(context, "com.sina.weibo");
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public static String c(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i2, context)) == null) {
            if (i2 == 3 || i2 == 2) {
                return String.format(context.getString(R.string.command_share_paste), context.getString(R.string.wechat));
            }
            if (i2 == 8 || i2 == 4) {
                return String.format(context.getString(R.string.command_share_paste), context.getString(R.string.qq));
            }
            if (i2 == 6) {
                return String.format(context.getString(R.string.command_share_paste), context.getString(R.string.sinaweibo));
            }
            return null;
        }
        return (String) invokeIL.objValue;
    }

    public static void d(int i2, Context context) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, null, i2, context) == null) {
            if (i2 == 3 || i2 == 2) {
                if (!b(context, i2)) {
                    BdToast.c(context.getApplicationContext(), context.getText(R.string.share_wechat_not_install)).q();
                    return;
                }
                intent = new Intent("android.intent.action.MAIN");
                ComponentName componentName = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.addFlags(268435456);
                intent.setComponent(componentName);
                context.startActivity(intent);
            } else if (i2 == 8 || i2 == 4) {
                if (!b(context, i2)) {
                    BdToast.c(context.getApplicationContext(), context.getText(R.string.share_qq_not_install)).q();
                    return;
                }
                intent = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mobileqq");
                intent.addFlags(268435456);
                context.startActivity(intent);
            } else if (i2 != 6) {
                intent = null;
            } else if (!b(context, i2)) {
                BdToast.c(context.getApplicationContext(), context.getText(R.string.share_sina_weibo_not_install)).q();
                return;
            } else {
                intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse("sinaweibo://splash"));
                intent.addFlags(268435456);
            }
            if (intent != null) {
                context.startActivity(intent);
            }
        }
    }

    public static void e(ShareItem shareItem, Context context, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, shareItem, context, i2, onCancelListener) == null) || shareItem == null || TextUtils.isEmpty(shareItem.s) || TextUtils.isEmpty(shareItem.r) || !(context instanceof Activity)) {
            return;
        }
        c.a.e.e.p.a.a(shareItem.o0);
        Activity activity = (Activity) context;
        c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(activity);
        aVar.setTitle(context.getString(R.string.command_share_tips));
        aVar.setMessage(shareItem.o0);
        aVar.setAutoNight(false);
        aVar.setCancelable(true);
        aVar.setTitleShowCenter(true);
        aVar.setPositiveButton(c(i2, context), new C0706a(i2, context, onCancelListener));
        aVar.setNegativeButton(R.string.cancel, new b(onCancelListener)).create(j.a(activity));
        if (onCancelListener != null) {
            aVar.setOnCalcelListener(onCancelListener);
        }
        aVar.show();
    }
}
