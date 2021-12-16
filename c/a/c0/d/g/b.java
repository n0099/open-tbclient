package c.a.c0.d.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes.dex */
public class b implements c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f1439c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.c0.d.h.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean[] a;

        public a(b bVar, boolean[] zArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, zArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zArr;
        }

        @Override // c.a.c0.d.h.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a[0] = z;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(748876040, "Lc/a/c0/d/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(748876040, "Lc/a/c0/d/g/b;");
                return;
            }
        }
        f1439c = new String[]{BaseWebViewActivity.SHOUBAI_SCHEME, "com.baidu.nani", "com.baidu.tieba", "bdminivideo", "xifan", "baidumap", "bdnetdisk", "askmybaby", "baiduboxmission", ThirdPartyUtil.TYPE_WEIXIN, "baiduboxlite", "baiduhaokan", "market", "samsungapps", "duxiaomanloan", "bdbook", "baiduime", "bdwenku", "iqiyi", "bdvideo", "zhidao", "mimarket", "appmarket", "oppomarket", "vivomarket", "youa", "com.tencent.mm", "gamenow", "flowlocal", "yykiwi", "baiduboxvision", "lemon", "duxiaoxiaoapp", "youjia", "bdwkst", "alipays", "bddrama", "comjia", "ctrip", "imeituan", "lianjia", "lianjiabeike", "meituanwaimai", "momochat", "openanjuke", "openapp.jdmobile", "openapp.jdpingou", "openjdlite", "pddopen", "pinduoduo", "qunaraphone", "suning", "tbopen", "vipshop", "vmall", "wbmain", "youku", "miyabaobei", "mogujie", "taobao"};
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.c0.d.g.c
    public void a(String str, String str2, c.a.c0.d.h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, aVar) == null) || aVar == null) {
            return;
        }
        aVar.onResult(true);
    }

    @Override // c.a.c0.d.g.c
    public boolean b(Context context, String str, @Nullable Map<String, Object> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, map)) == null) {
            boolean[] zArr = new boolean[1];
            c.a.c0.d.h.c.a(context, str, null, new a(this, zArr), true);
            return zArr[0];
        }
        return invokeLLL.booleanValue;
    }

    @Override // c.a.c0.d.g.c
    public String[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String[]) invokeV.objValue;
    }

    @Override // c.a.c0.d.g.c
    public boolean d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (String str2 : f1439c) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
