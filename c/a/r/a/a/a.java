package c.a.r.a.a;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Call;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.support.okhttp.converters.ResponseConverter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class a implements Call {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public Request f14114e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public okhttp3.Request f14115f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public OkHttpClient f14116g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public okhttp3.Call f14117h;

    /* renamed from: c.a.r.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0906a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ com.baidu.searchbox.network.outback.core.Callback a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f14118b;

        public C0906a(a aVar, com.baidu.searchbox.network.outback.core.Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14118b = aVar;
            this.a = callback;
        }

        @Override // okhttp3.Callback
        public void onFailure(okhttp3.Call call, IOException iOException) {
            com.baidu.searchbox.network.outback.core.Callback callback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) || (callback = this.a) == null) {
                return;
            }
            callback.onFailure(this.f14118b, iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(okhttp3.Call call, Response response) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                com.baidu.searchbox.network.outback.core.Response fromOks = ResponseConverter.fromOks(this.f14118b.f14114e, response);
                if (fromOks.getStatRecord() != null) {
                    fromOks.getStatRecord().finishTs = System.currentTimeMillis();
                }
                com.baidu.searchbox.network.outback.core.Callback callback = this.a;
                if (callback != null) {
                    callback.onResponse(this.f14118b, fromOks);
                }
            }
        }
    }

    public a(@NonNull Request request, @NonNull okhttp3.Request request2, @NonNull OkHttpClient okHttpClient) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {request, request2, okHttpClient};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14114e = request;
        this.f14115f = request2;
        this.f14116g = okHttpClient;
        this.f14117h = okHttpClient.newCall(request2);
    }

    @Override // com.baidu.searchbox.network.outback.core.Call
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f14117h.cancel();
        }
    }

    @Override // com.baidu.searchbox.network.outback.core.Call
    public void enqueue(com.baidu.searchbox.network.outback.core.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, callback) == null) {
            this.f14114e.getNetworkStatRecord().startTs = System.currentTimeMillis();
            this.f14117h.enqueue(new C0906a(this, callback));
        }
    }

    @Override // com.baidu.searchbox.network.outback.core.Call
    public com.baidu.searchbox.network.outback.core.Response execute() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.f14114e.getNetworkStatRecord().startTs = System.currentTimeMillis();
            com.baidu.searchbox.network.outback.core.Response fromOks = ResponseConverter.fromOks(this.f14114e, this.f14117h.execute());
            if (fromOks.getStatRecord() != null) {
                fromOks.getStatRecord().finishTs = System.currentTimeMillis();
            }
            return fromOks;
        }
        return (com.baidu.searchbox.network.outback.core.Response) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.Call
    public boolean isCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14117h.isCanceled() : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.Call
    public boolean isExecuted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14117h.isExecuted() : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.Call
    public Request request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f14114e : (Request) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.network.outback.core.Call
    public Call clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this.f14114e, this.f14115f, this.f14116g) : (Call) invokeV.objValue;
    }
}
