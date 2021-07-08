package com.baidu.idl.util;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public class HttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HttpRequest";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(617623317, "Lcom/baidu/idl/util/HttpRequest;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(617623317, "Lcom/baidu/idl/util/HttpRequest;");
        }
    }

    public HttpRequest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:146:0x01c2 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x009e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x00a1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x00a4 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x00a7 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x00aa */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0153 A[Catch: IOException -> 0x01a8, TryCatch #27 {IOException -> 0x01a8, blocks: (B:41:0x00cd, B:43:0x00d2, B:45:0x00d7, B:47:0x00dc, B:85:0x012a, B:87:0x012f, B:89:0x0134, B:91:0x0139, B:97:0x0149, B:99:0x014e, B:101:0x0153, B:103:0x0158, B:109:0x0168, B:111:0x016d, B:113:0x0172, B:115:0x0177, B:121:0x0186, B:123:0x018b, B:125:0x0190, B:127:0x0195, B:133:0x01a4, B:137:0x01ac, B:139:0x01b1, B:141:0x01b6), top: B:168:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0158 A[Catch: IOException -> 0x01a8, TRY_LEAVE, TryCatch #27 {IOException -> 0x01a8, blocks: (B:41:0x00cd, B:43:0x00d2, B:45:0x00d7, B:47:0x00dc, B:85:0x012a, B:87:0x012f, B:89:0x0134, B:91:0x0139, B:97:0x0149, B:99:0x014e, B:101:0x0153, B:103:0x0158, B:109:0x0168, B:111:0x016d, B:113:0x0172, B:115:0x0177, B:121:0x0186, B:123:0x018b, B:125:0x0190, B:127:0x0195, B:133:0x01a4, B:137:0x01ac, B:139:0x01b1, B:141:0x01b6), top: B:168:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0168 A[Catch: IOException -> 0x01a8, TRY_ENTER, TryCatch #27 {IOException -> 0x01a8, blocks: (B:41:0x00cd, B:43:0x00d2, B:45:0x00d7, B:47:0x00dc, B:85:0x012a, B:87:0x012f, B:89:0x0134, B:91:0x0139, B:97:0x0149, B:99:0x014e, B:101:0x0153, B:103:0x0158, B:109:0x0168, B:111:0x016d, B:113:0x0172, B:115:0x0177, B:121:0x0186, B:123:0x018b, B:125:0x0190, B:127:0x0195, B:133:0x01a4, B:137:0x01ac, B:139:0x01b1, B:141:0x01b6), top: B:168:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x016d A[Catch: IOException -> 0x01a8, TryCatch #27 {IOException -> 0x01a8, blocks: (B:41:0x00cd, B:43:0x00d2, B:45:0x00d7, B:47:0x00dc, B:85:0x012a, B:87:0x012f, B:89:0x0134, B:91:0x0139, B:97:0x0149, B:99:0x014e, B:101:0x0153, B:103:0x0158, B:109:0x0168, B:111:0x016d, B:113:0x0172, B:115:0x0177, B:121:0x0186, B:123:0x018b, B:125:0x0190, B:127:0x0195, B:133:0x01a4, B:137:0x01ac, B:139:0x01b1, B:141:0x01b6), top: B:168:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0172 A[Catch: IOException -> 0x01a8, TryCatch #27 {IOException -> 0x01a8, blocks: (B:41:0x00cd, B:43:0x00d2, B:45:0x00d7, B:47:0x00dc, B:85:0x012a, B:87:0x012f, B:89:0x0134, B:91:0x0139, B:97:0x0149, B:99:0x014e, B:101:0x0153, B:103:0x0158, B:109:0x0168, B:111:0x016d, B:113:0x0172, B:115:0x0177, B:121:0x0186, B:123:0x018b, B:125:0x0190, B:127:0x0195, B:133:0x01a4, B:137:0x01ac, B:139:0x01b1, B:141:0x01b6), top: B:168:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0177 A[Catch: IOException -> 0x01a8, TRY_LEAVE, TryCatch #27 {IOException -> 0x01a8, blocks: (B:41:0x00cd, B:43:0x00d2, B:45:0x00d7, B:47:0x00dc, B:85:0x012a, B:87:0x012f, B:89:0x0134, B:91:0x0139, B:97:0x0149, B:99:0x014e, B:101:0x0153, B:103:0x0158, B:109:0x0168, B:111:0x016d, B:113:0x0172, B:115:0x0177, B:121:0x0186, B:123:0x018b, B:125:0x0190, B:127:0x0195, B:133:0x01a4, B:137:0x01ac, B:139:0x01b1, B:141:0x01b6), top: B:168:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0186 A[Catch: IOException -> 0x01a8, TRY_ENTER, TryCatch #27 {IOException -> 0x01a8, blocks: (B:41:0x00cd, B:43:0x00d2, B:45:0x00d7, B:47:0x00dc, B:85:0x012a, B:87:0x012f, B:89:0x0134, B:91:0x0139, B:97:0x0149, B:99:0x014e, B:101:0x0153, B:103:0x0158, B:109:0x0168, B:111:0x016d, B:113:0x0172, B:115:0x0177, B:121:0x0186, B:123:0x018b, B:125:0x0190, B:127:0x0195, B:133:0x01a4, B:137:0x01ac, B:139:0x01b1, B:141:0x01b6), top: B:168:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x018b A[Catch: IOException -> 0x01a8, TryCatch #27 {IOException -> 0x01a8, blocks: (B:41:0x00cd, B:43:0x00d2, B:45:0x00d7, B:47:0x00dc, B:85:0x012a, B:87:0x012f, B:89:0x0134, B:91:0x0139, B:97:0x0149, B:99:0x014e, B:101:0x0153, B:103:0x0158, B:109:0x0168, B:111:0x016d, B:113:0x0172, B:115:0x0177, B:121:0x0186, B:123:0x018b, B:125:0x0190, B:127:0x0195, B:133:0x01a4, B:137:0x01ac, B:139:0x01b1, B:141:0x01b6), top: B:168:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0190 A[Catch: IOException -> 0x01a8, TryCatch #27 {IOException -> 0x01a8, blocks: (B:41:0x00cd, B:43:0x00d2, B:45:0x00d7, B:47:0x00dc, B:85:0x012a, B:87:0x012f, B:89:0x0134, B:91:0x0139, B:97:0x0149, B:99:0x014e, B:101:0x0153, B:103:0x0158, B:109:0x0168, B:111:0x016d, B:113:0x0172, B:115:0x0177, B:121:0x0186, B:123:0x018b, B:125:0x0190, B:127:0x0195, B:133:0x01a4, B:137:0x01ac, B:139:0x01b1, B:141:0x01b6), top: B:168:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0195 A[Catch: IOException -> 0x01a8, TRY_LEAVE, TryCatch #27 {IOException -> 0x01a8, blocks: (B:41:0x00cd, B:43:0x00d2, B:45:0x00d7, B:47:0x00dc, B:85:0x012a, B:87:0x012f, B:89:0x0134, B:91:0x0139, B:97:0x0149, B:99:0x014e, B:101:0x0153, B:103:0x0158, B:109:0x0168, B:111:0x016d, B:113:0x0172, B:115:0x0177, B:121:0x0186, B:123:0x018b, B:125:0x0190, B:127:0x0195, B:133:0x01a4, B:137:0x01ac, B:139:0x01b1, B:141:0x01b6), top: B:168:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a4 A[Catch: IOException -> 0x01a8, TRY_ENTER, TryCatch #27 {IOException -> 0x01a8, blocks: (B:41:0x00cd, B:43:0x00d2, B:45:0x00d7, B:47:0x00dc, B:85:0x012a, B:87:0x012f, B:89:0x0134, B:91:0x0139, B:97:0x0149, B:99:0x014e, B:101:0x0153, B:103:0x0158, B:109:0x0168, B:111:0x016d, B:113:0x0172, B:115:0x0177, B:121:0x0186, B:123:0x018b, B:125:0x0190, B:127:0x0195, B:133:0x01a4, B:137:0x01ac, B:139:0x01b1, B:141:0x01b6), top: B:168:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ac A[Catch: IOException -> 0x01a8, TryCatch #27 {IOException -> 0x01a8, blocks: (B:41:0x00cd, B:43:0x00d2, B:45:0x00d7, B:47:0x00dc, B:85:0x012a, B:87:0x012f, B:89:0x0134, B:91:0x0139, B:97:0x0149, B:99:0x014e, B:101:0x0153, B:103:0x0158, B:109:0x0168, B:111:0x016d, B:113:0x0172, B:115:0x0177, B:121:0x0186, B:123:0x018b, B:125:0x0190, B:127:0x0195, B:133:0x01a4, B:137:0x01ac, B:139:0x01b1, B:141:0x01b6), top: B:168:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b1 A[Catch: IOException -> 0x01a8, TryCatch #27 {IOException -> 0x01a8, blocks: (B:41:0x00cd, B:43:0x00d2, B:45:0x00d7, B:47:0x00dc, B:85:0x012a, B:87:0x012f, B:89:0x0134, B:91:0x0139, B:97:0x0149, B:99:0x014e, B:101:0x0153, B:103:0x0158, B:109:0x0168, B:111:0x016d, B:113:0x0172, B:115:0x0177, B:121:0x0186, B:123:0x018b, B:125:0x0190, B:127:0x0195, B:133:0x01a4, B:137:0x01ac, B:139:0x01b1, B:141:0x01b6), top: B:168:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b6 A[Catch: IOException -> 0x01a8, TRY_LEAVE, TryCatch #27 {IOException -> 0x01a8, blocks: (B:41:0x00cd, B:43:0x00d2, B:45:0x00d7, B:47:0x00dc, B:85:0x012a, B:87:0x012f, B:89:0x0134, B:91:0x0139, B:97:0x0149, B:99:0x014e, B:101:0x0153, B:103:0x0158, B:109:0x0168, B:111:0x016d, B:113:0x0172, B:115:0x0177, B:121:0x0186, B:123:0x018b, B:125:0x0190, B:127:0x0195, B:133:0x01a4, B:137:0x01ac, B:139:0x01b1, B:141:0x01b6), top: B:168:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01ce A[Catch: IOException -> 0x01ca, TryCatch #10 {IOException -> 0x01ca, blocks: (B:149:0x01c6, B:153:0x01ce, B:155:0x01d3, B:157:0x01d8), top: B:165:0x01c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d3 A[Catch: IOException -> 0x01ca, TryCatch #10 {IOException -> 0x01ca, blocks: (B:149:0x01c6, B:153:0x01ce, B:155:0x01d3, B:157:0x01d8), top: B:165:0x01c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01d8 A[Catch: IOException -> 0x01ca, TRY_LEAVE, TryCatch #10 {IOException -> 0x01ca, blocks: (B:149:0x01c6, B:153:0x01ce, B:155:0x01d3, B:157:0x01d8), top: B:165:0x01c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x012a A[Catch: IOException -> 0x01a8, TRY_ENTER, TryCatch #27 {IOException -> 0x01a8, blocks: (B:41:0x00cd, B:43:0x00d2, B:45:0x00d7, B:47:0x00dc, B:85:0x012a, B:87:0x012f, B:89:0x0134, B:91:0x0139, B:97:0x0149, B:99:0x014e, B:101:0x0153, B:103:0x0158, B:109:0x0168, B:111:0x016d, B:113:0x0172, B:115:0x0177, B:121:0x0186, B:123:0x018b, B:125:0x0190, B:127:0x0195, B:133:0x01a4, B:137:0x01ac, B:139:0x01b1, B:141:0x01b6), top: B:168:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x012f A[Catch: IOException -> 0x01a8, TryCatch #27 {IOException -> 0x01a8, blocks: (B:41:0x00cd, B:43:0x00d2, B:45:0x00d7, B:47:0x00dc, B:85:0x012a, B:87:0x012f, B:89:0x0134, B:91:0x0139, B:97:0x0149, B:99:0x014e, B:101:0x0153, B:103:0x0158, B:109:0x0168, B:111:0x016d, B:113:0x0172, B:115:0x0177, B:121:0x0186, B:123:0x018b, B:125:0x0190, B:127:0x0195, B:133:0x01a4, B:137:0x01ac, B:139:0x01b1, B:141:0x01b6), top: B:168:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0134 A[Catch: IOException -> 0x01a8, TryCatch #27 {IOException -> 0x01a8, blocks: (B:41:0x00cd, B:43:0x00d2, B:45:0x00d7, B:47:0x00dc, B:85:0x012a, B:87:0x012f, B:89:0x0134, B:91:0x0139, B:97:0x0149, B:99:0x014e, B:101:0x0153, B:103:0x0158, B:109:0x0168, B:111:0x016d, B:113:0x0172, B:115:0x0177, B:121:0x0186, B:123:0x018b, B:125:0x0190, B:127:0x0195, B:133:0x01a4, B:137:0x01ac, B:139:0x01b1, B:141:0x01b6), top: B:168:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0139 A[Catch: IOException -> 0x01a8, TRY_LEAVE, TryCatch #27 {IOException -> 0x01a8, blocks: (B:41:0x00cd, B:43:0x00d2, B:45:0x00d7, B:47:0x00dc, B:85:0x012a, B:87:0x012f, B:89:0x0134, B:91:0x0139, B:97:0x0149, B:99:0x014e, B:101:0x0153, B:103:0x0158, B:109:0x0168, B:111:0x016d, B:113:0x0172, B:115:0x0177, B:121:0x0186, B:123:0x018b, B:125:0x0190, B:127:0x0195, B:133:0x01a4, B:137:0x01ac, B:139:0x01b1, B:141:0x01b6), top: B:168:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0149 A[Catch: IOException -> 0x01a8, TRY_ENTER, TryCatch #27 {IOException -> 0x01a8, blocks: (B:41:0x00cd, B:43:0x00d2, B:45:0x00d7, B:47:0x00dc, B:85:0x012a, B:87:0x012f, B:89:0x0134, B:91:0x0139, B:97:0x0149, B:99:0x014e, B:101:0x0153, B:103:0x0158, B:109:0x0168, B:111:0x016d, B:113:0x0172, B:115:0x0177, B:121:0x0186, B:123:0x018b, B:125:0x0190, B:127:0x0195, B:133:0x01a4, B:137:0x01ac, B:139:0x01b1, B:141:0x01b6), top: B:168:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x014e A[Catch: IOException -> 0x01a8, TryCatch #27 {IOException -> 0x01a8, blocks: (B:41:0x00cd, B:43:0x00d2, B:45:0x00d7, B:47:0x00dc, B:85:0x012a, B:87:0x012f, B:89:0x0134, B:91:0x0139, B:97:0x0149, B:99:0x014e, B:101:0x0153, B:103:0x0158, B:109:0x0168, B:111:0x016d, B:113:0x0172, B:115:0x0177, B:121:0x0186, B:123:0x018b, B:125:0x0190, B:127:0x0195, B:133:0x01a4, B:137:0x01ac, B:139:0x01b1, B:141:0x01b6), top: B:168:0x000e }] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v19, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v20, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v21, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v22, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v24, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v43, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v45 */
    /* JADX WARN: Type inference failed for: r8v46 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String httpUrlConnectionPost(String str, String str2) {
        ?? r5;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        Exception e2;
        IOException e3;
        ProtocolException e4;
        MalformedURLException e5;
        UnsupportedEncodingException e6;
        ByteArrayOutputStream byteArrayOutputStream3;
        ?? r8;
        HttpURLConnection httpURLConnection2;
        String str3;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r5 = 65538;
            InterceptResult invokeLL = interceptable.invokeLL(65538, null, str, str2);
            if (invokeLL != null) {
                return (String) invokeLL.objValue;
            }
        }
        ?? r0 = "8000";
        StringBuilder sb = new StringBuilder("");
        ByteArrayOutputStream byteArrayOutputStream4 = null;
        try {
            try {
                try {
                    str3 = "data=" + URLEncoder.encode(str2, "UTF-8");
                    str = (HttpURLConnection) new URL(str).openConnection();
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    System.setProperty("sun.net.client.defaultConnectTimeout", "8000");
                    System.setProperty("sun.net.client.defaultReadTimeout", "8000");
                    str.setDoOutput(true);
                    str.setDoInput(true);
                    str.setRequestMethod("POST");
                    str.setUseCaches(false);
                    str.setInstanceFollowRedirects(true);
                    str.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    str.connect();
                    r0 = str.getOutputStream();
                } catch (UnsupportedEncodingException e7) {
                    e = e7;
                    r0 = 0;
                    byteArrayOutputStream2 = null;
                } catch (MalformedURLException e8) {
                    e = e8;
                    r0 = 0;
                    byteArrayOutputStream2 = null;
                } catch (ProtocolException e9) {
                    e = e9;
                    r0 = 0;
                    byteArrayOutputStream2 = null;
                } catch (IOException e10) {
                    e = e10;
                    r0 = 0;
                    byteArrayOutputStream2 = null;
                } catch (Exception e11) {
                    e = e11;
                    r0 = 0;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                    httpURLConnection = str;
                    byteArrayOutputStream3 = byteArrayOutputStream;
                    httpURLConnection2 = httpURLConnection;
                    r8 = byteArrayOutputStream;
                    if (byteArrayOutputStream4 != null) {
                    }
                    if (byteArrayOutputStream3 != null) {
                    }
                    if (r8 != 0) {
                    }
                    if (httpURLConnection2 != null) {
                    }
                    throw th;
                }
            } catch (UnsupportedEncodingException e12) {
                str2 = 0;
                r0 = 0;
                byteArrayOutputStream2 = null;
                e6 = e12;
                str = 0;
            } catch (MalformedURLException e13) {
                str2 = 0;
                r0 = 0;
                byteArrayOutputStream2 = null;
                e5 = e13;
                str = 0;
            } catch (ProtocolException e14) {
                str2 = 0;
                r0 = 0;
                byteArrayOutputStream2 = null;
                e4 = e14;
                str = 0;
            } catch (IOException e15) {
                str2 = 0;
                r0 = 0;
                byteArrayOutputStream2 = null;
                e3 = e15;
                str = 0;
            } catch (Exception e16) {
                str2 = 0;
                r0 = 0;
                byteArrayOutputStream2 = null;
                e2 = e16;
                str = 0;
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
                byteArrayOutputStream = null;
            }
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        try {
            r0.write(str3.getBytes());
            r0.flush();
            r0.close();
            if (200 == str.getResponseCode()) {
                str2 = str.getInputStream();
                try {
                    byte[] bArr = new byte[1024];
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = str2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr, 0, read);
                        } catch (UnsupportedEncodingException e18) {
                            e6 = e18;
                            e6.printStackTrace();
                            if (r0 != 0) {
                                r0.close();
                            }
                            if (byteArrayOutputStream2 != null) {
                                byteArrayOutputStream2.close();
                            }
                            if (str2 != 0) {
                                str2.close();
                            }
                            if (str != 0) {
                                str.disconnect();
                            }
                            return sb.toString();
                        } catch (MalformedURLException e19) {
                            e5 = e19;
                            e5.printStackTrace();
                            if (r0 != 0) {
                                r0.close();
                            }
                            if (byteArrayOutputStream2 != null) {
                                byteArrayOutputStream2.close();
                            }
                            if (str2 != 0) {
                                str2.close();
                            }
                            if (str != 0) {
                                str.disconnect();
                            }
                            return sb.toString();
                        } catch (ProtocolException e20) {
                            e4 = e20;
                            e4.printStackTrace();
                            if (r0 != 0) {
                                r0.close();
                            }
                            if (byteArrayOutputStream2 != null) {
                                byteArrayOutputStream2.close();
                            }
                            if (str2 != 0) {
                                str2.close();
                            }
                            if (str != 0) {
                                str.disconnect();
                            }
                            return sb.toString();
                        } catch (IOException e21) {
                            e3 = e21;
                            e3.printStackTrace();
                            if (r0 != 0) {
                                r0.close();
                            }
                            if (byteArrayOutputStream2 != null) {
                                byteArrayOutputStream2.close();
                            }
                            if (str2 != 0) {
                                str2.close();
                            }
                            if (str != 0) {
                                str.disconnect();
                            }
                            return sb.toString();
                        } catch (Exception e22) {
                            e2 = e22;
                            e2.printStackTrace();
                            if (r0 != 0) {
                                r0.close();
                            }
                            if (byteArrayOutputStream2 != null) {
                                byteArrayOutputStream2.close();
                            }
                            if (str2 != 0) {
                                str2.close();
                            }
                            if (str != 0) {
                                str.disconnect();
                            }
                            return sb.toString();
                        }
                    }
                    sb.append(new String(byteArrayOutputStream2.toByteArray(), "utf-8"));
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream4 = byteArrayOutputStream2;
                    inputStream = str2;
                } catch (UnsupportedEncodingException e23) {
                    byteArrayOutputStream2 = null;
                    e6 = e23;
                } catch (MalformedURLException e24) {
                    byteArrayOutputStream2 = null;
                    e5 = e24;
                } catch (ProtocolException e25) {
                    byteArrayOutputStream2 = null;
                    e4 = e25;
                } catch (IOException e26) {
                    byteArrayOutputStream2 = null;
                    e3 = e26;
                } catch (Exception e27) {
                    byteArrayOutputStream2 = null;
                    e2 = e27;
                } catch (Throwable th4) {
                    th = th4;
                    r5 = 0;
                    byteArrayOutputStream4 = r0;
                    byteArrayOutputStream3 = r5;
                    httpURLConnection2 = str;
                    r8 = str2;
                    if (byteArrayOutputStream4 != null) {
                        try {
                            byteArrayOutputStream4.close();
                        } catch (IOException e28) {
                            e28.printStackTrace();
                            throw th;
                        }
                    }
                    if (byteArrayOutputStream3 != null) {
                        byteArrayOutputStream3.close();
                    }
                    if (r8 != 0) {
                        r8.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } else {
                inputStream = null;
            }
            if (r0 != 0) {
                r0.close();
            }
            if (byteArrayOutputStream4 != null) {
                byteArrayOutputStream4.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (str != 0) {
                str.disconnect();
            }
        } catch (UnsupportedEncodingException e29) {
            e = e29;
            byteArrayOutputStream2 = null;
            r0 = r0;
            e6 = e;
            str2 = byteArrayOutputStream2;
            e6.printStackTrace();
            if (r0 != 0) {
            }
            if (byteArrayOutputStream2 != null) {
            }
            if (str2 != 0) {
            }
            if (str != 0) {
            }
            return sb.toString();
        } catch (MalformedURLException e30) {
            e = e30;
            byteArrayOutputStream2 = null;
            r0 = r0;
            e5 = e;
            str2 = byteArrayOutputStream2;
            e5.printStackTrace();
            if (r0 != 0) {
            }
            if (byteArrayOutputStream2 != null) {
            }
            if (str2 != 0) {
            }
            if (str != 0) {
            }
            return sb.toString();
        } catch (ProtocolException e31) {
            e = e31;
            byteArrayOutputStream2 = null;
            r0 = r0;
            e4 = e;
            str2 = byteArrayOutputStream2;
            e4.printStackTrace();
            if (r0 != 0) {
            }
            if (byteArrayOutputStream2 != null) {
            }
            if (str2 != 0) {
            }
            if (str != 0) {
            }
            return sb.toString();
        } catch (IOException e32) {
            e = e32;
            byteArrayOutputStream2 = null;
            r0 = r0;
            e3 = e;
            str2 = byteArrayOutputStream2;
            e3.printStackTrace();
            if (r0 != 0) {
            }
            if (byteArrayOutputStream2 != null) {
            }
            if (str2 != 0) {
            }
            if (str != 0) {
            }
            return sb.toString();
        } catch (Exception e33) {
            e = e33;
            byteArrayOutputStream2 = null;
            r0 = r0;
            e2 = e;
            str2 = byteArrayOutputStream2;
            e2.printStackTrace();
            if (r0 != 0) {
            }
            if (byteArrayOutputStream2 != null) {
            }
            if (str2 != 0) {
            }
            if (str != 0) {
            }
            return sb.toString();
        } catch (Throwable th5) {
            th = th5;
            str2 = 0;
            r5 = 0;
        }
        return sb.toString();
    }

    public static String request(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) ? (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) ? "" : httpUrlConnectionPost(str, str2) : (String) invokeLL.objValue;
    }
}
