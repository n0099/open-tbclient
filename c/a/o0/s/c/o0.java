package c.a.o0.s.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumInfo;
import tbclient.ThreadInfo;
import tbclient.VoiceRoom;
/* loaded from: classes2.dex */
public class o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Long a;

    /* renamed from: b  reason: collision with root package name */
    public String f11239b;

    /* renamed from: c  reason: collision with root package name */
    public List<VoiceRoom> f11240c;

    public o0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11240c = new ArrayList();
    }

    public List<VoiceRoom> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11240c : (List) invokeV.objValue;
    }

    public Long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (Long) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f11239b : (String) invokeV.objValue;
    }

    public void d(DataRes dataRes) {
        VoiceRoom voiceRoom;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dataRes) == null) || dataRes == null) {
            return;
        }
        ForumInfo forumInfo = dataRes.forum;
        if (forumInfo != null) {
            this.a = forumInfo.id;
            this.f11239b = forumInfo.name;
        }
        if (ListUtils.isEmpty(dataRes.voice_room_list)) {
            return;
        }
        for (ThreadInfo threadInfo : dataRes.voice_room_list) {
            if (threadInfo != null && (voiceRoom = threadInfo.voice_room) != null && !StringUtils.isNull(voiceRoom.room_name) && voiceRoom.room_id.longValue() > 0) {
                this.f11240c.add(voiceRoom);
            }
        }
    }
}
