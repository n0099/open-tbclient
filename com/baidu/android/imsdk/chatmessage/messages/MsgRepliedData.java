package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MsgRepliedData implements Parcelable, NoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<MsgRepliedData> CREATOR;
    public static final String JSON_KEY_REPLY_DATA = "reply_data";
    public static final String JSON_KEY_REPLY_IS_REPLY = "is_reply_msg";
    public static final String TAG = "MsgRepliedData";
    public transient /* synthetic */ FieldHolder $fh;
    public String displayBody;
    public boolean isReplyMsg;
    public boolean parseSucceed;
    public String replyExt;
    public int replyMsgAutoRiskControlStatus;
    public String replyMsgContent;
    public long replyMsgId;
    public String replyMsgSenderBdUk;
    public String replyMsgSenderNickname;
    public long replyMsgSenderPauid;
    public int replyMsgStatus;
    public String replyMsgStatusDisplayText;
    public long replyMsgToGroup;
    public int replyMsgType;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1310708989, "Lcom/baidu/android/imsdk/chatmessage/messages/MsgRepliedData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1310708989, "Lcom/baidu/android/imsdk/chatmessage/messages/MsgRepliedData;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<MsgRepliedData>() { // from class: com.baidu.android.imsdk.chatmessage.messages.MsgRepliedData.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MsgRepliedData createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new MsgRepliedData(parcel);
                }
                return (MsgRepliedData) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MsgRepliedData[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new MsgRepliedData[i];
                }
                return (MsgRepliedData[]) invokeI.objValue;
            }
        };
    }

    public String getDisplayBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.displayBody;
        }
        return (String) invokeV.objValue;
    }

    public String getReplyExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.replyExt;
        }
        return (String) invokeV.objValue;
    }

    public int getReplyMsgAutoRiskControlStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.replyMsgAutoRiskControlStatus;
        }
        return invokeV.intValue;
    }

    public String getReplyMsgContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.replyMsgContent;
        }
        return (String) invokeV.objValue;
    }

    public long getReplyMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.replyMsgId;
        }
        return invokeV.longValue;
    }

    public String getReplyMsgSenderBdUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.replyMsgSenderBdUk;
        }
        return (String) invokeV.objValue;
    }

    public String getReplyMsgSenderNickname() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.replyMsgSenderNickname;
        }
        return (String) invokeV.objValue;
    }

    public long getReplyMsgSenderPauid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.replyMsgSenderPauid;
        }
        return invokeV.longValue;
    }

    public int getReplyMsgStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.replyMsgStatus;
        }
        return invokeV.intValue;
    }

    public String getReplyMsgStatusDisplayText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.replyMsgStatusDisplayText;
        }
        return (String) invokeV.objValue;
    }

    public long getReplyMsgToGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.replyMsgToGroup;
        }
        return invokeV.longValue;
    }

    public int getReplyMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.replyMsgType;
        }
        return invokeV.intValue;
    }

    public boolean isReplyMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.isReplyMsg;
        }
        return invokeV.booleanValue;
    }

    public boolean parseCorrect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.parseSucceed;
        }
        return invokeV.booleanValue;
    }

    public MsgRepliedData(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.replyMsgType = i;
        this.replyMsgId = j;
    }

    public MsgRepliedData(Parcel parcel) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.replyMsgType = parcel.readInt();
        this.replyMsgContent = parcel.readString();
        this.displayBody = parcel.readString();
        this.replyMsgAutoRiskControlStatus = parcel.readInt();
        this.replyMsgStatus = parcel.readInt();
        this.replyMsgStatusDisplayText = parcel.readString();
        this.replyMsgId = parcel.readLong();
        this.replyMsgSenderBdUk = parcel.readString();
        this.replyMsgSenderPauid = parcel.readLong();
        this.replyMsgToGroup = parcel.readLong();
        this.replyMsgSenderNickname = parcel.readString();
        this.replyExt = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isReplyMsg = z;
        this.parseSucceed = parcel.readInt() == 1;
    }

    public void appendMsgRepliedDataToMsgJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            if (jSONObject == null) {
                LogUtils.d(TAG, "appendMsgRepliedDataToMsgJson stopped, to append jsonObj is null");
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("re_msg_type", this.replyMsgType);
                jSONObject2.put("re_msg", this.replyMsgContent);
                jSONObject2.put("display_body", this.displayBody);
                jSONObject2.put("re_auto_risk_control_status", this.replyMsgAutoRiskControlStatus);
                jSONObject2.put("re_msg_status", this.replyMsgStatus);
                jSONObject2.put("re_msg_status_display_text", this.replyMsgStatusDisplayText);
                jSONObject2.put("re_msgid", this.replyMsgId);
                jSONObject2.put("re_baidu_uk", this.replyMsgSenderBdUk);
                jSONObject2.put("re_pa_uid", this.replyMsgSenderPauid);
                jSONObject2.put("re_nickname", this.replyMsgSenderNickname);
                jSONObject2.put("re_ext", this.replyExt);
                jSONObject.put(JSON_KEY_REPLY_DATA, jSONObject2.toString());
                jSONObject.put(JSON_KEY_REPLY_IS_REPLY, 1);
            } catch (JSONException e) {
                LogUtils.e(TAG, "appendMsgRepliedDataToMsgJson failed：", e);
            }
        }
    }

    public MsgRepliedData(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        parseReplyData(jSONObject);
    }

    public void setDisplayBody(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.displayBody = str;
        }
    }

    public void setReplyMsgToGroup(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
            this.replyMsgToGroup = j;
        }
    }

    public static String appendMsgRepliedDataToMsgJson(String str, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        long fromUser;
        NetDiskFileMsg netDiskFileMsg;
        NetDiskFileMsg.NetDiskFile[] files;
        String name;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, chatMsg)) == null) {
            if (chatMsg == null) {
                return str;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.put(JSON_KEY_REPLY_IS_REPLY, 1);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("re_msg_type", chatMsg.getMsgType());
                JSONObject jSONObject3 = new JSONObject();
                int msgType = chatMsg.getMsgType();
                if (msgType != 0) {
                    if (msgType != 1) {
                        if (msgType != 2) {
                            if (msgType != 8) {
                                if (msgType != 18) {
                                    if (msgType != 55) {
                                        if (msgType != 39) {
                                            if (msgType == 40 && (chatMsg instanceof FansGroupAtMsg)) {
                                                jSONObject3.put("text", ((FansGroupAtMsg) chatMsg).getText());
                                            }
                                        } else if (chatMsg instanceof FansGroupInviteMsg) {
                                            FansGroupInviteMsg fansGroupInviteMsg = (FansGroupInviteMsg) chatMsg;
                                            if (TextUtils.isEmpty(fansGroupInviteMsg.getTitle())) {
                                                jSONObject3.put("text", "邀请你加入群聊");
                                            } else {
                                                jSONObject3.put("text", fansGroupInviteMsg.getTitle());
                                            }
                                            jSONObject3.put("inviteGroupId", fansGroupInviteMsg.getGroupId());
                                            jSONObject3.put("invitor", fansGroupInviteMsg.getInvitor());
                                        }
                                    } else if ((chatMsg instanceof NetDiskFileMsg) && (files = (netDiskFileMsg = (NetDiskFileMsg) chatMsg).getFiles()) != null && files.length > 0) {
                                        NetDiskFileMsg.NetDiskFile netDiskFile = files[0];
                                        if (netDiskFileMsg.getFilesCount() > 1) {
                                            name = String.format(netDiskFile.getName() + "等%d个文件", Integer.valueOf(netDiskFileMsg.getFilesCount()));
                                        } else {
                                            name = netDiskFile.getName();
                                        }
                                        jSONObject3.put("text", name);
                                        jSONObject3.put("url", netDiskFileMsg.getSchema());
                                        if (netDiskFileMsg.getTplType() == 1) {
                                            jSONObject3.put("image", netDiskFile.getCoverUrl());
                                        }
                                    }
                                } else if (chatMsg instanceof HtmlMsg) {
                                    jSONObject3.put("text", ((HtmlMsg) chatMsg).getText());
                                }
                            } else if (chatMsg instanceof SignleGraphicTextMsg) {
                                jSONObject3.put("image", ((SignleGraphicTextMsg) chatMsg).getCover());
                                jSONObject3.put("url", ((SignleGraphicTextMsg) chatMsg).getArticleUrl());
                                jSONObject3.put("text", ((SignleGraphicTextMsg) chatMsg).getTitle());
                            }
                        } else if (chatMsg instanceof AudioMsg) {
                            AudioMsg audioMsg = (AudioMsg) chatMsg;
                            jSONObject2.put("re_msg", audioMsg.toJsonString());
                            jSONObject3.put("text", String.format("%1$d''", Integer.valueOf(audioMsg.getDuration())));
                        }
                    } else if (chatMsg instanceof ImageMsg) {
                        jSONObject3.put("image", ((ImageMsg) chatMsg).getThumbUrl());
                        jSONObject3.put("url", ((ImageMsg) chatMsg).getRemoteUrl());
                    }
                } else if (chatMsg instanceof TextMsg) {
                    jSONObject3.put("text", ((TextMsg) chatMsg).getText());
                }
                jSONObject2.put("display_body", jSONObject3.toString());
                jSONObject2.put("re_auto_risk_control_status", chatMsg.getAutoRiskControlStatus());
                jSONObject2.put("re_msg_status", 0);
                if (chatMsg.getCategory() == 1) {
                    jSONObject2.put("re_msg_to_group", chatMsg.getContacter());
                    fromUser = Utility.getLongByString(chatMsg.getSenderUid(), 0L);
                } else {
                    fromUser = chatMsg.getFromUser();
                }
                if (fromUser > 0) {
                    jSONObject2.put("re_from_user", chatMsg.getFromUser());
                    if ((17592186044416L & fromUser) != 0) {
                        jSONObject2.put("re_pa_uid", fromUser);
                    } else if (!TextUtils.isEmpty(chatMsg.getSenderUid())) {
                        String transBDUID = Utility.transBDUID(chatMsg.getSenderUid());
                        if (!TextUtils.isEmpty(transBDUID)) {
                            jSONObject2.put("re_baidu_uk", transBDUID);
                        }
                    }
                }
                jSONObject2.put("re_msgid", chatMsg.getMsgId());
                jSONObject2.put("re_nickname", chatMsg.getRepliedName());
                jSONObject2.put("re_ext", "");
                jSONObject.put(JSON_KEY_REPLY_DATA, jSONObject2);
                return jSONObject.toString();
            } catch (JSONException e) {
                LogUtils.e(TAG, "construct reply data exception:", e);
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String getUpdatedMsgContent(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65541, null, str, i, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                LogUtils.d(TAG, "getUpdatedMsgContent msg content empty");
                return "";
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString(JSON_KEY_REPLY_DATA));
                jSONObject2.put("re_msg_status", i);
                jSONObject2.put("re_msg_status_display_text", str2);
                jSONObject.put(JSON_KEY_REPLY_DATA, jSONObject2.toString());
                return jSONObject.toString();
            } catch (JSONException e) {
                LogUtils.e(TAG, "getUpdatedMsgContent exception,", e);
                return "";
            }
        }
        return (String) invokeLIL.objValue;
    }

    private void parseReplyData(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, jSONObject) == null) {
            try {
                boolean z = false;
                if (jSONObject.optInt(JSON_KEY_REPLY_IS_REPLY, 0) == 1) {
                    z = true;
                }
                this.isReplyMsg = z;
                if (!z) {
                    this.parseSucceed = true;
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString(JSON_KEY_REPLY_DATA));
                this.replyMsgType = jSONObject2.optInt("re_msg_type");
                this.replyMsgContent = jSONObject2.optString("re_msg");
                this.displayBody = jSONObject2.optString("display_body");
                this.replyMsgAutoRiskControlStatus = jSONObject2.optInt("re_auto_risk_control_status");
                this.replyMsgStatus = jSONObject2.optInt("re_msg_status");
                this.replyMsgStatusDisplayText = jSONObject2.optString("re_msg_status_display_text");
                this.replyMsgId = jSONObject2.optLong("re_msgid");
                this.replyMsgSenderBdUk = jSONObject2.optString("re_baidu_uk");
                this.replyMsgSenderPauid = jSONObject2.optLong("re_pa_uid");
                this.replyMsgToGroup = jSONObject2.optLong("re_msg_to_group");
                this.replyMsgSenderNickname = jSONObject2.optString("re_nickname");
                this.replyExt = jSONObject2.optString("re_ext");
                this.parseSucceed = true;
            } catch (JSONException e) {
                LogUtils.e(TAG, "parse reply data failed:" + e.toString());
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return "MsgRepliedData{replyMsgType=" + this.replyMsgType + ", replyMsgContent='" + this.replyMsgContent + "', displayBody='" + this.displayBody + "', replyMsgAutoRiskControlStatus=" + this.replyMsgAutoRiskControlStatus + ", replyMsgStatus=" + this.replyMsgStatus + ", replyMsgStatusDisplayText='" + this.replyMsgStatusDisplayText + "', replyMsgId=" + this.replyMsgId + ", replyMsgSenderBdUk='" + this.replyMsgSenderBdUk + "', replyMsgSenderPauid=" + this.replyMsgSenderPauid + ", replyMsgSenderNickname='" + this.replyMsgSenderNickname + "', replyMsgToGroup='" + this.replyMsgToGroup + "', replyExt='" + this.replyExt + "'}";
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, parcel, i) == null) {
            parcel.writeInt(this.replyMsgType);
            parcel.writeString(this.replyMsgContent);
            parcel.writeString(this.displayBody);
            parcel.writeInt(this.replyMsgAutoRiskControlStatus);
            parcel.writeInt(this.replyMsgStatus);
            parcel.writeString(this.replyMsgStatusDisplayText);
            parcel.writeLong(this.replyMsgId);
            parcel.writeString(this.replyMsgSenderBdUk);
            parcel.writeLong(this.replyMsgSenderPauid);
            parcel.writeLong(this.replyMsgToGroup);
            parcel.writeString(this.replyMsgSenderNickname);
            parcel.writeString(this.replyExt);
            parcel.writeInt(this.isReplyMsg ? 1 : 0);
            parcel.writeInt(this.parseSucceed ? 1 : 0);
        }
    }
}
