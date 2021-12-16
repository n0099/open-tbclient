package com.baidu.searchbox.bddownload.core.breakpoint;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class KeyToIdMap {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final SparseArray<String> idToKeyMap;
    @NonNull
    public final HashMap<String, Integer> keyToIdMap;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KeyToIdMap() {
        this(new HashMap(), new SparseArray());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((HashMap) objArr[0], (SparseArray) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void add(@NonNull DownloadTask downloadTask, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, downloadTask, i2) == null) {
            String generateKey = generateKey(downloadTask);
            this.keyToIdMap.put(generateKey, Integer.valueOf(i2));
            this.idToKeyMap.put(i2, generateKey);
        }
    }

    public String generateKey(@NonNull DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadTask)) == null) {
            return downloadTask.getUrl() + downloadTask.getUri() + downloadTask.getFilename();
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public Integer get(@NonNull DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadTask)) == null) {
            Integer num = this.keyToIdMap.get(generateKey(downloadTask));
            if (num != null) {
                return num;
            }
            return null;
        }
        return (Integer) invokeL.objValue;
    }

    public void remove(int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (str = this.idToKeyMap.get(i2)) == null) {
            return;
        }
        this.keyToIdMap.remove(str);
        this.idToKeyMap.remove(i2);
    }

    public KeyToIdMap(@NonNull HashMap<String, Integer> hashMap, @NonNull SparseArray<String> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hashMap, sparseArray};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.keyToIdMap = hashMap;
        this.idToKeyMap = sparseArray;
    }
}
