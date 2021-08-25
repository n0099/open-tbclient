package c.a.p0.s.m;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.s.f;
import c.a.p0.s.s.i;
import c.a.q0.i3.y;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f14066a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f14067e;

        public a(PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14067e = popupDialog;
        }

        @Override // c.a.p0.s.s.i.e
        public void onItemClick(i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (i2 == 0) {
                    b.h(true, true);
                    TiebaStatic.log(new StatisticItem("c14201").param("obj_locate", "1"));
                } else if (i2 == 1) {
                    b.h(true, false);
                    TiebaStatic.log(new StatisticItem("c14201").param("obj_locate", "2"));
                }
                PopupDialog popupDialog = this.f14067e;
                if (popupDialog != null) {
                    popupDialog.dismiss();
                }
            }
        }
    }

    /* renamed from: c.a.p0.s.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0691b implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f14068a;

        public C0691b(PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14068a = popupDialog;
        }

        @Override // c.a.p0.s.s.i.c
        public void onClick() {
            PopupDialog popupDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (popupDialog = this.f14068a) == null) {
                return;
            }
            popupDialog.dismiss();
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f14066a : (String) invokeV.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? d() || e() : invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "5".equals(f14066a) : invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? "6".equals(f14066a) : invokeV.booleanValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                TbPageContext pageContext = ((TbPageContextSupport) currentActivity).getPageContext();
                String string = pageContext.getString(R.string.work_publish_open_dialog_title);
                PopupDialog popupDialog = new PopupDialog(pageContext);
                i iVar = new i(currentActivity);
                iVar.q(string);
                ArrayList arrayList = new ArrayList();
                f fVar = new f(0, pageContext.getString(R.string.work_publish_open_dialog_load_draft), iVar);
                fVar.n(R.color.CAM_X0105);
                arrayList.add(fVar);
                f fVar2 = new f(1, pageContext.getString(R.string.work_publish_open_dialog_add_new), iVar);
                fVar2.n(R.color.CAM_X0105);
                arrayList.add(fVar2);
                a aVar = new a(popupDialog);
                C0691b c0691b = new C0691b(popupDialog);
                iVar.k(arrayList);
                iVar.n(aVar);
                iVar.m(c0691b);
                popupDialog.setCanceledOnTouchOutside(true);
                popupDialog.setContentView(iVar);
                popupDialog.showDialog();
                TiebaStatic.log(new StatisticItem("c14200"));
            }
        }
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        f14066a = str;
        if (!TextUtils.isEmpty(y.w())) {
            f();
        } else {
            h(false, false);
        }
    }

    public static void h(boolean z, boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (!z) {
                i2 = 0;
            } else if (z2) {
                i2 = 2;
            } else {
                y.r("");
                i2 = 1;
            }
            c.f14071c.c(i2, TbadkCoreApplication.getInst().getCurrentActivity());
        }
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            f14066a = str;
        }
    }
}
