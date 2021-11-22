package b.a.r0.x0.d3;

import androidx.recyclerview.widget.DiffUtil;
import com.baidu.tieba.frs.voiceroom.data.VoiceRoomWrapper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class b extends DiffUtil.ItemCallback<VoiceRoomWrapper> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: a */
    public boolean areContentsTheSame(VoiceRoomWrapper voiceRoomWrapper, VoiceRoomWrapper voiceRoomWrapper2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, voiceRoomWrapper, voiceRoomWrapper2)) == null) ? Intrinsics.areEqual(voiceRoomWrapper.getVoiceRoom().status, voiceRoomWrapper2.getVoiceRoom().status) && Intrinsics.areEqual(voiceRoomWrapper.getVoiceRoom().joined_num, voiceRoomWrapper2.getVoiceRoom().joined_num) : invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: b */
    public boolean areItemsTheSame(VoiceRoomWrapper voiceRoomWrapper, VoiceRoomWrapper voiceRoomWrapper2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, voiceRoomWrapper, voiceRoomWrapper2)) == null) ? Intrinsics.areEqual(voiceRoomWrapper.getVoiceRoom().room_id, voiceRoomWrapper2.getVoiceRoom().room_id) : invokeLL.booleanValue;
    }
}
