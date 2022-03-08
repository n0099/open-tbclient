package c.a.r0.s1.u;

import android.content.Context;
import android.text.TextUtils;
import c.a.r0.s1.g.d;
import c.a.r0.s1.w.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.AddMsgRecordModel;
import com.baidu.tieba.stampmission.message.StampMissionHttpRequestMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f22008c;
    public transient /* synthetic */ FieldHolder $fh;
    public HashSet<String> a;

    /* renamed from: b  reason: collision with root package name */
    public StringBuilder f22009b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-772149766, "Lc/a/r0/s1/u/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-772149766, "Lc/a/r0/s1/u/a;");
                return;
            }
        }
        f22008c = new a();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashSet<>();
        this.f22009b = new StringBuilder();
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f22008c : (a) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || str == null || str.length() <= 0) {
            return;
        }
        StringBuilder sb = this.f22009b;
        sb.append(str);
        sb.append(",");
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            StringBuilder sb = this.f22009b;
            if (sb != null && sb.length() > 0) {
                StringBuilder sb2 = this.f22009b;
                sb2.delete(0, sb2.length());
            }
            HashSet<String> hashSet = this.a;
            if (hashSet != null) {
                hashSet.clear();
            }
        }
    }

    public void d(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d k;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, chatMessage, context) == null) || chatMessage == null || StringUtils.isNull(chatMessage.getContent()) || (userInfo = chatMessage.getUserInfo()) == null) {
            return;
        }
        if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (k = c.k(chatMessage.getContent())) != null && !TextUtils.isEmpty(k.f21791b) && this.a.add(k.f21791b)) {
            TiebaStatic.eventStat(context, "message_open", "click", 1, StampMissionHttpRequestMessage.KEY_TASK_TYPE, k.a, "task_id", k.f21791b);
        }
    }

    public void e(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, chatMessage, context) == null) || chatMessage == null || StringUtils.isNull(chatMessage.getContent()) || (userInfo = chatMessage.getUserInfo()) == null || userInfo.getUserType() != 4) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13989");
        statisticItem.param("service_id", chatMessage.getStatisticsServiceId());
        statisticItem.param("task_id", chatMessage.getStatTaskId());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        TiebaStatic.log(statisticItem);
    }

    public void f() {
        String str;
        StringBuilder sb;
        StringBuilder sb2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String str2 = null;
            if (this.a != null) {
                StringBuilder sb3 = new StringBuilder();
                Iterator<String> it = this.a.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null && next.length() > 0) {
                        sb3.append(next);
                        sb3.append(",");
                    }
                }
                if (sb3.length() > 0) {
                    sb3.deleteCharAt(sb3.length() - 1);
                    if (sb3.length() > 0) {
                        str = sb3.toString();
                        sb = this.f22009b;
                        if (sb != null && sb.length() > 0) {
                            this.f22009b.deleteCharAt(sb2.length() - 1);
                            str2 = this.f22009b.toString();
                        }
                        new AddMsgRecordModel().reqViewAndClick(str, str2);
                    }
                }
            }
            str = null;
            sb = this.f22009b;
            if (sb != null) {
                this.f22009b.deleteCharAt(sb2.length() - 1);
                str2 = this.f22009b.toString();
            }
            new AddMsgRecordModel().reqViewAndClick(str, str2);
        }
    }
}
