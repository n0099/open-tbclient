package c.a.s0.r3.c;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import c.a.s0.r3.b.b;
import c.a.s0.y3.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncher.MainTabScheduleStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    public a() {
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

    @NonNull
    public static a e(@NonNull b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            a aVar = new a();
            aVar.a = bVar;
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a(MainTabScheduleStrategy.FLUSHING);
            this.a.getActivity();
            if (this.a.h() == 1) {
                if (this.a.i()) {
                    c();
                } else {
                    b();
                }
            }
            if (this.a.h() == 2) {
                d();
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_VIEW_END_STAMP_KEY);
                MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921636, ""));
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getActivity().getClass().getSimpleName()).param("obj_param1", 3).param(TiebaStatic.Params.OBJ_PARAM2, -1));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921639, 2));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.getActivity().finish();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View findViewById = this.a.getActivity().findViewById(R.id.splash_ad_container);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            Fragment findFragmentById = this.a.getActivity().getSupportFragmentManager().findFragmentById(R.id.splash_ad_container);
            if (findFragmentById != null) {
                this.a.getActivity().getSupportFragmentManager().beginTransaction().remove(findFragmentById).commitAllowingStateLoss();
            }
            this.a.getActivity().getWindow().clearFlags(1024);
        }
    }
}
