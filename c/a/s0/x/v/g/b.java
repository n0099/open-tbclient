package c.a.s0.x.v.g;

import c.a.s0.e1.k0;
import c.a.s0.e1.n0;
import c.a.s0.e1.s;
import c.a.t0.s1.h.m;
import c.a.t0.w3.a0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.s0.x.v.f.a a;

    /* loaded from: classes6.dex */
    public class a extends k0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.s0.x.v.f.a a;

        public a(b bVar, c.a.s0.x.v.f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.s0.e1.k0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Long.valueOf(m.t().i(this.a.a().f14132e)) : invokeV.objValue;
        }
    }

    public b(c.a.s0.x.v.f.a aVar) {
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
        this.a = aVar;
    }

    public final ChatMessage a(String str, long j2) {
        InterceptResult invokeLJ;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, str, j2)) == null) {
            ChatMessage b2 = b();
            if (b2 == null) {
                return null;
            }
            b2.setCustomGroupType(2);
            b2.setMsgType(1);
            b2.setContent(str);
            long b3 = c.a.t0.s1.w.b.b(j2);
            b2.setMsgId(b3);
            b2.setRecordId(b3);
            b2.setTime(System.currentTimeMillis() / 1000);
            UserData userData = new UserData();
            userData.setUserName(TbadkCoreApplication.getCurrentAccountName());
            userData.setUserId(TbadkCoreApplication.getCurrentAccount());
            userData.setName_show(TbadkCoreApplication.getCurrentAccountNameShow());
            userData.setPortrait(TbadkCoreApplication.getCurrentPortrait());
            b2.setUserInfo(userData);
            try {
                j3 = c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            } catch (Exception unused) {
                j3 = 0;
            }
            b2.setUserId(j3);
            MsgLocalData msgLocalData = new MsgLocalData();
            msgLocalData.setStatus((short) 1);
            msgLocalData.setErrno(0L);
            msgLocalData.setRetry(0L);
            msgLocalData.setUpload_offset(null);
            b2.setLocalData(msgLocalData);
            return b2;
        }
        return (ChatMessage) invokeLJ.objValue;
    }

    public ChatMessage b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.s0.x.v.f.a aVar = this.a;
            if (aVar == null || aVar.a() == null) {
                return null;
            }
            PersonalChatMessage personalChatMessage = new PersonalChatMessage();
            personalChatMessage.setBornTime(System.currentTimeMillis());
            personalChatMessage.setToUserId(Long.parseLong(this.a.a().f14132e));
            UserData userData = new UserData();
            userData.setUserId(this.a.a().f14132e);
            userData.setPortrait(this.a.a().f14134g);
            userData.setName_show(this.a.a().f14133f);
            personalChatMessage.setToUserInfo(userData);
            personalChatMessage.setIsFriend(this.a.a().n ? 1 : 0);
            return personalChatMessage;
        }
        return (ChatMessage) invokeV.objValue;
    }

    public /* synthetic */ void c(String str, Object obj) {
        if (obj instanceof Long) {
            c.a.t0.s1.s.a.j().t(a(str, ((Long) obj).longValue()));
            e("");
        }
    }

    public void d(a0.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) || gVar == null) {
            return;
        }
        c.a.s0.x.v.f.a aVar = this.a;
        if (aVar != null && aVar.a() != null) {
            a0.m(this.a.a().f14132e, gVar);
        } else {
            gVar.a(null);
        }
    }

    public void e(String str) {
        c.a.s0.x.v.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (aVar = this.a) == null || aVar.a() == null) {
            return;
        }
        a0.w(this.a.a().f14132e, str);
    }

    public void f(c.a.s0.x.v.f.a aVar, final String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, aVar, str) == null) {
            this.a = aVar;
            n0.c(new a(this, aVar), new s() { // from class: c.a.s0.x.v.g.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // c.a.s0.e1.s
                public final void onReturnDataInUI(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        b.this.c(str, obj);
                    }
                }
            });
        }
    }
}
