package b.a.f0.a.c;

import android.animation.Animator;
import android.text.TextUtils;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements LottieListener<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f2782a;

        public a(b bVar, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2782a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, th) == null) || (fVar = this.f2782a) == null) {
                return;
            }
            fVar.b();
        }
    }

    /* renamed from: b.a.f0.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0065b implements LottieListener<LottieComposition> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f2783a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f2784b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f2785c;

        /* renamed from: b.a.f0.a.c.b$b$a */
        /* loaded from: classes.dex */
        public class a implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0065b f2786e;

            public a(C0065b c0065b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0065b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f2786e = c0065b;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Animator.AnimatorListener animatorListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || (animatorListener = this.f2786e.f2785c) == null) {
                    return;
                }
                animatorListener.onAnimationCancel(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Animator.AnimatorListener animatorListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || (animatorListener = this.f2786e.f2785c) == null) {
                    return;
                }
                animatorListener.onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Animator.AnimatorListener animatorListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) || (animatorListener = this.f2786e.f2785c) == null) {
                    return;
                }
                animatorListener.onAnimationRepeat(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Animator.AnimatorListener animatorListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, animator) == null) || (animatorListener = this.f2786e.f2785c) == null) {
                    return;
                }
                animatorListener.onAnimationStart(animator);
            }
        }

        public C0065b(b bVar, f fVar, LottieAnimationView lottieAnimationView, Animator.AnimatorListener animatorListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, fVar, lottieAnimationView, animatorListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2783a = fVar;
            this.f2784b = lottieAnimationView;
            this.f2785c = animatorListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) || lottieComposition == null) {
                return;
            }
            f fVar = this.f2783a;
            if (fVar != null) {
                fVar.a();
            }
            this.f2784b.setVisibility(0);
            this.f2784b.setComposition(lottieComposition);
            this.f2784b.playAnimation();
            this.f2784b.addAnimatorListener(new a(this));
        }
    }

    /* loaded from: classes.dex */
    public class c implements LottieListener<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f2787a;

        public c(b bVar, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2787a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, th) == null) || (fVar = this.f2787a) == null) {
                return;
            }
            fVar.b();
        }
    }

    /* loaded from: classes.dex */
    public class d implements LottieListener<LottieComposition> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f2788a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f2789b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f2790c;

        /* loaded from: classes.dex */
        public class a implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f2791e;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f2791e = dVar;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Animator.AnimatorListener animatorListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || (animatorListener = this.f2791e.f2790c) == null) {
                    return;
                }
                animatorListener.onAnimationCancel(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Animator.AnimatorListener animatorListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || (animatorListener = this.f2791e.f2790c) == null) {
                    return;
                }
                animatorListener.onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Animator.AnimatorListener animatorListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) || (animatorListener = this.f2791e.f2790c) == null) {
                    return;
                }
                animatorListener.onAnimationRepeat(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Animator.AnimatorListener animatorListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, animator) == null) || (animatorListener = this.f2791e.f2790c) == null) {
                    return;
                }
                animatorListener.onAnimationStart(animator);
            }
        }

        public d(b bVar, f fVar, LottieAnimationView lottieAnimationView, Animator.AnimatorListener animatorListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, fVar, lottieAnimationView, animatorListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2788a = fVar;
            this.f2789b = lottieAnimationView;
            this.f2790c = animatorListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) || lottieComposition == null) {
                return;
            }
            f fVar = this.f2788a;
            if (fVar != null) {
                fVar.a();
            }
            this.f2789b.setVisibility(0);
            this.f2789b.setComposition(lottieComposition);
            this.f2789b.playAnimation();
            this.f2789b.addAnimatorListener(new a(this));
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static b f2792a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1241101808, "Lb/a/f0/a/c/b$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1241101808, "Lb/a/f0/a/c/b$e;");
                    return;
                }
            }
            f2792a = new b(null);
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a();

        void b();
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? e.f2792a : (b) invokeV.objValue;
    }

    public void a(File file, LottieAnimationView lottieAnimationView, Animator.AnimatorListener animatorListener, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, file, lottieAnimationView, animatorListener, fVar) == null) || file == null || !file.exists() || lottieAnimationView == null) {
            return;
        }
        try {
            LottieCompositionFactory.fromZipStream(new ZipInputStream(new FileInputStream(file.getPath())), null).addListener(new C0065b(this, fVar, lottieAnimationView, animatorListener)).addFailureListener(new a(this, fVar));
        } catch (Exception unused) {
            lottieAnimationView.setVisibility(8);
            if (fVar != null) {
                fVar.b();
            }
        }
    }

    public void b(String str, LottieAnimationView lottieAnimationView, Animator.AnimatorListener animatorListener, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, lottieAnimationView, animatorListener, fVar) == null) || TextUtils.isEmpty(str) || lottieAnimationView == null) {
            return;
        }
        File o = b.a.f0.b.g.f.o(str);
        if (o != null && o.exists()) {
            a(o, lottieAnimationView, animatorListener, fVar);
            return;
        }
        try {
            LottieCompositionFactory.fromUrl(b.a.f0.a.b.a.f2781a.get().o(), str).addListener(new d(this, fVar, lottieAnimationView, animatorListener)).addFailureListener(new c(this, fVar));
        } catch (Exception unused) {
            lottieAnimationView.setVisibility(8);
            if (fVar != null) {
                fVar.b();
            }
        }
    }

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
}
