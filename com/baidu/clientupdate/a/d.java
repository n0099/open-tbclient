package com.baidu.clientupdate.a;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.SearchView;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.clientupdate.d.j;
import com.baidu.minivideo.plugin.capture.download.utils.LogUtils;
import com.baidu.mobstat.Config;
import com.baidu.util.Base64Encoder;
import com.baidu.util.LogUtil;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: e  reason: collision with root package name */
    public static d f4567e;

    /* renamed from: a  reason: collision with root package name */
    public List f4568a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List f4569b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.clientupdate.download.a f4570c;

    /* renamed from: d  reason: collision with root package name */
    public b f4571d;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x00c5 -> B:35:0x00c8). Please submit an issue!!! */
    public d(Context context) {
        this.f4570c = com.baidu.clientupdate.download.a.a(context);
        this.f4571d = b.a(context);
        try {
            if (this.f4570c.h()) {
                String a2 = com.baidu.util.a.a(context).a("lcsdk_xml", "apkMD5", "");
                String a3 = j.a(context, context.getPackageName());
                String a4 = com.baidu.util.a.a(context).a("lcsdk_xml", "sessionId", "-1");
                String a5 = com.baidu.util.a.a(context).a("lcsdk_xml", "sessionInfo", "");
                if (a3.equals(a2)) {
                    a(a4, "0", a5, "a10", "0", (System.currentTimeMillis() / 1000) + "", "", "InstallSuccess", "");
                    LogUtil.logE(LogUtils.TAG, "向db添加a10");
                } else {
                    a(a4, "0", a5, "a10", "1", (System.currentTimeMillis() / 1000) + "", "", "InstallFail", "");
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting() && this.f4570c.g()) {
                LogUtil.logE(LogUtils.TAG, "符合wifi下、有a6动作的上报时机");
                b();
                if (this.f4568a == null || this.f4568a.size() == 0) {
                    return;
                }
                String a6 = a(this.f4568a);
                if (TextUtils.isEmpty(a6)) {
                    return;
                }
                byte[] a7 = a(a6.getBytes());
                LogUtil.logE(LogUtils.TAG, "gZip后上传大小：" + (a7.length / 1024));
                long a8 = com.baidu.util.a.a(context).a("lcsdk_xml", "time", System.currentTimeMillis());
                if (a7.length / 1024 <= 20 && (a8 - System.currentTimeMillis()) / 86400000 <= 7) {
                    new e(this, a7).start();
                    return;
                }
                LogUtil.logE(LogUtils.TAG, "日志超过20k或者日志超过7天 ，将日志舍弃");
                this.f4570c.b();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private a a(Cursor cursor) {
        a aVar = new a();
        try {
            aVar.f4553b = cursor.getString(cursor.getColumnIndex("ug"));
            aVar.f4554c = cursor.getString(cursor.getColumnIndex(SearchView.IME_OPTION_NO_MICROPHONE));
            aVar.f4552a = cursor.getString(cursor.getColumnIndex("sessioninfo"));
            aVar.f4555d = cursor.getString(cursor.getColumnIndex("flag"));
            aVar.f4556e = new JSONArray(cursor.getString(cursor.getColumnIndex("stm")));
            aVar.f4557f = new JSONArray(cursor.getString(cursor.getColumnIndex(Config.STAT_SDK_CHANNEL)));
            aVar.f4558g = new JSONArray(cursor.getString(cursor.getColumnIndex("etm")));
            aVar.f4559h = new JSONArray(cursor.getString(cursor.getColumnIndex("mg")));
            aVar.f4560i = new JSONArray(cursor.getString(cursor.getColumnIndex(Config.EXCEPTION_PART)));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return aVar;
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f4567e == null) {
                f4567e = new d(context);
            }
            dVar = f4567e;
        }
        return dVar;
    }

    private String a(List list) {
        try {
            JSONObject jSONObject = new JSONObject(((a) list.get(list.size() - 1)).a());
            JSONArray jSONArray = new JSONArray();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject2.put(SearchView.IME_OPTION_NO_MICROPHONE, aVar.b());
                jSONObject2.put("tm", aVar.c());
                jSONObject3.put(Config.STAT_SDK_CHANNEL, aVar.d());
                jSONObject3.put("tm", aVar.e());
                jSONObject3.put("mg", aVar.f());
                jSONObject3.put(Config.EXCEPTION_PART, aVar.g());
                jSONObject2.put("in", jSONObject3);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("acs", jSONArray);
            byte[] b64Encode = Base64Encoder.b64Encode(URLEncoder.encode(jSONObject.toString()).getBytes());
            LogUtil.logE(LogUtils.TAG, jSONObject.toString());
            LogUtil.logE(LogUtils.TAG, new String(b64Encode));
            return new String(b64Encode);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        LogUtil.logE(LogUtils.TAG, "把db数据的flag变为1");
        this.f4570c.d();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: android.database.Cursor */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: android.database.Cursor */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: android.database.Cursor */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
        if (r1 != null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
        if (r1 == null) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0057, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
        if (r1 == 0) goto L7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List b() {
        Cursor cursor;
        LogUtil.logE(LogUtils.TAG, "queryAllLog");
        List list = this.f4569b;
        Cursor cursor2 = null;
        List list2 = list;
        if (list != null) {
            int size = list.size();
            list2 = size;
        }
        try {
            try {
                cursor = this.f4570c.f();
                if (cursor != null) {
                    try {
                        cursor.moveToFirst();
                        while (!cursor.isAfterLast()) {
                            this.f4569b.add(a(cursor));
                            cursor.moveToNext();
                        }
                        this.f4568a.addAll(this.f4569b);
                        this.f4569b = null;
                        List list3 = this.f4568a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        return list3;
                    } catch (Exception e2) {
                        e = e2;
                        LogUtil.logE(LogUtils.TAG, Log.getStackTraceString(e));
                    }
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = list2;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        long currentTimeMillis;
        String str10;
        Cursor a2;
        Cursor cursor;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        JSONArray jSONArray5;
        Cursor cursor2 = null;
        try {
            try {
                currentTimeMillis = System.currentTimeMillis();
                LogUtil.logE(LogUtils.TAG, "打log");
                str10 = TextUtils.isEmpty(str3) ? StringUtil.ARRAY_START : str3;
                a2 = this.f4570c.a(str4);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                if (a2 != null) {
                    try {
                        if (a2.moveToNext()) {
                            a a3 = a(a2);
                            if (a3.f4554c.equals(str4) && a3.f4555d.equals(str2)) {
                                LogUtil.logE(LogUtils.TAG, IMTrack.DbBuilder.ACTION_UPDATE);
                                a3.a(str10);
                                a3.f4557f.put(str5);
                                a3.f4556e.put(str6);
                                a3.f4558g.put(System.currentTimeMillis() / 1000);
                                a3.f4559h.put(str8);
                                a3.f4560i.put(str9);
                                this.f4570c.b(a3);
                            }
                            cursor = a2;
                            LogUtil.logE(LogUtils.TAG, "log time:" + (System.currentTimeMillis() - currentTimeMillis));
                            if (cursor == null) {
                                cursor.close();
                                return;
                            }
                            return;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        cursor2 = a2;
                        LogUtil.logE(LogUtils.TAG, Log.getStackTraceString(e));
                        if (cursor2 != null) {
                            cursor2.close();
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = a2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
                this.f4570c.a(new a(str, str2, str10, str4, jSONArray, jSONArray2, jSONArray3, jSONArray4, jSONArray5));
                LogUtil.logE(LogUtils.TAG, "log time:" + (System.currentTimeMillis() - currentTimeMillis));
                if (cursor == null) {
                }
            } catch (Exception e4) {
                e = e4;
                cursor2 = cursor;
                LogUtil.logE(LogUtils.TAG, Log.getStackTraceString(e));
                if (cursor2 != null) {
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                }
                throw th;
            }
            LogUtil.logE(LogUtils.TAG, "insert");
            jSONArray = new JSONArray();
            jSONArray.put(str6);
            jSONArray2 = new JSONArray();
            jSONArray2.put(str5);
            jSONArray3 = new JSONArray();
            jSONArray3.put((System.currentTimeMillis() / 1000) + "");
            jSONArray4 = new JSONArray();
            jSONArray4.put(str8);
            jSONArray5 = new JSONArray();
            jSONArray5.put(str9);
            cursor = a2;
        } catch (Exception e5) {
            e = e5;
            cursor = a2;
            cursor2 = cursor;
            LogUtil.logE(LogUtils.TAG, Log.getStackTraceString(e));
            if (cursor2 != null) {
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = a2;
            cursor2 = cursor;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    public byte[] a(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return bArr2;
        }
    }
}
