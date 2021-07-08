package com.baidu.mobads.container;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.SdcardUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class XAdPersistData {
    public static /* synthetic */ Interceptable $ic = null;
    public static String SEPERATOR = ":";
    public static XAdPersistData mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, String> mData;
    public String mDataPath;
    public boolean mDataSync;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-130211719, "Lcom/baidu/mobads/container/XAdPersistData;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-130211719, "Lcom/baidu/mobads/container/XAdPersistData;");
        }
    }

    public XAdPersistData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDataSync = false;
        this.mData = new HashMap<>();
    }

    private void close(Writer writer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, writer) == null) {
            try {
                writer.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static XAdPersistData getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (mInstance == null) {
                synchronized (XAdPersistData.class) {
                    mInstance = new XAdPersistData();
                }
            }
            return mInstance;
        }
        return (XAdPersistData) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean readData(String str, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65547, this, str, hashMap)) != null) {
            return invokeLL.booleanValue;
        }
        Reader reader = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                close((Reader) null);
                return true;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                String readLine = bufferedReader.readLine();
                int indexOf = readLine.indexOf(SEPERATOR);
                if (indexOf > 0) {
                    hashMap.put(readLine.substring(0, indexOf), readLine.substring(indexOf + 1));
                }
                close(bufferedReader);
                return true;
            } catch (Throwable unused) {
                reader = bufferedReader;
                close(reader);
                return false;
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeData(String str, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65548, this, str, hashMap) != null) {
            return;
        }
        Writer writer = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            try {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    bufferedWriter.write(String.format("%s%s%s\n", entry.getKey(), SEPERATOR, entry.getValue()));
                }
                close(bufferedWriter);
            } catch (Throwable unused) {
                writer = bufferedWriter;
                close(writer);
            }
        } catch (Throwable unused2) {
        }
    }

    public String get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.mData.get(str) : (String) invokeL.objValue;
    }

    public void put(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            this.mData.put(str, str2);
            try {
                TaskScheduler.getInstance().submitWithDelay(new BaseTask(this) { // from class: com.baidu.mobads.container.XAdPersistData.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ XAdPersistData this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    @Override // com.baidu.mobads.container.executor.BaseTask
                    public Object doInBackground() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            XAdPersistData xAdPersistData = this.this$0;
                            xAdPersistData.writeData(xAdPersistData.mDataPath, this.this$0.mData);
                            return null;
                        }
                        return invokeV.objValue;
                    }
                }, 3L, TimeUnit.SECONDS);
            } catch (Throwable unused) {
            }
        }
    }

    public void sync(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) && context != null && !this.mDataSync) {
            try {
                TaskScheduler.getInstance().submitWithDelay(new BaseTask(this, context) { // from class: com.baidu.mobads.container.XAdPersistData.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ XAdPersistData this$0;
                    public final /* synthetic */ Context val$context;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context};
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
                        this.val$context = context;
                    }

                    @Override // com.baidu.mobads.container.executor.BaseTask
                    public Object doInBackground() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            this.this$0.mDataPath = String.format("%s/%s", SdcardUtils.getStoragePathForDlApk(this.val$context), "pdata");
                            XAdPersistData xAdPersistData = this.this$0;
                            xAdPersistData.mDataSync = xAdPersistData.readData(xAdPersistData.mDataPath, this.this$0.mData);
                            return null;
                        }
                        return invokeV.objValue;
                    }
                }, 0L, TimeUnit.MILLISECONDS);
            } catch (Throwable unused) {
            }
        }
    }

    private void close(Reader reader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, reader) == null) {
            try {
                reader.close();
            } catch (Throwable unused) {
            }
        }
    }
}
