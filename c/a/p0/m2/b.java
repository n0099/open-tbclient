package c.a.p0.m2;

import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.q.b1;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ForumData> f22044a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<ForumData> f22045b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<ForumData> f22046c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<ForumData> f22047d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<ForumData> f22048e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<ForumData> f22049f;

    /* renamed from: g  reason: collision with root package name */
    public b1 f22050g;

    /* renamed from: h  reason: collision with root package name */
    public int f22051h;

    /* renamed from: i  reason: collision with root package name */
    public int f22052i;

    /* renamed from: j  reason: collision with root package name */
    public int f22053j;

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
        this.f22052i = 0;
        this.f22053j = 0;
        this.f22044a = new ArrayList<>();
        this.f22045b = new ArrayList<>();
        this.f22046c = new ArrayList<>();
        this.f22047d = new ArrayList<>();
        this.f22049f = new ArrayList<>();
        this.f22048e = new ArrayList<>();
        this.f22050g = new b1();
        s(false);
    }

    public void a(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, arrayList, arrayList2) == null) {
            if (this.f22047d == null) {
                this.f22047d = new ArrayList<>();
            }
            ArrayList<ForumData> arrayList3 = this.f22048e;
            if (arrayList3 != null && arrayList != null) {
                arrayList3.addAll(arrayList);
            }
            ArrayList<ForumData> arrayList4 = this.f22049f;
            if (arrayList4 != null && arrayList2 != null) {
                arrayList4.addAll(arrayList2);
            }
            if (this.f22048e == null && this.f22049f == null) {
                return;
            }
            this.f22047d.clear();
            ArrayList<ForumData> arrayList5 = this.f22048e;
            if (arrayList5 != null) {
                this.f22047d.addAll(arrayList5);
            }
            ArrayList<ForumData> arrayList6 = this.f22049f;
            if (arrayList6 != null) {
                this.f22047d.addAll(arrayList6);
            }
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f22053j += i2;
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, arrayList, arrayList2) == null) {
            if (this.f22044a == null) {
                this.f22044a = new ArrayList<>();
            }
            ArrayList<ForumData> arrayList3 = this.f22045b;
            if (arrayList3 != null && arrayList != null) {
                arrayList3.addAll(arrayList);
            }
            ArrayList<ForumData> arrayList4 = this.f22046c;
            if (arrayList4 != null && arrayList2 != null) {
                arrayList4.addAll(arrayList2);
            }
            if (this.f22045b == null && this.f22046c == null) {
                return;
            }
            this.f22044a.clear();
            ArrayList<ForumData> arrayList5 = this.f22045b;
            if (arrayList5 != null) {
                this.f22044a.addAll(arrayList5);
            }
            ArrayList<ForumData> arrayList6 = this.f22046c;
            if (arrayList6 != null) {
                this.f22044a.addAll(arrayList6);
            }
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f22052i += i2;
        }
    }

    public ArrayList<ForumData> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22047d : (ArrayList) invokeV.objValue;
    }

    public ArrayList<ForumData> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f22049f : (ArrayList) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22053j : invokeV.intValue;
    }

    public ArrayList<ForumData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f22048e : (ArrayList) invokeV.objValue;
    }

    public ArrayList<ForumData> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f22044a : (ArrayList) invokeV.objValue;
    }

    public ArrayList<ForumData> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f22046c : (ArrayList) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f22052i : invokeV.intValue;
    }

    public ArrayList<ForumData> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f22045b : (ArrayList) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f22051h == 1 : invokeV.booleanValue;
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || str == null) {
            return;
        }
        try {
            o(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void o(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jSONObject) == null) {
            try {
                this.f22050g.i(jSONObject.optJSONObject("page"));
                this.f22051h = jSONObject.optInt("has_more", 1);
                long optLong = jSONObject.optLong("ctime", 0L);
                if (optLong > 0) {
                    new Date(optLong);
                } else {
                    new Date();
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
                if (optJSONObject == null) {
                    return;
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.f22052i = optJSONArray.length();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i2));
                        this.f22045b.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i3));
                        this.f22046c.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 == null) {
                    return;
                }
                JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                if (optJSONArray3 != null) {
                    this.f22053j = optJSONArray3.length();
                    for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                        ForumData forumData3 = new ForumData();
                        forumData3.parserJson(optJSONArray3.getJSONObject(i4));
                        this.f22048e.add(forumData3);
                    }
                }
                JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                if (optJSONArray4 != null) {
                    for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                        ForumData forumData4 = new ForumData();
                        forumData4.parserJson(optJSONArray4.getJSONObject(i5));
                        this.f22049f.add(forumData4);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void p(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, arrayList, arrayList2) == null) {
            if (this.f22047d == null) {
                this.f22047d = new ArrayList<>();
            }
            ArrayList<ForumData> arrayList3 = this.f22048e;
            if (arrayList3 != null && arrayList != null) {
                arrayList3.clear();
                this.f22048e.addAll(arrayList);
            }
            ArrayList<ForumData> arrayList4 = this.f22049f;
            if (arrayList4 != null && arrayList2 != null) {
                arrayList4.clear();
                this.f22049f.addAll(arrayList2);
            }
            if (this.f22048e == null && this.f22049f == null) {
                return;
            }
            this.f22047d.clear();
            ArrayList<ForumData> arrayList5 = this.f22048e;
            if (arrayList5 != null) {
                this.f22047d.addAll(arrayList5);
            }
            ArrayList<ForumData> arrayList6 = this.f22049f;
            if (arrayList6 != null) {
                this.f22047d.addAll(arrayList6);
            }
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f22053j = i2;
        }
    }

    public void r(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, arrayList, arrayList2) == null) {
            if (this.f22044a == null) {
                this.f22044a = new ArrayList<>();
            }
            ArrayList<ForumData> arrayList3 = this.f22045b;
            if (arrayList3 != null && arrayList != null) {
                arrayList3.clear();
                this.f22045b.addAll(arrayList);
            }
            ArrayList<ForumData> arrayList4 = this.f22046c;
            if (arrayList4 != null && arrayList2 != null) {
                arrayList4.clear();
                this.f22046c.addAll(arrayList2);
            }
            if (this.f22045b == null && this.f22046c == null) {
                return;
            }
            this.f22044a.clear();
            ArrayList<ForumData> arrayList5 = this.f22045b;
            if (arrayList5 != null) {
                this.f22044a.addAll(arrayList5);
            }
            ArrayList<ForumData> arrayList6 = this.f22046c;
            if (arrayList6 != null) {
                this.f22044a.addAll(arrayList6);
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f22051h = z ? 1 : 0;
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f22052i = i2;
        }
    }
}
