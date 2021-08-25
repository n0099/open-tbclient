package c.a.o0.f.j.m;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import c.a.o0.a.k;
import c.a.o0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.dialog.GamenowRecommendPopView;
import com.baidu.swan.game.guide.view.GameGuideViewContainer;
import com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
@Singleton
@Service
/* loaded from: classes3.dex */
public class d implements c.a.o0.h.t.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements GamenowRecommendPopView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GameCloseGuidePopView.e f10704a;

        public a(d dVar, GameCloseGuidePopView.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10704a = eVar;
        }

        @Override // com.baidu.swan.game.guide.dialog.GamenowRecommendPopView.e
        public void a() {
            GameCloseGuidePopView.e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (eVar = this.f10704a) == null) {
                return;
            }
            eVar.a();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1598616335, "Lc/a/o0/f/j/m/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1598616335, "Lc/a/o0/f/j/m/d;");
                return;
            }
        }
        boolean z = k.f7049a;
    }

    public d() {
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

    @Override // c.a.o0.h.t.c.d
    public View a(Context context, GameCloseGuidePopView.e eVar) {
        InterceptResult invokeLL;
        c.a.o0.f.j.b bVar;
        GameGuideConfigInfo z;
        GameGuideConfigInfo.CloseInfo closeInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, eVar)) == null) {
            if (context == null || (bVar = c.a.o0.f.j.b.o) == null) {
                return null;
            }
            String I = bVar.I();
            if ((!TextUtils.equals(I, c.f10703a) && q0.F(context, I)) || (z = c.a.o0.f.j.b.o.z()) == null || (closeInfo = z.closeInfo) == null) {
                return null;
            }
            int i2 = closeInfo.type;
            ArrayList<GameGuideConfigInfo.RecommendGameInfo> arrayList = closeInfo.gameList;
            if ((i2 != 0 || arrayList == null || arrayList.size() < 3) && ((i2 != 1 || arrayList == null || arrayList.size() < 6) && i2 != 2)) {
                return null;
            }
            if (i2 == 0 || i2 == 1) {
                c.a.o0.f.j.r.b.n().c("gbBDialogShow");
            } else if (i2 == 2) {
                c.a.o0.f.j.r.b.n().c("gbADialogShow");
            }
            GamenowRecommendPopView gamenowRecommendPopView = new GamenowRecommendPopView(context, closeInfo);
            gamenowRecommendPopView.setOnClickListener(new a(this, eVar));
            return gamenowRecommendPopView;
        }
        return (View) invokeLL.objValue;
    }

    @Override // c.a.o0.h.t.c.d
    public void b(int i2) {
        c.a.o0.f.j.b bVar;
        GameGuideViewContainer B;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (bVar = c.a.o0.f.j.b.o) == null || (B = bVar.B()) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) B.getLayoutParams();
        layoutParams.rightMargin = i2;
        B.setLayoutParams(layoutParams);
    }

    @Override // c.a.o0.h.t.c.d
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.o0.f.j.n.c.n().u();
        }
    }
}
