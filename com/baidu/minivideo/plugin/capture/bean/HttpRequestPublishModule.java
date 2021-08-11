package com.baidu.minivideo.plugin.capture.bean;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiOptions;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class HttpRequestPublishModule {
    public static /* synthetic */ Interceptable $ic;
    public static final int HTTP_NO_ERROR = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class ImageData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int height;
        public String url;
        public int width;

        public ImageData() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class PopInfoDaLiBao implements Jsonable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean enabled;
        public int points;
        public String text;
        public int time;

        public PopInfoDaLiBao() {
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
            this.enabled = false;
        }

        @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
        public boolean parse(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.enabled = jSONObject.optBoolean(SapiOptions.KEY_CACHE_ENABLED);
                    this.text = jSONObject.optString("text");
                    this.time = jSONObject.optInt("time");
                    this.points = jSONObject.optInt("points");
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return true;
                }
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
        public JSONObject toJson() {
            InterceptResult invokeV;
            JSONObject jSONObject;
            Exception e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                try {
                    jSONObject = new JSONObject();
                } catch (Exception e3) {
                    jSONObject = null;
                    e2 = e3;
                }
                try {
                    jSONObject.put(SapiOptions.KEY_CACHE_ENABLED, this.enabled);
                    jSONObject.put("text", this.text);
                    jSONObject.put("time", this.time);
                    jSONObject.put("points", this.points);
                } catch (Exception e4) {
                    e2 = e4;
                    e2.printStackTrace();
                    return jSONObject;
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class PublishData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String coverImg;
        public String duration;
        public String heightInPixel;
        public String isTransfer;
        public String mediaType;
        public String metaId;
        public final /* synthetic */ HttpRequestPublishModule this$0;
        public String userType;
        public String vid;
        public String videoUrl;
        public String widthInPixel;

        public PublishData(HttpRequestPublishModule httpRequestPublishModule) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpRequestPublishModule};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = httpRequestPublishModule;
        }
    }

    /* loaded from: classes5.dex */
    public class PublishResultInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String msg;
        public PopInfoDaLiBao popInfoDaLiBao;
        public ShareData share;
        public int status;
        public final /* synthetic */ HttpRequestPublishModule this$0;
        public PublishData video;

        public PublishResultInfo(HttpRequestPublishModule httpRequestPublishModule) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpRequestPublishModule};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = httpRequestPublishModule;
        }

        public boolean isResultCorrect() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.status != 0 || this.video == null || this.share == null || this.popInfoDaLiBao == null) ? false : true : invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class ShareData implements Jsonable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String content;
        public String icon;
        public String link;
        public String shareText;
        public final /* synthetic */ HttpRequestPublishModule this$0;
        public String title;

        public ShareData(HttpRequestPublishModule httpRequestPublishModule) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpRequestPublishModule};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = httpRequestPublishModule;
        }

        @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
        public boolean parse(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.title = jSONObject.optString("title");
                    this.content = jSONObject.optString("content");
                    this.link = jSONObject.optString("link");
                    this.icon = jSONObject.optString("icon");
                    this.shareText = jSONObject.optString("shareText");
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return true;
                }
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
        public JSONObject toJson() {
            InterceptResult invokeV;
            JSONObject jSONObject;
            Exception e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                try {
                    jSONObject = new JSONObject();
                } catch (Exception e3) {
                    jSONObject = null;
                    e2 = e3;
                }
                try {
                    jSONObject.put("title", this.title);
                    jSONObject.put("content", this.content);
                    jSONObject.put("link", this.link);
                    jSONObject.put("icon", this.icon);
                    jSONObject.put("shareText", this.shareText);
                } catch (Exception e4) {
                    e2 = e4;
                    e2.printStackTrace();
                    return jSONObject;
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class VideoUploadModel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String coverUrl;
        public String duration;
        public String height;
        public String mediaId;
        public String size;
        public String width;

        public VideoUploadModel() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public HttpRequestPublishModule() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
