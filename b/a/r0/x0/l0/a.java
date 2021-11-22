package b.a.r0.x0.l0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.HorseRace.LiveHorseRaceData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetHorseRaceLampList.DataRes;
import tbclient.GetHorseRaceLampList.LiveList;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<LiveHorseRaceData> f27478a;

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
                return;
            }
        }
        this.f27478a = new ArrayList();
    }

    public List<LiveHorseRaceData> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27478a : (List) invokeV.objValue;
    }

    public void b(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        new LiveHorseRaceData();
        List<LiveList> list = dataRes.live_list;
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                LiveHorseRaceData liveHorseRaceData = new LiveHorseRaceData();
                liveHorseRaceData.parserProtobuf(list.get(i2));
                this.f27478a.add(liveHorseRaceData);
            }
        }
    }
}
