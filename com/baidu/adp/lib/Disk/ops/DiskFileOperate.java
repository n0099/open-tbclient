package com.baidu.adp.lib.Disk.ops;

import androidx.core.view.InputDeviceCompat;
import c.a.e.e.a.d;
import c.a.e.e.a.e;
import c.a.e.e.m.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.OutputStream;
import org.apache.http.client.methods.HttpDelete;
/* loaded from: classes4.dex */
public class DiskFileOperate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Action mAction;
    public e.b mCustomOperate;
    public volatile byte[] mData;
    public String mDesName;
    public String mDesPath;
    public File mFileInfo;
    public boolean mFormatData;
    public boolean mIsSubFolder;
    public volatile boolean mIsSuccess;
    public volatile Object mLock;
    public String mName;
    public OperateType mOperateType;
    public OutputStream mOutputStream;
    public String mPath;
    public boolean mSavedCache;
    public boolean mSdCard;
    public int mTrySuccessWeight;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class Action {
        public static final /* synthetic */ Action[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Action APPEND;
        public static final Action APPEND_MORE;
        public static final Action CUSTOM;
        public static final Action DELETE;
        public static final Action DELETE_FILES;
        public static final Action INFO;
        public static final Action READ;
        public static final Action RENAME;
        public static final Action WRITE;
        public static final Action WRITE_FORCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1289743049, "Lcom/baidu/adp/lib/Disk/ops/DiskFileOperate$Action;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1289743049, "Lcom/baidu/adp/lib/Disk/ops/DiskFileOperate$Action;");
                    return;
                }
            }
            READ = new Action("READ", 0);
            WRITE = new Action("WRITE", 1);
            WRITE_FORCE = new Action("WRITE_FORCE", 2);
            APPEND = new Action("APPEND", 3);
            APPEND_MORE = new Action("APPEND_MORE", 4);
            DELETE = new Action(HttpDelete.METHOD_NAME, 5);
            DELETE_FILES = new Action("DELETE_FILES", 6);
            INFO = new Action("INFO", 7);
            RENAME = new Action("RENAME", 8);
            Action action = new Action("CUSTOM", 9);
            CUSTOM = action;
            $VALUES = new Action[]{READ, WRITE, WRITE_FORCE, APPEND, APPEND_MORE, DELETE, DELETE_FILES, INFO, RENAME, action};
        }

        public Action(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Action valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Action) Enum.valueOf(Action.class, str) : (Action) invokeL.objValue;
        }

        public static Action[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Action[]) $VALUES.clone() : (Action[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class OperateType {
        public static final /* synthetic */ OperateType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final OperateType MUST_SUCCESS;
        public static final OperateType TRY_SUCCESS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(830921707, "Lcom/baidu/adp/lib/Disk/ops/DiskFileOperate$OperateType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(830921707, "Lcom/baidu/adp/lib/Disk/ops/DiskFileOperate$OperateType;");
                    return;
                }
            }
            MUST_SUCCESS = new OperateType("MUST_SUCCESS", 0);
            OperateType operateType = new OperateType("TRY_SUCCESS", 1);
            TRY_SUCCESS = operateType;
            $VALUES = new OperateType[]{MUST_SUCCESS, operateType};
        }

        public OperateType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static OperateType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (OperateType) Enum.valueOf(OperateType.class, str) : (OperateType) invokeL.objValue;
        }

        public static OperateType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (OperateType[]) $VALUES.clone() : (OperateType[]) invokeV.objValue;
        }
    }

    public DiskFileOperate(String str, String str2, Action action) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, action};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOperateType = OperateType.MUST_SUCCESS;
        this.mIsSubFolder = false;
        this.mAction = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.mIsSuccess = false;
        this.mFormatData = true;
        this.mOutputStream = null;
        this.mFileInfo = null;
        this.mSdCard = true;
        this.mSavedCache = false;
        this.mTrySuccessWeight = 0;
        this.mDesPath = null;
        this.mDesName = null;
        this.mCustomOperate = null;
        this.mPath = str;
        this.mName = str2;
        this.mAction = action;
    }

    public boolean asyncCall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.g().a(this) : invokeV.booleanValue;
    }

    public String buildDesPath() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mIsSubFolder && (str = this.mDesName) != null) {
                int hashCode = str.hashCode();
                if (hashCode < 0) {
                    hashCode *= -1;
                }
                int i2 = (hashCode % 100) + 1;
                if (this.mDesPath == null) {
                    return String.valueOf(i2);
                }
                return this.mDesPath + "/" + i2;
            }
            return this.mDesPath;
        }
        return (String) invokeV.objValue;
    }

    public byte[] buildFormatData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    public String buildPath() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mIsSubFolder && (str = this.mName) != null) {
                int hashCode = str.hashCode();
                if (hashCode < 0) {
                    hashCode *= -1;
                }
                int i2 = (hashCode % 100) + 1;
                if (this.mPath == null) {
                    return String.valueOf(i2);
                }
                return this.mPath + "/" + i2;
            }
            return this.mPath;
        }
        return (String) invokeV.objValue;
    }

    public boolean call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? d.g().d(this) : invokeV.booleanValue;
    }

    public void callback(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    public void cancelAsyncCall() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.g().e(this);
        }
    }

    public void endLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.finalize();
            release();
        }
    }

    public boolean formatData(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bArr)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public Action getAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mAction : (Action) invokeV.objValue;
    }

    public e.b getCustomOperate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mCustomOperate : (e.b) invokeV.objValue;
    }

    public byte[] getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mData : (byte[]) invokeV.objValue;
    }

    public String getDesName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mDesName : (String) invokeV.objValue;
    }

    public String getDesPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mDesPath : (String) invokeV.objValue;
    }

    public File getFileInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mFileInfo : (File) invokeV.objValue;
    }

    public Object getLock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mLock : invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mName : (String) invokeV.objValue;
    }

    public OperateType getOperateType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mOperateType : (OperateType) invokeV.objValue;
    }

    public OutputStream getOutputStream() {
        InterceptResult invokeV;
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            synchronized (this) {
                outputStream = this.mOutputStream;
            }
            return outputStream;
        }
        return (OutputStream) invokeV.objValue;
    }

    public String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mPath : (String) invokeV.objValue;
    }

    public int getTrySuccessWeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mTrySuccessWeight : invokeV.intValue;
    }

    public boolean isFormatData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mFormatData : invokeV.booleanValue;
    }

    public boolean isSavedCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mSavedCache : invokeV.booleanValue;
    }

    public boolean isSdCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mSdCard : invokeV.booleanValue;
    }

    public boolean isSubFolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mIsSubFolder : invokeV.booleanValue;
    }

    public boolean isSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mIsSuccess : invokeV.booleanValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            synchronized (this) {
                if (this.mOutputStream != null) {
                    a.d(this.mOutputStream);
                    this.mOutputStream = null;
                }
            }
        }
    }

    public void setCustomOperate(e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bVar) == null) {
            this.mCustomOperate = bVar;
        }
    }

    public void setData(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bArr) == null) {
            this.mData = bArr;
        }
    }

    public void setFileInfo(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, file) == null) {
            this.mFileInfo = file;
        }
    }

    public void setIsFormatData(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.mFormatData = z;
        }
    }

    public void setLock(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, obj) == null) {
            this.mLock = obj;
        }
    }

    public void setOperateType(OperateType operateType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, operateType) == null) {
            this.mOperateType = operateType;
        }
    }

    public void setOutputStream(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, outputStream) == null) {
            synchronized (this) {
                if (outputStream == this.mOutputStream) {
                    return;
                }
                release();
                this.mOutputStream = outputStream;
            }
        }
    }

    public void setSavedCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.mSavedCache = z;
        }
    }

    public void setSdCard(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.mSdCard = z;
        }
    }

    public void setSubFolder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.mIsSubFolder = z;
        }
    }

    public void setSuccess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.mIsSuccess = z;
        }
    }

    public void setTrySuccessWeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.mTrySuccessWeight = i2;
        }
    }

    public void startLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
        }
    }

    public void unLock() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || this.mLock == null) {
            return;
        }
        try {
            synchronized (this.mLock) {
                this.mLock.notifyAll();
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, action};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mOperateType = OperateType.MUST_SUCCESS;
        this.mIsSubFolder = false;
        this.mAction = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.mIsSuccess = false;
        this.mFormatData = true;
        this.mOutputStream = null;
        this.mFileInfo = null;
        this.mSdCard = true;
        this.mSavedCache = false;
        this.mTrySuccessWeight = 0;
        this.mDesPath = null;
        this.mDesName = null;
        this.mCustomOperate = null;
        this.mPath = str;
        this.mName = str2;
        this.mDesPath = str3;
        this.mDesName = str4;
        this.mAction = action;
    }
}
