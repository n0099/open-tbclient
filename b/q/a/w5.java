package b.q.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
import com.win.opensdk.PBNativeListener;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class w5 implements e5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f33552a;

    public w5(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33552a = lVar;
    }

    @Override // b.q.a.e5
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // b.q.a.e5
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            Info info = (Info) obj;
            try {
                this.f33552a.f33377c = info;
                if (this.f33552a.f33380f != null) {
                    if (info == null || info.getType() != 11) {
                        this.f33552a.f33380f.onFail(PBError.PID_TYPE_ERROR);
                    } else if (this.f33552a.g()) {
                        this.f33552a.f33380f.onLoaded();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // b.q.a.e5
    public void onFail(PBError pBError) {
        PBNativeListener pBNativeListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBError) == null) || (pBNativeListener = this.f33552a.f33380f) == null) {
            return;
        }
        pBNativeListener.onFail(pBError);
    }
}
