package c.a.t0.e1.e3.g;

import c.a.s0.h.b.b.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.voiceroom.data.VoiceRoomListNetModel;
import com.baidu.tieba.frs.voiceroom.data.VoiceRoomWrapper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final VoiceRoomListNetModel a;

    /* loaded from: classes7.dex */
    public static final class a implements NetModel.k<b, c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.h.b.a.a<List<VoiceRoomWrapper>> f16416e;

        public a(c.a.s0.h.b.a.a<List<VoiceRoomWrapper>> aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16416e = aVar;
        }

        @Override // com.baidu.tbadk.mvc.model.NetModel.m
        public void k(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.hasError()) {
                return;
            }
            if (mvcSocketResponsedMessage.getError() == 0) {
                this.f16416e.a(new a.c(mvcSocketResponsedMessage.getData().a()));
                return;
            }
            c.a.s0.h.b.a.a<List<VoiceRoomWrapper>> aVar = this.f16416e;
            String errorString = mvcSocketResponsedMessage.getErrorString();
            Intrinsics.checkNotNullExpressionValue(errorString, "responsedMessage.errorString");
            aVar.a(new a.C0859a(errorString, null, 2, null));
        }

        @Override // com.baidu.tbadk.mvc.model.NetModel.l
        public void p(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
                return;
            }
            if (mvcHttpResponsedMessage.getError() == 0) {
                this.f16416e.a(new a.c(mvcHttpResponsedMessage.getData().a()));
                return;
            }
            c.a.s0.h.b.a.a<List<VoiceRoomWrapper>> aVar = this.f16416e;
            String errorString = mvcHttpResponsedMessage.getErrorString();
            Intrinsics.checkNotNullExpressionValue(errorString, "responsedMessage.errorString");
            aVar.a(new a.C0859a(errorString, null, 2, null));
        }
    }

    public d() {
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
        this.a = new VoiceRoomListNetModel();
    }

    public final void a(TbPageContext<?> tbPageContext, long j2, long j3, c.a.s0.h.b.a.a<List<VoiceRoomWrapper>> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbPageContext, Long.valueOf(j2), Long.valueOf(j3), callback}) == null) {
            Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
            Intrinsics.checkNotNullParameter(callback, "callback");
            b bVar = new b(j2, j3);
            this.a.setUniqueId(tbPageContext.getUniqueId());
            this.a.Z(bVar);
            this.a.Y(new a(callback));
            this.a.loadData();
            callback.a(new a.b(null, 1, null));
        }
    }
}
