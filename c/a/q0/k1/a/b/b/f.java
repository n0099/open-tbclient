package c.a.q0.k1.a.b.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.b1.h0;
import c.a.p0.b1.k0;
import c.a.p0.b1.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.imMessageCenter.RequestQueryUserInfoMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.p0.t.e.a f21217a;

    /* renamed from: b  reason: collision with root package name */
    public DataRes f21218b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f21219c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f21220d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f21221e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f21222f;

    /* renamed from: g  reason: collision with root package name */
    public final BlackListModel f21223g;

    /* renamed from: h  reason: collision with root package name */
    public PersonalTalkSettingActivity f21224h;

    /* renamed from: i  reason: collision with root package name */
    public e f21225i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.e.c.g.c f21226j;
    public CustomMessageListener k;

    /* loaded from: classes3.dex */
    public class a extends h0<PersonalSettingItemData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f21227a;

        public a(f fVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21227a = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.h0
        /* renamed from: a */
        public PersonalSettingItemData doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.q0.j1.t.e.j().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f21227a)) : (PersonalSettingItemData) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements n<PersonalSettingItemData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f21228a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalTalkSettingActivity f21229b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f21230c;

        public b(f fVar, long j2, PersonalTalkSettingActivity personalTalkSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Long.valueOf(j2), personalTalkSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21230c = fVar;
            this.f21228a = j2;
            this.f21229b = personalTalkSettingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, personalSettingItemData) == null) {
                if (personalSettingItemData != null) {
                    this.f21230c.f21221e = personalSettingItemData.isAcceptNotify();
                }
                RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
                requestQueryUserInfoMessage.setReqUserId(this.f21228a);
                this.f21229b.sendMessage(requestQueryUserInfoMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends c.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f21231a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21231a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) || socketResponsedMessage == null) {
                return;
            }
            int cmd = socketResponsedMessage.getCmd();
            if (cmd == 104102) {
                if (socketResponsedMessage instanceof ResponsedMessage) {
                    this.f21231a.f21224h.closeLoadingDialog();
                    if (socketResponsedMessage.getError() != 0) {
                        this.f21231a.f21224h.showToast(socketResponsedMessage.getErrorString());
                    }
                }
                if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                    ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                    if (responseUpdateMaskInfoMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) {
                        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) responseUpdateMaskInfoMessage.getOrginalMessage();
                        if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                            this.f21231a.f21220d = requestUpdateMaskInfoMessage.getIsMask() == 1;
                            if (this.f21231a.f21225i != null) {
                                this.f21231a.f21225i.updateUI();
                            }
                        }
                    }
                }
            } else if (cmd != 205003) {
            } else {
                if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() != 0) {
                    this.f21231a.f21224h.hideProgressBar();
                    this.f21231a.f21224h.showToast(socketResponsedMessage.getErrorString());
                } else if (socketResponsedMessage instanceof ResponseQueryUserInfoMessage) {
                    ResponseQueryUserInfoMessage responseQueryUserInfoMessage = (ResponseQueryUserInfoMessage) socketResponsedMessage;
                    if (responseQueryUserInfoMessage.getResData() != null) {
                        this.f21231a.f21218b = responseQueryUserInfoMessage.getResData();
                        f fVar = this.f21231a;
                        fVar.f21219c = fVar.f21218b.hasConcerned.intValue() == 1;
                        f fVar2 = this.f21231a;
                        fVar2.f21220d = fVar2.f21218b.isBlacklist.intValue() == 1;
                        this.f21231a.f21224h.hideProgressBar();
                        if (this.f21231a.f21225i != null) {
                            this.f21231a.f21225i.updateUI();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f21232a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21232a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (!updateAttentionMessage.isSucc()) {
                    if (this.f21232a.f21224h == null || TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                        return;
                    }
                    this.f21232a.f21224h.showToast(updateAttentionMessage.getErrorString());
                    return;
                }
                this.f21232a.f21219c = updateAttentionMessage.isAttention();
                if (this.f21232a.f21224h != null) {
                    if (this.f21232a.f21219c) {
                        this.f21232a.f21224h.showToast(R.string.add_success);
                    } else {
                        this.f21232a.f21224h.showToast(R.string.remove_succ);
                    }
                }
                if (this.f21232a.f21225i != null) {
                    this.f21232a.f21225i.updateUI();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void updateUI();
    }

    public f(PersonalTalkSettingActivity personalTalkSettingActivity, e eVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalTalkSettingActivity, eVar, Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21219c = false;
        this.f21220d = false;
        this.f21221e = false;
        this.f21222f = BdUniqueId.gen();
        this.f21226j = new c(this, 0);
        this.k = new d(this, 0);
        this.f21224h = personalTalkSettingActivity;
        this.f21225i = eVar;
        this.f21217a = new c.a.p0.t.e.a(personalTalkSettingActivity.getPageContext());
        this.f21223g = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        k0.c(new a(this, j2), new b(this, j2, personalTalkSettingActivity));
    }

    public CustomMessageListener i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (CustomMessageListener) invokeV.objValue;
    }

    public DataRes j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21218b : (DataRes) invokeV.objValue;
    }

    public c.a.e.c.g.c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21226j : (c.a.e.c.g.c) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21220d : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f21221e : invokeV.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.p0.t.e.a aVar = this.f21217a;
            if (aVar != null) {
                aVar.g();
            }
            BlackListModel blackListModel = this.f21223g;
            if (blackListModel != null) {
                blackListModel.cancelLoadData();
            }
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f21221e = z;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
            requestUpdateMaskInfoMessage.setMaskType(9);
            requestUpdateMaskInfoMessage.setList(String.valueOf(this.f21218b.id));
            requestUpdateMaskInfoMessage.setSettingMask(z);
            requestUpdateMaskInfoMessage.setTag(this.f21222f);
            MessageManager.getInstance().removeMessage(104102, this.f21222f);
            MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f21224h.showLoadingDialog(null);
            if (z) {
                this.f21223g.addToBlackList(this.f21218b.id.longValue());
            } else {
                this.f21223g.removeFromBlackList(this.f21218b.id.longValue());
            }
        }
    }
}
