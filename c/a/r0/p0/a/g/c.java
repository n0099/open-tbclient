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
    public int f23442a;

    /* renamed from: b  reason: collision with root package name */
    public int f23443b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaData f23444c;

    /* renamed from: d  reason: collision with root package name */
    public float f23445d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23446e;

    /* renamed from: f  reason: collision with root package name */
    public String f23447f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23448g;

    /* renamed from: h  reason: collision with root package name */
    public Buffer f23449h;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f23450a;

        /* renamed from: b  reason: collision with root package name */
        public int f23451b;

        /* renamed from: c  reason: collision with root package name */
        public MultiMediaData f23452c;

        /* renamed from: d  reason: collision with root package name */
        public List<LocalAlbumInfo> f23453d;

        /* renamed from: e  reason: collision with root package name */
        public float f23454e;

        /* renamed from: f  reason: collision with root package name */
        public String f23455f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f23456g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f23457h;

        /* renamed from: i  reason: collision with root package name */
        public String f23458i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f23459j;
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
            this.f23450a = RecordConstants.VIDEO_CONSTANT_WIDTH;
            this.f23451b = RecordConstants.VIDEO_CONSTANT_HEIGHT;
            this.f23454e = 0.0f;
            this.f23456g = false;
            this.f23457h = false;
            this.f23459j = false;
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
                this.f23451b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a p(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f23459j = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a q(MultiMediaData multiMediaData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, multiMediaData)) == null) {
                this.f23452c = multiMediaData;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a r(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
                this.f23454e = f2;
                return this;
            }
            return (a) invokeF.objValue;
        }

        public a s(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f23458i = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a t(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.f23450a = i2;
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
        this.f23442a = aVar.f23450a;
        this.f23443b = aVar.f23451b;
        this.f23445d = aVar.f23454e;
        String unused = aVar.f23455f;
        this.f23444c = aVar.f23452c;
        List unused2 = aVar.f23453d;
        this.f23446e = aVar.f23456g;
        boolean unused3 = aVar.f23457h;
        this.f23447f = aVar.f23458i;
        this.f23448g = aVar.f23459j;
        this.f23449h = aVar.k;
        long unused4 = aVar.l;
    }
}
