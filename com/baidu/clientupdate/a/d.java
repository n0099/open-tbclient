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
/* loaded from: classes10.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static d f34287e;
    public transient /* synthetic */ FieldHolder $fh;
    public List a;

    /* renamed from: b  reason: collision with root package name */
    public List f34288b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.clientupdate.download.a f34289c;

    /* renamed from: d  reason: collision with root package name */
    public b f34290d;

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
        this.f34289c = com.baidu.clientupdate.download.a.a(context);
        this.f34290d = b.a(context);
        this.a = new ArrayList();
        this.f34288b = new ArrayList();
        try {
            if (this.f34289c.h()) {
                String a = com.baidu.util.a.a(context).a("lcsdk_xml", "apkMD5", "");
                String a2 = j.a(context, context.getPackageName());
                String a3 = com.baidu.util.a.a(context).a("lcsdk_xml", "sessionId", "-1");
                String a4 = com.baidu.util.a.a(context).a("lcsdk_xml", "sessionInfo", "");
                if (a2.equals(a)) {
                    a(a3, "0", a4, "a10", "0", (System.currentTimeMillis() / 1000) + "", "", "InstallSuccess", "");
                    LogUtil.logE(LogUtils.TAG, "向db添加a10");
                } else {
                    a(a3, "0", a4, "a10", "1", (System.currentTimeMillis() / 1000) + "", "", "InstallFail", "");
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting() && this.f34289c.g()) {
                LogUtil.logE(LogUtils.TAG, "符合wifi下、有a6动作的上报时机");
                b();
                if (this.a == null || this.a.size() == 0) {
                    return;
                }
                String a5 = a(this.a);
                if (TextUtils.isEmpty(a5)) {
                    return;
                }
                byte[] a6 = a(a5.getBytes());
                LogUtil.logE(LogUtils.TAG, "gZip后上传大小：" + (a6.length / 1024));
                long a7 = com.baidu.util.a.a(context).a("lcsdk_xml", "time", System.currentTimeMillis());
                if (a6.length / 1024 <= 20 && (a7 - System.currentTimeMillis()) / 86400000 <= 7) {
                    new e(this, a6).start();
                    return;
                }
                LogUtil.logE(LogUtils.TAG, "日志超过20k或者日志超过7天 ，将日志舍弃");
                this.f34289c.b();
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
                aVar.f34275b = cursor.getString(cursor.getColumnIndex("ug"));
                aVar.f34276c = cursor.getString(cursor.getColumnIndex(SearchView.IME_OPTION_NO_MICROPHONE));
                aVar.a = cursor.getString(cursor.getColumnIndex("sessioninfo"));
                aVar.f34277d = cursor.getString(cursor.getColumnIndex("flag"));
                aVar.f34278e = new JSONArray(cursor.getString(cursor.getColumnIndex(ConstantHelper.LOG_STM)));
                aVar.f34279f = new JSONArray(cursor.getString(cursor.getColumnIndex("sc")));
                aVar.f34280g = new JSONArray(cursor.getString(cursor.getColumnIndex(ConstantHelper.LOG_ETM)));
                aVar.f34281h = new JSONArray(cursor.getString(cursor.getColumnIndex("mg")));
                aVar.f34282i = new JSONArray(cursor.getString(cursor.getColumnIndex("ex")));
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
                if (f34287e == null) {
                    f34287e = new d(context);
                }
                dVar = f34287e;
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
            this.f34289c.d();
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
            List list = this.f34288b;
            Cursor cursor2 = null;
            if (list == null || list.size() == 0) {
                try {
                    cursor = this.f34289c.f();
                    if (cursor != null) {
                        try {
                            try {
                                cursor.moveToFirst();
                                while (!cursor.isAfterLast()) {
                                    this.f34288b.add(a(cursor));
                                    cursor.moveToNext();
                                }
                                this.a.addAll(this.f34288b);
                                this.f34288b = null;
                                List list2 = this.a;
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

    /* JADX WARN: Can't wrap try/catch for region: R(11:3|4|5|(1:7)(1:57)|8|9|(5:(3:42|43|(5:45|(1:49)|51|17|(2:19|20)(1:22)))|15|16|17|(0)(0))|11|12|13|14) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0110, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0111, code lost:
        r21 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0116, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0117, code lost:
        r21 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0128, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x012b, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x012e, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        long currentTimeMillis;
        String str10;
        Cursor a;
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
                a = this.f34289c.a(str4);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (a != null) {
                try {
                    if (a.moveToNext()) {
                        a a2 = a(a);
                        if (a2.f34276c.equals(str4) && a2.f34277d.equals(str2)) {
                            LogUtil.logE(LogUtils.TAG, "update");
                            a2.a(str10);
                            a2.f34279f.put(str5);
                            a2.f34278e.put(str6);
                            a2.f34280g.put(System.currentTimeMillis() / 1000);
                            a2.f34281h.put(str8);
                            a2.f34282i.put(str9);
                            this.f34289c.b(a2);
                        }
                        cursor = a;
                        LogUtil.logE(LogUtils.TAG, "log time:" + (System.currentTimeMillis() - currentTimeMillis));
                        if (cursor == null) {
                            cursor.close();
                            return;
                        }
                        return;
                    }
                } catch (Exception e3) {
                    e = e3;
                    cursor2 = a;
                    LogUtil.logE(LogUtils.TAG, Log.getStackTraceString(e));
                    if (cursor2 != null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = a;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
            this.f34289c.a(new a(str, str2, str10, str4, jSONArray, jSONArray2, jSONArray3, jSONArray4, jSONArray5));
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
        cursor = a;
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
