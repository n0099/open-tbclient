package b.a.r0.m1.a.b.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.c1.i0;
import b.a.q0.c1.l0;
import b.a.q0.c1.q;
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
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.q0.t.e.a f22064a;

    /* renamed from: b  reason: collision with root package name */
    public DataRes f22065b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22066c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22067d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22068e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f22069f;

    /* renamed from: g  reason: collision with root package name */
    public final BlackListModel f22070g;

    /* renamed from: h  reason: collision with root package name */
    public PersonalTalkSettingActivity f22071h;

    /* renamed from: i  reason: collision with root package name */
    public e f22072i;
    public b.a.e.c.g.c j;
    public CustomMessageListener k;

    /* loaded from: classes5.dex */
    public class a extends i0<PersonalSettingItemData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f22073a;

        public a(f fVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22073a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.i0
        /* renamed from: a */
        public PersonalSettingItemData doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b.a.r0.l1.t.e.j().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f22073a)) : (PersonalSettingItemData) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements q<PersonalSettingItemData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f22074a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalTalkSettingActivity f22075b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f22076c;

        public b(f fVar, long j, PersonalTalkSettingActivity personalTalkSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Long.valueOf(j), personalTalkSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22076c = fVar;
            this.f22074a = j;
            this.f22075b = personalTalkSettingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.q
        /* renamed from: a */
        public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, personalSettingItemData) == null) {
                if (personalSettingItemData != null) {
                    this.f22076c.f22068e = personalSettingItemData.isAcceptNotify();
                }
                RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
                requestQueryUserInfoMessage.setReqUserId(this.f22074a);
                this.f22075b.sendMessage(requestQueryUserInfoMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends b.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f22077a;

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
            this.f22077a = fVar;
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
                    this.f22077a.f22071h.closeLoadingDialog();
                    if (socketResponsedMessage.getError() != 0) {
                        this.f22077a.f22071h.showToast(socketResponsedMessage.getErrorString());
                    }
                }
                if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                    ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                    if (responseUpdateMaskInfoMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) {
                        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) responseUpdateMaskInfoMessage.getOrginalMessage();
                        if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                            this.f22077a.f22067d = requestUpdateMaskInfoMessage.getIsMask() == 1;
                            if (this.f22077a.f22072i != null) {
                                this.f22077a.f22072i.updateUI();
                            }
                        }
                    }
                }
            } else if (cmd != 205003) {
            } else {
                if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() != 0) {
                    this.f22077a.f22071h.hideProgressBar();
                    this.f22077a.f22071h.showToast(socketResponsedMessage.getErrorString());
                } else if (socketResponsedMessage instanceof ResponseQueryUserInfoMessage) {
                    ResponseQueryUserInfoMessage responseQueryUserInfoMessage = (ResponseQueryUserInfoMessage) socketResponsedMessage;
                    if (responseQueryUserInfoMessage.getResData() != null) {
                        this.f22077a.f22065b = responseQueryUserInfoMessage.getResData();
                        f fVar = this.f22077a;
                        fVar.f22066c = fVar.f22065b.hasConcerned.intValue() == 1;
                        f fVar2 = this.f22077a;
                        fVar2.f22067d = fVar2.f22065b.isBlacklist.intValue() == 1;
                        this.f22077a.f22071h.hideProgressBar();
                        if (this.f22077a.f22072i != null) {
                            this.f22077a.f22072i.updateUI();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f22078a;

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
            this.f22078a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (!updateAttentionMessage.isSucc()) {
                    if (this.f22078a.f22071h == null || TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                        return;
                    }
                    this.f22078a.f22071h.showToast(updateAttentionMessage.getErrorString());
                    return;
                }
                this.f22078a.f22066c = updateAttentionMessage.isAttention();
                if (this.f22078a.f22071h != null) {
                    if (this.f22078a.f22066c) {
                        this.f22078a.f22071h.showToast(R.string.add_success);
                    } else {
                        this.f22078a.f22071h.showToast(R.string.remove_succ);
                    }
                }
                if (this.f22078a.f22072i != null) {
                    this.f22078a.f22072i.updateUI();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void updateUI();
    }

    public f(PersonalTalkSettingActivity personalTalkSettingActivity, e eVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalTalkSettingActivity, eVar, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22066c = false;
        this.f22067d = false;
        this.f22068e = false;
        this.f22069f = BdUniqueId.gen();
        this.j = new c(this, 0);
        this.k = new d(this, 0);
        this.f22071h = personalTalkSettingActivity;
        this.f22072i = eVar;
        this.f22064a = new b.a.q0.t.e.a(personalTalkSettingActivity.getPageContext());
        this.f22070g = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        l0.c(new a(this, j), new b(this, j, personalTalkSettingActivity));
    }

    public CustomMessageListener i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (CustomMessageListener) invokeV.objValue;
    }

    public DataRes j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22065b : (DataRes) invokeV.objValue;
    }

    public b.a.e.c.g.c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : (b.a.e.c.g.c) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22067d : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22068e : invokeV.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.a.q0.t.e.a aVar = this.f22064a;
            if (aVar != null) {
                aVar.g();
            }
            BlackListModel blackListModel = this.f22070g;
            if (blackListModel != null) {
                blackListModel.cancelLoadData();
            }
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f22068e = z;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
            requestUpdateMaskInfoMessage.setMaskType(9);
            requestUpdateMaskInfoMessage.setList(String.valueOf(this.f22065b.id));
            requestUpdateMaskInfoMessage.setSettingMask(z);
            requestUpdateMaskInfoMessage.setTag(this.f22069f);
            MessageManager.getInstance().removeMessage(104102, this.f22069f);
            MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f22071h.showLoadingDialog(null);
            if (z) {
                this.f22070g.addToBlackList(this.f22065b.id.longValue());
            } else {
                this.f22070g.removeFromBlackList(this.f22065b.id.longValue());
            }
        }
    }
}
