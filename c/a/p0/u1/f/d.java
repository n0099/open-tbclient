package c.a.p0.u1.f;

import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends c.a.d.a.c<MsglistActivity<?>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TextView f18669b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f18670c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f18671d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f18672e;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18673b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18674c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f18675d;

        public a(d dVar, long j, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Long.valueOf(j), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18675d = dVar;
            this.a = j;
            this.f18673b = str;
            this.f18674c = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.f18675d.mContext.getPageActivity(), String.valueOf(this.a), this.f18673b, this.f18674c, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d0562);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.d.a.f) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18669b = null;
        h();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TextView textView = (TextView) c(R.id.obfuscated_res_0x7f091f15);
            this.f18669b = textView;
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            this.f18670c = (LinearLayout) c(R.id.obfuscated_res_0x7f0911ad);
            this.f18671d = (TextView) c(R.id.obfuscated_res_0x7f090406);
            this.f18672e = (TextView) c(R.id.obfuscated_res_0x7f091f23);
            this.f18670c.setVisibility(8);
        }
    }

    public final boolean i(ChatMessage chatMessage) {
        InterceptResult invokeL;
        UserData toUserInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatMessage)) == null) {
            if (chatMessage != null && (chatMessage instanceof PersonalChatMessage) && chatMessage.getMsgType() == 11 && !TextUtils.isEmpty(chatMessage.getContent())) {
                try {
                    JSONObject jSONObject = new JSONObject(chatMessage.getContent());
                    String optString = jSONObject.optString(TbEnum.SystemMessage.KEY_EVENT_ID);
                    if (optString != null && optString.equals(TbEnum.SystemMessage.EVENT_ID_ADD_FRIEND)) {
                        this.f18670c.setVisibility(0);
                        this.f18669b.setVisibility(8);
                        String optString2 = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_MSG);
                        JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                        if (optJSONObject == null) {
                            return false;
                        }
                        int optInt = optJSONObject.optInt("button_type");
                        String optString3 = optJSONObject.optString("name");
                        long optLong = optJSONObject.optLong("userId");
                        if (chatMessage.getUserId() == optLong) {
                            toUserInfo = chatMessage.getUserInfo();
                        } else {
                            toUserInfo = chatMessage.getToUserInfo();
                        }
                        String userName = toUserInfo.getUserName();
                        String portrait = toUserInfo.getPortrait();
                        this.f18672e.setText(optString2);
                        if (optInt == 1) {
                            this.f18671d.setVisibility(0);
                            this.f18671d.setText(optString3);
                            this.f18671d.setOnClickListener(new a(this, optLong, userName, portrait));
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void j(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) == null) {
            this.f18670c.setVisibility(8);
            if (chatMessage == null) {
                this.f18669b.setText("");
            } else if (i(chatMessage)) {
            } else {
                this.f18669b.setVisibility(0);
                String v = c.a.p0.u1.w.c.v(chatMessage);
                if (!TextUtils.isEmpty(v)) {
                    this.f18669b.setText(v);
                } else {
                    this.f18669b.setText("");
                }
            }
        }
    }
}
