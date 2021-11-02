package com.baidu.prologue.service.network;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.f0.b.f;
import b.a.f0.d.a.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.prologue.service.network.Request;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class Als {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42152a;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Area {
        public static final /* synthetic */ Area[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Area DEEPLINK_RESULT_APP;
        public static final Area DEEPLINK_RESULT_H5;
        public static final Area GIF;
        public static final Area IMAGE;
        public static final Area SKIP_BUTTON;
        public static final Area UNKNOW;
        public static final Area VIDEO;
        public transient /* synthetic */ FieldHolder $fh;
        public final String value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-185781923, "Lcom/baidu/prologue/service/network/Als$Area;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-185781923, "Lcom/baidu/prologue/service/network/Als$Area;");
                    return;
                }
            }
            SKIP_BUTTON = new Area("SKIP_BUTTON", 0, "skip_button");
            IMAGE = new Area("IMAGE", 1, "image");
            VIDEO = new Area(AdParamInfo.AdClickActionString.AD_CLICK_ACTION_VIDEO, 2, "video");
            GIF = new Area("GIF", 3, "gif");
            DEEPLINK_RESULT_APP = new Area("DEEPLINK_RESULT_APP", 4, "APP");
            DEEPLINK_RESULT_H5 = new Area("DEEPLINK_RESULT_H5", 5, "URL");
            Area area = new Area("UNKNOW", 6, "unknow");
            UNKNOW = area;
            $VALUES = new Area[]{SKIP_BUTTON, IMAGE, VIDEO, GIF, DEEPLINK_RESULT_APP, DEEPLINK_RESULT_H5, area};
        }

        public Area(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = str2;
        }

        public static Area valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Area) Enum.valueOf(Area.class, str) : (Area) invokeL.objValue;
        }

        public static Area[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (Area[]) $VALUES.clone() : (Area[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class CloseType {
        public static final /* synthetic */ CloseType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CloseType CLICK_AD_AREA;
        public static final CloseType CLICK_SKIP_BUTTON;
        public static final CloseType COUNTDOWN_TIME_FINISH;
        public static final CloseType OTHER;
        public transient /* synthetic */ FieldHolder $fh;
        public final String value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-707508614, "Lcom/baidu/prologue/service/network/Als$CloseType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-707508614, "Lcom/baidu/prologue/service/network/Als$CloseType;");
                    return;
                }
            }
            COUNTDOWN_TIME_FINISH = new CloseType("COUNTDOWN_TIME_FINISH", 0, "0");
            CLICK_SKIP_BUTTON = new CloseType("CLICK_SKIP_BUTTON", 1, "1");
            CLICK_AD_AREA = new CloseType("CLICK_AD_AREA", 2, "2");
            CloseType closeType = new CloseType("OTHER", 3, "3");
            OTHER = closeType;
            $VALUES = new CloseType[]{COUNTDOWN_TIME_FINISH, CLICK_SKIP_BUTTON, CLICK_AD_AREA, closeType};
        }

        public CloseType(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = str2;
        }

        public static CloseType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CloseType) Enum.valueOf(CloseType.class, str) : (CloseType) invokeL.objValue;
        }

        public static CloseType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CloseType[]) $VALUES.clone() : (CloseType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Page {
        public static final /* synthetic */ Page[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Page NA_DEEPLINK;
        public static final Page NA_SPLASH;
        public transient /* synthetic */ FieldHolder $fh;
        public final String value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-172433509, "Lcom/baidu/prologue/service/network/Als$Page;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-172433509, "Lcom/baidu/prologue/service/network/Als$Page;");
                    return;
                }
            }
            NA_SPLASH = new Page("NA_SPLASH", 0, "NA_SPLASH");
            Page page = new Page("NA_DEEPLINK", 1, "DEEPLINK");
            NA_DEEPLINK = page;
            $VALUES = new Page[]{NA_SPLASH, page};
        }

        public Page(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = str2;
        }

        public static Page valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Page) Enum.valueOf(Page.class, str) : (Page) invokeL.objValue;
        }

        public static Page[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (Page[]) $VALUES.clone() : (Page[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Type {
        public static final /* synthetic */ Type[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Type CLICK;
        public static final Type CLOSE;
        public static final Type DEEP_LINK;
        public static final Type DISCARD;
        public static final Type SHOW;
        public transient /* synthetic */ FieldHolder $fh;
        public final String value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-168015792, "Lcom/baidu/prologue/service/network/Als$Type;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-168015792, "Lcom/baidu/prologue/service/network/Als$Type;");
                    return;
                }
            }
            CLICK = new Type("CLICK", 0, "2");
            SHOW = new Type("SHOW", 1, "3");
            DISCARD = new Type("DISCARD", 2, "5");
            CLOSE = new Type("CLOSE", 3, "7");
            Type type = new Type("DEEP_LINK", 4, PraiseUBCHelper.PRAISE_FLOW_ID);
            DEEP_LINK = type;
            $VALUES = new Type[]{CLICK, SHOW, DISCARD, CLOSE, type};
        }

        public Type(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = str2;
        }

        public static Type valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Type) Enum.valueOf(Type.class, str) : (Type) invokeL.objValue;
        }

        public static Type[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (Type[]) $VALUES.clone() : (Type[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class a implements l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // b.a.f0.d.a.i
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, th) == null) && Als.f42152a) {
                String str = "Als get error response, " + th;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.f0.d.a.i
        /* renamed from: b */
        public void onResponse(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                boolean unused = Als.f42152a;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // b.a.f0.d.a.i
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, th) == null) && Als.f42152a) {
                String str = "Als performance get error response, " + th;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.f0.d.a.i
        /* renamed from: b */
        public void onResponse(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                boolean unused = Als.f42152a;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final JSONObject f42153a;

        public c(@NonNull Type type) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {type};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42153a = new JSONObject();
            d("da_type", type.value);
            c("origin_time", Long.valueOf(System.currentTimeMillis()));
            i(String.valueOf(f.a()));
            j(b.a.f0.b.g.c.f2835b);
        }

        public final <T> c b(String str, T t) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, t)) == null) {
                if (Als.f42152a && this.f42153a.has(str)) {
                    throw new IllegalArgumentException("key " + str + " has been set!");
                }
                try {
                    this.f42153a.put(str, t);
                } catch (JSONException unused) {
                    if (Als.f42152a) {
                        throw new IllegalArgumentException("Json put create invalid exception");
                    }
                }
                return this;
            }
            return (c) invokeLL.objValue;
        }

        public final c c(String str, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj)) == null) {
                b(str, obj);
                return this;
            }
            return (c) invokeLL.objValue;
        }

        public final c d(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
                b(str, str2);
                return this;
            }
            return (c) invokeLL.objValue;
        }

        public c e(@NonNull Area area) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, area)) == null) {
                d("da_area", area.value);
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c f(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                d("da_ext1", str);
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c g(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                d("da_ext2", str);
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c h(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                d("da_ext3", str);
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c i(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                d("da_ext4", str);
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c j(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                d("da_menu1", str);
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c k(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                d("da_menu2", str);
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c l(@NonNull Page page) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, page)) == null) {
                d("da_page", page.value);
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c m(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                d("extra_param", str);
                return this;
            }
            return (c) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1961984376, "Lcom/baidu/prologue/service/network/Als;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1961984376, "Lcom/baidu/prologue/service/network/Als;");
                return;
            }
        }
        f42152a = b.a.f0.a.b.a.f2781a.get() != null && b.a.f0.a.b.a.f2781a.get().s();
    }

    public static void b(Request.c cVar, b.a.f0.a.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, cVar, aVar) == null) {
            cVar.j(HttpRequest.CLIENT_TYPE, "2");
            cVar.j(AdUploadHttpRequest.KEY_OS_TYPE, "2");
            cVar.j("_client_version", aVar.C());
            cVar.j(AdUploadHttpRequest.KEY_OS_VERSION, aVar.g());
            cVar.j("model", aVar.q());
            cVar.j("cuid", aVar.f());
            cVar.j("productId", aVar.p());
            cVar.j("net_type", String.valueOf(new b.a.f0.d.a.f(aVar.o()).d()));
        }
    }

    public static void c(Request.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, cVar) == null) {
            cVar.j("c_id", "1038");
            cVar.j(TiePlusStat.RichTextType.STAT_KEY, "every");
        }
    }

    public static void d(Request.c cVar, String str, String str2, String str3, long j, long j2, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{cVar, str, str2, str3, Long.valueOf(j), Long.valueOf(j2), str4}) == null) {
            cVar.j("f1", str);
            cVar.j("f2", str2);
            cVar.j("f3", str3);
            cVar.j("f4", j2 + "");
            cVar.j("f5", str4);
            cVar.j("f6", String.valueOf(f.a()));
            cVar.j("f10", String.valueOf(j));
        }
    }

    public static void e(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, cVar) == null) {
            b.a.f0.a.b.a aVar = b.a.f0.a.b.a.f2781a.get();
            if (aVar == null) {
                if (f42152a) {
                    throw new IllegalStateException("宿主App未初始化IAppContext");
                }
                return;
            }
            Request.c cVar2 = new Request.c(aVar.o(), "https://als.baidu.com/clog/clog");
            b(cVar2, aVar);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(cVar.f42153a);
            cVar2.j("ad", jSONArray.toString());
            cVar2.n();
            cVar2.l().e(new a());
        }
    }

    public static void f(String str, String str2, String str3, long j, long j2, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{str, str2, str3, Long.valueOf(j), Long.valueOf(j2), str4}) == null) {
            b.a.f0.a.b.a aVar = b.a.f0.a.b.a.f2781a.get();
            if (aVar == null) {
                if (f42152a) {
                    throw new IllegalStateException("宿主App未初始化IAppContext");
                }
                return;
            }
            Request.c cVar = new Request.c(aVar.o(), "http://als.baidu.com/elog/plog");
            b(cVar, aVar);
            c(cVar);
            d(cVar, str, str2, str3, j, j2, str4);
            cVar.n();
            cVar.l().e(new b());
        }
    }
}
