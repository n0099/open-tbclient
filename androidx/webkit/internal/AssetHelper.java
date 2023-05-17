package androidx.webkit.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
/* loaded from: classes.dex */
public class AssetHelper {
    public static final String DEFAULT_MIME_TYPE = "text/plain";
    public static final String TAG = "AssetHelper";
    @NonNull
    public Context mContext;

    public AssetHelper(@NonNull Context context) {
        this.mContext = context;
    }

    @NonNull
    public static String getCanonicalPath(@NonNull File file) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        if (!canonicalPath.endsWith("/")) {
            return canonicalPath + "/";
        }
        return canonicalPath;
    }

    @NonNull
    public static File getDataDir(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.getDataDir();
        }
        return context.getCacheDir().getParentFile();
    }

    private int getValueType(int i) {
        TypedValue typedValue = new TypedValue();
        this.mContext.getResources().getValue(i, typedValue, true);
        return typedValue.type;
    }

    @NonNull
    public static String guessMimeType(@NonNull String str) {
        String guessContentTypeFromName = URLConnection.guessContentTypeFromName(str);
        if (guessContentTypeFromName == null) {
            return "text/plain";
        }
        return guessContentTypeFromName;
    }

    @Nullable
    public static InputStream openFile(@NonNull File file) {
        try {
            return handleSvgzStream(file.getPath(), new FileInputStream(file));
        } catch (IOException e) {
            Log.e(TAG, "Error opening the requested file " + file, e);
            return null;
        }
    }

    @NonNull
    public static String removeLeadingSlash(@NonNull String str) {
        if (str.length() > 1 && str.charAt(0) == '/') {
            return str.substring(1);
        }
        return str;
    }

    @Nullable
    public InputStream openAsset(@NonNull String str) {
        String removeLeadingSlash = removeLeadingSlash(str);
        try {
            return handleSvgzStream(removeLeadingSlash, this.mContext.getAssets().open(removeLeadingSlash, 2));
        } catch (IOException unused) {
            Log.e(TAG, "Unable to open asset path: " + removeLeadingSlash);
            return null;
        }
    }

    private int getFieldId(@NonNull String str, @NonNull String str2) {
        return this.mContext.getResources().getIdentifier(str2, str, this.mContext.getPackageName());
    }

    public static boolean isCanonicalChildOf(@NonNull File file, @NonNull File file2) {
        try {
            String canonicalPath = file.getCanonicalPath();
            String canonicalPath2 = file2.getCanonicalPath();
            if (!canonicalPath.endsWith("/")) {
                canonicalPath = canonicalPath + "/";
            }
            return canonicalPath2.startsWith(canonicalPath);
        } catch (IOException e) {
            Log.e(TAG, "Error getting the canonical path of file", e);
            return false;
        }
    }

    @Nullable
    public static InputStream handleSvgzStream(@NonNull String str, @Nullable InputStream inputStream) {
        if (inputStream != null && str.endsWith(".svgz")) {
            try {
                return new GZIPInputStream(inputStream);
            } catch (IOException e) {
                Log.e(TAG, "Error decompressing " + str + " - " + e.getMessage());
                return null;
            }
        }
        return inputStream;
    }

    @Nullable
    public InputStream openResource(@NonNull String str) {
        String removeLeadingSlash = removeLeadingSlash(str);
        String[] split = removeLeadingSlash.split("/");
        if (split.length != 2) {
            Log.e(TAG, "Incorrect resource path: " + removeLeadingSlash);
            return null;
        }
        try {
            int fieldId = getFieldId(split[0], split[1].split("\\.")[0]);
            int valueType = getValueType(fieldId);
            if (valueType == 3) {
                return handleSvgzStream(removeLeadingSlash, this.mContext.getResources().openRawResource(fieldId));
            }
            Log.e(TAG, String.format("Expected %s resource to be of TYPE_STRING but was %d", removeLeadingSlash, Integer.valueOf(valueType)));
            return null;
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource not found from the path: " + removeLeadingSlash, e);
            return null;
        }
    }
}
