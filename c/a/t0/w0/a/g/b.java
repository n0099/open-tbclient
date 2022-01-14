package c.a.t0.w0.a.g;

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
    public int f24664b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaData f24665c;

    /* renamed from: d  reason: collision with root package name */
    public float f24666d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24667e;

    /* renamed from: f  reason: collision with root package name */
    public String f24668f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24669g;

    /* renamed from: h  reason: collision with root package name */
    public Buffer f24670h;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f24671b;

        /* renamed from: c  reason: collision with root package name */
        public MultiMediaData f24672c;

        /* renamed from: d  reason: collision with root package name */
        public List<LocalAlbumInfo> f24673d;

        /* renamed from: e  reason: collision with root package name */
        public float f24674e;

        /* renamed from: f  reason: collision with root package name */
        public String f24675f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f24676g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f24677h;

        /* renamed from: i  reason: collision with root package name */
        public String f24678i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f24679j;
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
            this.a = RecordConstants.VIDEO_CONSTANT_WIDTH;
            this.f24671b = RecordConstants.VIDEO_CONSTANT_HEIGHT;
            this.f24674e = 0.0f;
            this.f24676g = false;
            this.f24677h = false;
            this.f24679j = false;
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
                this.f24671b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a p(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f24679j = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a q(MultiMediaData multiMediaData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, multiMediaData)) == null) {
                this.f24672c = multiMediaData;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a r(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
                this.f24674e = f2;
                return this;
            }
            return (a) invokeF.objValue;
        }

        public a s(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f24678i = str;
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
        this.f24664b = aVar.f24671b;
        this.f24666d = aVar.f24674e;
        String unused = aVar.f24675f;
        this.f24665c = aVar.f24672c;
        List unused2 = aVar.f24673d;
        this.f24667e = aVar.f24676g;
        boolean unused3 = aVar.f24677h;
        this.f24668f = aVar.f24678i;
        this.f24669g = aVar.f24679j;
        this.f24670h = aVar.k;
        long unused4 = aVar.l;
    }
}
