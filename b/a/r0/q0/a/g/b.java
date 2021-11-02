package b.a.r0.q0.a.g;

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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f22511a;

    /* renamed from: b  reason: collision with root package name */
    public int f22512b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaData f22513c;

    /* renamed from: d  reason: collision with root package name */
    public float f22514d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22515e;

    /* renamed from: f  reason: collision with root package name */
    public String f22516f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22517g;

    /* renamed from: h  reason: collision with root package name */
    public Buffer f22518h;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f22519a;

        /* renamed from: b  reason: collision with root package name */
        public int f22520b;

        /* renamed from: c  reason: collision with root package name */
        public MultiMediaData f22521c;

        /* renamed from: d  reason: collision with root package name */
        public List<LocalAlbumInfo> f22522d;

        /* renamed from: e  reason: collision with root package name */
        public float f22523e;

        /* renamed from: f  reason: collision with root package name */
        public String f22524f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f22525g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f22526h;

        /* renamed from: i  reason: collision with root package name */
        public String f22527i;
        public boolean j;
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
            this.f22519a = RecordConstants.VIDEO_CONSTANT_WIDTH;
            this.f22520b = RecordConstants.VIDEO_CONSTANT_HEIGHT;
            this.f22523e = 0.0f;
            this.f22525g = false;
            this.f22526h = false;
            this.j = false;
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
                this.k = buffer;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a o(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f22520b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a p(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.j = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a q(MultiMediaData multiMediaData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, multiMediaData)) == null) {
                this.f22521c = multiMediaData;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a r(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
                this.f22523e = f2;
                return this;
            }
            return (a) invokeF.objValue;
        }

        public a s(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f22527i = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a t(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.f22519a = i2;
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
        this.f22511a = aVar.f22519a;
        this.f22512b = aVar.f22520b;
        this.f22514d = aVar.f22523e;
        String unused = aVar.f22524f;
        this.f22513c = aVar.f22521c;
        List unused2 = aVar.f22522d;
        this.f22515e = aVar.f22525g;
        boolean unused3 = aVar.f22526h;
        this.f22516f = aVar.f22527i;
        this.f22517g = aVar.j;
        this.f22518h = aVar.k;
        long unused4 = aVar.l;
    }
}
