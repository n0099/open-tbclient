package c.a.s0.s.v;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.feedManager.FeedRecModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f13851d;
    public transient /* synthetic */ FieldHolder $fh;
    public FeedRecModel a;

    /* renamed from: b  reason: collision with root package name */
    public DataRes f13852b;

    /* renamed from: c  reason: collision with root package name */
    public FeedRecModel.b f13853c;

    /* renamed from: c.a.s0.s.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0897a implements FeedRecModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0897a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void a(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a.f13852b = dataRes;
            }
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.a.f13852b = null;
            }
        }
    }

    public a() {
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
        this.f13853c = new C0897a(this);
        FeedRecModel feedRecModel = new FeedRecModel();
        this.a = feedRecModel;
        feedRecModel.z(this.f13853c);
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f13851d == null) {
                synchronized (a.class) {
                    if (f13851d == null) {
                        f13851d = new a();
                    }
                }
            }
            return f13851d;
        }
        return (a) invokeV.objValue;
    }

    public DataRes c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13852b : (DataRes) invokeV.objValue;
    }
}
