package com.baidu.searchbox.ugc.utils;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
/* loaded from: classes19.dex */
public class FileHelper {
    public static boolean exists(Uri uri) {
        Context appContext;
        if (uri == null) {
            return false;
        }
        if (UgcUriUtils.isLocalFileUri(uri)) {
            return new File(uri.getPath()).exists();
        }
        if (!UgcUriUtils.isLocalContentUri(uri) || (appContext = AppRuntime.getAppContext()) == null) {
            return false;
        }
        try {
            ParcelFileDescriptor openFileDescriptor = appContext.getContentResolver().openFileDescriptor(uri, "r");
            boolean z = openFileDescriptor != null;
            Closeables.closeSafely(openFileDescriptor);
            return z;
        } catch (FileNotFoundException e) {
            Closeables.closeSafely((Closeable) null);
            return false;
        } catch (Throwable th) {
            Closeables.closeSafely((Closeable) null);
            throw th;
        }
    }

    public static boolean exists(String str) {
        return exists(UgcUriUtils.getUri(str));
    }

    public static InputStream getInputStream(String str) {
        Uri uri = UgcUriUtils.getUri(str);
        if (uri == null) {
            return null;
        }
        if (UgcUriUtils.isLocalContentUri(uri)) {
            Context appContext = AppRuntime.getAppContext();
            if (appContext == null) {
                return null;
            }
            try {
                return appContext.getContentResolver().openInputStream(uri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        } else if (!UgcUriUtils.isLocalFileUri(uri)) {
            return null;
        } else {
            try {
                return new FileInputStream(uri.getPath());
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }
}
