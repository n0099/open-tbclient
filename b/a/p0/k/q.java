package b.a.p0.k;

import android.util.SparseArray;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static SparseArray<o> f11027a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-613100522, "Lb/a/p0/k/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-613100522, "Lb/a/p0/k/q;");
                return;
            }
        }
        SparseArray<o> sparseArray = new SparseArray<>();
        f11027a = sparseArray;
        sparseArray.put(5, new o(5, k.aiapp_menu_text_night_mode, h.aiapp_menu_item_nightmode, true));
        f11027a.put(35, new o(35, k.aiapp_menu_add_launcher, h.aiapp_menu_item_ai_apps_add_to_launcher_selector, true));
        f11027a.put(39, new o(39, k.aiapp_menu_restart, h.aiapp_menu_item_restart_selector, true));
        f11027a.put(4, new o(4, k.aiapp_menu_text_share, h.aiapp_menu_item_share_arrow_selector, true));
        f11027a.put(37, new o(37, k.aiapp_menu_authority_management, h.aiapp_menu_item_ai_apps_authority_management_selector, true));
        f11027a.put(38, new o(38, k.aiapp_menu_text_favorite, h.aiapp_menu_item_add_fav_selector, true));
        f11027a.put(42, new o(42, k.aiapp_menu_game_restart, h.aiapp_menu_item_restart_selector, true));
        f11027a.put(49, new o(49, k.swan_app_menu_setting, h.swan_app_menu_item_setting_selector, true));
        f11027a.put(50, new o(50, k.swanapp_menu_font_setting, h.swan_app_menu_item_font_setting_selector, true));
        f11027a.put(43, new o(43, k.aiapp_menu_apply_guarantee, h.aiapp_menu_item_apply_guarantee_selector, true));
        f11027a.put(9, new o(9, k.aiapp_menu_text_feedback, h.aiapp_menu_item_feedback_selector, true));
        f11027a.put(46, new o(46, k.aiapp_menu_global_notice, h.aiapp_menu_item_global_notice_selector, true));
        f11027a.put(47, new o(47, k.aiapp_menu_global_private, h.aiapp_menu_item_global_private_selector, true));
    }

    public static o a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? o.k(f11027a.get(i2)) : (o) invokeI.objValue;
    }

    public static List<o> b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i2 != 0) {
                if (i2 != 12) {
                    if (i2 != 13) {
                        switch (i2) {
                            case 16:
                                arrayList.add(o.k(f11027a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(o.k(f11027a.get(38)));
                                arrayList.add(o.k(f11027a.get(4)));
                                arrayList.add(o.k(f11027a.get(39)));
                                arrayList.add(o.k(f11027a.get(35)));
                                arrayList.add(o.k(f11027a.get(5)));
                                arrayList.add(o.k(f11027a.get(49)));
                                break;
                            case 19:
                                arrayList.add(o.l(f11027a.get(38), false));
                                arrayList.add(o.l(f11027a.get(4), false));
                                arrayList.add(o.k(f11027a.get(39)));
                                arrayList.add(o.l(f11027a.get(35), false));
                                arrayList.add(o.k(f11027a.get(5)));
                                arrayList.add(o.l(f11027a.get(49), false));
                                break;
                        }
                    } else {
                        arrayList.add(o.k(f11027a.get(43)));
                    }
                }
                arrayList.add(o.k(f11027a.get(38)));
                arrayList.add(o.k(f11027a.get(4)));
                arrayList.add(o.k(f11027a.get(39)));
                arrayList.add(o.k(f11027a.get(35)));
                arrayList.add(o.k(f11027a.get(5)));
                arrayList.add(o.k(f11027a.get(49)));
            } else {
                arrayList.add(o.k(f11027a.get(38)));
                arrayList.add(o.k(f11027a.get(5)));
                arrayList.add(o.k(f11027a.get(4)));
                arrayList.add(o.k(f11027a.get(35)));
                arrayList.add(o.k(f11027a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}
