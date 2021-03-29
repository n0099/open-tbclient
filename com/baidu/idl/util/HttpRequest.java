package com.baidu.idl.util;

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
    public static final String TAG = "HttpRequest";

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:144:0x01bc */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x0098 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x009b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x009e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x00a1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x00a4 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0152 A[Catch: IOException -> 0x01a2, TRY_LEAVE, TryCatch #28 {IOException -> 0x01a2, blocks: (B:39:0x00c7, B:41:0x00cc, B:43:0x00d1, B:45:0x00d6, B:83:0x0124, B:85:0x0129, B:87:0x012e, B:89:0x0133, B:95:0x0143, B:97:0x0148, B:99:0x014d, B:101:0x0152, B:107:0x0162, B:109:0x0167, B:111:0x016c, B:113:0x0171, B:119:0x0180, B:121:0x0185, B:123:0x018a, B:125:0x018f, B:131:0x019e, B:135:0x01a6, B:137:0x01ab, B:139:0x01b0), top: B:162:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0162 A[Catch: IOException -> 0x01a2, TRY_ENTER, TryCatch #28 {IOException -> 0x01a2, blocks: (B:39:0x00c7, B:41:0x00cc, B:43:0x00d1, B:45:0x00d6, B:83:0x0124, B:85:0x0129, B:87:0x012e, B:89:0x0133, B:95:0x0143, B:97:0x0148, B:99:0x014d, B:101:0x0152, B:107:0x0162, B:109:0x0167, B:111:0x016c, B:113:0x0171, B:119:0x0180, B:121:0x0185, B:123:0x018a, B:125:0x018f, B:131:0x019e, B:135:0x01a6, B:137:0x01ab, B:139:0x01b0), top: B:162:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0167 A[Catch: IOException -> 0x01a2, TryCatch #28 {IOException -> 0x01a2, blocks: (B:39:0x00c7, B:41:0x00cc, B:43:0x00d1, B:45:0x00d6, B:83:0x0124, B:85:0x0129, B:87:0x012e, B:89:0x0133, B:95:0x0143, B:97:0x0148, B:99:0x014d, B:101:0x0152, B:107:0x0162, B:109:0x0167, B:111:0x016c, B:113:0x0171, B:119:0x0180, B:121:0x0185, B:123:0x018a, B:125:0x018f, B:131:0x019e, B:135:0x01a6, B:137:0x01ab, B:139:0x01b0), top: B:162:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x016c A[Catch: IOException -> 0x01a2, TryCatch #28 {IOException -> 0x01a2, blocks: (B:39:0x00c7, B:41:0x00cc, B:43:0x00d1, B:45:0x00d6, B:83:0x0124, B:85:0x0129, B:87:0x012e, B:89:0x0133, B:95:0x0143, B:97:0x0148, B:99:0x014d, B:101:0x0152, B:107:0x0162, B:109:0x0167, B:111:0x016c, B:113:0x0171, B:119:0x0180, B:121:0x0185, B:123:0x018a, B:125:0x018f, B:131:0x019e, B:135:0x01a6, B:137:0x01ab, B:139:0x01b0), top: B:162:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0171 A[Catch: IOException -> 0x01a2, TRY_LEAVE, TryCatch #28 {IOException -> 0x01a2, blocks: (B:39:0x00c7, B:41:0x00cc, B:43:0x00d1, B:45:0x00d6, B:83:0x0124, B:85:0x0129, B:87:0x012e, B:89:0x0133, B:95:0x0143, B:97:0x0148, B:99:0x014d, B:101:0x0152, B:107:0x0162, B:109:0x0167, B:111:0x016c, B:113:0x0171, B:119:0x0180, B:121:0x0185, B:123:0x018a, B:125:0x018f, B:131:0x019e, B:135:0x01a6, B:137:0x01ab, B:139:0x01b0), top: B:162:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0180 A[Catch: IOException -> 0x01a2, TRY_ENTER, TryCatch #28 {IOException -> 0x01a2, blocks: (B:39:0x00c7, B:41:0x00cc, B:43:0x00d1, B:45:0x00d6, B:83:0x0124, B:85:0x0129, B:87:0x012e, B:89:0x0133, B:95:0x0143, B:97:0x0148, B:99:0x014d, B:101:0x0152, B:107:0x0162, B:109:0x0167, B:111:0x016c, B:113:0x0171, B:119:0x0180, B:121:0x0185, B:123:0x018a, B:125:0x018f, B:131:0x019e, B:135:0x01a6, B:137:0x01ab, B:139:0x01b0), top: B:162:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0185 A[Catch: IOException -> 0x01a2, TryCatch #28 {IOException -> 0x01a2, blocks: (B:39:0x00c7, B:41:0x00cc, B:43:0x00d1, B:45:0x00d6, B:83:0x0124, B:85:0x0129, B:87:0x012e, B:89:0x0133, B:95:0x0143, B:97:0x0148, B:99:0x014d, B:101:0x0152, B:107:0x0162, B:109:0x0167, B:111:0x016c, B:113:0x0171, B:119:0x0180, B:121:0x0185, B:123:0x018a, B:125:0x018f, B:131:0x019e, B:135:0x01a6, B:137:0x01ab, B:139:0x01b0), top: B:162:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x018a A[Catch: IOException -> 0x01a2, TryCatch #28 {IOException -> 0x01a2, blocks: (B:39:0x00c7, B:41:0x00cc, B:43:0x00d1, B:45:0x00d6, B:83:0x0124, B:85:0x0129, B:87:0x012e, B:89:0x0133, B:95:0x0143, B:97:0x0148, B:99:0x014d, B:101:0x0152, B:107:0x0162, B:109:0x0167, B:111:0x016c, B:113:0x0171, B:119:0x0180, B:121:0x0185, B:123:0x018a, B:125:0x018f, B:131:0x019e, B:135:0x01a6, B:137:0x01ab, B:139:0x01b0), top: B:162:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x018f A[Catch: IOException -> 0x01a2, TRY_LEAVE, TryCatch #28 {IOException -> 0x01a2, blocks: (B:39:0x00c7, B:41:0x00cc, B:43:0x00d1, B:45:0x00d6, B:83:0x0124, B:85:0x0129, B:87:0x012e, B:89:0x0133, B:95:0x0143, B:97:0x0148, B:99:0x014d, B:101:0x0152, B:107:0x0162, B:109:0x0167, B:111:0x016c, B:113:0x0171, B:119:0x0180, B:121:0x0185, B:123:0x018a, B:125:0x018f, B:131:0x019e, B:135:0x01a6, B:137:0x01ab, B:139:0x01b0), top: B:162:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x019e A[Catch: IOException -> 0x01a2, TRY_ENTER, TryCatch #28 {IOException -> 0x01a2, blocks: (B:39:0x00c7, B:41:0x00cc, B:43:0x00d1, B:45:0x00d6, B:83:0x0124, B:85:0x0129, B:87:0x012e, B:89:0x0133, B:95:0x0143, B:97:0x0148, B:99:0x014d, B:101:0x0152, B:107:0x0162, B:109:0x0167, B:111:0x016c, B:113:0x0171, B:119:0x0180, B:121:0x0185, B:123:0x018a, B:125:0x018f, B:131:0x019e, B:135:0x01a6, B:137:0x01ab, B:139:0x01b0), top: B:162:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a6 A[Catch: IOException -> 0x01a2, TryCatch #28 {IOException -> 0x01a2, blocks: (B:39:0x00c7, B:41:0x00cc, B:43:0x00d1, B:45:0x00d6, B:83:0x0124, B:85:0x0129, B:87:0x012e, B:89:0x0133, B:95:0x0143, B:97:0x0148, B:99:0x014d, B:101:0x0152, B:107:0x0162, B:109:0x0167, B:111:0x016c, B:113:0x0171, B:119:0x0180, B:121:0x0185, B:123:0x018a, B:125:0x018f, B:131:0x019e, B:135:0x01a6, B:137:0x01ab, B:139:0x01b0), top: B:162:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ab A[Catch: IOException -> 0x01a2, TryCatch #28 {IOException -> 0x01a2, blocks: (B:39:0x00c7, B:41:0x00cc, B:43:0x00d1, B:45:0x00d6, B:83:0x0124, B:85:0x0129, B:87:0x012e, B:89:0x0133, B:95:0x0143, B:97:0x0148, B:99:0x014d, B:101:0x0152, B:107:0x0162, B:109:0x0167, B:111:0x016c, B:113:0x0171, B:119:0x0180, B:121:0x0185, B:123:0x018a, B:125:0x018f, B:131:0x019e, B:135:0x01a6, B:137:0x01ab, B:139:0x01b0), top: B:162:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b0 A[Catch: IOException -> 0x01a2, TRY_LEAVE, TryCatch #28 {IOException -> 0x01a2, blocks: (B:39:0x00c7, B:41:0x00cc, B:43:0x00d1, B:45:0x00d6, B:83:0x0124, B:85:0x0129, B:87:0x012e, B:89:0x0133, B:95:0x0143, B:97:0x0148, B:99:0x014d, B:101:0x0152, B:107:0x0162, B:109:0x0167, B:111:0x016c, B:113:0x0171, B:119:0x0180, B:121:0x0185, B:123:0x018a, B:125:0x018f, B:131:0x019e, B:135:0x01a6, B:137:0x01ab, B:139:0x01b0), top: B:162:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c8 A[Catch: IOException -> 0x01c4, TryCatch #13 {IOException -> 0x01c4, blocks: (B:147:0x01c0, B:151:0x01c8, B:153:0x01cd, B:155:0x01d2), top: B:159:0x01c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01cd A[Catch: IOException -> 0x01c4, TryCatch #13 {IOException -> 0x01c4, blocks: (B:147:0x01c0, B:151:0x01c8, B:153:0x01cd, B:155:0x01d2), top: B:159:0x01c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d2 A[Catch: IOException -> 0x01c4, TRY_LEAVE, TryCatch #13 {IOException -> 0x01c4, blocks: (B:147:0x01c0, B:151:0x01c8, B:153:0x01cd, B:155:0x01d2), top: B:159:0x01c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0124 A[Catch: IOException -> 0x01a2, TRY_ENTER, TryCatch #28 {IOException -> 0x01a2, blocks: (B:39:0x00c7, B:41:0x00cc, B:43:0x00d1, B:45:0x00d6, B:83:0x0124, B:85:0x0129, B:87:0x012e, B:89:0x0133, B:95:0x0143, B:97:0x0148, B:99:0x014d, B:101:0x0152, B:107:0x0162, B:109:0x0167, B:111:0x016c, B:113:0x0171, B:119:0x0180, B:121:0x0185, B:123:0x018a, B:125:0x018f, B:131:0x019e, B:135:0x01a6, B:137:0x01ab, B:139:0x01b0), top: B:162:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0129 A[Catch: IOException -> 0x01a2, TryCatch #28 {IOException -> 0x01a2, blocks: (B:39:0x00c7, B:41:0x00cc, B:43:0x00d1, B:45:0x00d6, B:83:0x0124, B:85:0x0129, B:87:0x012e, B:89:0x0133, B:95:0x0143, B:97:0x0148, B:99:0x014d, B:101:0x0152, B:107:0x0162, B:109:0x0167, B:111:0x016c, B:113:0x0171, B:119:0x0180, B:121:0x0185, B:123:0x018a, B:125:0x018f, B:131:0x019e, B:135:0x01a6, B:137:0x01ab, B:139:0x01b0), top: B:162:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x012e A[Catch: IOException -> 0x01a2, TryCatch #28 {IOException -> 0x01a2, blocks: (B:39:0x00c7, B:41:0x00cc, B:43:0x00d1, B:45:0x00d6, B:83:0x0124, B:85:0x0129, B:87:0x012e, B:89:0x0133, B:95:0x0143, B:97:0x0148, B:99:0x014d, B:101:0x0152, B:107:0x0162, B:109:0x0167, B:111:0x016c, B:113:0x0171, B:119:0x0180, B:121:0x0185, B:123:0x018a, B:125:0x018f, B:131:0x019e, B:135:0x01a6, B:137:0x01ab, B:139:0x01b0), top: B:162:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0133 A[Catch: IOException -> 0x01a2, TRY_LEAVE, TryCatch #28 {IOException -> 0x01a2, blocks: (B:39:0x00c7, B:41:0x00cc, B:43:0x00d1, B:45:0x00d6, B:83:0x0124, B:85:0x0129, B:87:0x012e, B:89:0x0133, B:95:0x0143, B:97:0x0148, B:99:0x014d, B:101:0x0152, B:107:0x0162, B:109:0x0167, B:111:0x016c, B:113:0x0171, B:119:0x0180, B:121:0x0185, B:123:0x018a, B:125:0x018f, B:131:0x019e, B:135:0x01a6, B:137:0x01ab, B:139:0x01b0), top: B:162:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0143 A[Catch: IOException -> 0x01a2, TRY_ENTER, TryCatch #28 {IOException -> 0x01a2, blocks: (B:39:0x00c7, B:41:0x00cc, B:43:0x00d1, B:45:0x00d6, B:83:0x0124, B:85:0x0129, B:87:0x012e, B:89:0x0133, B:95:0x0143, B:97:0x0148, B:99:0x014d, B:101:0x0152, B:107:0x0162, B:109:0x0167, B:111:0x016c, B:113:0x0171, B:119:0x0180, B:121:0x0185, B:123:0x018a, B:125:0x018f, B:131:0x019e, B:135:0x01a6, B:137:0x01ab, B:139:0x01b0), top: B:162:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0148 A[Catch: IOException -> 0x01a2, TryCatch #28 {IOException -> 0x01a2, blocks: (B:39:0x00c7, B:41:0x00cc, B:43:0x00d1, B:45:0x00d6, B:83:0x0124, B:85:0x0129, B:87:0x012e, B:89:0x0133, B:95:0x0143, B:97:0x0148, B:99:0x014d, B:101:0x0152, B:107:0x0162, B:109:0x0167, B:111:0x016c, B:113:0x0171, B:119:0x0180, B:121:0x0185, B:123:0x018a, B:125:0x018f, B:131:0x019e, B:135:0x01a6, B:137:0x01ab, B:139:0x01b0), top: B:162:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x014d A[Catch: IOException -> 0x01a2, TryCatch #28 {IOException -> 0x01a2, blocks: (B:39:0x00c7, B:41:0x00cc, B:43:0x00d1, B:45:0x00d6, B:83:0x0124, B:85:0x0129, B:87:0x012e, B:89:0x0133, B:95:0x0143, B:97:0x0148, B:99:0x014d, B:101:0x0152, B:107:0x0162, B:109:0x0167, B:111:0x016c, B:113:0x0171, B:119:0x0180, B:121:0x0185, B:123:0x018a, B:125:0x018f, B:131:0x019e, B:135:0x01a6, B:137:0x01ab, B:139:0x01b0), top: B:162:0x000a }] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
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
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
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
            } catch (UnsupportedEncodingException e7) {
                str2 = 0;
                r0 = 0;
                byteArrayOutputStream2 = null;
                e6 = e7;
                str = 0;
            } catch (MalformedURLException e8) {
                str2 = 0;
                r0 = 0;
                byteArrayOutputStream2 = null;
                e5 = e8;
                str = 0;
            } catch (ProtocolException e9) {
                str2 = 0;
                r0 = 0;
                byteArrayOutputStream2 = null;
                e4 = e9;
                str = 0;
            } catch (IOException e10) {
                str2 = 0;
                r0 = 0;
                byteArrayOutputStream2 = null;
                e3 = e10;
                str = 0;
            } catch (Exception e11) {
                str2 = 0;
                r0 = 0;
                byteArrayOutputStream2 = null;
                e2 = e11;
                str = 0;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = null;
                byteArrayOutputStream = null;
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
            } catch (UnsupportedEncodingException e12) {
                e = e12;
                r0 = 0;
                byteArrayOutputStream2 = null;
            } catch (MalformedURLException e13) {
                e = e13;
                r0 = 0;
                byteArrayOutputStream2 = null;
            } catch (ProtocolException e14) {
                e = e14;
                r0 = 0;
                byteArrayOutputStream2 = null;
            } catch (IOException e15) {
                e = e15;
                r0 = 0;
                byteArrayOutputStream2 = null;
            } catch (Exception e16) {
                e = e16;
                r0 = 0;
                byteArrayOutputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
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
                    byteArrayOutputStream3 = null;
                    byteArrayOutputStream4 = r0;
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
            byteArrayOutputStream3 = null;
        }
        return sb.toString();
    }

    public static String request(String str, String str2) {
        return (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) ? "" : httpUrlConnectionPost(str, str2);
    }
}
