package c.a.t0.s1.y;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public T f22925b;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public T a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22925b : (T) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : invokeV.intValue;
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [com.baidu.tbadk.data.ShareFromFrsMsgData, T] */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.baidu.tbadk.data.ShareFromGameCenterMsgData, T, com.baidu.tbadk.data.ShareFromPBMsgData] */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, com.baidu.tbadk.data.ShareFromPBMsgData] */
    public int c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (str == null) {
                return -1;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() == 3) {
                    jSONArray.optString(0);
                    this.a = jSONArray.optInt(1);
                    JSONObject optJSONObject = jSONArray.optJSONObject(2);
                    if (1 == this.a) {
                        String optString = optJSONObject.optString("button");
                        String optString2 = optJSONObject.optString("shareSourceIcon");
                        String optString3 = optJSONObject.optString("shareSource");
                        String optString4 = optJSONObject.optString("shareUrl");
                        String optString5 = optJSONObject.optString("shareSourceUrl");
                        if (TextUtils.isEmpty(optString4)) {
                            ?? r4 = (T) new ShareFromPBMsgData();
                            r4.setContent(optJSONObject.optString("themeContent"));
                            r4.setForumName(optJSONObject.optString("forumName"));
                            r4.setImageUrl(optJSONObject.optString("themeImageUrl"));
                            r4.setPostId(optJSONObject.optString("postID"));
                            r4.setThreadId(optJSONObject.optString("themeID"));
                            r4.setTitle(optJSONObject.optString("themeTitle"));
                            r4.setTheNewThemeId(optJSONObject.optString("theNewThemeID"));
                            r4.setThreadType(optJSONObject.optInt("threadType"));
                            this.f22925b = r4;
                            return 0;
                        }
                        ?? r1 = (T) new ShareFromGameCenterMsgData();
                        r1.setContent(optJSONObject.optString("themeContent"));
                        r1.setForumName(optJSONObject.optString("forumName"));
                        r1.setImageUrl(optJSONObject.optString("themeImageUrl"));
                        r1.setPostId(optJSONObject.optString("postID"));
                        r1.setThreadId(optJSONObject.optString("themeID"));
                        r1.setTitle(optJSONObject.optString("themeTitle"));
                        r1.setButton(optString);
                        r1.setShareSource(optString3);
                        r1.setShareSourceIcon(optString2);
                        r1.setShareSourceUrl(optString5);
                        r1.setShareUrl(optString4);
                        this.f22925b = r1;
                        return 1;
                    } else if (4 == this.a) {
                        ?? r12 = (T) new ShareFromFrsMsgData();
                        r12.setName(optJSONObject.optString("forumName"));
                        r12.setImageUrl(optJSONObject.optString("themeImageUrl"));
                        r12.setMemberNum(optJSONObject.optInt("memberNum"));
                        r12.setPostNum(optJSONObject.optInt("postNum"));
                        this.f22925b = r12;
                        return 2;
                    } else {
                        return -1;
                    }
                }
                return -1;
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeLL.intValue;
    }
}
