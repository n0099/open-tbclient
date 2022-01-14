package c.a.t0.x2.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25346e;

    public e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25346e = z;
    }

    public PersonStatus h(UserData userData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, userData)) == null) {
            if (userData == null) {
                if (this.f25346e) {
                    return PersonStatus.HOST_DEFAULT;
                }
                return PersonStatus.GUEST_DEFAULT;
            } else if (userData.isBaijiahaoUser()) {
                if (this.f25346e) {
                    return PersonStatus.HOST_BJH;
                }
                return PersonStatus.GUEST_BJH;
            } else if (this.f25346e) {
                return PersonStatus.HOST_DEFAULT;
            } else {
                return PersonStatus.GUEST_DEFAULT;
            }
        }
        return (PersonStatus) invokeL.objValue;
    }

    public PersonStatus i(c.a.t0.x2.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (aVar != null && aVar.j() != null) {
                return h(aVar.j());
            }
            if (this.f25346e) {
                return PersonStatus.HOST_DEFAULT;
            }
            return PersonStatus.GUEST_DEFAULT;
        }
        return (PersonStatus) invokeL.objValue;
    }
}
