package c.a.u0.u1.a.c;

import android.content.Intent;
import android.os.Bundle;
import c.a.d.a.f;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.imMessageCenter.RequestCommitInviteMessage;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import protobuf.CommitInviteMsg.DataReq;
/* loaded from: classes9.dex */
public class e extends BdBaseModel<InviteFriendListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RequestCommitInviteMessage f22918e;

    /* renamed from: f  reason: collision with root package name */
    public long f22919f;

    /* renamed from: g  reason: collision with root package name */
    public long f22920g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inviteFriendListActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void initWithBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) || bundle == null) {
            return;
        }
        this.f22919f = bundle.getLong("gid", -1L);
        this.f22920g = bundle.getLong("groupid", -1L);
    }

    public void initWithIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) || intent == null) {
            return;
        }
        this.f22919f = intent.getLongExtra("gid", -1L);
        this.f22920g = intent.getLongExtra("groupid", -1L);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final RequestCommitInviteMessage w(long j2, long j3, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str})) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.groupId = Long.valueOf(j2);
            builder.msgType = 5;
            builder.toUids = str;
            builder.content = "{\"type\":" + String.valueOf(1) + ",\"groupId\":" + String.valueOf(j3) + "}";
            RequestCommitInviteMessage requestCommitInviteMessage = new RequestCommitInviteMessage();
            requestCommitInviteMessage.setReqData(builder.build(false));
            return requestCommitInviteMessage;
        }
        return (RequestCommitInviteMessage) invokeCommon.objValue;
    }

    public void x(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            bundle.putLong("gid", this.f22919f);
            bundle.putLong("groupid", this.f22920g);
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            RequestCommitInviteMessage w = w(this.f22919f, this.f22920g, str);
            this.f22918e = w;
            super.sendMessage(w);
        }
    }
}
