package c.a.q0.i2.k.e.z0.g;

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
    public Handler f19818a;

    /* renamed from: b  reason: collision with root package name */
    public SearchEmotionModel f19819b;

    /* renamed from: c  reason: collision with root package name */
    public String f19820c;

    /* renamed from: d  reason: collision with root package name */
    public SearchEmotionModel.b f19821d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f19822e;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19823e;

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
            this.f19823e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f19823e.f19820c) || this.f19823e.f19821d == null) {
                return;
            }
            if (this.f19823e.f19819b == null) {
                this.f19823e.f19819b = new SearchEmotionModel();
            }
            this.f19823e.f19819b.x(this.f19823e.f19820c, 0, 30, this.f19823e.f19821d);
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
        this.f19822e = new a(this);
        this.f19818a = new Handler();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SearchEmotionModel searchEmotionModel = this.f19819b;
            if (searchEmotionModel != null) {
                searchEmotionModel.cancelLoadData();
            }
            this.f19818a.removeCallbacks(this.f19822e);
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f19820c = "";
                return;
            }
            this.f19818a.removeCallbacks(this.f19822e);
            this.f19818a.postDelayed(this.f19822e, 300L);
            this.f19820c = str;
        }
    }

    public void g(SearchEmotionModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f19821d = bVar;
        }
    }
}
