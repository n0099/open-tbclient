package c.a.b0.s.b0;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import c.a.b0.h0.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class j extends o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f1886e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1886e = jVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1886e.t();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1935115013, "Lc/a/b0/s/b0/j;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1935115013, "Lc/a/b0/s/b0/j;");
        }
    }

    public j() {
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

    @Override // c.a.b0.s.b0.o
    public void A() {
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f1898g.bottomMargin = c.a.b0.e0.a.d.b.b(10.0f);
            FrameLayout.LayoutParams layoutParams = this.f1898g;
            if (n().V()) {
                b2 = c.a.b0.e0.a.d.b.b(45.0f);
            } else {
                b2 = c.a.b0.e0.a.d.b.b(15.0f);
            }
            layoutParams.leftMargin = b2;
            TextView mNextTips = this.f1897f;
            Intrinsics.checkNotNullExpressionValue(mNextTips, "mNextTips");
            mNextTips.setLayoutParams(this.f1898g);
        }
    }

    @Override // c.a.b0.s.b0.o
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f1898g.bottomMargin = c.a.b0.e0.a.d.b.b(45.0f);
            this.f1898g.leftMargin = c.a.b0.e0.a.d.b.b(15.0f);
            TextView mNextTips = this.f1897f;
            Intrinsics.checkNotNullExpressionValue(mNextTips, "mNextTips");
            mNextTips.setLayoutParams(this.f1898g);
        }
    }

    @Override // c.a.b0.s.b0.o, c.a.b0.s.b0.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TextView textView = new TextView(getContext());
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            textView.setTextSize(0, context.getResources().getDimension(c.a.b0.h0.p.nad_videoplayer_immersive_video_next_text_size));
            textView.setTextColor(-1);
            textView.setBackground(ContextCompat.getDrawable(textView.getContext(), q.nad_videoplayer_next_play_tips_background));
            textView.setGravity(16);
            textView.setAlpha(0.0f);
            textView.setMaxEms(18);
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setIncludeFontPadding(false);
            textView.setPadding(c.a.b0.e0.a.d.b.b(13.0f), 0, c.a.b0.e0.a.d.b.b(13.0f), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, c.a.b0.e0.a.d.b.b(24.0f));
            this.f1898g = layoutParams;
            layoutParams.gravity = BadgeDrawable.BOTTOM_START;
            layoutParams.leftMargin = c.a.b0.e0.a.d.b.b(15.0f);
            textView.setLayoutParams(this.f1898g);
            Unit unit = Unit.INSTANCE;
            this.f1897f = textView;
            u();
        }
    }

    @Override // c.a.b0.s.b0.o, c.a.b0.s.b0.a
    public void h(c.a.b0.s.c0.p event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            String c2 = event.c();
            switch (c2.hashCode()) {
                case -1327414233:
                    if (c2.equals(LayerEvent.ACTION_OPTIMIZE_CONTINUE_TIPS_SHOW)) {
                        if (n().r1()) {
                            return;
                        }
                        Object f2 = event.f(24);
                        if (!(f2 instanceof String)) {
                            f2 = null;
                        }
                        String str = (String) f2;
                        if (str == null) {
                            str = "";
                        }
                        TextView mNextTips = this.f1897f;
                        Intrinsics.checkNotNullExpressionValue(mNextTips, "mNextTips");
                        mNextTips.setText(str);
                        if (this.f1899h) {
                            B();
                        } else {
                            A();
                        }
                        if (v()) {
                            return;
                        }
                        C();
                        return;
                    }
                    break;
                case -552621273:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        t();
                        return;
                    }
                    break;
                case -552580917:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        x(false);
                        return;
                    }
                    break;
                case 1933234291:
                    if (c2.equals(ControlEvent.ACTION_CONTINUE_TIPS_SHOW)) {
                        return;
                    }
                    break;
            }
            super.h(event);
        }
    }

    @Override // c.a.b0.s.b0.o
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f1897f.postDelayed(new a(this), 5000L);
        }
    }
}
