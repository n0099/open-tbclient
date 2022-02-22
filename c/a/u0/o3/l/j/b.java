package c.a.u0.o3.l.j;

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
/* loaded from: classes8.dex */
public class b extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20194e;

    /* renamed from: f  reason: collision with root package name */
    public final String f20195f;

    /* renamed from: g  reason: collision with root package name */
    public Process f20196g;

    /* renamed from: h  reason: collision with root package name */
    public BufferedReader f20197h;

    /* renamed from: i  reason: collision with root package name */
    public FileOutputStream f20198i;

    /* renamed from: j  reason: collision with root package name */
    public a f20199j;

    /* loaded from: classes8.dex */
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
        this.f20194e = true;
        this.f20197h = null;
        this.f20198i = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.ENGLISH);
            this.f20198i = new FileOutputStream(new File(str, str2 + "-" + simpleDateFormat.format(new Date()) + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION), true);
        } catch (FileNotFoundException e2) {
            BdLog.e(Log.getStackTraceString(e2));
        }
        if (z) {
            this.f20195f = "logcat -v threadtime *:v -d";
        } else {
            this.f20195f = "logcat -v threadtime *:v";
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Process process = this.f20196g;
            if (process != null) {
                process.destroy();
                this.f20196g = null;
            }
            BufferedReader bufferedReader = this.f20197h;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    this.f20197h = null;
                } catch (IOException e2) {
                    BdLog.e(Log.getStackTraceString(e2));
                }
            }
            FileOutputStream fileOutputStream = this.f20198i;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    BdLog.e(Log.getStackTraceString(e3));
                }
                this.f20198i = null;
            }
            a aVar = this.f20199j;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f20199j = aVar;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f20194e = false;
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
                    this.f20196g = Runtime.getRuntime().exec(this.f20195f);
                    this.f20197h = new BufferedReader(new InputStreamReader(this.f20196g.getInputStream()), 1024);
                    while (this.f20194e && (readLine = this.f20197h.readLine()) != null && this.f20194e) {
                        if (readLine.length() != 0 && this.f20198i != null) {
                            FileOutputStream fileOutputStream = this.f20198i;
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
