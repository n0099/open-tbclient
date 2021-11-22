package b.a.r0.x0.d3.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.VoiceRoom.VoiceRoom;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<b.a.r0.x0.d3.e.a> a(List<VoiceRoom> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (VoiceRoom voiceRoom : list) {
                if (voiceRoom != null) {
                    ArrayList arrayList2 = new ArrayList();
                    b.a.r0.x0.d3.e.a aVar = new b.a.r0.x0.d3.e.a();
                    aVar.f27266a = voiceRoom.room_name;
                    aVar.f27268c = String.valueOf(voiceRoom.talker_num);
                    aVar.f27269d = String.valueOf(voiceRoom.joined_num);
                    aVar.f27270e = voiceRoom.room_id.longValue();
                    for (User user : voiceRoom.talker) {
                        if (user != null) {
                            arrayList2.add(user.portrait);
                        }
                    }
                    aVar.f27267b = arrayList2;
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
