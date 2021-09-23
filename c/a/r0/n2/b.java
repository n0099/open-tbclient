package c.a.r0.n2;

import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.b1;
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
    public ArrayList<ForumData> f22958a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<ForumData> f22959b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<ForumData> f22960c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<ForumData> f22961d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<ForumData> f22962e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<ForumData> f22963f;

    /* renamed from: g  reason: collision with root package name */
    public b1 f22964g;

    /* renamed from: h  reason: collision with root package name */
    public int f22965h;

    /* renamed from: i  reason: collision with root package name */
    public int f22966i;

    /* renamed from: j  reason: collision with root package name */
    public int f22967j;

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
        this.f22966i = 0;
        this.f22967j = 0;
        this.f22958a = new ArrayList<>();
        this.f22959b = new ArrayList<>();
        this.f22960c = new ArrayList<>();
        this.f22961d = new ArrayList<>();
        this.f22963f = new ArrayList<>();
        this.f22962e = new ArrayList<>();
        this.f22964g = new b1();
        s(false);
    }

    public void a(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, arrayList, arrayList2) == null) {
            if (this.f22961d == null) {
                this.f22961d = new ArrayList<>();
            }
            ArrayList<ForumData> arrayList3 = this.f22962e;
            if (arrayList3 != null && arrayList != null) {
                arrayList3.addAll(arrayList);
            }
            ArrayList<ForumData> arrayList4 = this.f22963f;
            if (arrayList4 != null && arrayList2 != null) {
                arrayList4.addAll(arrayList2);
            }
            if (this.f22962e == null && this.f22963f == null) {
                return;
            }
            this.f22961d.clear();
            ArrayList<ForumData> arrayList5 = this.f22962e;
            if (arrayList5 != null) {
                this.f22961d.addAll(arrayList5);
            }
            ArrayList<ForumData> arrayList6 = this.f22963f;
            if (arrayList6 != null) {
                this.f22961d.addAll(arrayList6);
            }
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f22967j += i2;
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, arrayList, arrayList2) == null) {
            if (this.f22958a == null) {
                this.f22958a = new ArrayList<>();
            }
            ArrayList<ForumData> arrayList3 = this.f22959b;
            if (arrayList3 != null && arrayList != null) {
                arrayList3.addAll(arrayList);
            }
            ArrayList<ForumData> arrayList4 = this.f22960c;
            if (arrayList4 != null && arrayList2 != null) {
                arrayList4.addAll(arrayList2);
            }
            if (this.f22959b == null && this.f22960c == null) {
                return;
            }
            this.f22958a.clear();
            ArrayList<ForumData> arrayList5 = this.f22959b;
            if (arrayList5 != null) {
                this.f22958a.addAll(arrayList5);
            }
            ArrayList<ForumData> arrayList6 = this.f22960c;
            if (arrayList6 != null) {
                this.f22958a.addAll(arrayList6);
            }
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f22966i += i2;
        }
    }

    public ArrayList<ForumData> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22961d : (ArrayList) invokeV.objValue;
    }

    public ArrayList<ForumData> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f22963f : (ArrayList) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22967j : invokeV.intValue;
    }

    public ArrayList<ForumData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f22962e : (ArrayList) invokeV.objValue;
    }

    public ArrayList<ForumData> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f22958a : (ArrayList) invokeV.objValue;
    }

    public ArrayList<ForumData> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f22960c : (ArrayList) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f22966i : invokeV.intValue;
    }

    public ArrayList<ForumData> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f22959b : (ArrayList) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f22965h == 1 : invokeV.booleanValue;
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
                this.f22964g.i(jSONObject.optJSONObject("page"));
                this.f22965h = jSONObject.optInt("has_more", 1);
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
                    this.f22966i = optJSONArray.length();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i2));
                        this.f22959b.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i3));
                        this.f22960c.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 == null) {
                    return;
                }
                JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                if (optJSONArray3 != null) {
                    this.f22967j = optJSONArray3.length();
                    for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                        ForumData forumData3 = new ForumData();
                        forumData3.parserJson(optJSONArray3.getJSONObject(i4));
                        this.f22962e.add(forumData3);
                    }
                }
                JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                if (optJSONArray4 != null) {
                    for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                        ForumData forumData4 = new ForumData();
                        forumData4.parserJson(optJSONArray4.getJSONObject(i5));
                        this.f22963f.add(forumData4);
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
            if (this.f22961d == null) {
                this.f22961d = new ArrayList<>();
            }
            ArrayList<ForumData> arrayList3 = this.f22962e;
            if (arrayList3 != null && arrayList != null) {
                arrayList3.clear();
                this.f22962e.addAll(arrayList);
            }
            ArrayList<ForumData> arrayList4 = this.f22963f;
            if (arrayList4 != null && arrayList2 != null) {
                arrayList4.clear();
                this.f22963f.addAll(arrayList2);
            }
            if (this.f22962e == null && this.f22963f == null) {
                return;
            }
            this.f22961d.clear();
            ArrayList<ForumData> arrayList5 = this.f22962e;
            if (arrayList5 != null) {
                this.f22961d.addAll(arrayList5);
            }
            ArrayList<ForumData> arrayList6 = this.f22963f;
            if (arrayList6 != null) {
                this.f22961d.addAll(arrayList6);
            }
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f22967j = i2;
        }
    }

    public void r(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, arrayList, arrayList2) == null) {
            if (this.f22958a == null) {
                this.f22958a = new ArrayList<>();
            }
            ArrayList<ForumData> arrayList3 = this.f22959b;
            if (arrayList3 != null && arrayList != null) {
                arrayList3.clear();
                this.f22959b.addAll(arrayList);
            }
            ArrayList<ForumData> arrayList4 = this.f22960c;
            if (arrayList4 != null && arrayList2 != null) {
                arrayList4.clear();
                this.f22960c.addAll(arrayList2);
            }
            if (this.f22959b == null && this.f22960c == null) {
                return;
            }
            this.f22958a.clear();
            ArrayList<ForumData> arrayList5 = this.f22959b;
            if (arrayList5 != null) {
                this.f22958a.addAll(arrayList5);
            }
            ArrayList<ForumData> arrayList6 = this.f22960c;
            if (arrayList6 != null) {
                this.f22958a.addAll(arrayList6);
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f22965h = z ? 1 : 0;
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f22966i = i2;
        }
    }
}
