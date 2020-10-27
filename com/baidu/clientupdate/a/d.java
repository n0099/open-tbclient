package com.baidu.clientupdate.a;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.clientupdate.d.j;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
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
/* loaded from: classes17.dex */
public final class d {
    private static d e;

    /* renamed from: a  reason: collision with root package name */
    private List f1316a = new ArrayList();
    private List b = new ArrayList();
    private com.baidu.clientupdate.download.a c;
    private b d;

    private d(Context context) {
        this.c = com.baidu.clientupdate.download.a.a(context);
        this.d = b.a(context);
        try {
            if (this.c.h()) {
                String a2 = com.baidu.util.a.a(context).a("lcsdk_xml", "apkMD5", "");
                String a3 = j.a(context, context.getPackageName());
                String a4 = com.baidu.util.a.a(context).a("lcsdk_xml", "sessionId", "-1");
                String a5 = com.baidu.util.a.a(context).a("lcsdk_xml", "sessionInfo", "");
                if (a3.equals(a2)) {
                    a(a4, "0", a5, "a10", "0", (System.currentTimeMillis() / 1000) + "", "", "InstallSuccess", "");
                    LogUtil.logE("LogUtils", "向db添加a10");
                } else {
                    a(a4, "0", a5, "a10", "1", (System.currentTimeMillis() / 1000) + "", "", "InstallFail", "");
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting() && this.c.g()) {
                LogUtil.logE("LogUtils", "符合wifi下、有a6动作的上报时机");
                b();
                if (this.f1316a == null || this.f1316a.size() == 0) {
                    return;
                }
                String a6 = a(this.f1316a);
                if (TextUtils.isEmpty(a6)) {
                    return;
                }
                byte[] a7 = a(a6.getBytes());
                LogUtil.logE("LogUtils", "gZip后上传大小：" + (a7.length / 1024));
                long a8 = com.baidu.util.a.a(context).a("lcsdk_xml", "time", System.currentTimeMillis());
                if (a7.length / 1024 <= 20 && (a8 - System.currentTimeMillis()) / 86400000 <= 7) {
                    new e(this, a7).start();
                    return;
                }
                LogUtil.logE("LogUtils", "日志超过20k或者日志超过7天 ，将日志舍弃");
                this.c.b();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private a a(Cursor cursor) {
        a aVar = new a();
        try {
            aVar.b = cursor.getString(cursor.getColumnIndex("ug"));
            aVar.c = cursor.getString(cursor.getColumnIndex("nm"));
            aVar.f1313a = cursor.getString(cursor.getColumnIndex("sessioninfo"));
            aVar.d = cursor.getString(cursor.getColumnIndex(FrsActivityConfig.FLAG));
            aVar.e = new JSONArray(cursor.getString(cursor.getColumnIndex("stm")));
            aVar.f = new JSONArray(cursor.getString(cursor.getColumnIndex(Config.STAT_SDK_CHANNEL)));
            aVar.g = new JSONArray(cursor.getString(cursor.getColumnIndex("etm")));
            aVar.h = new JSONArray(cursor.getString(cursor.getColumnIndex("mg")));
            aVar.i = new JSONArray(cursor.getString(cursor.getColumnIndex(Config.EXCEPTION_PART)));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return aVar;
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (e == null) {
                e = new d(context);
            }
            dVar = e;
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
                jSONObject2.put("nm", aVar.b());
                jSONObject2.put(IXAdRequestInfo.MAX_TITLE_LENGTH, aVar.c());
                jSONObject3.put(Config.STAT_SDK_CHANNEL, aVar.d());
                jSONObject3.put(IXAdRequestInfo.MAX_TITLE_LENGTH, aVar.e());
                jSONObject3.put("mg", aVar.f());
                jSONObject3.put(Config.EXCEPTION_PART, aVar.g());
                jSONObject2.put("in", jSONObject3);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("acs", jSONArray);
            byte[] b64Encode = Base64Encoder.b64Encode(URLEncoder.encode(jSONObject.toString()).getBytes());
            LogUtil.logE("LogUtils", jSONObject.toString());
            LogUtil.logE("LogUtils", new String(b64Encode));
            return new String(b64Encode);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        LogUtil.logE("LogUtils", "把db数据的flag变为1");
        this.c.d();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0066 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List b() {
        Throwable th;
        Cursor cursor;
        List list = null;
        ?? r2 = "queryAllLog";
        LogUtil.logE("LogUtils", "queryAllLog");
        if (this.b == null || this.b.size() == 0) {
            try {
                try {
                    cursor = this.c.f();
                    if (cursor != null) {
                        try {
                            cursor.moveToFirst();
                            while (!cursor.isAfterLast()) {
                                this.b.add(a(cursor));
                                cursor.moveToNext();
                            }
                            this.f1316a.addAll(this.b);
                            this.b = null;
                            list = this.f1316a;
                            if (cursor != null) {
                                cursor.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            LogUtil.logE("LogUtils", Log.getStackTraceString(e));
                            if (cursor != null) {
                                cursor.close();
                            }
                            return list;
                        }
                    } else if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (r2 != 0) {
                        r2.close();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th3) {
                r2 = 0;
                th = th3;
                if (r2 != 0) {
                }
                throw th;
            }
        }
        return list;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            LogUtil.logE("LogUtils", "打log");
            String str10 = TextUtils.isEmpty(str3) ? "{" : str3;
            cursor = this.c.a(str4);
            if (cursor != null) {
                try {
                    if (cursor.moveToNext()) {
                        a a2 = a(cursor);
                        if (a2.c.equals(str4) && a2.d.equals(str2)) {
                            LogUtil.logE("LogUtils", IMTrack.DbBuilder.ACTION_UPDATE);
                            a2.a(str10);
                            a2.f.put(str5);
                            a2.e.put(str6);
                            a2.g.put(System.currentTimeMillis() / 1000);
                            a2.h.put(str8);
                            a2.i.put(str9);
                            this.c.b(a2);
                        }
                        LogUtil.logE("LogUtils", "log time:" + (System.currentTimeMillis() - currentTimeMillis));
                        if (cursor == null) {
                            cursor.close();
                            return;
                        }
                        return;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor2 = cursor;
                    try {
                        LogUtil.logE("LogUtils", Log.getStackTraceString(e));
                        if (cursor2 != null) {
                            cursor2.close();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursor2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
            LogUtil.logE("LogUtils", "insert");
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str6);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(str5);
            JSONArray jSONArray3 = new JSONArray();
            jSONArray3.put((System.currentTimeMillis() / 1000) + "");
            JSONArray jSONArray4 = new JSONArray();
            jSONArray4.put(str8);
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(str9);
            this.c.a(new a(str, str2, str10, str4, jSONArray, jSONArray2, jSONArray3, jSONArray4, jSONArray5));
            LogUtil.logE("LogUtils", "log time:" + (System.currentTimeMillis() - currentTimeMillis));
            if (cursor == null) {
            }
        } catch (Exception e3) {
            e = e3;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    public byte[] a(byte[] bArr) {
        byte[] bArr2;
        Exception e2;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
        } catch (Exception e3) {
            bArr2 = null;
            e2 = e3;
        }
        try {
            byteArrayOutputStream.close();
        } catch (Exception e4) {
            e2 = e4;
            e2.printStackTrace();
            return bArr2;
        }
        return bArr2;
    }
}
