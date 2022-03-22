package c.a.p0.l4;

import android.text.TextUtils;
import c.a.d.a.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(f fVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, fVar, str)) == null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < jSONArray.length(); i++) {
                    sb.append(jSONArray.optJSONObject(i).optString("src"));
                }
                return sb.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
                return fVar.getString(R.string.obfuscated_res_0x7f0f0e3d);
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String b(f fVar, ChatMessage chatMessage) {
        InterceptResult invokeLL;
        String content;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, fVar, chatMessage)) == null) {
            int msgType = chatMessage.getMsgType();
            if (msgType == 1) {
                content = chatMessage.getContent();
            } else if (msgType != 2) {
                content = msgType != 3 ? "" : fVar.getString(R.string.obfuscated_res_0x7f0f152c);
            } else {
                content = a(fVar, chatMessage.getContent());
            }
            if (chatMessage != null && chatMessage.getToUserInfo() != null) {
                if (TextUtils.equals(chatMessage.getToUserInfo().getUserId(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                    string = fVar.getString(R.string.obfuscated_res_0x7f0f0ecf);
                } else {
                    string = fVar.getString(R.string.obfuscated_res_0x7f0f0ecc);
                }
                return string + chatMessage.getToUserInfo().getUserName() + fVar.getString(R.string.obfuscated_res_0x7f0f0ecd) + content;
            }
            return fVar.getString(R.string.obfuscated_res_0x7f0f0ecc);
        }
        return (String) invokeLL.objValue;
    }
}
