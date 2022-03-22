package c.a.p0.x3.f;

import android.content.DialogInterface;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.t.o;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.stampmission.mission.StampMission;
import com.baidu.tieba.stampmission.view.SingleStampView;
import com.baidu.tieba.stampmission.view.StampMissionContentView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(List<c.a.p0.x3.c.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return 0;
            }
            int i = 0;
            for (c.a.p0.x3.c.a aVar : list) {
                if (aVar.a() >= aVar.b()) {
                    i++;
                }
            }
            if (i == 0) {
                return 1;
            }
            if (i == 1) {
                return 2;
            }
            if (i == 2) {
                return 3;
            }
            return i == list.size() ? 4 : 0;
        }
        return invokeL.intValue;
    }

    public static /* synthetic */ void b(o oVar, c.a.p0.x3.c.a aVar) {
        c.a.o0.l.a.m(TbadkCoreApplication.getInst(), "https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&user_id=" + TbadkCoreApplication.getCurrentAccount() + "&icon_name=" + aVar.e());
        oVar.d();
    }

    public static void e(c.a.p0.x3.c.b bVar, String str, c.a.p0.x3.c.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar, str, cVar) == null) || bVar == null || bVar.f20710h == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (bVar.f20710h.a != null) {
            c.a.p0.x3.c.a aVar = new c.a.p0.x3.c.a();
            aVar.h(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0626));
            aVar.j(bVar.f20710h.a.a);
            aVar.i(bVar.f20710h.a.f20711b);
            aVar.f(c.a.p0.x3.b.r().q(StampMission.Type.FOLLOW_FORUM));
            aVar.g(c.a.p0.x3.b.r().s(StampMission.Type.FOLLOW_FORUM));
            arrayList.add(aVar);
        }
        if (bVar.f20710h.f20712b != null) {
            c.a.p0.x3.c.a aVar2 = new c.a.p0.x3.c.a();
            aVar2.h(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09e1));
            aVar2.j(bVar.f20710h.f20712b.a);
            aVar2.i(bVar.f20710h.f20712b.f20711b);
            aVar2.f(c.a.p0.x3.b.r().q(StampMission.Type.LIKE_THREAD));
            aVar2.g(c.a.p0.x3.b.r().s(StampMission.Type.LIKE_THREAD));
            arrayList.add(aVar2);
        }
        if (bVar.f20710h.f20713c != null) {
            c.a.p0.x3.c.a aVar3 = new c.a.p0.x3.c.a();
            aVar3.h(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f96));
            aVar3.j(bVar.f20710h.f20713c.a);
            aVar3.i(bVar.f20710h.f20713c.f20711b);
            aVar3.f(c.a.p0.x3.b.r().q(StampMission.Type.REPLAY_THREAD));
            aVar3.g(c.a.p0.x3.b.r().s(StampMission.Type.REPLAY_THREAD));
            arrayList.add(aVar3);
        }
        f(arrayList, (bVar.f20704b * 1000) - System.currentTimeMillis(), str, cVar);
    }

    public static void f(List<c.a.p0.x3.c.a> list, long j, String str, c.a.p0.x3.c.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{list, Long.valueOf(j), str, cVar}) == null) || list.isEmpty() || j < 0 || TbadkCoreApplication.getInst().getCurrentActivity() == null) {
            return;
        }
        if (!UbsABTestHelper.isStampMissionDialogABTestA() || TbadkCoreApplication.getInst().getCurrentActivity().toString().contains("MainTabActivity")) {
            TBAlertConfig.b a = TBAlertConfig.a(new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0645, TBAlertConfig.OperateBtnStyle.FORCE));
            final o oVar = new o(TbadkCoreApplication.getInst().getCurrentActivity());
            final StampMissionContentView stampMissionContentView = new StampMissionContentView(TbadkCoreApplication.getInst().getCurrentActivity());
            stampMissionContentView.setData(list, j, new SingleStampView.a() { // from class: c.a.p0.x3.f.c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.stampmission.view.SingleStampView.a
                public final void a(c.a.p0.x3.c.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        e.b(o.this, aVar);
                    }
                }
            });
            oVar.v(R.string.obfuscated_res_0x7f0f11ba);
            oVar.l(R.string.obfuscated_res_0x7f0f11bb);
            oVar.j(stampMissionContentView);
            oVar.i(false);
            oVar.t(true);
            oVar.g();
            oVar.q(new DialogInterface.OnDismissListener() { // from class: c.a.p0.x3.f.d
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        StampMissionContentView.this.a();
                    }
                }
            });
            oVar.h(new View.OnClickListener() { // from class: c.a.p0.x3.f.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        StampMissionContentView.this.a();
                    }
                }
            });
            oVar.s(a);
            oVar.y();
            c.a.o0.r.j0.b.k().x(str, System.currentTimeMillis());
            if (cVar != null) {
                cVar.f20715c = a(list);
                c.a.p0.x3.d.a.a(cVar);
            }
        }
    }
}
