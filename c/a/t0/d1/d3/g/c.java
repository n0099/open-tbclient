package c.a.t0.d1.d3.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.s0.l0.b.h;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.frs.voiceroom.data.VoiceRoomWrapper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.VoiceRoom;
import tbclient.VoiceRoomListPage.VoiceRoomListPageResIdl;
/* loaded from: classes7.dex */
public class c implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadInfo> f16370e;

    public c() {
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
        this.f16370e = new ArrayList();
    }

    @NonNull
    public List<VoiceRoomWrapper> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (ThreadInfo threadInfo : this.f16370e) {
                VoiceRoom voiceRoom = threadInfo.voice_room;
                if (voiceRoom != null && b(voiceRoom)) {
                    String str = threadInfo.fname;
                    if (str == null) {
                        str = "";
                    }
                    arrayList.add(new VoiceRoomWrapper(voiceRoom, str));
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean b(@NonNull VoiceRoom voiceRoom) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceRoom)) == null) {
            Long l = voiceRoom.room_id;
            return (l == null || l.longValue() == 0 || TextUtils.isEmpty(voiceRoom.room_name)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.s0.l0.b.h
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("voice_room_list");
                if (optJSONArray != null) {
                    this.f16370e = DataExt.c(optJSONArray.toString(), ThreadInfo.class);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // c.a.s0.l0.b.h
    public void initByProtobuf(Message message) {
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, message) == null) && (message instanceof VoiceRoomListPageResIdl) && (list = ((VoiceRoomListPageResIdl) message).data.voice_room_list) != null) {
            this.f16370e = list;
        }
    }
}
