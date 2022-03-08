package c.a.p0.n;

import android.util.SparseArray;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<g> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1885004540, "Lc/a/p0/n/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1885004540, "Lc/a/p0/n/i;");
                return;
            }
        }
        SparseArray<g> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new g(5, R.string.aiapp_menu_text_night_mode, R.drawable.aiapp_menu_item_nightmode, true));
        a.put(35, new g(35, R.string.aiapp_menu_add_launcher, R.drawable.aiapp_menu_item_ai_apps_add_to_launcher_selector, true));
        a.put(39, new g(39, R.string.aiapp_menu_restart, R.drawable.aiapp_menu_item_restart_selector, true));
        a.put(4, new g(4, R.string.aiapp_menu_text_share, R.drawable.aiapp_menu_item_share_arrow_selector, true));
        a.put(37, new g(37, R.string.aiapp_menu_authority_management, R.drawable.aiapp_menu_item_ai_apps_authority_management_selector, true));
        a.put(38, new g(38, R.string.aiapp_menu_text_favorite, R.drawable.aiapp_menu_item_add_fav_selector, true));
        a.put(42, new g(42, R.string.aiapp_menu_game_restart, R.drawable.aiapp_menu_item_restart_selector, true));
        a.put(49, new g(49, R.string.swan_app_menu_setting, R.drawable.swan_app_menu_item_setting_selector, true));
        a.put(50, new g(50, R.string.swanapp_menu_font_setting, R.drawable.swan_app_menu_item_font_setting_selector, true));
        a.put(43, new g(43, R.string.aiapp_menu_apply_guarantee, R.drawable.aiapp_menu_item_apply_guarantee_selector, true));
        a.put(9, new g(9, R.string.aiapp_menu_text_feedback, R.drawable.aiapp_menu_item_feedback_selector, true));
        a.put(46, new g(46, R.string.aiapp_menu_global_notice, R.drawable.aiapp_menu_item_global_notice_selector, true));
        a.put(47, new g(47, R.string.aiapp_menu_global_private, R.drawable.aiapp_menu_item_global_private_selector, true));
    }

    public static g a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? g.k(a.get(i2)) : (g) invokeI.objValue;
    }

    public static List<g> b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i2 != 0) {
                if (i2 != 12) {
                    if (i2 != 13) {
                        switch (i2) {
                            case 16:
                                arrayList.add(g.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(g.k(a.get(38)));
                                arrayList.add(g.k(a.get(4)));
                                arrayList.add(g.k(a.get(39)));
                                arrayList.add(g.k(a.get(35)));
                                arrayList.add(g.k(a.get(5)));
                                arrayList.add(g.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(g.l(a.get(38), false));
                                arrayList.add(g.l(a.get(4), false));
                                arrayList.add(g.k(a.get(39)));
                                arrayList.add(g.l(a.get(35), false));
                                arrayList.add(g.k(a.get(5)));
                                arrayList.add(g.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(g.k(a.get(38)));
                                arrayList.add(g.k(a.get(4)));
                                arrayList.add(g.k(a.get(39)));
                                arrayList.add(g.k(a.get(35)));
                                arrayList.add(g.k(a.get(5)));
                                arrayList.add(g.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(g.k(a.get(43)));
                    }
                }
                arrayList.add(g.k(a.get(38)));
                arrayList.add(g.k(a.get(4)));
                arrayList.add(g.k(a.get(39)));
                arrayList.add(g.k(a.get(35)));
                arrayList.add(g.k(a.get(5)));
                arrayList.add(g.k(a.get(49)));
            } else {
                arrayList.add(g.k(a.get(38)));
                arrayList.add(g.k(a.get(5)));
                arrayList.add(g.k(a.get(4)));
                arrayList.add(g.k(a.get(35)));
                arrayList.add(g.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}
