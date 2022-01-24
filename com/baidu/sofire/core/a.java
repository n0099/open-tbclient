package com.baidu.sofire.core;

import android.content.pm.ActivityInfo;
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
/* loaded from: classes11.dex */
public final class a implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<b> a;

    public a(ActivityInfo[] activityInfoArr) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activityInfoArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        if (activityInfoArr == null || (length = activityInfoArr.length) <= 0) {
            return;
        }
        this.a = new ArrayList<>(length);
        for (int i4 = 0; i4 < length; i4++) {
            if (activityInfoArr[i4] != null) {
                b bVar = new b();
                bVar.f38407h = activityInfoArr[i4].configChanges;
                bVar.f38405f = activityInfoArr[i4].flags;
                bVar.l = activityInfoArr[i4].labelRes;
                bVar.f38401b = activityInfoArr[i4].launchMode;
                if (activityInfoArr[i4].nonLocalizedLabel != null) {
                    bVar.m = activityInfoArr[i4].nonLocalizedLabel.toString();
                }
                bVar.f38409j = activityInfoArr[i4].name;
                bVar.k = activityInfoArr[i4].packageName;
                bVar.f38402c = activityInfoArr[i4].permission;
                bVar.f38406g = activityInfoArr[i4].screenOrientation;
                bVar.f38408i = activityInfoArr[i4].softInputMode;
                bVar.f38404e = activityInfoArr[i4].targetActivity;
                bVar.f38403d = activityInfoArr[i4].taskAffinity;
                bVar.a = activityInfoArr[i4].theme;
                this.a.add(bVar);
            }
        }
    }

    public final byte[] a() {
        InterceptResult invokeV;
        ObjectOutputStream objectOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
            return (byte[]) invokeV.objValue;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(this.a);
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        objectOutputStream.close();
                        byteArrayOutputStream.close();
                    } catch (IOException unused) {
                        com.baidu.sofire.utility.c.a();
                    }
                    return byteArray;
                } catch (IOException unused2) {
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException unused3) {
                            com.baidu.sofire.utility.c.a();
                            return null;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException unused4) {
                            com.baidu.sofire.utility.c.a();
                            throw th;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException unused5) {
                objectOutputStream = null;
            } catch (Throwable th3) {
                objectOutputStream = null;
                th = th3;
            }
        } catch (IOException unused6) {
            byteArrayOutputStream = null;
            objectOutputStream = null;
        } catch (Throwable th4) {
            objectOutputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static ArrayList<b> a(byte[] bArr) {
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
                ArrayList<b> arrayList = (ArrayList) objectInputStream.readObject();
                try {
                    objectInputStream.close();
                    byteArrayInputStream.close();
                } catch (IOException unused3) {
                    com.baidu.sofire.utility.c.a();
                }
                return arrayList;
            } catch (Throwable unused4) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException unused5) {
                        com.baidu.sofire.utility.c.a();
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
}
