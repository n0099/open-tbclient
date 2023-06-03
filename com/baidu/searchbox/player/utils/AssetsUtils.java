package com.baidu.searchbox.player.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u001a\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u001a\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002\u001a\f\u0010\t\u001a\u00020\n*\u0004\u0018\u00010\u000b¨\u0006\f"}, d2 = {"loadConfigFromAssets", "", "context", "Landroid/content/Context;", "fileName", "loadConfigFromExternalCache", "loadConfigFromInputStream", "inputStream", "Ljava/io/InputStream;", "closeSafe", "", "Ljava/io/Closeable;", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "AssetsUtils")
/* loaded from: classes4.dex */
public final class AssetsUtils {
    public static final void closeSafe(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                BdVideoLog.e(e.getMessage());
            }
        }
    }

    public static final String loadConfigFromAssets(Context context, String str) {
        boolean z;
        InputStream open;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return null;
        }
        if (context != null) {
            try {
                AssetManager assets = context.getAssets();
                if (assets != null) {
                    open = assets.open(str);
                    return loadConfigFromInputStream(context, open);
                }
            } catch (Exception e) {
                BdVideoLog.e(e.getMessage());
                return null;
            }
        }
        open = null;
        return loadConfigFromInputStream(context, open);
    }

    public static final String loadConfigFromExternalCache(Context context, String str) {
        boolean z;
        File externalCacheDir;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return null;
        }
        try {
            if (Intrinsics.areEqual("mounted", Environment.getExternalStorageState()) && context != null && (externalCacheDir = context.getExternalCacheDir()) != null) {
                return loadConfigFromInputStream(context, new FileInputStream(new File(externalCacheDir.getPath(), str)));
            }
        } catch (Exception e) {
            BdVideoLog.e(e.getMessage());
        }
        return null;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x004e: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:29:0x004e */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
    public static final String loadConfigFromInputStream(Context context, InputStream inputStream) {
        Closeable closeable;
        BufferedReader bufferedReader;
        Closeable closeable2 = null;
        if (context != null) {
            try {
                if (inputStream != null) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        try {
                            Ref.ObjectRef objectRef = new Ref.ObjectRef();
                            while (true) {
                                ?? readLine = bufferedReader.readLine();
                                objectRef.element = readLine;
                                if (readLine != 0) {
                                    sb.append((String) readLine);
                                } else {
                                    String sb2 = sb.toString();
                                    closeSafe(bufferedReader);
                                    return sb2;
                                }
                            }
                        } catch (IOException e) {
                            e = e;
                            BdVideoLog.e(e.getMessage());
                            closeSafe(bufferedReader);
                            return null;
                        } catch (JSONException e2) {
                            e = e2;
                            BdVideoLog.e(e.getMessage());
                            closeSafe(bufferedReader);
                            return null;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        bufferedReader = null;
                    } catch (JSONException e4) {
                        e = e4;
                        bufferedReader = null;
                    } catch (Throwable th) {
                        th = th;
                        closeSafe(closeable2);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                closeable2 = closeable;
            }
        }
        return null;
    }
}
