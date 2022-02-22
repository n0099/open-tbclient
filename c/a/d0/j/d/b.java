package c.a.d0.j.d;

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
    public String f2806b;

    /* renamed from: c  reason: collision with root package name */
    public String f2807c;

    /* renamed from: d  reason: collision with root package name */
    public long f2808d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2809e;

    /* renamed from: f  reason: collision with root package name */
    public int f2810f;

    /* renamed from: g  reason: collision with root package name */
    public int f2811g;

    /* renamed from: h  reason: collision with root package name */
    public int f2812h;

    /* renamed from: i  reason: collision with root package name */
    public String f2813i;

    /* renamed from: j  reason: collision with root package name */
    public int f2814j;
    public int k;
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
        this.f2807c = "";
        this.f2808d = 0L;
        this.f2809e = false;
        this.f2810f = 0;
        this.f2811g = 0;
        this.f2812h = 0;
    }

    public static String a(@NonNull b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("page", bVar.a);
                jSONObject.put(Constant.KEY_BUSINESS, bVar.f2806b);
                jSONObject.put("content_type", bVar.f2807c);
                jSONObject.put(BreakpointSQLiteKey.CONTENT_LENGTH, bVar.f2808d);
                jSONObject.put("is_dirty", bVar.f2809e ? 1 : 0);
                jSONObject.put("close_v_download", bVar.f2810f);
                jSONObject.put("no_click_opt", bVar.f2811g);
                jSONObject.put("open_after_install", bVar.f2812h);
                jSONObject.put("action_area", bVar.f2813i);
                jSONObject.put("notification_show_count", bVar.f2814j);
                jSONObject.put("tips_show_count", bVar.k);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
