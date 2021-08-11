package c.p.a.e.b.e;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.f.o;
import c.p.a.e.b.f.s;
import c.p.a.e.b.f.z;
import c.p.a.e.b.g.e;
import c.p.a.e.b.g.q;
import c.p.a.e.b.i.i;
import c.p.a.e.b.l.f;
import c.p.a.e.b.o.k;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.g;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                return TextUtils.isDigitsOnly(str) ? String.valueOf(Long.valueOf(str).longValue() % 100) : "";
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static JSONObject b(String str, DownloadInfo downloadInfo, BaseException baseException, int i2) {
        InterceptResult invokeLLLI;
        String str2;
        String str3;
        String str4;
        int i3;
        String str5;
        String str6;
        String str7;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLI = interceptable.invokeLLLI(65537, null, str, downloadInfo, baseException, i2)) != null) {
            return (JSONObject) invokeLLLI.objValue;
        }
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                q z0 = e.z0();
                if (z0 != null) {
                    str2 = z0.b();
                    str3 = a(str2);
                    str4 = z0.a();
                    i3 = z0.c();
                } else {
                    str2 = "";
                    str3 = str2;
                    str4 = str3;
                    i3 = 0;
                }
                String a2 = (baseException == null || !(baseException instanceof g)) ? "" : ((g) baseException).a();
                jSONObject2.put("event_page", str);
                jSONObject2.put("app_id", str4);
                jSONObject2.put("device_id", str2);
                jSONObject2.put("device_id_postfix", str3);
                jSONObject2.put("update_version", i3);
                jSONObject2.put("download_status", i2);
                if (downloadInfo != null) {
                    jSONObject2.put("setting_tag", c.p.a.e.b.j.a.d(downloadInfo.getId()).t("setting_tag"));
                    jSONObject2.put("download_id", downloadInfo.getId());
                    jSONObject2.put("name", downloadInfo.getName());
                    jSONObject2.put("url", downloadInfo.getUrl());
                    jSONObject2.put("save_path", downloadInfo.getSavePath());
                    jSONObject2.put("download_time", downloadInfo.getDownloadTime());
                    jSONObject2.put("cur_bytes", downloadInfo.getCurBytes());
                    jSONObject2.put(DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES, downloadInfo.getTotalBytes());
                    jSONObject2.put("network_quality", downloadInfo.getNetworkQuality());
                    int i4 = 1;
                    jSONObject2.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                    jSONObject2.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                    jSONObject2.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                    jSONObject2.put(PackageTable.MD5, downloadInfo.getMd5() == null ? "" : downloadInfo.getMd5());
                    jSONObject2.put("chunk_count", downloadInfo.getChunkCount());
                    jSONObject2.put("is_force", downloadInfo.isForce() ? 1 : 0);
                    jSONObject2.put("retry_count", downloadInfo.getRetryCount());
                    jSONObject2.put("cur_retry_time", downloadInfo.getCurRetryTime());
                    jSONObject2.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                    jSONObject2.put("need_reuse_first_connection", downloadInfo.isNeedReuseFirstConnection() ? 1 : 0);
                    jSONObject2.put("default_http_service_backup", downloadInfo.isNeedDefaultHttpServiceBackUp() ? 1 : 0);
                    jSONObject2.put("retry_delay_status", downloadInfo.getRetryDelayStatus().ordinal());
                    jSONObject2.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                    jSONObject2.put("download_byte_error_retry_status", downloadInfo.getByteInvalidRetryStatus().ordinal());
                    jSONObject2.put("forbidden_handler_status", downloadInfo.getAsyncHandleStatus().ordinal());
                    jSONObject2.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                    jSONObject2.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                    jSONObject2.put("extra", downloadInfo.getExtra() != null ? downloadInfo.getExtra() : "");
                    if (!downloadInfo.isAddListenerToSameTask()) {
                        i4 = 0;
                    }
                    jSONObject2.put("add_listener_to_same_task", i4);
                    jSONObject2.put("backup_url_count", downloadInfo.getBackUpUrls() != null ? downloadInfo.getBackUpUrls().size() : 0);
                    jSONObject2.put("cur_backup_url_index", downloadInfo.getBackUpUrls() != null ? downloadInfo.getCurBackUpUrlIndex() : -1);
                    jSONObject2.put("forbidden_urls", downloadInfo.getForbiddenBackupUrls() != null ? downloadInfo.getForbiddenBackupUrls().toString() : "");
                    jSONObject2.put("task_id", TextUtils.isEmpty(downloadInfo.getTaskId()) ? "" : downloadInfo.getTaskId());
                    String url = downloadInfo.getUrl();
                    if (TextUtils.isEmpty(url)) {
                        str5 = "";
                        str6 = str5;
                        str7 = str6;
                    } else {
                        Uri parse = Uri.parse(url);
                        str6 = parse.getHost();
                        str7 = parse.getPath();
                        str5 = parse.getLastPathSegment();
                        if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str5)) {
                            try {
                                str7 = str7.substring(0, str7.length() - str5.length());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                    jSONObject2.put("url_host", str6);
                    jSONObject2.put("url_path", str7);
                    jSONObject2.put("url_last_path_segment", str5);
                }
                jSONObject2.put("error_code", baseException != null ? baseException.getErrorCode() : 0);
                jSONObject2.put("error_msg", baseException != null ? baseException.getErrorMessage() : "");
                jSONObject2.put("request_log", a2);
                return jSONObject2;
            } catch (JSONException e2) {
                e = e2;
                jSONObject = jSONObject2;
                e.printStackTrace();
                return jSONObject;
            }
        } catch (JSONException e3) {
            e = e3;
        }
    }

    public static void c(int i2, JSONObject jSONObject, DownloadInfo downloadInfo) throws JSONException {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65538, null, i2, jSONObject, downloadInfo) == null) {
            if (i2 == -5) {
                str = "download_uncomplete";
            } else if (i2 == -4) {
                str = "download_cancel";
            } else if (i2 != -3) {
                str = i2 != -2 ? i2 != 0 ? i2 != 2 ? i2 != 6 ? "" : "download_first_start" : "download_start" : "download_create" : "download_pause";
            } else {
                double downloadSpeed = downloadInfo.getDownloadSpeed();
                if (downloadSpeed >= 0.0d) {
                    jSONObject.put("download_speed", downloadSpeed);
                }
                str = "download_success";
            }
            jSONObject.put("status", str);
        }
    }

    public static void d(b bVar, DownloadInfo downloadInfo, BaseException baseException, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65539, null, bVar, downloadInfo, baseException, i2) == null) || bVar == null || !downloadInfo.isNeedSDKMonitor() || TextUtils.isEmpty(downloadInfo.getMonitorScene())) {
            return;
        }
        try {
            JSONObject b2 = b(downloadInfo.getMonitorScene(), downloadInfo, baseException, i2);
            if (b2 == null) {
                b2 = new JSONObject();
            }
            if (i2 == -1) {
                b2.put("status", baseException.getErrorCode());
                bVar.a("download_failed", b2, null, null);
                return;
            }
            c(i2, b2, downloadInfo);
            bVar.a("download_common", b2, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void e(z zVar, DownloadInfo downloadInfo, BaseException baseException, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, zVar, downloadInfo, baseException, i2) == null) || zVar == null) {
            return;
        }
        try {
            String b2 = zVar.b();
            if (TextUtils.isEmpty(b2)) {
                b2 = "default";
            }
            JSONObject b3 = b(b2, downloadInfo, baseException, i2);
            if (b3 == null) {
                b3 = new JSONObject();
            }
            zVar.a(b3);
        } catch (Throwable unused) {
        }
    }

    public static void f(c.p.a.e.b.j.a aVar, DownloadInfo downloadInfo, String str, k kVar, boolean z, boolean z2, BaseException baseException, long j2, long j3, boolean z3, long j4, long j5, long j6, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{aVar, downloadInfo, str, kVar, Boolean.valueOf(z), Boolean.valueOf(z2), baseException, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), jSONObject}) == null) {
            k("download_io", aVar.m("monitor_download_io"), aVar, downloadInfo, str, null, null, kVar, z, z2, baseException, j2, j3, z3, j4, j5, j6, null);
        }
    }

    public static void g(c.p.a.e.b.j.a aVar, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z, k kVar, BaseException baseException, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{aVar, downloadInfo, str, str2, str3, Boolean.valueOf(z), kVar, baseException, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            k("segment_io", aVar.m("monitor_segment_io"), aVar, downloadInfo, str, str2, str3, kVar, z, false, baseException, j2, j3, false, -1L, -1L, -1L, null);
        }
    }

    public static void h(DownloadInfo downloadInfo, List<i> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, downloadInfo, list) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("segments", i.b(list));
                jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject.put(DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES, downloadInfo.getTotalBytes());
                c p = e.p();
                if (p != null) {
                    p.b(downloadInfo.getId(), "segments_error", jSONObject);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void i(c.p.a.e.b.n.a aVar, BaseException baseException, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65544, null, aVar, baseException, i2) == null) || aVar == null) {
            return;
        }
        try {
            DownloadInfo J = aVar.J();
            if (J == null) {
                return;
            }
            z R = aVar.R();
            boolean d2 = c.p.a.e.b.d.a.d(i2);
            if (!d2 && !(d2 = l(J.getExtraMonitorStatus(), i2)) && R != null && (R instanceof o)) {
                d2 = l(((o) R).a(), i2);
            }
            if (d2) {
                s E = aVar.E();
                if (E != null) {
                    E.a(J, baseException, i2);
                }
                e(R, J, baseException, i2);
                d(e.t0(), J, baseException, i2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:13|(4:71|72|73|(16:75|76|16|(2:51|(1:(2:59|(1:61)(3:62|63|64)))(1:56))|19|20|(2:24|25)|28|29|30|(1:32)|33|34|(1:46)|37|(2:41|43)(1:40)))|15|16|(0)|51|(1:53)|(0)|19|20|(3:22|24|25)|28|29|30|(0)|33|34|(0)|44|46|37|(0)|41|43) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0118, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0119, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005c A[Catch: all -> 0x013e, TRY_LEAVE, TryCatch #3 {all -> 0x013e, blocks: (B:20:0x0033, B:22:0x0037, B:46:0x0083, B:48:0x0099, B:51:0x00ac, B:52:0x00b1, B:54:0x00ed, B:55:0x00fe, B:68:0x0132, B:62:0x0124, B:64:0x012a, B:58:0x0119, B:28:0x004b, B:30:0x0051, B:35:0x005c, B:38:0x0069, B:42:0x006f, B:44:0x007b, B:15:0x0029), top: B:81:0x0029, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ed A[Catch: JSONException -> 0x0118, all -> 0x013e, TryCatch #1 {JSONException -> 0x0118, blocks: (B:52:0x00b1, B:54:0x00ed, B:55:0x00fe), top: B:79:0x00b1, outer: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void j(@Nullable c.p.a.e.b.o.i iVar, String str, String str2, long j2, String str3, int i2, IOException iOException, DownloadInfo downloadInfo) {
        c.p.a.e.b.j.a d2;
        int b2;
        String e2;
        String errorMessage;
        int httpStatusCode;
        String path;
        String lastPathSegment;
        JSONObject jSONObject;
        b t0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{iVar, str, str2, Long.valueOf(j2), str3, Integer.valueOf(i2), iOException, downloadInfo}) == null) || downloadInfo == null || (b2 = (d2 = c.p.a.e.b.j.a.d(downloadInfo.getId())).b("monitor_download_connect", 0)) <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        int i3 = -1;
        if (iVar != null) {
            try {
                i3 = iVar.b();
                if (iVar instanceof c.p.a.e.b.o.c) {
                    e2 = ((c.p.a.e.b.o.c) iVar).e();
                    String str4 = "";
                    if (i3 >= 200 || i3 >= 400) {
                        if (downloadInfo.getCurRetryTime() == 0 && ((httpStatusCode = downloadInfo.getHttpStatusCode()) < 200 || httpStatusCode >= 400)) {
                            return;
                        }
                        if (iOException != null) {
                            if (f.r0(e.n())) {
                                try {
                                    f.B(iOException, "");
                                    throw null;
                                } catch (BaseException e3) {
                                    i3 = e3.getErrorCode();
                                    errorMessage = e3.getErrorMessage();
                                    if (e3 instanceof g) {
                                        str4 = ((g) e3).a();
                                    }
                                }
                            } else {
                                i3 = SDKLogTypeConstants.TYPE_LP_LOAD_URL;
                            }
                        }
                    }
                    errorMessage = null;
                    Uri parse = Uri.parse(str);
                    String host = parse.getHost();
                    path = parse.getPath();
                    lastPathSegment = parse.getLastPathSegment();
                    if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                        try {
                            path = path.substring(0, path.length() - lastPathSegment.length());
                        } catch (Throwable unused) {
                        }
                    }
                    jSONObject = new JSONObject();
                    jSONObject.put("setting_tag", d2.t("setting_tag"));
                    jSONObject.put("url_host", host);
                    jSONObject.putOpt("host_ip", str2);
                    jSONObject.putOpt("host_real_ip", e2);
                    jSONObject.put("url_path", path);
                    jSONObject.put("url_last_path_segment", lastPathSegment);
                    jSONObject.put("net_lib", i2);
                    jSONObject.put("connect_type", str3);
                    jSONObject.put("status_code", i3);
                    jSONObject.put("request_log", str4);
                    if (errorMessage != null) {
                        jSONObject.put("error_msg", f.k(errorMessage, d2.b("exception_msg_length", 500)));
                    }
                    jSONObject.put("connect_time", j2);
                    jSONObject.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, downloadInfo.getPackageName());
                    jSONObject.put("name", downloadInfo.getTitle());
                    if ((b2 != 1 || b2 == 3) && (t0 = e.t0()) != null) {
                        t0.a("download_connect", jSONObject, null, null);
                    }
                    if (b2 != 2 || b2 == 3) {
                        e.p().b(downloadInfo.getId(), "download_connect", jSONObject);
                    }
                    return;
                }
            }
        }
        e2 = null;
        String str42 = "";
        if (i3 >= 200) {
        }
        if (downloadInfo.getCurRetryTime() == 0) {
        }
        if (iOException != null) {
        }
        errorMessage = null;
        Uri parse2 = Uri.parse(str);
        String host2 = parse2.getHost();
        path = parse2.getPath();
        lastPathSegment = parse2.getLastPathSegment();
        if (!TextUtils.isEmpty(path)) {
            path = path.substring(0, path.length() - lastPathSegment.length());
        }
        jSONObject = new JSONObject();
        jSONObject.put("setting_tag", d2.t("setting_tag"));
        jSONObject.put("url_host", host2);
        jSONObject.putOpt("host_ip", str2);
        jSONObject.putOpt("host_real_ip", e2);
        jSONObject.put("url_path", path);
        jSONObject.put("url_last_path_segment", lastPathSegment);
        jSONObject.put("net_lib", i2);
        jSONObject.put("connect_type", str3);
        jSONObject.put("status_code", i3);
        jSONObject.put("request_log", str42);
        if (errorMessage != null) {
        }
        jSONObject.put("connect_time", j2);
        jSONObject.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, downloadInfo.getPackageName());
        jSONObject.put("name", downloadInfo.getTitle());
        if (b2 != 1) {
        }
        t0.a("download_connect", jSONObject, null, null);
        if (b2 != 2) {
        }
        e.p().b(downloadInfo.getId(), "download_connect", jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0074 A[Catch: all -> 0x0192, TryCatch #0 {all -> 0x0192, blocks: (B:9:0x001a, B:11:0x0031, B:28:0x0069, B:30:0x0074, B:34:0x007b, B:36:0x0087, B:37:0x0091, B:41:0x009e, B:43:0x00a2, B:44:0x00a8, B:46:0x00ac, B:49:0x00bf, B:51:0x010c, B:52:0x011d, B:54:0x012f, B:56:0x0138, B:57:0x0153, B:69:0x0186, B:62:0x0172, B:64:0x0178, B:22:0x0051, B:26:0x0062, B:25:0x005e), top: B:77:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010c A[Catch: all -> 0x0192, TryCatch #0 {all -> 0x0192, blocks: (B:9:0x001a, B:11:0x0031, B:28:0x0069, B:30:0x0074, B:34:0x007b, B:36:0x0087, B:37:0x0091, B:41:0x009e, B:43:0x00a2, B:44:0x00a8, B:46:0x00ac, B:49:0x00bf, B:51:0x010c, B:52:0x011d, B:54:0x012f, B:56:0x0138, B:57:0x0153, B:69:0x0186, B:62:0x0172, B:64:0x0178, B:22:0x0051, B:26:0x0062, B:25:0x005e), top: B:77:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012f A[Catch: all -> 0x0192, TryCatch #0 {all -> 0x0192, blocks: (B:9:0x001a, B:11:0x0031, B:28:0x0069, B:30:0x0074, B:34:0x007b, B:36:0x0087, B:37:0x0091, B:41:0x009e, B:43:0x00a2, B:44:0x00a8, B:46:0x00ac, B:49:0x00bf, B:51:0x010c, B:52:0x011d, B:54:0x012f, B:56:0x0138, B:57:0x0153, B:69:0x0186, B:62:0x0172, B:64:0x0178, B:22:0x0051, B:26:0x0062, B:25:0x005e), top: B:77:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0138 A[Catch: all -> 0x0192, TryCatch #0 {all -> 0x0192, blocks: (B:9:0x001a, B:11:0x0031, B:28:0x0069, B:30:0x0074, B:34:0x007b, B:36:0x0087, B:37:0x0091, B:41:0x009e, B:43:0x00a2, B:44:0x00a8, B:46:0x00ac, B:49:0x00bf, B:51:0x010c, B:52:0x011d, B:54:0x012f, B:56:0x0138, B:57:0x0153, B:69:0x0186, B:62:0x0172, B:64:0x0178, B:22:0x0051, B:26:0x0062, B:25:0x005e), top: B:77:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0178 A[Catch: all -> 0x0192, TryCatch #0 {all -> 0x0192, blocks: (B:9:0x001a, B:11:0x0031, B:28:0x0069, B:30:0x0074, B:34:0x007b, B:36:0x0087, B:37:0x0091, B:41:0x009e, B:43:0x00a2, B:44:0x00a8, B:46:0x00ac, B:49:0x00bf, B:51:0x010c, B:52:0x011d, B:54:0x012f, B:56:0x0138, B:57:0x0153, B:69:0x0186, B:62:0x0172, B:64:0x0178, B:22:0x0051, B:26:0x0062, B:25:0x005e), top: B:77:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0184 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r17v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void k(String str, int i2, c.p.a.e.b.j.a aVar, DownloadInfo downloadInfo, String str2, String str3, String str4, k kVar, boolean z, boolean z2, BaseException baseException, long j2, long j3, boolean z3, long j4, long j5, long j6, JSONObject jSONObject) {
        int i3;
        String errorMessage;
        long j7;
        String str5;
        int i4;
        int i5;
        double nanos;
        b t0;
        String str6;
        int i6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i2), aVar, downloadInfo, str2, str3, str4, kVar, Boolean.valueOf(z), Boolean.valueOf(z2), baseException, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), jSONObject}) == null) || i2 <= 0 || j3 <= 0) {
            return;
        }
        try {
            Uri parse = Uri.parse(str2);
            String host = parse.getHost();
            String path = parse.getPath();
            String lastPathSegment = parse.getLastPathSegment();
            if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                try {
                    path = path.substring(0, path.length() - lastPathSegment.length());
                } catch (Throwable unused) {
                }
            }
            if (z) {
                i3 = 1;
            } else if (z2) {
                i3 = 2;
            } else if (baseException != null) {
                i3 = !f.r0(e.n()) ? SDKLogTypeConstants.TYPE_LP_LOAD_URL : baseException.getErrorCode();
                errorMessage = baseException.getErrorMessage();
                JSONObject jSONObject2 = new JSONObject();
                if (kVar == null) {
                    i4 = kVar instanceof c.p.a.e.b.o.g ? 0 : 1;
                    String a2 = kVar.a("X-Cache");
                    int contains = TextUtils.isEmpty(a2) ? -1 : a2.toLowerCase().contains("hit");
                    if (aVar.b("monitor_sla", 1) == 1 && !z && !z2 && (kVar instanceof c.p.a.e.b.o.c)) {
                        ((c.p.a.e.b.o.c) kVar).c(jSONObject2, true);
                    }
                    j7 = j2;
                    str5 = kVar instanceof c.p.a.e.b.o.c ? ((c.p.a.e.b.o.c) kVar).f() : "";
                    i5 = contains;
                } else {
                    j7 = j2;
                    str5 = "";
                    i4 = -1;
                    i5 = -1;
                }
                double d2 = j7 / 1048576.0d;
                double d3 = j3;
                nanos = d3 / TimeUnit.SECONDS.toNanos(1L);
                jSONObject2.put("setting_tag", aVar.t("setting_tag"));
                jSONObject2.put("url_host", host);
                jSONObject2.putOpt("host_ip", str3);
                jSONObject2.putOpt("host_real_ip", str4);
                jSONObject2.put("url_path", path);
                jSONObject2.put("url_last_path_segment", lastPathSegment);
                jSONObject2.put("net_lib", i4);
                jSONObject2.put("hit_cdn_cache", i5);
                jSONObject2.put("status_code", i3);
                jSONObject2.put("request_log", str5);
                if (errorMessage != null) {
                    jSONObject2.put("error_msg", f.k(errorMessage, aVar.b("exception_msg_length", 500)));
                }
                jSONObject2.put("download_sec", nanos);
                jSONObject2.put("download_mb", d2);
                if (nanos > 0.0d) {
                    jSONObject2.put("download_speed", d2 / nanos);
                }
                if (z3) {
                    jSONObject2.put("rw_read_time", j4 / d3);
                    jSONObject2.put("rw_write_time", j5 / d3);
                    jSONObject2.put("rw_sync_time", j6 / d3);
                }
                jSONObject2.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, downloadInfo.getPackageName());
                jSONObject2.put("name", downloadInfo.getTitle());
                if (i2 != 1 && i2 != 3) {
                    i6 = 2;
                    str6 = str;
                    if (i2 != i6 || i2 == 3) {
                        e.p().b(downloadInfo.getId(), str6, jSONObject2);
                    }
                    return;
                }
                t0 = e.t0();
                if (t0 == null) {
                    str6 = str;
                    t0.a(str6, jSONObject2, null, null);
                } else {
                    str6 = str;
                }
                i6 = 2;
                if (i2 != i6) {
                }
                e.p().b(downloadInfo.getId(), str6, jSONObject2);
            } else {
                i3 = 0;
            }
            errorMessage = null;
            JSONObject jSONObject22 = new JSONObject();
            if (kVar == null) {
            }
            double d22 = j7 / 1048576.0d;
            double d32 = j3;
            nanos = d32 / TimeUnit.SECONDS.toNanos(1L);
            jSONObject22.put("setting_tag", aVar.t("setting_tag"));
            jSONObject22.put("url_host", host);
            jSONObject22.putOpt("host_ip", str3);
            jSONObject22.putOpt("host_real_ip", str4);
            jSONObject22.put("url_path", path);
            jSONObject22.put("url_last_path_segment", lastPathSegment);
            jSONObject22.put("net_lib", i4);
            jSONObject22.put("hit_cdn_cache", i5);
            jSONObject22.put("status_code", i3);
            jSONObject22.put("request_log", str5);
            if (errorMessage != null) {
            }
            jSONObject22.put("download_sec", nanos);
            jSONObject22.put("download_mb", d22);
            if (nanos > 0.0d) {
            }
            if (z3) {
            }
            jSONObject22.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, downloadInfo.getPackageName());
            jSONObject22.put("name", downloadInfo.getTitle());
            if (i2 != 1) {
                i6 = 2;
                str6 = str;
                if (i2 != i6) {
                }
                e.p().b(downloadInfo.getId(), str6, jSONObject22);
            }
            t0 = e.t0();
            if (t0 == null) {
            }
            i6 = 2;
            if (i2 != i6) {
            }
            e.p().b(downloadInfo.getId(), str6, jSONObject22);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean l(int[] iArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, iArr, i2)) == null) {
            if (iArr != null && iArr.length > 0) {
                for (int i3 : iArr) {
                    if (i2 == i3) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }
}
