package c.a.s0.d1;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.module.frs.Frs$From;
import com.baidu.tieba.frs.voiceroom.VoiceRoomListActivity;
import com.baidu.tieba.frs.voiceroom.VoiceRoomStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class y extends c.a.j0.b.b.a<c.a.r0.j0.c.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a implements c.a.r0.j0.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // c.a.r0.j0.c.a
        public void a(TbPageContext<?> tbPageContext, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, tbPageContext, j2) == null) {
                Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
                d(tbPageContext, Intrinsics.stringPlus("bdtiebalive://video/mixlive?room_id=", Long.valueOf(j2)));
            }
        }

        @Override // c.a.r0.j0.c.a
        public void b(Context context, Frs$From from, Long l, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, from, l, str) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(from, "from");
                VoiceRoomListActivity.Companion.a(context, from, l, str);
            }
        }

        @Override // c.a.r0.j0.c.a
        public void c(Long l, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, l, str) == null) {
                VoiceRoomStat.d(l, str);
            }
        }

        public void d(TbPageContext<?> tbPageContext, String scheme) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, tbPageContext, scheme) == null) {
                Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
                Intrinsics.checkNotNullParameter(scheme, "scheme");
                UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{scheme});
            }
        }
    }

    public y() {
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
    @Override // c.a.j0.b.b.a
    /* renamed from: a */
    public c.a.r0.j0.c.a createService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a() : (c.a.r0.j0.c.a) invokeV.objValue;
    }
}
