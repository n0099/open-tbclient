package b.a.r0.w.f.d;

import android.content.Context;
import android.text.TextUtils;
import b.a.r0.x1.n.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f26279a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.r0.w.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C1277a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f26280a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1246352526, "Lb/a/r0/w/f/d/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1246352526, "Lb/a/r0/w/f/d/a$b;");
                    return;
                }
            }
            f26280a = new a(null);
        }
    }

    public /* synthetic */ a(C1277a c1277a) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f26279a == null) {
                f26279a = b.f26280a;
            }
            return f26279a;
        }
        return (a) invokeV.objValue;
    }

    public String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? i2 == 1 ? SkinManager.SKIN_TYPE_STR_NIGHT : i2 == 4 ? SkinManager.SKIN_TYPE_STR_DARK : "day" : (String) invokeI.objValue;
    }

    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            if (!LiveFeedPageSdk.e().k()) {
                b.a.w.b.e.b.a().d(R.raw.lottie_common_pull_refresh, R.raw.lottie_common_pull_refresh_1, R.raw.lottie_common_pull_refresh_2, R.raw.lottie_common_pull_refresh_1, 15, 15, 30, 30);
                b.a.w.b.e.b.a().b("live_feed_page_load_more.json", "live_feed_page_load_more.json", "live_feed_page_load_more.json", "live_feed_page_load_more.json");
                b.a.w.b.e.b.a().c(R.raw.lottie_full_screen_refresh, R.raw.lottie_full_screen_refresh_1, R.raw.lottie_full_screen_refresh_2, R.raw.lottie_full_screen_refresh_1, "", 67.0f, 67.0f);
                b.a.w.b.g.b.a a2 = b.a.w.b.g.b.a.a();
                int i2 = R.drawable.new_pic_emotion_05;
                a2.b(i2, i2, i2, i2, 125.0f, 125.0f);
                b.a.w.b.g.b.a a3 = b.a.w.b.g.b.a.a();
                int i3 = R.drawable.new_pic_emotion_05;
                a3.c(i3, i3, i3, i3, 125.0f, 125.0f);
                b.a.w.b.g.b.a a4 = b.a.w.b.g.b.a.a();
                int i4 = R.drawable.new_pic_emotion_08;
                a4.d(i4, i4, i4, i4, 125.0f, 125.0f);
                b.a.w.b.g.b.a.a().e(R.drawable.live_feed_page_place_holder_day, R.drawable.live_feed_page_place_holder_night, R.drawable.live_feed_page_place_holder_dark, R.drawable.live_feed_page_place_holder_day);
                LiveFeedPageSdk.e().j(new c());
                LiveFeedPageSdk.e().h("tieba", b(TbadkCoreApplication.getInst().getSkinType()));
                LiveFeedPageSdk.e().i(new b.a.r0.w.f.d.b());
                LiveFeedPageSdk.e().n();
            }
            LiveFeedPageSdk.e().m(context);
            if (LiveFeedPageSdk.e().f() == null || TextUtils.isEmpty(LiveFeedPageSdk.e().f().b())) {
                return;
            }
            LiveFeedPageSdk.e().o(LiveFeedPageSdk.e().f().b());
        }
    }

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
}
