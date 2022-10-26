package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class DocumentsContractApi19 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FLAG_VIRTUAL_DOCUMENT = 512;
    public static final String TAG = "DocumentFile";
    public transient /* synthetic */ FieldHolder $fh;

    public DocumentsContractApi19() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean canRead(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, uri)) == null) {
            if (context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !TextUtils.isEmpty(getRawType(context, uri))) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static long getFlags(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, uri)) == null) {
            return queryForLong(context, uri, "flags", 0L);
        }
        return invokeLL.longValue;
    }

    public static String getName(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, uri)) == null) {
            return queryForString(context, uri, "_display_name", null);
        }
        return (String) invokeLL.objValue;
    }

    public static String getRawType(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, uri)) == null) {
            return queryForString(context, uri, "mime_type", null);
        }
        return (String) invokeLL.objValue;
    }

    public static String getType(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, uri)) == null) {
            String rawType = getRawType(context, uri);
            if ("vnd.android.document/directory".equals(rawType)) {
                return null;
            }
            return rawType;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isDirectory(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, uri)) == null) {
            return "vnd.android.document/directory".equals(getRawType(context, uri));
        }
        return invokeLL.booleanValue;
    }

    public static boolean isFile(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, uri)) == null) {
            String rawType = getRawType(context, uri);
            if (!"vnd.android.document/directory".equals(rawType) && !TextUtils.isEmpty(rawType)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isVirtual(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, uri)) == null) {
            if (!DocumentsContract.isDocumentUri(context, uri) || (getFlags(context, uri) & 512) == 0) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static long lastModified(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, uri)) == null) {
            return queryForLong(context, uri, "last_modified", 0L);
        }
        return invokeLL.longValue;
    }

    public static long length(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, uri)) == null) {
            return queryForLong(context, uri, "_size", 0L);
        }
        return invokeLL.longValue;
    }

    public static boolean canWrite(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, uri)) == null) {
            if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
                return false;
            }
            String rawType = getRawType(context, uri);
            int queryForInt = queryForInt(context, uri, "flags", 0);
            if (TextUtils.isEmpty(rawType)) {
                return false;
            }
            if ((queryForInt & 4) != 0) {
                return true;
            }
            if ("vnd.android.document/directory".equals(rawType) && (queryForInt & 8) != 0) {
                return true;
            }
            if (TextUtils.isEmpty(rawType) || (queryForInt & 2) == 0) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean exists(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, uri)) == null) {
            ContentResolver contentResolver = context.getContentResolver();
            boolean z = false;
            Cursor cursor = null;
            try {
                cursor = contentResolver.query(uri, new String[]{"document_id"}, null, null, null);
                if (cursor.getCount() > 0) {
                    z = true;
                }
                return z;
            } catch (Exception e) {
                Log.w("DocumentFile", "Failed query: " + e);
                return false;
            } finally {
                closeQuietly(cursor);
            }
        }
        return invokeLL.booleanValue;
    }

    public static void closeQuietly(AutoCloseable autoCloseable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, autoCloseable) == null) && autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static int queryForInt(Context context, Uri uri, String str, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65550, null, context, uri, str, i)) == null) {
            return (int) queryForLong(context, uri, str, i);
        }
        return invokeLLLI.intValue;
    }

    public static long queryForLong(Context context, Uri uri, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{context, uri, str, Long.valueOf(j)})) == null) {
            Cursor cursor = null;
            try {
                cursor = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
                if (cursor.moveToFirst() && !cursor.isNull(0)) {
                    return cursor.getLong(0);
                }
                return j;
            } catch (Exception e) {
                Log.w("DocumentFile", "Failed query: " + e);
                return j;
            } finally {
                closeQuietly(cursor);
            }
        }
        return invokeCommon.longValue;
    }

    public static String queryForString(Context context, Uri uri, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65552, null, context, uri, str, str2)) == null) {
            Cursor cursor = null;
            try {
                cursor = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
                if (cursor.moveToFirst() && !cursor.isNull(0)) {
                    return cursor.getString(0);
                }
                return str2;
            } catch (Exception e) {
                Log.w("DocumentFile", "Failed query: " + e);
                return str2;
            } finally {
                closeQuietly(cursor);
            }
        }
        return (String) invokeLLLL.objValue;
    }
}
