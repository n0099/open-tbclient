package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NetDiskFileMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<NetDiskFileMsg> CREATOR;
    public static final String JSON_KEY_EXT = "ext";
    public static final String JSON_KEY_FILES = "files";
    public static final String JSON_KEY_FILES_COUNT = "files_count";
    public static final String JSON_KEY_SCHEMA = "schema";
    public static final String JSON_KEY_SHARE_URL = "share_url";
    public static final String JSON_KEY_TPL_TYPE = "tpl_type";
    public static final int MAX_DISPLAY_FILE_COUNT = 3;
    public static final String TAG = "NetDiskFileMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public String ext;
    public NetDiskFile[] files;
    public int filesCount;
    public String schema;
    public String shareUrl;
    public int tplType;

    /* loaded from: classes.dex */
    public static class NetDiskFile implements Parcelable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final Parcelable.Creator<NetDiskFile> CREATOR;
        public static final String JSON_KEY_CATEGORY = "file_category";
        public static final String JSON_KEY_COVER_URL = "cover_url";
        public static final String JSON_KEY_FILE_TYPE = "file_type";
        public static final String JSON_KEY_NAME = "file_title";
        public static final String JSON_KEY_SIZE = "size";
        public static final String JSON_KEY_TIMESTAMP = "timestamp";
        public transient /* synthetic */ FieldHolder $fh;
        public int category;
        public String coverUrl;
        public int fileType;
        public String name;
        public String size;
        public long timestamp;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1265552386, "Lcom/baidu/android/imsdk/chatmessage/messages/NetDiskFileMsg$NetDiskFile;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1265552386, "Lcom/baidu/android/imsdk/chatmessage/messages/NetDiskFileMsg$NetDiskFile;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<NetDiskFile>() { // from class: com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg.NetDiskFile.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public NetDiskFile createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new NetDiskFile(parcel);
                    }
                    return (NetDiskFile) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public NetDiskFile[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return new NetDiskFile[i];
                    }
                    return (NetDiskFile[]) invokeI.objValue;
                }
            };
        }

        public NetDiskFile() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Parcelable.Creator<NetDiskFile> getCREATOR() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return CREATOR;
            }
            return (Parcelable.Creator) invokeV.objValue;
        }

        public String getCoverUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.coverUrl;
            }
            return (String) invokeV.objValue;
        }

        public int getFileType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.fileType;
            }
            return invokeV.intValue;
        }

        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.name;
            }
            return (String) invokeV.objValue;
        }

        public String getSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.size;
            }
            return (String) invokeV.objValue;
        }

        public long getTimestamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.timestamp;
            }
            return invokeV.longValue;
        }

        public NetDiskFile(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            setName(parcel.readString());
            setSize(parcel.readString());
            setCategory(parcel.readInt());
            setFileType(parcel.readInt());
            setTimestamp(parcel.readInt());
            setCoverUrl(parcel.readString());
        }

        public int getCategory() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i = this.category;
                if (i >= 0 && i <= 11) {
                    return i;
                }
                LogUtils.e("NetDiskFile", "category 类型异常，当前为: " + this.category + " 修改为默认值 1");
                return 1;
            }
            return invokeV.intValue;
        }

        public void setCategory(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
                this.category = i;
            }
        }

        public void setCoverUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.coverUrl = str;
            }
        }

        public void setFileType(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
                this.fileType = i;
            }
        }

        public void setName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                this.name = str;
            }
        }

        public void setSize(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                this.size = str;
            }
        }

        public void setTimestamp(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
                this.timestamp = j;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048589, this, parcel, i) == null) {
                parcel.writeString(getName());
                parcel.writeString(getSize());
                parcel.writeInt(getCategory());
                parcel.writeInt(getFileType());
                parcel.writeInt((int) getTimestamp());
                parcel.writeString(getCoverUrl());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class TplType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MULTIPLE_FILE = 2;
        public static final int SINGLE_FILE = 1;
        public transient /* synthetic */ FieldHolder $fh;

        public TplType() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1244900852, "Lcom/baidu/android/imsdk/chatmessage/messages/NetDiskFileMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1244900852, "Lcom/baidu/android/imsdk/chatmessage/messages/NetDiskFileMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<NetDiskFileMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public NetDiskFileMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new NetDiskFileMsg(parcel);
                }
                return (NetDiskFileMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public NetDiskFileMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new NetDiskFileMsg[i];
                }
                return (NetDiskFileMsg[]) invokeI.objValue;
            }
        };
    }

    public NetDiskFileMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setMsgType(55);
    }

    public static Parcelable.Creator<NetDiskFileMsg> getCREATOR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return CREATOR;
        }
        return (Parcelable.Creator) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.ext;
        }
        return (String) invokeV.objValue;
    }

    public NetDiskFile[] getFiles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.files;
        }
        return (NetDiskFile[]) invokeV.objValue;
    }

    public int getFilesCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.filesCount;
        }
        return invokeV.intValue;
    }

    public String getSchema() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.schema;
        }
        return (String) invokeV.objValue;
    }

    public String getShareUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.shareUrl;
        }
        return (String) invokeV.objValue;
    }

    public int getTplType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.tplType;
        }
        return invokeV.intValue;
    }

    public boolean isFilesValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            NetDiskFile[] netDiskFileArr = this.files;
            if (netDiskFileArr != null && netDiskFileArr.length > 0 && this.filesCount >= 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetDiskFileMsg(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        setTplType(parcel.readInt());
        setShareUrl(parcel.readString());
        setSchema(parcel.readString());
        setFilesCount(parcel.readInt());
        Parcelable[] readParcelableArray = parcel.readParcelableArray(NetDiskFile.class.getClassLoader());
        if (readParcelableArray != null) {
            setFiles((NetDiskFile[]) Arrays.copyOf(readParcelableArray, readParcelableArray.length, NetDiskFile[].class));
        }
        setExt(parcel.readString());
    }

    private void parseAndSetFiles(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject) == null) {
            try {
                setFilesCount(jSONObject.optInt(JSON_KEY_FILES_COUNT));
                JSONArray jSONArray = new JSONArray(jSONObject.getString(JSON_KEY_FILES));
                if (jSONArray.length() == 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length() && arrayList.size() <= 3; i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        NetDiskFile netDiskFile = new NetDiskFile();
                        netDiskFile.setName(jSONObject2.getString(NetDiskFile.JSON_KEY_NAME));
                        netDiskFile.setCategory(jSONObject2.getInt(NetDiskFile.JSON_KEY_CATEGORY));
                        netDiskFile.setTimestamp(jSONObject2.getInt("timestamp"));
                        netDiskFile.setSize(jSONObject2.optString("size"));
                        netDiskFile.setCoverUrl(jSONObject2.optString(NetDiskFile.JSON_KEY_COVER_URL));
                        netDiskFile.setFileType(jSONObject2.optInt(NetDiskFile.JSON_KEY_FILE_TYPE));
                        arrayList.add(netDiskFile);
                    }
                }
                this.files = (NetDiskFile[]) arrayList.toArray(new NetDiskFile[arrayList.size()]);
            } catch (JSONException e) {
                LogUtils.e(TAG, "parse json failed:" + e.getMessage());
            }
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            NetDiskFile[] netDiskFileArr = this.files;
            if (netDiskFileArr != null && netDiskFileArr.length > 0 && netDiskFileArr[0] != null) {
                return "[网盘文件]" + this.files[0].name;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void onMsgSetComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            JSONObject jSONObject = new JSONObject();
            if (isFilesValid()) {
                try {
                    jSONObject.put(JSON_KEY_TPL_TYPE, getTplType());
                    jSONObject.put("schema", getSchema());
                    jSONObject.put("share_url", getShareUrl());
                    jSONObject.put(JSON_KEY_FILES_COUNT, getFilesCount());
                    if (!TextUtils.isEmpty(getExt())) {
                        jSONObject.put("ext", getExt());
                    }
                    NetDiskFile[] files = getFiles();
                    JSONArray jSONArray = new JSONArray();
                    if (files != null && files.length > 0) {
                        for (NetDiskFile netDiskFile : files) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(NetDiskFile.JSON_KEY_NAME, netDiskFile.getName());
                            jSONObject2.put(NetDiskFile.JSON_KEY_CATEGORY, netDiskFile.getCategory());
                            jSONObject2.put(NetDiskFile.JSON_KEY_FILE_TYPE, netDiskFile.getFileType());
                            jSONObject2.put("size", netDiskFile.getSize());
                            jSONObject2.put("timestamp", netDiskFile.getTimestamp());
                            jSONObject2.put(NetDiskFile.JSON_KEY_COVER_URL, netDiskFile.getCoverUrl());
                            jSONArray.put(jSONObject2);
                        }
                        jSONObject.put(JSON_KEY_FILES, jSONArray);
                    } else {
                        jSONObject.put(JSON_KEY_FILES, jSONArray);
                    }
                } catch (JSONException e) {
                    LogUtils.e(TAG, "set data failed:" + e.getMessage());
                }
            } else {
                LogUtils.e(TAG, "NetDiskMsg invalid");
            }
            setMsgContent(jSONObject.toString());
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(getMsgContent());
                parseAndSetFiles(jSONObject);
                if (!isFilesValid()) {
                    return false;
                }
                setTplType(jSONObject.getInt(JSON_KEY_TPL_TYPE));
                setShareUrl(jSONObject.optString("share_url"));
                setSchema(jSONObject.getString("schema"));
                setExt(jSONObject.optString("ext"));
                return true;
            } catch (JSONException e) {
                LogUtils.e(TAG, "parseJsonString", e);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void setExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.ext = str;
        }
    }

    public void setFiles(NetDiskFile[] netDiskFileArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, netDiskFileArr) == null) {
            this.files = netDiskFileArr;
        }
    }

    public void setFilesCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.filesCount = i;
        }
    }

    public void setSchema(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.schema = str;
        }
    }

    public void setShareUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.shareUrl = str;
        }
    }

    public void setTplType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.tplType = i;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(getTplType());
            parcel.writeString(getShareUrl());
            parcel.writeString(getSchema());
            parcel.writeInt(getFilesCount());
            NetDiskFile[] netDiskFileArr = this.files;
            if (netDiskFileArr != null) {
                parcel.writeParcelableArray(netDiskFileArr, i);
            }
            parcel.writeString(getExt());
        }
    }
}
