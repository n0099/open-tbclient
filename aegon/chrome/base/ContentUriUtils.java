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
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes3.dex */
public abstract class ContentUriUtils {
    public static final /* synthetic */ boolean $assertionsDisabled = !ContentUriUtils.class.desiredAssertionStatus();

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
        new Object();
    }

    @CalledByNative
    public static boolean contentUriExists(String str) {
        AssetFileDescriptor assetFileDescriptor = getAssetFileDescriptor(str);
        boolean z = assetFileDescriptor != null;
        if (assetFileDescriptor != null) {
            try {
                assetFileDescriptor.close();
            } catch (IOException e) {
            }
        }
        return z;
    }

    @CalledByNative
    public static boolean delete(String str) {
        Uri parse;
        if (!$assertionsDisabled) {
            if (!((str == null || (parse = Uri.parse(str)) == null || !"content".equals(parse.getScheme())) ? false : true)) {
                throw new AssertionError();
            }
        }
        return ContextUtils.sApplicationContext.getContentResolver().delete(Uri.parse(str), null, null) > 0;
    }

    public static AssetFileDescriptor getAssetFileDescriptor(String str) {
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
                        } catch (IOException e) {
                        }
                        throw new SecurityException("Cannot open files with non-zero offset type.");
                    }
                } else {
                    ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(parse, "r");
                    if (openFileDescriptor != null) {
                        return new AssetFileDescriptor(openFileDescriptor, 0L, -1L);
                    }
                }
            } catch (FileNotFoundException e2) {
                android.util.Log.w("ContentUriUtils", "Cannot find content uri: " + str, e2);
            }
        } catch (SecurityException e3) {
            android.util.Log.w("ContentUriUtils", "Cannot open content uri: " + str, e3);
        } catch (Exception e4) {
            android.util.Log.w("ContentUriUtils", "Unknown content uri: " + str, e4);
        }
        return null;
    }

    public static String getDisplayName(Uri uri, Context context, String str) {
        String[] streamTypes;
        String extensionFromMimeType;
        if (uri == null) {
            return "";
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            Cursor query = contentResolver.query(uri, null, null, null, null);
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
            String str2 = (!hasVirtualFlag(query) || (streamTypes = contentResolver.getStreamTypes(uri, "*/*")) == null || streamTypes.length <= 0 || (extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(streamTypes[0])) == null) ? string : string + "." + extensionFromMimeType;
            $closeResource(null, query);
            return str2;
        } catch (NullPointerException e) {
            return "";
        }
    }

    @CalledByNative
    public static String getMimeType(String str) {
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

    public static boolean hasVirtualFlag(Cursor cursor) {
        int columnIndex;
        return Build.VERSION.SDK_INT >= 24 && (columnIndex = cursor.getColumnIndex("flags")) > -1 && (cursor.getLong(columnIndex) & 512) != 0;
    }

    public static boolean isVirtualDocument(Uri uri) {
        if (Build.VERSION.SDK_INT >= 19 && uri != null && DocumentsContract.isDocumentUri(ContextUtils.sApplicationContext, uri)) {
            try {
                Cursor query = ContextUtils.sApplicationContext.getContentResolver().query(uri, null, null, null, null);
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
            } catch (NullPointerException e) {
                return false;
            }
        }
        return false;
    }

    @Nullable
    @CalledByNative
    public static String maybeGetDisplayName(String str) {
        try {
            String displayName = getDisplayName(Uri.parse(str), ContextUtils.sApplicationContext, "_display_name");
            if (TextUtils.isEmpty(displayName)) {
                return null;
            }
            return displayName;
        } catch (Exception e) {
            android.util.Log.w("ContentUriUtils", "Cannot open content uri: " + str, e);
            return null;
        }
    }

    @CalledByNative
    public static int openContentUriForRead(String str) {
        AssetFileDescriptor assetFileDescriptor = getAssetFileDescriptor(str);
        if (assetFileDescriptor != null) {
            return assetFileDescriptor.getParcelFileDescriptor().detachFd();
        }
        return -1;
    }
}
