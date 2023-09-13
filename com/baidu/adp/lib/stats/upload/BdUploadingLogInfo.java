package com.baidu.adp.lib.stats.upload;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ac;
import com.baidu.tieba.vb;
import com.baidu.tieba.xg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class BdUploadingLogInfo extends ArrayList<ArrayList<xg>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -1737585838278753290L;
    public transient /* synthetic */ FieldHolder $fh;
    public String mLogDir;
    public boolean mMustSuccess;
    public boolean mUseSdCard;

    public BdUploadingLogInfo(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLogDir = null;
        this.mLogDir = str;
        this.mUseSdCard = z;
        this.mMustSuccess = z2;
    }

    private String readLogFileString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            ac acVar = new ac(this.mLogDir, str, DiskFileOperate.Action.READ);
            acVar.setSdCard(this.mUseSdCard);
            if (!this.mMustSuccess) {
                acVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                acVar.setTrySuccessWeight(3);
            }
            vb.f().call(acVar);
            if (acVar.isSuccess()) {
                return acVar.a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public ArrayList<String> getLogStringByIndex(int i, ArrayList<String> arrayList) {
        InterceptResult invokeIL;
        int i2;
        String[] split;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, arrayList)) == null) {
            if (arrayList != null) {
                i2 = arrayList.size();
            } else {
                i2 = 0;
            }
            ArrayList<xg> arrayList2 = get(i);
            ArrayList<String> arrayList3 = new ArrayList<>();
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                String readLogFileString = readLogFileString(arrayList2.get(i3).b);
                if (!TextUtils.isEmpty(readLogFileString)) {
                    for (String str : readLogFileString.split("\r\n")) {
                        if (i2 > 0) {
                            Iterator<String> it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (str.contains(it.next())) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        z = false;
                        if (!z) {
                            arrayList3.add(str);
                        }
                    }
                }
            }
            return arrayList3;
        }
        return (ArrayList) invokeIL.objValue;
    }

    public ArrayList<String> getTrackLogStringByIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            ArrayList<xg> arrayList = get(i);
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                String readLogFileString = readLogFileString(arrayList.get(i2).b);
                if (!TextUtils.isEmpty(readLogFileString)) {
                    for (String str : readLogFileString.split("\r\n")) {
                        arrayList2.add(str);
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeI.objValue;
    }
}
