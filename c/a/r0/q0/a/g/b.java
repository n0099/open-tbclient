package c.a.r0.q0.a.g;

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
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f23617a;

    /* renamed from: b  reason: collision with root package name */
    public int f23618b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaData f23619c;

    /* renamed from: d  reason: collision with root package name */
    public float f23620d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23621e;

    /* renamed from: f  reason: collision with root package name */
    public String f23622f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23623g;

    /* renamed from: h  reason: collision with root package name */
    public Buffer f23624h;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f23625a;

        /* renamed from: b  reason: collision with root package name */
        public int f23626b;

        /* renamed from: c  reason: collision with root package name */
        public MultiMediaData f23627c;

        /* renamed from: d  reason: collision with root package name */
        public List<LocalAlbumInfo> f23628d;

        /* renamed from: e  reason: collision with root package name */
        public float f23629e;

        /* renamed from: f  reason: collision with root package name */
        public String f23630f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f23631g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f23632h;

        /* renamed from: i  reason: collision with root package name */
        public String f23633i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f23634j;
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
            this.f23625a = RecordConstants.VIDEO_CONSTANT_WIDTH;
            this.f23626b = RecordConstants.VIDEO_CONSTANT_HEIGHT;
            this.f23629e = 0.0f;
            this.f23631g = false;
            this.f23632h = false;
            this.f23634j = false;
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
                this.f23626b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a p(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f23634j = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a q(MultiMediaData multiMediaData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, multiMediaData)) == null) {
                this.f23627c = multiMediaData;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a r(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
                this.f23629e = f2;
                return this;
            }
            return (a) invokeF.objValue;
        }

        public a s(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f23633i = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a t(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.f23625a = i2;
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
        this.f23617a = aVar.f23625a;
        this.f23618b = aVar.f23626b;
        this.f23620d = aVar.f23629e;
        String unused = aVar.f23630f;
        this.f23619c = aVar.f23627c;
        List unused2 = aVar.f23628d;
        this.f23621e = aVar.f23631g;
        boolean unused3 = aVar.f23632h;
        this.f23622f = aVar.f23633i;
        this.f23623g = aVar.f23634j;
        this.f23624h = aVar.k;
        long unused4 = aVar.l;
    }
}
