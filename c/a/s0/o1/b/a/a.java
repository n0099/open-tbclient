package c.a.s0.o1.b.a;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.b;
import c.a.r0.s.r.d2;
import c.a.r0.s.r.l0;
import c.a.r0.s.r.n;
import c.a.s0.o1.j.h.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.listview.TKRecyclerView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.BannerImage;
import tbclient.RecomTopicList;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d2> f20615b;

    /* renamed from: c  reason: collision with root package name */
    public n f20616c;

    /* renamed from: d  reason: collision with root package name */
    public l0 f20617d;

    /* renamed from: e  reason: collision with root package name */
    public c f20618e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public String f20619f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.s0.l2.b.a f20620g;

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
                return;
            }
        }
        this.a = true;
    }

    public n a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20616c : (n) invokeV.objValue;
    }

    public l0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20617d : (l0) invokeV.objValue;
    }

    public c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20618e : (c) invokeV.objValue;
    }

    public c.a.s0.l2.b.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20620g : (c.a.s0.l2.b.a) invokeV.objValue;
    }

    public ArrayList<d2> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f20615b : (ArrayList) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.s0.l2.b.a aVar = this.f20620g;
            return aVar != null && aVar.f19132e;
        }
        return invokeV.booleanValue;
    }

    public void h(JSONObject jSONObject) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                this.f20615b = new ArrayList<>(optJSONArray.length());
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    if (jSONObject2 != null) {
                        d2 d2Var = new d2();
                        d2Var.e2 = true;
                        d2Var.j2 = MainTabActivity.TAB_CODE_LOCAL.equals(this.f20619f);
                        d2Var.b3(jSONObject2);
                        d2Var.J1();
                        this.f20615b.add(d2Var);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("banner_list");
            if (optJSONArray2 != null) {
                this.f20616c = new n();
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                    JSONObject optJSONObject = optJSONArray2.optJSONObject(i4);
                    if (optJSONObject != null) {
                        BannerImage.Builder builder = new BannerImage.Builder();
                        builder.ahead_url = optJSONObject.optString("ahead_url");
                        builder.img_url = optJSONObject.optString(BigdayActivityConfig.IMG_URL);
                        builder.title = optJSONObject.optString("title");
                        arrayList.add(builder.build(true));
                    }
                }
                this.f20616c.parserProtobuf(arrayList);
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray(TKRecyclerView.TYPE_GRID);
            if (optJSONArray3 != null && optJSONArray3.length() >= 4) {
                this.f20617d = new l0();
                ArrayList arrayList2 = new ArrayList();
                for (int i5 = 0; i5 < optJSONArray3.length(); i5++) {
                    JSONObject optJSONObject2 = optJSONArray3.optJSONObject(i5);
                    if (optJSONObject2 != null) {
                        BannerImage.Builder builder2 = new BannerImage.Builder();
                        builder2.ahead_url = optJSONObject2.optString("ahead_url");
                        builder2.img_url = optJSONObject2.optString(BigdayActivityConfig.IMG_URL);
                        builder2.title = optJSONObject2.optString("title");
                        arrayList2.add(builder2.build(true));
                    }
                }
                this.f20617d.parserProtobuf(arrayList2);
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("module_list");
            JSONArray jSONArray = null;
            int i6 = 0;
            while (true) {
                if (i6 >= optJSONArray4.length()) {
                    i2 = 0;
                    break;
                }
                JSONObject optJSONObject3 = optJSONArray4.optJSONObject(i6);
                if ("hot_topic".equals(optJSONObject3.optString("type"))) {
                    jSONArray = optJSONObject3.optJSONArray("hot_topic");
                    i2 = optJSONObject3.optInt("position");
                    break;
                }
                i6++;
            }
            if (jSONArray != null && jSONArray.length() >= 4) {
                ArrayList arrayList3 = new ArrayList();
                for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                    JSONObject optJSONObject4 = jSONArray.optJSONObject(i7);
                    if (optJSONObject4 != null && i7 < 6) {
                        RecomTopicList.Builder builder3 = new RecomTopicList.Builder();
                        builder3.topic_id = Long.valueOf(b.g(optJSONObject4.optString("topic_id"), 0L));
                        builder3.topic_name = optJSONObject4.optString(IntentConfig.TOPIC_NAME);
                        builder3.topic_desc = optJSONObject4.optString("topic_desc");
                        builder3.tag = Integer.valueOf(optJSONObject4.optInt("tag"));
                        builder3.topic_pic = optJSONObject4.optString("topic_pic");
                        builder3.type = Integer.valueOf(optJSONObject4.optInt("type"));
                        builder3.discuss_num = Long.valueOf(b.g(optJSONObject4.optString("discuss_num"), 0L));
                        arrayList3.add(builder3.build(true));
                    }
                    c cVar = new c();
                    this.f20618e = cVar;
                    cVar.floorPosition = i2;
                    cVar.parserProtobuf(arrayList3);
                }
            }
            this.a = jSONObject.optInt("has_more", 1) == 1;
            JSONObject optJSONObject5 = jSONObject.optJSONObject("nearby_person");
            if (optJSONObject5 != null) {
                c.a.s0.l2.b.a aVar = new c.a.s0.l2.b.a();
                this.f20620g = aVar;
                aVar.a(optJSONObject5);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f20619f = str;
        }
    }
}
