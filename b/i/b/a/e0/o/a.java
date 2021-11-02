package b.i.b.a.e0.o;

import android.text.Html;
import android.text.TextUtils;
import b.i.b.a.e0.c;
import b.i.b.a.i0.g;
import b.i.b.a.i0.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public final class a extends c {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern o;
    public transient /* synthetic */ FieldHolder $fh;
    public final StringBuilder n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597281860, "Lb/i/b/a/e0/o/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597281860, "Lb/i/b/a/e0/o/a;");
                return;
            }
        }
        o = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super("SubripDecoder");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = new StringBuilder();
    }

    public static long A(Matcher matcher, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, matcher, i2)) == null) ? ((Long.parseLong(matcher.group(i2 + 1)) * 60 * 60 * 1000) + (Long.parseLong(matcher.group(i2 + 2)) * 60 * 1000) + (Long.parseLong(matcher.group(i2 + 3)) * 1000) + Long.parseLong(matcher.group(i2 + 4))) * 1000 : invokeLI.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.i.b.a.e0.c
    /* renamed from: z */
    public b w(byte[] bArr, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            ArrayList arrayList = new ArrayList();
            g gVar = new g();
            l lVar = new l(bArr, i2);
            while (true) {
                String k = lVar.k();
                if (k == null) {
                    break;
                } else if (k.length() != 0) {
                    try {
                        Integer.parseInt(k);
                        String k2 = lVar.k();
                        if (k2 == null) {
                            break;
                        }
                        Matcher matcher = o.matcher(k2);
                        if (matcher.matches()) {
                            boolean z2 = true;
                            gVar.a(A(matcher, 1));
                            if (TextUtils.isEmpty(matcher.group(6))) {
                                z2 = false;
                            } else {
                                gVar.a(A(matcher, 6));
                            }
                            this.n.setLength(0);
                            while (true) {
                                String k3 = lVar.k();
                                if (TextUtils.isEmpty(k3)) {
                                    break;
                                }
                                if (this.n.length() > 0) {
                                    this.n.append("<br>");
                                }
                                this.n.append(k3.trim());
                            }
                            arrayList.add(new b.i.b.a.e0.b(Html.fromHtml(this.n.toString())));
                            if (z2) {
                                arrayList.add(null);
                            }
                        } else {
                            String str = "Skipping invalid timing: " + k2;
                        }
                    } catch (NumberFormatException unused) {
                        String str2 = "Skipping invalid index: " + k;
                    }
                }
            }
            b.i.b.a.e0.b[] bVarArr = new b.i.b.a.e0.b[arrayList.size()];
            arrayList.toArray(bVarArr);
            return new b(bVarArr, gVar.d());
        }
        return (b) invokeCommon.objValue;
    }
}
