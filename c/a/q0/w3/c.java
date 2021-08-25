package c.a.q0.w3;

import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.SevenZipUtils;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f28193a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f28194b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f28195c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f28196d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f28197e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f28198f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f28199g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f28200h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f28201i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(56785345, "Lc/a/q0/w3/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(56785345, "Lc/a/q0/w3/c;");
                return;
            }
        }
        f28193a = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.music/";
        StringBuilder sb = new StringBuilder();
        sb.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb.append("/");
        sb.append("tieba");
        sb.append("/videoCover.jpg");
        f28194b = sb.toString();
        f28195c = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbNewVideo/" + SevenZipUtils.FILE_NAME_TEMP;
        f28196d = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbVideo/" + SevenZipUtils.FILE_NAME_TEMP;
        f28197e = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbNewVideo/temp/";
        f28198f = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbVideo/temp/";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb2.append("/");
        sb2.append("DCIM/tieba/");
        f28199g = sb2.toString();
        f28200h = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.pendant/";
        f28201i = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/takepic/";
    }
}
