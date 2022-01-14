package com.baidu.nadcore.video.plugin.videoplayer.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.k0.o;
import c.a.c0.v.w.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ClarityUrlList extends ArrayList<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mClarityInfoStr;
    public c mCurrentClarityUrl;
    public int mDefaultClarity;
    public int mMultiRateSwitchRank;
    public int mSelectType;

    /* loaded from: classes10.dex */
    public class a implements Comparator<c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ClarityUrlList f37129e;

        public a(ClarityUrlList clarityUrlList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {clarityUrlList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37129e = clarityUrlList;
        }

        public final int a(String str) {
            InterceptResult invokeL;
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                int hashCode = str.hashCode();
                if (hashCode == 3324) {
                    if (str.equals("hd")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                } else if (hashCode == 46737913) {
                    if (str.equals("1080p")) {
                        c2 = 3;
                    }
                    c2 = 65535;
                } else if (hashCode != 3664) {
                    if (hashCode == 3665 && str.equals("sd")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                } else {
                    if (str.equals("sc")) {
                        c2 = 2;
                    }
                    c2 = 65535;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        if (c2 != 2) {
                            return c2 != 3 ? Integer.MAX_VALUE : 4;
                        }
                        return 3;
                    }
                    return 2;
                }
                return 1;
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(c cVar, c cVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2)) == null) ? a(cVar.c()) - a(cVar2.c()) : invokeLL.intValue;
        }
    }

    /* loaded from: classes10.dex */
    public class b extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public ClarityUrlList() {
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

    private void convert(@NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, jSONArray) == null) {
            convert(jSONArray, false);
        }
    }

    @Nullable
    public b getAutoClarity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            for (int i2 = 0; i2 < size(); i2++) {
                c cVar = get(i2);
                if (cVar instanceof b) {
                    return (b) cVar;
                }
            }
            return null;
        }
        return (b) invokeV.objValue;
    }

    @Nullable
    public c getClarityByIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.mDefaultClarity;
            if (i2 < 0 || i2 >= size()) {
                return null;
            }
            return get(this.mDefaultClarity);
        }
        return (c) invokeV.objValue;
    }

    public c getClarityByOriginRank(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            for (int i3 = 0; i3 < size(); i3++) {
                c cVar = get(i3);
                if (cVar.e() == i2) {
                    return cVar;
                }
            }
            return null;
        }
        return (c) invokeI.objValue;
    }

    public String getClarityInfoStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mClarityInfoStr : (String) invokeV.objValue;
    }

    public c getCurrentClarityUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mCurrentClarityUrl : (c) invokeV.objValue;
    }

    @NonNull
    public String getCurrentKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c cVar = this.mCurrentClarityUrl;
            if (cVar != null) {
                String c2 = cVar.c();
                return !TextUtils.isEmpty(c2) ? c2 : c2;
            }
            return "sd";
        }
        return (String) invokeV.objValue;
    }

    public int getCurrentRank() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            for (int i2 = 0; i2 < size(); i2++) {
                c cVar = get(i2);
                if (cVar != null && cVar.compareTo(this.mCurrentClarityUrl) == 0) {
                    return cVar.f37132g;
                }
            }
            return this.mDefaultClarity;
        }
        return invokeV.intValue;
    }

    public int getDefaultClarity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mDefaultClarity : invokeV.intValue;
    }

    public String getDefaultTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? get(this.mDefaultClarity).f() : (String) invokeV.objValue;
    }

    public String getDefaultUrl() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.mDefaultClarity >= size() || (i2 = this.mDefaultClarity) < 0) {
                return "";
            }
            if (!"auto".equals(get(i2).c())) {
                return get(this.mDefaultClarity).g();
            }
            return get(0).g();
        }
        return (String) invokeV.objValue;
    }

    public int getMultiRateSwitchRank() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mMultiRateSwitchRank : invokeV.intValue;
    }

    public int getSelectType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mSelectType : invokeV.intValue;
    }

    public void setCurrentClarityUrl(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.mCurrentClarityUrl = cVar;
        }
    }

    public void setDefaultClarity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            if (i2 >= 0 && i2 < size()) {
                this.mDefaultClarity = i2;
            } else {
                this.mDefaultClarity = 0;
            }
        }
    }

    public void setMultiRateSwitchRank(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.mMultiRateSwitchRank = i2;
        }
    }

    public void updateCurrentClarityToLowest() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this);
        Collections.sort(arrayList, new a(this));
        setCurrentClarityUrl((c) arrayList.get(0));
        if (d.b()) {
            setMultiRateSwitchRank(((c) arrayList.get(0)).f37132g);
        }
    }

    public ClarityUrlList(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONArray};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        convert(jSONArray, false);
    }

    private void convert(@NonNull JSONArray jSONArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONArray, z) == null) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    add(new c(optJSONObject, length));
                }
            }
            if (size() <= 0) {
                return;
            }
            Collections.sort(this);
            c.a.c0.v.m0.c b2 = c.a.c0.v.v0.c.b(this, get(size() - 1).i());
            this.mSelectType = b2.f2466b;
            int i3 = b2.a;
            this.mDefaultClarity = i3;
            c cVar = get(i3);
            this.mCurrentClarityUrl = cVar;
            this.mMultiRateSwitchRank = cVar.f37132g;
        }
    }

    public ClarityUrlList(JSONArray jSONArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONArray, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (jSONArray == null) {
            return;
        }
        this.mClarityInfoStr = jSONArray.toString();
        if (z) {
            convert(jSONArray, true);
        } else {
            convert(jSONArray);
        }
    }

    /* loaded from: classes10.dex */
    public static class c implements Comparable<c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f37130e;

        /* renamed from: f  reason: collision with root package name */
        public int f37131f;

        /* renamed from: g  reason: collision with root package name */
        public int f37132g;

        /* renamed from: h  reason: collision with root package name */
        public String f37133h;

        /* renamed from: i  reason: collision with root package name */
        public String f37134i;

        /* renamed from: j  reason: collision with root package name */
        public float f37135j;
        public float k;
        public int l;
        public int m;
        public c.a.c0.v.y.a.c n;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1266051185, "Lcom/baidu/nadcore/video/plugin/videoplayer/model/ClarityUrlList$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1266051185, "Lcom/baidu/nadcore/video/plugin/videoplayer/model/ClarityUrlList$c;");
                    return;
                }
            }
            c.a.c0.h.a.b().getString(o.nad_videoplayer_clarity_text_sd);
            c.a.c0.h.a.b().getString(o.nad_videoplayer_clarity_text_hd);
            c.a.c0.h.a.b().getString(o.nad_videoplayer_clarity_text_sc);
            c.a.c0.h.a.b().getString(o.nad_videoplayer_clarity_text_1080p);
            c.a.c0.h.a.b().getString(o.nad_videoplayer_clarity_text_auto);
        }

        public c(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f37131f = -1;
            this.f37132g = -1;
            this.f37135j = -1.0f;
            this.f37130e = jSONObject.optString("key");
            int optInt = jSONObject.optInt("rank", i2);
            this.f37131f = optInt;
            this.f37132g = (i2 - 1) - optInt;
            this.f37133h = jSONObject.optString("title");
            this.f37134i = jSONObject.optString("url");
            jSONObject.optInt("width");
            jSONObject.optInt("height");
            jSONObject.has("download_url");
            jSONObject.optString("download_url");
            jSONObject.optString("airPlay_url");
            this.f37135j = (float) jSONObject.optDouble(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, -1.0d);
            this.k = (float) jSONObject.optDouble("video_clarity_score", -1.0d);
            String optString = jSONObject.optString("h265Url", "");
            if (!TextUtils.isEmpty(optString) && jSONObject.has("h265VideoSize")) {
                this.f37134i = optString;
                this.f37135j = (float) jSONObject.optDouble("h265VideoSize");
            }
            this.l = jSONObject.optInt("videoBps");
            this.m = jSONObject.optInt("vodMoovSize");
            this.n = c.a.c0.v.y.b.a.b(jSONObject.optString("auth"));
            jSONObject.optLong("expire_date");
            jSONObject.optString("interact_url");
            jSONObject.optInt("prefetch_size");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                int i2 = this.f37132g;
                int i3 = cVar.f37132g;
                if (i2 == i3) {
                    return 0;
                }
                return i2 > i3 ? 1 : -1;
            }
            return invokeL.intValue;
        }

        public c.a.c0.v.y.a.c b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : (c.a.c0.v.y.a.c) invokeV.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37130e : (String) invokeV.objValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : invokeV.intValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f37131f : invokeV.intValue;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f37133h : (String) invokeV.objValue;
        }

        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f37134i : (String) invokeV.objValue;
        }

        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.l : invokeV.intValue;
        }

        public float i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k : invokeV.floatValue;
        }

        public float j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f37135j : invokeV.floatValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return "ClarityUrl{mKey='" + this.f37130e + ExtendedMessageFormat.QUOTE + ", mTitle='" + this.f37133h + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f37131f = -1;
            this.f37132g = -1;
            this.f37135j = -1.0f;
        }
    }
}
