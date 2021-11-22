package b.a.r0.b1.b;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import b.a.e.f.p.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static SpannableString a(long j, int i2, int i3) {
        InterceptResult invokeCommon;
        String formatOverBaiwanNum;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (i2 == 1) {
                if (CurrencySwitchUtil.isYyIsConvert(i3)) {
                    formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(i3, j);
                } else {
                    formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(j);
                }
                drawable = CurrencySwitchUtil.getMoneyIcon(i3);
            } else {
                Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_gift_bluedrill);
                formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(j);
                drawable = drawable2;
            }
            String str = "[icon]" + formatOverBaiwanNum;
            SpannableString spannableString = new SpannableString(str);
            if (TbadkApplication.getInst().getSkinType() == 1) {
                drawable.setAlpha(179);
            } else {
                drawable.setAlpha(255);
            }
            int g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds24);
            if (i2 == 1) {
                drawable.setBounds(0, 0, g2, g2);
            } else {
                drawable.setBounds(0, 0, g2, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20));
            }
            b.a.q0.e1.d dVar = new b.a.q0.e1.d(drawable);
            dVar.b(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
            dVar.c(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
            UtilHelper.setSpan(spannableString, str, "[icon]", dVar);
            UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0108)));
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static SpannableString b(long j, boolean z, int i2) {
        InterceptResult invokeCommon;
        String formatOverBaiwanNum;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            if (CurrencySwitchUtil.isYyIsConvert(i2)) {
                formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(i2, j);
            } else {
                formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(j);
            }
            if (z) {
                str = "=[icon]" + formatOverBaiwanNum;
            } else {
                str = "[icon]" + formatOverBaiwanNum;
            }
            SpannableString spannableString = new SpannableString(str);
            Drawable moneyIcon = CurrencySwitchUtil.getMoneyIcon(i2);
            int g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds24);
            moneyIcon.setBounds(0, 0, g2, g2);
            b.a.q0.e1.d dVar = new b.a.q0.e1.d(moneyIcon);
            dVar.b(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
            dVar.c(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
            UtilHelper.setSpan(spannableString, str, "[icon]", dVar);
            UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
            if (z) {
                UtilHelper.setSpan(spannableString, str, "=", new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0108)));
            }
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static SpannableString c(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            if (StringUtils.isNull(str)) {
                return new SpannableString("");
            }
            SpannableString spannableString = new SpannableString(str);
            UtilHelper.setSpan(spannableString, str, str, new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)));
            UtilHelper.setSpan(spannableString, str, str2, new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
            if (!StringUtils.isNull(str3)) {
                UtilHelper.setSpan(spannableString, str, str3, new StrikethroughSpan());
            }
            return spannableString;
        }
        return (SpannableString) invokeLLL.objValue;
    }
}
