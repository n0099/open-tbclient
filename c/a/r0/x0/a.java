package c.a.r0.x0;

import c.a.q0.b0.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f24472b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1800429766, "Lc/a/r0/x0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1800429766, "Lc/a/r0/x0/a;");
                return;
            }
        }
        a = Pattern.compile("#\\([a-zA-Z0-9_~！\\-\\u4E00-\\u9FA5]+\\)");
        f24472b = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    }

    public static int a(CharSequence charSequence) {
        InterceptResult invokeL;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, charSequence)) == null) {
            int i2 = 0;
            if (charSequence != null && charSequence.length() != 0) {
                Matcher matcher = a.matcher(charSequence);
                while (matcher.find()) {
                    String group = matcher.group();
                    if (MessageManager.getInstance().findTask(2004608) != null && (runTask = MessageManager.getInstance().runTask(2004608, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                        i2++;
                    }
                }
                Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(charSequence);
                while (matcher2.find()) {
                    String[] split = matcher2.group().split(",");
                    if (split != null && split.length == 5) {
                        i2++;
                    }
                }
                Matcher matcher3 = Pattern.compile("#\\(meme,net_[a-zA-Z0-9_\\-\\.\\%,]+\\)").matcher(charSequence);
                while (matcher3.find()) {
                    String[] split2 = matcher3.group().split(",");
                    if (split2 != null && split2.length == 6) {
                        i2++;
                    }
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static int b(CharSequence charSequence) {
        InterceptResult invokeL;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, charSequence)) == null) {
            int i2 = 0;
            if (charSequence != null && charSequence.length() != 0) {
                Matcher matcher = a.matcher(charSequence);
                while (matcher.find()) {
                    String group = matcher.group();
                    if (MessageManager.getInstance().findTask(2004608) != null && (runTask = MessageManager.getInstance().runTask(2004608, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                        i2++;
                    }
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            String replaceAll = str.replaceAll(d.f12091f, EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX_SHORT);
            Matcher matcher = Pattern.compile("#\\(meme,net_[a-zA-Z0-9_\\-\\.\\%,]+\\)").matcher(replaceAll);
            StringBuilder sb = new StringBuilder(replaceAll);
            int i2 = 0;
            while (matcher.find()) {
                String[] split = matcher.group().split(",");
                if (split != null && split.length == 6) {
                    StringBuilder sb2 = new StringBuilder();
                    int start = matcher.start() - i2;
                    int end = matcher.end() - i2;
                    for (int i3 = 0; i3 < split.length; i3++) {
                        if (i3 != 1) {
                            sb2.append(split[i3]);
                            if (i3 < split.length - 1) {
                                sb2.append(",");
                            }
                        }
                    }
                    i2 += (end - start) - sb2.toString().length();
                    if (start >= 0 && end <= sb.length()) {
                        sb.replace(start, end, sb2.toString());
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
