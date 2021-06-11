package com.baidu.sofire.core;

import android.content.pm.ActivityInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f10168a;

    public a(ActivityInfo[] activityInfoArr) {
        int length;
        this.f10168a = null;
        if (activityInfoArr == null || (length = activityInfoArr.length) <= 0) {
            return;
        }
        this.f10168a = new ArrayList<>(length);
        for (int i2 = 0; i2 < length; i2++) {
            if (activityInfoArr[i2] != null) {
                b bVar = new b();
                bVar.f10176h = activityInfoArr[i2].configChanges;
                bVar.f10174f = activityInfoArr[i2].flags;
                bVar.l = activityInfoArr[i2].labelRes;
                bVar.f10170b = activityInfoArr[i2].launchMode;
                if (activityInfoArr[i2].nonLocalizedLabel != null) {
                    bVar.m = activityInfoArr[i2].nonLocalizedLabel.toString();
                }
                bVar.j = activityInfoArr[i2].name;
                bVar.k = activityInfoArr[i2].packageName;
                bVar.f10171c = activityInfoArr[i2].permission;
                bVar.f10175g = activityInfoArr[i2].screenOrientation;
                bVar.f10177i = activityInfoArr[i2].softInputMode;
                bVar.f10173e = activityInfoArr[i2].targetActivity;
                bVar.f10172d = activityInfoArr[i2].taskAffinity;
                bVar.f10169a = activityInfoArr[i2].theme;
                this.f10168a.add(bVar);
            }
        }
    }

    public final byte[] a() {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(this.f10168a);
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        objectOutputStream.close();
                        byteArrayOutputStream.close();
                    } catch (IOException unused) {
                        com.baidu.sofire.g.d.a();
                    }
                    return byteArray;
                } catch (IOException unused2) {
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException unused3) {
                            com.baidu.sofire.g.d.a();
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
                            com.baidu.sofire.g.d.a();
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
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    ArrayList<b> arrayList = (ArrayList) objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                        byteArrayInputStream.close();
                    } catch (IOException unused) {
                        com.baidu.sofire.g.d.a();
                    }
                    return arrayList;
                } catch (Throwable unused2) {
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException unused3) {
                            com.baidu.sofire.g.d.a();
                            return null;
                        }
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    return null;
                }
            } catch (Throwable unused4) {
                objectInputStream = null;
            }
        } catch (Throwable unused5) {
            objectInputStream = null;
            byteArrayInputStream = null;
        }
    }
}
