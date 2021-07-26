package a.a.a.a.v.g;

import a.a.a.a.v.f;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a implements f.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f1403a;

    public a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1403a = cVar;
    }

    @Override // a.a.a.a.v.f.b
    public void a(@Nullable NetworkInfo networkInfo) {
        c cVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, networkInfo) == null) {
            if (networkInfo == null) {
                this.f1403a.f1407d = "unknow";
                return;
            }
            if (networkInfo.isConnectedOrConnecting()) {
                String subtypeName = networkInfo.getSubtypeName();
                if (!TextUtils.isEmpty(subtypeName)) {
                    this.f1403a.f1407d = subtypeName;
                    return;
                } else {
                    cVar = this.f1403a;
                    str = networkInfo.getTypeName();
                }
            } else {
                cVar = this.f1403a;
                str = "unknow";
            }
            cVar.f1407d = str;
        }
    }
}
