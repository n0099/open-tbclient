package b.a.r0.z3;

import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.SevenZipUtils;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f28281a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f28282b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f28283c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f28284d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f28285e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f28286f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f28287g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f28288h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f28289i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1673283524, "Lb/a/r0/z3/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1673283524, "Lb/a/r0/z3/c;");
                return;
            }
        }
        f28281a = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.music/";
        StringBuilder sb = new StringBuilder();
        sb.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb.append("/");
        sb.append("tieba");
        sb.append("/videoCover.jpg");
        f28282b = sb.toString();
        f28283c = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbNewVideo/" + SevenZipUtils.FILE_NAME_TEMP;
        f28284d = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbVideo/" + SevenZipUtils.FILE_NAME_TEMP;
        f28285e = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbNewVideo/temp/";
        f28286f = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbVideo/temp/";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb2.append("/");
        sb2.append("DCIM/tieba/");
        f28287g = sb2.toString();
        f28288h = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.pendant/";
        f28289i = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/takepic/";
    }
}
