package c.a.t0.m3.c.j;

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
/* loaded from: classes7.dex */
public class b extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19987e;

    /* renamed from: f  reason: collision with root package name */
    public final String f19988f;

    /* renamed from: g  reason: collision with root package name */
    public Process f19989g;

    /* renamed from: h  reason: collision with root package name */
    public BufferedReader f19990h;

    /* renamed from: i  reason: collision with root package name */
    public FileOutputStream f19991i;

    /* renamed from: j  reason: collision with root package name */
    public a f19992j;

    /* loaded from: classes7.dex */
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
        this.f19987e = true;
        this.f19990h = null;
        this.f19991i = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.ENGLISH);
            this.f19991i = new FileOutputStream(new File(str, str2 + "-" + simpleDateFormat.format(new Date()) + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION), true);
        } catch (FileNotFoundException e2) {
            BdLog.e(Log.getStackTraceString(e2));
        }
        if (z) {
            this.f19988f = "logcat -v threadtime *:v -d";
        } else {
            this.f19988f = "logcat -v threadtime *:v";
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Process process = this.f19989g;
            if (process != null) {
                process.destroy();
                this.f19989g = null;
            }
            BufferedReader bufferedReader = this.f19990h;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    this.f19990h = null;
                } catch (IOException e2) {
                    BdLog.e(Log.getStackTraceString(e2));
                }
            }
            FileOutputStream fileOutputStream = this.f19991i;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    BdLog.e(Log.getStackTraceString(e3));
                }
                this.f19991i = null;
            }
            a aVar = this.f19992j;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f19992j = aVar;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f19987e = false;
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
                    this.f19989g = Runtime.getRuntime().exec(this.f19988f);
                    this.f19990h = new BufferedReader(new InputStreamReader(this.f19989g.getInputStream()), 1024);
                    while (this.f19987e && (readLine = this.f19990h.readLine()) != null && this.f19987e) {
                        if (readLine.length() != 0 && this.f19991i != null) {
                            FileOutputStream fileOutputStream = this.f19991i;
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
