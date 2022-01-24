package c.a.t0.x0.a.g;

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
    public int f24923b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaData f24924c;

    /* renamed from: d  reason: collision with root package name */
    public float f24925d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24926e;

    /* renamed from: f  reason: collision with root package name */
    public String f24927f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24928g;

    /* renamed from: h  reason: collision with root package name */
    public Buffer f24929h;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f24930b;

        /* renamed from: c  reason: collision with root package name */
        public MultiMediaData f24931c;

        /* renamed from: d  reason: collision with root package name */
        public List<LocalAlbumInfo> f24932d;

        /* renamed from: e  reason: collision with root package name */
        public float f24933e;

        /* renamed from: f  reason: collision with root package name */
        public String f24934f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f24935g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f24936h;

        /* renamed from: i  reason: collision with root package name */
        public String f24937i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f24938j;
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
            this.f24930b = RecordConstants.VIDEO_CONSTANT_HEIGHT;
            this.f24933e = 0.0f;
            this.f24935g = false;
            this.f24936h = false;
            this.f24938j = false;
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
                this.f24930b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a p(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f24938j = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a q(MultiMediaData multiMediaData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, multiMediaData)) == null) {
                this.f24931c = multiMediaData;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a r(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
                this.f24933e = f2;
                return this;
            }
            return (a) invokeF.objValue;
        }

        public a s(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f24937i = str;
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
        this.f24923b = aVar.f24930b;
        this.f24925d = aVar.f24933e;
        String unused = aVar.f24934f;
        this.f24924c = aVar.f24931c;
        List unused2 = aVar.f24932d;
        this.f24926e = aVar.f24935g;
        boolean unused3 = aVar.f24936h;
        this.f24927f = aVar.f24937i;
        this.f24928g = aVar.f24938j;
        this.f24929h = aVar.k;
        long unused4 = aVar.l;
    }
}
