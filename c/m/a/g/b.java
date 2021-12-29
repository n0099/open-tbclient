package c.m.a.g;

import android.graphics.Path;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
import java.util.StringTokenizer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes9.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public Path f31138b;

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) ",", false, 2, (Object) null) ? StringsKt__StringsJVMKt.replace$default(str, ",", " ", false, 4, (Object) null) : str;
    }

    public final void a(Path path) {
        Set set;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, path) == null) {
            Path path2 = this.f31138b;
            if (path2 != null) {
                path.set(path2);
                return;
            }
            Path path3 = new Path();
            StringTokenizer stringTokenizer = new StringTokenizer(this.a, "MLHVCSQRAZmlhvcsqraz", true);
            String str = "";
            while (stringTokenizer.hasMoreTokens()) {
                String segment = stringTokenizer.nextToken();
                Intrinsics.checkExpressionValueIsNotNull(segment, "segment");
                if (!(segment.length() == 0)) {
                    set = c.a;
                    if (set.contains(segment)) {
                        if (Intrinsics.areEqual(segment, "Z") || Intrinsics.areEqual(segment, "z")) {
                            b(path3, segment, new StringTokenizer("", ""));
                        }
                        str = segment;
                    } else {
                        b(path3, str, new StringTokenizer(segment, " "));
                    }
                }
            }
            this.f31138b = path3;
            path.set(path3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(Path path, String str, StringTokenizer stringTokenizer) {
        c.m.a.h.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, path, str, stringTokenizer) != null) {
            return;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        int i2 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            try {
                String s = stringTokenizer.nextToken();
                Intrinsics.checkExpressionValueIsNotNull(s, "s");
                if (!(s.length() == 0)) {
                    if (i2 == 0) {
                        f2 = Float.parseFloat(s);
                    }
                    if (i2 == 1) {
                        f3 = Float.parseFloat(s);
                    }
                    if (i2 == 2) {
                        f4 = Float.parseFloat(s);
                    }
                    if (i2 == 3) {
                        f5 = Float.parseFloat(s);
                    }
                    if (i2 == 4) {
                        f6 = Float.parseFloat(s);
                    }
                    if (i2 == 5) {
                        f7 = Float.parseFloat(s);
                    }
                    i2++;
                }
            } catch (Exception unused) {
            }
        }
        float f8 = f2;
        float f9 = f3;
        float f10 = f4;
        float f11 = f5;
        c.m.a.h.a aVar2 = new c.m.a.h.a(0.0f, 0.0f, 0.0f);
        if (Intrinsics.areEqual(str, "M")) {
            path.moveTo(f8, f9);
            aVar2 = new c.m.a.h.a(f8, f9, 0.0f);
        } else if (Intrinsics.areEqual(str, "m")) {
            path.rMoveTo(f8, f9);
            aVar = new c.m.a.h.a(aVar2.a() + f8, aVar2.b() + f9, 0.0f);
            if (!Intrinsics.areEqual(str, "L")) {
                path.lineTo(f8, f9);
            } else if (Intrinsics.areEqual(str, "l")) {
                path.rLineTo(f8, f9);
            }
            if (!Intrinsics.areEqual(str, "C")) {
                path.cubicTo(f8, f9, f10, f11, f6, f7);
            } else if (Intrinsics.areEqual(str, "c")) {
                path.rCubicTo(f8, f9, f10, f11, f6, f7);
            }
            if (!Intrinsics.areEqual(str, "Q")) {
                path.quadTo(f8, f9, f10, f11);
            } else if (Intrinsics.areEqual(str, "q")) {
                path.rQuadTo(f8, f9, f10, f11);
            }
            if (!Intrinsics.areEqual(str, "H")) {
                path.lineTo(f8, aVar.b());
            } else if (Intrinsics.areEqual(str, "h")) {
                path.rLineTo(f8, 0.0f);
            }
            if (!Intrinsics.areEqual(str, "V")) {
                path.lineTo(aVar.a(), f8);
            } else if (Intrinsics.areEqual(str, "v")) {
                path.rLineTo(0.0f, f8);
            }
            if (!Intrinsics.areEqual(str, "Z")) {
                path.close();
                return;
            } else if (Intrinsics.areEqual(str, "z")) {
                path.close();
                return;
            } else {
                return;
            }
        }
        aVar = aVar2;
        if (!Intrinsics.areEqual(str, "L")) {
        }
        if (!Intrinsics.areEqual(str, "C")) {
        }
        if (!Intrinsics.areEqual(str, "Q")) {
        }
        if (!Intrinsics.areEqual(str, "H")) {
        }
        if (!Intrinsics.areEqual(str, "V")) {
        }
        if (!Intrinsics.areEqual(str, "Z")) {
        }
    }
}
