package c.a.r0.w0.a.g;

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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f24986b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaData f24987c;

    /* renamed from: d  reason: collision with root package name */
    public float f24988d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24989e;

    /* renamed from: f  reason: collision with root package name */
    public String f24990f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24991g;

    /* renamed from: h  reason: collision with root package name */
    public Buffer f24992h;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f24993b;

        /* renamed from: c  reason: collision with root package name */
        public MultiMediaData f24994c;

        /* renamed from: d  reason: collision with root package name */
        public List<LocalAlbumInfo> f24995d;

        /* renamed from: e  reason: collision with root package name */
        public float f24996e;

        /* renamed from: f  reason: collision with root package name */
        public String f24997f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f24998g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f24999h;

        /* renamed from: i  reason: collision with root package name */
        public String f25000i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f25001j;

        /* renamed from: k  reason: collision with root package name */
        public Buffer f25002k;
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
            this.f24993b = RecordConstants.VIDEO_CONSTANT_HEIGHT;
            this.f24996e = 0.0f;
            this.f24998g = false;
            this.f24999h = false;
            this.f25001j = false;
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
                this.f25002k = buffer;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a o(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f24993b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a p(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f25001j = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a q(MultiMediaData multiMediaData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, multiMediaData)) == null) {
                this.f24994c = multiMediaData;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a r(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
                this.f24996e = f2;
                return this;
            }
            return (a) invokeF.objValue;
        }

        public a s(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f25000i = str;
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
        this.f24986b = aVar.f24993b;
        this.f24988d = aVar.f24996e;
        String unused = aVar.f24997f;
        this.f24987c = aVar.f24994c;
        List unused2 = aVar.f24995d;
        this.f24989e = aVar.f24998g;
        boolean unused3 = aVar.f24999h;
        this.f24990f = aVar.f25000i;
        this.f24991g = aVar.f25001j;
        this.f24992h = aVar.f25002k;
        long unused4 = aVar.l;
    }
}
