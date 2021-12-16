package c.a.c0.g.d;

import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f1522b;

    /* renamed from: c  reason: collision with root package name */
    public String f1523c;

    /* renamed from: d  reason: collision with root package name */
    public long f1524d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1525e;

    /* renamed from: f  reason: collision with root package name */
    public int f1526f;

    /* renamed from: g  reason: collision with root package name */
    public int f1527g;

    /* renamed from: h  reason: collision with root package name */
    public int f1528h;

    /* renamed from: i  reason: collision with root package name */
    public String f1529i;

    /* renamed from: j  reason: collision with root package name */
    public int f1530j;

    /* renamed from: k  reason: collision with root package name */
    public int f1531k;
    public String l;
    public String m;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1523c = "";
        this.f1524d = 0L;
        this.f1525e = false;
        this.f1526f = 0;
        this.f1527g = 0;
        this.f1528h = 0;
    }

    public static String a(@NonNull b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("page", bVar.a);
                jSONObject.put(Constant.KEY_BUSINESS, bVar.f1522b);
                jSONObject.put("content_type", bVar.f1523c);
                jSONObject.put(BreakpointSQLiteKey.CONTENT_LENGTH, bVar.f1524d);
                jSONObject.put("is_dirty", bVar.f1525e ? 1 : 0);
                jSONObject.put("close_v_download", bVar.f1526f);
                jSONObject.put("no_click_opt", bVar.f1527g);
                jSONObject.put("open_after_install", bVar.f1528h);
                jSONObject.put("action_area", bVar.f1529i);
                jSONObject.put("notification_show_count", bVar.f1530j);
                jSONObject.put("tips_show_count", bVar.f1531k);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
