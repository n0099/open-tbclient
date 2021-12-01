package com.baidu.tbadk.core.util.httpNet;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes9.dex */
public class NetWorkParam {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String charSet;
    public HashMap<String, byte[]> mFileData;
    public String mFrom;
    public boolean mIsBDImage;
    public boolean mIsBaiduServer;
    public boolean mIsJson;
    public String mNetType;
    public ArrayList<BasicNameValuePair> mPostData;
    public boolean mRequestGzip;
    public String mSeqId;
    public String mUrl;

    public NetWorkParam() {
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
        this.mIsBaiduServer = true;
        this.mIsJson = true;
        this.charSet = "UTF-8";
        this.mUrl = null;
        this.mPostData = null;
        this.mRequestGzip = true;
        this.mIsBDImage = false;
        this.mFileData = null;
        this.mIsJson = true;
        this.mSeqId = null;
        this.mNetType = null;
        this.mFrom = null;
    }
}
