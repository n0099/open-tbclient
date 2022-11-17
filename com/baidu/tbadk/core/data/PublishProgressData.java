package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.hr8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Objects;
/* loaded from: classes3.dex */
public class PublishProgressData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long ID;
    public String forumId;
    public boolean isRunning;
    public boolean isWork;
    public int progress;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1552590605, "Lcom/baidu/tbadk/core/data/PublishProgressData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1552590605, "Lcom/baidu/tbadk/core/data/PublishProgressData;");
                return;
            }
        }
        MessageManager.getInstance().registerStickyMode(2921526);
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.progress;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return Objects.hash(Long.valueOf(this.ID));
        }
        return invokeV.intValue;
    }

    public void hideRunning() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.isRunning = false;
        }
    }

    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.isRunning;
        }
        return invokeV.booleanValue;
    }

    public boolean isWork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.isWork;
        }
        return invokeV.booleanValue;
    }

    public PublishProgressData(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.forumId = "0";
        this.ID = j;
    }

    public static PublishProgressData valueOf(@NonNull WriteData writeData, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, writeData, i)) == null) {
            PublishProgressData publishProgressData = new PublishProgressData(writeData.startPublishTime());
            if (!TextUtils.isEmpty(writeData.getForumId())) {
                publishProgressData.forumId = writeData.getForumId();
            }
            publishProgressData.isWork = writeData.isWork();
            publishProgressData.progress = i;
            return publishProgressData;
        }
        return (PublishProgressData) invokeLI.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof PublishProgressData) && this.ID == ((PublishProgressData) obj).ID) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isCurrentForum(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return this.forumId.equals(str);
        }
        return invokeL.booleanValue;
    }

    public void update(@NonNull PublishProgressData publishProgressData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, publishProgressData) == null) {
            if (!publishProgressData.isRunning) {
                this.isRunning = false;
            }
            this.progress = publishProgressData.getProgress();
        }
    }

    public void send(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.isRunning = z;
            if (this.ID > 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921526, this));
                if (this.isWork && this.progress == 93) {
                    WorkPostNotifyFlutterData notifyFlutterVideoUploadSucc = WorkPostNotifyFlutterData.notifyFlutterVideoUploadSucc();
                    notifyFlutterVideoUploadSucc.setFlutterPageId(hr8.k().j());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, notifyFlutterVideoUploadSucc));
                }
            }
        }
    }
}
