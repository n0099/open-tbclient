package com.baidu.searchbox.downloads.manage;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.net.DownloadProxyHttpClient;
import com.baidu.webkit.sdk.MimeTypeMap;
import java.io.IOException;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.params.ClientPNames;
/* loaded from: classes3.dex */
public class FetchUrlMimeType extends AsyncTask<ContentValues, String, String> {
    @SuppressLint({"StaticFieldLeak"})
    public Context mActivity;
    public ContentValues mValues;

    public FetchUrlMimeType(Context context) {
        this.mActivity = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0085, code lost:
        r3 = r6.getFirstHeader("Content-Type");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008b, code lost:
        if (r3 == null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008d, code lost:
        r3 = r3.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0093, code lost:
        r4 = r3.indexOf(59);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0098, code lost:
        if (r4 == (-1)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009a, code lost:
        r3 = r3.substring(0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009f, code lost:
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a0, code lost:
        r0 = r6.getFirstHeader("Content-Disposition");
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a6, code lost:
        if (r0 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a8, code lost:
        r1 = new java.lang.String(r0.getValue().getBytes("ISO-8859-1"), "utf8");
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00be, code lost:
        if (android.os.Build.VERSION.SDK_INT <= 28) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c0, code lost:
        r11 = com.baidu.searchbox.download.util.FileClassifyHelper.guessFileName(r11, r1, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c5, code lost:
        r11 = android.webkit.URLUtil.guessFileName(r11, r1, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00cd, code lost:
        if (android.text.TextUtils.isEmpty(r11) != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00cf, code lost:
        r10.mValues.put("hint", r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d6, code lost:
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d9, code lost:
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00dc, code lost:
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00df, code lost:
        r1 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0125 A[Catch: all -> 0x0120, TRY_ENTER, TryCatch #1 {all -> 0x0120, blocks: (B:10:0x0044, B:12:0x004b, B:14:0x0051, B:19:0x0062, B:21:0x0068, B:22:0x006d, B:24:0x0073, B:26:0x0079, B:28:0x0085, B:30:0x008d, B:32:0x0093, B:34:0x009a, B:36:0x00a0, B:38:0x00a8, B:39:0x00ba, B:41:0x00c0, B:43:0x00c9, B:45:0x00cf, B:42:0x00c5, B:58:0x00f2, B:60:0x00fa, B:62:0x0104, B:65:0x0115, B:72:0x0125, B:75:0x012c, B:78:0x0133), top: B:87:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x012c A[Catch: all -> 0x0120, TryCatch #1 {all -> 0x0120, blocks: (B:10:0x0044, B:12:0x004b, B:14:0x0051, B:19:0x0062, B:21:0x0068, B:22:0x006d, B:24:0x0073, B:26:0x0079, B:28:0x0085, B:30:0x008d, B:32:0x0093, B:34:0x009a, B:36:0x00a0, B:38:0x00a8, B:39:0x00ba, B:41:0x00c0, B:43:0x00c9, B:45:0x00cf, B:42:0x00c5, B:58:0x00f2, B:60:0x00fa, B:62:0x0104, B:65:0x0115, B:72:0x0125, B:75:0x012c, B:78:0x0133), top: B:87:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0133 A[Catch: all -> 0x0120, TRY_LEAVE, TryCatch #1 {all -> 0x0120, blocks: (B:10:0x0044, B:12:0x004b, B:14:0x0051, B:19:0x0062, B:21:0x0068, B:22:0x006d, B:24:0x0073, B:26:0x0079, B:28:0x0085, B:30:0x008d, B:32:0x0093, B:34:0x009a, B:36:0x00a0, B:38:0x00a8, B:39:0x00ba, B:41:0x00c0, B:43:0x00c9, B:45:0x00cf, B:42:0x00c5, B:58:0x00f2, B:60:0x00fa, B:62:0x0104, B:65:0x0115, B:72:0x0125, B:75:0x012c, B:78:0x0133), top: B:87:0x0044 }] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String doInBackground(ContentValues... contentValuesArr) {
        ContentValues contentValues = contentValuesArr[0];
        this.mValues = contentValues;
        String asString = contentValues.getAsString("uri");
        String str = null;
        if (asString != null && asString.length() != 0) {
            DownloadProxyHttpClient downloadProxyHttpClient = new DownloadProxyHttpClient(this.mValues.getAsString("useragent"));
            downloadProxyHttpClient.getParams().setBooleanParameter(ClientPNames.HANDLE_REDIRECTS, false);
            String asString2 = this.mValues.getAsString("cookiedata");
            String asString3 = this.mValues.getAsString("referer");
            HttpHead httpHead = null;
            int i = 0;
            while (true) {
                if (i >= 5) {
                    break;
                }
                try {
                    try {
                        HttpHead httpHead2 = new HttpHead(asString);
                        if (asString2 != null) {
                            try {
                                if (asString2.length() > 0) {
                                    httpHead2.addHeader("Cookie", asString2);
                                }
                            } catch (IOException unused) {
                                httpHead = httpHead2;
                                if (httpHead != null) {
                                    httpHead.abort();
                                }
                                return str;
                            } catch (IllegalArgumentException unused2) {
                                httpHead = httpHead2;
                                if (httpHead != null) {
                                    httpHead.abort();
                                }
                                return str;
                            } catch (Exception unused3) {
                                httpHead = httpHead2;
                                if (httpHead != null) {
                                    httpHead.abort();
                                }
                                return str;
                            }
                        }
                        if (asString3 != null && asString3.length() > 0) {
                            httpHead2.addHeader("Referer", asString3);
                        }
                        HttpResponse executeSafely = downloadProxyHttpClient.executeSafely(httpHead2);
                        if (executeSafely != null && executeSafely.getStatusLine() != null) {
                            int statusCode = executeSafely.getStatusLine().getStatusCode();
                            if (statusCode != 200) {
                                if (statusCode != 301 && statusCode != 302 && statusCode != 303 && statusCode != 307) {
                                    break;
                                }
                                Header firstHeader = executeSafely.getFirstHeader("Location");
                                if (firstHeader != null) {
                                    String value = firstHeader.getValue();
                                    if (!TextUtils.isEmpty(value)) {
                                        asString = new URI(asString).resolve(value).toString();
                                    } else {
                                        asString = value;
                                    }
                                } else {
                                    asString = null;
                                }
                                if (TextUtils.isEmpty(asString)) {
                                    break;
                                }
                                i++;
                                httpHead = httpHead2;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    } finally {
                        downloadProxyHttpClient.close();
                    }
                } catch (IOException unused4) {
                } catch (IllegalArgumentException unused5) {
                } catch (Exception unused6) {
                }
            }
        }
        return str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        String mimeTypeFromExtension;
        if (str != null) {
            String asString = this.mValues.getAsString("uri");
            if ((str.equalsIgnoreCase("text/plain") || str.equalsIgnoreCase("application/octet-stream")) && (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(asString))) != null) {
                this.mValues.put("mimetype", mimeTypeFromExtension);
            }
        }
        SearchBoxDownloadManager.getInstance(AppRuntime.getAppContext()).beginDownload(this.mValues);
    }
}
