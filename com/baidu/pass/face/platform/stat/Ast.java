package com.baidu.pass.face.platform.stat;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.pass.face.platform.stat.NetUtil;
import com.baidu.pass.main.facesdk.FaceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class Ast {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AS_FILE_NAME = "ast";
    public static final long UPADTE_DEFUALT_DELAY_TIME = 15000;
    public static Ast instance;
    public transient /* synthetic */ FieldHolder $fh;
    public File asFile;
    public Context context;
    public Dev dev;
    public String faceHitKey;
    public String faceHitKeyLasttime;
    public SparseArray<Integer> faceIds;
    public boolean isInit;
    public long lastSavetime;
    public Properties properties;
    public String scene;

    public Ast() {
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
        this.faceHitKey = "";
        this.faceHitKeyLasttime = "FACE_HIT_KEY_LASSTTIME";
        this.faceIds = new SparseArray<>();
    }

    private void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.properties.clear();
        }
    }

    private String generateFaceHitKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, str)) == null) {
            return new SimpleDateFormat("yyyy_MM_dd_HH").format(new Date()) + "_" + str;
        }
        return (String) invokeL.objValue;
    }

    public static Ast getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (instance == null) {
                synchronized (Ast.class) {
                    instance = new Ast();
                }
            }
            return instance;
        }
        return (Ast) invokeV.objValue;
    }

    private boolean initFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            this.asFile = new File(this.context.getFilesDir(), AS_FILE_NAME);
            this.properties = new Properties();
            if (FileUtil.createFile(this.asFile)) {
                return FileUtil.loadPropertiesFile(this.asFile, this.properties);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void netRequest() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.properties.size() == 0) {
            return;
        }
        NetUtil.uploadData(new NetUtil.RequestAdapter<Object>(this) { // from class: com.baidu.pass.face.platform.stat.Ast.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Ast this$0;

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

            @Override // com.baidu.pass.face.platform.stat.NetUtil.RequestAdapter
            public String getRequestString() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("mh", "faceSdkStatistic");
                        JSONArray jSONArray = new JSONArray();
                        for (Map.Entry entry : ((Properties) this.this$0.properties.clone()).entrySet()) {
                            String str = (String) entry.getKey();
                            String str2 = (String) entry.getValue();
                            if (!str.equalsIgnoreCase(this.this$0.faceHitKeyLasttime)) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("type", "facesdk");
                                jSONObject2.put("scene", this.this$0.scene);
                                jSONObject2.put("appid", this.this$0.dev.getPackagename());
                                jSONObject2.put("device", this.this$0.dev.getBrand());
                                jSONObject2.put("imei", this.this$0.dev.getUniqueID());
                                jSONObject2.put("os", "Android");
                                jSONObject2.put(ConstantHelper.LOG_OS, this.this$0.dev.getSysVersion());
                                jSONObject2.put("version", this.this$0.dev.getSdkVersion());
                                if (str.contains("liveness")) {
                                    jSONObject2.put("isliving", "true");
                                } else {
                                    jSONObject2.put("isliving", "false");
                                }
                                jSONObject2.put(ConstantHelper.LOG_FINISH, "1");
                                String[] split = str.split("_");
                                if (split.length > 4) {
                                    jSONObject2.put("year", split[0]);
                                    jSONObject2.put("month", split[1]);
                                    jSONObject2.put("day", split[2]);
                                    jSONObject2.put("hour", split[3]);
                                }
                                jSONObject2.put("num", str2);
                                jSONArray.put(jSONObject2);
                            }
                        }
                        jSONObject.put("dt", jSONArray);
                        return jSONObject.toString();
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        return "";
                    }
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.pass.face.platform.stat.NetUtil.RequestAdapter
            public String getURL() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "https://brain.baidu.com/record/api" : (String) invokeV.objValue;
            }

            /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
            @Override // com.baidu.pass.face.platform.stat.NetUtil.RequestAdapter
            public void parseResponse(InputStream inputStream) throws IOException, JSONException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, inputStream) == null) {
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
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    byteArrayOutputStream.flush();
                    if (new JSONObject(new String(byteArrayOutputStream.toByteArray(), "UTF-8")).optInt("code") == 0) {
                        this.this$0.properties.clear();
                        this.this$0.dev.setFirstRun(false);
                        FileUtil.savePropertiesFile(this.this$0.asFile, this.this$0.properties);
                    }
                }
            }
        });
    }

    private void sendData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            Executors.newSingleThreadExecutor().submit(new Runnable(this) { // from class: com.baidu.pass.face.platform.stat.Ast.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Ast this$0;

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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.netRequest();
                    }
                }
            });
        }
    }

    public void faceHit(String str, int i2, FaceInfo[] faceInfoArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i2, faceInfoArr) == null) {
            if (faceInfoArr == null) {
                this.faceIds.clear();
                return;
            }
            int i3 = 0;
            for (FaceInfo faceInfo : faceInfoArr) {
                if (this.faceIds.get(faceInfo.faceID) == null) {
                    SparseArray<Integer> sparseArray = this.faceIds;
                    int i4 = faceInfo.faceID;
                    sparseArray.put(i4, Integer.valueOf(i4));
                    i3++;
                }
            }
            if (i3 == 0) {
                return;
            }
            faceHit(str, i2, i3);
        }
    }

    public void immediatelyUpload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            sendData();
        }
    }

    public boolean init(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, context, str, str2)) == null) {
            if (!this.isInit && context != null) {
                this.context = context.getApplicationContext();
                Dev dev = new Dev();
                this.dev = dev;
                dev.init(context);
                this.dev.setSdkVersion(str);
                this.scene = str2;
                initFile();
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void faceHit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            faceHit("liveness", 15000L, 1);
        }
    }

    public void faceHit(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            faceHit(str, 15000L, 1);
        }
    }

    public void faceHit(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
            faceHit(str, 15000L, i2);
        }
    }

    public void faceHit(String str, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Long.valueOf(j2), Integer.valueOf(i2)}) == null) || this.properties == null) {
            return;
        }
        String generateFaceHitKey = generateFaceHitKey(str);
        String property = this.properties.getProperty(generateFaceHitKey);
        if (TextUtils.isEmpty(property)) {
            this.properties.setProperty(generateFaceHitKey, String.valueOf(i2));
            this.properties.setProperty(this.faceHitKeyLasttime, String.valueOf(System.currentTimeMillis()));
        } else {
            this.properties.setProperty(generateFaceHitKey, String.valueOf(Integer.parseInt(property) + i2));
        }
        FileUtil.savePropertiesFile(this.asFile, this.properties);
        String property2 = this.properties.getProperty(this.faceHitKeyLasttime);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            currentTimeMillis = Long.parseLong(property2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.dev.getFirstRun() || System.currentTimeMillis() - currentTimeMillis >= j2) {
            sendData();
        }
    }
}
