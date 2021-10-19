package c.a.r0.y3;

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
    public static final String f29076a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f29077b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f29078c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f29079d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f29080e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f29081f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f29082g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f29083h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f29084i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1801442722, "Lc/a/r0/y3/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1801442722, "Lc/a/r0/y3/c;");
                return;
            }
        }
        f29076a = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.music/";
        StringBuilder sb = new StringBuilder();
        sb.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb.append("/");
        sb.append("tieba");
        sb.append("/videoCover.jpg");
        f29077b = sb.toString();
        f29078c = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbNewVideo/" + SevenZipUtils.FILE_NAME_TEMP;
        f29079d = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbVideo/" + SevenZipUtils.FILE_NAME_TEMP;
        f29080e = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbNewVideo/temp/";
        f29081f = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbVideo/temp/";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb2.append("/");
        sb2.append("DCIM/tieba/");
        f29082g = sb2.toString();
        f29083h = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.pendant/";
        f29084i = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/takepic/";
    }
}
