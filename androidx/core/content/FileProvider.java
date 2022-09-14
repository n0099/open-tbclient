package androidx.core.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class FileProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ATTR_NAME = "name";
    public static final String ATTR_PATH = "path";
    public static final String[] COLUMNS;
    public static final File DEVICE_ROOT;
    public static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    public static final String TAG_CACHE_PATH = "cache-path";
    public static final String TAG_EXTERNAL = "external-path";
    public static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    public static final String TAG_EXTERNAL_FILES = "external-files-path";
    public static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    public static final String TAG_FILES_PATH = "files-path";
    public static final String TAG_ROOT_PATH = "root-path";
    @GuardedBy("sCache")
    public static HashMap<String, PathStrategy> sCache;
    public transient /* synthetic */ FieldHolder $fh;
    public PathStrategy mStrategy;

    /* loaded from: classes.dex */
    public interface PathStrategy {
        File getFileForUri(Uri uri);

        Uri getUriForFile(File file);
    }

    /* loaded from: classes.dex */
    public static class SimplePathStrategy implements PathStrategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String mAuthority;
        public final HashMap<String, File> mRoots;

        public SimplePathStrategy(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mRoots = new HashMap<>();
            this.mAuthority = str;
        }

        public void addRoot(String str, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, file) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        this.mRoots.put(str, file.getCanonicalFile());
                        return;
                    } catch (IOException e) {
                        throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e);
                    }
                }
                throw new IllegalArgumentException("Name must not be empty");
            }
        }

        @Override // androidx.core.content.FileProvider.PathStrategy
        public File getFileForUri(Uri uri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri)) == null) {
                String encodedPath = uri.getEncodedPath();
                int indexOf = encodedPath.indexOf(47, 1);
                String decode = Uri.decode(encodedPath.substring(1, indexOf));
                String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
                File file = this.mRoots.get(decode);
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

        @Override // androidx.core.content.FileProvider.PathStrategy
        public Uri getUriForFile(File file) {
            String substring;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file)) == null) {
                try {
                    String canonicalPath = file.getCanonicalPath();
                    Map.Entry<String, File> entry = null;
                    for (Map.Entry<String, File> entry2 : this.mRoots.entrySet()) {
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
                        return new Uri.Builder().scheme("content").authority(this.mAuthority).encodedPath(Uri.encode(entry.getKey()) + WebvttCueParser.CHAR_SLASH + Uri.encode(substring, "/")).build();
                    }
                    throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
                }
            }
            return (Uri) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1046240962, "Landroidx/core/content/FileProvider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1046240962, "Landroidx/core/content/FileProvider;");
                return;
            }
        }
        COLUMNS = new String[]{"_display_name", "_size"};
        DEVICE_ROOT = new File("/");
        sCache = new HashMap<>();
    }

    public FileProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static File buildPath(File file, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, file, strArr)) == null) {
            for (String str : strArr) {
                if (str != null) {
                    file = new File(file, str);
                }
            }
            return file;
        }
        return (File) invokeLL.objValue;
    }

    public static String[] copyOf(String[] strArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, strArr, i)) == null) {
            String[] strArr2 = new String[i];
            System.arraycopy(strArr, 0, strArr2, 0, i);
            return strArr2;
        }
        return (String[]) invokeLI.objValue;
    }

    public static PathStrategy getPathStrategy(Context context, String str) {
        InterceptResult invokeLL;
        PathStrategy pathStrategy;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            synchronized (sCache) {
                pathStrategy = sCache.get(str);
                if (pathStrategy == null) {
                    try {
                        pathStrategy = parsePathStrategy(context, str);
                        sCache.put(str, pathStrategy);
                    } catch (IOException e) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                    } catch (XmlPullParserException e2) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                    }
                }
            }
            return pathStrategy;
        }
        return (PathStrategy) invokeLL.objValue;
    }

    public static Uri getUriForFile(@NonNull Context context, @NonNull String str, @NonNull File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, context, str, file)) == null) ? getPathStrategy(context, str).getUriForFile(file) : (Uri) invokeLLL.objValue;
    }

    public static int modeToMode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if ("r".equals(str)) {
                return LaunchTaskConstants.OTHER_PROCESS;
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

    public static PathStrategy parsePathStrategy(Context context, String str) throws IOException, XmlPullParserException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65544, null, context, str)) != null) {
            return (PathStrategy) invokeLL.objValue;
        }
        SimplePathStrategy simplePathStrategy = new SimplePathStrategy(str);
        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(str, 128);
        if (resolveContentProvider != null) {
            XmlResourceParser loadXmlMetaData = resolveContentProvider.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
            if (loadXmlMetaData == null) {
                throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
            }
            while (true) {
                int next = loadXmlMetaData.next();
                if (next == 1) {
                    return simplePathStrategy;
                }
                if (next == 2) {
                    String name = loadXmlMetaData.getName();
                    File file = null;
                    String attributeValue = loadXmlMetaData.getAttributeValue(null, "name");
                    String attributeValue2 = loadXmlMetaData.getAttributeValue(null, "path");
                    if ("root-path".equals(name)) {
                        file = DEVICE_ROOT;
                    } else if ("files-path".equals(name)) {
                        file = context.getFilesDir();
                    } else if ("cache-path".equals(name)) {
                        file = context.getCacheDir();
                    } else if ("external-path".equals(name)) {
                        file = Environment.getExternalStorageDirectory();
                    } else if ("external-files-path".equals(name)) {
                        File[] externalFilesDirs = ContextCompat.getExternalFilesDirs(context, null);
                        if (externalFilesDirs.length > 0) {
                            file = externalFilesDirs[0];
                        }
                    } else if ("external-cache-path".equals(name)) {
                        File[] externalCacheDirs = ContextCompat.getExternalCacheDirs(context);
                        if (externalCacheDirs.length > 0) {
                            file = externalCacheDirs[0];
                        }
                    } else if (Build.VERSION.SDK_INT >= 21 && TAG_EXTERNAL_MEDIA.equals(name)) {
                        File[] externalMediaDirs = context.getExternalMediaDirs();
                        if (externalMediaDirs.length > 0) {
                            file = externalMediaDirs[0];
                        }
                    }
                    if (file != null) {
                        simplePathStrategy.addRoot(attributeValue, buildPath(file, attributeValue2));
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + str);
        }
    }

    @Override // android.content.ContentProvider
    public void attachInfo(@NonNull Context context, @NonNull ProviderInfo providerInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, providerInfo) == null) {
            super.attachInfo(context, providerInfo);
            if (!providerInfo.exported) {
                if (providerInfo.grantUriPermissions) {
                    this.mStrategy = getPathStrategy(context, providerInfo.authority);
                    return;
                }
                throw new SecurityException("Provider must grant uri permissions");
            }
            throw new SecurityException("Provider must not be exported");
        }
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, str, strArr)) == null) ? this.mStrategy.getFileForUri(uri).delete() ? 1 : 0 : invokeLLL.intValue;
    }

    @Override // android.content.ContentProvider
    public String getType(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uri)) == null) {
            File fileForUri = this.mStrategy.getFileForUri(uri);
            int lastIndexOf = fileForUri.getName().lastIndexOf(46);
            if (lastIndexOf >= 0) {
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileForUri.getName().substring(lastIndexOf + 1));
                return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
            }
            return "application/octet-stream";
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public Uri insert(@NonNull Uri uri, ContentValues contentValues) {
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
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String str) throws FileNotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, uri, str)) == null) ? ParcelFileDescriptor.open(this.mStrategy.getFileForUri(uri), modeToMode(str)) : (ParcelFileDescriptor) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048582, this, uri, strArr, str, strArr2, str2)) == null) {
            File fileForUri = this.mStrategy.getFileForUri(uri);
            if (strArr == null) {
                strArr = COLUMNS;
            }
            String[] strArr3 = new String[strArr.length];
            Object[] objArr = new Object[strArr.length];
            int i2 = 0;
            for (String str3 : strArr) {
                if ("_display_name".equals(str3)) {
                    strArr3[i2] = "_display_name";
                    i = i2 + 1;
                    objArr[i2] = fileForUri.getName();
                } else if ("_size".equals(str3)) {
                    strArr3[i2] = "_size";
                    i = i2 + 1;
                    objArr[i2] = Long.valueOf(fileForUri.length());
                }
                i2 = i;
            }
            String[] copyOf = copyOf(strArr3, i2);
            Object[] copyOf2 = copyOf(objArr, i2);
            MatrixCursor matrixCursor = new MatrixCursor(copyOf, 1);
            matrixCursor.addRow(copyOf2);
            return matrixCursor;
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, uri, contentValues, str, strArr)) == null) {
            throw new UnsupportedOperationException("No external updates");
        }
        return invokeLLLL.intValue;
    }

    public static Object[] copyOf(Object[] objArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, objArr, i)) == null) {
            Object[] objArr2 = new Object[i];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            return objArr2;
        }
        return (Object[]) invokeLI.objValue;
    }
}
