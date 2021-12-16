package c.a.s0.w0.a.g;

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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f25177b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaData f25178c;

    /* renamed from: d  reason: collision with root package name */
    public float f25179d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25180e;

    /* renamed from: f  reason: collision with root package name */
    public String f25181f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25182g;

    /* renamed from: h  reason: collision with root package name */
    public Buffer f25183h;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f25184b;

        /* renamed from: c  reason: collision with root package name */
        public MultiMediaData f25185c;

        /* renamed from: d  reason: collision with root package name */
        public List<LocalAlbumInfo> f25186d;

        /* renamed from: e  reason: collision with root package name */
        public float f25187e;

        /* renamed from: f  reason: collision with root package name */
        public String f25188f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f25189g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f25190h;

        /* renamed from: i  reason: collision with root package name */
        public String f25191i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f25192j;

        /* renamed from: k  reason: collision with root package name */
        public Buffer f25193k;
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
            this.a = RecordConstants.VIDEO_CONSTANT_WIDTH;
            this.f25184b = RecordConstants.VIDEO_CONSTANT_HEIGHT;
            this.f25187e = 0.0f;
            this.f25189g = false;
            this.f25190h = false;
            this.f25192j = false;
        }

        public b m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this) : (b) invokeV.objValue;
        }

        public a n(Buffer buffer) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer)) == null) {
                this.f25193k = buffer;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a o(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f25184b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a p(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f25192j = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a q(MultiMediaData multiMediaData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, multiMediaData)) == null) {
                this.f25185c = multiMediaData;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a r(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
                this.f25187e = f2;
                return this;
            }
            return (a) invokeF.objValue;
        }

        public a s(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f25191i = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a t(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.a = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    public b(a aVar) {
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
        this.a = aVar.a;
        this.f25177b = aVar.f25184b;
        this.f25179d = aVar.f25187e;
        String unused = aVar.f25188f;
        this.f25178c = aVar.f25185c;
        List unused2 = aVar.f25186d;
        this.f25180e = aVar.f25189g;
        boolean unused3 = aVar.f25190h;
        this.f25181f = aVar.f25191i;
        this.f25182g = aVar.f25192j;
        this.f25183h = aVar.f25193k;
        long unused4 = aVar.l;
    }
}
