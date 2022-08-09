package com.baidu.tbadk.core.util;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class MessageJumpHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MessageJumpHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void jumpGameGodsPage(Context context, String str, String str2, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, context, str, str2, strArr) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("game_id", str);
            hashMap.put("god_id", str2);
            hashMap.put("open_pay", strArr);
            hashMap.put("transparent", Boolean.TRUE);
            hashMap.put("swipeback", Boolean.FALSE);
            hashMap.put("isFromNative", "1");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(context, "GameGodsDetailPage", hashMap)));
        }
    }

    public static void jumpGameOrderFinishPage(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, str, str2) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", str);
            hashMap.put("example_image_url", str2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(context, "GameOrderFinish", hashMap)));
        }
    }
}
