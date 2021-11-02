package com.baidu.idl.statistics;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.idl.license.License;
import com.baidu.idl.util.FileUtil;
import com.baidu.idl.util.NetUtil;
import com.baidu.idl.util.StuLogEx;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class Statistics {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AS_FILE_NAME = "as";
    public static final int MESSAGE_INSTANT_SYNC_FILE = 1;
    public static final int MESSAGE_INTERVAL_SYNC_FILE = 2;
    public static final String SERVER_URL = "http://sdkss.shitu.baidu.com/cgi-bin/sdkstat.py";
    public static final long SYNC_FILE_DELAY_TIME = 3000;
    public static final String TAG = "AuthenticationStatistics";
    public transient /* synthetic */ FieldHolder $fh;
    public String al_version;
    public Context app;
    public String appId;
    public final Properties as;
    public File asFile;
    public String au_version;
    public boolean isInit;
    public String userId;
    public Handler workerHandler;
    public HandlerThread workerThread;

    /* loaded from: classes7.dex */
    public static final class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static final Statistics instance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(643464654, "Lcom/baidu/idl/statistics/Statistics$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(643464654, "Lcom/baidu/idl/statistics/Statistics$Holder;");
                    return;
                }
            }
            instance = new Statistics();
        }

        public Holder() {
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
    }

    /* loaded from: classes7.dex */
    public static final class StatisticsResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String errmsg;
        public int errno;

        public StatisticsResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.errno = i2;
            this.errmsg = str;
        }
    }

    public static Statistics getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? Holder.instance : (Statistics) invokeV.objValue;
    }

    private boolean initFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            File file = new File(this.app.getFilesDir(), "as");
            this.asFile = file;
            return FileUtil.createFile(file) && FileUtil.loadPropertiesFile(this.asFile, this.as);
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void merge(Properties properties) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, properties) == null) {
            synchronized (this) {
                for (Map.Entry entry : properties.entrySet()) {
                    String obj = entry.getKey().toString();
                    String obj2 = entry.getValue().toString();
                    if (!this.as.containsKey(obj)) {
                        this.as.setProperty(obj, obj2);
                    } else {
                        this.as.setProperty(obj, String.format(Locale.getDefault(), "%s-%s", obj2, this.as.getProperty(obj)));
                    }
                }
                syncFile(true);
            }
        }
    }

    private void syncFile(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, this, z) == null) {
            if (z) {
                this.workerHandler.removeMessages(1);
                this.workerHandler.sendEmptyMessage(1);
                return;
            }
            this.workerHandler.removeMessages(2);
            this.workerHandler.sendEmptyMessageDelayed(2, 3000L);
        }
    }

    public boolean init(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (this.isInit) {
                return true;
            }
            if (context != null && str != null && !"".equals(str)) {
                this.app = context;
                this.appId = str;
                try {
                    this.userId = CommonParam.getCUID(context);
                } catch (SecurityException e2) {
                    e2.printStackTrace();
                }
                this.al_version = License.getAlgorithmVersion();
                this.au_version = License.getAuthorityVersion();
                HandlerThread handlerThread = new HandlerThread("workerThread");
                this.workerThread = handlerThread;
                handlerThread.start();
                this.workerHandler = new Handler(this, this.workerThread.getLooper()) { // from class: com.baidu.idl.statistics.Statistics.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Statistics this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r8};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((Looper) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                            int i2 = message.what;
                            if (i2 == 1 || i2 == 2) {
                                FileUtil.savePropertiesFile(this.this$0.asFile, this.this$0.as);
                            }
                        }
                    }
                };
                if (initFile()) {
                    if (NetUtil.isConnected(context) && this.as.size() > 0) {
                        this.as.clear();
                        new Thread(new Runnable(this, (Properties) this.as.clone()) { // from class: com.baidu.idl.statistics.Statistics.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Statistics this$0;
                            public final /* synthetic */ Properties val$asCopy;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r7};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$asCopy = r7;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    NetUtil.uploadData(new NetUtil.RequestAdapter<StatisticsResult>(this) { // from class: com.baidu.idl.statistics.Statistics.2.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass2 this$1;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$1 = this;
                                        }

                                        @Override // com.baidu.idl.util.NetUtil.RequestAdapter
                                        public String getRequestString() {
                                            InterceptResult invokeV;
                                            String[] split;
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || (invokeV = interceptable3.invokeV(1048576, this)) == null) {
                                                StringBuilder sb = new StringBuilder();
                                                for (Map.Entry entry : this.this$1.val$asCopy.entrySet()) {
                                                    String str2 = (String) entry.getKey();
                                                    for (String str3 : ((String) entry.getValue()).split("-")) {
                                                        sb.append(this.this$1.this$0.appId);
                                                        sb.append(" ");
                                                        sb.append(this.this$1.this$0.userId);
                                                        sb.append(" ");
                                                        sb.append(str2);
                                                        sb.append(" ");
                                                        sb.append(str3);
                                                        sb.append(" ");
                                                        sb.append(this.this$1.this$0.au_version);
                                                        sb.append(" ");
                                                        sb.append(this.this$1.this$0.al_version);
                                                        sb.append(StringUtils.LF);
                                                    }
                                                }
                                                return sb.toString();
                                            }
                                            return (String) invokeV.objValue;
                                        }

                                        @Override // com.baidu.idl.util.NetUtil.RequestAdapter
                                        public String getURL() {
                                            InterceptResult invokeV;
                                            Interceptable interceptable3 = $ic;
                                            return (interceptable3 == null || (invokeV = interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Statistics.SERVER_URL : (String) invokeV.objValue;
                                        }

                                        /* JADX DEBUG: Method merged with bridge method */
                                        @Override // com.baidu.idl.util.NetUtil.RequestAdapter
                                        public void onResponse(int i2, StatisticsResult statisticsResult, Exception exc) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, statisticsResult, exc) == null) {
                                                if (i2 != 0) {
                                                    StuLogEx.e(Statistics.TAG, exc.getMessage(), exc);
                                                } else if (statisticsResult.errno != 0) {
                                                    StuLogEx.e(Statistics.TAG, statisticsResult.errmsg);
                                                } else {
                                                    this.this$1.val$asCopy.clear();
                                                }
                                                AnonymousClass2 anonymousClass2 = this.this$1;
                                                anonymousClass2.this$0.merge(anonymousClass2.val$asCopy);
                                            }
                                        }

                                        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
                                        /* JADX DEBUG: Method merged with bridge method */
                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // com.baidu.idl.util.NetUtil.RequestAdapter
                                        public StatisticsResult parseResponse(InputStream inputStream) throws IOException, JSONException {
                                            InterceptResult invokeL;
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || (invokeL = interceptable3.invokeL(1048580, this, inputStream)) == null) {
                                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                byte[] bArr = new byte[1024];
                                                while (true) {
                                                    try {
                                                        int read = inputStream.read(bArr);
                                                        if (read <= 0) {
                                                            break;
                                                        }
                                                        byteArrayOutputStream.write(bArr, 0, read);
                                                    } finally {
                                                        try {
                                                            byteArrayOutputStream.close();
                                                        } catch (IOException unused) {
                                                        }
                                                    }
                                                }
                                                byteArrayOutputStream.flush();
                                                JSONObject jSONObject = new JSONObject(new String(byteArrayOutputStream.toByteArray(), "UTF-8"));
                                                return new StatisticsResult(jSONObject.getInt("errno"), jSONObject.getString("errnmsg"));
                                            }
                                            return (StatisticsResult) invokeL.objValue;
                                        }
                                    });
                                }
                            }
                        }).start();
                    }
                    this.isInit = true;
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("The params is invalid!");
        }
        return invokeLL.booleanValue;
    }

    public synchronized void triggerEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (this) {
            }
        }
    }

    public Statistics() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.app = null;
        this.appId = null;
        this.userId = null;
        this.al_version = null;
        this.au_version = null;
        this.isInit = false;
        this.asFile = null;
        this.as = new Properties();
        this.workerThread = null;
        this.workerHandler = null;
    }
}
