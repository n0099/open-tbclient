package b.a.r0.x0.d3.e;

import b.a.q0.h.b.b.a;
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
/* loaded from: classes5.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final VoiceRoomListNetModel f27274a;

    /* loaded from: classes5.dex */
    public static final class a implements NetModel.k<b, c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.h.b.a.a f27275e;

        public a(b.a.q0.h.b.a.a aVar) {
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
            this.f27275e = aVar;
        }

        @Override // com.baidu.tbadk.mvc.model.NetModel.m
        public void k(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.hasError()) {
                return;
            }
            if (mvcSocketResponsedMessage.getError() == 0) {
                c response = mvcSocketResponsedMessage.getData();
                b.a.q0.h.b.a.a aVar = this.f27275e;
                Intrinsics.checkExpressionValueIsNotNull(response, "response");
                aVar.a(new a.c(response.a()));
                return;
            }
            b.a.q0.h.b.a.a aVar2 = this.f27275e;
            String errorString = mvcSocketResponsedMessage.getErrorString();
            Intrinsics.checkExpressionValueIsNotNull(errorString, "responsedMessage.errorString");
            aVar2.a(new a.C0697a(errorString, null, 2, null));
        }

        @Override // com.baidu.tbadk.mvc.model.NetModel.l
        public void p(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
                return;
            }
            if (mvcHttpResponsedMessage.getError() == 0) {
                c response = mvcHttpResponsedMessage.getData();
                b.a.q0.h.b.a.a aVar = this.f27275e;
                Intrinsics.checkExpressionValueIsNotNull(response, "response");
                aVar.a(new a.c(response.a()));
                return;
            }
            b.a.q0.h.b.a.a aVar2 = this.f27275e;
            String errorString = mvcHttpResponsedMessage.getErrorString();
            Intrinsics.checkExpressionValueIsNotNull(errorString, "responsedMessage.errorString");
            aVar2.a(new a.C0697a(errorString, null, 2, null));
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
        this.f27274a = new VoiceRoomListNetModel();
    }

    public final void a(TbPageContext<?> tbPageContext, long j, long j2, b.a.q0.h.b.a.a<List<VoiceRoomWrapper>> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbPageContext, Long.valueOf(j), Long.valueOf(j2), aVar}) == null) {
            b bVar = new b(j, j2);
            this.f27274a.setUniqueId(tbPageContext.getUniqueId());
            this.f27274a.Z(bVar);
            this.f27274a.Y(new a(aVar));
            this.f27274a.loadData();
            aVar.a(new a.b(null, 1, null));
        }
    }
}
