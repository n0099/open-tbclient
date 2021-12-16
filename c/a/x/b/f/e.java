package c.a.x.b.f;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.DecimalFormat;
/* loaded from: classes9.dex */
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
            long j2 = i2;
            if (j2 < 10000) {
                return i2 + context.getString(c.a.x.c.a.e.live_feed_page_person_unit);
            }
            if (j2 < 100000000) {
                string = context.getString(c.a.x.c.a.e.live_feed_page_million_unit);
                valueOf = Float.valueOf(i2 / 10000.0f);
            } else {
                string = context.getString(c.a.x.c.a.e.live_feed_page_billion_unit);
                valueOf = Float.valueOf(i2 / 1.0E8f);
            }
            DecimalFormat decimalFormat = new DecimalFormat("####.#");
            return decimalFormat.format(valueOf) + string;
        }
        return (String) invokeLI.objValue;
    }
}
