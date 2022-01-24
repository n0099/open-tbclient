package c.a.t0.d2.h;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(TextView textView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, textView, str, str2) == null) || textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = str2.trim().toLowerCase();
        textView.setText(str);
        int indexOf = lowerCase.indexOf(lowerCase2);
        if (indexOf >= 0) {
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, lowerCase2.length() + indexOf, 33);
            if (indexOf > 0) {
                spannableStringBuilder.setSpan(new StyleSpan(1), 0, indexOf, 33);
            }
            spannableStringBuilder.setSpan(new StyleSpan(1), indexOf + lowerCase2.length(), lowerCase.length(), 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
