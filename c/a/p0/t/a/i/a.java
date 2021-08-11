package c.a.p0.t.a.i;

import android.os.Environment;
import android.text.TextUtils;
import c.a.e.e.j.a.e;
import c.a.e.e.p.q;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes3.dex */
public class a extends BdAsyncTask<Void, Void, Boolean> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final String f24148b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f24149c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdInfo f24150a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1826575726, "Lc/a/p0/t/a/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1826575726, "Lc/a/p0/t/a/i/a;");
                return;
            }
        }
        f24148b = Environment.getExternalStorageDirectory() + "/tieba/.advideo";
        f24149c = File.separator;
    }

    public a() {
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

    public final void b(boolean z, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, file) == null) {
            if (z && file != null) {
                File file2 = new File(f24148b + f24149c + (q.c(this.f24150a.adVideoUrl) + ".mp4"));
                if (file2.exists()) {
                    file2.delete();
                }
                if (file.renameTo(file2)) {
                    this.f24150a.videoLocalPath = file2.getAbsolutePath();
                } else {
                    this.f24150a.videoLocalPath = "";
                }
            } else {
                this.f24150a.videoLocalPath = "";
            }
            c.a.p0.t.a.j.a.g(this.f24150a);
        }
    }

    public void c(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adInfo) == null) {
            this.f24150a = adInfo;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0093, code lost:
        if (r12.equalsIgnoreCase(r11.f24150a.videoMd5) == false) goto L26;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Boolean doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        File file;
        boolean z;
        boolean c2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voidArr)) != null) {
            return (Boolean) invokeL.objValue;
        }
        String str = f24148b + f24149c + "advideo.temp";
        file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        z = false;
        try {
            new File(f24148b).mkdirs();
            if (!file.createNewFile()) {
                b(false, null);
                return Boolean.FALSE;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        e eVar = new e();
        eVar.b().s(this.f24150a.adVideoUrl);
        c2 = new c.a.e.e.j.a.c(eVar).c(str, null, 3, 3000, -1, -1, true, true);
        try {
            if (TextUtils.isEmpty(this.f24150a.videoMd5)) {
                b(c2, file);
                return Boolean.valueOf(c2);
            }
            String b2 = q.b(new FileInputStream(str));
            if (TextUtils.isEmpty(b2)) {
                c2 = false;
            }
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
        }
        z = c2;
        b(z, file);
        return Boolean.valueOf(z);
    }
}
