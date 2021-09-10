package c.a.r0.p0.a.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.bean.LocalAlbumInfo;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.RecordConstants;
import java.nio.Buffer;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f23426a;

    /* renamed from: b  reason: collision with root package name */
    public int f23427b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaData f23428c;

    /* renamed from: d  reason: collision with root package name */
    public float f23429d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23430e;

    /* renamed from: f  reason: collision with root package name */
    public String f23431f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23432g;

    /* renamed from: h  reason: collision with root package name */
    public Buffer f23433h;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f23434a;

        /* renamed from: b  reason: collision with root package name */
        public int f23435b;

        /* renamed from: c  reason: collision with root package name */
        public MultiMediaData f23436c;

        /* renamed from: d  reason: collision with root package name */
        public List<LocalAlbumInfo> f23437d;

        /* renamed from: e  reason: collision with root package name */
        public float f23438e;

        /* renamed from: f  reason: collision with root package name */
        public String f23439f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f23440g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f23441h;

        /* renamed from: i  reason: collision with root package name */
        public String f23442i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f23443j;
        public Buffer k;
        public long l;

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
            this.f23434a = RecordConstants.VIDEO_CONSTANT_WIDTH;
            this.f23435b = RecordConstants.VIDEO_CONSTANT_HEIGHT;
            this.f23438e = 0.0f;
            this.f23440g = false;
            this.f23441h = false;
            this.f23443j = false;
        }

        public c m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c(this) : (c) invokeV.objValue;
        }

        public a n(Buffer buffer) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer)) == null) {
                this.k = buffer;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a o(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f23435b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a p(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f23443j = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a q(MultiMediaData multiMediaData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, multiMediaData)) == null) {
                this.f23436c = multiMediaData;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a r(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
                this.f23438e = f2;
                return this;
            }
            return (a) invokeF.objValue;
        }

        public a s(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f23442i = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a t(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.f23434a = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    public c(a aVar) {
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
        this.f23426a = aVar.f23434a;
        this.f23427b = aVar.f23435b;
        this.f23429d = aVar.f23438e;
        String unused = aVar.f23439f;
        this.f23428c = aVar.f23436c;
        List unused2 = aVar.f23437d;
        this.f23430e = aVar.f23440g;
        boolean unused3 = aVar.f23441h;
        this.f23431f = aVar.f23442i;
        this.f23432g = aVar.f23443j;
        this.f23433h = aVar.k;
        long unused4 = aVar.l;
    }
}
