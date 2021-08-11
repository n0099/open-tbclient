package c.a.p0.j1.f;

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
/* loaded from: classes3.dex */
public class d extends c.a.e.a.c<MsglistActivity<?>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TextView f20290b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f20291c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f20292d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f20293e;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f20294e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f20295f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f20296g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f20297h;

        public a(d dVar, long j2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Long.valueOf(j2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20297h = dVar;
            this.f20294e = j2;
            this.f20295f = str;
            this.f20296g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.f20297h.mContext.getPageActivity(), String.valueOf(this.f20294e), this.f20295f, this.f20296g, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgmid_view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.e.a.f) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20290b = null;
        f();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TextView textView = (TextView) c(R.id.tex_msgcontent);
            this.f20290b = textView;
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            this.f20291c = (LinearLayout) c(R.id.lay_add_friend);
            this.f20292d = (TextView) c(R.id.btn_add_friend);
            this.f20293e = (TextView) c(R.id.text_add_friend);
            this.f20291c.setVisibility(8);
        }
    }

    public final boolean g(ChatMessage chatMessage) {
        InterceptResult invokeL;
        UserData toUserInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatMessage)) == null) {
            if (chatMessage != null && (chatMessage instanceof PersonalChatMessage) && chatMessage.getMsgType() == 11 && !TextUtils.isEmpty(chatMessage.getContent())) {
                try {
                    JSONObject jSONObject = new JSONObject(chatMessage.getContent());
                    String optString = jSONObject.optString(TbEnum.SystemMessage.KEY_EVENT_ID);
                    if (optString != null && optString.equals(TbEnum.SystemMessage.EVENT_ID_ADD_FRIEND)) {
                        this.f20291c.setVisibility(0);
                        this.f20290b.setVisibility(8);
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
                        this.f20293e.setText(optString2);
                        if (optInt == 1) {
                            this.f20292d.setVisibility(0);
                            this.f20292d.setText(optString3);
                            this.f20292d.setOnClickListener(new a(this, optLong, userName, portrait));
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

    public void h(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) == null) {
            this.f20291c.setVisibility(8);
            if (chatMessage == null) {
                this.f20290b.setText("");
            } else if (g(chatMessage)) {
            } else {
                this.f20290b.setVisibility(0);
                String v = c.a.p0.j1.w.c.v(chatMessage);
                if (!TextUtils.isEmpty(v)) {
                    this.f20290b.setText(v);
                } else {
                    this.f20290b.setText("");
                }
            }
        }
    }
}
