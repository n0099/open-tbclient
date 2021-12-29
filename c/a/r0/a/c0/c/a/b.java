package c.a.r0.a.c0.c.a;

import android.animation.Animator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.d2.e;
import c.a.r0.a.e0.d;
import c.a.r0.a.n2.c;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b extends c.a.r0.a.c0.a.d.a<LottieAnimationView, c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public String f5428i;

    /* loaded from: classes.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5429e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f5430f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f5431g;

        public a(b bVar, c cVar, JSONObject jSONObject, LottieAnimationView lottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, jSONObject, lottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5429e = cVar;
            this.f5430f = jSONObject;
            this.f5431g = lottieAnimationView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                c cVar = this.f5429e;
                c.a.r0.a.a3.g.c.a.d(cVar.f5422g, cVar.f5421f, "animateview", "ended", this.f5430f);
                d.i("Component-AnimationView", "progress: " + this.f5431g.getProgress());
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                d.i("Component-AnimationView", "onAnimationRepeat ");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@Nullable Context context, @NonNull c cVar, @NonNull String str) {
        super(context, cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (c.a.r0.a.c0.a.d.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5428i = str;
    }

    public static void Z(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("json", str);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str2);
            } catch (Exception e2) {
                if (c.a.r0.a.c0.b.a.f5409h) {
                    e2.printStackTrace();
                }
            }
            String jSONObject2 = jSONObject.toString();
            if (c.a.r0.a.c0.b.a.f5409h && TextUtils.isEmpty(jSONObject2)) {
                return;
            }
            if (c.a.r0.a.c0.b.a.f5409h) {
                String str3 = "reportLottieAnimationCrash: " + jSONObject2;
            }
            c.b bVar = new c.b(10009);
            bVar.i(jSONObject2);
            bVar.h(e.f0());
            bVar.m();
        }
    }

    public final void S(@NonNull LottieAnimationView lottieAnimationView, @NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, lottieAnimationView, cVar) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, cVar.f5422g);
                jSONObject.put("vtype", "ended");
                jSONObject2.putOpt("animationViewId", cVar.f5421f);
                jSONObject.put("data", jSONObject2.toString());
            } catch (JSONException e2) {
                if (c.a.r0.a.c0.b.a.f5409h) {
                    e2.printStackTrace();
                }
            }
            lottieAnimationView.addAnimatorListener(new a(this, cVar, jSONObject, lottieAnimationView));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.c0.b.a
    @NonNull
    /* renamed from: T */
    public LottieAnimationView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) ? new LottieAnimationView(context) : (LottieAnimationView) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.c0.b.a
    /* renamed from: U */
    public void A(@NonNull LottieAnimationView lottieAnimationView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lottieAnimationView) == null) {
            super.A(lottieAnimationView);
            try {
                c cVar = (c) n();
                lottieAnimationView.loop(cVar.y);
                lottieAnimationView.enableMergePathsForKitKatAndAbove(true);
                lottieAnimationView.setImageAssetDelegate(new c.a.r0.a.c0.c.a.a(cVar.x));
                lottieAnimationView.setAnimationFromJson(this.f5428i, cVar.f5421f);
                if (cVar.z) {
                    lottieAnimationView.playAnimation();
                }
                if (cVar.y) {
                    return;
                }
                S(lottieAnimationView, cVar);
            } catch (Exception unused) {
                Z(this.f5428i, e.f0());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.c0.a.d.a
    /* renamed from: V */
    public void O(@NonNull LottieAnimationView lottieAnimationView, @NonNull c cVar, @NonNull c.a.r0.a.c0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lottieAnimationView, cVar, bVar) == null) {
            super.C(lottieAnimationView, cVar, bVar);
            W(lottieAnimationView, cVar);
        }
    }

    public final void W(@NonNull LottieAnimationView lottieAnimationView, @NonNull c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, lottieAnimationView, cVar) == null) && t()) {
            boolean z = c.a.r0.a.c0.b.a.f5409h;
            String str = cVar.A;
            if (TextUtils.equals(str, "play")) {
                lottieAnimationView.resumeAnimation();
            } else if (TextUtils.equals(str, "pause")) {
                lottieAnimationView.pauseAnimation();
            } else if (TextUtils.equals(str, IntentConfig.STOP)) {
                lottieAnimationView.cancelAnimation();
                lottieAnimationView.setProgress(0.0f);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.c0.a.d.a
    /* renamed from: X */
    public void Q(@NonNull LottieAnimationView lottieAnimationView, @NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, lottieAnimationView, cVar) == null) {
            boolean z = c.a.r0.a.c0.b.a.f5409h;
            lottieAnimationView.setColorFilter(new PorterDuffColorFilter(cVar.o, PorterDuff.Mode.ADD));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.c0.a.d.a
    /* renamed from: Y */
    public void R(@NonNull LottieAnimationView lottieAnimationView, @NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, lottieAnimationView, cVar) == null) {
        }
    }
}
