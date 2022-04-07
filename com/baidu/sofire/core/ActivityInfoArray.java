package com.baidu.sofire.core;

import android.content.pm.ActivityInfo;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ActivityInfoArray implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ActivityInfoData> array;

    public ActivityInfoArray(ActivityInfo[] activityInfoArr) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activityInfoArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.array = null;
        if (activityInfoArr == null || (length = activityInfoArr.length) <= 0) {
            return;
        }
        this.array = new ArrayList<>(length);
        for (int i3 = 0; i3 < length; i3++) {
            if (activityInfoArr[i3] != null) {
                ActivityInfoData activityInfoData = new ActivityInfoData();
                activityInfoData.configChanges = activityInfoArr[i3].configChanges;
                activityInfoData.flags = activityInfoArr[i3].flags;
                activityInfoData.labelRes = activityInfoArr[i3].labelRes;
                activityInfoData.launchMode = activityInfoArr[i3].launchMode;
                if (activityInfoArr[i3].nonLocalizedLabel != null) {
                    activityInfoData.nonLocalizedLabel = activityInfoArr[i3].nonLocalizedLabel.toString();
                }
                activityInfoData.name = activityInfoArr[i3].name;
                activityInfoData.packageName = activityInfoArr[i3].packageName;
                activityInfoData.permission = activityInfoArr[i3].permission;
                activityInfoData.screenOrientation = activityInfoArr[i3].screenOrientation;
                activityInfoData.softInputMode = activityInfoArr[i3].softInputMode;
                activityInfoData.targetActivity = activityInfoArr[i3].targetActivity;
                activityInfoData.taskAffinity = activityInfoArr[i3].taskAffinity;
                activityInfoData.theme = activityInfoArr[i3].theme;
                this.array.add(activityInfoData);
            }
        }
    }

    public static ArrayList<ActivityInfoData> deserialize(byte[] bArr) {
        InterceptResult invokeL;
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                } catch (Throwable unused) {
                    objectInputStream = null;
                }
            } catch (Throwable unused2) {
                objectInputStream = null;
                byteArrayInputStream = null;
            }
            try {
                ArrayList<ActivityInfoData> arrayList = (ArrayList) objectInputStream.readObject();
                try {
                    objectInputStream.close();
                    byteArrayInputStream.close();
                } catch (IOException e) {
                    CommonMethods.handleNuLException(e);
                }
                return arrayList;
            } catch (Throwable unused3) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e2) {
                        CommonMethods.handleNuLException(e2);
                        return null;
                    }
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                return null;
            }
        }
        return (ArrayList) invokeL.objValue;
    }

    public byte[] serialize() {
        InterceptResult invokeV;
        ObjectOutputStream objectOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                } catch (IOException unused) {
                    objectOutputStream = null;
                } catch (Throwable th2) {
                    objectOutputStream = null;
                    th = th2;
                }
            } catch (IOException unused2) {
                byteArrayOutputStream = null;
                objectOutputStream = null;
            } catch (Throwable th3) {
                objectOutputStream = null;
                th = th3;
                byteArrayOutputStream = null;
            }
            try {
                objectOutputStream.writeObject(this.array);
                objectOutputStream.close();
                byteArrayOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    CommonMethods.handleNuLException(e);
                }
                return byteArray;
            } catch (IOException unused3) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e2) {
                        CommonMethods.handleNuLException(e2);
                        return null;
                    }
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                        CommonMethods.handleNuLException(e3);
                        throw th;
                    }
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        }
        return (byte[]) invokeV.objValue;
    }
}
