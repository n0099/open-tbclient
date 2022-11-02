package com.baidu.nadcore.video.plugin.videoplayer.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tieba.R;
import com.baidu.tieba.cy0;
import com.baidu.tieba.js0;
import com.baidu.tieba.ns0;
import com.baidu.tieba.os0;
import com.baidu.tieba.pz0;
import com.baidu.tieba.zi0;
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
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ClarityUrlList extends ArrayList<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mClarityInfoStr;
    public c mCurrentClarityUrl;
    public int mDefaultClarity;
    public int mMultiRateSwitchRank;
    public int mSelectType;

    /* loaded from: classes2.dex */
    public class b extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class a implements Comparator<c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ClarityUrlList a;

        public a(ClarityUrlList clarityUrlList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {clarityUrlList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = clarityUrlList;
        }

        public final int a(String str) {
            InterceptResult invokeL;
            char c;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                int hashCode = str.hashCode();
                if (hashCode != 3324) {
                    if (hashCode != 46737913) {
                        if (hashCode != 3664) {
                            if (hashCode == 3665 && str.equals("sd")) {
                                c = 0;
                            }
                            c = 65535;
                        } else {
                            if (str.equals(Config.STAT_SDK_CHANNEL)) {
                                c = 2;
                            }
                            c = 65535;
                        }
                    } else {
                        if (str.equals("1080p")) {
                            c = 3;
                        }
                        c = 65535;
                    }
                } else {
                    if (str.equals("hd")) {
                        c = 1;
                    }
                    c = 65535;
                }
                if (c == 0) {
                    return 1;
                }
                if (c == 1) {
                    return 2;
                }
                if (c == 2) {
                    return 3;
                }
                if (c != 3) {
                    return Integer.MAX_VALUE;
                }
                return 4;
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(c cVar, c cVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2)) == null) {
                return a(cVar.c()) - a(cVar2.c());
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Comparable<c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public int c;
        public String d;
        public String e;
        public float f;
        public HashMap<String, String> g;
        public float h;
        public int i;
        public int j;
        public ns0 k;

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
            zi0.b().getString(R.string.obfuscated_res_0x7f0f0c52);
            zi0.b().getString(R.string.obfuscated_res_0x7f0f0c50);
            zi0.b().getString(R.string.obfuscated_res_0x7f0f0c51);
            zi0.b().getString(R.string.obfuscated_res_0x7f0f0c4e);
            zi0.b().getString(R.string.obfuscated_res_0x7f0f0c4f);
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.b = -1;
            this.c = -1;
            this.f = -1.0f;
        }

        public ns0 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.k;
            }
            return (ns0) invokeV.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.j;
            }
            return invokeV.intValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.b;
            }
            return invokeV.intValue;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.d;
            }
            return (String) invokeV.objValue;
        }

        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.e;
            }
            return (String) invokeV.objValue;
        }

        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.i;
            }
            return invokeV.intValue;
        }

        public float i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.h;
            }
            return invokeV.floatValue;
        }

        public HashMap<String, String> j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.g;
            }
            return (HashMap) invokeV.objValue;
        }

        public float k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.f;
            }
            return invokeV.floatValue;
        }

        public c(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, Integer.valueOf(i)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.b = -1;
            this.c = -1;
            this.f = -1.0f;
            this.a = jSONObject.optString("key");
            int optInt = jSONObject.optInt("rank", i);
            this.b = optInt;
            this.c = (i - 1) - optInt;
            this.d = jSONObject.optString("title");
            this.e = jSONObject.optString("url");
            jSONObject.optInt("width");
            jSONObject.optInt("height");
            jSONObject.has("download_url");
            jSONObject.optString("download_url");
            jSONObject.optString("airPlay_url");
            this.f = (float) jSONObject.optDouble(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, -1.0d);
            this.h = (float) jSONObject.optDouble("video_clarity_score", -1.0d);
            String optString = jSONObject.optString("h265Url", "");
            if (!TextUtils.isEmpty(optString) && jSONObject.has("h265VideoSize")) {
                this.e = optString;
                this.f = (float) jSONObject.optDouble("h265VideoSize");
            }
            this.g = null;
            this.i = jSONObject.optInt("videoBps");
            this.j = jSONObject.optInt("vodMoovSize");
            this.k = os0.b(jSONObject.optString("auth"));
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
                int i = this.c;
                int i2 = cVar.c;
                if (i == i2) {
                    return 0;
                }
                if (i > i2) {
                    return 1;
                }
                return -1;
            }
            return invokeL.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return "ClarityUrl{mKey='" + this.a + "', mTitle='" + this.d + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    public ClarityUrlList() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Nullable
    public b getAutoClarity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            for (int i = 0; i < size(); i++) {
                c cVar = get(i);
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
            int i = this.mDefaultClarity;
            if (i >= 0 && i < size()) {
                return get(this.mDefaultClarity);
            }
            return null;
        }
        return (c) invokeV.objValue;
    }

    public String getClarityInfoStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mClarityInfoStr;
        }
        return (String) invokeV.objValue;
    }

    public c getCurrentClarityUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mCurrentClarityUrl;
        }
        return (c) invokeV.objValue;
    }

    @NonNull
    public String getCurrentKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c cVar = this.mCurrentClarityUrl;
            if (cVar != null) {
                String c2 = cVar.c();
                if (!TextUtils.isEmpty(c2)) {
                    return c2;
                }
                return c2;
            }
            return "sd";
        }
        return (String) invokeV.objValue;
    }

    public int getCurrentRank() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            for (int i = 0; i < size(); i++) {
                c cVar = get(i);
                if (cVar != null && cVar.compareTo(this.mCurrentClarityUrl) == 0) {
                    return cVar.c;
                }
            }
            return this.mDefaultClarity;
        }
        return invokeV.intValue;
    }

    public int getDefaultClarity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mDefaultClarity;
        }
        return invokeV.intValue;
    }

    public String getDefaultTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return get(this.mDefaultClarity).f();
        }
        return (String) invokeV.objValue;
    }

    public int getMultiRateSwitchRank() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mMultiRateSwitchRank;
        }
        return invokeV.intValue;
    }

    public int getSelectType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mSelectType;
        }
        return invokeV.intValue;
    }

    public ClarityUrlList(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONArray};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        convert(jSONArray, false);
    }

    private void convert(@NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, jSONArray) == null) {
            convert(jSONArray, false);
        }
    }

    public c getClarityByOriginRank(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            for (int i2 = 0; i2 < size(); i2++) {
                c cVar = get(i2);
                if (cVar.e() == i) {
                    return cVar;
                }
            }
            return null;
        }
        return (c) invokeI.objValue;
    }

    public void setCurrentClarityUrl(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.mCurrentClarityUrl = cVar;
        }
    }

    public void setDefaultClarity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            if (i >= 0 && i < size()) {
                this.mDefaultClarity = i;
            } else {
                this.mDefaultClarity = 0;
            }
        }
    }

    public void setMultiRateSwitchRank(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.mMultiRateSwitchRank = i;
        }
    }

    public ClarityUrlList(JSONArray jSONArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONArray, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    private void convert(@NonNull JSONArray jSONArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONArray, z) == null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    add(new c(optJSONObject, length));
                }
            }
            if (size() <= 0) {
                return;
            }
            Collections.sort(this);
            cy0 b2 = pz0.b(this, get(size() - 1).i());
            this.mSelectType = b2.b;
            int i2 = b2.a;
            this.mDefaultClarity = i2;
            c cVar = get(i2);
            this.mCurrentClarityUrl = cVar;
            this.mMultiRateSwitchRank = cVar.c;
        }
    }

    public String getDefaultUrl() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.mDefaultClarity < size() && (i = this.mDefaultClarity) >= 0) {
                if (!"auto".equals(get(i).c())) {
                    return get(this.mDefaultClarity).g();
                }
                return get(0).g();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void updateCurrentClarityToLowest() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this);
        Collections.sort(arrayList, new a(this));
        setCurrentClarityUrl((c) arrayList.get(0));
        if (js0.b()) {
            setMultiRateSwitchRank(((c) arrayList.get(0)).c);
        }
    }
}
