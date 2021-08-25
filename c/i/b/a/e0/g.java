package c.i.b.a.e0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes4.dex */
public interface g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f33331a = new a();

    /* loaded from: classes4.dex */
    public static class a implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // c.i.b.a.e0.g
        public boolean a(Format format) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, format)) == null) {
                String str = format.sampleMimeType;
                return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str);
            }
            return invokeL.booleanValue;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // c.i.b.a.e0.g
        public f b(Format format) {
            InterceptResult invokeL;
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, format)) == null) {
                String str = format.sampleMimeType;
                switch (str.hashCode()) {
                    case -1351681404:
                        if (str.equals("application/dvbsubs")) {
                            c2 = '\t';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1026075066:
                        if (str.equals("application/x-mp4-vtt")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1004728940:
                        if (str.equals("text/vtt")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 691401887:
                        if (str.equals("application/x-quicktime-tx3g")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 822864842:
                        if (str.equals("text/x-ssa")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 930165504:
                        if (str.equals("application/x-mp4-cea-608")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1566015601:
                        if (str.equals("application/cea-608")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1566016562:
                        if (str.equals("application/cea-708")) {
                            c2 = '\b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1668750253:
                        if (str.equals("application/x-subrip")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1693976202:
                        if (str.equals("application/ttml+xml")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        return new c.i.b.a.e0.r.g();
                    case 1:
                        return new c.i.b.a.e0.n.a(format.initializationData);
                    case 2:
                        return new c.i.b.a.e0.r.b();
                    case 3:
                        return new c.i.b.a.e0.p.a();
                    case 4:
                        return new c.i.b.a.e0.o.a();
                    case 5:
                        return new c.i.b.a.e0.q.a(format.initializationData);
                    case 6:
                    case 7:
                        return new c.i.b.a.e0.l.a(format.sampleMimeType, format.accessibilityChannel);
                    case '\b':
                        return new c.i.b.a.e0.l.c(format.accessibilityChannel);
                    case '\t':
                        return new c.i.b.a.e0.m.a(format.initializationData);
                    default:
                        throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
                }
            }
            return (f) invokeL.objValue;
        }
    }

    boolean a(Format format);

    f b(Format format);
}
