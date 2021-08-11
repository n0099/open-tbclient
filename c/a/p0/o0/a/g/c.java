package c.a.p0.o0.a.g;

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
    public int f22504a;

    /* renamed from: b  reason: collision with root package name */
    public int f22505b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaData f22506c;

    /* renamed from: d  reason: collision with root package name */
    public float f22507d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22508e;

    /* renamed from: f  reason: collision with root package name */
    public String f22509f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22510g;

    /* renamed from: h  reason: collision with root package name */
    public Buffer f22511h;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f22512a;

        /* renamed from: b  reason: collision with root package name */
        public int f22513b;

        /* renamed from: c  reason: collision with root package name */
        public MultiMediaData f22514c;

        /* renamed from: d  reason: collision with root package name */
        public List<LocalAlbumInfo> f22515d;

        /* renamed from: e  reason: collision with root package name */
        public float f22516e;

        /* renamed from: f  reason: collision with root package name */
        public String f22517f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f22518g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f22519h;

        /* renamed from: i  reason: collision with root package name */
        public String f22520i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f22521j;
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
            this.f22512a = RecordConstants.VIDEO_CONSTANT_WIDTH;
            this.f22513b = RecordConstants.VIDEO_CONSTANT_HEIGHT;
            this.f22516e = 0.0f;
            this.f22518g = false;
            this.f22519h = false;
            this.f22521j = false;
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
                this.f22513b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a p(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f22521j = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a q(MultiMediaData multiMediaData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, multiMediaData)) == null) {
                this.f22514c = multiMediaData;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a r(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
                this.f22516e = f2;
                return this;
            }
            return (a) invokeF.objValue;
        }

        public a s(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f22520i = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a t(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.f22512a = i2;
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
        this.f22504a = aVar.f22512a;
        this.f22505b = aVar.f22513b;
        this.f22507d = aVar.f22516e;
        String unused = aVar.f22517f;
        this.f22506c = aVar.f22514c;
        List unused2 = aVar.f22515d;
        this.f22508e = aVar.f22518g;
        boolean unused3 = aVar.f22519h;
        this.f22509f = aVar.f22520i;
        this.f22510g = aVar.f22521j;
        this.f22511h = aVar.k;
        long unused4 = aVar.l;
    }
}
