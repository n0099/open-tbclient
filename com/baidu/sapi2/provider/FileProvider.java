package com.baidu.sapi2.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes5.dex */
public class FileProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f44776b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f44777c = "android.support.FILE_PROVIDER_PATHS";

    /* renamed from: d  reason: collision with root package name */
    public static final String f44778d = "root-path";

    /* renamed from: e  reason: collision with root package name */
    public static final String f44779e = "files-path";

    /* renamed from: f  reason: collision with root package name */
    public static final String f44780f = "cache-path";

    /* renamed from: g  reason: collision with root package name */
    public static final String f44781g = "external-path";

    /* renamed from: h  reason: collision with root package name */
    public static final String f44782h = "name";

    /* renamed from: i  reason: collision with root package name */
    public static final String f44783i = "path";

    /* renamed from: j  reason: collision with root package name */
    public static final File f44784j;
    public static HashMap<String, a> k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f44785a;

    /* loaded from: classes5.dex */
    public interface a {
        Uri a(File file);

        File a(Uri uri);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(810120930, "Lcom/baidu/sapi2/provider/FileProvider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(810120930, "Lcom/baidu/sapi2/provider/FileProvider;");
                return;
            }
        }
        f44776b = new String[]{"_display_name", "_size"};
        f44784j = new File("/");
        k = new HashMap<>();
    }

    public FileProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a a(Context context, String str) {
        InterceptResult invokeLL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            synchronized (k) {
                aVar = k.get(str);
                if (aVar == null) {
                    try {
                        aVar = b(context, str);
                        k.put(str, aVar);
                    } catch (IOException e2) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                    } catch (XmlPullParserException e3) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e3);
                    }
                }
            }
            return aVar;
        }
        return (a) invokeLL.objValue;
    }

    public static a b(Context context, String str) throws IOException, XmlPullParserException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65543, null, context, str)) != null) {
            return (a) invokeLL.objValue;
        }
        b bVar = new b(str);
        XmlResourceParser loadXmlMetaData = context.getPackageManager().resolveContentProvider(str, 128).loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (loadXmlMetaData == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = loadXmlMetaData.next();
            if (next == 1) {
                return bVar;
            }
            if (next == 2) {
                String name = loadXmlMetaData.getName();
                File file = null;
                String attributeValue = loadXmlMetaData.getAttributeValue(null, "name");
                String attributeValue2 = loadXmlMetaData.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    file = a(f44784j, attributeValue2);
                } else if ("files-path".equals(name)) {
                    file = a(context.getFilesDir(), attributeValue2);
                } else if ("cache-path".equals(name)) {
                    file = a(context.getCacheDir(), attributeValue2);
                } else if ("external-path".equals(name)) {
                    file = a(Environment.getExternalStorageDirectory(), attributeValue2);
                }
                if (file != null) {
                    bVar.a(attributeValue, file);
                }
            }
        }
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, context, str, file)) == null) ? a(context, str).a(file) : (Uri) invokeLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, providerInfo) == null) {
            super.attachInfo(context, providerInfo);
            if (!providerInfo.exported) {
                if (providerInfo.grantUriPermissions) {
                    this.f44785a = a(context, providerInfo.authority);
                    return;
                }
                throw new SecurityException("Provider must grant uri permissions");
            }
            throw new SecurityException("Provider must not be exported");
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, str, strArr)) == null) ? this.f44785a.a(uri).delete() ? 1 : 0 : invokeLLL.intValue;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uri)) == null) {
            File a2 = this.f44785a.a(uri);
            int lastIndexOf = a2.getName().lastIndexOf(46);
            if (lastIndexOf >= 0) {
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a2.getName().substring(lastIndexOf + 1));
                return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
            }
            return "application/octet-stream";
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, uri, contentValues)) == null) {
            throw new UnsupportedOperationException("No external inserts");
        }
        return (Uri) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, uri, str)) == null) ? ParcelFileDescriptor.open(this.f44785a.a(uri), a(str)) : (ParcelFileDescriptor) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048582, this, uri, strArr, str, strArr2, str2)) == null) {
            File a2 = this.f44785a.a(uri);
            if (strArr == null) {
                strArr = f44776b;
            }
            String[] strArr3 = new String[strArr.length];
            Object[] objArr = new Object[strArr.length];
            int i3 = 0;
            for (String str3 : strArr) {
                if ("_display_name".equals(str3)) {
                    strArr3[i3] = "_display_name";
                    i2 = i3 + 1;
                    objArr[i3] = a2.getName();
                } else if ("_size".equals(str3)) {
                    strArr3[i3] = "_size";
                    i2 = i3 + 1;
                    objArr[i3] = Long.valueOf(a2.length());
                }
                i3 = i2;
            }
            String[] a3 = a(strArr3, i3);
            Object[] a4 = a(objArr, i3);
            MatrixCursor matrixCursor = new MatrixCursor(a3, 1);
            matrixCursor.addRow(a4);
            return matrixCursor;
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, uri, contentValues, str, strArr)) == null) {
            throw new UnsupportedOperationException("No external updates");
        }
        return invokeLLLL.intValue;
    }

    /* loaded from: classes5.dex */
    public static class b implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f44786a;

        /* renamed from: b  reason: collision with root package name */
        public final HashMap<String, File> f44787b;

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
            this.f44787b = new HashMap<>();
            this.f44786a = str;
        }

        public void a(String str, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, file) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        this.f44787b.put(str, file.getCanonicalFile());
                        return;
                    } catch (IOException e2) {
                        throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e2);
                    }
                }
                throw new IllegalArgumentException("Name must not be empty");
            }
        }

        @Override // com.baidu.sapi2.provider.FileProvider.a
        public Uri a(File file) {
            String substring;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
                try {
                    String canonicalPath = file.getCanonicalPath();
                    Map.Entry<String, File> entry = null;
                    for (Map.Entry<String, File> entry2 : this.f44787b.entrySet()) {
                        String path = entry2.getValue().getPath();
                        if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                            entry = entry2;
                        }
                    }
                    if (entry != null) {
                        String path2 = entry.getValue().getPath();
                        if (path2.endsWith("/")) {
                            substring = canonicalPath.substring(path2.length());
                        } else {
                            substring = canonicalPath.substring(path2.length() + 1);
                        }
                        return new Uri.Builder().scheme("content").authority(this.f44786a).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(substring, "/")).build();
                    }
                    throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
                }
            }
            return (Uri) invokeL.objValue;
        }

        @Override // com.baidu.sapi2.provider.FileProvider.a
        public File a(Uri uri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri)) == null) {
                String encodedPath = uri.getEncodedPath();
                int indexOf = encodedPath.indexOf(47, 1);
                String decode = Uri.decode(encodedPath.substring(1, indexOf));
                String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
                File file = this.f44787b.get(decode);
                if (file != null) {
                    File file2 = new File(file, decode2);
                    try {
                        File canonicalFile = file2.getCanonicalFile();
                        if (canonicalFile.getPath().startsWith(file.getPath())) {
                            return canonicalFile;
                        }
                        throw new SecurityException("Resolved path jumped beyond configured root");
                    } catch (IOException unused) {
                        throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
                    }
                }
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
            return (File) invokeL.objValue;
        }
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (r.f42169a.equals(str)) {
                return 268435456;
            }
            if ("w".equals(str) || "wt".equals(str)) {
                return 738197504;
            }
            if ("wa".equals(str)) {
                return 704643072;
            }
            if ("rw".equals(str)) {
                return 939524096;
            }
            if ("rwt".equals(str)) {
                return 1006632960;
            }
            throw new IllegalArgumentException("Invalid mode: " + str);
        }
        return invokeL.intValue;
    }

    public static File a(File file, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, strArr)) == null) {
            for (String str : strArr) {
                if (str != null) {
                    file = new File(file, str);
                }
            }
            return file;
        }
        return (File) invokeLL.objValue;
    }

    public static String[] a(String[] strArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, strArr, i2)) == null) {
            String[] strArr2 = new String[i2];
            System.arraycopy(strArr, 0, strArr2, 0, i2);
            return strArr2;
        }
        return (String[]) invokeLI.objValue;
    }

    public static Object[] a(Object[] objArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, objArr, i2)) == null) {
            Object[] objArr2 = new Object[i2];
            System.arraycopy(objArr, 0, objArr2, 0, i2);
            return objArr2;
        }
        return (Object[]) invokeLI.objValue;
    }
}
