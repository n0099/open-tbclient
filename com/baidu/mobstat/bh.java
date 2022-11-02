package com.baidu.mobstat;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class bh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List<b> b;
    public String c;
    public bj d;
    public boolean e;

    /* loaded from: classes2.dex */
    public interface a {
        void a(View view2, boolean z);
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public boolean c;
        public int d;
        public final /* synthetic */ bh e;

        public b(bh bhVar, String str, String str2, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bhVar, str, str2, Boolean.valueOf(z), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = bhVar;
            this.a = str;
            this.b = str2;
            this.c = z;
            this.d = i;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public c d;

        public c(View view2, c cVar, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, cVar, view3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = cVar;
            this.a = bi.m(view2);
            this.b = bi.b(view2);
            String c = bi.c(view2);
            if (TextUtils.isEmpty(c)) {
                c = bi.a(view2, c());
                if (TextUtils.isEmpty(c)) {
                    c = bi.a(view2, view3);
                }
            }
            this.c = c;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                StringBuilder sb = new StringBuilder();
                for (c cVar = this; cVar != null; cVar = cVar.d) {
                    sb.insert(0, cVar.a(false));
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                c cVar = this.d;
                if (cVar == null) {
                    return "";
                }
                return cVar.b;
            }
            return (String) invokeV.objValue;
        }

        public String a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("/");
                sb.append(this.a);
                if (!z) {
                    sb.append(PreferencesUtil.LEFT_MOUNT);
                    sb.append(this.c);
                    sb.append(PreferencesUtil.RIGHT_MOUNT);
                }
                return sb.toString();
            }
            return (String) invokeZ.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                StringBuilder sb = new StringBuilder();
                boolean z = false;
                for (c cVar = this; cVar != null; cVar = cVar.d) {
                    boolean z2 = true;
                    if (!z) {
                        String c = cVar.c();
                        if ("ListView".equals(c) || RecyclerView.TAG.equals(c) || "GridView".equals(c)) {
                            z = true;
                            sb.insert(0, cVar.a(z2));
                        }
                    }
                    z2 = false;
                    sb.insert(0, cVar.a(z2));
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    public bh(Activity activity, bj bjVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, bjVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.c = activity.getClass().getName();
        this.d = bjVar;
        this.e = z;
    }

    private void a(Activity activity, View view2, c cVar, View view3) {
        boolean a2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65537, this, activity, view2, cVar, view3) != null) || view2 == null || ah.a(view2) || bi.c(activity, view2)) {
            return;
        }
        c cVar2 = new c(view2, cVar, view3);
        if (cVar != null) {
            String a3 = cVar2.a();
            String b2 = cVar2.b();
            if (this.a) {
                a2 = bi.b(view2, cVar2.c());
            } else {
                a2 = a(this.b, a3, b2);
            }
            if (a2 || this.e) {
                if (bc.c().b() && a2) {
                    bc c2 = bc.c();
                    c2.a("accumulate view:" + view2.getClass().getName() + "; content:" + bi.h(view2));
                }
                if (bg.c().b()) {
                    bg c3 = bg.c();
                    c3.a("accumulate view:" + view2.getClass().getName() + "; content:" + bi.h(view2));
                }
                this.d.a(view2, a2);
            }
        }
        if (!(view2 instanceof WebView) && (view2 instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view2;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(activity, viewGroup.getChildAt(i), cVar2, view3);
            }
        }
    }

    private boolean a(List<b> list, String str, String str2) {
        InterceptResult invokeLLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, list, str, str2)) == null) {
            for (b bVar : list) {
                if (bVar.c) {
                    str3 = str2;
                } else {
                    str3 = str;
                }
                if (!TextUtils.isEmpty(str3) && str3.equals(bVar.b)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void a(Activity activity) {
        List<b> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            if (!this.e && !this.a && ((list = this.b) == null || list.size() == 0)) {
                return;
            }
            View a2 = bi.a(activity);
            a(activity, a2, null, a2);
        }
    }

    public void a(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            if (((JSONObject) jSONObject.get("meta")).getInt("matchAll") != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.a = z2;
        } catch (Exception unused) {
        }
        if (this.a) {
            return;
        }
        try {
            JSONArray jSONArray = (JSONArray) jSONObject.get("data");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                String optString = jSONObject2.optString("page");
                String optString2 = jSONObject2.optString(TtmlNode.TAG_LAYOUT);
                int optInt = jSONObject2.optInt("contentAsLabel");
                if (jSONObject2.optInt("ignoreCellIndex") != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (this.c.equals(optString)) {
                    this.b.add(new b(this, optString, optString2, z, optInt));
                }
            }
        } catch (Exception unused2) {
        }
    }
}
