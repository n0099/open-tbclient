package b.a.w.b.f;

import android.content.Context;
import com.baidu.searchbox.ui.CoolPraiseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.DecimalFormat;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context, int i2) {
        InterceptResult invokeLI;
        String string;
        Float valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, context, i2)) == null) {
            if (i2 < 0) {
                return "";
            }
            long j = i2;
            if (j < 10000) {
                return i2 + context.getString(b.a.w.c.a.e.live_feed_page_person_unit);
            }
            if (j < CoolPraiseView.BILLION) {
                string = context.getString(b.a.w.c.a.e.live_feed_page_million_unit);
                valueOf = Float.valueOf(i2 / 10000.0f);
            } else {
                string = context.getString(b.a.w.c.a.e.live_feed_page_billion_unit);
                valueOf = Float.valueOf(i2 / 1.0E8f);
            }
            DecimalFormat decimalFormat = new DecimalFormat("####.#");
            return decimalFormat.format(valueOf) + string;
        }
        return (String) invokeLI.objValue;
    }
}
