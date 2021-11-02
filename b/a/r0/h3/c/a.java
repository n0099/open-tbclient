package b.a.r0.h3.c;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import b.a.r0.h3.b.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f17745a;

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
    public static a e(@NonNull c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cVar)) == null) {
            a aVar = new a();
            aVar.f17745a = cVar;
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17745a.getActivity();
            if (this.f17745a.h() == 1) {
                if (this.f17745a.isFromHotSplash()) {
                    c();
                } else {
                    b();
                }
            }
            if (this.f17745a.h() == 2) {
                d();
                SpeedStatsManager.getInstance().addStatsTimeStamp(6001);
                MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921636, ""));
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.f17745a.getActivity().getClass().getSimpleName()).param("obj_param1", 3).param(TiebaStatic.Params.OBJ_PARAM2, -1));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921639, 2));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f17745a.getActivity().finish();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View findViewById = this.f17745a.getActivity().findViewById(R.id.splash_ad_container);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            Fragment findFragmentById = this.f17745a.getActivity().getSupportFragmentManager().findFragmentById(R.id.splash_ad_container);
            if (findFragmentById != null) {
                this.f17745a.getActivity().getSupportFragmentManager().beginTransaction().remove(findFragmentById).commitAllowingStateLoss();
            }
            this.f17745a.getActivity().getWindow().clearFlags(1024);
        }
    }
}
