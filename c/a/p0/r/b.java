package c.a.p0.r;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f12243a;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
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
        this.f12243a = context;
    }

    public final boolean a(u uVar) {
        InterceptResult invokeL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uVar)) == null) {
            File file = new File(this.f12243a.getFilesDir() + File.separator + "ubcdir", "proc");
            if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
                return false;
            }
            for (File file2 : listFiles) {
                BufferedReader bufferedReader = null;
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
                        long j2 = Long.MAX_VALUE;
                        long j3 = 0;
                        int i2 = 0;
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                JSONObject jSONObject = new JSONObject(new String(Base64.decode(readLine.getBytes(), 2)));
                                if (jSONObject.has("abtest")) {
                                    uVar.f12375f = "1";
                                }
                                long j4 = jSONObject.getLong("timestamp");
                                if (j4 > 0) {
                                    if (j4 < j2) {
                                        j2 = j4;
                                    }
                                    if (j4 > j3) {
                                        j3 = j4;
                                    }
                                }
                                uVar.a(jSONObject);
                                i2++;
                                if (i2 >= 10) {
                                    break;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                bufferedReader = bufferedReader2;
                                e.printStackTrace();
                                c.a.p0.t.d.d(bufferedReader);
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                c.a.p0.t.d.d(bufferedReader);
                                throw th;
                            }
                        }
                        uVar.g(j2, j3);
                        c.a.p0.t.d.d(bufferedReader2);
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void b(boolean z) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            File file = new File(this.f12243a.getFilesDir(), "ubcdir");
            if (file.exists()) {
                File file2 = new File(file, z ? "filereal" : "filedata");
                if (file2.exists()) {
                    file2.delete();
                }
                File file3 = new File(file, "proc");
                if (!file3.exists() || !file3.isDirectory() || (listFiles = file3.listFiles()) == null || listFiles.length == 0) {
                    return;
                }
                for (File file4 : listFiles) {
                    if (file4.isFile()) {
                        file4.delete();
                    }
                }
            }
        }
    }

    public boolean c(u uVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, uVar, z)) == null) {
            File file = new File(this.f12243a.getFilesDir(), "ubcdir");
            if (!file.exists()) {
                file.mkdir();
            }
            boolean a2 = !z ? a(uVar) : false;
            File file2 = new File(file, z ? "filereal" : "filedata");
            if (file2.exists()) {
                BufferedReader bufferedReader = null;
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
                    long j2 = Long.MAX_VALUE;
                    long j3 = 0;
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(new String(Base64.decode(readLine.getBytes(), 2)));
                            if (jSONObject.has("abtest")) {
                                uVar.f12375f = "1";
                            }
                            long j4 = jSONObject.getLong("timestamp");
                            if (j4 > 0) {
                                if (j4 < j2) {
                                    j2 = j4;
                                }
                                if (j4 > j3) {
                                    j3 = j4;
                                }
                            }
                            uVar.a(jSONObject);
                            a2 = true;
                        } catch (Exception unused) {
                            bufferedReader = bufferedReader2;
                            c.a.p0.t.d.d(bufferedReader);
                            return a2;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            c.a.p0.t.d.d(bufferedReader);
                            throw th;
                        }
                    }
                    uVar.g(j2, j3);
                    c.a.p0.t.d.d(bufferedReader2);
                } catch (Exception unused2) {
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return a2;
        }
        return invokeLZ.booleanValue;
    }

    public void d(i iVar, boolean z) {
        File file;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, iVar, z) == null) {
            File file2 = new File(this.f12243a.getFilesDir(), "ubcdir");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (!TextUtils.isEmpty(iVar.k)) {
                File file3 = new File(file2, "proc");
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                file = new File(file3, iVar.k);
            } else {
                file = new File(file2, z ? "filereal" : "filedata");
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (iVar.f12288e != null) {
                    JSONObject jSONObject2 = iVar.f12288e;
                    if (jSONObject2.has("bizId")) {
                        try {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject("content");
                            JSONObject jSONObject4 = jSONObject2.getJSONObject(DI.APP_INFO_NAME);
                            if (jSONObject3 != null && jSONObject4 != null) {
                                jSONObject3.put(DI.APP_INFO_NAME, jSONObject4);
                                jSONObject2.remove(DI.APP_INFO_NAME);
                            }
                            jSONObject = jSONObject2;
                        } catch (JSONException unused) {
                            jSONObject = jSONObject2;
                        }
                    } else {
                        jSONObject.put("content", jSONObject2);
                    }
                } else if (!TextUtils.isEmpty(iVar.f12287d)) {
                    jSONObject.put("content", iVar.f12287d);
                }
                jSONObject.put("bizId", iVar.f12284a);
                jSONObject.put("timestamp", iVar.f12289f);
                jSONObject.put("eventType", "0");
                if (!TextUtils.isEmpty(iVar.f12291h)) {
                    jSONObject.put("abtest", iVar.f12291h);
                }
                if (!TextUtils.isEmpty(iVar.f12292i)) {
                    jSONObject.put("c", iVar.f12292i);
                }
                if (iVar.f12293j) {
                    jSONObject.put("of", "1");
                }
                jSONObject.put(Constant.ID_TYPE, d.g().j(iVar.f12284a));
            } catch (JSONException unused2) {
            }
            byte[] encode = Base64.encode(jSONObject.toString().getBytes(), 2);
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file, true);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(encode);
                fileOutputStream.write(StringUtils.LF.getBytes());
                fileOutputStream.flush();
                c.a.p0.t.d.d(fileOutputStream);
            } catch (Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                c.a.p0.t.d.d(fileOutputStream2);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                c.a.p0.t.d.d(fileOutputStream2);
                throw th;
            }
        }
    }
}
