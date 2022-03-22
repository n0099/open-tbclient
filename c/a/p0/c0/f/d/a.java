package c.a.p0.c0.f.d;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.i2.n.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.c0.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0981a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(790538889, "Lc/a/p0/c0/f/d/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(790538889, "Lc/a/p0/c0/f/d/a$b;");
                    return;
                }
            }
            a = new a(null);
        }
    }

    public /* synthetic */ a(C0981a c0981a) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                a = b.a;
            }
            return a;
        }
        return (a) invokeV.objValue;
    }

    public String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? i == 1 ? SkinManager.SKIN_TYPE_STR_NIGHT : i == 4 ? SkinManager.SKIN_TYPE_STR_DARK : Config.TRACE_VISIT_RECENT_DAY : (String) invokeI.objValue;
    }

    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            if (!LiveFeedPageSdk.f().l()) {
                c.a.v.b.e.b.a().d(R.raw.lottie_common_pull_refresh, R.raw.obfuscated_res_0x7f110024, R.raw.obfuscated_res_0x7f110025, R.raw.obfuscated_res_0x7f110024, 15, 15, 30, 30);
                c.a.v.b.e.b.a().b("live_feed_page_load_more.json", "live_feed_page_load_more.json", "live_feed_page_load_more.json", "live_feed_page_load_more.json");
                c.a.v.b.e.b.a().c(R.raw.lottie_full_screen_refresh, R.raw.obfuscated_res_0x7f11002b, R.raw.obfuscated_res_0x7f11002c, R.raw.obfuscated_res_0x7f11002b, "", 67.0f, 67.0f);
                c.a.v.b.g.b.a.a().b(R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, 125.0f, 125.0f);
                c.a.v.b.g.b.a.a().c(R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, 125.0f, 125.0f);
                c.a.v.b.g.b.a.a().d(R.drawable.new_pic_emotion_08, R.drawable.new_pic_emotion_08, R.drawable.new_pic_emotion_08, R.drawable.new_pic_emotion_08, 125.0f, 125.0f);
                c.a.v.b.g.b.a.a().e(R.drawable.obfuscated_res_0x7f080d15, R.drawable.obfuscated_res_0x7f080d16, R.drawable.obfuscated_res_0x7f080d14, R.drawable.obfuscated_res_0x7f080d15);
                LiveFeedPageSdk.f().k(new c());
                LiveFeedPageSdk.f().i("tieba", b(TbadkCoreApplication.getInst().getSkinType()));
                LiveFeedPageSdk.f().j(new c.a.p0.c0.f.d.b());
                LiveFeedPageSdk.f().p();
            }
            LiveFeedPageSdk.f().o(context);
            if (LiveFeedPageSdk.f().g() == null || TextUtils.isEmpty(LiveFeedPageSdk.f().g().c())) {
                return;
            }
            LiveFeedPageSdk.f().r(LiveFeedPageSdk.f().g().c());
        }
    }

    public a() {
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
}
