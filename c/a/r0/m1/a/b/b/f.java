package c.a.r0.m1.a.b.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.d1.i0;
import c.a.q0.d1.l0;
import c.a.q0.d1.q;
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
    public c.a.q0.t.e.a f21991a;

    /* renamed from: b  reason: collision with root package name */
    public DataRes f21992b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f21993c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f21994d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f21995e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f21996f;

    /* renamed from: g  reason: collision with root package name */
    public final BlackListModel f21997g;

    /* renamed from: h  reason: collision with root package name */
    public PersonalTalkSettingActivity f21998h;

    /* renamed from: i  reason: collision with root package name */
    public e f21999i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.e.c.g.c f22000j;
    public CustomMessageListener k;

    /* loaded from: classes3.dex */
    public class a extends i0<PersonalSettingItemData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f22001a;

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
            this.f22001a = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.i0
        /* renamed from: a */
        public PersonalSettingItemData doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.r0.l1.t.e.j().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f22001a)) : (PersonalSettingItemData) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements q<PersonalSettingItemData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f22002a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalTalkSettingActivity f22003b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f22004c;

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
            this.f22004c = fVar;
            this.f22002a = j2;
            this.f22003b = personalTalkSettingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, personalSettingItemData) == null) {
                if (personalSettingItemData != null) {
                    this.f22004c.f21995e = personalSettingItemData.isAcceptNotify();
                }
                RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
                requestQueryUserInfoMessage.setReqUserId(this.f22002a);
                this.f22003b.sendMessage(requestQueryUserInfoMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends c.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f22005a;

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
            this.f22005a = fVar;
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
                    this.f22005a.f21998h.closeLoadingDialog();
                    if (socketResponsedMessage.getError() != 0) {
                        this.f22005a.f21998h.showToast(socketResponsedMessage.getErrorString());
                    }
                }
                if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                    ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                    if (responseUpdateMaskInfoMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) {
                        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) responseUpdateMaskInfoMessage.getOrginalMessage();
                        if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                            this.f22005a.f21994d = requestUpdateMaskInfoMessage.getIsMask() == 1;
                            if (this.f22005a.f21999i != null) {
                                this.f22005a.f21999i.updateUI();
                            }
                        }
                    }
                }
            } else if (cmd != 205003) {
            } else {
                if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() != 0) {
                    this.f22005a.f21998h.hideProgressBar();
                    this.f22005a.f21998h.showToast(socketResponsedMessage.getErrorString());
                } else if (socketResponsedMessage instanceof ResponseQueryUserInfoMessage) {
                    ResponseQueryUserInfoMessage responseQueryUserInfoMessage = (ResponseQueryUserInfoMessage) socketResponsedMessage;
                    if (responseQueryUserInfoMessage.getResData() != null) {
                        this.f22005a.f21992b = responseQueryUserInfoMessage.getResData();
                        f fVar = this.f22005a;
                        fVar.f21993c = fVar.f21992b.hasConcerned.intValue() == 1;
                        f fVar2 = this.f22005a;
                        fVar2.f21994d = fVar2.f21992b.isBlacklist.intValue() == 1;
                        this.f22005a.f21998h.hideProgressBar();
                        if (this.f22005a.f21999i != null) {
                            this.f22005a.f21999i.updateUI();
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
        public final /* synthetic */ f f22006a;

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
            this.f22006a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (!updateAttentionMessage.isSucc()) {
                    if (this.f22006a.f21998h == null || TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                        return;
                    }
                    this.f22006a.f21998h.showToast(updateAttentionMessage.getErrorString());
                    return;
                }
                this.f22006a.f21993c = updateAttentionMessage.isAttention();
                if (this.f22006a.f21998h != null) {
                    if (this.f22006a.f21993c) {
                        this.f22006a.f21998h.showToast(R.string.add_success);
                    } else {
                        this.f22006a.f21998h.showToast(R.string.remove_succ);
                    }
                }
                if (this.f22006a.f21999i != null) {
                    this.f22006a.f21999i.updateUI();
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
        this.f21993c = false;
        this.f21994d = false;
        this.f21995e = false;
        this.f21996f = BdUniqueId.gen();
        this.f22000j = new c(this, 0);
        this.k = new d(this, 0);
        this.f21998h = personalTalkSettingActivity;
        this.f21999i = eVar;
        this.f21991a = new c.a.q0.t.e.a(personalTalkSettingActivity.getPageContext());
        this.f21997g = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        l0.c(new a(this, j2), new b(this, j2, personalTalkSettingActivity));
    }

    public CustomMessageListener i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (CustomMessageListener) invokeV.objValue;
    }

    public DataRes j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21992b : (DataRes) invokeV.objValue;
    }

    public c.a.e.c.g.c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22000j : (c.a.e.c.g.c) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21994d : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f21995e : invokeV.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.q0.t.e.a aVar = this.f21991a;
            if (aVar != null) {
                aVar.g();
            }
            BlackListModel blackListModel = this.f21997g;
            if (blackListModel != null) {
                blackListModel.cancelLoadData();
            }
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f21995e = z;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
            requestUpdateMaskInfoMessage.setMaskType(9);
            requestUpdateMaskInfoMessage.setList(String.valueOf(this.f21992b.id));
            requestUpdateMaskInfoMessage.setSettingMask(z);
            requestUpdateMaskInfoMessage.setTag(this.f21996f);
            MessageManager.getInstance().removeMessage(104102, this.f21996f);
            MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f21998h.showLoadingDialog(null);
            if (z) {
                this.f21997g.addToBlackList(this.f21992b.id.longValue());
            } else {
                this.f21997g.removeFromBlackList(this.f21992b.id.longValue());
            }
        }
    }
}
