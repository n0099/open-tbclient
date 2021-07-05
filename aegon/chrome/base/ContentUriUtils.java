package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes.dex */
public abstract class ContentUriUtils {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static /* synthetic */ void $closeResource(Throwable th, AutoCloseable autoCloseable) {
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-657623585, "Laegon/chrome/base/ContentUriUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-657623585, "Laegon/chrome/base/ContentUriUtils;");
        }
    }

    public ContentUriUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
            }
        }
    }

    @CalledByNative
    public static boolean contentUriExists(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            AssetFileDescriptor assetFileDescriptor = getAssetFileDescriptor(str);
            boolean z = assetFileDescriptor != null;
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException unused) {
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @CalledByNative
    public static boolean delete(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) ? ContextUtils.sApplicationContext.getContentResolver().delete(Uri.parse(str), null, null) > 0 : invokeL.booleanValue;
    }

    public static AssetFileDescriptor getAssetFileDescriptor(String str) {
        InterceptResult invokeL;
        StringBuilder sb;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            ContentResolver contentResolver = ContextUtils.sApplicationContext.getContentResolver();
            Uri parse = Uri.parse(str);
            try {
                try {
                    if (isVirtualDocument(parse)) {
                        String[] streamTypes = contentResolver.getStreamTypes(parse, "*/*");
                        if (streamTypes != null && streamTypes.length > 0) {
                            AssetFileDescriptor openTypedAssetFileDescriptor = contentResolver.openTypedAssetFileDescriptor(parse, streamTypes[0], null);
                            if (openTypedAssetFileDescriptor == null || openTypedAssetFileDescriptor.getStartOffset() == 0) {
                                return openTypedAssetFileDescriptor;
                            }
                            try {
                                openTypedAssetFileDescriptor.close();
                            } catch (IOException unused) {
                            }
                            throw new SecurityException("Cannot open files with non-zero offset type.");
                        }
                    } else {
                        ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(parse, r.f7745a);
                        if (openFileDescriptor != null) {
                            return new AssetFileDescriptor(openFileDescriptor, 0L, -1L);
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    sb = new StringBuilder();
                    str2 = "Cannot find content uri: ";
                    sb.append(str2);
                    sb.append(str);
                    android.util.Log.w("ContentUriUtils", sb.toString(), e);
                    return null;
                }
            } catch (SecurityException e3) {
                e = e3;
                sb = new StringBuilder();
                str2 = "Cannot open content uri: ";
                sb.append(str2);
                sb.append(str);
                android.util.Log.w("ContentUriUtils", sb.toString(), e);
                return null;
            } catch (Exception e4) {
                e = e4;
                sb = new StringBuilder();
                str2 = "Unknown content uri: ";
                sb.append(str2);
                sb.append(str);
                android.util.Log.w("ContentUriUtils", sb.toString(), e);
                return null;
            }
            return null;
        }
        return (AssetFileDescriptor) invokeL.objValue;
    }

    public static String getDisplayName(Uri uri, Context context, String str) {
        InterceptResult invokeLLL;
        Cursor query;
        String[] streamTypes;
        String extensionFromMimeType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, uri, context, str)) == null) {
            if (uri == null) {
                return "";
            }
            ContentResolver contentResolver = context.getContentResolver();
            try {
                query = contentResolver.query(uri, null, null, null, null);
            } catch (NullPointerException unused) {
            }
            if (query == null || query.getCount() < 1) {
                if (query != null) {
                    $closeResource(null, query);
                }
                return "";
            }
            query.moveToFirst();
            int columnIndex = query.getColumnIndex(str);
            if (columnIndex == -1) {
                $closeResource(null, query);
                return "";
            }
            String string = query.getString(columnIndex);
            if (hasVirtualFlag(query) && (streamTypes = contentResolver.getStreamTypes(uri, "*/*")) != null && streamTypes.length > 0 && (extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(streamTypes[0])) != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                sb.append(".");
                sb.append(extensionFromMimeType);
                string = sb.toString();
            }
            $closeResource(null, query);
            return string;
        }
        return (String) invokeLLL.objValue;
    }

    @CalledByNative
    public static String getMimeType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            ContentResolver contentResolver = ContextUtils.sApplicationContext.getContentResolver();
            Uri parse = Uri.parse(str);
            if (isVirtualDocument(parse)) {
                String[] streamTypes = contentResolver.getStreamTypes(parse, "*/*");
                if (streamTypes == null || streamTypes.length <= 0) {
                    return null;
                }
                return streamTypes[0];
            }
            return contentResolver.getType(parse);
        }
        return (String) invokeL.objValue;
    }

    public static boolean hasVirtualFlag(Cursor cursor) {
        InterceptResult invokeL;
        int columnIndex;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, cursor)) == null) ? Build.VERSION.SDK_INT >= 24 && (columnIndex = cursor.getColumnIndex("flags")) > -1 && (cursor.getLong(columnIndex) & 512) != 0 : invokeL.booleanValue;
    }

    public static boolean isVirtualDocument(Uri uri) {
        InterceptResult invokeL;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, uri)) == null) {
            if (Build.VERSION.SDK_INT >= 19 && uri != null && DocumentsContract.isDocumentUri(ContextUtils.sApplicationContext, uri)) {
                try {
                    query = ContextUtils.sApplicationContext.getContentResolver().query(uri, null, null, null, null);
                } catch (NullPointerException unused) {
                }
                if (query == null || query.getCount() < 1) {
                    if (query != null) {
                        $closeResource(null, query);
                    }
                    return false;
                }
                query.moveToFirst();
                boolean hasVirtualFlag = hasVirtualFlag(query);
                $closeResource(null, query);
                return hasVirtualFlag;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    @CalledByNative
    public static String maybeGetDisplayName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            try {
                String displayName = getDisplayName(Uri.parse(str), ContextUtils.sApplicationContext, "_display_name");
                if (TextUtils.isEmpty(displayName)) {
                    return null;
                }
                return displayName;
            } catch (Exception e2) {
                android.util.Log.w("ContentUriUtils", "Cannot open content uri: " + str, e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    @CalledByNative
    public static int openContentUriForRead(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            AssetFileDescriptor assetFileDescriptor = getAssetFileDescriptor(str);
            if (assetFileDescriptor != null) {
                return assetFileDescriptor.getParcelFileDescriptor().detachFd();
            }
            return -1;
        }
        return invokeL.intValue;
    }
}
