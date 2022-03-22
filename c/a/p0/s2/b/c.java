package c.a.p0.s2.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.newinterest.fragment.BaseInterestSelectionFragment;
import com.baidu.tieba.newinterest.model.InterestSelectionStyleAModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c<V> implements c.a.p0.s2.f.a<V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InterestSelectionStyleAModel a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.s2.a.a f18223b;

    /* renamed from: c  reason: collision with root package name */
    public BaseInterestSelectionFragment f18224c;

    public c(BaseInterestSelectionFragment baseInterestSelectionFragment, c.a.p0.s2.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseInterestSelectionFragment, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18224c = baseInterestSelectionFragment;
        this.f18223b = aVar;
        this.a = new InterestSelectionStyleAModel(aVar, this);
    }

    @Override // c.a.p0.s2.f.a
    public void a(V v) {
        BaseInterestSelectionFragment baseInterestSelectionFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, v) == null) || (baseInterestSelectionFragment = this.f18224c) == null) {
            return;
        }
        baseInterestSelectionFragment.D0();
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
        interestSelectionStyleAModel.D();
    }

    @Override // c.a.p0.s2.f.a
    public void onError(int i, String str) {
        BaseInterestSelectionFragment baseInterestSelectionFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) || (baseInterestSelectionFragment = this.f18224c) == null) {
            return;
        }
        baseInterestSelectionFragment.E0(str);
    }
}
