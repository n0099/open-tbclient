package c.a.p0.p3.c.k;

import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes2.dex */
public class b extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final String f16993b;

    /* renamed from: c  reason: collision with root package name */
    public Process f16994c;

    /* renamed from: d  reason: collision with root package name */
    public BufferedReader f16995d;

    /* renamed from: e  reason: collision with root package name */
    public FileOutputStream f16996e;

    /* renamed from: f  reason: collision with root package name */
    public a f16997f;

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    public b(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = true;
        this.f16995d = null;
        this.f16996e = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.ENGLISH);
            this.f16996e = new FileOutputStream(new File(str, str2 + "-" + simpleDateFormat.format(new Date()) + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION), true);
        } catch (FileNotFoundException e2) {
            BdLog.e(Log.getStackTraceString(e2));
        }
        if (z) {
            this.f16993b = "logcat -v threadtime *:v -d";
        } else {
            this.f16993b = "logcat -v threadtime *:v";
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Process process = this.f16994c;
            if (process != null) {
                process.destroy();
                this.f16994c = null;
            }
            BufferedReader bufferedReader = this.f16995d;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    this.f16995d = null;
                } catch (IOException e2) {
                    BdLog.e(Log.getStackTraceString(e2));
                }
            }
            FileOutputStream fileOutputStream = this.f16996e;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    BdLog.e(Log.getStackTraceString(e3));
                }
                this.f16996e = null;
            }
            a aVar = this.f16997f;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f16997f = aVar;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = false;
            a();
            interrupt();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                try {
                    this.f16994c = Runtime.getRuntime().exec(this.f16993b);
                    this.f16995d = new BufferedReader(new InputStreamReader(this.f16994c.getInputStream()), 1024);
                    while (this.a && (readLine = this.f16995d.readLine()) != null && this.a) {
                        if (readLine.length() != 0 && this.f16996e != null) {
                            FileOutputStream fileOutputStream = this.f16996e;
                            fileOutputStream.write((readLine + "\n").getBytes());
                        }
                    }
                    BdLog.d("collector complete.");
                } catch (IOException e2) {
                    BdLog.e(Log.getStackTraceString(e2));
                }
            } finally {
                a();
            }
        }
    }
}
