package com.baidu.sofire.b;

import android.content.pm.ActivityInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a implements Serializable {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        if (activityInfoArr != null && (length = activityInfoArr.length) > 0) {
            this.a = new ArrayList<>(length);
            for (int i3 = 0; i3 < length; i3++) {
                if (activityInfoArr[i3] != null) {
                    b bVar = new b();
                    bVar.h = activityInfoArr[i3].configChanges;
                    bVar.f = activityInfoArr[i3].flags;
                    bVar.l = activityInfoArr[i3].labelRes;
                    bVar.b = activityInfoArr[i3].launchMode;
                    if (activityInfoArr[i3].nonLocalizedLabel != null) {
                        bVar.m = activityInfoArr[i3].nonLocalizedLabel.toString();
                    }
                    bVar.j = activityInfoArr[i3].name;
                    bVar.k = activityInfoArr[i3].packageName;
                    bVar.c = activityInfoArr[i3].permission;
                    bVar.g = activityInfoArr[i3].screenOrientation;
                    bVar.i = activityInfoArr[i3].softInputMode;
                    bVar.e = activityInfoArr[i3].targetActivity;
                    bVar.d = activityInfoArr[i3].taskAffinity;
                    bVar.a = activityInfoArr[i3].theme;
                    this.a.add(bVar);
                }
            }
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
                    int i = com.baidu.sofire.a.b.a;
                }
                return arrayList;
            } catch (Throwable unused4) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException unused5) {
                        int i2 = com.baidu.sofire.a.b.a;
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
