package c.a.r0.k2.k.e.b1.g;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f20121a;

    /* renamed from: b  reason: collision with root package name */
    public SearchEmotionModel f20122b;

    /* renamed from: c  reason: collision with root package name */
    public String f20123c;

    /* renamed from: d  reason: collision with root package name */
    public SearchEmotionModel.b f20124d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f20125e;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20126e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20126e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f20126e.f20123c) || this.f20126e.f20124d == null) {
                return;
            }
            if (this.f20126e.f20122b == null) {
                this.f20126e.f20122b = new SearchEmotionModel();
            }
            this.f20126e.f20122b.x(this.f20126e.f20123c, 0, 30, this.f20126e.f20124d);
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
                return;
            }
        }
        this.f20125e = new a(this);
        this.f20121a = new Handler();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SearchEmotionModel searchEmotionModel = this.f20122b;
            if (searchEmotionModel != null) {
                searchEmotionModel.cancelLoadData();
            }
            this.f20121a.removeCallbacks(this.f20125e);
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f20123c = "";
                return;
            }
            this.f20121a.removeCallbacks(this.f20125e);
            this.f20121a.postDelayed(this.f20125e, 300L);
            this.f20123c = str;
        }
    }

    public void g(SearchEmotionModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f20124d = bVar;
        }
    }
}
