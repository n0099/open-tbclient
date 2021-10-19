package c.a.r0.k3.i0;

import androidx.core.app.NotificationCompat;
import com.baidu.tbadk.core.data.AbstractData;
import com.baidu.tbadk.data.MetaData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f21068a;

    /* renamed from: b  reason: collision with root package name */
    public MetaData f21069b;

    /* renamed from: c  reason: collision with root package name */
    public List<AbstractData> f21070c;

    public q() {
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
        this.f21070c = new ArrayList();
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            try {
                this.f21068a = jSONObject.optString("id");
                MetaData metaData = new MetaData();
                this.f21069b = metaData;
                metaData.parserJson(jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR));
                JSONArray optJSONArray = jSONObject.optJSONArray("abstract");
                this.f21070c = new ArrayList();
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        AbstractData abstractData = new AbstractData();
                        abstractData.parserJson(optJSONArray.getJSONObject(i2));
                        this.f21070c.add(abstractData);
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
