package c.a.r0.b3.c.j;

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
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes3.dex */
public class b extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16106e;

    /* renamed from: f  reason: collision with root package name */
    public final String f16107f;

    /* renamed from: g  reason: collision with root package name */
    public Process f16108g;

    /* renamed from: h  reason: collision with root package name */
    public BufferedReader f16109h;

    /* renamed from: i  reason: collision with root package name */
    public FileOutputStream f16110i;

    /* renamed from: j  reason: collision with root package name */
    public a f16111j;

    /* loaded from: classes3.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16106e = true;
        this.f16109h = null;
        this.f16110i = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.ENGLISH);
            this.f16110i = new FileOutputStream(new File(str, str2 + "-" + simpleDateFormat.format(new Date()) + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION), true);
        } catch (FileNotFoundException e2) {
            BdLog.e(Log.getStackTraceString(e2));
        }
        if (z) {
            this.f16107f = "logcat -v threadtime *:v -d";
        } else {
            this.f16107f = "logcat -v threadtime *:v";
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Process process = this.f16108g;
            if (process != null) {
                process.destroy();
                this.f16108g = null;
            }
            BufferedReader bufferedReader = this.f16109h;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    this.f16109h = null;
                } catch (IOException e2) {
                    BdLog.e(Log.getStackTraceString(e2));
                }
            }
            FileOutputStream fileOutputStream = this.f16110i;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    BdLog.e(Log.getStackTraceString(e3));
                }
                this.f16110i = null;
            }
            a aVar = this.f16111j;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f16111j = aVar;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16106e = false;
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
                    this.f16108g = Runtime.getRuntime().exec(this.f16107f);
                    this.f16109h = new BufferedReader(new InputStreamReader(this.f16108g.getInputStream()), 1024);
                    while (this.f16106e && (readLine = this.f16109h.readLine()) != null && this.f16106e) {
                        if (readLine.length() != 0 && this.f16110i != null) {
                            FileOutputStream fileOutputStream = this.f16110i;
                            fileOutputStream.write((readLine + StringUtils.LF).getBytes());
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
