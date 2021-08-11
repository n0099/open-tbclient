package com.baidu.clientupdate.a;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.clientupdate.d.j;
import com.baidu.minivideo.plugin.capture.download.utils.LogUtils;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes5.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static d f38645e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List f38646a;

    /* renamed from: b  reason: collision with root package name */
    public List f38647b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.clientupdate.download.a f38648c;

    /* renamed from: d  reason: collision with root package name */
    public b f38649d;

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38648c = com.baidu.clientupdate.download.a.a(context);
        this.f38649d = b.a(context);
        this.f38646a = new ArrayList();
        this.f38647b = new ArrayList();
        try {
            if (this.f38648c.h()) {
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
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting() && this.f38648c.g()) {
                LogUtil.logE(LogUtils.TAG, "符合wifi下、有a6动作的上报时机");
                b();
                if (this.f38646a == null || this.f38646a.size() == 0) {
                    return;
                }
                String a6 = a(this.f38646a);
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
                this.f38648c.b();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private a a(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, cursor)) == null) {
            a aVar = new a();
            try {
                aVar.f38631b = cursor.getString(cursor.getColumnIndex("ug"));
                aVar.f38632c = cursor.getString(cursor.getColumnIndex(SearchView.IME_OPTION_NO_MICROPHONE));
                aVar.f38630a = cursor.getString(cursor.getColumnIndex("sessioninfo"));
                aVar.f38633d = cursor.getString(cursor.getColumnIndex("flag"));
                aVar.f38634e = new JSONArray(cursor.getString(cursor.getColumnIndex(ConstantHelper.LOG_STM)));
                aVar.f38635f = new JSONArray(cursor.getString(cursor.getColumnIndex("sc")));
                aVar.f38636g = new JSONArray(cursor.getString(cursor.getColumnIndex(ConstantHelper.LOG_ETM)));
                aVar.f38637h = new JSONArray(cursor.getString(cursor.getColumnIndex("mg")));
                aVar.f38638i = new JSONArray(cursor.getString(cursor.getColumnIndex("ex")));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public static synchronized d a(Context context) {
        InterceptResult invokeL;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (d.class) {
                if (f38645e == null) {
                    f38645e = new d(context);
                }
                dVar = f38645e;
            }
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    private String a(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, list)) == null) {
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
                    jSONObject3.put("sc", aVar.d());
                    jSONObject3.put("tm", aVar.e());
                    jSONObject3.put("mg", aVar.f());
                    jSONObject3.put("ex", aVar.g());
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
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            LogUtil.logE(LogUtils.TAG, "把db数据的flag变为1");
            this.f38648c.d();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
        if (r1 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
        if (r1 == null) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List b() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            LogUtil.logE(LogUtils.TAG, "queryAllLog");
            List list = this.f38647b;
            Cursor cursor2 = null;
            if (list == null || list.size() == 0) {
                try {
                    cursor = this.f38648c.f();
                    if (cursor != null) {
                        try {
                            try {
                                cursor.moveToFirst();
                                while (!cursor.isAfterLast()) {
                                    this.f38647b.add(a(cursor));
                                    cursor.moveToNext();
                                }
                                this.f38646a.addAll(this.f38647b);
                                this.f38647b = null;
                                List list2 = this.f38646a;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return list2;
                            } catch (Exception e2) {
                                e = e2;
                                LogUtil.logE(LogUtils.TAG, Log.getStackTraceString(e));
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
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
            return null;
        }
        return (List) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
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
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9}) != null) {
            return;
        }
        Cursor cursor2 = null;
        try {
            try {
                currentTimeMillis = System.currentTimeMillis();
                LogUtil.logE(LogUtils.TAG, "打log");
                str10 = TextUtils.isEmpty(str3) ? StringUtil.ARRAY_START : str3;
                a2 = this.f38648c.a(str4);
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
                            if (a3.f38632c.equals(str4) && a3.f38633d.equals(str2)) {
                                LogUtil.logE(LogUtils.TAG, "update");
                                a3.a(str10);
                                a3.f38635f.put(str5);
                                a3.f38634e.put(str6);
                                a3.f38636g.put(System.currentTimeMillis() / 1000);
                                a3.f38637h.put(str8);
                                a3.f38638i.put(str9);
                                this.f38648c.b(a3);
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
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = a2;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                }
                this.f38648c.a(new a(str, str2, str10, str4, jSONArray, jSONArray2, jSONArray3, jSONArray4, jSONArray5));
                LogUtil.logE(LogUtils.TAG, "log time:" + (System.currentTimeMillis() - currentTimeMillis));
                if (cursor == null) {
                }
            } catch (Exception e4) {
                e = e4;
                cursor2 = cursor;
                LogUtil.logE(LogUtils.TAG, Log.getStackTraceString(e));
                if (cursor2 != null) {
                    cursor2.close();
                    return;
                }
                return;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
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
        return (byte[]) invokeL.objValue;
    }
}
