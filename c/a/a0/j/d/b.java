package c.a.a0.j.d;

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
    public String f1252b;

    /* renamed from: c  reason: collision with root package name */
    public String f1253c;

    /* renamed from: d  reason: collision with root package name */
    public long f1254d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1255e;

    /* renamed from: f  reason: collision with root package name */
    public int f1256f;

    /* renamed from: g  reason: collision with root package name */
    public int f1257g;

    /* renamed from: h  reason: collision with root package name */
    public int f1258h;
    public String i;
    public int j;
    public int k;
    public String l;
    public String m;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1253c = "";
        this.f1254d = 0L;
        this.f1255e = false;
        this.f1256f = 0;
        this.f1257g = 0;
        this.f1258h = 0;
    }

    public static String a(@NonNull b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("page", bVar.a);
                jSONObject.put(Constant.KEY_BUSINESS, bVar.f1252b);
                jSONObject.put("content_type", bVar.f1253c);
                jSONObject.put(BreakpointSQLiteKey.CONTENT_LENGTH, bVar.f1254d);
                jSONObject.put("is_dirty", bVar.f1255e ? 1 : 0);
                jSONObject.put("close_v_download", bVar.f1256f);
                jSONObject.put("no_click_opt", bVar.f1257g);
                jSONObject.put("open_after_install", bVar.f1258h);
                jSONObject.put("action_area", bVar.i);
                jSONObject.put("notification_show_count", bVar.j);
                jSONObject.put("tips_show_count", bVar.k);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
