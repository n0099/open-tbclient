package c.a.r0.g3.j;

import com.baidu.tieba.square.flist.ForumListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f18742a;

    /* renamed from: b  reason: collision with root package name */
    public String f18743b;

    /* renamed from: c  reason: collision with root package name */
    public String f18744c;

    /* renamed from: d  reason: collision with root package name */
    public String f18745d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d> f18746e;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            this.f18742a = jSONObject.optString("menu_type");
            this.f18743b = jSONObject.optString(ForumListActivity.KEY_MENU_NAME);
            this.f18744c = jSONObject.optString(ForumListActivity.KEY_MENU_ID);
            String optString = jSONObject.optString("default_logo_url", null);
            this.f18745d = optString;
            this.f18745d = optString != null ? this.f18745d + "?v=2" : null;
            if (jSONObject.has("child_menu_list")) {
                ArrayList<d> arrayList = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("child_menu_list");
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    d dVar = new d();
                    dVar.a(optJSONArray.getJSONObject(i2));
                    arrayList.add(dVar);
                }
                this.f18746e = arrayList;
            }
        }
    }
}
