package c.a.u0.q2.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.newinterest.fragment.BaseInterestSelectionFragment;
import com.baidu.tieba.newinterest.model.InterestSelectionStyleAModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c<V> implements c.a.u0.q2.f.a<V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InterestSelectionStyleAModel a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.u0.q2.a.a f21391b;

    /* renamed from: c  reason: collision with root package name */
    public BaseInterestSelectionFragment f21392c;

    public c(BaseInterestSelectionFragment baseInterestSelectionFragment, c.a.u0.q2.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseInterestSelectionFragment, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21392c = baseInterestSelectionFragment;
        this.f21391b = aVar;
        this.a = new InterestSelectionStyleAModel(aVar, this);
    }

    @Override // c.a.u0.q2.f.a
    public void a(V v) {
        BaseInterestSelectionFragment baseInterestSelectionFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, v) == null) || (baseInterestSelectionFragment = this.f21392c) == null) {
            return;
        }
        baseInterestSelectionFragment.onDataRes();
    }

    public void b() {
        InterestSelectionStyleAModel interestSelectionStyleAModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (interestSelectionStyleAModel = this.a) == null) {
            return;
        }
        interestSelectionStyleAModel.onDestroy();
    }

    public void c() {
        InterestSelectionStyleAModel interestSelectionStyleAModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (interestSelectionStyleAModel = this.a) == null) {
            return;
        }
        interestSelectionStyleAModel.B();
    }

    @Override // c.a.u0.q2.f.a
    public void onError(int i2, String str) {
        BaseInterestSelectionFragment baseInterestSelectionFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) || (baseInterestSelectionFragment = this.f21392c) == null) {
            return;
        }
        baseInterestSelectionFragment.onError(str);
    }
}
