package c.a.p0.i0.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class a<T> extends b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public String f13539f;

    /* renamed from: g  reason: collision with root package name */
    public Class<T> f13540g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int i2, String str, Class<T> cls) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13539f = str;
        this.f13540g = cls;
    }

    public T a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return this.f13540g.newInstance();
            } catch (ExceptionInInitializerError e2) {
                e2.printStackTrace();
                return null;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return null;
            } catch (InstantiationException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return (T) invokeV.objValue;
    }
}
