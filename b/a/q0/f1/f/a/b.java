package b.a.q0.f1.f.a;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DataSetObservable f12321a;

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
        this.f12321a = new DataSetObservable();
    }

    public abstract int a();

    public abstract View b(int i2, ViewGroup viewGroup);

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f12321a.notifyChanged();
        }
    }

    public void d(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dataSetObserver) == null) {
            try {
                this.f12321a.registerObserver(dataSetObserver);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    public void e(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dataSetObserver) == null) {
            try {
                this.f12321a.unregisterObserver(dataSetObserver);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }
}
