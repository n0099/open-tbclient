package c.a.q0.d1;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import c.a.q0.s.c.l0;
import c.a.r0.y3.t0.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    public static PostWriteCallBackData a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public static l0 f12253b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public static WriteData f12254c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public static AntiData f12255d;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            int indexOf = str.indexOf("(");
            int indexOf2 = str.indexOf(SmallTailInfo.EMOTION_SUFFIX);
            if (indexOf == -1 || indexOf2 == -1 || (i2 = indexOf + 1) >= indexOf2) {
                return null;
            }
            return str.substring(i2, indexOf2);
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            return str.equals("4") || str.equals("5");
        }
        return invokeL.booleanValue;
    }

    public static boolean c(int i2, int i3, @Nullable Intent intent) {
        InterceptResult invokeIIL;
        PostWriteCallBackData postWriteCallBackData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65538, null, i2, i3, intent)) == null) {
            if (i2 != 12006) {
                return false;
            }
            boolean z = i3 == -1 && intent != null;
            if (a != null && f12253b != null && f12254c != null && f12255d != null && z) {
                try {
                    postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                } catch (Exception e2) {
                    BdLog.e(e2);
                    postWriteCallBackData = null;
                }
                if (postWriteCallBackData == null) {
                    return false;
                }
                b.k().h(true, postWriteCallBackData, f12253b, f12254c, f12255d);
            } else {
                b.k().h(false, a, null, f12254c, f12255d);
            }
            a = null;
            f12253b = null;
            f12254c = null;
            f12255d = null;
            return true;
        }
        return invokeIIL.booleanValue;
    }

    public static boolean d(@Nullable PostWriteCallBackData postWriteCallBackData, @Nullable l0 l0Var, @Nullable WriteData writeData, @Nullable AntiData antiData) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, postWriteCallBackData, l0Var, writeData, antiData)) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            boolean z = (currentActivity == null || writeData == null || l0Var == null || TextUtils.isEmpty(l0Var.c())) ? false : true;
            if (z) {
                a = postWriteCallBackData;
                f12253b = l0Var;
                f12254c = writeData;
                f12255d = antiData;
                writeData.setVcodeMD5(l0Var.b());
                writeData.setVcodeUrl(l0Var.c());
                writeData.setVcodeExtra(l0Var.a());
                if (b(l0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(currentActivity, 12006, writeData, false, l0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(currentActivity, writeData, 12006)));
                }
            }
            return z;
        }
        return invokeLLLL.booleanValue;
    }
}
