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
/* loaded from: classes4.dex */
public class bi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f27309b;

    /* renamed from: c  reason: collision with root package name */
    public String f27310c;

    /* renamed from: d  reason: collision with root package name */
    public bk f27311d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f27312e;

    /* loaded from: classes4.dex */
    public interface a {
        void a(View view, boolean z);
    }

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f27313b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f27314c;

        /* renamed from: d  reason: collision with root package name */
        public int f27315d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ bi f27316e;

        public b(bi biVar, String str, String str2, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {biVar, str, str2, Boolean.valueOf(z), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27316e = biVar;
            this.a = str;
            this.f27313b = str2;
            this.f27314c = z;
            this.f27315d = i;
        }
    }

    public bi(Activity activity, bk bkVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, bkVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27309b = new ArrayList();
        this.f27310c = activity.getClass().getName();
        this.f27311d = bkVar;
        this.f27312e = z;
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.a = ((JSONObject) jSONObject.get("meta")).getInt("matchAll") != 0;
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
                boolean z = jSONObject2.optInt("ignoreCellIndex") != 0;
                if (this.f27310c.equals(optString)) {
                    this.f27309b.add(new b(this, optString, optString2, z, optInt));
                }
            }
        } catch (Exception unused2) {
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f27317b;

        /* renamed from: c  reason: collision with root package name */
        public String f27318c;

        /* renamed from: d  reason: collision with root package name */
        public c f27319d;

        public c(View view, c cVar, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, cVar, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27319d = cVar;
            this.a = bj.l(view);
            this.f27317b = bj.b(view);
            String c2 = bj.c(view);
            if (TextUtils.isEmpty(c2)) {
                c2 = bj.a(view, c());
                if (TextUtils.isEmpty(c2)) {
                    c2 = bj.a(view, view2);
                }
            }
            this.f27318c = c2;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                StringBuilder sb = new StringBuilder();
                for (c cVar = this; cVar != null; cVar = cVar.f27319d) {
                    sb.insert(0, cVar.a(false));
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                StringBuilder sb = new StringBuilder();
                boolean z = false;
                for (c cVar = this; cVar != null; cVar = cVar.f27319d) {
                    boolean z2 = true;
                    if (!z) {
                        String c2 = cVar.c();
                        if ("ListView".equals(c2) || RecyclerView.TAG.equals(c2) || "GridView".equals(c2)) {
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

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                c cVar = this.f27319d;
                return cVar == null ? "" : cVar.f27317b;
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
                    sb.append(this.f27318c);
                    sb.append(PreferencesUtil.RIGHT_MOUNT);
                }
                return sb.toString();
            }
            return (String) invokeZ.objValue;
        }
    }

    public void a(Activity activity) {
        List<b> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            if (this.f27312e || this.a || !((list = this.f27309b) == null || list.size() == 0)) {
                View a2 = bj.a(activity);
                a(activity, a2, null, a2);
            }
        }
    }

    private void a(Activity activity, View view, c cVar, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65537, this, activity, view, cVar, view2) == null) || view == null || ai.a(view) || bj.c(activity, view)) {
            return;
        }
        c cVar2 = new c(view, cVar, view2);
        if (cVar != null) {
            boolean b2 = this.a ? bj.b(view, cVar2.c()) : a(this.f27309b, cVar2.a(), cVar2.b());
            if (b2 || this.f27312e) {
                if (bd.c().b() && b2) {
                    bd c2 = bd.c();
                    c2.a("accumulate view:" + view.getClass().getName() + "; content:" + bj.h(view));
                }
                if (bh.c().b()) {
                    bh c3 = bh.c();
                    c3.a("accumulate view:" + view.getClass().getName() + "; content:" + bj.h(view));
                }
                this.f27311d.a(view, b2);
            }
        }
        if (!(view instanceof WebView) && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(activity, viewGroup.getChildAt(i), cVar2, view2);
            }
        }
    }

    private boolean a(List<b> list, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, list, str, str2)) == null) {
            for (b bVar : list) {
                String str3 = bVar.f27314c ? str2 : str;
                if (!TextUtils.isEmpty(str3) && str3.equals(bVar.f27313b)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
