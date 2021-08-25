package c.a.q0.f1.e.c;

import c.a.p0.s.q.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.face.base.b.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.RecomVertical.SubClassItem;
/* loaded from: classes3.dex */
public class a extends p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f17494a;

    /* renamed from: b  reason: collision with root package name */
    public String f17495b;

    /* renamed from: c  reason: collision with root package name */
    public String f17496c;

    /* renamed from: d  reason: collision with root package name */
    public int f17497d;

    public a() {
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

    public void a(SubClassItem subClassItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, subClassItem) == null) || subClassItem == null) {
            return;
        }
        this.f17494a = subClassItem.sub_class_id.intValue();
        this.f17495b = subClassItem.sub_class_name;
        this.f17496c = subClassItem.sub_class_icon;
        this.f17497d = subClassItem.enable.intValue();
    }

    @Override // c.a.p0.s.q.p
    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f17494a = jSONObject.optInt("sub_class_id");
        this.f17495b = jSONObject.optString("sub_class_name");
        this.f17496c = jSONObject.optString("sub_class_icon");
        this.f17497d = jSONObject.optInt(c.l);
    }
}
