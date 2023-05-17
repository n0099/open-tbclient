package com.baidu.dynamic.download.data.bean;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.NoProGuard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes3.dex */
public class DynamicFile implements NoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int callbackIndex;
    public String channelId;
    public String channelName;
    public long createTime;
    public long currentSize;
    public int downloadOption;
    public String downloadUrl;
    public String errMsg;
    public int errNo;
    public String extraLocal;
    public String extraServer;
    public byte[] fileData;
    public String filePath;
    public int fileSaveType;
    public String maxHostVersion;
    public String md5;
    public String minHostVersion;
    public String name;
    public String packageName;
    public long rawid;
    public int rollback;
    public String size;
    public String tipMsg;
    public long totalSize;
    public int type;
    public String uniqueID;
    public long updateTime;
    public long updateVersion;
    public long version;
    public int wifi;

    public DynamicFile() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.version = -1L;
        this.updateVersion = 0L;
        this.rollback = 0;
        this.errNo = -1;
        this.type = 0;
        this.filePath = "";
        this.fileData = null;
        this.fileSaveType = 0;
        this.totalSize = 0L;
        this.currentSize = 0L;
        this.createTime = 0L;
        this.updateTime = 0L;
        this.rawid = 0L;
        this.callbackIndex = 0;
        this.uniqueID = "";
    }

    @Deprecated
    public void copyDownloadInfo(DynamicFile dynamicFile) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dynamicFile) == null) {
            dynamicFile.errNo = this.errNo;
            dynamicFile.errMsg = this.errMsg;
            dynamicFile.tipMsg = this.tipMsg;
            dynamicFile.type = this.type;
            dynamicFile.filePath = this.filePath;
            dynamicFile.fileData = this.fileData;
            dynamicFile.fileSaveType = this.fileSaveType;
            dynamicFile.totalSize = this.totalSize;
            dynamicFile.currentSize = this.currentSize;
            dynamicFile.createTime = this.createTime;
            dynamicFile.updateTime = this.updateTime;
        }
    }

    @Deprecated
    public boolean equalsDynamicFile(DynamicFile dynamicFile) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dynamicFile)) == null) {
            if (this.channelId.equals(dynamicFile.channelId) && this.packageName.equals(dynamicFile.packageName) && this.version == dynamicFile.version && this.md5.equals(dynamicFile.md5)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public void sign(DynamicFile dynamicFile) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dynamicFile) == null) {
            dynamicFile.extraLocal = this.extraLocal;
            dynamicFile.downloadOption = this.downloadOption;
            dynamicFile.channelId = this.channelId;
            dynamicFile.channelName = this.channelName;
            dynamicFile.version = this.version;
            dynamicFile.updateVersion = this.updateVersion;
            dynamicFile.minHostVersion = this.minHostVersion;
            dynamicFile.maxHostVersion = this.maxHostVersion;
            dynamicFile.extraServer = this.extraServer;
            dynamicFile.downloadUrl = this.downloadUrl;
            dynamicFile.packageName = this.packageName;
        }
    }

    @Deprecated
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj == null || !(obj instanceof DynamicFile)) {
                return false;
            }
            return equalsDynamicFile((DynamicFile) obj);
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public boolean isOlderThan(DynamicFile dynamicFile) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dynamicFile)) == null) {
            if (this.version < dynamicFile.version) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("packageName:" + this.packageName);
            sb.append(",name:" + this.name);
            sb.append(",version:" + this.version);
            sb.append(",updateVersion:" + this.updateVersion);
            sb.append(",downloadUrl:" + this.downloadUrl);
            sb.append(",md5:" + this.md5);
            sb.append(",size:" + this.size);
            sb.append(",minHostVersion:" + this.minHostVersion);
            sb.append(",maxHostVersion:" + this.maxHostVersion);
            sb.append(",wifi:" + this.wifi);
            sb.append(",rollback:" + this.rollback);
            sb.append(",errNo:" + this.errNo);
            sb.append(",errMsg:" + this.errMsg);
            sb.append(",tipMsg:" + this.tipMsg);
            sb.append(",channelId:" + this.channelId);
            sb.append(",channelName:" + this.channelName);
            sb.append(",downloadOption:" + this.downloadOption);
            sb.append(",extraLocal:" + this.extraLocal);
            sb.append(",type:" + this.type);
            sb.append(",filePath:" + this.filePath);
            sb.append(",fileData:" + this.fileData);
            sb.append(",fileSaveType:" + this.fileSaveType);
            sb.append(",totalSize:" + this.totalSize);
            sb.append(",currentSize:" + this.currentSize);
            sb.append(",createTime:" + this.createTime);
            sb.append(",updateTime:" + this.updateTime);
            sb.append(",rawid:" + this.rawid);
            sb.append(",callbackIndex:" + this.callbackIndex);
            sb.append(",uniqueID:" + this.uniqueID);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
