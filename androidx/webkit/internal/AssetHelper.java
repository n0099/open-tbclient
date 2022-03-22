package androidx.webkit.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
/* loaded from: classes.dex */
public class AssetHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_MIME_TYPE = "text/plain";
    public static final String TAG = "AssetHelper";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public Context mContext;

    public AssetHelper(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    @NonNull
    public static String getCanonicalPath(@NonNull File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            String canonicalPath = file.getCanonicalPath();
            if (canonicalPath.endsWith("/")) {
                return canonicalPath;
            }
            return canonicalPath + "/";
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public static File getDataDir(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return context.getDataDir();
            }
            return context.getCacheDir().getParentFile();
        }
        return (File) invokeL.objValue;
    }

    private int getFieldId(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) ? this.mContext.getResources().getIdentifier(str2, str, this.mContext.getPackageName()) : invokeLL.intValue;
    }

    private int getValueType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i)) == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getResources().getValue(i, typedValue, true);
            return typedValue.type;
        }
        return invokeI.intValue;
    }

    @NonNull
    public static String guessMimeType(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            String guessContentTypeFromName = URLConnection.guessContentTypeFromName(str);
            return guessContentTypeFromName == null ? "text/plain" : guessContentTypeFromName;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static InputStream handleSvgzStream(@NonNull String str, @Nullable InputStream inputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, inputStream)) == null) {
            if (inputStream == null || !str.endsWith(".svgz")) {
                return inputStream;
            }
            try {
                return new GZIPInputStream(inputStream);
            } catch (IOException e2) {
                Log.e(TAG, "Error decompressing " + str + " - " + e2.getMessage());
                return null;
            }
        }
        return (InputStream) invokeLL.objValue;
    }

    public static boolean isCanonicalChildOf(@NonNull File file, @NonNull File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, file, file2)) == null) {
            try {
                String canonicalPath = file.getCanonicalPath();
                String canonicalPath2 = file2.getCanonicalPath();
                if (!canonicalPath.endsWith("/")) {
                    canonicalPath = canonicalPath + "/";
                }
                return canonicalPath2.startsWith(canonicalPath);
            } catch (IOException e2) {
                Log.e(TAG, "Error getting the canonical path of file", e2);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Nullable
    public static InputStream openFile(@NonNull File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, file)) == null) {
            try {
                return handleSvgzStream(file.getPath(), new FileInputStream(file));
            } catch (IOException e2) {
                Log.e(TAG, "Error opening the requested file " + file, e2);
                return null;
            }
        }
        return (InputStream) invokeL.objValue;
    }

    @NonNull
    public static String removeLeadingSlash(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? (str.length() <= 1 || str.charAt(0) != '/') ? str : str.substring(1) : (String) invokeL.objValue;
    }

    @Nullable
    public InputStream openAsset(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String removeLeadingSlash = removeLeadingSlash(str);
            try {
                return handleSvgzStream(removeLeadingSlash, this.mContext.getAssets().open(removeLeadingSlash, 2));
            } catch (IOException unused) {
                Log.e(TAG, "Unable to open asset path: " + removeLeadingSlash);
                return null;
            }
        }
        return (InputStream) invokeL.objValue;
    }

    @Nullable
    public InputStream openResource(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            String removeLeadingSlash = removeLeadingSlash(str);
            String[] split = removeLeadingSlash.split("/");
            if (split.length != 2) {
                Log.e(TAG, "Incorrect resource path: " + removeLeadingSlash);
                return null;
            }
            try {
                int fieldId = getFieldId(split[0], split[1].split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX)[0]);
                int valueType = getValueType(fieldId);
                if (valueType == 3) {
                    return handleSvgzStream(removeLeadingSlash, this.mContext.getResources().openRawResource(fieldId));
                }
                Log.e(TAG, String.format("Expected %s resource to be of TYPE_STRING but was %d", removeLeadingSlash, Integer.valueOf(valueType)));
                return null;
            } catch (Resources.NotFoundException e2) {
                Log.e(TAG, "Resource not found from the path: " + removeLeadingSlash, e2);
                return null;
            }
        }
        return (InputStream) invokeL.objValue;
    }
}
