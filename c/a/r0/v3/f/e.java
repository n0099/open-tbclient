package c.a.r0.v3.f;

import android.content.DialogInterface;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.r.t.m;
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

    public static int a(List<c.a.r0.v3.c.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return 0;
            }
            int i2 = 0;
            for (c.a.r0.v3.c.a aVar : list) {
                if (aVar.a() >= aVar.b()) {
                    i2++;
                }
            }
            if (i2 == 0) {
                return 1;
            }
            if (i2 == 1) {
                return 2;
            }
            if (i2 == 2) {
                return 3;
            }
            return i2 == list.size() ? 4 : 0;
        }
        return invokeL.intValue;
    }

    public static /* synthetic */ void b(m mVar, c.a.r0.v3.c.a aVar) {
        c.a.q0.l.a.m(TbadkCoreApplication.getInst(), "https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&user_id=" + TbadkCoreApplication.getCurrentAccount() + "&icon_name=" + aVar.e());
        mVar.d();
    }

    public static void e(c.a.r0.v3.c.b bVar, String str, c.a.r0.v3.c.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar, str, cVar) == null) || bVar == null || bVar.f24304h == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (bVar.f24304h.a != null) {
            c.a.r0.v3.c.a aVar = new c.a.r0.v3.c.a();
            aVar.h(TbadkCoreApplication.getInst().getString(R.string.follow_thread_stamp_view_desc));
            aVar.j(bVar.f24304h.a.a);
            aVar.i(bVar.f24304h.a.f24306b);
            aVar.f(c.a.r0.v3.b.r().q(StampMission.Type.FOLLOW_FORUM));
            aVar.g(c.a.r0.v3.b.r().s(StampMission.Type.FOLLOW_FORUM));
            arrayList.add(aVar);
        }
        if (bVar.f24304h.f24307b != null) {
            c.a.r0.v3.c.a aVar2 = new c.a.r0.v3.c.a();
            aVar2.h(TbadkCoreApplication.getInst().getString(R.string.like_stamp_view_desc));
            aVar2.j(bVar.f24304h.f24307b.a);
            aVar2.i(bVar.f24304h.f24307b.f24306b);
            aVar2.f(c.a.r0.v3.b.r().q(StampMission.Type.LIKE_THREAD));
            aVar2.g(c.a.r0.v3.b.r().s(StampMission.Type.LIKE_THREAD));
            arrayList.add(aVar2);
        }
        if (bVar.f24304h.f24308c != null) {
            c.a.r0.v3.c.a aVar3 = new c.a.r0.v3.c.a();
            aVar3.h(TbadkCoreApplication.getInst().getString(R.string.reply_stamp_view_desc));
            aVar3.j(bVar.f24304h.f24308c.a);
            aVar3.i(bVar.f24304h.f24308c.f24306b);
            aVar3.f(c.a.r0.v3.b.r().q(StampMission.Type.REPLAY_THREAD));
            aVar3.g(c.a.r0.v3.b.r().s(StampMission.Type.REPLAY_THREAD));
            arrayList.add(aVar3);
        }
        f(arrayList, (bVar.f24298b * 1000) - System.currentTimeMillis(), str, cVar);
    }

    public static void f(List<c.a.r0.v3.c.a> list, long j2, String str, c.a.r0.v3.c.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{list, Long.valueOf(j2), str, cVar}) == null) || list.isEmpty() || j2 < 0 || TbadkCoreApplication.getInst().getCurrentActivity() == null) {
            return;
        }
        if (!UbsABTestHelper.isStampMissionDialogABTestA() || TbadkCoreApplication.getInst().getCurrentActivity().toString().contains("MainTabActivity")) {
            TBAlertConfig.b a = TBAlertConfig.a(new TBAlertConfig.a((int) R.string.forum_broadcast_major_history_known, TBAlertConfig.OperateBtnStyle.FORCE));
            final m mVar = new m(TbadkCoreApplication.getInst().getCurrentActivity());
            final StampMissionContentView stampMissionContentView = new StampMissionContentView(TbadkCoreApplication.getInst().getCurrentActivity());
            stampMissionContentView.setData(list, j2, new SingleStampView.a() { // from class: c.a.r0.v3.f.c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.stampmission.view.SingleStampView.a
                public final void a(c.a.r0.v3.c.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        e.b(m.this, aVar);
                    }
                }
            });
            mVar.v(R.string.stamp_mission);
            mVar.l(R.string.stamp_mission_desc);
            mVar.j(stampMissionContentView);
            mVar.i(false);
            mVar.t(true);
            mVar.g();
            mVar.q(new DialogInterface.OnDismissListener() { // from class: c.a.r0.v3.f.d
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        StampMissionContentView.this.cancel();
                    }
                }
            });
            mVar.h(new View.OnClickListener() { // from class: c.a.r0.v3.f.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        StampMissionContentView.this.cancel();
                    }
                }
            });
            mVar.s(a);
            mVar.y();
            c.a.q0.r.j0.b.k().x(str, System.currentTimeMillis());
            if (cVar != null) {
                cVar.f24310c = a(list);
                c.a.r0.v3.d.a.a(cVar);
            }
        }
    }
}
