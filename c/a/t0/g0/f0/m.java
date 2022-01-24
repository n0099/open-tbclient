package c.a.t0.g0.f0;

import c.a.s0.s.q.e2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.VoiceRoom;
/* loaded from: classes7.dex */
public class m extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String U0;
    public List<String> V0;
    public String W0;
    public String X0;
    public long Y0;

    public m(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (e2Var == null) {
            return;
        }
        this.f17600e = e2Var;
        String str = e2Var.E;
        e2Var.getTitle();
        VoiceRoom H1 = e2Var.H1();
        if (H1 != null) {
            this.U0 = H1.room_name;
            this.V0 = g0(H1);
            this.W0 = String.valueOf(H1.talker_num);
            this.X0 = String.valueOf(H1.joined_num);
            this.Y0 = H1.room_id.longValue();
        }
    }

    public static boolean Y(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, e2Var)) == null) ? (e2Var == null || e2Var.H1() == null || e2Var.H1().room_id.longValue() <= 0 || StringUtils.isNull(e2Var.H1().room_name)) ? false : true : invokeL.booleanValue;
    }

    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.X0 : (String) invokeV.objValue;
    }

    public List<String> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.V0 : (List) invokeV.objValue;
    }

    public long d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.Y0 : invokeV.longValue;
    }

    public String e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.U0 : (String) invokeV.objValue;
    }

    public String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.W0 : (String) invokeV.objValue;
    }

    public final List<String> g0(VoiceRoom voiceRoom) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, voiceRoom)) == null) {
            ArrayList arrayList = new ArrayList();
            for (User user : voiceRoom.talker) {
                if (user != null) {
                    arrayList.add(user.portrait);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // c.a.t0.g0.f0.k, com.baidu.tieba.card.data.BaseCardInfo, c.a.d.n.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.G) {
                return k.M0;
            }
            return e2.v3;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
